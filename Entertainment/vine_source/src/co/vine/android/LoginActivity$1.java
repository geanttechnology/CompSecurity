// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            LoginActivity

class this._cls0
    implements android.widget.rActionListener
{

    final LoginActivity this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (keyevent != null && keyevent.getKeyCode() == 66 || i == 6 && LoginActivity.access$000(LoginActivity.this))
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(LoginActivity.access$100(LoginActivity.this).getWindowToken(), 0);
            LoginActivity.access$200(LoginActivity.this, false);
        }
        return true;
    }

    thodManager()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
