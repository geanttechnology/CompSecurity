// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Artist $VALUES[];
    public static final Artist Artist;
    public static final Artist DateAdded;
    public static final Artist Name;
    public static final Artist PlayCount;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$GetAlbumsInCollection_sort, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PlayCount = new <init>("PlayCount", 0);
        DateAdded = new <init>("DateAdded", 1);
        Name = new <init>("Name", 2);
        Artist = new <init>("Artist", 3);
        $VALUES = (new .VALUES[] {
            PlayCount, DateAdded, Name, Artist
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
