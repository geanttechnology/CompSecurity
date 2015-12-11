// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.utils.IntentHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.security.KeyPair;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ServiceWrappingContext, KeyPairGenHelper

public class PregeneratedKeyPairStorage
{
    public static final class SelfGeneratedKeyPair
    {

        public static final String ALGO = "algo";
        public static final String ENCODED_PRIV_KEY = "encoded_priv_key";
        public static final String ENCODED_PUB_KEY = "encoded_pub_key";
        public static final String FORMAT = "format";
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


    static final String AMZN_SELF_KEY_FORMAT = "B64/X.509";
    static final String KEY_PAIR_GENERATION_SERVICE_NAME = "com.amazon.dcp.sso.KeyPairGenerationService";
    static final String SELF_GENERATED_KEY_PAIR_ALGO_SETTING_NAME = "KeyPairGenerationService_Self_Generated_Key_Pair_Algo";
    static final String SELF_GENERATED_KEY_PAIR_CACHE_NAME = "com.amazon.dcp.sso.KeyPairGenerationService.SHARED_PREFS";
    private static final String TAG = com/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage.getName();
    private static PregeneratedKeyPairStorage sPregeneratedKeyPairStorage;
    private final Context mContext;

    PregeneratedKeyPairStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
    }

    private void generateKeyPairAndPutToCache(SharedPreferences sharedpreferences, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (getKeyPairFromCache(sharedpreferences) != null) goto _L2; else goto _L1
_L1:
        MAPLog.i(TAG, (new StringBuilder("KeyPairGenerationService found not key pair in cache and tried to generate one with algoritm:")).append(s).toString());
        if (!s.equalsIgnoreCase("RSA")) goto _L4; else goto _L3
_L3:
        SelfGeneratedKeyPair selfgeneratedkeypair = generateKeyPairRSA();
_L8:
        if (selfgeneratedkeypair == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        MAPLog.i(TAG, (new StringBuilder("KeyPairGenerationService successfully generated a key pair with algoritm:")).append(s).toString());
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putString("algo", selfgeneratedkeypair.getAlgo());
        sharedpreferences.putString("encoded_pub_key", selfgeneratedkeypair.getEncodedPublicKey());
        sharedpreferences.putString("encoded_priv_key", selfgeneratedkeypair.getEncodedPrivateKey());
        sharedpreferences.putString("format", selfgeneratedkeypair.getFormat());
        if (!sharedpreferences.commit())
        {
            MAPLog.e(TAG, "Unable to save self generated key pair to cache.");
        }
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (s.equalsIgnoreCase("EC"))
        {
            selfgeneratedkeypair = generateKeyPairEC();
            continue; /* Loop/switch isn't completed */
        }
        MAPLog.e(TAG, (new StringBuilder("Unsupported algorithm: ")).append(s).toString());
        selfgeneratedkeypair = null;
        continue; /* Loop/switch isn't completed */
_L2:
        MAPLog.i(TAG, "KeyPairGenerationService found a key pair in cache. No need to generate one.");
        if (true) goto _L6; else goto _L5
_L5:
        sharedpreferences;
        throw sharedpreferences;
        if (true) goto _L8; else goto _L7
_L7:
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

    private SelfGeneratedKeyPair getKeyPairFromCache(SharedPreferences sharedpreferences)
    {
        Object obj = null;
        String s = sharedpreferences.getString("algo", null);
        String s1 = sharedpreferences.getString("encoded_pub_key", null);
        String s2 = sharedpreferences.getString("encoded_priv_key", null);
        String s3 = sharedpreferences.getString("format", null);
        sharedpreferences = obj;
        if (s != null)
        {
            sharedpreferences = obj;
            if (s1 != null)
            {
                sharedpreferences = obj;
                if (s2 != null)
                {
                    sharedpreferences = obj;
                    if (s3 != null)
                    {
                        sharedpreferences = new SelfGeneratedKeyPair(s, s1, s2, s3);
                    }
                }
            }
        }
        return sharedpreferences;
    }

    public void generateKeyPair()
    {
        this;
        JVM INSTR monitorenter ;
        String s = PlatformSettings.getInstance(mContext).getSettingString("KeyPairGenerationService_Self_Generated_Key_Pair_Algo", null);
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        MAPLog.i(TAG, "KeyPairGenerationService_Self_Generated_Key_Pair_Algo was null or empty when start KeyPairGenerationService.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        generateKeyPairAndPutToCache(mContext.getSharedPreferences("com.amazon.dcp.sso.KeyPairGenerationService.SHARED_PREFS", 0), s);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected SelfGeneratedKeyPair generateKeyPairEC()
    {
        PlatformMetricsTimer platformmetricstimer = SSOMetrics.getKeyPairSelfGenerationTimer("EC");
        platformmetricstimer.start();
        Object obj = KeyPairGenHelper.getECKeyPair();
        String s = KeyPairGenHelper.encodePublicKey(((KeyPair) (obj)).getPublic());
        obj = KeyPairGenHelper.encodeECPrivateKey(((KeyPair) (obj)).getPrivate());
        platformmetricstimer.stop();
        return new SelfGeneratedKeyPair("EC", s, ((String) (obj)), "B64/X.509");
    }

    protected SelfGeneratedKeyPair generateKeyPairRSA()
    {
        PlatformMetricsTimer platformmetricstimer = SSOMetrics.getKeyPairSelfGenerationTimer("RSA");
        platformmetricstimer.start();
        Object obj = KeyPairGenHelper.getRSAKeyPair();
        String s = KeyPairGenHelper.encodePublicKey(((KeyPair) (obj)).getPublic());
        obj = KeyPairGenHelper.encodeRSAPrivateKey(((KeyPair) (obj)).getPrivate());
        platformmetricstimer.stop();
        return new SelfGeneratedKeyPair("RSA", s, ((String) (obj)), "B64/X.509");
    }

    public SelfGeneratedKeyPair retrieveSelfGeneratedKeyPair()
    {
        this;
        JVM INSTR monitorenter ;
        if (!TextUtils.isEmpty(PlatformSettings.getInstance(mContext).getSettingString("KeyPairGenerationService_Self_Generated_Key_Pair_Algo", null))) goto _L2; else goto _L1
_L1:
        Object obj = TAG;
        obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((SelfGeneratedKeyPair) (obj));
_L2:
        SelfGeneratedKeyPair selfgeneratedkeypair;
        obj = mContext.getSharedPreferences("com.amazon.dcp.sso.KeyPairGenerationService.SHARED_PREFS", 0);
        selfgeneratedkeypair = getKeyPairFromCache(((SharedPreferences) (obj)));
        if (selfgeneratedkeypair == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        android.content.Intent intent;
        MAPLog.i(TAG, "KeyPairGenerationService found a key pair In cache when retrieveSelfGeneratedKeyPair.");
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).clear();
        if (!((android.content.SharedPreferences.Editor) (obj)).commit())
        {
            MAPLog.e(TAG, "Unable to clear self generated key pair cache.");
        }
        intent = IntentHelpers.getBestIntentForService(mContext, null, "com.amazon.dcp.sso.KeyPairGenerationService");
        obj = selfgeneratedkeypair;
        if (intent == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        mContext.startService(intent);
        obj = selfgeneratedkeypair;
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        MAPLog.i(TAG, "KeyPairGenerationService found no key pair in cache when retrieveSelfGeneratedKeyPair.");
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

}
