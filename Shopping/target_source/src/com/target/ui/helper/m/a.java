// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.m;

import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.ui.service.e;
import com.target.ui.service.k;
import com.target.ui.service.l;
import com.target.ui.service.provider.b;
import com.target.ui.service.provider.m;
import java.util.List;

public class com.target.ui.helper.m.a
{
    public static interface a
    {

        public abstract void a(Guest guest);
    }

    public static interface b
        extends a, c
    {

        public abstract void a(List list);

        public abstract void d();
    }

    public static interface c
    {

        public abstract void e();
    }

    private class d extends h
    {

        private e listener;
        private String storeId;
        final com.target.ui.helper.m.a this$0;

        public void a(com.target.mothership.model.store.interfaces.b b1)
        {
            com.target.mothership.model.a.c.a a1 = b1. new com.target.mothership.model.a.c.a() {

                final d this$1;
                final com.target.mothership.model.store.interfaces.b val$response;

                public int a()
                {
                    return response.b();
                }

                public String b()
                {
                    return response.a();
                }

                public String c()
                {
                    return response.a();
                }

            
            {
                this$1 = final_d1;
                response = com.target.mothership.model.store.interfaces.b.this;
                super();
            }
            };
            com.target.ui.helper.m.a.a(com.target.ui.helper.m.a.this, storeId, b1.b(), a1, 0, listener);
        }

        public void a(x x1)
        {
            listener.c();
        }

        public volatile void a(Object obj)
        {
            a((com.target.mothership.model.store.interfaces.b)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        public d(String s, e e1)
        {
            this$0 = com.target.ui.helper.m.a.this;
            super();
            storeId = s;
            listener = e1;
        }
    }

    public static interface e
        extends a, c
    {

        public abstract void a(com.target.mothership.model.a.c.a a1);

        public abstract void c();
    }


    public static final int REQUEST_ID = 0;
    private com.target.ui.service.provider.b mConnectivityProvider;
    private com.target.ui.service.e mDepartmentAdjacencyService;
    private m mGuestProvider;
    private k mRelevantStoreService;
    private final String mRequestTag = String.valueOf(hashCode());
    private l mRequestTeamMemberService;

    public com.target.ui.helper.m.a(l l1, com.target.ui.service.e e1, k k1, com.target.ui.service.provider.b b1, m m1)
    {
        mRequestTeamMemberService = l1;
        mDepartmentAdjacencyService = e1;
        mRelevantStoreService = k1;
        mConnectivityProvider = b1;
        mGuestProvider = m1;
    }

    static String a(com.target.ui.helper.m.a a1)
    {
        return a1.mRequestTag;
    }

    private String a(String s)
    {
        String s1 = "T";
        int j = s.length();
        for (int i = 0; i < 4 - j; i++)
        {
            s1 = (new StringBuilder()).append(s1).append("0").toString();
        }

        return (new StringBuilder()).append(s1).append(s).toString();
    }

    static void a(com.target.ui.helper.m.a a1, String s, int i, com.target.mothership.model.a.c.a a2, int j, e e1)
    {
        a1.a(s, i, a2, j, e1);
    }

    private void a(String s, int i, final com.target.mothership.model.a.c.a departmentAdjacency, int j, final e listener)
    {
        if (!mConnectivityProvider.a())
        {
            listener.e();
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null || guest.isAnonymous())
        {
            listener.a(guest);
            return;
        } else
        {
            mRequestTeamMemberService.a(guest, a(s), i, j, new com.target.mothership.model.d() {

                final com.target.ui.helper.m.a this$0;
                final com.target.mothership.model.a.c.a val$departmentAdjacency;
                final e val$listener;

                public String a()
                {
                    return com.target.ui.helper.m.a.a(com.target.ui.helper.m.a.this);
                }

                public void a(com.target.mothership.model.d.c.a.a a1)
                {
                    listener.c();
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    listener.a(departmentAdjacency);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.d.c.a.a)obj);
                }

            
            {
                this$0 = com.target.ui.helper.m.a.this;
                listener = e1;
                departmentAdjacency = a2;
                super();
            }
            });
            return;
        }
    }

    public void a()
    {
        mRequestTeamMemberService.a(mRequestTag);
    }

    public void a(String s, int i, int j, e e1)
    {
        mRelevantStoreService.a(s, i, j, new d(s, e1));
    }

    public void a(String s, com.target.mothership.model.a.c.a a1, e e1)
    {
        a(s, a1.a(), a1, 0, e1);
    }

    public void a(String s, final b listener)
    {
        if (!mConnectivityProvider.a())
        {
            listener.e();
            return;
        } else
        {
            mDepartmentAdjacencyService.a(new com.target.mothership.model.d() {

                final com.target.ui.helper.m.a this$0;
                final b val$listener;

                public void a(com.target.mothership.model.a.c.a.a a1)
                {
                    listener.d();
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
                    a((com.target.mothership.model.a.c.a.a)obj);
                }

            
            {
                this$0 = com.target.ui.helper.m.a.this;
                listener = b1;
                super();
            }
            });
            return;
        }
    }
}
