// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.livemixtapes:
//            SignUp

class this._cls0
    implements android.view.ckListener
{

    final SignUp this$0;

    public void onClick(View view)
    {
        SignUp.access$10(SignUp.this).setText("");
        SignUp.access$10(SignUp.this).requestFocus();
    }

    stener()
    {
        this$0 = SignUp.this;
        super();
    }
}
