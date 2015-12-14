// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.widgetpool.common.FixedAspectRatioFrameLayout;
import com.cyberlink.youcammakeup.widgetpool.common.MultiColorView;
import com.cyberlink.youcammakeup.widgetpool.common.StrokeTextView;
import com.cyberlink.youcammakeup.widgetpool.common.v;
import com.perfectcorp.utility.u;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class d extends FrameLayout
{

    private TextView a;
    private TextView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private View m;
    private View n;
    private View o;
    private View p;
    private StrokeTextView q;
    private StrokeTextView r;
    private StrokeTextView s;
    private LinearLayout t;
    private ImageView u;
    private Uri v;
    private MultiColorView w;
    private MultiColorView x;
    private MultiColorView y;
    private android.view.View.OnClickListener z;

    public d(Context context)
    {
        super(context);
        z = new android.view.View.OnClickListener() {

            final d a;

            public void onClick(View view)
            {
                Object obj = new u(d.a(a).toString());
                ((u) (obj)).a("SourceType", "feature_room");
                String s1;
                try
                {
                    obj = Uri.parse(((u) (obj)).c());
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                s1 = ((Uri) (obj)).getScheme();
                if (s1 != null && s1.equalsIgnoreCase(a.getContext().getString(0x7f070742)))
                {
                    obj = new Intent("android.intent.action.VIEW", ((Uri) (obj)));
                    view.getContext().startActivity(((Intent) (obj)));
                    return;
                } else
                {
                    Intent intent = new Intent(a.getContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                    intent.putExtra("RedirectUrl", d.a(a).toString());
                    view.getContext().startActivity(intent);
                    return;
                }
            }

            
            {
                a = d.this;
                super();
            }
        };
        a(context);
    }

    private Bitmap a(String s1)
    {
        BufferedInputStream bufferedinputstream;
        if (s1.indexOf("assets://") != 0)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        bufferedinputstream = new BufferedInputStream(getContext().getAssets().open(s1.substring("assets://".length())));
        s1 = BitmapFactory.decodeStream(bufferedinputstream);
        bufferedinputstream.close();
        return s1;
        s1 = BitmapFactory.decodeFile(s1);
        return s1;
        IOException ioexception;
        ioexception;
        s1 = null;
_L2:
        ioexception.printStackTrace();
        return s1;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static Uri a(d d1)
    {
        return d1.v;
    }

    private void a(Context context)
    {
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0301f7, this);
        a = (TextView)findViewById(0x7f0c08ad);
        b = (TextView)findViewById(0x7f0c08ae);
        c = (ImageView)findViewById(0x7f0c08b0);
        d = (ImageView)findViewById(0x7f0c08af);
        e = (ImageView)findViewById(0x7f0c08b4);
        f = (ImageView)findViewById(0x7f0c08bb);
        g = (ImageView)findViewById(0x7f0c08bf);
        q = (StrokeTextView)findViewById(0x7f0c08b8);
        r = (StrokeTextView)findViewById(0x7f0c08bc);
        s = (StrokeTextView)findViewById(0x7f0c08c0);
        i = (TextView)findViewById(0x7f0c08b9);
        j = (TextView)findViewById(0x7f0c08bd);
        k = (TextView)findViewById(0x7f0c08c1);
        h = (TextView)findViewById(0x7f0c08b2);
        l = (TextView)findViewById(0x7f0c08b1);
        m = findViewById(0x7f0c08b3);
        n = findViewById(0x7f0c08ba);
        o = findViewById(0x7f0c08be);
        p = findViewById(0x7f0c08c2);
        t = (LinearLayout)findViewById(0x7f0c08c3);
        u = (ImageView)findViewById(0x7f0c08c4);
        w = (MultiColorView)findViewById(0x7f0c08b5);
        x = (MultiColorView)findViewById(0x7f0c08b6);
        y = (MultiColorView)findViewById(0x7f0c08b7);
        q.setTextHeightRatio(0.5F);
        r.setTextHeightRatio(0.5F);
        s.setTextHeightRatio(0.5F);
        q.setTextFillColor(Color.parseColor("#333333"));
        r.setTextFillColor(Color.parseColor("#333333"));
        s.setTextFillColor(Color.parseColor("#333333"));
        q.setTextStrokeColor(Color.parseColor("#EDE1D9"));
        r.setTextStrokeColor(Color.parseColor("#EDE1D9"));
        s.setTextStrokeColor(Color.parseColor("#EDE1D9"));
        p.setOnClickListener(z);
    }

    public void a(int i1, int j1)
    {
        if (w != null)
        {
            w.a(i1, j1);
        }
    }

    public void a(int i1, int j1, int k1, float f1)
    {
        if (y != null)
        {
            y.a(i1, j1, k1, f1);
        }
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        if (x != null)
        {
            x.a(i1, j1, k1, l1);
        }
    }

    public void setBrandImage(String s1)
    {
        if (s1 == null)
        {
            u.setVisibility(4);
            return;
        } else
        {
            u.setVisibility(0);
            s1 = a(s1);
            u.setImageBitmap(s1);
            return;
        }
    }

    public void setBuyButtonVisibility(int i1)
    {
        p.setVisibility(i1);
    }

    public void setBuyUri(Uri uri)
    {
        v = uri;
    }

    public void setFirstPropertyColor(int i1)
    {
        e.setBackgroundColor(i1);
    }

    public void setFirstPropertyFourColorViewVisibility(int i1)
    {
        if (x != null)
        {
            x.setVisibility(i1);
        }
    }

    public void setFirstPropertyImage(Bitmap bitmap)
    {
        e.setImageBitmap(bitmap);
    }

    public void setFirstPropertyImage(String s1)
    {
        setFirstPropertyImage(a(s1));
    }

    public void setFirstPropertyImageTexture(int i1)
    {
        q.setBackgroundResource(i1);
    }

    public void setFirstPropertyIntensity(int i1)
    {
        if (i1 < 0)
        {
            i.setVisibility(8);
            return;
        } else
        {
            i.setVisibility(0);
            String s1 = (new StringBuilder()).append(String.valueOf(i1)).append('%').toString();
            i.setText(s1);
            return;
        }
    }

    public void setFirstPropertyThreeColorViewVisibility(int i1)
    {
        if (y != null)
        {
            y.setVisibility(i1);
        }
    }

    public void setFirstPropertyTwoColorViewVisibility(int i1)
    {
        if (w != null)
        {
            w.setVisibility(i1);
        }
    }

    public void setFirstPropertyVisibility(int i1)
    {
        m.setVisibility(i1);
    }

    public void setOrderTextVisibility(int i1)
    {
        if (i1 == 0)
        {
            q.setText("1");
            r.setText("2");
            s.setText("3");
            return;
        } else
        {
            q.setText(null);
            r.setText(null);
            s.setText(null);
            return;
        }
    }

    public void setPatternBackground(Bitmap bitmap)
    {
        d.setImageBitmap(bitmap);
    }

    public void setPatternBackground(String s1)
    {
        if (s1 != null)
        {
            setPatternBackground(a(s1));
            return;
        } else
        {
            setPatternBackground((Bitmap)null);
            return;
        }
    }

    public void setPatternImage(Bitmap bitmap)
    {
        c.setVisibility(0);
        c.setImageBitmap(bitmap);
        t.setVisibility(4);
    }

    public void setPatternImage(String s1)
    {
        if (s1 != null)
        {
            setPatternImage(a(s1));
            return;
        } else
        {
            setPatternImage((Bitmap)null);
            return;
        }
    }

    public void setPatternImages(List list)
    {
        t.removeAllViews();
        t.setVisibility(0);
        c.setVisibility(4);
        Object obj;
        for (list = list.iterator(); list.hasNext(); t.addView(((View) (obj)), new android.widget.LinearLayout.LayoutParams(0, -1)))
        {
            obj = (String)list.next();
            ImageView imageview = new ImageView(getContext());
            imageview.setImageBitmap(a(((String) (obj))));
            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            obj = new FixedAspectRatioFrameLayout(getContext());
            ((FixedAspectRatioFrameLayout) (obj)).addView(imageview, new v(-1, -1));
            ((FixedAspectRatioFrameLayout) (obj)).a(161, 149);
        }

    }

    public void setPatternText(CharSequence charsequence)
    {
        h.setText(charsequence);
    }

    public void setSecondPropertyColor(int i1)
    {
        f.setBackgroundColor(i1);
    }

    public void setSecondPropertyImage(Bitmap bitmap)
    {
        f.setImageBitmap(bitmap);
    }

    public void setSecondPropertyImage(String s1)
    {
        setSecondPropertyImage(a(s1));
    }

    public void setSecondPropertyImageTexture(int i1)
    {
        r.setBackgroundResource(i1);
    }

    public void setSecondPropertyIntensity(int i1)
    {
        if (i1 < 0)
        {
            j.setVisibility(8);
            return;
        } else
        {
            j.setVisibility(0);
            String s1 = (new StringBuilder()).append(String.valueOf(i1)).append('%').toString();
            j.setText(s1);
            return;
        }
    }

    public void setSecondPropertyVisibility(int i1)
    {
        n.setVisibility(i1);
    }

    public void setSkuNameText(String s1)
    {
        if (l != null)
        {
            l.setText(s1);
        }
    }

    public void setSkuNameTextVisibility(int i1)
    {
        if (l != null)
        {
            l.setVisibility(i1);
        }
    }

    public void setSubTitle(CharSequence charsequence)
    {
        if (charsequence == null || charsequence.toString().equals(""))
        {
            b.setVisibility(8);
        } else
        {
            b.setVisibility(0);
        }
        b.setText(charsequence);
    }

    public void setThirdPropertyColor(int i1)
    {
        g.setBackgroundColor(i1);
    }

    public void setThirdPropertyImage(Bitmap bitmap)
    {
        g.setImageBitmap(bitmap);
    }

    public void setThirdPropertyImage(String s1)
    {
        setThirdPropertyImage(a(s1));
    }

    public void setThirdPropertyImageTexture(int i1)
    {
        s.setBackgroundResource(i1);
    }

    public void setThirdPropertyIntensity(int i1)
    {
        if (i1 < 0)
        {
            k.setVisibility(8);
            return;
        } else
        {
            k.setVisibility(0);
            String s1 = (new StringBuilder()).append(String.valueOf(i1)).append('%').toString();
            k.setText(s1);
            return;
        }
    }

    public void setThirdPropertyVisibility(int i1)
    {
        o.setVisibility(i1);
    }

    public void setTitle(CharSequence charsequence)
    {
        a.setText(charsequence);
    }
}
