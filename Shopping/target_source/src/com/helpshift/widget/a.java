// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.helpshift.o;

// Referenced classes of package com.helpshift.widget:
//            CSATView

public class a extends Dialog
    implements android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnShowListener, android.view.View.OnClickListener, android.view.View.OnTouchListener
{

    private Context a;
    private CSATView b;
    private RatingBar c;
    private TextView d;
    private EditText e;
    private float f;
    private boolean g;

    public a(Context context)
    {
        super(context);
        g = false;
        a = context;
    }

    private void a()
    {
        Toast.makeText(a, a.getString(com.helpshift.b.g.M), 1).show();
    }

    protected void a(CSATView csatview)
    {
        b = csatview;
        f = csatview.getRatingBar().getRating();
        show();
    }

    public void onClick(View view)
    {
        if (view.getId() == com.helpshift.b.c.ae)
        {
            b.a(c.getRating(), e.getText().toString());
            g = true;
            a();
            dismiss();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(com.helpshift.b.d.A);
        setOnShowListener(this);
        setOnDismissListener(this);
        c = (RatingBar)findViewById(com.helpshift.b.c.U);
        c.setOnTouchListener(this);
        d = (TextView)findViewById(com.helpshift.b.c.ac);
        e = (EditText)findViewById(com.helpshift.b.c.ad);
        ((Button)findViewById(com.helpshift.b.c.ae)).setOnClickListener(this);
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (g)
        {
            b.a();
            return;
        } else
        {
            o.a("cr");
            b.getRatingBar().setRating(0.0F);
            return;
        }
    }

    public void onShow(DialogInterface dialoginterface)
    {
        o.a("sr");
        c.setRating(f);
        dialoginterface = a.getResources().getQuantityString(com.helpshift.b.f.b, (int)f, new Object[] {
            Integer.valueOf((int)f)
        });
        if ((double)f > 2D)
        {
            d.setText(com.helpshift.b.g.K);
        } else
        {
            d.setText(com.helpshift.b.g.L);
        }
        c.setContentDescription(dialoginterface);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return view.getId() == com.helpshift.b.c.U;
    }
}
