// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class et extends Enum
{

    public static final et a;
    public static final et b;
    public static final et c;
    public static final et d;
    public static final et e;
    public static final et f;
    public static final et g;
    public static final et h;
    public static final et i;
    public static final et j;
    private static final et k[];

    private et(String s, int l)
    {
        super(s, l);
    }

    public static et valueOf(String s)
    {
        return (et)Enum.valueOf(a/a/et, s);
    }

    public static et[] values()
    {
        return (et[])k.clone();
    }

    static 
    {
        a = new et("DISKSPACEFREE_EXTERNAL_STORAGE_DIRECTORY_FAULT", 0);
        b = new et("DISKSPACETOTAL_EXTERNAL_STORAGE_DIRECTORY_FAULT", 1);
        c = new et("SDSPACEFREE_EXTERNAL_STORAGE_DIRECTORY_FAULT", 2);
        d = new et("SDSPACETOTAL_EXTERNAL_STORAGE_DIRECTORY_FAULT", 3);
        e = new et("GENERIC_HANDLER_DO_OPEN_CONNECTION_FAULT", 4);
        f = new et("STREAM_HANDLER_FACTORY_ANNUL_REFLECTION_FAULT", 5);
        g = new et("STREAM_HANDLER_FACTORY_CLEAR_STREAM_HANDLERS_FAULT", 6);
        h = new et("HASHED_DEVICE_ID_GENERATE_FROM_DROID_ID_FAULT", 7);
        i = new et("HASHED_DEVICE_ID_GENERATE_RANDOM_ID_FAULT", 8);
        j = new et("TXN_CRASH_ALL_FAULT", 9);
        k = (new et[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
