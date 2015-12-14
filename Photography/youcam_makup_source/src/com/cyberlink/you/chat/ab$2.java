// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.AsyncTask;

// Referenced classes of package com.cyberlink.you.chat:
//            ab, XMPPObject

class b extends AsyncTask
{

    final XMPPObject a;
    final boolean b;
    final ab c;

    protected transient Void a(Void avoid[])
    {
        ab.b(c, a, b);
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    bject(ab ab1, XMPPObject xmppobject, boolean flag)
    {
        c = ab1;
        a = xmppobject;
        b = flag;
        super();
    }
}
