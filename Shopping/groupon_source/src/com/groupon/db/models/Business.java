// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.util.BuyUtils;
import com.groupon.util.SortableCard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            AbstractBusiness, Special, Deal, Location, 
//            Tip

public class Business extends AbstractBusiness
    implements SortableCard
{
    protected static class Categorizations
    {

        public Collection children;
        public String friendlyName;

        protected Categorizations()
        {
            friendlyName = "";
            children = Collections.emptyList();
        }
    }

    protected static class Children
    {

        public Collection children;
        public String friendlyName;

        protected Children()
        {
            friendlyName = "";
            children = Collections.emptyList();
        }
    }

    protected static class Division
    {

        public String name;
        public String permalink;

        protected Division()
        {
            name = "";
            permalink = "";
        }
    }

    protected static class HeroImage
    {

        public String url;

        protected HeroImage()
        {
            url = "";
        }
    }

    protected static class Interval
    {

        public String interval;

        protected Interval()
        {
            interval = "";
        }
    }

    protected static class Offerings
    {

        public List deals;
        public List ordering;
        public List specials;

        protected Offerings()
        {
            ordering = Collections.emptyList();
            deals = Collections.emptyList();
            specials = Collections.emptyList();
        }
    }

    protected static class OpenHour
    {

        public String days;
        public Collection intervals;

        protected OpenHour()
        {
            days = "";
            intervals = Collections.emptyList();
        }
    }

    protected static class Recommendations
    {

        public String percentMessage;
        public String totalMessage;

        protected Recommendations()
        {
            percentMessage = "";
            totalMessage = "";
        }
    }


    protected static final Division DefaultDivision = new Division();
    protected static final HeroImage DefaultHeroImage = new HeroImage();
    protected static final Offerings DefaultOfferings = new Offerings();
    protected static final Recommendations DefaultRecommendations = new Recommendations();
    protected volatile ArrayList businessLocationsList;
    public String businessUrl;
    public String categorizationFriendlyName;
    public Collection categorizations;
    public String channel;
    public Collection deals;
    public volatile ArrayList dealsList;
    public int derivedActualPosition;
    public int derivedTrackingPosition;
    public String descriptionHtml;
    public Division division;
    public String divisionName;
    public String divisionPermalink;
    public String firstSpecialName;
    public boolean hasDeals;
    public boolean hasSpecials;
    public HeroImage heroImage;
    public boolean isExactMatch;
    public Collection locations;
    public Date modificationDate;
    public Offerings offerings;
    public Collection openHours;
    public HashMap openHoursMap;
    public String orderingListString;
    public String percentMessage;
    public String phoneNumber;
    public Long primaryKey;
    public String recommend;
    public Recommendations recommendations;
    public String remoteId;
    public boolean requestedDeal;
    public String requestedDealMessage;
    public Collection specials;
    public volatile ArrayList specialsList;
    public int tipCount;
    public Collection tips;
    public volatile ArrayList tipsList;
    public String titleHtml;
    public String totalMessage;
    public String website;

    public Business()
    {
        division = DefaultDivision;
        offerings = DefaultOfferings;
        heroImage = DefaultHeroImage;
        recommendations = DefaultRecommendations;
        descriptionHtml = "";
        titleHtml = "";
        website = "";
        businessUrl = "";
        isExactMatch = false;
        phoneNumber = "";
        divisionName = "";
        divisionPermalink = "";
        tipCount = 0;
        requestedDeal = false;
        requestedDealMessage = "";
        categorizations = Collections.emptyList();
        openHours = Collections.emptyList();
        percentMessage = "";
        totalMessage = "";
        recommend = "";
        openHoursMap = new HashMap();
        hasDeals = false;
        hasSpecials = false;
        firstSpecialName = "";
        categorizationFriendlyName = "";
        orderingListString = null;
        locations = Collections.emptyList();
        specials = Collections.emptyList();
        deals = Collections.emptyList();
        tips = Collections.emptyList();
    }

    public void afterJsonDeserializationPostProcessor(BuyUtils buyutils)
    {
        boolean flag1 = true;
        setSpecials(offerings.specials);
        setDeals(offerings.deals);
        boolean flag;
        if (!offerings.specials.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasSpecials = flag;
        if (!offerings.deals.isEmpty())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        hasDeals = flag;
        if (hasSpecials)
        {
            firstSpecialName = ((Special)offerings.specials.get(0)).name;
        }
        if (division != null)
        {
            divisionName = division.name;
            divisionPermalink = division.permalink;
        }
        if (heroImage != null)
        {
            heroImageUrl = heroImage.url;
        }
        if (recommendations != null)
        {
            percentMessage = recommendations.percentMessage;
            totalMessage = recommendations.totalMessage;
        }
        for (Iterator iterator = getSpecials().iterator(); iterator.hasNext(); ((Special)iterator.next()).afterJsonDeserializationPostProcessor()) { }
        for (Iterator iterator1 = getDeals().iterator(); iterator1.hasNext(); ((Deal)iterator1.next()).afterJsonDeserializationPostProcessor(buyutils)) { }
        if (offerings.ordering != null)
        {
            buyutils = new ArrayList();
            for (Iterator iterator2 = offerings.ordering.iterator(); iterator2.hasNext(); buyutils.add((String)iterator2.next())) { }
            orderingListString = Strings.join(" ", buyutils);
        }
        OpenHour openhour;
        ArrayList arraylist;
        for (buyutils = openHours.iterator(); buyutils.hasNext(); openHoursMap.put(openhour.days, Strings.join(",", arraylist)))
        {
            openhour = (OpenHour)buyutils.next();
            arraylist = new ArrayList();
            for (Iterator iterator3 = openhour.intervals.iterator(); iterator3.hasNext(); arraylist.add(((Interval)iterator3.next()).interval)) { }
        }

        if (categorizations != null && categorizations.size() > 0)
        {
            categorizationFriendlyName = getFriendlyCatorizationNameRecursive(categorizations.toArray()[0]);
        }
    }

    public int cardPosition()
    {
        return derivedActualPosition;
    }

    public ArrayList getDeals()
    {
        if (dealsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (dealsList == null)
        {
            dealsList = new ArrayList(deals);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return dealsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getFriendlyCatorizationNameRecursive(Object obj)
    {
        if (obj instanceof Categorizations)
        {
            obj = (Categorizations)obj;
            if (((Categorizations) (obj)).children.size() == 0)
            {
                return ((Categorizations) (obj)).friendlyName;
            } else
            {
                return getFriendlyCatorizationNameRecursive(((Categorizations) (obj)).children.toArray()[0]);
            }
        }
        if (obj instanceof Children)
        {
            obj = (Children)obj;
            if (((Children) (obj)).children.size() == 0)
            {
                return ((Children) (obj)).friendlyName;
            } else
            {
                return getFriendlyCatorizationNameRecursive(((Children) (obj)).children.toArray()[0]);
            }
        } else
        {
            return "";
        }
    }

    public ArrayList getLocations()
    {
        if (businessLocationsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (businessLocationsList == null)
        {
            businessLocationsList = new ArrayList(locations);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return businessLocationsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getRecommend()
    {
        if (recommend == null)
        {
            return "";
        } else
        {
            return recommend;
        }
    }

    public ArrayList getSpecials()
    {
        if (specialsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (specialsList == null)
        {
            specialsList = new ArrayList(specials);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return specialsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ArrayList getTips()
    {
        if (tipsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (tipsList == null)
        {
            tipsList = new ArrayList(tips);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return tipsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setDeals(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Deal)collection.next()).parentBusiness = this;
        }

        deals = ((Collection) (obj));
    }

    public void setLocations(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Location)collection.next()).parentBusiness = this;
        }

        locations = ((Collection) (obj));
    }

    public void setSpecials(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Special)collection.next()).parentBusiness = this;
        }

        specials = ((Collection) (obj));
    }

    public void setTips(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Tip)collection.next()).parentBusiness = this;
        }

        tips = ((Collection) (obj));
    }

}
