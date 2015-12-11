// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

// Referenced classes of package com.wishabi.flipp.app:
//            cf

public class FocusedRecyclerView extends RecyclerView
{

    boolean p;
    private cf q;

    public FocusedRecyclerView(Context context)
    {
        super(context);
    }

    public FocusedRecyclerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public FocusedRecyclerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        p = true;
        super.onLayout(flag, i, j, k, l);
        p = false;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        android.view.View view = getFocusedChild();
        if (view != null && k != 0 && l != 0)
        {
            a(c(view));
        }
    }

    public void setResizeListener(cf cf)
    {
        q = cf;
    }
}
