// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.ebay.mobile.activities:
//            PriceRangeActivity

private static final class inputManager extends Handler
    implements android.view.splayKeyboard, Runnable
{

    InputMethodManager inputManager;
    View view;

    public void onFocusChange(View view1, boolean flag)
    {
        view = view1;
        if (flag)
        {
            postDelayed(this, 100L);
        }
    }

    public void run()
    {
        inputManager.showSoftInput(view, 1);
    }

    public (Context context)
    {
        inputManager = (InputMethodManager)context.getSystemService("input_method");
    }
}
