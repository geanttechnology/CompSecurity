// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.common:
//            a

public class CheckableFormItem extends FrameLayout
    implements com.target.ui.view.common.a
{
    private class a
    {

        CheckBox checkbox;
        TextView text;
        final CheckableFormItem this$0;

        a(View view)
        {
            this$0 = CheckableFormItem.this;
            super();
            checkbox = (CheckBox)view.findViewById(0x7f10035a);
            text = (TextView)view.findViewById(0x7f10035b);
        }
    }


    private a mViews;

    public CheckableFormItem(Context context)
    {
        super(context);
        a(context);
    }

    public CheckableFormItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public CheckableFormItem(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030121, this);
        mViews = new a(this);
    }

    public View getView()
    {
        return this;
    }

    public boolean isChecked()
    {
        return mViews.checkbox.isChecked();
    }

    public void setChecked(boolean flag)
    {
        mViews.checkbox.setChecked(flag);
    }

    public void setText(String s)
    {
        mViews.text.setText(s);
    }

    public void toggle()
    {
        boolean flag;
        if (!mViews.checkbox.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChecked(flag);
    }
}
