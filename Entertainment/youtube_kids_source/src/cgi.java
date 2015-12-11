// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;

public final class cgi extends Enum
{

    private static cgi A;
    private static cgi B;
    private static cgi C;
    private static final cgi D[];
    public static final cgi a;
    public static final cgi b;
    public static final cgi c;
    public static final cgi d;
    public static final cgi e;
    public static final cgi f;
    public static final cgi g;
    public static final cgi h;
    private static cgi i;
    private static cgi j;
    private static cgi k;
    private static cgi l;
    private static cgi m;
    private static cgi n;
    private static cgi o;
    private static cgi p;
    private static cgi q;
    private static cgi r;
    private static cgi s;
    private static cgi t;
    private static cgi u;
    private static cgi v;
    private static cgi w;
    private static cgi x;
    private static cgi y;
    private static cgi z;

    private cgi(String s1, int i1)
    {
        super(s1, i1);
    }

    public static cgi a(String s1)
    {
        return valueOf(s1.substring(s1.lastIndexOf(".") + 1));
    }

    public static cgi valueOf(String s1)
    {
        return (cgi)Enum.valueOf(cgi, s1);
    }

    public static cgi[] values()
    {
        return (cgi[])D.clone();
    }

    public final Intent a()
    {
        return new Intent(toString());
    }

    public final String toString()
    {
        String s1 = String.valueOf(cgi.getCanonicalName());
        String s2 = String.valueOf(name());
        return (new StringBuilder(String.valueOf(s1).length() + 1 + String.valueOf(s2).length())).append(s1).append(".").append(s2).toString();
    }

    static 
    {
        i = new cgi("AUTHORIZATION_LIGHTWEIGHT_ACCOUNT", 0);
        j = new cgi("BIG_SCREEN_CONNECTED", 1);
        a = new cgi("BIG_SCREEN_DISCONNECTED", 2);
        k = new cgi("BIG_SCREEN_ON_ERROR", 3);
        l = new cgi("BIG_SCREEN_PLAY_STATE_UPDATE", 4);
        m = new cgi("BIG_SCREEN_PLAYER_STATE_CHANGED", 5);
        n = new cgi("BIG_SCREEN_PLAYLIST_CONFIRMED", 6);
        o = new cgi("BIG_SCREEN_PLAYLIST_UPDATE", 7);
        b = new cgi("CLOUD_SERVICE_IPV6_ERROR", 8);
        c = new cgi("CLOUD_SERVICE_NO_NETWORK", 9);
        d = new cgi("CONNECTION_STATUS_CONNECTED", 10);
        e = new cgi("CONNECTION_STATUS_DISCONNECTED", 11);
        f = new cgi("CONNECTION_STATUS_STARTED_CONNECTING", 12);
        g = new cgi("CONNECTION_STATUS_STOPPED_CONNECTING", 13);
        p = new cgi("DECLINED_PARTY", 14);
        q = new cgi("END_PARTY_MODE", 15);
        r = new cgi("GO_HOME", 16);
        h = new cgi("LOUNGE_SERVER_CONNECTION_ERROR", 17);
        s = new cgi("LOUNGE_STATUS", 18);
        t = new cgi("NO_ACTION", 19);
        u = new cgi("PARTY_VIDEO_FLING", 20);
        v = new cgi("PLAYSTATE_CHANGED", 21);
        w = new cgi("QUEUE_MODIFIED", 22);
        x = new cgi("QUEUE_MODIFIED_VIDEO_ADDED", 23);
        y = new cgi("QUEUE_MODIFIED_VIDEO_REMOVED", 24);
        z = new cgi("REFRESH", 25);
        A = new cgi("REMOTE_CALL_ERROR", 26);
        B = new cgi("SHARED_PLAYLIST_MODIFIED", 27);
        C = new cgi("SWITCH_USER", 28);
        D = (new cgi[] {
            i, j, a, k, l, m, n, o, b, c, 
            d, e, f, g, p, q, r, h, s, t, 
            u, v, w, x, y, z, A, B, C
        });
    }
}
