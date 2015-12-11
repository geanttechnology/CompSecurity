// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayNowFlyinMenuActivity

class this._cls0
    implements Runnable
{

    final PlayNowFlyinMenuActivity this$0;

    public void run()
    {
        PlayNowFlyinMenuActivity.access$000(PlayNowFlyinMenuActivity.this).requestFocus();
        PlayNowFlyinMenuActivity.access$300(PlayNowFlyinMenuActivity.this).showSoftInput(PlayNowFlyinMenuActivity.access$000(PlayNowFlyinMenuActivity.this), 1);
    }

    ()
    {
        this$0 = PlayNowFlyinMenuActivity.this;
        super();
    }
}
