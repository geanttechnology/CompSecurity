// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.am;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, BeautyToolPanelItemAdapter, TemplateButton, p, 
//            r, b

class a
    implements p
{

    final BeautyMode a;
    final BeautyToolPanel b;

    public void a(AdapterView adapterview, View view, int i, long l)
    {
        if (!b.m) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (b.h != null && b.h.a())
        {
            o.c();
            b.i.a(b.h.c(), true);
            return;
        }
        adapterview = outType.b;
        if (view instanceof TemplateButton)
        {
            adapterview = ((TemplateButton)view).getLayoutType();
        }
        if (i != 0 || adapterview != outType.a || a != BeautyMode.l && a != BeautyMode.m && a != BeautyMode.x && !BeautyMode.d(a)) goto _L4; else goto _L3
_L3:
        String s;
        l = -1L;
        s = null;
        adapterview = CategoryType.e;
        if (a != BeautyMode.l) goto _L6; else goto _L5
_L5:
        l = CategoryType.a(CategoryType.e);
        s = b.getString(0x7f07033b);
        adapterview = CategoryType.e;
_L8:
        if (a == BeautyMode.z)
        {
            view = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
            view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(adapterview));
            view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", s);
            view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", adapterview);
            view.putExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", false);
            DownloadUseUtils.a(view, true);
            b.startActivity(view);
            return;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (a == BeautyMode.m)
        {
            l = CategoryType.a(CategoryType.f);
            s = b.getString(0x7f07033a);
            adapterview = CategoryType.f;
        } else
        if (a == BeautyMode.x)
        {
            l = CategoryType.a(CategoryType.o);
            s = b.getString(0x7f070501);
            adapterview = CategoryType.o;
        } else
        if (a == BeautyMode.z)
        {
            l = CategoryType.a(CategoryType.i);
            s = b.getString(0x7f07008c);
            adapterview = CategoryType.i;
        } else
        if (a == BeautyMode.A)
        {
            l = CategoryType.a(CategoryType.j);
            s = b.getString(0x7f07008d);
            adapterview = CategoryType.j;
        } else
        if (a == BeautyMode.B)
        {
            l = CategoryType.a(CategoryType.k);
            s = b.getString(0x7f07008e);
            adapterview = CategoryType.k;
        } else
        if (a == BeautyMode.C)
        {
            l = CategoryType.a(CategoryType.l);
            s = b.getString(0x7f07008b);
            adapterview = CategoryType.l;
        } else
        if (a == BeautyMode.t)
        {
            l = CategoryType.a(CategoryType.g);
            s = b.getString(0x7f07033d);
            adapterview = CategoryType.g;
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (l != 0x15ab1bL) goto _L10; else goto _L9
_L9:
        YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry..Source.b.a());
_L11:
        view = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", l);
        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", s);
        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", adapterview);
        view.putExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", false);
        view.putExtra("KEY_EXTRA_DOWNLOAD_HIDE_TOP_NEW_TAB", BeautyMode.d(a));
        DownloadUseUtils.a(view, true);
        b.startActivity(view);
        return;
_L10:
        if (l == 0x15ab1cL)
        {
            YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry..Source.c.a());
        }
        if (true) goto _L11; else goto _L4
_L4:
        adapterview = StatusManager.j().e();
        String s1 = b.h.a(i).c;
        if (a == BeautyMode.x && b.c != null && (b.c instanceof r))
        {
            ((r)b.c).a(adapterview, s1);
        }
        if ((a == BeautyMode.s || a == BeautyMode.t || BeautyMode.d(a)) && b.c != null && (b.c instanceof b))
        {
            ((b)b.c).a(adapterview, s1);
        }
        if (adapterview == null || !adapterview.equals(s1))
        {
            if (BeautyMode.d(a) && PanelDataCenter.a().b(s1).a() < 2)
            {
                b.d(false);
            }
            b.i.a(i, true);
            b.h.d(i);
            StatusManager.j().a(s1, false, new Float[0]);
            view.post(new Runnable(view, i) {

                final View a;
                final int b;
                final BeautyToolPanel._cls4 c;

                public void run()
                {
                    ((TemplateButton)a).a(false);
                    c.b.h.a(b, false);
                }

            
            {
                c = BeautyToolPanel._cls4.this;
                a = view;
                b = i;
                super();
            }
            });
            return;
        }
        if (true) goto _L1; else goto _L12
_L12:
    }

    _cls1.b(BeautyToolPanel beautytoolpanel, BeautyMode beautymode)
    {
        b = beautytoolpanel;
        a = beautymode;
        super();
    }
}
