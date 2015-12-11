// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.o;

import com.target.mothership.model.h;
import com.target.mothership.model.typeahead.c;
import com.target.mothership.services.x;
import com.target.ui.service.provider.d;
import java.util.List;

public class b
{
    public static interface a
    {

        public abstract void a(x x, String s);

        public abstract void a(List list, String s);

        public abstract void c(String s);
    }


    private com.target.ui.service.provider.b mConnectivityProvider;
    private c mProductSuggestionManager;
    private String mRequestTag;

    public b()
    {
        this(new c(), ((com.target.ui.service.provider.b) (new d())));
    }

    public b(c c1, com.target.ui.service.provider.b b1)
    {
        mProductSuggestionManager = c1;
        mConnectivityProvider = b1;
        mRequestTag = String.valueOf(hashCode());
    }

    static String a(b b1)
    {
        return b1.mRequestTag;
    }

    public void a()
    {
        mProductSuggestionManager.a(mRequestTag);
    }

    public void a(final String query, final a listener)
    {
        if (!mConnectivityProvider.a())
        {
            listener.c(query);
            return;
        } else
        {
            mProductSuggestionManager.a(query, new h() {

                final b this$0;
                final a val$listener;
                final String val$query;

                public String a()
                {
                    return b.a(b.this);
                }

                public void a(x x1)
                {
                    listener.a(x1, query);
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    listener.a(list, query);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = b.this;
                listener = a1;
                query = s;
                super();
            }
            });
            return;
        }
    }
}
