// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public final class bls extends blr
{

    private Context a;
    private Animation b;

    public bls(Context context)
    {
        a = (Context)b.a(context);
    }

    public final Animation a()
    {
        if (b == null)
        {
            b = AnimationUtils.loadAnimation(a, 0x10a0000);
            b.setDuration(a.getResources().getInteger(0x10e0000));
        }
        return b;
    }
}
