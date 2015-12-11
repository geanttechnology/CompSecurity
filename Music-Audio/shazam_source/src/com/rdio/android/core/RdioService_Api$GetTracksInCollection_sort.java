// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Artist $VALUES[];
    public static final Artist Album;
    public static final Artist Artist;
    public static final Artist DateAdded;
    public static final Artist Name;
    public static final Artist PlayCount;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$GetTracksInCollection_sort, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Album = new <init>("Album", 0);
        PlayCount = new <init>("PlayCount", 1);
        DateAdded = new <init>("DateAdded", 2);
        Name = new <init>("Name", 3);
        Artist = new <init>("Artist", 4);
        $VALUES = (new .VALUES[] {
            Album, PlayCount, DateAdded, Name, Artist
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
