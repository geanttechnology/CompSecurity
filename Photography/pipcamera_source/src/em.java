// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.fotoable.alertad.FotoAlert;

public class em
{

    private Context a;
    private FotoAlert b;
    private String c;
    private android.content.DialogInterface.OnClickListener d;
    private android.content.DialogInterface.OnClickListener e;

    public em(Context context)
    {
        a = context;
    }

    static android.content.DialogInterface.OnClickListener a(em em1)
    {
        return em1.d;
    }

    static android.content.DialogInterface.OnClickListener b(em em1)
    {
        return em1.e;
    }

    public el a()
    {
        Object obj = (LayoutInflater)a.getSystemService("layout_inflater");
        el el1 = new el(a, com.fotoable.fotoadpackage.R.style.FotoAlertDialog);
        obj = ((LayoutInflater) (obj)).inflate(com.fotoable.fotoadpackage.R.layout.dialog_fotoalert, null);
        el1.addContentView(((View) (obj)), new android.view.ViewGroup.LayoutParams(-1, -2));
        if (d != null)
        {
            ImageView imageview = (ImageView)((View) (obj)).findViewById(com.fotoable.fotoadpackage.R.id.alert_image);
            Point point = ev.a(b.a(c), a);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)imageview.getLayoutParams();
            layoutparams.width = ew.a(a, point.x / 2);
            layoutparams.height = ew.a(a, point.y / 2);
            if (layoutparams.width > ew.d(a) - ew.a(a, 30F) || layoutparams.height > ew.e(a) - ew.a(a, 30F))
            {
                layoutparams.width = ew.a(a, point.x / 3);
                layoutparams.height = ew.a(a, point.y / 3);
            }
            imageview.requestLayout();
            imageview.setBackgroundColor(0xffffff);
            ex.a().a(a, b.a(c), imageview, point.x, point.y);
            imageview.setOnClickListener(new android.view.View.OnClickListener(el1) {

                final el a;
                final em b;

                public void onClick(View view)
                {
                    Log.i("FotoAlertFactory", "positiveButtonClick");
                    em.a(b).onClick(a, -1);
                    a.hide();
                }

            
            {
                b = em.this;
                a = el1;
                super();
            }
            });
        }
        if (e != null)
        {
            ((View) (obj)).findViewById(com.fotoable.fotoadpackage.R.id.alert_close).setOnClickListener(new android.view.View.OnClickListener(el1) {

                final el a;
                final em b;

                public void onClick(View view)
                {
                    em.b(b).onClick(a, -2);
                    a.hide();
                }

            
            {
                b = em.this;
                a = el1;
                super();
            }
            });
        }
        el1.setContentView(((View) (obj)));
        return el1;
    }

    public em a(int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        d = onclicklistener;
        return this;
    }

    public em a(FotoAlert fotoalert)
    {
        b = fotoalert;
        return this;
    }

    public em a(String s)
    {
        c = s;
        return this;
    }

    public em b(int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        e = onclicklistener;
        return this;
    }
}
