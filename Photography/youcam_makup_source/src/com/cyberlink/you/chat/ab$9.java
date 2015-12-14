// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.AsyncTask;
import org.jivesoftware.smack.packet.Message;

// Referenced classes of package com.cyberlink.you.chat:
//            ab

class c extends AsyncTask
{

    final String a;
    final String b;
    final Message c;
    final ab d;

    protected transient Void a(Void avoid[])
    {
        d.a(a, b, c);
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    t.Message(ab ab1, String s, String s1, Message message)
    {
        d = ab1;
        a = s;
        b = s1;
        c = message;
        super();
    }
}
