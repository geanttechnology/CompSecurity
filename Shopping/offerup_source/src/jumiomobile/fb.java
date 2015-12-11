// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netswipe.sdk.enums.CreditCardType;

// Referenced classes of package jumiomobile:
//            ed, bf, fc, eb

public class fb extends RelativeLayout
{

    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;

    public fb(Context context)
    {
        super(context);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(10);
        setLayoutParams(layoutparams);
        setId(ed.a);
        int i = bf.a(context, 13);
        int j = bf.a(context, 10);
        setPadding(j, i, j, i);
        a = new ImageView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.rightMargin = bf.a(context, 12);
        layoutparams.addRule(10);
        layoutparams.addRule(9);
        a.setLayoutParams(layoutparams);
        a.setId(ed.e);
        addView(a);
        b = new TextView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(1, ed.e);
        layoutparams.addRule(10);
        b.setLayoutParams(layoutparams);
        b.setId(ed.f);
        b.setTextColor(-1);
        b.setTextSize(0, bf.a(context, 13));
        b.setTypeface(Environment.loadOcraFontTypeface(context));
        addView(b);
        c = new TextView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(1, ed.e);
        layoutparams.addRule(3, ed.f);
        c.setLayoutParams(layoutparams);
        c.setId(ed.g);
        c.setTextColor(-1);
        c.setTextSize(0, bf.a(context, 13));
        c.setTypeface(Environment.loadOcraFontTypeface(context));
        c.setVisibility(8);
        addView(c);
        d = new TextView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(1, ed.e);
        layoutparams.addRule(3, ed.g);
        d.setLayoutParams(layoutparams);
        d.setId(ed.h);
        d.setTextColor(-1);
        d.setTextSize(0, bf.a(context, 13));
        d.setTypeface(Environment.loadOcraFontTypeface(context));
        d.setVisibility(8);
        addView(d);
        setBackgroundColor(0x99000000);
    }

    public void a(CreditCardType creditcardtype, Resources resources)
    {
        android.graphics.Bitmap bitmap;
        Object obj;
        obj = null;
        bitmap = obj;
        fc.a[creditcardtype.ordinal()];
        JVM INSTR tableswitch 1 8: default 60
    //                   1 72
    //                   2 83
    //                   3 94
    //                   4 105
    //                   5 116
    //                   6 127
    //                   7 138
    //                   8 63;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        break; /* Loop/switch isn't completed */
_L1:
        bitmap = obj;
_L11:
        a.setImageBitmap(bitmap);
        return;
_L2:
        bitmap = eb.a(resources, eb.m);
        continue; /* Loop/switch isn't completed */
_L3:
        bitmap = eb.a(resources, eb.p);
        continue; /* Loop/switch isn't completed */
_L4:
        bitmap = eb.a(resources, eb.n);
        continue; /* Loop/switch isn't completed */
_L5:
        bitmap = eb.a(resources, eb.o);
        continue; /* Loop/switch isn't completed */
_L6:
        bitmap = eb.a(resources, eb.q);
        continue; /* Loop/switch isn't completed */
_L7:
        bitmap = eb.a(resources, eb.l);
        continue; /* Loop/switch isn't completed */
_L8:
        bitmap = eb.a(resources, eb.k);
        if (true) goto _L11; else goto _L10
_L10:
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
