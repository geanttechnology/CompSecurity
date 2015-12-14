// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            VASTParser

public static class maintainAspectRatio
{

    public int bitrate;
    public String contentType;
    public String delivery;
    public int height;
    public boolean maintainAspectRatio;
    public String url;
    public int width;

    (String s, String s1, String s2, int i, int j, int k, boolean flag)
    {
        url = s;
        contentType = s1;
        delivery = s2;
        width = i;
        height = j;
        bitrate = k;
        maintainAspectRatio = flag;
    }
}
