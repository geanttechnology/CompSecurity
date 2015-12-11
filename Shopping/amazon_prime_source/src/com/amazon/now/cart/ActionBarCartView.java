// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.amazon.now.cart:
//            CartSubscriber, CartController

public class ActionBarCartView extends RelativeLayout
    implements CartSubscriber
{

    private TextView mCartText;

    public ActionBarCartView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void updateCartCount(final int count)
    {
        post(new Runnable() {

            final ActionBarCartView this$0;
            final int val$count;

            public void run()
            {
                float f = 12F;
                if (count >= 100)
                {
                    f = 9F;
                }
                mCartText.setTextSize(2, f);
                mCartText.setText(Integer.toString(count));
            }

            
            {
                this$0 = ActionBarCartView.this;
                count = i;
                super();
            }
        });
    }

    public void cartCountUpdated(int i)
    {
        updateCartCount(i);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mCartText = (TextView)findViewById(0x7f0e0032);
        CartController.getInstance().addSubscriber(this);
        updateCartCount(CartController.getInstance().getCartCount());
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        CartController.getInstance().removeSubscriber(this);
    }

}
