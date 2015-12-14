// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.b;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.InputStream;

class k
    implements ImageDownloader
{

    private final ImageDownloader a;

    public k(ImageDownloader imagedownloader)
    {
        a = imagedownloader;
    }

    public InputStream a_(String s, Object obj)
    {
        obj = a.a_(s, obj);
        switch (h._cls1.a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.a(s).ordinal()])
        {
        default:
            return ((InputStream) (obj));

        case 1: // '\001'
        case 2: // '\002'
            return new b(((InputStream) (obj)));
        }
    }
}
