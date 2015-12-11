// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.webkit.WebView;
import com.rhythmnewmedia.sdk.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

public final class Util
{
    public static interface ProcessCallback
    {

        public abstract void process(String s);
    }


    private static String a = null;
    private static String b = null;

    public Util()
    {
    }

    public static Class a(Class class1)
    {
        if (!class1.isPrimitive())
        {
            return class1;
        }
        if (class1 == Boolean.TYPE)
        {
            return java/lang/Boolean;
        }
        if (class1 == Byte.TYPE)
        {
            return java/lang/Byte;
        }
        if (class1 == Character.TYPE)
        {
            return java/lang/Character;
        }
        if (class1 == Double.TYPE)
        {
            return java/lang/Double;
        }
        if (class1 == Float.TYPE)
        {
            return java/lang/Float;
        }
        if (class1 == Integer.TYPE)
        {
            return java/lang/Integer;
        }
        if (class1 == Long.TYPE)
        {
            return java/lang/Long;
        }
        if (class1 == Short.TYPE)
        {
            return java/lang/Short;
        }
        if (class1 == Void.TYPE)
        {
            return java/lang/Void;
        } else
        {
            return null;
        }
    }

    public static String a()
    {
        return b;
    }

    public static String a(Context context)
    {
        com/rhythmnewmedia/sdk/util/Util;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = b(context);
        }
        context = a;
        com/rhythmnewmedia/sdk/util/Util;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static String a(InputStream inputstream)
        throws IOException
    {
        char ac[] = new char[10240];
        StringBuilder stringbuilder = new StringBuilder();
        inputstream = new InputStreamReader(inputstream, "UTF-8");
        int i;
        do
        {
            i = inputstream.read(ac, 0, ac.length);
            if (i > 0)
            {
                stringbuilder.append(ac, 0, i);
            }
        } while (i >= 0);
        return stringbuilder.toString();
    }

    public static String a(String s, String s1)
    {
        if (s.indexOf("vdm=SPD") == -1 && s.indexOf("vdm=SSPD") == -1)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        StringBuilder stringbuilder;
        int j;
        stringbuilder = new StringBuilder();
        stringbuilder.append("603");
        stringbuilder.append("0129");
        stringbuilder.append("11");
        j = s.indexOf("?");
        int i;
        i = j;
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        i = s.length();
        int k;
        String s2 = s.substring(s.lastIndexOf("/", i) + 1, i);
        StringBuilder stringbuilder2 = new StringBuilder();
        stringbuilder2.append(s2);
        stringbuilder2.append(s1);
        stringbuilder2.append(stringbuilder.toString());
        s1 = f(stringbuilder2.toString());
        if (s.indexOf("auth=") == -1)
        {
            return String.format("%s&auth=%s", new Object[] {
                s, s1
            });
        }
        k = s.indexOf("auth=") + 5;
        j = s.indexOf("&", k);
        i = j;
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        i = s.length();
        StringBuilder stringbuilder1 = new StringBuilder();
        stringbuilder1.append(s.substring(0, k));
        stringbuilder1.append(s1);
        stringbuilder1.append(s.substring(i));
        s = stringbuilder1.toString();
        return s;
        s;
        y.b(s, "failed to generate auth", new Object[0]);
        return null;
    }

    public static String a(String s, String s1, String s2)
    {
        s1 = String.format("&%s=", new Object[] {
            s1
        });
        s = new StringBuilder(s);
        int i = s.indexOf(s1);
        if (i == -1)
        {
            s.append(s1);
            s.append(s2);
        } else
        {
            int k = i + s1.length();
            int j = s.indexOf("&", k);
            i = j;
            if (j == -1)
            {
                i = s.length();
            }
            s.replace(k, i, String.valueOf(s2));
        }
        return s.toString();
    }

    private static transient Method a(Object obj, String s, Object aobj[])
    {
        Object obj1;
        Class class1;
        obj1 = null;
        class1 = null;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj1 = class1;
_L4:
        return ((Method) (obj1));
_L2:
        class1 = obj.getClass();
        obj = obj1;
_L15:
        obj1 = obj;
        if (class1 == null) goto _L4; else goto _L3
_L3:
        Object obj2 = obj;
        Method amethod[] = class1.getDeclaredMethods();
        obj2 = obj;
        int k = amethod.length;
        int i = 0;
_L17:
        obj1 = obj;
        if (i >= k) goto _L6; else goto _L5
_L5:
        obj1 = amethod[i];
        obj2 = obj;
        Class aclass[] = ((Method) (obj1)).getParameterTypes();
        obj2 = obj;
        if (!((Method) (obj1)).getName().equals(s)) goto _L8; else goto _L7
_L7:
        obj2 = obj;
        if (aclass.length != aobj.length) goto _L8; else goto _L9
_L9:
        int j = 0;
_L16:
        obj2 = obj;
        if (j >= aclass.length) goto _L11; else goto _L10
_L10:
        obj2 = obj;
        if (a(aclass[j]).isAssignableFrom(aobj[j].getClass())) goto _L13; else goto _L12
_L12:
        j = 0;
          goto _L14
_L6:
        obj2 = obj1;
        ((Method) (obj1)).setAccessible(true);
        return ((Method) (obj1));
        obj;
        class1 = class1.getSuperclass();
        obj = obj2;
          goto _L15
_L13:
        j++;
          goto _L16
_L8:
        i++;
          goto _L17
_L11:
        j = 1;
_L14:
        if (j == 0) goto _L8; else goto _L6
    }

    public static transient void a(Handler handler, Object obj, String s, Object aobj[])
    {
        if (obj == null)
        {
            return;
        }
        Method method = a(obj, s, aobj);
        if (method != null)
        {
            handler.post(new Runnable(method, obj, aobj, s) {

                final Method a;
                final Object b;
                final Object c[];
                final String d;

                public final void run()
                {
                    try
                    {
                        a.invoke(b, c);
                        return;
                    }
                    catch (Exception exception)
                    {
                        y.a(exception, "Failed to invoke method %s on %s", new Object[] {
                            d, b.getClass().getSimpleName()
                        });
                    }
                }

            
            {
                a = method;
                b = obj;
                c = aobj;
                d = s;
                super();
            }
            });
            return;
        } else
        {
            y.b("Failed to find method %s on %s", new Object[] {
                s, obj.getClass().getSimpleName()
            });
            return;
        }
    }

    public static void a(WebView webview, ProcessCallback processcallback)
    {
        webview.addJavascriptInterface(new Object(processcallback) {

            final ProcessCallback a;

            public final void process(String s)
            {
                a.process(s);
            }

            
            {
                a = processcallback;
                super();
            }
        }, "RhythmJSBridge");
    }

    public static void a(WebView webview, String s)
    {
        if (s != null)
        {
            webview.loadUrl(String.format("javascript:%s", new Object[] {
                s
            }));
        }
    }

    public static void a(String s)
    {
        b = s;
    }

    private static String b(Context context)
    {
        String s = null;
        String s1 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        s = s1;
_L1:
        Exception exception;
        if (s == null || s.trim().length() == 0)
        {
            context = "emulator";
        } else
        {
label0:
            {
                if (!s.equalsIgnoreCase("9774d56d682e549c"))
                {
                    break label0;
                }
                context = (WifiManager)context.getSystemService("wifi");
                if (context == null)
                {
                    break label0;
                }
                context = f(context.getConnectionInfo().getMacAddress());
                if (context == null || context.trim().length() == 0)
                {
                    break label0;
                }
                context = String.format("%s_%s", new Object[] {
                    s, context
                });
            }
        }
_L2:
        return String.format("%s%s", new Object[] {
            "DROID", context
        });
        exception;
        y.a("error getting udid", new Object[0]);
          goto _L1
        context = s;
          goto _L2
    }

    public static boolean b(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    public static String c(String s)
    {
        if (s != null)
        {
            if ((s = s.trim()).length() != 0)
            {
                return s;
            }
        }
        return null;
    }

    public static String d(String s)
    {
        if (s == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            y.a(unsupportedencodingexception, "Failed to encode %s", new Object[] {
                s
            });
            return s;
        }
        return s1;
    }

    public static String e(String s)
    {
        if (s == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            y.a(unsupportedencodingexception, "Failed to encode %s", new Object[] {
                s
            });
            return s;
        }
        return s1;
    }

    private static String f(String s)
    {
        if (s == null || s.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        Object obj;
        int j;
        obj = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj)).update(s.getBytes());
        s = ((MessageDigest) (obj)).digest();
        obj = new StringBuilder();
        j = s.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuilder) (obj)).append(String.format("%02x", new Object[] {
            Byte.valueOf(s[i])
        }));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s = ((StringBuilder) (obj)).toString();
        return s;
        s;
        y.b(s, "Error while using MD5 algorithm", new Object[0]);
        return null;
    }

}
