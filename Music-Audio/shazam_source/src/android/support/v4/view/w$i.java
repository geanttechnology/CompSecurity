// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            w, al, ak, s

static final class  extends 
{

    public final ak a(View view, ak ak)
    {
        Object obj = ak;
        if (ak instanceof al)
        {
            android.view.WindowInsets windowinsets = ((al)ak).a;
            view = view.onApplyWindowInsets(windowinsets);
            obj = ak;
            if (view != windowinsets)
            {
                obj = new al(view);
            }
        }
        return ((ak) (obj));
    }

    public final void a(View view, s s)
    {
        view.setOnApplyWindowInsetsListener(new <init>(s));
    }

    public final void f(View view, float f1)
    {
        view.setElevation(f1);
    }

    public final void q(View view)
    {
        view.requestApplyInsets();
    }

    public final void t(View view)
    {
        view.stopNestedScroll();
    }

    ()
    {
    }
}
