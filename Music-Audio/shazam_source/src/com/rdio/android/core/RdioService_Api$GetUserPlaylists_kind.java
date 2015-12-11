// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class A extends Enum
{

    private static final Owned $VALUES[];
    public static final Owned Collab;
    public static final Owned Favorites;
    public static final Owned Owned;
    public static final Owned Subscribed;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetUserPlaylists_kind, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        Favorites = new <init>("Favorites", 0);
        Subscribed = new <init>("Subscribed", 1);
        Collab = new <init>("Collab", 2);
        Owned = new <init>("Owned", 3);
        $VALUES = (new .VALUES[] {
            Favorites, Subscribed, Collab, Owned
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
