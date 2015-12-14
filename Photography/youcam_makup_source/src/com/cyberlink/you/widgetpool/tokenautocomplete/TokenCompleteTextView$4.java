// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.text.Editable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            TokenCompleteTextView, c, f

class a
    implements Runnable
{

    final Object a;
    final TokenCompleteTextView b;

    public void run()
    {
        int i = 0;
        Editable editable = b.getText();
        if (editable != null)
        {
            Object obj = new ArrayList();
            Iterator iterator = TokenCompleteTextView.e(b).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                c c3 = (c)iterator.next();
                if (c3.a().equals(a))
                {
                    ((ArrayList) (obj)).add(c3);
                }
            } while (true);
            c c2;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); TokenCompleteTextView.f(b).onSpanRemoved(editable, c2, 0, 0))
            {
                c2 = (c)((Iterator) (obj)).next();
                TokenCompleteTextView.e(b).remove(c2);
            }

            TokenCompleteTextView.g(b);
            c ac[] = (c[])editable.getSpans(0, editable.length(), com/cyberlink/you/widgetpool/tokenautocomplete/c);
            int j = ac.length;
            while (i < j) 
            {
                c c1 = ac[i];
                if (c1.a().equals(a))
                {
                    TokenCompleteTextView.a(b, c1);
                }
                i++;
            }
        }
    }

    (TokenCompleteTextView tokencompletetextview, Object obj)
    {
        b = tokencompletetextview;
        a = obj;
        super();
    }
}
