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
//            zzd, zzaj, zzf, zzn, 
//            zzam

public class zza extends zzd
{

    public static boolean zzMq;
    private com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzMr;
    private final zzaj zzMs;
    private String zzMt;
    private boolean zzMu;
    private Object zzMv;

    zza(zzf zzf1)
    {
        super(zzf1);
        zzMu = false;
        zzMv = new Object();
        zzMs = new zzaj(zzf1.zzit());
    }

    private boolean zza(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info, com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info1)
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
        s = zziz().zzjt();
        Object obj1 = zzMv;
        obj1;
        JVM INSTR monitorenter ;
        if (zzMu) goto _L2; else goto _L1
_L1:
        zzMt = zzij();
        zzMu = true;
_L4:
        info = zzaY((new StringBuilder()).append(info1).append(s).toString());
        if (!TextUtils.isEmpty(info))
        {
            break MISSING_BLOCK_LABEL_192;
        }
        return false;
        info;
        obj1;
        JVM INSTR monitorexit ;
        throw info;
_L2:
        if (!TextUtils.isEmpty(zzMt)) goto _L4; else goto _L3
_L3:
        if (info != null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        info = obj;
_L5:
        if (info != null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        boolean flag = zzaZ((new StringBuilder()).append(info1).append(s).toString());
        obj1;
        JVM INSTR monitorexit ;
        return flag;
        info = info.getId();
          goto _L5
        zzMt = zzaY((new StringBuilder()).append(info).append(s).toString());
          goto _L4
        if (!info.equals(zzMt))
        {
            break MISSING_BLOCK_LABEL_208;
        }
        obj1;
        JVM INSTR monitorexit ;
        return true;
        if (TextUtils.isEmpty(zzMt))
        {
            break MISSING_BLOCK_LABEL_269;
        }
        zzba("Resetting the client id because Advertising Id changed.");
        info = zziz().zzju();
        zza("New client Id", info);
_L6:
        flag = zzaZ((new StringBuilder()).append(info1).append(info).toString());
        obj1;
        JVM INSTR monitorexit ;
        return flag;
        info = s;
          goto _L6
    }

    private static String zzaY(String s)
    {
        MessageDigest messagedigest = zzam.zzbs("MD5");
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

    private boolean zzaZ(String s)
    {
        try
        {
            s = zzaY(s);
            zzba("Storing hashed adid.");
            FileOutputStream fileoutputstream = getContext().openFileOutput("gaClientIdData", 0);
            fileoutputstream.write(s.getBytes());
            fileoutputstream.close();
            zzMt = s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zze("Error creating hash file", s);
            return false;
        }
        return true;
    }

    private com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzih()
    {
        this;
        JVM INSTR monitorenter ;
        if (zzMs.zzv(1000L))
        {
            zzMs.start();
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = zzii();
            if (!zza(zzMr, info))
            {
                break MISSING_BLOCK_LABEL_53;
            }
            zzMr = info;
        }
_L1:
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info1 = zzMr;
        this;
        JVM INSTR monitorexit ;
        return info1;
        zzbe("Failed to reset client id on adid change. Not using adid");
        zzMr = new com.google.android.gms.ads.identifier.AdvertisingIdClient.Info("", false);
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    protected void zzhR()
    {
    }

    public boolean zzic()
    {
        boolean flag1 = false;
        zziE();
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = zzih();
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

    public String zzig()
    {
        zziE();
        Object obj = zzih();
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

    protected com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzii()
    {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = null;
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info1 = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        info = info1;
_L2:
        return info;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        zzbd("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        return null;
        Throwable throwable;
        throwable;
        if (!zzMq)
        {
            zzMq = true;
            zzd("Error getting advertiser id", throwable);
            return null;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected String zzij()
    {
        Object obj = null;
        byte abyte0[];
        FileInputStream fileinputstream;
        int i;
        fileinputstream = getContext().openFileInput("gaClientIdData");
        abyte0 = new byte[128];
        i = fileinputstream.read(abyte0, 0, 128);
        if (fileinputstream.available() <= 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzbd("Hash file seems corrupted, deleting it.");
        fileinputstream.close();
        getContext().deleteFile("gaClientIdData");
        return null;
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        zzba("Hash file is empty.");
        fileinputstream.close();
        return null;
        Object obj1 = new String(abyte0, 0, i);
        fileinputstream.close();
        return ((String) (obj1));
        obj1;
_L2:
        zzd("Error reading Hash file, deleting it", obj1);
        getContext().deleteFile("gaClientIdData");
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
}
