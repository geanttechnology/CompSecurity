// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import com.socialin.android.dialog.g;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView

final class d extends Thread
{

    final TemplateActivity a;
    private String b[];
    private int c[];
    private ArrayList d;

    public final void run()
    {
        TemplateActivity.b(a).setImages(b, c, d);
        a.runOnUiThread(new Runnable() {

            private TemplateActivity._cls2 a;

            public final void run()
            {
                TemplateActivity.b(a.a).invalidate();
                a.a.a.dismiss();
            }

            
            {
                a = TemplateActivity._cls2.this;
                super();
            }
        });
    }

    _cls1.a(TemplateActivity templateactivity, String as[], int ai[], ArrayList arraylist)
    {
        a = templateactivity;
        b = as;
        c = ai;
        d = arraylist;
        super();
    }
}
