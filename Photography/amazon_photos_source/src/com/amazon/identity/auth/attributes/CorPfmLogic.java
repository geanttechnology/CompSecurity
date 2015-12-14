// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.MultipleAccountPlugin;
import com.amazon.identity.auth.accounts.MultipleAccountPluginHolder;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.AccountTransaction;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.SSOBroadcastIntentFactory;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CorPfmInfo, CORPFMResponse, CorPfmFetcher

public class CorPfmLogic
{
    private static class CorPfmFetcherTask
    {

        final CountDownLatch mLatch;
        CORPFMResponse mResponse;

        private CorPfmFetcherTask()
        {
            mLatch = new CountDownLatch(1);
        }

        CorPfmFetcherTask(byte byte0)
        {
            this();
        }
    }


    private static final String TAG = com/amazon/identity/auth/attributes/CorPfmLogic.getName();
    private static CorPfmLogic sTheOneAndTheOnly;
    private final ServiceWrappingContext mContext;
    private final CorPfmInfo mCorPfmInfo;
    private final DataStorage mDataStorage;
    private final Map mOutstandingTasks = new HashMap();

    CorPfmLogic(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mDataStorage = mContext.getDataStorage();
        mCorPfmInfo = new CorPfmInfo(mContext);
    }

    private CORPFMResponse getCurrentAccountCorPfm(String s)
    {
        return new CORPFMResponse(mDataStorage.getUserData(s, "com.amazon.dcp.sso.property.account.cor"), mDataStorage.getUserData(s, "com.amazon.dcp.sso.property.account.pfm"), CORPFMResponse.ComputationConfidenceValue.CUSTOMER_PROVIDED);
    }

    public static CorPfmLogic getInstance(Context context)
    {
        com/amazon/identity/auth/attributes/CorPfmLogic;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new CorPfmLogic(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/attributes/CorPfmLogic;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static boolean isValidCorPfmFromDCAS(String s, String s1, String s2)
    {
        return s != null && !TextUtils.isEmpty(s1) && s2 != null;
    }

    public static void notifyChange(String s, MultipleAccountPlugin multipleaccountplugin)
    {
        Object obj = TAG;
        obj = SSOBroadcastIntentFactory.createIntent("com.amazon.dcp.sso.broadcast.CORPFMHasChanged");
        ((Intent) (obj)).putExtra("new.account.property.changed", s);
        multipleaccountplugin.sendBroadcast(s, ((Intent) (obj)), "com.amazon.dcp.sso.permission.MANAGE_COR_PFM");
    }

    private String readSecureSettings(String s)
    {
        String s1;
        try
        {
            s1 = android.provider.Settings.Secure.getString(mContext.getContentResolver(), s);
        }
        catch (Exception exception)
        {
            MAPLog.w(TAG, (new StringBuilder("Error calling Secure Settings for resource ")).append(s).toString(), exception);
            return null;
        }
        return s1;
    }

    private boolean saveCorPfmResponse(String s, CORPFMResponse corpfmresponse, Map map)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        String s2 = TAG;
        String s3 = corpfmresponse.getCOR();
        String s4 = corpfmresponse.getPFM();
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$identity$auth$attributes$CORPFMResponse$ComputationConfidenceValue[];

            static 
            {
                $SwitchMap$com$amazon$identity$auth$attributes$CORPFMResponse$ComputationConfidenceValue = new int[CORPFMResponse.ComputationConfidenceValue.values().length];
                try
                {
                    $SwitchMap$com$amazon$identity$auth$attributes$CORPFMResponse$ComputationConfidenceValue[CORPFMResponse.ComputationConfidenceValue.CUSTOMER_PROVIDED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$attributes$CORPFMResponse$ComputationConfidenceValue[CORPFMResponse.ComputationConfidenceValue.CUSTOMER_BASED_GUESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$attributes$CORPFMResponse$ComputationConfidenceValue[CORPFMResponse.ComputationConfidenceValue.DEVICE_BASED_GUESS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        String s1;
        if (corpfmresponse.getComputationConfidenceValue() != null)
        {
            s1 = corpfmresponse.getComputationConfidenceValue().toString();
        } else
        {
            s1 = null;
        }
        MAPLog.i(s2, String.format("Trying to save COR/PFM response : \nCoR: %s \nPFM:%s \n Computation Confidence Value: %s", new Object[] {
            s3, s4, s1
        }));
        _cls1..SwitchMap.com.amazon.identity.auth.attributes.CORPFMResponse.ComputationConfidenceValue[corpfmresponse.getComputationConfidenceValue().ordinal()];
        JVM INSTR tableswitch 1 3: default 104
    //                   1 137
    //                   2 237
    //                   3 243;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException(String.format("Cor Pfm value type %s is not supported", new Object[] {
            corpfmresponse.getComputationConfidenceValue().name()
        }));
_L2:
        MAPLog.i(TAG, "Saving user backed COR/PFM");
        if (s == null) goto _L6; else goto _L5
_L5:
        if (mDataStorage.doesAccountExist(s)) goto _L8; else goto _L7
_L7:
        MAPLog.w(TAG, "Could not save COR/PFM values because the given account does not exist");
_L10:
        map.put("is_cor_pfm_set", "true");
        return flag;
_L8:
        if (corpfmresponse.equals(getCurrentAccountCorPfm(s)))
        {
            MAPLog.i(TAG, "User COR PFM has not changed.");
            continue; /* Loop/switch isn't completed */
        }
_L6:
        map.put("com.amazon.dcp.sso.property.account.cor", corpfmresponse.getCOR());
        map.put("com.amazon.dcp.sso.property.account.pfm", corpfmresponse.getPFM());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L4:
        MAPLog.i(TAG, "Saving device defaults COR/PFM");
        s = mCorPfmInfo.getCorPfmDeviceDefaults();
        mCorPfmInfo.setDeviceDefaultCorPfm(corpfmresponse);
        if (corpfmresponse.equals(s))
        {
            MAPLog.i(TAG, "Default COR/PFM has not changed.");
            flag = flag1;
        } else
        {
            flag = true;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public CORPFMResponse fetchCorPfm(String s, Tracer tracer)
    {
        Object obj1 = mOutstandingTasks;
        obj1;
        JVM INSTR monitorenter ;
        obj = (CorPfmFetcherTask)mOutstandingTasks.get(s);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new CorPfmFetcherTask((byte)0);
        mOutstandingTasks.put(s, obj);
        boolean flag = true;
_L10:
        obj1;
        JVM INSTR monitorexit ;
        obj1 = null;
        if (!flag) goto _L4; else goto _L3
_L3:
        Object obj2 = TAG;
        tracer = (new CorPfmFetcher(mContext, s, tracer)).fetch();
        if (tracer == null) goto _L6; else goto _L5
_L5:
        obj1 = tracer;
        obj2 = new LinkedHashMap();
        obj1 = tracer;
        boolean flag1 = saveCorPfmResponse(s, tracer, ((Map) (obj2)));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        obj1 = tracer;
        mDataStorage.setData(new AccountTransaction(s, ((Map) (obj2)), null));
        if (!flag1) goto _L8; else goto _L7
_L7:
        obj1 = tracer;
        MAPLog.i(TAG, "COR/PFM value has changed. Sending notifications.");
        obj1 = tracer;
        notifyChange(s, MultipleAccountPluginHolder.getMultipleAccountPlugin(mContext));
_L6:
        obj.mResponse = tracer;
        ((CorPfmFetcherTask) (obj)).mLatch.countDown();
        synchronized (mOutstandingTasks)
        {
            mOutstandingTasks.remove(s);
        }
        return tracer;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L8:
        obj1 = tracer;
        MAPLog.i(TAG, "COR/PFM values are not different. Not firing the changed broadcast");
          goto _L6
        tracer;
        obj.mResponse = ((CORPFMResponse) (obj1));
        ((CorPfmFetcherTask) (obj)).mLatch.countDown();
        synchronized (mOutstandingTasks)
        {
            mOutstandingTasks.remove(s);
        }
        throw tracer;
_L4:
        s = TAG;
        if (((CorPfmFetcherTask) (obj)).mLatch.await(5L, TimeUnit.SECONDS))
        {
            return ((CorPfmFetcherTask) (obj)).mResponse;
        }
        MAPLog.e(TAG, "Timed out waiting for cor/pfm response");
        return null;
        s;
        MAPLog.e(TAG, "Interrupted waiting for cor/pfm response", s);
        return null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public CORPFMResponse fetchCorPfmIfNotSet(String s, Tracer tracer)
    {
        Object obj1 = null;
        boolean flag = true;
        Object obj;
        if (s == null || !mDataStorage.doesAccountExist(s))
        {
            obj = TAG;
            MAPLog.i(TAG, "getting Cor/Pfm from Secure Settings");
            obj = readSecureSettings("DEFAULT_COR");
            String s2 = readSecureSettings("DEFAULT_PFM");
            if (!TextUtils.isEmpty(((CharSequence) (obj))) && !TextUtils.isEmpty(s2))
            {
                MAPLog.i(TAG, String.format("Returning Cor/Pfm from Secure Settings. Cor: %s, Pfm: %s", new Object[] {
                    obj, s2
                }));
                obj = new CORPFMResponse(((String) (obj)), s2, CORPFMResponse.ComputationConfidenceValue.CUSTOMER_PROVIDED);
            } else
            {
                obj = null;
            }
            if (obj == null)
            {
                obj = obj1;
                if (mCorPfmInfo.hasSetDeviceDefaultsForCorPfm())
                {
                    obj = mCorPfmInfo.getCorPfmDeviceDefaults();
                }
            }
        } else
        {
            if (mDataStorage.getUserData(s, "is_cor_pfm_set") == null)
            {
                flag = false;
            }
            obj = obj1;
            if (flag)
            {
                obj = getCurrentAccountCorPfm(s);
            }
        }
        if (obj != null)
        {
            s = TAG;
            return ((CORPFMResponse) (obj));
        } else
        {
            String s1 = TAG;
            return fetchCorPfm(s, tracer);
        }
    }

    public void setInitialCORPFM(CORPFMResponse corpfmresponse, Map map)
    {
        if (corpfmresponse == null)
        {
            MAPLog.w(TAG, "Cor/PFM response given to set is null. Not setting.");
            return;
        } else
        {
            saveCorPfmResponse(null, corpfmresponse, map);
            return;
        }
    }

}
