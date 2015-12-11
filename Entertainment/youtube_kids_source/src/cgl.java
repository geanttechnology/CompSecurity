// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Map;

public final class cgl extends Enum
{

    private static cgl A;
    private static cgl B;
    private static cgl C;
    private static cgl D;
    private static cgl E;
    private static cgl F;
    private static cgl G;
    private static cgl H;
    private static Map I;
    private static final cgl K[];
    public static final cgl a;
    public static final cgl b;
    public static final cgl c;
    public static final cgl d;
    public static final cgl e;
    public static final cgl f;
    public static final cgl g;
    public static final cgl h;
    public static final cgl i;
    public static final cgl j;
    public static final cgl k;
    public static final cgl l;
    public static final cgl m;
    public static final cgl n;
    public static final cgl o;
    public static final cgl p;
    public static final cgl q;
    public static final cgl r;
    public static final cgl s;
    public static final cgl t;
    public static final cgl u;
    public static final cgl v;
    public static final cgl w;
    public static final cgl x;
    public static final cgl y;
    private static cgl z;
    private final String J;

    private cgl(String s1, int i1, String s2)
    {
        super(s1, i1);
        J = (String)b.a(s2);
    }

    public static cgl a(String s1)
    {
        return (cgl)I.get(s1);
    }

    public static cgl valueOf(String s1)
    {
        return (cgl)Enum.valueOf(cgl, s1);
    }

    public static cgl[] values()
    {
        return (cgl[])K.clone();
    }

    public final String toString()
    {
        return J;
    }

    static 
    {
        int i1 = 0;
        z = new cgl("ADD_VIDEO", 0, "addVideo");
        A = new cgl("ADD_VIDEOS", 1, "addVideos");
        a = new cgl("AD_PLAYING", 2, "adPlaying");
        b = new cgl("ON_AD_STATE_CHANGED", 3, "onAdStateChange");
        B = new cgl("CLEAR_PLAYLIST", 4, "clearPlaylist");
        C = new cgl("CONFIRM_PLAYLIST_UPDATE", 5, "confirmPlaylistUpdate");
        c = new cgl("ON_ERROR", 6, "onError");
        d = new cgl("LOUNGE_STATUS", 7, "loungeStatus");
        D = new cgl("MOVE_VIDEO", 8, "moveVideo");
        e = new cgl("NEXT", 9, "next");
        E = new cgl("NOOP", 10, "noop");
        f = new cgl("NOW_PLAYING", 11, "nowPlaying");
        g = new cgl("NOW_PLAYING_PLAYLIST", 12, "nowPlayingPlaylist");
        h = new cgl("ON_SUBTITLES_TRACK_CHANGED", 13, "onSubtitlesTrackChanged");
        i = new cgl("PAUSE", 14, "pause");
        j = new cgl("PLAY", 15, "play");
        k = new cgl("PLAYLIST_MODIFIED", 16, "playlistModified");
        l = new cgl("PREVIOUS", 17, "previous");
        m = new cgl("REMOTE_CONNECTED", 18, "remoteConnected");
        n = new cgl("REMOTE_DISCONNECTED", 19, "remoteDisconnected");
        F = new cgl("REMOVE_VIDEO", 20, "removeVideo");
        o = new cgl("SCREEN_CONNECTED", 21, "loungeScreenConnected");
        p = new cgl("SCREEN_DISCONNECTED", 22, "loungeScreenDisconnected");
        q = new cgl("SEEK_TO", 23, "seekTo");
        r = new cgl("SET_PLAYLIST", 24, "setPlaylist");
        s = new cgl("SET_SUBTITLES_TRACK", 25, "setSubtitlesTrack");
        G = new cgl("SET_VIDEO", 26, "setVideo");
        t = new cgl("SET_VOLUME", 27, "setVolume");
        u = new cgl("ON_VOLUME_CHANGED", 28, "onVolumeChanged");
        H = new cgl("SHOW_QR_CODE", 29, "showQrCode");
        v = new cgl("SKIP_AD", 30, "skipAd");
        w = new cgl("ON_STATE_CHANGED", 31, "onStateChange");
        x = new cgl("STOP", 32, "stopVideo");
        y = new cgl("UPDATE_USER", 33, "updateUser");
        K = (new cgl[] {
            z, A, a, b, B, C, c, d, D, e, 
            E, f, g, h, i, j, k, l, m, n, 
            F, o, p, q, r, s, G, t, u, H, 
            v, w, x, y
        });
        I = new HashMap();
        cgl acgl[] = values();
        for (int j1 = acgl.length; i1 < j1; i1++)
        {
            cgl cgl1 = acgl[i1];
            I.put(cgl1.J, cgl1);
        }

    }
}
