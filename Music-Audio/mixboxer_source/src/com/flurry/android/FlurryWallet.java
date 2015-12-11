// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.flurry.android.responses.AppCloudError;
import java.util.UUID;

// Referenced classes of package com.flurry.android:
//            et, du, AppCloudUser, FlurryAppCloudRequestManager, 
//            FlurryWalletHandler, r

public class FlurryWallet
{

    protected static String EMAIL_END = ".flurry.com";
    private static AppCloudUser cO = null;
    private static Context mContext = null;

    public FlurryWallet()
    {
    }

    static AppCloudUser a(AppCloudUser appclouduser)
    {
        cO = appclouduser;
        return appclouduser;
    }

    public static void addObserverForCurrencyKey(String s, FlurryWalletHandler flurrywallethandler)
    {
        String s1 = et.aZ();
        String s2 = et.bd();
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            Log.i("FlurryWallet", "There is no last logged in user");
            s1 = generateDeviceId();
            s2 = (new StringBuilder()).append(s1).append("@").append(s1).append(EMAIL_END).toString();
            try
            {
                AppCloudUser.loginUserWithName(s1, s1, s2, true, new du(s, flurrywallethandler));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        } else
        {
            FlurryAppCloudRequestManager.UserSession = s2;
            AppCloudUser.setCurrentUser(et.aY());
            addObserverForUser(s, s1, flurrywallethandler);
            return;
        }
    }

    protected static void addObserverForUser(String s, String s1, FlurryWalletHandler flurrywallethandler)
    {
        if (cO == null)
        {
            cO = et.aY();
        }
        s1 = cO.getId();
        if (TextUtils.isEmpty(s1))
        {
            flurrywallethandler.onError(new AppCloudError(400, "Please assign an object id."));
            return;
        } else
        {
            r.a(s1, s, flurrywallethandler);
            r.b(s1);
            return;
        }
    }

    static void g(Context context)
    {
        mContext = context;
    }

    protected static String generateDeviceId()
    {
        Object obj = (TelephonyManager)mContext.getSystemService("phone");
        obj = (new StringBuilder()).append("").append(((TelephonyManager) (obj)).getDeviceId()).toString();
        long l = (new StringBuilder()).append("").append(android.provider.Settings.Secure.getString(mContext.getContentResolver(), "android_id")).toString().hashCode();
        long l1 = ((String) (obj)).hashCode();
        return (new UUID(l, (long)"".hashCode() | l1 << 32)).toString();
    }

    public static boolean removeAllObservers()
    {
        AppCloudUser appclouduser = et.aY();
        if (appclouduser != null)
        {
            return appclouduser.removeAllObservers();
        } else
        {
            return false;
        }
    }

    public static boolean removeObserver(FlurryWalletHandler flurrywallethandler)
    {
        Object obj;
label0:
        {
            obj = et.aY();
            if (obj != null)
            {
                obj = ((AppCloudUser) (obj)).getId();
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    break label0;
                }
            }
            return false;
        }
        return r.a(((String) (obj)), flurrywallethandler);
    }

    public static boolean removeObserversForCurrencyKey(String s)
    {
        Object obj;
label0:
        {
            obj = et.aY();
            if (obj != null)
            {
                obj = ((AppCloudUser) (obj)).getId();
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    break label0;
                }
            }
            return false;
        }
        return r.a(((String) (obj)), s);
    }

}
