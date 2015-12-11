// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.volley.toolbox;

import com.mopub.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

// Referenced classes of package com.mopub.volley.toolbox:
//            DiskBasedCache

static class responseHeaders
{

    public String etag;
    public String key;
    public Map responseHeaders;
    public long serverDate;
    public long size;
    public long softTtl;
    public long ttl;

    public static responseHeaders readHeader(InputStream inputstream)
        throws IOException
    {
        responseHeaders responseheaders = new <init>();
        if (DiskBasedCache.readInt(inputstream) != 0x20140623)
        {
            throw new IOException();
        }
        responseheaders.key = DiskBasedCache.readString(inputstream);
        responseheaders.etag = DiskBasedCache.readString(inputstream);
        if (responseheaders.etag.equals(""))
        {
            responseheaders.etag = null;
        }
        responseheaders.serverDate = DiskBasedCache.readLong(inputstream);
        responseheaders.ttl = DiskBasedCache.readLong(inputstream);
        responseheaders.softTtl = DiskBasedCache.readLong(inputstream);
        responseheaders.responseHeaders = DiskBasedCache.readStringStringMap(inputstream);
        return responseheaders;
    }

    public com.mopub.volley.eHeader toCacheEntry(byte abyte0[])
    {
        com.mopub.volley.eHeader eheader = new com.mopub.volley.eHeader();
        eheader.eHeader = abyte0;
        eheader.eHeader = etag;
        eheader.etag = serverDate;
        eheader.serverDate = ttl;
        eheader.ttl = softTtl;
        eheader. = responseHeaders;
        return eheader;
    }

    public boolean writeHeader(OutputStream outputstream)
    {
        DiskBasedCache.writeInt(outputstream, 0x20140623);
        DiskBasedCache.writeString(outputstream, key);
        if (etag != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        String s = "";
_L1:
        try
        {
            DiskBasedCache.writeString(outputstream, s);
            DiskBasedCache.writeLong(outputstream, serverDate);
            DiskBasedCache.writeLong(outputstream, ttl);
            DiskBasedCache.writeLong(outputstream, softTtl);
            DiskBasedCache.writeStringStringMap(responseHeaders, outputstream);
            outputstream.flush();
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            VolleyLog.d("%s", new Object[] {
                outputstream.toString()
            });
            return false;
        }
        return true;
        s = etag;
          goto _L1
    }

    private _cls9()
    {
    }

    public _cls9(String s, com.mopub.volley.eHeader eheader)
    {
        key = s;
        size = eheader.size.length;
        etag = eheader.etag;
        serverDate = eheader.serverDate;
        ttl = eheader.ttl;
        softTtl = eheader.softTtl;
        responseHeaders = eheader.;
    }
}
