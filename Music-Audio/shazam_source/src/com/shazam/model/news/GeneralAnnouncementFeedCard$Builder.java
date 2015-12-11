// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import com.shazam.model.details.InteractiveInfo;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            GeneralAnnouncementFeedCard, Content

public static class 
{

    public Actions actions;
    public final Map beaconData = new HashMap();
    public Content content;
    public String id;
    public InteractiveInfo interactiveInfo;
    public long timestamp;

    static long a( )
    {
        return .timestamp;
    }

    public static timestamp a()
    {
        return new <init>();
    }

    static Actions b(<init> <init>1)
    {
        return <init>1.actions;
    }

    static String c(actions actions1)
    {
        return actions1.id;
    }

    static Map d(id id1)
    {
        return id1.beaconData;
    }

    static Content e(beaconData beacondata)
    {
        return beacondata.content;
    }

    static InteractiveInfo f(content content1)
    {
        return content1.interactiveInfo;
    }

    public ()
    {
    }
}
