// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;

import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.model.media:
//            UploadPart

public class UploadChunk
    implements Comparable
{

    private final int chunkNumber;
    private String eTag;
    private final String filePath;
    private final String headers;
    private final String parameters;
    private final long startPosition;
    private final String uploadUrl;

    public UploadChunk(String s, int i, long l, String s1, String s2, String s3, 
            String s4)
    {
        filePath = s;
        chunkNumber = i;
        startPosition = l;
        uploadUrl = s1;
        headers = s2;
        parameters = s3;
        eTag = s4;
    }

    public UploadChunk(String s, UploadPart uploadpart, long l)
    {
        this(s, uploadpart.getPartNumber(), l, uploadpart.getUploadUrl(), uploadpart.getHeaders().toString(), uploadpart.getUploadParameters().toString(), null);
    }

    public int compareTo(UploadChunk uploadchunk)
    {
        if (uploadchunk == null)
        {
            return -1;
        } else
        {
            return chunkNumber - uploadchunk.chunkNumber;
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((UploadChunk)obj);
    }

    public int getChunkNumber()
    {
        return chunkNumber;
    }

    public String getETag()
    {
        return eTag;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public String getHeaders()
    {
        return headers;
    }

    public String getParameters()
    {
        return parameters;
    }

    public long getStartPosition()
    {
        return startPosition;
    }

    public String getUploadUrl()
    {
        return uploadUrl;
    }

    public void setETag(String s)
    {
        eTag = s;
    }
}
