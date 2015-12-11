// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import com.wishabi.flipp.b.x;
import com.wishabi.flipp.content.FlyerActivityIntent;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

// Referenced classes of package com.wishabi.flipp.app:
//            MainActivity

final class dk extends x
{

    final boolean a;
    final String b;
    final MainActivity c;

    dk(MainActivity mainactivity, boolean flag, String s)
    {
        c = mainactivity;
        a = flag;
        b = s;
        super();
    }

    public final void a()
    {
        MainActivity.c(c).setVisibility(8);
        MainActivity.c(c).setRefreshing(false);
    }

    public final void a(boolean flag)
    {
        if (MainActivity.d(c) != null)
        {
            Object obj;
            try
            {
                obj = Uri.parse(MainActivity.d(c));
                obj = c.getContentResolver().query(((Uri) (obj)), null, "postal_code = ?", new String[] {
                    b
                }, null);
            }
            catch (Exception exception)
            {
                exception = null;
            }
            if (obj != null && ((Cursor) (obj)).getCount() > 0)
            {
                ((Cursor) (obj)).moveToFirst();
                FlyerActivityIntent flyeractivityintent = new FlyerActivityIntent(c.getApplicationContext(), ((Cursor) (obj)));
                c.startActivity(flyeractivityintent);
                c.overridePendingTransition(0x7f040001, 0x7f040002);
                ((Cursor) (obj)).close();
            }
        }
        MainActivity.e(c);
        MainActivity.c(c).setVisibility(8);
        MainActivity.c(c).setRefreshing(false);
        MainActivity.f(c);
    }

    public final void b()
    {
        if (a)
        {
            MainActivity.c(c).setVisibility(0);
            MainActivity.b(c).a(false);
        }
        MainActivity.c(c).setRefreshing(true);
    }
}
