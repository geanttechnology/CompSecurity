// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import java.util.Map;

final class >
    implements vd
{

    public void a(gu gu1, Map map)
    {
        map = (String)map.get("u");
        if (map == null)
        {
            acb.e("URL missing from httpTrack GMSG.");
            return;
        } else
        {
            (new abz(gu1.getContext(), gu1.i().b, map)).e();
            return;
        }
    }

    >()
    {
    }
}
