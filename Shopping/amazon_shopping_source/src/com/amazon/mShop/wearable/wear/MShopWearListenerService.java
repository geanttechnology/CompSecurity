// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import amazon.android.dexload.SupplementalDexLoader;
import android.os.AsyncTask;
import android.util.Log;
import com.amazon.device.crashmanager.CrashDetectionHelper;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.account.OneClickListener;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mShop.wearable.AbstractResultListener;
import com.amazon.mShop.wearable.ResultListener;
import com.amazon.mShop.wearable.SearchResultListener;
import com.amazon.mShop.wearable.WearableCrashDetails;
import com.amazon.mShop.wearable.WearableDeviceType;
import com.amazon.mShop.wearable.WearableService;
import com.amazon.mShop.wearable.WearableServiceImpl;
import com.amazon.mShop.wearable.model.MobileState;
import com.amazon.mShop.wearable.model.WearableSearchResult;
import com.amazon.mShop.wearable.wear.shared.StampedMessage;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItems;
import com.amazon.rio.j2me.client.services.mShop.GetOneClickBasicInfoRequest;
import com.amazon.rio.j2me.client.services.mShop.GetOneClickBasicInfoResponse;
import com.amazon.rio.j2me.client.services.mShop.GetOneClickBasicInfoResponseListener;
import com.amazon.rio.j2me.client.services.mShop.HomeRequest;
import com.amazon.rio.j2me.client.services.mShop.HomeResponseListener;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.LoginData;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            ImageFetcherThread

public class MShopWearListenerService extends WearableListenerService
{
    private abstract class ErrorListener extends AbstractResultListener
    {

        private final String mError;
        protected final String mMessageId;
        protected final String mNode;
        final MShopWearListenerService this$0;

        public final void onError(String s, Throwable throwable)
        {
            MShopWearListenerService.reply(mNode, mMessageId, "/error", s);
            if (mError != null)
            {
                mWearableService.incrementMetricCounter("VoiceSearch", mError, 1);
            }
        }

        public ErrorListener(String s, String s1)
        {
            this(s, s1, null);
        }

        public ErrorListener(String s, String s1, String s2)
        {
            this$0 = MShopWearListenerService.this;
            super();
            mNode = s;
            mError = s2;
            mMessageId = s1;
        }
    }

    private static interface MessageHandler
    {

        public abstract void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent);
    }

    private static class MyHomeResponseListener
        implements HomeResponseListener
    {

        public void cancelled(ServiceCall servicecall)
        {
        }

        public void completed(ServiceCall servicecall)
        {
            MShopWearListenerService.sendMobileState();
        }

        public void error(Exception exception, ServiceCall servicecall)
        {
            Log.e("WearListenerService", "Unable to query home info", exception);
        }

        public void receivedCartItems(CartItems cartitems, ServiceCall servicecall)
        {
        }

        public void receivedCompletedRemembersItemIds(List list, ServiceCall servicecall)
        {
        }

        public void receivedLoginData(LoginData logindata, ServiceCall servicecall)
        {
            logindata = logindata.getPrimeOneClickStatus();
            if (logindata != null)
            {
                MShopWearListenerService.sMobileState.oneClickEnabled = logindata.getIsOneClickEnabled();
                return;
            } else
            {
                MShopWearListenerService.sMobileState.oneClickEnabled = false;
                return;
            }
        }

        public void receivedNotification(Notification notification, ServiceCall servicecall)
        {
        }

        public void receivedPromoSlot0(PromoSlot promoslot, ServiceCall servicecall)
        {
        }

        public void receivedPromoSlot1(PromoSlot promoslot, ServiceCall servicecall)
        {
        }

        public void receivedShoveler0(HomeShoveler homeshoveler, ServiceCall servicecall)
        {
        }

        public void receivedShoveler1(HomeShoveler homeshoveler, ServiceCall servicecall)
        {
        }

        private MyHomeResponseListener()
        {
        }

    }

    private class MySpeechResultHandler
        implements SpeechResultHandler
    {

        private final String mMessageId;
        private final String mNode;
        final MShopWearListenerService this$0;

        private void asyncReply(final String path, String s)
        {
            (s. new AsyncTask() {

                final MySpeechResultHandler this$1;
                final String val$data;
                final String val$path;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    MShopWearListenerService.reply(mNode, mMessageId, path, data);
                    return null;
                }

            
            {
                this$1 = final_myspeechresulthandler;
                path = s;
                data = String.this;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        public void onError()
        {
            asyncReply("/error/asr", "Error during speech regocnition");
        }

        public void onSuccess(String s)
        {
            asyncReply("/speech/recognize/result", s);
        }



        MySpeechResultHandler(String s, String s1)
        {
            this$0 = MShopWearListenerService.this;
            super();
            mNode = s;
            mMessageId = s1;
        }
    }

    private static class OneClickBasicInfoResponseListener
        implements GetOneClickBasicInfoResponseListener
    {

        public void cancelled(ServiceCall servicecall)
        {
        }

        public void completed(GetOneClickBasicInfoResponse getoneclickbasicinforesponse, ServiceCall servicecall)
        {
            if (getoneclickbasicinforesponse != null)
            {
                MShopWearListenerService.sMobileState.oneClickCity = getoneclickbasicinforesponse.getCity();
                MShopWearListenerService.sMobileState.oneClickName = getoneclickbasicinforesponse.getFullName();
                MShopWearListenerService.sendMobileState();
            }
        }

        public void error(Exception exception, ServiceCall servicecall)
        {
            Log.e("WearListenerService", "Unable to query one click info", exception);
        }

        private OneClickBasicInfoResponseListener()
        {
        }

    }

    private static final class Requirement extends Enum
    {

        private static final Requirement $VALUES[];
        public static final Requirement AUTH;
        public static final Requirement ONE_CLICK_ENABLED;
        public static final Requirement US_LOCALE;

        public static Requirement valueOf(String s)
        {
            return (Requirement)Enum.valueOf(com/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement, s);
        }

        public static Requirement[] values()
        {
            return (Requirement[])$VALUES.clone();
        }

        static 
        {
            US_LOCALE = new Requirement("US_LOCALE", 0);
            AUTH = new Requirement("AUTH", 1);
            ONE_CLICK_ENABLED = new Requirement("ONE_CLICK_ENABLED", 2);
            $VALUES = (new Requirement[] {
                US_LOCALE, AUTH, ONE_CLICK_ENABLED
            });
        }

        private Requirement(String s, int i)
        {
            super(s, i);
        }
    }

    private class SimpleListener extends ErrorListener
    {

        private final String mPath;
        private final String mSuccess;
        final MShopWearListenerService this$0;

        public void onSuccess()
        {
            MShopWearListenerService.sendMessage(mNode, mMessageId, mPath, null);
            if (mSuccess != null)
            {
                mWearableService.incrementMetricCounter("VoiceSearch", mSuccess, 1);
            }
        }

        public SimpleListener(String s, String s1, String s2)
        {
            this(s, s1, s2, null, null);
        }

        public SimpleListener(String s, String s1, String s2, String s3, String s4)
        {
            this$0 = MShopWearListenerService.this;
            super(s, s1, s4);
            mPath = s2;
            mSuccess = s3;
        }
    }

    private abstract class SimpleResultListener extends ErrorListener
        implements SearchResultListener
    {

        final MShopWearListenerService this$0;

        public SimpleResultListener(String s, String s1)
        {
            this$0 = MShopWearListenerService.this;
            super(s, s1);
        }
    }

    public static interface SpeechResultHandler
    {

        public abstract void onError();

        public abstract void onSuccess(String s);
    }


    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final Map HANDLER_MAP;
    private static final ObjectMapper MAPPER;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static GoogleApiClient sGoogleApiClient = null;
    private static ImageFetcherThread sImageFetcherThread;
    private static MobileState sMobileState = new MobileState();
    private static OneClickListener sOneClickListener = new OneClickListener() {

        public void oneClickStatusChanged(boolean flag)
        {
            MShopWearListenerService.sMobileState.oneClickEnabled = flag;
            MShopWearListenerService.updateMobileState();
        }

    };
    private static UserListener sUserListener = new UserListener() {

        public void userSignedIn(User user)
        {
            MShopWearListenerService.updateMobileState();
        }

        public void userSignedOut()
        {
            MShopWearListenerService.updateMobileState();
        }

        public void userUpdated(User user)
        {
        }

    };
    private static String sWearableNode = null;
    private WearableService mWearableService;

    public MShopWearListenerService()
    {
    }

    private static StampedMessage fromMessageEvent(MessageEvent messageevent)
    {
        StampedMessage stampedmessage1 = new StampedMessage();
        StampedMessage stampedmessage = stampedmessage1;
        if (messageevent != null)
        {
            stampedmessage = stampedmessage1;
            if (messageevent.getData() != null)
            {
                try
                {
                    stampedmessage = (StampedMessage)MAPPER.readValue(messageevent.getData(), com/amazon/mShop/wearable/wear/shared/StampedMessage);
                }
                catch (IOException ioexception)
                {
                    Log.e("WearListenerService", (new StringBuilder()).append("Unable to parse incoming message: ").append(new String(messageevent.getData(), UTF_8)).toString());
                    return stampedmessage1;
                }
            }
        }
        return stampedmessage;
    }

    private final transient boolean meetsConditions(String s, String s1, Requirement arequirement[])
    {
        int i;
        int j;
        j = arequirement.length;
        i = 0;
_L6:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Requirement requirement = arequirement[i];
        static class _cls25
        {

            static final int $SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement[];

            static 
            {
                $SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement = new int[Requirement.values().length];
                try
                {
                    $SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement[Requirement.US_LOCALE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement[Requirement.ONE_CLICK_ENABLED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement[Requirement.AUTH.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls25..SwitchMap.com.amazon.mShop.wearable.wear.MShopWearListenerService.Requirement[requirement.ordinal()];
        JVM INSTR tableswitch 1 3: default 56
    //                   1 65
    //                   2 56
    //                   3 84;
           goto _L3 _L4 _L3 _L5
_L3:
        i++;
          goto _L6
_L4:
        if (LocaleUtils.isCurrentLocale("en_US")) goto _L3; else goto _L7
_L7:
        reply(s, s1, "/error/locale");
        return false;
_L5:
        if (SSOUtil.hasAmazonAccount()) goto _L3; else goto _L8
_L8:
        reply(s, s1, "/error/auth");
        return false;
_L2:
        return true;
    }

    private void onOpenAsin(MessageEvent messageevent)
    {
        String s = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        if (!meetsConditions(s, ((StampedMessage) (messageevent)).mId, new Requirement[] {
    Requirement.US_LOCALE
}))
        {
            return;
        } else
        {
            mWearableService.openProductPage(messageevent.dataAsString(), "offerId", "", ClickStreamTag.ORIGIN_WEARABLES_WEAR, new SimpleListener(s, ((StampedMessage) (messageevent)).mId, "/open/asin"));
            return;
        }
    }

    private void onOpenSearch(MessageEvent messageevent)
    {
        String s = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        if (!meetsConditions(s, ((StampedMessage) (messageevent)).mId, new Requirement[] {
    Requirement.US_LOCALE
}))
        {
            return;
        } else
        {
            mWearableService.openTextSearchResults(messageevent.dataAsString(), new SimpleListener(s, ((StampedMessage) (messageevent)).mId, "/search/text"));
            return;
        }
    }

    private void onRetailSearch(MessageEvent messageevent)
    {
        updateMobileState();
        final String final_s = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        if (!meetsConditions(final_s, ((StampedMessage) (messageevent)).mId, new Requirement[] {
    Requirement.US_LOCALE
}))
        {
            return;
        } else
        {
            ArrayList arraylist = new ArrayList();
            mWearableService.searchByText(messageevent.dataAsString(), new SimpleResultListener(((StampedMessage) (messageevent)).mId, arraylist) {

                final MShopWearListenerService this$0;
                final List val$results;

                public void onFoundProduct(WearableSearchResult wearablesearchresult)
                {
                    results.add(wearablesearchresult);
                }

                public void onSuccess()
                {
                    Object obj;
                    try
                    {
                        obj = MShopWearListenerService.MAPPER.createArrayNode();
                        ObjectWriter objectwriter = MShopWearListenerService.MAPPER.writerWithDefaultPrettyPrinter();
                        String s;
                        for (Iterator iterator = results.iterator(); iterator.hasNext(); ((ArrayNode) (obj)).add(MShopWearListenerService.MAPPER.readTree(s)))
                        {
                            s = objectwriter.writeValueAsString((WearableSearchResult)iterator.next());
                        }

                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        onError("Failed to serialize results to JSON", ((Throwable) (obj)));
                        return;
                    }
                    obj = MShopWearListenerService.MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
                    MShopWearListenerService.reply(mNode, mMessageId, "/search/text/result", ((String) (obj)));
                    return;
                }

            
            {
                this$0 = MShopWearListenerService.this;
                results = list;
                super(final_s, s1);
            }
            });
            return;
        }
    }

    private void onSpeechReconition(MessageEvent messageevent)
    {
        Object obj = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        if (!meetsConditions(((String) (obj)), ((StampedMessage) (messageevent)).mId, new Requirement[] {
    Requirement.US_LOCALE
}))
        {
            return;
        }
        SupplementalDexLoader.getInstance().waitForLoad();
        obj = new MySpeechResultHandler(((String) (obj)), ((StampedMessage) (messageevent)).mId);
        try
        {
            ((Runnable)(Runnable)SecondDexEntry.getInstance().getClassLoader().loadClass("com.amazon.mShop.wearable.wear.speech.SpeechRequestHandler").getDeclaredConstructors()[0].newInstance(new Object[] {
                this, ((StampedMessage) (messageevent)).mData, obj
            })).run();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MessageEvent messageevent)
        {
            Log.e("WearListenerService", "Failed to load speech recognition module", messageevent);
        }
        ((SpeechResultHandler) (obj)).onError();
    }

    private void onWishlistAsin(MessageEvent messageevent)
    {
        String s = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        if (!meetsConditions(s, ((StampedMessage) (messageevent)).mId, new Requirement[] {
    Requirement.US_LOCALE, Requirement.AUTH
}))
        {
            return;
        } else
        {
            mWearableService.addProductToWishList(messageevent.dataAsString(), new SimpleListener(s, ((StampedMessage) (messageevent)).mId, "/wishlist/asin", "WearAddtoWLCount", "WearAddtoWLError"));
            return;
        }
    }

    private void onWishlistText(MessageEvent messageevent)
    {
        String s = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        if (!meetsConditions(s, ((StampedMessage) (messageevent)).mId, new Requirement[] {
    Requirement.US_LOCALE, Requirement.AUTH
}))
        {
            return;
        } else
        {
            mWearableService.addTextToWishlist(messageevent.dataAsString(), new SimpleListener(s, ((StampedMessage) (messageevent)).mId, "/wishlist/text", "WearSaveTextIdeatoWLCount", "WearSaveTextIdeatoWLError"));
            return;
        }
    }

    private static void reply(String s, String s1, String s2)
    {
        sendMessage(s, s1, s2, null);
    }

    private static void reply(String s, String s1, String s2, String s3)
    {
        if (s3 == null)
        {
            reply(s, s1, s2, (byte[])null);
            return;
        } else
        {
            reply(s, s1, s2, s3.getBytes(UTF_8));
            return;
        }
    }

    private static void reply(String s, String s1, String s2, byte abyte0[])
    {
        sendMessage(s, s1, s2, abyte0);
    }

    private static void sendMessage(String s, String s1, String s2, byte abyte0[])
    {
        if (DEBUG)
        {
            Log.d("WearListenerService", String.format("Sending reply to wearable node %s on path %s", new Object[] {
                s, s2
            }));
        }
        if (!sGoogleApiClient.isConnected())
        {
            sGoogleApiClient.blockingConnect();
        }
        s1 = toBytes(new StampedMessage(s1, abyte0));
        if (s != null)
        {
            Wearable.MessageApi.sendMessage(sGoogleApiClient, s, s2, s1).await();
            return;
        } else
        {
            Wearable.NodeApi.getConnectedNodes(sGoogleApiClient).setResultCallback(new ResultCallback(s2, s1) {

                final String val$replyPath;
                final byte val$stampedData[];

                public volatile void onResult(Result result)
                {
                    onResult((com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult)result);
                }

                public void onResult(com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult getconnectednodesresult)
                {
                    Node node;
                    for (getconnectednodesresult = getconnectednodesresult.getNodes().iterator(); getconnectednodesresult.hasNext(); Wearable.MessageApi.sendMessage(MShopWearListenerService.sGoogleApiClient, node.getId(), replyPath, stampedData).await())
                    {
                        node = (Node)getconnectednodesresult.next();
                    }

                }

            
            {
                replyPath = s;
                stampedData = abyte0;
                super();
            }
            });
            return;
        }
    }

    private static void sendMobileState()
    {
        com/amazon/mShop/wearable/wear/MShopWearListenerService;
        JVM INSTR monitorenter ;
        long l;
        l = System.currentTimeMillis();
        if (l > sMobileState.updateTime)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        MobileState mobilestate = sMobileState;
        mobilestate.updateTime = mobilestate.updateTime + 1L;
_L1:
        byte abyte0[];
        String s = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(sMobileState);
        if (DEBUG)
        {
            Log.v("WearListenerService", s);
        }
        abyte0 = s.getBytes(UTF_8);
        (new AsyncTask(abyte0) {

            final byte val$responseJson[];

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                MShopWearListenerService.sendMessage(MShopWearListenerService.sWearableNode, null, "/query/mobileState", responseJson);
                return null;
            }

            
            {
                responseJson = abyte0;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        com/amazon/mShop/wearable/wear/MShopWearListenerService;
        JVM INSTR monitorexit ;
        return;
        sMobileState.updateTime = l;
          goto _L1
        Object obj;
        obj;
        throw new IllegalStateException(((Throwable) (obj)));
        obj;
        com/amazon/mShop/wearable/wear/MShopWearListenerService;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public static byte[] toBytes(StampedMessage stampedmessage)
    {
        try
        {
            stampedmessage = MAPPER.writeValueAsBytes(stampedmessage);
        }
        // Misplaced declaration of an exception variable
        catch (StampedMessage stampedmessage)
        {
            return null;
        }
        return stampedmessage;
    }

    private static void updateMobileState()
    {
        if (DEBUG)
        {
            Log.d("WearListenerService", "Update mobile state called");
        }
        sMobileState.supportedLocale = LocaleUtils.isCurrentLocale("en_US");
        sMobileState.networkAvailable = NetInfo.hasNetworkConnection();
        User user = User.getUser();
        if (user != null)
        {
            sMobileState.loggedIn = true;
            sMobileState.prime = user.isPrime();
        } else
        {
            sMobileState.oneClickEnabled = false;
            sMobileState.loggedIn = false;
            sMobileState.prime = false;
            sMobileState.oneClickCity = null;
            sMobileState.oneClickName = null;
        }
        sMobileState.weblabOneClickDisabled = Features.getInstance().isFeatureActivated("Android_Wear_OneClick_Buy");
        sMobileState.weblabWearableDeviceDisabled = Features.getInstance().isFeatureActivated("WearableDevicesDisabled");
        if (sMobileState.loggedIn)
        {
            try
            {
                ServiceController.getMShopService().home(new HomeRequest(), new MyHomeResponseListener());
            }
            catch (Exception exception)
            {
                Log.e("WearListenerService", "Error while trying to get one click basic info", exception);
            }
            try
            {
                ServiceController.getMShopService().getOneClickBasicInfo(new GetOneClickBasicInfoRequest(), new OneClickBasicInfoResponseListener());
            }
            catch (Exception exception1)
            {
                Log.e("WearListenerService", "Error while trying to get one click basic info", exception1);
            }
        }
        sendMobileState();
    }

    protected void onAddLatencyMetrics(MessageEvent messageevent)
    {
        messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        try
        {
            messageevent = MAPPER.readTree(((StampedMessage) (messageevent)).mData);
            String s = messageevent.path("source").asText();
            String s1 = messageevent.path("timerName").asText();
            double d = messageevent.path("timerValue").asDouble(0.0D);
            mWearableService.addTimer(s, s1, d);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MessageEvent messageevent)
        {
            Log.e("WearListenerService", "Unable to parse message from wearable device for latency metrics", messageevent);
        }
    }

    public void onCreate()
    {
        super.onCreate();
        if (DEBUG)
        {
            Log.d("WearListenerService", "Started MShop wear listener service");
        }
        mWearableService = new WearableServiceImpl(this, WearableDeviceType.AndroidWear);
        if (sGoogleApiClient == null)
        {
            sGoogleApiClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(getApplicationContext())).addApi(Wearable.API).build();
            sImageFetcherThread = new ImageFetcherThread(sGoogleApiClient);
            User.addUserListener(sUserListener);
        }
    }

    public void onDestroy()
    {
        if (DEBUG)
        {
            Log.d("WearListenerService", "Stopped MShop wear listener service");
        }
    }

    protected void onEmitClickStream(MessageEvent messageevent)
    {
        messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        try
        {
            messageevent = MAPPER.readTree(((StampedMessage) (messageevent)).mData);
            String s = messageevent.path("source").asText();
            String s1 = messageevent.path("pageType").asText();
            String s2 = messageevent.path("pageTypeId").asText();
            String s3 = messageevent.path("subPageType").asText();
            String s4 = messageevent.path("hitType").asText();
            String s5 = messageevent.path("pageAction").asText();
            String s6 = messageevent.path("counterName").asText();
            String s7 = messageevent.path("refTag").asText();
            int i = messageevent.path("count").asInt(0);
            mWearableService.emitClickStream(s, s1, s2, s3, s4, s5, s6, s7, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MessageEvent messageevent)
        {
            Log.e("WearListenerService", "Unable to parse message from wearable device for clickstream counter", messageevent);
        }
    }

    protected void onIncrementPMETCounter(MessageEvent messageevent)
    {
        messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        try
        {
            if (DEBUG)
            {
                Log.d("WearListenerService", (new StringBuilder()).append("Received PMET metric :data : ").append(messageevent.dataAsString()).toString());
            }
            messageevent = MAPPER.readTree(((StampedMessage) (messageevent)).mData);
            String s = messageevent.path("source").asText();
            String s1 = messageevent.path("counterName").asText();
            int i = messageevent.path("count").asInt(0);
            mWearableService.incrementMetricCounter(s, s1, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MessageEvent messageevent)
        {
            Log.e("WearListenerService", "Unable to parse message from wearable device for PMET counter", messageevent);
        }
    }

    protected void onLoadImage(MessageEvent messageevent)
    {
        StampedMessage stampedmessage = fromMessageEvent(messageevent);
        sImageFetcherThread.fetchImage(messageevent.getSourceNodeId(), stampedmessage.dataAsString());
    }

    protected void onLogRefmarker(MessageEvent messageevent)
    {
        messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        mWearableService.logRefMarker(messageevent.dataAsString());
    }

    public void onMessageReceived(MessageEvent messageevent)
    {
        String s = messageevent.getPath();
        if (DEBUG)
        {
            Log.d("WearListenerService", (new StringBuilder()).append("got message for path ").append(s).toString());
        }
        if (!HANDLER_MAP.containsKey(s))
        {
            Log.e("WearListenerService", String.format("Unknown message for path %s", new Object[] {
                s
            }));
            return;
        } else
        {
            (new AsyncTask() {

                final MShopWearListenerService this$0;
                final MessageHandler val$handler;
                final MessageEvent val$messageEvent;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    handler.onHandleMessage(MShopWearListenerService.this, messageEvent);
                    return null;
                }

            
            {
                this$0 = MShopWearListenerService.this;
                handler = messagehandler;
                messageEvent = messageevent;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

    protected void onOpenMShop(MessageEvent messageevent)
    {
        messageevent = fromMessageEvent(messageevent);
        mWearableService.openMShopHome(messageevent.dataAsString());
    }

    protected void onOpenSettingsLocale(MessageEvent messageevent)
    {
        String s = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        mWearableService.openLocaleSettings(new SimpleListener(s, ((StampedMessage) (messageevent)).mId, "/open/settings/locale"));
    }

    protected void onOpenSettingsLogin(MessageEvent messageevent)
    {
        String s = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        mWearableService.openLoginUi(new SimpleListener(s, ((StampedMessage) (messageevent)).mId, "/open/settings/login"));
    }

    protected void onOpenSettingsOneClick(MessageEvent messageevent)
    {
        String s = messageevent.getSourceNodeId();
        messageevent = fromMessageEvent(messageevent);
        mWearableService.openOneClickSettings(new SimpleListener(s, ((StampedMessage) (messageevent)).mId, "/open/settings/one_click"));
    }

    public void onPeerConnected(Node node)
    {
        if (DEBUG)
        {
            Log.d("WearListenerService", (new StringBuilder()).append("got peer connected ").append(node).toString());
        }
    }

    public void onPeerDisconnected(Node node)
    {
        if (DEBUG)
        {
            Log.d("WearListenerService", (new StringBuilder()).append("got peer disconnected ").append(node).toString());
        }
    }

    protected void onPurchaseAsin(MessageEvent messageevent)
    {
        String s = messageevent.getSourceNodeId();
        Object obj = fromMessageEvent(messageevent);
        if (!meetsConditions(s, ((StampedMessage) (obj)).mId, new Requirement[] {
    Requirement.US_LOCALE, Requirement.AUTH
}))
        {
            return;
        }
        messageevent = new SimpleListener(s, ((StampedMessage) (obj)).mId, "/buy/asin", "WearBuyCount", "WearBuyError");
        try
        {
            obj = MAPPER.readTree(((StampedMessage) (obj)).mData);
            String s1 = ((JsonNode) (obj)).path("asin").asText();
            obj = ((JsonNode) (obj)).path("offerId").asText();
            mWearableService.purchaseProduct(s1, ((String) (obj)), ClickStreamTag.ORIGIN_WEARABLES_WEAR, messageevent);
            return;
        }
        catch (IOException ioexception)
        {
            messageevent.onError("Unable to parse message from wearable device", ioexception);
        }
    }

    protected void onQueryMobileState(MessageEvent messageevent)
    {
        sWearableNode = messageevent.getSourceNodeId();
        updateMobileState();
    }

    protected void onReportWearCrash(MessageEvent messageevent)
    {
        try
        {
            messageevent = DataMap.fromByteArray(messageevent.getData());
            Throwable throwable = (Throwable)(new ObjectInputStream(new ByteArrayInputStream(messageevent.getByteArray("CrashExceptionKey")))).readObject();
            messageevent.remove("CrashExceptionKey");
            WearableCrashDetails.getInstance().setCrashDetails(messageevent);
            CrashDetectionHelper.getInstance().reportCrash(throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MessageEvent messageevent)
        {
            Log.e("WearListenerService", "onReportWearCrash", messageevent);
        }
    }

    static 
    {
        MAPPER = new ObjectMapper();
        MAPPER.setVisibilityChecker(MAPPER.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY).withGetterVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE).withSetterVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE).withCreatorVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE));
        HashMap hashmap = new HashMap();
        hashmap.put("/query/mobileState", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onQueryMobileState(messageevent);
            }

        });
        hashmap.put("/speech/recognize", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onSpeechReconition(messageevent);
            }

        });
        hashmap.put("/image", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onLoadImage(messageevent);
            }

        });
        hashmap.put("/search/text", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onRetailSearch(messageevent);
            }

        });
        hashmap.put("/open/asin", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onOpenAsin(messageevent);
            }

        });
        hashmap.put("/open/search", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onOpenSearch(messageevent);
            }

        });
        hashmap.put("/wishlist/asin", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onWishlistAsin(messageevent);
            }

        });
        hashmap.put("/wishlist/text", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onWishlistText(messageevent);
            }

        });
        hashmap.put("/buy/asin", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onPurchaseAsin(messageevent);
            }

        });
        hashmap.put("/open/settings/locale", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onOpenSettingsLocale(messageevent);
            }

        });
        hashmap.put("/open/settings/login", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onOpenSettingsLogin(messageevent);
            }

        });
        hashmap.put("/open/settings/one_click", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onOpenSettingsOneClick(messageevent);
            }

        });
        hashmap.put("/metric/pmet", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onIncrementPMETCounter(messageevent);
            }

        });
        hashmap.put("/metric/latency", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onAddLatencyMetrics(messageevent);
            }

        });
        hashmap.put("/metric/clickstream", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onEmitClickStream(messageevent);
            }

        });
        hashmap.put("/metric/refmarker", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onLogRefmarker(messageevent);
            }

        });
        hashmap.put("/openMShop", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onOpenMShop(messageevent);
            }

        });
        hashmap.put("/report/crash", new MessageHandler() {

            public void onHandleMessage(MShopWearListenerService mshopwearlistenerservice, MessageEvent messageevent)
            {
                mshopwearlistenerservice.onReportWearCrash(messageevent);
            }

        });
        HANDLER_MAP = Collections.unmodifiableMap(hashmap);
    }















}
