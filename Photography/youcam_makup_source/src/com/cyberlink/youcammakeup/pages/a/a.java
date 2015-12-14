// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.NetworkBaseActivity;
import com.cyberlink.youcammakeup.activity.CostumeLooksPagerActivity;
import com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.e;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.GetPromotionTask;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.af;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ah;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.w;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility;
import com.cyberlink.youcammakeup.pages.moreview.n;
import com.cyberlink.youcammakeup.pages.moreview.p;
import com.cyberlink.youcammakeup.pages.moreview.q;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.o;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a extends PagerAdapter
    implements q
{

    private static String b = "CostumeLooksPagerAdapter";
    com.cyberlink.youcammakeup.e a;
    private Context c;
    private List d;
    private ag e;
    private NetworkManager f;
    private Object g;
    private DownloadItemUtility h;
    private List i;
    private Set j;
    private n k;
    private android.view.View.OnClickListener l;

    public a(Context context)
    {
        k = new n() {

            final a a;

            public void a(View view)
            {
                p p1;
                String s1;
                int i1;
                p1 = (p)view.getTag();
                i1 = p1.a();
                ((CostumeLooksPagerActivity)a.a(a)).c(false);
                if (i1 >= com.cyberlink.youcammakeup.pages.a.a.b(a).size())
                {
                    break MISSING_BLOCK_LABEL_224;
                }
                s1 = ((MakeupItemMetadata)com.cyberlink.youcammakeup.pages.a.a.b(a).get(i1)).b();
                String s2 = ((MakeupItemMetadata)com.cyberlink.youcammakeup.pages.a.a.b(a).get(i1)).c();
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKCostumeMakeupEvent(com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent.Operation.b, s2));
                if (!bo.h(s1)) goto _L2; else goto _L1
_L1:
                DownloadUseUtils.a(false);
                ((CostumeLooksPagerActivity)a.a(a)).a(new com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate(-1L, s1, MakeupMode.a, BeautyMode.D));
_L4:
                return;
_L2:
                if (p1.c() == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c) goto _L4; else goto _L3
_L3:
                if (NetworkManager.L())
                {
                    p1.a(com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.c);
                    a.c(a).a((DownloadGridItem)view, (MakeupItemMetadata)com.cyberlink.youcammakeup.pages.a.a.b(a).get(i1));
                    return;
                } else
                {
                    view = Globals.d().getResources().getString(0x7f070533);
                    a.c(a).a(view);
                    return;
                }
                view = ((as)a.d(a).get(i1 - com.cyberlink.youcammakeup.pages.a.a.b(a).size())).a();
                DownloadUseUtils.a(false);
                ((CostumeLooksPagerActivity)a.a(a)).a(new com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate(-1L, view, MakeupMode.a, BeautyMode.D));
                return;
            }

            
            {
                a = a.this;
                super();
            }
        };
        a = new com.cyberlink.youcammakeup.e() {

            final a a;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                m.b(com.cyberlink.youcammakeup.pages.a.a.e(), "getTemplateMetadata complete");
                if (list == null)
                {
                    return;
                } else
                {
                    (new Handler(Looper.getMainLooper())).post(new Runnable(this, list) {

                        final List a;
                        final _cls3 b;

                        public void run()
                        {
                            a.a(b.a, a);
                            b.a.notifyDataSetChanged();
                            if (a.a(b.a) != null && (a.a(b.a) instanceof CostumeLooksPagerActivity))
                            {
                                ((CostumeLooksPagerActivity)a.a(b.a)).k();
                            }
                        }

            
            {
                b = _pcls3;
                a = list;
                super();
            }
                    });
                    return;
                }
            }

            public void b(Object obj)
            {
                m.e(com.cyberlink.youcammakeup.pages.a.a.e(), "getTemplateMetadata error");
            }

            public void c(Object obj)
            {
                m.e(com.cyberlink.youcammakeup.pages.a.a.e(), "getTemplateMetadata cancel");
            }

            
            {
                a = a.this;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final a a;

            public void onClick(View view)
            {
                Globals.d().i().l(a.a(a));
            }

            
            {
                a = a.this;
                super();
            }
        };
        c = context;
        context = PanelDataCenter.a().a("Costume", new com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a
        });
        d = new ArrayList();
        String s;
        for (context = context.iterator(); context.hasNext(); d.add(PanelDataCenter.a().o(s)))
        {
            s = (String)context.next();
        }

        f();
        notifyDataSetChanged();
        f = Globals.d().w();
        h = new DownloadItemUtility(this, g, com.cyberlink.youcammakeup.Globals.ActivityType.m, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a);
        h.a(e);
        h.a(l);
        i = new ArrayList();
        g();
        j = z.c(Globals.d());
    }

    static Context a(a a1)
    {
        return a1.c;
    }

    static List a(a a1, List list)
    {
        a1.i = list;
        return list;
    }

    static List b(a a1)
    {
        return a1.i;
    }

    static DownloadItemUtility c(a a1)
    {
        return a1.h;
    }

    static List d(a a1)
    {
        return a1.d;
    }

    static String e()
    {
        return b;
    }

    private void f()
    {
        k k1 = new k(c, null);
        k1.g = false;
        k1.a(0.15F);
        e = new ag(c);
        e.a(((Activity)c).getFragmentManager(), k1);
    }

    private void g()
    {
        int i1 = 0;
        Object obj = GetPromotionTask.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.GetPromotionTask.PromotionCategoryType.a.a());
        if (obj != null && !NetworkManager.L())
        {
            e e1 = com.cyberlink.youcammakeup.h.v();
            boolean flag = ((NetworkBaseActivity)a()).j();
            ((NetworkBaseActivity)a()).b(false);
            if (!flag)
            {
                obj = ((af) (obj)).a();
                ArrayList arraylist = new ArrayList();
                for (; i1 < ((List) (obj)).size(); i1++)
                {
                    MakeupItemMetadata makeupitemmetadata = e1.a(((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ag)((List) (obj)).get(i1)).a);
                    if (makeupitemmetadata != null && h.a(makeupitemmetadata, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.b))
                    {
                        arraylist.add(makeupitemmetadata);
                    }
                }

                a.a(arraylist);
                return;
            }
        }
        f.a(new GetPromotionTask(f, com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.GetPromotionTask.PromotionCategoryType.a, new ah() {

            final a a;

            public void a(af af1)
            {
                m.b(com.cyberlink.youcammakeup.pages.a.a.e(), "GetPromotionTask complete");
                if (af1 != null)
                {
                    if ((af1 = af1.a()) != null)
                    {
                        ArrayList arraylist1 = new ArrayList(af1.size());
                        for (int j1 = 0; j1 < af1.size(); j1++)
                        {
                            w w1 = new w();
                            w1.a = ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ag)af1.get(j1)).a;
                            w1.b = ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ag)af1.get(j1)).b;
                            arraylist1.add(w1);
                        }

                        (new Handler(Looper.getMainLooper())).post(new Runnable(this, arraylist1) {

                            final List a;
                            final _cls2 b;

                            public void run()
                            {
                                a.c(b.a).b(a, b.a.a);
                            }

            
            {
                b = _pcls2;
                a = list;
                super();
            }
                        });
                        return;
                    }
                }
            }

            public void a(bn bn1)
            {
                m.e(com.cyberlink.youcammakeup.pages.a.a.e(), "GetPromotionTask error");
            }

            public volatile void a(Object obj1)
            {
                a((af)obj1);
            }

            public void a(Void void1)
            {
                m.e(com.cyberlink.youcammakeup.pages.a.a.e(), "GetPromotionTask cancel");
            }

            public void b(Object obj1)
            {
                a((bn)obj1);
            }

            public void c(Object obj1)
            {
                a((Void)obj1);
            }

            
            {
                a = a.this;
                super();
            }
        }));
    }

    public Context a()
    {
        return c;
    }

    public String a(int i1)
    {
        if (i1 < i.size())
        {
            return ((MakeupItemMetadata)i.get(i1)).b();
        } else
        {
            return ((as)d.get(i1 - i.size())).a();
        }
    }

    public void a(List list)
    {
    }

    public long b()
    {
        return -1L;
    }

    public MakeupItemMetadata b(int i1)
    {
        if (i1 < i.size())
        {
            return (MakeupItemMetadata)i.get(i1);
        } else
        {
            return null;
        }
    }

    public void c()
    {
        int i1 = 0;
        HashSet hashset = new HashSet();
        if (i != null && i.size() > 0)
        {
            MakeupItemMetadata amakeupitemmetadata[] = (MakeupItemMetadata[])i.toArray(new MakeupItemMetadata[0]);
            for (int j1 = amakeupitemmetadata.length; i1 < j1; i1++)
            {
                MakeupItemMetadata makeupitemmetadata = amakeupitemmetadata[i1];
                hashset.add(makeupitemmetadata.m());
                h.a(makeupitemmetadata);
            }

            z.a(Globals.d(), hashset);
        }
    }

    public CategoryType d()
    {
        return null;
    }

    public void destroyItem(ViewGroup viewgroup, int i1, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return i.size() + d.size();
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i1)
    {
        DownloadGridItem downloadgriditem = new DownloadGridItem(viewgroup.getContext(), com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.f, null);
        Object obj = new p();
        downloadgriditem.setTag(obj);
        ((p) (obj)).a(i1);
        if (i1 < i.size())
        {
            MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)i.get(i1);
            ((p) (obj)).a(Long.valueOf(makeupitemmetadata.a()));
            downloadgriditem.setTitle(makeupitemmetadata.c());
            downloadgriditem.setDescription(makeupitemmetadata.e());
            h.b(makeupitemmetadata, downloadgriditem, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.b);
            obj = makeupitemmetadata.m();
            if (!j.contains(obj))
            {
                downloadgriditem.a(true);
            } else
            {
                downloadgriditem.a(false);
            }
        } else
        {
            i1 -= i.size();
            e.a(((as)d.get(i1)).e(), downloadgriditem.getThumbView());
            ((p) (obj)).a(Long.valueOf(0x8000000000000000L));
            downloadgriditem.setTitle(((as)d.get(i1)).b());
            downloadgriditem.setDescription(((as)d.get(i1)).l());
            downloadgriditem.a(false);
        }
        downloadgriditem.setOnDownloadClickListener(k);
        downloadgriditem.b(false);
        viewgroup.addView(downloadgriditem, 0);
        return downloadgriditem;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (View)obj;
    }

}
