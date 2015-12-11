// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.util.Log;
import com.ebay.common.model.EbayDeals;
import com.ebay.common.net.deals.EbayDealsApi;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.io.CacheStream;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class GetDealsLoader extends FwNetLoader
{
    private static final class CachingDealsRequest extends com.ebay.common.net.deals.EbayDealsApi.DealsRequest
    {

        private final File file;

        public com.ebay.common.net.deals.EbayDealsApi.DealsResponse getResponse()
        {
            return new CachingDealsResponse(file);
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public CachingDealsRequest(EbaySite ebaysite, int i, int j, File file1)
        {
            super(ebaysite, i, j);
            file = file1;
        }
    }

    private static final class CachingDealsResponse extends com.ebay.common.net.deals.EbayDealsApi.DealsResponse
    {

        private final File file;

        private InputStream makeCacheStream(InputStream inputstream)
        {
            Object obj;
            Object obj1;
            Object obj3;
            obj = null;
            obj1 = null;
            obj3 = null;
            Object obj2 = new BufferedOutputStream(new FileOutputStream(file), 8192);
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(((java.io.OutputStream) (obj2)));
            obj1 = gzipoutputstream;
            obj = gzipoutputstream;
            obj2 = new CacheStream(inputstream, gzipoutputstream);
            if (obj2 == null)
            {
                StreamUtil.closeQuietly(gzipoutputstream);
                obj = obj2;
            } else
            {
                obj = obj2;
            }
            if (obj != null)
            {
                return ((InputStream) (obj));
            } else
            {
                return inputstream;
            }
            obj2;
_L4:
            obj = obj1;
            ((IOException) (obj2)).printStackTrace();
            obj = obj3;
            if (true)
            {
                StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
                obj = obj3;
            }
            break MISSING_BLOCK_LABEL_72;
            inputstream;
_L2:
            if (true)
            {
                StreamUtil.closeQuietly(((java.io.Closeable) (obj)));
            }
            throw inputstream;
            inputstream;
            obj = obj2;
            if (true) goto _L2; else goto _L1
_L1:
            obj;
            obj1 = obj2;
            obj2 = obj;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            InputStream inputstream1;
            if (inputstream == null || file == null)
            {
                break MISSING_BLOCK_LABEL_49;
            }
            inputstream1 = inputstream;
            inputstream = makeCacheStream(inputstream);
            inputstream1 = inputstream;
            super.parse(inputstream);
            StreamUtil.closeQuietly(inputstream);
            if (false && (inputstream instanceof CacheStream))
            {
                file.delete();
            }
            return;
            inputstream;
            StreamUtil.closeQuietly(inputstream1);
            if (true && (inputstream1 instanceof CacheStream))
            {
                file.delete();
            }
            throw inputstream;
        }

        public CachingDealsResponse(File file1)
        {
            file = file1;
        }
    }


    private final File cacheDirectory;
    public volatile EbayDeals deals;
    private final boolean force;
    private final EbaySite site;

    public GetDealsLoader(EbayContext ebaycontext, File file, boolean flag, EbaySite ebaysite)
    {
        super(ebaycontext);
        deals = null;
        cacheDirectory = file;
        force = flag;
        site = ebaysite;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        File file;
        file = new File(cacheDirectory, (new StringBuilder()).append("Deals-").append(site.id).append(".gz").toString());
        deals = null;
        if (force || file.lastModified() + 0x36ee80L <= System.currentTimeMillis()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        Object obj2 = new BufferedInputStream(new FileInputStream(file), 8192);
        GZIPInputStream gzipinputstream = new GZIPInputStream(((InputStream) (obj2)));
        obj1 = gzipinputstream;
        obj = gzipinputstream;
        deals = EbayDealsApi.parseDeals(gzipinputstream);
        StreamUtil.closeQuietly(gzipinputstream);
        return;
        obj2;
_L6:
        obj = obj1;
        Log.w("GetDealsLoader", "stored XML bad", ((Throwable) (obj2)));
        StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
        if (file.exists())
        {
            file.delete();
        }
_L2:
        deals = ((com.ebay.common.net.deals.EbayDealsApi.DealsResponse)sendRequest(new CachingDealsRequest(site, 4, 0, file))).getData();
        return;
        Exception exception1;
        exception1;
_L4:
        StreamUtil.closeQuietly(((java.io.Closeable) (obj)));
        throw exception1;
        exception1;
        obj = obj2;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        exception1 = ((Exception) (obj2));
        obj2 = exception;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
