// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.cart.interfaces.a.l;
import com.target.mothership.model.cart.interfaces.a.z;
import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.g.a;
import com.target.ui.helper.b.d;
import com.target.ui.service.provider.m;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;
import java.util.List;

public class b
    implements a, com.target.ui.helper.b.d.a
{

    private static final String TAG = com/target/ui/fragment/cart/b/b.getSimpleName();
    private d mDataHelper;
    private m mGuestProvider;
    private com.target.ui.fragment.cart.a.b mPresentation;

    public b(d d1, m m1)
    {
        mDataHelper = d1;
        mGuestProvider = m1;
    }

    private void b(List list)
    {
        if (list.isEmpty())
        {
            mPresentation.g();
            return;
        } else
        {
            mPresentation.a(list);
            return;
        }
    }

    private void m()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "tried to refresh the saved for later list but the current session is null");
            mPresentation.b();
            return;
        } else
        {
            mPresentation.a(true);
            mDataHelper.a(guest, this);
            return;
        }
    }

    public void a(int i1)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.a(false);
        switch (i1)
        {
        default:
            mPresentation.b(0x7f09027b);
            return;

        case 60: // '<'
            mPresentation.h();
            break;
        }
    }

    public void a(int i1, Guest guest, o o)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.a(false);
        if (i1 == 60)
        {
            mPresentation.h();
        }
        mPresentation.a(guest, o);
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0904d3);
        mPresentation.a(menu, menuinflater, 0x7f120005);
    }

    public void a(SaveForLaterProduct saveforlaterproduct)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "tried to add a saved product to cart, but the current session was null");
            mPresentation.b();
            return;
        } else
        {
            mPresentation.o();
            mPresentation.a(true);
            mDataHelper.a(guest, saveforlaterproduct, this);
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.b b1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.b(0x7f0904da);
            return;
        }
    }

    public void a(l l1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.h();
            return;
        }
    }

    public void a(z z)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.i();
            return;
        }
    }

    public void a(com.target.ui.fragment.cart.a.b b1)
    {
        mPresentation = b1;
        m();
    }

    public void a(BitmapImageView bitmapimageview, SaveForLaterProduct saveforlaterproduct)
    {
        saveforlaterproduct = new com.target.ui.c.d.d(saveforlaterproduct.k_(), saveforlaterproduct.a().a());
        saveforlaterproduct.a(bitmapimageview);
        mPresentation.a(saveforlaterproduct);
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.cart.a.b)obj);
    }

    public void a(List list)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            b(list);
            return;
        }
    }

    public void b(SaveForLaterProduct saveforlaterproduct)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "tried to delete a saved product, but the current session was null");
            mPresentation.b();
            return;
        } else
        {
            mPresentation.k();
            mPresentation.a(true);
            mDataHelper.b(guest, saveforlaterproduct, this);
            return;
        }
    }

    public void c()
    {
        m();
    }

    public void d()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(true);
            return;
        }
    }

    public void e()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            m();
            return;
        }
    }

    public void f()
    {
    }

    public void g()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.e();
            return;
        }
    }

    public void h()
    {
    }

    public void i()
    {
    }

    public void j()
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.c(0x7f0904d7);
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            mPresentation.e();
            return;
        } else
        {
            mDataHelper.a(guest, this);
            return;
        }
    }

    public void k()
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.c(0x7f0904d5);
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            mPresentation.e();
            return;
        } else
        {
            mDataHelper.a(guest, this);
            return;
        }
    }

    public void l()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.j();
            return;
        }
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }

}
