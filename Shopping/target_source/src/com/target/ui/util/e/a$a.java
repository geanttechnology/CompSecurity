// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.e;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.ref.WeakReference;

// Referenced classes of package com.target.ui.util.e:
//            a

private static final class ce
    implements Runnable
{

    public static final int POST_DELAY_MS = 50;
    WeakReference contextRef;
    WeakReference viewRef;

    public void run()
    {
        Context context = (Context)contextRef.get();
        View view = (View)viewRef.get();
        if (context == null || view == null)
        {
            return;
        } else
        {
            com.target.ui.util.e.a.a(context).showSoftInput(view, 0);
            return;
        }
    }

    public ce(Context context, View view)
    {
        contextRef = new WeakReference(context);
        viewRef = new WeakReference(view);
    }
}
