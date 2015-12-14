// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;


// Referenced classes of package it.sephiroth.android.library.picasso:
//            Picasso

public static final class debugColor extends Enum
{

    private static final DISK_CACHE $VALUES[];
    public static final DISK_CACHE DISK;
    public static final DISK_CACHE DISK_CACHE;
    public static final DISK_CACHE MEMORY;
    public static final DISK_CACHE NETWORK;
    final int debugColor;

    public static debugColor valueOf(String s)
    {
        return (debugColor)Enum.valueOf(it/sephiroth/android/library/picasso/Picasso$LoadedFrom, s);
    }

    public static debugColor[] values()
    {
        return (debugColor[])$VALUES.clone();
    }

    static 
    {
        MEMORY = new <init>("MEMORY", 0, 0xff00ff00);
        DISK = new <init>("DISK", 1, -256);
        NETWORK = new <init>("NETWORK", 2, 0xffff0000);
        DISK_CACHE = new <init>("DISK_CACHE", 3, 0xff0000ff);
        $VALUES = (new .VALUES[] {
            MEMORY, DISK, NETWORK, DISK_CACHE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        debugColor = j;
    }
}
