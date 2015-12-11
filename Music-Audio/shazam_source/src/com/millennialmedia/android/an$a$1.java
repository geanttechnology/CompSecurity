// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            an, w, al

static final class a
    implements Runnable
{

    final String a;

    public final void run()
    {
        w w1 = new w();
        try
        {
            w1.a(a);
            return;
        }
        catch (Exception exception)
        {
            al.a(a, "Error logging event: ", exception);
        }
    }

    (String s)
    {
        a = s;
        super();
    }
}
