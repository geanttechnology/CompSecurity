// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class an extends FrameLayout
{

    private an(Context context)
    {
        super(context);
    }

    static ViewGroup a(View view)
    {
        an an1 = new an(view.getContext());
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if (layoutparams != null)
        {
            an1.setLayoutParams(layoutparams);
        }
        view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        an1.addView(view);
        return an1;
    }

    protected final void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        dispatchThawSelfOnly(sparsearray);
    }

    protected final void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        dispatchFreezeSelfOnly(sparsearray);
    }
}
