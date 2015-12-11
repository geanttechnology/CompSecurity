// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import android.net.Uri;
import com.google.a.b.k;
import com.target.ui.fragment.cardstream.CardStreamOnClickHandler;
import com.target.ui.fragment.cardstream.b;
import com.target.ui.fragment.cardstream.c.f;
import com.target.ui.fragment.cardstream.f.e;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            b, a

public class g
    implements com.target.ui.fragment.cardstream.b.b
{

    private static final com.google.a.a.b sItemToViewtagenSet = new com.google.a.a.b() {

        public e a(com.target.ui.fragment.cardstream.c.e e1)
        {
            return e.a(0x7f100010).a(e1.offerDescription).e(0x7f100011).a(e1.barcodeValue).e(0x7f10000e).a(e1.barcodePngLocation.toString()).e(0x7f10000d).a(CardStreamOnClickHandler.a(e1.barcodeWebUri, e1.offerDescription)).a();
        }

        public volatile Object a(Object obj)
        {
            return a((com.target.ui.fragment.cardstream.c.e)obj);
        }

    };
    private final e mChrome = d();
    private final f mDataSource;

    public g(f f1)
    {
        mDataSource = f1;
    }

    private e a(List list)
    {
        return e.a(0x7f1000b8).a(0x7f030026, k.a(list, sItemToViewtagenSet)).a();
    }

    private e d()
    {
        return com.target.ui.fragment.cardstream.b.a.a(0x7f020058).a(a.sHideActionsList).b(0x7f100006).d(0).a();
    }

    public boolean a()
    {
        return mDataSource.g();
    }

    public com.google.a.a.e b()
    {
        Object obj = mDataSource.f();
        if (!((com.google.a.a.e) (obj)).b())
        {
            return com.google.a.a.e.e();
        }
        obj = (List)((com.google.a.a.e) (obj)).c();
        if (((List) (obj)).isEmpty())
        {
            return com.google.a.a.e.e();
        } else
        {
            obj = a(((List) (obj)));
            return com.google.a.a.e.b(new b(0x7f030027, mChrome, ((e) (obj)), c()));
        }
    }

    public com.target.ui.fragment.cardstream.e c()
    {
        return com.target.ui.fragment.cardstream.e.MOBILE_COUPONS;
    }

}
