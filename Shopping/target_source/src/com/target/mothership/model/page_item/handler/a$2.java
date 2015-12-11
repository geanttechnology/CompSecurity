// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import com.target.mothership.common.page_item.a;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.page_item.interfaces.Action;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.d.b.a.c;
import com.target.mothership.services.e.d.b.a.d;
import com.target.mothership.services.e.d.b.a.h;
import com.target.mothership.services.e.d.b.a.i;
import com.target.mothership.services.e.d.b.a.j;
import com.target.mothership.services.e.d.b.b;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.target.mothership.model.page_item.handler:
//            a, TGTAction, TGTCardSize, TGTCustomAction, 
//            TGTDigitalVendorMarketing, TGTDisplayDates, TGTImageInfo, TGTProductInfo, 
//            TGTTrackingInfo, TGTWeeklyAdInfo, TGTPageItem

class this._cls0
    implements aa
{

    final com.target.mothership.model.page_item.handler.a this$0;

    public PageItem a(b b1)
    {
        TGTAction tgtaction = (TGTAction)com.target.mothership.model.page_item.handler.a.b(com.target.mothership.model.page_item.handler.a.this).a(b1.a());
        TGTCardSize tgtcardsize = new TGTCardSize();
        tgtcardsize.a(com.target.mothership.common.page_item.a.a(b1.i()));
        Object obj = b1.b();
        TGTCustomAction tgtcustomaction;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        String s;
        TGTImageInfo tgtimageinfo;
        if (obj != null)
        {
            obj = com.target.mothership.model.page_item.handler.a.this.a(((com.target.mothership.services.e.d.b.a) (obj)));
        } else
        {
            obj = null;
        }
        tgtcustomaction = new TGTCustomAction();
        obj1 = b1.f();
        if (obj1 != null)
        {
            tgtcustomaction.a(((d) (obj1)).a());
            tgtcustomaction.a((ImageInfo)com.target.mothership.model.page_item.handler.a.c(com.target.mothership.model.page_item.handler.a.this).a(((d) (obj1)).c()));
            tgtcustomaction.b(((d) (obj1)).d());
            tgtcustomaction.a((Action)com.target.mothership.model.page_item.handler.a.b(com.target.mothership.model.page_item.handler.a.this).a(((d) (obj1)).e()));
            tgtcustomaction.b((Action)com.target.mothership.model.page_item.handler.a.b(com.target.mothership.model.page_item.handler.a.this).a(((d) (obj1)).f()));
            tgtcustomaction.a(com.target.mothership.common.page_item.b.a(((d) (obj1)).b()));
        } else
        {
            tgtcustomaction = null;
        }
        obj1 = new TGTDigitalVendorMarketing();
        obj2 = b1.c();
        if (obj2 != null)
        {
            ((TGTDigitalVendorMarketing) (obj1)).a(((com.target.mothership.services.e.d.b.a.b) (obj2)).a());
            ((TGTDigitalVendorMarketing) (obj1)).b(((com.target.mothership.services.e.d.b.a.b) (obj2)).b());
            ((TGTDigitalVendorMarketing) (obj1)).c(((com.target.mothership.services.e.d.b.a.b) (obj2)).c());
        } else
        {
            obj1 = null;
        }
        obj2 = new TGTDisplayDates();
        obj3 = b1.d();
        if (obj3 != null && (((c) (obj3)).a() != null || ((c) (obj3)).b() != null))
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
            simpledateformat.setTimeZone(TimeZone.getDefault());
            if (((c) (obj3)).a() != null)
            {
                ((TGTDisplayDates) (obj2)).a(simpledateformat.parse(((c) (obj3)).a(), new ParsePosition(0)));
            }
            if (((c) (obj3)).b() != null)
            {
                ((TGTDisplayDates) (obj2)).b(simpledateformat.parse(((c) (obj3)).b(), new ParsePosition(0)));
            }
        } else
        {
            obj2 = null;
        }
        s = b1.e();
        tgtimageinfo = (TGTImageInfo)com.target.mothership.model.page_item.handler.a.c(com.target.mothership.model.page_item.handler.a.this).a(b1.g());
        obj4 = new TGTProductInfo();
        obj5 = b1.h();
        if (obj5 != null && (((h) (obj5)).a() != null || ((h) (obj5)).b() != null))
        {
            String s1;
            if (((h) (obj5)).a() != null)
            {
                obj3 = new Tcin(((h) (obj5)).a());
            } else
            {
                obj3 = null;
            }
            ((TGTProductInfo) (obj4)).a(((Tcin) (obj3)));
            if (((h) (obj5)).b() != null)
            {
                obj3 = new Tcin(((h) (obj5)).b());
            } else
            {
                obj3 = null;
            }
            ((TGTProductInfo) (obj4)).b(((Tcin) (obj3)));
            obj3 = obj4;
        } else
        {
            obj3 = null;
        }
        s1 = b1.j();
        obj4 = new TGTTrackingInfo();
        obj5 = b1.k();
        if (obj5 != null)
        {
            ((TGTTrackingInfo) (obj4)).a(((i) (obj5)).a());
            ((TGTTrackingInfo) (obj4)).a(((i) (obj5)).b());
            ((TGTTrackingInfo) (obj4)).b(((i) (obj5)).c());
        } else
        {
            obj4 = null;
        }
        obj5 = new TGTWeeklyAdInfo();
        b1 = b1.l();
        if (b1 != null)
        {
            ((TGTWeeklyAdInfo) (obj5)).a((ImageInfo)com.target.mothership.model.page_item.handler.a.c(com.target.mothership.model.page_item.handler.a.this).a(b1.a()));
            ((TGTWeeklyAdInfo) (obj5)).a(b1.b());
            b1 = ((b) (obj5));
        } else
        {
            b1 = null;
        }
        obj5 = new TGTPageItem();
        ((TGTPageItem) (obj5)).a(tgtaction);
        ((TGTPageItem) (obj5)).a(tgtcardsize);
        ((TGTPageItem) (obj5)).a(((com.target.mothership.model.page_item.interfaces.PageItemCollection) (obj)));
        ((TGTPageItem) (obj5)).a(tgtcustomaction);
        ((TGTPageItem) (obj5)).a(((com.target.mothership.model.page_item.interfaces.DigitalVendorMarketing) (obj1)));
        ((TGTPageItem) (obj5)).a(((com.target.mothership.model.page_item.interfaces.DisplayDates) (obj2)));
        ((TGTPageItem) (obj5)).a(s);
        ((TGTPageItem) (obj5)).a(tgtimageinfo);
        ((TGTPageItem) (obj5)).a(((com.target.mothership.model.page_item.interfaces.ProductInfo) (obj3)));
        ((TGTPageItem) (obj5)).b(s1);
        ((TGTPageItem) (obj5)).a(((com.target.mothership.model.page_item.interfaces.TrackingInfo) (obj4)));
        ((TGTPageItem) (obj5)).a(b1);
        return ((PageItem) (obj5));
    }

    public volatile Object a(Object obj)
    {
        return a((b)obj);
    }

    ageItem()
    {
        this$0 = com.target.mothership.model.page_item.handler.a.this;
        super();
    }
}
