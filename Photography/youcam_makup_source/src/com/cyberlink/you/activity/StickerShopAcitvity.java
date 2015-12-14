// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.cyberlink.you.BaseFragmentActivity;
import com.cyberlink.you.g;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.r;
import com.cyberlink.you.widgetpool.common.CLFragmentTabHost;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.cyberlink.you.activity:
//            t, u

public class StickerShopAcitvity extends BaseFragmentActivity
{

    public static ThreadPoolExecutor a;
    private static AtomicBoolean e = new AtomicBoolean(false);
    private static final int g;
    private static ThreadGroup h = new ThreadGroup("NetAsyncTask");
    private boolean b;
    private boolean c;
    private t d;
    private CLFragmentTabHost f;
    private android.view.View.OnClickListener i;

    public StickerShopAcitvity()
    {
        b = false;
        c = false;
        d = null;
        f = null;
        i = new android.view.View.OnClickListener() {

            final StickerShopAcitvity a;

            public void onClick(View view)
            {
                if (StickerShopAcitvity.a(a))
                {
                    view = new Intent();
                    view.putExtra("isChanged", StickerShopAcitvity.a(a));
                    a.setResult(-1, view);
                }
                a.finish();
            }

            
            {
                a = StickerShopAcitvity.this;
                super();
            }
        };
    }

    private View a(String s, int j)
    {
        Object obj = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        j = (int)((float)((DisplayMetrics) (obj)).widthPixels / (float)2);
        int k = (int)(0.1944444F * (float)j);
        obj = getLayoutInflater().inflate(p.u_chat_album_fragment_selection, null);
        ((TextView)((View) (obj)).findViewById(o.chat_album_fragment_item_text)).setText(s);
        ((View) (obj)).setLayoutParams(new android.view.ViewGroup.LayoutParams(j, k));
        return ((View) (obj));
    }

    static ThreadGroup a()
    {
        return h;
    }

    static boolean a(StickerShopAcitvity stickershopacitvity)
    {
        return stickershopacitvity.c;
    }

    static AtomicBoolean b()
    {
        return e;
    }

    static boolean b(StickerShopAcitvity stickershopacitvity)
    {
        return stickershopacitvity.b;
    }

    static CLFragmentTabHost c(StickerShopAcitvity stickershopacitvity)
    {
        return stickershopacitvity.f;
    }

    private void c()
    {
        e.set(true);
        d = new t(this);
        d.executeOnExecutor(a, new Void[0]);
    }

    public void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        j;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (intent != null && -1 == k && intent.getBooleanExtra("isChanged", false))
        {
            c = true;
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        if (c)
        {
            Intent intent = new Intent();
            intent.putExtra("isChanged", c);
            setResult(-1, intent);
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = false;
        c = false;
        setContentView(p.u_activity_sticker_shop);
        u.a(com.cyberlink.you.g.a().w());
        c();
        u.a(findViewById(o.tabsNewIcon));
        findViewById(o.close).setOnClickListener(i);
        f = (CLFragmentTabHost)findViewById(o.tabhost);
        f.a(this, getSupportFragmentManager(), o.realtabcontent);
        bundle = new Bundle();
        bundle.putString("type", "Top");
        f.a(f.newTabSpec("Top").setIndicator(a(getString(r.u_top_tab), p.u_chat_album_fragment_selection)), com/cyberlink/you/activity/u, bundle);
        bundle = new Bundle();
        bundle.putString("type", "New");
        f.a(f.newTabSpec("New").setIndicator(a(getString(r.u_new_tab), p.u_chat_album_fragment_selection)), com/cyberlink/you/activity/u, bundle);
        if (!com.cyberlink.you.g.a().B())
        {
            com.cyberlink.you.g.a().c(true);
            return;
        } else
        {
            f.setCurrentTabByTag("New");
            return;
        }
    }

    public void onDestroy()
    {
        b = true;
        if (d != null && d.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            d.cancel(true);
        }
        u.a(null);
        findViewById(o.close).setOnClickListener(null);
        super.onDestroy();
    }

    static 
    {
        g = Runtime.getRuntime().availableProcessors();
        a = new ThreadPoolExecutor(g + 1, g * 5 + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(StickerShopAcitvity.a(), runnable, (new StringBuilder()).append("Network AsyncTask #").append(a.getAndIncrement()).toString());
            }

        });
    }
}
