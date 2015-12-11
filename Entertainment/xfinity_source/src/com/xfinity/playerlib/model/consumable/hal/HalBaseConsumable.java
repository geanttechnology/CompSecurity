// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.xfinity.playerlib.model.MerlinId;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalActor, HalReview

public abstract class HalBaseConsumable
    implements HalParseable
{

    private static final SimpleDateFormat sdf;
    private Set castList;
    private String description;
    private MerlinId merlinEntityId;
    private List reviews;
    private String title;

    public HalBaseConsumable()
    {
        castList = new LinkedHashSet();
        reviews = new ArrayList();
    }

    private String removeTz(String s)
    {
        return s.substring(0, s.length() - 4);
    }

    public String castListAsString()
    {
        String s = "";
        for (Iterator iterator = castList.iterator(); iterator.hasNext();)
        {
            HalActor halactor = (HalActor)iterator.next();
            String s1 = s;
            if (!s.isEmpty())
            {
                s1 = (new StringBuilder()).append(s).append(", ").toString();
            }
            s = (new StringBuilder()).append(s1).append(halactor.getName()).toString();
        }

        return s;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (HalBaseConsumable)obj;
            if (castList == null ? ((HalBaseConsumable) (obj)).castList != null : !castList.equals(((HalBaseConsumable) (obj)).castList))
            {
                return false;
            }
            if (description == null ? ((HalBaseConsumable) (obj)).description != null : !description.equals(((HalBaseConsumable) (obj)).description))
            {
                return false;
            }
            if (merlinEntityId == null ? ((HalBaseConsumable) (obj)).merlinEntityId != null : !merlinEntityId.equals(((HalBaseConsumable) (obj)).merlinEntityId))
            {
                return false;
            }
            if (title == null ? ((HalBaseConsumable) (obj)).title != null : !title.equals(((HalBaseConsumable) (obj)).title))
            {
                return false;
            }
        }
        return true;
    }

    public Set getCastList()
    {
        return castList;
    }

    public String getDescription()
    {
        return description;
    }

    public MerlinId getMerlinEntityId()
    {
        return merlinEntityId;
    }

    public abstract com.xfinity.playerlib.model.MerlinId.Namespace getNamespace();

    public List getReviews()
    {
        return reviews;
    }

    public String getTitle()
    {
        return title;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (merlinEntityId != null)
        {
            i = merlinEntityId.hashCode();
        } else
        {
            i = 0;
        }
        if (title != null)
        {
            j = title.hashCode();
        } else
        {
            j = 0;
        }
        if (description != null)
        {
            k = description.hashCode();
        } else
        {
            k = 0;
        }
        if (castList != null)
        {
            l = castList.hashCode();
        }
        return ((i * 31 + j) * 31 + k) * 31 + l;
    }

    protected Date parseDate(String s)
    {
        if (s != null)
        {
            return sdf.parse(removeTz(s), new ParsePosition(0));
        } else
        {
            return null;
        }
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        if (getNamespace() != null)
        {
            String s = microdatapropertyresolver.fetchString("id");
            merlinEntityId = new MerlinId(getNamespace(), Long.valueOf(Long.parseLong(s)));
        }
        title = microdatapropertyresolver.fetchOptionalString("name");
        if (title == null)
        {
            title = "";
        }
        description = microdatapropertyresolver.fetchOptionalString("description");
        if (description == null)
        {
            description = "";
        }
        Object obj = microdatapropertyresolver.fetchOptionalItemList("actor");
        if (obj != null)
        {
            HalActor halactor;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); castList.add(halactor))
            {
                MicrodataItem microdataitem = (MicrodataItem)((Iterator) (obj)).next();
                halactor = new HalActor();
                halactor.parseHalContent(microdatapropertyresolver.copy(microdataitem));
            }

        }
        obj = microdatapropertyresolver.fetchOptionalItemList("reviews");
        if (obj != null)
        {
            HalReview halreview;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); reviews.add(halreview))
            {
                MicrodataItem microdataitem1 = (MicrodataItem)((Iterator) (obj)).next();
                halreview = new HalReview();
                halreview.parseHalContent(microdatapropertyresolver.copy(microdataitem1));
            }

        }
    }

    static 
    {
        sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
