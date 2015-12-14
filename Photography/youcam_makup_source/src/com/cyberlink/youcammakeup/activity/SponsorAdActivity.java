// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent;
import com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent;
import com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent;
import com.cyberlink.youcammakeup.clflurry.YMKPageViewADFromLauncherBannerEvent;
import com.cyberlink.youcammakeup.clflurry.c;
import com.cyberlink.youcammakeup.clflurry.d;
import com.cyberlink.youcammakeup.clflurry.f;
import com.cyberlink.youcammakeup.clflurry.g;
import com.cyberlink.youcammakeup.clflurry.k;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.kernelctrl.Camera;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ai;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aj;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ak;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.a;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.av;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;
import com.cyberlink.youcammakeup.widgetpool.common.MultiLangTextView;
import com.cyberlink.youcammakeup.widgetpool.dialogs.i;
import com.pf.common.utility.m;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            u, LauncherActivity, EditViewActivity, WebViewerExActivity, 
//            LibraryPickerActivity

public class SponsorAdActivity extends BaseActivity
{

    public static final UUID a = UUID.randomUUID();
    public static String b = "BannerID";
    private View c;
    private ImageView d;
    private ImageView e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl o;
    private Uri p;
    private com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName q;
    private boolean r;
    private u s;
    private android.view.View.OnClickListener t;

    public SponsorAdActivity()
    {
        q = null;
        r = false;
        s = new u(this);
        t = new android.view.View.OnClickListener() {

            final SponsorAdActivity a;
            private Toast b;

            static void a(_cls9 _pcls9, com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
            {
                _pcls9.a(cannotcreatefolderexception);
            }

            private void a(com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
            {
                com.pf.common.utility.m.e("SponsorAdActivity", cannotcreatefolderexception.toString());
                if (b != null)
                {
                    b.cancel();
                    b = null;
                }
                b = Toast.makeText(a.getApplicationContext(), 0x7f0704ea, 0);
                b.show();
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a, true);
            }

            public void onClick(View view)
            {
                boolean flag = false;
                if (!view.isClickable() || !view.isEnabled() || com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).getVisibility() != 0)
                {
                    return;
                }
                if (com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a) != null)
                {
                    view = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).type;
                    String s1 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).skuGuid;
                    String s2 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new f(view, s1, s2));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksADFromLauncherBannerEvent(s1, s2, com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.e));
                }
                com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.a));
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a, false);
                Globals.d().a(false);
                if (!al.a(a.getPackageManager()))
                {
                    int i1 = z.b();
                    if (i1 % 3 == 0)
                    {
                        if (z.g().isEmpty())
                        {
                            z.a(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a);
                            com.cyberlink.youcammakeup.clflurry.b.a(new YCPInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a));
                        }
                        view = new com.cyberlink.youcammakeup.widgetpool.dialogs.h();
                        view.a(new i(this) {

                            final _cls9 a;

                            public void a(boolean flag)
                            {
                                if (!flag)
                                {
                                    try
                                    {
                                        Camera.a().a(a.a);
                                    }
                                    catch (com.cyberlink.youcammakeup.kernelctrl.Camera.CannotCreateFolderException cannotcreatefolderexception)
                                    {
                                        com.cyberlink.youcammakeup.activity._cls9.a(a, cannotcreatefolderexception);
                                    }
                                }
                                com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a.a, true);
                            }

            
            {
                a = _pcls9;
                super();
            }
                        });
                        com.cyberlink.youcammakeup.utility.o.a(a, view, "DownloadYouPerfectDialog");
                        i1 = ((flag) ? 1 : 0);
                    } else
                    {
                        try
                        {
                            Camera.a().a(a);
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            a(view);
                        }
                    }
                    z.a(i1 + 1);
                    return;
                }
                try
                {
                    Camera.a().a(a);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    a(view);
                }
            }

            
            {
                a = SponsorAdActivity.this;
                super();
            }
        };
    }

    static com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl a(SponsorAdActivity sponsoradactivity)
    {
        return sponsoradactivity.o;
    }

    static void a(SponsorAdActivity sponsoradactivity, boolean flag)
    {
        sponsoradactivity.b(flag);
    }

    private void a(String s1)
    {
        ArrayList arraylist;
        HashMap hashmap;
        boolean flag;
        if (!z.b(Globals.d(), "").equals(com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        arraylist = new ArrayList();
        arraylist.add(s1);
        s1 = Globals.d().w();
        hashmap = new HashMap();
        hashmap.put(o.type, arraylist);
        s1.a(new ai(s1, hashmap, flag, new aj() {

            final SponsorAdActivity a;

            public void a(ak ak1)
            {
                Object obj;
                com.pf.common.utility.m.b("SponsorAdActivity", "getSkuByGuid complete");
                obj = ak1.a();
                if (obj == null || ((Collection) (obj)).size() == 0)
                {
                    com.cyberlink.youcammakeup.activity.SponsorAdActivity.c(a);
                    return;
                }
                obj = ((Collection) (obj)).iterator();
_L4:
                if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
                com.cyberlink.youcammakeup.database.more.i.d d1 = (com.cyberlink.youcammakeup.database.more.i.d)((Iterator) (obj)).next();
                if (d1 == null) goto _L4; else goto _L3
_L3:
                long l1;
                long l2;
                long l3;
                l1 = System.currentTimeMillis();
                l2 = d1.f();
                l3 = d1.g();
                if (l2 <= l1 && l3 >= l1) goto _L4; else goto _L5
_L5:
                boolean flag1 = true;
_L7:
                if (flag1)
                {
                    com.cyberlink.youcammakeup.activity.SponsorAdActivity.c(a);
                    return;
                } else
                {
                    ArrayList arraylist1 = new ArrayList();
                    arraylist1.add(com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).type);
                    com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(com.cyberlink.youcammakeup.activity.SponsorAdActivity.k(a));
                    com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(arraylist1, ak1);
                    return;
                }
_L2:
                flag1 = false;
                if (true) goto _L7; else goto _L6
_L6:
            }

            public void a(bn bn1)
            {
                com.pf.common.utility.m.e("SponsorAdActivity", (new StringBuilder()).append("getSkuByGuid error = ").append(bn1.toString()).toString());
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.c(a);
            }

            public volatile void a(Object obj)
            {
                a((ak)obj);
            }

            public void a(Void void1)
            {
                com.pf.common.utility.m.b("SponsorAdActivity", "getSkuByGuid cancel");
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.c(a);
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = SponsorAdActivity.this;
                super();
            }
        }));
    }

    static void b(SponsorAdActivity sponsoradactivity)
    {
        sponsoradactivity.n();
    }

    private void b(boolean flag)
    {
        h.setClickable(flag);
        m.setClickable(flag);
    }

    static void c(SponsorAdActivity sponsoradactivity)
    {
        sponsoradactivity.q();
    }

    static void d(SponsorAdActivity sponsoradactivity)
    {
        sponsoradactivity.o();
    }

    static View e(SponsorAdActivity sponsoradactivity)
    {
        return sponsoradactivity.n;
    }

    static boolean f(SponsorAdActivity sponsoradactivity)
    {
        return sponsoradactivity.r;
    }

    static View g(SponsorAdActivity sponsoradactivity)
    {
        return sponsoradactivity.j;
    }

    static View h(SponsorAdActivity sponsoradactivity)
    {
        return sponsoradactivity.k;
    }

    static Uri i(SponsorAdActivity sponsoradactivity)
    {
        return sponsoradactivity.p;
    }

    static com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName j(SponsorAdActivity sponsoradactivity)
    {
        return sponsoradactivity.q;
    }

    private boolean j()
    {
        Uri uri = getIntent().getData();
        if (uri != null) goto _L2; else goto _L1
_L1:
        List list;
        return false;
_L2:
        if ((list = uri.getPathSegments()) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!com.cyberlink.youcammakeup.utility.a.c(uri.toString()))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (list.size() != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        o = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl((String)list.get(0), (String)list.get(1), (String)list.get(2), null);
_L4:
        return true;
        if (list.size() != 2) goto _L1; else goto _L3
_L3:
        o = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(uri.getHost(), (String)list.get(0), (String)list.get(1), null);
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    static u k(SponsorAdActivity sponsoradactivity)
    {
        return sponsoradactivity.s;
    }

    private void k()
    {
        StatusManager.j().a("sponsorAdActivity");
        c = findViewById(0x7f0c01a7);
        d = (ImageView)findViewById(0x7f0c01a8);
        e = (ImageView)findViewById(0x7f0c01ae);
        f = findViewById(0x7f0c01aa);
        h = findViewById(0x7f0c01ab);
        i = findViewById(0x7f0c01ad);
        g = findViewById(0x7f0c01ac);
        j = findViewById(0x7f0c01af);
        k = findViewById(0x7f0c01b0);
        l = findViewById(0x7f0c01b1);
        m = findViewById(0x7f0c01b2);
        n = findViewById(0x7f0c01b3);
    }

    private void l()
    {
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorAdActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a, false);
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.d(a);
            }

            
            {
                a = SponsorAdActivity.this;
                super();
            }
        });
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorAdActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.SponsorAdActivity.e(a).getVisibility() != 8 || com.cyberlink.youcammakeup.activity.SponsorAdActivity.f(a))
                {
                    return;
                }
                if (com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a) != null)
                {
                    view = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).type;
                    String s1 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).skuGuid;
                    String s2 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new k(view, s1, s2));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksADFromLauncherBannerEvent(s1, s2, com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.c));
                }
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.g(a).setClickable(true);
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).setVisibility(0);
                view = new AnimationSet(true);
                view.setInterpolator(new DecelerateInterpolator());
                view.setDuration(100L);
                view.addAnimation(new AlphaAnimation(0.0F, 1.0F));
                view.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.2F, 1, 0.0F));
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).clearAnimation();
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).startAnimation(view);
            }

            
            {
                a = SponsorAdActivity.this;
                super();
            }
        });
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorAdActivity a;

            public void onClick(View view)
            {
                while (com.cyberlink.youcammakeup.activity.SponsorAdActivity.e(a).getVisibility() != 8 || com.cyberlink.youcammakeup.activity.SponsorAdActivity.f(a) || !view.isClickable() || !view.isEnabled() || com.cyberlink.youcammakeup.activity.SponsorAdActivity.i(a) == null) 
                {
                    return;
                }
                if (com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a) != null)
                {
                    view = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).type;
                    String s1 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).skuGuid;
                    String s2 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new g(view, s1, s2));
                    if (SponsorAdActivity.j(a) != null)
                    {
                        com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksADFromLauncherBannerEvent(s1, s2, SponsorAdActivity.j(a)));
                    }
                }
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a, false);
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                view.putExtra("RedirectUrl", com.cyberlink.youcammakeup.activity.SponsorAdActivity.i(a).toString());
                a.startActivity(view);
            }

            
            {
                a = SponsorAdActivity.this;
                super();
            }
        });
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorAdActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.SponsorAdActivity.e(a).getVisibility() != 8 || com.cyberlink.youcammakeup.activity.SponsorAdActivity.f(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.activity.SponsorAdActivity.g(a).setClickable(false);
                    com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).setVisibility(8);
                    view = new AnimationSet(true);
                    view.setInterpolator(new LinearInterpolator());
                    view.setDuration(100L);
                    view.addAnimation(new AlphaAnimation(1.0F, 0.0F));
                    view.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 0.2F));
                    com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).clearAnimation();
                    com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).startAnimation(view);
                    return;
                }
            }

            
            {
                a = SponsorAdActivity.this;
                super();
            }
        });
        j.setClickable(false);
        k.setVisibility(4);
        l.setOnClickListener(t);
        m.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorAdActivity a;

            public void onClick(View view)
            {
                while (com.cyberlink.youcammakeup.activity.SponsorAdActivity.e(a).getVisibility() != 8 || com.cyberlink.youcammakeup.activity.SponsorAdActivity.f(a) || !view.isClickable() || !view.isEnabled() || com.cyberlink.youcammakeup.activity.SponsorAdActivity.h(a).getVisibility() != 0) 
                {
                    return;
                }
                if (com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a) != null)
                {
                    view = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).type;
                    String s1 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).skuGuid;
                    String s2 = com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a).itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new c(view, s1, s2));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksADFromLauncherBannerEvent(s1, s2, com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.f));
                }
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a, false);
                StatusManager.j().b(-1L);
                StatusManager.j().a(null, com.cyberlink.youcammakeup.activity.SponsorAdActivity.a);
                Globals.d().a(false);
                view = new LibraryPickerActivity.State("editView");
                Intent intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
                intent.putExtra("LibraryPickerActivity_STATE", view);
                intent.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", com.cyberlink.youcammakeup.activity.SponsorAdActivity.a(a));
                a.startActivity(intent);
            }

            
            {
                a = SponsorAdActivity.this;
                super();
            }
        });
    }

    static void l(SponsorAdActivity sponsoradactivity)
    {
        sponsoradactivity.r();
    }

    private void m()
    {
        if (o == null && !j())
        {
            return;
        }
        p();
        h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
        if (h1.f().size() == 0)
        {
            a(o.skuGuid);
            return;
        }
        if (h1.b(o.type, o.skuGuid) == null)
        {
            a(o.skuGuid);
            return;
        }
        if (!h1.a(o.type, o.skuGuid))
        {
            h1.b(o.type, o.skuGuid, s);
            return;
        } else
        {
            n();
            return;
        }
    }

    private void n()
    {
        Object obj;
        Object obj1;
        n.setVisibility(8);
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().d(o.type, o.skuGuid);
        if (obj == null)
        {
            d.setImageResource(0x7f020872);
        } else
        {
            obj = BitmapFactory.decodeFile(((String) (obj)));
            d.setImageBitmap(((android.graphics.Bitmap) (obj)));
        }
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().c(o.type, o.skuGuid);
        if (obj == null)
        {
            e.setImageResource(0x7f02001b);
        } else
        {
            obj = BitmapFactory.decodeFile(((String) (obj)));
            e.setImageBitmap(((android.graphics.Bitmap) (obj)));
        }
        obj = o;
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj)).type, ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj)).skuGuid, ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj)).itemGuid);
        if (obj == null)
        {
            h.setVisibility(4);
            i.setVisibility(4);
            return;
        }
        try
        {
            obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().g(o.type, o.skuGuid);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            h.setVisibility(4);
            i.setVisibility(4);
            return;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        if (((String) (obj1)).equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.d.a()))
        {
            f.setVisibility(4);
            g.setVisibility(4);
        }
        obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().e(o.type, o.skuGuid);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        if (!((String) (obj1)).equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.c.a()) || ((e) (obj)).b().toString().isEmpty())
        {
            break MISSING_BLOCK_LABEL_378;
        }
        ((MultiLangTextView)i).setText(0x7f0706ff);
        obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().f(o.type, o.skuGuid);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        obj1 = av.a(((av) (obj1)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        if (!((String) (obj1)).equals(""))
        {
            ((MultiLangTextView)i).setText(((CharSequence) (obj1)));
        }
        p = Uri.parse(((e) (obj)).b().toString());
        h.setBackgroundResource(0x7f020838);
        q = com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.b;
        return;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_507;
        }
        if (!((String) (obj1)).equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.a.a()) || ((e) (obj)).c().toString().isEmpty())
        {
            break MISSING_BLOCK_LABEL_507;
        }
        ((MultiLangTextView)i).setText(0x7f070506);
        obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().f(o.type, o.skuGuid);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        obj1 = av.a(((av) (obj1)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        if (!((String) (obj1)).equals(""))
        {
            ((MultiLangTextView)i).setText(((CharSequence) (obj1)));
        }
        p = Uri.parse(((e) (obj)).c().toString());
        h.setBackgroundResource(0x7f020775);
        q = com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.a;
        return;
        if (!((e) (obj)).b().toString().isEmpty())
        {
            p = Uri.parse(((e) (obj)).b().toString());
            ((MultiLangTextView)i).setText(0x7f0706ff);
            h.setBackgroundResource(0x7f020838);
            q = com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.b;
            return;
        }
        if (!((e) (obj)).c().toString().isEmpty())
        {
            p = Uri.parse(((e) (obj)).c().toString());
            ((MultiLangTextView)i).setText(0x7f070506);
            h.setBackgroundResource(0x7f020775);
            q = com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.a;
            return;
        }
        h.setVisibility(4);
        i.setVisibility(4);
        q = null;
        return;
    }

    private void o()
    {
        if (o != null)
        {
            String s1 = o.type;
            String s2 = o.skuGuid;
            String s3 = o.itemGuid;
            com.cyberlink.youcammakeup.clflurry.b.a(new d(s1, s2, s3));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksADFromLauncherBannerEvent(s2, s3, com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ButtonName.d));
        }
        if (isTaskRoot())
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        }
        finish();
    }

    private void p()
    {
        float f1 = bo.c();
        if (bo.b())
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, this);
            bo.e();
            bo.v();
            bo.b(new bu(f1) {

                final float a;
                final SponsorAdActivity b;

                public void a(List list)
                {
                    z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, b);
                }

            
            {
                b = SponsorAdActivity.this;
                a = f1;
                super();
            }
            });
        } else
        if (z.e("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", this) != f1 || bo.a())
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, this);
            bo.e();
            bo.v();
            bo.a(new bu(f1) {

                final float a;
                final SponsorAdActivity b;

                public void a(List list)
                {
                    bo.u();
                    if (bo.a())
                    {
                        bo.b(new bu(this) {

                            final _cls11 a;

                            public void a(List list)
                            {
                                z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a.a, a.b);
                            }

            
            {
                a = _pcls11;
                super();
            }
                        });
                        return;
                    } else
                    {
                        z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, b);
                        return;
                    }
                }

            
            {
                b = SponsorAdActivity.this;
                a = f1;
                super();
            }
            });
            return;
        }
    }

    private void q()
    {
        r = true;
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
            Globals.d(new Runnable() {

                final SponsorAdActivity a;

                public void run()
                {
                    SponsorAdActivity.l(a);
                }

            
            {
                a = SponsorAdActivity.this;
                super();
            }
            });
            return;
        } else
        {
            r();
            return;
        }
    }

    private void r()
    {
        o o1 = Globals.d().i();
        String s1 = getString(0x7f070533);
        n.setVisibility(8);
        o1.a(new r(o1) {

            final o a;
            final SponsorAdActivity b;

            public void a()
            {
                com.cyberlink.youcammakeup.activity.SponsorAdActivity.d(b);
                a.a(null);
            }

            
            {
                b = SponsorAdActivity.this;
                a = o1;
                super();
            }
        });
        o1.a(this, null, s1, false);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 100)
        {
            com.pf.common.utility.m.e("onActivityResult", (new StringBuilder()).append("resultCode = ").append(String.valueOf(j1)).toString());
            if (j1 == -1)
            {
                intent = Camera.a().b();
                if (intent == null)
                {
                    com.pf.common.utility.m.e("onActivityResult", "capturedPath is null");
                    return;
                } else
                {
                    Camera.a().a(null);
                    StatusManager.j().f(true);
                    StatusManager.j().a(-9L, a);
                    Intent intent1 = new Intent(this, com/cyberlink/youcammakeup/activity/EditViewActivity);
                    intent1.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(intent)));
                    intent1.setAction("android.intent.action.SEND");
                    intent1.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", o);
                    startActivity(intent1);
                    return;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001e);
        k();
        l();
        o = (com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl)getIntent().getSerializableExtra("URL_CONTENT");
        m();
        if (!com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b().equalsIgnoreCase(com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.b()) && com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.b() != "")
        {
            o();
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            if (k.getVisibility() == 0)
            {
                j.performClick();
            } else
            {
                o();
            }
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("sponsorAdActivity");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (o != null)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.a(o.type, o.skuGuid, o.itemGuid));
        }
        String s1 = getIntent().getStringExtra(b);
        if (s1 != null && !s1.isEmpty())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKPageViewADFromLauncherBannerEvent(com.cyberlink.youcammakeup.clflurry.YMKPageViewADFromLauncherBannerEvent.BannerType.a, s1));
        }
        YMKClicksLipsCartEvent.a(com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent.SourceName.a);
        b(true);
        Globals.d().c(null);
    }

}
