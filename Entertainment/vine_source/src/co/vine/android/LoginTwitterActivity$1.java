// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            LoginTwitterActivity

class this._cls0
    implements android.widget.Listener
{

    final LoginTwitterActivity this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (keyevent != null && keyevent.getKeyCode() == 66 || i == 6)
        {
            LoginTwitterActivity.access$000(LoginTwitterActivity.this, false);
        }
        return false;
    }

    istener()
    {
        this$0 = LoginTwitterActivity.this;
        super();
    }
}
