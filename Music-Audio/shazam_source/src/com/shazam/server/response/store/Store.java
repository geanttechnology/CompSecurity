// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.store;

import java.util.List;

public class Store
{

    public final List actions;
    public final String blurredArtUrl;
    public final String coverArtUrl;
    public final String previewUrl;

    public String getBlurredArtUrl()
    {
        return blurredArtUrl;
    }

    public String getCoverArtUrl()
    {
        return coverArtUrl;
    }

    public String getPreviewUrl()
    {
        return previewUrl;
    }
}
