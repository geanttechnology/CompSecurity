// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            cn, cw

final class co
    implements android.widget.TextView.OnEditorActionListener
{

    final cn a;

    co(cn cn1)
    {
        a = cn1;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return false;

        case 6: // '\006'
            break;
        }
        if (a.n != null)
        {
            a.n.a();
        }
        return true;
    }
}
