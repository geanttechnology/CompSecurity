// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PersonName;
import com.target.mothership.util.o;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import com.target.ui.util.u;
import java.util.List;

public class ShippingAddressAdapter extends e
    implements android.view.View.OnClickListener
{
    static class ViewHolder extends com.target.ui.view.a
    {

        RadioButton addressChoice;
        ImageView checkoutImageView;
        ImageButton editAddressButton;
        TextView mainAddressView;
        int position;
        View root;
        TextView secondaryTextView;

        ViewHolder(View view)
        {
            super(view);
            position = -1;
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(GuestAddress guestaddress);
    }


    private static final int ADDRESS_LINE_1_INDEX = 0;
    private static final int ADDRESS_LINE_2_INDEX = 1;
    private static final int DEFAULT_SELECTION = 0;
    private static final int NULL_INT = -1;
    private final List mGuestAddressList;
    private final a mListener;
    private boolean mSelectable;
    private int mSelectedPosition;

    public ShippingAddressAdapter(Context context, List list, a a1, boolean flag)
    {
        super(context, list);
        mSelectedPosition = 0;
        mGuestAddressList = list;
        mListener = a1;
        mSelectable = flag;
        c();
    }

    private void a(TextView textview)
    {
        al.a(textview, getContext().getText(0x7f09009c));
        textview.setTextColor(getContext().getResources().getColor(0x7f0f00ec));
    }

    private void a(TextView textview, GuestAddress guestaddress)
    {
        if (!mSelectable && guestaddress.e().booleanValue())
        {
            a(textview);
            return;
        } else
        {
            b(textview, guestaddress);
            return;
        }
    }

    private boolean a(GuestAddress guestaddress)
    {
        return o.g(guestaddress.a()) && (guestaddress.getAddressLines() == null || guestaddress.getAddressLines().isEmpty());
    }

    private void b(TextView textview, GuestAddress guestaddress)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (a(guestaddress))
        {
            stringbuilder.append(getContext().getString(0x7f090250));
        } else
        {
            stringbuilder.append(guestaddress.getCity());
            stringbuilder.append(", ");
            stringbuilder.append(guestaddress.getStateOrProvince());
            stringbuilder.append(" ");
            stringbuilder.append(guestaddress.getPostalCode());
        }
        al.a(textview, stringbuilder.toString());
        textview.setTextColor(getContext().getResources().getColor(0x7f0f00f6));
    }

    private void c()
    {
        mSelectedPosition = 0;
        mListener.a((GuestAddress)mGuestAddressList.get(mSelectedPosition));
    }

    private void c(TextView textview, GuestAddress guestaddress)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!a(guestaddress)) goto _L2; else goto _L1
_L1:
        if (guestaddress.c().b())
        {
            guestaddress = ((PersonName)guestaddress.c().c()).a();
        } else
        {
            guestaddress = "";
        }
        stringbuilder.append(getContext().getString(0x7f090252, new Object[] {
            guestaddress
        }));
_L4:
        al.a(textview, stringbuilder.toString());
        return;
_L2:
        guestaddress = guestaddress.getAddressLines();
        stringbuilder.append((String)guestaddress.get(0));
        if (guestaddress.size() > 1 && o.g((String)guestaddress.get(1)))
        {
            stringbuilder.append(", ");
            stringbuilder.append((String)guestaddress.get(1));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean a()
    {
        return mSelectedPosition != 0;
    }

    public GuestAddress b()
    {
        return (GuestAddress)mGuestAddressList.get(mSelectedPosition);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
        GuestAddress guestaddress = (GuestAddress)getItem(i);
        if (view == null)
        {
            view = mInflater.inflate(0x7f03013f, null, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
            view.setOnClickListener(this);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        viewgroup.position = i;
        if (mSelectable)
        {
            al.c(((ViewHolder) (viewgroup)).checkoutImageView);
            RadioButton radiobutton = ((ViewHolder) (viewgroup)).addressChoice;
            if (i == mSelectedPosition)
            {
                flag = true;
            }
            radiobutton.setChecked(flag);
            ((ViewHolder) (viewgroup)).addressChoice.setTag(viewgroup);
            ((ViewHolder) (viewgroup)).addressChoice.setOnClickListener(this);
        } else
        {
            al.b(((ViewHolder) (viewgroup)).checkoutImageView);
        }
        c(((ViewHolder) (viewgroup)).mainAddressView, guestaddress);
        a(((ViewHolder) (viewgroup)).secondaryTextView, guestaddress);
        if (a(guestaddress))
        {
            al.d(((ViewHolder) (viewgroup)).editAddressButton);
            return view;
        } else
        {
            al.b(((ViewHolder) (viewgroup)).editAddressButton);
            ((ViewHolder) (viewgroup)).editAddressButton.setTag(viewgroup);
            ((ViewHolder) (viewgroup)).editAddressButton.setOnClickListener(this);
            return view;
        }
    }

    public void onClick(View view)
    {
        ViewHolder viewholder = (ViewHolder)u.a(view.getTag(), com/target/ui/adapter/checkout/ShippingAddressAdapter$ViewHolder);
        if (mSelectedPosition != viewholder.position)
        {
            mSelectedPosition = viewholder.position;
            mListener.a((GuestAddress)mGuestAddressList.get(mSelectedPosition));
            notifyDataSetChanged();
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131756001: 
            mListener.a();
            break;
        }
    }
}
