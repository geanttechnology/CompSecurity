// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            gi, hi, hj, hk, 
//            hl, hn, hm

public class gh
    implements gi
{

    private final List a = new ArrayList(3);

    public gh()
    {
        a.add(new hi());
        a.add(new hj());
        a.add(new hk());
        a.add(new hl());
        a.add(new hn());
        a.add(new hm());
    }

    public void a()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).a()) { }
    }

    public void a(Activity activity)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).a(activity)) { }
    }

    public void a(Application application)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).a(application)) { }
    }

    public void a(Context context, String s, Map map, ParseUser parseuser)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).a(context, s, map, parseuser)) { }
    }

    public void a(ParseUser parseuser)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).a(parseuser)) { }
    }

    public void b()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).b()) { }
    }

    public void b(Activity activity)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).b(activity)) { }
    }

    public void b(Context context, String s, Map map, ParseUser parseuser)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).b(context, s, map, parseuser)) { }
    }

    public void c(Activity activity)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).c(activity)) { }
    }

    public void d(Activity activity)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).d(activity)) { }
    }

    public void e(Activity activity)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).e(activity)) { }
    }

    public void f(Activity activity)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((gi)iterator.next()).f(activity)) { }
    }
}
