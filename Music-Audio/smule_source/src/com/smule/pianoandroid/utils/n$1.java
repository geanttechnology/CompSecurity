// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package com.smule.pianoandroid.utils:
//            n

final class b
    implements Runnable
{

    final Activity a;
    final EditText b;

    public void run()
    {
        ((InputMethodManager)a.getSystemService("input_method")).showSoftInput(b, 0);
    }

    hodManager(Activity activity, EditText edittext)
    {
        a = activity;
        b = edittext;
        super();
    }
}
