// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.d;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            z, RecyclerView

class t> extends a
{

    final z a;

    public void onInitializeAccessibilityNodeInfo(View view, d d)
    {
        super.onInitializeAccessibilityNodeInfo(view, d);
        if (a.a.getLayoutManager() != null)
        {
            a.a.getLayoutManager().a(view, d);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        if (a.a.getLayoutManager() != null)
        {
            return a.a.getLayoutManager().a(view, i, bundle);
        } else
        {
            return false;
        }
    }

    clerView.h(z z1)
    {
        a = z1;
        super();
    }
}
