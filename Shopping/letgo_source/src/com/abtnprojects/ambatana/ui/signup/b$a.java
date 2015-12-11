// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.content.Context;
import com.parse.ParseException;
import com.parse.RequestPasswordResetCallback;
import java.lang.ref.WeakReference;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            b

private class d
    implements RequestPasswordResetCallback
{

    final b a;
    private final WeakReference b;
    private final WeakReference c;
    private final String d;

    public void done(ParseException parseexception)
    {
        b b1 = (b)b.get();
        if (parseexception == null)
        {
            if (b1 != null)
            {
                com.abtnprojects.ambatana.ui.signup.b.a(b1, (Context)c.get(), d);
            }
        } else
        if (b1 != null)
        {
            com.abtnprojects.ambatana.ui.signup.b.a(b1);
            return;
        }
    }

    public volatile void done(Throwable throwable)
    {
        done((ParseException)throwable);
    }

    public (b b1, b b2, Context context, String s)
    {
        a = b1;
        super();
        b = new WeakReference(b2);
        c = new WeakReference(context);
        d = s;
    }
}
