// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.core.download:
//            ImageDownloader

public class NetworkDeniedImageDownloader
    implements ImageDownloader
{

    private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[];
    private final ImageDownloader wrappedDownloader;

    static int[] $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()
    {
        int ai[] = $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[ImageDownloader.Scheme.values().length];
        try
        {
            ai[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[ImageDownloader.Scheme.FILE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme = ai;
        return ai;
    }

    public NetworkDeniedImageDownloader(ImageDownloader imagedownloader)
    {
        wrappedDownloader = imagedownloader;
    }

    public InputStream getStream(String s, Object obj)
        throws IOException
    {
        switch ($SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()[ImageDownloader.Scheme.ofUri(s).ordinal()])
        {
        default:
            return wrappedDownloader.getStream(s, obj);

        case 1: // '\001'
        case 2: // '\002'
            throw new IllegalStateException();
        }
    }
}
