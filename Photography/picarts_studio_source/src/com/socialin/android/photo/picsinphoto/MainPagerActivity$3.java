// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.d;
import com.socialin.android.util.ab;
import myobfuscated.bn.a;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a extends Thread
{

    final MainPagerActivity a;

    public final void run()
    {
label0:
        {
            if (Inventory.isAdsEnabled())
            {
                if (!myobfuscated.bn.a.a(a))
                {
                    break label0;
                }
                d.b(MainPagerActivity.e(), new Object[] {
                    "Vaelil FS es anqam."
                });
                a.runOnUiThread(new Runnable() {

                    public final void run()
                    {
                    }

                });
                try
                {
                    Thread.sleep(4000L);
                }
                catch (InterruptedException interruptedexception)
                {
                    d.b(MainPagerActivity.e(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(interruptedexception.getMessage()).toString()
                    });
                }
                a.runOnUiThread(new Runnable() {

                    private MainPagerActivity._cls3 a;

                    public final void run()
                    {
                        DialogUtils.openInfoDialog("", a.a.getString(0x7f0802a9), "", a.a.getString(0x7f080569), a.a, Integer.valueOf(0));
                    }

            
            {
                a = MainPagerActivity._cls3.this;
                super();
            }
                });
            }
            return;
        }
        a.runOnUiThread(new Runnable() {

            private MainPagerActivity._cls3 a;

            public final void run()
            {
                ab.a(a.a, 2);
            }

            
            {
                a = MainPagerActivity._cls3.this;
                super();
            }
        });
    }

    _cls3.a(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}
