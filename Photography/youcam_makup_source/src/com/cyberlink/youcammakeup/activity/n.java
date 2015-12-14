// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            OpeningTutorialActivity, o, LauncherActivity

class n extends PagerAdapter
{

    final OpeningTutorialActivity a;
    private final int b[] = {
        0x7f03015e, 0x7f03015f, 0x7f03015d, 0x7f03015a, 0x7f03015b
    };

    private n(OpeningTutorialActivity openingtutorialactivity)
    {
        a = openingtutorialactivity;
        super();
    }

    n(OpeningTutorialActivity openingtutorialactivity, OpeningTutorialActivity._cls1 _pcls1)
    {
        this(openingtutorialactivity);
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return b.length;
    }

    public int getItemPosition(Object obj)
    {
        return -1;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        Object obj = LayoutInflater.from(a.getApplicationContext());
        i = b[i];
        obj = ((LayoutInflater) (obj)).inflate(i, null);
        if (i == 0x7f03015b)
        {
            ((View) (obj)).findViewById(0x7f0c0633).setOnClickListener(new android.view.View.OnClickListener() {

                final n a;

                public void onClick(View view)
                {
                    OpeningTutorialActivity.b(a.a).a();
                    view = new Intent(a.a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
                    a.a.startActivity(view);
                    a.a.finish();
                }

            
            {
                a = n.this;
                super();
            }
            });
        }
        viewgroup.addView(((View) (obj)));
        return obj;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
