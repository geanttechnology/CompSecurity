// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.bd;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            r

class b extends bd
{

    final r a;
    private boolean b;

    public void onAnimationCancel(View view)
    {
        b = true;
    }

    public void onAnimationEnd(View view)
    {
        if (!b)
        {
            r.a(a).setVisibility(8);
        }
    }

    (r r1)
    {
        a = r1;
        super();
        b = false;
    }
}
