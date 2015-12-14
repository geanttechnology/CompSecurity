// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.util:
//            HoverTooltip

public final class am extends HoverTooltip
{

    public am(Context context)
    {
        super(context);
    }

    protected final View a(Context context)
    {
        context = new TextView(context);
        context.setBackgroundResource(0x7f020726);
        return context;
    }

    protected final void b(View view, Object obj)
    {
        ((TextView)view).setText((String)obj);
    }
}
