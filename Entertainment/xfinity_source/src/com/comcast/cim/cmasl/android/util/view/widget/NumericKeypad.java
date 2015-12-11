// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumericKeypad extends RelativeLayout
{
    public static interface KeyPressedListener
    {

        public abstract void onKeyPressed(String s);
    }


    private View backspaceButton;
    private List buttons;
    private KeyPressedListener keyPressedListener;

    public NumericKeypad(Context context)
    {
        super(context);
        buttons = new ArrayList();
        init(context);
    }

    public NumericKeypad(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        buttons = new ArrayList();
        init(context);
    }

    public NumericKeypad(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        buttons = new ArrayList();
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(com.comcast.cim.cmasl.android.util.R.layout.numeric_keypad, this, true);
        context = new Integer[10];
        context[0] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadZero);
        context[1] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadOne);
        context[2] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadTwo);
        context[3] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadThree);
        context[4] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadFour);
        context[5] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadFive);
        context[6] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadSix);
        context[7] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadSeven);
        context[8] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadEight);
        context[9] = Integer.valueOf(com.comcast.cim.cmasl.android.util.R.id.keypadNine);
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final NumericKeypad this$0;

            public void onClick(View view)
            {
                if (keyPressedListener != null)
                {
                    KeyPressedListener keypressedlistener = keyPressedListener;
                    if (view.getTag() != null)
                    {
                        view = view.getTag().toString();
                    } else
                    {
                        view = null;
                    }
                    keypressedlistener.onKeyPressed(view);
                }
            }

            
            {
                this$0 = NumericKeypad.this;
                super();
            }
        };
        int j = context.length;
        for (int i = 0; i < j; i++)
        {
            TextView textview = (TextView)findViewById(context[i].intValue());
            textview.setTag(textview.getText());
            textview.setOnClickListener(onclicklistener);
            buttons.add(textview);
        }

        backspaceButton = findViewById(com.comcast.cim.cmasl.android.util.R.id.keypadBackspace);
        backspaceButton.setOnClickListener(onclicklistener);
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        for (Iterator iterator = buttons.iterator(); iterator.hasNext(); ((View)iterator.next()).setEnabled(flag)) { }
        backspaceButton.setEnabled(flag);
    }

    public void setKeyPressedListener(KeyPressedListener keypressedlistener)
    {
        keyPressedListener = keypressedlistener;
    }

}
