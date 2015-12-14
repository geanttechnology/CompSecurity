// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Point;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Strings;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            VastInLineXmlManager, VastLinearXmlManager, VastVideoConfig, VastWrapperXmlManager, 
//            VastErrorCode, VastXmlManager, VastBaseInLineWrapperXmlManager, VastExtensionParentXmlManager, 
//            VastExtensionXmlManager, VastAdXmlManager, VastCompanionAdXmlManager, VastCompanionAdConfig, 
//            VastResource, VastIconXmlManager, VastIconConfig, VastMediaXmlManager

public class VastXmlManagerAggregator extends AsyncTask
{
    static final class CompanionOrientation extends Enum
    {

        private static final CompanionOrientation $VALUES[];
        public static final CompanionOrientation LANDSCAPE;
        public static final CompanionOrientation PORTRAIT;

        public static CompanionOrientation valueOf(String s)
        {
            return (CompanionOrientation)Enum.valueOf(com/mopub/mobileads/VastXmlManagerAggregator$CompanionOrientation, s);
        }

        public static CompanionOrientation[] values()
        {
            return (CompanionOrientation[])$VALUES.clone();
        }

        static 
        {
            LANDSCAPE = new CompanionOrientation("LANDSCAPE", 0);
            PORTRAIT = new CompanionOrientation("PORTRAIT", 1);
            $VALUES = (new CompanionOrientation[] {
                LANDSCAPE, PORTRAIT
            });
        }

        private CompanionOrientation(String s, int i)
        {
            super(s, i);
        }
    }

    static interface VastXmlManagerAggregatorListener
    {

        public abstract void onAggregationComplete(VastVideoConfig vastvideoconfig);
    }


    private static final double AREA_WEIGHT = 30D;
    private static final double ASPECT_RATIO_WEIGHT = 70D;
    static final int MAX_TIMES_TO_FOLLOW_VAST_REDIRECT = 10;
    private static final int MINIMUM_COMPANION_AD_HEIGHT = 250;
    private static final int MINIMUM_COMPANION_AD_WIDTH = 300;
    private static final String MOPUB = "MoPub";
    private static final List VIDEO_MIME_TYPES = Arrays.asList(new String[] {
        "video/mp4", "video/3gpp"
    });
    private final Context mContext;
    private final int mScreenAreaDp;
    private final double mScreenAspectRatio;
    private int mTimesFollowedVastRedirect;
    private final WeakReference mVastXmlManagerAggregatorListener;

    VastXmlManagerAggregator(VastXmlManagerAggregatorListener vastxmlmanageraggregatorlistener, double d, int i, Context context)
    {
        Preconditions.checkNotNull(vastxmlmanageraggregatorlistener);
        Preconditions.checkNotNull(context);
        mVastXmlManagerAggregatorListener = new WeakReference(vastxmlmanageraggregatorlistener);
        mScreenAspectRatio = d;
        mScreenAreaDp = i;
        mContext = context.getApplicationContext();
    }

    private double calculateFitness(int i, int j)
    {
        double d = (double)i / (double)j / mScreenAspectRatio;
        double d1 = (double)(i * j) / (double)mScreenAreaDp;
        return 70D * Math.abs(Math.log(d)) + 30D * Math.abs(Math.log(d1));
    }

    private VastVideoConfig evaluateInLineXmlManager(VastInLineXmlManager vastinlinexmlmanager, List list)
    {
        Preconditions.checkNotNull(vastinlinexmlmanager);
        Preconditions.checkNotNull(list);
        for (Iterator iterator = vastinlinexmlmanager.getLinearXmlManagers().iterator(); iterator.hasNext();)
        {
            VastLinearXmlManager vastlinearxmlmanager = (VastLinearXmlManager)iterator.next();
            String s = getBestMediaFileUrl(vastlinearxmlmanager.getMediaXmlManagers());
            if (s != null)
            {
                VastVideoConfig vastvideoconfig = new VastVideoConfig();
                vastvideoconfig.addImpressionTrackers(vastinlinexmlmanager.getImpressionTrackers());
                populateLinearTrackersAndIcon(vastlinearxmlmanager, vastvideoconfig);
                vastvideoconfig.setClickThroughUrl(vastlinearxmlmanager.getClickThroughUrl());
                vastvideoconfig.setNetworkMediaFileUrl(s);
                vastvideoconfig.setVastCompanionAd(getBestCompanionAd(vastinlinexmlmanager.getCompanionAdXmlManagers(), CompanionOrientation.LANDSCAPE), getBestCompanionAd(vastinlinexmlmanager.getCompanionAdXmlManagers(), CompanionOrientation.PORTRAIT));
                list.addAll(vastinlinexmlmanager.getErrorTrackers());
                vastvideoconfig.addErrorTrackers(list);
                populateVideoViewabilityTracker(vastinlinexmlmanager, vastvideoconfig);
                return vastvideoconfig;
            }
        }

        return null;
    }

    private String evaluateWrapperRedirect(VastWrapperXmlManager vastwrapperxmlmanager, List list)
    {
        vastwrapperxmlmanager = vastwrapperxmlmanager.getVastAdTagURI();
        if (vastwrapperxmlmanager != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        vastwrapperxmlmanager = followVastRedirect(vastwrapperxmlmanager);
        return vastwrapperxmlmanager;
        vastwrapperxmlmanager;
        MoPubLog.d("Failed to follow VAST redirect", vastwrapperxmlmanager);
        if (!list.isEmpty())
        {
            TrackingRequest.makeVastTrackingHttpRequest(list, VastErrorCode.WRAPPER_TIMEOUT, null, null, mContext);
            return null;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private boolean fireErrorTrackerIfNoAds(List list, VastXmlManager vastxmlmanager, Context context)
    {
        if (list.isEmpty() && vastxmlmanager.getErrorTracker() != null)
        {
            vastxmlmanager = Collections.singletonList(vastxmlmanager.getErrorTracker());
            if (mTimesFollowedVastRedirect > 0)
            {
                list = VastErrorCode.NO_ADS_VAST_RESPONSE;
            } else
            {
                list = VastErrorCode.UNDEFINED_ERROR;
            }
            TrackingRequest.makeVastTrackingHttpRequest(vastxmlmanager, list, null, null, context);
            return true;
        } else
        {
            return false;
        }
    }

    private String followVastRedirect(String s)
        throws IOException
    {
        Preconditions.checkNotNull(s);
        if (mTimesFollowedVastRedirect >= 10) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj2;
        mTimesFollowedVastRedirect = mTimesFollowedVastRedirect + 1;
        obj = null;
        obj2 = null;
        s = MoPubHttpUrlConnection.getHttpUrlConnection(s);
        obj = s;
        Object obj1 = new BufferedInputStream(s.getInputStream());
        obj = Strings.fromStream(((java.io.InputStream) (obj1)));
        Streams.closeStream(((java.io.Closeable) (obj1)));
        if (s != null)
        {
            s.disconnect();
        }
        return ((String) (obj));
        obj1;
        s = ((String) (obj));
        obj = obj2;
_L4:
        Streams.closeStream(((java.io.Closeable) (obj)));
        if (s != null)
        {
            s.disconnect();
        }
        throw obj1;
_L2:
        return null;
        Exception exception;
        exception;
        obj = obj1;
        obj1 = exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean isValidSequenceNumber(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            int i;
            try
            {
                i = Integer.parseInt(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return true;
            }
            if (i >= 2)
            {
                return false;
            }
        }
        return true;
    }

    private void populateLinearTrackersAndIcon(VastLinearXmlManager vastlinearxmlmanager, VastVideoConfig vastvideoconfig)
    {
        Preconditions.checkNotNull(vastlinearxmlmanager, "linearXmlManager cannot be null");
        Preconditions.checkNotNull(vastvideoconfig, "vastVideoConfig cannot be null");
        vastvideoconfig.addAbsoluteTrackers(vastlinearxmlmanager.getAbsoluteProgressTrackers());
        vastvideoconfig.addFractionalTrackers(vastlinearxmlmanager.getFractionalProgressTrackers());
        vastvideoconfig.addPauseTrackers(vastlinearxmlmanager.getPauseTrackers());
        vastvideoconfig.addResumeTrackers(vastlinearxmlmanager.getResumeTrackers());
        vastvideoconfig.addCompleteTrackers(vastlinearxmlmanager.getVideoCompleteTrackers());
        vastvideoconfig.addCloseTrackers(vastlinearxmlmanager.getVideoCloseTrackers());
        vastvideoconfig.addSkipTrackers(vastlinearxmlmanager.getVideoSkipTrackers());
        vastvideoconfig.addClickTrackers(vastlinearxmlmanager.getClickTrackers());
        if (vastvideoconfig.getSkipOffsetString() == null)
        {
            vastvideoconfig.setSkipOffset(vastlinearxmlmanager.getSkipOffset());
        }
        if (vastvideoconfig.getVastIconConfig() == null)
        {
            vastvideoconfig.setVastIconConfig(getBestIcon(vastlinearxmlmanager.getIconXmlManagers()));
        }
    }

    private void populateMoPubCustomElements(VastXmlManager vastxmlmanager, VastVideoConfig vastvideoconfig)
    {
        Preconditions.checkNotNull(vastxmlmanager, "xmlManager cannot be null");
        Preconditions.checkNotNull(vastvideoconfig, "vastVideoConfig cannot be null");
        vastvideoconfig.addImpressionTrackers(vastxmlmanager.getMoPubImpressionTrackers());
        if (vastvideoconfig.getCustomCtaText() == null)
        {
            vastvideoconfig.setCustomCtaText(vastxmlmanager.getCustomCtaText());
        }
        if (vastvideoconfig.getCustomSkipText() == null)
        {
            vastvideoconfig.setCustomSkipText(vastxmlmanager.getCustomSkipText());
        }
        if (vastvideoconfig.getCustomCloseIconUrl() == null)
        {
            vastvideoconfig.setCustomCloseIconUrl(vastxmlmanager.getCustomCloseIconUrl());
        }
        if (!vastvideoconfig.isCustomForceOrientationSet())
        {
            vastvideoconfig.setCustomForceOrientation(vastxmlmanager.getCustomForceOrientation());
        }
    }

    private void populateVideoViewabilityTracker(VastBaseInLineWrapperXmlManager vastbaseinlinewrapperxmlmanager, VastVideoConfig vastvideoconfig)
    {
        Preconditions.checkNotNull(vastbaseinlinewrapperxmlmanager);
        Preconditions.checkNotNull(vastvideoconfig);
        if (vastvideoconfig.getVideoViewabilityTracker() == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        VastExtensionXmlManager vastextensionxmlmanager;
        if ((vastbaseinlinewrapperxmlmanager = vastbaseinlinewrapperxmlmanager.getVastExtensionParentXmlManager()) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        vastbaseinlinewrapperxmlmanager = vastbaseinlinewrapperxmlmanager.getVastExtensionXmlManagers().iterator();
        do
        {
            if (!vastbaseinlinewrapperxmlmanager.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            vastextensionxmlmanager = (VastExtensionXmlManager)vastbaseinlinewrapperxmlmanager.next();
        } while (!"MoPub".equals(vastextensionxmlmanager.getType()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        vastvideoconfig.setVideoViewabilityTracker(vastextensionxmlmanager.getVideoViewabilityTracker());
        return;
    }

    protected transient VastVideoConfig doInBackground(String as[])
    {
        if (as == null || as.length == 0 || as[0] == null)
        {
            return null;
        }
        try
        {
            as = evaluateVastXmlManager(as[0], new ArrayList());
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            MoPubLog.d("Unable to generate VastVideoConfig.", as);
            return null;
        }
        return as;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    VastVideoConfig evaluateVastXmlManager(String s, List list)
    {
        Preconditions.checkNotNull(s, "vastXml cannot be null");
        Preconditions.checkNotNull(list, "errorTrackers cannot be null");
        VastXmlManager vastxmlmanager = new VastXmlManager();
        try
        {
            vastxmlmanager.parseVastXml(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MoPubLog.d("Failed to parse VAST XML", s);
            TrackingRequest.makeVastTrackingHttpRequest(list, VastErrorCode.XML_PARSING_ERROR, null, null, mContext);
            return null;
        }
        s = vastxmlmanager.getAdXmlManagers();
        if (fireErrorTrackerIfNoAds(s, vastxmlmanager, mContext))
        {
            return null;
        }
        for (s = s.iterator(); s.hasNext();)
        {
            Object obj = (VastAdXmlManager)s.next();
            if (isValidSequenceNumber(((VastAdXmlManager) (obj)).getSequence()))
            {
                Object obj1 = ((VastAdXmlManager) (obj)).getInLineXmlManager();
                if (obj1 != null)
                {
                    obj1 = evaluateInLineXmlManager(((VastInLineXmlManager) (obj1)), list);
                    if (obj1 != null)
                    {
                        populateMoPubCustomElements(vastxmlmanager, ((VastVideoConfig) (obj1)));
                        return ((VastVideoConfig) (obj1));
                    }
                }
                obj = ((VastAdXmlManager) (obj)).getWrapperXmlManager();
                if (obj != null)
                {
                    Object obj2 = new ArrayList(list);
                    ((List) (obj2)).addAll(((VastWrapperXmlManager) (obj)).getErrorTrackers());
                    String s1 = evaluateWrapperRedirect(((VastWrapperXmlManager) (obj)), ((List) (obj2)));
                    if (s1 != null)
                    {
                        obj2 = evaluateVastXmlManager(s1, ((List) (obj2)));
                        if (obj2 != null)
                        {
                            ((VastVideoConfig) (obj2)).addImpressionTrackers(((VastWrapperXmlManager) (obj)).getImpressionTrackers());
                            for (s = ((VastWrapperXmlManager) (obj)).getLinearXmlManagers().iterator(); s.hasNext(); populateLinearTrackersAndIcon((VastLinearXmlManager)s.next(), ((VastVideoConfig) (obj2)))) { }
                            populateVideoViewabilityTracker(((VastBaseInLineWrapperXmlManager) (obj)), ((VastVideoConfig) (obj2)));
                            if (!((VastVideoConfig) (obj2)).hasCompanionAd())
                            {
                                ((VastVideoConfig) (obj2)).setVastCompanionAd(getBestCompanionAd(((VastWrapperXmlManager) (obj)).getCompanionAdXmlManagers(), CompanionOrientation.LANDSCAPE), getBestCompanionAd(((VastWrapperXmlManager) (obj)).getCompanionAdXmlManagers(), CompanionOrientation.PORTRAIT));
                            } else
                            {
                                s = ((VastVideoConfig) (obj2)).getVastCompanionAd(2);
                                list = ((VastVideoConfig) (obj2)).getVastCompanionAd(1);
                                if (s != null && list != null)
                                {
                                    obj = ((VastWrapperXmlManager) (obj)).getCompanionAdXmlManagers().iterator();
                                    while (((Iterator) (obj)).hasNext()) 
                                    {
                                        VastCompanionAdXmlManager vastcompanionadxmlmanager = (VastCompanionAdXmlManager)((Iterator) (obj)).next();
                                        if (!vastcompanionadxmlmanager.hasResources())
                                        {
                                            s.addClickTrackers(vastcompanionadxmlmanager.getClickTrackers());
                                            s.addCreativeViewTrackers(vastcompanionadxmlmanager.getCompanionCreativeViewTrackers());
                                            list.addClickTrackers(vastcompanionadxmlmanager.getClickTrackers());
                                            list.addCreativeViewTrackers(vastcompanionadxmlmanager.getCompanionCreativeViewTrackers());
                                        }
                                    }
                                }
                            }
                            populateMoPubCustomElements(vastxmlmanager, ((VastVideoConfig) (obj2)));
                            return ((VastVideoConfig) (obj2));
                        }
                    }
                }
            }
        }

        return null;
    }

    VastCompanionAdConfig getBestCompanionAd(List list, CompanionOrientation companionorientation)
    {
        Preconditions.checkNotNull(list, "managers cannot be null");
        Preconditions.checkNotNull(companionorientation, "orientation cannot be null");
        ArrayList arraylist = new ArrayList(list);
        double d1 = (1.0D / 0.0D);
        Object obj = null;
        list = null;
        Point point = null;
        VastResource.Type atype[] = VastResource.Type.values();
        int j = atype.length;
        int i = 0;
        do
        {
label0:
            {
                Object obj2 = list;
                Object obj1 = obj;
                Point point1 = point;
                if (i < j)
                {
                    VastResource.Type type = atype[i];
                    Iterator iterator = arraylist.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        obj2 = (VastCompanionAdXmlManager)iterator.next();
                        Integer integer = ((VastCompanionAdXmlManager) (obj2)).getWidth();
                        Integer integer1 = ((VastCompanionAdXmlManager) (obj2)).getHeight();
                        if (integer != null && integer.intValue() >= 300 && integer1 != null && integer1.intValue() >= 250)
                        {
                            point1 = getScaledDimensions(integer.intValue(), integer1.intValue());
                            obj1 = VastResource.fromVastResourceXmlManager(((VastCompanionAdXmlManager) (obj2)).getResourceXmlManager(), type, point1.x, point1.y);
                            if (obj1 != null)
                            {
                                double d;
                                if (CompanionOrientation.PORTRAIT == companionorientation)
                                {
                                    d = calculateFitness(integer1.intValue(), integer.intValue());
                                } else
                                {
                                    d = calculateFitness(integer.intValue(), integer1.intValue());
                                }
                                if (d < d1)
                                {
                                    obj = obj2;
                                    list = ((List) (obj1));
                                    point = point1;
                                    d1 = d;
                                }
                            }
                        }
                    } while (true);
                    if (obj == null)
                    {
                        break label0;
                    }
                    point1 = point;
                    obj1 = obj;
                    obj2 = list;
                }
                if (obj1 != null)
                {
                    return new VastCompanionAdConfig(point1.x, point1.y, ((VastResource) (obj2)), ((VastCompanionAdXmlManager) (obj1)).getClickThroughUrl(), ((VastCompanionAdXmlManager) (obj1)).getClickTrackers(), ((VastCompanionAdXmlManager) (obj1)).getCompanionCreativeViewTrackers());
                } else
                {
                    return null;
                }
            }
            i++;
        } while (true);
    }

    VastIconConfig getBestIcon(List list)
    {
        Preconditions.checkNotNull(list, "managers cannot be null");
        list = new ArrayList(list);
        VastResource.Type atype[] = VastResource.Type.values();
        int j = atype.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            VastResource.Type type = atype[i];
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                VastIconXmlManager vasticonxmlmanager = (VastIconXmlManager)iterator.next();
                Object obj = vasticonxmlmanager.getWidth();
                Integer integer = vasticonxmlmanager.getHeight();
                if (obj != null && ((Integer) (obj)).intValue() > 0 && ((Integer) (obj)).intValue() <= 300 && integer != null && integer.intValue() > 0 && integer.intValue() <= 300)
                {
                    obj = VastResource.fromVastResourceXmlManager(vasticonxmlmanager.getResourceXmlManager(), type, ((Integer) (obj)).intValue(), integer.intValue());
                    if (obj != null)
                    {
                        return new VastIconConfig(vasticonxmlmanager.getWidth().intValue(), vasticonxmlmanager.getHeight().intValue(), vasticonxmlmanager.getOffsetMS(), vasticonxmlmanager.getDurationMS(), ((VastResource) (obj)), vasticonxmlmanager.getClickTrackingUris(), vasticonxmlmanager.getClickThroughUri(), vasticonxmlmanager.getViewTrackingUris());
                    }
                }
            }

            i++;
        } while (true);
        return null;
    }

    String getBestMediaFileUrl(List list)
    {
        Preconditions.checkNotNull(list, "managers cannot be null");
        ArrayList arraylist = new ArrayList(list);
        double d = (1.0D / 0.0D);
        list = null;
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (VastMediaXmlManager)iterator.next();
            String s1 = ((VastMediaXmlManager) (obj)).getType();
            String s = ((VastMediaXmlManager) (obj)).getMediaUrl();
            if (!VIDEO_MIME_TYPES.contains(s1) || s == null)
            {
                iterator.remove();
            } else
            {
                Integer integer = ((VastMediaXmlManager) (obj)).getWidth();
                obj = ((VastMediaXmlManager) (obj)).getHeight();
                if (integer != null && integer.intValue() > 0 && obj != null && ((Integer) (obj)).intValue() > 0)
                {
                    double d1 = calculateFitness(integer.intValue(), ((Integer) (obj)).intValue());
                    if (d1 < d)
                    {
                        d = d1;
                        list = s;
                    }
                }
            }
        } while (true);
        return list;
    }

    Point getScaledDimensions(int i, int j)
    {
        Point point = new Point(i, j);
        Display display = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay();
        int l = display.getWidth();
        int i1 = display.getHeight();
        int k = Math.max(l, i1);
        l = Math.min(l, i1);
        i = Dips.dipsToIntPixels(i, mContext);
        j = Dips.dipsToIntPixels(j, mContext);
        if (i > k || j > l)
        {
            float f = (float)i / (float)k;
            float f1 = (float)j / (float)l;
            Point point1 = new Point();
            if (f >= f1)
            {
                point1.x = k - 16;
                point1.y = (int)((float)j / f) - 16;
            } else
            {
                point1.x = (int)((float)i / f1) - 16;
                point1.y = l - 16;
            }
            if (point1.x >= 0 && point1.y >= 0)
            {
                point1.x = Dips.pixelsToIntDips(point1.x, mContext);
                point1.y = Dips.pixelsToIntDips(point1.y, mContext);
                return point1;
            }
        }
        return point;
    }

    protected void onCancelled()
    {
        VastXmlManagerAggregatorListener vastxmlmanageraggregatorlistener = (VastXmlManagerAggregatorListener)mVastXmlManagerAggregatorListener.get();
        if (vastxmlmanageraggregatorlistener != null)
        {
            vastxmlmanageraggregatorlistener.onAggregationComplete(null);
        }
    }

    protected void onPostExecute(VastVideoConfig vastvideoconfig)
    {
        VastXmlManagerAggregatorListener vastxmlmanageraggregatorlistener = (VastXmlManagerAggregatorListener)mVastXmlManagerAggregatorListener.get();
        if (vastxmlmanageraggregatorlistener != null)
        {
            vastxmlmanageraggregatorlistener.onAggregationComplete(vastvideoconfig);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((VastVideoConfig)obj);
    }

    protected void onPreExecute()
    {
        Networking.getUserAgent(mContext);
    }

    void setTimesFollowedVastRedirect(int i)
    {
        mTimesFollowedVastRedirect = i;
    }

}
