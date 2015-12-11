// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.request_team_member.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.request_team_member.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
    implements com.target.ui.g.a, com.target.ui.helper.m.b, com.target.ui.helper.m.e
{

    private static final int POSITION_NOT_AVAILABLE = -1;
    private List mDepartmentAdjacencyList;
    private com.target.ui.helper.m.e mLocationRequestTeamMemberDataListener;
    private com.target.ui.helper.m.a mRequestTeamMemberDataHelper;
    private com.target.ui.fragment.request_team_member.a.a mRequestTeamMemberPresentation;
    private e mSelectedDepartmentAdjacency;
    private String mStoreId;
    private b mTeamMemberRequestingStatusProvider;
    private int mXPosition;
    private int mYPosition;

    public a(com.target.ui.helper.m.a a1, Store store, b b1, int i1, int j1)
    {
        mXPosition = -1;
        mYPosition = -1;
        mSelectedDepartmentAdjacency = com.google.a.a.e.e();
        mLocationRequestTeamMemberDataListener = new com.target.ui.helper.m.e() {

            final a this$0;

            public void a(com.target.mothership.model.a.c.a a2)
            {
                a.a(a.this, a2);
            }

            public void a(Guest guest)
            {
                a.a(a.this, guest);
            }

            public void c()
            {
                a.a(a.this);
            }

            public void e()
            {
                com.target.ui.fragment.request_team_member.b.a.b(a.this);
            }

            
            {
                this$0 = a.this;
                super();
            }
        };
        mRequestTeamMemberDataHelper = a1;
        mTeamMemberRequestingStatusProvider = b1;
        mStoreId = store.getStoreId().a();
        mXPosition = i1;
        mYPosition = j1;
    }

    static void a(a a1)
    {
        a1.l();
    }

    static void a(a a1, com.target.mothership.model.a.c.a a2)
    {
        a1.c(a2);
    }

    static void a(a a1, Guest guest)
    {
        a1.b(guest);
    }

    private void a(String s, e e1, int i1, int j1)
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        }
        m();
        if (e1.b())
        {
            e1 = (com.target.mothership.model.a.c.a)e1.c();
            mRequestTeamMemberDataHelper.a(s, e1, this);
            return;
        }
        if (i1 != -1 && j1 != -1)
        {
            mRequestTeamMemberDataHelper.a(s, i1, j1, mLocationRequestTeamMemberDataListener);
            return;
        } else
        {
            l();
            return;
        }
    }

    private List b(List list)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            com.target.mothership.model.a.c.a a2 = (com.target.mothership.model.a.c.a)list.next();
            if (a2.a() != -1)
            {
                a1.put(a2.b(), a2);
            }
        } while (true);
        list = new ArrayList(a1.values());
        Collections.sort(list, new Comparator() {

            final a this$0;

            public int a(com.target.mothership.model.a.c.a a3, com.target.mothership.model.a.c.a a4)
            {
                return a3.b().compareTo(a4.b());
            }

            public int compare(Object obj, Object obj1)
            {
                return a((com.target.mothership.model.a.c.a)obj, (com.target.mothership.model.a.c.a)obj1);
            }

            
            {
                this$0 = a.this;
                super();
            }
        });
        return list;
    }

    private void b(Guest guest)
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            mRequestTeamMemberPresentation.d();
            mRequestTeamMemberPresentation.a(guest);
            mRequestTeamMemberPresentation.j();
            return;
        }
    }

    static void b(a a1)
    {
        a1.k();
    }

    private void c(com.target.mothership.model.a.c.a a1)
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            mTeamMemberRequestingStatusProvider.a(new com.target.ui.service.l.a(true, a1));
            d(a1);
            return;
        }
    }

    private void d(com.target.mothership.model.a.c.a a1)
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            mRequestTeamMemberPresentation.d(false);
            mRequestTeamMemberPresentation.b(false);
            mRequestTeamMemberPresentation.c(false);
            mRequestTeamMemberPresentation.e();
            mRequestTeamMemberPresentation.a();
            mRequestTeamMemberPresentation.a(a1.b());
            mRequestTeamMemberPresentation.b(a1);
            return;
        }
    }

    private void k()
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            mRequestTeamMemberPresentation.i();
            return;
        }
    }

    private void l()
    {
        mRequestTeamMemberDataHelper.a(mStoreId, this);
    }

    private void m()
    {
        mRequestTeamMemberPresentation.b(false);
        mRequestTeamMemberPresentation.e();
        mRequestTeamMemberPresentation.d(true);
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(com.target.mothership.model.a.c.a a1)
    {
        c(a1);
    }

    public void a(Guest guest)
    {
        b(guest);
    }

    public void a(com.target.ui.fragment.request_team_member.a.a a1)
    {
        mRequestTeamMemberPresentation = a1;
        a1 = mTeamMemberRequestingStatusProvider.a();
        mSelectedDepartmentAdjacency = a1.b();
        if (a1.a() && mSelectedDepartmentAdjacency.b())
        {
            d((com.target.mothership.model.a.c.a)mSelectedDepartmentAdjacency.c());
            return;
        } else
        {
            a(mStoreId, mSelectedDepartmentAdjacency, mXPosition, mYPosition);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.request_team_member.a.a)obj);
    }

    public void a(List list)
    {
        mDepartmentAdjacencyList = b(list);
        mSelectedDepartmentAdjacency = com.google.a.a.e.c(mDepartmentAdjacencyList.get(0));
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            mRequestTeamMemberPresentation.d(false);
            mRequestTeamMemberPresentation.a(mDepartmentAdjacencyList);
            mRequestTeamMemberPresentation.b(true);
            mRequestTeamMemberPresentation.f();
            mRequestTeamMemberPresentation.a(true);
            return;
        }
    }

    public void b(com.target.mothership.model.a.c.a a1)
    {
        mSelectedDepartmentAdjacency = com.google.a.a.e.c(a1);
    }

    public void c()
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            mRequestTeamMemberPresentation.d(false);
            mRequestTeamMemberPresentation.h();
            mRequestTeamMemberPresentation.g();
            return;
        }
    }

    public void d()
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            mRequestTeamMemberPresentation.d(false);
            mRequestTeamMemberPresentation.k();
            mRequestTeamMemberPresentation.g();
            return;
        }
    }

    public void e()
    {
        k();
    }

    public void f()
    {
        mRequestTeamMemberDataHelper.a();
    }

    public void g()
    {
        a(mStoreId, mSelectedDepartmentAdjacency, mXPosition, mYPosition);
    }

    public void h()
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            f();
            mRequestTeamMemberPresentation.j();
            return;
        }
    }

    public void i()
    {
        a(mStoreId, mSelectedDepartmentAdjacency, mXPosition, mYPosition);
    }

    public void j()
    {
        if (mRequestTeamMemberPresentation == null)
        {
            return;
        } else
        {
            mRequestTeamMemberPresentation.d();
            mRequestTeamMemberPresentation.b();
            mRequestTeamMemberPresentation.c();
            mRequestTeamMemberPresentation.g();
            mRequestTeamMemberPresentation.a(true);
            return;
        }
    }

    public void v_()
    {
        mRequestTeamMemberDataHelper = null;
    }

    public void z_()
    {
        mRequestTeamMemberDataHelper.a();
        mRequestTeamMemberPresentation = null;
    }
}
