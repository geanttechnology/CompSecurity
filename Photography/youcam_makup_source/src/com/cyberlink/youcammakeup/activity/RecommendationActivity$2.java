// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.a.a;
import com.cyberlink.youcammakeup.database.a.b;
import com.cyberlink.youcammakeup.database.a.c;
import com.cyberlink.youcammakeup.utility.j;
import com.cyberlink.youcammakeup.utility.k;
import com.cyberlink.youcammakeup.utility.o;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            RecommendationActivity

class b
    implements k
{

    final a a;
    final j b;
    final RecommendationActivity c;

    public void a()
    {
        boolean flag = false;
        Globals.d().i().h(c);
        LinearLayout linearlayout = (LinearLayout)View.inflate(c, 0x7f030201, null);
        LinearLayout linearlayout1 = (LinearLayout)linearlayout.findViewById(0x7f0c08d7);
        linearlayout.setId(((Integer)com.cyberlink.youcammakeup.activity.RecommendationActivity.b(c).get(a.a().a())).intValue());
        ((TextView)linearlayout.findViewById(0x7f0c08d8)).setText(((c)a.b().get(0)).d());
        ((TextView)linearlayout.findViewById(0x7f0c08d9)).setText(((c)a.b().get(0)).e());
        android.widget.mmendationActivity mmendationactivity = new android.widget.<init>(-1, -1, 80);
        b.a(linearlayout1, mmendationactivity);
        int i = 0;
        do
        {
            if (i >= com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildCount() || linearlayout.getId() < com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildAt(i).getId())
            {
                com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).addView(linearlayout, i);
                i = ((flag) ? 1 : 0);
                while (i < com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildCount()) 
                {
                    if (i % 2 == 0)
                    {
                        com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildAt(i).setBackgroundColor(0xfff8f8f8);
                    } else
                    {
                        com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildAt(i).setBackgroundColor(-1);
                    }
                    i++;
                }
                break;
            }
            i++;
        } while (true);
        RecommendationActivity.d(c).setVisibility(8);
    }

    public void b()
    {
        RecommendationActivity.e(c);
    }

    (RecommendationActivity recommendationactivity, a a1, j j1)
    {
        c = recommendationactivity;
        a = a1;
        b = j1;
        super();
    }
}
