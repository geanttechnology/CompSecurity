// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.template.CollageFrameRes;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import myobfuscated.cb.a;
import myobfuscated.cb.c;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.clipart:
//            j

public class f extends Fragment
    implements CommonConstants
{

    private static String l = (new StringBuilder()).append(com/socialin/android/photo/clipart/f.getSimpleName()).append(System.currentTimeMillis()).toString();
    private static int n = 0;
    j f;
    g g;
    private ItemType h;
    private String i;
    private String j;
    private a k;
    private ListView m;
    private boolean o;
    private int p;
    private int q;
    private com.socialin.android.billing.d r;
    private String s;
    private int t[];
    private boolean u;

    public f()
    {
        h = ItemType.CLIPART;
        k = null;
        o = false;
        r = null;
        g = null;
        s = null;
        t = null;
        u = false;
    }

    static int a(int i1)
    {
        n = i1;
        return i1;
    }

    static a a(f f1)
    {
        return f1.k;
    }

    private void a(int i1, int ai[], int ai1[])
    {
        Object obj;
        Activity activity;
        com.picsart.shop.a a1;
        a a2;
        ArrayList arraylist;
        byte byte0;
        activity = getActivity();
        if (activity == null)
        {
            return;
        }
        AnalyticUtils.getInstance(activity).trackLocalAction("clipartCat:onCreate");
        t = ai;
        n = getActivity().getSharedPreferences("categoryIndexes", 0).getInt(e[h.getValue()], 0);
        int l1 = ai.length;
        c c3;
        android.graphics.Bitmap bitmap2;
        int j1;
        if (i1 != 1)
        {
            j1 = 0;
        } else
        {
            j1 = 1;
        }
        m = (ListView)getView().findViewById(0x7f10028b);
        k = new a(activity, m);
        k.c = n;
        if (!FileUtils.a(i))
        {
            c c1 = new c();
            c1.e = getString(ai[j1]);
            android.graphics.Bitmap bitmap = com.socialin.android.util.c.a(getResources(), ai1[j1], null, l);
            c1.f = new myobfuscated.cd.a(getResources(), bitmap);
            k.a(c1);
        }
        if (i1 == 1)
        {
            c c2 = new c();
            c2.e = getString(ai[0]);
            android.graphics.Bitmap bitmap1 = com.socialin.android.util.c.a(getResources(), ai1[0], null, l);
            c2.f = new myobfuscated.cd.a(getResources(), bitmap1);
            k.a(c2);
        }
        a1 = com.picsart.shop.a.a(activity);
        a2 = k;
        if (a1.c == null)
        {
            a1.c(activity);
        }
        arraylist = a1.b();
        if (a1.c == null)
        {
            a1.c(activity);
        }
        if (arraylist != null && arraylist.size() != 0) goto _L2; else goto _L1
_L2:
        k1 = arraylist.size() - 1;
_L33:
        if (k1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.get(k1);
        if (!shopitem.isVisible || !shopitem.installed) goto _L4; else goto _L3
_L3:
        obj = null;
        jsonobject = new JSONObject(shopitem.data.propsJson);
        obj = jsonobject;
_L9:
        if (obj == null) goto _L4; else goto _L5
_L5:
        RandomAccessFile randomaccessfile;
        boolean flag = false;
        JSONObject jsonobject1;
        Exception exception;
        String s2;
        byte abyte0[];
        if (i1 == 1 && ((JSONObject) (obj)).has("has_clipart"))
        {
            byte0 = 1;
        } else
        if (i1 == 2 && ((JSONObject) (obj)).has("has_frame"))
        {
            byte0 = 1;
        } else
        if (i1 == 4 && ((JSONObject) (obj)).has("has_collage_frame"))
        {
            byte0 = 1;
        } else
        if (i1 == 6 && ((JSONObject) (obj)).has("has_textart"))
        {
            byte0 = 1;
        } else
        {
            byte0 = flag;
            if (i1 == 5)
            {
                byte0 = flag;
                if (((JSONObject) (obj)).has("has_mask"))
                {
                    byte0 = 1;
                }
            }
        }
        if (byte0 == 0) goto _L4; else goto _L6
_L6:
        c4 = new c();
        c4.e = shopitem.data.name;
        obj = com.socialin.android.util.c.a(activity.getResources(), 0x7f020566, null, com.picsart.shop.a.d);
        c4.f = new myobfuscated.cd.a(activity.getResources(), ((android.graphics.Bitmap) (obj)));
        c4.i = true;
        c4.k = shopitem.data.shopItemUid;
        c4.p = shopitem;
        a2.a(c4);
        s1 = (new StringBuilder()).append(a1.c).append(shopitem.data.shopItemUid).toString();
        randomaccessfile = new RandomAccessFile(s1, "r");
        obj = randomaccessfile;
        a1.a.a(randomaccessfile, s1);
        obj = randomaccessfile;
        jsonobject1 = new JSONObject(new String(a1.a.a((new StringBuilder()).append(shopitem.data.shopItemUid).append(".json").toString())));
        obj = randomaccessfile;
        s2 = jsonobject1.optString("category_icon", null);
        if (s2 == null) goto _L8; else goto _L7
_L7:
        obj = randomaccessfile;
        abyte0 = a1.a.a(s2);
        obj = randomaccessfile;
        c4.f = new myobfuscated.cd.a(activity.getResources(), com.socialin.android.util.c.a(abyte0, abyte0.length));
_L16:
        obj = randomaccessfile;
        com.socialin.android.util.t.a(a1.a, s1);
        obj = randomaccessfile;
        c4.a(0);
        obj = randomaccessfile;
        c4.q = jsonobject1.optString("bg_color", null);
        Object obj1;
        try
        {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(com.picsart.shop.a.d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
            });
        }
_L4:
        k1--;
        break; /* Loop/switch isn't completed */
        exception;
        (new StringBuilder("Can't parse ++++   ")).append(shopitem.data.propsJson);
        com.socialin.android.d.b(com.picsart.shop.a.d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
          goto _L9
_L8:
        obj = randomaccessfile;
        s3 = shopitem.data.shopItemUid;
        byte0 = -1;
        obj = randomaccessfile;
        s3.hashCode();
        JVM INSTR lookupswitch 5: default 1772
    //                   -1979615343: 1284
    //                   -1558708502: 1305
    //                   -1558708501: 1326
    //                   796424543: 1242
    //                   859810130: 1263;
           goto _L10 _L11 _L12 _L13 _L14 _L15
_L26:
        obj = randomaccessfile;
        c4.f = activity.getResources().getDrawable(0x7f02010a);
          goto _L16
        obj1;
_L23:
        obj = randomaccessfile;
        a1.a(shopitem, ((Exception) (obj1)), s1, c4);
        try
        {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(com.picsart.shop.a.d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
            });
        }
          goto _L4
_L14:
        obj = randomaccessfile;
        if (s3.equals("package_mawns_font"))
        {
            byte0 = 0;
        }
          goto _L10
_L15:
        obj = randomaccessfile;
        if (s3.equals("package_mawns_font_2"))
        {
            byte0 = 1;
        }
          goto _L10
_L11:
        obj = randomaccessfile;
        if (s3.equals("package_textart_3"))
        {
            byte0 = 2;
        }
          goto _L10
_L12:
        obj = randomaccessfile;
        if (s3.equals("package_ultra_fonts_1"))
        {
            byte0 = 3;
        }
          goto _L10
_L13:
        obj = randomaccessfile;
        if (s3.equals("package_ultra_fonts_2"))
        {
            byte0 = 4;
        }
          goto _L10
_L27:
        obj = randomaccessfile;
        c4.f = activity.getResources().getDrawable(0x7f02010b);
          goto _L16
_L28:
        obj = randomaccessfile;
        c4.f = activity.getResources().getDrawable(0x7f020117);
          goto _L16
        obj1;
_L22:
        obj = randomaccessfile;
        ((Exception) (obj1)).printStackTrace();
        obj = randomaccessfile;
        a1.a(shopitem, ((Exception) (obj1)), s1, c4);
        if (shopitem == null) goto _L18; else goto _L17
_L17:
        obj = randomaccessfile;
        if (shopitem.data == null) goto _L18; else goto _L19
_L19:
        obj = randomaccessfile;
        if (shopitem.data.name == null) goto _L18; else goto _L20
_L20:
        obj = randomaccessfile;
        obj1 = shopitem.data.name;
_L24:
        obj = randomaccessfile;
        Utils.c(activity, (new StringBuilder("Can't load package ")).append(((String) (obj1))).toString());
        try
        {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(com.picsart.shop.a.d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
            });
        }
          goto _L4
_L29:
        obj = randomaccessfile;
        c4.f = activity.getResources().getDrawable(0x7f020119);
          goto _L16
        ai;
_L21:
        try
        {
            ((RandomAccessFile) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (int ai1[])
        {
            com.socialin.android.d.b(com.picsart.shop.a.d, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(ai1.getMessage()).toString()
            });
        }
        throw ai;
_L30:
        obj = randomaccessfile;
        c4.f = activity.getResources().getDrawable(0x7f02011a);
          goto _L16
_L1:
        m.setAdapter(k);
        m.setSelected(true);
        m.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(activity) {

            private Activity a;
            private f b;

            public final void onItemClick(AdapterView adapterview, View view, int i2, long l2)
            {
                if (com.socialin.android.photo.clipart.f.a(b).a(i2).i && com.socialin.android.photo.clipart.f.a(b).a(i2).w == 0 || !com.socialin.android.photo.clipart.f.a(b).a(i2).i)
                {
                    adapterview = a.findViewById(0x7f100169);
                    if (adapterview != null && (adapterview instanceof ViewPager))
                    {
                        ((ViewPager)adapterview).setCurrentItem(1, true);
                    }
                    if (f.b() != i2 || f.b(b))
                    {
                        com.socialin.android.photo.clipart.f.c(b);
                        com.socialin.android.photo.clipart.f.a(b, i2);
                    }
                    com.socialin.android.photo.clipart.f.a(i2);
                    com.socialin.android.photo.clipart.f.a(b).c = f.b();
                    com.socialin.android.photo.clipart.f.a(b).notifyDataSetChanged();
                    return;
                } else
                {
                    com.socialin.android.photo.clipart.f.a(b, a, com.socialin.android.photo.clipart.f.a(b).a(i2));
                    return;
                }
            }

            
            {
                b = f.this;
                a = activity;
                super();
            }
        });
        JSONObject jsonobject;
        com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem;
        c c4;
        String s1;
        String s3;
        int k1;
        if (n < k.getCount())
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        if (n < k.getCount())
        {
            b(n);
        }
        obj = new myobfuscated.bp.c(i1) {

            private int a;
            private f b;

            public final void a(ArrayList arraylist1)
            {
                if (b.isAdded()) goto _L2; else goto _L1
_L1:
                Object obj2;
                return;
_L2:
                if ((obj2 = b.getActivity()) == null || ((Activity) (obj2)).isFinishing()) goto _L1; else goto _L3
_L3:
                com.picsart.shop.a.a(((android.content.Context) (obj2))).a(arraylist1);
                arraylist1 = arraylist1.iterator();
_L4:
                if (!arraylist1.hasNext())
                {
                    break MISSING_BLOCK_LABEL_174;
                }
                obj2 = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist1.next();
                boolean flag1 = com.socialin.android.photo.clipart.f.a(a, new JSONObject(((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj2)).data.propsJson));
                if (flag1)
                {
                    c c5 = new c();
                    c5.o = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj2)).installed;
                    c5.r = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj2)).owned;
                    boolean flag2 = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj2)).installing;
                    c5.e = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj2)).data.name;
                    c5.g = com.picsart.shop.a.b(((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj2)));
                    c5.k = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj2)).data.shopItemUid;
                    c5.p = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj2));
                    c5.a(0);
                    com.socialin.android.photo.clipart.f.a(b).a(c5);
                }
                  goto _L4
                com.socialin.android.photo.clipart.f.a(b).a();
                com.socialin.android.photo.clipart.f.a(b).notifyDataSetChanged();
                if (f.b() < com.socialin.android.photo.clipart.f.a(b).getCount())
                {
                    com.socialin.android.photo.clipart.f.a(b, f.b());
                    return;
                }
                  goto _L1
                JSONException jsonexception;
                jsonexception;
                  goto _L4
            }

            
            {
                b = f.this;
                a = i1;
                super();
            }
        };
        for (i1 = j1 + 1; i1 < l1; i1++)
        {
            c3 = new c();
            c3.e = getString(ai[i1]);
            bitmap2 = com.socialin.android.util.c.a(getResources(), ai1[i1], null, l);
            c3.f = new myobfuscated.cd.a(getResources(), bitmap2);
            k.a(c3);
        }

        if (byte0 == 0)
        {
            b(n);
        }
        r.requestShopItems(false, ((myobfuscated.bp.c) (obj)));
        if (!activity.isFinishing())
        {
            activity.runOnUiThread(new Runnable() {

                private f a;

                public final void run()
                {
                    com.socialin.android.photo.clipart.f.a(a).notifyDataSetChanged();
                }

            
            {
                a = f.this;
                super();
            }
            });
        }
        k.a();
        return;
        ai;
        obj = null;
          goto _L21
        obj1;
        randomaccessfile = null;
          goto _L22
        obj1;
        randomaccessfile = null;
          goto _L23
        obj1;
        randomaccessfile = null;
          goto _L23
_L18:
        obj1 = "";
          goto _L24
_L10:
        byte0;
        JVM INSTR tableswitch 0 4: default 1808
    //                   0 1152
    //                   1 1347
    //                   2 1370
    //                   3 1542
    //                   4 1573;
           goto _L25 _L26 _L27 _L28 _L29 _L30
_L25:
        continue; /* Loop/switch isn't completed */
        obj1;
          goto _L23
        if (true) goto _L16; else goto _L31
_L31:
        if (true) goto _L33; else goto _L32
_L32:
        if (true) goto _L1; else goto _L34
_L34:
    }

    static void a(f f1, int i1)
    {
        f1.b(i1);
    }

    static void a(f f1, Activity activity, c c1)
    {
        if (c1.w == 1)
        {
            Utils.b(activity, 0x7f08041b);
        } else
        {
            Utils.b(activity, 0x7f08041c);
        }
        f1.m.post(f1. new Runnable(activity) {

            private Activity a;
            private f b;

            public final void run()
            {
                com.socialin.android.photo.clipart.f.d(b).setItemChecked(f.b(), true);
                View view = a.findViewById(0x7f100169);
                if (view != null && (view instanceof ViewPager))
                {
                    ((ViewPager)view).setCurrentItem(0, true);
                }
            }

            
            {
                b = f.this;
                a = activity;
                super();
            }
        });
    }

    static boolean a(int i1, JSONObject jsonobject)
    {
        while (i1 == 1 && jsonobject.has("has_clipart") || i1 == 2 && jsonobject.has("has_frame") || i1 == 4 && jsonobject.has("has_collage_frame") || i1 == 6 && jsonobject.has("has_textart")) 
        {
            return true;
        }
        return false;
    }

    static int b()
    {
        return n;
    }

    private void b(int i1)
    {
        Activity activity;
        boolean flag;
        flag = false;
        activity = getActivity();
        if (k != null && f != null && activity != null) goto _L2; else goto _L1
_L1:
        if (d.b)
        {
            com.socialin.android.d.b((new StringBuilder("adapter or selectClipArtFragment or activity is null +++++++++++++++++++")).append(f).append(" ").append(k).append(" ").append(activity).toString());
        }
_L6:
        return;
_L2:
        Object obj;
        int j1;
        j1 = i1;
        if (i1 >= k.getCount())
        {
            k.c = 0;
            k.notifyDataSetChanged();
            j1 = 0;
        }
        obj = k.a(j1);
        if ((!((c) (obj)).i || ((c) (obj)).w != 0) && ((c) (obj)).i) goto _L4; else goto _L3
_L3:
        c c1;
label0:
        {
            if (j1 < k.getCount())
            {
                n = j1;
            }
            obj = activity.getSharedPreferences("categoryIndexes", 0).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putInt(e[h.getValue()], n);
            ((android.content.SharedPreferences.Editor) (obj)).apply();
            if (j1 < k.getCount())
            {
                i1 = j1;
                if (j1 >= 0)
                {
                    break label0;
                }
            }
            i1 = 0;
        }
        c1 = k.a(i1);
        if ((!c1.i || c1.w != 0) && c1.i) goto _L6; else goto _L5
_L5:
        Intent intent;
        AnalyticUtils.getInstance(activity).trackLocalAction("clipartCat:done");
        intent = new Intent();
        if (c1.i || t == null)
        {
            break MISSING_BLOCK_LABEL_818;
        }
        obj = c1.e;
        j1 = ((flag) ? 1 : 0);
_L9:
        if (j1 >= t.length)
        {
            break MISSING_BLOCK_LABEL_818;
        }
        if (!getString(t[j1]).equals(obj)) goto _L8; else goto _L7
_L7:
        if (getResources().getString(0x7f0800ae).equals(c1.e) && (h == ItemType.CLIPART || h == ItemType.FRAME) && com.socialin.android.photo.f.a(i) != com.socialin.android.photo.f.a(activity, h))
        {
            com.socialin.android.photo.f.a(activity, j, i, h);
        }
        intent.putExtra("selectedCategory", j1);
        String s1;
        if (c1.o)
        {
            s1 = k.a(i1).k;
        } else
        {
            s1 = c1.k;
        }
        s = s1;
        if (c1.p != null && c1.p.data != null)
        {
            intent.putExtra("content", c1.p.data.content);
            intent.putExtra("brand", c1.p.data.brand);
            intent.putExtra("provider", c1.p.data.provider);
        }
        intent.putExtra("packageName", s);
        intent.putExtra("installed", c1.o);
        intent.putExtra("bgColor", c1.q);
        if (!c1.o)
        {
            intent.putExtra("selectedShopItem", c1.p);
        }
        if (p == 6)
        {
            intent.putExtra("selectedCategoryName", k.a(i1).e);
        }
        if (c1.e.equals(getResources().getString(0x7f0800b5)))
        {
            intent.putExtra("categoryMyClipart", j1);
        } else
        {
            intent.putExtra("categoryMyClipart", -1);
        }
        if (c1.e.equals(getResources().getString(0x7f0800ae)))
        {
            intent.putExtra("categoryFavorite", j1);
        } else
        {
            intent.putExtra("categoryFavorite", -1);
        }
        intent.putExtra("fromComment", u);
        if (j1 < CollageFrameRes.b.length)
        {
            intent.putExtra("readFrom", CollageFrameRes.b[j1]);
        }
        f.a(intent, c1);
        n = i1;
        k.notifyDataSetChanged();
        if (c1.e != null)
        {
            activity.setTitle(c1.e);
            return;
        }
          goto _L6
_L4:
        n = j1;
        k.c = n;
        k.notifyDataSetChanged();
        return;
_L8:
        j1++;
          goto _L9
        j1 = i1;
          goto _L7
    }

    static boolean b(f f1)
    {
        return false;
    }

    private void c()
    {
        if (getArguments() == null) goto _L2; else goto _L1
_L1:
        Bundle bundle;
        bundle = getArguments();
        p = bundle.getInt("item_type");
        q = bundle.getInt("selected_activity");
        i = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0800af)).append("/").append(d[q]).toString();
        j = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0800af)).append("/").append(d[q]).append("/icons").toString();
        if (p != 1) goto _L4; else goto _L3
_L3:
        h = ItemType.CLIPART;
_L6:
        int ai[] = bundle.getIntArray("titles");
        int ai1[] = bundle.getIntArray("icons");
        u = bundle.getBoolean("fromComment", false);
        a(p, ai, ai1);
_L2:
        return;
_L4:
        if (p == 6)
        {
            h = ItemType.TEXTART;
        } else
        if (p == 4)
        {
            h = ItemType.COLLAGE_FRAME;
        } else
        if (p == 2)
        {
            h = ItemType.FRAME;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean c(f f1)
    {
        f1.o = false;
        return false;
    }

    static ListView d(f f1)
    {
        return f1.m;
    }

    public final void a()
    {
        if (getActivity() == null || getActivity().isFinishing())
        {
            return;
        }
        if (g != null)
        {
            g.dismiss();
        }
        android.content.SharedPreferences.Editor editor = getActivity().getSharedPreferences("categoryIndexes", 0).edit();
        if (p != 1)
        {
            editor.putInt(e[h.getValue()], 0);
        } else
        if (!FileUtils.a(i))
        {
            editor.putInt(e[h.getValue()], 2);
        } else
        {
            editor.putInt(e[h.getValue()], 1);
        }
        editor.apply();
        c();
    }

    public final void a(j j1)
    {
        f = j1;
        b(n);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        l = (new StringBuilder()).append(com/socialin/android/photo/clipart/f.getSimpleName()).append(System.currentTimeMillis()).toString();
        r = myobfuscated.f.m.a(getActivity(), getString(0x7f0808be));
        c();
        g = new g(getActivity());
        g.setMessage(getString(0x7f080450));
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030068, viewgroup, false);
    }

    public void onResume()
    {
        super.onResume();
        if (k != null)
        {
            Object obj = k.a;
            if (obj != null && ((ArrayList) (obj)).size() > 0)
            {
                ArrayList arraylist = com.picsart.shop.a.a(getActivity()).b();
                Iterator iterator = ((ArrayList) (obj)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    c c2 = (c)iterator.next();
                    if (!TextUtils.isEmpty(c2.k))
                    {
                        c2.r = false;
                        c2.o = false;
                    }
                } while (true);
                for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    c c1 = (c)((Iterator) (obj)).next();
                    Iterator iterator1 = arraylist.iterator();
                    while (iterator1.hasNext()) 
                    {
                        com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator1.next();
                        if (c1.k != null && c1.k.equals(shopitem.data.shopItemUid))
                        {
                            c1.r = shopitem.owned;
                            c1.o = shopitem.installed;
                            boolean flag = shopitem.installing;
                            if (shopitem.data.shopItemUid.equals(s))
                            {
                                b(n);
                            }
                        }
                    }
                }

                k.a();
                k.notifyDataSetChanged();
            }
        }
    }

}
