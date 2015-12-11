// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import android.os.SystemClock;
import android.util.Log;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.net.ServiceCallIdentifier;
import com.amazon.mShop.platform.AndroidDataStore;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Feature;
import com.amazon.rio.j2me.client.services.mShop.FeatureStateRequest;
import com.amazon.rio.j2me.client.services.mShop.FeatureStateResponse;
import com.amazon.rio.j2me.client.services.mShop.FeatureStateResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.feature:
//            FeatureStateSubscriber

public class Features
{
    public static final class FeatureStateChangeType extends Enum
    {

        private static final FeatureStateChangeType $VALUES[];
        public static final FeatureStateChangeType CACHETIMESTAMP_CHANGE;
        public static final FeatureStateChangeType NO_CHANGE;
        public static final FeatureStateChangeType TREATMENT_CHANGE;

        public static FeatureStateChangeType valueOf(String s)
        {
            return (FeatureStateChangeType)Enum.valueOf(com/amazon/mShop/feature/Features$FeatureStateChangeType, s);
        }

        public static FeatureStateChangeType[] values()
        {
            return (FeatureStateChangeType[])$VALUES.clone();
        }

        static 
        {
            TREATMENT_CHANGE = new FeatureStateChangeType("TREATMENT_CHANGE", 0);
            CACHETIMESTAMP_CHANGE = new FeatureStateChangeType("CACHETIMESTAMP_CHANGE", 1);
            NO_CHANGE = new FeatureStateChangeType("NO_CHANGE", 2);
            $VALUES = (new FeatureStateChangeType[] {
                TREATMENT_CHANGE, CACHETIMESTAMP_CHANGE, NO_CHANGE
            });
        }

        private FeatureStateChangeType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static Features sInstance;
    private final Map mFeatureMap = new HashMap();
    private List mFeatureNames;
    private final List mFeatureStateSubscribers = new ArrayList(4);
    private long mLastUpdateTime;
    private final FeatureStateResponseListener mResponseListener = new FeatureStateResponseListener() {

        final Features this$0;

        public void cancelled(ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final _cls1 this$1;

                public void run()
                {
                    notifyCancel();
                }

            
            {
                this$1 = _cls1.this;
                super();
            }
            });
        }

        public void completed(FeatureStateResponse featurestateresponse, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(featurestateresponse. new Runnable() {

                final _cls1 this$1;
                final FeatureStateResponse val$response;

                public void run()
                {
                    List list = response.getFeatureStates();
                    Object obj = new ArrayList(mFeatureNames);
                    for (Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).remove(((Feature)iterator.next()).getFeatureName())) { }
                    Feature feature;
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); list.add(feature))
                    {
                        String s = (String)((Iterator) (obj)).next();
                        feature = new Feature();
                        feature.setFeatureName(s);
                        feature.setClientTreatmentPath("");
                        feature.setSendTrigger(Boolean.valueOf(false));
                        feature.setCacheStamp(null);
                    }

                    notifyFeatureStateReceived(list);
                }

            
            {
                this$1 = final__pcls1;
                response = FeatureStateResponse.this;
                super();
            }
            });
        }

        public void error(Exception exception, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(exception. new Runnable() {

                final _cls1 this$1;
                final Exception val$e;

                public void run()
                {
                    notifyError(e);
                }

            
            {
                this$1 = final__pcls1;
                e = Exception.this;
                super();
            }
            });
        }

            
            {
                this$0 = Features.this;
                super();
            }
    };
    private ServiceCall mServiceCall;
    private Timer mTimer;
    private final UserListener mUserListener = new UserListener() {

        final Features this$0;

        public void userSignedIn(User user)
        {
            sendFeatureStateRequest();
        }

        public void userSignedOut()
        {
            sendFeatureStateRequest();
        }

        public void userUpdated(User user)
        {
        }

            
            {
                this$0 = Features.this;
                super();
            }
    };

    private Features()
    {
        mLastUpdateTime = -1L;
        mFeatureNames = new ArrayList();
        mFeatureNames.add("Android_ShopAppOneClickSetting");
        mFeatureNames.add("Android_ShopAppSigninPrompt");
        mFeatureNames.add("Android_ShopAppAIV");
        mFeatureNames.add("SX_mShop_Android_Fast_Browse");
        mFeatureNames.add("Android_SocialConnectOOBE");
        mFeatureNames.add("Android_ShopAppFlow");
        mFeatureNames.add("Android_CN_Amazon_Ten_Years_Logo");
        mFeatureNames.add("Android_ShopAppHTMLGateway");
        mFeatureNames.add("Android_ShopAppSpinnerHardwareAcc");
        mFeatureNames.add("Android_HTMLNotificationsPage");
        mFeatureNames.add("Android_DexLoading");
        mFeatureNames.add("Android_Enable_Sns_CA");
        mFeatureNames.add("Android_UnknownSourcesGuide");
        mFeatureNames.add("Android_ShopAppHTMLRecommendations");
        mFeatureNames.add("Android_ShopAppHtmlGatewayHA");
        mFeatureNames.add("Android_UpgradeThruAppstore");
        mFeatureNames.add("Android_DataMatrix");
        mFeatureNames.add("SX_mShop_Android_Assets_Loading_Scheme");
        mFeatureNames.add("SX_mShop_Android_Dynamic_Display_Settings");
        mFeatureNames.add("SX_Shop_Android_Gallery_Messaging");
        mFeatureNames.add("Android_AmazonSmile");
        mFeatureNames.add("Android_Deals");
        mFeatureNames.add("SX_Shop_Android_Web_Client_GTE_5.1");
        mFeatureNames.add("SX_mShop_Android_Voice_Search_Nav");
        mFeatureNames.add("SX_mShop_Android_Voice_Search_Result_Nav");
        mFeatureNames.add("SX_mShop_Android_Voice_Search_Access");
        mFeatureNames.add("SX_mShop_Android_Voice_Search_Scan_Flow");
        mFeatureNames.add("SX_mShop_Android_Voice_Search_Barcode");
        mFeatureNames.add("SX_mShop_Android_Voice_Search_Shop_By_Department");
        mFeatureNames.add("Android_Wear_OneClick_Buy");
        mFeatureNames.add("WearableDevicesDisabled");
        mFeatureNames.add("AIVGROVERINTEGRATION_42456");
        User.addUserListener(mUserListener);
    }

    private static final Feature StringToFeature(String s)
    {
        Object obj = null;
        if (!Util.isEmpty(s))
        {
            String as[] = s.split(";");
            if (as.length >= 3)
            {
                Feature feature = new Feature();
                feature.setFeatureName(as[0]);
                feature.setClientTreatmentPath(as[1]);
                feature.setSendTrigger(Boolean.valueOf(Boolean.parseBoolean(as[2])));
                s = obj;
                if (as.length == 4)
                {
                    s = Integer.valueOf(Integer.parseInt(as[3]));
                }
                feature.setCacheStamp(s);
                return feature;
            }
        }
        return null;
    }

    private Feature buildFeature(String s)
    {
        Feature feature1 = (Feature)mFeatureMap.get(AndroidDataStore.wrapKeyWithLocale(s));
        Feature feature = feature1;
        if (feature1 == null)
        {
            Feature feature2 = StringToFeature(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString(s));
            feature = feature2;
            if (feature2 != null)
            {
                mFeatureMap.put(AndroidDataStore.wrapKeyWithLocale(s), feature2);
                feature = feature2;
            }
        }
        return feature;
    }

    private void clearTimer()
    {
        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer.purge();
            mTimer = null;
        }
    }

    public static final String featureToString(Feature feature)
    {
        if (feature != null)
        {
            StringBuilder stringbuilder = (new StringBuilder()).append(feature.getFeatureName()).append(";").append(feature.getClientTreatmentPath()).append(";").append(feature.getSendTrigger()).append(";");
            if (feature.getCacheStamp() == null)
            {
                feature = "";
            } else
            {
                feature = feature.getCacheStamp().toString();
            }
            return stringbuilder.append(feature).toString();
        } else
        {
            return null;
        }
    }

    public static Features getInstance()
    {
        com/amazon/mShop/feature/Features;
        JVM INSTR monitorenter ;
        Features features;
        if (sInstance == null)
        {
            sInstance = new Features();
        }
        features = sInstance;
        com/amazon/mShop/feature/Features;
        JVM INSTR monitorexit ;
        return features;
        Exception exception;
        exception;
        throw exception;
    }

    private void notifyCancel()
    {
        mServiceCall = null;
        for (Iterator iterator = (new ArrayList(mFeatureStateSubscribers)).iterator(); iterator.hasNext(); ((FeatureStateSubscriber)iterator.next()).onCancel()) { }
    }

    private void notifyError(Exception exception)
    {
        mServiceCall = null;
        for (Iterator iterator = (new ArrayList(mFeatureStateSubscribers)).iterator(); iterator.hasNext(); ((FeatureStateSubscriber)iterator.next()).onError(exception)) { }
        CallObserver.start(new ServiceCallIdentifier("mshop_android_features", (new StringBuilder()).append("Error_").append(exception.getMessage()).toString())).onComplete();
    }

    private void notifyFeatureStateReceived(List list)
    {
        if (DEBUG)
        {
            Log.d("Feature", "FeatureState Service Call completed");
        }
        mServiceCall = null;
        mLastUpdateTime = SystemClock.elapsedRealtime();
        if (!Util.isEmpty(list))
        {
            Feature feature;
            for (Iterator iterator = list.iterator(); iterator.hasNext(); saveFeature(feature.getFeatureName(), feature))
            {
                feature = (Feature)iterator.next();
            }

        }
        for (Iterator iterator1 = (new ArrayList(mFeatureStateSubscribers)).iterator(); iterator1.hasNext(); ((FeatureStateSubscriber)iterator1.next()).onFeatureStateReceived(list)) { }
        CallObserver.start(new ServiceCallIdentifier("mshop_android_features", "success")).onComplete();
    }

    private void saveFeature(String s, Feature feature)
    {
        if (feature != null)
        {
            String s1 = AndroidDataStore.wrapKeyWithLocale(s);
            mFeatureMap.put(s1, feature);
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString(s, featureToString(feature));
            if (DEBUG)
            {
                Log.d("Feature", (new StringBuilder()).append("put: ").append(s1).append("=").append(featureToString(feature)).toString());
                return;
            }
        }
    }

    private void scheduleFeatureStateCall(long l)
    {
        clearTimer();
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {

            final Features this$0;

            public void run()
            {
                sendFeatureStateRequest();
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls2 this$1;

                    public void run()
                    {
                        clearTimer();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            
            {
                this$0 = Features.this;
                super();
            }
        }, l);
    }

    private void scheduleSecondFeatureStateCall(long l)
    {
        scheduleFeatureStateCall(l);
    }

    private void sendFeatureStateRequest()
    {
        if (mServiceCall != null)
        {
            mServiceCall.cancel();
        }
        FeatureStateRequest featurestaterequest = new FeatureStateRequest();
        featurestaterequest.setCheckFeatures(new Vector(mFeatureNames));
        mServiceCall = ServiceController.getMShopService().featureState(featurestaterequest, mResponseListener);
        if (DEBUG)
        {
            Log.d("Feature", "send service call: featureState");
            String s;
            for (Iterator iterator = mFeatureNames.iterator(); iterator.hasNext(); Log.d("Feature", (new StringBuilder()).append("FeatureStateRequest: ").append(s).toString()))
            {
                s = (String)iterator.next();
            }

        }
    }

    private boolean shouldDelayFeatureStateCall()
    {
        return Util.isEmpty(CookieBridge.getCurrentSessionId());
    }

    private boolean shouldSendFeatureStateRequest()
    {
        while (mLastUpdateTime == -1L || SystemClock.elapsedRealtime() - mLastUpdateTime > 0x927c0L) 
        {
            return true;
        }
        return false;
    }

    public void addFeatureStateSubscriber(FeatureStateSubscriber featurestatesubscriber)
    {
        if (!mFeatureStateSubscribers.contains(featurestatesubscriber))
        {
            mFeatureStateSubscribers.add(featurestatesubscriber);
        }
    }

    public transient boolean areFeaturesCached(String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (buildFeature(as[i]) == null)
            {
                return false;
            }
        }

        return true;
    }

    public void fetchFeatureStates()
    {
        fetchFeatureStates(false);
    }

    public void fetchFeatureStates(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        sendFeatureStateRequest();
_L4:
        return;
_L2:
        if (mTimer != null || !shouldSendFeatureStateRequest())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!shouldDelayFeatureStateCall())
        {
            break; /* Loop/switch isn't completed */
        }
        scheduleFeatureStateCall(60000L);
        if (DEBUG)
        {
            Log.d("Feature", "** Delay Feature State Call because session id is empty");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        sendFeatureStateRequest();
        if (mLastUpdateTime == -1L)
        {
            scheduleSecondFeatureStateCall(60000L);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public Feature getFeature(String s)
    {
        s = buildFeature(s);
        if (s != null)
        {
            return s;
        } else
        {
            return null;
        }
    }

    public Integer getFeatureCacheStamp(String s)
    {
        s = buildFeature(s);
        if (s != null)
        {
            return s.getCacheStamp();
        } else
        {
            return null;
        }
    }

    public String getFeatureState(String s)
    {
        s = buildFeature(s);
        if (s != null)
        {
            return s.getClientTreatmentPath();
        } else
        {
            return null;
        }
    }

    public Map getFeaturesMap()
    {
        return mFeatureMap;
    }

    public boolean isAllowClientTrigger(String s)
    {
        s = buildFeature(s);
        if (s != null)
        {
            return s.getSendTrigger().booleanValue();
        } else
        {
            return false;
        }
    }

    public boolean isFeatureActivated(String s)
    {
        s = getFeatureState(s);
        return "T1".equals(s) || "T2".equals(s);
    }

    public void removeFeatureStateSubscriber(FeatureStateSubscriber featurestatesubscriber)
    {
        mFeatureStateSubscribers.remove(featurestatesubscriber);
    }

    public void resetStatus()
    {
        if (DEBUG)
        {
            Log.d("Feature", "resetStatus");
        }
        mLastUpdateTime = -1L;
        clearTimer();
        if (mServiceCall != null)
        {
            mServiceCall.cancel();
            mServiceCall = null;
        }
    }







}
