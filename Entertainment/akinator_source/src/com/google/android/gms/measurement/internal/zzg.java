// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzv, zzp, zzag, EventParams

public class zzg
{

    final String mName;
    final long zzZH;
    final String zzaLl;
    final String zzaMb;
    final long zzaMc;
    final EventParams zzaMd;

    zzg(zzv zzv1, String s, String s1, String s2, long l, long l1, Bundle bundle)
    {
        zzx.zzcr(s1);
        zzx.zzcr(s2);
        zzaLl = s1;
        mName = s2;
        s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = null;
        }
        zzaMb = s1;
        zzZH = l;
        zzaMc = l1;
        if (zzaMc != 0L && zzaMc > zzZH)
        {
            zzv1.zzyd().zzzL().zzec("Event created with reverse previous/current timestamps");
        }
        if (bundle != null && !bundle.isEmpty())
        {
            s = new Bundle(bundle);
            for (s1 = s.keySet().iterator(); s1.hasNext();)
            {
                s2 = (String)s1.next();
                if (s2 == null)
                {
                    s1.remove();
                } else
                {
                    bundle = ((Bundle) (zzv1.zzzq().zzC(s.get(s2))));
                    if (bundle == null)
                    {
                        s1.remove();
                    } else
                    {
                        zzv1.zzzq().zza(s, s2, bundle);
                    }
                }
            }

            zzaMd = new EventParams(s);
            return;
        } else
        {
            zzaMd = new EventParams(new Bundle());
            return;
        }
    }

    private zzg(zzv zzv1, String s, String s1, String s2, long l, long l1, EventParams eventparams)
    {
        zzx.zzcr(s1);
        zzx.zzcr(s2);
        zzx.zzw(eventparams);
        zzaLl = s1;
        mName = s2;
        s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = null;
        }
        zzaMb = s1;
        zzZH = l;
        zzaMc = l1;
        if (zzaMc != 0L && zzaMc > zzZH)
        {
            zzv1.zzyd().zzzL().zzec("Event created with reverse previous/current timestamps");
        }
        zzaMd = eventparams;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Event{");
        stringbuilder.append("appId='").append(zzaLl).append('\'');
        stringbuilder.append(", name='").append(mName).append('\'');
        stringbuilder.append(", params=").append(zzaMd);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    zzg zza(zzv zzv1, long l)
    {
        return new zzg(zzv1, zzaMb, zzaLl, mName, zzZH, l, zzaMd);
    }
}
