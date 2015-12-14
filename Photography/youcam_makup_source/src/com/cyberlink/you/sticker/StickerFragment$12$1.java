// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Adapter;
import com.cyberlink.you.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.you.widgetpool.clhorizontalgridview.p;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, a, i

class a
    implements Runnable
{

    final d a;

    public void run()
    {
        StickerFragment.h(a.a).notifyDataSetChanged();
    }

    ew.AdapterView(ew.AdapterView adapterview)
    {
        a = adapterview;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/sticker/StickerFragment$12

/* anonymous class */
    class StickerFragment._cls12
        implements p
    {

        final StickerFragment a;

        public void a(AdapterView adapterview, View view, int j, long l)
        {
            adapterview = (EmojiHelper.EmojiCategory)adapterview.getAdapter().getItem(j);
            if (adapterview != null)
            {
                adapterview = (PagerAdapter)StickerFragment.f(a).get(adapterview.toString());
                if (adapterview != null)
                {
                    StickerFragment.e(a).setAdapter(adapterview);
                    StickerFragment.g(a).a(a.getActivity());
                }
            }
            StickerFragment.h(a).a(j);
            adapterview = a.getActivity();
            if (adapterview != null)
            {
                adapterview.runOnUiThread(new StickerFragment._cls12._cls1(this));
            }
        }

            
            {
                a = stickerfragment;
                super();
            }
    }

}
