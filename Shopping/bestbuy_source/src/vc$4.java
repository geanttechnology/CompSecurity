// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import java.util.Map;

final class >
    implements vd
{

    public void a(gu gu1, Map map)
    {
        String s;
        s = (String)map.get("u");
        if (s == null)
        {
            acb.e("URL missing from click GMSG.");
            return;
        }
        map = Uri.parse(s);
        Object obj = gu1.h();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!((aea) (obj)).b(map))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = ((aea) (obj)).a(map, gu1.getContext());
        map = ((Map) (obj));
_L2:
        map = map.toString();
        (new abz(gu1.getContext(), gu1.i().b, map)).e();
        return;
        aec aec1;
        aec1;
        acb.e((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    >()
    {
    }
}
