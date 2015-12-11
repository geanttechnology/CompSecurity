// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.KeyEvent;
import android.view.View;

final class ov
    implements android.view.View.OnKeyListener
{

    private ou a;

    ov(ou ou1)
    {
        a = ou1;
        super();
    }

    public final boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 111)
        {
            a.finish();
            return true;
        } else
        {
            return false;
        }
    }
}
