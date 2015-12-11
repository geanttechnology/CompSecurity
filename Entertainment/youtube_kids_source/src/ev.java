// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewPropertyAnimator;

class ev extends es
{

    ev()
    {
    }

    public final void a(ep ep, View view, fa fa)
    {
        if (fa != null)
        {
            view.animate().setListener(new ez(fa, view));
            return;
        } else
        {
            view.animate().setListener(null);
            return;
        }
    }
}
