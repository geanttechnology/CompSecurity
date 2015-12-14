// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.database.more.l.b;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.an;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ar;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.av;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aw;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.p;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.v;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.i;
import com.cyberlink.youcammakeup.kernelctrl.w;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ad;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            s, q, DownloadGridItem, p, 
//            af, n, o, t, 
//            r

public class DownloadItemUtility
{

    com.cyberlink.youcammakeup.pages.moreview.n a;
    com.cyberlink.youcammakeup.pages.moreview.o b;
    private NetworkManager c;
    private b d;
    private q e;
    private android.view.View.OnClickListener f;
    private t g;
    private android.view.View.OnClickListener h;
    private Toast i;
    private ag j;
    private com.cyberlink.youcammakeup.Globals.ActivityType k;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType l;

    public DownloadItemUtility(q q1, Object obj, com.cyberlink.youcammakeup.Globals.ActivityType activitytype, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        k = com.cyberlink.youcammakeup.Globals.ActivityType.c;
        a = new com.cyberlink.youcammakeup.pages.moreview.n() {

            final DownloadItemUtility a;

            public void a(View view)
            {
                Object obj2 = (com.cyberlink.youcammakeup.pages.moreview.p)view.getTag();
                if (((com.cyberlink.youcammakeup.pages.moreview.p) (obj2)).b() != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                Object obj1;
                DownloadGridItem downloadgriditem;
                MakeupItemMetadata makeupitemmetadata;
                long l1;
                l1 = ((com.cyberlink.youcammakeup.pages.moreview.p) (obj2)).b().longValue();
                int i1 = ((com.cyberlink.youcammakeup.pages.moreview.p) (obj2)).a();
                m.b("DownloadItemUtility", (new StringBuilder()).append("onItemClick, tid:").append(l1).toString());
                downloadgriditem = (DownloadGridItem)view;
                makeupitemmetadata = com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(a).b(i1);
                obj1 = com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(a).d();
                if (((com.cyberlink.youcammakeup.pages.moreview.p) (obj2)).c() == DownloadGridItem.DownloadState.c)
                {
                    a.a(makeupitemmetadata);
                    ((com.cyberlink.youcammakeup.pages.moreview.p) (obj2)).a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b);
                    downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b);
                    return;
                }
                if (((com.cyberlink.youcammakeup.pages.moreview.p) (obj2)).c() != DownloadGridItem.DownloadState.d) goto _L4; else goto _L3
_L3:
                boolean flag;
                if (DownloadItemUtility.d(a) == com.cyberlink.youcammakeup.Globals.ActivityType.d && (obj1 == CategoryType.c || obj1 == CategoryType.b))
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Operation.d, makeupitemmetadata.b(), null));
                } else
                if (DownloadItemUtility.d(a) == com.cyberlink.youcammakeup.Globals.ActivityType.c && (obj1 == CategoryType.c || obj1 == CategoryType.b))
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksCategoryEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent.Operation.d, makeupitemmetadata.b(), makeupitemmetadata.c()));
                }
                YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Source.e.a());
                if (obj1 == CategoryType.d)
                {
                    boolean flag1 = bo.f(makeupitemmetadata.b());
                    flag = flag1;
                    if (flag1)
                    {
                        bo.c(makeupitemmetadata.b(), false);
                        flag = flag1;
                    }
                } else
                if (obj1 == CategoryType.b || obj1 == CategoryType.c)
                {
                    boolean flag2;
                    if (obj1 == CategoryType.b)
                    {
                        YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.f.a());
                    } else
                    {
                        YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.g.a());
                    }
                    flag2 = bo.h(makeupitemmetadata.b());
                    flag = flag2;
                    if (flag2)
                    {
                        bo.a(makeupitemmetadata.b(), false);
                        flag = flag2;
                    }
                } else
                {
                    boolean flag3 = bo.g(makeupitemmetadata.b());
                    flag = flag3;
                    if (flag3)
                    {
                        bo.b(makeupitemmetadata.b(), false);
                        flag = flag3;
                    }
                }
                if (flag)
                {
                    obj2 = (Activity)view.getContext();
                    if (obj2 != null)
                    {
                        Intent intent = (new Intent()).setFlags(0x4000000);
                        if (obj1 == CategoryType.d)
                        {
                            view = MakeupMode.d;
                            obj1 = BeautyMode.n;
                        } else
                        if (obj1 == CategoryType.f)
                        {
                            view = MakeupMode.d;
                            obj1 = BeautyMode.m;
                        } else
                        if (obj1 == CategoryType.e)
                        {
                            view = MakeupMode.d;
                            obj1 = BeautyMode.l;
                        } else
                        if (obj1 == CategoryType.b || obj1 == CategoryType.c)
                        {
                            view = MakeupMode.a;
                            obj1 = BeautyMode.D;
                        } else
                        if (obj1 == CategoryType.o)
                        {
                            view = MakeupMode.b;
                            obj1 = BeautyMode.x;
                        } else
                        if (obj1 == CategoryType.i)
                        {
                            view = MakeupMode.f;
                            obj1 = BeautyMode.D;
                        } else
                        if (obj1 == CategoryType.j)
                        {
                            view = MakeupMode.f;
                            obj1 = BeautyMode.D;
                        } else
                        if (obj1 == CategoryType.k)
                        {
                            view = MakeupMode.f;
                            obj1 = BeautyMode.D;
                        } else
                        if (obj1 == CategoryType.l)
                        {
                            view = MakeupMode.f;
                            obj1 = BeautyMode.D;
                        } else
                        if (obj1 == CategoryType.m)
                        {
                            view = MakeupMode.f;
                            obj1 = BeautyMode.D;
                        } else
                        {
                            obj1 = null;
                            view = null;
                        }
                        if (view != null && obj1 != null)
                        {
                            DownloadUseUtils.a(false);
                            intent.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate(l1, makeupitemmetadata.b(), view, ((BeautyMode) (obj1))));
                            l1 = StatusManager.j().l();
                            view = ViewEngine.a().a(l1, 1.0D, null);
                            if (downloadgriditem.getUseTemplateTarget() == UseTemplateTarget.c)
                            {
                                intent.setClass(((android.content.Context) (obj2)), com/cyberlink/youcammakeup/activity/CameraActivity);
                            } else
                            if ((l1 > -1L || com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1)) && view != null)
                            {
                                intent.setClass(((android.content.Context) (obj2)), com/cyberlink/youcammakeup/activity/EditViewActivity);
                            } else
                            {
                                view = new com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State("editView");
                                intent.setClass(((android.content.Context) (obj2)), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
                                intent.putExtra("LibraryPickerActivity_STATE", view);
                                view = ((Activity) (obj2)).getIntent().getData();
                                if (view != null && com.cyberlink.youcammakeup.utility.a.a(view.toString()))
                                {
                                    intent.putExtra("EXTRA_KEY_TEMPLATE_DEEPLINK_URI", view.toString());
                                    intent.setFlags(32768);
                                }
                            }
                        }
                        DownloadUseUtils.a(((Activity) (obj2)).getIntent(), intent);
                        if (intent.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/LibraryPickerActivity.getName()))
                        {
                            StatusManager.j().b(-1L);
                            StatusManager.j().a(-1L, null);
                            ((Activity) (obj2)).startActivity(intent);
                            return;
                        }
                        if (intent.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/CameraActivity.getName()))
                        {
                            ((Activity) (obj2)).startActivity(intent);
                            return;
                        } else
                        {
                            ((Activity) (obj2)).startActivity(intent);
                            ((Activity) (obj2)).finish();
                            return;
                        }
                    }
                }
_L10:
                if (true) goto _L1; else goto _L4
_L4:
                if (makeupitemmetadata.k()) goto _L6; else goto _L5
_L5:
                if (DownloadItemUtility.d(a) != com.cyberlink.youcammakeup.Globals.ActivityType.d || obj1 != CategoryType.c && obj1 != CategoryType.b) goto _L8; else goto _L7
_L7:
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Operation.c, makeupitemmetadata.b(), null));
_L9:
                ((com.cyberlink.youcammakeup.pages.moreview.p) (obj2)).a(DownloadGridItem.DownloadState.c);
                downloadgriditem.setDownloadBtnState(DownloadGridItem.DownloadState.c);
                a.a(downloadgriditem, makeupitemmetadata);
                a.b();
                return;
_L8:
                if (DownloadItemUtility.d(a) == com.cyberlink.youcammakeup.Globals.ActivityType.c && (obj1 == CategoryType.c || obj1 == CategoryType.b))
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksCategoryEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent.Operation.c, makeupitemmetadata.b(), makeupitemmetadata.c()));
                }
                if (true) goto _L9; else goto _L6
_L6:
                view = Globals.d().a(DownloadItemUtility.d(a));
                if (makeupitemmetadata.p().size() > 0)
                {
                    Globals.d().a(makeupitemmetadata);
                    o.a(view, com.cyberlink.youcammakeup.widgetpool.dialogs.an.a(makeupitemmetadata), "ShareToUnlockDialog");
                    return;
                }
                  goto _L10
            }

            
            {
                a = DownloadItemUtility.this;
                super();
            }

            private class UseTemplateTarget extends Enum
            {

                public static final UseTemplateTarget a;
                public static final UseTemplateTarget b;
                public static final UseTemplateTarget c;
                private static final UseTemplateTarget d[];

                public static UseTemplateTarget valueOf(String s1)
                {
                    return (UseTemplateTarget)Enum.valueOf(com/cyberlink/youcammakeup/pages/moreview/DownloadItemUtility$UseTemplateTarget, s1);
                }

                public static UseTemplateTarget[] values()
                {
                    return (UseTemplateTarget[])d.clone();
                }

                static 
                {
                    a = new UseTemplateTarget("Default", 0);
                    b = new UseTemplateTarget("EditView", 1);
                    c = new UseTemplateTarget("Camera", 2);
                    d = (new UseTemplateTarget[] {
                        a, b, c
                    });
                }

                private UseTemplateTarget(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        };
        b = new com.cyberlink.youcammakeup.pages.moreview.o() {

            final DownloadItemUtility a;

            public void a(View view)
            {
                if (com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.e(a) != null)
                {
                    com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.e(a).onClick(view);
                }
            }

            
            {
                a = DownloadItemUtility.this;
                super();
            }
        };
        e = q1;
        c = Globals.d().w();
        d = com.cyberlink.youcammakeup.h.c();
        k = activitytype;
        l = displaymakeuptype;
    }

    static q a(DownloadItemUtility downloaditemutility)
    {
        return downloaditemutility.e;
    }

    private List a(v v1)
    {
        Object obj = MakeupItemTreeManager.a().d(l, v1.a);
        v1 = new ArrayList();
        s s1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); v1.add(s1))
        {
            w w1 = (w)((Iterator) (obj)).next();
            s1 = new s();
            s1.a = w1;
            s1.c = a(e.d());
        }

        return v1;
    }

    static List a(DownloadItemUtility downloaditemutility, long l1)
    {
        return downloaditemutility.b(l1);
    }

    static List a(DownloadItemUtility downloaditemutility, v v1)
    {
        return downloaditemutility.a(v1);
    }

    private void a(MKCategoryV2Status mkcategoryv2status, e e1)
    {
        (new Runnable(mkcategoryv2status, e1) {

            final MKCategoryV2Status a;
            final e b;
            final DownloadItemUtility c;

            public void run()
            {
                com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.b(c).a(new av(com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.b(c), -1L, DownloadItemUtility.c(c), a, new aw(this) {

                    final _cls2 a;

                    public void a(ar ar1)
                    {
                        ar1 = MakeupItemTreeManager.a().b();
                        com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.b(a.c).K().a(MoreMakeupActivity.a, ar1);
                        a.b.a(null);
                    }

                    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                    {
                        a.b.b(bn1);
                    }

                    public volatile void a(Object obj)
                    {
                        a((ar)obj);
                    }

                    public void a(Void void1)
                    {
                        a.b.c(void1);
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
                a = _pcls2;
                super();
            }
                }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
            }

            
            {
                c = DownloadItemUtility.this;
                a = mkcategoryv2status;
                b = e1;
                super();
            }
        }).run();
    }

    private void a(e e1)
    {
        b(new e(e1) {

            final e a;
            final DownloadItemUtility b;

            public void a(ap ap1)
            {
                ap1 = ap1.i();
                if (ap1 == null)
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(b, ap1, a);
                    return;
                }
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                a.b(bn1);
            }

            public volatile void a(Object obj)
            {
                a((ap)obj);
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a.c(obj);
            }

            
            {
                b = DownloadItemUtility.this;
                a = e1;
                super();
            }
        });
    }

    static void a(DownloadItemUtility downloaditemutility, MKCategoryV2Status mkcategoryv2status, e e1)
    {
        downloaditemutility.a(mkcategoryv2status, e1);
    }

    static NetworkManager b(DownloadItemUtility downloaditemutility)
    {
        return downloaditemutility.c;
    }

    private List b(long l1)
    {
        return MakeupItemTreeManager.a().b(l, l1);
    }

    private void b(e e1)
    {
        m.b("DownloadItemUtility", "[requestStatus]");
        c.a(new an(e.a(), c, new ao(e1) {

            final e a;
            final DownloadItemUtility b;

            public void a(ap ap1)
            {
                a.a(ap1);
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                a.b(bn1);
            }

            public volatile void a(Object obj)
            {
                a((ap)obj);
            }

            public void a(Void void1)
            {
                a.c(new String("GetStatusTask cancel"));
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
                b = DownloadItemUtility.this;
                a = e1;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
    }

    static com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType c(DownloadItemUtility downloaditemutility)
    {
        return downloaditemutility.l;
    }

    static com.cyberlink.youcammakeup.Globals.ActivityType d(DownloadItemUtility downloaditemutility)
    {
        return downloaditemutility.k;
    }

    static t e(DownloadItemUtility downloaditemutility)
    {
        return downloaditemutility.g;
    }

    DownloadGridItem.LayoutTypeInfo.LayoutType a(CategoryType categorytype)
    {
        if (categorytype == CategoryType.o)
        {
            return DownloadGridItem.LayoutTypeInfo.LayoutType.g;
        }
        if (categorytype == CategoryType.e)
        {
            return DownloadGridItem.LayoutTypeInfo.LayoutType.c;
        }
        if (categorytype == CategoryType.f)
        {
            return DownloadGridItem.LayoutTypeInfo.LayoutType.d;
        }
        if (categorytype == CategoryType.d)
        {
            return com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.b;
        }
        if (categorytype == CategoryType.i || categorytype == CategoryType.j || categorytype == CategoryType.k || categorytype == CategoryType.l || categorytype == CategoryType.m)
        {
            return com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.i;
        } else
        {
            return com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.a;
        }
    }

    void a()
    {
        if (i != null)
        {
            i.cancel();
            i = null;
        }
    }

    void a(long l1)
    {
        Activity activity = (Activity)e.a();
        Globals.d().i().b(activity);
        a(new e(l1, activity) {

            final long a;
            final Activity b;
            final DownloadItemUtility c;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                m.e("DownloadItemUtility", bn1.toString());
                b.runOnUiThread(new Runnable(this, bn1) {

                    final com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn a;
                    final _cls1 b;

                    public void run()
                    {
                        Globals.d().i().h(b.b);
                        b.c.a(NetworkManager.a(a.a()));
                    }

            
            {
                b = _pcls1;
                a = bn1;
                super();
            }
                });
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                List list = com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(c, a);
                void1 = new ArrayList();
                v v1;
                for (Iterator iterator = list.iterator(); iterator.hasNext(); void1.add(new r(v1, com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(c, v1))))
                {
                    v1 = (v)iterator.next();
                }

                if (list.size() == 0)
                {
                    Object obj = new v();
                    obj.a = a;
                    obj = new r(((v) (obj)), com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(c, ((v) (obj))));
                    if (((r) (obj)).c.size() != 0)
                    {
                        void1.add(obj);
                    }
                }
                b.runOnUiThread(new Runnable(this, void1) {

                    final List a;
                    final _cls1 b;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(b.c).a(a);
                        Globals.d().i().h(b.b);
                    }

            
            {
                b = _pcls1;
                a = list;
                super();
            }
                });
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                m.b("DownloadItemUtility", obj.toString());
                b.runOnUiThread(new Runnable(this, obj) {

                    final Object a;
                    final _cls1 b;

                    public void run()
                    {
                        Globals.d().i().h(b.b);
                        b.c.a(a.toString());
                    }

            
            {
                b = _pcls1;
                a = obj;
                super();
            }
                });
            }

            
            {
                c = DownloadItemUtility.this;
                a = l1;
                b = activity;
                super();
            }
        });
    }

    public void a(android.view.View.OnClickListener onclicklistener)
    {
        f = onclicklistener;
    }

    public void a(MakeupItemMetadata makeupitemmetadata)
    {
        bn.a(makeupitemmetadata);
    }

    public void a(MakeupItemMetadata makeupitemmetadata, ImageView imageview, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType imagetype)
    {
        bn.a(j, makeupitemmetadata, imageview, imagetype);
    }

    void a(MakeupItemMetadata makeupitemmetadata, DownloadGridItem downloadgriditem)
    {
        long l1 = makeupitemmetadata.a();
        com.cyberlink.youcammakeup.pages.moreview.p p1;
        if (downloadgriditem != null)
        {
            if ((p1 = (com.cyberlink.youcammakeup.pages.moreview.p)downloadgriditem.getTag()).b().longValue() == l1 && p1.c() == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.a)
            {
                long l2 = e.b();
                DownloadingState downloadingstate;
                int i1;
                boolean flag;
                if (l2 == 0x15ab16L)
                {
                    flag = bo.f(makeupitemmetadata.b());
                } else
                if (l2 == 0x15ab1bL || l2 == 0x15ab1cL)
                {
                    flag = bo.h(makeupitemmetadata.b());
                } else
                {
                    flag = bo.g(makeupitemmetadata.b());
                }
                downloadingstate = c.a(l1);
                if (d.a(l1) || flag)
                {
                    makeupitemmetadata = DownloadGridItem.DownloadState.d;
                    i1 = 0;
                } else
                if (downloadingstate.a() == com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState.State.a)
                {
                    makeupitemmetadata = DownloadGridItem.DownloadState.c;
                    i1 = 0;
                } else
                if (downloadingstate.a() == com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState.State.b)
                {
                    makeupitemmetadata = DownloadGridItem.DownloadState.c;
                    i1 = com.cyberlink.youcammakeup.pages.moreview.af.a(downloadingstate.b());
                } else
                {
                    makeupitemmetadata = com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b;
                    i1 = 0;
                }
                if (downloadgriditem != null && ((com.cyberlink.youcammakeup.pages.moreview.p)downloadgriditem.getTag()).b().longValue() == l1)
                {
                    downloadgriditem.setDownloadBtnState(makeupitemmetadata);
                    if (makeupitemmetadata == DownloadGridItem.DownloadState.c)
                    {
                        downloadgriditem.setProgress(i1);
                    }
                    ((com.cyberlink.youcammakeup.pages.moreview.p)downloadgriditem.getTag()).a(makeupitemmetadata);
                    return;
                }
            }
        }
    }

    void a(MakeupItemMetadata makeupitemmetadata, DownloadGridItem downloadgriditem, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType imagetype)
    {
        b(makeupitemmetadata, downloadgriditem, imagetype);
        a(makeupitemmetadata, downloadgriditem);
        downloadgriditem.setClickable(true);
    }

    public void a(a a1, ImageView imageview)
    {
        bn.a(j, a1, imageview);
    }

    public void a(ag ag)
    {
        j = ag;
    }

    void a(DownloadGridItem downloadgriditem)
    {
        downloadgriditem.setClickable(false);
        downloadgriditem.a();
        downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.a);
        downloadgriditem.b(false);
        downloadgriditem.c(false);
        downloadgriditem.a(false);
        downloadgriditem.setTitle(null);
        downloadgriditem.setDescription(null);
        ((com.cyberlink.youcammakeup.pages.moreview.p)downloadgriditem.getTag()).a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.a);
    }

    public void a(DownloadGridItem downloadgriditem, MakeupItemMetadata makeupitemmetadata)
    {
        downloadgriditem.setProgress(0);
        bn.a(e.b(), makeupitemmetadata, null);
    }

    public void a(t t)
    {
        g = t;
    }

    void a(Long long1)
    {
        com.cyberlink.youcammakeup.pages.moreview.af.b(MoreMakeupActivity.a, long1.longValue());
    }

    void a(Long long1, Long long2, DownloadGridItem downloadgriditem)
    {
        long l1 = Globals.d().w().K().c(MoreMakeupActivity.a, long2.longValue());
        boolean flag;
        if (long1.longValue() > l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        downloadgriditem.a(flag);
    }

    public void a(String s1)
    {
        Activity activity = (Activity)e.a();
        Globals.d().i().a(activity, k, f, h, s1);
    }

    void a(List list, e e1)
    {
        c.a(new com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.o(c, list, new p(e1) {

            final e a;
            final DownloadItemUtility b;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                a.b(bn1);
            }

            public void a(n n1)
            {
                if (n1 == null || n1.a() == null)
                {
                    return;
                } else
                {
                    a.a(n1.a());
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((n)obj);
            }

            public void a(Void void1)
            {
                a.c(void1);
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
                b = DownloadItemUtility.this;
                a = e1;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
    }

    public boolean a(MakeupItemMetadata makeupitemmetadata, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType imagetype)
    {
        return bn.a(makeupitemmetadata, imagetype);
    }

    public void b()
    {
        if (Globals.d().c().c())
        {
            return;
        }
        boolean flag = z.a(com.cyberlink.youcammakeup.pages.moreview.af.a, Globals.d());
        int j1 = z.c(af.c, Globals.d()) + 1;
        int i1;
        if (!flag)
        {
            i1 = j1;
            if (j1 == 10)
            {
                (new ad((Activity)e.a(), true)).show();
                z.a(com.cyberlink.youcammakeup.pages.moreview.af.a, Boolean.valueOf(true), Globals.d());
                i1 = 0;
            }
        } else
        {
            i1 = 0;
        }
        z.a(af.c, i1, Globals.d());
    }

    public void b(android.view.View.OnClickListener onclicklistener)
    {
        h = onclicklistener;
    }

    public void b(MakeupItemMetadata makeupitemmetadata, DownloadGridItem downloadgriditem, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType imagetype)
    {
        bn.a(j, makeupitemmetadata, downloadgriditem, imagetype);
    }

    public void b(List list, e e1)
    {
        bn.a(list, e1);
    }

    public void c(List list, e e1)
    {
        bn.b(list, e1);
    }
}
