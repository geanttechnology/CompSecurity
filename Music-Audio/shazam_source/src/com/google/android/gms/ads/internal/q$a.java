// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;
import com.google.android.gms.d.go;
import com.google.android.gms.d.gw;
import com.google.android.gms.d.he;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal:
//            q

public static final class b extends ViewSwitcher
{

    final go a;
    final gw b;

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (b != null)
        {
            b.c();
        }
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (b != null)
        {
            b.d();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        a.a(motionevent);
        return false;
    }

    public final void removeAllViews()
    {
        Object obj = new ArrayList();
        for (int i = 0; i < getChildCount(); i++)
        {
            android.view.View view = getChildAt(i);
            if (view != null && (view instanceof he))
            {
                ((List) (obj)).add((he)view);
            }
        }

        super.removeAllViews();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((he)((Iterator) (obj)).next()).destroy()) { }
    }

    public dListener(Context context, android.view.TreeObserver.OnGlobalLayoutListener ongloballayoutlistener, android.view.TreeObserver.OnScrollChangedListener onscrollchangedlistener)
    {
        super(context);
        a = new go(context);
        if (context instanceof Activity)
        {
            b = new gw((Activity)context, ongloballayoutlistener, onscrollchangedlistener);
            b.a();
            return;
        } else
        {
            b = null;
            return;
        }
    }
}
