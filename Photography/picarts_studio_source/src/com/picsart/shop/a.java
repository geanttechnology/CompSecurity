// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.apiv3.util.PublicSyncInventory;
import com.socialin.android.d;
import com.socialin.android.photo.template.Template;
import com.socialin.android.photo.template.i;
import com.socialin.android.photo.textart.TextArtStyle;
import com.socialin.android.photo.textart.TypefaceSpec;
import com.socialin.android.util.Utils;
import com.socialin.android.util.t;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import myobfuscated.cb.c;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{

    public static final String d = (new StringBuilder()).append(com/picsart/shop/a.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    public static final Uri e = Uri.parse("content://com.picsart.studio.provider/user.shop.items.update");
    private static a g = null;
    private static final String i;
    private static boolean j;
    public t a;
    myobfuscated.cp.a b;
    public String c;
    public Context f;
    private String h;

    private a(Context context)
    {
        a = new t();
        b = new myobfuscated.cp.a();
        c = null;
        h = null;
        f = null;
        if (context != null)
        {
            f = context;
            c(context);
        }
    }

    public static a a()
    {
        if (g == null)
        {
            g = new a(null);
        }
        return g;
    }

    public static a a(Context context)
    {
        if (g == null)
        {
            g = new a(context);
        }
        return g;
    }

    public static String a(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        return (new StringBuilder()).append(shopitem.data.baseUrl).append("package_icon/").append(shopitem.data.shopItemUid).append("_icons/banner_1.jpg").toString();
    }

    public static String a(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem, int k)
    {
        if ("small".equalsIgnoreCase(shopitem.data.previewSize) || shopitem.data.previewSize == null)
        {
            return (new StringBuilder()).append(shopitem.data.baseUrl).append("package_icon/").append(shopitem.data.shopItemUid).append("_icons/").append(shopitem.data.namePrefix).append("_").append(k).append(".png").toString();
        } else
        {
            return (new StringBuilder()).append(shopitem.data.baseUrl).append("package_icon_").append(shopitem.data.previewSize).append("/").append(shopitem.data.shopItemUid).append("_icons/").append(shopitem.data.namePrefix).append("_").append(k).append(".png").toString();
        }
    }

    public static String a(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem, String s)
    {
        return (new StringBuilder()).append(shopitem.data.baseUrl).append("promo/").append(s).append(".jpg").toString();
    }

    public static double b(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if ((s = Pattern.compile("\\d+\\.?\\d+").matcher(s.replace(",", "."))).find())
            {
                double d1;
                try
                {
                    d1 = Double.parseDouble(s.group());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return 0.0D;
                }
                return d1;
            }
        }
        return 0.0D;
    }

    public static String b(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        return (new StringBuilder()).append(shopitem.data.baseUrl).append("package_icon/").append(shopitem.data.shopItemUid).append("_icons/category_icon_mini.png").toString();
    }

    public static String b(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem, int k)
    {
        return (new StringBuilder()).append(shopitem.data.baseUrl).append("package_icon/").append(shopitem.data.shopItemUid).append("_icons/mini/").append(shopitem.data.namePrefix).append("_").append(k).append(".png").toString();
    }

    public static String c(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        return (new StringBuilder()).append(shopitem.data.baseUrl).append("package_icon/").append(shopitem.data.shopItemUid).append("_icons/category_icon.png").toString();
    }

    public static String c(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return "$";
        }
        String s1 = String.valueOf(b(s));
        if (s.contains(s1))
        {
            return s.replace(s1, "").trim();
        } else
        {
            return s.replace(s1.replace(".", ","), "").trim();
        }
    }

    private static boolean d(String s, String s1)
    {
        Object obj1 = new ArrayList();
        Object obj = Inventory.getUserShopItems();
_L2:
        obj = ((ArrayList) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)((Iterator) (obj)).next();
        } while (!((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj1)).data.shopItemUid.equals(s));
        JSONException jsonexception;
        try
        {
            s = new JSONObject(((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj1)).data.propsJson);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
            s = null;
        }
        return s != null && s.optBoolean(s1, false);
        jsonexception;
_L3:
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(jsonexception.getMessage()).toString()
        });
        jsonexception = ((JSONException) (obj1));
        if (true) goto _L2; else goto _L1
_L1:
        return false;
        jsonexception;
          goto _L3
    }

    public final ByteArrayInputStream a(String s, String s1)
    {
        return new ByteArrayInputStream(c(s, s1));
    }

    public final List a(Context context, String s)
    {
        Object obj;
        String s1;
        obj = Collections.emptyList();
        if (s == null)
        {
            return ((List) (obj));
        }
        s1 = (new StringBuilder()).append(b(context)).append(s).toString();
        context = new RandomAccessFile(s1, "r");
        Context context1 = context;
        a.a(context, s1);
        context1 = context;
        s = (new StringBuilder()).append(s).append(".json").toString();
        context1 = context;
        ArrayList arraylist = com.socialin.android.photo.template.i.a((new JSONObject(new String(a.a(s)))).getJSONArray("collage_frames"));
        context1 = context;
        Object obj1 = new ArrayList(15);
        int k = 0;
_L2:
        context1 = context;
        if (k >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        context1 = context;
        obj = new c();
        context1 = context;
        obj.a = arraylist.get(k);
        context1 = context;
        obj.j = s1;
        context1 = context;
        obj.k = s;
        context1 = context;
        obj.l = ((Template)arraylist.get(k)).i;
        context1 = context;
        obj.m = ((Template)arraylist.get(k)).h;
        context1 = context;
        obj.i = true;
        context1 = context;
        ((List) (obj1)).add(obj);
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
            });
            return ((List) (obj1));
        }
        return ((List) (obj1));
        context;
        s = null;
_L12:
        obj1 = obj;
        obj = context;
        context = s;
        s = ((String) (obj1));
_L7:
        context1 = context;
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
        if (!j && context == null)
        {
            try
            {
                throw new AssertionError();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.socialin.android.d.b(d, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
                });
            }
            return s;
        }
        context.close();
        return s;
        context;
        context1 = null;
_L8:
        if (j || context1 != null) goto _L4; else goto _L3
_L3:
        try
        {
            throw new AssertionError();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
        }
_L6:
        throw context;
_L4:
        context1.close();
        if (true) goto _L6; else goto _L5
_L5:
        s;
        context = null;
_L10:
        obj1 = s;
        s = ((String) (obj));
        obj = obj1;
          goto _L7
        s;
        context = null;
_L9:
        obj1 = s;
        s = ((String) (obj));
        obj = obj1;
          goto _L7
        context;
          goto _L8
        s;
          goto _L9
        s;
        obj = obj1;
          goto _L9
        s;
          goto _L10
        s;
        obj = obj1;
          goto _L10
        obj1;
        s = context;
        context = ((Context) (obj1));
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        obj = obj1;
        s = context;
        context = numberformatexception;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public final List a(Context context, String s, int k)
    {
        Object obj1;
        String s2;
        obj1 = Collections.emptyList();
        if (s == null)
        {
            return ((List) (obj1));
        }
        s2 = (new StringBuilder()).append(b(context)).append(s).toString();
        Object obj = new RandomAccessFile(s2, "r");
        Object obj2 = obj;
        a.a(((RandomAccessFile) (obj)), s2);
        obj2 = obj;
        String s3 = (new StringBuilder()).append(s).append(".json").toString();
        obj2 = obj;
        context = new JSONObject(new String(a.a(s3)));
        k;
        JVM INSTR tableswitch 1 6: default 829
    //                   1 445
    //                   2 460
    //                   3 475
    //                   4 829
    //                   5 505
    //                   6 490;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6
_L19:
        obj2 = obj;
        s = new ArrayList(15);
        k = 0;
_L8:
        obj2 = obj;
        if (k >= context.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj;
        Object obj3 = context.getJSONObject(k);
        obj2 = obj;
        obj1 = ((JSONObject) (obj3)).optString("icon");
        obj2 = obj;
        String s4 = ((JSONObject) (obj3)).optString("item");
        obj2 = obj;
        String s5 = ((JSONObject) (obj3)).optString("type");
        obj2 = obj;
        String s6 = ((JSONObject) (obj3)).optString("name");
        obj2 = obj;
        String s7 = ((JSONObject) (obj3)).optString("blending", "normal");
        obj2 = obj;
        String s8 = ((JSONObject) (obj3)).optString("fill_type", "mask");
        obj2 = obj;
        obj3 = ((JSONObject) (obj3)).optString("orientation");
        obj2 = obj;
        c c1 = new c();
        obj2 = obj;
        c1.j = s2;
        obj2 = obj;
        c1.k = s3;
        obj2 = obj;
        c1.l = ((String) (obj1));
        obj2 = obj;
        c1.m = s4;
        obj2 = obj;
        c1.t = ((String) (obj3));
        obj2 = obj;
        c1.s = s6;
        obj2 = obj;
        c1.u = s5;
        obj2 = obj;
        c1.v = s8;
        obj2 = obj;
        c1.i = true;
        obj2 = obj;
        c1.x = s7;
        obj2 = obj;
        s.add(c1);
        k++;
        if (true) goto _L8; else goto _L7
_L2:
        obj2 = obj;
        context = context.getJSONArray("cliparts");
        continue; /* Loop/switch isn't completed */
_L3:
        obj2 = obj;
        context = context.getJSONArray("frames");
        continue; /* Loop/switch isn't completed */
_L4:
        obj2 = obj;
        context = context.getJSONArray("collage_backgrounds");
        continue; /* Loop/switch isn't completed */
_L6:
        obj2 = obj;
        context = context.getJSONArray("texts");
        continue; /* Loop/switch isn't completed */
_L5:
        obj2 = obj;
        context = context.getJSONArray("masks");
        continue; /* Loop/switch isn't completed */
_L7:
        try
        {
            ((RandomAccessFile) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
            });
            return s;
        }
        return s;
        context;
        obj = obj1;
        s = null;
_L17:
        obj1 = context;
        context = s;
        s = ((String) (obj));
_L13:
        obj2 = context;
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj1)).getMessage()).toString()
        });
        if (!j && context == null)
        {
            try
            {
                throw new AssertionError();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.socialin.android.d.b(d, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
                });
            }
            return s;
        }
        context.close();
        return s;
        context;
        obj2 = null;
_L14:
        if (j || obj2 != null) goto _L10; else goto _L9
_L9:
        try
        {
            throw new AssertionError();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
        }
_L12:
        throw context;
_L10:
        ((RandomAccessFile) (obj2)).close();
        if (true) goto _L12; else goto _L11
_L11:
        context;
        obj = null;
_L15:
        s = ((String) (obj1));
        obj1 = context;
        context = ((Context) (obj));
          goto _L13
        context;
        obj = null;
_L16:
        s = ((String) (obj1));
        obj1 = context;
        context = ((Context) (obj));
          goto _L13
        context;
          goto _L14
        context;
          goto _L15
        context;
        obj1 = s;
          goto _L15
        context;
          goto _L16
        context;
        obj1 = s;
          goto _L16
        context;
        s = ((String) (obj));
        obj = obj1;
          goto _L17
        context;
        String s1 = s;
        s = ((String) (obj));
        obj = s1;
          goto _L17
_L1:
        context = null;
        if (true) goto _L19; else goto _L18
_L18:
    }

    public final void a(Context context, String s, String s1, c c1, myobfuscated.cp.c c2)
    {
        if (c == null)
        {
            c(context);
        }
        context = (new StringBuilder()).append(d(s)).append(s).toString();
        b.a(context, c, c1, s1, c2);
    }

    public final void a(Context context, String s, String s1, myobfuscated.cp.c c1)
    {
        a(context, s, s1, null, c1);
    }

    public final void a(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem, Exception exception, String s, c c1)
    {
        t.b(s);
        s = (new StringBuilder()).append(d(shopitem.data.shopItemUid)).append(shopitem.data.shopItemUid).toString();
        b.a(s, c, c1, shopitem.data.shopItemUid);
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
    }

    public final void a(List list)
    {
        String s;
        Object obj;
        int k;
        boolean flag;
        ArrayList arraylist = b();
        com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem;
        Iterator iterator;
        if (f != null)
        {
            s = Utils.f(f);
        } else
        {
            s = "";
        }
        list = list.iterator();
        String as[];
        int l;
        if (list.hasNext())
        {
            shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)list.next();
            iterator = arraylist.iterator();
        } else
        {
            return;
        }
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_27;
        }
        obj = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator.next();
        if (shopitem.data.shopItemUid.equals(((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj)).data.shopItemUid))
        {
            shopitem.installed = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj)).installed;
            shopitem.installing = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj)).installing;
            shopitem.isVisible = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj)).isVisible;
            shopitem.owned = true;
        }
        if ("".equals(s))
        {
            break MISSING_BLOCK_LABEL_268;
        }
        if (shopitem.data.promotion == null) goto _L2; else goto _L1
_L1:
        obj = shopitem.data.promotion.networkOperator;
        if (obj != null && !"".equals(obj)) goto _L4; else goto _L3
_L3:
        k = 0;
_L6:
        if (k == 0)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        flag = true;
_L8:
        shopitem.promoted = flag;
        break MISSING_BLOCK_LABEL_53;
_L4:
        as = ((String) (obj)).split(",");
        l = as.length;
        k = 0;
_L7:
        if (k >= l) goto _L2; else goto _L5
_L5:
label0:
        {
            if (!s.equals(as[k].trim()))
            {
                break label0;
            }
            k = 1;
        }
          goto _L6
        k++;
          goto _L7
_L2:
        k = 0;
          goto _L6
        flag = false;
          goto _L8
    }

    public final boolean a(String s)
    {
        return (new File((new StringBuilder()).append(c).append(s).toString())).exists();
    }

    public final String b(Context context)
    {
        if (c == null)
        {
            c(context);
        }
        return c;
    }

    public final ArrayList b()
    {
        Object obj;
        Iterator iterator;
        obj = Inventory.getUserShopItems();
        iterator = ((ArrayList) (obj)).iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem;
        shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator.next();
        shopitem.owned = true;
        if (!"ad_remover".equalsIgnoreCase(shopitem.data.shopItemUid)) goto _L4; else goto _L3
_L3:
        boolean flag;
        if (!Inventory.isAdsEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shopitem.installed = flag;
          goto _L5
        obj;
_L7:
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
        return new ArrayList();
_L4:
        shopitem.installed = a(shopitem.data.shopItemUid);
        shopitem.installing = a((new StringBuilder()).append(shopitem.data.shopItemUid).append(".part").toString());
          goto _L5
_L2:
        for (Iterator iterator1 = PublicSyncInventory.readUserLocalShopItems().iterator(); !iterator1.hasNext();)
        {
            break MISSING_BLOCK_LABEL_291;
        }

        shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator1.next();
        shopitem.owned = true;
        if (!"ad_remover".equalsIgnoreCase(shopitem.data.shopItemUid))
        {
            break MISSING_BLOCK_LABEL_239;
        }
        if (!Inventory.isAdsEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shopitem.installed = flag;
_L6:
        ((ArrayList) (obj)).add(shopitem);
          goto _L2
        shopitem.installed = a(shopitem.data.shopItemUid);
        shopitem.installing = a((new StringBuilder()).append(shopitem.data.shopItemUid).append(".part").toString());
          goto _L6
        return ((ArrayList) (obj));
          goto _L2
        obj;
          goto _L7
    }

    public final ArrayList b(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        RandomAccessFile randomaccessfile = new RandomAccessFile(s, "r");
        Object obj = randomaccessfile;
        a.a(randomaccessfile, s);
        obj = randomaccessfile;
        byte abyte0[] = a.a((new StringBuilder()).append(s1).append(".json").toString());
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        obj = randomaccessfile;
        JSONArray jsonarray;
        TextArtStyle textartstyle;
        int k;
        try
        {
            throw new RuntimeException((new StringBuilder()).append(s1).append(".json file not found").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s = randomaccessfile;
        }
        finally { }
_L11:
        obj = s;
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
        });
        if (!j && s == null)
        {
            try
            {
                throw new AssertionError();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.b(d, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
                });
            }
            return arraylist;
        }
          goto _L3
_L2:
        obj = randomaccessfile;
        jsonarray = (new JSONObject(new String(abyte0))).getJSONArray("texts");
        k = 0;
_L5:
        obj = randomaccessfile;
        if (k >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = randomaccessfile;
        textartstyle = TextArtStyle.getPreviewStyleObj(true, jsonarray.getJSONObject(k).getString("text_font_type_path"));
        obj = randomaccessfile;
        textartstyle.getTypefaceSpec().setFontPackagePath(s);
        obj = randomaccessfile;
        textartstyle.getTypefaceSpec().setFontPackageName(s1);
        obj = randomaccessfile;
        arraylist.add(textartstyle);
        k++;
        if (true) goto _L5; else goto _L4
_L4:
        obj = randomaccessfile;
        t.a(a, s);
        try
        {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
            return arraylist;
        }
        return arraylist;
_L3:
        s.close();
        return arraylist;
        s;
        obj = null;
        if (j || obj != null) goto _L7; else goto _L6
_L6:
        try
        {
            throw new AssertionError();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
            });
        }
_L9:
        throw s;
_L7:
        ((RandomAccessFile) (obj)).close();
        if (true) goto _L9; else goto _L8
_L8:
        s1;
        s = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final ArrayList c()
    {
        Object obj = b();
        ArrayList arraylist = new ArrayList();
        if (TextUtils.isEmpty("has_mask"))
        {
            return arraylist;
        }
        obj = ((ArrayList) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)((Iterator) (obj)).next();
            if (!TextUtils.isEmpty(shopitem.data.propsJson))
            {
                try
                {
                    if ((new JSONObject(shopitem.data.propsJson)).optBoolean("has_mask", false))
                    {
                        arraylist.add(shopitem);
                    }
                }
                catch (JSONException jsonexception) { }
            }
        } while (true);
        return arraylist;
    }

    public final void c(Context context)
    {
        h = (new StringBuilder()).append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808dc)).append("/").append(context.getString(0x7f0808dd)).toString();
        c = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(h).append("/").toString();
    }

    public final byte[] c(String s, String s1)
    {
        try
        {
            s = m.a(s, s1, a);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
            return null;
        }
        return s;
    }

    public final String d(String s)
    {
        char c1 = '\u0400';
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.picsart.studio.PicsartContext.MemoryType.values().length];
                try
                {
                    a[com.picsart.studio.PicsartContext.MemoryType.LOW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.picsart.studio.PicsartContext.MemoryType.NORMAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.picsart.studio.PicsartContext.MemoryType.NORMAL_PLUS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.picsart.studio.PicsartContext.MemoryType.HIGH.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.picsart.studio.PicsartContext.MemoryType.XHIGH.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.picsart.studio.PicsartContext.MemoryType.XXHIGH.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[PicsartContext.a.ordinal()];
        JVM INSTR tableswitch 1 6: default 52
    //                   1 89
    //                   2 89
    //                   3 89
    //                   4 102
    //                   5 102
    //                   6 102;
           goto _L1 _L2 _L2 _L2 _L3 _L3 _L3
_L1:
        c1 = '\u0280';
_L4:
        StringBuilder stringbuilder = (new StringBuilder()).append(i);
        if (c1 == '\u0280')
        {
            s = "/";
        } else
        {
            s = (new StringBuilder("_")).append(c1).append("/").toString();
        }
        return stringbuilder.append(s).toString();
_L2:
        if (!d(s, "has_large_res")) goto _L5; else goto _L4
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        if (!d(s, "has_xlarge_res"))
        {
            continue; /* Loop/switch isn't completed */
        }
        c1 = '\u0800';
          goto _L4
        if (!d(s, "has_large_res")) goto _L1; else goto _L4
    }

    static 
    {
        boolean flag;
        if (!com/picsart/shop/a.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = flag;
        i = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("shop/package_v1").toString();
    }
}
