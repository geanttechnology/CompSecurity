// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.google.android.gms.tagmanager:
//            DataLayer, zzd, zzs, zzbg, 
//            zzw, zzcu, zzo, zzct, 
//            zzp, zzcb

public class TagManager
{

    private static TagManager zzaZr;
    private final Context mContext;
    private final DataLayer zzaVR;
    private final zzs zzaYl;
    private final zza zzaZo;
    private final zzct zzaZp;
    private final ConcurrentMap zzaZq;

    TagManager(Context context, zza zza1, DataLayer datalayer, zzct zzct1)
    {
        if (context == null)
        {
            throw new NullPointerException("context cannot be null");
        } else
        {
            mContext = context.getApplicationContext();
            zzaZp = zzct1;
            zzaZo = zza1;
            zzaZq = new ConcurrentHashMap();
            zzaVR = datalayer;
            zzaVR.zza(new _cls1());
            zzaVR.zza(new zzd(mContext));
            zzaYl = new zzs();
            zzDL();
            return;
        }
    }

    public static TagManager getInstance(Context context)
    {
        com/google/android/gms/tagmanager/TagManager;
        JVM INSTR monitorenter ;
        if (zzaZr != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        zzbg.e("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
        context;
        com/google/android/gms/tagmanager/TagManager;
        JVM INSTR monitorexit ;
        throw context;
        zzaZr = new TagManager(context, new _cls2(), new DataLayer(new zzw(context)), zzcu.zzDG());
        context = zzaZr;
        com/google/android/gms/tagmanager/TagManager;
        JVM INSTR monitorexit ;
        return context;
    }

    private void zzDL()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            mContext.registerComponentCallbacks(new _cls3());
        }
    }

    static void zza(TagManager tagmanager, String s)
    {
        tagmanager.zzfa(s);
    }

    private void zzfa(String s)
    {
        for (Iterator iterator = zzaZq.keySet().iterator(); iterator.hasNext(); ((zzo)iterator.next()).zzeC(s)) { }
    }

    public void dispatch()
    {
        zzaZp.dispatch();
    }

    public DataLayer getDataLayer()
    {
        return zzaVR;
    }

    public PendingResult loadContainerDefaultOnly(String s, int i)
    {
        s = zzaZo.zza(mContext, this, null, s, i, zzaYl);
        s.zzCy();
        return s;
    }

    public PendingResult loadContainerDefaultOnly(String s, int i, Handler handler)
    {
        s = zzaZo.zza(mContext, this, handler.getLooper(), s, i, zzaYl);
        s.zzCy();
        return s;
    }

    public PendingResult loadContainerPreferFresh(String s, int i)
    {
        s = zzaZo.zza(mContext, this, null, s, i, zzaYl);
        s.zzCA();
        return s;
    }

    public PendingResult loadContainerPreferFresh(String s, int i, Handler handler)
    {
        s = zzaZo.zza(mContext, this, handler.getLooper(), s, i, zzaYl);
        s.zzCA();
        return s;
    }

    public PendingResult loadContainerPreferNonDefault(String s, int i)
    {
        s = zzaZo.zza(mContext, this, null, s, i, zzaYl);
        s.zzCz();
        return s;
    }

    public PendingResult loadContainerPreferNonDefault(String s, int i, Handler handler)
    {
        s = zzaZo.zza(mContext, this, handler.getLooper(), s, i, zzaYl);
        s.zzCz();
        return s;
    }

    public void setVerboseLoggingEnabled(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 5;
        }
        zzbg.setLogLevel(byte0);
    }

    void zza(zzo zzo1)
    {
        zzaZq.put(zzo1, Boolean.valueOf(true));
    }

    boolean zzb(zzo zzo1)
    {
        return zzaZq.remove(zzo1) != null;
    }

    boolean zzm(Uri uri)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = zzcb.zzDm();
        if (!((zzcb) (obj)).zzm(uri)) goto _L2; else goto _L1
_L1:
        int i;
        uri = ((zzcb) (obj)).getContainerId();
        i = _cls4.zzaZt[((zzcb) (obj)).zzDn().ordinal()];
        i;
        JVM INSTR tableswitch 1 3: default 60
    //                   1 68
    //                   2 130
    //                   3 130;
           goto _L3 _L4 _L5 _L5
_L3:
        boolean flag = true;
_L9:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        obj = zzaZq.keySet().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            zzo zzo1 = (zzo)((Iterator) (obj)).next();
            if (zzo1.getContainerId().equals(uri))
            {
                zzo1.zzeE(null);
                zzo1.refresh();
            }
        }
          goto _L3
        uri;
        throw uri;
_L5:
        Iterator iterator = zzaZq.keySet().iterator();
_L7:
        zzo zzo2;
        while (iterator.hasNext()) 
        {
            zzo2 = (zzo)iterator.next();
            if (!zzo2.getContainerId().equals(uri))
            {
                continue; /* Loop/switch isn't completed */
            }
            zzo2.zzeE(((zzcb) (obj)).zzDo());
            zzo2.refresh();
        }
          goto _L3
        if (zzo2.zzCv() == null) goto _L7; else goto _L6
_L6:
        zzo2.zzeE(null);
        zzo2.refresh();
        if (true) goto _L7; else goto _L8
_L8:
          goto _L3
_L2:
        flag = false;
          goto _L9
    }

    private class _cls1
        implements DataLayer.zzb
    {

        final TagManager zzaZs;

        public void zzJ(Map map)
        {
            map = ((Map) (map.get("event")));
            if (map != null)
            {
                TagManager.zza(zzaZs, map.toString());
            }
        }

        _cls1()
        {
            zzaZs = TagManager.this;
            super();
        }
    }


    private class _cls2
        implements zza
    {

        public final zzp zza(Context context, TagManager tagmanager, Looper looper, String s, int i, zzs zzs1)
        {
            return new zzp(context, tagmanager, looper, s, i, zzs1);
        }

        _cls2()
        {
        }
    }


    private class _cls3
        implements ComponentCallbacks2
    {

        final TagManager zzaZs;

        public void onConfigurationChanged(Configuration configuration)
        {
        }

        public void onLowMemory()
        {
        }

        public void onTrimMemory(int i)
        {
            if (i == 20)
            {
                zzaZs.dispatch();
            }
        }

        _cls3()
        {
            zzaZs = TagManager.this;
            super();
        }
    }


    private class zza
    {

        public abstract zzp zza(Context context, TagManager tagmanager, Looper looper, String s, int i, zzs zzs1);
    }


    private class _cls4
    {

        static final int zzaZt[];

        static 
        {
            zzaZt = new int[zzcb.zza.values().length];
            try
            {
                zzaZt[zzcb.zza.zzaXY.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                zzaZt[zzcb.zza.zzaXZ.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                zzaZt[zzcb.zza.zzaYa.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
