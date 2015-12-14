// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.bumptech.glide.b;
import com.picsart.shop.a;
import com.picsart.studio.ImagePickerActivity;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.f;
import com.socialin.android.colorpicker.g;
import com.socialin.android.d;
import com.socialin.android.photo.h;
import com.socialin.android.photo.i;
import com.socialin.android.photo.j;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import com.socialin.android.util.y;
import com.socialin.android.util.z;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.collage:
//            a

public class SelectCollageBgActivity extends AdBaseActivity
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, i, j
{

    private static final String a = com/socialin/android/photo/collage/SelectCollageBgActivity.getSimpleName();
    private String b;
    private int c;
    private ArrayList d;
    private String e;
    private WeakReference f;
    private com.socialin.android.net.a g;
    private h h;
    private myobfuscated.cb.f i;
    private com.bumptech.glide.g j;
    private boolean k;
    private boolean l;
    private Mode m;
    private boolean n;
    private RecyclerView o;
    private int p;
    private com.socialin.android.colorpicker.c q;

    public SelectCollageBgActivity()
    {
        b = null;
        c = 0;
        d = new ArrayList();
        g = myobfuscated.f.m.b(this);
        h = new h(this, this);
        k = true;
        l = false;
        m = Mode.OTHER;
        n = false;
        o = null;
        p = 4;
        q = new com.socialin.android.colorpicker.c() {

            private SelectCollageBgActivity a;

            public final void a(int i1)
            {
                com.socialin.android.photo.collage.SelectCollageBgActivity.a(a, i1);
                AnalyticUtils.getInstance(a).trackLocalAction("collageBg:color");
            }

            
            {
                a = SelectCollageBgActivity.this;
                super();
            }
        };
    }

    static int a(SelectCollageBgActivity selectcollagebgactivity)
    {
        return selectcollagebgactivity.p;
    }

    private void a()
    {
        a(b, false, ((HashMap) (null)), 0);
    }

    static void a(SelectCollageBgActivity selectcollagebgactivity, int i1)
    {
        int j1 = (int)Math.sqrt(PicsartContext.a.getMaxImageSizePixel());
        android.graphics.Bitmap bitmap = com.socialin.android.util.c.a(j1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(bitmap)).drawColor(i1);
        File file = w.a(selectcollagebgactivity.getResources().getString(0x7f08096b), (new StringBuilder()).append(selectcollagebgactivity.getString(0x7f0808fc)).append("_").append(System.currentTimeMillis()).toString(), bitmap, selectcollagebgactivity, android.graphics.Bitmap.CompressFormat.JPEG, false);
        com.socialin.android.util.c.a(bitmap);
        if (file != null)
        {
            selectcollagebgactivity.a(file.getAbsolutePath(), false, ((HashMap) (null)), 0);
            return;
        } else
        {
            Utils.a(selectcollagebgactivity, 0x7f08061e);
            return;
        }
    }

    public static void a(SelectCollageBgActivity selectcollagebgactivity, String s, String s1, String s2)
    {
        selectcollagebgactivity.a(s, s1, s2);
    }

    private void a(String s, String s1, String s2)
    {
        (new Thread((new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/").append(s1).toString(), s, s2) {

            final SelectCollageBgActivity a;
            private String b;
            private String c;
            private String d;

            public final void run()
            {
                boolean flag = com.socialin.android.photo.collage.SelectCollageBgActivity.b(a, b, c, d);
                if (flag)
                {
                    SelectCollageBgActivity.e(a);
                }
                if (!flag)
                {
                    a.runOnUiThread(new Runnable(this) {

                        private _cls3 a;

                        public final void run()
                        {
                            if (!a.a.isFinishing())
                            {
                                Utils.c(a.a, a.a.getString(0x7f08024e));
                            }
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                }
            }

            
            {
                a = SelectCollageBgActivity.this;
                b = s;
                c = s1;
                d = s2;
                super();
            }
        }).start();
    }

    private void a(String s, boolean flag, HashMap hashmap, int i1)
    {
        Intent intent = new Intent();
        intent.putExtra("path", s);
        intent.putExtra("bufferData", hashmap);
        intent.putExtra("degree", i1);
        intent.putExtra("fromGallery", flag);
        intent.putExtra("origin", "collage");
        setResult(-1, intent);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("collageBg:exit");
    }

    private boolean a(boolean flag, String s, String s1, String s2)
    {
        boolean flag1;
        flag1 = true;
        File file = FileUtils.a(s, s2);
        if (file.canRead())
        {
            b = file.getAbsolutePath();
            com.socialin.android.d.b("Cache Hit -_- ", new Object[] {
                file.getAbsolutePath()
            });
        }
        flag = flag1;
        if (file.canRead())
        {
            break MISSING_BLOCK_LABEL_106;
        }
        s1 = com.picsart.shop.a.a(getApplicationContext()).a(s1, s2);
        s = FileUtils.a(s, s2, s1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (s.canRead())
        {
            b = s.getAbsolutePath();
        }
        s1.close();
        flag = flag1;
_L1:
        if (b == null)
        {
            return false;
        } else
        {
            return flag;
        }
        s;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
        });
        flag = false;
          goto _L1
    }

    public static int b(SelectCollageBgActivity selectcollagebgactivity)
    {
        return selectcollagebgactivity.c;
    }

    static boolean b(SelectCollageBgActivity selectcollagebgactivity, String s, String s1, String s2)
    {
        return selectcollagebgactivity.a(true, s, s1, s2);
    }

    public static ArrayList c(SelectCollageBgActivity selectcollagebgactivity)
    {
        return selectcollagebgactivity.d;
    }

    public static Mode d(SelectCollageBgActivity selectcollagebgactivity)
    {
        return selectcollagebgactivity.m;
    }

    private String d(int i1)
    {
        if (m == Mode.DRAWING)
        {
            return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("drawing_texture/").append(Utils.b()).append("/texture_").append(i1).append(".jpg").toString();
        } else
        {
            return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_bg_ver3/").append(Utils.b()).append("/collage_bg_").append(i1).append(".jpg").toString();
        }
    }

    private void e(int i1)
    {
        com.socialin.android.photo.h.a(this, i1, g);
    }

    static void e(SelectCollageBgActivity selectcollagebgactivity)
    {
        selectcollagebgactivity.a();
    }

    public final void a(int i1)
    {
        String s = c(i1);
        if ((new File(s)).exists())
        {
            b = s;
            a();
            return;
        } else
        {
            h.a = i1;
            h.b = s;
            h.a();
            e(i1);
            return;
        }
    }

    public final String b(int i1)
    {
        if (m == Mode.DRAWING)
        {
            return d(com.socialin.android.photo.collage.a.b[i1]);
        } else
        {
            return d(com.socialin.android.photo.collage.a.a[i1]);
        }
    }

    public final String c(int i1)
    {
        if (m == Mode.DRAWING)
        {
            return (new StringBuilder()).append(e).append("texture_").append(com.socialin.android.photo.collage.a.b[i1]).toString();
        } else
        {
            return (new StringBuilder()).append(e).append("collage_bg_").append(com.socialin.android.photo.collage.a.a[i1]).toString();
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public final int getCount()
    {
        if (m == Mode.DRAWING)
        {
            int ai[] = com.socialin.android.photo.collage.a.b;
            return 23;
        } else
        {
            int ai1[] = com.socialin.android.photo.collage.a.a;
            return 43;
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 12 12: default 32
    //                   12 33;
           goto _L2 _L3
_L2:
        return;
_L3:
        String s = intent.getExtras().getString("path");
        i1 = intent.getExtras().getInt("degree");
        HashMap hashmap = null;
        if (intent.hasExtra("bufferData"))
        {
            hashmap = (HashMap)intent.getSerializableExtra("bufferData");
        }
        a(s, true, hashmap, i1);
        return;
    }

    public void onClick(View view)
    {
        int i1 = view.getId();
        if (i1 == 0x7f10080a)
        {
            view = q;
            g g1 = new g();
            g1.a = view;
            g1.e = 0xff00ff00;
            g1.f = 0xff00ff00;
            g1.c = true;
            view = g1.a(this);
            f = new WeakReference(view);
            if (!view.isShowing())
            {
                view.show();
            }
        } else
        if (i1 == 0x7f10080b)
        {
            view = new Intent(this, com/picsart/studio/ImagePickerActivity);
            view.putExtra("from", "collage");
            view.putExtra("showCameraEffects", true);
            myobfuscated.cv.c.a(view, this);
            startActivityForResult(view, 12);
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (f != null)
        {
            Object obj = (f)f.get();
            if (obj != null && ((f) (obj)).isShowing())
            {
                int i1 = ((f) (obj)).b();
                ((f) (obj)).dismiss();
                configuration = q;
                int k1 = ((f) (obj)).a;
                obj = new g();
                obj.a = configuration;
                obj.e = k1;
                obj.f = i1;
                obj.c = true;
                configuration = ((g) (obj)).a(this);
                f = new WeakReference(configuration);
                if (!configuration.isShowing())
                {
                    configuration.show();
                }
            }
        }
        int j1;
        if (m == Mode.DRAWING)
        {
            j1 = getResources().getInteger(0x7f0e0003);
        } else
        {
            j1 = getResources().getInteger(0x7f0e0002);
        }
        o.setLayoutManager(new GridLayoutManager(getApplicationContext(), j1));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        AnalyticUtils.getInstance(this).trackLocalAction("collageBg:onCreate");
        bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("extra.mode"))
        {
            m = (Mode)bundle.getSerializable("extra.mode");
        }
        p = (int)Utils.a(p, getApplicationContext());
        n = SocialinV3.getInstance().isRegistered();
        setContentView(0x7f0301ac);
        if (bundle != null)
        {
            k = bundle.getBoolean("showColorPanel", true);
        }
        if (bundle != null)
        {
            l = bundle.getBoolean("showGalleryPanel", false);
        }
        if (m == Mode.DRAWING)
        {
            k = false;
            l = false;
        }
        int i1;
        if (m == Mode.DRAWING)
        {
            e = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/drawing_texture/").toString();
        } else
        {
            e = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/collage_bg_ver3/").toString();
        }
        if (!k)
        {
            findViewById(0x7f10080a).setVisibility(8);
        } else
        {
            findViewById(0x7f10080a).setVisibility(0);
        }
        if (l)
        {
            findViewById(0x7f10080b).setVisibility(0);
        } else
        {
            findViewById(0x7f10080b).setVisibility(8);
        }
        i = new myobfuscated.cb.f();
        if (m == Mode.DRAWING)
        {
            i1 = getResources().getInteger(0x7f0e0003);
        } else
        {
            i1 = getResources().getInteger(0x7f0e0002);
        }
        o = (RecyclerView)findViewById(0x7f100808);
        o.setLayoutManager(new GridLayoutManager(getApplicationContext(), i1));
        o.setAdapter(i);
        j = new com.bumptech.glide.g();
        bundle = new com.picsart.studio.j(com.bumptech.glide.b.a(this), i, j);
        o.setOnScrollListener(bundle);
        o.setItemViewCacheSize(0);
        o.addItemDecoration(new android.support.v7.widget.RecyclerView.ItemDecoration() {

            private SelectCollageBgActivity a;

            public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
            {
                super.getItemOffsets(rect, view, recyclerview, state);
                rect.set(com.socialin.android.photo.collage.SelectCollageBgActivity.a(a), com.socialin.android.photo.collage.SelectCollageBgActivity.a(a), com.socialin.android.photo.collage.SelectCollageBgActivity.a(a), com.socialin.android.photo.collage.SelectCollageBgActivity.a(a));
            }

            
            {
                a = SelectCollageBgActivity.this;
                super();
            }
        });
        o.addOnItemTouchListener(new y(getApplicationContext(), new z(this)));
        findViewById(0x7f10080a).setOnClickListener(this);
        findViewById(0x7f10080b).setOnClickListener(this);
        bundle = getSupportActionBar();
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        bundle.setTitle(0x7f080608);
        bundle.setDisplayHomeAsUpEnabled(true);
        e(-1);
        initAd();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        w.c((new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/photoid_collage_bg").toString());
        w.c((new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/collage_bg_ver2").toString());
        w.c((new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/collage_bg").toString());
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        if (i1 < c)
        {
            adapterview = (myobfuscated.cb.c)d.get(i1);
            a(((myobfuscated.cb.c) (adapterview)).j, ((myobfuscated.cb.c) (adapterview)).k, ((myobfuscated.cb.c) (adapterview)).m);
            AnalyticUtils.getInstance(this).trackLocalAction("collageBg:load_shop_item");
            return;
        } else
        {
            a(i1 - c);
            AnalyticUtils.getInstance(this).trackLocalAction("collageBg:start_download");
            return;
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            setResult(1);
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("collageBg:exit");
        }
        return super.onKeyDown(i1, keyevent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("collageBg:back");
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onResume()
    {
        super.onResume();
        boolean flag;
        if (!SocialinV3.getInstance().isRegistered())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag != n)
        {
            myobfuscated.cb.f f1;
            if (!n)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            n = flag;
            f1 = i;
            f1.a.clear();
            f1.notifyDataSetChanged();
            if (m == Mode.DRAWING)
            {
                int ai[] = com.socialin.android.photo.collage.a.b;
                for (int i1 = 0; i1 < 23; i1++)
                {
                    int i2 = ai[i1];
                    myobfuscated.cb.c c3 = new myobfuscated.cb.c();
                    c3.c = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("drawing_texture/icons/i_texture_").append(i2).append(".jpg").toString();
                    c3.i = false;
                    i.a(c3);
                }

            } else
            {
                c = 0;
                ArrayList arraylist = com.picsart.shop.a.a(getApplicationContext()).b();
                if (arraylist != null)
                {
                    int j1 = arraylist.size() - 1;
                    while (j1 >= 0) 
                    {
                        Object obj = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.get(j1);
                        if (((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj)).isVisible && ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj)).installed)
                        {
                            try
                            {
                                if ((new JSONObject(((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj)).data.propsJson)).optBoolean("has_collage_bg", false))
                                {
                                    obj = com.picsart.shop.a.a(getApplicationContext()).a(this, ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj)).data.shopItemUid, 3);
                                    c = c + ((List) (obj)).size();
                                    d.addAll(((java.util.Collection) (obj)));
                                }
                            }
                            catch (Exception exception)
                            {
                                com.socialin.android.d.b(a, new Object[] {
                                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                                });
                            }
                        }
                        j1--;
                    }
                }
                for (int k1 = 0; k1 < d.size(); k1++)
                {
                    myobfuscated.cb.c c1 = (myobfuscated.cb.c)d.get(k1);
                    i.a(c1);
                }

                int l1 = 0;
                do
                {
                    int ai1[] = com.socialin.android.photo.collage.a.a;
                    if (l1 >= 43)
                    {
                        break;
                    }
                    myobfuscated.cb.c c2 = new myobfuscated.cb.c();
                    c2.c = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_bg_ver3/icons/i_collage_bg_").append(com.socialin.android.photo.collage.a.a[l1]).append(".jpg").toString();
                    c2.i = false;
                    i.a(c2);
                    l1++;
                } while (true);
            }
        }
    }

    public void onStart()
    {
        super.onStart();
        if (g != null)
        {
            g.a(h);
        }
    }

    public void onStop()
    {
        super.onStop();
        if (g != null)
        {
            g.b();
        }
    }


    private class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode DRAWING;
        public static final Mode OTHER;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/socialin/android/photo/collage/SelectCollageBgActivity$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            DRAWING = new Mode("DRAWING", 0);
            OTHER = new Mode("OTHER", 1);
            $VALUES = (new Mode[] {
                DRAWING, OTHER
            });
        }

        private Mode(String s, int i1)
        {
            super(s, i1);
        }
    }

}
