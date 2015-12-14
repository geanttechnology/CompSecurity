// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomDownloadId
{
    public static final class RequestType extends Enum
    {

        private static final RequestType $VALUES[];
        public static final RequestType ASSET;
        public static final RequestType ORIGINAL;

        public static RequestType valueOf(String s)
        {
            return (RequestType)Enum.valueOf(com/amazon/gallery/framework/network/download/CustomDownloadId$RequestType, s);
        }

        public static RequestType[] values()
        {
            return (RequestType[])$VALUES.clone();
        }

        static 
        {
            ORIGINAL = new RequestType("ORIGINAL", 0);
            ASSET = new RequestType("ASSET", 1);
            $VALUES = (new RequestType[] {
                ORIGINAL, ASSET
            });
        }

        private RequestType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/download/CustomDownloadId.getName();
    private final int category;
    private int desiredHeight;
    private int desiredWidth;
    private ObjectID mediaItemObjectId;
    private MediaType mediaType;
    private RequestType requestType;
    private final ObjectID tagObjectId;
    private int total;

    public CustomDownloadId(ObjectID objectid)
    {
        total = -1;
        requestType = RequestType.ASSET;
        tagObjectId = ObjectID.getRoot();
        category = 2;
        mediaItemObjectId = objectid;
    }

    public CustomDownloadId(ObjectID objectid, int i)
    {
        total = -1;
        requestType = RequestType.ASSET;
        tagObjectId = objectid;
        category = 0;
        total = i;
    }

    public CustomDownloadId(ObjectID objectid, ObjectID objectid1)
    {
        total = -1;
        requestType = RequestType.ASSET;
        tagObjectId = objectid;
        category = 1;
        mediaItemObjectId = objectid1;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (CustomDownloadId)obj;
            if (category != ((CustomDownloadId) (obj)).category)
            {
                return false;
            }
            if (desiredHeight != ((CustomDownloadId) (obj)).desiredHeight)
            {
                return false;
            }
            if (desiredWidth != ((CustomDownloadId) (obj)).desiredWidth)
            {
                return false;
            }
            if (total != ((CustomDownloadId) (obj)).total)
            {
                return false;
            }
            if (mediaItemObjectId == null ? ((CustomDownloadId) (obj)).mediaItemObjectId != null : !mediaItemObjectId.equals(((CustomDownloadId) (obj)).mediaItemObjectId))
            {
                return false;
            }
            if (mediaType != ((CustomDownloadId) (obj)).mediaType)
            {
                return false;
            }
            if (!tagObjectId.equals(((CustomDownloadId) (obj)).tagObjectId))
            {
                return false;
            }
            if (requestType != ((CustomDownloadId) (obj)).requestType)
            {
                return false;
            }
        }
        return true;
    }

    public int getCategory()
    {
        return category;
    }

    public int getDesiredHeight()
    {
        return desiredHeight;
    }

    public int getDesiredWidth()
    {
        return desiredWidth;
    }

    public ObjectID getMediaItemObjectId()
    {
        return mediaItemObjectId;
    }

    public MediaType getMediaType()
    {
        return mediaType;
    }

    public RequestType getRequestType()
    {
        return requestType;
    }

    public ObjectID getTag()
    {
        return tagObjectId;
    }

    public int getTotal()
    {
        return total;
    }

    public int hashCode()
    {
        int j = 0;
        int k = tagObjectId.hashCode();
        int l = category;
        int i1 = total;
        int i;
        if (mediaItemObjectId != null)
        {
            i = mediaItemObjectId.hashCode();
        } else
        {
            i = 0;
        }
        if (mediaType != null)
        {
            j = mediaType.hashCode();
        }
        return ((((((k * 31 + l) * 31 + i1) * 31 + i) * 31 + j) * 31 + desiredWidth) * 31 + desiredHeight) * 31 + requestType.ordinal();
    }

    public void setDesiredHeight(int i)
    {
        desiredHeight = i;
    }

    public void setDesiredWidth(int i)
    {
        desiredWidth = i;
    }

    public void setMediaType(MediaType mediatype)
    {
        mediaType = mediatype;
    }

    public void setRequestType(RequestType requesttype)
    {
        requestType = requesttype;
    }

    public String toJSON()
    {
        Object obj;
        obj = new JSONObject();
        ((JSONObject) (obj)).put("tag", tagObjectId.toString());
        ((JSONObject) (obj)).put("category", category);
        category;
        JVM INSTR tableswitch 0 2: default 191
    //                   0 104
    //                   1 120
    //                   2 120;
           goto _L1 _L2 _L3 _L3
_L1:
        throw new JSONException((new StringBuilder()).append("Undefined category: ").append(category).toString());
        obj;
        throw new IllegalStateException(((Throwable) (obj)));
_L2:
        ((JSONObject) (obj)).put("total", total);
_L5:
        return ((JSONObject) (obj)).toString();
_L3:
        ((JSONObject) (obj)).put("mediaItem", mediaItemObjectId);
        ((JSONObject) (obj)).put("mediaType", mediaType);
        ((JSONObject) (obj)).put("requestType", requestType.toString());
        if (requestType == RequestType.ASSET)
        {
            ((JSONObject) (obj)).put("desiredWidth", desiredWidth);
            ((JSONObject) (obj)).put("desiredHeight", desiredHeight);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public String toString()
    {
        return toJSON();
    }

}
