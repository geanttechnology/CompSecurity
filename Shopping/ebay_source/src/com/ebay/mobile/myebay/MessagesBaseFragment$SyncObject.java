// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesBaseFragment

private static class args
{

    public ArrayList args;
    public MessagesBaseFragment sendingFragment;

    public transient (MessagesBaseFragment messagesbasefragment, Object aobj[])
    {
        args = new ArrayList();
        sendingFragment = messagesbasefragment;
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                messagesbasefragment = ((MessagesBaseFragment) (aobj[i]));
                args.add(messagesbasefragment);
            }

        }
    }
}
