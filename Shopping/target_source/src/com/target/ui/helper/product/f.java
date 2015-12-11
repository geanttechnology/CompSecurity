// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import com.target.mothership.util.b;
import com.target.ui.util.h.a;
import com.target.ui.util.q;
import java.net.URL;

public class f
{
    public static interface a
    {

        public abstract void a(String s);

        public abstract void c();

        public abstract void d();
    }


    private static final String TAG = com/target/ui/helper/product/f.getSimpleName();

    public f()
    {
    }

    static String a()
    {
        return TAG;
    }

    public void a(URL url, final a listener)
    {
        if (!b.a().b())
        {
            listener.c();
            return;
        } else
        {
            com.target.ui.util.h.a.a(url, new com.target.ui.util.h.a.b() {

                final f this$0;
                final a val$listener;

                public void a()
                {
                    q.a(com.target.ui.helper.product.f.a(), "Unable to get the html content");
                    if (listener == null)
                    {
                        return;
                    } else
                    {
                        listener.d();
                        return;
                    }
                }

                public void a(String s)
                {
                    if (listener == null)
                    {
                        return;
                    } else
                    {
                        listener.a(s);
                        return;
                    }
                }

            
            {
                this$0 = f.this;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

}
