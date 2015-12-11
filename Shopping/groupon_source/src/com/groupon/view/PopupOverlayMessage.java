// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;

public class PopupOverlayMessage extends RelativeLayout
{

    TextView messageTextView;
    View overlayContainer;

    public PopupOverlayMessage(Context context)
    {
        this(context, null);
    }

    public PopupOverlayMessage(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PopupOverlayMessage(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f030193, this);
        ButterKnife.bind(this);
        setOnClickListener(new android.view.View.OnClickListener() {

            final PopupOverlayMessage this$0;

            public void onClick(View view)
            {
                hide();
            }

            
            {
                this$0 = PopupOverlayMessage.this;
                super();
            }
        });
    }

    public int getOverlayHeight()
    {
        return overlayContainer.getHeight();
    }

    public void hide()
    {
        setVisibility(8);
    }

    public void setMessage(String s)
    {
        messageTextView.setText(s);
    }

    public void setOverlayLocationY(int i)
    {
        overlayContainer.setY(i);
    }

    public void show()
    {
        setVisibility(0);
    }
}
