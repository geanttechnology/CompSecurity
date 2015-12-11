// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view.widgetcards:
//            WidgetHeaderCard

public class EndlessListWidgetHeaderCard extends WidgetHeaderCard
{

    private TextView titleView;

    public EndlessListWidgetHeaderCard(Context context)
    {
        this(context, null);
    }

    public EndlessListWidgetHeaderCard(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, 0x7f0300da, this);
        init();
    }

    public void init()
    {
        super.init();
        titleView = (TextView)findViewById(0x7f10007a);
    }

    public void setInfo(String s, String s1)
    {
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final EndlessListWidgetHeaderCard this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = EndlessListWidgetHeaderCard.this;
                super();
            }
        });
        String s2 = s;
        if (Strings.notEmpty(s1))
        {
            s2 = getResources().getString(0x7f080530, new Object[] {
                s, s1
            });
        }
        titleView.setText(Html.fromHtml(s2));
    }
}
