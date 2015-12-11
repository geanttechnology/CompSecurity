// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package jumiomobile:
//            ei

class ej
    implements android.view.View.OnKeyListener
{

    final ei a;

    ej(ei ei1)
    {
        a = ei1;
        super();
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 67 && ei.a(a).getText().length() == 0)
        {
            ei.b(a).requestFocus();
        }
        return false;
    }
}
