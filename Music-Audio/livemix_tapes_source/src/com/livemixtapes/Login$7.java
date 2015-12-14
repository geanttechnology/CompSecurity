// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.livemixtapes:
//            Login

class this._cls0
    implements android.view.lickListener
{

    final Login this$0;

    public void onClick(View view)
    {
        Login.access$5(Login.this).setText("");
        Login.access$5(Login.this).requestFocus();
    }

    Listener()
    {
        this$0 = Login.this;
        super();
    }
}
