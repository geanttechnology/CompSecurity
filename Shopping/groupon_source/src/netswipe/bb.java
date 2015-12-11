// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package netswipe:
//            ba

class bb
    implements android.view.View.OnKeyListener
{

    final ba a;

    bb(ba ba1)
    {
        a = ba1;
        super();
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 67 && ba.a(a).getText().length() == 0)
        {
            ba.b(a).requestFocus();
        }
        return false;
    }
}
