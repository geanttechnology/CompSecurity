// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            tq, ul

public class qp
{

    private final ul a;
    private final boolean b;
    private final String c;

    public qp(ul ul1, Map map)
    {
        a = ul1;
        c = (String)map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange"))
        {
            b = Boolean.parseBoolean((String)map.get("allowOrientationChange"));
            return;
        } else
        {
            b = true;
            return;
        }
    }

    public void a()
    {
        if (a == null)
        {
            zzb.zzaE("AdWebView is null");
            return;
        }
        int i;
        if ("portrait".equalsIgnoreCase(c))
        {
            i = zzp.zzbz().b();
        } else
        if ("landscape".equalsIgnoreCase(c))
        {
            i = zzp.zzbz().a();
        } else
        if (b)
        {
            i = -1;
        } else
        {
            i = zzp.zzbz().c();
        }
        a.setRequestedOrientation(i);
    }
}
