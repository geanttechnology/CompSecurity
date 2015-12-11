// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            ox, qo, qn, qq, 
//            qp, ul

public class pd
    implements ox
{

    static final Map a;
    private final zze b;
    private final qo c;

    public pd(zze zze1, qo qo1)
    {
        b = zze1;
        c = qo1;
    }

    public void zza(ul ul, Map map)
    {
        String s = (String)map.get("a");
        int i = ((Integer)a.get(s)).intValue();
        if (i != 5 && b != null && !b.zzbe())
        {
            b.zzp(null);
            return;
        }
        switch (i)
        {
        case 2: // '\002'
        default:
            zzb.zzaD("Unknown MRAID command called.");
            return;

        case 1: // '\001'
            c.a(map);
            return;

        case 4: // '\004'
            (new qn(ul, map)).a();
            return;

        case 3: // '\003'
            (new qq(ul, map)).a();
            return;

        case 5: // '\005'
            (new qp(ul, map)).a();
            return;

        case 6: // '\006'
            c.a(true);
            break;
        }
    }

    static 
    {
        a = new HashMap();
        a.put("resize", Integer.valueOf(1));
        a.put("playVideo", Integer.valueOf(2));
        a.put("storePicture", Integer.valueOf(3));
        a.put("createCalendarEvent", Integer.valueOf(4));
        a.put("setOrientationProperties", Integer.valueOf(5));
        a.put("closeResizedAd", Integer.valueOf(6));
    }
}
