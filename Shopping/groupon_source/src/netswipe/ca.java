// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import com.jumio.netswipe.sdk.environment.Environment;

// Referenced classes of package netswipe:
//            as, dc, cb, aq

public class ca extends RelativeLayout
{

    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;

    public ca(Context context)
    {
        super(context);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(10);
        setLayoutParams(layoutparams);
        setId(as.a);
        int i = dc.a(context, 13);
        int j = dc.a(context, 10);
        setPadding(j, i, j, i);
        a = new ImageView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.rightMargin = dc.a(context, 12);
        layoutparams.addRule(10);
        layoutparams.addRule(9);
        a.setLayoutParams(layoutparams);
        a.setId(as.e);
        addView(a);
        b = new TextView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(1, as.e);
        layoutparams.addRule(10);
        b.setLayoutParams(layoutparams);
        b.setId(as.f);
        b.setTextColor(-1);
        b.setTextSize(0, dc.a(context, 13));
        b.setTypeface(Environment.loadOcraFontTypeface(context));
        addView(b);
        c = new TextView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(1, as.e);
        layoutparams.addRule(3, as.f);
        c.setLayoutParams(layoutparams);
        c.setId(as.g);
        c.setTextColor(-1);
        c.setTextSize(0, dc.a(context, 13));
        c.setTypeface(Environment.loadOcraFontTypeface(context));
        c.setVisibility(8);
        addView(c);
        d = new TextView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(1, as.e);
        layoutparams.addRule(3, as.g);
        d.setLayoutParams(layoutparams);
        d.setId(as.h);
        d.setTextColor(-1);
        d.setTextSize(0, dc.a(context, 13));
        d.setTypeface(Environment.loadOcraFontTypeface(context));
        d.setVisibility(8);
        addView(d);
        setBackgroundColor(0x99000000);
    }

    public void a(CreditCardType creditcardtype, Resources resources)
    {
        Object obj = null;
        cb.a[creditcardtype.ordinal()];
        JVM INSTR tableswitch 1 7: default 52
    //                   1 63
    //                   2 74
    //                   3 85
    //                   4 96
    //                   5 107
    //                   6 118
    //                   7 129;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        creditcardtype = obj;
_L10:
        a.setImageBitmap(creditcardtype);
        return;
_L2:
        creditcardtype = aq.a(resources, aq.d);
        continue; /* Loop/switch isn't completed */
_L3:
        creditcardtype = aq.a(resources, aq.g);
        continue; /* Loop/switch isn't completed */
_L4:
        creditcardtype = aq.a(resources, aq.e);
        continue; /* Loop/switch isn't completed */
_L5:
        creditcardtype = aq.a(resources, aq.f);
        continue; /* Loop/switch isn't completed */
_L6:
        creditcardtype = aq.a(resources, aq.h);
        continue; /* Loop/switch isn't completed */
_L7:
        creditcardtype = aq.a(resources, aq.c);
        continue; /* Loop/switch isn't completed */
_L8:
        creditcardtype = aq.a(resources, aq.b);
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void setCreditCardNumber(CharSequence charsequence)
    {
        b.setText(charsequence);
    }

    public void setExpiryDate(CharSequence charsequence)
    {
        c.setText(charsequence);
        c.setVisibility(0);
    }

    public void setSortCodeAndAccountNumber(CharSequence charsequence)
    {
        d.setText(charsequence);
        d.setVisibility(0);
    }
}
