// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;

// Referenced classes of package android.support.v7.internal.widget:
//            ActivityChooserView, q

public static class setBackgroundDrawable extends LinearLayoutCompat
{

    private static final int a[] = {
        0x10100d4
    };


    public (Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = q.a(context, attributeset, a);
        setBackgroundDrawable(context.a(0));
        context.b();
    }
}
