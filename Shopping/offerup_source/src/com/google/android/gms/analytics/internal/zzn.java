// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zzg;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzf

public class zzn extends zzd
{

    private volatile String zzMj;
    private Future zzNM;

    protected zzn(zzf zzf)
    {
        super(zzf);
    }

    static String zza(zzn zzn1)
    {
        return zzn1.zzjw();
    }

    private boolean zzi(Context context, String s)
    {
        Context context1;
        Context context2;
        Context context3;
        Object obj;
        Object obj1;
        Object obj2;
        boolean flag;
        flag = false;
        zzx.zzcr(s);
        zzx.zzcj("ClientId should be saved from worker thread");
        obj1 = null;
        obj2 = null;
        obj = null;
        context2 = obj;
        context3 = obj1;
        context1 = obj2;
        zza("Storing clientId", s);
        context2 = obj;
        context3 = obj1;
        context1 = obj2;
        context = context.openFileOutput("gaClientId", 0);
        context2 = context;
        context3 = context;
        context1 = context;
        context.write(s.getBytes());
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                zze("Failed to close clientId writing stream", context);
            }
        }
        flag = true;
_L2:
        return flag;
        context;
        context1 = context2;
        zze("Error creating clientId file", context);
        if (context2 == null) goto _L2; else goto _L1
_L1:
        try
        {
            context2.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            zze("Failed to close clientId writing stream", context);
            return false;
        }
        return false;
        context;
        context1 = context3;
        zze("Error writing to clientId file", context);
        if (context3 == null) goto _L2; else goto _L3
_L3:
        try
        {
            context3.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            zze("Failed to close clientId writing stream", context);
            return false;
        }
        return false;
        context;
        if (context1 != null)
        {
            try
            {
                context1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                zze("Failed to close clientId writing stream", s);
            }
        }
        throw context;
    }

    private String zzjw()
    {
        String s;
        String s1;
        s1 = zzjx();
        s = s1;
        if (!zzi(zziw().getContext(), s1))
        {
            s = "0";
        }
        return s;
        Exception exception;
        exception;
        zze("Error saving clientId file", exception);
        return "0";
    }

    protected String zzZ(Context context)
    {
        zzx.zzcj("ClientId should be loaded from worker thread");
        Object obj = context.openFileInput("gaClientId");
        Object obj1 = obj;
        byte abyte0[] = new byte[36];
        obj1 = obj;
        int i = ((FileInputStream) (obj)).read(abyte0, 0, 36);
        obj1 = obj;
        if (((FileInputStream) (obj)).available() <= 0) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        zzbd("clientId file seems corrupted, deleting it.");
        obj1 = obj;
        ((FileInputStream) (obj)).close();
        obj1 = obj;
        context.deleteFile("gaClientId");
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                zze("Failed to close client id reading stream", context);
                return null;
            }
        }
_L4:
        return null;
_L2:
        if (i >= 14)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        zzbd("clientId file is empty, deleting it.");
        obj1 = obj;
        ((FileInputStream) (obj)).close();
        obj1 = obj;
        context.deleteFile("gaClientId");
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                zze("Failed to close client id reading stream", context);
                return null;
            }
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        ((FileInputStream) (obj)).close();
        obj1 = obj;
        String s = new String(abyte0, 0, i);
        obj1 = obj;
        zza("Read client id from disk", s);
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                zze("Failed to close client id reading stream", context);
            }
        }
        return s;
        context;
        context = null;
_L10:
        if (context == null) goto _L4; else goto _L5
_L5:
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            zze("Failed to close client id reading stream", context);
            return null;
        }
        return null;
        IOException ioexception;
        ioexception;
        obj = null;
_L9:
        obj1 = obj;
        zze("Error reading client id file, deleting it", ioexception);
        obj1 = obj;
        context.deleteFile("gaClientId");
        if (obj == null) goto _L4; else goto _L6
_L6:
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            zze("Failed to close client id reading stream", context);
            return null;
        }
        return null;
        context;
        obj1 = null;
_L8:
        if (obj1 != null)
        {
            try
            {
                ((FileInputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                zze("Failed to close client id reading stream", obj);
            }
        }
        throw context;
        context;
        if (true) goto _L8; else goto _L7
_L7:
        ioexception;
          goto _L9
        context;
        context = ((Context) (obj));
          goto _L10
    }

    protected void zzhR()
    {
    }

    public String zzjt()
    {
        zziE();
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (zzMj == null)
        {
            zzNM = zziw().zzb(new _cls1());
        }
        obj = zzNM;
        if (obj == null) goto _L2; else goto _L1
_L1:
        zzMj = (String)zzNM.get();
_L3:
        if (zzMj == null)
        {
            zzMj = "0";
        }
        zza("Loaded clientId", zzMj);
        zzNM = null;
_L2:
        obj = zzMj;
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        Object obj1;
        obj1;
        zzd("ClientId loading or generation was interrupted", obj1);
        zzMj = "0";
          goto _L3
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        zze("Failed to load or generate client id", obj1);
        zzMj = "0";
          goto _L3
    }

    String zzju()
    {
        this;
        JVM INSTR monitorenter ;
        zzMj = null;
        zzNM = zziw().zzb(new _cls2());
        this;
        JVM INSTR monitorexit ;
        return zzjt();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    String zzjv()
    {
        String s1 = zzZ(zziw().getContext());
        String s = s1;
        if (s1 == null)
        {
            s = zzjw();
        }
        return s;
    }

    protected String zzjx()
    {
        return UUID.randomUUID().toString().toLowerCase();
    }

    private class _cls1
        implements Callable
    {

        final zzn zzNN;

        public Object call()
        {
            return zzjy();
        }

        public String zzjy()
        {
            return zzNN.zzjv();
        }

        _cls1()
        {
            zzNN = zzn.this;
            super();
        }
    }


    private class _cls2
        implements Callable
    {

        final zzn zzNN;

        public Object call()
        {
            return zzjy();
        }

        public String zzjy()
        {
            return zzn.zza(zzNN);
        }

        _cls2()
        {
            zzNN = zzn.this;
            super();
        }
    }

}
