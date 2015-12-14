// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.common.api.Releasable;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zziz

public abstract class zzdv
    implements Releasable
{

    protected zziz zzoM;

    public zzdv(zziz zziz)
    {
        zzoM = zziz;
    }

    static String zza(zzdv zzdv1, String s)
    {
        return zzdv1.zzad(s);
    }

    private String zzad(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 10: default 96
    //                   -1396664534: 239
    //                   -1347010958: 183
    //                   -918817863: 254
    //                   -659376217: 197
    //                   -642208130: 169
    //                   -354048396: 269
    //                   -32082395: 284
    //                   96784904: 155
    //                   580119100: 225
    //                   725497484: 211;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_284;
_L12:
        switch (byte0)
        {
        default:
            return "internal";

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return "internal";

        case 4: // '\004'
        case 5: // '\005'
            return "io";

        case 6: // '\006'
        case 7: // '\007'
            return "network";

        case 8: // '\b'
        case 9: // '\t'
            return "policy";
        }
_L9:
        if (s.equals("error"))
        {
            byte0 = 0;
        }
          goto _L12
_L6:
        if (s.equals("playerFailed"))
        {
            byte0 = 1;
        }
          goto _L12
_L3:
        if (s.equals("inProgress"))
        {
            byte0 = 2;
        }
          goto _L12
_L5:
        if (s.equals("contentLengthMissing"))
        {
            byte0 = 3;
        }
          goto _L12
_L11:
        if (s.equals("noCacheDir"))
        {
            byte0 = 4;
        }
          goto _L12
_L10:
        if (s.equals("expireFailed"))
        {
            byte0 = 5;
        }
          goto _L12
_L2:
        if (s.equals("badUrl"))
        {
            byte0 = 6;
        }
          goto _L12
_L4:
        if (s.equals("downloadTimeout"))
        {
            byte0 = 7;
        }
          goto _L12
_L7:
        if (s.equals("sizeExceeded"))
        {
            byte0 = 8;
        }
          goto _L12
        if (s.equals("externalAbort"))
        {
            byte0 = 9;
        }
          goto _L12
    }

    public abstract void abort();

    public void release()
    {
    }

    protected void zza(String s, String s1, int i)
    {
        zza.zzJt.post(new Runnable(s, s1, i) {

            final String zzyc;
            final String zzyd;
            final int zzyf;
            final zzdv zzyh;

            public void run()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("event", "precacheComplete");
                hashmap.put("src", zzyc);
                hashmap.put("cachedSrc", zzyd);
                hashmap.put("totalBytes", Integer.toString(zzyf));
                zzyh.zzoM.zzb("onPrecacheEvent", hashmap);
            }

            
            {
                zzyh = zzdv.this;
                zzyc = s;
                zzyd = s1;
                zzyf = i;
                super();
            }
        });
    }

    protected void zza(String s, String s1, int i, int j, boolean flag)
    {
        zza.zzJt.post(new Runnable(s, s1, i, j, flag) {

            final String zzyc;
            final String zzyd;
            final int zzye;
            final int zzyf;
            final boolean zzyg;
            final zzdv zzyh;

            public void run()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("event", "precacheProgress");
                hashmap.put("src", zzyc);
                hashmap.put("cachedSrc", zzyd);
                hashmap.put("bytesLoaded", Integer.toString(zzye));
                hashmap.put("totalBytes", Integer.toString(zzyf));
                String s2;
                if (zzyg)
                {
                    s2 = "1";
                } else
                {
                    s2 = "0";
                }
                hashmap.put("cacheReady", s2);
                zzyh.zzoM.zzb("onPrecacheEvent", hashmap);
            }

            
            {
                zzyh = zzdv.this;
                zzyc = s;
                zzyd = s1;
                zzye = i;
                zzyf = j;
                zzyg = flag;
                super();
            }
        });
    }

    protected void zza(String s, String s1, String s2, String s3)
    {
        zza.zzJt.post(new Runnable(s, s1, s2, s3) {

            final String zzyc;
            final String zzyd;
            final zzdv zzyh;
            final String zzyi;
            final String zzyj;

            public void run()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("event", "precacheCanceled");
                hashmap.put("src", zzyc);
                if (!TextUtils.isEmpty(zzyd))
                {
                    hashmap.put("cachedSrc", zzyd);
                }
                hashmap.put("type", com.google.android.gms.internal.zzdv.zza(zzyh, zzyi));
                hashmap.put("reason", zzyi);
                if (!TextUtils.isEmpty(zzyj))
                {
                    hashmap.put("message", zzyj);
                }
                zzyh.zzoM.zzb("onPrecacheEvent", hashmap);
            }

            
            {
                zzyh = zzdv.this;
                zzyc = s;
                zzyd = s1;
                zzyi = s2;
                zzyj = s3;
                super();
            }
        });
    }

    public abstract boolean zzab(String s);

    protected String zzac(String s)
    {
        return zzl.zzcF().zzaE(s);
    }
}
