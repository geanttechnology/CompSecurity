// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.o;

import com.shazam.android.k.h;
import com.shazam.c.i;
import com.shazam.o.b;
import com.shazam.server.response.store.Store;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
    implements com.shazam.b.a.a
{

    private final i a;
    private final i b;
    private final com.shazam.android.k.i c;

    public a(i j, i k, com.shazam.android.k.i l)
    {
        a = j;
        b = k;
        c = l;
    }

    public final Object a(Object obj)
    {
        obj = (Map)obj;
        if (obj == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = ((Map) (obj)).entrySet().iterator();
        while (iterator.hasNext()) 
        {
            obj = (java.util.Map.Entry)iterator.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            Store store = (Store)((java.util.Map.Entry) (obj)).getValue();
            if (store == null)
            {
                obj = null;
            } else
            {
                i j = a;
                if (store.actions == null)
                {
                    obj = Collections.emptyList();
                } else
                {
                    obj = store.actions;
                }
                obj = (List)j.a(obj);
                obj = (List)b.a(obj);
                if (com.shazam.o.b.a(((java.util.Collection) (obj))))
                {
                    obj = null;
                } else
                {
                    android.content.Intent intent = h.a(((List) (obj)), c);
                    if (intent == null)
                    {
                        obj = null;
                    } else
                    {
                        com.shazam.model.store.Store.Builder builder = com.shazam.model.store.Store.Builder.a();
                        builder.key = s;
                        builder.intents = ((List) (obj));
                        builder.validIntent = intent;
                        builder.coverArt = store.getCoverArtUrl();
                        builder.blurredCoverArt = store.getBlurredArtUrl();
                        builder.previewUrl = store.getPreviewUrl();
                        obj = builder.b();
                    }
                }
            }
            arraylist.add(obj);
        }
        obj = com.shazam.model.store.Stores.Builder.a();
        obj.stores = arraylist;
        return ((com.shazam.model.store.Stores.Builder) (obj)).b();
    }
}
