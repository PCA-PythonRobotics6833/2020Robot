I can connect to the robot's wifi radio with my iphone, but the laptop does not seem to be able to upload via the wifi.
We can successfully use the wire to connect to the robot from the laptop.

Somethings to try:
* Check Network Adapters: Ensure that all other network adapters on your laptop are disabled. Sometimes, multiple active network adapters can cause conflicts.
* Run as Administrator: Make sure you are running the FRC Radio Configuration Utility with administrator privileges. This is necessary to configure the network settings properly.
* Direct Connection: Plug your laptop directly into the wireless bridge's Ethernet port closest to the power jack. If you're using a PoE adapter, try connecting the laptop to the alternate port on the radio.
* Static IP Address: Verify that the radio is set to a static IP address. The default should be 10.TE.AM.1, where TE.AM corresponds to your team number.
* mDNS Issues: If you can connect via a tether but not wirelessly, it might be an mDNS issue. Try disabling other adapters, restarting the Driver Station, logging off and back on, or rebooting your laptop.