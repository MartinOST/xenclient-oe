DESCRIPTION = "Stubdomain atapi-cdrom helper)"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"
DEPENDS = "libv4v"

PV = "0+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRC_URI = "git://${OPENXT_GIT_MIRROR}/xctools.git;protocol=${OPENXT_GIT_PROTOCOL};branch=${OPENXT_BRANCH}"

FILES_${PN} += "/usr/lib/xen/bin/atapi_pt_helper"

S = "${WORKDIR}/git/atapi_pt_helper"

ASNEEDED = ""

inherit autotools
inherit pkgconfig
inherit xenclient

do_install(){
        install -d ${D}/usr/lib/xen/bin
        install -m 755 ${B}/src/atapi_pt_helper ${D}/usr/lib/xen/bin/
}
