// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cdn extends Enum
{

    public static final cdn a;
    public static final cdn b;
    public static final cdn c;
    public static final cdn d;
    public static final cdn e;
    public static final cdn f;
    public static final cdn g;
    public static final cdn h;
    public static final cdn i;
    public static final cdn j;
    private static final cdn l[];
    public final boolean k;

    private cdn(String s, int i1, int j1, boolean flag)
    {
        super(s, i1);
        k = flag;
    }

    public static cdn valueOf(String s)
    {
        return (cdn)Enum.valueOf(cdn, s);
    }

    public static cdn[] values()
    {
        return (cdn[])l.clone();
    }

    static 
    {
        a = new cdn("VIDEO_LIKED", 0, 0x7f0b0090, true);
        b = new cdn("VIDEO_SHARED", 1, 0x7f0b0091, true);
        c = new cdn("VIDEO_FAVORITED", 2, 0x7f0b0092, true);
        d = new cdn("VIDEO_COMMENTED", 3, 0x7f0b0093, true);
        e = new cdn("VIDEO_UPLOADED", 4, 0x7f0b0094, true);
        f = new cdn("VIDEO_RECOMMENDED", 5, 0x7f0b0098, true);
        g = new cdn("VIDEO_ADDED_TO_PLAYLIST", 6, 0x7f0b0095, true);
        h = new cdn("FRIEND_ADDED", 7, 0x7f0b0096, false);
        i = new cdn("USER_SUBSCRIPTION_ADDED", 8, 0x7f0b0097, false);
        j = new cdn("BULLETIN_POSTED", 9, 0x7f0b0099, true);
        l = (new cdn[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
