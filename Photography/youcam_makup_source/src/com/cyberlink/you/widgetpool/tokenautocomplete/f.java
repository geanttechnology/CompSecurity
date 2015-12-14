// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.text.SpanWatcher;
import android.text.Spannable;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            c, TokenCompleteTextView, e

class f
    implements SpanWatcher
{

    final TokenCompleteTextView a;

    private f(TokenCompleteTextView tokencompletetextview)
    {
        a = tokencompletetextview;
        super();
    }

    f(TokenCompleteTextView tokencompletetextview, TokenCompleteTextView._cls1 _pcls1)
    {
        this(tokencompletetextview);
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i, int j)
    {
        if ((obj instanceof c) && !TokenCompleteTextView.j(a) && !TokenCompleteTextView.k(a))
        {
            spannable = (c)obj;
            TokenCompleteTextView.b(a).add(spannable.a());
            if (TokenCompleteTextView.l(a) != null)
            {
                TokenCompleteTextView.l(a).b(spannable.a());
            }
        }
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int j, int k, int l)
    {
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int j)
    {
        if ((obj instanceof c) && !TokenCompleteTextView.j(a) && !TokenCompleteTextView.k(a))
        {
            spannable = (c)obj;
            if (TokenCompleteTextView.b(a).contains(spannable.a()))
            {
                TokenCompleteTextView.b(a).remove(spannable.a());
            }
            if (TokenCompleteTextView.l(a) != null)
            {
                TokenCompleteTextView.l(a).a(spannable.a());
            }
        }
    }
}
