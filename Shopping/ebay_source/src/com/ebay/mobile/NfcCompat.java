// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Activity;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.text.TextUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NfcCompat
{
    public static interface OnBeamPushListener
    {

        public abstract String getBeamPushUrl();

        public abstract void onBeamPushComplete();
    }


    public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBayNfc", 3, "NFC logging");

    public NfcCompat()
    {
    }

    public static boolean isBeamPushEnabled(Context context)
    {
        try
        {
            context = NfcAdapter.getDefaultAdapter(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            logger.logAsError("Error during NFC detection", context);
            return false;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        logDebug("NFC hardware not available on this device.");
        return false;
        if (context.isEnabled())
        {
            break MISSING_BLOCK_LABEL_42;
        }
        logDebug("NFC system setting is disabled.");
        return false;
        if (android.os.Build.VERSION.SDK_INT < 16 || isNdefPushEnabled(context))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        logDebug("Android Beam system setting is disabled.");
        return false;
        logDebug("NFC push is enabled");
        return true;
    }

    private static boolean isNdefPushEnabled(NfcAdapter nfcadapter)
    {
        return nfcadapter.isNdefPushEnabled();
    }

    private static void logDebug(String s)
    {
        if (logger.isLoggable)
        {
            logger.log(s);
        }
    }

    public static void registerForBeamPush(Activity activity, OnBeamPushListener onbeampushlistener)
    {
        if (activity == null || onbeampushlistener == null || !isBeamPushEnabled(activity))
        {
            return;
        } else
        {
            setNdefPushMessageCallback(activity, onbeampushlistener);
            setOnNdefPushCompleteCallback(activity, onbeampushlistener);
            return;
        }
    }

    private static void setNdefPushMessageCallback(Activity activity, OnBeamPushListener onbeampushlistener)
    {
        try
        {
            Class class1 = Class.forName("android.nfc.NfcAdapter");
            Object obj = class1.getMethod("getDefaultAdapter", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                activity
            });
            Class class2 = Class.forName("android.nfc.NfcAdapter$CreateNdefMessageCallback");
            ClassLoader classloader = class2.getClassLoader();
            onbeampushlistener = new InvocationHandler(onbeampushlistener) {

                final OnBeamPushListener val$nfcPushCallback;

                public Object invoke(Object obj1, Method method, Object aobj[])
                    throws Throwable
                {
                    NfcCompat.logDebug("CreateNdefMessageCallback invoked");
                    Object obj2 = nfcPushCallback.getBeamPushUrl();
                    if (TextUtils.isEmpty(((CharSequence) (obj2))))
                    {
                        NfcCompat.logger.logAsWarning("An NFC URL is not available to send.");
                        return null;
                    } else
                    {
                        NfcCompat.logDebug((new StringBuilder()).append("Sending NFC URL: ").append(((String) (obj2))).toString());
                        obj1 = Class.forName("android.nfc.NdefMessage");
                        method = Class.forName("android.nfc.NdefRecord");
                        aobj = Class.forName("[Landroid.nfc.NdefRecord;");
                        obj2 = method.getMethod("createUri", new Class[] {
                            java/lang/String
                        }).invoke(null, new Object[] {
                            obj2
                        });
                        Object obj3 = Array.newInstance(method, 0);
                        return ((Class) (obj1)).getConstructor(new Class[] {
                            method, aobj
                        }).newInstance(new Object[] {
                            obj2, obj3
                        });
                    }
                }

            
            {
                nfcPushCallback = onbeampushlistener;
                super();
            }
            };
            onbeampushlistener = ((OnBeamPushListener) (Proxy.newProxyInstance(classloader, new Class[] {
                class2
            }, onbeampushlistener)));
            class1.getMethod("setNdefPushMessageCallback", new Class[] {
                class2, android/app/Activity, [Landroid/app/Activity;
            }).invoke(obj, new Object[] {
                class2.cast(onbeampushlistener), activity, new Activity[0]
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            logger.logAsError("Error while setting setNdefPushMessageCallback.", activity);
        }
    }

    private static void setOnNdefPushCompleteCallback(Activity activity, OnBeamPushListener onbeampushlistener)
    {
        try
        {
            Class class1 = Class.forName("android.nfc.NfcAdapter");
            Object obj = class1.getMethod("getDefaultAdapter", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                activity
            });
            Class class2 = Class.forName("android.nfc.NfcAdapter$OnNdefPushCompleteCallback");
            ClassLoader classloader = class2.getClassLoader();
            onbeampushlistener = new InvocationHandler(onbeampushlistener) {

                final OnBeamPushListener val$nfcPushCallback;

                public Object invoke(Object obj1, Method method, Object aobj[])
                    throws Throwable
                {
                    NfcCompat.logDebug("OnNdefPushCompleteCallback invoked");
                    nfcPushCallback.onBeamPushComplete();
                    return null;
                }

            
            {
                nfcPushCallback = onbeampushlistener;
                super();
            }
            };
            onbeampushlistener = ((OnBeamPushListener) (Proxy.newProxyInstance(classloader, new Class[] {
                class2
            }, onbeampushlistener)));
            class1.getMethod("setOnNdefPushCompleteCallback", new Class[] {
                class2, android/app/Activity, [Landroid/app/Activity;
            }).invoke(obj, new Object[] {
                class2.cast(onbeampushlistener), activity, new Activity[0]
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            logger.logAsError("Error while setting setOnNdefPushCompleteCallback.", activity);
        }
    }


}
