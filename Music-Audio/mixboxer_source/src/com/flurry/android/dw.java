// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            av

final class dw
{

    private static final dw fF = new dw();
    private final Map fG = new HashMap();

    private dw()
    {
    }

    public static av e(Context context, String s)
    {
        if (context == null || TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return fF.f(context, s);
        }
    }

    private av f(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        av av2 = (av)fG.get(s);
        av av1;
        av1 = av2;
        if (av2 != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        av1 = new av(context.getApplicationContext(), s);
        fG.put(s, av1);
        this;
        JVM INSTR monitorexit ;
        return av1;
        context;
        throw context;
    }

}
