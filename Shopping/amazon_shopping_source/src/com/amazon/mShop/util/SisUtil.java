// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import com.amazon.device.ads.AmazonOOAdRegistration;
import com.amazon.device.ads.AmazonOOAdRegistrationListener;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.control.home.HomeSubscriber;
import com.amazon.mShop.control.sis.SisController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.KeyValuePair;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.util:
//            Util, AttributionUtils

public final class SisUtil
{

    private static HomeSubscriber sHomeSubscriber;
    private static final AmazonOOAdRegistrationListener sIdentifyUserListener = new AmazonOOAdRegistrationListener() {

        public void onRegistrationInfoReady(com.amazon.device.ads.AmazonOOAdRegistration.AmazonOOAdRegistrationInfo amazonooadregistrationinfo)
        {
            if (amazonooadregistrationinfo != null && amazonooadregistrationinfo.shouldIdentifyUser())
            {
                SisUtil.identifyUserSession(amazonooadregistrationinfo.getDeviceInfoParams(true));
            }
        }

    };
    private static final AmazonOOAdRegistrationListener sRegInfoListener = new AmazonOOAdRegistrationListener() {

        public void onRegistrationInfoReady(com.amazon.device.ads.AmazonOOAdRegistration.AmazonOOAdRegistrationInfo amazonooadregistrationinfo)
        {
            if (amazonooadregistrationinfo != null)
            {
                SisUtil.identifyUserSession(amazonooadregistrationinfo.getDeviceInfoParams(true));
            }
        }

    };
    private static UserListener sUserListener;

    public SisUtil()
    {
    }

    public static void identify()
    {
        identifyDeviceAppIfNeeded();
        identifyUserSessionIfNeeded();
    }

    public static void identifyDeviceAppIfNeeded()
    {
        Context context;
        String s;
        context = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
        s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("referrerSource");
        if (Util.isEmpty(s)) goto _L2; else goto _L1
_L1:
        AmazonOOAdRegistration.setReferrer(context, s);
_L4:
        AmazonOOAdRegistration.enableTLS(true);
        AmazonOOAdRegistration.registerApp(context);
        return;
_L2:
        String s1 = AttributionUtils.getAssociatesTag(context);
        if (!Util.isEmpty(s1))
        {
            AmazonOOAdRegistration.setReferrer(context, (new StringBuilder()).append("OEM-PRE-INSTALL: ").append(s1).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void identifyUserSession(Map map)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        Map map1 = AmazonOOAdRegistration.getDeviceNativeParams();
        if (map != null)
        {
            KeyValuePair keyvaluepair1;
            for (map = map.entrySet().iterator(); map.hasNext(); arraylist.add(keyvaluepair1))
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)map.next();
                keyvaluepair1 = new KeyValuePair();
                keyvaluepair1.setKey((String)entry1.getKey());
                keyvaluepair1.setValue((String)entry1.getValue());
            }

        }
        KeyValuePair keyvaluepair;
        for (map = map1.entrySet().iterator(); map.hasNext(); arraylist1.add(keyvaluepair))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            keyvaluepair = new KeyValuePair();
            keyvaluepair.setKey((String)entry.getKey());
            keyvaluepair.setValue((String)entry.getValue());
        }

        SisController.getInstance().startIdentifyUserSessionWithSis(arraylist, arraylist1);
        AmazonOOAdRegistration.updateLastIdentifyUserWithSISTime((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
    }

    public static void identifyUserSessionIfNeeded()
    {
        AmazonOOAdRegistration.prepareRegistrationInfo((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext(), sIdentifyUserListener);
    }

    public static void identifyUserWhenRegInfoReady()
    {
        AmazonOOAdRegistration.prepareRegistrationInfo((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext(), sRegInfoListener);
    }

    public static void reset(Context context)
    {
        com/amazon/mShop/util/SisUtil;
        JVM INSTR monitorenter ;
        SisController.clearInstance();
        HomeController.getInstance().removeSubscriber(sHomeSubscriber);
        User.removeUserListener(sUserListener);
        sHomeSubscriber = null;
        sUserListener = null;
        sHomeSubscriber = new HomeSubscriber() {

            public void onAvailableCountReceived(int i)
            {
            }

            public void onCancelled()
            {
            }

            public void onError(Exception exception, ServiceCall servicecall)
            {
            }

            public void onHomeCallStarted()
            {
            }

            public void onHomeShoveler0Received(HomeShoveler homeshoveler)
            {
            }

            public void onHomeShoveler1Received(HomeShoveler homeshoveler)
            {
            }

            public void onNotificationReceived(Notification notification)
            {
            }

            public void onObjectReceived(Object obj, int i)
            {
            }

            public void onObjectsReceived()
            {
            }

            public void onPageComplete()
            {
                SisUtil.identify();
            }

            public void onPromoSlot0Received(PromoSlot promoslot)
            {
            }

            public void onPromoSlot1Received(PromoSlot promoslot)
            {
            }

            public void preHomeCallStarted()
            {
            }

        };
        HomeController.getInstance().addSubscriber(sHomeSubscriber);
        sUserListener = new UserListener() {

            public void userSignedIn(User user)
            {
                SisUtil.identifyUserWhenRegInfoReady();
            }

            public void userSignedOut()
            {
            }

            public void userUpdated(User user)
            {
            }

        };
        User.addUserListener(sUserListener);
        com/amazon/mShop/util/SisUtil;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

}
