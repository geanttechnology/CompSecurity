// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.playbackclient.views.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import com.google.common.base.Preconditions;

public class CheckablePreference extends LinearLayout
    implements Checkable
{

    private Checkable mCheckableView;

    public CheckablePreference(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean isChecked()
    {
        return mCheckableView.isChecked();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mCheckableView = (Checkable)Preconditions.checkNotNull((Checkable)findViewById(0x1020001));
        setOnClickListener(new android.view.View.OnClickListener() {

            final CheckablePreference this$0;

            public void onClick(View view)
            {
                mCheckableView.toggle();
            }

            
            {
                this$0 = CheckablePreference.this;
                super();
            }
        });
    }

    public void setChecked(boolean flag)
    {
        mCheckableView.setChecked(flag);
    }

    public void toggle()
    {
        mCheckableView.toggle();
    }

}
