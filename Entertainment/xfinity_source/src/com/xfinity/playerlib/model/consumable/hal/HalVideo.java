// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalBaseConsumable, HalNetworkProvider, HalEncoding

public class HalVideo extends HalBaseConsumable
{

    private String contentRating;
    private Date datePublished;
    private int durationInSeconds;
    private List encodings;
    private Date expirationDate;
    private String form;
    private boolean isAdult;
    private HalNetworkProvider provider;
    private String subRating;
    private long videoId;
    private String videoQuality;

    public HalVideo()
    {
        encodings = new ArrayList();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            if (!super.equals(obj))
            {
                return false;
            }
            obj = (HalVideo)obj;
            if (durationInSeconds != ((HalVideo) (obj)).durationInSeconds)
            {
                return false;
            }
            if (isAdult != ((HalVideo) (obj)).isAdult)
            {
                return false;
            }
            if (videoId != ((HalVideo) (obj)).videoId)
            {
                return false;
            }
            if (contentRating == null ? ((HalVideo) (obj)).contentRating != null : !contentRating.equals(((HalVideo) (obj)).contentRating))
            {
                return false;
            }
            if (datePublished == null ? ((HalVideo) (obj)).datePublished != null : !datePublished.equals(((HalVideo) (obj)).datePublished))
            {
                return false;
            }
            if (!encodings.equals(((HalVideo) (obj)).encodings))
            {
                return false;
            }
            if (expirationDate == null ? ((HalVideo) (obj)).expirationDate != null : !expirationDate.equals(((HalVideo) (obj)).expirationDate))
            {
                return false;
            }
            if (form == null ? ((HalVideo) (obj)).form != null : !form.equals(((HalVideo) (obj)).form))
            {
                return false;
            }
            if (provider == null ? ((HalVideo) (obj)).provider != null : !provider.equals(((HalVideo) (obj)).provider))
            {
                return false;
            }
            if (videoQuality == null ? ((HalVideo) (obj)).videoQuality != null : !videoQuality.equals(((HalVideo) (obj)).videoQuality))
            {
                return false;
            }
        }
        return true;
    }

    public String getContentRating()
    {
        return contentRating;
    }

    public Date getDatePublished()
    {
        return datePublished;
    }

    public int getDurationInSeconds()
    {
        return durationInSeconds;
    }

    public HalEncoding getEncoding()
    {
        if (encodings.size() > 0)
        {
            return (HalEncoding)encodings.get(0);
        } else
        {
            return null;
        }
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }

    public String getForm()
    {
        return form;
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getNamespace()
    {
        return null;
    }

    public HalNetworkProvider getProvider()
    {
        return provider;
    }

    public String getSubRating()
    {
        return subRating;
    }

    public long getVideoId()
    {
        return videoId;
    }

    public String getVideoQuality()
    {
        return videoQuality;
    }

    public int hashCode()
    {
        int k1 = 0;
        int l1 = super.hashCode();
        int i2 = (int)(videoId ^ videoId >>> 32);
        int j2 = durationInSeconds;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (datePublished != null)
        {
            i = datePublished.hashCode();
        } else
        {
            i = 0;
        }
        if (expirationDate != null)
        {
            j = expirationDate.hashCode();
        } else
        {
            j = 0;
        }
        if (videoQuality != null)
        {
            k = videoQuality.hashCode();
        } else
        {
            k = 0;
        }
        if (contentRating != null)
        {
            l = contentRating.hashCode();
        } else
        {
            l = 0;
        }
        if (isAdult)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (form != null)
        {
            j1 = form.hashCode();
        } else
        {
            j1 = 0;
        }
        if (provider != null)
        {
            k1 = provider.hashCode();
        }
        return (((((((((l1 * 31 + i2) * 31 + j2) * 31 + i) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + encodings.hashCode();
    }

    public boolean isAdult()
    {
        return isAdult;
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        super.parseHalContent(microdatapropertyresolver);
        videoId = Long.valueOf(microdatapropertyresolver.fetchString("id")).longValue();
        durationInSeconds = microdatapropertyresolver.fetchOptionalInt("duration/seconds", 0);
        datePublished = parseDate(microdatapropertyresolver.fetchOptionalString("datePublished/availableDate"));
        expirationDate = parseDate(microdatapropertyresolver.fetchOptionalString("expires/RFC1123"));
        videoQuality = microdatapropertyresolver.fetchOptionalString("videoQuality");
        if (videoQuality == null)
        {
            videoQuality = "";
        }
        contentRating = microdatapropertyresolver.fetchOptionalString("contentRating");
        subRating = microdatapropertyresolver.fetchOptionalString("subRating");
        isAdult = microdatapropertyresolver.fetchOptionalBoolean("isAdult", true);
        form = microdatapropertyresolver.fetchOptionalString("form");
        if (form == null)
        {
            form = "";
        }
        Object obj = microdatapropertyresolver.fetchOptionalItem("provider");
        if (obj != null)
        {
            provider = new HalNetworkProvider();
            provider.parseHalContent(microdatapropertyresolver.copy(((MicrodataItem) (obj))));
        }
        obj = microdatapropertyresolver.fetchOptionalItemList("encoding");
        if (obj != null)
        {
            HalEncoding halencoding;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); encodings.add(halencoding))
            {
                MicrodataItem microdataitem = (MicrodataItem)((Iterator) (obj)).next();
                halencoding = new HalEncoding();
                halencoding.parseHalContent(microdatapropertyresolver.copy(microdataitem));
            }

        }
    }
}
