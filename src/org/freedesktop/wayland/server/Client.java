package org.freedesktop.wayland.server;

import java.io.File;

public class Client
{
    private long client_ptr;

    public Client(Display display, int fd)
    {
        create(display, fd);
    }

    public static native Client startClient(Display display, File executable,
            String[] args);

    private native void create(Display display, int fd);
    public native void flush();
    public native int addResource(Resource resource);
    public native Display getDisplay();
    public native void destroy();

    @Override
    protected void finalize() throws Throwable
    {
        destroy();
        super.finalize();
    }

    static {
        System.loadLibrary("wayland-java-server");
    }
}

