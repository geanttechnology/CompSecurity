// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import android.widget.ListView;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableScrollView;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment

class a
    implements Runnable
{

    final View a;
    final w.setSelection b;

    public void run()
    {
        ((CLMultiColumnListView)a).setSelection(0);
    }

    a(a a1, View view)
    {
        b = a1;
        a = view;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/BottomBarFragment$17

/* anonymous class */
    class BottomBarFragment._cls17
        implements android.view.View.OnClickListener
    {

        final BottomBarFragment a;

        public void onClick(View view)
        {
            Iterator iterator = BottomBarFragment.b(a).entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                if (view.equals(((java.util.Map.Entry) (obj)).getValue()))
                {
                    obj = (View)((java.util.Map.Entry) (obj)).getKey();
                    if (obj != null)
                    {
                        view.setTag(j.to_top_btn, Boolean.valueOf(true));
                        if (obj instanceof ListView)
                        {
                            int i = ((ListView)obj).getFirstVisiblePosition();
                            BottomBarFragment.a(a, true);
                            if (i > 4)
                            {
                                ((ListView)obj).setSelection(4);
                            }
                            ((ListView)obj).smoothScrollToPositionFromTop(0, 0);
                            ((ListView)obj).postDelayed(new BottomBarFragment._cls17._cls1(((View) (obj))), 300L);
                        } else
                        if (obj instanceof ObservableScrollView)
                        {
                            ((ObservableScrollView)obj).scrollTo(0, 0);
                        } else
                        if (obj instanceof CLMultiColumnListView)
                        {
                            int k = ((CLMultiColumnListView)obj).getFirstVisiblePosition();
                            BottomBarFragment.a(a, true);
                            if (k > 4)
                            {
                                ((CLMultiColumnListView)obj).setSelection(4);
                            }
                            ((CLMultiColumnListView)obj).b(0, 0);
                            ((CLMultiColumnListView)obj).postDelayed(new BottomBarFragment._cls17._cls2(this, ((View) (obj))), 300L);
                        }
                    }
                }
            } while (true);
        }

            
            {
                a = bottombarfragment;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/BottomBarFragment$17$1

/* anonymous class */
        class BottomBarFragment._cls17._cls1
            implements Runnable
        {

            final View a;
            final BottomBarFragment._cls17 b;

            public void run()
            {
                ((ListView)a).setSelection(0);
            }

                    
                    {
                        b = BottomBarFragment._cls17.this;
                        a = view;
                        super();
                    }
        }

    }

}
