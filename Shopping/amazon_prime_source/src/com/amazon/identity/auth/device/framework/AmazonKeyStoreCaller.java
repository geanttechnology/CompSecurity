// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            Tracer

public final class AmazonKeyStoreCaller
{

    private static final String TAG = com/amazon/identity/auth/device/framework/AmazonKeyStoreCaller.getName();

    private AmazonKeyStoreCaller()
    {
    }

    private static String callAmazonKeyStoreStaticMethod(String s, String s1, Tracer tracer)
    {
        Object obj = getAmazonKeyStoreClass();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((String) (obj));
_L2:
        String s2 = (String)((Class) (obj)).getMethod(s, new Class[0]).invoke(null, new Object[0]);
        obj = s2;
        if (!TextUtils.isEmpty(s2)) goto _L4; else goto _L3
_L3:
        MAPLog.e(TAG, (new StringBuilder("Attribute:")).append(s1).append(" is missing").toString());
        return null;
        s1;
        MAPLog.w(TAG, (new StringBuilder("Current fireOS version doesn't have ")).append(s).append(" api in AmazonKeyStore ready").toString());
_L6:
        return null;
        Exception exception;
        exception;
        MAPLog.logAndReportError(TAG, tracer, (new StringBuilder("Unknown error happens when calling platform api:")).append(s).toString(), (new StringBuilder()).append(s1).append("Collection:Exception:").append(exception.getClass().getName()).toString(), exception);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static String getAmazonDeviceMacAddress(Tracer tracer)
    {
        return callAmazonKeyStoreStaticMethod("getMacAddress", "MacAddress", tracer);
    }

    private static Class getAmazonKeyStoreClass()
    {
        Class class1;
        try
        {
            class1 = Class.forName("amazon.security.AmazonKeyStore");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return null;
        }
        return class1;
    }

    public static Object getAmzonKeyStoreInstance(Tracer tracer)
    {
        Object obj = getAmazonKeyStoreClass();
        if (obj == null)
        {
            return null;
        }
        try
        {
            obj = ((Class) (obj)).getMethod("getAmznInstance", new Class[0]).invoke(null, new Object[0]);
        }
        catch (Exception exception)
        {
            MAPLog.logAndReportError(TAG, tracer, "Error getting AmazonKeyStore instance", (new StringBuilder("AmazonKeyStoreError:")).append(exception.getClass().getSimpleName()).toString(), exception);
            return null;
        }
        return obj;
    }

    public static String getDeviceSecret()
    {
        return callAmazonKeyStoreStaticMethod("getSecret", "DeviceSecret", null);
    }

}
