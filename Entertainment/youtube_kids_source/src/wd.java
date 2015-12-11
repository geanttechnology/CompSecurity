// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.google.android.apps.youtube.kids.activities.BrowseActivity;

public final class wd
    implements byb
{

    final BrowseActivity a;

    public wd(BrowseActivity browseactivity)
    {
        a = browseactivity;
        super();
    }

    public final void a()
    {
        if (BrowseActivity.a(a))
        {
            BrowseActivity.b(a).b(a.getIntent());
            String s = BrowseActivity.b(a).a(a.getIntent());
            BrowseActivity.a(a, s);
            return;
        } else
        {
            a.l();
            (new Handler()).postDelayed(new we(this), 100L);
            return;
        }
    }
}
