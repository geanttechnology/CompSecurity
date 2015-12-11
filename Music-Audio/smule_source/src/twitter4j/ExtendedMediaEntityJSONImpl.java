// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Arrays;

// Referenced classes of package twitter4j:
//            MediaEntityJSONImpl, ExtendedMediaEntity, JSONException, JSONObject, 
//            JSONArray, TwitterException

public class ExtendedMediaEntityJSONImpl extends MediaEntityJSONImpl
    implements ExtendedMediaEntity
{

    private static final long serialVersionUID = 0xca0734401bf96625L;
    private int videoAspectRatioHeight;
    private int videoAspectRatioWidth;
    private long videoDurationMillis;
    private Variant videoVariants[];

    ExtendedMediaEntityJSONImpl()
    {
    }

    ExtendedMediaEntityJSONImpl(JSONObject jsonobject)
    {
        int i;
        i = 0;
        super(jsonobject);
        if (!jsonobject.has("video_info"))
        {
            break MISSING_BLOCK_LABEL_118;
        }
        jsonobject = jsonobject.getJSONObject("video_info");
        JSONArray jsonarray = jsonobject.getJSONArray("aspect_ratio");
        videoAspectRatioWidth = jsonarray.getInt(0);
        videoAspectRatioHeight = jsonarray.getInt(1);
        if (!jsonobject.isNull("duration_millis"))
        {
            videoDurationMillis = jsonobject.getLong("duration_millis");
        }
        jsonobject = jsonobject.getJSONArray("variants");
        videoVariants = new Variant[jsonobject.length()];
_L1:
        if (i >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_126;
        }
        videoVariants[i] = new Variant(jsonobject.getJSONObject(i));
        i++;
          goto _L1
        videoVariants = new Variant[0];
        return;
        jsonobject;
        throw new TwitterException(jsonobject);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ExtendedMediaEntityJSONImpl))
            {
                return false;
            }
            obj = (ExtendedMediaEntityJSONImpl)obj;
            if (id != ((ExtendedMediaEntityJSONImpl) (obj)).id)
            {
                return false;
            }
        }
        return true;
    }

    public int getVideoAspectRatioHeight()
    {
        return videoAspectRatioHeight;
    }

    public int getVideoAspectRatioWidth()
    {
        return videoAspectRatioWidth;
    }

    public long getVideoDurationMillis()
    {
        return videoDurationMillis;
    }

    public ExtendedMediaEntity.Variant[] getVideoVariants()
    {
        return videoVariants;
    }

    public int hashCode()
    {
        return (int)(id ^ id >>> 32);
    }

    public String toString()
    {
        return (new StringBuilder()).append("ExtendedMediaEntityJSONImpl{id=").append(id).append(", url=").append(url).append(", mediaURL=").append(mediaURL).append(", mediaURLHttps=").append(mediaURLHttps).append(", expandedURL=").append(expandedURL).append(", displayURL='").append(displayURL).append('\'').append(", sizes=").append(sizes).append(", type=").append(type).append(", videoAspectRatioWidth=").append(videoAspectRatioWidth).append(", videoAspectRatioHeight=").append(videoAspectRatioHeight).append(", videoDurationMillis=").append(videoDurationMillis).append(", videoVariants=").append(Arrays.toString(videoVariants)).append('}').toString();
    }

    private class Variant
        implements ExtendedMediaEntity.Variant
    {

        private static final long serialVersionUID = 0xe417a3c1936481cL;
        int bitrate;
        String contentType;
        String url;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof Variant))
                {
                    return false;
                }
                obj = (Variant)obj;
                if (bitrate != ((Variant) (obj)).bitrate)
                {
                    return false;
                }
                if (!contentType.equals(((Variant) (obj)).contentType))
                {
                    return false;
                }
                if (!url.equals(((Variant) (obj)).url))
                {
                    return false;
                }
            }
            return true;
        }

        public int getBitrate()
        {
            return bitrate;
        }

        public String getContentType()
        {
            return contentType;
        }

        public String getUrl()
        {
            return url;
        }

        public int hashCode()
        {
            int j = 0;
            int k = bitrate;
            int i;
            if (contentType != null)
            {
                i = contentType.hashCode();
            } else
            {
                i = 0;
            }
            if (url != null)
            {
                j = url.hashCode();
            }
            return (i + k * 31) * 31 + j;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Variant{bitrate=").append(bitrate).append(", contentType=").append(contentType).append(", url=").append(url).append('}').toString();
        }

        Variant()
        {
        }

        Variant(JSONObject jsonobject)
        {
            int i;
            if (jsonobject.has("bitrate"))
            {
                i = jsonobject.getInt("bitrate");
            } else
            {
                i = 0;
            }
            bitrate = i;
            contentType = jsonobject.getString("content_type");
            url = jsonobject.getString("url");
        }
    }

}
