// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import android.graphics.Bitmap;
import com.ebay.nautilus.domain.net.ImageRequest;
import com.ebay.nautilus.domain.net.ImageResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.net.URL;

public class GetImageNetLoader extends FwNetLoader
{

    private Bitmap bitmap;
    private final URL url;

    public GetImageNetLoader(EbayContext ebaycontext, URL url1)
    {
        super(ebaycontext);
        bitmap = null;
        url = url1;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        try
        {
            bitmap = ((ImageResponse)sendRequest(new ImageRequest(url))).getImage();
            return;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            bitmap = null;
        }
    }

    public Bitmap getBitmap()
    {
        return bitmap;
    }
}
