TARGETS = mountkernfs.sh mountdevsubfs.sh hwclock.sh checkroot.sh mountall.sh mountoverflowtmp networking ifupdown urandom ifupdown-clean hostname.sh mountnfs.sh mountnfs-bootclean.sh stop-bootlogd-single checkfs.sh mtab.sh bootmisc.sh bootlogd procps mountall-bootclean.sh
INTERACTIVE = checkroot.sh checkfs.sh
mountdevsubfs.sh: mountkernfs.sh
hwclock.sh: checkroot.sh bootlogd
checkroot.sh: mountdevsubfs.sh hostname.sh bootlogd
mountall.sh: checkfs.sh
mountoverflowtmp: mountall-bootclean.sh
networking: mountkernfs.sh mountall.sh mountoverflowtmp ifupdown
ifupdown: ifupdown-clean
urandom: mountall.sh mountoverflowtmp
ifupdown-clean: checkroot.sh
hostname.sh: bootlogd
mountnfs.sh: mountall.sh mountoverflowtmp networking ifupdown
mountnfs-bootclean.sh: mountall.sh mountoverflowtmp mountnfs.sh
stop-bootlogd-single: mountall.sh mountoverflowtmp hwclock.sh checkroot.sh networking mountkernfs.sh ifupdown urandom ifupdown-clean hostname.sh mountnfs.sh mountnfs-bootclean.sh checkfs.sh mtab.sh mountdevsubfs.sh bootmisc.sh bootlogd procps mountall-bootclean.sh
checkfs.sh: checkroot.sh mtab.sh
mtab.sh: checkroot.sh
bootmisc.sh: mountall.sh mountoverflowtmp mountnfs.sh mountnfs-bootclean.sh
bootlogd: mountdevsubfs.sh
procps: mountkernfs.sh mountall.sh mountoverflowtmp bootlogd
mountall-bootclean.sh: mountall.sh
