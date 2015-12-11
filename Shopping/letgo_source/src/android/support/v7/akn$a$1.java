// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Message;

// Referenced classes of package android.support.v7:
//            akn

class a
    implements Runnable
{

    final Message a;
    final tring b;

    public void run()
    {
        throw new AssertionError((new StringBuilder()).append("Unknown handler message received: ").append(a.what).toString());
    }

    ( , Message message)
    {
        b = ;
        a = message;
        super();
    }
}
