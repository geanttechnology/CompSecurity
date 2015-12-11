// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.view.View;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            NumericKeypad

class this._cls0
    implements android.view.ener
{

    final NumericKeypad this$0;

    public void onClick(View view)
    {
        if (NumericKeypad.access$000(NumericKeypad.this) != null)
        {
            yPressedListener ypressedlistener = NumericKeypad.access$000(NumericKeypad.this);
            if (view.getTag() != null)
            {
                view = view.getTag().toString();
            } else
            {
                view = null;
            }
            ypressedlistener.onKeyPressed(view);
        }
    }

    yPressedListener()
    {
        this$0 = NumericKeypad.this;
        super();
    }
}
