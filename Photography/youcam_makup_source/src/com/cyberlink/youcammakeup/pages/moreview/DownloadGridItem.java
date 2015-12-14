// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.a;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            n, o, p

public class DownloadGridItem extends RelativeLayout
{

    private android.view.View.OnClickListener A;
    private View a;
    private View b;
    private Button c;
    private View d;
    private ProgressBar e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private n i;
    private o j;
    private android.view.View.OnClickListener k;
    private int l;
    private View m;
    private LayoutTypeInfo.LayoutType n;
    private View o;
    private View p;
    private DownloadState q;
    private View r;
    private boolean s;
    private boolean t;
    private TextView u;
    private View v;
    private View w;
    private View x;
    private DownloadItemUtility.UseTemplateTarget y;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType z;

    public DownloadGridItem(Context context, LayoutTypeInfo.LayoutType layouttype, a a1)
    {
        super(context);
        y = com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.UseTemplateTarget.a;
        z = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a;
        A = new android.view.View.OnClickListener() {

            final DownloadGridItem a;

            private boolean a()
            {
                return DownloadGridItem.d(a) && !DownloadGridItem.e(a);
            }

            private boolean b()
            {
                return !DownloadGridItem.d(a) && DownloadGridItem.e(a);
            }

            public void onClick(View view)
            {
                view = (p)a.getTag();
                class LayoutTypeInfo.LayoutType extends Enum
                {

                    public static final LayoutTypeInfo.LayoutType a;
                    public static final LayoutTypeInfo.LayoutType b;
                    public static final LayoutTypeInfo.LayoutType c;
                    public static final LayoutTypeInfo.LayoutType d;
                    public static final LayoutTypeInfo.LayoutType e;
                    public static final LayoutTypeInfo.LayoutType f;
                    public static final LayoutTypeInfo.LayoutType g;
                    public static final LayoutTypeInfo.LayoutType h;
                    public static final LayoutTypeInfo.LayoutType i;
                    private static final LayoutTypeInfo.LayoutType j[];

                    public static LayoutTypeInfo.LayoutType valueOf(String s1)
                    {
                        return (LayoutTypeInfo.LayoutType)Enum.valueOf(com/cyberlink/youcammakeup/pages/moreview/DownloadGridItem$LayoutTypeInfo$LayoutType, s1);
                    }

                    public static LayoutTypeInfo.LayoutType[] values()
                    {
                        return (LayoutTypeInfo.LayoutType[])j.clone();
                    }

                    static 
                    {
                        a = new LayoutTypeInfo.LayoutType("LOOK_TYPE", 0);
                        b = new LayoutTypeInfo.LayoutType("EYE_SHADOW_TYPE", 1);
                        c = new LayoutTypeInfo.LayoutType("EYE_LINE_TYPE", 2);
                        d = new LayoutTypeInfo.LayoutType("EYE_LASH_TYPE", 3);
                        e = new LayoutTypeInfo.LayoutType("CATEGOTY_LOOK_TYPE", 4);
                        f = new LayoutTypeInfo.LayoutType("PROMOTION_LOOK_TYPE", 5);
                        g = new LayoutTypeInfo.LayoutType("WIG_TYPE", 6);
                        h = new LayoutTypeInfo.LayoutType("CATEGORY_ACCESSORY_TYPE", 7);
                        i = new LayoutTypeInfo.LayoutType("ACCESSORY_TYPE", 8);
                        j = (new LayoutTypeInfo.LayoutType[] {
                            a, b, c, d, e, f, g, h, i
                        });
                    }

                        private LayoutTypeInfo.LayoutType(String s1, int i1)
                        {
                            super(s1, i1);
                        }
                }

                if (DownloadGridItem.f(a) != com.cyberlink.youcammakeup.pages.moreview.LayoutTypeInfo.LayoutType.a || DownloadGridItem.g(a) == null || view.c() != DownloadState.d) goto _L2; else goto _L1
_L1:
                if (DownloadGridItem.h(a) != com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c && !a()) goto _L4; else goto _L3
_L3:
                a.setUseTemplateTarget(DownloadItemUtility.UseTemplateTarget.c);
_L2:
                if (DownloadGridItem.f(a) == LayoutTypeInfo.LayoutType.e && view.c() == DownloadState.d && (DownloadGridItem.h(a) == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c || a()))
                {
                    a.setUseTemplateTarget(DownloadItemUtility.UseTemplateTarget.c);
                }
                if (DownloadGridItem.c(a) != null)
                {
                    DownloadGridItem.c(a).a(a);
                }
                return;
_L4:
                if (DownloadGridItem.h(a) != com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.b && !b())
                {
                    break; /* Loop/switch isn't completed */
                }
                a.setUseTemplateTarget(DownloadItemUtility.UseTemplateTarget.b);
                if (true) goto _L2; else goto _L5
_L5:
                int i1 = DownloadGridItem.g(a).getVisibility();
                view = a;
                if (i1 == 0)
                {
                    i1 = 4;
                } else
                {
                    i1 = 0;
                }
                view.setLookTemplateMenuVisibility(i1);
                return;
            }

            
            {
                a = DownloadGridItem.this;
                super();
            }

            private class DownloadState extends Enum
            {

                public static final DownloadState a;
                public static final DownloadState b;
                public static final DownloadState c;
                public static final DownloadState d;
                public static final DownloadState e;
                private static final DownloadState f[];

                public static DownloadState valueOf(String s1)
                {
                    return (DownloadState)Enum.valueOf(com/cyberlink/youcammakeup/pages/moreview/DownloadGridItem$DownloadState, s1);
                }

                public static DownloadState[] values()
                {
                    return (DownloadState[])f.clone();
                }

                static 
                {
                    a = new DownloadState("Init", 0);
                    b = new DownloadState("CanDownload", 1);
                    c = new DownloadState("Downloading", 2);
                    d = new DownloadState("Downloaded", 3);
                    e = new DownloadState("Error", 4);
                    f = (new DownloadState[] {
                        a, b, c, d, e
                    });
                }

                private DownloadState(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        };
        a(context, layouttype, a1);
    }

    private int a(a a1)
    {
        if (a1 != null)
        {
            if (a1.b() == CategoryType.e)
            {
                return 0x7f0208a2;
            }
            if (a1.b() == CategoryType.b)
            {
                return 0x7f0208ca;
            }
            if (a1.b() == CategoryType.c)
            {
                return 0x7f0208c9;
            }
        }
        return 0x7f0208a3;
    }

    private int a(LayoutTypeInfo.LayoutType layouttype)
    {
        if (layouttype == LayoutTypeInfo.LayoutType.g)
        {
            return 0x7f0301e7;
        }
        if (layouttype == LayoutTypeInfo.LayoutType.d || layouttype == LayoutTypeInfo.LayoutType.c)
        {
            return 0x7f0301df;
        }
        if (layouttype == LayoutTypeInfo.LayoutType.b)
        {
            return 0x7f0301e1;
        }
        if (layouttype == LayoutTypeInfo.LayoutType.e)
        {
            return 0x7f030115;
        }
        if (layouttype == LayoutTypeInfo.LayoutType.f)
        {
            return 0x7f0301d9;
        }
        if (layouttype == LayoutTypeInfo.LayoutType.h)
        {
            return 0x7f030114;
        }
        return layouttype != LayoutTypeInfo.LayoutType.i ? 0x7f0301e4 : 0x7f0301de;
    }

    static o a(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.j;
    }

    private void a(Context context, LayoutTypeInfo.LayoutType layouttype, a a1)
    {
        a = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(a(layouttype), this);
        b = a.findViewById(0x7f0c0579);
        c = (Button)a.findViewById(0x7f0c0578);
        d = a.findViewById(0x7f0c0523);
        e = (ProgressBar)a.findViewById(0x7f0c0524);
        f = (TextView)a.findViewById(0x7f0c057e);
        g = (TextView)a.findViewById(0x7f0c0589);
        h = (ImageView)a.findViewById(0x7f0c0576);
        l = a(a1);
        m = a.findViewById(0x7f0c0876);
        n = layouttype;
        o = a.findViewById(0x7f0c0871);
        p = a.findViewById(0x7f0c0872);
        r = a.findViewById(0x7f0c057c);
        u = (TextView)a.findViewById(0x7f0c0588);
        if (g != null)
        {
            g.setMovementMethod(new ScrollingMovementMethod());
        }
        h.setOnClickListener(A);
        c.setOnClickListener(A);
        if (m != null && (layouttype == com.cyberlink.youcammakeup.pages.moreview.LayoutTypeInfo.LayoutType.a || layouttype == LayoutTypeInfo.LayoutType.g))
        {
            m.setOnClickListener(new android.view.View.OnClickListener() {

                final DownloadGridItem a;

                public void onClick(View view)
                {
                    if (com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.a(a) != null)
                    {
                        com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.a(a).a(a);
                    }
                }

            
            {
                a = DownloadGridItem.this;
                super();
            }
            });
        }
        if (o != null)
        {
            o.setOnClickListener(new android.view.View.OnClickListener() {

                final DownloadGridItem a;

                public void onClick(View view)
                {
                    if (DownloadGridItem.b(a) != null)
                    {
                        DownloadGridItem.b(a).onClick(a);
                    }
                }

            
            {
                a = DownloadGridItem.this;
                super();
            }
            });
        }
        if (n == com.cyberlink.youcammakeup.pages.moreview.LayoutTypeInfo.LayoutType.a)
        {
            v = a.findViewById(0x7f0c0586);
            if (v != null)
            {
                x = v.findViewById(0x7f0c01b2);
                w = v.findViewById(0x7f0c01b1);
                x.setOnClickListener(new android.view.View.OnClickListener() {

                    final DownloadGridItem a;

                    public void onClick(View view)
                    {
                        a.setUseTemplateTarget(DownloadItemUtility.UseTemplateTarget.b);
                        if (DownloadGridItem.c(a) != null)
                        {
                            DownloadGridItem.c(a).a(a);
                        }
                        a.setLookTemplateMenuVisibility(4);
                    }

            
            {
                a = DownloadGridItem.this;
                super();
            }
                });
                w.setOnClickListener(new android.view.View.OnClickListener() {

                    final DownloadGridItem a;

                    public void onClick(View view)
                    {
                        a.setUseTemplateTarget(DownloadItemUtility.UseTemplateTarget.c);
                        if (DownloadGridItem.c(a) != null)
                        {
                            DownloadGridItem.c(a).a(a);
                        }
                        a.setLookTemplateMenuVisibility(4);
                    }

            
            {
                a = DownloadGridItem.this;
                super();
            }
                });
            }
        }
    }

    static android.view.View.OnClickListener b(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.k;
    }

    static n c(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.i;
    }

    static boolean d(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.t;
    }

    static boolean e(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.s;
    }

    static LayoutTypeInfo.LayoutType f(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.n;
    }

    static View g(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.v;
    }

    static com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType h(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.z;
    }

    static ImageView i(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.h;
    }

    static View j(DownloadGridItem downloadgriditem)
    {
        return downloadgriditem.m;
    }

    private void setDownloadBtnText(String s1)
    {
        if (n == LayoutTypeInfo.LayoutType.e || n == LayoutTypeInfo.LayoutType.h)
        {
            return;
        } else
        {
            c.setText(s1);
            return;
        }
    }

    public void a()
    {
        h.setImageResource(l);
    }

    public void a(DownloadItemUtility.UseTemplateTarget usetemplatetarget)
    {
        setUseTemplateTarget(usetemplatetarget);
        if (i != null)
        {
            i.a(this);
        }
    }

    public void a(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        b.setVisibility(i1);
    }

    public boolean a(float f1, float f2)
    {
        if (v != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        Rect rect;
        rect = new Rect();
        h.getGlobalVisibleRect(rect);
        if (rect.contains(Math.round(f1), Math.round(f2))) goto _L1; else goto _L3
_L3:
        rect = new Rect();
        c.getGlobalVisibleRect(rect);
        if (rect.contains(Math.round(f1), Math.round(f2))) goto _L1; else goto _L4
_L4:
        if (x == null || x.getVisibility() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        rect = new Rect();
        x.getGlobalVisibleRect(rect);
        if (rect.contains(Math.round(f1), Math.round(f2))) goto _L1; else goto _L5
_L5:
        if (w == null || w.getVisibility() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        rect = new Rect();
        w.getGlobalVisibleRect(rect);
        if (rect.contains(Math.round(f1), Math.round(f2))) goto _L1; else goto _L6
_L6:
        return false;
    }

    public void b()
    {
        c.performClick();
    }

    public void b(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        d.setVisibility(i1);
    }

    public void c()
    {
        if (m != null)
        {
            View view = m;
            int i1;
            if (n == com.cyberlink.youcammakeup.pages.moreview.LayoutTypeInfo.LayoutType.a || n == LayoutTypeInfo.LayoutType.g)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            view.setVisibility(i1);
        }
    }

    public void c(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (r != null)
        {
            r.setVisibility(i1);
        }
    }

    public void d()
    {
        if (u != null)
        {
            if (s && t)
            {
                u.setText(0x7f07044f);
                return;
            }
            if (s)
            {
                u.setText(0x7f07044e);
                return;
            }
            if (t)
            {
                u.setText(0x7f07044d);
                return;
            }
        }
    }

    public void d(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (c != null)
        {
            c.setVisibility(i1);
        }
    }

    public void e(boolean flag)
    {
        if (p == null)
        {
            return;
        }
        if (flag)
        {
            p.setBackgroundResource(0x7f0206ee);
            return;
        } else
        {
            p.setBackgroundResource(0x7f0206eb);
            return;
        }
    }

    public com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType getDisplayMakeupType()
    {
        return z;
    }

    public DownloadState getDownloadState()
    {
        return q;
    }

    public LayoutTypeInfo.LayoutType getLayoutType()
    {
        return n;
    }

    public ImageView getThumbView()
    {
        return h;
    }

    public DownloadItemUtility.UseTemplateTarget getUseTemplateTarget()
    {
        return y;
    }

    public void setClickable(boolean flag)
    {
        super.setClickable(flag);
        h.setClickable(flag);
        c.setClickable(flag);
        if (m != null)
        {
            m.setClickable(flag);
        }
        if (o != null)
        {
            o.setClickable(flag);
        }
    }

    public void setDescription(CharSequence charsequence)
    {
        if (g != null)
        {
            g.setText(charsequence);
        }
    }

    public void setDisplayMakeupType(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        z = displaymakeuptype;
    }

    public void setDownloadBtnState(DownloadState downloadstate)
    {
        class _cls7
        {

            static final int a[];

            static 
            {
                a = new int[DownloadState.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.pages.moreview.DownloadState.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[DownloadState.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[DownloadState.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[DownloadState.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[DownloadState.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.cyberlink.youcammakeup.pages.moreview._cls7.a[downloadstate.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 50
    //                   2 144
    //                   3 237
    //                   4 264
    //                   5 329;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        q = downloadstate;
        return;
_L2:
        c.setEnabled(false);
        if (n == LayoutTypeInfo.LayoutType.f)
        {
            setDownloadBtnText(Globals.d().getApplicationContext().getString(0x7f0703c7));
        } else
        {
            setDownloadBtnText(Globals.d().getApplicationContext().getString(0x7f070522));
        }
        d.setVisibility(8);
        if (n == LayoutTypeInfo.LayoutType.e || n == LayoutTypeInfo.LayoutType.h)
        {
            c.setVisibility(8);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        c.setEnabled(true);
        if (n == LayoutTypeInfo.LayoutType.f)
        {
            setDownloadBtnText(Globals.d().getApplicationContext().getString(0x7f0703c7));
        } else
        {
            setDownloadBtnText(Globals.d().getApplicationContext().getString(0x7f07051a));
        }
        d.setVisibility(8);
        if (n == LayoutTypeInfo.LayoutType.e || n == LayoutTypeInfo.LayoutType.h)
        {
            c.setVisibility(0);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        c.setEnabled(true);
        setDownloadBtnText(Globals.d().getApplicationContext().getString(0x7f0703aa));
        continue; /* Loop/switch isn't completed */
_L5:
        c.setEnabled(true);
        setDownloadBtnText(Globals.d().getApplicationContext().getString(0x7f0703c7));
        d.setVisibility(8);
        if (n == LayoutTypeInfo.LayoutType.e || n == LayoutTypeInfo.LayoutType.h)
        {
            c.setVisibility(8);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        c.setEnabled(true);
        setDownloadBtnText(Globals.d().getApplicationContext().getString(0x7f070529));
        d.setVisibility(8);
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void setEditMode(boolean flag)
    {
        s = flag;
    }

    public void setLiveMode(boolean flag)
    {
        t = flag;
    }

    public void setLookTemplateMenuVisibility(int i1)
    {
        if (v != null)
        {
            v.setVisibility(i1);
        }
    }

    public void setOnDownloadClickListener(n n1)
    {
        i = n1;
    }

    public void setOnEnlargeClickListener(o o1)
    {
        j = o1;
    }

    public void setOnGroupClickListener(android.view.View.OnClickListener onclicklistener)
    {
        k = onclicklistener;
    }

    public void setProgress(int i1)
    {
        if (i1 < 0 || i1 > 100)
        {
            return;
        }
        if (d.getVisibility() != 0)
        {
            d.setVisibility(0);
        }
        e.setProgress(i1);
    }

    public void setTitle(CharSequence charsequence)
    {
        if (f != null)
        {
            f.setText(charsequence);
        }
    }

    public void setTumbnail(String s1)
    {
        if (s1 == null)
        {
            return;
        } else
        {
            (new AsyncTask(s1) {

                final String a;
                final DownloadGridItem b;

                protected transient Bitmap a(Void avoid[])
                {
                    return BitmapFactory.decodeFile(a);
                }

                protected void a(Bitmap bitmap)
                {
                    if (bitmap != null)
                    {
                        DownloadGridItem.i(b).setImageBitmap(bitmap);
                        if (DownloadGridItem.j(b) != null)
                        {
                            bitmap = DownloadGridItem.j(b);
                            int i1;
                            if (DownloadGridItem.f(b) == com.cyberlink.youcammakeup.pages.moreview.LayoutTypeInfo.LayoutType.a || DownloadGridItem.f(b) == LayoutTypeInfo.LayoutType.g)
                            {
                                i1 = 0;
                            } else
                            {
                                i1 = 4;
                            }
                            bitmap.setVisibility(i1);
                        }
                    }
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Bitmap)obj);
                }

            
            {
                b = DownloadGridItem.this;
                a = s1;
                super();
            }
            }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            return;
        }
    }

    public void setUseTemplateTarget(DownloadItemUtility.UseTemplateTarget usetemplatetarget)
    {
        y = usetemplatetarget;
    }
}
