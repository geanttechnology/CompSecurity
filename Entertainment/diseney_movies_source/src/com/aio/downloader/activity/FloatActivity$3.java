// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.aio.downloader.views.DeletableEditText;

// Referenced classes of package com.aio.downloader.activity:
//            FloatActivity

class this._cls0
    implements Runnable
{

    final FloatActivity this$0;

    public void run()
    {
        ((InputMethodManager)FloatActivity.access$0(FloatActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(FloatActivity.access$0(FloatActivity.this).getWindowToken(), 0);
    }

    ()
    {
        this$0 = FloatActivity.this;
        super();
    }
}
