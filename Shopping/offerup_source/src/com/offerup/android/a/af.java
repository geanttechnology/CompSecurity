// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.offerup.android.activities.PaymentMethodsActivity;
import com.offerup.android.dto.CreditCard;
import com.offerup.android.dto.GoogleWalletMetaData;
import com.offerup.android.dto.PaymentMethod;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.a:
//            ag

public final class af extends BaseAdapter
{

    private List a;
    private LayoutInflater b;
    private PaymentMethodsActivity c;

    public af(PaymentMethodsActivity paymentmethodsactivity, List list)
    {
        a = list;
        c = paymentmethodsactivity;
        b = LayoutInflater.from(paymentmethodsactivity.getApplicationContext());
    }

    public final PaymentMethod a(int i)
    {
        return (PaymentMethod)a.get(i);
    }

    public final int getCount()
    {
        if (a != null)
        {
            return a.size();
        } else
        {
            return 0;
        }
    }

    public final Object getItem(int i)
    {
        return a(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        String s;
        if (view == null)
        {
            view = b.inflate(0x7f040070, null);
            viewgroup = new ag();
            viewgroup.a = (ImageView)view.findViewById(0x7f1001c6);
            viewgroup.b = (TextView)view.findViewById(0x7f1001c7);
            viewgroup.c = (TextView)view.findViewById(0x7f1001ca);
            viewgroup.d = view.findViewById(0x7f1001c9);
            viewgroup.e = view.findViewById(0x7f1001c8);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ag)view.getTag();
        }
        obj = (PaymentMethod)a.get(i);
        if (((PaymentMethod) (obj)).isDefaultPaymentMethod().booleanValue())
        {
            ((ag) (viewgroup)).e.setVisibility(0);
        }
        if (((PaymentMethod) (obj)).getCreditCard() == null) goto _L2; else goto _L1
_L1:
        viewgroup.a();
        obj = ((PaymentMethod) (obj)).getCreditCard();
        if (!StringUtils.isNotEmpty(((CreditCard) (obj)).getCardType())) goto _L4; else goto _L3
_L3:
        ((ag) (viewgroup)).d.setVisibility(0);
        ((ag) (viewgroup)).c.setVisibility(0);
        s = ((CreditCard) (obj)).getCardType();
        if (!StringUtils.isNotEmpty(s)) goto _L6; else goto _L5
_L5:
        s = s.toLowerCase();
        if (!s.contains("visa")) goto _L8; else goto _L7
_L7:
        i = 0x7f0201a4;
_L10:
        if (i > 0)
        {
            ((ag) (viewgroup)).a.setVisibility(0);
            ((ag) (viewgroup)).a.setImageResource(i);
        } else
        {
            ((ag) (viewgroup)).a.setVisibility(4);
        }
_L4:
        ((ag) (viewgroup)).b.setText(((CreditCard) (obj)).getDisplayName());
        ((ag) (viewgroup)).c.setText(((CreditCard) (obj)).getLastFour());
        return view;
_L8:
        if (s.contains("ame"))
        {
            i = 0x7f02019f;
            continue; /* Loop/switch isn't completed */
        }
        if (s.contains("mast"))
        {
            i = 0x7f0201a3;
            continue; /* Loop/switch isn't completed */
        }
        if (s.contains("disc"))
        {
            i = 0x7f0201a1;
            continue; /* Loop/switch isn't completed */
        }
        if (s.contains("jcb"))
        {
            i = 0x7f0201a2;
            continue; /* Loop/switch isn't completed */
        }
        if (s.contains("diner"))
        {
            i = 0x7f0201a0;
            continue; /* Loop/switch isn't completed */
        }
          goto _L6
_L2:
        if (((PaymentMethod) (obj)).isAndroidPay())
        {
            viewgroup.a();
            c.c(true);
            ((ag) (viewgroup)).a.setImageResource(0x7f020126);
            obj = ((PaymentMethod) (obj)).getGoogleWalletMetaData();
            if (obj != null)
            {
                ((ag) (viewgroup)).b.setText((new StringBuilder()).append(c.getString(0x7f0901ab)).append(System.getProperty("line.separator")).append(((GoogleWalletMetaData) (obj)).getDisplayName()).toString());
                ((ag) (viewgroup)).c.setText(((GoogleWalletMetaData) (obj)).getLastFour());
                return view;
            } else
            {
                ((ag) (viewgroup)).b.setText(c.getString(0x7f0901ab));
                return view;
            }
        } else
        {
            ((ag) (viewgroup)).a.setVisibility(8);
            ((ag) (viewgroup)).b.setVisibility(8);
            ((ag) (viewgroup)).d.setVisibility(8);
            ((ag) (viewgroup)).c.setVisibility(8);
            ((ag) (viewgroup)).e.setVisibility(8);
            return view;
        }
_L6:
        i = 0;
        if (true) goto _L10; else goto _L9
_L9:
    }
}
