// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.widget.ListView;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.hockeyapp.android.a.a;
import net.hockeyapp.android.c.b;
import net.hockeyapp.android.c.c;
import net.hockeyapp.android.c.d;

// Referenced classes of package net.hockeyapp.android:
//            FeedbackActivity

final class n
    implements Runnable
{

    final d a;
    final FeedbackActivity b;

    n(FeedbackActivity feedbackactivity, d d1)
    {
        b = feedbackactivity;
        a = d1;
        super();
    }

    public final void run()
    {
        b.a(true);
        Object obj1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMM h:mm a");
        if (a != null && a.b != null && a.b.e != null && a.b.e.size() > 0)
        {
            net.hockeyapp.android.FeedbackActivity.a(b, a.b.e);
            Collections.reverse(FeedbackActivity.e(b));
            try
            {
                obj1 = ((SimpleDateFormat) (obj1)).parse(((c)FeedbackActivity.e(b).get(0)).f);
                FeedbackActivity.f(b).setText(String.format("Last Updated: %s", new Object[] {
                    simpledateformat.format(((java.util.Date) (obj1)))
                }));
            }
            catch (ParseException parseexception)
            {
                parseexception.printStackTrace();
            }
            if (FeedbackActivity.g(b) == null)
            {
                net.hockeyapp.android.FeedbackActivity.a(b, new a(net.hockeyapp.android.FeedbackActivity.c(b), FeedbackActivity.e(b)));
            } else
            {
                Object obj = FeedbackActivity.g(b);
                if (((a) (obj)).a != null)
                {
                    ((a) (obj)).a.clear();
                }
                obj = FeedbackActivity.e(b).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    c c1 = (c)((Iterator) (obj)).next();
                    a a1 = FeedbackActivity.g(b);
                    if (c1 != null && a1.a != null)
                    {
                        a1.a.add(c1);
                    }
                } while (true);
                FeedbackActivity.g(b).notifyDataSetChanged();
            }
            FeedbackActivity.h(b).setAdapter(FeedbackActivity.g(b));
        }
    }
}
