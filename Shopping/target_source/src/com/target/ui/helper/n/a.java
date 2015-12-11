// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.n;

import com.target.mothership.common.params.c;
import com.target.mothership.model.bazaar_voice.b;
import com.target.mothership.model.bazaar_voice.interfaces.ProductReviewWrapper;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.ui.util.q;

public class com.target.ui.helper.n.a
{
    public static interface a
    {

        public abstract void a(ProductReviewWrapper productreviewwrapper);

        public abstract void e();

        public abstract void f();
    }


    private static final String TAG = com/target/ui/helper/n/a.getSimpleName();
    private static final String TAG_GET_GUEST = "tag_review";
    private b mBazaarVoiceManager;
    private boolean mIsDataRequested;
    private a mListener;

    public com.target.ui.helper.n.a(a a1)
    {
        mListener = a1;
        mBazaarVoiceManager = new b();
        mIsDataRequested = false;
    }

    static a a(com.target.ui.helper.n.a a1)
    {
        return a1.mListener;
    }

    static boolean a(com.target.ui.helper.n.a a1, boolean flag)
    {
        a1.mIsDataRequested = flag;
        return flag;
    }

    static String c()
    {
        return TAG;
    }

    public void a()
    {
        if (mBazaarVoiceManager == null)
        {
            return;
        } else
        {
            mIsDataRequested = false;
            mBazaarVoiceManager.a("tag_review");
            return;
        }
    }

    public void a(c c1)
    {
        if (mListener == null)
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            mListener.f();
            return;
        } else
        {
            mIsDataRequested = true;
            mBazaarVoiceManager.a(c1, new h() {

                final com.target.ui.helper.n.a this$0;

                public String a()
                {
                    return "tag_review";
                }

                public void a(ProductReviewWrapper productreviewwrapper)
                {
                    com.target.ui.helper.n.a.a(com.target.ui.helper.n.a.this, false);
                    com.target.ui.helper.n.a.a(com.target.ui.helper.n.a.this).a(productreviewwrapper);
                }

                public void a(x x1)
                {
                    q.a(com.target.ui.helper.n.a.c(), (new StringBuilder()).append("Failed to load the product review : ").append(x1.getMessage()).toString());
                    com.target.ui.helper.n.a.a(com.target.ui.helper.n.a.this, false);
                    com.target.ui.helper.n.a.a(com.target.ui.helper.n.a.this).e();
                }

                public volatile void a(Object obj)
                {
                    a((ProductReviewWrapper)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.n.a.this;
                super();
            }
            });
            return;
        }
    }

    public boolean b()
    {
        return mIsDataRequested;
    }

}
