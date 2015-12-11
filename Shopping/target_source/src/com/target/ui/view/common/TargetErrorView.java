// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.common:
//            b, c

public class TargetErrorView extends LinearLayout
    implements com.target.ui.view.common.b
{
    private class a
        implements android.view.View.OnClickListener
    {

        final TargetErrorView this$0;

        public void onClick(View view)
        {
            if (TargetErrorView.a(TargetErrorView.this) == null)
            {
                return;
            } else
            {
                TargetErrorView.a(TargetErrorView.this).A_();
                return;
            }
        }

        private a()
        {
            this$0 = TargetErrorView.this;
            super();
        }

    }

    private class b
    {

        final TextView errorSubTitle;
        final TextView errorTitle;
        final ImageView noNetwork;
        final TargetErrorView this$0;
        final Button tryAgainBtn;
        final ImageView warningIcon;

        public b(View view)
        {
            this$0 = TargetErrorView.this;
            super();
            noNetwork = (ImageView)view.findViewById(0x7f1005d2);
            warningIcon = (ImageView)view.findViewById(0x7f1005d3);
            errorTitle = (TextView)view.findViewById(0x7f1005d4);
            errorSubTitle = (TextView)view.findViewById(0x7f1005d5);
            tryAgainBtn = (Button)view.findViewById(0x7f1005d6);
        }
    }


    private c mListener;
    private b mViews;

    public TargetErrorView(Context context)
    {
        super(context);
        a();
    }

    public TargetErrorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public TargetErrorView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static c a(TargetErrorView targeterrorview)
    {
        return targeterrorview.mListener;
    }

    private void a()
    {
        setOrientation(1);
        setGravity(17);
        inflate(getContext(), 0x7f030201, this);
        mViews = new b(this);
        mViews.tryAgainBtn.setOnClickListener(new a());
    }

    public void a(b.a a1, boolean flag)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$view$common$ErrorContainer$ErrorType[];

            static 
            {
                $SwitchMap$com$target$ui$view$common$ErrorContainer$ErrorType = new int[com.target.ui.view.common.b.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$common$ErrorContainer$ErrorType[b.a.ERROR_NO_NETWORK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$view$common$ErrorContainer$ErrorType[b.a.ERROR_DEFAULT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.view.common.ErrorContainer.ErrorType[a1.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 54
    //                   2 110;
           goto _L1 _L2 _L3
_L1:
        al.b(mViews.errorSubTitle);
        al.a(mViews.tryAgainBtn, flag);
        return;
_L2:
        mViews.errorSubTitle.setText(getResources().getString(0x7f0902fc));
        al.a(mViews.noNetwork, new View[] {
            mViews.errorTitle, mViews.warningIcon
        });
        continue; /* Loop/switch isn't completed */
_L3:
        mViews.errorSubTitle.setText(getResources().getString(0x7f0902fa));
        al.a(mViews.warningIcon, new View[] {
            mViews.errorTitle, mViews.noNetwork
        });
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void a(String s, String s1, boolean flag)
    {
        if (o.g(s))
        {
            mViews.errorTitle.setText(s);
            al.a(mViews.errorTitle, new View[] {
                mViews.warningIcon
            });
        }
        if (o.g(s1))
        {
            mViews.errorSubTitle.setText(s1);
            al.b(mViews.errorSubTitle);
        }
        al.a(mViews.tryAgainBtn, flag);
        al.a(mViews.warningIcon, new View[] {
            mViews.noNetwork
        });
    }

    public void setClickListener(c c)
    {
        mListener = c;
    }
}
