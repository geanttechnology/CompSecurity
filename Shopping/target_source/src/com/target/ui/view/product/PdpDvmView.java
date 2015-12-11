// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.ui.adapter.b.c;
import com.target.ui.view.BitmapImageView;

public class PdpDvmView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        BitmapImageView imageView;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(DvmDataResponse dvmdataresponse);
    }


    private a mListener;
    private Views mViews;

    public PdpDvmView(Context context)
    {
        super(context);
        a();
    }

    public PdpDvmView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public PdpDvmView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(PdpDvmView pdpdvmview)
    {
        return pdpdvmview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f030188, this);
        mViews = new Views(this);
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setDvmContent(final DvmDataResponse dvmDataResponse)
    {
        c.a(mViews.imageView.getContext(), dvmDataResponse.a(), mViews.imageView);
        mViews.imageView.setOnClickListener(new android.view.View.OnClickListener() {

            final PdpDvmView this$0;
            final DvmDataResponse val$dvmDataResponse;

            public void onClick(View view)
            {
                if (PdpDvmView.a(PdpDvmView.this) == null)
                {
                    return;
                } else
                {
                    PdpDvmView.a(PdpDvmView.this).a(dvmDataResponse);
                    return;
                }
            }

            
            {
                this$0 = PdpDvmView.this;
                dvmDataResponse = dvmdataresponse;
                super();
            }
        });
    }
}
