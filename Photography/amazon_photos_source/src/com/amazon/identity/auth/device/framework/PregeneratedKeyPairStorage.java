// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.IntentHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.setting.PlatformSettings;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ServiceWrappingContext

public class PregeneratedKeyPairStorage
{
    public static final class SelfGeneratedKeyPair
    {

        private final String mAlgo;
        private final String mEncodedPrivateKey;
        private final String mEncodedPublicKey;
        private final String mFormat;

        public String getAlgo()
        {
            return mAlgo;
        }

        public String getEncodedPrivateKey()
        {
            return mEncodedPrivateKey;
        }

        public String getEncodedPublicKey()
        {
            return mEncodedPublicKey;
        }

        public String getFormat()
        {
            return mFormat;
        }

        public SelfGeneratedKeyPair(String s, String s1, String s2, String s3)
        {
            mAlgo = s;
            mEncodedPublicKey = s1;
            mEncodedPrivateKey = s2;
            mFormat = s3;
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage.getName();
    private static PregeneratedKeyPairStorage sPregeneratedKeyPairStorage;
    private final Context mContext;

    PregeneratedKeyPairStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
    }

    public static PregeneratedKeyPairStorage getInstance(Context context)
    {
        com/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;
        JVM INSTR monitorenter ;
        if (sPregeneratedKeyPairStorage == null)
        {
            sPregeneratedKeyPairStorage = new PregeneratedKeyPairStorage(context);
        }
        context = sPregeneratedKeyPairStorage;
        com/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public SelfGeneratedKeyPair retrieveSelfGeneratedKeyPair()
    {
        this;
        JVM INSTR monitorenter ;
        if (!TextUtils.isEmpty(PlatformSettings.getInstance(mContext).getSettingString("KeyPairGenerationService_Self_Generated_Key_Pair_Algo", null))) goto _L2; else goto _L1
_L1:
        Object obj = TAG;
        Object obj1 = null;
_L8:
        this;
        JVM INSTR monitorexit ;
        return ((SelfGeneratedKeyPair) (obj1));
_L2:
        Object obj2;
        String s;
        String s1;
        obj1 = mContext.getSharedPreferences("com.amazon.dcp.sso.KeyPairGenerationService.SHARED_PREFS", 0);
        obj = ((SharedPreferences) (obj1)).getString("algo", null);
        obj2 = ((SharedPreferences) (obj1)).getString("encoded_pub_key", null);
        s = ((SharedPreferences) (obj1)).getString("encoded_priv_key", null);
        s1 = ((SharedPreferences) (obj1)).getString("format", null);
        if (obj == null || obj2 == null || s == null || s1 == null) goto _L4; else goto _L3
_L3:
        obj = new SelfGeneratedKeyPair(((String) (obj)), ((String) (obj2)), s, s1);
_L6:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        MAPLog.i(TAG, "KeyPairGenerationService found a key pair In cache when retrieveSelfGeneratedKeyPair.");
        obj1 = ((SharedPreferences) (obj1)).edit();
        ((android.content.SharedPreferences.Editor) (obj1)).clear();
        if (!((android.content.SharedPreferences.Editor) (obj1)).commit())
        {
            MAPLog.e(TAG, "Unable to clear self generated key pair cache.");
        }
        obj2 = IntentHelpers.getBestIntentForService$49025054(mContext, "com.amazon.dcp.sso.KeyPairGenerationService");
        obj1 = obj;
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        mContext.startService(((android.content.Intent) (obj2)));
        obj1 = obj;
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
_L4:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
        MAPLog.i(TAG, "KeyPairGenerationService found no key pair in cache when retrieveSelfGeneratedKeyPair.");
        obj1 = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

}
