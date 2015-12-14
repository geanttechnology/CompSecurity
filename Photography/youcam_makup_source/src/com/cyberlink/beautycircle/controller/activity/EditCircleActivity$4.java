// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditCircleActivity

class a
    implements TextWatcher
{

    final EditCircleActivity a;

    public void afterTextChanged(Editable editable)
    {
        if (EditCircleActivity.d(a) != null)
        {
            editable = EditCircleActivity.d(a).getText().toString();
            if (EditCircleActivity.e(a) != null)
            {
                EditCircleActivity.e(a).setText((new StringBuilder()).append(String.valueOf(editable.length())).append("/").append(180).toString());
            }
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    I(EditCircleActivity editcircleactivity)
    {
        a = editcircleactivity;
        super();
    }
}
