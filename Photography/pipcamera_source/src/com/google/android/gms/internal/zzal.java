// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            zzak, zzap, zzar, zzat, 
//            zzaq

public abstract class zzal extends zzak
{

    private static long startTime = 0L;
    private static Method zzmV;
    private static Method zzmW;
    private static Method zzmX;
    private static Method zzmY;
    private static Method zzmZ;
    private static Method zzna;
    private static Method zznb;
    private static Method zznc;
    private static Method zznd;
    private static Method zzne;
    private static Method zznf;
    private static Method zzng;
    private static Method zznh;
    private static String zzni;
    private static String zznj;
    private static String zznk;
    private static zzar zznl;
    static boolean zznm = false;

    protected zzal(Context context, zzap zzap1, zzaq zzaq)
    {
        super(context, zzap1, zzaq);
    }

    static String zzU()
    {
        if (zzni == null)
        {
            throw new zza();
        } else
        {
            return zzni;
        }
    }

    static Long zzV()
    {
        if (zzmV == null)
        {
            throw new zza();
        }
        Long long1;
        try
        {
            long1 = (Long)zzmV.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new zza(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new zza(invocationtargetexception);
        }
        return long1;
    }

    static String zzW()
    {
        if (zzmX == null)
        {
            throw new zza();
        }
        String s;
        try
        {
            s = (String)zzmX.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new zza(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new zza(invocationtargetexception);
        }
        return s;
    }

    static Long zzX()
    {
        if (zzmW == null)
        {
            throw new zza();
        }
        Long long1;
        try
        {
            long1 = (Long)zzmW.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new zza(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new zza(invocationtargetexception);
        }
        return long1;
    }

    static String zza(Context context, zzap zzap1)
    {
        if (zznj != null)
        {
            return zznj;
        }
        if (zzmY == null)
        {
            throw new zza();
        }
        try
        {
            context = (ByteBuffer)zzmY.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new zza();
        zznj = zzap1.zza(context.array(), true);
        context = zznj;
        return context;
    }

    static ArrayList zza(MotionEvent motionevent, DisplayMetrics displaymetrics)
    {
        if (zzmZ == null || motionevent == null)
        {
            throw new zza();
        }
        try
        {
            motionevent = (ArrayList)zzmZ.invoke(null, new Object[] {
                motionevent, displaymetrics
            });
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new zza(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new zza(motionevent);
        }
        return motionevent;
    }

    protected static void zza(String s, Context context, zzap zzap1)
    {
        com/google/android/gms/internal/zzal;
        JVM INSTR monitorenter ;
        boolean flag = zznm;
        if (!flag)
        {
            try
            {
                zznl = new zzar(zzap1, null);
                zzni = s;
                zzl(context);
                startTime = zzV().longValue();
                zznm = true;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            finally
            {
                com/google/android/gms/internal/zzal;
            }
        }
        com/google/android/gms/internal/zzal;
        JVM INSTR monitorexit ;
        return;
        throw s;
    }

    static String zzb(Context context, zzap zzap1)
    {
        if (zznk != null)
        {
            return zznk;
        }
        if (zznb == null)
        {
            throw new zza();
        }
        try
        {
            context = (ByteBuffer)zznb.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new zza();
        zznk = zzap1.zza(context.array(), true);
        context = zznk;
        return context;
    }

    private static String zzb(byte abyte0[], String s)
    {
        try
        {
            abyte0 = new String(zznl.zzc(abyte0, s), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new zza(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new zza(abyte0);
        }
        return abyte0;
    }

    static String zze(Context context)
    {
        if (zzna == null)
        {
            throw new zza();
        }
        try
        {
            context = (String)zzna.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new zza();
        return context;
    }

    static String zzf(Context context)
    {
        if (zzne == null)
        {
            throw new zza();
        }
        try
        {
            context = (String)zzne.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        return context;
    }

    static Long zzg(Context context)
    {
        if (zznf == null)
        {
            throw new zza();
        }
        try
        {
            context = (Long)zznf.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        return context;
    }

    static ArrayList zzh(Context context)
    {
        if (zznc == null)
        {
            throw new zza();
        }
        try
        {
            context = (ArrayList)zznc.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (context.size() == 2)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new zza();
        return context;
    }

    static int[] zzi(Context context)
    {
        if (zznd == null)
        {
            throw new zza();
        }
        try
        {
            context = (int[])zznd.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        return context;
    }

    static int zzj(Context context)
    {
        if (zzng == null)
        {
            throw new zza();
        }
        int i;
        try
        {
            i = ((Integer)zzng.invoke(null, new Object[] {
                context
            })).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        return i;
    }

    static int zzk(Context context)
    {
        if (zznh == null)
        {
            throw new zza();
        }
        int i;
        try
        {
            i = ((Integer)zznh.invoke(null, new Object[] {
                context
            })).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        return i;
    }

    private static void zzl(Context context)
    {
        File file;
        File file1;
        byte abyte0[];
        String s;
        byte abyte1[];
        Class class1;
        Object obj;
        Class class2;
        Class class3;
        Class class4;
        Class class5;
        Class class6;
        Class class7;
        Class class8;
        Class class9;
        Class class10;
        Object obj1;
        try
        {
            abyte0 = zznl.zzl(zzat.getKey());
            abyte1 = zznl.zzc(abyte0, zzat.zzad());
            file1 = context.getCacheDir();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new zza(context);
        }
        file = file1;
        if (file1 != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        file1 = context.getDir("dex", 0);
        file = file1;
        if (file1 != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new zza();
        file1 = File.createTempFile("ads", ".jar", file);
        obj = new FileOutputStream(file1);
        ((FileOutputStream) (obj)).write(abyte1, 0, abyte1.length);
        ((FileOutputStream) (obj)).close();
        obj1 = new DexClassLoader(file1.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
        context = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzam()));
        class1 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzaA()));
        obj = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzau()));
        class2 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzaq()));
        class3 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzaC()));
        class4 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzao()));
        class5 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzay()));
        class6 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzaw()));
        class7 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzak()));
        class8 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzai()));
        class9 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzag()));
        class10 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzas()));
        obj1 = ((DexClassLoader) (obj1)).loadClass(zzb(abyte0, zzat.zzae()));
        zzmV = context.getMethod(zzb(abyte0, zzat.zzan()), new Class[0]);
        zzmW = class1.getMethod(zzb(abyte0, zzat.zzaB()), new Class[0]);
        zzmX = ((Class) (obj)).getMethod(zzb(abyte0, zzat.zzav()), new Class[0]);
        zzmY = class2.getMethod(zzb(abyte0, zzat.zzar()), new Class[] {
            android/content/Context
        });
        zzmZ = class3.getMethod(zzb(abyte0, zzat.zzaD()), new Class[] {
            android/view/MotionEvent, android/util/DisplayMetrics
        });
        zzna = class4.getMethod(zzb(abyte0, zzat.zzap()), new Class[] {
            android/content/Context
        });
        zznb = class5.getMethod(zzb(abyte0, zzat.zzaz()), new Class[] {
            android/content/Context
        });
        zznc = class6.getMethod(zzb(abyte0, zzat.zzax()), new Class[] {
            android/content/Context
        });
        zznd = class7.getMethod(zzb(abyte0, zzat.zzal()), new Class[] {
            android/content/Context
        });
        zzne = class8.getMethod(zzb(abyte0, zzat.zzaj()), new Class[] {
            android/content/Context
        });
        zznf = class9.getMethod(zzb(abyte0, zzat.zzah()), new Class[] {
            android/content/Context
        });
        zzng = class10.getMethod(zzb(abyte0, zzat.zzat()), new Class[] {
            android/content/Context
        });
        zznh = ((Class) (obj1)).getMethod(zzb(abyte0, zzat.zzaf()), new Class[] {
            android/content/Context
        });
        context = file1.getName();
        file1.delete();
        (new File(file, context.replace(".jar", ".dex"))).delete();
        return;
        context;
        s = file1.getName();
        file1.delete();
        (new File(file, s.replace(".jar", ".dex"))).delete();
        throw context;
    }

    protected void zzc(Context context)
    {
        try
        {
            zza(1, zzW());
        }
        catch (zza zza11) { }
        try
        {
            zza(2, zzU());
        }
        catch (zza zza10) { }
        try
        {
            long l = zzV().longValue();
            zza(25, l);
            if (startTime != 0L)
            {
                zza(17, l - startTime);
                zza(23, startTime);
            }
        }
        catch (zza zza9) { }
        try
        {
            ArrayList arraylist = zzh(context);
            zza(31, ((Long)arraylist.get(0)).longValue());
            zza(32, ((Long)arraylist.get(1)).longValue());
        }
        catch (zza zza8) { }
        try
        {
            zza(33, zzX().longValue());
        }
        catch (zza zza7) { }
        try
        {
            zza(27, zza(context, zzmT));
        }
        catch (zza zza6) { }
        try
        {
            zza(29, zzb(context, zzmT));
        }
        catch (zza zza5) { }
        try
        {
            int ai[] = zzi(context);
            zza(5, ai[0]);
            zza(6, ai[1]);
        }
        catch (zza zza4) { }
        try
        {
            zza(12, zzj(context));
        }
        catch (zza zza3) { }
        try
        {
            zza(3, zzk(context));
        }
        catch (zza zza2) { }
        try
        {
            zza(34, zzf(context));
        }
        catch (zza zza1) { }
        try
        {
            zza(35, zzg(context).longValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        context;
    }

    protected void zzd(Context context)
    {
        try
        {
            zza(2, zzU());
        }
        catch (zza zza5) { }
        try
        {
            zza(1, zzW());
        }
        catch (zza zza4) { }
        try
        {
            zza(25, zzV().longValue());
        }
        catch (zza zza3) { }
        try
        {
            ArrayList arraylist = zza(zzmR, zzmS);
            zza(14, ((Long)arraylist.get(0)).longValue());
            zza(15, ((Long)arraylist.get(1)).longValue());
            if (arraylist.size() >= 3)
            {
                zza(16, ((Long)arraylist.get(2)).longValue());
            }
        }
        catch (zza zza2) { }
        try
        {
            zza(34, zzf(context));
        }
        catch (zza zza1) { }
        try
        {
            zza(35, zzg(context).longValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        context;
    }


    private class zza extends Exception
    {

        public zza()
        {
        }

        public zza(Throwable throwable)
        {
            super(throwable);
        }
    }

}
