// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.text.TextUtils;
import com.picsart.shop.a;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.d;
import com.socialin.android.photo.template.i;
import com.socialin.android.photo.textart.TextArtStyle;
import com.socialin.android.photo.textart.TypefaceSpec;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.t;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cb.c;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
    implements CommonConstants
{

    private static final String f = com/socialin/android/photo/f.getSimpleName();
    private static int g = 0;

    public f()
    {
    }

    static int a()
    {
        return g;
    }

    public static int a(Activity activity, String s, ItemType itemtype)
    {
        int k = 0;
        s = s.substring(s.lastIndexOf(File.separator) + 1);
        char c1;
        int j;
        if (itemtype.getValue() == ItemType.CLIPART.getValue())
        {
            c1 = '\001';
        } else
        if (itemtype.getValue() == ItemType.FRAME.getValue())
        {
            c1 = '\uFF01';
        } else
        {
            c1 = '\0';
        }
        activity = a(((Context) (activity)), "", itemtype);
        j = c1;
        if (activity == null) goto _L2; else goto _L1
_L1:
        j = c1;
        if (k >= activity.length()) goto _L2; else goto _L3
_L3:
        itemtype = activity.optJSONObject(k);
        if (!itemtype.optString("name").equals(s)) goto _L5; else goto _L4
_L4:
        j = itemtype.optInt("type");
_L2:
        return j;
_L5:
        k++;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public static int a(Context context, ItemType itemtype)
    {
        context = a(context, "", itemtype);
        if (context != null)
        {
            return context.length();
        } else
        {
            return 0;
        }
    }

    public static int a(String s)
    {
        FileFilter filefilter = new FileFilter() {

            public final boolean accept(File file)
            {
                return file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(File.separator) + 1).contains(CommonConstants.b[com.socialin.android.photo.f.a()]);
            }

        };
        return (new File(s)).listFiles(filefilter).length;
    }

    private static String a(Context context)
    {
        context = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0800af)).toString());
        if (!context.exists())
        {
            context.mkdir();
        }
        context = new File((new StringBuilder()).append(context).append("/").append(d[g]).toString());
        if (!context.exists())
        {
            context.mkdir();
        }
        return context.getAbsolutePath();
    }

    public static List a(String s, ItemType itemtype)
    {
        return c(s, itemtype, false);
    }

    public static List a(String s, ItemType itemtype, boolean flag)
    {
        return c(s, itemtype, flag);
    }

    private static JSONArray a(Context context, String s, ItemType itemtype)
    {
        Object obj = s;
        if (context != null)
        {
            context = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0800af)).append("/").append(d[itemtype.getValue()]).toString();
            obj = s;
            if (s.equals(""))
            {
                obj = context;
            }
        }
        obj = new File((new StringBuilder()).append(((String) (obj))).append("/").append(d_[itemtype.getValue()]).toString());
        s = null;
        context = s;
        if (((File) (obj)).exists())
        {
            obj = FileUtils.c(((File) (obj)));
            context = s;
            if (obj != null)
            {
                context = ((JSONObject) (obj)).optJSONArray(c[itemtype.getValue()]);
            }
        }
        return context;
    }

    private static JSONObject a(File file, String s, String s1, int j, int k)
    {
        return a(file, s, s1, j, k, null, null);
    }

    private static JSONObject a(File file, String s, String s1, int j, int k, JSONObject jsonobject, c c1)
    {
        JSONArray jsonarray;
        int l;
        int i1;
        boolean flag;
        flag = true;
        i1 = 0;
        file = FileUtils.c(file);
        Object obj = file;
        if (file == null)
        {
            obj = new JSONObject();
        }
        int j1;
        if (((JSONObject) (obj)).length() != 0)
        {
            jsonarray = ((JSONObject) (obj)).optJSONArray(c[g]);
        } else
        {
            jsonarray = new JSONArray();
        }
        file = null;
        l = 0;
_L3:
        if (l >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_328;
        }
        file = jsonarray.getJSONObject(l);
        if (!file.optString("name").equals(s)) goto _L2; else goto _L1
_L1:
        i1 = file.optInt("usedCount");
        j1 = i1 + 1;
        i1 = l;
        l = j1;
_L4:
        if (!flag)
        {
            file = new JSONObject();
            file.put("name", s);
            file.put("usedCount", l);
            file.put("last_date", System.currentTimeMillis());
            if (c1 != null)
            {
                file.put("packageDir", c1.j);
                file.put("fromShop", c1.i);
            }
            if (jsonobject != null && g == ItemType.COLLAGE_FRAME.getValue())
            {
                file.put("frame", jsonobject);
            }
            if (g != ItemType.TEXTART.getValue() && g != ItemType.COLLAGE_FRAME.getValue())
            {
                file.put("type", j);
                file.put("itemIconUrl", s1);
                file.put("colorFillType", k);
            }
            jsonarray.put(file);
        } else
        {
            file.put("last_date", System.currentTimeMillis());
            file.put("usedCount", l);
            jsonarray.put(i1, file);
        }
        ((JSONObject) (obj)).put(c[g], jsonarray);
        return ((JSONObject) (obj));
_L2:
        l++;
          goto _L3
        l = 1;
        flag = false;
          goto _L4
    }

    public static void a(Context context, ItemType itemtype, TextArtStyle textartstyle, int j)
    {
        File file;
        Object obj;
        File file1;
        String s;
        String s1;
        obj = null;
        g = itemtype.getValue();
        itemtype = a(context);
        file1 = new File((new StringBuilder()).append(itemtype).append("/icons").toString());
        if (!file1.exists())
        {
            file1.mkdirs();
        }
        textartstyle = textartstyle.getTypefaceSpec();
        s = textartstyle.getFontPackagePath();
        itemtype = textartstyle.getFontPackageName();
        s1 = textartstyle.getFontPath();
        if (j == 1)
        {
            itemtype = (new StringBuilder()).append(b[g]).append("myFont").append("_").append(s1.substring(s1.lastIndexOf(File.separator) + 1)).toString();
        } else
        {
            itemtype = (new StringBuilder()).append(b[g]).append(itemtype).append("_").append(s1.substring(s1.lastIndexOf("_") + 1)).toString();
        }
        if (j == 3) goto _L2; else goto _L1
_L1:
        textartstyle = itemtype;
        file = new File((new StringBuilder()).append(file1.getPath()).append("/").append(itemtype).toString());
        textartstyle = itemtype;
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_196;
        }
        textartstyle = itemtype;
        file.createNewFile();
        textartstyle = itemtype;
        obj = new FileOutputStream(file);
_L8:
        if (j != 0) goto _L4; else goto _L3
_L3:
        textartstyle = itemtype;
        FileUtils.a(context.getResources().getAssets().open(s1), ((java.io.OutputStream) (obj)));
        context = itemtype;
_L6:
        textartstyle = context;
        a(file1.getPath(), ((String) (context)), "", 0, 0);
_L5:
        return;
_L4:
        if (j != 1)
        {
            break MISSING_BLOCK_LABEL_396;
        }
        textartstyle = itemtype;
        obj = new File(s1);
        context = itemtype;
        textartstyle = itemtype;
        if (!((File) (obj)).exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        textartstyle = itemtype;
        FileUtils.b(((File) (obj)), file);
        context = itemtype;
        continue; /* Loop/switch isn't completed */
        context;
        context = new File((new StringBuilder()).append(file1.getPath()).append("/").append(textartstyle).toString());
        if (context.exists())
        {
            context.delete();
            return;
        }
          goto _L5
        if (j != 2)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        textartstyle = itemtype;
        FileUtils.a(com.picsart.shop.a.a(context).a(s, s1), ((java.io.OutputStream) (obj)));
        context = itemtype;
        continue; /* Loop/switch isn't completed */
        context;
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
        return;
        textartstyle = itemtype;
        context = s1.substring(s1.lastIndexOf(File.separator) + 1);
        if (true) goto _L6; else goto _L2
_L2:
        file = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void a(Context context, ItemType itemtype, String s, String s1, int j)
    {
        Object obj = null;
        File file;
        g = itemtype.getValue();
        itemtype = a(context);
        file = new File((new StringBuilder()).append(itemtype).append("/icons").toString());
        if (!file.exists())
        {
            file.mkdirs();
        }
        if (s1.equals(d_[g])) goto _L2; else goto _L1
_L1:
        context = (JSONObject)(new JSONObject(FileUtils.a(context.getAssets().open(s1)))).optJSONArray("collageFrames").optJSONObject(j).opt("frame");
        itemtype = context.optString("url");
        itemtype = (new StringBuilder()).append(b[g]).append(s).append("_").append(itemtype.substring(itemtype.lastIndexOf("_") + 1, itemtype.lastIndexOf("."))).toString();
_L3:
        a(file.getAbsolutePath(), ((JSONObject) (context)), ((String) (itemtype)), ((c) (null)));
        return;
_L2:
        itemtype = FileUtils.c(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0800af)).append("/").append(d[g]).append("/icons/").append(s1).toString())).optJSONArray(c[g]).optJSONObject(j).optString("name");
        context = obj;
          goto _L3
        context;
_L5:
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
        return;
        context;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void a(Context context, ItemType itemtype, String s, String s1, String s2, int j, int k, String s3)
    {
        String s4;
        File file;
        File file1;
        g = itemtype.getValue();
        file = new File(s);
        s4 = a(context);
        if (s.contains(context.getString(0x7f0800af)))
        {
            break MISSING_BLOCK_LABEL_175;
        }
        s3 = (new StringBuilder()).append(b[g]).append(s3).append("_").append(s.substring(s.lastIndexOf("_") + 1)).toString();
        file1 = new File((new StringBuilder()).append(s4).append("/").append(s3).toString());
        itemtype = s3;
        if (file1.exists())
        {
            break MISSING_BLOCK_LABEL_162;
        }
        file1.createNewFile();
        FileUtils.b(file, file1);
        itemtype = s3;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        a(context, s1, s3);
        itemtype = s3;
_L1:
        try
        {
            a(s4, ((String) (itemtype)), s2, j, k);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = new File(s);
            if (context.exists())
            {
                context.delete();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(f, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
            });
        }
        break MISSING_BLOCK_LABEL_250;
        itemtype = s.substring(s.lastIndexOf(File.separator) + 1);
          goto _L1
    }

    public static void a(Context context, ItemType itemtype, c c1, int j)
    {
        try
        {
            g = itemtype.getValue();
            itemtype = a(context);
            itemtype = new File((new StringBuilder()).append(itemtype).append("/icons").toString());
            if (!itemtype.exists())
            {
                itemtype.mkdirs();
            }
            String s = c1.k.substring(0, c1.k.lastIndexOf("."));
            Object obj = new t();
            context = (new StringBuilder()).append(com.picsart.shop.a.a(context).b(context)).append(s).toString();
            ((t) (obj)).a(new RandomAccessFile(context, "r"), context);
            context = (JSONObject)(new JSONObject(new String(((t) (obj)).a((new StringBuilder()).append(s).append(".json").toString())))).optJSONArray("collage_frames").optJSONObject(j).opt("frame");
            obj = c1.m;
            s = (new StringBuilder()).append(b[g]).append(s).append("_").append(((String) (obj)).substring(((String) (obj)).lastIndexOf("_") + 1, ((String) (obj)).lastIndexOf("."))).toString();
            a(itemtype.getAbsolutePath(), ((JSONObject) (context)), s, c1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
    }

    public static void a(Context context, String s, String s1, ItemType itemtype)
    {
        File file = new File(s1);
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        File afile[];
        afile = file.listFiles(new FileFilter() {

            public final boolean accept(File file4)
            {
                return file4.getAbsolutePath().substring(file4.getAbsolutePath().lastIndexOf(File.separator) + 1).contains(CommonConstants.b[com.socialin.android.photo.f.a()]);
            }

        });
        itemtype = a(context, s1, itemtype);
        if (itemtype != null) goto _L3; else goto _L2
_L2:
        return;
_L3:
        int j = 0;
_L5:
        if (j >= itemtype.length())
        {
            break; /* Loop/switch isn't completed */
        }
        context = itemtype.optJSONObject(j).optString("name");
        File file1 = new File((new StringBuilder()).append(s1).append("/").append(context).toString());
        File file3 = new File((new StringBuilder()).append(s).append("/i_").append(context).toString());
        if (file1.exists())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        file1.delete();
        file3.delete();
        a(((String) (context)), s1);
_L6:
        j++;
        if (true) goto _L5; else goto _L4
        context;
_L13:
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
          goto _L6
_L4:
        int l;
        m.a(s, s1);
        m.a(s, s1, g);
        l = afile.length;
        j = 0;
_L12:
        if (j >= l) goto _L2; else goto _L7
_L7:
        File file2;
        String s2;
        file2 = afile[j];
        context = file2.getAbsolutePath();
        s2 = context.substring(context.lastIndexOf(File.separator) + 1);
        if ((new File((new StringBuilder()).append(s).append("/i_").append(s2).toString())).exists()) goto _L9; else goto _L8
_L8:
        int k = 0;
_L10:
        if (k >= itemtype.length())
        {
            break; /* Loop/switch isn't completed */
        }
        context = itemtype.optJSONObject(k);
        if (!context.optString("name").equals(s2) || !TextUtils.isEmpty(context.optString("itemIconUrl")))
        {
            break MISSING_BLOCK_LABEL_356;
        }
        a(s2, s1);
        file2.delete();
_L11:
        k++;
        if (true) goto _L10; else goto _L9
        context;
_L14:
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
          goto _L11
_L9:
        j++;
          goto _L12
        context;
          goto _L13
        context;
          goto _L14
    }

    private static void a(File file, JSONObject jsonobject)
    {
        JSONArray jsonarray = jsonobject.optJSONArray(c[g]);
        Object obj = new ArrayList();
        for (int j = 0; j < jsonarray.length(); j++)
        {
            ((ArrayList) (obj)).add(jsonarray.optJSONObject(j));
        }

        Collections.sort(((List) (obj)), new Comparator() {

            public final int compare(Object obj1, Object obj2)
            {
                obj1 = (JSONObject)obj1;
                obj2 = (JSONObject)obj2;
                if (((JSONObject) (obj1)).optInt("usedCount") == ((JSONObject) (obj2)).optInt("usedCount")) goto _L2; else goto _L1
_L1:
                if (((JSONObject) (obj2)).optInt("usedCount") >= ((JSONObject) (obj1)).optInt("usedCount")) goto _L4; else goto _L3
_L3:
                return -1;
_L4:
                return 1;
_L2:
                if (((JSONObject) (obj2)).optInt("last_date") >= ((JSONObject) (obj1)).optInt("last_date"))
                {
                    return ((JSONObject) (obj2)).optInt("last_date") != ((JSONObject) (obj1)).optInt("last_date") ? 1 : 0;
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

        });
        jsonarray = new JSONArray();
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); jsonarray.put((JSONObject)((Iterator) (obj)).next())) { }
        jsonobject.putOpt(c[g], jsonarray);
        FileUtils.a(file, jsonobject);
    }

    private static void a(String s, String s1)
    {
        s = new File((new StringBuilder()).append(s1).append("/").append(d_[g]).toString());
        if (s.exists())
        {
            s1 = new JSONArray();
            JSONObject jsonobject = FileUtils.c(s);
            if (jsonobject != null)
            {
                jsonobject.put(c[g], s1);
                FileUtils.a(s, jsonobject);
            }
        }
    }

    private static void a(String s, String s1, String s2, int j, int k)
    {
        s = new File((new StringBuilder()).append(s).append("/").append(d_[g]).toString());
        if (!s.exists())
        {
            s.createNewFile();
        }
        s1 = a(((File) (s)), s1, s2, j, k);
        if (s1 != null)
        {
            a(((File) (s)), ((JSONObject) (s1)));
        }
    }

    private static void a(String s, JSONObject jsonobject, String s1, c c1)
    {
        s = new File((new StringBuilder()).append(s).append("/").append(d_[g]).toString());
        if (!s.exists())
        {
            s.createNewFile();
        }
        jsonobject = a(((File) (s)), s1, "", 0, 0, jsonobject, c1);
        if (jsonobject != null)
        {
            a(((File) (s)), jsonobject);
        }
    }

    private static boolean a(Context context, String s, String s1)
    {
        context = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0800af)).append("/").append(d[g]).toString();
        s = new File(s);
        File file = new File((new StringBuilder()).append(context).append("/icons").toString());
        if (!file.exists())
        {
            file.mkdirs();
        }
        context = new File((new StringBuilder()).append(context).append("/icons/i_").append(s1).toString());
        if (!s.exists())
        {
            return false;
        }
        if (!context.exists())
        {
            context.createNewFile();
        }
        FileUtils.b(s, context);
        return true;
    }

    public static int b(Activity activity, String s, ItemType itemtype)
    {
        s = s.substring(s.lastIndexOf(File.separator) + 1);
        activity = a(activity, "", itemtype);
        if (activity != null)
        {
            for (int j = 0; j < activity.length(); j++)
            {
                itemtype = activity.optJSONObject(j);
                if (itemtype.optString("name").equals(s))
                {
                    return itemtype.optInt("colorFillType");
                }
            }

        }
        return 1;
    }

    public static int b(String s, ItemType itemtype, boolean flag)
    {
        return Math.min(c(s, itemtype, flag).size(), 20);
    }

    public static ArrayList b(String s, ItemType itemtype)
    {
        Object obj = null;
        g = itemtype.getValue();
        s = new File((new StringBuilder()).append(s).append("/").append(d_[g]).toString());
        if (s.exists())
        {
            s = FileUtils.c(s);
        } else
        {
            s = null;
        }
        itemtype = obj;
        if (s != null)
        {
            itemtype = s.optJSONArray(c[g]);
        }
        return i.a(itemtype);
    }

    public static void b(Context context, ItemType itemtype, c c1, int j)
    {
        g = itemtype.getValue();
        String s;
        String s1;
        String s2;
        Object obj;
        File file;
        int k;
        if (itemtype.getValue() == ItemType.CLIPART.getValue())
        {
            if (c1.v.equals("mask"))
            {
                k = 1;
            } else
            if (c1.v.equals("absolute"))
            {
                k = 0;
            } else
            {
                k = -1;
            }
        } else
        {
            k = 0;
        }
        itemtype = c1.k;
        s1 = (new StringBuilder()).append(SocialinV3.SHOP_PACKAGE_ICON_URL).append("_240/").append(itemtype.substring(0, itemtype.lastIndexOf("."))).append("/").append(c1.l).toString();
        obj = c1.m;
        s2 = c1.k.substring(0, c1.k.lastIndexOf("."));
        itemtype = a(context);
        s = (new StringBuilder()).append(b[g]).append(s2).append("_").append(((String) (obj)).substring(((String) (obj)).lastIndexOf("_") + 1, ((String) (obj)).lastIndexOf("."))).toString();
        obj = com.picsart.shop.a.a(context).a(c1.j, ((String) (obj)));
        ((ByteArrayInputStream) (obj)).close();
        file = new File((new StringBuilder()).append(itemtype).append("/").append(s).toString());
        if (!file.exists())
        {
            file.createNewFile();
        }
        FileUtils.a(((java.io.InputStream) (obj)), new FileOutputStream(file));
        if (!a(context, (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808dc)).append("/").append(context.getString(0x7f0808dd)).append("/").append(s2).append("_").append(c1.l).toString(), s))
        {
            context = com.picsart.shop.a.a(context).a(c1.j, c1.l);
            c1 = new File((new StringBuilder()).append(itemtype).append("/icons").toString());
            if (!c1.exists())
            {
                c1.mkdirs();
            }
            c1 = new File((new StringBuilder()).append(itemtype).append("/icons/i_").append(s).toString());
            if (!c1.exists())
            {
                c1.createNewFile();
            }
            FileUtils.a(context, new FileOutputStream(c1));
        }
        a(itemtype, s, s1, j, k);
_L1:
        return;
        context;
        context = new File((new StringBuilder()).append(itemtype).append("/").append(s).toString());
        if (context.exists())
        {
            context.delete();
            return;
        }
          goto _L1
        context;
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
        return;
    }

    public static String c(Activity activity, String s, ItemType itemtype)
    {
        s = s.substring(s.lastIndexOf(File.separator) + 1);
        activity = a(activity, "", itemtype);
        if (activity != null)
        {
            for (int j = 0; j < activity.length(); j++)
            {
                itemtype = activity.optJSONObject(j);
                if (itemtype.optString("name").equals(s))
                {
                    return itemtype.optString("itemIconUrl");
                }
            }

        }
        return "";
    }

    private static List c(String s, ItemType itemtype, boolean flag)
    {
        int j = 0;
        g = itemtype.getValue();
        ArrayList arraylist = new ArrayList();
        Object obj;
        boolean flag1;
        if (s.contains("icons") && itemtype.getValue() != ItemType.TEXTART.getValue())
        {
            flag1 = true;
            obj = s.substring(0, s.lastIndexOf(File.separator));
        } else
        {
            obj = s;
            flag1 = false;
        }
        obj = a(((Context) (null)), ((String) (obj)), itemtype);
        if (obj != null)
        {
            int k = ((JSONArray) (obj)).length();
            while (j < k) 
            {
                JSONObject jsonobject = ((JSONArray) (obj)).optJSONObject(j);
                if (flag1)
                {
                    itemtype = (new StringBuilder("i_")).append(jsonobject.optString("name")).toString();
                } else
                {
                    itemtype = jsonobject.optString("name");
                }
                itemtype = new File((new StringBuilder()).append(s).append("/").append(itemtype).toString());
                if (flag && !jsonobject.optString("itemIconUrl").equals("") && arraylist.size() < 20)
                {
                    arraylist.add(itemtype);
                }
                if (!flag && arraylist.size() < 20)
                {
                    arraylist.add(itemtype);
                }
                j++;
            }
        }
        return arraylist;
    }

    public static String d(Activity activity, String s, ItemType itemtype)
    {
        int j = 0;
        s = s.substring(s.lastIndexOf(File.separator) + 1);
        s = s.substring(s.indexOf("i_", 0), s.length());
        activity = a(activity, "", itemtype);
        if (activity != null)
        {
            for (; j < activity.length(); j++)
            {
                itemtype = activity.optJSONObject(j);
                if (itemtype.optString("name").equals(s))
                {
                    return itemtype.optString("itemIconUrl");
                }
            }

        }
        return "";
    }

}
