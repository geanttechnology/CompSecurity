// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.zzg;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzf, zzaf, zzy, zzr, 
//            zzb, zzan, zza, zzk, 
//            zzu, zzv, zzai, zzn

public class zzc
{

    private final zzf zzME;

    protected zzc(zzf zzf1)
    {
        zzx.zzw(zzf1);
        zzME = zzf1;
    }

    private void zza(int i, String s, Object obj, Object obj1, Object obj2)
    {
        zzaf zzaf1 = null;
        if (zzME != null)
        {
            zzaf1 = zzME.zziH();
        }
        if (zzaf1 != null)
        {
            zzaf1.zza(i, s, obj, obj1, obj2);
        } else
        {
            String s1 = (String)zzy.zzOg.get();
            if (Log.isLoggable(s1, i))
            {
                Log.println(i, s1, zzc(s, obj, obj1, obj2));
                return;
            }
        }
    }

    protected static String zzc(String s, Object obj, Object obj1, Object obj2)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        String s2 = zzi(obj);
        obj1 = zzi(obj1);
        obj2 = zzi(obj2);
        StringBuilder stringbuilder = new StringBuilder();
        s = "";
        if (!TextUtils.isEmpty(s1))
        {
            stringbuilder.append(s1);
            s = ": ";
        }
        obj = s;
        if (!TextUtils.isEmpty(s2))
        {
            stringbuilder.append(s);
            stringbuilder.append(s2);
            obj = ", ";
        }
        s = ((String) (obj));
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            stringbuilder.append(((String) (obj)));
            stringbuilder.append(((String) (obj1)));
            s = ", ";
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            stringbuilder.append(s);
            stringbuilder.append(((String) (obj2)));
        }
        return stringbuilder.toString();
    }

    private static String zzi(Object obj)
    {
        if (obj == null)
        {
            return "";
        }
        if (obj instanceof String)
        {
            return (String)obj;
        }
        if (obj instanceof Boolean)
        {
            if (obj == Boolean.TRUE)
            {
                return "true";
            } else
            {
                return "false";
            }
        }
        if (obj instanceof Throwable)
        {
            return ((Throwable)obj).toString();
        } else
        {
            return obj.toString();
        }
    }

    protected Context getContext()
    {
        return zzME.getContext();
    }

    public void zza(String s, Object obj)
    {
        zza(2, s, obj, null, null);
    }

    public void zza(String s, Object obj, Object obj1)
    {
        zza(2, s, obj, obj1, null);
    }

    public void zza(String s, Object obj, Object obj1, Object obj2)
    {
        zza(3, s, obj, obj1, obj2);
    }

    public void zzb(String s, Object obj)
    {
        zza(3, s, obj, null, null);
    }

    public void zzb(String s, Object obj, Object obj1)
    {
        zza(3, s, obj, obj1, null);
    }

    public void zzb(String s, Object obj, Object obj1, Object obj2)
    {
        zza(5, s, obj, obj1, obj2);
    }

    public void zzba(String s)
    {
        zza(2, s, null, null, null);
    }

    public void zzbb(String s)
    {
        zza(3, s, null, null, null);
    }

    public void zzbc(String s)
    {
        zza(4, s, null, null, null);
    }

    public void zzbd(String s)
    {
        zza(5, s, null, null, null);
    }

    public void zzbe(String s)
    {
        zza(6, s, null, null, null);
    }

    public void zzc(String s, Object obj)
    {
        zza(4, s, obj, null, null);
    }

    public void zzc(String s, Object obj, Object obj1)
    {
        zza(5, s, obj, obj1, null);
    }

    public void zzd(String s, Object obj)
    {
        zza(5, s, obj, null, null);
    }

    public void zzd(String s, Object obj, Object obj1)
    {
        zza(6, s, obj, obj1, null);
    }

    public void zze(String s, Object obj)
    {
        zza(6, s, obj, null, null);
    }

    public GoogleAnalytics zzhK()
    {
        return zzME.zziI();
    }

    protected zzb zzhP()
    {
        return zzME.zzhP();
    }

    protected zzan zzhQ()
    {
        return zzME.zzhQ();
    }

    protected zza zziA()
    {
        return zzME.zziK();
    }

    protected zzk zziB()
    {
        return zzME.zziB();
    }

    protected zzu zziC()
    {
        return zzME.zziC();
    }

    public boolean zziD()
    {
        return Log.isLoggable((String)zzy.zzOg.get(), 2);
    }

    public zzf zziq()
    {
        return zzME;
    }

    protected void zzir()
    {
        if (zziv().zzjA())
        {
            throw new IllegalStateException("Call only supported on the client side");
        } else
        {
            return;
        }
    }

    protected void zzis()
    {
        zzME.zzis();
    }

    protected zzmn zzit()
    {
        return zzME.zzit();
    }

    protected zzaf zziu()
    {
        return zzME.zziu();
    }

    protected zzr zziv()
    {
        return zzME.zziv();
    }

    protected zzg zziw()
    {
        return zzME.zziw();
    }

    protected zzv zzix()
    {
        return zzME.zzix();
    }

    protected zzai zziy()
    {
        return zzME.zziy();
    }

    protected zzn zziz()
    {
        return zzME.zziL();
    }
}
