// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzrb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbg, zzcp, DataLayer, zzdf, 
//            zzbw, zzcb, zzbo, zzah

public class Container
{

    private final Context mContext;
    private final String zzaVQ;
    private final DataLayer zzaVR;
    private zzcp zzaVS;
    private Map zzaVT;
    private Map zzaVU;
    private volatile long zzaVV;
    private volatile String zzaVW;

    Container(Context context, DataLayer datalayer, String s, long l, com.google.android.gms.internal.zzaf.zzj zzj)
    {
        zzaVT = new HashMap();
        zzaVU = new HashMap();
        zzaVW = "";
        mContext = context;
        zzaVR = datalayer;
        zzaVQ = s;
        zzaVV = l;
        zza(zzj.zziR);
        if (zzj.zziQ != null)
        {
            zza(zzj.zziQ);
        }
    }

    Container(Context context, DataLayer datalayer, String s, long l, com.google.android.gms.internal.zzrb.zzc zzc)
    {
        zzaVT = new HashMap();
        zzaVU = new HashMap();
        zzaVW = "";
        mContext = context;
        zzaVR = datalayer;
        zzaVQ = s;
        zzaVV = l;
        zza(zzc);
    }

    private zzcp zzCu()
    {
        this;
        JVM INSTR monitorenter ;
        zzcp zzcp1 = zzaVS;
        this;
        JVM INSTR monitorexit ;
        return zzcp1;
        Exception exception;
        exception;
        throw exception;
    }

    private void zza(com.google.android.gms.internal.zzaf.zzf zzf)
    {
        if (zzf == null)
        {
            throw new NullPointerException();
        }
        com.google.android.gms.internal.zzrb.zzc zzc;
        try
        {
            zzc = zzrb.zzb(zzf);
        }
        catch (com.google.android.gms.internal.zzrb.zzg zzg)
        {
            zzbg.e((new StringBuilder("Not loading resource: ")).append(zzf).append(" because it is invalid: ").append(zzg.toString()).toString());
            return;
        }
        zza(zzc);
    }

    private void zza(com.google.android.gms.internal.zzrb.zzc zzc)
    {
        zzaVW = zzc.getVersion();
        zzah zzah = zzeD(zzaVW);
        zza(new zzcp(mContext, zzc, zzaVR, new zza(null), new zzb(null), zzah));
        if (getBoolean("_gtm.loadEventEnabled"))
        {
            zzaVR.pushEvent("gtm.load", DataLayer.mapOf(new Object[] {
                "gtm.id", zzaVQ
            }));
        }
    }

    private void zza(zzcp zzcp1)
    {
        this;
        JVM INSTR monitorenter ;
        zzaVS = zzcp1;
        this;
        JVM INSTR monitorexit ;
        return;
        zzcp1;
        throw zzcp1;
    }

    private void zza(com.google.android.gms.internal.zzaf.zzi azzi[])
    {
        ArrayList arraylist = new ArrayList();
        int j = azzi.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(azzi[i]);
        }

        zzCu().zzA(arraylist);
    }

    public boolean getBoolean(String s)
    {
        zzcp zzcp1 = zzCu();
        if (zzcp1 == null)
        {
            zzbg.e("getBoolean called for closed container.");
            return zzdf.zzDU().booleanValue();
        }
        boolean flag;
        try
        {
            flag = zzdf.zzk((com.google.android.gms.internal.zzag.zza)zzcp1.zzeY(s).getObject()).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzbg.e((new StringBuilder("Calling getBoolean() threw an exception: ")).append(s.getMessage()).append(" Returning default value.").toString());
            return zzdf.zzDU().booleanValue();
        }
        return flag;
    }

    public String getContainerId()
    {
        return zzaVQ;
    }

    public double getDouble(String s)
    {
        zzcp zzcp1 = zzCu();
        if (zzcp1 == null)
        {
            zzbg.e("getDouble called for closed container.");
            return zzdf.zzDT().doubleValue();
        }
        double d;
        try
        {
            d = zzdf.zzj((com.google.android.gms.internal.zzag.zza)zzcp1.zzeY(s).getObject()).doubleValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzbg.e((new StringBuilder("Calling getDouble() threw an exception: ")).append(s.getMessage()).append(" Returning default value.").toString());
            return zzdf.zzDT().doubleValue();
        }
        return d;
    }

    public long getLastRefreshTime()
    {
        return zzaVV;
    }

    public long getLong(String s)
    {
        zzcp zzcp1 = zzCu();
        if (zzcp1 == null)
        {
            zzbg.e("getLong called for closed container.");
            return zzdf.zzDS().longValue();
        }
        long l;
        try
        {
            l = zzdf.zzi((com.google.android.gms.internal.zzag.zza)zzcp1.zzeY(s).getObject()).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzbg.e((new StringBuilder("Calling getLong() threw an exception: ")).append(s.getMessage()).append(" Returning default value.").toString());
            return zzdf.zzDS().longValue();
        }
        return l;
    }

    public String getString(String s)
    {
        zzcp zzcp1 = zzCu();
        if (zzcp1 == null)
        {
            zzbg.e("getString called for closed container.");
            return zzdf.zzDW();
        }
        try
        {
            s = zzdf.zzg((com.google.android.gms.internal.zzag.zza)zzcp1.zzeY(s).getObject());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzbg.e((new StringBuilder("Calling getString() threw an exception: ")).append(s.getMessage()).append(" Returning default value.").toString());
            return zzdf.zzDW();
        }
        return s;
    }

    public boolean isDefault()
    {
        return getLastRefreshTime() == 0L;
    }

    public void registerFunctionCallMacroCallback(String s, FunctionCallMacroCallback functioncallmacrocallback)
    {
        if (functioncallmacrocallback == null)
        {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (zzaVT)
        {
            zzaVT.put(s, functioncallmacrocallback);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void registerFunctionCallTagCallback(String s, FunctionCallTagCallback functioncalltagcallback)
    {
        if (functioncalltagcallback == null)
        {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (zzaVU)
        {
            zzaVU.put(s, functioncalltagcallback);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    void release()
    {
        zzaVS = null;
    }

    public void unregisterFunctionCallMacroCallback(String s)
    {
        synchronized (zzaVT)
        {
            zzaVT.remove(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void unregisterFunctionCallTagCallback(String s)
    {
        synchronized (zzaVU)
        {
            zzaVU.remove(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    String zzCt()
    {
        return zzaVW;
    }

    FunctionCallMacroCallback zzeA(String s)
    {
        synchronized (zzaVT)
        {
            s = (FunctionCallMacroCallback)zzaVT.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    FunctionCallTagCallback zzeB(String s)
    {
        synchronized (zzaVU)
        {
            s = (FunctionCallTagCallback)zzaVU.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    void zzeC(String s)
    {
        zzCu().zzeC(s);
    }

    zzah zzeD(String s)
    {
        zzcb.zzDm().zzDn().equals(zzcb.zza.zzaYa);
        return new zzbo();
    }

    private class zza
        implements zzt.zza
    {

        final Container zzaVX;

        public Object zzc(String s, Map map)
        {
            FunctionCallMacroCallback functioncallmacrocallback = zzaVX.zzeA(s);
            if (functioncallmacrocallback == null)
            {
                return null;
            } else
            {
                return functioncallmacrocallback.getValue(s, map);
            }
        }

        private zza()
        {
            zzaVX = Container.this;
            super();
        }

        zza(_cls1 _pcls1)
        {
            this();
        }
    }


    private class zzb
        implements zzt.zza
    {

        final Container zzaVX;

        public Object zzc(String s, Map map)
        {
            FunctionCallTagCallback functioncalltagcallback = zzaVX.zzeB(s);
            if (functioncalltagcallback != null)
            {
                functioncalltagcallback.execute(s, map);
            }
            return zzdf.zzDW();
        }

        private zzb()
        {
            zzaVX = Container.this;
            super();
        }

        zzb(_cls1 _pcls1)
        {
            this();
        }
    }


    private class FunctionCallMacroCallback
    {

        public abstract Object getValue(String s, Map map);
    }


    private class FunctionCallTagCallback
    {

        public abstract void execute(String s, Map map);
    }

}
