// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.profile.ProfileActivity;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RemoveStreamController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Stream;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.StreamParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.a;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.picsart.profile.util.z;
import com.socialin.android.picsart.upload.PicsartUploadEditActivity;
import com.socialin.android.util.Utils;
import com.socialin.android.util.f;
import com.socialin.android.util.s;
import com.socialin.asyncnet.b;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            f, i, h, j, 
//            SliderActivity

public class MemboxItemsActivity extends BaseActivity
{

    private static final String b = (new StringBuilder()).append(com/socialin/android/picsart/profile/activity/MemboxItemsActivity.getSimpleName()).append(" - ").toString();
    protected z a;
    private long c;
    private long d;
    private ViewerUser e;
    private Stream f;
    private RecyclerView g;
    private TextView h;
    private boolean i;
    private int j;
    private BaseSocialinApiRequestController k;
    private RemoveStreamController l;
    private StreamParams m;
    private e n;
    private com.picsart.studio.d o;

    public MemboxItemsActivity()
    {
        a = null;
        f = null;
        h = null;
        i = false;
        j = 2;
        k = RequestControllerFactory.createGetStreamItemsController();
        l = new RemoveStreamController();
        m = new StreamParams();
    }

    static RecyclerView a(MemboxItemsActivity memboxitemsactivity)
    {
        return memboxitemsactivity.g;
    }

    static String a()
    {
        return b;
    }

    static void a(MemboxItemsActivity memboxitemsactivity, ImageItem imageitem)
    {
        if (imageitem == null) goto _L2; else goto _L1
_L1:
        com.socialin.android.picsart.profile.activity.f f1;
        ImageItem aimageitem[];
        f1 = (com.socialin.android.picsart.profile.activity.f)memboxitemsactivity.g.getAdapter();
        aimageitem = new ImageItem[f1.getItemCount()];
        int i1 = 0;
_L4:
        if (i1 >= aimageitem.length)
        {
            break; /* Loop/switch isn't completed */
        }
        aimageitem[i1] = f1.a(i1);
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        memboxitemsactivity.getIntent().putExtra("requestForItem", true);
        memboxitemsactivity.getIntent().putExtra("memboxId", memboxitemsactivity.f.id);
        memboxitemsactivity.getIntent().putExtra("memboxType", memboxitemsactivity.f.type);
        if (memboxitemsactivity.f.user != null)
        {
            memboxitemsactivity.getIntent().putExtra("memboxUserId", memboxitemsactivity.f.user.id);
        }
        memboxitemsactivity.getIntent().putExtra("memboxName", memboxitemsactivity.f.title);
        if (imageitem.url != null) goto _L6; else goto _L5
_L5:
        String s = null;
_L13:
        int j1 = f1.getItemCount();
        i1 = 0;
_L11:
        if (i1 >= j1) goto _L8; else goto _L7
_L7:
        if (((ImageItem)f1.a.get(i1)).id != imageitem.id) goto _L10; else goto _L9
_L9:
        GalleryUtils.a(memboxitemsactivity, aimageitem, i1, GalleryUtils.b(memboxitemsactivity, String.valueOf(imageitem.id), s), 4539);
        return;
_L6:
        try
        {
            s = imageitem.url.substring(imageitem.url.lastIndexOf("."), imageitem.url.length());
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (MemboxItemsActivity memboxitemsactivity)
        {
            com.socialin.android.d.a(b, memboxitemsactivity);
        }
          goto _L2
_L10:
        i1++;
          goto _L11
_L8:
        i1 = 0;
          goto _L9
_L2:
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    static void a(MemboxItemsActivity memboxitemsactivity, Stream stream)
    {
        memboxitemsactivity.f = stream;
        if (memboxitemsactivity.f == null)
        {
            Utils.c(memboxitemsactivity, memboxitemsactivity.getString(0x7f08024e));
            memboxitemsactivity.finish();
            return;
        }
        if (memboxitemsactivity.f.user == null && memboxitemsactivity.e != null)
        {
            memboxitemsactivity.f.user = memboxitemsactivity.e;
            memboxitemsactivity.d = memboxitemsactivity.f.user.id;
        }
        memboxitemsactivity.invalidateOptionsMenu();
        stream = memboxitemsactivity.f.user;
        int i1;
        if (stream != null)
        {
            ((TextView)memboxitemsactivity.findViewById(0x7f1009d9)).setText(((ViewerUser) (stream)).name);
            Object obj = (ImageView)memboxitemsactivity.findViewById(0x7f1009d7);
            String s = stream.getPhoto();
            if (TextUtils.isEmpty(s))
            {
                ((ImageView) (obj)).setImageResource(0x7f020669);
            } else
            {
                (new f(memboxitemsactivity.getApplicationContext())).a(s, ((ImageView) (obj)), (e)((e)((e)memboxitemsactivity.n.b(0x7f020669)).a(0x7f020669)).a(l.a), null);
            }
            if (!TextUtils.isEmpty(((ViewerUser) (stream)).username))
            {
                ((TextView)memboxitemsactivity.findViewById(0x7f1009d8)).setText((new StringBuilder("@")).append(((ViewerUser) (stream)).username).toString());
            }
            ((TextView)memboxitemsactivity.findViewById(0x7f1009d9)).setText(((ViewerUser) (stream)).name);
            ((TextView)memboxitemsactivity.findViewById(0x7f1009da)).setText(memboxitemsactivity.f.description);
            obj = memboxitemsactivity. new android.view.View.OnClickListener(stream) {

                private ViewerUser a;
                private MemboxItemsActivity b;

                public final void onClick(View view)
                {
                    com.socialin.android.picsart.profile.activity.MemboxItemsActivity.a(b, a);
                }

            
            {
                b = MemboxItemsActivity.this;
                a = vieweruser;
                super();
            }
            };
            if (((ViewerUser) (stream)).id != SocialinV3.getInstance().getUser().id)
            {
                memboxitemsactivity.findViewById(0x7f1009d6).setOnClickListener(((android.view.View.OnClickListener) (obj)));
                memboxitemsactivity.findViewById(0x7f1009d8).setOnClickListener(((android.view.View.OnClickListener) (obj)));
            } else
            {
                memboxitemsactivity.findViewById(0x7f1009d6).setClickable(false);
            }
        }
        if (memboxitemsactivity.f.items == null)
        {
            i1 = 0;
        } else
        {
            i1 = memboxitemsactivity.f.items.size();
        }
        if (i1 == 0)
        {
            stream = "";
        } else
        {
            stream = (new StringBuilder(" (")).append(i1).append(")").toString();
        }
        memboxitemsactivity.getSupportActionBar().setTitle((new StringBuilder()).append(memboxitemsactivity.f.title).append(stream).toString());
        if (i1 == 0)
        {
            memboxitemsactivity.a(memboxitemsactivity.getString(0x7f0803f9));
        }
        stream = memboxitemsactivity.f.items;
        if (memboxitemsactivity.g == null)
        {
            memboxitemsactivity.g = (RecyclerView)memboxitemsactivity.findViewById(0x7f1009dc);
        }
        if (stream == null || stream.isEmpty())
        {
            memboxitemsactivity.a(memboxitemsactivity.getString(0x7f0803f9));
        } else
        if (memboxitemsactivity.h != null)
        {
            memboxitemsactivity.h.setVisibility(8);
        }
        if (memboxitemsactivity.g.getAdapter() != null && (memboxitemsactivity.g.getAdapter() instanceof com.socialin.android.picsart.profile.activity.f))
        {
            ((com.socialin.android.picsart.profile.activity.f)memboxitemsactivity.g.getAdapter()).b();
        }
        if (memboxitemsactivity.getResources().getConfiguration().orientation == 1)
        {
            memboxitemsactivity.j = memboxitemsactivity.getResources().getInteger(0x7f0e0012);
        } else
        {
            memboxitemsactivity.j = memboxitemsactivity.getResources().getInteger(0x7f0e0011);
        }
        stream = new com.socialin.android.picsart.profile.activity.f(memboxitemsactivity, stream);
        obj = new StaggeredGridLayoutManager(memboxitemsactivity.j, 1);
        ((StaggeredGridLayoutManager) (obj)).setGapStrategy(0);
        memboxitemsactivity.g.setLayoutManager(((android.support.v7.widget.RecyclerView.LayoutManager) (obj)));
        memboxitemsactivity.g.addItemDecoration(new i((int)memboxitemsactivity.getResources().getDimension(0x7f0b00f5)));
        memboxitemsactivity.g.setAdapter(stream);
    }

    static void a(MemboxItemsActivity memboxitemsactivity, ViewerUser vieweruser)
    {
        Intent intent = new Intent();
        intent.putExtra("profileUser", vieweruser);
        intent.putExtra("profileUserId", vieweruser.id);
        myobfuscated.cv.c.a(intent, memboxitemsactivity);
        intent.setClass(memboxitemsactivity, com/picsart/studio/profile/ProfileActivity);
        intent.putExtra("from", com/socialin/android/picsart/profile/activity/MemboxItemsActivity.getName());
        memboxitemsactivity.startActivity(intent);
    }

    static void a(MemboxItemsActivity memboxitemsactivity, String s)
    {
        memboxitemsactivity.a(s);
    }

    private void a(String s)
    {
        if (h != null)
        {
            h.setText(s);
            h.setVisibility(0);
        }
    }

    private void b()
    {
        m.streamId = c;
        StreamParams streamparams = m;
        int i1;
        if (SocialinV3.getInstance().getUser().mature)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        streamparams.contentRating = i1;
        k.setRequestParams(m);
        k.setRequestCompleteListener(new h(this, (byte)0));
        if (k.getRequestStatus() == 0)
        {
            com.socialin.asyncnet.b.a().a(k.getRequestId());
        }
        k.doRequest(b, m);
    }

    static void b(MemboxItemsActivity memboxitemsactivity)
    {
        AnalyticUtils.getInstance(memboxitemsactivity).trackLocalAction("membox:remove");
        memboxitemsactivity.m.streamId = memboxitemsactivity.c;
        memboxitemsactivity.l.setRequestCompleteListener(new j(memboxitemsactivity, (byte)0));
        memboxitemsactivity.l.setRequestParams(memboxitemsactivity.m);
        memboxitemsactivity.l.doRequest("removeMembox", memboxitemsactivity.m);
    }

    static TextView c(MemboxItemsActivity memboxitemsactivity)
    {
        return memboxitemsactivity.h;
    }

    private void c()
    {
        if (g.getAdapter() != null)
        {
            ((com.socialin.android.picsart.profile.activity.f)g.getAdapter()).a();
        }
        int i1 = k.getDefaultCacheConfig();
        m.offset = 0;
        k.setCacheConfig(3);
        a(getString(0x7f0803d8));
        b();
        k.setCacheConfig(i1);
    }

    static void d(MemboxItemsActivity memboxitemsactivity)
    {
        Intent intent = new Intent();
        intent.setAction("com.picsart.studio.action.update.tabs.delete.membox");
        memboxitemsactivity.sendBroadcast(intent);
        memboxitemsactivity.getIntent().putExtra("memboxChangedAction", true);
        memboxitemsactivity.setResult(-1, memboxitemsactivity.getIntent());
        memboxitemsactivity.finish();
    }

    static com.picsart.studio.d e(MemboxItemsActivity memboxitemsactivity)
    {
        return memboxitemsactivity.o;
    }

    static int f(MemboxItemsActivity memboxitemsactivity)
    {
        return memboxitemsactivity.j;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1 || intent == null) goto _L2; else goto _L1
_L1:
        if (i1 != 4540) goto _L4; else goto _L3
_L3:
        intent = intent.getExtras().getString("path");
        Intent intent1 = getIntent();
        intent1.addCategory("android.intent.category.DEFAULT");
        intent1.setClassName(getPackageName(), com/socialin/android/picsart/upload/PicsartUploadEditActivity.getName());
        intent1.putExtra("picsInGalleryCategory", "camera");
        intent1.putExtra("path", intent);
        intent1.putExtra("fbToken", SocialinV3.getInstance().getUserFbToken());
        intent1.putExtra("appGalleryName", "photo");
        startActivity(intent1);
_L2:
        return;
_L4:
        long l1;
        if (i1 != 4539)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = intent.getLongExtra("memboxIdForDelete", -1L);
        intent = intent.getStringExtra("deletedItemIds");
        if (l1 != c || TextUtils.isEmpty(intent)) goto _L2; else goto _L5
_L5:
        i = true;
        c();
        return;
        if (i1 != 1001 || !intent.getBooleanExtra("renameSuccess", false)) goto _L2; else goto _L6
_L6:
        i = true;
        f.title = intent.getStringExtra("memboxName");
        getSupportActionBar().setTitle((new StringBuilder()).append(f.title).append("(").append(g.getAdapter().getItemCount()).append(")").toString());
        c();
        return;
    }

    public void onBackPressed()
    {
        if (i)
        {
            getIntent().putExtra("memboxChangedAction", true);
            setResult(-1, getIntent());
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        long l2 = -1L;
        super.onCreate(bundle);
        setContentView(0x7f03021f);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setIcon(getResources().getDrawable(0x7f0203b0));
            bundle.setTitle(0x7f0803ef);
        }
        bundle = getIntent();
        if (bundle != null)
        {
            myobfuscated.cv.c.a(bundle, this);
            z z1;
            int i1;
            int j1;
            long l1;
            if (bundle.hasExtra("memboxId"))
            {
                l1 = bundle.getLongExtra("memboxId", -1L);
            } else
            {
                l1 = -1L;
            }
            c = l1;
            if (c < 0L)
            {
                Utils.c(this, "Invalid memboxId!");
                finish();
            }
            l1 = l2;
            if (bundle.hasExtra("userId"))
            {
                l1 = bundle.getLongExtra("userId", -1L);
            }
            d = l1;
            if (bundle.hasExtra("profileUser"))
            {
                try
                {
                    e = (ViewerUser)bundle.getExtras().getParcelable("profileUser");
                    if (d < 0L)
                    {
                        d = e.id;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    com.socialin.android.d.a(b, bundle);
                }
            }
        }
        n = (e)((e)((e)com.bumptech.glide.request.e.c(this).a(l.a)).a(0x7f020669)).b(0x7f020669);
        o = new com.picsart.studio.d(getApplicationContext());
        g = (RecyclerView)findViewById(0x7f1009dc);
        bundle = new StaggeredGridLayoutManager(2, 1);
        g.setLayoutManager(bundle);
        bundle = findViewById(0x7f1001f2);
        bundle.setVisibility(8);
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            private MemboxItemsActivity a;

            public final void onClick(View view)
            {
                if (com.socialin.android.picsart.profile.activity.MemboxItemsActivity.a(a) != null)
                {
                    com.socialin.android.picsart.profile.activity.MemboxItemsActivity.a(a).smoothScrollToPosition(0);
                }
            }

            
            {
                a = MemboxItemsActivity.this;
                super();
            }
        });
        bundle = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(bundle);
        if (a != null)
        {
            z1 = a;
            i1 = ((DisplayMetrics) (bundle)).widthPixels;
            j1 = ((DisplayMetrics) (bundle)).heightPixels;
            z1.g = i1;
            z1.h = j1;
        } else
        {
            a = new z(this, ((DisplayMetrics) (bundle)).widthPixels, ((DisplayMetrics) (bundle)).heightPixels);
        }
        bundle = a;
        bundle.a = new com.socialin.android.picsart.profile.util.z._cls1(bundle);
        bundle = findViewById(0x7f100941);
        z1 = a;
        z1.b = bundle;
        z1.b.setDrawingCacheEnabled(true);
        a.e = (TextView)bundle.findViewById(0x7f100945);
        a.d = (TextView)bundle.findViewById(0x7f100944);
        a.f = (TextView)bundle.findViewById(0x7f100946);
        a.c = (ImageView)bundle.findViewById(0x7f100943);
        h = (TextView)findViewById(0x7f1009db);
        h.setVisibility(8);
        y.h(this);
        AnalyticUtils.getInstance(this).trackLocalAction("membox:onCreate");
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        boolean flag;
        boolean flag1;
        if (f != null && f.user != null && f.user.id == SocialinV3.getInstance().getUser().id)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = "repost".equals(getIntent().getStringExtra("memboxType"));
        if (flag && !flag1)
        {
            MenuItemCompat.setShowAsAction(menu.add(0, 1, 0, getString(0x7f0802bd)), 0);
            MenuItemCompat.setShowAsAction(menu.add(0, 2, 0, getString(0x7f0802b2)), 0);
        }
        menu.add(0, 3, 0, getString(0x7f0802e0));
        return true;
    }

    public void onDestroy()
    {
        super.onDestroy();
        try
        {
            if (g != null && g.getAdapter() != null && (g.getAdapter() instanceof com.socialin.android.picsart.profile.activity.f))
            {
                ((com.socialin.android.picsart.profile.activity.f)g.getAdapter()).b();
            }
            com.socialin.asyncnet.b.a().a(b);
            k.setRequestCompleteListener(null);
            l.setRequestCompleteListener(null);
            return;
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a(b, exception);
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && i)
        {
            getIntent().putExtra("memboxChangedAction", true);
            setResult(-1, getIntent());
            finish();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        com.bumptech.glide.b.a(getApplicationContext()).onLowMemory();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            if (i)
            {
                getIntent().putExtra("memboxChangedAction", true);
                setResult(-1, getIntent());
            }
            finish();
        }
        menuitem.getItemId();
        JVM INSTR tableswitch 1 3: default 76
    //                   1 88
    //                   2 184
    //                   3 278;
           goto _L1 _L2 _L3 _L4
_L1:
        com.socialin.android.d.a(b, "onOptionsItemSelected: default");
        return true;
_L2:
        menuitem = new Intent(this, com/socialin/android/picsart/profile/activity/SliderActivity);
        menuitem.putExtra("sliderContent", "createMembox");
        menuitem.putExtra("fromRename", true);
        menuitem.putExtra("memboxName", f.title);
        menuitem.putExtra("memboxDesc", f.description);
        menuitem.putExtra("memboxId", f.id);
        menuitem.putExtra("source", "membox");
        startActivityForResult(menuitem, 1001);
        return true;
_L3:
        android.app.Fragment fragment;
        try
        {
            menuitem = getFragmentManager().beginTransaction();
            fragment = getFragmentManager().findFragmentByTag("remove_confirm_dialog");
        }
        // Misplaced declaration of an exception variable
        catch (MenuItem menuitem)
        {
            com.socialin.android.d.a(b, menuitem);
            return true;
        }
        if (fragment == null) goto _L6; else goto _L5
_L5:
        menuitem.remove(fragment);
_L6:
        com.socialin.android.dialog.b b1 = (new com.socialin.android.dialog.b()).a(1, 0x7f0c0190);
        b1.b = getResources().getString(0x7f0805ea);
        b1.a(new android.view.View.OnClickListener() {

            private MemboxItemsActivity a;

            public final void onClick(View view)
            {
                if (!s.a(a))
                {
                    y.a(a);
                    return;
                } else
                {
                    com.socialin.android.picsart.profile.activity.MemboxItemsActivity.b(a);
                    return;
                }
            }

            
            {
                a = MemboxItemsActivity.this;
                super();
            }
        }).a().show(menuitem, "remove_confirm_dialog");
        return true;
_L4:
        DialogUtils.openInfoDialog(null, getString(0x7f0803ef), "", getString(0x7f0803ed), this, null);
        return true;
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        findViewById(0x7f1009d6).postDelayed(new Runnable() {

            private MemboxItemsActivity a;

            public final void run()
            {
                int ai[] = new int[2];
                a.findViewById(0x7f1009d6).getLocationOnScreen(ai);
                z z1 = a.a;
                int i1 = ai[1];
                com.socialin.android.d.b("spen", new Object[] {
                    (new StringBuilder("top offset :: ")).append(i1).toString()
                });
                z1.i = i1;
            }

            
            {
                a = MemboxItemsActivity.this;
                super();
            }
        }, 100L);
        runOnUiThread(new Runnable(true) {

            private boolean a;
            private MemboxItemsActivity b;

            public final void run()
            {
                try
                {
                    if (a && com.socialin.android.picsart.profile.activity.MemboxItemsActivity.a(b).getAdapter() != null && (com.socialin.android.picsart.profile.activity.MemboxItemsActivity.a(b).getAdapter() instanceof com.socialin.android.picsart.profile.activity.f))
                    {
                        ((com.socialin.android.picsart.profile.activity.f)com.socialin.android.picsart.profile.activity.MemboxItemsActivity.a(b).getAdapter()).b();
                        ((com.socialin.android.picsart.profile.activity.f)com.socialin.android.picsart.profile.activity.MemboxItemsActivity.a(b).getAdapter()).a();
                    }
                    if (com.socialin.android.picsart.profile.activity.MemboxItemsActivity.c(b) != null)
                    {
                        com.socialin.android.picsart.profile.activity.MemboxItemsActivity.c(b).setText(0x7f0803d8);
                        com.socialin.android.picsart.profile.activity.MemboxItemsActivity.c(b).setVisibility(0);
                    }
                    return;
                }
                catch (Exception exception)
                {
                    com.socialin.android.d.a(com.socialin.android.picsart.profile.activity.MemboxItemsActivity.a(), exception);
                }
            }

            
            {
                b = MemboxItemsActivity.this;
                a = true;
                super();
            }
        });
        b();
    }

}
