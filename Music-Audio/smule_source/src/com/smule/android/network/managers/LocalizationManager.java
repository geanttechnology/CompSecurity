// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.android.f.p;
import com.smule.android.f.q;
import com.smule.android.network.a.j;
import com.smule.android.network.core.a;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.a.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

// Referenced classes of package com.smule.android.network.managers:
//            n, m

public class LocalizationManager
{

    private static final String a = com/smule/android/network/managers/LocalizationManager.getName();
    private static LocalizationManager b = null;
    private Context c;
    private j d;
    private Map e;

    private LocalizationManager(Context context)
    {
        c = context;
        d = j.a(context);
        e = new HashMap();
    }

    static Context a(LocalizationManager localizationmanager)
    {
        return localizationmanager.c;
    }

    public static LocalizationManager a()
    {
        return b;
    }

    public static void a(Context context)
    {
        b = new LocalizationManager(context);
    }

    static void a(LocalizationManager localizationmanager, String s)
    {
        localizationmanager.c(s);
    }

    static String b()
    {
        return a;
    }

    private String b(String s)
    {
        Object obj;
        String s1;
        obj = c.getResources().getConfiguration().locale;
        s1 = ((Locale) (obj)).toString();
        obj = ((Locale) (obj)).getLanguage();
        if (obj != null && !((String) (obj)).isEmpty() && s1 != null && !s1.isEmpty()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int k;
        obj = ((String) (obj)).toLowerCase();
        s1 = s1.toLowerCase();
        s = s.replace('-', '_');
        s1 = (new StringBuilder()).append(s).append("_").append(s1).toString();
        k = c.getResources().getIdentifier(s1, "raw", c.getPackageName());
        int i = k;
        if (k == 0)
        {
            obj = (new StringBuilder()).append(s).append("_").append(((String) (obj))).toString();
            i = c.getResources().getIdentifier(((String) (obj)), "raw", c.getPackageName());
        }
        k = i;
        if (i == 0)
        {
            s = (new StringBuilder()).append(s).append("_en").toString();
            k = c.getResources().getIdentifier(s, "raw", c.getPackageName());
        }
        if (k == 0) goto _L1; else goto _L3
_L3:
        obj = c.getResources().openRawResource(k);
        if (obj == null) goto _L1; else goto _L4
_L4:
        s = new StringBuilder(2048);
        obj = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj))));
_L5:
        s1 = ((BufferedReader) (obj)).readLine();
label0:
        {
            if (s1 == null)
            {
                break label0;
            }
            try
            {
                s.append(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                aa.b(a, "Unable to load default settings", s);
                return null;
            }
        }
          goto _L5
        s = s.toString();
        return s;
    }

    private void c(String s)
    {
        Object obj = b(s);
        if (obj == null)
        {
            aa.a(a, "Unable to get default localization");
        } else
        {
            try
            {
                aa.a(a, (new StringBuilder()).append("Loading default localization config ").append(s).append(" ").append(((String) (obj))).toString());
                obj = new n(com.smule.android.f.e.a().readTree(((String) (obj))));
            }
            catch (Exception exception)
            {
                aa.b(a, "Failed create default localized config", exception);
                exception = null;
            }
            s = (c)e.get(s);
            if (obj != null && s != null)
            {
                s.a(((n) (obj)));
                return;
            }
        }
    }

    private void d(String s)
    {
        Object obj = c.getSharedPreferences((new StringBuilder()).append("localized_").append(s).toString(), 0);
        String s1 = ((SharedPreferences) (obj)).getString("config", "{}");
        obj = s1;
        if (!s1.equals("{}"))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        s1 = b(s);
        obj = s1;
        if (s1 == null)
        {
            obj = "{}";
        }
        try
        {
            aa.a(a, (new StringBuilder()).append("Loading localized ").append(s).append(" ").append(((String) (obj))).toString());
            obj = new n(com.smule.android.f.e.a().readTree(((String) (obj))));
        }
        catch (Exception exception)
        {
            aa.b(a, "Failed to load localized songbook", exception);
            exception = new n();
        }
        s = (c)e.get(s);
        if (s != null)
        {
            s.a(((n) (obj)));
        }
        return;
    }

    public m a(String s)
    {
        return com.smule.android.network.managers.m.a(d.a(s));
    }

    public Object a(String s, Object obj)
    {
        c c1 = (c)e.get(s);
        s = ((String) (obj));
        if (c1 != null)
        {
            s = ((String) (c1.a(obj)));
        }
        return s;
    }

    public Future a(String s, GetLocalizationPackageListener getlocalizationpackagelistener)
    {
        return com.smule.android.network.core.b.a(new Runnable(s, getlocalizationpackagelistener) {

            final String a;
            final GetLocalizationPackageListener b;
            final LocalizationManager c;

            public void run()
            {
                com.smule.android.network.managers.LocalizationManager.a(c, a);
                com.smule.android.network.core.a.a(b, c.a(a));
            }

            
            {
                c = LocalizationManager.this;
                a = s;
                b = getlocalizationpackagelistener;
                super();
            }
        });
    }

    public void a(c c1)
    {
        String s = c1.a();
        c1.a(c);
        e.put(s, c1);
        d(s);
    }

    public void a(Runnable runnable)
    {
        runnable = new q(e.size(), runnable);
        for (Iterator iterator = e.keySet().iterator(); iterator.hasNext(); a((String)iterator.next(), runnable.b())) { }
    }

    public void a(String s, Runnable runnable)
    {
        aa.a(a, (new StringBuilder()).append("Reload ").append(s).toString());
        c c1 = (c)e.get(s);
        if (c1 == null)
        {
            if (runnable != null)
            {
                runnable.run();
            }
            return;
        } else
        {
            a(s, new GetLocalizationPackageListener(c1, s, runnable) {

                final c a;
                final String b;
                final Runnable c;
                final LocalizationManager d;

                public void handleResponse(m m1)
                {
                    m1 = m1.b();
                    if (m1 != null)
                    {
                        a.a(m1);
                        m1 = m1.a();
                        android.content.SharedPreferences.Editor editor = com.smule.android.network.managers.LocalizationManager.a(d).getSharedPreferences((new StringBuilder()).append("localized_").append(b).toString(), 0).edit();
                        editor.putString("config", m1);
                        p.a(editor);
                        aa.a(com.smule.android.network.managers.LocalizationManager.b(), (new StringBuilder()).append("Saved ").append(m1).toString());
                    }
                    if (c != null)
                    {
                        c.run();
                    }
                }

                public volatile void handleResponse(Object obj)
                {
                    handleResponse((m)obj);
                }

            
            {
                d = LocalizationManager.this;
                a = c1;
                b = s;
                c = runnable;
                super();
            }
            });
            return;
        }
    }

}
