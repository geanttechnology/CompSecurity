// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            DesktopScreen

class this._cls0
    implements TextWatcher
{

    final DesktopScreen this$0;

    public void afterTextChanged(Editable editable)
    {
        Button button = DesktopScreen.access$000(DesktopScreen.this);
        boolean flag;
        if (editable != null && editable.length() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setEnabled(flag);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = DesktopScreen.this;
        super();
    }
}
