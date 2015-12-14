// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditAboutActivity

class a
    implements TextWatcher
{

    final EditAboutActivity a;

    public void afterTextChanged(Editable editable)
    {
        if (EditAboutActivity.d(a) != null && EditAboutActivity.h(a) != null)
        {
            editable = EditAboutActivity.d(a).getText().toString();
            EditAboutActivity.h(a).setText((new StringBuilder()).append(String.valueOf(editable.length())).append("/255").toString());
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (EditAboutActivity editaboutactivity)
    {
        a = editaboutactivity;
        super();
    }
}
