// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.livemixtapes:
//            LoginActivity, MainActivity

class this._cls0
    implements android.view.ener
{

    final LoginActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(LoginActivity.this, com/livemixtapes/MainActivity);
        startActivity(view);
    }

    ()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
