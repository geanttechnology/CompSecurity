// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.bestbuy.android.bbyobjects.ProductImageGallery;

class lang.Object
    implements android.view.OnClickListener
{

    final int a;
    final kn b;

    public void onClick(View view)
    {
        if (ProductImageGallery.b(b.c) != null)
        {
            ProductImageGallery.b(b.c).a(a);
        }
    }

    >(kn kn1, int i)
    {
        b = kn1;
        a = i;
        super();
    }
}
