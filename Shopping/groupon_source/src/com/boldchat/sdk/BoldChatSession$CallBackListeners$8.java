// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatViewManager

class this._cls1
    implements Runnable
{

    final nputFromWindow this$1;

    public void run()
    {
        EditText edittext = BoldChatSession.access$500(_fld0).getMessageInputField();
        edittext.clearFocus();
        ((InputMethodManager)BoldChatSession.access$300(_fld0).getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
