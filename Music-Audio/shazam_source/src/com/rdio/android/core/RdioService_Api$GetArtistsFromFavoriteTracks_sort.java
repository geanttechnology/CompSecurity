// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Name $VALUES[];
    public static final Name DateAdded;
    public static final Name Name;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$GetArtistsFromFavoriteTracks_sort, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DateAdded = new <init>("DateAdded", 0);
        Name = new <init>("Name", 1);
        $VALUES = (new .VALUES[] {
            DateAdded, Name
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
