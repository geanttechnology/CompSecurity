// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.i;

import com.shazam.android.widget.share.c;
import com.shazam.b.a.a;
import com.shazam.model.configuration.ShareConfiguration;
import com.shazam.model.share.ShareDataItem;
import com.shazam.server.response.details.Share;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class b
    implements a
{

    private final c a;
    private final ShareConfiguration b;

    public b(c c1, ShareConfiguration shareconfiguration)
    {
        a = c1;
        b = shareconfiguration;
    }

    static int a(b b1, String s)
    {
        b1 = b1.b.a();
        int j = b1.size();
        for (int i = 0; i < j; i++)
        {
            if (s.equals(b1.get(i)))
            {
                return i;
            }
        }

        return j;
    }

    public final Object a(Object obj)
    {
        obj = (Share)obj;
        Object obj1 = com.shazam.model.share.ShareData.Builder.a();
        obj1.subject = ((Share) (obj)).subject;
        obj1.text = (new StringBuilder()).append(((Share) (obj)).text).append(" ").append(((Share) (obj)).href).toString();
        obj1 = ((com.shazam.model.share.ShareData.Builder) (obj1)).b();
        obj = a.a(((com.shazam.model.share.ShareData) (obj1)));
        obj1 = com.shazam.model.share.ShareData.Builder.a(((com.shazam.model.share.ShareData) (obj1)));
        Collections.sort(((List) (obj)), new Comparator() {

            final b a;

            public final int compare(Object obj2, Object obj3)
            {
                obj2 = (ShareDataItem)obj2;
                obj3 = (ShareDataItem)obj3;
                return com.shazam.android.l.i.b.a(a, ((ShareDataItem) (obj2)).intentPackageName) - com.shazam.android.l.i.b.a(a, ((ShareDataItem) (obj3)).intentPackageName);
            }

            
            {
                a = b.this;
                super();
            }
        });
        ((com.shazam.model.share.ShareData.Builder) (obj1)).shareDataItems.clear();
        ((com.shazam.model.share.ShareData.Builder) (obj1)).shareDataItems.addAll(((java.util.Collection) (obj)));
        return ((com.shazam.model.share.ShareData.Builder) (obj1)).b();
    }
}
