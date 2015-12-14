// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import com.amazon.gallery.framework.data.dao.deduplicate.Deduplicater;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDeduplicater
    implements Deduplicater
{

    protected final MediaItemDao mediaItemDao;
    protected final ThreadLocal resultArray = new ThreadLocal() {

        final AbstractDeduplicater this$0;

        public volatile Object get()
        {
            return get();
        }

        public List get()
        {
            List list = (List)super.get();
            list.clear();
            return list;
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected List initialValue()
        {
            return new ArrayList();
        }

            
            {
                this$0 = AbstractDeduplicater.this;
                super();
            }
    };

    public AbstractDeduplicater(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
    }

    public void onAccountRegistered()
    {
    }
}
