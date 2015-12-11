// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.groupon.view:
//            EllipsizingTextView

public class MaxLinesTextView extends EllipsizingTextView
{

    private boolean displayWholeText;

    public MaxLinesTextView(Context context)
    {
        this(context, null, 0);
    }

    public MaxLinesTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MaxLinesTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected int getLinesCount()
    {
        if (displayWholeText)
        {
            return 0x7fffffff;
        } else
        {
            return super.getLinesCount();
        }
    }

    public void setMaxLines(int i)
    {
        super.setMaxLines(i);
        boolean flag;
        if (i == 0x7fffffff)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayWholeText = flag;
    }
}
