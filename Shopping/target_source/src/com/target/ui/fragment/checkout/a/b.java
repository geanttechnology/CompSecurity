// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout.a;

import com.google.a.a.e;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.mothership.model.coupon_wallets.interfaces.a;
import com.target.mothership.util.o;
import com.target.ui.helper.c.c;
import com.target.ui.service.provider.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.fragment.checkout.a:
//            a

public class b
    implements com.target.ui.fragment.checkout.a.a, com.target.ui.helper.c.c.b, com.target.ui.helper.c.c.c
{

    private c mCheckoutDataHelper;
    private com.target.ui.fragment.checkout.d.a mCheckoutModelHolder;
    private com.target.ui.fragment.checkout.d.b mCheckoutPresentation;
    private m mGuestProvider;

    public b(com.target.ui.fragment.checkout.d.b b1, m m1, c c1, com.target.ui.fragment.checkout.d.a a1)
    {
        mCheckoutPresentation = b1;
        mGuestProvider = m1;
        mCheckoutDataHelper = c1;
        mCheckoutModelHolder = a1;
    }

    private void a(int i)
    {
        mCheckoutPresentation.h(true);
        mCheckoutPresentation.i(false);
        mCheckoutPresentation.b(0x7f09029d, i);
        mCheckoutPresentation.D();
    }

    private void a(WalletItem walletitem)
    {
        mCheckoutPresentation.h(false);
        mCheckoutPresentation.i(true);
        c(walletitem);
        mCheckoutPresentation.D();
    }

    private void b(WalletItem walletitem)
    {
        mCheckoutPresentation.h(false);
        mCheckoutPresentation.i(false);
        c(walletitem);
        mCheckoutPresentation.g(0x7f090296);
    }

    private void c(WalletItem walletitem)
    {
        walletitem = (String)walletitem.c().d();
        if (o.g(walletitem))
        {
            mCheckoutPresentation.h(walletitem);
            return;
        } else
        {
            mCheckoutPresentation.f(0x7f090297);
            return;
        }
    }

    private void d(List list)
    {
        if (mCheckoutPresentation != null)
        {
            mCheckoutPresentation.B();
            Object obj = f(list);
            list = (List)((Map) (obj)).get(a.ACTIVE);
            obj = (List)((Map) (obj)).get(a.APPLIED);
            int i = ((List) (obj)).size();
            int j = list.size();
            int k = j + i;
            if (i == 0 && j == 1)
            {
                a((WalletItem)list.get(0));
                return;
            }
            if (i == 1 && j == 0)
            {
                b((WalletItem)((List) (obj)).get(0));
                return;
            }
            if (k > 0)
            {
                a(k);
            }
            if (i > 0)
            {
                e(((List) (obj)));
                return;
            }
        }
    }

    private void e(List list)
    {
        mCheckoutPresentation.d(list);
    }

    private Map f(List list)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        if (list != null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                WalletItem walletitem = (WalletItem)list.next();
                Object obj = walletitem.e();
                if (((e) (obj)).b())
                {
                    obj = (a)((e) (obj)).c();
                    if (a.ACTIVE.equals(obj))
                    {
                        arraylist.add(walletitem);
                    } else
                    if (a.APPLIED.equals(obj))
                    {
                        arraylist1.add(walletitem);
                    }
                }
            } while (true);
        }
        a1.put(a.ACTIVE, arraylist);
        a1.put(a.APPLIED, arraylist1);
        return a1;
    }

    public void a()
    {
        mCheckoutDataHelper.b();
        mCheckoutPresentation = null;
    }

    public void a(com.target.mothership.model.coupon_wallets.interfaces.a.b b1)
    {
        mCheckoutModelHolder.h(null);
        if (mCheckoutPresentation == null)
        {
            return;
        } else
        {
            mCheckoutPresentation.C();
            mCheckoutPresentation.c(0x7f09029b);
            return;
        }
    }

    public void a(List list)
    {
        if (mCheckoutPresentation != null)
        {
            if (list == null || list.isEmpty())
            {
                mCheckoutPresentation.C();
                list = mGuestProvider.a();
                if (list != null)
                {
                    mCheckoutDataHelper.a(list, this, this);
                    return;
                }
            } else
            {
                d(list);
                return;
            }
        }
    }

    public void b()
    {
        com.target.mothership.model.guest.interfaces.Guest guest = mGuestProvider.a();
        if (guest != null)
        {
            mCheckoutDataHelper.a(guest, this, this);
        }
    }

    public void b(List list)
    {
        if (mCheckoutPresentation == null)
        {
            return;
        } else
        {
            list = f(list);
            ArrayList arraylist = new ArrayList();
            arraylist.addAll((Collection)list.get(a.ACTIVE));
            arraylist.addAll((Collection)list.get(a.APPLIED));
            mCheckoutPresentation.a(arraylist);
            return;
        }
    }

    public void c()
    {
        if (mCheckoutPresentation == null)
        {
            return;
        } else
        {
            mCheckoutPresentation.w();
            return;
        }
    }

    public void c(List list)
    {
        mCheckoutModelHolder.h(list);
        if (mCheckoutPresentation == null)
        {
            return;
        }
        if (mCheckoutModelHolder.O())
        {
            mCheckoutModelHolder.l(false);
            mCheckoutPresentation.e(0x7f09029c);
            mCheckoutModelHolder.b(null);
        }
        if (list.isEmpty())
        {
            mCheckoutPresentation.C();
            return;
        } else
        {
            d(list);
            return;
        }
    }
}
