// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditCommentActivity

class a
    implements TextWatcher
{

    final EditCommentActivity a;

    public void afterTextChanged(Editable editable)
    {
        if (EditCommentActivity.a(a).getText().toString().length() == 0)
        {
            EditCommentActivity.b(a).setEnabled(false);
            return;
        } else
        {
            EditCommentActivity.b(a).setEnabled(true);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (EditCommentActivity editcommentactivity)
    {
        a = editcommentactivity;
        super();
    }
}
