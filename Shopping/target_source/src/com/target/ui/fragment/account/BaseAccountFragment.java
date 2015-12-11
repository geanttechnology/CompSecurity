// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.os.Bundle;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.c;
import com.target.mothership.model.guest.interfaces.a.d;
import com.target.mothership.services.o;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.helper.a.a;

public abstract class BaseAccountFragment extends BaseNavigationFragment
{
    private class a
        implements com.target.ui.helper.a.a.b
    {

        final BaseAccountFragment this$0;

        public void a()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                c();
                return;
            }
        }

        public void a(Guest guest, o o)
        {
        }

        public void a(d d1)
        {
            if (getView() == null)
            {
                return;
            } else
            {
                BaseAccountFragment.this.a(d1);
                return;
            }
        }

        public void o_()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                b();
                return;
            }
        }

        public void q_()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                d();
                return;
            }
        }

        private a()
        {
            this$0 = BaseAccountFragment.this;
            super();
        }

    }

    private class b
        implements com.target.ui.helper.a.a.e
    {

        final BaseAccountFragment this$0;

        public void a()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                e();
                return;
            }
        }

        public void a(Guest guest, o o)
        {
        }

        public void a(com.target.mothership.model.guest.interfaces.a.c c1)
        {
            if (getView() == null)
            {
                return;
            } else
            {
                BaseAccountFragment.this.a(c1);
                return;
            }
        }

        public void o_()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                b();
                return;
            }
        }

        public void q_()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                d();
                return;
            }
        }

        private b()
        {
            this$0 = BaseAccountFragment.this;
            super();
        }

    }

    private class c
        implements com.target.ui.helper.a.a.f
    {

        final BaseAccountFragment this$0;

        public void a()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                f();
                return;
            }
        }

        public void a(Guest guest, o o)
        {
        }

        public void d()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                g();
                return;
            }
        }

        public void o_()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                b();
                return;
            }
        }

        public void q_()
        {
        }

        private c()
        {
            this$0 = BaseAccountFragment.this;
            super();
        }

    }


    private com.target.ui.helper.a.a mAccountDataHelper;

    public BaseAccountFragment()
    {
    }

    protected void a(com.target.mothership.model.guest.interfaces.a.c c1)
    {
    }

    protected void a(d d1)
    {
    }

    protected void a(String s, String s1)
    {
        mAccountDataHelper.a(s, s1, new b());
    }

    protected void a(String s, String s1, String s2, String s3, boolean flag)
    {
        mAccountDataHelper.a(s, s1, s2, s3, flag, new a());
    }

    protected void b()
    {
    }

    protected void c()
    {
    }

    protected void d()
    {
    }

    protected void e()
    {
    }

    protected void f()
    {
    }

    protected void g()
    {
    }

    protected void h()
    {
        if (mAccountDataHelper == null)
        {
            return;
        } else
        {
            mAccountDataHelper.a();
            return;
        }
    }

    protected void i()
    {
        mAccountDataHelper.a(new c());
    }

    protected Guest j()
    {
        return mAccountDataHelper.b();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(false);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAccountDataHelper = new com.target.ui.helper.a.a();
    }

    public void onDestroy()
    {
        super.onDestroy();
        mAccountDataHelper = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        h();
    }
}
