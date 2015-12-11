// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.net.Uri;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.s;
import com.wishabi.flipp.content.ShoppingList;
import com.wishabi.flipp.util.q;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment, ff

final class ey
    implements android.widget.TextView.OnEditorActionListener
{

    final ShoppingListFragment a;

    ey(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        i;
        JVM INSTR tableswitch 6 6: default 20
    //                   6 22;
           goto _L1 _L2
_L1:
        return false;
_L2:
        textview.setTag(Boolean.valueOf(true));
        keyevent = a;
        textview = (EditText)textview;
        String s1 = textview.getText().toString().trim();
        if (s1.equals(""))
        {
            keyevent.a(keyevent.getString(0x7f0e0019));
            return true;
        }
        if (((ShoppingListFragment) (keyevent)).a.b() == 300)
        {
            keyevent.a(keyevent.getString(0x7f0e0161));
            return true;
        }
        Object obj = ((ShoppingListFragment) (keyevent)).a.a(s1);
        if (obj != null)
        {
            obj = ((Uri) (obj)).getLastPathSegment();
            long l;
            if (obj != null && q.d(((String) (obj))))
            {
                l = Long.parseLong(((String) (obj)));
            } else
            {
                l = -1L;
            }
            keyevent.c = l;
            textview.setText("");
            if (((ShoppingListFragment) (keyevent)).b != null)
            {
                ((ShoppingListFragment) (keyevent)).b.a(s1);
            }
            a.a.a(s1, s.a, -1);
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
