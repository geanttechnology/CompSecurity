// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.widget.p;
import android.support.v7.internal.widget.q;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView
{

    private static final int TINT_ATTRS[] = {
        0x1010108
    };
    private p mTintManager;

    public AppCompatCheckedTextView(Context context)
    {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x10103c8);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (p.a)
        {
            context = q.a(getContext(), attributeset, TINT_ATTRS, i, 0);
            setCheckMarkDrawable(context.a(0));
            context.b();
            mTintManager = context.c();
        }
    }

    public void setCheckMarkDrawable(int i)
    {
        if (mTintManager != null)
        {
            setCheckMarkDrawable(mTintManager.a(i));
            return;
        } else
        {
            super.setCheckMarkDrawable(i);
            return;
        }
    }

}
