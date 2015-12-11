// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

// Referenced classes of package com.ebay.mobile.widget:
//            PriceView

public class BidFlowPriceView extends PriceView
{
    private class BidFlowInputConnection extends InputConnectionWrapper
    {

        final BidFlowPriceView this$0;

        public boolean deleteSurroundingText(int i, int j)
        {
            if (i == 1 && j == 0)
            {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            } else
            {
                return super.deleteSurroundingText(i, j);
            }
        }

        public boolean sendKeyEvent(KeyEvent keyevent)
        {
            if (keyevent.getAction() == 1)
            {
                if (keyevent.getKeyCode() != 67);
            }
            return super.sendKeyEvent(keyevent);
        }

        public BidFlowInputConnection(InputConnection inputconnection, boolean flag)
        {
            this$0 = BidFlowPriceView.this;
            super(inputconnection, flag);
        }
    }


    public BidFlowPriceView(Context context)
    {
        this(context, null);
    }

    public BidFlowPriceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        return new BidFlowInputConnection(super.onCreateInputConnection(editorinfo), true);
    }
}
