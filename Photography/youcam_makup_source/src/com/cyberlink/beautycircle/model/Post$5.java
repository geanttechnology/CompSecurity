// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.os.AsyncTask;
import com.cyberlink.beautycircle.model.database.a.a;
import com.cyberlink.beautycircle.model.database.b;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            Post, r

class b extends AsyncTask
{

    final Long a;
    final r b;
    final Post c;

    protected transient Post a(Void avoid[])
    {
        com.cyberlink.beautycircle.model.database.b.c().a(c, a);
        return com.cyberlink.beautycircle.model.database.b.c().a(c.postId.longValue());
    }

    protected void a(Post post)
    {
        if (b != null)
        {
            b.a(post);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Post)obj);
    }

    e.a.a(Post post, Long long1, r r1)
    {
        c = post;
        a = long1;
        b = r1;
        super();
    }
}
