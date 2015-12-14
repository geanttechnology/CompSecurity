// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.content.Context;
import android.widget.Checkable;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortItemView

public class DragSortItemViewCheckable extends DragSortItemView
    implements Checkable
{

    public DragSortItemViewCheckable(Context context)
    {
        super(context);
    }

    public boolean isChecked()
    {
        boolean flag = false;
        android.view.View view = getChildAt(0);
        if (view instanceof Checkable)
        {
            flag = ((Checkable)view).isChecked();
        }
        return flag;
    }

    public void setChecked(boolean flag)
    {
        android.view.View view = getChildAt(0);
        if (view instanceof Checkable)
        {
            ((Checkable)view).setChecked(flag);
        }
    }

    public void toggle()
    {
        android.view.View view = getChildAt(0);
        if (view instanceof Checkable)
        {
            ((Checkable)view).toggle();
        }
    }
}
