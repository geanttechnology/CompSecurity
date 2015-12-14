// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.az;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.az:
//            c, d

public class b
{

    private static String a = myobfuscated/az/b.getName();
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static b f;
    private ArrayList b;

    private b(Context context, String s)
    {
        b = new ArrayList();
        a(context, s, "effect_textures_info.json");
    }

    public static Bitmap a(Context context, String s, String s1, int i, int j, boolean flag)
    {
        b b1 = b(context);
        if (b1 != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int k = 0;
_L9:
        if (k >= b1.b.size()) goto _L4; else goto _L3
_L3:
        myobfuscated.az.c c1 = (myobfuscated.az.c)b1.b.get(k);
        if (c1.a.compareToIgnoreCase(s) != 0) goto _L6; else goto _L5
_L5:
        k = 0;
_L10:
        if (k >= c1.c.size())
        {
            break MISSING_BLOCK_LABEL_430;
        }
        s = (myobfuscated.az.d)c1.c.get(k);
        if (((myobfuscated.az.d) (s)).a.compareToIgnoreCase(s1) != 0) goto _L8; else goto _L7
_L7:
label0:
        {
            if (s == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            HashMap hashmap = new HashMap();
            String s2;
            Bitmap bitmap;
            if (!flag && ((myobfuscated.az.d) (s)).e != null && i <= 256 && j <= 256)
            {
                hashmap.put("path", ((myobfuscated.az.d) (s)).e);
                hashmap.put("width", Integer.valueOf(((myobfuscated.az.d) (s)).h));
                hashmap.put("height", Integer.valueOf(((myobfuscated.az.d) (s)).i));
                s1 = ((myobfuscated.az.d) (s)).d;
                s2 = ((myobfuscated.az.d) (s)).e;
            } else
            {
                hashmap.put("path", ((myobfuscated.az.d) (s)).b);
                hashmap.put("width", Integer.valueOf(((myobfuscated.az.d) (s)).f));
                hashmap.put("height", Integer.valueOf(((myobfuscated.az.d) (s)).g));
                s1 = ((myobfuscated.az.d) (s)).c;
                s2 = ((myobfuscated.az.d) (s)).b;
            }
            Log.e("ex1", "*********************");
            Log.e("ex1", (new StringBuilder("loadFileName = ")).append(s1).toString());
            Log.e("ex1", (new StringBuilder("loadFilePath = ")).append(s2).toString());
            Log.e("ex1", "*********************");
            bitmap = w.b(hashmap, 0, 0, 0);
            s = bitmap;
            if (bitmap == null)
            {
                a(context, c1, s1, s2, true, 0);
                s = w.b(hashmap, 0, 0, 0);
            }
            if (s == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            Log.e("ex1", (new StringBuilder("bg w = ")).append(s.getWidth()).toString());
            Log.e("ex1", (new StringBuilder("bg h = ")).append(s.getHeight()).toString());
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_491;
            }
            if (s.isMutable() && s.getConfig() == android.graphics.Bitmap.Config.ARGB_8888)
            {
                context = s;
                if (s.getWidth() * s.getHeight() * 4 == s.getRowBytes() * s.getHeight())
                {
                    break label0;
                }
            }
            context = com.socialin.android.util.c.b(s, android.graphics.Bitmap.Config.ARGB_8888);
            com.socialin.android.util.c.a(s);
        }
        return context;
_L6:
        k++;
          goto _L9
_L4:
        c1 = null;
          goto _L5
_L8:
        k++;
          goto _L10
        s = null;
          goto _L7
        context = com.socialin.android.util.c.a(s, i, j, true);
        if (s != context)
        {
            com.socialin.android.util.c.a(s);
        }
        if (context != null && !context.isRecycled())
        {
            s = com.socialin.android.util.c.b(context, android.graphics.Bitmap.Config.ARGB_8888);
            com.socialin.android.util.c.a(context);
            return s;
        }
        if (true) goto _L1; else goto _L11
_L11:
    }

    private static final HashMap a(Context context, File file, String s, String s1, String s2, File file1)
    {
        Object obj = null;
        if (!file.canRead())
        {
            b(context, s, s1);
        }
        try
        {
            context = m.b(s, s2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b("EX ***", new Object[] {
                context.getMessage()
            });
            context = null;
        }
        file = obj;
        if (context != null)
        {
            try
            {
                context = com.socialin.android.util.c.a(context, 0, context.length, null, a);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = null;
            }
            file = obj;
            if (context != null)
            {
                file = obj;
                if (!context.isRecycled())
                {
                    file = w.a(file1.getAbsolutePath(), context);
                    com.socialin.android.util.c.a(context, a);
                }
            }
        }
        return file;
    }

    private void a(Context context, String s, String s1)
    {
        Object obj = null;
        int i;
        try
        {
            context = context.getAssets().open(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = obj;
        }
        context = FileUtils.a(context);
        context = (new JSONObject(context)).getJSONArray("packages");
        i = 0;
_L2:
        if (i >= context.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = new myobfuscated.az.c((JSONObject)context.getJSONObject(i).get("package"), s);
        b.add(s1);
        i++;
        if (true) goto _L2; else goto _L1
        context;
        context.printStackTrace();
_L1:
    }

    private static boolean a(Context context, myobfuscated.az.c c1, String s, String s1, boolean flag, int i)
    {
        do
        {
            if (s == null)
            {
                return false;
            }
            Log.e("ex1", "loadTexture");
            Log.e("ex1", (new StringBuilder("fileName = ")).append(s).toString());
            Log.e("ex1", (new StringBuilder("path = ")).append(s1).toString());
            Object obj = new File(s1);
            ((File) (obj)).canRead();
            if (a(context, new File(c1.b), c1.b, c1.a, s, ((File) (obj))) == null)
            {
                obj = Boolean.valueOf(false);
            } else
            {
                obj = Boolean.valueOf(true);
            }
            if (((Boolean) (obj)).booleanValue())
            {
                return true;
            }
            if (i > 2)
            {
                return false;
            }
            i++;
            b(context, c1.b, c1.a);
        } while (true);
    }

    public static b b(Context context)
    {
        if (f != null) goto _L2; else goto _L1
_L1:
        if (!Environment.getExternalStorageState().equals("mounted")) goto _L4; else goto _L3
_L3:
        boolean flag;
        boolean flag1 = c(context);
        flag = flag1;
        if (!flag1)
        {
            if (Environment.getExternalStorageState().equals("mounted"))
            {
                String s = f(context);
                Log.e("ex1", (new StringBuilder("delete resourceDirPath = ")).append(s).toString());
                Utils.a(new File(s));
            }
            flag = c(context);
        }
        if (!flag) goto _L4; else goto _L5
_L5:
        context = new b(context, f(context));
_L7:
        f = context;
_L2:
        return f;
_L4:
        context = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static void b(Context context, String s, String s1)
    {
        try
        {
            FileUtils.a(s, context.getAssets().open(s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    private static boolean c(Context context)
    {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            if (Environment.getExternalStorageState().equals("mounted"))
            {
                d(context);
                e(context);
            }
            Utils.a(new File((new StringBuilder()).append(d(context)).append(".resource/").toString()));
            String s = d(context);
            Object obj = e(context);
            File file = new File(s);
            obj = new File(((String) (obj)));
            boolean flag = true;
            for (int i = 0; i < 2;)
            {
                File file1 = (new File[] {
                    file, obj
                })[i];
                boolean flag1 = flag;
                if (!file1.exists())
                {
                    flag1 = flag;
                    if (!file1.mkdirs())
                    {
                        String s1 = (new StringBuilder()).append(context.getString(0x7f080407)).append("  ").append(s).toString();
                        com.socialin.android.d.b(context.getString(0x7f0808af), new Object[] {
                            s1
                        });
                        flag1 = false;
                    }
                }
                i++;
                flag = flag1;
            }

            if (flag)
            {
                w.a(context.getString(0x7f080959), context);
            }
            return flag;
        } else
        {
            return false;
        }
    }

    private static String d(Context context)
    {
        if (c == null)
        {
            c = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(context.getString(0x7f0808fb)).append("/").toString();
        }
        return c;
    }

    private static String e(Context context)
    {
        String s = d(context);
        if (d == null)
        {
            d = (new StringBuilder()).append(s).append(context.getString(0x7f08096c)).append("/").toString();
        }
        return d;
    }

    private static String f(Context context)
    {
        if (e == null)
        {
            e = (new StringBuilder()).append(d(context)).append(context.getString(0x7f080959)).append("/").toString();
        }
        return e;
    }

    public final void a(Context context)
    {
        Log.e("ex1", "setupPackagesDirs");
        int i = 0;
        while (i < b.size()) 
        {
            Object obj = (myobfuscated.az.c)b.get(i);
            File file = new File(((myobfuscated.az.c) (obj)).b);
            if (!file.exists() || !file.canRead())
            {
                Log.e("ex1", (new StringBuilder("bufferDataPackage.packageName = ")).append(((myobfuscated.az.c) (obj)).a).toString());
                Log.e("ex1", (new StringBuilder("bufferDataPackage.packagePath = ")).append(((myobfuscated.az.c) (obj)).b).toString());
                b(context, ((myobfuscated.az.c) (obj)).b, ((myobfuscated.az.c) (obj)).a);
                obj = new File(((myobfuscated.az.c) (obj)).b);
                if (!((File) (obj)).exists() || !((File) (obj)).canRead())
                {
                    Log.e("ex1", "cant copy package");
                } else
                {
                    Log.e("ex1", "copy succes");
                }
            }
            i++;
        }
    }

}
