// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.os.Environment;
import com.socialin.android.d;
import com.socialin.android.photo.exif.ExifTool;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.UUID;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.util:
//            FileUtils, w

public final class x
{

    public static final Comparator a = new _cls3();
    private static final String b = com/socialin/android/util/x.getSimpleName();
    private static final x c = new x();

    private x()
    {
    }

    public static x a()
    {
        return c;
    }

    public static String a(Context context)
    {
        context = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f08096b)).toString();
        (new File(context)).mkdirs();
        return context;
    }

    public static String a(InputStream inputstream)
    {
        String s = UUID.randomUUID().toString();
        String s1 = d();
        (new File(s1, s)).mkdirs();
        s = (new StringBuilder()).append(s1).append("/").append(s).append("/orig").toString();
        boolean flag;
        try
        {
            FileUtils.a(s, inputstream);
            flag = w.e(s);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(inputstream.getMessage()).toString()
            });
            return null;
        }
        if (!flag)
        {
            return null;
        } else
        {
            c();
            return s;
        }
    }

    public static String a(String s)
    {
        String s1 = UUID.randomUUID().toString();
        String s2 = d();
        (new File(s2, s1)).mkdirs();
        s1 = (new StringBuilder()).append(s2).append("/").append(s1).append("/orig").toString();
        if (!(new File(s)).renameTo(new File(s1)))
        {
            return null;
        } else
        {
            c();
            return s1;
        }
    }

    public static String a(String s, String s1)
    {
        return b(s, m.c(s1));
    }

    public static String a(String s, boolean flag)
    {
        String s1 = UUID.randomUUID().toString();
        m.c(s);
        Object obj = d();
        (new File(((String) (obj)), s1)).mkdirs();
        s1 = (new StringBuilder()).append(((String) (obj))).append("/").append(s1).append("/orig").toString();
        obj = new File(s);
        File file = new File(s1);
        if (flag)
        {
            try
            {
                FileUtils.b(s, s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.b(b, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
                });
                return null;
            }
        } else
        if (!((File) (obj)).renameTo(file))
        {
            return null;
        }
        c();
        return s1;
    }

    public static HashMap a(HashMap hashmap)
    {
        String s = UUID.randomUUID().toString();
        String s1 = d();
        (new File(s1, s)).mkdirs();
        int i = ((Integer)hashmap.get("width")).intValue();
        int j = ((Integer)hashmap.get("height")).intValue();
        hashmap = (String)hashmap.get("path");
        s = (new StringBuilder()).append(s1).append("/").append(s).append("/orig_w").append(i).append("_h").append(j).toString();
        try
        {
            FileUtils.b(hashmap, s);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(hashmap.getMessage()).toString()
            });
            return null;
        }
        hashmap = new HashMap();
        hashmap.put("path", s);
        hashmap.put("width", Integer.valueOf(i));
        hashmap.put("height", Integer.valueOf(j));
        c();
        return hashmap;
    }

    public static void a(String s, int i, int j)
    {
        if (com.socialin.android.util.FileUtils.d(s) != FileUtils.ImageFileFormat.JPEG) goto _L2; else goto _L1
_L1:
        Object obj = ExifTool.a(s, "Exif.Photo.UserComment");
        if (obj == null || !d(((String) (obj)))) goto _L2; else goto _L3
_L3:
        obj = new JSONObject(((String) (obj)));
        if (((JSONObject) (obj)).isNull("effects_applied")) goto _L5; else goto _L4
_L4:
        ((JSONObject) (obj)).put("effects_applied", ((JSONObject) (obj)).optInt("effects_applied") + i);
_L10:
        if (((JSONObject) (obj)).isNull("total_effects_actions")) goto _L7; else goto _L6
_L6:
        ((JSONObject) (obj)).put("total_effects_actions", ((JSONObject) (obj)).optInt("total_effects_actions") + j);
_L8:
        ExifTool.a(s, "Exif.Photo.UserComment", ((JSONObject) (obj)).toString());
        return;
_L5:
        try
        {
            ((JSONObject) (obj)).put("effects_applied", i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        ((JSONObject) (obj)).put("total_effects_actions", j);
          goto _L8
_L2:
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static void a(String s, String s1, String s2, String s3)
    {
        if (com.socialin.android.util.FileUtils.d(s) != FileUtils.ImageFileFormat.JPEG) goto _L2; else goto _L1
_L1:
        Object obj;
        if (s1 != null && com.socialin.android.util.FileUtils.d(s) == FileUtils.ImageFileFormat.JPEG)
        {
            obj = ExifTool.a(s1);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = ((String) (obj)).split(";");
            if (obj != null)
            {
                int j = obj.length;
                for (int i = 0; i < j; i++)
                {
                    String s4 = obj[i];
                    String s5 = ExifTool.a(s1, s4);
                    if (s5 != null)
                    {
                        ExifTool.a(s, s4, s5);
                    }
                }

            }
        }
        s1 = m.c(s);
        if (s1 != null) goto _L4; else goto _L3
_L3:
        if (s3 != null)
        {
            ExifTool.a(s, "Exif.Photo.UserComment", s3);
        }
_L6:
        if (s2 != null)
        {
            m.a(s, s2, null);
        }
_L2:
        return;
_L4:
        if (!d(s1) && s3 != null)
        {
            ExifTool.a(s, "Exif.Photo.UserComment", s3);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static String b(String s)
    {
        Object obj = null;
        String s1 = obj;
        if (com.socialin.android.util.FileUtils.d(s) != FileUtils.ImageFileFormat.JPEG)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        s = ExifTool.a(s, "Exif.Photo.UserComment");
        s1 = obj;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        s1 = obj;
        if (!d(s))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        s1 = obj;
        if (!s.isNull("uid"))
        {
            s1 = s.optString("uid");
        }
        return s1;
    }

    public static String b(String s, String s1)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("from", s);
            jsonobject.put("uid", UUID.randomUUID().toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
            return jsonobject.toString();
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (d(s1))
        {
            return (new JSONObject(s1)).toString();
        }
        s = jsonobject.toString();
        return s;
    }

    public static String b(String s, boolean flag)
    {
        String s1 = UUID.randomUUID().toString();
        m.c(s);
        Object obj = d();
        (new File(((String) (obj)), s1)).mkdirs();
        s1 = (new StringBuilder()).append(((String) (obj))).append("/").append(s1).append("/orig").toString();
        obj = new File(s);
        File file = new File(s1);
        if (flag)
        {
            try
            {
                FileUtils.b(s, s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.b(b, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
                });
                return null;
            }
        } else
        if (!((File) (obj)).renameTo(file))
        {
            return null;
        }
        c();
        return s1;
    }

    public static void b()
    {
        File afile[] = (new File(d())).listFiles();
        if (afile != null)
        {
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                FileUtils.b(afile[i].getPath());
            }

        }
    }

    public static String c(String s)
    {
        return b(s, ((String) (null)));
    }

    public static void c()
    {
        int i = 10;
        File afile[] = (new File(d())).listFiles();
        if (afile != null && afile.length > 10)
        {
            Arrays.sort(afile, a);
            for (; i < afile.length; i++)
            {
                FileUtils.b(afile[i].getPath());
            }

        }
    }

    public static void c(String s, String s1)
    {
        String s2;
        if (com.socialin.android.util.FileUtils.d(s) != FileUtils.ImageFileFormat.JPEG)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        s2 = ExifTool.a(s, "Exif.Photo.UserComment");
        if (s2 == null || !d(s2))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        s1 = new JSONObject(s2);
        if (s1.isNull("uid") || s1.optString("uid").isEmpty())
        {
            s1.put("uid", UUID.randomUUID());
        }
        ExifTool.a(s, "Exif.Photo.UserComment", s1.toString());
        return;
        s;
        s.printStackTrace();
        return;
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("uid", UUID.randomUUID());
            jsonobject.put("from", s1);
            ExifTool.a(s, "Exif.Photo.UserComment", jsonobject.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }

    public static String d()
    {
        String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/PicsArt/.recent").toString();
        (new File(s)).mkdirs();
        return s;
    }

    private static boolean d(String s)
    {
        try
        {
            new JSONObject(s);
        }
        catch (JSONException jsonexception)
        {
            try
            {
                new JSONArray(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
        }
        return true;
    }

    public static String e()
    {
        return UUID.randomUUID().toString();
    }

    public final String a(File file)
    {
        File afile[] = file.listFiles(new _cls1());
        if (afile != null && afile.length != 0)
        {
            return afile[0].getPath();
        } else
        {
            return (new StringBuilder()).append(file.getPath()).append("/orig").toString();
        }
    }

    static 
    {
        new _cls4();
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}

}
