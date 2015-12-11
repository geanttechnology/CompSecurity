// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package android.support.v4.view:
//            ad, ah

static class ator extends ator
{

    public final void a(ad ad1, View view, ah ah)
    {
        if (ah != null)
        {
            view.animate().setListener(new <init>(ah, view));
            return;
        } else
        {
            view.animate().setListener(null);
            return;
        }
    }

    ator()
    {
    }
}
