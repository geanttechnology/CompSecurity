// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent;
import com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.f;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.bd;
import com.cyberlink.youcammakeup.utility.d;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            a, b, i, j

public class h extends a
{

    private TextView a;
    private Map b;
    private List c;
    private Map d;
    private j e;

    public h(Activity activity, View view, TextView textview)
    {
        super(activity, view);
        a = textview;
    }

    static j a(h h1)
    {
        return h1.e;
    }

    static List a(h h1, List list)
    {
        h1.c = list;
        return list;
    }

    static void b(h h1)
    {
        h1.com.cyberlink.youcammakeup.b.a.m();
    }

    private void u()
    {
        Handler handler = new Handler();
        (new e()).a(new f(handler) {

            final Handler a;
            final h b;

            private void b(List list)
            {
                a.post(new Runnable(this, list) {

                    final List a;
                    final _cls1 b;

                    public void run()
                    {
                        h.a(b.b, a);
                        com.cyberlink.youcammakeup.b.h.b(b.b);
                    }

            
            {
                b = _pcls1;
                a = list;
                super();
            }
                });
            }

            public void a(List list)
            {
                if (al.a("com.cyberlink.U") || !Globals.d().c().b())
                {
                    if (list.size() > 0)
                    {
                        a.post(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                if (h.a(a.b) != null)
                                {
                                    h.a(a.b).a();
                                }
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        b(list);
                    }
                    return;
                } else
                {
                    b(list);
                    return;
                }
            }

            
            {
                b = h.this;
                a = handler;
                super();
            }
        });
    }

    protected Animation a(boolean flag)
    {
        AnimationSet animationset = new AnimationSet(true);
        ScaleAnimation scaleanimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.13315F, 1, 0.5F);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        animationset.setDuration(e());
        animationset.setStartOffset(e());
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.addAnimation(scaleanimation);
        animationset.addAnimation(alphaanimation);
        return animationset;
    }

    public void a()
    {
        super.a();
        u();
    }

    protected void a(Activity activity, LayoutInflater layoutinflater, List list)
    {
        if (b != null)
        {
            b.clear();
            b = null;
        }
        b = new HashMap();
        if (c == null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.cyberlink.youcammakeup.b.b b1 = (com.cyberlink.youcammakeup.b.b)list.next();
                Object obj = b1.a;
                if (al.a(activity.getPackageManager(), ((String) (obj)), "android.intent.action.MAIN", "android.intent.category.LAUNCHER", null) == null)
                {
                    obj = a(layoutinflater, b1.b, b1.c, new Runnable(activity, ((String) (obj))) {

                        final Activity a;
                        final String b;
                        final h c;

                        public void run()
                        {
                            bd.a(a, b, "ymk", "bigbangsharedialog");
                        }

            
            {
                c = h.this;
                a = activity;
                b = s1;
                super();
            }
                    });
                    b.put(obj, b1);
                }
            } while (true);
        } else
        {
            if (d != null)
            {
                d.clear();
                d = null;
            }
            d = new HashMap();
            list = c.iterator();
            while (list.hasNext()) 
            {
                b b2 = (b)list.next();
                String s1 = b2.d;
                View view = a(layoutinflater, b2.a(), b2.c, new Runnable(s1, activity) {

                    final String a;
                    final Activity b;
                    final h c;

                    public void run()
                    {
                        if ("$LinkToUStore".equalsIgnoreCase(a))
                        {
                            bd.a(b, "com.cyberlink.U", "ymk", "bigbangsharedialog");
                            return;
                        } else
                        {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a));
                            b.startActivity(intent);
                            return;
                        }
                    }

            
            {
                c = h.this;
                a = s1;
                b = activity;
                super();
            }
                });
                TextView textview = (TextView)view.findViewById(0x7f0c08ea);
                if ("$LinkToUStore".equalsIgnoreCase(s1))
                {
                    textview.setText(0x7f0706dc);
                } else
                {
                    textview.setText(0x7f0706dd);
                }
                d.put(view, b2);
            }
        }
    }

    protected void a(View view)
    {
        if (d != null)
        {
            view = (b)d.get(view);
            if (view != null && "$LinkToUStore".equals(((b) (view)).d))
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.a));
                if (z.f().isEmpty())
                {
                    z.a(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS.a);
                    com.cyberlink.youcammakeup.clflurry.b.a(new UInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS.a));
                }
            }
        } else
        if (b != null)
        {
            view = (com.cyberlink.youcammakeup.b.b)b.get(view);
            if (view != null && ((com.cyberlink.youcammakeup.b.b) (view)).a.equalsIgnoreCase("com.cyberlink.U"))
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.a));
                return;
            }
        }
    }

    public void a(j j)
    {
        e = j;
    }

    protected Animation b(boolean flag)
    {
        AnimationSet animationset = new AnimationSet(true);
        ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.13315F, 1, 0.5F);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        animationset.setDuration(e());
        animationset.setInterpolator(new AccelerateInterpolator());
        animationset.addAnimation(scaleanimation);
        animationset.addAnimation(alphaanimation);
        return animationset;
    }

    protected void b(View view)
    {
        if (d != null)
        {
            view = (b)d.get(view);
            if (view != null && a != null)
            {
                a.setText(((b) (view)).b);
            }
        } else
        {
            view = (i)b.get(view);
            if (view != null && a != null)
            {
                a.setText(((i) (view)).e);
                return;
            }
        }
    }

    protected int d()
    {
        return 7000;
    }

    protected int f()
    {
        return 0x7f03020c;
    }

    protected int g()
    {
        return 0x7f0c08e8;
    }

    protected int h()
    {
        return 0x7f0c08e9;
    }

    public void n()
    {
        super.n();
        try
        {
            b.clear();
            b = null;
            if (d == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((b)iterator.next()).b()) { }
        }
        catch (Exception exception)
        {
            m.e("BigBangShareDialogUCtrl", com.cyberlink.youcammakeup.utility.d.a(exception));
            return;
        }
        d.clear();
        d = null;
        return;
    }

    protected List o()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new i[] {
            new i(this, "com.cyberlink.U", 0x7f02075c, 0x7f0706e0, 0x7f070687), new i(this, "com.cyberlink.U", 0x7f02075c, 0x7f0706da, 0x7f070687)
        }));
        return arraylist;
    }

    protected int p()
    {
        return 0x7f0c06ee;
    }

    protected boolean q()
    {
        return false;
    }

    protected boolean r()
    {
        return true;
    }

    protected boolean s()
    {
        return true;
    }
}
