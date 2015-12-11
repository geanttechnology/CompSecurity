// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.net.IHeader;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.IResponseHeaderHandler;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Locale;

public class ImageResponse extends Response
    implements IResponseDataHandler, IResponseHeaderHandler
{

    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ImageResponse", 3, "Image response handler");
    private Bitmap bitmap;
    private final boolean fetchAsBytes;
    public boolean isCacheable;
    private byte rawData[];

    public ImageResponse(boolean flag)
    {
        isCacheable = true;
        fetchAsBytes = flag;
    }

    public final byte[] getByteArray()
    {
        if (!fetchAsBytes)
        {
            throw new IllegalStateException("You cannot call getByteArray() unless you specify asBytes as true in constructor, see constructor for ImageRequest.");
        } else
        {
            return rawData;
        }
    }

    public IResponseDataHandler getDataHandler()
    {
        if (hasSuccessResponseCode())
        {
            return this;
        } else
        {
            return null;
        }
    }

    public IResponseHeaderHandler getHeaderHandler()
    {
        return this;
    }

    public final Bitmap getImage()
    {
        if (bitmap == null && rawData != null)
        {
            bitmap = BitmapFactory.decodeByteArray(rawData, 0, rawData.length);
        }
        return bitmap;
    }

    public final Bitmap getSizedImage(int i)
    {
        Object obj = getByteArray();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((Bitmap) (obj));
_L2:
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(((byte []) (obj)), 0, obj.length, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = 1;
        Bitmap bitmap1;
        if (options.outWidth > i || options.outHeight > i)
        {
            if (options.outHeight > options.outWidth)
            {
                options.inSampleSize = Math.round((float)options.outHeight / (float)i);
            } else
            {
                options.inSampleSize = Math.round((float)options.outWidth / (float)i);
            }
        }
        bitmap1 = BitmapFactory.decodeByteArray(((byte []) (obj)), 0, obj.length, options);
        obj = bitmap1;
        if (bitmap1 == null) goto _L4; else goto _L3
_L3:
        options.outWidth = bitmap1.getWidth();
        options.outHeight = bitmap1.getHeight();
        if (options.outWidth > i * 2)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = bitmap1;
        if (options.outHeight <= i * 2) goto _L4; else goto _L5
_L5:
        if (options.outHeight > options.outWidth)
        {
            options.outWidth = Math.round((float)options.outWidth / ((float)options.outHeight / (float)i));
            options.outHeight = i;
        } else
        {
            options.outHeight = Math.round((float)options.outHeight / ((float)options.outWidth / (float)i));
            options.outWidth = i;
        }
        obj = Bitmap.createScaledBitmap(bitmap1, options.outWidth, options.outHeight, true);
        bitmap1.recycle();
        return ((Bitmap) (obj));
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        if (fetchAsBytes)
        {
            rawData = StreamUtil.streamToBytesForParse(inputstream);
            return;
        }
        try
        {
            bitmap = BitmapFactory.decodeStream(inputstream);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        if (logger.isLoggable)
        {
            logger.logAsError("Failed to load Bitmap", inputstream);
        }
        bitmap = null;
        rawData = null;
        return;
    }

    public void readHeaders(IHeaders iheaders)
    {
        iheaders = iheaders.iterator();
        do
        {
            if (!iheaders.hasNext())
            {
                break;
            }
            Object obj = (IHeader)iheaders.next();
            String s = ((IHeader) (obj)).getName();
            if (TextUtils.isEmpty(s) || !"cache-control".equals(s.toLowerCase(Locale.US)))
            {
                continue;
            }
            obj = ((IHeader) (obj)).getValue();
            if (TextUtils.isEmpty(((CharSequence) (obj))) || !((String) (obj)).contains("no-cache") && !((String) (obj)).contains("no-store"))
            {
                continue;
            }
            isCacheable = false;
            break;
        } while (true);
    }

}
