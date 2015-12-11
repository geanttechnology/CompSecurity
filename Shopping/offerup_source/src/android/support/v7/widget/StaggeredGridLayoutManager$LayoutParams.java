// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;

public class  extends 
{

    boolean mFullSpan;
    mFullSpan mSpan;

    public final int getSpanIndex()
    {
        if (mSpan == null)
        {
            return -1;
        } else
        {
            return mSpan.mSpan;
        }
    }

    public void setFullSpan(boolean flag)
    {
        mFullSpan = flag;
    }

    public (int i, int j)
    {
        super(i, j);
    }

    public (Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public (android.view.LayoutParams layoutparams)
    {
        super(layoutparams);
    }

    public (android.view.LayoutParams layoutparams)
    {
        super(layoutparams);
    }
}
