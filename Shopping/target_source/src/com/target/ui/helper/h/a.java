// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.h;

import com.target.mothership.common.params.GoogleNowSendCardParams;
import com.target.mothership.model.b.c;
import com.target.mothership.model.h;
import com.target.mothership.services.x;

public class com.target.ui.helper.h.a
{
    public static interface a
    {

        public abstract void a(x x);

        public abstract void a(Void void1);

        public abstract void b(x x);

        public abstract void b(Void void1);

        public abstract void c(x x);

        public abstract void c(Void void1);
    }


    private static final String TAG = com/target/ui/helper/h/a.getSimpleName();
    private final c mGoogleNowManager = new c();
    private a mSendGoogleNowListener;

    public com.target.ui.helper.h.a(a a1)
    {
        mSendGoogleNowListener = a1;
    }

    static a a(com.target.ui.helper.h.a a1)
    {
        return a1.mSendGoogleNowListener;
    }

    public int a()
    {
        return com.target.mothership.a.a.a().c();
    }

    public void a(GoogleNowSendCardParams googlenowsendcardparams)
    {
        mGoogleNowManager.a(googlenowsendcardparams, new h() {

            final com.target.ui.helper.h.a this$0;

            public void a(x x1)
            {
                com.target.ui.helper.h.a.a(com.target.ui.helper.h.a.this).a(x1);
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.h.a.a(com.target.ui.helper.h.a.this).a(void1);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.h.a.this;
                super();
            }
        });
    }

    public void a(GoogleNowSendCardParams googlenowsendcardparams, String s)
    {
        mGoogleNowManager.a(googlenowsendcardparams, s, new h() {

            final com.target.ui.helper.h.a this$0;

            public void a(x x1)
            {
                com.target.ui.helper.h.a.a(com.target.ui.helper.h.a.this).b(x1);
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.h.a.a(com.target.ui.helper.h.a.this).b(void1);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.h.a.this;
                super();
            }
        });
    }

    public void a(String s)
    {
        mGoogleNowManager.a(s, new h() {

            final com.target.ui.helper.h.a this$0;

            public void a(x x1)
            {
                com.target.ui.helper.h.a.a(com.target.ui.helper.h.a.this).c(x1);
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.h.a.a(com.target.ui.helper.h.a.this).c(void1);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.h.a.this;
                super();
            }
        });
    }

}
