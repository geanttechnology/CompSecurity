// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;

import android.net.Uri;
import java.util.List;

// Referenced classes of package com.shazam.model.player:
//            Playlist

public static class 
{

    public List items;
    public Uri playlistUri;
    public String title;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.title;
    }

    static List b(title title1)
    {
        return title1.items;
    }

    static Uri c(items items1)
    {
        return items1.playlistUri;
    }

    public final Playlist b()
    {
        return new Playlist(this, null);
    }

    public ()
    {
    }
}
