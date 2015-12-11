// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewPropertyAnimator;

class es extends eq
{

    es()
    {
    }

    public final void a(ep ep, View view)
    {
        view.animate().cancel();
    }

    public final void a(ep ep, View view, float f)
    {
        view.animate().translationY(f);
    }

    public void a(ep ep, View view, fa fa)
    {
        view.setTag(0x7e000000, fa);
        ep = new et(ep);
        view.animate().setListener(new ey(ep, view));
    }
}
