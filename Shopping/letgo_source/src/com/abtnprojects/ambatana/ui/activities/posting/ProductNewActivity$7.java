// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;


// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            ProductNewActivity

class a
    implements Runnable
{

    final String a;
    final ProductNewActivity b;

    public void run()
    {
        ProductNewActivity.a(b, a);
        b.setResult(-1);
        b.finish();
    }

    (ProductNewActivity productnewactivity, String s)
    {
        b = productnewactivity;
        a = s;
        super();
    }
}
