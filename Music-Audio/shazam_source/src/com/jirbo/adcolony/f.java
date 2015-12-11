// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            aj, q, n, ac, 
//            ar, aa, af

public final class f
{
    private static final class a extends AsyncTask
    {

        Activity a;
        String b;
        boolean c;

        private transient Void a()
        {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
            try
            {
                info = AdvertisingIdClient.getAdvertisingIdInfo(a);
            }
            catch (NoClassDefFoundError noclassdeffounderror)
            {
                aj.d.b("Google Play Services SDK not installed! Collecting Android Id instead of Advertising Id.");
                return null;
            }
            catch (NoSuchMethodError nosuchmethoderror)
            {
                aj.d.b("Google Play Services SDK is out of date! Collecting Android Id instead of Advertising Id.");
                return null;
            }
            catch (Exception exception)
            {
                aj.d.b("Advertising Id not available! Collecting Android Id instead of Advertising Id.");
                exception.printStackTrace();
                return null;
            }
            b = info.getId();
            c = info.isLimitAdTrackingEnabled();
            return null;
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a();
        }

        protected final void onPostExecute(Object obj)
        {
            af.a = b;
            af.b = c;
            f.a = true;
        }

        public a(Activity activity)
        {
            b = "";
            a = activity;
        }
    }


    public static boolean a;

    public static void a()
    {
        aj.c.b("[ADC] AdColony pause called.");
        q.k = true;
        for (int i = 0; i < q.X.size(); i++)
        {
            if (q.X.get(i) == null)
            {
                continue;
            }
            n n1 = (n)q.X.get(i);
            n1.u = true;
            if (n1.S == null || n1.p || !n1.S.isPlaying())
            {
                continue;
            }
            if (q.m)
            {
                n1.I.setVisibility(0);
            }
            if (!n1.p && n1.S != null && n1.S.isPlaying() && !n1.q)
            {
                q.c.d.a("video_paused", null, n1.D);
                n1.S.pause();
            }
        }

    }

    public static void a(Activity activity)
    {
        aj.c.b("[ADC] AdColony resume called.");
        q.k = false;
        q.a(activity);
        q.j = false;
        if (activity == null)
        {
            aj.d.b("Activity reference is null. Disabling AdColony.");
            q.h = true;
            return;
        } else
        {
            (new Thread(new Runnable(activity) {

                final Activity a;

                public final void run()
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls2 a;

                        public final void run()
                        {
                            for (int i = 0; i < q.X.size(); i++)
                            {
                                n n1 = (n)q.X.get(i);
                                if (n1 == null || q.b() != n1.a || n1.p)
                                {
                                    continue;
                                }
                                n1.u = false;
                                n1.invalidate();
                                if (n1.I != null)
                                {
                                    n1.I.a = false;
                                    n1.I.invalidate();
                                }
                            }

                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                }

            
            {
                a = activity;
                super();
            }
            })).start();
            q.u = false;
            return;
        }
    }

    public static boolean a(String s)
    {
        if (q.c != null && q.c.b != null && q.c.b.j != null && q.c.b.j.n != null)
        {
            aa aa1 = q.c.b;
            int i = 0;
            while (i < aa1.j.n.a.size()) 
            {
                al.c c = aa1.j.n.a(i);
                if (c.b(false) && c.a.equals(s))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static boolean b(String s)
    {
        if (q.c != null && q.c.b != null && q.c.b.j != null && q.c.b.j.n != null && q.c.b.j.n.a(s) != null && q.c.b.j.n.a(s).i != null && q.c.b.j.n.a(s).i.a != null)
        {
            int i = 0;
            while (i < q.c.b.j.n.a(s).i.a.size()) 
            {
                if (q.c.b.j.n.a(s).i.a(i).v.a)
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    // Unreferenced inner class com/jirbo/adcolony/f$1

/* anonymous class */
    public static final class _cls1
        implements Runnable
    {

        public final void run()
        {
            q.p = false;
        }

    }

}
