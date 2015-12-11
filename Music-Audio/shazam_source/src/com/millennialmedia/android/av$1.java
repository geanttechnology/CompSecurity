// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            av

final class a
    implements Runnable
{

    final String a;
    final av b;

    public final void run()
    {
        if (a.equalsIgnoreCase("restartVideo"))
        {
            b.h();
        } else
        if (a.equalsIgnoreCase("endVideo"))
        {
            b.i();
            return;
        }
    }

    (av av1, String s)
    {
        b = av1;
        a = s;
        super();
    }
}
