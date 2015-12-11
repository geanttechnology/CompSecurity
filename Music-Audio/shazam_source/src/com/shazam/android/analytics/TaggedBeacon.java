// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.android.analytics.event.EventParameters;
import com.shazam.b.e.a;
import com.shazam.model.Factory;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.audio.Messages;
import com.shazam.model.audio.Mood;
import com.shazam.model.audio.Watermark;
import com.shazam.model.gimbal.Gimbal;
import com.shazam.model.gimbal.GimbalBeacon;
import com.shazam.model.location.SimpleLocation;
import com.shazam.n.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.analytics:
//            TaggingOutcome, TaggedBeaconData

public class TaggedBeacon
{
    private static class SizedTimeInterval
    {

        public int dataSize;
        public final l timeInterval;

        public SizedTimeInterval(l l1)
        {
            timeInterval = l1;
        }
    }


    public static final String RECOGNITION_TYPE_NETWORK = "network";
    protected String beaconKey;
    protected String campaign;
    protected String category;
    protected l currentLatencyInterval;
    protected SizedTimeInterval currentRequestSizedInterval;
    protected SizedTimeInterval currentResponseSizedInterval;
    protected long endTime;
    private com.shazam.android.analytics.event.EventParameters.Builder eventParametersBuilder;
    private boolean finishedInnerTaggedBeacon;
    private Gimbal gimbal;
    protected TaggedBeacon innerTaggedBeacon;
    protected final ArrayList latencyIntervalList = new ArrayList();
    protected SimpleLocation location;
    protected String networkTypeName;
    protected TaggingOutcome outcome;
    protected String recognitionType;
    protected l recordingTimeInterval;
    protected String requestId;
    protected final ArrayList requestSizedIntervalList = new ArrayList();
    protected final ArrayList responseSizedIntervalList = new ArrayList();
    protected Long sampleLength;
    protected final long startTime;
    protected String tagResultVersion;
    protected final TaggedBeaconData taggedBeaconData;
    protected final Factory timeIntervalFactory;
    protected String trackId;
    protected final l uiTime = newTimeInterval();
    protected boolean unsubmitted;
    protected Watermark watermark;

    protected TaggedBeacon(Factory factory, TaggedBeaconData taggedbeacondata, long l1)
    {
        eventParametersBuilder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters();
        outcome = TaggingOutcome.UNKNOWN;
        finishedInnerTaggedBeacon = false;
        timeIntervalFactory = factory;
        startTime = l1;
        taggedBeaconData = taggedbeacondata;
    }

    private void appendGimbalParametersToParameterMap(com.shazam.android.analytics.event.EventParameters.Builder builder, Gimbal gimbal1)
    {
        if (gimbal1 != null && gimbal1.beacons != null && !gimbal1.beacons.isEmpty())
        {
            gimbal1 = gimbal1.beacons;
            StringBuilder stringbuilder = new StringBuilder();
            Iterator iterator = gimbal1.iterator();
            for (gimbal1 = ""; iterator.hasNext(); gimbal1 = ":")
            {
                GimbalBeacon gimbalbeacon = (GimbalBeacon)iterator.next();
                stringbuilder.append(gimbal1).append(gimbalbeacon.uuid).append(",").append(gimbalbeacon.rssi);
            }

            builder.putNotEmptyOrNullParameter(com.shazam.android.analytics.event.StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey("gimbal").build(), stringbuilder.toString());
        }
    }

    public static void appendWatermarkParametersToParameterMap(com.shazam.android.analytics.event.EventParameters.Builder builder, Watermark watermark1)
    {
        if (watermark1 != null && watermark1.mood != null)
        {
            watermark1 = watermark1.mood.messages.iterator();
            int i = 1;
            do
            {
                if (!watermark1.hasNext())
                {
                    break;
                }
                Messages messages = (Messages)watermark1.next();
                if (a.c(messages.id))
                {
                    builder.putNotEmptyOrNullParameter(com.shazam.android.analytics.event.StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey((new StringBuilder("watermark")).append(i).toString()).build(), (new StringBuilder()).append(messages.id).append(",").append(messages.type).toString());
                    i++;
                }
            } while (true);
        }
    }

    private boolean forwardToInnerTaggedBeacon()
    {
        return innerTaggedBeacon != null && !isFinishedInnerTaggedBeacon();
    }

    private String getRecordingLength()
    {
        if (recordingTimeInterval == null)
        {
            return null;
        } else
        {
            return String.valueOf(recordingTimeInterval.a());
        }
    }

    private double getRequestDurationMean()
    {
        Iterator iterator = requestSizedIntervalList.iterator();
        long l1;
        for (l1 = 0L; iterator.hasNext(); l1 = ((SizedTimeInterval)iterator.next()).timeInterval.a() + l1) { }
        return (double)l1 / (double)requestSizedIntervalList.size();
    }

    private String getSampleLength()
    {
        if (sampleLength == null)
        {
            return null;
        } else
        {
            return sampleLength.toString();
        }
    }

    private boolean locationIsValid()
    {
        return location != null && location.latitude != 0.0D && location.longitude != 0.0D;
    }

    public static TaggedBeacon newInstance(Factory factory, TaggedBeaconData taggedbeacondata, long l1)
    {
        TaggedBeacon taggedbeacon = new TaggedBeacon(factory, taggedbeacondata, l1);
        taggedbeacon.setInnerTaggedBeacon(new TaggedBeacon(factory, taggedbeacondata, l1));
        return taggedbeacon;
    }

    private l newTimeInterval()
    {
        return (l)timeIntervalFactory.create(null);
    }

    private void prepareParameters()
    {
        com.shazam.android.analytics.event.EventParameters.Builder builder = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters();
        builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.TIME, getUiTimeString()).putNotEmptyOrNullParameter(DefinedEventParameterKey.SAMPLE_LENGTH, getSampleLength()).putNotEmptyOrNullParameter(DefinedEventParameterKey.RECORD_TIME, getRecordingLength()).putNotEmptyOrNullParameter(DefinedEventParameterKey.NETWORK, networkTypeName).putNotEmptyOrNullParameter(DefinedEventParameterKey.ID, requestId).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, trackId).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, beaconKey).putNotEmptyOrNullParameter(DefinedEventParameterKey.CAMPAIGN, getCampaign()).putNotEmptyOrNullParameter(DefinedEventParameterKey.MATCH_CATEGORY, getCategory()).putNotEmptyOrNullParameter(DefinedEventParameterKey.REC_TYPE, getRecognitionType()).putNotEmptyOrNullParameter(DefinedEventParameterKey.TAG_RESULT_VERSION, getTagResultVersion());
        if (!latencyIntervalList.isEmpty())
        {
            builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.LATENCY, String.valueOf(getLatencyMean()));
        }
        if (!requestSizedIntervalList.isEmpty())
        {
            builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.REQUEST_TIME, String.valueOf(getRequestDurationMean())).putNotEmptyOrNullParameter(DefinedEventParameterKey.REQUEST_SIZE, String.valueOf(getRequestSizeMean()));
        }
        if (!responseSizedIntervalList.isEmpty())
        {
            builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.RESPONSE_TIME, String.valueOf(getResponseDurationMean())).putNotEmptyOrNullParameter(DefinedEventParameterKey.RESPONSE_SIZE, String.valueOf(getResponseSizeMean()));
        }
        if (unsubmitted)
        {
            builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.UNSUBMITTED, "true");
        }
        appendWatermarkParametersToParameterMap(builder, watermark);
        appendGimbalParametersToParameterMap(builder, gimbal);
        if (locationIsValid())
        {
            builder.putNotEmptyOrNullParameter(DefinedEventParameterKey.LOCATION, (new StringBuilder()).append(location.latitude).append(",").append(location.longitude).toString());
        }
        taggedBeaconData.addAdditionalTaggedBeaconParamsTo(builder);
        eventParametersBuilder = builder;
    }

    private void setInnerTaggedBeacon(TaggedBeacon taggedbeacon)
    {
        innerTaggedBeacon = taggedbeacon;
    }

    public void clearInnerTaggedBeacon()
    {
        innerTaggedBeacon = null;
    }

    public void endLatencyInterval()
    {
        if (currentLatencyInterval != null)
        {
            currentLatencyInterval.b(0L);
            latencyIntervalList.add(currentLatencyInterval);
        }
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.endLatencyInterval();
        }
    }

    public void endRecordingTime()
    {
        if (recordingTimeInterval != null)
        {
            recordingTimeInterval.b(0L);
        }
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.endRecordingTime();
        }
    }

    public void endRequestInterval(int i)
    {
        if (currentRequestSizedInterval != null)
        {
            currentRequestSizedInterval.timeInterval.b(0L);
            currentRequestSizedInterval.dataSize = i;
            requestSizedIntervalList.add(currentRequestSizedInterval);
        }
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.endRequestInterval(i);
        }
    }

    public void endResponseInterval(int i)
    {
        if (currentResponseSizedInterval != null)
        {
            currentResponseSizedInterval.timeInterval.b(0L);
            currentResponseSizedInterval.dataSize = i;
            responseSizedIntervalList.add(currentResponseSizedInterval);
        }
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.endResponseInterval(i);
        }
    }

    public String getBeaconKey()
    {
        return beaconKey;
    }

    public String getCampaign()
    {
        return campaign;
    }

    public String getCategory()
    {
        return category;
    }

    public long getEndTime()
    {
        return endTime;
    }

    public EventParameters getEventParameters()
    {
        prepareParameters();
        return eventParametersBuilder.build();
    }

    public EventParameters getInnerEventParameters()
    {
        return innerTaggedBeacon.getEventParameters();
    }

    public double getLatencyMean()
    {
        Iterator iterator = latencyIntervalList.iterator();
        long l1;
        for (l1 = 0L; iterator.hasNext(); l1 = ((l)iterator.next()).a() + l1) { }
        return (double)l1 / (double)latencyIntervalList.size();
    }

    public SimpleLocation getLocation()
    {
        return location;
    }

    public TaggingOutcome getOutcome()
    {
        return outcome;
    }

    public String getRecognitionType()
    {
        return recognitionType;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public double getRequestSizeMean()
    {
        Iterator iterator = requestSizedIntervalList.iterator();
        long l1;
        for (l1 = 0L; iterator.hasNext(); l1 = (long)((SizedTimeInterval)iterator.next()).dataSize + l1) { }
        return (double)l1 / (double)requestSizedIntervalList.size();
    }

    public double getResponseDurationMean()
    {
        Iterator iterator = responseSizedIntervalList.iterator();
        long l1;
        for (l1 = 0L; iterator.hasNext(); l1 = ((SizedTimeInterval)iterator.next()).timeInterval.a() + l1) { }
        return (double)l1 / (double)responseSizedIntervalList.size();
    }

    public double getResponseSizeMean()
    {
        Iterator iterator = responseSizedIntervalList.iterator();
        long l1;
        for (l1 = 0L; iterator.hasNext(); l1 = (long)((SizedTimeInterval)iterator.next()).dataSize + l1) { }
        return (double)l1 / (double)responseSizedIntervalList.size();
    }

    public long getStartTime()
    {
        return startTime;
    }

    public String getTagResultVersion()
    {
        return tagResultVersion;
    }

    public TaggedBeaconData getTaggedBeaconData()
    {
        return taggedBeaconData;
    }

    public String getTrackId()
    {
        return trackId;
    }

    public Long getUiTime()
    {
        if (uiTime == null)
        {
            return null;
        } else
        {
            return Long.valueOf(uiTime.a());
        }
    }

    public String getUiTimeString()
    {
        if (getUiTime() == null)
        {
            return null;
        } else
        {
            return String.valueOf(getUiTime());
        }
    }

    public Watermark getWatermark()
    {
        return watermark;
    }

    public boolean isFinishedInnerTaggedBeacon()
    {
        return finishedInnerTaggedBeacon;
    }

    public void markFinishedIntermediateTaggedBeacon()
    {
        finishedInnerTaggedBeacon = true;
    }

    public void setBeaconKey(String s)
    {
        beaconKey = s;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setBeaconKey(s);
        }
    }

    public void setCampaign(String s)
    {
        campaign = s;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setCampaign(s);
        }
    }

    public void setCategory(String s)
    {
        category = s;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setCategory(s);
        }
    }

    public void setEndTime(long l1)
    {
        endTime = l1;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setEndTime(l1);
        }
    }

    public void setGimbal(Gimbal gimbal1)
    {
        gimbal = gimbal1;
        if (innerTaggedBeacon != null)
        {
            innerTaggedBeacon.setGimbal(gimbal1);
        }
    }

    public void setLocation(SimpleLocation simplelocation)
    {
        location = simplelocation;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setLocation(simplelocation);
        }
    }

    public void setNetworkTypeName(String s)
    {
        networkTypeName = s;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setNetworkTypeName(s);
        }
    }

    public void setOutcome(TaggingOutcome taggingoutcome)
    {
        outcome = taggingoutcome;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setOutcome(taggingoutcome);
        }
    }

    public void setRecognitionType(String s)
    {
        recognitionType = s;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setRecognitionType(s);
        }
    }

    public void setRequestId(String s)
    {
        requestId = s;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setRequestId(s);
        }
    }

    public void setSampleLength(long l1)
    {
        sampleLength = Long.valueOf(l1);
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setSampleLength(l1);
        }
    }

    public void setTagResultVersion(String s)
    {
        tagResultVersion = s;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setTagResultVersion(s);
        }
    }

    public void setTrackId(String s)
    {
        trackId = s;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setTrackId(s);
        }
    }

    public void setUnsubmittedTag()
    {
        unsubmitted = true;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setUnsubmittedTag();
        }
    }

    public void setValuesForSubmission(String s, String s1)
    {
        setNetworkTypeName(s);
        setRecognitionType(s1);
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setNetworkTypeName(s);
            innerTaggedBeacon.setRecognitionType(s1);
        }
    }

    public void setWatermark(Watermark watermark1)
    {
        watermark = watermark1;
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.setWatermark(watermark1);
        }
    }

    public void startLatencyInterval()
    {
        currentLatencyInterval = newTimeInterval();
        currentLatencyInterval.a(0L);
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.startLatencyInterval();
        }
    }

    public void startRecordingTime()
    {
        recordingTimeInterval = newTimeInterval();
        recordingTimeInterval.a(0L);
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.startRecordingTime();
        }
    }

    public void startRequestInterval()
    {
        currentRequestSizedInterval = new SizedTimeInterval(newTimeInterval());
        currentRequestSizedInterval.timeInterval.a(0L);
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.startRequestInterval();
        }
    }

    public void startResponseInterval()
    {
        currentResponseSizedInterval = new SizedTimeInterval(newTimeInterval());
        currentResponseSizedInterval.timeInterval.a(0L);
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.startResponseInterval();
        }
    }

    public void startUiTime()
    {
        uiTime.a(0L);
        if (forwardToInnerTaggedBeacon())
        {
            innerTaggedBeacon.startUiTime();
        }
    }

    public void stopInnerUiTime()
    {
        if (innerTaggedBeacon != null)
        {
            innerTaggedBeacon.stopUiTime();
        }
    }

    public void stopUiTime()
    {
        uiTime.b(0L);
    }
}
