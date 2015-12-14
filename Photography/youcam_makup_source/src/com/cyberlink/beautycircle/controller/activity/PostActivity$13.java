// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity

class a
    implements TextWatcher
{

    final PostActivity a;

    public void afterTextChanged(Editable editable)
    {
label0:
        {
            if (PostActivity.j(a) != null && PostActivity.k(a) != null)
            {
                if (!PostActivity.j(a).getText().toString().isEmpty())
                {
                    break label0;
                }
                PostActivity.k(a).setEnabled(false);
            }
            return;
        }
        PostActivity.k(a).setEnabled(true);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (PostActivity postactivity)
    {
        a = postactivity;
        super();
    }
}
