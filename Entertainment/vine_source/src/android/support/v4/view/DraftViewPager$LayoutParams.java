// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.support.v4.view:
//            DraftViewPager

public static class gravity extends android.view.youtParams
{

    public int gravity;
    public boolean isDecor;

    public _cls9()
    {
        super(-1, -1);
    }

    public _cls9(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, DraftViewPager.access$100());
        gravity = context.getInteger(0, 0);
        context.recycle();
    }
}
