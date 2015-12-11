// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ContentSyncManager
{
    public static interface ContentSync
    {

        public abstract void updateContent(String s, Object obj);
    }


    private static final HashMap contentCollection = new HashMap();

    private ContentSyncManager()
    {
    }

    private static void add(String s, ContentSync contentsync)
    {
        if (contentsync != null)
        {
            contentsync = new WeakReference(contentsync);
            Object obj = (List)contentCollection.get(s);
            if (obj == null)
            {
                obj = new ArrayList();
                ((List) (obj)).add(contentsync);
                contentCollection.put(s, obj);
                return;
            }
            boolean flag = true;
            int j = ((List) (obj)).size();
            for (int i = 0; i < j && flag; i++)
            {
                if ((ContentSync)((WeakReference)((List) (obj)).get(i)).get() == null)
                {
                    ((List) (obj)).set(i, contentsync);
                    flag = false;
                }
            }

            if (flag)
            {
                ((List) (obj)).add(contentsync);
                return;
            }
        }
    }

    public static void notifyUpdate(Object obj, String s)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        List list;
        return;
_L2:
        if ((list = (List)contentCollection.get(s)) != null)
        {
            ContentSync acontentsync[] = new ContentSync[list.size()];
            int i;
            for (i = 0; i < list.size();)
            {
                acontentsync[i] = (ContentSync)((WeakReference)list.get(i)).get();
                if (acontentsync[i] == null)
                {
                    list.remove(i);
                } else
                {
                    i++;
                }
            }

            if (i == 0)
            {
                contentCollection.remove(s);
                return;
            }
            int j = 0;
            while (j < i) 
            {
                acontentsync[j].updateContent(s, obj);
                j++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static transient void register(ContentSync contentsync, String as[])
    {
        if (contentsync == null)
        {
            throw new NullPointerException("value");
        }
        if (as == null || as.length == 0)
        {
            throw new NullPointerException("keys");
        }
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            add(as[i], contentsync);
        }

    }

    private static void remove(String s, ContentSync contentsync)
    {
        List list;
        if (contentsync != null)
        {
            if ((list = (List)contentCollection.get(s)) != null)
            {
                for (int i = 0; i < list.size();)
                {
                    ContentSync contentsync1 = (ContentSync)((WeakReference)list.get(i)).get();
                    if (contentsync1 == null || contentsync1 == contentsync)
                    {
                        list.remove(i);
                    } else
                    {
                        i++;
                    }
                }

                if (list.isEmpty())
                {
                    contentCollection.remove(s);
                    return;
                }
            }
        }
    }

    public static transient void unregister(ContentSync contentsync, String as[])
    {
        if (contentsync == null)
        {
            throw new NullPointerException("value");
        }
        if (as == null || as.length == 0)
        {
            throw new NullPointerException("keys");
        }
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            remove(as[i], contentsync);
        }

    }

}
