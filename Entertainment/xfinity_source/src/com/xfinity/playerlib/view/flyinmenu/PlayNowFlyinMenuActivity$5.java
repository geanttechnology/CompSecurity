// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayNowFlyinMenuActivity

class this._cls0
    implements android.widget.ener
{

    final PlayNowFlyinMenuActivity this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (i == 6)
        {
            PlayNowFlyinMenuActivity.access$300(PlayNowFlyinMenuActivity.this).hideSoftInputFromWindow(PlayNowFlyinMenuActivity.access$000(PlayNowFlyinMenuActivity.this).getWindowToken(), 0);
            flag = true;
        }
        return flag;
    }

    ()
    {
        this$0 = PlayNowFlyinMenuActivity.this;
        super();
    }
}
