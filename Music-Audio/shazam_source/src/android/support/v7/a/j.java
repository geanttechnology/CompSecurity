// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v7.a:
//            l, g

class j extends l
{

    j(Context context, Window window, g g)
    {
        super(context, window, g);
    }

    final View b(View view, String s, Context context, AttributeSet attributeset)
    {
        View view1 = super.b(view, s, context, attributeset);
        if (view1 != null)
        {
            return view1;
        }
        if (c instanceof android.view.LayoutInflater.Factory2)
        {
            return ((android.view.LayoutInflater.Factory2)c).onCreateView(view, s, context, attributeset);
        } else
        {
            return null;
        }
    }
}
