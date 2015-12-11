// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.e;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            bj, RecyclerView, au

final class bk extends a
{

    final bj b;

    bk(bj bj1)
    {
        b = bj1;
        super();
    }

    public final void a(View view, e e)
    {
        super.a(view, e);
        if (b.b.getLayoutManager() != null)
        {
            b.b.getLayoutManager().a(view, e);
        }
    }

    public final boolean a(View view, int i, Bundle bundle)
    {
        boolean flag = false;
        if (super.a(view, i, bundle))
        {
            flag = true;
        } else
        if (b.b.getLayoutManager() != null)
        {
            view = b.b.getLayoutManager();
            bundle = ((au) (view)).q.a;
            view = ((au) (view)).q.m;
            return false;
        }
        return flag;
    }
}
