// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.internal:
//            zzby, zzbu, zzcd, zzid, 
//            zzcg

public class zzca
{

    final Context mContext;
    final String zzqV;
    String zzvB;
    BlockingQueue zzvD;
    ExecutorService zzvE;
    LinkedHashMap zzvF;
    Map zzvG;
    private AtomicBoolean zzvH;
    private File zzvI;

    public zzca(Context context, String s, String s1, Map map)
    {
        zzvF = new LinkedHashMap();
        zzvG = new HashMap();
        mContext = context;
        zzqV = s;
        zzvB = s1;
        zzvH = new AtomicBoolean(false);
        zzvH.set(((Boolean)zzby.zzuS.get()).booleanValue());
        if (zzvH.get())
        {
            context = Environment.getExternalStorageDirectory();
            if (context != null)
            {
                zzvI = new File(context, "sdk_csi_data.txt");
            }
        }
        for (context = map.entrySet().iterator(); context.hasNext(); zzvF.put(s.getKey(), s.getValue()))
        {
            s = (java.util.Map.Entry)context.next();
        }

        zzvD = new ArrayBlockingQueue(30);
        zzvE = Executors.newSingleThreadExecutor();
        zzvE.execute(new Runnable() {

            final zzca zzvJ;

            public void run()
            {
                zzca.zza(zzvJ);
            }

            
            {
                zzvJ = zzca.this;
                super();
            }
        });
        zzvG.put("action", zzcd.zzvL);
        zzvG.put("ad_format", zzcd.zzvL);
        zzvG.put("e", zzcd.zzvM);
    }

    static void zza(zzca zzca1)
    {
        zzca1.zzdj();
    }

    private void zza(File file, String s)
    {
        if (file == null) goto _L2; else goto _L1
_L1:
        FileOutputStream fileoutputstream = new FileOutputStream(file, true);
        file = fileoutputstream;
        fileoutputstream.write(s.getBytes());
        file = fileoutputstream;
        fileoutputstream.write(10);
        fileoutputstream.close();
_L4:
        return;
        file;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", file);
        return;
        IOException ioexception;
        ioexception;
        s = null;
_L7:
        file = s;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", ioexception);
        if (s == null) goto _L4; else goto _L3
_L3:
        try
        {
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", file);
        }
        return;
        s;
        file = null;
_L6:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", file);
            }
        }
        throw s;
_L2:
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
        return;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        ioexception;
        s = fileoutputstream;
          goto _L7
    }

    private void zzc(Map map, String s)
    {
        map = zza(zzvB, map, s);
        if (zzvH.get())
        {
            zza(zzvI, map);
            return;
        } else
        {
            zzp.zzbv().zzc(mContext, zzqV, map);
            return;
        }
    }

    private void zzdj()
    {
        do
        {
            zzcg zzcg1;
            String s;
            do
            {
                zzcg1 = (zzcg)zzvD.take();
                s = zzcg1.zzdp();
            } while (TextUtils.isEmpty(s));
            zzc(zza(zzvF, zzcg1.zzn()), s);
        } while (true);
        InterruptedException interruptedexception;
        interruptedexception;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter:reporter interrupted", interruptedexception);
        return;
    }

    public zzcd zzR(String s)
    {
        s = (zzcd)zzvG.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return zzcd.zzvK;
        }
    }

    String zza(String s, Map map, String s1)
    {
        s = Uri.parse(s).buildUpon();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); s.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        s = new StringBuilder(s.build().toString());
        s.append("&it=").append(s1);
        return s.toString();
    }

    Map zza(Map map, Map map1)
    {
        map = new LinkedHashMap(map);
        if (map1 == null)
        {
            return map;
        }
        String s;
        Object obj;
        String s1;
        for (map1 = map1.entrySet().iterator(); map1.hasNext(); map.put(s, zzR(s).zzd(s1, ((String) (obj)))))
        {
            obj = (java.util.Map.Entry)map1.next();
            s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            s1 = (String)map.get(s);
        }

        return map;
    }

    public boolean zza(zzcg zzcg1)
    {
        return zzvD.offer(zzcg1);
    }

    public void zzb(List list)
    {
        if (list != null && !list.isEmpty())
        {
            zzvF.put("e", TextUtils.join(",", list));
        }
    }
}
