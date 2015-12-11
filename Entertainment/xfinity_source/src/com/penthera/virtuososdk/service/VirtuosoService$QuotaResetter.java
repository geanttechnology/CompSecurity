// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.service;


// Referenced classes of package com.penthera.virtuososdk.service:
//            VirtuosoService

private class client
    implements Runnable
{

    String client;
    final VirtuosoService this$0;

    public void run()
    {
        VirtuosoService.access$4(VirtuosoService.this, this, client, true);
    }

    public (String s)
    {
        this$0 = VirtuosoService.this;
        super();
        client = s;
    }
}
