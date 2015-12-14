// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

// Referenced classes of package com.livemixtapes:
//            CommentsActivity

class this._cls0
    implements TextWatcher
{

    final CommentsActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        if (editable.length() == 0)
        {
            sendButton.setVisibility(8);
            return;
        } else
        {
            sendButton.setVisibility(0);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = CommentsActivity.this;
        super();
    }
}
