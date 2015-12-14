// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.socialin.android.videogenerator:
//            a

final class a
    implements android.content.ogInterface.OnKeyListener
{

    private a a;

    public final boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (a.c != null)
            {
                a.c.onClick(a.b);
            }
            return true;
        } else
        {
            return false;
        }
    }

    tener(a a1)
    {
        a = a1;
        super();
    }
}
