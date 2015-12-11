// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.content.Context;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            f

class a
    implements LogInCallback
{

    final f a;

    public void done(ParseUser parseuser, ParseException parseexception)
    {
        parseuser = (Context)f.b(a).get();
        if (parseuser != null)
        {
            f.a(a, parseuser, parseexception);
        }
    }

    public volatile void done(Object obj, Throwable throwable)
    {
        done((ParseUser)obj, (ParseException)throwable);
    }

    (f f1)
    {
        a = f1;
        super();
    }
}
