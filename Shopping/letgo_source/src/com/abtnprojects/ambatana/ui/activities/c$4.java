// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.support.v7.aqo;
import android.support.v7.ic;
import com.parse.LogOutCallback;
import com.parse.ParseException;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            c

class a
    implements LogOutCallback
{

    final c a;

    public void done(ParseException parseexception)
    {
        if (parseexception == null)
        {
            a.x.d();
            return;
        } else
        {
            aqo.b(parseexception, "Error trying to logout a banned user", new Object[0]);
            return;
        }
    }

    public volatile void done(Throwable throwable)
    {
        done((ParseException)throwable);
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
