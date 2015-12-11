// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            v

final class n extends android.widget.FrameLayout.LayoutParams
{

    final String a;

    n(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, v.PullToRefreshView);
        a = context.getString(v.PullToRefreshView_ptrViewDelegateClass);
        context.recycle();
    }
}
