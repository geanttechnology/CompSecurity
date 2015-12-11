// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, ew, et, cd

final class aa
    implements af
{

    aa()
    {
    }

    public final void a(ew ew1, Map map)
    {
        ew1 = ew1.b();
        if (ew1 == null)
        {
            et.d("A GMSG tried to close something that wasn't an overlay.");
            return;
        } else
        {
            ((cd) (ew1)).a.finish();
            return;
        }
    }
}
