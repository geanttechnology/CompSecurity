// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, k, r, l, 
//            o, z

public final class a extends p
{

    public static boolean a;
    private com.google.android.gms.ads.identifier.AdvertisingIdClient.Info b;
    private final k c;
    private String d;
    private boolean e;
    private Object f;

    a(r r1)
    {
        super(r1);
        e = false;
        f = new Object();
        c = new k(r1.c);
    }

    private static String a(String s)
    {
        MessageDigest messagedigest = l.d("MD5");
        if (messagedigest == null)
        {
            return null;
        } else
        {
            return String.format(Locale.US, "%032X", new Object[] {
                new BigInteger(1, messagedigest.digest(s.getBytes()))
            });
        }
    }

    private boolean a(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info, com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info1)
    {
        Object obj;
        String s;
        obj = null;
        if (info1 == null)
        {
            info1 = null;
        } else
        {
            info1 = info1.getId();
        }
        if (TextUtils.isEmpty(info1))
        {
            return true;
        }
        s = super.i.g().b();
        Object obj1 = f;
        obj1;
        JVM INSTR monitorenter ;
        if (e) goto _L2; else goto _L1
_L1:
        d = f();
        e = true;
_L4:
        info = a((new StringBuilder()).append(info1).append(s).toString());
        if (!TextUtils.isEmpty(info))
        {
            break MISSING_BLOCK_LABEL_195;
        }
        return false;
        info;
        obj1;
        JVM INSTR monitorexit ;
        throw info;
_L2:
        if (!TextUtils.isEmpty(d)) goto _L4; else goto _L3
_L3:
        if (info != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        info = obj;
_L5:
        if (info != null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        boolean flag = g((new StringBuilder()).append(info1).append(s).toString());
        obj1;
        JVM INSTR monitorexit ;
        return flag;
        info = info.getId();
          goto _L5
        d = a((new StringBuilder()).append(info).append(s).toString());
          goto _L4
        if (!info.equals(d))
        {
            break MISSING_BLOCK_LABEL_211;
        }
        obj1;
        JVM INSTR monitorexit ;
        return true;
        if (TextUtils.isEmpty(d))
        {
            break MISSING_BLOCK_LABEL_275;
        }
        b("Resetting the client id because Advertising Id changed.");
        info = super.i.g().c();
        a("New client Id", info);
_L6:
        flag = g((new StringBuilder()).append(info1).append(info).toString());
        obj1;
        JVM INSTR monitorexit ;
        return flag;
        info = s;
          goto _L6
    }

    private com.google.android.gms.ads.identifier.AdvertisingIdClient.Info d()
    {
        this;
        JVM INSTR monitorenter ;
        if (c.a(1000L))
        {
            c.a();
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = e();
            if (!a(b, info))
            {
                break MISSING_BLOCK_LABEL_53;
            }
            b = info;
        }
_L1:
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info1 = b;
        this;
        JVM INSTR monitorexit ;
        return info1;
        f("Failed to reset client id on adid change. Not using adid");
        b = new com.google.android.gms.ads.identifier.AdvertisingIdClient.Info("", false);
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private com.google.android.gms.ads.identifier.AdvertisingIdClient.Info e()
    {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = null;
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info1 = AdvertisingIdClient.getAdvertisingIdInfo(super.i.a);
        info = info1;
_L2:
        return info;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        e("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        return null;
        Throwable throwable;
        throwable;
        if (!a)
        {
            a = true;
            d("Error getting advertiser id", throwable);
            return null;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String f()
    {
        Object obj = null;
        byte abyte0[];
        FileInputStream fileinputstream;
        int i;
        fileinputstream = super.i.a.openFileInput("gaClientIdData");
        abyte0 = new byte[128];
        i = fileinputstream.read(abyte0, 0, 128);
        if (fileinputstream.available() <= 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        e("Hash file seems corrupted, deleting it.");
        fileinputstream.close();
        super.i.a.deleteFile("gaClientIdData");
        return null;
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        b("Hash file is empty.");
        fileinputstream.close();
        return null;
        Object obj1 = new String(abyte0, 0, i);
        fileinputstream.close();
        return ((String) (obj1));
        obj1;
_L2:
        d("Error reading Hash file, deleting it", obj1);
        super.i.a.deleteFile("gaClientIdData");
        return ((String) (obj));
        IOException ioexception;
        ioexception;
        obj = obj1;
        obj1 = ioexception;
        if (true) goto _L2; else goto _L1
_L1:
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        return ((String) (obj1));
        filenotfoundexception;
        return null;
    }

    private boolean g(String s)
    {
        try
        {
            s = a(s);
            b("Storing hashed adid.");
            FileOutputStream fileoutputstream = super.i.a.openFileOutput("gaClientIdData", 0);
            fileoutputstream.write(s.getBytes());
            fileoutputstream.close();
            d = s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            e("Error creating hash file", s);
            return false;
        }
        return true;
    }

    protected final void a()
    {
    }

    public final boolean b()
    {
        boolean flag1 = false;
        o();
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = d();
        boolean flag = flag1;
        if (info != null)
        {
            flag = flag1;
            if (!info.isLimitAdTrackingEnabled())
            {
                flag = true;
            }
        }
        return flag;
    }

    public final String c()
    {
        o();
        Object obj = d();
        if (obj != null)
        {
            obj = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).getId();
        } else
        {
            obj = null;
        }
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return null;
        } else
        {
            return ((String) (obj));
        }
    }
}
