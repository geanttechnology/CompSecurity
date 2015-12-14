// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.j;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditCircleActivity

class a
    implements TextWatcher
{

    final EditCircleActivity a;

    public void afterTextChanged(Editable editable)
    {
        if (EditCircleActivity.b(a) != null)
        {
            editable = EditCircleActivity.b(a).getText().toString();
            if (editable.isEmpty())
            {
                a.findViewById(j.edit_displayname_clear_button).setVisibility(4);
            } else
            {
                a.findViewById(j.edit_displayname_clear_button).setVisibility(0);
            }
            if (EditCircleActivity.c(a) != null)
            {
                EditCircleActivity.c(a).setText((new StringBuilder()).append(String.valueOf(editable.length())).append("/").append(30).toString());
            }
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int k, int l)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int k, int l)
    {
    }

    I(EditCircleActivity editcircleactivity)
    {
        a = editcircleactivity;
        super();
    }
}
