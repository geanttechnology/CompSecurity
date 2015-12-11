// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.view.View;

// Referenced classes of package com.sessionm.ui:
//            ProgressViewController

class this._cls0
    implements android.view.._cls2
{

    final ProgressViewController this$0;

    public void onClick(View view)
    {
        if (ProgressViewController.access$100(ProgressViewController.this) != null)
        {
            ProgressViewController.access$100(ProgressViewController.this).onCancel();
        }
    }

    stener()
    {
        this$0 = ProgressViewController.this;
        super();
    }
}
