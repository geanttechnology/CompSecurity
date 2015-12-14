// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class d
{

    final EditViewActivity a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;

    public d(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
        b = editviewactivity.findViewById(0x7f0c00cc);
        b.setOnClickListener(new android.view.View.OnClickListener(editviewactivity) {

            final EditViewActivity a;
            final d b;

            public void onClick(View view)
            {
                if (!StatusManager.j().E().booleanValue())
                {
                    return;
                }
                if (YMKSavingPageEvent.e())
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.PageType.a));
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.g, false, false));
                StatusManager.j().a(Boolean.valueOf(false));
                EditViewActivity.f(b.a).d();
                StatusManager.j().a(Boolean.valueOf(true));
            }

            
            {
                b = d.this;
                a = editviewactivity;
                super();
            }
        });
        c = editviewactivity.findViewById(0x7f0c00ce);
        c.setOnClickListener(new android.view.View.OnClickListener(editviewactivity) {

            final EditViewActivity a;
            final d b;

            public void onClick(View view)
            {
                if (!StatusManager.j().E().booleanValue())
                {
                    return;
                }
                if (YMKSavingPageEvent.f())
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.PageType.b));
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.h, false, false));
                if (StatusManager.j().r() == MakeupMode.a)
                {
                    EditViewActivity.ae().a();
                    return;
                } else
                {
                    StatusManager.j().a(Boolean.valueOf(false));
                    EditViewActivity.ae().b();
                    StatusManager.j().a(Boolean.valueOf(true));
                    return;
                }
            }

            
            {
                b = d.this;
                a = editviewactivity;
                super();
            }
        });
        d = editviewactivity.findViewById(0x7f0c00cd);
        e = editviewactivity.findViewById(0x7f0c00cf);
        f = editviewactivity.findViewById(0x7f0c00d0);
    }

    static void a(d d1, boolean flag)
    {
        d1.b(flag);
    }

    private void b(boolean flag)
    {
        if (f == null || d == null || e == null)
        {
            return;
        }
        int k = f.getWidth();
        int i = d.getWidth();
        if (i == 0)
        {
            d.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(flag) {

                final boolean a;
                final d b;

                public void onLayoutChange(View view1, int l, int i1, int j1, int k1, int l1, int i2, 
                        int j2, int k2)
                {
                    view1.removeOnLayoutChangeListener(this);
                    d.a(b, a);
                }

            
            {
                b = d.this;
                a = flag;
                super();
            }
            });
            return;
        }
        int j = e.getWidth();
        if (j == 0)
        {
            e.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(flag) {

                final boolean a;
                final d b;

                public void onLayoutChange(View view1, int l, int i1, int j1, int k1, int l1, int i2, 
                        int j2, int k2)
                {
                    view1.removeOnLayoutChangeListener(this);
                    d.a(b, a);
                }

            
            {
                b = d.this;
                a = flag;
                super();
            }
            });
            return;
        }
        if (k == 0)
        {
            f.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(flag) {

                final boolean a;
                final d b;

                public void onLayoutChange(View view1, int l, int i1, int j1, int k1, int l1, int i2, 
                        int j2, int k2)
                {
                    view1.removeOnLayoutChangeListener(this);
                    d.a(b, a);
                }

            
            {
                b = d.this;
                a = flag;
                super();
            }
            });
            return;
        }
        float f1;
        float f2;
        View view;
        if (!flag)
        {
            i = j;
        }
        i = (int)((double)i * 1.5D);
        if (flag)
        {
            view = d;
        } else
        {
            view = e;
        }
        view = (View)view.getParent();
        f1 = (float)i / (float)k;
        j = view.getLeft();
        f2 = (view.getWidth() / 2 + j) - i / 2;
        f.animate().cancel();
        f.setPivotX(0.0F);
        f.setScaleX(f1);
        if (f.getVisibility() == 0)
        {
            f.animate().translationX(f2).setDuration(200L).start();
            return;
        } else
        {
            f.setScaleX(f1);
            f.setTranslationX(f2);
            f.setVisibility(0);
            return;
        }
    }

    public void a(boolean flag)
    {
        b(flag);
        View view = b;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        view.setEnabled(flag1);
        c.setEnabled(flag);
    }
}
