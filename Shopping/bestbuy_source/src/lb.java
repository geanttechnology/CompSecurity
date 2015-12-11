// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.pdp.PDPMedia;
import com.bestbuy.android.api.lib.models.product.Product;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.bbyobjects.BBYTextView;

public class lb extends Dialog
    implements android.view.View.OnClickListener
{

    private Context a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private DNMProduct h;
    private BBYProduct i;
    private Product j;

    public lb(Context context, int k, int l)
    {
        super(context, 0x7f0e002b);
        a = context;
        b = k;
        d = l;
    }

    public lb(Context context, int k, int l, int i1, int j1)
    {
        super(context, 0x7f0e002b);
        a = context;
        b = k;
        c = i1;
        d = l;
        e = j1;
    }

    public lb(Context context, int k, int l, int i1, int j1, int k1)
    {
        super(context, 0x7f0e002b);
        a = context;
        b = k;
        c = i1;
        d = l;
        e = j1;
        f = k1;
    }

    public lb(Context context, int k, int l, int i1, int j1, boolean flag, DNMProduct dnmproduct, 
            BBYProduct bbyproduct)
    {
        super(context, 0x7f0e002b);
        a = context;
        b = k;
        c = i1;
        d = l;
        e = j1;
        g = flag;
        h = dnmproduct;
        i = bbyproduct;
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0c0329)
        {
            cancel();
        } else
        if (view.getId() == 0x7f0c0325)
        {
            view = new Intent("android.intent.action.VIEW", Uri.parse(a.getResources().getString(0x7f0801ac)));
            a.startActivity(view);
            cancel();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        String s1;
        BBYTextView bbytextview;
        ImageView imageview;
        Summary summary;
        super.onCreate(bundle);
        setContentView(0x7f0300ca);
        ((BBYTextView)findViewById(0x7f0c0323)).setText(((Activity)a).getResources().getString(b));
        ((BBYTextView)findViewById(0x7f0c0324)).setText(((Activity)a).getResources().getString(d));
        String s;
        LinearLayout linearlayout;
        if (e <= 0)
        {
            findViewById(0x7f0c0326).setVisibility(8);
        } else
        {
            ((BBYTextView)findViewById(0x7f0c0327)).setText(((Activity)a).getResources().getString(c));
            ((BBYTextView)findViewById(0x7f0c0328)).setText(((Activity)a).getResources().getString(e));
        }
        if (f <= 0)
        {
            findViewById(0x7f0c0325).setVisibility(8);
        } else
        {
            ((BBYTextView)findViewById(0x7f0c0325)).setText(((Activity)a).getResources().getString(f));
        }
        findViewById(0x7f0c0329).setOnClickListener(this);
        findViewById(0x7f0c0325).setOnClickListener(this);
        if (!g) goto _L2; else goto _L1
_L1:
        bundle = (LinearLayout)findViewById(0x7f0c0301);
        if (h == null) goto _L2; else goto _L3
_L3:
        if (h.isMapFlag())
        {
            ((BBYTextView)findViewById(0x7f0c0327)).setVisibility(8);
            ((BBYTextView)findViewById(0x7f0c0328)).setVisibility(8);
        }
        bundle.setVisibility(0);
        imageview = (ImageView)bundle.findViewById(0x7f0c012e);
        bbytextview = (BBYTextView)bundle.findViewById(0x7f0c012f);
        linearlayout = (LinearLayout)bundle.findViewById(0x7f0c00cd);
        linearlayout.removeAllViews();
        bundle = "";
        if (i == null) goto _L5; else goto _L4
_L4:
        summary = i.getSummary();
        if (summary.getNames() != null)
        {
            bundle = summary.getNames().getShortName();
        }
        s1 = "";
        if (summary.getMedia() == null) goto _L7; else goto _L6
_L6:
label0:
        {
            if (summary.getMedia().getPrimaryImage() != null)
            {
                s1 = summary.getMedia().getPrimaryImage().getUrl();
            }
            if (!s1.isEmpty())
            {
                s = s1;
                if (!s1.equals(a.getString(0x7f080068)))
                {
                    break label0;
                }
            }
            s = s1;
            if (summary.getMedia().getListImage() != null)
            {
                s = summary.getMedia().getListImage().getUrl();
            }
        }
label1:
        {
            if (!s.isEmpty())
            {
                s1 = s;
                if (!s.equals(a.getString(0x7f080068)))
                {
                    break label1;
                }
            }
            s1 = s;
            if (summary.getMedia().getThumbnailImage() != null)
            {
                s1 = summary.getMedia().getThumbnailImage().getUrl();
            }
        }
        ng.a(s1, imageview, false);
_L13:
        Object obj;
        try
        {
            lt.a(a, bbytextview, bundle, 1000, 0x7f080024);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            bbytextview.setText(bundle);
        }
        bundle = null;
        if (i == null) goto _L9; else goto _L8
_L8:
        bundle = lp.a((Activity)a, i, 1, true, h, true, "");
_L11:
        linearlayout.addView(bundle);
_L2:
        return;
_L7:
        if (summary.getPdpMedia() != null)
        {
            if (summary.getPdpMedia().getPrimaryImage() != null)
            {
                s1 = summary.getPdpMedia().getPrimaryImage().getUrl();
            }
            ng.a(s1, imageview, false);
        }
        continue; /* Loop/switch isn't completed */
_L5:
label2:
        {
label3:
            {
                if (j == null)
                {
                    break; /* Loop/switch isn't completed */
                }
                s1 = j.getName();
                if (j.getImages().getImage() == null)
                {
                    break label2;
                }
                obj = j.getImages().getPrimaryImage();
                if (!((String) (obj)).isEmpty())
                {
                    bundle = ((Bundle) (obj));
                    if (!((String) (obj)).equals(a.getString(0x7f080068)))
                    {
                        break label3;
                    }
                }
                bundle = j.getImages().getThumbnailImage();
            }
label4:
            {
                if (!bundle.isEmpty())
                {
                    obj = bundle;
                    if (!bundle.equals(a.getString(0x7f080068)))
                    {
                        break label4;
                    }
                }
                obj = j.getImages().getImage();
            }
label5:
            {
                if (!((String) (obj)).isEmpty())
                {
                    bundle = ((Bundle) (obj));
                    if (!((String) (obj)).equals(a.getString(0x7f080068)))
                    {
                        break label5;
                    }
                }
                bundle = j.getImages().getLargeFrontImage();
            }
label6:
            {
                if (!bundle.isEmpty())
                {
                    obj = bundle;
                    if (!bundle.equals(a.getString(0x7f080068)))
                    {
                        break label6;
                    }
                }
                obj = j.getImages().getLargeImage();
            }
            ng.a(((String) (obj)), imageview, true);
        }
        bundle = s1;
        continue; /* Loop/switch isn't completed */
_L9:
        if (j != null)
        {
            bundle = lp.a((Activity)a, i, 1, true, h, true, "");
        }
        if (true) goto _L11; else goto _L10
_L10:
        bundle = "";
        if (true) goto _L13; else goto _L12
_L12:
    }
}
