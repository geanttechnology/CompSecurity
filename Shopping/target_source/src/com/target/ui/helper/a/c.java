// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.a;

import com.google.a.a.e;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.i;
import com.target.mothership.services.o;
import com.target.mothership.util.b;
import com.target.ui.helper.a;
import com.target.ui.service.f;
import java.util.List;

public class c extends com.target.ui.helper.a
{
    public static interface a
        extends com.target.ui.helper.b
    {

        public abstract void a(i i);

        public abstract void a(List list);

        public abstract void m();
    }


    private static final String TAG = com/target/ui/helper/a/c.getSimpleName();
    private final f mDataService;
    private final String mRequestTag = String.valueOf(hashCode());

    public c(f f1)
    {
        mDataService = f1;
    }

    static String a(c c1)
    {
        return c1.mRequestTag;
    }

    static boolean a(c c1, com.target.ui.helper.b b1, j j, Guest guest, o o)
    {
        return c1.a(b1, j, guest, o);
    }

    public void a()
    {
        mDataService.a(mRequestTag);
    }

    public void a(final Guest guest, final a listener)
    {
        if (!b.a().b())
        {
            listener.m();
            return;
        } else
        {
            mDataService.d(guest, new d() {

                final c this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.a.c.a(c.this);
                }

                public void a(i j)
                {
                    if (com.target.ui.helper.a.c.a(c.this, listener, j.e(), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(j);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    listener.a(list);
                }

                public void b(Object obj)
                {
                    a((i)obj);
                }

            
            {
                this$0 = c.this;
                listener = a1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

}
