// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import com.jumio.netswipe.sdk.environment.Environment;

// Referenced classes of package netswipe:
//            bl, dc, as, aq, 
//            ar, bz

public class by extends bl
{

    private ImageView c;
    private TableRow d;
    private ImageView e;
    private TextView f;
    private TableRow g;
    private TextView h;
    private TableRow i;
    private TextView j;
    private TextView k;
    private ProgressBar l;
    private TableRow m;
    private TextView n;
    private TextView o;
    private ProgressBar p;
    private TableRow q;
    private TextView r;
    private TextView s;

    public by(Context context)
    {
        super(context);
        android.graphics.Typeface typeface = Environment.loadOcraFontTypeface(context);
        int i1 = dc.a(context, 2);
        int j1 = dc.a(context, 1);
        int k1 = dc.a(context, 13);
        int l1 = dc.a(context, 11);
        int i2 = dc.a(context, 11);
        a.setPadding(a.getPaddingLeft(), l1, 0, i2);
        b.setVisibility(8);
        c = new ImageView(context);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        c.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        c.setId(as.H);
        c.setImageBitmap(aq.a(context, "info_view_success"));
        c.setVisibility(4);
        a.addView(c);
        obj = new TableLayout(context);
        Object obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(0, as.H);
        ((TableLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((TableLayout) (obj)).setPadding(0, dc.a(context, 1), 0, 0);
        a.addView(((android.view.View) (obj)));
        d = new TableRow(context);
        obj1 = new android.widget.TableLayout.LayoutParams(-2, -2);
        obj1.topMargin = i1;
        d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        d.setVisibility(8);
        ((TableLayout) (obj)).addView(d);
        e = new ImageView(context);
        obj1 = new android.widget.TableRow.LayoutParams(-2, -2);
        obj1.gravity = 3;
        e.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        e.setAdjustViewBounds(true);
        e.setId(as.B);
        d.addView(e);
        f = new TextView(context);
        obj1 = new android.widget.TableLayout.LayoutParams(-2, -2);
        obj1.topMargin = dc.a(context, 3);
        f.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        f.setTypeface(typeface);
        f.setTextColor(0xff000000);
        f.setId(as.C);
        f.setTextSize(0, k1);
        f.setVisibility(8);
        ((TableLayout) (obj)).addView(f);
        g = new TableRow(context);
        obj1 = new android.widget.TableLayout.LayoutParams(-2, -2);
        obj1.topMargin = i1;
        g.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        g.setVisibility(8);
        ((TableLayout) (obj)).addView(g);
        obj1 = new TextView(context);
        android.widget.TableRow.LayoutParams layoutparams = new android.widget.TableRow.LayoutParams(-2, -2);
        layoutparams.rightMargin = i1;
        ((TextView) (obj1)).setLayoutParams(layoutparams);
        ((TextView) (obj1)).setText(ar.a(context, "success_view_expiry_valid_through"));
        ((TextView) (obj1)).setTextSize(0, k1);
        ((TextView) (obj1)).setTextColor(0xff000000);
        ((TextView) (obj1)).setPadding(0, 0, dc.a(context, 8), 0);
        g.addView(((android.view.View) (obj1)));
        h = new TextView(context);
        obj1 = new android.widget.TableRow.LayoutParams(-2, -2);
        h.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        h.setTextColor(0xff000000);
        h.setTypeface(typeface);
        h.setId(as.D);
        h.setTextSize(0, k1);
        g.addView(h);
        m = new TableRow(context);
        obj1 = new android.widget.TableLayout.LayoutParams(-2, -2);
        obj1.topMargin = dc.a(context, 10);
        m.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        m.setVisibility(8);
        ((TableLayout) (obj)).addView(m);
        n = new TextView(context);
        obj1 = new android.widget.TableRow.LayoutParams(-2, -2);
        obj1.rightMargin = i1;
        n.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        n.setText(ar.a(context, "success_view_sort_code"));
        n.setTextSize(0, k1);
        n.setTextColor(0xff000000);
        m.addView(n);
        o = new TextView(context);
        obj1 = new android.widget.TableRow.LayoutParams(-2, -2);
        o.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        o.setTextColor(0xff000000);
        o.setTypeface(typeface);
        o.setTextSize(0, k1);
        o.setId(as.F);
        m.addView(o);
        p = new ProgressBar(context);
        obj1 = new android.widget.TableRow.LayoutParams(k1, k1);
        obj1.gravity = 16;
        p.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        p.setIndeterminate(true);
        q = new TableRow(context);
        obj1 = new android.widget.TableLayout.LayoutParams(-2, -2);
        obj1.topMargin = j1;
        q.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        q.setVisibility(8);
        ((TableLayout) (obj)).addView(q);
        r = new TextView(context);
        obj1 = new android.widget.TableRow.LayoutParams(-2, -2);
        obj1.rightMargin = i1;
        r.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        r.setText(ar.a(context, "success_view_account_number"));
        r.setTextColor(0xff000000);
        r.setTextSize(0, k1);
        q.addView(r);
        s = new TextView(context);
        obj1 = new android.widget.TableRow.LayoutParams(-2, -2);
        s.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        s.setTextColor(0xff000000);
        s.setTextSize(0, k1);
        s.setTypeface(typeface);
        s.setId(as.F);
        q.addView(s);
        i = new TableRow(context);
        obj1 = new android.widget.TableLayout.LayoutParams(-2, -2);
        obj1.topMargin = j1;
        i.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        i.setVisibility(8);
        ((TableLayout) (obj)).addView(i);
        j = new TextView(context);
        obj = new android.widget.TableRow.LayoutParams(-2, -2);
        obj.rightMargin = i1;
        j.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        j.setText(ar.a(context, "success_view_name"));
        j.setTextSize(0, k1);
        j.setTextColor(0xff000000);
        i.addView(j);
        k = new TextView(context);
        obj = new android.widget.TableRow.LayoutParams(-2, -2);
        k.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        k.setTextColor(0xff000000);
        k.setTypeface(typeface);
        k.setTextSize(0, k1);
        k.setId(as.F);
        i.addView(k);
        l = new ProgressBar(context);
        context = new android.widget.TableRow.LayoutParams(k1, k1);
        context.gravity = 16;
        l.setLayoutParams(context);
        l.setIndeterminate(true);
    }

    private boolean a(CharSequence charsequence)
    {
        return charsequence != null && charsequence.length() != 0;
    }

    public void a()
    {
        a(CreditCardType.UNKNOWN, getResources());
        setCreditCardNumber(null);
        a(((CharSequence) (null)), ((CharSequence) (null)));
        setCardholderName(null);
        setSortCode(null);
        setAccountNumber(null);
    }

    public void a(CreditCardType creditcardtype, Resources resources)
    {
        Object obj = null;
        bz.a[creditcardtype.ordinal()];
        JVM INSTR tableswitch 1 7: default 52
    //                   1 81
    //                   2 92
    //                   3 103
    //                   4 114
    //                   5 125
    //                   6 136
    //                   7 147;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_147;
_L1:
        creditcardtype = obj;
_L9:
        e.setImageBitmap(creditcardtype);
        resources = d;
        int i1;
        if (creditcardtype != null)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        resources.setVisibility(i1);
        return;
_L2:
        creditcardtype = aq.a(resources, aq.d);
          goto _L9
_L3:
        creditcardtype = aq.a(resources, aq.g);
          goto _L9
_L4:
        creditcardtype = aq.a(resources, aq.e);
          goto _L9
_L5:
        creditcardtype = aq.a(resources, aq.f);
          goto _L9
_L6:
        creditcardtype = aq.a(resources, aq.h);
          goto _L9
_L7:
        creditcardtype = aq.a(resources, aq.c);
          goto _L9
        creditcardtype = aq.a(resources, aq.b);
          goto _L9
    }

    public void a(CharSequence charsequence, CharSequence charsequence1)
    {
        h.setText((new StringBuilder()).append(charsequence).append("/").append(charsequence1).toString());
        TableRow tablerow = g;
        int i1;
        if (a(charsequence1) && a(charsequence))
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        tablerow.setVisibility(i1);
    }

    public void setAccountNumber(CharSequence charsequence)
    {
        s.setText(charsequence);
        setAccountNumberActive(true);
    }

    public void setAccountNumberActive(boolean flag)
    {
        TextView textview = r;
        int i1;
        if (flag)
        {
            i1 = 0xff000000;
        } else
        {
            i1 = 0xff888888;
        }
        textview.setTextColor(i1);
    }

    public void setCardHolderNameActive(boolean flag)
    {
        TextView textview = j;
        int i1;
        if (flag)
        {
            i1 = 0xff000000;
        } else
        {
            i1 = 0xff888888;
        }
        textview.setTextColor(i1);
    }

    public void setCardholderName(CharSequence charsequence)
    {
        setCardholderNamePending(false);
        k.setText(charsequence);
    }

    public void setCardholderNamePending(boolean flag)
    {
        if (flag && k.getParent() != null || !flag && l.getParent() != null)
        {
            TableRow tablerow = i;
            Object obj;
            if (flag)
            {
                obj = k;
            } else
            {
                obj = l;
            }
            tablerow.removeView(((android.view.View) (obj)));
            tablerow = i;
            if (flag)
            {
                obj = l;
            } else
            {
                obj = k;
            }
            tablerow.addView(((android.view.View) (obj)));
        }
    }

    public void setCardholderNameVisibility(int i1)
    {
        i.setVisibility(i1);
    }

    public void setCreditCardNumber(CharSequence charsequence)
    {
        f.setText(charsequence);
        TextView textview = f;
        int i1;
        if (a(charsequence))
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        textview.setVisibility(i1);
    }

    public void setShowSuccessIcon(boolean flag)
    {
        ImageView imageview = c;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        imageview.setVisibility(i1);
    }

    public void setSortCode(CharSequence charsequence)
    {
        setSortCodeAndAccountNumberPending(false);
        o.setText(charsequence);
    }

    public void setSortCodeActive(boolean flag)
    {
        TextView textview = n;
        int i1;
        if (flag)
        {
            i1 = 0xff000000;
        } else
        {
            i1 = 0xff888888;
        }
        textview.setTextColor(i1);
    }

    public void setSortCodeAndAccountNumberPending(boolean flag)
    {
        if (flag && o.getParent() != null || !flag && p.getParent() != null)
        {
            TableRow tablerow = m;
            Object obj;
            if (flag)
            {
                obj = o;
            } else
            {
                obj = p;
            }
            tablerow.removeView(((android.view.View) (obj)));
            tablerow = m;
            if (flag)
            {
                obj = p;
            } else
            {
                obj = o;
            }
            tablerow.addView(((android.view.View) (obj)));
        }
    }

    public void setSortCodeAndAccountNumberVisibility(int i1)
    {
        m.setVisibility(i1);
        q.setVisibility(i1);
    }
}
