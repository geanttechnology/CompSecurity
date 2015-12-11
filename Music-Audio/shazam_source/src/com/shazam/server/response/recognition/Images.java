// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.recognition;

import com.shazam.b.e.a;

public class Images
{

    public final String largeImage;
    public final String smallImage;

    public String getLargestAvailableImage()
    {
        String s1 = largeImage;
        String s = s1;
        if (a.a(s1))
        {
            s = smallImage;
        }
        return s;
    }
}
