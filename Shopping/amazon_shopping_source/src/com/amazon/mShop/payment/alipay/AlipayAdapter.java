// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mShop.payment.alipay:
//            AlipayAdapterStatus, AlipayServiceConnection, AlipayCallback

public class AlipayAdapter
{
    public static class Factory
    {

        public static AlipayAdapter getInstance()
        {
            return AlipayAdapter.SINGLETON_INSTANCE;
        }

        public Factory()
        {
        }
    }


    private static final Pattern RESULT_FIELD_PATTERN = Pattern.compile("\\s*([^;]+?)\\s*=\\s*\\{(.*?)\\}\\s*");
    private static final AlipayAdapter SINGLETON_INSTANCE = new AlipayAdapter();

    private AlipayAdapter()
    {
    }

    private JSONObject convertPaymentResultStrToJson(String s)
    {
        if (isEmpty(s))
        {
            return null;
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        try
        {
            s = RESULT_FIELD_PATTERN.matcher(s);
            do
            {
                if (!s.find())
                {
                    break;
                }
                if (s.groupCount() == 2)
                {
                    jsonobject.put(s.group(1), s.group(2));
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    private boolean isCompatiblePackInstalled(Context context, String s, int i)
    {
        boolean flag1 = false;
        int j;
        boolean flag;
        try
        {
            context = context.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        flag = flag1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        j = ((PackageInfo) (context)).versionCode;
        flag = flag1;
        if (j > i)
        {
            flag = true;
        }
        return flag;
    }

    private boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public String getResultAsUriQueryParam(String s)
    {
        if (!isEmpty(s))
        {
            if ((s = convertPaymentResultStrToJson(s)) != null)
            {
                try
                {
                    s = s.getString(AlipayCallback.ResultField.result.toString());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return null;
                }
                return s;
            }
        }
        return null;
    }

    public boolean isAlipayInstalled(Context context)
    {
        return isCompatiblePackInstalled(context, "com.eg.android.AlipayGphone", 38) || isCompatiblePackInstalled(context, "com.alipay.android.app", 1);
    }

    public boolean isPaymentSuccess(String s)
    {
        if (!isEmpty(s))
        {
            if ((s = convertPaymentResultStrToJson(s)) != null)
            {
                boolean flag;
                try
                {
                    flag = "9000".equals(s.getString(AlipayCallback.ResultField.resultStatus.toString()));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return false;
                }
                if (flag)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public AlipayAdapterStatus pay(Activity activity, String s, AlipayCallback alipaycallback)
    {
        AlipayAdapterStatus alipayadapterstatus = AlipayAdapterStatus.ADAPTER_INVOKE_SUCCESS;
        if (isCompatiblePackInstalled(activity, "com.eg.android.AlipayGphone", 38))
        {
            (new AlipayServiceConnection(activity, s, alipaycallback)).startPayment("com.eg.android.AlipayGphone.IAlixPay");
            return alipayadapterstatus;
        }
        if (isCompatiblePackInstalled(activity, "com.alipay.android.app", 1))
        {
            (new AlipayServiceConnection(activity, s, alipaycallback)).startPayment("com.alipay.android.app.IAlixPay");
            return alipayadapterstatus;
        } else
        {
            return AlipayAdapterStatus.ALIPAY_UAVAILABLE;
        }
    }


}
