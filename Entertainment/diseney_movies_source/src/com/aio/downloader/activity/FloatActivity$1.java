// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.aio.downloader.views.DeletableEditText;

// Referenced classes of package com.aio.downloader.activity:
//            FloatActivity, AppRecommendKeywordsActivity

class this._cls0
    implements android.view.er
{

    final FloatActivity this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 0 && i == 66)
        {
            try
            {
                ((InputMethodManager)FloatActivity.access$0(FloatActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(FloatActivity.access$0(FloatActivity.this).getWindowToken(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (View view) { }
            try
            {
                if (FloatActivity.access$0(FloatActivity.this).getText().toString().equals(""))
                {
                    FloatActivity.access$0(FloatActivity.this).setText("AIO Cleaner");
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppRecommendKeywordsActivity);
                view.putExtra("searchid", FloatActivity.access$0(FloatActivity.this).getText().toString());
                view.putExtra("searchint", 1);
                view.setFlags(0x10000000);
                startActivity(view);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return false;
            }
        }
        return false;
    }

    ordsActivity()
    {
        this$0 = FloatActivity.this;
        super();
    }
}
