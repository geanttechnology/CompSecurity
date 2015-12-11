// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            v, RecyclerView

final class t> extends a
{

    final v b;

    public final void a(View view, b b1)
    {
        super.a(view, b1);
        if (!b.a() && b.b.getLayoutManager() != null)
        {
            b.b.getLayoutManager().a(view, b1);
        }
    }

    public final boolean a(View view, int i, Bundle bundle)
    {
        boolean flag1 = false;
        boolean flag;
        if (super.a(view, i, bundle))
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (!b.a())
            {
                flag = flag1;
                if (b.b.getLayoutManager() != null)
                {
                    view = b.b.getLayoutManager();
                    bundle = ((clerView.i) (view)).i.a;
                    view = ((clerView.i) (view)).i.o;
                    return false;
                }
            }
        }
        return flag;
    }

    clerView.i(v v1)
    {
        b = v1;
        super();
    }
}
