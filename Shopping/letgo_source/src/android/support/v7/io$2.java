// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.parse.ParseException;
import com.parse.SaveCallback;

// Referenced classes of package android.support.v7:
//            io, aqo

static final class a
    implements SaveCallback
{

    final String a;

    public void done(ParseException parseexception)
    {
        if (parseexception != null)
        {
            aqo.b(parseexception, "Error saving installation details userId : %s ", new Object[] {
                a
            });
        }
    }

    public volatile void done(Throwable throwable)
    {
        done((ParseException)throwable);
    }

    (String s)
    {
        a = s;
        super();
    }
}
