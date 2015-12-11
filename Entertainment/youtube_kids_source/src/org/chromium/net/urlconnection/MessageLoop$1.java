// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net.urlconnection;


// Referenced classes of package org.chromium.net.urlconnection:
//            MessageLoop

class a
    implements Runnable
{

    private MessageLoop a;

    public void run()
    {
        MessageLoop.a(a, false);
    }

    (MessageLoop messageloop)
    {
        a = messageloop;
        super();
    }
}
