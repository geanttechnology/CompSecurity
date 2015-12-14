// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTParser

public static class companionClickTracking
{

    public int assetHeight;
    public int assetWidth;
    public String companionClickThrough;
    public List companionClickTracking;
    public int height;
    public boolean hideButtons;
    public companionClickTracking htmlResource;
    public String id;
    public companionClickTracking iframeResource;
    public ce staticResource;
    public Map trackingEvents;
    public int width;

    ce(String s, int i, int j, int k, int l, boolean flag)
    {
        id = s;
        width = i;
        height = j;
        assetWidth = k;
        assetHeight = l;
        hideButtons = flag;
        companionClickTracking = new ArrayList();
    }
}
