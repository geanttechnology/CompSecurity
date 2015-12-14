// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import dc;
import dd;

public class FitWindowsLinearLayout extends LinearLayout
    implements dc
{

    private dd mListener;

    public FitWindowsLinearLayout(Context context)
    {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        if (mListener != null)
        {
            mListener.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(dd dd1)
    {
        mListener = dd1;
    }
}
