// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.Camera;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ai;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aj;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ak;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.al;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.librarypicker.PickedFragment;
import com.cyberlink.youcammakeup.pages.librarypicker.TopBarFragment;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import com.pf.common.utility.m;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            m, LauncherActivity, EditViewActivity, EditViewActivityForIntent

public class LibraryPickerActivity extends BaseActivity
    implements al
{

    public static final UUID a = UUID.randomUUID();
    protected boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl g;
    private Runnable h;
    private com.cyberlink.youcammakeup.activity.m i;
    private boolean j;
    private boolean k;
    private boolean l;
    private String m;
    private String n;
    private State o;
    private PickedFragment p;
    private Toast q;

    public LibraryPickerActivity()
    {
        b = false;
        c = 0;
        d = false;
        e = false;
        f = false;
        g = null;
        h = null;
        i = new com.cyberlink.youcammakeup.activity.m(this);
        j = false;
        k = false;
        l = false;
    }

    private static State a(Bundle bundle)
    {
        if (bundle == null)
        {
            bundle = null;
        } else
        {
            State state = (State)bundle.getSerializable("LibraryPickerActivity_STATE");
            bundle = state;
            if (state == null)
            {
                return null;
            }
        }
        return bundle;
    }

    static Class a(String s1)
    {
        return b(s1);
    }

    static String a(LibraryPickerActivity librarypickeractivity, String s1)
    {
        librarypickeractivity.m = s1;
        return s1;
    }

    private static void a(Activity activity, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s1, String s2, String s3)
    {
        o o1 = Globals.d().i();
        o1.c(activity);
        o1.a(new y(flag, flag1, flag2, flag3, s1, s2));
        o1.a(new w(o1, activity) {

            final o a;
            final Activity b;

            public void a(boolean flag4)
            {
                a.i(b);
                ((BaseActivity)b).f();
            }

            public void b(boolean flag4)
            {
            }

            
            {
                a = o1;
                b = activity;
                super();
            }
        });
        o1.b(null, s3);
    }

    static void a(LibraryPickerActivity librarypickeractivity, Runnable runnable)
    {
        librarypickeractivity.b(runnable);
    }

    static void a(LibraryPickerActivity librarypickeractivity, String s1, Intent intent)
    {
        librarypickeractivity.a(s1, intent);
    }

    static void a(LibraryPickerActivity librarypickeractivity, String s1, String s2)
    {
        librarypickeractivity.a(s1, s2);
    }

    private void a(String s1, Intent intent)
    {
        if (s1 == null)
        {
            setResult(-1, intent);
            Globals.d().H();
            finish();
        } else
        {
            a(intent);
            startActivity(intent);
            if (!s1.equals("editViewForIntent"))
            {
                Globals.d().H();
                finish();
                return;
            }
        }
    }

    private void a(String s1, String s2)
    {
        boolean flag = true;
        com.pf.common.utility.m.b("activity.LibraryPickerActivity", "getSkuByGuid() start");
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
        {
            e = true;
            com.pf.common.utility.m.b("activity.LibraryPickerActivity", "getSkuByGuid() Invalid input");
            return;
        }
        ArrayList arraylist;
        NetworkManager networkmanager;
        HashMap hashmap;
        if (z.b(Globals.d(), "").equals(com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()))
        {
            flag = false;
        }
        arraylist = new ArrayList();
        arraylist.add(s2);
        networkmanager = Globals.d().w();
        hashmap = new HashMap();
        hashmap.put(s1, arraylist);
        networkmanager.a(new ai(networkmanager, hashmap, flag, new aj(s1, s2) {

            final String a;
            final String b;
            final LibraryPickerActivity c;

            public void a(ak ak1)
            {
                Object obj;
                boolean flag2;
                com.pf.common.utility.m.b("activity.LibraryPickerActivity", "getSkuByGuid() complete!!");
                obj = ak1.a();
                if (obj == null || ((Collection) (obj)).size() == 0)
                {
                    com.pf.common.utility.m.b("activity.LibraryPickerActivity", "getSkuByGuid() no sku collection!!");
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(c, true);
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(c, LibraryPickerActivity.f(c));
                    return;
                }
                flag2 = com.cyberlink.youcammakeup.kernelctrl.sku.h.c();
                obj = ((Collection) (obj)).iterator();
_L4:
                if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
                com.cyberlink.youcammakeup.database.more.i.d d1 = (com.cyberlink.youcammakeup.database.more.i.d)((Iterator) (obj)).next();
                if (d1 == null || flag2) goto _L4; else goto _L3
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
                    com.pf.common.utility.m.b("activity.LibraryPickerActivity", "getSkuByGuid() Expired!!");
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(c, true);
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(c, LibraryPickerActivity.f(c));
                    return;
                } else
                {
                    com.pf.common.utility.m.b("activity.LibraryPickerActivity", "getSkuByGuid() wait sku ready!!");
                    ArrayList arraylist1 = new ArrayList();
                    arraylist1.add(a);
                    com.cyberlink.youcammakeup.kernelctrl.sku.h.b().b(a, b, LibraryPickerActivity.g(c));
                    com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(arraylist1, ak1);
                    return;
                }
_L2:
                flag1 = false;
                if (true) goto _L7; else goto _L6
_L6:
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                com.pf.common.utility.m.e("activity.LibraryPickerActivity", (new StringBuilder()).append("getSkuByGuid() error = ").append(bn1.toString()).toString());
                com.cyberlink.youcammakeup.activity.LibraryPickerActivity.h(c);
            }

            public volatile void a(Object obj)
            {
                a((ak)obj);
            }

            public void a(Void void1)
            {
                com.pf.common.utility.m.b("activity.LibraryPickerActivity", "getSkuByGuid() cancel");
                com.cyberlink.youcammakeup.activity.LibraryPickerActivity.h(c);
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                c = LibraryPickerActivity.this;
                a = s1;
                b = s2;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
        com.pf.common.utility.m.b("activity.LibraryPickerActivity", "getSkuByGuid() end");
    }

    static boolean a(LibraryPickerActivity librarypickeractivity)
    {
        return librarypickeractivity.d;
    }

    static boolean a(LibraryPickerActivity librarypickeractivity, boolean flag)
    {
        librarypickeractivity.e = flag;
        return flag;
    }

    static com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl b(LibraryPickerActivity librarypickeractivity)
    {
        return librarypickeractivity.g;
    }

    private static Class b(String s1)
    {
        if (s1 == null)
        {
            return com/cyberlink/youcammakeup/activity/LauncherActivity;
        }
        if (s1.equals("editView"))
        {
            return com/cyberlink/youcammakeup/activity/EditViewActivity;
        }
        if (s1.equals("editViewForIntent"))
        {
            return com/cyberlink/youcammakeup/activity/EditViewActivityForIntent;
        } else
        {
            return com/cyberlink/youcammakeup/activity/LauncherActivity;
        }
    }

    static String b(LibraryPickerActivity librarypickeractivity, String s1)
    {
        librarypickeractivity.n = s1;
        return s1;
    }

    private void b(Bundle bundle)
    {
        State state = o;
        o = c(getIntent());
        if (o != null)
        {
            bundle = String.format(getResources().getString(0x7f07058e), new Object[] {
                Integer.valueOf(o.a()), Integer.valueOf(o.b())
            });
            p.a(bundle);
        } else
        {
            o = a(bundle);
            if (o != null)
            {
                bundle = String.format(getResources().getString(0x7f07058e), new Object[] {
                    Integer.valueOf(o.a()), Integer.valueOf(o.b())
                });
                p.a(bundle);
                return;
            }
            if (state != null)
            {
                o = state;
                return;
            }
            o = k();
            if (com.cyberlink.youcammakeup.activity.State.a(o) == null)
            {
                s();
                return;
            }
        }
    }

    private void b(Runnable runnable)
    {
        if (runnable == null)
        {
            return;
        }
        if (!t())
        {
            Globals.d(runnable);
            return;
        }
        if (u())
        {
            com.cyberlink.youcammakeup.utility.o.a(this);
            x();
            return;
        }
        if (v())
        {
            com.cyberlink.youcammakeup.utility.o.a(this);
            Globals.d(runnable);
            return;
        } else
        {
            Globals.d().i().a(this, 0L);
            return;
        }
    }

    static boolean b(Intent intent)
    {
        return f(intent);
    }

    static boolean b(LibraryPickerActivity librarypickeractivity, String s1, String s2)
    {
        return librarypickeractivity.b(s1, s2);
    }

    static boolean b(LibraryPickerActivity librarypickeractivity, boolean flag)
    {
        librarypickeractivity.f = flag;
        return flag;
    }

    private boolean b(String s1, String s2)
    {
        if (s1.equalsIgnoreCase("Look"))
        {
            return bo.h(s2);
        } else
        {
            return false;
        }
    }

    private static State c(Intent intent)
    {
        if (intent == null)
        {
            intent = null;
        } else
        {
            intent = intent.getExtras();
            if (intent == null)
            {
                return null;
            }
            State state = (State)intent.getSerializable("LibraryPickerActivity_STATE");
            intent = state;
            if (state == null)
            {
                return null;
            }
        }
        return intent;
    }

    private void c(Bundle bundle)
    {
        b(bundle);
        if (p != null)
        {
            p.a();
        }
        if (!o.d())
        {
            bundle = (TopBarFragment)getFragmentManager().findFragmentById(0x7f0c0156);
            bundle.getView().findViewById(0x7f0c05c0).setVisibility(4);
            bundle.getView().findViewById(0x7f0c05c1).setVisibility(4);
        }
    }

    private void c(String s1, String s2)
    {
        Globals.d(new Runnable(s1, s2) {

            final String a;
            final String b;
            final LibraryPickerActivity c;

            public void run()
            {
                if (com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(c, a, b))
                {
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(c, a);
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(c, b);
                }
                LibraryPickerActivity.c(c, true);
                com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(c, LibraryPickerActivity.f(c));
            }

            
            {
                c = LibraryPickerActivity.this;
                a = s1;
                b = s2;
                super();
            }
        });
    }

    static boolean c(LibraryPickerActivity librarypickeractivity)
    {
        return librarypickeractivity.j;
    }

    static boolean c(LibraryPickerActivity librarypickeractivity, boolean flag)
    {
        librarypickeractivity.l = flag;
        return flag;
    }

    static String d(LibraryPickerActivity librarypickeractivity)
    {
        return librarypickeractivity.n;
    }

    private void d(Intent intent)
    {
        if (intent != null && intent.getExtras() != null)
        {
            Object obj = intent.getExtras();
            intent = ((Bundle) (obj)).getString("SkuType", "");
            String s1 = ((Bundle) (obj)).getString("SkuGuid", "");
            obj = ((Bundle) (obj)).getString("SkuItemGuid", "");
            boolean flag;
            if (!intent.isEmpty() && !s1.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d = flag;
            if (d)
            {
                g = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(intent, s1, ((String) (obj)), null);
                (new AsyncTask() {

                    final LibraryPickerActivity a;

                    protected transient Void a(Void avoid[])
                    {
                        com.pf.common.utility.m.b("activity.LibraryPickerActivity", "prepareSku() start");
                        if (com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a) == null)
                        {
                            com.pf.common.utility.m.b("activity.LibraryPickerActivity", "prepareSku() mSkuUrlContent is null");
                            com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(a, true);
                        } else
                        {
                            avoid = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
                            if (avoid.f().size() == 0 || avoid.b(com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).type, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).skuGuid) == null)
                            {
                                com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a, false);
                                com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(a, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).type, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).skuGuid);
                            } else
                            if (!avoid.a(com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).type, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).skuGuid))
                            {
                                com.pf.common.utility.m.b("activity.LibraryPickerActivity", "prepareSku() wait sku ready");
                                com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a, false);
                                avoid.b(com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).type, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).skuGuid, LibraryPickerActivity.g(a));
                            } else
                            {
                                com.pf.common.utility.m.b("activity.LibraryPickerActivity", "prepareSku() sku is ready");
                                com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a, true);
                            }
                        }
                        com.pf.common.utility.m.b("activity.LibraryPickerActivity", "prepareSku() end");
                        return null;
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

            
            {
                a = LibraryPickerActivity.this;
                super();
            }
                }).execute(new Void[0]);
                return;
            }
        }
    }

    static String e(LibraryPickerActivity librarypickeractivity)
    {
        return librarypickeractivity.m;
    }

    private void e(Intent intent)
    {
        if (intent != null && intent.getExtras() != null)
        {
            Object obj = intent.getExtras();
            String s1 = ((Bundle) (obj)).getString("Type", "");
            obj = ((Bundle) (obj)).getString("Guid", "");
            if (!s1.equals("") && !((String) (obj)).equals(""))
            {
                j = true;
                c(s1, ((String) (obj)));
            }
            Globals.d().b(f(intent));
            if (!((String) (obj)).equals("") && !bo.h(((String) (obj))))
            {
                if (!NetworkManager.L())
                {
                    a(this, true, false, true, false, getString(0x7f0703fd), null, getString(0x7f070533));
                    return;
                } else
                {
                    Globals.d().i().b(this);
                    intent = new LinkedList();
                    intent.add(obj);
                    bn.b(intent, new e(s1, ((String) (obj))) {

                        final String a;
                        final String b;
                        final LibraryPickerActivity c;

                        public volatile void a(Object obj1)
                        {
                            a((List)obj1);
                        }

                        public void a(List list)
                        {
                            if (list.size() != 1)
                            {
                                ((BaseActivity)c.getApplicationContext()).f();
                                return;
                            }
                            list = (MakeupItemMetadata)list.get(0);
                            NetworkManager networkmanager = Globals.d().w();
                            try
                            {
                                networkmanager.a(new d(networkmanager, 0x15ab1cL, list, new j(this) {

                                    final _cls3 a;

                                    public void a(a a1)
                                    {
                                    }

                                    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                                    {
                                    }

                                    public volatile void a(Object obj)
                                    {
                                        a((Void)obj);
                                    }

                                    public void a(Void void1)
                                    {
                                        com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(a.c, a.a);
                                        com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a.c, a.b);
                                        Globals.d().i().h(a.c);
                                    }

                                    public void b(Object obj)
                                    {
                                        a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
                                    }

                                    public void b(Void void1)
                                    {
                                    }

                                    public void c(Object obj)
                                    {
                                        b((Void)obj);
                                    }

                                    public void d(Object obj)
                                    {
                                        a((a)obj);
                                    }

            
            {
                a = _pcls3;
                super();
            }
                                }));
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (List list)
                            {
                                list.printStackTrace();
                            }
                        }

                        public void b(Object obj1)
                        {
                        }

                        public void c(Object obj1)
                        {
                        }

            
            {
                c = LibraryPickerActivity.this;
                a = s1;
                b = s2;
                super();
            }
                    });
                    return;
                }
            }
        }
    }

    static Runnable f(LibraryPickerActivity librarypickeractivity)
    {
        return librarypickeractivity.h;
    }

    private static boolean f(Intent intent)
    {
        return intent != null && intent.getExtras() != null && Boolean.valueOf(intent.getExtras().getString("FromBC", Boolean.FALSE.toString())).booleanValue();
    }

    static com.cyberlink.youcammakeup.activity.m g(LibraryPickerActivity librarypickeractivity)
    {
        return librarypickeractivity.i;
    }

    static void h(LibraryPickerActivity librarypickeractivity)
    {
        librarypickeractivity.w();
    }

    private void s()
    {
        if (isTaskRoot())
        {
            p();
            return;
        } else
        {
            finish();
            return;
        }
    }

    private boolean t()
    {
        return d || j;
    }

    private boolean u()
    {
        return e || k;
    }

    private boolean v()
    {
        return f || l;
    }

    private void w()
    {
        c = c + 1;
        com.pf.common.utility.m.b("activity.LibraryPickerActivity", (new StringBuilder()).append("Retry get sku metadata :").append(c).toString());
        if (c < 3 && g != null)
        {
            Globals.a(new Runnable() {

                final LibraryPickerActivity a;

                public void run()
                {
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(a, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).type, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(a).skuGuid);
                }

            
            {
                a = LibraryPickerActivity.this;
                super();
            }
            }, 3000L);
            return;
        } else
        {
            e = true;
            Globals.d(new Runnable() {

                final LibraryPickerActivity a;

                public void run()
                {
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(a, LibraryPickerActivity.f(a));
                }

            
            {
                a = LibraryPickerActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void x()
    {
        Globals.d(new Runnable() {

            final LibraryPickerActivity a;

            public void run()
            {
                o o1 = Globals.d().i();
                String s1 = a.getString(0x7f070533);
                o1.a(new r(this, o1) {

                    final o a;
                    final _cls2 b;

                    public void a()
                    {
                        a.a(null);
                    }

            
            {
                b = _pcls2;
                a = o1;
                super();
            }
                });
                o1.a(a, null, s1, false);
            }

            
            {
                a = LibraryPickerActivity.this;
                super();
            }
        });
    }

    public void P()
    {
        StatusManager.j().b(this);
        Globals.d().i().c(this);
        Globals.d().i().e(this);
        Globals.d().i().a(new w() {

            final LibraryPickerActivity a;

            public void a(boolean flag)
            {
                a.p();
            }

            public void b(boolean flag)
            {
            }

            
            {
                a = LibraryPickerActivity.this;
                super();
            }
        });
    }

    protected void a(Intent intent)
    {
    }

    public boolean a(int i1)
    {
        return p.b().length + i1 <= o.b();
    }

    public void b(long l1)
    {
        h = new Runnable(l1) {

            final long a;
            final LibraryPickerActivity b;

            public void run()
            {
                StatusManager.j().a(a, null);
                String s1 = b.j().c();
                Class class1 = com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(s1);
                Intent intent = new Intent(b, class1);
                intent.putExtras(b.getIntent());
                intent.putExtra("LibraryPickerActivity_ID", a);
                if (com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(b) && com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(b) != null)
                {
                    Globals.T();
                    StatusManager.j().a(MakeupMode.g, false);
                    StatusManager.j().a(BeautyMode.D, false);
                    intent.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(b));
                }
                if (LibraryPickerActivity.c(b) && com.cyberlink.youcammakeup.activity.LibraryPickerActivity.d(b) != null)
                {
                    Globals.T();
                    MakeupMode makeupmode = MakeupMode.g;
                    BeautyMode beautymode = BeautyMode.D;
                    if (com.cyberlink.youcammakeup.activity.LibraryPickerActivity.e(b).equalsIgnoreCase("Look"))
                    {
                        makeupmode = MakeupMode.a;
                    }
                    if (makeupmode != MakeupMode.g)
                    {
                        DownloadUseUtils.a(false);
                        intent.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate(-1L, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.d(b), makeupmode, beautymode));
                    }
                }
                com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(b, s1, intent);
            }

            
            {
                b = LibraryPickerActivity.this;
                a = l1;
                super();
            }
        };
        b(h);
    }

    public boolean b(int i1)
    {
        Object obj = getResources();
        if (a(i1))
        {
            return true;
        }
        obj = String.format(((Resources) (obj)).getString(0x7f07058f), new Object[] {
            Integer.valueOf(o.b())
        });
        if (q != null)
        {
            q.cancel();
        }
        q = Toast.makeText(this, ((CharSequence) (obj)), 1);
        q.show();
        return false;
    }

    public boolean d()
    {
        Intent intent = getIntent();
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        Object obj = intent.getStringExtra("EXTRA_KEY_TEMPLATE_DEEPLINK_URI");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        intent = new Intent();
        intent.setData(Uri.parse(((String) (obj))));
        startActivity(intent);
        return true;
        obj = (Class)intent.getSerializableExtra(getResources().getString(0x7f070729));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        startActivity(new Intent(getApplicationContext(), ((Class) (obj))));
        return true;
        intent = (Intent)intent.getParcelableExtra(getResources().getString(0x7f07072a));
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        startActivity(intent);
        return true;
        Exception exception;
        exception;
        exception.printStackTrace();
        return false;
    }

    public State j()
    {
        return o;
    }

    protected State k()
    {
        return new State();
    }

    protected void l()
    {
    }

    protected void m()
    {
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("SHOULD_REOPEN_LIBRARY_CAMERA", false))
        {
            ((TopBarFragment)getFragmentManager().findFragmentById(0x7f0c0156)).c();
            intent.removeExtra("SHOULD_REOPEN_LIBRARY_CAMERA");
        }
    }

    protected void n()
    {
        Globals.d().c("libraryView");
    }

    public boolean o()
    {
        return p.b().length >= o.a();
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        com.pf.common.utility.m.d("YMK150505-0029", String.format(Locale.US, "requestCode: %d", new Object[] {
            Integer.valueOf(i1)
        }));
        if (i1 == 100)
        {
            com.pf.common.utility.m.d("YMK150505-0029", String.format(Locale.US, "resultCode: %d", new Object[] {
                Integer.valueOf(j1)
            }));
            com.pf.common.utility.m.e("onActivityResult", (new StringBuilder()).append("resultCode = ").append(String.valueOf(j1)).toString());
            if (j1 == -1)
            {
                com.pf.common.utility.m.d("YMK150505-0029", String.format("data: %s", new Object[] {
                    String.valueOf(intent)
                }));
                intent = Camera.a().b();
                com.pf.common.utility.m.d("YMK150505-0029", String.format("capturedPath: %s", new Object[] {
                    String.valueOf(intent)
                }));
                if (intent == null)
                {
                    com.pf.common.utility.m.e("onActivityResult", "capturedPath is null");
                    return;
                } else
                {
                    com.pf.common.utility.m.d("YMK150505-0029", "setCapturedFilePath(null)");
                    Camera.a().a(null);
                    com.pf.common.utility.m.d("YMK150505-0029", "Start EditViewActivity.");
                    h = new Runnable(intent) {

                        final String a;
                        final LibraryPickerActivity b;

                        public void run()
                        {
                            Intent intent1;
                            StatusManager.j().a(-9L, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a);
                            intent1 = new Intent(b, b.r());
                            intent1.putExtras(b.getIntent());
                            intent1.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(a)));
                            intent1.setAction("android.intent.action.SEND");
                            intent1.putExtra("IS_INTENT_FROM_LIBRARY_CAMERA", true);
                            if (com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(b) == null) goto _L2; else goto _L1
_L1:
                            intent1.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(b));
_L4:
                            b.a(intent1);
                            b.startActivity(intent1);
                            return;
_L2:
                            if (com.cyberlink.youcammakeup.activity.LibraryPickerActivity.b(b.getIntent()))
                            {
                                MakeupMode makeupmode = MakeupMode.g;
                                BeautyMode beautymode = BeautyMode.D;
                                if (com.cyberlink.youcammakeup.activity.LibraryPickerActivity.e(b).equalsIgnoreCase("Look"))
                                {
                                    makeupmode = MakeupMode.a;
                                }
                                DownloadUseUtils.a(false);
                                intent1.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate(-1L, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.d(b), makeupmode, beautymode));
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }

            
            {
                b = LibraryPickerActivity.this;
                a = s1;
                super();
            }
                    };
                    b(h);
                    return;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        l();
        super.onCreate(bundle);
        setContentView(0x7f030013);
        StatusManager.j().a("libraryView");
        p = (PickedFragment)getFragmentManager().findFragmentById(0x7f0c0157);
        c(bundle);
        StatusManager.j().a(this);
        StatusManager.j().g(false);
        StatusManager.j().c(null);
        BeautifierManager.a();
        DownloadUseUtils.c(this);
    }

    public void onDestroy()
    {
        StatusManager.j().b(this);
        super.onDestroy();
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
            if (Globals.d().i().a())
            {
                return false;
            } else
            {
                ((TopBarFragment)getFragmentManager().findFragmentById(0x7f0c0156)).a();
                return true;
            }
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        c(((Bundle) (null)));
    }

    protected void onPause()
    {
        StatusManager.j().b(this);
        n();
        super.onPause();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        bundle = (State)bundle.getSerializable("LibraryPickerActivity_STATE");
        if (bundle == null)
        {
            o = new State();
            s();
            return;
        } else
        {
            o = bundle;
            return;
        }
    }

    protected void onResume()
    {
        StatusManager.j().a(this);
        super.onResume();
        Globals.d().c(null);
        m();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("LibraryPickerActivity_STATE", o);
    }

    protected void onStart()
    {
        super.onStart();
        d(getIntent());
        e(getIntent());
        if (Camera.a().c())
        {
            return;
        } else
        {
            StatusManager.j().a("libraryView");
            return;
        }
    }

    protected void onStop()
    {
        super.onStop();
    }

    public void p()
    {
        if (j() == null || j().c() == null || !j().c().equals("editViewForIntent"))
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        }
        finish();
    }

    public boolean q()
    {
        return b;
    }

    protected Class r()
    {
        return com/cyberlink/youcammakeup/activity/EditViewActivity;
    }


    private class State
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private final String mDestView;
        private final int mMax;
        private final int mMin;
        private final boolean mMultiSelect;

        static String a(State state)
        {
            return state.mDestView;
        }

        private void readObject(ObjectInputStream objectinputstream)
        {
            try
            {
                objectinputstream.defaultReadObject();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ObjectInputStream objectinputstream)
            {
                return;
            }
        }

        private void writeObject(ObjectOutputStream objectoutputstream)
        {
            try
            {
                objectoutputstream.defaultWriteObject();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ObjectOutputStream objectoutputstream)
            {
                return;
            }
        }

        public int a()
        {
            return mMin;
        }

        public int b()
        {
            return mMax;
        }

        public String c()
        {
            return mDestView;
        }

        public boolean d()
        {
            return mMultiSelect;
        }

        private State()
        {
            mMultiSelect = true;
            mDestView = null;
            mMin = -1;
            mMax = -1;
        }


        public State(String s1)
        {
            mMultiSelect = false;
            mDestView = s1;
            mMin = -1;
            mMax = -1;
        }
    }

}
