## This is a base prototype with mostly hardcoded values on existing sample code

This deployment has 50% idles on 1 core, with 80% bandsiwdth and by defualt runs for 1 hour before self termination.
If using a different unregistered client id for each run, please send your settings and profile information with the custom clientid to profile@weave.sh so that we can let you know how many work units were successully completed in the hour.

```bash
usage: java -Xmx256m -Xms256m -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled weave.Fiber_Weave_1c5b8t1hr example-clientId-101112-2250

```
