// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.utility.o;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            PromoteLooksDialog, aj

class a
    implements Runnable
{

    final List a;
    final lidate b;

    public void run()
    {
        PromoteLooksDialog.i(b.b).b(a);
        PromoteLooksDialog.a(b.b).setAdapter(PromoteLooksDialog.i(b.b));
        PromoteLooksDialog.a(b.b).setOnPageChangeListener(PromoteLooksDialog.l(b.b));
        PromoteLooksDialog.l(b.b).onPageSelected(0);
        PromoteLooksDialog.i(b.b).notifyDataSetChanged();
        b.b.invalidate();
    }

    ( , List list)
    {
        b = ;
        a = list;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/PromoteLooksDialog$2

/* anonymous class */
    class PromoteLooksDialog._cls2
        implements e
    {

        final PromoteLooksDialog a;

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            if (list != null && list.size() > 0)
            {
                Globals.d(new PromoteLooksDialog._cls2._cls1(this, list));
            }
        }

        public void b(Object obj)
        {
            m.e("DownloadLooksDialog", (new StringBuilder()).append("[setDisplayLooks] getTemplateMetadata error: ").append(obj.toString()).toString());
            obj = (Activity)a.getContext();
            Globals.d().i().a(((android.content.Context) (obj)), PromoteLooksDialog.k(a), com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.m(a), PromoteLooksDialog.n(a), Globals.d().getResources().getString(0x7f070533));
        }

        public void c(Object obj)
        {
            m.b("DownloadLooksDialog", (new StringBuilder()).append("[setDisplayLooks] getTemplateMetadata cancel: ").append(obj.toString()).toString());
        }

            
            {
                a = promotelooksdialog;
                super();
            }
    }

}
