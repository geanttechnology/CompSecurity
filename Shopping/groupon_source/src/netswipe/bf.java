// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package netswipe:
//            dc, ar, as, aq, 
//            bg

public class bf extends LinearLayout
{

    private int a;

    public bf(Context context, ArrayList arraylist, android.view.View.OnClickListener onclicklistener)
    {
        Object obj;
        int i;
        super(context);
        a = 0;
        setBackgroundColor(0xccffffff);
        setOrientation(1);
        a = dc.a(context, 250);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        i = dc.a(context, 26);
        obj = new LinearLayout(context);
        Object obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        obj1.leftMargin = i;
        obj1.topMargin = dc.a(context, 17);
        obj1.bottomMargin = dc.a(context, 6);
        obj1.rightMargin = dc.a(context, 17);
        ((LinearLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        obj1 = new TextView(context);
        android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams1.gravity = 16;
        layoutparams1.weight = 1.0F;
        ((TextView) (obj1)).setLayoutParams(layoutparams1);
        ((TextView) (obj1)).setText(ar.a(context, "help_view_accepted_creditcards"));
        ((TextView) (obj1)).setTextColor(0xff000000);
        ((TextView) (obj1)).setTypeface(null, 1);
        ((TextView) (obj1)).setTextSize(0, dc.a(context, 13));
        ((TextView) (obj1)).setId(as.m);
        ((LinearLayout) (obj)).addView(((android.view.View) (obj1)));
        obj1 = new ImageView(context);
        layoutparams1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        ((ImageView) (obj1)).setImageBitmap(aq.a(context.getResources(), aq.j));
        ((ImageView) (obj1)).setLayoutParams(layoutparams1);
        ((ImageView) (obj1)).setOnClickListener(onclicklistener);
        ((ImageView) (obj1)).setId(as.n);
        ((LinearLayout) (obj)).addView(((android.view.View) (obj1)));
        addView(((android.view.View) (obj)));
        onclicklistener = new LinearLayout(context);
        obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
        obj.leftMargin = i;
        onclicklistener.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        onclicklistener.setId(as.v);
        addView(onclicklistener);
        obj = arraylist.iterator();
_L13:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        arraylist = (CreditCardType)((Iterator) (obj)).next();
        bg.a[arraylist.ordinal()];
        JVM INSTR tableswitch 1 7: default 424
    //                   1 502
    //                   2 535
    //                   3 568
    //                   4 601
    //                   5 634
    //                   6 667
    //                   7 700;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
        arraylist = null;
_L11:
        if (arraylist != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(dc.a(context, 33), dc.a(context, 22));
            if (onclicklistener.getChildCount() != 0)
            {
                arraylist.setPadding(dc.a(context, 8), 0, 0, 0);
            }
            arraylist.setLayoutParams(layoutparams);
            arraylist.setEnabled(false);
            arraylist.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            arraylist.setAdjustViewBounds(true);
            onclicklistener.addView(arraylist);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        arraylist = new ImageView(context);
        arraylist.setImageBitmap(aq.a(context.getResources(), aq.b));
        arraylist.setId(as.o);
        continue; /* Loop/switch isn't completed */
_L5:
        arraylist = new ImageView(context);
        arraylist.setImageBitmap(aq.a(context.getResources(), aq.c));
        arraylist.setId(as.p);
        continue; /* Loop/switch isn't completed */
_L6:
        arraylist = new ImageView(context);
        arraylist.setImageBitmap(aq.a(context.getResources(), aq.e));
        arraylist.setId(as.q);
        continue; /* Loop/switch isn't completed */
_L7:
        arraylist = new ImageView(context);
        arraylist.setImageBitmap(aq.a(context.getResources(), aq.f));
        arraylist.setId(as.r);
        continue; /* Loop/switch isn't completed */
_L8:
        arraylist = new ImageView(context);
        arraylist.setImageBitmap(aq.a(context.getResources(), aq.d));
        arraylist.setId(as.s);
        continue; /* Loop/switch isn't completed */
_L9:
        arraylist = new ImageView(context);
        arraylist.setImageBitmap(aq.a(context.getResources(), aq.g));
        arraylist.setId(as.t);
        continue; /* Loop/switch isn't completed */
_L10:
        arraylist = new ImageView(context);
        arraylist.setImageBitmap(aq.a(context.getResources(), aq.h));
        arraylist.setId(as.u);
        if (true) goto _L11; else goto _L2
_L2:
        arraylist = new TextView(context);
        onclicklistener = new android.widget.LinearLayout.LayoutParams(-1, -2);
        onclicklistener.topMargin = dc.a(context, 28);
        onclicklistener.leftMargin = i;
        arraylist.setLayoutParams(onclicklistener);
        arraylist.setText(ar.a(context, "help_view_how_to"));
        arraylist.setTextColor(0xff000000);
        arraylist.setTypeface(null, 1);
        arraylist.setTextSize(0, dc.a(context, 13));
        arraylist.setId(as.w);
        addView(arraylist);
        arraylist = new ImageView(context);
        onclicklistener = new android.widget.LinearLayout.LayoutParams(-2, -2);
        onclicklistener.topMargin = dc.a(context, 10);
        arraylist.setImageBitmap(aq.a(context.getResources(), aq.k));
        arraylist.setLayoutParams(onclicklistener);
        addView(arraylist);
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public int getAnimationHeight()
    {
        return a;
    }
}
