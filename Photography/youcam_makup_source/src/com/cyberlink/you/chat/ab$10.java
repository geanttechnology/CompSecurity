// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.AsyncTask;
import java.util.List;

// Referenced classes of package com.cyberlink.you.chat:
//            ab

class b extends AsyncTask
{

    final String a;
    final List b;
    final ab c;

    protected transient Void a(Void avoid[])
    {
        c.a(a, b);
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    (ab ab1, String s, List list)
    {
        c = ab1;
        a = s;
        b = list;
        super();
    }
}
