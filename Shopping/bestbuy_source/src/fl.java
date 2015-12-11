// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class fl extends ArrayAdapter
{

    private ArrayList a;
    private ArrayList b;
    private Context c;
    private LayoutInflater d;
    private nb e;

    public fl(Context context, int i, ArrayList arraylist, ArrayList arraylist1, nb nb)
    {
        super(context, i, arraylist);
        a = arraylist;
        b = arraylist1;
        c = context;
        e = nb;
        if (context != null)
        {
            d = LayoutInflater.from(context);
        }
    }

    static Context a(fl fl1)
    {
        return fl1.c;
    }

    private String a(String s)
    {
        String s1;
        try
        {
            double d1 = Double.parseDouble(s);
            s1 = (new DecimalFormat("###,###,###.##")).format(Double.valueOf(d1));
        }
        catch (Exception exception)
        {
            return s;
        }
        return s1;
    }

    private void a(Uri uri, String s)
    {
        (new kw(c, uri, s)).show();
    }

    static void a(fl fl1, Uri uri, String s)
    {
        fl1.a(uri, s);
    }

    static nb b(fl fl1)
    {
        return fl1.e;
    }

    public int a(BBYProduct bbyproduct)
    {
        return a.indexOf(bbyproduct);
    }

    public int getCount()
    {
        return a.size();
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public int getPosition(Object obj)
    {
        return a((BBYProduct)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        DNMProduct dnmproduct;
        Object obj;
        BBYProduct bbyproduct;
        if (view == null)
        {
            view = d.inflate(0x7f030035, viewgroup, false);
            viewgroup = new fm();
            viewgroup.a = (BBYTextView)view.findViewById(0x7f0c00e1);
            viewgroup.b = (ImageView)view.findViewById(0x7f0c00e0);
            viewgroup.c = (BBYTextView)view.findViewById(0x7f0c00d2);
            viewgroup.d = (BBYTextView)view.findViewById(0x7f0c0024);
            viewgroup.e = (BBYTextView)view.findViewById(0x7f0c00d8);
            viewgroup.f = (BBYTextView)view.findViewById(0x7f0c00d9);
            viewgroup.g = (BBYTextView)view.findViewById(0x7f0c00d4);
            viewgroup.i = (LinearLayout)view.findViewById(0x7f0c00d6);
            viewgroup.h = (BBYTextView)view.findViewById(0x7f0c00d5);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (fm)view.getTag();
        }
        obj = new DecimalFormat("0.00");
        bbyproduct = (BBYProduct)a.get(i);
        dnmproduct = (DNMProduct)b.get(i);
        if (bbyproduct == null) goto _L2; else goto _L1
_L1:
        if (dnmproduct.getOpenBoxCondition().equals(c.getString(0x7f080068)))
        {
            ((fm) (viewgroup)).a.setVisibility(8);
            ((fm) (viewgroup)).b.setVisibility(8);
        } else
        {
            ((fm) (viewgroup)).a.setText((new StringBuilder()).append(dnmproduct.getOpenBoxCondition()).append(" Condition").toString());
        }
        ((fm) (viewgroup)).d.setText(dnmproduct.getStoreName());
        ((fm) (viewgroup)).c.setText((new StringBuilder()).append(dnmproduct.getDistance()).append(" Miles Away").toString());
        ((fm) (viewgroup)).c.setOnClickListener(new android.view.View.OnClickListener(dnmproduct) {

            final DNMProduct a;
            final fl b;

            public void onClick(View view1)
            {
                view1 = (new StringBuilder()).append(a.getStoreCity()).append(",").append(a.getStoreState()).append(" ").append(a.getStoreZipCode()).toString();
                view1 = (new StringBuilder()).append(a.getStoreAddress1()).append(",").append(view1).toString();
                Uri uri = Uri.parse((new StringBuilder()).append(fl.a(b).getResources().getString(0x7f0801d0)).append(fl.b(b).y()).append(",").append(fl.b(b).z()).append("&daddr=").append(view1).append("&hl=en").toString());
                fl.a(b, uri, view1);
            }

            
            {
                b = fl.this;
                a = dnmproduct;
                super();
            }
        });
        if (dnmproduct.isMapFlag())
        {
            ((fm) (viewgroup)).g.setVisibility(0);
            ((fm) (viewgroup)).i.setVisibility(8);
            ((fm) (viewgroup)).g.setText("See Price in Cart");
            ((fm) (viewgroup)).h.setVisibility(0);
            ((fm) (viewgroup)).h.setText((new StringBuilder()).append("Reg.Price: $").append(a(Double.toString(dnmproduct.getSkuPermRegPrice()))).toString());
        } else
        if (dnmproduct.getIcrMapPriceValue().equals("1"))
        {
            ((fm) (viewgroup)).g.setVisibility(0);
            ((fm) (viewgroup)).i.setVisibility(8);
            ((fm) (viewgroup)).g.setText(c.getString(0x7f0802af));
        } else
        if (dnmproduct.getIcrMapPriceValue().equals("2"))
        {
            ((fm) (viewgroup)).g.setVisibility(0);
            ((fm) (viewgroup)).e.setText((new StringBuilder()).append("$").append(a(Double.toString(dnmproduct.getClearancePrice()))).toString());
            ((fm) (viewgroup)).g.setText(c.getString(0x7f0802af));
            ((fm) (viewgroup)).e.setPaintFlags(((fm) (viewgroup)).e.getPaintFlags() | 0x10);
            ((fm) (viewgroup)).f.setVisibility(8);
        } else
        {
            ((fm) (viewgroup)).g.setVisibility(8);
            ((fm) (viewgroup)).i.setVisibility(0);
            ((fm) (viewgroup)).f.setVisibility(0);
            ((fm) (viewgroup)).e.setPaintFlags(((fm) (viewgroup)).e.getPaintFlags() & 0xffffffef);
            ((fm) (viewgroup)).e.setText((new StringBuilder()).append("$").append(a(Double.toString(dnmproduct.getClearancePrice()))).toString());
            String s = String.valueOf(String.format("%.2f", new Object[] {
                Double.valueOf(dnmproduct.getSaveAmt())
            }));
            try
            {
                if (dnmproduct.getSaveAmt() > 1.0D)
                {
                    s.replace(s.substring(s.indexOf("."), s.length()), "");
                }
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
            obj = ((DecimalFormat) (obj)).format(dnmproduct.getSkuPermRegPrice());
            s = (new StringBuilder()).append("").append(Math.round(dnmproduct.getSaveAmt())).toString();
            obj = (new StringBuilder()).append("<span class='bold'>SAVE $").append(a(s)).append("</span> (Reg. $").append(a(((String) (obj)))).append(")").toString();
            try
            {
                lt.a(c, ((fm) (viewgroup)).f, ((String) (obj)), 300, Color.rgb(216, 37, 38));
            }
            catch (Exception exception)
            {
                kf.a("", (new StringBuilder()).append("Error Text: ").append(exception.getLocalizedMessage()).toString());
            }
        }
_L6:
        ((fm) (viewgroup)).g.setOnClickListener(new android.view.View.OnClickListener(dnmproduct, bbyproduct) {

            final DNMProduct a;
            final BBYProduct b;
            final fl c;

            public void onClick(View view1)
            {
                boolean flag = true;
                if (!a.getIcrMapPriceValue().equals("1") && !a.getIcrMapPriceValue().equals("2")) goto _L2; else goto _L1
_L1:
                view1 = new lb(fl.a(c), 0x7f0801e4, 0x7f0801e1, 0x7f0801e5, 0x7f0801e2, 0x7f0801e3);
_L10:
                if (view1 != null)
                {
                    view1.show();
                }
                return;
_L2:
                if (!a.isMapFlag()) goto _L4; else goto _L3
_L3:
                if (a.getSkuTypeCode() == null || a.getSkuTypeCode().equals(fl.a(c).getString(0x7f080068))) goto _L6; else goto _L5
_L5:
                if (!a.getSkuTypeCode().equals(fl.a(c).getString(0x7f08003a))) goto _L8; else goto _L7
_L7:
                view1 = new lb(fl.a(c), 0x7f080224, 0x7f080222, 0x7f080225, 0x7f080223, flag, a, b);
                continue; /* Loop/switch isn't completed */
_L8:
                if (a.getSkuDisplayable() != null)
                {
                    if (!a.getSkuDisplayable().equals("1"))
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                continue; /* Loop/switch isn't completed */
_L6:
                flag = false;
                if (true) goto _L7; else goto _L4
_L4:
                view1 = null;
                if (true) goto _L10; else goto _L9
_L9:
            }

            
            {
                c = fl.this;
                a = dnmproduct;
                b = bbyproduct;
                super();
            }
        });
        if (!dnmproduct.getDnmType().equals(c.getString(0x7f08012a))) goto _L4; else goto _L3
_L3:
        ((fm) (viewgroup)).b.setImageResource(0x7f020134);
_L2:
        return view;
_L4:
        ((fm) (viewgroup)).b.setImageResource(0x7f020134);
        return view;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
