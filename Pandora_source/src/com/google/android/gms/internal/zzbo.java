// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Looper;
import android.webkit.WebView;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzbs, zzgd

public abstract class zzbo
    implements zzbs
{

    public zzbo()
    {
    }

    public void zza(zzgd zzgd1, Map map)
    {
        if (!Looper.myLooper().equals(Looper.getMainLooper()))
        {
            zzgd1.getWebView().post(new Runnable(zzgd1, map) {

                final zzgd a;
                final Map b;
                final zzbo c;

                public void run()
                {
                    c.zza(a, b);
                }

            
            {
                c = zzbo.this;
                a = zzgd1;
                b = map;
                super();
            }
            });
            return;
        } else
        {
            zzb(zzgd1, map);
            return;
        }
    }

    abstract void zzb(zzgd zzgd1, Map map);
}
