// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.accessibility.CaptioningManager;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class sz
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    public static final tl a = new tl();
    public final SharedPreferences b;
    public final boolean c;
    public ti d;
    public ta e;
    private final Context f;
    private final tl g;
    private CaptioningManager h;

    public sz(Context context, SharedPreferences sharedpreferences, boolean flag, tl tl1)
    {
        b = (SharedPreferences)b.a(sharedpreferences);
        f = (Context)b.a(context);
        if (flag && android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        g = tl1;
        if (a.d(context))
        {
            d();
        }
        if (c)
        {
            d = new ti(this);
            a().addCaptioningChangeListener(d);
            return;
        } else
        {
            b.registerOnSharedPreferenceChangeListener(this);
            return;
        }
    }

    public static float a(Context context, float f1, int i, int j)
    {
        float f2 = 13F;
        i = Math.min(i, j);
        context = context.getResources().getDisplayMetrics();
        float f3 = ((float)i / ((DisplayMetrics) (context)).scaledDensity) * 0.0625F;
        if (f3 >= 13F)
        {
            f2 = f3;
        }
        return f2 * f1;
    }

    private static int a(int i, int j)
    {
        int k = i;
        if (i != tb.a(tb.a))
        {
            k = 0xffffff & i | j << 24;
        }
        return k;
    }

    private static int a(SharedPreferences sharedpreferences, String s, int i)
    {
        sharedpreferences = sharedpreferences.getString(s, null);
        if (sharedpreferences == null)
        {
            return i;
        } else
        {
            return Integer.parseInt(sharedpreferences);
        }
    }

    private static cyi a(SharedPreferences sharedpreferences)
    {
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        String s = sharedpreferences.getString("subtitles_style", null);
        if (s == null)
        {
            i = tj.a();
        } else
        {
            i = Integer.parseInt(s);
        }
        if (i != tj.a(tj.e)) goto _L2; else goto _L1
_L1:
        j = a(a(sharedpreferences, "subtitles_background_color", tb.a()), a(sharedpreferences, "subtitles_background_opacity", th.a()));
        i = a(a(sharedpreferences, "subtitles_window_color", tb.b()), a(sharedpreferences, "subtitles_window_opacity", th.b()));
        i1 = a(a(sharedpreferences, "subtitles_text_color", tb.c()), a(sharedpreferences, "subtitles_text_opacity", th.c()));
        l = a(sharedpreferences, "subtitles_edge_type", tc.a());
        k = a(sharedpreferences, "subtitles_edge_color", tb.d());
        j1 = a(sharedpreferences, "subtitles_font", td.a());
_L4:
        return new cyi(j, i, k, l, i1, j1);
_L2:
        if (i != tj.a(tj.a))
        {
            break; /* Loop/switch isn't completed */
        }
        j = tb.a(tb.c);
        i = tb.a(tb.b);
_L5:
        int k1 = tb.b();
        l = tc.a();
        k = tb.d();
        j1 = td.a();
        i1 = i;
        i = k1;
        if (true) goto _L4; else goto _L3
_L3:
        if (i == tj.a(tj.b))
        {
            j = tb.a(tb.b);
            i = tb.a(tb.c);
        } else
        if (i == tj.a(tj.c))
        {
            j = tb.a(tb.c);
            i = tb.a(tb.d);
        } else
        {
            boolean flag;
            if (i == tj.a(tj.d))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b.b(flag);
            j = tb.a(tb.e);
            i = tb.a(tb.d);
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    static ta a(sz sz1)
    {
        return sz1.e;
    }

    static tl b(sz sz1)
    {
        return sz1.g;
    }

    private void d()
    {
        HashSet hashset;
        int i;
        try
        {
            hashset = new HashSet(Arrays.asList(f.getAssets().list("fonts")));
        }
        catch (IOException ioexception)
        {
            throw new IllegalStateException("Project is missing required fonts.", ioexception);
        }
        for (i = 0; i < 4; i++)
        {
            String s = (new String[] {
                "MonoSerif-Regular.ttf", "ComingSoon-Regular.ttf", "DancingScript-Regular.ttf", "CarroisGothicSC-Regular.ttf"
            })[i];
            b.b(hashset.contains(s), String.format("Project is missing required font %s.", new Object[] {
                s
            }));
        }

    }

    public CaptioningManager a()
    {
        if (h == null)
        {
            h = (CaptioningManager)f.getSystemService("captioning");
        }
        return h;
    }

    public final float b()
    {
        if (c)
        {
            return a().getFontScale();
        }
        String s = b.getString("subtitles_scale", null);
        if (s == null)
        {
            return tk.a();
        } else
        {
            return Float.parseFloat(s);
        }
    }

    public final cyi c()
    {
        if (c)
        {
            return new cyi(a().getUserStyle(), g.a());
        } else
        {
            return a(b);
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (e != null)
        {
            if ("subtitles_scale".equals(s))
            {
                s = e;
                sharedpreferences = sharedpreferences.getString("subtitles_scale", null);
                float f1;
                if (sharedpreferences == null)
                {
                    f1 = tk.a();
                } else
                {
                    f1 = Float.parseFloat(sharedpreferences);
                }
                s.a(f1);
            } else
            if ("subtitles_style".equals(s) || "subtitles_font".equals(s) || "subtitles_text_color".equals(s) || "subtitles_text_opacity".equals(s) || "subtitles_edge_type".equals(s) || "subtitles_edge_color".equals(s) || "subtitles_background_color".equals(s) || "subtitles_background_opacity".equals(s) || "subtitles_window_color".equals(s) || "subtitles_window_opacity".equals(s))
            {
                e.a(a(sharedpreferences));
                return;
            }
        }
    }

}
