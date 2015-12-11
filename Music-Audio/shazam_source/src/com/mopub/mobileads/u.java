// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.c.p;
import com.mopub.common.c.a;
import com.mopub.common.d.h;
import com.mopub.d.l;
import com.mopub.mobileads.a.b;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            e, s, l

public class u extends FrameLayout
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(s s1);
    }

    public static interface b
    {
    }

    public static interface c
    {
    }

    public static interface d
    {
    }

    public static interface e
    {
    }

    public static interface f
    {
    }

    public static interface g
    {
    }


    private Context a;
    protected com.mopub.mobileads.e b;
    protected com.mopub.mobileads.l c;
    private int d;
    private BroadcastReceiver e;
    private a f;
    private g g;
    private e h;
    private d i;
    private f j;
    private c k;
    private b l;

    public u(Context context)
    {
        this(context, (byte)0);
    }

    private u(Context context, byte byte0)
    {
        super(context, null);
        com.mopub.common.d.h.a(context);
        a = context;
        d = getVisibility();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (WebViewDatabase.getInstance(context) == null)
        {
            com.mopub.common.c.a.e("Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:http://code.google.com/p/android/issues/detail?id=10789");
            return;
        } else
        {
            b = com.mopub.mobileads.a.a.a(context, this);
            e = new BroadcastReceiver() {

                final u a;

                public final void onReceive(Context context1, Intent intent)
                {
                    boolean flag;
                    if (com.mopub.mobileads.u.a(a) == 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag && intent != null)
                    {
                        context1 = intent.getAction();
                        if ("android.intent.action.USER_PRESENT".equals(context1))
                        {
                            com.mopub.mobileads.u.a(a, 0);
                            return;
                        }
                        if ("android.intent.action.SCREEN_OFF".equals(context1))
                        {
                            com.mopub.mobileads.u.a(a, 8);
                            return;
                        }
                    }
                }

            
            {
                a = u.this;
                super();
            }
            };
            context = new IntentFilter("android.intent.action.SCREEN_OFF");
            context.addAction("android.intent.action.USER_PRESENT");
            a.registerReceiver(e, context);
            return;
        }
    }

    static int a(u u1)
    {
        return u1.d;
    }

    static void a(u u1, int i1)
    {
        u1.setAdVisibility(i1);
    }

    private void setAdVisibility(int i1)
    {
        if (b == null)
        {
            return;
        }
        if (i1 == 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            com.mopub.mobileads.e e1 = b;
            e1.a(e1.k);
            return;
        } else
        {
            com.mopub.mobileads.e e2 = b;
            e2.k = e2.j;
            e2.a(false);
            return;
        }
    }

    protected void a(s s1)
    {
        if (f != null)
        {
            f.a(s1);
        }
    }

    protected void a(String s1, Map map)
    {
        if (b != null)
        {
            if (TextUtils.isEmpty(s1))
            {
                com.mopub.common.c.a.b("Couldn't invoke custom event because the server did not specify one.");
                b(s.g);
                return;
            }
            if (c != null)
            {
                c.a();
            }
            com.mopub.common.c.a.b("Loading custom event adapter.");
            c = com.mopub.mobileads.a.b.a(this, s1, map, b.a, b.c());
            s1 = c;
            if (!((com.mopub.mobileads.l) (s1)).a && ((com.mopub.mobileads.l) (s1)).b != null && s1.b() > 0)
            {
                ((com.mopub.mobileads.l) (s1)).c.postDelayed(((com.mopub.mobileads.l) (s1)).d, s1.b());
                return;
            }
        }
    }

    public final void b()
    {
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            e1.h = 1;
            e1.a();
        }
    }

    protected final void b(s s1)
    {
        if (b != null)
        {
            b.a(s1);
        }
    }

    public final void c()
    {
        try
        {
            a.unregisterReceiver(e);
        }
        catch (Exception exception)
        {
            com.mopub.common.c.a.b("Failed to unregister screen state broadcast receiver (never registered).");
        }
        removeAllViews();
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            if (!e1.f)
            {
                if (e1.q != null)
                {
                    e1.q.h = true;
                    e1.q = null;
                }
                e1.a(false);
                e1.e();
                e1.c = null;
                e1.b = null;
                e1.d = null;
                e1.f = true;
            }
            b = null;
        }
        if (c != null)
        {
            c.a();
            c = null;
        }
    }

    protected final void d()
    {
        if (b != null)
        {
            Object obj = b;
            if (((com.mopub.mobileads.e) (obj)).e != null)
            {
                String s1 = ((com.mopub.mobileads.e) (obj)).e.c;
                obj = ((com.mopub.mobileads.e) (obj)).b;
                com.mopub.common.a.a.d d1 = com.mopub.common.a.a.d.c;
                p.a(s1, ((Context) (obj)));
            }
            if (f != null)
            {
                f.a();
            }
        }
    }

    public Activity getActivity()
    {
        return (Activity)a;
    }

    public com.mopub.common.a getAdFormat()
    {
        return com.mopub.common.a.a;
    }

    public int getAdHeight()
    {
        boolean flag = false;
        int i1 = ((flag) ? 1 : 0);
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            i1 = ((flag) ? 1 : 0);
            if (e1.e != null)
            {
                i1 = ((flag) ? 1 : 0);
                if (e1.e.h != null)
                {
                    i1 = e1.e.h.intValue();
                }
            }
        }
        return i1;
    }

    Integer getAdTimeoutDelay()
    {
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            if (e1.e != null)
            {
                return e1.e.i;
            }
        }
        return null;
    }

    public String getAdUnitId()
    {
        if (b != null)
        {
            return b.o;
        } else
        {
            return null;
        }
    }

    com.mopub.mobileads.e getAdViewController()
    {
        return b;
    }

    public int getAdWidth()
    {
        boolean flag = false;
        int i1 = ((flag) ? 1 : 0);
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            i1 = ((flag) ? 1 : 0);
            if (e1.e != null)
            {
                i1 = ((flag) ? 1 : 0);
                if (e1.e.g != null)
                {
                    i1 = e1.e.g.intValue();
                }
            }
        }
        return i1;
    }

    public boolean getAutorefreshEnabled()
    {
        if (b != null)
        {
            return b.j;
        } else
        {
            com.mopub.common.c.a.b("Can't get autorefresh status for destroyed MoPubView. Returning false.");
            return false;
        }
    }

    public a getBannerAdListener()
    {
        return f;
    }

    public String getClickTrackingUrl()
    {
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            if (e1.e != null)
            {
                return e1.e.c;
            }
        }
        return null;
    }

    public String getClickthroughUrl()
    {
        return getClickTrackingUrl();
    }

    public String getKeywords()
    {
        if (b != null)
        {
            return b.l;
        } else
        {
            return null;
        }
    }

    public Map getLocalExtras()
    {
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            if (e1.i != null)
            {
                return new TreeMap(e1.i);
            } else
            {
                return new TreeMap();
            }
        } else
        {
            return new TreeMap();
        }
    }

    public Location getLocation()
    {
        if (b != null)
        {
            return b.m;
        } else
        {
            return null;
        }
    }

    public com.mopub.common.k.a getLocationAwareness()
    {
        return com.mopub.common.k.a.a(com.mopub.common.l.a());
    }

    public int getLocationPrecision()
    {
        return com.mopub.common.l.b();
    }

    public String getResponseString()
    {
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            if (e1.e != null)
            {
                return e1.e.l;
            }
        }
        return null;
    }

    public boolean getTesting()
    {
        if (b != null)
        {
            return b.n;
        } else
        {
            com.mopub.common.c.a.b("Can't get testing status for destroyed MoPubView. Returning false.");
            return false;
        }
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        boolean flag2 = true;
        boolean flag;
        boolean flag1;
        if (d == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i1 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag != flag1)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            d = i1;
            setAdVisibility(d);
        }
    }

    public void setAdContentView(View view)
    {
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            e1.g.post(new e._cls3(e1, view));
        }
    }

    public void setAdUnitId(String s1)
    {
        if (b != null)
        {
            b.o = s1;
        }
    }

    public void setAutorefreshEnabled(boolean flag)
    {
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            e1.k = flag;
            e1.a(flag);
        }
    }

    public void setBannerAdListener(a a1)
    {
        f = a1;
    }

    public void setClickthroughUrl(String s1)
    {
    }

    public void setFacebookSupported(boolean flag)
    {
    }

    public void setKeywords(String s1)
    {
        if (b != null)
        {
            b.l = s1;
        }
    }

    public void setLocalExtras(Map map)
    {
        if (b != null)
        {
            com.mopub.mobileads.e e1 = b;
            if (map != null)
            {
                map = new TreeMap(map);
            } else
            {
                map = new TreeMap();
            }
            e1.i = map;
        }
    }

    public void setLocation(Location location)
    {
        if (b != null)
        {
            b.m = location;
        }
    }

    public void setLocationAwareness(com.mopub.common.k.a a1)
    {
        if (a1 == com.mopub.common.k.a.b)
        {
            a1 = com.mopub.common.l.a.b;
        } else
        if (a1 == com.mopub.common.k.a.c)
        {
            a1 = com.mopub.common.l.a.c;
        } else
        {
            a1 = com.mopub.common.l.a.a;
        }
        com.mopub.common.l.a(a1);
    }

    public void setLocationPrecision(int i1)
    {
        com.mopub.common.l.a(i1);
    }

    public void setOnAdClickedListener(b b1)
    {
        l = b1;
    }

    public void setOnAdClosedListener(c c1)
    {
        k = c1;
    }

    public void setOnAdFailedListener(d d1)
    {
        i = d1;
    }

    public void setOnAdLoadedListener(e e1)
    {
        h = e1;
    }

    public void setOnAdPresentedOverlayListener(f f1)
    {
        j = f1;
    }

    public void setOnAdWillLoadListener(g g1)
    {
        g = g1;
    }

    public void setTesting(boolean flag)
    {
        if (b != null)
        {
            b.n = flag;
        }
    }

    public void setTimeout(int i1)
    {
        if (b != null)
        {
            b.p = i1;
        }
    }
}
