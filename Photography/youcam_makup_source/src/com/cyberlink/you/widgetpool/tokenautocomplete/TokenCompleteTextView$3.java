// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.text.Editable;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            TokenCompleteTextView

class b
    implements Runnable
{

    final Object a;
    final CharSequence b;
    final TokenCompleteTextView c;

    public void run()
    {
        if (a != null && (TokenCompleteTextView.d(c) || !TokenCompleteTextView.b(c).contains(a)) && (TokenCompleteTextView.a(c) == -1 || TokenCompleteTextView.b(c).size() != TokenCompleteTextView.a(c)))
        {
            TokenCompleteTextView.a(c, a, b);
            if (c.getText() != null && c.isFocused())
            {
                c.setSelection(c.getText().length());
                return;
            }
        }
    }

    (TokenCompleteTextView tokencompletetextview, Object obj, CharSequence charsequence)
    {
        c = tokencompletetextview;
        a = obj;
        b = charsequence;
        super();
    }
}
