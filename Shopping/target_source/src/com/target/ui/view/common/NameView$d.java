// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.KeyEvent;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.validation.a.k;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.common:
//            NameView

private final class <init>
    implements android.widget.EditorActionListener
{

    final NameView this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            textview = NameView.b(NameView.this);
            if (o.g(textview.b()))
            {
                NameView.c(NameView.this).lastNameWrapper.setErrorState(textview.b());
            }
        }
        return false;
    }

    private pper()
    {
        this$0 = NameView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
