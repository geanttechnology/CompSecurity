// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bwa extends Enum
{

    public static final bwa a;
    public static final bwa b;
    public static final bwa c;
    private static bwa e;
    private static bwa f;
    private static bwa g;
    private static bwa h;
    private static bwa i;
    private static bwa j;
    private static bwa k;
    private static bwa l;
    private static bwa m;
    private static bwa n;
    private static bwa o;
    private static bwa p;
    private static bwa q;
    private static final bwa r[];
    public final int d;

    private bwa(String s, int i1, int j1)
    {
        super(s, i1);
        d = j1;
    }

    public static bwa valueOf(String s)
    {
        return (bwa)Enum.valueOf(bwa, s);
    }

    public static bwa[] values()
    {
        return (bwa[])r.clone();
    }

    static 
    {
        a = new bwa("WATCH_PAGE", 0, 3832);
        b = new bwa("BROWSE_PAGE", 1, 6827);
        c = new bwa("SEARCH_PAGE", 2, 4724);
        e = new bwa("SEARCH_BOX", 3, 10349);
        f = new bwa("GUIDE", 4, 3966);
        g = new bwa("MUSIC_PRE_PURCHASE_TUTORIAL", 5, 10372);
        h = new bwa("MUSIC_PRE_PURCHASE_TUTORIAL_BUTTON", 6, 10373);
        i = new bwa("PREVIOUS_VIDEO_BUTTON", 7, 6803);
        j = new bwa("UPLOAD_VIDEO_EDITING_PAGE", 8, 9729);
        k = new bwa("UPLOAD_VIDEO_EDITING_COMPLETED_BUTTON", 9, 9701);
        l = new bwa("UPLOAD_VIDEO_EDITING_CANCEL_BUTTON", 10, 9702);
        m = new bwa("UPLOAD_VIDEO_EDITING_VIDEO_PREVIEW", 11, 9915);
        n = new bwa("UPLOAD_VIDEO_EDITING_VIDEO_PREVIEW_ERROR", 12, 9916);
        o = new bwa("UPLOAD_VIDEO_EDITING_TRIM_VIEW", 13, 9917);
        p = new bwa("YPC_OFFERS_PAGE", 14, 8196);
        q = new bwa("YPC_TIP_JAR_PAGE", 15, 8197);
        r = (new bwa[] {
            a, b, c, e, f, g, h, i, j, k, 
            l, m, n, o, p, q
        });
    }
}
