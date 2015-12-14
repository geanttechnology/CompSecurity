// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class this._cls0
    implements android.view.eListener
{

    final SignInActivity this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag && SignInActivity.access$500(SignInActivity.this).getVisibility() != 0)
        {
            SignInActivity.access$600(SignInActivity.this, true);
            SignInActivity.access$700(SignInActivity.this).setVisibility(4);
            SignInActivity.access$700(SignInActivity.this).clearAnimation();
        }
    }

    ()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
