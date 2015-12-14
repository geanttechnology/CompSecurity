// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostCommentActivity

class a
    implements TextWatcher
{

    final PostCommentActivity a;

    public void afterTextChanged(Editable editable)
    {
label0:
        {
            if (PostCommentActivity.c(a) != null && PostCommentActivity.d(a) != null)
            {
                if (!PostCommentActivity.c(a).getText().toString().isEmpty())
                {
                    break label0;
                }
                PostCommentActivity.d(a).setEnabled(false);
            }
            return;
        }
        PostCommentActivity.d(a).setEnabled(true);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (PostCommentActivity postcommentactivity)
    {
        a = postcommentactivity;
        super();
    }
}
