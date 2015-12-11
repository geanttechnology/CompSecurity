// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.i;

import com.target.mothership.model.d;
import com.target.ui.d.c;

public class com.target.ui.helper.i.a
{
    public static interface a
    {

        public abstract void a(int i);

        public abstract void d();
    }

    public static interface b
    {

        public abstract void b(int i);
    }


    private com.target.ui.d.a mHelpShiftService;

    public com.target.ui.helper.i.a(com.target.ui.d.a a1)
    {
        mHelpShiftService = a1;
    }

    public void a(final a listener)
    {
        mHelpShiftService.a(new d() {

            final com.target.ui.helper.i.a this$0;
            final a val$listener;

            public void a(com.target.ui.d.b b1)
            {
                listener.a(b1.a());
            }

            public void a(c c1)
            {
                listener.d();
            }

            public volatile void a(Object obj)
            {
                a((com.target.ui.d.b)obj);
            }

            public void b(Object obj)
            {
                a((c)obj);
            }

            
            {
                this$0 = com.target.ui.helper.i.a.this;
                listener = a2;
                super();
            }
        });
    }

    public void a(final b notificationListener)
    {
        mHelpShiftService.a(new com.target.ui.d.a() {

            final com.target.ui.helper.i.a this$0;
            final b val$notificationListener;

            public void a(int i)
            {
                if (notificationListener != null)
                {
                    notificationListener.b(i);
                }
            }

            
            {
                this$0 = com.target.ui.helper.i.a.this;
                notificationListener = b1;
                super();
            }
        });
    }
}
