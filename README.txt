small stripped down debian distro (~50M). git'd as an lxc container. can easily burn it to an iso and make it bootable etc.

To create a manifest of all files and their permissions/owners/groups, run:
./bin/create_rootfs_permissions

To modify all of the permissions/owners/groups based on the manifest file (metadata/perms.txt), run:
./bin/restore_rootfs_permissions

Those scripts are most important for git.
