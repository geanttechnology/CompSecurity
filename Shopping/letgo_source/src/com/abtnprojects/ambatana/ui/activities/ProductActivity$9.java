// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.DialogInterface;
import android.widget.EditText;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ProductActivity

class a
    implements android.content.ClickListener
{

    final EditText a;
    final ProductActivity b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (ProductActivity.a(b, a.getText()))
        {
            ProductActivity.q(b);
            return;
        } else
        {
            ProductActivity.b(b, a.getText().toString());
            return;
        }
    }

    (ProductActivity productactivity, EditText edittext)
    {
        b = productactivity;
        a = edittext;
        super();
    }
}
