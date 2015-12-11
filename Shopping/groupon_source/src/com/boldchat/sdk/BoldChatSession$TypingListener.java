// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import com.boldchat.visitor.api.Chat;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

private class <init>
    implements TextWatcher, android.view.ner
{

    final BoldChatSession this$0;

    public void afterTextChanged(Editable editable)
    {
        if (BoldChatSession.access$400() != null)
        {
            Chat chat = BoldChatSession.access$400();
            boolean flag;
            if (!TextUtils.isEmpty(editable.toString()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            chat.setVisitorTyping(flag);
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 66 && !keyevent.isShiftPressed())
        {
            BoldChatSession.access$3200(BoldChatSession.this);
            return true;
        } else
        {
            return false;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = BoldChatSession.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
