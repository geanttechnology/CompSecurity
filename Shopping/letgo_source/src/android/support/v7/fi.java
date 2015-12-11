// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.os.AsyncTask;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.ui.fragments.h;
import com.abtnprojects.ambatana.ui.fragments.i;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7:
//            fx, gf

public class fi extends AsyncTask
{

    public final String a = android/support/v7/fi.getSimpleName();
    protected final WeakReference b;
    protected final int c;
    protected final String d;
    protected final String e;
    protected final h f;
    private final i g;
    private final com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b h;
    private final String i;
    private final fx j = new fx();
    private final LatitudeLongitude k;
    private final CountryCurrencyInfo l;
    private String m;

    public fi(i i1, int j1, String s, String s1, Activity activity, h h1, com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b b1, 
            String s2, LatitudeLongitude latitudelongitude, CountryCurrencyInfo countrycurrencyinfo)
    {
        c = j1;
        d = s;
        e = s1;
        l = countrycurrencyinfo;
        b = new WeakReference(activity);
        f = h1;
        g = i1;
        h = b1;
        i = s2;
        k = latitudelongitude;
        m = ParseUser.getCurrentUser().getSessionToken();
    }

    protected transient gf a(Void avoid[])
    {
        avoid = (Activity)b.get();
        if (g.j() == null || i == null || avoid == null)
        {
            return null;
        }
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b.values().length];
                try
                {
                    a[com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[h.ordinal()])
        {
        default:
            return j.a(avoid, l, m, i);

        case 1: // '\001'
            return j.c(c, avoid, l, m, i, d);

        case 2: // '\002'
            return j.b(c, avoid, l, m, i, d);
        }
    }

    protected void a(gf gf1)
    {
        if (f != null && f.n())
        {
            f.a(gf1);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((gf)obj);
    }
}
