// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.picsart.studio.utils.ItemControl;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.multiselect.e;
import com.socialin.android.picsart.profile.adapter.af;
import com.socialin.android.picsart.profile.fragment.ak;
import com.socialin.android.picsart.profile.fragment.ao;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import myobfuscated.cr.h;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            q

public class UserPhotosActivity extends BaseActivity
{

    private int a;
    private boolean b;
    private boolean c;
    private e d;
    private ViewPager e;
    private q f;

    public UserPhotosActivity()
    {
        a = 1;
        b = false;
        c = false;
        d = null;
    }

    static int a(UserPhotosActivity userphotosactivity, int i)
    {
        userphotosactivity.a = i;
        return i;
    }

    static ViewPager a(UserPhotosActivity userphotosactivity)
    {
        return userphotosactivity.e;
    }

    static e b(UserPhotosActivity userphotosactivity)
    {
        return userphotosactivity.d;
    }

    public final void a()
    {
        Object obj = getIntent();
        if (((Intent) (obj)).hasExtra("multipleCheckMode"))
        {
            b = ((Intent) (obj)).getBooleanExtra("multipleCheckMode", false);
        }
        e = (ViewPager)findViewById(0x7f100a34);
        e.setVisibility(0);
        SlidingTabLayout slidingtablayout = (SlidingTabLayout)findViewById(0x7f10068c);
        af af1 = new af(getFragmentManager());
        Object obj1;
        if (b)
        {
            obj = new a() {

                private UserPhotosActivity a;

                public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
                {
                    aobj = (ImageItem)aobj[0];
                    if (((ImageItem) (aobj)).url == null)
                    {
                        itemcontrol = null;
                    } else
                    {
                        itemcontrol = ((ImageItem) (aobj)).url.substring(((ImageItem) (aobj)).url.lastIndexOf("."), ((ImageItem) (aobj)).url.length());
                    }
                    itemcontrol = GalleryUtils.a(a, String.valueOf(((ImageItem) (aobj)).id), itemcontrol);
                    UserPhotosActivity.b(a).a(((ImageItem) (aobj)).url, ((ImageItem) (aobj)).getThumbUrl(), itemcontrol);
                }

            
            {
                a = UserPhotosActivity.this;
                super();
            }
            };
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            if (d == null)
            {
                d = new e();
                fragmenttransaction.replace(0x7f100505, d, "multiselectFragment");
                fragmenttransaction.commit();
            }
        } else
        {
            obj = new a() {

                private UserPhotosActivity a;

                public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
                {
                    itemcontrol = (ImageItem)aobj[0];
                    aobj = a.getIntent();
                    com.socialin.android.picsart.profile.activity.UserPhotosActivity.a(a).getCurrentItem();
                    JVM INSTR tableswitch 0 1: default 48
                //                               0 105
                //                               1 117;
                       goto _L1 _L2 _L3
_L1:
                    ((Intent) (aobj)).putExtra("source_tab", "picsart");
_L5:
                    ((Intent) (aobj)).setData(Uri.parse(((ImageItem) (itemcontrol)).url));
                    ((Intent) (aobj)).putExtra("item", itemcontrol);
                    ((Intent) (aobj)).putExtra("path", ((ImageItem) (itemcontrol)).url);
                    a.setResult(-1, ((Intent) (aobj)));
                    a.finish();
                    return;
_L2:
                    ((Intent) (aobj)).putExtra("source_tab", "picsart_photos");
                    continue; /* Loop/switch isn't completed */
_L3:
                    ((Intent) (aobj)).putExtra("source_tab", "picsart_freetoedit");
                    if (true) goto _L5; else goto _L4
_L4:
                }

            
            {
                a = UserPhotosActivity.this;
                super();
            }
            };
        }
        if (!SocialinV3.getInstance().isRegistered())
        {
            obj1 = new ao();
        } else
        {
            obj1 = ak.a(this, RequestControllerFactory.createGetOwnerItemsController(1));
            ((ak) (obj1)).a((new h(getResources())).a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
                com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.GRID
            }).b());
            ((ak) (obj1)).a(((a) (obj)));
            ((ak) (obj1)).g();
        }
        af1.a(((android.app.Fragment) (obj1)), getString(0x7f080320), 0x7f100090);
        if (!c)
        {
            obj1 = RequestControllerFactory.createSearchItemsController();
            ((GetItemsParams)((BaseSocialinApiRequestController) (obj1)).getRequestParams()).searchTag = "freetoedit";
            obj1 = ak.a(this, ((BaseSocialinApiRequestController) (obj1)));
            ((ak) (obj1)).a((new h(getResources())).a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
                com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.GRID
            }).b());
            ((ak) (obj1)).a(((a) (obj)));
            ((ak) (obj1)).g();
            af1.a(((android.app.Fragment) (obj1)), getString(0x7f0802d3), 0x7f10007a);
        }
        e.setAdapter(af1);
        af1.a = af1.a + (long)(af1.getCount() + 0);
        if (!c)
        {
            slidingtablayout.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

                private UserPhotosActivity a;

                public final void onPageSelected(int i)
                {
                    super.onPageSelected(i);
                    com.socialin.android.picsart.profile.activity.UserPhotosActivity.a(a, i);
                }

            
            {
                a = UserPhotosActivity.this;
                super();
            }
            });
            slidingtablayout.setViewPager(e);
        } else
        {
            slidingtablayout.setVisibility(8);
        }
        e.setCurrentItem(a);
        obj = getSupportActionBar();
        if (obj != null)
        {
            ((ActionBar) (obj)).setDisplayHomeAsUpEnabled(true);
            ((ActionBar) (obj)).setTitle(getResources().getString(0x7f080324));
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1 && i == 4538)
        {
            a();
        }
        if (j == 0 && i == 4538)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030266);
        c = getIntent().getBooleanExtra("contest_item", false);
        a();
        f = new q(this, (byte)0);
        registerReceiver(f, new IntentFilter("com.picsart.studio.update.user.action"));
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (f != null)
        {
            unregisterReceiver(f);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }
}
