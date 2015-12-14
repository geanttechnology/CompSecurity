// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.cyberlink.beautycircle.j;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditAboutActivity

class a
    implements TextWatcher
{

    final EditAboutActivity a;

    public void afterTextChanged(Editable editable)
    {
label0:
        {
            if (EditAboutActivity.c(a) != null)
            {
                if (!EditAboutActivity.c(a).getText().toString().isEmpty())
                {
                    break label0;
                }
                a.findViewById(j.edit_displayname_clear_button).setVisibility(4);
            }
            return;
        }
        a.findViewById(j.edit_displayname_clear_button).setVisibility(0);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int k, int l)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int k, int l)
    {
    }

    (EditAboutActivity editaboutactivity)
    {
        a = editaboutactivity;
        super();
    }
}
