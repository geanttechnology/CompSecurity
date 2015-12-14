// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLooksPromotionItemEvent;
import com.cyberlink.youcammakeup.clflurry.ao;
import com.cyberlink.youcammakeup.database.more.l.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.i;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.o;
import com.pf.common.utility.m;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ai, DownloadItemUtility, aj, ak

public class PromoteLooksDialog extends FrameLayout
{

    private ViewPager a;
    private aj b;
    private ai c;
    private ag d;
    private DownloadItemUtility e;
    private b f;
    private List g;
    private com.cyberlink.youcammakeup.Globals.ActivityType h;
    private ak i;
    private DownloadItemUtility.UseTemplateTarget j;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType k;
    private android.view.View.OnClickListener l = new android.view.View.OnClickListener() {

        final PromoteLooksDialog a;

        public void onClick(View view)
        {
            Globals.d().i().l(a.getContext());
            PromoteLooksDialog.a(a, PromoteLooksDialog.j(a), com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.k(a));
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };
    private android.support.v4.view.ViewPager.OnPageChangeListener m = new android.support.v4.view.ViewPager.OnPageChangeListener() {

        final PromoteLooksDialog a;

        public void onPageScrollStateChanged(int i1)
        {
        }

        public void onPageScrolled(int i1, float f1, int j1)
        {
        }

        public void onPageSelected(int i1)
        {
            MakeupItemMetadata makeupitemmetadata;
            String s1;
            if (com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(a) != null)
            {
                if ((makeupitemmetadata = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(a).b(i1)) != null && makeupitemmetadata.b() != null && !(s1 = makeupitemmetadata.b()).isEmpty())
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new ao(s1));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksPromotionItemEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksPromotionItemEvent.Operation.a, makeupitemmetadata.b(), makeupitemmetadata.c()));
                    return;
                }
            }
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };
    private android.view.View.OnClickListener n = new android.view.View.OnClickListener() {

        final PromoteLooksDialog a;

        public void onClick(View view)
        {
            Globals.d().i().l(a.getContext());
            a.b();
            a.setVisibility(4);
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };
    private android.view.View.OnClickListener o = new android.view.View.OnClickListener() {

        final PromoteLooksDialog a;

        public void onClick(View view)
        {
            a.b();
            a.setVisibility(4);
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };
    private android.view.View.OnClickListener p = new android.view.View.OnClickListener() {

        final PromoteLooksDialog a;

        public void onClick(View view)
        {
            int i1 = PromoteLooksDialog.a(a).getCurrentItem();
            PromoteLooksDialog.a(a).setCurrentItem(i1 - 1);
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };
    private android.view.View.OnClickListener q = new android.view.View.OnClickListener() {

        final PromoteLooksDialog a;

        public void onClick(View view)
        {
            int i1 = PromoteLooksDialog.a(a).getCurrentItem();
            PromoteLooksDialog.a(a).setCurrentItem(i1 + 1);
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };
    private android.view.View.OnClickListener r = new android.view.View.OnClickListener() {

        final PromoteLooksDialog a;

        public void onClick(View view)
        {
            int i1 = PromoteLooksDialog.a(a).getCurrentItem();
            view = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(a).b(i1);
            if (view == null)
            {
                return;
            }
            View view1 = PromoteLooksDialog.a(a).findViewWithTag(view.m());
            switch (_cls3.a[PromoteLooksDialog.a(a, view).ordinal()])
            {
            default:
                return;

            case 1: // '\001'
            case 2: // '\002'
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksPromotionItemEvent(view.b(), view.c(), com.cyberlink.youcammakeup.clflurry.YMKLooksPromotionItemEvent.ButtonType.a));
                com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.b(a, view);
                PromoteLooksDialog.a(a, view1, DownloadGridItem.DownloadState.c);
                return;

            case 3: // '\003'
                Globals.d().w().d(view.a());
                return;

            case 4: // '\004'
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksPromotionItemEvent(view.b(), view.c(), com.cyberlink.youcammakeup.clflurry.YMKLooksPromotionItemEvent.ButtonType.b));
                break;
            }
            PromoteLooksDialog.c(a, view);
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };
    private android.view.View.OnClickListener s = new android.view.View.OnClickListener() {

        final PromoteLooksDialog a;

        public void onClick(View view)
        {
            int i1 = PromoteLooksDialog.a(a).getCurrentItem();
            view = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(a).b(i1);
            if (view == null)
            {
                return;
            }
            PromoteLooksDialog.a(a, DownloadItemUtility.UseTemplateTarget.c);
            PromoteLooksDialog.d(a, view);
            view = PromoteLooksDialog.a(a).findViewWithTag(view.m()).findViewById(0x7f0c0586);
            if (view.getVisibility() == 0)
            {
                i1 = 4;
            } else
            {
                i1 = 0;
            }
            view.setVisibility(i1);
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };
    private android.view.View.OnClickListener t = new android.view.View.OnClickListener() {

        final PromoteLooksDialog a;

        public void onClick(View view)
        {
            int i1 = PromoteLooksDialog.a(a).getCurrentItem();
            view = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(a).b(i1);
            if (view == null)
            {
                return;
            }
            PromoteLooksDialog.a(a, com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.UseTemplateTarget.b);
            PromoteLooksDialog.d(a, view);
            view = PromoteLooksDialog.a(a).findViewWithTag(view.m()).findViewById(0x7f0c0586);
            if (view.getVisibility() == 0)
            {
                i1 = 4;
            } else
            {
                i1 = 0;
            }
            view.setVisibility(i1);
        }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
    };

    public PromoteLooksDialog(Context context)
    {
        super(context);
        j = DownloadItemUtility.UseTemplateTarget.a;
        k = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a;
        a(context);
    }

    public PromoteLooksDialog(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        j = DownloadItemUtility.UseTemplateTarget.a;
        k = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a;
        a(context);
    }

    public PromoteLooksDialog(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        j = DownloadItemUtility.UseTemplateTarget.a;
        k = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a;
        a(context);
    }

    static ViewPager a(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.a;
    }

    private DownloadGridItem.DownloadState a(MakeupItemMetadata makeupitemmetadata)
    {
        if (makeupitemmetadata == null)
        {
            return DownloadGridItem.DownloadState.a;
        }
        boolean flag = bo.h(makeupitemmetadata.b());
        DownloadingState downloadingstate = Globals.d().w().a(makeupitemmetadata.a());
        if (f.a(makeupitemmetadata.a()) || flag)
        {
            return DownloadGridItem.DownloadState.d;
        }
        if (downloadingstate.a() == com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState.State.a)
        {
            return DownloadGridItem.DownloadState.c;
        }
        if (downloadingstate.a() == com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState.State.b)
        {
            return DownloadGridItem.DownloadState.c;
        } else
        {
            return com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b;
        }
    }

    static DownloadGridItem.DownloadState a(PromoteLooksDialog promotelooksdialog, MakeupItemMetadata makeupitemmetadata)
    {
        return promotelooksdialog.a(makeupitemmetadata);
    }

    static DownloadItemUtility.UseTemplateTarget a(PromoteLooksDialog promotelooksdialog, DownloadItemUtility.UseTemplateTarget usetemplatetarget)
    {
        promotelooksdialog.j = usetemplatetarget;
        return usetemplatetarget;
    }

    private void a(Context context)
    {
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030188, this);
        a = (ViewPager)findViewById(0x7f0c06ba);
        c = new ai(this);
        f = com.cyberlink.youcammakeup.h.c();
        b(context);
    }

    private void a(View view, DownloadGridItem.DownloadState downloadstate)
    {
        if (view == null)
        {
            return;
        }
        Button button = (Button)view.findViewById(0x7f0c0584);
        View view1 = view.findViewById(0x7f0c0523);
        view = (ProgressBar)view.findViewById(0x7f0c0524);
        if (button == null || view1 == null || view == null)
        {
            com.pf.common.utility.m.e("DownloadLooksDialog", "downloadBtn == null || downloadContainer == null || progress == null");
            return;
        }
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[DownloadGridItem.DownloadState.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.e.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.DownloadState.b.ordinal()] = 2;
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
                    a[DownloadGridItem.DownloadState.a.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3.a[downloadstate.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            button.setEnabled(true);
            button.setText(0x7f070529);
            view1.setVisibility(8);
            return;

        case 5: // '\005'
            button.setEnabled(false);
            button.setText(0x7f070522);
            view1.setVisibility(8);
            return;

        case 2: // '\002'
            button.setEnabled(true);
            button.setText(0x7f07051a);
            view1.setVisibility(8);
            return;

        case 3: // '\003'
            button.setEnabled(true);
            button.setText(0x7f0703aa);
            view1.setVisibility(0);
            view.setProgress(0);
            return;

        case 4: // '\004'
            button.setEnabled(true);
            button.setText(0x7f0703c6);
            view1.setVisibility(8);
            return;
        }
    }

    private void a(TextView textview, MakeupItemMetadata makeupitemmetadata)
    {
        if (textview != null && makeupitemmetadata != null)
        {
            if (makeupitemmetadata.w() && makeupitemmetadata.x())
            {
                textview.setText(0x7f07044f);
                return;
            }
            if (makeupitemmetadata.w())
            {
                textview.setText(0x7f07044e);
                return;
            }
            if (makeupitemmetadata.x())
            {
                textview.setText(0x7f07044d);
                return;
            }
        }
    }

    static void a(PromoteLooksDialog promotelooksdialog, View view, DownloadGridItem.DownloadState downloadstate)
    {
        promotelooksdialog.a(view, downloadstate);
    }

    static void a(PromoteLooksDialog promotelooksdialog, TextView textview, MakeupItemMetadata makeupitemmetadata)
    {
        promotelooksdialog.a(textview, makeupitemmetadata);
    }

    static void a(PromoteLooksDialog promotelooksdialog, List list, com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
    {
        promotelooksdialog.a(list, activitytype);
    }

    private void a(List list, com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
    {
        e = new DownloadItemUtility(b, null, activitytype, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a);
        e.a(d);
        e.a(l);
        g = list;
        h = activitytype;
        e.c(list, new e() {

            final PromoteLooksDialog a;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list1)
            {
                if (list1 != null && list1.size() > 0)
                {
                    Globals.d(new Runnable(this, list1) {

                        final List a;
                        final _cls2 b;

                        public void run()
                        {
                            com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(b.a).b(a);
                            PromoteLooksDialog.a(b.a).setAdapter(com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(b.a));
                            PromoteLooksDialog.a(b.a).setOnPageChangeListener(PromoteLooksDialog.l(b.a));
                            PromoteLooksDialog.l(b.a).onPageSelected(0);
                            com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(b.a).notifyDataSetChanged();
                            b.a.invalidate();
                        }

            
            {
                b = _pcls2;
                a = list;
                super();
            }
                    });
                }
            }

            public void b(Object obj)
            {
                com.pf.common.utility.m.e("DownloadLooksDialog", (new StringBuilder()).append("[setDisplayLooks] getTemplateMetadata error: ").append(obj.toString()).toString());
                obj = (Activity)a.getContext();
                Globals.d().i().a(((Context) (obj)), com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.k(a), com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.m(a), PromoteLooksDialog.n(a), Globals.d().getResources().getString(0x7f070533));
            }

            public void c(Object obj)
            {
                com.pf.common.utility.m.b("DownloadLooksDialog", (new StringBuilder()).append("[setDisplayLooks] getTemplateMetadata cancel: ").append(obj.toString()).toString());
            }

            
            {
                a = PromoteLooksDialog.this;
                super();
            }
        });
    }

    static android.view.View.OnClickListener b(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.o;
    }

    private void b(Context context)
    {
        k k1 = new k(context, null);
        k1.g = false;
        k1.a(0.15F);
        d = new ag(context);
        d.a(((Activity)context).getFragmentManager(), k1);
    }

    private void b(MakeupItemMetadata makeupitemmetadata)
    {
        if (makeupitemmetadata != null)
        {
            boolean flag = bo.h(makeupitemmetadata.b());
            if (flag)
            {
                bo.a(makeupitemmetadata.b(), false);
            }
            if (flag)
            {
                Activity activity = (Activity)getContext();
                if (activity != null)
                {
                    Intent intent = (new Intent()).setFlags(0x4000000);
                    MakeupMode makeupmode = MakeupMode.a;
                    BeautyMode beautymode = BeautyMode.D;
                    if (makeupmode != null && beautymode != null)
                    {
                        DownloadUseUtils.a(false);
                        intent.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate(makeupitemmetadata.a(), makeupitemmetadata.b(), makeupmode, beautymode));
                        long l1 = StatusManager.j().l();
                        makeupitemmetadata = ViewEngine.a().a(l1, 1.0D, null);
                        if (j == DownloadItemUtility.UseTemplateTarget.c)
                        {
                            intent.setClass(activity, com/cyberlink/youcammakeup/activity/CameraActivity);
                        } else
                        if ((l1 > -1L || com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1)) && makeupitemmetadata != null)
                        {
                            intent.setClass(activity, com/cyberlink/youcammakeup/activity/EditViewActivity);
                        } else
                        {
                            makeupitemmetadata = new com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State("editView");
                            intent.setClass(activity, com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
                            intent.putExtra("LibraryPickerActivity_STATE", makeupitemmetadata);
                        }
                    }
                    if (intent.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/LibraryPickerActivity.getName()))
                    {
                        StatusManager.j().b(-1L);
                        StatusManager.j().a(-1L, null);
                        activity.startActivity(intent);
                        return;
                    }
                    if (intent.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/LibraryPickerActivity.getName()))
                    {
                        activity.startActivity(intent);
                        return;
                    } else
                    {
                        activity.startActivity(intent);
                        activity.finish();
                        return;
                    }
                }
            }
        }
    }

    static void b(PromoteLooksDialog promotelooksdialog, MakeupItemMetadata makeupitemmetadata)
    {
        promotelooksdialog.c(makeupitemmetadata);
    }

    static android.view.View.OnClickListener c(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.p;
    }

    private void c()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(c);
            networkmanager.a(c);
            networkmanager.a(c);
            networkmanager.a(c);
        }
    }

    private void c(MakeupItemMetadata makeupitemmetadata)
    {
        if (makeupitemmetadata == null)
        {
            return;
        }
        Object obj = a.findViewWithTag(makeupitemmetadata.m());
        View view = ((View) (obj)).findViewById(0x7f0c0523);
        if (view != null)
        {
            view.setVisibility(0);
        }
        obj = (ProgressBar)((View) (obj)).findViewById(0x7f0c0524);
        if (obj != null)
        {
            ((ProgressBar) (obj)).setProgress(0);
        }
        try
        {
            Globals.d().w().a(makeupitemmetadata.a(), b.b(), makeupitemmetadata, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MakeupItemMetadata makeupitemmetadata)
        {
            makeupitemmetadata.printStackTrace();
        }
    }

    static void c(PromoteLooksDialog promotelooksdialog, MakeupItemMetadata makeupitemmetadata)
    {
        promotelooksdialog.f(makeupitemmetadata);
    }

    static android.view.View.OnClickListener d(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.q;
    }

    private void d()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(c);
            networkmanager.b(c);
            networkmanager.b(c);
            networkmanager.b(c);
        }
    }

    static void d(PromoteLooksDialog promotelooksdialog, MakeupItemMetadata makeupitemmetadata)
    {
        promotelooksdialog.b(makeupitemmetadata);
    }

    private boolean d(MakeupItemMetadata makeupitemmetadata)
    {
        return makeupitemmetadata.x() && !makeupitemmetadata.w();
    }

    static DownloadItemUtility e(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.e;
    }

    private boolean e(MakeupItemMetadata makeupitemmetadata)
    {
        return !makeupitemmetadata.x() && makeupitemmetadata.w();
    }

    static android.view.View.OnClickListener f(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.r;
    }

    private void f(MakeupItemMetadata makeupitemmetadata)
    {
        if (k == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c || d(makeupitemmetadata))
        {
            j = DownloadItemUtility.UseTemplateTarget.c;
            b(makeupitemmetadata);
            return;
        }
        if (k == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.b || e(makeupitemmetadata))
        {
            j = com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.UseTemplateTarget.b;
            b(makeupitemmetadata);
            return;
        }
        makeupitemmetadata = a.findViewWithTag(makeupitemmetadata.m()).findViewById(0x7f0c0586);
        byte byte0;
        if (makeupitemmetadata.getVisibility() == 0)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        makeupitemmetadata.setVisibility(byte0);
        invalidate();
    }

    static android.view.View.OnClickListener g(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.t;
    }

    static android.view.View.OnClickListener h(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.s;
    }

    static aj i(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.b;
    }

    static List j(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.g;
    }

    static com.cyberlink.youcammakeup.Globals.ActivityType k(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.h;
    }

    static android.support.v4.view.ViewPager.OnPageChangeListener l(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.m;
    }

    static android.view.View.OnClickListener m(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.l;
    }

    static android.view.View.OnClickListener n(PromoteLooksDialog promotelooksdialog)
    {
        return promotelooksdialog.n;
    }

    public void a()
    {
        m.onPageSelected(a.getCurrentItem());
    }

    public void a(long l1, List list, com.cyberlink.youcammakeup.Globals.ActivityType activitytype, ak ak1)
    {
        b = new aj(this, l1, list);
        c();
        i = ak1;
        a(list, activitytype);
    }

    public void b()
    {
        a.removeAllViews();
        d();
        if (i != null)
        {
            i.a();
        }
    }

    public com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType getDisplayMakeupType()
    {
        return k;
    }

    public void setDisplayMakeupType(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        k = displaymakeuptype;
    }
}
