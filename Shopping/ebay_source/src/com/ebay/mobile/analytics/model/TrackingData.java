// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.model;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.common.util.TrackableDictionary;
import com.ebay.mobile.analytics.AnalyticsService;
import com.ebay.mobile.analytics.AnalyticsUtil;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.experimentation.ExperimentationUtil;
import com.ebay.nautilus.domain.data.SerializablePair;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwContext;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.mobile.analytics.model:
//            TrackingFlags, SourceIdentification

public class TrackingData
    implements Parcelable, TrackableDictionary
{
    public static final class SendHelper
    {

        private final Context context;
        private final EbayContext ebayContext;

        public void send(TrackingData trackingdata)
        {
            trackingdata.send(context, ebayContext);
        }

        public SendHelper(Activity activity)
        {
            context = activity;
            if (activity instanceof FwActivity)
            {
                activity = ((FwActivity)activity).getEbayContext();
            } else
            {
                activity = null;
            }
            ebayContext = activity;
        }

        public SendHelper(Service service)
        {
            context = service;
            ebayContext = ((FwContext)service).getEbayContext();
        }

        public SendHelper(EbayContext ebaycontext)
        {
            context = (Context)ebaycontext.getExtension(android/content/Context);
            ebayContext = ebaycontext;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TrackingData createFromParcel(Parcel parcel)
        {
            return new TrackingData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public TrackingData[] newArray(int i)
        {
            return new TrackingData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String DEFAULT_PRINT_FORMAT = (new StringBuilder()).append(com/ebay/mobile/analytics/model/TrackingData.getSimpleName()).append(" event %s of type %s.").toString();
    private static final Pattern INVALID_KEY_PATTERN = Pattern.compile("[^a-zA-Z0-9]");
    public static final String TRACKING_DATA_EXTRA = "com.ebay.common.model.analytics.tracking_data";
    protected boolean forceFlush;
    protected final String name;
    protected final Bundle sessionData;
    protected SourceIdentification sid;
    protected final Bundle tags;
    protected TrackingFlags trackingFlags;
    protected final TrackingType trackingType;

    protected TrackingData(Parcel parcel)
    {
        name = parcel.readString();
        trackingType = TrackingType.valueOf(parcel.readString());
        trackingFlags = (TrackingFlags)parcel.readParcelable(com/ebay/mobile/analytics/model/TrackingFlags.getClassLoader());
        tags = parcel.readBundle();
        sessionData = parcel.readBundle();
        sid = (SourceIdentification)parcel.readParcelable(com/ebay/mobile/analytics/model/SourceIdentification.getClassLoader());
    }

    public TrackingData(TrackingData trackingdata)
    {
        name = trackingdata.name;
        trackingType = trackingdata.trackingType;
        tags = new Bundle(trackingdata.tags);
        sessionData = new Bundle(trackingdata.sessionData);
        trackingFlags = new TrackingFlags(trackingdata.trackingFlags);
        trackingdata = trackingdata.getSourceIdentification();
        if (trackingdata != null)
        {
            sid = new SourceIdentification(trackingdata.getEvent(), trackingdata.getModule(), trackingdata.getLink());
            return;
        } else
        {
            sid = null;
            return;
        }
    }

    public TrackingData(String s, TrackingType trackingtype)
    {
        this(s, null, trackingtype);
    }

    public TrackingData(String s, String s1, TrackingType trackingtype)
    {
        String s2 = s;
        if (TextUtils.isEmpty(s))
        {
            s2 = null;
        }
        name = s2;
        s = trackingtype;
        if (trackingtype == null)
        {
            s = TrackingType.PAGE_IMPRESSION;
        }
        trackingType = s;
        tags = new Bundle();
        sessionData = new Bundle();
        trackingFlags = new TrackingFlags(s1);
        sid = null;
    }

    public static final void logContents(com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo, TrackingData trackingdata)
    {
        logTrackingData(loginfo, trackingdata, DEFAULT_PRINT_FORMAT);
    }

    public static final void logContentsWithFormat(com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo, TrackingData trackingdata, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            logTrackingData(loginfo, trackingdata, DEFAULT_PRINT_FORMAT);
            return;
        }
        try
        {
            String.format(s, new Object[] {
                "1", "2"
            });
            logTrackingData(loginfo, trackingdata, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logTrackingData(loginfo, trackingdata, DEFAULT_PRINT_FORMAT);
        }
    }

    private static final void logTrackingData(com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo, TrackingData trackingdata, String s)
    {
        if (loginfo == null || !loginfo.isLoggable) goto _L2; else goto _L1
_L1:
        if (trackingdata != null) goto _L4; else goto _L3
_L3:
        loginfo.log((new StringBuilder()).append(com/ebay/mobile/analytics/model/TrackingData.getSimpleName()).append(" object is null.").toString());
_L2:
        return;
_L4:
        if (loginfo.priority <= 3)
        {
            loginfo.log(String.format(s, new Object[] {
                trackingdata.getName(), trackingdata.getTrackingType().toString()
            }));
        }
        if (loginfo.priority <= 2)
        {
            if (trackingdata.hasSessionData())
            {
                loginfo.log("\tSession data:");
                String s1;
                for (s = trackingdata.sessionData.keySet().iterator(); s.hasNext(); loginfo.log((new StringBuilder()).append("\t\t-").append(s1).append(" : ").append(trackingdata.sessionData.getString(s1)).toString()))
                {
                    s1 = (String)s.next();
                }

            }
            if (trackingdata.hasKeyValuePairs())
            {
                loginfo.log("\tTag data:");
                String s2;
                for (s = trackingdata.tags.keySet().iterator(); s.hasNext(); loginfo.log((new StringBuilder()).append("\t\t-").append(s2).append(" : ").append(trackingdata.tags.getString(s2)).toString()))
                {
                    s2 = (String)s.next();
                }

            }
            if (trackingdata.hasFlags())
            {
                loginfo.log((new StringBuilder()).append("\tFlagset ").append(trackingdata.trackingFlags.getName()).append(":").toString());
                trackingdata = trackingdata.trackingFlags.getBitPositionsAsStrings().iterator();
                while (trackingdata.hasNext()) 
                {
                    s = (String)trackingdata.next();
                    loginfo.log((new StringBuilder()).append("\t\t-Bit position : ").append(s).toString());
                }
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static final String sanitize(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return INVALID_KEY_PATTERN.matcher(s).replaceAll("");
        }
    }

    public TrackingData addExperimentEventTargetTags(Treatment treatment)
    {
        if (treatment != null && treatment.eTags != null)
        {
            SerializablePair serializablepair;
            for (treatment = treatment.eTags.iterator(); treatment.hasNext(); addKeyValuePair((String)serializablepair.key, (String)serializablepair.value))
            {
                serializablepair = (SerializablePair)treatment.next();
            }

        }
        return this;
    }

    public TrackingData addExperimentServedTags(Treatment treatment)
    {
        if (treatment != null && treatment.xTags != null)
        {
            SerializablePair serializablepair;
            for (treatment = treatment.xTags.iterator(); treatment.hasNext(); addKeyValuePair((String)serializablepair.key, (String)serializablepair.value))
            {
                serializablepair = (SerializablePair)treatment.next();
            }

        }
        return this;
    }

    public void addFlag(int i)
    {
        trackingFlags.setBitPosition(i);
    }

    public void addKeyValuePair(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            tags.putString(s, s1);
        }
    }

    public void addKeyValuePair(String s, String s1, boolean flag)
    {
        String s2 = s1;
        if (flag)
        {
            s2 = sanitize(s1);
        }
        addKeyValuePair(s, s2);
    }

    public void addSessionData(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            sessionData.putString(s, s1);
        }
    }

    public TrackingData addSourceIdentification(Intent intent)
    {
        if (intent != null)
        {
            SourceIdentification sourceidentification = (SourceIdentification)intent.getParcelableExtra("com.ebay.mobile.analytics.sid");
            intent.removeExtra("com.ebay.mobile.analytics.sid");
            sid = sourceidentification;
        }
        return this;
    }

    public TrackingData addSourceIdentification(SourceIdentification sourceidentification)
    {
        sid = sourceidentification;
        return this;
    }

    public void clearAll()
    {
        if (trackingFlags != null)
        {
            trackingFlags.clearAllFlags();
        }
        if (tags != null)
        {
            tags.clear();
        }
        if (sessionData != null)
        {
            sessionData.clear();
        }
        sid = null;
    }

    public void clearSessionData()
    {
        if (sessionData != null)
        {
            sessionData.clear();
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAndRemoveValueForKey(String s)
    {
        String s1 = tags.getString(s);
        removeKeyValuePair(s);
        return s1;
    }

    public Set getKeySet()
    {
        return tags.keySet();
    }

    public Bundle getKeyValuePairs()
    {
        return (Bundle)tags.clone();
    }

    public String getName()
    {
        return name;
    }

    public Bundle getSessionData()
    {
        return (Bundle)sessionData.clone();
    }

    public String getSessionDataForKey(String s)
    {
        return sessionData.getString(s);
    }

    public Set getSessionKeySet()
    {
        return sessionData.keySet();
    }

    public SourceIdentification getSourceIdentification()
    {
        return sid;
    }

    public TrackingFlags getTrackingFlags()
    {
        return trackingFlags;
    }

    public TrackingType getTrackingType()
    {
        return trackingType;
    }

    public String getValueForKey(String s)
    {
        return tags.getString(s);
    }

    public boolean hasFlags()
    {
        return trackingFlags != null && trackingFlags.hasFlags();
    }

    public boolean hasKeyValuePairs()
    {
        return !tags.isEmpty();
    }

    public boolean hasSessionData()
    {
        return !sessionData.isEmpty();
    }

    public boolean removeFlag(int i)
    {
        return trackingFlags.clearBitPosition(i);
    }

    public boolean removeKeyValuePair(String s)
    {
        if (!TextUtils.isEmpty(s) && tags != null && tags.containsKey(s))
        {
            tags.remove(s);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean removeSessionData(String s)
    {
        if (!TextUtils.isEmpty(s) && sessionData != null && sessionData.containsKey(s))
        {
            sessionData.remove(s);
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean requiresFlush()
    {
        return forceFlush;
    }

    public void send(Activity activity)
    {
        EbayContext ebaycontext;
        if (activity instanceof FwActivity)
        {
            ebaycontext = ((FwActivity)activity).getEbayContext();
        } else
        {
            ebaycontext = null;
        }
        send(((Context) (activity)), ebaycontext);
    }

    public void send(Service service)
    {
        send(((Context) (service)), ((FwContext)service).getEbayContext());
    }

    public void send(Context context, EbayContext ebaycontext)
    {
        if (name != null && context != null)
        {
            addSessionData("ids", MimsUtil.getIdentityStringEncoded());
            if (ebaycontext != null)
            {
                ebaycontext = ExperimentationUtil.getManager(ebaycontext, false);
                if (ebaycontext != null)
                {
                    sessionData.putBundle("qTags", ebaycontext.getTrackingSessionState());
                }
            }
            ebaycontext = new Intent(context, com/ebay/mobile/analytics/AnalyticsService);
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.ebay.common.model.analytics.tracking_data", this);
            ebaycontext.putExtras(bundle);
            context.startService(ebaycontext);
        } else
        if (AnalyticsUtil.debugLogger.isLoggable)
        {
            if (name == null)
            {
                AnalyticsUtil.debugLogger.log("Attempted to send a tracking event that had no name. Event supressed.");
            }
            if (context == null)
            {
                ebaycontext = AnalyticsUtil.debugLogger;
                StringBuilder stringbuilder = (new StringBuilder()).append("Attempted to send ");
                if (name == null)
                {
                    context = "unknown event";
                } else
                {
                    context = name;
                }
                ebaycontext.log(stringbuilder.append(context).append(" with null context. Event supressed.").toString());
                return;
            }
        }
    }

    public void send(EbayContext ebaycontext)
    {
        send((Context)ebaycontext.getExtension(android/content/Context), ebaycontext);
    }

    public final void setFlush(boolean flag)
    {
        forceFlush = flag;
    }

    public final void setTrackingFlags(TrackingFlags trackingflags)
    {
        if (trackingflags != null)
        {
            trackingFlags = trackingflags;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(trackingType.toString()).append(" tracking type named ").append(name).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeString(trackingType.toString());
        parcel.writeParcelable(trackingFlags, 0);
        parcel.writeBundle(tags);
        parcel.writeBundle(sessionData);
        parcel.writeParcelable(sid, 0);
    }

}
