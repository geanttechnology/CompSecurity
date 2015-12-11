// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;


// Referenced classes of package twitter4j:
//            JSONObject

class url
    implements url
{

    private static final long serialVersionUID = 0xe417a3c1936481cL;
    int bitrate;
    String contentType;
    String url;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof url))
            {
                return false;
            }
            obj = (url)obj;
            if (bitrate != ((bitrate) (obj)).bitrate)
            {
                return false;
            }
            if (!contentType.equals(((contentType) (obj)).contentType))
            {
                return false;
            }
            if (!url.equals(((url) (obj)).url))
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

    ()
    {
    }

    (JSONObject jsonobject)
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
