// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.text.Editable;
import android.view.View;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            h, TokenCompleteTextView

public class c extends h
{

    final TokenCompleteTextView a;
    private Object c;

    public c(TokenCompleteTextView tokencompletetextview, View view, Object obj, int i)
    {
        a = tokencompletetextview;
        super(view, i);
        c = obj;
    }

    public Object a()
    {
        return c;
    }

    public void b()
    {
        Editable editable = a.getText();
        if (editable != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (TokenCompleteTextView._cls5.b[TokenCompleteTextView.h(a).ordinal()])
        {
        default:
            if (a.getSelectionStart() != editable.getSpanEnd(this) + 1)
            {
                a.setSelection(editable.getSpanEnd(this) + 1);
                return;
            }
            break;

        case 1: // '\001'
        case 2: // '\002'
            if (!b.isSelected())
            {
                TokenCompleteTextView.i(a);
                b.setSelected(true);
                a.a(b);
                return;
            }
            if (TokenCompleteTextView.h(a) == TokenCompleteTextView.TokenClickStyle.d)
            {
                b.setSelected(false);
                a.a(b);
                a.invalidate();
                return;
            }
            // fall through

        case 3: // '\003'
            TokenCompleteTextView.a(a, this);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
