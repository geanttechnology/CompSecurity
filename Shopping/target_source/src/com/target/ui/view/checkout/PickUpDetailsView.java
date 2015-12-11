// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.model.checkout.TGTPickUpPersonDetailsModel;
import com.target.ui.service.a;
import com.target.ui.util.al;
import com.target.ui.util.validation.validator.FirstNameValidator;
import com.target.ui.util.validation.validator.LastNameValidator;
import com.target.ui.view.account.b;
import com.target.ui.view.account.c;
import com.target.ui.view.common.NameView;

public class PickUpDetailsView extends LinearLayout
    implements android.view.View.OnClickListener, com.target.ui.view.account.b, c
{
    static class Views extends com.target.ui.view.a
    {

        View pickUpDetailsView;
        NameView pickUpNameView;
        TextView pickUpPersonName;
        View root;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a
        implements com.target.ui.view.common.NameView.f
    {

        String firstName;
        boolean isValid;
        String lastName;
        final PickUpDetailsView this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1)
        {
            firstName = s;
            lastName = s1;
            isValid = true;
        }

        private a()
        {
            this$0 = PickUpDetailsView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(String s, String s1);
    }


    private DeliveryView.a mActionListener;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public PickUpDetailsView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public PickUpDetailsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public PickUpDetailsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void a(boolean flag)
    {
        if (mValidationListener != null)
        {
            mValidationListener.a(this, flag);
        }
    }

    private void b(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        mViews.pickUpNameView.setInputValidationListener(this);
        mViews.pickUpNameView.setInputChangeListener(this);
        mViews.pickUpNameView.setHintText(getResources().getString(0x7f090210));
        mViews.root.setOnClickListener(null);
        if (o.g(pickuppersondetailsmodel.c()))
        {
            mViews.pickUpNameView.a(pickuppersondetailsmodel.c(), pickuppersondetailsmodel.d());
        }
        al.a(mViews.pickUpNameView, new View[] {
            mViews.pickUpDetailsView
        });
    }

    private void c(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        if (o.g(pickuppersondetailsmodel.c()))
        {
            StringBuilder stringbuilder = new StringBuilder(pickuppersondetailsmodel.c());
            stringbuilder.append(" ");
            stringbuilder.append(pickuppersondetailsmodel.d());
            al.a(mViews.pickUpPersonName, stringbuilder);
        }
        mViews.root.setOnClickListener(this);
        al.a(mViews.pickUpDetailsView, new View[] {
            mViews.pickUpNameView
        });
        a(true);
    }

    private Guest getCurrentGuest()
    {
        com.target.ui.service.a a1 = com.target.ui.service.a.a();
        if (a1.c().b())
        {
            return (Guest)a1.c().c();
        } else
        {
            return null;
        }
    }

    public void a()
    {
        for (Guest guest = getCurrentGuest(); guest == null || !guest.isAnonymous();)
        {
            return;
        }

        mViews.pickUpNameView.b();
    }

    public void a(Context context)
    {
        mViews = new Views(LayoutInflater.from(context).inflate(0x7f030137, this, true));
        mViews.pickUpNameView.setFirstNameValidator(new FirstNameValidator(getContext()));
        mViews.pickUpNameView.setLastNameValidator(new LastNameValidator(getContext()));
    }

    public void a(View view, boolean flag)
    {
        if (view.getId() == mViews.pickUpNameView.getId())
        {
            a(flag);
        }
    }

    public void a(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        if (pickuppersondetailsmodel.b())
        {
            c(pickuppersondetailsmodel);
            return;
        } else
        {
            b(pickuppersondetailsmodel);
            return;
        }
    }

    public void a(PickUpPersonDetailsModel pickuppersondetailsmodel, DeliveryView.a a1)
    {
        mActionListener = a1;
        if (pickuppersondetailsmodel.b())
        {
            c(pickuppersondetailsmodel);
            return;
        } else
        {
            b(pickuppersondetailsmodel);
            return;
        }
    }

    public void a(b b1)
    {
        a a1 = new a();
        mViews.pickUpNameView.a(a1);
        if (a1.isValid)
        {
            b1.a(a1.firstName, a1.lastName);
            return;
        } else
        {
            b1.a();
            return;
        }
    }

    public void a(boolean flag, String s, String s1)
    {
        if (flag && o.g(s) && o.g(s1))
        {
            TGTPickUpPersonDetailsModel tgtpickuppersondetailsmodel = new TGTPickUpPersonDetailsModel();
            tgtpickuppersondetailsmodel.a(true);
            tgtpickuppersondetailsmodel.b(false);
            tgtpickuppersondetailsmodel.a(s);
            tgtpickuppersondetailsmodel.b(s1);
            if (mActionListener != null)
            {
                mActionListener.a(tgtpickuppersondetailsmodel);
                return;
            }
        }
    }

    public void onClick(View view)
    {
        if (view == null || mActionListener == null)
        {
            return;
        } else
        {
            mActionListener.j();
            return;
        }
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
