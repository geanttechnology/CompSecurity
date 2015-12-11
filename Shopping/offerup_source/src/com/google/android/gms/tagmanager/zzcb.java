// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbg

class zzcb
{

    private static zzcb zzaXU;
    private volatile String zzaVQ;
    private volatile zza zzaXV;
    private volatile String zzaXW;
    private volatile String zzaXX;

    zzcb()
    {
        clear();
    }

    static zzcb zzDm()
    {
        com/google/android/gms/tagmanager/zzcb;
        JVM INSTR monitorenter ;
        zzcb zzcb1;
        if (zzaXU == null)
        {
            zzaXU = new zzcb();
        }
        zzcb1 = zzaXU;
        com/google/android/gms/tagmanager/zzcb;
        JVM INSTR monitorexit ;
        return zzcb1;
        Exception exception;
        exception;
        com/google/android/gms/tagmanager/zzcb;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private String zzeV(String s)
    {
        return s.split("&")[0].split("=")[1];
    }

    private String zzn(Uri uri)
    {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    void clear()
    {
        zzaXV = zza.zzaXY;
        zzaXW = null;
        zzaVQ = null;
        zzaXX = null;
    }

    String getContainerId()
    {
        return zzaVQ;
    }

    zza zzDn()
    {
        return zzaXV;
    }

    String zzDo()
    {
        return zzaXW;
    }

    boolean zzm(Uri uri)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        String s = URLDecoder.decode(uri.toString(), "UTF-8");
        if (!s.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) goto _L2; else goto _L1
_L1:
        zzbg.v((new StringBuilder("Container preview url: ")).append(s).toString());
        if (!s.matches(".*?&gtm_debug=x$")) goto _L4; else goto _L3
_L3:
        zzaXV = zza.zzaYa;
_L6:
        zzaXX = zzn(uri);
        if (zzaXV == zza.zzaXZ || zzaXV == zza.zzaYa)
        {
            zzaXW = (new StringBuilder("/r?")).append(zzaXX).toString();
        }
        zzaVQ = zzeV(zzaXX);
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
        uri;
        flag = false;
          goto _L5
_L4:
        zzaXV = zza.zzaXZ;
          goto _L6
        uri;
        throw uri;
_L2:
label0:
        {
            if (!s.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
            {
                break label0;
            }
            if (!zzeV(uri.getQuery()).equals(zzaVQ))
            {
                break MISSING_BLOCK_LABEL_235;
            }
            zzbg.v((new StringBuilder("Exit preview mode for container: ")).append(zzaVQ).toString());
            zzaXV = zza.zzaXY;
            zzaXW = null;
        }
          goto _L5
        zzbg.zzaH((new StringBuilder("Invalid preview uri: ")).append(s).toString());
        flag = false;
          goto _L5
        flag = false;
          goto _L5
    }

    private class zza extends Enum
    {

        public static final zza zzaXY;
        public static final zza zzaXZ;
        public static final zza zzaYa;
        private static final zza zzaYb[];

        public static zza valueOf(String s)
        {
            return (zza)Enum.valueOf(com/google/android/gms/tagmanager/zzcb$zza, s);
        }

        public static zza[] values()
        {
            return (zza[])zzaYb.clone();
        }

        static 
        {
            zzaXY = new zza("NONE", 0);
            zzaXZ = new zza("CONTAINER", 1);
            zzaYa = new zza("CONTAINER_DEBUG", 2);
            zzaYb = (new zza[] {
                zzaXY, zzaXZ, zzaYa
            });
        }

        private zza(String s, int i)
        {
            super(s, i);
        }
    }

}
