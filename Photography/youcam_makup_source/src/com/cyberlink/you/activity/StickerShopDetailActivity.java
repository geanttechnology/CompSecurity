// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.you.BaseActivity;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.m;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.l;
import com.cyberlink.you.n;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.r;
import com.nostra13.universalimageloader.core.f;

public class StickerShopDetailActivity extends BaseActivity
{

    private StickerPackObj a;
    private Button b;
    private View c;
    private String d;
    private com.cyberlink.you.friends.l e;
    private ProgressDialog f;
    private android.view.View.OnClickListener g;
    private android.view.View.OnClickListener h;

    public StickerShopDetailActivity()
    {
        d = null;
        f = null;
        g = new android.view.View.OnClickListener() {

            final StickerShopDetailActivity a;

            public void onClick(View view)
            {
                StickerShopDetailActivity.a(a);
            }

            
            {
                a = StickerShopDetailActivity.this;
                super();
            }
        };
        h = new android.view.View.OnClickListener() {

            final StickerShopDetailActivity a;

            public void onClick(View view)
            {
                if (StickerShopDetailActivity.b(a) != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if ((view = StickerShopDetailActivity.b(a).o()) == null) goto _L1; else goto _L3
_L3:
                if (view.isEmpty()) goto _L1; else goto _L4
_L4:
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(view));
                a.startActivity(intent);
                return;
                view;
                Log.d("StickerShopDetailACT", Log.getStackTraceString(view));
                return;
            }

            
            {
                a = StickerShopDetailActivity.this;
                super();
            }
        };
    }

    private void a()
    {
        if (b().getCallingActivity() != null)
        {
            setResult(-1, null);
        }
        finish();
    }

    static void a(StickerShopDetailActivity stickershopdetailactivity)
    {
        stickershopdetailactivity.a();
    }

    private Activity b()
    {
        return this;
    }

    static StickerPackObj b(StickerShopDetailActivity stickershopdetailactivity)
    {
        return stickershopdetailactivity.a;
    }

    private void c()
    {
        b.setEnabled(false);
        b.setBackgroundResource(n.u_bg_edittext_normal_gray_border);
        b.setTextColor(getResources().getColor(l.you_color_normal_gray_text));
        b.setText(getString(r.u_downloaded));
    }

    private void d()
    {
        DisplayMetrics displaymetrics = com.cyberlink.you.g.I().getResources().getDisplayMetrics();
        float f1 = (float)displaymetrics.widthPixels / 1080F;
        int i = (int)Math.ceil(((float)150 / (float)134) * (128F * f1));
        int j = displaymetrics.widthPixels;
        ((TextView)findViewById(o.title)).setMaxWidth(j - i * 2);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_sticker_shop_detail);
        findViewById(o.back).setOnClickListener(g);
        findViewById(o.publisherText).setOnClickListener(h);
        bundle = (StickerPackObj)getIntent().getParcelableExtra("stickerPckObj");
        Log.d("StickerShopDetailACT", (new StringBuilder()).append("stickerPackObj.getPackId() = ").append(bundle.b()).toString());
        StickerPackObj stickerpackobj = com.cyberlink.you.e.i().a(bundle.b());
        if (stickerpackobj != null)
        {
            a = stickerpackobj;
        } else
        {
            a = bundle;
        }
        ((TextView)findViewById(o.auther)).setText(a.m());
        if (a.i().b != null)
        {
            bundle = a.i().b;
            com.nostra13.universalimageloader.core.d d1 = (new com.nostra13.universalimageloader.core.e()).a(g.d).c(false).a();
            com.nostra13.universalimageloader.core.f.b().a(bundle, (ImageView)findViewById(o.cover), d1);
        }
        if (a.f() != null)
        {
            ((TextView)findViewById(o.name)).setText(a.f());
            ((TextView)findViewById(o.title)).setText(a.f());
            d();
        }
        ((TextView)findViewById(o.expiration)).setText(getString(r.u_no_expiry_date));
        if (a.g() != null && !a.g().equals("null"))
        {
            ((TextView)findViewById(o.description)).setVisibility(0);
            ((TextView)findViewById(o.description)).setText(a.g());
        } else
        {
            ((TextView)findViewById(o.description)).setVisibility(8);
        }
        if (a.i().f != null)
        {
            bundle = a.i().f;
            com.nostra13.universalimageloader.core.d d2 = (new com.nostra13.universalimageloader.core.e()).a(g.d).c(false).a();
            com.nostra13.universalimageloader.core.f.b().a(bundle, (ImageView)findViewById(o.preview), d2);
        }
        b = (Button)findViewById(o.download);
        if (a.q() && a.p())
        {
            c();
        }
        if (a.o() == null || a.o().isEmpty())
        {
            findViewById(o.publisherArea).setVisibility(8);
        }
        if (!a.e().equals("Purchase"))
        {
            ((TextView)findViewById(o.text)).setText(getString(r.u_now_get_it_free));
        }
        c = findViewById(o.loading);
        e = new com.cyberlink.you.friends.l(b());
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.d("StickerShopDetailACT", "Destroying helper.");
        if (f != null)
        {
            f.dismiss();
            f = null;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            a();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }
}
