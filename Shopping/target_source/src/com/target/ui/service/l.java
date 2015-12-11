// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.google.a.a.e;
import com.target.mothership.model.d;
import com.target.mothership.model.d.c;
import com.target.mothership.model.d.c.a.a;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.analytics.a.j;

// Referenced classes of package com.target.ui.service:
//            RequestTeamMemberAlarmManager

public class l
{
    public static class a
    {

        private e mDepartmentAdjacency;
        private boolean mRequesting;

        public boolean a()
        {
            return mRequesting;
        }

        public e b()
        {
            return mDepartmentAdjacency;
        }

        public a(boolean flag, com.target.mothership.model.a.c.a a1)
        {
            mDepartmentAdjacency = e.e();
            mDepartmentAdjacency = e.c(a1);
            mRequesting = flag;
        }
    }


    private static l sInstance;
    private RequestTeamMemberAlarmManager mRequestTeamMemberAlarmManager;
    private c mRequestTeamMemberManager;
    private a mStatus;

    private l(RequestTeamMemberAlarmManager requestteammemberalarmmanager)
    {
        mRequestTeamMemberAlarmManager = requestteammemberalarmmanager;
        mRequestTeamMemberManager = new c();
        mStatus = new a(false, null);
    }

    static RequestTeamMemberAlarmManager a(l l1)
    {
        return l1.mRequestTeamMemberAlarmManager;
    }

    public static l a(RequestTeamMemberAlarmManager requestteammemberalarmmanager)
    {
        if (sInstance == null)
        {
            sInstance = new l(requestteammemberalarmmanager);
        }
        return sInstance;
    }

    public a a()
    {
        return mStatus;
    }

    public void a(Guest guest, String s, int i, int k, d d1)
    {
        if (mStatus.a())
        {
            d1.b(new com.target.mothership.model.d.c.a.a());
            return;
        } else
        {
            d1 = new d() {

                final l this$0;
                final j val$errorReportingReceiver;

                public void a(com.target.mothership.model.d.c.a.a a1)
                {
                    errorReportingReceiver.a(a1);
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    errorReportingReceiver.a(void1);
                    com.target.ui.service.l.a(l.this).a();
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.d.c.a.a)obj);
                }

            
            {
                this$0 = l.this;
                errorReportingReceiver = j1;
                super();
            }
            };
            mRequestTeamMemberManager.a(guest, s, i, k, d1);
            return;
        }
    }

    public void a(a a1)
    {
        mStatus = a1;
    }

    public void a(String s)
    {
        mRequestTeamMemberManager.a(s);
    }
}
