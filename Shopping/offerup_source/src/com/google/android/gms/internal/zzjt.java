// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzse, zzju

public class zzjt
{

    private static DocumentSection zza(String s, zzox.zzc zzc)
    {
        s = (new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(s)).zzM(true).zzbB(s).zzbA("blob").zzlt();
        return new DocumentSection(zzse.zzf(zzc), s);
    }

    public static UsageInfo zza(Action action, long l, String s, int i)
    {
        boolean flag = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzlx());
        Object obj = bundle.getBundle("object");
        String s1;
        String s2;
        byte byte0;
        if (((Bundle) (obj)).containsKey("id"))
        {
            action = Uri.parse(((Bundle) (obj)).getString("id"));
        } else
        {
            action = null;
        }
        s1 = ((Bundle) (obj)).getString("name");
        s2 = ((Bundle) (obj)).getString("type");
        obj = zzju.zza(s, Uri.parse(((Bundle) (obj)).getString("url")));
        action = UsageInfo.zza(((android.content.Intent) (obj)), s1, action, s2, null);
        if (bundle.containsKey(".private:ssbContext"))
        {
            action.zza(DocumentSection.zzh(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName"))
        {
            action.zzb(new Account(bundle.getString(".private:accountName"), "com.google"));
            bundle.remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly"))
        {
            byte0 = 4;
            bundle.remove(".private:isContextOnly");
        } else
        {
            byte0 = 0;
        }
        if (bundle.containsKey(".private:isDeviceOnly"))
        {
            flag = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        action.zza(zza(".private:action", zzf(bundle)));
        return (new com.google.android.gms.appdatasearch.UsageInfo.zza()).zza(UsageInfo.zza(s, ((android.content.Intent) (obj)))).zzw(l).zzan(byte0).zza(action.zzlo()).zzO(flag).zzao(i).zzlv();
    }

    static zzox.zzc zzf(Bundle bundle)
    {
        zzox.zzc zzc = new zzox.zzc();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            zzox.zzb zzb = new zzox.zzb();
            zzb.name = s;
            zzb.zzaCZ = new zzox.zzd();
            if (obj instanceof String)
            {
                zzb.zzaCZ.zzagS = (String)obj;
            } else
            if (obj instanceof Bundle)
            {
                zzb.zzaCZ.zzaDe = zzf((Bundle)obj);
            } else
            {
                Log.e("SearchIndex", (new StringBuilder("Unsupported value: ")).append(obj).toString());
            }
            arraylist.add(zzb);
        }
        if (bundle.containsKey("type"))
        {
            zzc.type = bundle.getString("type");
        }
        zzc.zzaDa = (zzox.zzb[])arraylist.toArray(new zzox.zzb[arraylist.size()]);
        return zzc;
    }
}
