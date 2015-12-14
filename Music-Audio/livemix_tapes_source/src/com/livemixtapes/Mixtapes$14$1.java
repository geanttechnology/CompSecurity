// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import com.livemixtapes.adapter.ViewPagerCustomDuration;
import java.util.ArrayList;
import java.util.TimerTask;

// Referenced classes of package com.livemixtapes:
//            Mixtapes, MixtapesActivity

class val.data
    implements Runnable
{

    final ount this$1;
    private final ArrayList val$data;

    public void run()
    {
        if (pageCount <= val$data.size())
        {
            viewPager.setCurrentItem(pageCount, true);
            Mixtapes mixtapes = _fld0;
            mixtapes.pageCount = mixtapes.pageCount + 1;
            return;
        } else
        {
            pageCount = 0;
            viewPager.setCurrentItem(pageCount, true);
            return;
        }
    }

    l.data()
    {
        this$1 = final_data1;
        val$data = ArrayList.this;
        super();
    }

    // Unreferenced inner class com/livemixtapes/Mixtapes$14

/* anonymous class */
    class Mixtapes._cls14 extends TimerTask
    {

        final Mixtapes this$0;
        private final ArrayList val$data;

        public void run()
        {
            activity.runOnUiThread(data. new Mixtapes._cls14._cls1());
        }


            
            {
                this$0 = final_mixtapes;
                data = ArrayList.this;
                super();
            }
    }

}
