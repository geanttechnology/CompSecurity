// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.millennialmedia.android:
//            MMAdView, MMLog

class a extends View
{

    private MMAdView a;

    final void a(View view)
    {
        this;
        JVM INSTR monitorenter ;
        MMAdView.b(a, view);
        if (getParent() != null && (getParent() instanceof ViewGroup))
        {
            ((ViewGroup)getParent()).addView(view);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        MMLog.b("MMAdView", "onRestoreInstanceState");
        MMAdView.a(a, a);
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        MMLog.b("MMAdView", "onSaveInstanceState");
        a(a);
        return super.onSaveInstanceState();
    }

    public (MMAdView mmadview, Context context)
    {
        a = mmadview;
        super(context);
    }
}
