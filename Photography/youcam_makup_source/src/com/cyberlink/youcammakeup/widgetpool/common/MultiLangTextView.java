// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.cyberlink.youcammakeup.j;
import com.cyberlink.youcammakeup.utility.aj;
import com.pf.common.utility.m;

public class MultiLangTextView extends TextView
{

    public MultiLangTextView(Context context)
    {
        super(context);
    }

    public MultiLangTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    public MultiLangTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context, attributeset);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, j.MultiLangLayoutArgs);
        context = attributeset.getString(0);
        boolean flag = attributeset.getBoolean(1, true);
        attributeset.recycle();
        if (context == null || context.equals(""))
        {
            return;
        }
        try
        {
            attributeset = aj.a(context);
        }
        // Misplaced declaration of an exception variable
        catch (AttributeSet attributeset)
        {
            m.b("MultiLangTextView", context, attributeset);
            return;
        }
        aj.a(this, flag, attributeset);
    }
}
