// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.millennialmedia.android:
//            ad, al

final class a extends View
{

    final ad a;

    final void a(View view)
    {
        this;
        JVM INSTR monitorenter ;
        ad.b(a, view);
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

    protected final void onRestoreInstanceState(Parcelable parcelable)
    {
        al.b();
        ad.a(a, a);
        super.onRestoreInstanceState(parcelable);
    }

    protected final Parcelable onSaveInstanceState()
    {
        al.b();
        a(a);
        return super.onSaveInstanceState();
    }

    public (ad ad1, Context context)
    {
        a = ad1;
        super(context);
    }
}
