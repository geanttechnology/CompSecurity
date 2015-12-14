// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMBaseActivity, MMActivity, MMLog, AdViewOverlayView, 
//            MMAdImpl, MMAdImplController, MMWebView, OverlaySettings, 
//            BridgeMMSpeechkit, InlineVideoView, MMLayout, MMSDK

class AdViewOverlayActivity extends MMBaseActivity
{

    OverlaySettings a;
    private AdViewOverlayView c;
    private boolean d;
    private boolean e;

    AdViewOverlayActivity()
    {
    }

    private void e()
    {
        if (b.getRequestedOrientation() == 0)
        {
            setRequestedOrientation(0);
            return;
        }
        if (b.getRequestedOrientation() == 8)
        {
            setRequestedOrientation(8);
            return;
        }
        if (b.getRequestedOrientation() == 9)
        {
            setRequestedOrientation(9);
            return;
        } else
        {
            setRequestedOrientation(1);
            return;
        }
    }

    protected final void a()
    {
        e = false;
        MMLog.b("AdViewOverlayActivity", "Overlay onResume");
        if (c != null)
        {
            if (d)
            {
                c.i();
            }
            c.addBlackView();
            if (c.e != null && c.e.h != null && c.e.h.a != null)
            {
                c.e.h.a.onResumeWebView();
            }
        }
        super.a();
    }

    protected final void a(Bundle bundle)
    {
        if (c != null)
        {
            bundle.putInt("adViewId", c.getId());
        }
        super.a(bundle);
    }

    final void a(boolean flag)
    {
        a.k = flag;
        if (flag)
        {
            setRequestedOrientation(-1);
            return;
        } else
        {
            e();
            return;
        }
    }

    protected final void b()
    {
        BridgeMMMedia.Audio audio;
        e = true;
        MMLog.b("AdViewOverlayActivity", "Overlay onPause");
        audio = BridgeMMMedia.Audio.a(b);
        if (audio == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        audio.b();
        this;
        JVM INSTR monitorexit ;
_L2:
        if (c != null)
        {
            c.h();
            if (c.e != null && c.e.h != null && c.e.h.a != null)
            {
                c.e.h.a.onPauseWebView();
            }
        }
        setResult(0);
        super.b();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final void b(Bundle bundle)
    {
        super.b(bundle);
    }

    protected final void c()
    {
        super.c();
    }

    public void finish()
    {
        if (c != null)
        {
            AdViewOverlayView adviewoverlayview = c;
            android.view.ViewParent viewparent;
            boolean flag;
            if (adviewoverlayview.e != null && adviewoverlayview.e.j != 0L && MMAdImplController.b(adviewoverlayview.e))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                adviewoverlayview = c;
                BridgeMMSpeechkit.a();
                if (adviewoverlayview.e != null && adviewoverlayview.e.h != null && adviewoverlayview.e.h.a != null)
                {
                    adviewoverlayview.e.h.a.clearFocus();
                    adviewoverlayview.e.h.a.l();
                    if (adviewoverlayview.e.e == "i")
                    {
                        adviewoverlayview.e.h.a.k();
                    }
                    adviewoverlayview.e.h.a.onPauseWebView();
                }
            }
            adviewoverlayview = c;
            adviewoverlayview.removeAllViews();
            viewparent = adviewoverlayview.getParent();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                ((ViewGroup)viewparent).removeView(adviewoverlayview);
            }
        }
        c = null;
        super.finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (c != null)
        {
            AdViewOverlayView adviewoverlayview = c;
            if (adviewoverlayview.i != null && adviewoverlayview.h != null)
            {
                adviewoverlayview.h.setLayoutParams(adviewoverlayview.i.getCustomLayoutParams());
                adviewoverlayview.d();
            }
        }
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        setTheme(0x1030010);
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().clearFlags(1024);
        getWindow().addFlags(2048);
        getWindow().addFlags(0x1000000);
        bundle = getIntent();
        a = (OverlaySettings)bundle.getParcelableExtra("settings");
        if (a == null)
        {
            a = new OverlaySettings();
        }
        MMLog.a("OverlaySettings", a.toString());
        if (a.f != null)
        {
            Object obj = a.f;
            if ("landscape".equalsIgnoreCase(((String) (obj))))
            {
                setRequestedOrientation(0);
            } else
            if ("portrait".equalsIgnoreCase(((String) (obj))))
            {
                setRequestedOrientation(1);
            }
        }
        if (a.k)
        {
            setRequestedOrientation(-1);
        } else
        {
            e();
        }
        if (bundle != null)
        {
            bundle = bundle.getData();
            if (bundle != null)
            {
                MMLog.a("AdViewOverlayActivity", String.format("Path: %s", new Object[] {
                    bundle.getLastPathSegment()
                }));
            }
        }
        bundle = new RelativeLayout(b);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        bundle.setId(0x34c60db9);
        bundle.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        c = new AdViewOverlayView(this, a);
        bundle.addView(c);
        setContentView(bundle);
        if (getLastNonConfigurationInstance() == null)
        {
            if (a.a())
            {
                if (c.e != null && c.e.h != null && c.e.h.a != null)
                {
                    c.e.h.a.n();
                }
                if (a.b())
                {
                    (new AdViewOverlayView.FetchWebViewContentTask(c, a.g)).execute(new Void[0]);
                }
            } else
            if (!a.a())
            {
                Object obj1 = c;
                bundle = a.l;
                String s = a.m;
                if (MMSDK.a(((MMLayout) (obj1)).getContext()))
                {
                    if (((MMLayout) (obj1)).e.h != null)
                    {
                        obj1 = ((MMLayout) (obj1)).e.h;
                        MMAdImpl mmadimpl = (MMAdImpl)((MMAdImplController) (obj1)).b.get();
                        if (mmadimpl != null && ((MMAdImplController) (obj1)).a != null)
                        {
                            ((MMAdImplController) (obj1)).a.a(bundle, s, mmadimpl);
                        }
                    }
                } else
                {
                    MMLog.e("MMLayout", "No network available, can't load overlay.");
                }
            }
        }
        a.f = null;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        MMLog.b("AdViewOverlayActivity", "Overlay onDestroy");
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0 && c != null)
        {
            c.b();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public Object onRetainNonConfigurationInstance()
    {
        if (c != null)
        {
            AdViewOverlayView adviewoverlayview = c;
            AdViewOverlayView.NonConfigurationInstance nonconfigurationinstance = new AdViewOverlayView.NonConfigurationInstance((byte)0);
            if (adviewoverlayview.e != null)
            {
                MMLog.b("AdViewOverlayView", (new StringBuilder("Saving getNonConfigurationInstance for ")).append(adviewoverlayview.e).toString());
                if (adviewoverlayview.e.h != null && adviewoverlayview.e.h.a != null)
                {
                    adviewoverlayview.e.h.a.o();
                }
                nonconfigurationinstance.b = adviewoverlayview.e.h;
            }
            nonconfigurationinstance.a = adviewoverlayview.a;
            nonconfigurationinstance.c = adviewoverlayview.b;
            return nonconfigurationinstance;
        } else
        {
            return null;
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        d = flag;
        if (!e && flag)
        {
            c.i();
        }
    }
}
