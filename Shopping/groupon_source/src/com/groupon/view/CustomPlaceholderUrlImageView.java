// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class CustomPlaceholderUrlImageView extends UrlImageView
{

    public CustomPlaceholderUrlImageView(Context context)
    {
        super(context);
    }

    public CustomPlaceholderUrlImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CustomPlaceholderUrlImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void init(Context context)
    {
        if (defaultPlaceholder != null) goto _L2; else goto _L1
_L1:
        com/groupon/view/UrlImageView;
        JVM INSTR monitorenter ;
        if (defaultPlaceholder == null)
        {
            defaultPlaceholder = context.getResources().getDrawable(0x7f0201a3);
        }
        com/groupon/view/UrlImageView;
        JVM INSTR monitorexit ;
_L2:
        defaultPlaceholder.setCallback(null);
        return;
        context;
        com/groupon/view/UrlImageView;
        JVM INSTR monitorexit ;
        throw context;
    }
}
