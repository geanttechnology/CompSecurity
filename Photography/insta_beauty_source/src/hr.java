// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.fotoable.alertad.FotoAlert;

public class hr
{

    private Context a;
    private FotoAlert b;
    private String c;
    private android.content.DialogInterface.OnClickListener d;
    private android.content.DialogInterface.OnClickListener e;

    public hr(Context context)
    {
        a = context;
    }

    static android.content.DialogInterface.OnClickListener a(hr hr1)
    {
        return hr1.d;
    }

    static android.content.DialogInterface.OnClickListener b(hr hr1)
    {
        return hr1.e;
    }

    public hq a()
    {
        Object obj = (LayoutInflater)a.getSystemService("layout_inflater");
        hq hq1 = new hq(a, aau.FotoAlertDialog);
        obj = ((LayoutInflater) (obj)).inflate(aas.dialog_fotoalert, null);
        hq1.addContentView(((View) (obj)), new android.view.ViewGroup.LayoutParams(-1, -2));
        if (d != null)
        {
            ImageView imageview = (ImageView)((View) (obj)).findViewById(aar.alert_image);
            Point point = yo.a(b.a(c), a);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)imageview.getLayoutParams();
            layoutparams.width = yp.a(a, point.x / 2);
            layoutparams.height = yp.a(a, point.y / 2);
            if (layoutparams.width > yp.d(a) - yp.a(a, 30F) || layoutparams.height > yp.e(a) - yp.a(a, 30F))
            {
                layoutparams.width = yp.a(a, point.x / 3);
                layoutparams.height = yp.a(a, point.y / 3);
            }
            imageview.requestLayout();
            imageview.setBackgroundColor(0xffffff);
            yq.a().a(a, b.a(c), imageview, point.x, point.y);
            imageview.setOnClickListener(new hs(this, hq1));
        }
        if (e != null)
        {
            ((View) (obj)).findViewById(aar.alert_close).setOnClickListener(new ht(this, hq1));
        }
        hq1.setContentView(((View) (obj)));
        return hq1;
    }

    public hr a(int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        d = onclicklistener;
        return this;
    }

    public hr a(FotoAlert fotoalert)
    {
        b = fotoalert;
        return this;
    }

    public hr a(String s)
    {
        c = s;
        return this;
    }

    public hr b(int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        e = onclicklistener;
        return this;
    }
}
