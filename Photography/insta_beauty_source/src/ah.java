// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.internal.widget.ActionBarContainer;
import android.view.View;

class ah
    implements ViewPropertyAnimatorUpdateListener
{

    final ae a;

    ah(ae ae1)
    {
        a = ae1;
        super();
    }

    public void onAnimationUpdate(View view)
    {
        ((View)ae.c(a).getParent()).invalidate();
    }
}
