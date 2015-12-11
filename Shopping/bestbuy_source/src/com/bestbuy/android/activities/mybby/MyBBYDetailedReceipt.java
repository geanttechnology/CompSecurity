// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.mybby.Transaction;
import com.bestbuy.android.api.lib.models.remix.Store;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import jx;
import kf;
import lu;
import nb;

public class MyBBYDetailedReceipt extends BBYBaseFragment
{

    private String a;
    private Transaction b;
    private LayoutInflater c;
    private BBYTextView g;
    private BBYTextView h;
    private BBYTextView i;
    private LinearLayout j;
    private BBYTextView k;
    private BBYTextView l;
    private LinearLayout m;
    private String n;
    private View o;
    private View p;
    private String q;
    private BBYTextView r;
    private BBYTextView s;

    private String a(double d1)
    {
        return a((new StringBuilder()).append("").append(d1).toString());
    }

    static String a(MyBBYDetailedReceipt mybbydetailedreceipt)
    {
        return mybbydetailedreceipt.q;
    }

    private String a(String s1)
    {
        String s2 = String.format("%.2f", new Object[] {
            Float.valueOf(s1), Locale.getDefault()
        });
        s1 = s2;
_L2:
        return (new StringBuilder()).append("$").append(s1).toString();
        Exception exception;
        exception;
        kf.c(a, (new StringBuilder()).append("Error attempting to parse price.  Continuing with poorly formatted price: ").append(exception.getLocalizedMessage()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(Context context, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>Do you want to call the Store?</font>"));
        builder.setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'>Yes</font>"), new android.content.DialogInterface.OnClickListener(s1, context) {

            final String a;
            final Context b;
            final MyBBYDetailedReceipt c;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder()).append("tel:").append(a).toString()));
                b.startActivity(intent);
                dialoginterface.cancel();
            }

            
            {
                c = MyBBYDetailedReceipt.this;
                a = s1;
                b = context;
                super();
            }
        });
        builder.setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>No</font>"), new android.content.DialogInterface.OnClickListener() {

            final MyBBYDetailedReceipt a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.cancel();
            }

            
            {
                a = MyBBYDetailedReceipt.this;
                super();
            }
        });
        builder.create();
        builder.show();
    }

    static void a(MyBBYDetailedReceipt mybbydetailedreceipt, Context context, String s1)
    {
        mybbydetailedreceipt.a(context, s1);
    }

    private double b()
    {
        double d1;
        try
        {
            d1 = Double.valueOf(b.getTotalRevenue()).doubleValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            kf.a(a, numberformatexception);
            return 0.0D;
        }
        return d1;
    }

    private double c()
    {
        if (!b.getTotalTax().equalsIgnoreCase(getString(0x7f080068)))
        {
            return Double.parseDouble(b.getTotalTax());
        } else
        {
            return Double.parseDouble("0.0");
        }
    }

    private String d()
    {
        return (new DecimalFormat("0.00")).format(b() + c());
    }

    public void a(Store store)
    {
label0:
        {
            LinearLayout linearlayout = (LinearLayout)o.findViewById(0x7f0c01ab);
            ArrayList arraylist = b.getSaleLineItems();
            Iterator iterator = arraylist.iterator();
            int i1 = 0;
            while (iterator.hasNext()) 
            {
                com.bestbuy.android.api.lib.models.mybby.Transaction.TransactionLineItem transactionlineitem = (com.bestbuy.android.api.lib.models.mybby.Transaction.TransactionLineItem)iterator.next();
                View view = c.inflate(0x7f03007b, null);
                r.setVisibility(0);
                s.setVisibility(0);
                Object obj = (BBYTextView)view.findViewById(0x7f0c01cf);
                ((BBYTextView) (obj)).setVisibility(0);
                BBYTextView bbytextview = (BBYTextView)view.findViewById(0x7f0c01d0);
                bbytextview.setVisibility(0);
                BBYTextView bbytextview1 = (BBYTextView)view.findViewById(0x7f0c01d1);
                bbytextview1.setVisibility(0);
                ImageView imageview = (ImageView)view.findViewById(0x7f0c01d2);
                imageview.setVisibility(0);
                linearlayout.addView(view);
                ((BBYTextView) (obj)).setText(transactionlineitem.getDescription());
                q = transactionlineitem.getProductSku();
                ((BBYTextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final MyBBYDetailedReceipt a;

                    public void onClick(View view1)
                    {
                        view1 = new MdotWebFragment();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("ProductObject", true);
                        bundle.putString("SKU", MyBBYDetailedReceipt.a(a));
                        view1.setArguments(bundle);
                    }

            
            {
                a = MyBBYDetailedReceipt.this;
                super();
            }
                });
                bbytextview.setText(a(transactionlineitem.getAmount()));
                bbytextview1.setText((new StringBuilder()).append("Qty: ").append(transactionlineitem.getQuantity()).toString());
                obj = new HashMap();
                ((HashMap) (obj)).put("ProductTitle", transactionlineitem.getDescription());
                lu.a(lu.ab, ((HashMap) (obj)));
                if (i1 == 0)
                {
                    view.setBackgroundResource(0x7f020088);
                    view.findViewById(0x7f0c01a8).setVisibility(0);
                } else
                if (i1 == arraylist.size() - 1)
                {
                    view.setBackgroundResource(0x7f020086);
                    view.findViewById(0x7f0c01a8).setVisibility(8);
                } else
                {
                    view.setBackgroundResource(0x7f020087);
                    view.findViewById(0x7f0c01a8).setVisibility(0);
                }
                if (transactionlineitem.getAmount() != null && !transactionlineitem.getAmount().equalsIgnoreCase("0.00") && transactionlineitem.getProductSku() != null)
                {
                    imageview.setVisibility(8);
                } else
                {
                    imageview.setVisibility(8);
                }
                i1++;
            }
            l.setText(a(b()));
            i.setText(a(c()));
            k.setText(a(d()));
            if (store != null)
            {
                ((LinearLayout)o.findViewById(0x7f0c01b2)).setVisibility(0);
                if (((TelephonyManager)getActivity().getApplicationContext().getSystemService("phone")).getPhoneType() == 0)
                {
                    j.setVisibility(8);
                } else
                if (store.getPhone() != null)
                {
                    h.setText((new StringBuilder()).append("Call ").append(store.getPhone().toUpperCase()).toString());
                    String s1 = store.getPhone();
                    j.setOnClickListener(new android.view.View.OnClickListener(s1) {

                        final String a;
                        final MyBBYDetailedReceipt b;

                        public void onClick(View view1)
                        {
                            MyBBYDetailedReceipt.a(b, view1.getContext(), a);
                        }

            
            {
                b = MyBBYDetailedReceipt.this;
                a = s1;
                super();
            }
                    });
                } else
                {
                    j.setVisibility(8);
                }
                if (store.getName() == null || store.getStoreId() == null || store.getRegion() == null || store.getPostalCode() == null)
                {
                    break label0;
                }
                g.setText((new StringBuilder()).append("View ").append(store.getName().toUpperCase(Locale.getDefault())).toString());
                m.setOnClickListener(new android.view.View.OnClickListener() {

                    final MyBBYDetailedReceipt a;

                    public void onClick(View view1)
                    {
                    }

            
            {
                a = MyBBYDetailedReceipt.this;
                super();
            }
                });
            }
            return;
        }
        m.setVisibility(8);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        o = layoutinflater.inflate(0x7f030075, null);
        c = layoutinflater;
        p = o.findViewById(0x7f0c0064);
        r = (BBYTextView)o.findViewById(0x7f0c01aa);
        s = (BBYTextView)o.findViewById(0x7f0c01ac);
        l = (BBYTextView)o.findViewById(0x7f0c01ae);
        i = (BBYTextView)o.findViewById(0x7f0c01b0);
        k = (BBYTextView)o.findViewById(0x7f0c01b1);
        m = (LinearLayout)o.findViewById(0x7f0c01b3);
        j = (LinearLayout)o.findViewById(0x7f0c01b5);
        g = (BBYTextView)o.findViewById(0x7f0c01b4);
        h = (BBYTextView)o.findViewById(0x7f0c01b6);
        layoutinflater = (BBYTextView)o.findViewById(0x7f0c01a7);
        viewgroup = (BBYTextView)o.findViewById(0x7f0c01a9);
        layoutinflater.setText((new SimpleDateFormat("MMM d, yyyy", Locale.US)).format(b.getDate()));
        viewgroup.setText(b.getPoints());
        n = b.getStoreID();
        if (n != null && n.equalsIgnoreCase("960"))
        {
            m.setVisibility(8);
            j.setVisibility(8);
        }
        (new jx(d, this, p, n)).executeOnExecutor(nb.h, new Void[0]);
        return o;
    }
}
