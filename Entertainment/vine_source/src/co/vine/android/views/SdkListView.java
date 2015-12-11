// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

public class SdkListView extends ListView
{

    public SdkListView(Context context)
    {
        super(context);
    }

    public SdkListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SdkListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        try
        {
            super.dispatchDraw(canvas);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Canvas canvas)
        {
            return;
        }
    }
}
