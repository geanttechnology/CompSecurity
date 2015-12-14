// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.i;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.a;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.an;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            n, DownloadItemUtility, p, DownloadGridItem, 
//            q

class a
    implements n
{

    final DownloadItemUtility a;

    public void a(View view)
    {
        Object obj1 = (p)view.getTag();
        if (((p) (obj1)).b() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        DownloadGridItem downloadgriditem;
        MakeupItemMetadata makeupitemmetadata;
        long l;
        l = ((p) (obj1)).b().longValue();
        int j = ((p) (obj1)).a();
        m.b("DownloadItemUtility", (new StringBuilder()).append("onItemClick, tid:").append(l).toString());
        downloadgriditem = (DownloadGridItem)view;
        makeupitemmetadata = com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(a).b(j);
        obj = com.cyberlink.youcammakeup.pages.moreview.DownloadItemUtility.a(a).d();
        if (((p) (obj1)).c() == oadState.c)
        {
            a.a(makeupitemmetadata);
            ((p) (obj1)).a(com.cyberlink.youcammakeup.pages.moreview.oadState.b);
            downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.oadState.b);
            return;
        }
        if (((p) (obj1)).c() != oadState.d) goto _L4; else goto _L3
_L3:
        boolean flag;
        if (DownloadItemUtility.d(a) == com.cyberlink.youcammakeup. && (obj == CategoryType.c || obj == CategoryType.b))
        {
            b.a(new YMKLooksStoreEvent(com.cyberlink.youcammakeup.clflurry.ration.d, makeupitemmetadata.b(), null));
        } else
        if (DownloadItemUtility.d(a) == com.cyberlink.youcammakeup. && (obj == CategoryType.c || obj == CategoryType.b))
        {
            b.a(new YMKLooksCategoryEvent(com.cyberlink.youcammakeup.clflurry.Operation.d, makeupitemmetadata.b(), makeupitemmetadata.c()));
        }
        YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.t.Source.e.a());
        if (obj == CategoryType.d)
        {
            boolean flag1 = bo.f(makeupitemmetadata.b());
            flag = flag1;
            if (flag1)
            {
                bo.c(makeupitemmetadata.b(), false);
                flag = flag1;
            }
        } else
        if (obj == CategoryType.b || obj == CategoryType.c)
        {
            boolean flag2;
            if (obj == CategoryType.b)
            {
                YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.rce.f.a());
            } else
            {
                YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.rce.g.a());
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
            obj1 = (Activity)view.getContext();
            if (obj1 != null)
            {
                Intent intent = (new Intent()).setFlags(0x4000000);
                if (obj == CategoryType.d)
                {
                    view = MakeupMode.d;
                    obj = BeautyMode.n;
                } else
                if (obj == CategoryType.f)
                {
                    view = MakeupMode.d;
                    obj = BeautyMode.m;
                } else
                if (obj == CategoryType.e)
                {
                    view = MakeupMode.d;
                    obj = BeautyMode.l;
                } else
                if (obj == CategoryType.b || obj == CategoryType.c)
                {
                    view = MakeupMode.a;
                    obj = BeautyMode.D;
                } else
                if (obj == CategoryType.o)
                {
                    view = MakeupMode.b;
                    obj = BeautyMode.x;
                } else
                if (obj == CategoryType.i)
                {
                    view = MakeupMode.f;
                    obj = BeautyMode.D;
                } else
                if (obj == CategoryType.j)
                {
                    view = MakeupMode.f;
                    obj = BeautyMode.D;
                } else
                if (obj == CategoryType.k)
                {
                    view = MakeupMode.f;
                    obj = BeautyMode.D;
                } else
                if (obj == CategoryType.l)
                {
                    view = MakeupMode.f;
                    obj = BeautyMode.D;
                } else
                if (obj == CategoryType.m)
                {
                    view = MakeupMode.f;
                    obj = BeautyMode.D;
                } else
                {
                    obj = null;
                    view = null;
                }
                if (view != null && obj != null)
                {
                    DownloadUseUtils.a(false);
                    intent.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.mplate(l, makeupitemmetadata.b(), view, ((BeautyMode) (obj))));
                    l = StatusManager.j().l();
                    view = ViewEngine.a().a(l, 1.0D, null);
                    if (downloadgriditem.getUseTemplateTarget() == eTemplateTarget.c)
                    {
                        intent.setClass(((android.content.Context) (obj1)), com/cyberlink/youcammakeup/activity/CameraActivity);
                    } else
                    if ((l > -1L || i.a(l)) && view != null)
                    {
                        intent.setClass(((android.content.Context) (obj1)), com/cyberlink/youcammakeup/activity/EditViewActivity);
                    } else
                    {
                        view = new com.cyberlink.youcammakeup.activity.State("editView");
                        intent.setClass(((android.content.Context) (obj1)), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
                        intent.putExtra("LibraryPickerActivity_STATE", view);
                        view = ((Activity) (obj1)).getIntent().getData();
                        if (view != null && com.cyberlink.youcammakeup.utility.a.a(view.toString()))
                        {
                            intent.putExtra("EXTRA_KEY_TEMPLATE_DEEPLINK_URI", view.toString());
                            intent.setFlags(32768);
                        }
                    }
                }
                DownloadUseUtils.a(((Activity) (obj1)).getIntent(), intent);
                if (intent.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/LibraryPickerActivity.getName()))
                {
                    StatusManager.j().b(-1L);
                    StatusManager.j().a(-1L, null);
                    ((Activity) (obj1)).startActivity(intent);
                    return;
                }
                if (intent.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/CameraActivity.getName()))
                {
                    ((Activity) (obj1)).startActivity(intent);
                    return;
                } else
                {
                    ((Activity) (obj1)).startActivity(intent);
                    ((Activity) (obj1)).finish();
                    return;
                }
            }
        }
_L10:
        if (true) goto _L1; else goto _L4
_L4:
        if (makeupitemmetadata.k()) goto _L6; else goto _L5
_L5:
        if (DownloadItemUtility.d(a) != com.cyberlink.youcammakeup. || obj != CategoryType.c && obj != CategoryType.b) goto _L8; else goto _L7
_L7:
        b.a(new YMKLooksStoreEvent(com.cyberlink.youcammakeup.clflurry.ration.c, makeupitemmetadata.b(), null));
_L9:
        ((p) (obj1)).a(oadState.c);
        downloadgriditem.setDownloadBtnState(oadState.c);
        a.a(downloadgriditem, makeupitemmetadata);
        a.b();
        return;
_L8:
        if (DownloadItemUtility.d(a) == com.cyberlink.youcammakeup. && (obj == CategoryType.c || obj == CategoryType.b))
        {
            b.a(new YMKLooksCategoryEvent(com.cyberlink.youcammakeup.clflurry.Operation.c, makeupitemmetadata.b(), makeupitemmetadata.c()));
        }
        if (true) goto _L9; else goto _L6
_L6:
        view = Globals.d().a(DownloadItemUtility.d(a));
        if (makeupitemmetadata.p().size() > 0)
        {
            Globals.d().a(makeupitemmetadata);
            o.a(view, an.a(makeupitemmetadata), "ShareToUnlockDialog");
            return;
        }
          goto _L10
    }

    ion(DownloadItemUtility downloaditemutility)
    {
        a = downloaditemutility;
        super();
    }
}
