// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;


// Referenced classes of package com.amazon.ansel.fetch:
//            UriRequest

public class ImageRequest
{

    private final int bitmapDensity;
    private final UriRequest uriRequest;

    public ImageRequest(UriRequest urirequest)
    {
        this(urirequest, 0);
    }

    public ImageRequest(UriRequest urirequest, int i)
    {
        uriRequest = urirequest;
        bitmapDensity = i;
    }

    public ImageRequest(String s)
    {
        this(new UriRequest(s));
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (ImageRequest)obj;
        if (bitmapDensity != ((ImageRequest) (obj)).bitmapDensity)
        {
            return false;
        }
        if (uriRequest != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ImageRequest) (obj)).uriRequest == null) goto _L1; else goto _L3
_L3:
        return false;
        if (uriRequest.equals(((ImageRequest) (obj)).uriRequest)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getBitmapDensity()
    {
        return bitmapDensity;
    }

    public UriRequest getUriRequest()
    {
        return uriRequest;
    }

    public int hashCode()
    {
        int j = bitmapDensity;
        int i;
        if (uriRequest == null)
        {
            i = 0;
        } else
        {
            i = uriRequest.hashCode();
        }
        return (j + 31) * 31 + i;
    }

    public String toString()
    {
        if (uriRequest != null)
        {
            return uriRequest.toString();
        } else
        {
            return "";
        }
    }
}
