// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

// Referenced classes of package com.amazon.mShop:
//            StandardView

public class StandardViewWithTextContent extends StandardView
{

    public StandardViewWithTextContent(Context context, Integer integer, int i, boolean flag)
    {
        super(context, integer);
        setContentView(com.amazon.mShop.android.lib.R.layout.standard_view_with_text_content);
        integer = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.standard_view_with_text_content_text);
        context = context.getResources().getString(i);
        if (flag)
        {
            integer.setText(Html.fromHtml(context));
            integer.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        } else
        {
            integer.setText(i);
            return;
        }
    }
}
