// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.utility.bn;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            x, w, DownloadGridItem, p

public class v
{

    private View a;
    private ImageView b;
    private Button c;
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private View j;
    private View k;
    private w l;
    private MakeupItemMetadata m;
    private DownloadGridItem n;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType o;
    private View p;
    private View q;
    private x r;
    private android.view.View.OnClickListener s;
    private android.view.View.OnClickListener t;
    private android.view.View.OnClickListener u;
    private android.view.View.OnClickListener v;

    public v(View view)
    {
        s = new android.view.View.OnClickListener() {

            final v a;

            public void onClick(View view1)
            {
                v.a(a).a(DownloadItemUtility.UseTemplateTarget.b);
                v.b(a);
            }

            
            {
                a = v.this;
                super();
            }
        };
        t = new android.view.View.OnClickListener() {

            final v a;

            public void onClick(View view1)
            {
                v.a(a).a(DownloadItemUtility.UseTemplateTarget.c);
                v.b(a);
            }

            
            {
                a = v.this;
                super();
            }
        };
        u = new android.view.View.OnClickListener() {

            final v a;

            private boolean a()
            {
                return v.c(a).x() && !v.c(a).w();
            }

            private boolean b()
            {
                return !v.c(a).x() && v.c(a).w();
            }

            public void onClick(View view1)
            {
                if (v.c(a) == null || v.a(a) == null)
                {
                    return;
                }
                if (((p)v.a(a).getTag()).c() == DownloadGridItem.DownloadState.d)
                {
                    if (v.d(a) == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c || a())
                    {
                        v.a(a).a(DownloadItemUtility.UseTemplateTarget.c);
                    } else
                    if (v.d(a) == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.b || b())
                    {
                        v.a(a).a(DownloadItemUtility.UseTemplateTarget.b);
                    } else
                    {
                        int i1 = v.e(a).getVisibility();
                        view1 = v.e(a);
                        if (i1 == 0)
                        {
                            i1 = 4;
                        } else
                        {
                            i1 = 0;
                        }
                        view1.setVisibility(i1);
                        return;
                    }
                } else
                {
                    v.a(a).b();
                }
                v.b(a);
            }

            
            {
                a = v.this;
                super();
            }
        };
        v = new android.view.View.OnClickListener() {

            final v a;

            public void onClick(View view1)
            {
                if (v.f(a) != null)
                {
                    v.f(a).a();
                }
                v.e(a).setVisibility(4);
                v.g(a).setVisibility(4);
            }

            
            {
                a = v.this;
                super();
            }
        };
        a(view);
    }

    static DownloadGridItem a(v v1)
    {
        return v1.n;
    }

    private void a(View view)
    {
        a = view;
        p = a.findViewById(0x7f0c0580);
        b = (ImageView)a.findViewById(0x7f0c0582);
        c = (Button)a.findViewById(0x7f0c0584);
        d = a.findViewById(0x7f0c058a);
        e = a.findViewById(0x7f0c0585);
        f = (TextView)a.findViewById(0x7f0c057e);
        g = (TextView)a.findViewById(0x7f0c0589);
        h = (TextView)a.findViewById(0x7f0c0588);
        c.setOnClickListener(u);
        d.setOnClickListener(v);
        i = a.findViewById(0x7f0c0586);
        if (i != null)
        {
            k = i.findViewById(0x7f0c01b2);
            j = i.findViewById(0x7f0c01b1);
            k.setOnClickListener(s);
            j.setOnClickListener(t);
        }
        r = new x(this);
        q = a.findViewById(0x7f0c058b);
        q.setOnTouchListener(new android.view.View.OnTouchListener() {

            final v a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
                {
                    float f1 = motionevent.getRawX();
                    float f2 = motionevent.getRawY();
                    if (!v.a(a, Math.round(f1), Math.round(f2)))
                    {
                        v.e(a).setVisibility(4);
                    }
                }
                if (motionevent.getAction() == 2 || motionevent.getAction() == 8)
                {
                    v.e(a).setVisibility(4);
                }
                v.h(a).dispatchTouchEvent(motionevent);
                return true;
            }

            
            {
                a = v.this;
                super();
            }
        });
    }

    private void a(DownloadGridItem.DownloadState downloadstate)
    {
        class _cls6
        {

            static final int a[];

            static 
            {
                a = new int[DownloadGridItem.DownloadState.values().length];
                try
                {
                    a[DownloadGridItem.DownloadState.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[DownloadGridItem.DownloadState.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[DownloadGridItem.DownloadState.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[DownloadGridItem.DownloadState.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[DownloadGridItem.DownloadState.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls6.a[downloadstate.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            c.setEnabled(false);
            c.setText(0x7f070522);
            return;

        case 2: // '\002'
            c.setEnabled(true);
            c.setText(0x7f07051a);
            return;

        case 3: // '\003'
            c.setEnabled(true);
            c.setText(0x7f0703aa);
            return;

        case 4: // '\004'
            c.setEnabled(true);
            c.setText(0x7f0703c6);
            return;

        case 5: // '\005'
            c.setEnabled(true);
            break;
        }
        c.setText(0x7f070529);
    }

    static void a(v v1, DownloadGridItem.DownloadState downloadstate)
    {
        v1.a(downloadstate);
    }

    private boolean a(int i1, int j1)
    {
        Rect rect;
        rect = new Rect();
        d.getGlobalVisibleRect(rect);
        if (!rect.contains(i1, j1)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        rect = new Rect();
        c.getGlobalVisibleRect(rect);
        if (rect.contains(i1, j1)) goto _L1; else goto _L3
_L3:
        if (k == null || k.getVisibility() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        rect = new Rect();
        k.getGlobalVisibleRect(rect);
        if (rect.contains(i1, j1)) goto _L1; else goto _L4
_L4:
        if (j == null || j.getVisibility() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        rect = new Rect();
        j.getGlobalVisibleRect(rect);
        if (rect.contains(i1, j1)) goto _L1; else goto _L5
_L5:
        return false;
    }

    static boolean a(v v1, int i1, int j1)
    {
        return v1.a(i1, j1);
    }

    private void b()
    {
        if (h != null && m != null)
        {
            if (m.w() && m.x())
            {
                h.setText(0x7f07044f);
                return;
            }
            if (m.w())
            {
                h.setText(0x7f07044e);
                return;
            }
            if (m.x())
            {
                h.setText(0x7f07044d);
                return;
            }
        }
    }

    static void b(v v1)
    {
        v1.c();
    }

    static MakeupItemMetadata c(v v1)
    {
        return v1.m;
    }

    private void c()
    {
        if (l != null)
        {
            l.a();
        }
        NetworkManager networkmanager = Globals.d().w();
        networkmanager.b(r);
        networkmanager.b(r);
        networkmanager.b(r);
        networkmanager.b(r);
        b.setImageBitmap(null);
        b.destroyDrawingCache();
        i.setVisibility(4);
        a.setVisibility(4);
    }

    static com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType d(v v1)
    {
        return v1.o;
    }

    static View e(v v1)
    {
        return v1.i;
    }

    static w f(v v1)
    {
        return v1.l;
    }

    static View g(v v1)
    {
        return v1.a;
    }

    static View h(v v1)
    {
        return v1.p;
    }

    public void a()
    {
        c();
    }

    public void a(MakeupItemMetadata makeupitemmetadata, DownloadGridItem downloadgriditem, ag ag, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        m = makeupitemmetadata;
        n = downloadgriditem;
        o = displaymakeuptype;
        downloadgriditem = (p)n.getTag();
        c.setTag(n);
        a(downloadgriditem.c());
        if (m != null)
        {
            b.setImageBitmap(null);
            b.setTag(Long.valueOf(m.a()));
            bn.a(ag, m, b, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.b);
            f.setText(m.c());
            g.setText(m.e());
            b();
            if (makeupitemmetadata.k())
            {
                e.setVisibility(0);
            } else
            {
                e.setVisibility(4);
            }
        }
        a.setVisibility(0);
        makeupitemmetadata = Globals.d().w();
        makeupitemmetadata.a(r);
        makeupitemmetadata.a(r);
        makeupitemmetadata.a(r);
        makeupitemmetadata.a(r);
    }

    public void a(w w1)
    {
        l = w1;
    }
}
