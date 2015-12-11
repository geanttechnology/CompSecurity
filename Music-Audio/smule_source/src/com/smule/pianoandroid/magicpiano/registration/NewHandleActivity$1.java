// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.b.r;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            NewHandleActivity, b

class a
    implements android.view.
{

    final NewHandleActivity a;

    public void onClick(View view)
    {
        if (NewHandleActivity.a(a).getText().toString().length() < 2)
        {
            MagicApplication.getInstance().showToast(a.getString(0x7f0c0136), 0);
            return;
        }
        if (NewHandleActivity.a(a).getText().toString().equals(UserManager.n().e()))
        {
            view = a.getResources().getString(0x7f0c023f);
            NewHandleActivity.a(a, new b(a));
            NewHandleActivity.b(a).a(view, NewHandleActivity.c());
            (new Handler()).postDelayed(new Runnable() {

                final NewHandleActivity._cls1 a;

                public void run()
                {
                    a.a.a(null, Boolean.valueOf(true), 0);
                }

            
            {
                a = NewHandleActivity._cls1.this;
                super();
            }
            }, 1000L);
            return;
        } else
        {
            view = a.getResources().getString(0x7f0c023f);
            NewHandleActivity.a(a, new b(a));
            NewHandleActivity.b(a).a(view, NewHandleActivity.c());
            (new r(NewHandleActivity.a(a).getText().toString(), "", "", null, a)).execute(new Void[0]);
            return;
        }
    }

    _cls1.a(NewHandleActivity newhandleactivity)
    {
        a = newhandleactivity;
        super();
    }
}
