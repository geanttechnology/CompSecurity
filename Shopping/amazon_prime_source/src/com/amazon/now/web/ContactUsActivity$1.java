// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.amazon.now.web:
//            ContactUsActivity

class this._cls0
    implements Runnable
{

    final ContactUsActivity this$0;

    public void run()
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentView().getWindowToken(), 0);
    }

    ager()
    {
        this$0 = ContactUsActivity.this;
        super();
    }
}
