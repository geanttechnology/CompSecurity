// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.app:
//            cn

final class cq
    implements android.widget.TextView.OnEditorActionListener
{

    final cn a;

    cq(cn cn1)
    {
        a = cn1;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        cn.d(a);
        return true;
    }
}
