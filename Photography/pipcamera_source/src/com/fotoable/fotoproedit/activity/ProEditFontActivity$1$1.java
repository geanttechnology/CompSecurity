// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.widget.FrameLayout;
import android.widget.ImageView;
import gm;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        if (ProEditFontActivity.a(a.a) == null)
        {
            a.a.finish();
            return;
        } else
        {
            ProEditFontActivity.b(a.a).setImageBitmap(ProEditFontActivity.a(a.a));
            ProEditFontActivity.c(a.a);
            ProEditFontActivity.d(a.a);
            ProEditFontActivity.e(a.a).setVisibility(8);
            return;
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/fotoable/fotoproedit/activity/ProEditFontActivity$1

/* anonymous class */
    class ProEditFontActivity._cls1
        implements Runnable
    {

        final ProEditFontActivity a;

        public void run()
        {
            for (int i = 0; ProEditFontActivity.a(a) == null && i < 6; ProEditFontActivity.a(a, gm.c().k()))
            {
                i++;
            }

            a.runOnUiThread(new ProEditFontActivity._cls1._cls1(this));
        }

            
            {
                a = proeditfontactivity;
                super();
            }
    }

}
