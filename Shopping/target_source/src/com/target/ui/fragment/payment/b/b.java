// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.g;
import com.target.mothership.services.o;
import com.target.ui.e.e;
import com.target.ui.fragment.payment.a.a;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.service.provider.m;
import com.target.ui.util.q;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.payment.b:
//            f

public class b
    implements f, com.target.ui.helper.a.a.i
{

    private static final String TAG = com/target/ui/fragment/payment/b/b.getSimpleName();
    private com.target.ui.helper.a.a mDataHelper;
    private m mGuestProvider;
    private a mPresentation;

    public b(com.target.ui.helper.a.a a1, m m1)
    {
        mDataHelper = a1;
        mGuestProvider = m1;
    }

    private void j()
    {
        mPresentation.a(0x7f09027a, true);
    }

    private void k()
    {
        mPresentation.d(true);
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "Tried to refresh the payment card list, but the current session was unexpectedly null");
            mPresentation.e();
            return;
        } else
        {
            mDataHelper.a(guest, this);
            return;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f09008d);
        mPresentation.a(0x7f120001, menu, menuinflater);
    }

    public void a(Guest guest, o o)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.a(guest, o);
            return;
        }
    }

    public void a(g g1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.a(0x7f090085, true);
            return;
        }
    }

    public void a(com.target.ui.fragment.account.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (a1 == null)
        {
            q.a(TAG, "tried to show the snackbar to message some payment card details change, but changeType was null");
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$account$listeners$Change[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$account$listeners$Change = new int[com.target.ui.fragment.account.a.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$account$listeners$Change[com.target.ui.fragment.account.a.a.Create.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$account$listeners$Change[com.target.ui.fragment.account.a.a.Update.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$account$listeners$Change[com.target.ui.fragment.account.a.a.Delete.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.account.listeners.Change[a1.ordinal()])
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Tried to show the snackbar but changeType ").append(a1).append(" was not recognized").toString());
            return;

        case 1: // '\001'
            mPresentation.c(0x7f0903fb);
            return;

        case 2: // '\002'
            mPresentation.c(0x7f0903fd);
            return;

        case 3: // '\003'
            mPresentation.c(0x7f0903fc);
            break;
        }
    }

    public void a(a a1)
    {
        mPresentation = a1;
        mPresentation.a(true);
        mPresentation.c(false);
        mPresentation.e(false);
        k();
    }

    public void a(PaymentCardInformationModel paymentcardinformationmodel)
    {
    }

    public void a(PaymentCardInformationModel paymentcardinformationmodel, String s)
    {
    }

    public volatile void a(Object obj)
    {
        a((a)obj);
    }

    public void a(List list)
    {
        while (mPresentation == null || list != null && !list.isEmpty()) 
        {
            return;
        }
        j();
    }

    public boolean a(e e1)
    {
        mDataHelper.a();
        e1.c(false);
        mPresentation.b();
        return true;
    }

    public void b(PaymentCardInformationModel paymentcardinformationmodel)
    {
        mPresentation.c(paymentcardinformationmodel);
    }

    public void b(List list)
    {
        while (mPresentation == null || list != null && !list.isEmpty()) 
        {
            return;
        }
        j();
    }

    public void c(PaymentCardInformationModel paymentcardinformationmodel)
    {
        mPresentation.c(paymentcardinformationmodel);
    }

    public void c(List list)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.d(false);
        if (list.isEmpty())
        {
            mPresentation.a(0x7f09008f, 0x7f090090);
            return;
        } else
        {
            mPresentation.a(com.target.ui.util.e.a(list));
            return;
        }
    }

    public void d()
    {
        mPresentation.f();
    }

    public void e()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(true);
            return;
        }
    }

    public void f()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            k();
            return;
        }
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
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.e();
            return;
        }
    }

    public void i()
    {
        k();
    }

    public void o_()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.g();
            return;
        }
    }

    public void q_()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.a(0x7f09027b, true);
            return;
        }
    }

    public void v_()
    {
        mDataHelper = null;
        mGuestProvider = null;
    }

    public void z_()
    {
        mDataHelper.a();
        mPresentation = null;
    }

}
