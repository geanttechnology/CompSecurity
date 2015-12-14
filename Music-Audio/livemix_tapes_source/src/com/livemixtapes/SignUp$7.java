// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;

// Referenced classes of package com.livemixtapes:
//            SignUp

class this._cls0
    implements android.view.cusChangeListener
{

    final SignUp this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (!flag)
        {
            SignUp.access$7(SignUp.this, view);
        }
    }

    hangeListener()
    {
        this$0 = SignUp.this;
        super();
    }
}
