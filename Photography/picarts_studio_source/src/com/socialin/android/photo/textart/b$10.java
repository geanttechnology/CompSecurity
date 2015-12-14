// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.c;

// Referenced classes of package com.socialin.android.photo.textart:
//            b

final class a
    implements c
{

    private b a;

    public final void a(int i)
    {
        AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("textart:gradient color selected");
        b.b(a, i);
    }

    Utils(b b1)
    {
        a = b1;
        super();
    }
}
