// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.q;
import android.util.AttributeSet;

// Referenced classes of package android.support.v7.internal.widget:
//            ActivityChooserView, r

public static class setBackgroundDrawable extends q
{

    private static final int a[] = {
        0x10100d4
    };


    public (Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = new r(context, context.obtainStyledAttributes(attributeset, a));
        setBackgroundDrawable(context.a(0));
        ((r) (context)).a.recycle();
    }
}
