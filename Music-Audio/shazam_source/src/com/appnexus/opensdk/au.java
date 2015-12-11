// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.l;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.appnexus.opensdk:
//            p, m, k, d

class au extends p
{

    private m a;
    android.webkit.WebChromeClient.CustomViewCallback c;
    FrameLayout d;
    Activity e;
    k f;
    LinkedList g;

    public au(Activity activity)
    {
        e = activity;
    }

    public au(m m1)
    {
        e = (Activity)m1.getContext();
        a = m1;
        f = a.b;
    }

    public void onGeolocationPermissionsHidePrompt()
    {
        if (f != null && !f.f() && !f.h)
        {
            f.getAdDispatcher().b();
        }
    }

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
    {
        Object obj;
        if (a != null)
        {
            obj = l.b(a);
        } else
        {
            obj = e;
        }
        obj = new android.app.AlertDialog.Builder(((android.content.Context) (obj)));
        ((android.app.AlertDialog.Builder) (obj)).setTitle(String.format(e.getResources().getString(an.d.html5_geo_permission_prompt_title), new Object[] {
            s
        }));
        ((android.app.AlertDialog.Builder) (obj)).setMessage(an.d.html5_geo_permission_prompt);
        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(an.d.allow, new android.content.DialogInterface.OnClickListener(callback, s) {

            final android.webkit.GeolocationPermissions.Callback a;
            final String b;
            final au c;

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                a.invoke(b, true, true);
            }

            
            {
                c = au.this;
                a = callback;
                b = s;
                super();
            }
        });
        ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(an.d.deny, new android.content.DialogInterface.OnClickListener(callback, s) {

            final android.webkit.GeolocationPermissions.Callback a;
            final String b;
            final au c;

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                a.invoke(b, false, false);
            }

            
            {
                c = au.this;
                a = callback;
                b = s;
                super();
            }
        });
        ((android.app.AlertDialog.Builder) (obj)).create().show();
        if (f != null && !f.f() && !f.h)
        {
            f.getAdDispatcher().a();
        }
    }

    public void onHideCustomView()
    {
        super.onHideCustomView();
        if (e == null || d == null)
        {
            b.d(b.b, b.a(an.d.fullscreen_video_hide_error));
        } else
        {
            ViewGroup viewgroup = (ViewGroup)e.findViewById(0x1020002);
            if (viewgroup == null)
            {
                b.d(b.b, b.a(an.d.fullscreen_video_hide_error));
                return;
            }
            viewgroup.removeView(d);
            if (g != null)
            {
                Pair pair;
                for (Iterator iterator = g.iterator(); iterator.hasNext(); ((View)pair.first).setVisibility(((Integer)pair.second).intValue()))
                {
                    pair = (Pair)iterator.next();
                }

            }
            g = null;
            if (c != null)
            {
                c.onCustomViewHidden();
                return;
            }
        }
    }

    public void onShowCustomView(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        onShowCustomView(view, customviewcallback);
    }

    public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        int i = 0;
        super.onShowCustomView(view, customviewcallback);
        if (e == null)
        {
            b.d(b.b, b.a(an.d.fullscreen_video_show_error));
            return;
        }
        ViewGroup viewgroup = (ViewGroup)e.findViewById(0x1020002);
        if (viewgroup == null)
        {
            b.d(b.b, b.a(an.d.fullscreen_video_show_error));
            return;
        }
        c = customviewcallback;
        if (view instanceof FrameLayout)
        {
            d = (FrameLayout)view;
            g = new LinkedList();
            for (; i < viewgroup.getChildCount(); i++)
            {
                view = viewgroup.getChildAt(i);
                g.add(new Pair(view, Integer.valueOf(view.getVisibility())));
                view.setVisibility(8);
            }

            try
            {
                view = d;
                customviewcallback = new ImageButton(e);
                customviewcallback.setImageDrawable(e.getResources().getDrawable(0x1080038));
                customviewcallback.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2, 53));
                customviewcallback.setBackgroundColor(0);
                customviewcallback.setOnClickListener(new android.view.View.OnClickListener() {

                    final au a;

                    public final void onClick(View view1)
                    {
                        a.onHideCustomView();
                    }

            
            {
                a = au.this;
                super();
            }
                });
                view.addView(customviewcallback);
                e.addContentView(d, new android.view.ViewGroup.LayoutParams(-1, -1));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                b.b(b.b, view.toString());
            }
            return;
        } else
        {
            d = null;
            return;
        }
    }
}
