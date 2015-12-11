// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import android.os.Parcel;
import android.os.Parcelable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalLiveStreamParseable

public class HalLiveFeaturedContent extends HalLiveStreamParseable
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public HalLiveFeaturedContent createFromParcel(Parcel parcel)
        {
            return new HalLiveFeaturedContent(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public HalLiveFeaturedContent[] newArray(int i)
        {
            return new HalLiveFeaturedContent[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent);
    private String description;
    private Date endDate;
    private String eventId;
    private String packageName;
    private Date startDate;
    private String subTitle;
    private String timeField;
    private String websiteLink;

    public HalLiveFeaturedContent()
    {
    }

    public HalLiveFeaturedContent(Parcel parcel)
    {
        super(parcel);
        description = parcel.readString();
        subTitle = parcel.readString();
        timeField = parcel.readString();
        websiteLink = parcel.readString();
        eventId = parcel.readString();
        startDate = new Date(parcel.readString());
        endDate = new Date(parcel.readString());
    }

    private Date convertDateString(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Date date = (new ISO8601DateFormat()).parse(s);
        return date;
        ParseException parseexception;
        parseexception;
        LOG.error((new StringBuilder()).append("Error parsing live stream featured content date : ").append(s).toString(), parseexception);
        return null;
    }

    public int describeContents()
    {
        return 1;
    }

    public String getDescription()
    {
        return description;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public String getEventId()
    {
        return eventId;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public String getSubTitle()
    {
        return subTitle;
    }

    public String getTimeField()
    {
        return timeField;
    }

    public String getWebsiteLink()
    {
        return websiteLink;
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        super.parseHalContent(microdatapropertyresolver);
        subTitle = microdatapropertyresolver.fetchOptionalString("subtitle");
        description = microdatapropertyresolver.fetchOptionalString("description");
        timeField = microdatapropertyresolver.fetchOptionalString("timeField");
        packageName = microdatapropertyresolver.fetchOptionalString("packageName");
        websiteLink = microdatapropertyresolver.fetchOptionalLinkAsString("website");
        startDate = convertDateString(microdatapropertyresolver.fetchOptionalString("start"));
        endDate = convertDateString(microdatapropertyresolver.fetchOptionalString("end"));
        com.comcast.cim.microdata.model.MicrodataItem microdataitem = microdatapropertyresolver.fetchItem("parameters");
        if (microdataitem != null)
        {
            eventId = microdatapropertyresolver.copy(microdataitem).fetchOptionalString("eventid");
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(description);
        parcel.writeString(subTitle);
        parcel.writeString(timeField);
        parcel.writeString(websiteLink);
        parcel.writeString(eventId);
        if (startDate != null)
        {
            parcel.writeString(startDate.toString());
        }
        if (endDate != null)
        {
            parcel.writeString(endDate.toString());
        }
    }

}
