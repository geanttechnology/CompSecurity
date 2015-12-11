// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.Map;

final class >
    implements vd
{

    public void a(gu gu1, Map map)
    {
        gu1 = gu1.d();
        if (gu1 == null)
        {
            acb.e("A GMSG tried to close something that wasn't an overlay.");
            return;
        } else
        {
            gu1.a();
            return;
        }
    }

    >()
    {
    }
}
