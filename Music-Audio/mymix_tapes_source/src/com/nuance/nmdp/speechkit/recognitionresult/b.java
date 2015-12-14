// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.recognitionresult;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import aw;
import bi;
import bk;
import com.nuance.nmsp.client.sdk.oem.c;
import cv;
import cw;
import fa;
import fb;
import j;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r;

// Referenced classes of package com.nuance.nmdp.speechkit.recognitionresult:
//            c

public final class b
{

    private boolean a;
    private final Context b;

    public b(Object obj)
    {
        b = (Context)obj;
        a = Build.PRODUCT.equals("sdk");
    }

    public static com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary a(cv cv1)
    {
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary(null);
        Enumeration enumeration = cv1.a();
        do
        {
            if (enumeration.hasMoreElements())
            {
                String s = (String)enumeration.nextElement();
                switch (cv1.c(s))
                {
                default:
                    b("PdxValue", "Unsupported PDX type found in dictionary, skipping");
                    break;

                case 224: 
                    dictionary.put(s, a(cv1.h(s)));
                    break;

                case 16: // '\020'
                    dictionary.put(s, a(cv1.i(s)));
                    break;

                case 192: 
                    dictionary.put(s, cv1.d(s));
                    break;

                case 193: 
                    dictionary.put(s, cv1.f(s));
                    break;

                case 22: // '\026'
                    dictionary.put(s, cv1.g(s));
                    break;

                case 4: // '\004'
                    dictionary.put(s, cv1.e(s));
                    break;
                }
            } else
            {
                return dictionary;
            }
        } while (true);
    }

    private static com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence a(cw cw1)
    {
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence;
        int l;
        sequence = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence(null);
        l = 0;
_L9:
        if (l >= cw1.a())
        {
            break MISSING_BLOCK_LABEL_192;
        }
        cw1.b(l);
        JVM INSTR lookupswitch 6: default 88
    //                   4: 178
    //                   16: 119
    //                   22: 164
    //                   192: 136
    //                   193: 150
    //                   224: 102;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        break MISSING_BLOCK_LABEL_178;
_L7:
        break; /* Loop/switch isn't completed */
_L1:
        b("PdxValue", "Unsupported PDX type found in sequence, skipping");
_L10:
        l++;
        if (true) goto _L9; else goto _L8
_L8:
        sequence.add(a(cw1.g(l)));
          goto _L10
_L3:
        sequence.add(a(cw1.h(l)));
          goto _L10
_L5:
        sequence.add(cw1.c(l));
          goto _L10
_L6:
        sequence.add(cw1.e(l));
          goto _L10
_L4:
        sequence.add(cw1.f(l));
          goto _L10
        sequence.add(cw1.d(l));
          goto _L10
        return sequence;
    }

    public static cv a(j j1, Map map)
    {
        cv cv1 = j1.g();
        map = map.entrySet().iterator();
        do
        {
            if (map.hasNext())
            {
                Object obj = (java.util.Map.Entry)map.next();
                String s = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (r)((java.util.Map.Entry) (obj)).getValue();
                switch (((r) (obj)).f())
                {
                case 0: // '\0'
                    cv1.b(s, ((r) (obj)).c());
                    break;

                case 1: // '\001'
                    cv1.b(s, ((r) (obj)).d());
                    break;

                case 4: // '\004'
                    cv1.a(s, ((r) (obj)).e());
                    break;

                case 2: // '\002'
                    cv1.a(s, a(j1, ((r) (obj)).a()));
                    break;

                case 3: // '\003'
                    cv1.a(s, a(j1, ((r) (obj)).b()));
                    break;
                }
            } else
            {
                return cv1;
            }
        } while (true);
    }

    public static cw a(j j1, List list)
    {
        cw cw1 = j1.h();
        list = list.iterator();
        do
        {
            if (list.hasNext())
            {
                r r1 = (r)list.next();
                switch (r1.f())
                {
                case 0: // '\0'
                    cw1.a(r1.c());
                    break;

                case 1: // '\001'
                    cw1.i(r1.d());
                    break;

                case 4: // '\004'
                    cw1.b(r1.e());
                    break;

                case 2: // '\002'
                    cw1.a(a(j1, r1.a()));
                    break;

                case 3: // '\003'
                    cw1.a(a(j1, r1.b()));
                    break;
                }
            } else
            {
                return cw1;
            }
        } while (true);
    }

    public static List a(byte abyte0[])
        throws IllegalArgumentException
    {
        if (abyte0 == null || abyte0.length < 4)
        {
            throw new IllegalArgumentException("Cannot parse results: The buffer length is too small to be containing any results.");
        }
        abyte0 = fb.a(abyte0);
        ArrayList arraylist = new ArrayList();
        for (int l = 0; l < abyte0.a(); l++)
        {
            arraylist.add(new com.nuance.nmdp.speechkit.recognitionresult.c(abyte0.a(l)));
        }

        return arraylist;
    }

    public static void a(Object obj, String s)
    {
        Log.i("SpeechKit", d(obj, s));
    }

    public static void a(Object obj, String s, Throwable throwable)
    {
        Log.e("SpeechKit", d(obj, s), throwable);
    }

    public static void b(Object obj, String s)
    {
        Log.w("SpeechKit", d(obj, s));
    }

    public static void c(Object obj, String s)
    {
        Log.e("SpeechKit", d(obj, s));
    }

    private static String d(Object obj, String s)
    {
        String s1;
        if (!aw.a && obj != null)
        {
            if ((s1 = obj.getClass().getName()) != null && s1.length() != 0)
            {
                int l = s1.lastIndexOf('.');
                obj = s1;
                if (l >= 0)
                {
                    l++;
                    obj = s1;
                    if (l < s1.length())
                    {
                        obj = s1.substring(l);
                    }
                }
                return (new StringBuilder()).append(((String) (obj))).append(": ").append(s).toString();
            }
        }
        return s;
    }

    public static String h()
    {
        return com.nuance.nmsp.client.sdk.oem.c.e().a();
    }

    public static String i()
    {
        return com.nuance.nmsp.client.sdk.oem.c.e().b();
    }

    public static String j()
    {
        return com.nuance.nmsp.client.sdk.oem.c.e().c();
    }

    public static String k()
    {
        return com.nuance.nmsp.client.sdk.oem.c.e().d();
    }

    public final String a()
    {
        String s;
label0:
        {
            String s1 = ((TelephonyManager)b.getSystemService("phone")).getNetworkOperatorName();
            if (s1 != null)
            {
                s = s1;
                if (s1.length() != 0)
                {
                    break label0;
                }
            }
            s = "carrier";
        }
        return s;
    }

    public final String b()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo != null)
        {
            String s = networkinfo.getTypeName();
            if (s != null && s.length() > 0)
            {
                return networkinfo.getTypeName();
            }
        }
        return null;
    }

    public final String c()
    {
        String s1 = (new c(b)).f();
        String s = s1;
        if (s1 != null)
        {
            s = s1;
            if (s1.length() == 0)
            {
                s = null;
            }
        }
        return s;
    }

    public final bi d()
    {
        if (((AudioManager)b.getSystemService("audio")).isBluetoothScoOn() || a)
        {
            return bi.a;
        } else
        {
            return bi.b;
        }
    }

    public final bi e()
    {
        if (((AudioManager)b.getSystemService("audio")).isBluetoothScoOn())
        {
            return bi.a;
        } else
        {
            return bi.b;
        }
    }

    public final byte[] f()
    {
        Object aobj[];
        ApplicationInfo applicationinfo = b.getApplicationInfo();
        if (applicationinfo.name != null)
        {
            return applicationinfo.name.getBytes("UTF-8");
        }
        if (applicationinfo.packageName == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        aobj = applicationinfo.packageName.split(".");
        if (aobj.length <= 1)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        aobj = aobj[aobj.length - 1].getBytes("UTF-8");
        return ((byte []) (aobj));
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        return new byte[0];
    }

    public final byte[] g()
    {
        byte abyte0[];
        ApplicationInfo applicationinfo = b.getApplicationInfo();
        if (applicationinfo.packageName == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        abyte0 = applicationinfo.packageName.getBytes("UTF-8");
        return abyte0;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        return new byte[0];
    }
}
