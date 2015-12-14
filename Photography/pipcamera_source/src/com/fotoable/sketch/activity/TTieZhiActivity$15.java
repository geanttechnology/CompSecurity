// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;


// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements Runnable
{

    final TTieZhiActivity a;

    public void run()
    {
        a.h = a.b();
        if (a.h == null);
        a.runOnUiThread(new Runnable() {

            final TTieZhiActivity._cls15 a;

            public void run()
            {
                TTieZhiActivity.a(a.a, false, "");
                TTieZhiActivity.e(a.a);
            }

            
            {
                a = TTieZhiActivity._cls15.this;
                super();
            }
        });
    }

    _cls1.a(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }
}
