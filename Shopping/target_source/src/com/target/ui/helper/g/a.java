// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.g;

import com.target.mothership.model.dvm.c;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.mothership.util.b;
import com.target.ui.util.q;

public class com.target.ui.helper.g.a
{
    public static interface a
    {

        public abstract void b(DvmDataResponse dvmdataresponse);

        public abstract void b(x x);

        public abstract void n();
    }

    public static interface b
    {

        public abstract void a(Void void1);

        public abstract void c(x x);
    }


    private static final String TAG = com/target/ui/helper/g/a.getSimpleName();
    private final c mDvmManager = new c();
    private final String mRequestTag = String.valueOf(hashCode());

    public com.target.ui.helper.g.a()
    {
    }

    static String a(com.target.ui.helper.g.a a1)
    {
        return a1.mRequestTag;
    }

    public void a()
    {
        q.c(TAG, "DvmDataHelper : Cancel Requested");
        mDvmManager.a(mRequestTag);
    }

    public void a(DvmRemoteData dvmremotedata, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.n();
            return;
        } else
        {
            mDvmManager.a(dvmremotedata, new h() {

                final com.target.ui.helper.g.a this$0;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.g.a.a(com.target.ui.helper.g.a.this);
                }

                public void a(DvmDataResponse dvmdataresponse)
                {
                    listener.b(dvmdataresponse);
                }

                public void a(x x1)
                {
                    listener.b(x1);
                }

                public volatile void a(Object obj)
                {
                    a((DvmDataResponse)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.g.a.this;
                listener = a2;
                super();
            }
            });
            return;
        }
    }

    public void a(String s, final b listener)
    {
        if (listener == null)
        {
            q.a(TAG, "DvmDataListener can't be null");
            return;
        } else
        {
            mDvmManager.a(s, new h() {

                final com.target.ui.helper.g.a this$0;
                final b val$listener;

                public String a()
                {
                    return com.target.ui.helper.g.a.a(com.target.ui.helper.g.a.this);
                }

                public void a(x x1)
                {
                    listener.c(x1);
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    listener.a(void1);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.g.a.this;
                listener = b1;
                super();
            }
            });
            return;
        }
    }

}
