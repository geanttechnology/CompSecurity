// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class ck extends Enum
{

    public static final ck a;
    public static final ck b;
    public static final ck c;
    public static final ck d;
    public static final ck e;
    public static final ck f;
    public static final ck g;
    public static final ck h;
    public static final ck i;
    public static final ck j;
    public static final ck k;
    public static final ck l;
    private static final ck n[];
    private String m;

    private ck(String s, int i1, String s1)
    {
        super(s, i1);
        m = s1;
    }

    public static ck valueOf(String s)
    {
        return (ck)Enum.valueOf(a/a/ck, s);
    }

    public static ck[] values()
    {
        return (ck[])n.clone();
    }

    public final String toString()
    {
        return m;
    }

    static 
    {
        a = new ck("NOT_LOGGED_YET", 0, "Not logged");
        b = new ck("INPUT_STREAM_READ", 1, "InputStream.read()");
        c = new ck("INPUT_STREAM_CLOSE", 2, "InputStream.close()");
        d = new ck("SOCKET_CLOSE", 3, "Socket.close()");
        e = new ck("LEGACY_JAVANET", 4, "Legacy java.net");
        f = new ck("HTTP_CONTENT_LENGTH_PARSER", 5, "parse()");
        g = new ck("INPUT_STREAM_FINISHED", 6, "finishedMessage()");
        h = new ck("PARSING_INPUT_STREAM_LOG_ERROR", 7, "logError()");
        i = new ck("SOCKET_IMPL_CONNECT", 8, "MonitoredSocketImpl.connect()");
        j = new ck("SSL_SOCKET_START_HANDSHAKE", 9, "MonitoredSSLSocket.startHandshake");
        k = new ck("UNIT_TEST", 10, "Unit test");
        l = new ck("LOG_ENDPOINT", 11, "logEndpoint");
        n = (new ck[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
    }
}
