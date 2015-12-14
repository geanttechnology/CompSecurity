// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import com.socialin.android.dialog.g;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        TemplateActivity.b(a.a).invalidate();
        a.a.a.dismiss();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/template/TemplateActivity$2

/* anonymous class */
    final class TemplateActivity._cls2 extends Thread
    {

        final TemplateActivity a;
        private String b[];
        private int c[];
        private ArrayList d;

        public final void run()
        {
            TemplateActivity.b(a).setImages(b, c, d);
            a.runOnUiThread(new TemplateActivity._cls2._cls1(this));
        }

            
            {
                a = templateactivity;
                b = as;
                c = ai;
                d = arraylist;
                super();
            }
    }

}
