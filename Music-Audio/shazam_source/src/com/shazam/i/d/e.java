// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.d;

import com.shazam.b.e.a;
import com.shazam.c.i;
import com.shazam.model.myshazam.MyShazamTag;
import com.shazam.model.post.Post;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
    implements i
{

    public e()
    {
    }

    public final Object a(Object obj)
    {
        Object obj1 = (List)obj;
        obj = new ArrayList(((List) (obj1)).size());
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            String s = ((MyShazamTag)((Iterator) (obj1)).next()).b().likeKey;
            if (com.shazam.b.e.a.c(s))
            {
                ((List) (obj)).add(s);
            }
        } while (true);
        return obj;
    }
}
