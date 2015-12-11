// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.WindowInsets;

// Referenced classes of package android.support.v4.view:
//            do, ba

final class bu
    implements android.view.View.OnApplyWindowInsetsListener
{

    private ba a;

    bu(ba ba1)
    {
        a = ba1;
        super();
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowinsets)
    {
        windowinsets = new do(windowinsets);
        return ((do)a.onApplyWindowInsets(view, windowinsets)).g();
    }
}
