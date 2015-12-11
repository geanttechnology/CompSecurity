// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.l;

import com.target.mothership.common.params.RegistryDetailsParam;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.model.h;
import com.target.mothership.model.registries.c;
import com.target.mothership.model.registries.interfaces.RegistryDetailWrapper;
import com.target.mothership.model.registries.interfaces.RegistrySearchWrapper;
import com.target.mothership.services.x;
import com.target.mothership.util.b;
import com.target.ui.util.q;

public class com.target.ui.helper.l.a
{
    public static interface a
    {

        public abstract void a();
    }

    public static interface b
        extends a
    {

        public abstract void a(RegistryDetailWrapper registrydetailwrapper);

        public abstract void a(x x);
    }

    public static interface c
        extends a
    {

        public abstract void a(RegistrySearchWrapper registrysearchwrapper);

        public abstract void a(x x);
    }


    private static final String TAG = com/target/ui/helper/l/a.getSimpleName();
    private boolean mIsRegistryDetailsRequested;
    private boolean mIsRegistrySummaryRequested;
    private final com.target.mothership.model.registries.c mRegistryManager = new com.target.mothership.model.registries.c();
    private final String mRequestTag = String.valueOf(hashCode());

    public com.target.ui.helper.l.a()
    {
        mIsRegistryDetailsRequested = false;
        mIsRegistrySummaryRequested = false;
    }

    static String a(com.target.ui.helper.l.a a1)
    {
        return a1.mRequestTag;
    }

    static boolean a(com.target.ui.helper.l.a a1, boolean flag)
    {
        a1.mIsRegistryDetailsRequested = flag;
        return flag;
    }

    static boolean b(com.target.ui.helper.l.a a1, boolean flag)
    {
        a1.mIsRegistrySummaryRequested = flag;
        return flag;
    }

    public void a()
    {
        q.c(TAG, "RegistryDataHelper : Cancel Requested");
        mIsRegistrySummaryRequested = false;
        mRegistryManager.a(mRequestTag);
    }

    public void a(RegistryDetailsParam registrydetailsparam, final b listener)
    {
        if (registrydetailsparam == null || listener == null)
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            listener.a();
            return;
        } else
        {
            mIsRegistryDetailsRequested = true;
            mRegistryManager.a(registrydetailsparam, new h() {

                final com.target.ui.helper.l.a this$0;
                final b val$listener;

                public void a(RegistryDetailWrapper registrydetailwrapper)
                {
                    com.target.ui.helper.l.a.a(com.target.ui.helper.l.a.this, false);
                    listener.a(registrydetailwrapper);
                }

                public void a(x x1)
                {
                    com.target.ui.helper.l.a.a(com.target.ui.helper.l.a.this, false);
                    listener.a(x1);
                }

                public volatile void a(Object obj)
                {
                    a((RegistryDetailWrapper)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.l.a.this;
                listener = b1;
                super();
            }
            });
            return;
        }
    }

    public void a(RegistrySearchParam registrysearchparam, final c listener)
    {
        if (registrysearchparam == null || listener == null)
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            listener.a();
            return;
        } else
        {
            mIsRegistrySummaryRequested = true;
            mRegistryManager.a(registrysearchparam, new h() {

                final com.target.ui.helper.l.a this$0;
                final c val$listener;

                public String a()
                {
                    return com.target.ui.helper.l.a.a(com.target.ui.helper.l.a.this);
                }

                public void a(RegistrySearchWrapper registrysearchwrapper)
                {
                    com.target.ui.helper.l.a.b(com.target.ui.helper.l.a.this, false);
                    listener.a(registrysearchwrapper);
                }

                public void a(x x1)
                {
                    com.target.ui.helper.l.a.b(com.target.ui.helper.l.a.this, false);
                    listener.a(x1);
                }

                public volatile void a(Object obj)
                {
                    a((RegistrySearchWrapper)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.l.a.this;
                listener = c1;
                super();
            }
            });
            return;
        }
    }

    public boolean b()
    {
        return mIsRegistryDetailsRequested;
    }

    public boolean c()
    {
        return mIsRegistrySummaryRequested;
    }

}
