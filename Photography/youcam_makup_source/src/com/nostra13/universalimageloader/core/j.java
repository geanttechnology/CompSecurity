// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.InputStream;

class j
    implements ImageDownloader
{

    private final ImageDownloader a;

    public j(ImageDownloader imagedownloader)
    {
        a = imagedownloader;
    }

    public InputStream a_(String s, Object obj)
    {
        switch (h._cls1.a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.a(s).ordinal()])
        {
        default:
            return a.a_(s, obj);

        case 1: // '\001'
        case 2: // '\002'
            throw new IllegalStateException();
        }
    }
}
