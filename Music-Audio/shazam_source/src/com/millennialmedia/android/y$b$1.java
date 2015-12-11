// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            y

final class a
    implements android.view.nClickListener
{

    final a a;

    public final void onClick(View view)
    {
        view = (y)a(a).get();
        if (view == null)
        {
            return;
        }
        a a1 = y.a(view);
        boolean flag;
        if (!y.a(view).a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a1.a = flag;
        y.b(view);
    }

    ( )
    {
        a = ;
        super();
    }
}
