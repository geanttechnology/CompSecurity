// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import com.helpshift.i.w;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment

class a
    implements TextWatcher
{

    final ImageButton a;
    final HSMessagesFragment b;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        HSMessagesFragment.b(b, true);
        if (charsequence.length() == 0)
        {
            a.setEnabled(false);
            a.setAlpha(64);
            w.d(HSMessagesFragment.g(b), a.getDrawable());
            return;
        } else
        {
            a.setEnabled(true);
            a.setAlpha(255);
            w.e(HSMessagesFragment.g(b), a.getDrawable());
            return;
        }
    }

    (HSMessagesFragment hsmessagesfragment, ImageButton imagebutton)
    {
        b = hsmessagesfragment;
        a = imagebutton;
        super();
    }
}
