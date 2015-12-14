// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class this._cls0
    implements android.view.ner
{

    final SignInActivity this$0;

    public void onClick(View view)
    {
        if (SignInActivity.access$400(SignInActivity.this).isChecked())
        {
            SignInActivity.access$400(SignInActivity.this).setChecked(false);
            SignInActivity.access$800(SignInActivity.this);
            return;
        } else
        {
            SignInActivity.access$400(SignInActivity.this).setChecked(true);
            SignInActivity.access$900(SignInActivity.this);
            return;
        }
    }

    ()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
