// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            c, TokenCompleteTextView, e

class g
    implements TextWatcher
{

    ArrayList a;
    final TokenCompleteTextView b;

    private g(TokenCompleteTextView tokencompletetextview)
    {
        b = tokencompletetextview;
        super();
        a = new ArrayList();
    }

    g(TokenCompleteTextView tokencompletetextview, TokenCompleteTextView._cls1 _pcls1)
    {
        this(tokencompletetextview);
    }

    protected void a(c c1, Editable editable)
    {
        editable.removeSpan(c1);
    }

    public void afterTextChanged(Editable editable)
    {
        Iterator iterator = (new ArrayList(a)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            c c1 = (c)iterator.next();
            int i = editable.getSpanStart(c1);
            int j = editable.getSpanEnd(c1);
            a(c1, editable);
            j--;
            if (j >= 0 && TokenCompleteTextView.a(b, editable.charAt(j)))
            {
                editable.delete(j, j + 1);
            }
            if (i >= 0 && TokenCompleteTextView.a(b, editable.charAt(i)))
            {
                editable.delete(i, i + 1);
            }
        } while (true);
        TokenCompleteTextView.i(b);
        TokenCompleteTextView.m(b);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (j > 0 && b.getText() != null)
        {
            charsequence = b.getText();
            k = i + j;
            j = i;
            if (charsequence.charAt(i) == ' ')
            {
                j = i - 1;
            }
            c ac[] = (c[])charsequence.getSpans(j, k, com/cyberlink/you/widgetpool/tokenautocomplete/c);
            a = new ArrayList();
            int l = ac.length;
            for (i = 0; i < l; i++)
            {
                c c1 = ac[i];
                if (charsequence.getSpanStart(c1) < k && j < charsequence.getSpanEnd(c1))
                {
                    a.add(c1);
                }
            }

        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        charsequence = b.c(charsequence.toString());
        TokenCompleteTextView.l(b).a(charsequence);
    }
}
