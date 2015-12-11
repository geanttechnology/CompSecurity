// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.media.SoundPool;
import android.os.Environment;
import android.os.StatFs;
import android.util.Pair;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.crittercism.app.Crittercism;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flurry.android.FlurryAds;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.a;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.g;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.utils:
//            d

public class n
{

    private static final String a = com/smule/pianoandroid/utils/n.getSimpleName();
    private static int b = -1;
    private static boolean c = true;

    public n()
    {
    }

    public static int a()
    {
        return b;
    }

    public static int a(long l)
    {
        return Math.round((float)Math.floor((double)(System.currentTimeMillis() / 1000L - l / 1000L) / 86400D)) + 1;
    }

    public static int a(SoundPool soundpool, int i, float f, boolean flag)
    {
        int j = 0;
        if (i != 0)
        {
            if (flag)
            {
                j = -1;
            } else
            {
                j = 0;
            }
            j = soundpool.play(i, f, f, 0, j, 1.0F);
        }
        return j;
    }

    public static Runnable a(Activity activity, Runnable runnable)
    {
        return new Runnable(activity, runnable) {

            final Activity a;
            final Runnable b;

            public void run()
            {
                a.runOnUiThread(b);
            }

            
            {
                a = activity;
                b = runnable;
                super();
            }
        };
    }

    public static LinkedList a(SongV2 songv2)
    {
        Object obj;
        LinkedList linkedlist;
        obj = new ObjectMapper();
        linkedlist = new LinkedList();
        if (songv2.extraData == null) goto _L2; else goto _L1
_L1:
        songv2 = (JsonNode)((ObjectMapper) (obj)).readValue(songv2.extraData, com/fasterxml/jackson/databind/JsonNode);
        if (!songv2.has("piano")) goto _L2; else goto _L3
_L3:
        songv2 = songv2.get("piano");
        if (!songv2.has("singer_info")) goto _L2; else goto _L4
_L4:
        Iterator iterator = songv2.get("singer_info").elements();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L5
_L5:
        obj = (JsonNode)iterator.next();
        if (obj == null) goto _L7; else goto _L6
_L6:
        if (!((JsonNode) (obj)).has("handle"))
        {
            break MISSING_BLOCK_LABEL_158;
        }
        songv2 = ((JsonNode) (obj)).get("handle").asText();
_L11:
        if (!((JsonNode) (obj)).has("pic_url")) goto _L9; else goto _L8
_L8:
        obj = ((JsonNode) (obj)).get("pic_url").asText();
_L10:
        linkedlist.add(new Pair(songv2, obj));
          goto _L7
        songv2;
_L2:
        return linkedlist;
_L9:
        obj = null;
          goto _L10
        songv2 = null;
          goto _L11
    }

    public static List a(Map map)
    {
        Object obj = new LinkedList(map.entrySet());
        Collections.sort(((List) (obj)), new Comparator() {

            public int a(java.util.Map.Entry entry, java.util.Map.Entry entry1)
            {
                return ((Comparable)entry.getValue()).compareTo(entry1.getValue());
            }

            public int compare(Object obj1, Object obj2)
            {
                return a((java.util.Map.Entry)obj1, (java.util.Map.Entry)obj2);
            }

        });
        map = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); map.add((java.util.Map.Entry)((Iterator) (obj)).next())) { }
        return map;
    }

    public static void a(Activity activity, EditText edittext)
    {
        edittext.postDelayed(new Runnable(activity, edittext) {

            final Activity a;
            final EditText b;

            public void run()
            {
                ((InputMethodManager)a.getSystemService("input_method")).showSoftInput(b, 0);
            }

            
            {
                a = activity;
                b = edittext;
                super();
            }
        }, 200L);
    }

    public static void a(Context context)
    {
        context = context.getSharedPreferences("magic_piano_prefs", 0);
        if (b == -1)
        {
            b = context.getInt("sessions", 0);
        }
        b++;
        p.a(context.edit().putInt("sessions", b));
    }

    public static void a(android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener, ViewTreeObserver viewtreeobserver)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            viewtreeobserver.removeOnGlobalLayoutListener(ongloballayoutlistener);
            return;
        } else
        {
            viewtreeobserver.removeGlobalOnLayoutListener(ongloballayoutlistener);
            return;
        }
    }

    private static void a(Exception exception)
    {
        if (c)
        {
            Crittercism.a(exception);
            c = false;
        }
    }

    public static boolean a(Context context, String s, File file)
    {
        int i = com/smule/magicpiano/g.getField(s).getInt(null);
        context = context.getResources().openRawResource(i);
        com.smule.android.f.n.a(context, file, true);
        return true;
        context;
        aa.b(a, (new StringBuilder()).append("couldn't open stream for ").append(s).toString());
        long l = d();
        Crittercism.a((new StringBuilder()).append("couldn't open stream for ").append(s).append(", ").append(l).append(" bytes free on device.").toString());
        a(((Exception) (context)));
        return false;
        context;
        try
        {
            aa.b(a, (new StringBuilder()).append("resource not found: ").append(s).toString());
            Crittercism.a((new StringBuilder()).append("raw resource not found: ").append(s).toString());
            a(((Exception) (context)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aa.c(a, (new StringBuilder()).append("resource field not found: ").append(s).toString());
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aa.b(a, (new StringBuilder()).append("IllegalArgumentException: ").append(s).toString());
            Crittercism.a((new StringBuilder()).append("IllegalArgumentException: ").append(s).toString());
            a(((Exception) (context)));
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aa.b(a, (new StringBuilder()).append("IllegalAccessException:").append(s).toString());
            Crittercism.a((new StringBuilder()).append("IllegalAccessException:").append(s).toString());
            a(((Exception) (context)));
            return false;
        }
        return false;
    }

    public static boolean a(String s)
    {
        if (!com.smule.android.network.managers.a.a().c())
        {
            return false;
        } else
        {
            return "FLURRY".equals(com.smule.android.network.managers.a.a().a("piandroid.adConfig", s, "").toUpperCase());
        }
    }

    public static boolean a(Throwable throwable)
    {
        Throwable throwable1;
        do
        {
            if (throwable instanceof OutOfMemoryError)
            {
                return true;
            }
            throwable1 = throwable.getCause();
            throwable = throwable1;
        } while (throwable1 != null);
        return false;
    }

    public static float b(SongV2 songv2)
    {
        float f;
        ObjectMapper objectmapper;
        objectmapper = new ObjectMapper();
        f = 1.0F;
        if (songv2.extraData == null) goto _L2; else goto _L1
_L1:
        songv2 = (JsonNode)objectmapper.readValue(songv2.extraData, com/fasterxml/jackson/databind/JsonNode);
        if (!songv2.has("piano")) goto _L4; else goto _L3
_L3:
        songv2 = songv2.get("piano");
        if (!songv2.has("jams_spacing")) goto _L4; else goto _L5
_L5:
        f = songv2.get("jams_spacing").floatValue();
_L2:
        return f;
        songv2;
        return 1.0F;
_L4:
        f = 1.0F;
        if (true) goto _L2; else goto _L6
_L6:
    }

    public static String b(Context context)
    {
        Object obj1 = "";
        Object obj = obj1;
        Object obj2 = obj1;
        Signature asignature[];
        MessageDigest messagedigest;
        int i;
        int j;
        try
        {
            asignature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return ((String) (obj2));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        obj2 = obj1;
        j = asignature.length;
        i = 0;
        context = ((Context) (obj1));
_L2:
        obj = context;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = asignature[i];
        obj = context;
        obj2 = context;
        messagedigest = MessageDigest.getInstance("SHA");
        obj = context;
        obj2 = context;
        messagedigest.update(((Signature) (obj1)).toByteArray());
        obj = context;
        obj2 = context;
        context = (new StringBuilder()).append(context).append("Sig: ").append(com.smule.pianoandroid.utils.d.a(messagedigest.digest())).append(" ").toString();
        i++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
    }

    public static boolean b()
    {
        return android.os.Build.VERSION.SDK_INT >= 11;
    }

    public static boolean b(String s)
    {
        if (com.smule.android.network.managers.a.a().c())
        {
            if ("DFP".equals((s = com.smule.android.network.managers.a.a().a("piandroid.adConfig", s, "")).toUpperCase()) || "BURSTLY".equals(s.toUpperCase()))
            {
                return true;
            }
        }
        return false;
    }

    public static void c()
    {
        long l = UserManager.n().c();
        if (l != 0L)
        {
            aa.c(a, (new StringBuilder()).append("Using Player ID ").append(l).append(" for Flurry ADs.").toString());
            HashMap hashmap = new HashMap();
            hashmap.put("player_id", Long.toString(l));
            FlurryAds.setUserCookies(hashmap);
            return;
        } else
        {
            aa.e(a, "Player ID is not available for Flurry ADs.");
            return;
        }
    }

    public static boolean c(String s)
    {
        if (!com.smule.android.network.managers.a.a().c())
        {
            return false;
        } else
        {
            return "ADCOLONY".equals(com.smule.android.network.managers.a.a().a("piandroid.adConfig", s, "").toUpperCase());
        }
    }

    public static long d()
    {
        StatFs statfs = new StatFs(Environment.getDataDirectory().getPath());
        return (long)(statfs.getAvailableBlocks() * statfs.getBlockSize());
    }

}
