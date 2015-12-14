// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

// Referenced classes of package com.cyberlink.you.c:
//            c

class a
    implements TextWatcher
{

    final c a;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        charsequence = charsequence.toString().trim();
        if (charsequence != null && !charsequence.isEmpty())
        {
            c.d(a).setEnabled(true);
            return;
        } else
        {
            c.d(a).setEnabled(false);
            return;
        }
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
