// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.appboy.Appboy;
import com.appboy.AppboyUser;
import com.appboy.ui.inappmessage.InAppMessageOperation;
import com.facebook.appevents.AppEventsLogger;
import com.firegnom.rat.util.DialogUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.melnykov.fab.FloatingActionButton;
import com.packetzoom.speed.PZLogLevel;
import com.packetzoom.speed.PacketZoomClient;
import com.picsart.collages.SelectCollageActivity;
import com.picsart.shop.ShopActivity;
import com.picsart.shop.h;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.util.StudioManager;
import com.picsart.studio.utils.a;
import com.picsart.studio.view.SlidingTabLayout;
import com.picsart.upload.UploadService;
import com.socialin.android.SocialinApplication;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.activity.InfoDialogActivity;
import com.socialin.android.activity.WhatsNewActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.GetAppPropsController;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.apiv3.util.PublicSyncInventory;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.constants.EventParam;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.e;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.photo.deeplinking.GalleryItemDeepLinkingActivity;
import com.socialin.android.photo.deeplinking.ShopDeepLinkingActivity;
import com.socialin.android.photo.deeplinking.UserIdDeepLinkingActivity;
import com.socialin.android.photo.effects.activity.EffectsActivityNew;
import com.socialin.android.photo.notifications.NotificationsService;
import com.socialin.android.picsart.profile.activity.BottomSheetActivity;
import com.socialin.android.picsart.profile.activity.DataActivity;
import com.socialin.android.picsart.profile.activity.GalleryItemShowActivity;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.picsart.profile.activity.MemboxItemsActivity;
import com.socialin.android.picsart.profile.activity.SearchActivity;
import com.socialin.android.picsart.profile.activity.TopTagsActivity;
import com.socialin.android.picsart.profile.activity.WebViewActivity;
import com.socialin.android.picsart.profile.fragment.NavigationFragment;
import com.socialin.android.picsart.profile.fragment.at;
import com.socialin.android.picsart.profile.fragment.au;
import com.socialin.android.picsart.profile.fragment.bs;
import com.socialin.android.picsart.profile.invite.NotificationInviteService;
import com.socialin.android.picsart.profile.invite.NotificationRedeemService;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.picsart.upload.PicsartUploadEditActivity;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ab;
import com.socialin.android.util.b;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            e, c, a, d, 
//            b

public class MainPagerActivity extends BaseActivity
    implements a, CommonConstants, e
{

    private static boolean M = false;
    private static boolean f = false;
    private static String g = (new StringBuilder()).append(com/socialin/android/photo/picsinphoto/MainPagerActivity.getSimpleName()).append(" - ").toString();
    private static boolean h = false;
    private Fragment A;
    private NavigationFragment B;
    private boolean C;
    private boolean D;
    private boolean E;
    private String F;
    private GoogleApiClient G;
    private Runnable H;
    private int I;
    private android.support.v4.view.ViewPager.SimpleOnPageChangeListener J;
    private FloatingActionButton K;
    private int L;
    private LocationListener i;
    private LocationManager j;
    private DrawerLayout k;
    private DrawerLayout l;
    private ActionBarDrawerToggle m;
    private SlidingTabLayout n;
    private ViewPager o;
    private com.socialin.android.photo.picsinphoto.e p;
    private com.socialin.android.photo.util.d q;
    private com.socialin.android.photo.picsinphoto.a r;
    private com.socialin.android.photo.picsinphoto.d s;
    private com.socialin.android.photo.picsinphoto.b t;
    private com.socialin.android.photo.picsinphoto.c u;
    private Handler v;
    private SharedPreferences w;
    private com.socialin.android.util.a x;
    private long y;
    private int z;

    public MainPagerActivity()
    {
        u = null;
        v = new Handler();
        y = 0L;
        z = 0;
        B = null;
        C = false;
        D = false;
        E = true;
        I = 13;
        J = new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            private MainPagerActivity a;

            public final void onPageSelected(int i1)
            {
                com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a, i1);
                if (com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a) == 13)
                {
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.b(a).setVisibility(0);
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.b(a).a(true, true, false);
                } else
                {
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.b(a).setVisibility(8);
                }
                switch (com.socialin.android.photo.picsinphoto.e.a[i1])
                {
                default:
                    return;

                case 2131232187: 
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a, "my_network");
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.b(a, com.socialin.android.photo.picsinphoto.e.b[0]);
                    if (com.socialin.android.photo.picsinphoto.MainPagerActivity.c(a))
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.NetworkOpenEvent("other"));
                        com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a, false);
                        return;
                    }
                    if (com.socialin.android.photo.picsinphoto.MainPagerActivity.d(a))
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.NetworkOpenEvent("landing_page"));
                        com.socialin.android.photo.picsinphoto.MainPagerActivity.e(a);
                        return;
                    } else
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.NetworkOpenEvent("tab_click"));
                        return;
                    }

                case 2131231428: 
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a, "explore");
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.b(a, com.socialin.android.photo.picsinphoto.e.b[1]);
                    if (com.socialin.android.photo.picsinphoto.MainPagerActivity.c(a))
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ExploreOpenEvent("other"));
                        com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a, false);
                        return;
                    }
                    if (com.socialin.android.photo.picsinphoto.MainPagerActivity.d(a))
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ExploreOpenEvent("landing_page"));
                        com.socialin.android.photo.picsinphoto.MainPagerActivity.e(a);
                        return;
                    } else
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ExploreOpenEvent("tab_click"));
                        return;
                    }

                case 2131232179: 
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a, "contest");
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.b(a, com.socialin.android.photo.picsinphoto.e.b[3]);
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ContestsOpenEvent("tab_click"));
                    return;

                case 2131231373: 
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a, "artist");
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.b(a, com.socialin.android.photo.picsinphoto.e.b[2]);
                    break;
                }
                if (com.socialin.android.photo.picsinphoto.MainPagerActivity.c(a))
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ArtistsOpenEvent("other"));
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.a(a, false);
                    return;
                } else
                {
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ArtistsOpenEvent("tab_click"));
                    return;
                }
            }

            
            {
                a = MainPagerActivity.this;
                super();
            }
        };
        K = null;
    }

    static int a(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.I;
    }

    static int a(MainPagerActivity mainpageractivity, int i1)
    {
        mainpageractivity.z = i1;
        return i1;
    }

    static String a(MainPagerActivity mainpageractivity, String s1)
    {
        mainpageractivity.F = s1;
        return s1;
    }

    private void a(Intent intent)
    {
        ArrayList arraylist = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (arraylist != null)
        {
            int j1 = arraylist.size();
            String as[] = new String[j1];
            int ai[] = new int[j1];
            int i1 = 0;
            while (i1 < j1) 
            {
                Uri uri = (Uri)arraylist.get(i1);
                int k1;
                if (uri.toString().contains("file://"))
                {
                    String s1 = uri.toString().substring(7);
                    intent = s1;
                    if (!(new File(s1)).exists())
                    {
                        intent = Uri.decode(uri.toString().substring(7));
                    }
                } else
                {
                    intent = com.socialin.android.util.w.a(uri, this);
                }
                k1 = com.socialin.android.util.w.a(this, uri, intent);
                as[i1] = intent;
                ai[i1] = k1;
                i1++;
            }
            intent = new Intent(this, com/picsart/collages/SelectCollageActivity);
            intent.putExtra("selectedItems", as);
            intent.putExtra("itemsCount", j1);
            intent.putExtra("selectedItemsDegrees", ai);
            startActivity(intent);
        }
    }

    private void a(Uri uri)
    {
        int i1 = 0;
        if (uri == null || !"picsartphotostudio".equals(uri.getScheme()) || uri.getQueryParameter("target_url") == null) goto _L2; else goto _L1
_L1:
        if (!"main_page".equals(uri.getHost())) goto _L4; else goto _L3
_L3:
        return;
_L4:
        List list = uri.getPathSegments();
        if (list != null && !list.isEmpty() && "gallery_item".equals(uri.getHost()))
        {
            long l1 = Long.parseLong((String)list.get(0));
            if (l1 > 0L)
            {
                Intent intent = new Intent(this, com/socialin/android/picsart/profile/activity/GalleryItemShowActivity);
                myobfuscated.cv.c.a(intent, this);
                intent.putExtra("item_id", l1);
                startActivity(intent);
            }
        }
_L2:
        List list1;
        long l2;
        list1 = uri.getPathSegments();
        l2 = -1L;
        long l3 = Long.parseLong(uri.getQueryParameter("target_item_id"));
        l2 = l3;
_L11:
        l3 = l2;
        if (l2 >= 0L) goto _L6; else goto _L5
_L5:
        l3 = l2;
        if (list1 == null) goto _L6; else goto _L7
_L7:
        l3 = l2;
        if (list1.isEmpty()) goto _L6; else goto _L8
_L8:
        if (i1 >= list1.size())
        {
            break MISSING_BLOCK_LABEL_354;
        }
        if (!((String)list1.get(i1)).equals("i")) goto _L10; else goto _L9
_L9:
        i1++;
_L13:
        Exception exception1;
        try
        {
            l3 = Long.parseLong((String)list1.get(i1));
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a(exception.getMessage(), exception);
            l3 = l2;
        }
_L6:
        try
        {
            uri = uri.getQueryParameter("target_user_id");
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            uri = null;
        }
        if (l3 > 0L)
        {
            uri = new Intent(this, com/socialin/android/picsart/profile/activity/GalleryItemShowActivity);
            myobfuscated.cv.c.a(uri, this);
            uri.putExtra("item_id", l3);
            startActivity(uri);
            return;
        }
        continue; /* Loop/switch isn't completed */
        exception1;
        com.socialin.android.d.a(exception1.getMessage(), exception1);
          goto _L11
_L10:
        i1++;
          goto _L8
        if (uri == null) goto _L3; else goto _L12
_L12:
        GalleryUtils.a(this, Long.parseLong(uri), null, "direct");
        return;
        i1 = -1;
          goto _L13
    }

    private void a(String s1, boolean flag)
    {
        if (Inventory.isAdsEnabled() && Inventory.isEditorAdsEnabled()) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            com.socialin.android.picsart.profile.invite.i.f(this);
        }
_L4:
        return;
_L2:
        SharedPreferences sharedpreferences;
        boolean flag1;
        sharedpreferences = com.socialin.android.picsart.profile.invite.i.a(this);
        flag1 = sharedpreferences.getBoolean("is_editor_active", false);
        if (!com.socialin.android.picsart.profile.invite.i.o(this))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!flag1 && !TextUtils.isEmpty(s1))
        {
            Utils.b(this, s1);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (flag1 && flag)
        {
            sharedpreferences.edit().putBoolean("invite.redeem.reminder.notification.snoozed", true).apply();
            return;
        }
        if (!com.socialin.android.picsart.profile.invite.i.m(this))
        {
            com.socialin.android.picsart.profile.invite.i.a(this, null);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static boolean a(MainPagerActivity mainpageractivity, boolean flag)
    {
        mainpageractivity.D = flag;
        return flag;
    }

    static FloatingActionButton b(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.K;
    }

    private void b(int i1)
    {
        Intent intent = new Intent(this, com/socialin/android/activity/WhatsNewActivity);
        intent.setFlags(0x20400000);
        if (i1 > 0)
        {
            intent.putExtra("version_code", i1);
        }
        startActivity(intent);
    }

    static void b(MainPagerActivity mainpageractivity, int i1)
    {
        if (i1 == 0x7f1006ce && mainpageractivity.k.isDrawerOpen(0x800003))
        {
            mainpageractivity.k.closeDrawer(0x800003);
        } else
        if (i1 == 0x7f1006cf && mainpageractivity.l.isDrawerOpen(0x800005))
        {
            mainpageractivity.l.closeDrawer(0x800005);
            return;
        }
    }

    static void b(MainPagerActivity mainpageractivity, String s1)
    {
        mainpageractivity = mainpageractivity.getFragmentManager();
        int i1 = 0;
        do
        {
            String as[] = com.socialin.android.photo.picsinphoto.e.b;
            if (i1 < 4)
            {
                String s2 = com.socialin.android.photo.picsinphoto.e.b[i1];
                Fragment fragment = mainpageractivity.findFragmentByTag(s2);
                if (fragment != null && (fragment instanceof myobfuscated.cs.e) && s2.equals(s1))
                {
                    ((myobfuscated.cs.e)fragment).g();
                }
                i1++;
            } else
            {
                return;
            }
        } while (true);
    }

    private void c(int i1)
    {
        D = true;
        i1 = com.socialin.android.photo.picsinphoto.e.a(i1);
        if (i1 < p.getCount())
        {
            o.setCurrentItem(i1);
            if (i1 == 0)
            {
                J.onPageSelected(0);
            }
        }
        n.setViewPager(o);
    }

    static boolean c(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.D;
    }

    static boolean d(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.E;
    }

    static String e()
    {
        return g;
    }

    static boolean e(MainPagerActivity mainpageractivity)
    {
        mainpageractivity.E = false;
        return false;
    }

    static Fragment f(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.A;
    }

    private void f()
    {
        com.socialin.android.picsart.profile.invite.i.a(false);
        while (com.socialin.android.picsart.profile.invite.i.q(this) || StudioManager.isLinkHandled() || !Inventory.isAdsEnabled() || !Inventory.isEditorAdsEnabled() || com.socialin.android.picsart.profile.invite.i.m(this) || com.socialin.android.picsart.profile.invite.i.o(this)) 
        {
            return;
        }
        if (SocialinV3.getInstance().getSettings().isAutoRedeemEnabled())
        {
            com.socialin.android.picsart.profile.invite.i.c(this);
            g();
        } else
        if (SocialinApplication.a)
        {
            com.socialin.android.picsart.profile.invite.i.a(this, findViewById(0x7f1006d0));
        } else
        {
            com.socialin.android.picsart.profile.invite.i.c(this);
            com.socialin.android.picsart.profile.invite.i.a(this, null);
        }
        StudioManager.setLinkHandled(true);
    }

    static Runnable g(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.H;
    }

    private void g()
    {
        com.socialin.android.picsart.profile.invite.i.a(this, new myobfuscated.cs.d() {

            private MainPagerActivity a;

            public final void a(boolean flag)
            {
                if (flag)
                {
                    if (MainPagerActivity.f(a) != null && MainPagerActivity.f(a).isAdded())
                    {
                        ((com.socialin.android.photo.notifications.a)MainPagerActivity.f(a)).a();
                    }
                    com.socialin.android.picsart.profile.invite.i.a(a, "ad_remover", EventParam.AUTO.getName(), 0, com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER_AUTO);
                }
            }

            public final void f()
            {
            }

            
            {
                a = MainPagerActivity.this;
                super();
            }
        });
    }

    static Runnable h(MainPagerActivity mainpageractivity)
    {
        mainpageractivity.H = null;
        return null;
    }

    private void h()
    {
        j();
        i();
        I = 13;
        B.a(13);
        p.a(true);
    }

    static String i(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.F;
    }

    private void i()
    {
        Object obj = getFragmentManager();
        Fragment fragment = ((FragmentManager) (obj)).findFragmentByTag("find.friends.fragment");
        if (fragment != null)
        {
            obj = ((FragmentManager) (obj)).beginTransaction();
            ((FragmentTransaction) (obj)).remove(fragment);
            ((FragmentTransaction) (obj)).commitAllowingStateLoss();
            getSupportActionBar().setTitle(com.socialin.android.photo.picsinphoto.e.a[o.getCurrentItem()]);
            B.a(13);
            I = 13;
        }
        K.setVisibility(0);
    }

    static DrawerLayout j(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.l;
    }

    private void j()
    {
        Object obj = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = ((android.support.v4.app.FragmentManager) (obj)).findFragmentByTag("shopFragmentTag");
        if (fragment != null)
        {
            obj = ((android.support.v4.app.FragmentManager) (obj)).beginTransaction();
            ((android.support.v4.app.FragmentTransaction) (obj)).remove(fragment);
            ((android.support.v4.app.FragmentTransaction) (obj)).commitAllowingStateLoss();
            getSupportActionBar().setTitle(com.socialin.android.photo.picsinphoto.e.a[o.getCurrentItem()]);
            B.a(13);
        }
        K.setVisibility(0);
    }

    private void k()
    {
        A = getFragmentManager().findFragmentByTag("notification.fragment");
        if (A != null && A.isAdded())
        {
            ((com.socialin.android.photo.notifications.a)A).d();
            ((com.socialin.android.photo.notifications.a)A).a();
        }
    }

    static boolean k(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.l();
    }

    static void l(MainPagerActivity mainpageractivity)
    {
        int i1;
        int k1;
        i1 = 0;
        com.socialin.android.util.a a1 = mainpageractivity.x;
        k1 = a1.a.getSharedPreferences(a1.b, 4).getInt("app_version", 0);
        int j1 = mainpageractivity.getPackageManager().getPackageInfo(mainpageractivity.getPackageName(), 0).versionCode;
        i1 = j1;
_L2:
        Object obj = mainpageractivity.x;
        obj = ((com.socialin.android.util.a) (obj)).a.getSharedPreferences(((com.socialin.android.util.a) (obj)).b, 4).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("app_version", i1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        if (k1 > 0 && k1 < i1)
        {
            mainpageractivity.b(-1);
        }
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        com.socialin.android.d.b(g, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(namenotfoundexception.getMessage()).toString()
        });
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean l()
    {
        boolean flag = false;
        if (w.getBoolean("show_app_update_available_dialog", false))
        {
            flag = true;
        } else
        {
            int i1;
            int j1;
            try
            {
                i1 = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                com.socialin.android.d.b(g, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(namenotfoundexception.getMessage()).toString()
                });
                i1 = 0;
            }
            j1 = SocialinV3.getInstance().getAppProps().getData().getAppLastVersion();
            if (j1 > i1)
            {
                b(j1);
                w.edit().putBoolean("show_app_update_available_dialog", true).apply();
                return true;
            }
        }
        return flag;
    }

    private void m()
    {
        if (getIntent() == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Intent intent;
        intent = new Intent();
        boolean flag;
        if (getIntent() == null)
        {
            obj = null;
        } else
        {
            obj = getIntent().getExtras();
        }
        flag = StudioManager.isHookHandled();
        StudioManager.setHookHandled(true);
        if (obj == null || flag || !((Bundle) (obj)).containsKey("from_urls") || !((Bundle) (obj)).getBoolean("from_urls") || !((Bundle) (obj)).containsKey("from") || ((Bundle) (obj)).getString("from").equals("picsart")) goto _L2; else goto _L3
_L3:
        com.appboy.ui.inappmessage.a.a().d = new myobfuscated.m.b() {

            public final InAppMessageOperation a()
            {
                return InAppMessageOperation.DISPLAY_LATER;
            }

        };
        obj1 = ((Bundle) (obj)).getString("from");
        if (!"invitefb".equals(obj1)) goto _L5; else goto _L4
_L4:
        myobfuscated.cy.d.a(this, "facebook_invite", "facebook_app_invite", -1L, new io.branch.referral.g() {

            private MainPagerActivity a;

            public final void a(String s1, io.branch.referral.m m1)
            {
                FacebookUtils.openInviteFriendChooser(a, null, s1);
            }

            
            {
                a = MainPagerActivity.this;
                super();
            }
        });
_L2:
        return;
_L5:
        if ("whats_new".equals(obj1))
        {
            intent.setClass(this, com/socialin/android/activity/WhatsNewActivity);
            if (((Bundle) (obj)).getString("URI") != null && ((Bundle) (obj)).getString("URI").contains("picsart://news?id="))
            {
                obj = ((Bundle) (obj)).getString("URI").replaceAll("\\s", "");
                obj1 = ((String) (obj)).substring(((String) (obj)).indexOf("news?id=")).substring(8);
                int i1 = Utils.a(Pattern.compile("[^a-zA-Z0-9]"), ((String) (obj1)));
                obj = obj1;
                if (i1 > 0)
                {
                    obj = ((String) (obj1)).substring(0, i1);
                }
                intent.putExtra("appboy_news_id", ((String) (obj)));
            }
            startActivity(intent);
            return;
        }
        if (!"camera".equals(obj1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!StudioManager.startCamera(this))
        {
            Utils.c(this, getString(0x7f080294));
            c(0x7f0802c4);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
        if ("gallery_item".equals(obj1))
        {
            obj1 = new Intent(this, com/socialin/android/photo/deeplinking/GalleryItemDeepLinkingActivity);
            ((Intent) (obj1)).setData(Uri.parse(((Bundle) (obj)).getString("URI")));
            startActivity(((Intent) (obj1)));
            return;
        }
        if ("shop_main".equals(obj1))
        {
            intent.setClass(this, com/picsart/shop/ShopActivity);
            startActivity(intent);
            return;
        }
        if ("shop_package".equals(obj1))
        {
            obj1 = new Intent(this, com/socialin/android/photo/deeplinking/ShopDeepLinkingActivity);
            ((Intent) (obj1)).setData(Uri.parse(((Bundle) (obj)).getString("URI")));
            startActivity(((Intent) (obj1)));
            return;
        }
        if ("my_network".equals(obj1))
        {
            c(0x7f0805bb);
            return;
        }
        if ("explore".equals(obj1))
        {
            c(0x7f0802c4);
            return;
        }
        if ("artists".equals(obj1))
        {
            c(0x7f08028d);
            return;
        }
        if ("contests".equals(obj1))
        {
            c(0x7f0805b3);
            return;
        }
        if (!"login".equals(obj1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!SocialinV3.getInstance().isRegistered())
        {
            obj = new Intent();
            ((Intent) (obj)).addCategory("android.intent.category.DEFAULT");
            ((Intent) (obj)).setClass(this, com/socialin/android/picsart/profile/activity/LoginFragmentActivity);
            ((Intent) (obj)).setFlags(0x4000000);
            startActivityForResult(((Intent) (obj)), 14);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
        if ("contest".equals(obj1) || "http://picsart.com/contests?id=".equals(obj1))
        {
            c(0x7f0805b3);
            return;
        }
        if ("collage".equals(obj1))
        {
            StudioManager.openCollage(this);
            return;
        }
        if ("draw".equals(obj1))
        {
            StudioManager.openDraw(this);
            return;
        }
        if ("effects".equals(obj1))
        {
            StudioManager.openEffects(this);
            return;
        }
        if ("editor".equals(obj1))
        {
            StudioManager.openPhotoEditor(this);
            return;
        }
        if ("notifications".equals(obj1))
        {
            l.openDrawer(0x800005);
            return;
        }
        if ("location".equals(obj1))
        {
            continue; /* Loop/switch isn't completed */
        }
        if ("tag_photos".equals(obj1))
        {
            obj = ((Bundle) (obj)).getString("URI");
            obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1);
            if (!com.socialin.android.util.s.a(this))
            {
                DialogUtils.showNoNetworkDialog(this, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
                return;
            }
            obj1 = new Intent(this, com/socialin/android/picsart/profile/activity/TopTagsActivity);
            ((Intent) (obj1)).putExtra("key.tag", ((String) (obj)));
            myobfuscated.cv.c.a(((Intent) (obj1)), this);
            if (I == 11)
            {
                ((Intent) (obj1)).putExtra("showPhotosTabInSearch", false);
            }
            startActivity(((Intent) (obj1)));
            return;
        }
        if ("user".equals(obj1))
        {
            obj1 = new Intent(this, com/socialin/android/photo/deeplinking/UserIdDeepLinkingActivity);
            ((Intent) (obj1)).setData(Uri.parse(((Bundle) (obj)).getString("URI")));
            startActivity(((Intent) (obj1)));
            return;
        }
        if ("stream".equals(obj1))
        {
            c(0x7f0802c4);
            return;
        }
        if ("tags".equals(obj1))
        {
            obj = ((Bundle) (obj)).getString("URI");
            obj1 = new Intent(this, com/socialin/android/picsart/profile/activity/DataActivity);
            ((Intent) (obj1)).putExtra("data_type", "tags_fragment");
            ((Intent) (obj1)).putExtra("type", ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1));
            ((Intent) (obj1)).putExtra("title", getIntent().getStringExtra("title"));
            startActivity(((Intent) (obj1)));
            return;
        }
        if ("photos".equals(((Bundle) (obj)).getString("from")))
        {
            obj = ((Bundle) (obj)).getString("URI");
            obj1 = new Intent(this, com/socialin/android/picsart/profile/activity/DataActivity);
            ((Intent) (obj1)).putExtra("data_type", "photos_fragment");
            ((Intent) (obj1)).putExtra("type", ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1));
            ((Intent) (obj1)).putExtra("title", getIntent().getStringExtra("title"));
            startActivity(((Intent) (obj1)));
            return;
        }
        if (!"users".equals(obj1))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((Bundle) (obj)).getString("URI");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj1 = new Intent(this, com/socialin/android/picsart/profile/activity/DataActivity);
            ((Intent) (obj1)).putExtra("data_type", "users_fragment");
            if (((String) (obj)).startsWith("picsart://users?type="))
            {
                ((Intent) (obj1)).putExtra("type", ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1));
            }
            ((Intent) (obj1)).putExtra("title", getIntent().getStringExtra("title"));
            startActivity(((Intent) (obj1)));
            return;
        }
        if (true) goto _L2; else goto _L8
_L8:
        if (!"reset".equals(obj1))
        {
            break MISSING_BLOCK_LABEL_1258;
        }
        obj = ((Bundle) (obj)).getString("URI");
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf(File.separator) + 1);
        Object obj2;
        try
        {
            obj1 = getFragmentManager().beginTransaction();
            obj2 = getFragmentManager().findFragmentByTag("dialogFragment");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(g, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
            });
            return;
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_1191;
        }
        ((FragmentTransaction) (obj1)).remove(((Fragment) (obj2)));
        obj2 = new bs();
        obj2.a = ((String) (obj));
        ((bs) (obj2)).show(((FragmentTransaction) (obj1)), "dialogFragment");
        ((bs) (obj2)).setStyle(1, 0x7f0c0190);
        return;
        if (!"web_page".equals(obj1))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((Bundle) (obj)).getString("URI");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj1 = new Intent(this, com/socialin/android/picsart/profile/activity/WebViewActivity);
            ((Intent) (obj1)).putExtra("url", ((String) (obj)).substring(22));
            startActivity(((Intent) (obj1)));
            return;
        }
        if (true) goto _L2; else goto _L9
_L9:
        if ("terms".equals(obj1))
        {
            obj = new Intent(this, com/socialin/android/picsart/profile/activity/WebViewActivity);
            ((Intent) (obj)).putExtra("url", "http://picsart.com/mobile/terms");
            startActivity(((Intent) (obj)));
            return;
        }
        if ("license".equals(obj1))
        {
            obj = new Intent(this, com/socialin/android/picsart/profile/activity/WebViewActivity);
            ((Intent) (obj)).putExtra("url", "http://picsart.com/license/android");
            startActivity(((Intent) (obj)));
            return;
        }
        if ("privacy_policy".equals(obj1))
        {
            obj = new Intent(this, com/socialin/android/picsart/profile/activity/WebViewActivity);
            ((Intent) (obj)).putExtra("url", "http://picsart.com/mobile/privacy");
            startActivity(((Intent) (obj)));
            return;
        }
        if ("dmca".equals(obj1))
        {
            obj = new Intent(this, com/socialin/android/picsart/profile/activity/WebViewActivity);
            ((Intent) (obj)).putExtra("url", "http://picsart.com/mobile/dmca");
            startActivity(((Intent) (obj)));
            return;
        }
        if ("membox".equals(obj1))
        {
            obj = ((Bundle) (obj)).getString("URI");
            if (!com.socialin.android.util.s.a(this) || TextUtils.isEmpty(((CharSequence) (obj))))
            {
                GalleryUtils.a(this);
                return;
            }
            obj = ((String) (obj)).substring(((String) (obj)).indexOf("membox?id=")).substring(10);
            int j1 = Utils.a(Pattern.compile("[^0-9]"), ((String) (obj)));
            if (j1 > 0)
            {
                obj = ((String) (obj)).substring(0, j1);
            }
            try
            {
                obj1 = new Intent(this, com/socialin/android/picsart/profile/activity/MemboxItemsActivity);
                ((Intent) (obj1)).setFlags(0x4000000);
                ((Intent) (obj1)).putExtra("memboxId", Long.parseLong(((String) (obj))));
                startActivity(((Intent) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((NumberFormatException) (obj1)).printStackTrace();
            }
            obj1 = new Intent(this, com/socialin/android/picsart/profile/activity/MemboxItemsActivity);
            ((Intent) (obj1)).setFlags(0x4000000);
            ((Intent) (obj1)).putExtra("memboxId", Long.parseLong(((String) (obj))));
            startActivity(((Intent) (obj1)));
            return;
        }
        if ("picsart://appinvite_redeem_reminder".equals(obj1))
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowInfectEvent("push", 2, com.socialin.android.picsart.profile.invite.i.p(getApplicationContext())));
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.PushClickedEvent(SocialinV3.getInstance().getUser().id));
            a(getString(0x7f0803c1), true);
            NotificationRedeemService.a(this);
            return;
        }
        if (!"picsart://appinvite_invite_reminder".equals(obj1)) goto _L11; else goto _L10
_L10:
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.PushClickedEvent(SocialinV3.getInstance().getUser().id));
        obj = com.socialin.android.picsart.profile.invite.i.a(this);
        if (!((SharedPreferences) (obj)).getBoolean("is_editor_active", false)) goto _L13; else goto _L12
_L12:
        ((SharedPreferences) (obj)).edit().putBoolean("invite.reminder.notification.snoozed", true).apply();
_L14:
        NotificationInviteService.a(this);
        return;
_L13:
        if (!com.socialin.android.picsart.profile.invite.i.o(this))
        {
            com.socialin.android.picsart.profile.invite.i.a(this, "ad_remover", EventParam.NOTIFICATIONS_REMINDER.getName());
        }
        if (true) goto _L14; else goto _L11
_L11:
        if ("picsart://appinvite".equals(obj1))
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowInfectEvent("push", 1, com.socialin.android.picsart.profile.invite.i.p(getApplicationContext())));
            a("", false);
            return;
        }
        if ("picsart://appinvite_skip_redeem".equalsIgnoreCase(((String) (obj1))))
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowInfectEvent("push", 1, com.socialin.android.picsart.profile.invite.i.p(getApplicationContext())));
            g();
            return;
        }
        if (true) goto _L2; else goto _L15
_L15:
    }

    static void m(MainPagerActivity mainpageractivity)
    {
        mainpageractivity.f();
    }

    public static void n(MainPagerActivity mainpageractivity)
    {
        mainpageractivity.j();
        Object obj = mainpageractivity.getFragmentManager();
        com.socialin.android.picsart.profile.fragment.w w1 = new com.socialin.android.picsart.profile.fragment.w();
        obj = ((FragmentManager) (obj)).beginTransaction();
        ((FragmentTransaction) (obj)).replace(0x7f10004c, w1, "find.friends.fragment");
        mainpageractivity.B.a(11);
        ((FragmentTransaction) (obj)).commitAllowingStateLoss();
        mainpageractivity.I = 11;
        mainpageractivity.setTitle(mainpageractivity.getString(0x7f0802cb));
        mainpageractivity.K.setVisibility(8);
    }

    public static com.socialin.android.photo.picsinphoto.e o(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.p;
    }

    public static void p(MainPagerActivity mainpageractivity)
    {
        mainpageractivity.h();
        mainpageractivity.o.setCurrentItem(com.socialin.android.photo.picsinphoto.e.a(0x7f0802c4));
    }

    public static void q(MainPagerActivity mainpageractivity)
    {
        mainpageractivity.i();
        Object obj = mainpageractivity.getSupportFragmentManager();
        h h1 = new h();
        obj = ((android.support.v4.app.FragmentManager) (obj)).beginTransaction();
        ((android.support.v4.app.FragmentTransaction) (obj)).add(0x7f10004c, h1, "shopFragmentTag");
        mainpageractivity.B.a(14);
        ((android.support.v4.app.FragmentTransaction) (obj)).commitAllowingStateLoss();
        mainpageractivity.I = 14;
        mainpageractivity.setTitle(mainpageractivity.getString(0x7f08034b));
        mainpageractivity.K.setVisibility(8);
    }

    static void r(MainPagerActivity mainpageractivity)
    {
        mainpageractivity = mainpageractivity.getFragmentManager().findFragmentByTag("my.network.fragment");
        if (mainpageractivity != null && mainpageractivity.isAdded())
        {
            ((at)mainpageractivity).a(true, true);
        }
    }

    static void s(MainPagerActivity mainpageractivity)
    {
        mainpageractivity.k();
    }

    static SlidingTabLayout t(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.n;
    }

    static ViewPager u(MainPagerActivity mainpageractivity)
    {
        return mainpageractivity.o;
    }

    public final void a()
    {
        K.a(true, true, false);
    }

    public final void a(int i1)
    {
        if (i1 >= 0)
        {
            L = i1;
            myobfuscated.bo.c.a(L, this);
            if (q != null)
            {
                com.socialin.android.photo.util.d d1 = q;
                String s1;
                if (L == 0)
                {
                    s1 = "";
                } else
                if (L > 99)
                {
                    s1 = "99";
                } else
                {
                    s1 = String.valueOf(L);
                }
                d1.a = s1;
                d1.invalidateSelf();
                return;
            }
        }
    }

    public final void b()
    {
        K.a(false, true, false);
    }

    public final boolean c()
    {
        return l.isDrawerOpen(0x800005);
    }

    public void closeNavigationBar(Runnable runnable)
    {
        k.closeDrawer(0x800003);
        l.closeDrawer(0x800005);
        H = runnable;
    }

    public final void d()
    {
        L = L - 1;
        a(L);
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        com.socialin.android.d.b(g, new Object[] {
            (new StringBuilder(" onActivityResult ")).append(i1).append(" ").append(j1).append(" ").append(intent).toString()
        });
        if (!myobfuscated.f.m.a(this, getString(0x7f0808be)).handleActivityResult(i1, j1, intent)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        super.onActivityResult(i1, j1, intent);
        if (f && (i1 == 5 || i1 == 6))
        {
            com.socialin.android.d.b(g, new Object[] {
                "fromOtherApp:: open Upload or Profile"
            });
            setResult(j1, intent);
            finish();
        }
        if (j1 == 126 || j1 == 166 || j1 == 150)
        {
            onFragmentFinishWithResultOK(126);
        }
        if (i1 == 1124 && A != null && A.isAdded())
        {
            ((com.socialin.android.photo.notifications.a)A).a();
        }
        if (j1 != -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1;
        JVM INSTR lookupswitch 7: default 256
    //                   7: 257
    //                   8: 257
    //                   13: 73
    //                   14: 345
    //                   101: 262
    //                   1122: 353
    //                   1129: 381;
           goto _L3 _L4 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        break; /* Loop/switch isn't completed */
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        finish();
        return;
_L7:
        if (p != null && o != null)
        {
            try
            {
                p.a();
                n.invalidate();
                invalidateOptionsMenu();
                o.setCurrentItem(com.socialin.android.photo.picsinphoto.e.a(0x7f0802c4));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                com.socialin.android.d.b(g, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(intent.getMessage()).toString()
                });
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L6:
        onFragmentFinishWithResultOK(150);
        return;
_L8:
        if (A == null || !A.isAdded()) goto _L11; else goto _L10
_L11:
        if (true) goto _L1; else goto _L12
_L10:
        ((com.socialin.android.photo.notifications.a)A).a();
        return;
_L12:
        g();
        return;
        if (j1 != 0 || i1 != 5) goto _L1; else goto _L13
_L13:
        Toast.makeText(this, 0x7f08058e, 0).show();
        return;
    }

    public void onAttachFragment(Fragment fragment)
    {
        super.onAttachFragment(fragment);
    }

    public void onBackPressed()
    {
        if (isPhotoFragmentOpen())
        {
            hideImagePreviewFragmentContainer();
            p.a(true);
            return;
        }
        if (k.isDrawerOpen(0x800003))
        {
            k.closeDrawer(0x800003);
            return;
        }
        if (l.isDrawerOpen(0x800005))
        {
            l.closeDrawer(0x800005);
            return;
        }
        if (I != 13)
        {
            h();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        p.a(true);
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        Bundle bundle1;
        Intent intent1;
        super.onCreate(bundle);
        setTheme(0x7f0c0197);
        if (SocialinV3.getInstance().getSettings().isPacketZoomEnabled())
        {
            PacketZoomClient.init(this, getString(0x7f080950), getString(0x7f08094f));
            PacketZoomClient.setLogLevel(PZLogLevel.pzlogINFO);
        }
        com.socialin.android.picsart.profile.invite.i.a(this).edit().putBoolean("exit_app", false).apply();
        StudioManager.setLinkHandled(false);
        G = myobfuscated.f.m.a(this);
        if (!isTaskRoot())
        {
            Intent intent = getIntent();
            String s1 = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && s1 != null && s1.equals("android.intent.action.MAIN"))
            {
                finish();
                return;
            }
        }
        getApplication();
        if (!SocialinApplication.c)
        {
            getApplication();
            SocialinApplication.c = true;
            boolean flag = FileUtils.d();
            long l1 = FileUtils.a(this);
            long l3 = FileUtils.c();
            obj = new Intent(this, com/socialin/android/activity/InfoDialogActivity);
            ((Intent) (obj)).putExtra("title", "Error");
            ((Intent) (obj)).setFlags(0x10000000);
            Object obj1;
            String s4;
            if (!flag)
            {
                ((Intent) (obj)).putExtra("desc", getString(0x7f0804a2));
                ((Intent) (obj)).putExtra("message", getString(0x7f080342));
                startActivity(((Intent) (obj)));
            } else
            if (l1 < 1L)
            {
                ((Intent) (obj)).putExtra("desc", "No space in Phone internal storage!");
                ((Intent) (obj)).putExtra("message", "Application needs internal storage for working properly.\nPlease free several megabytes from internal storage.");
                startActivity(((Intent) (obj)));
            } else
            if (l3 < 1L)
            {
                ((Intent) (obj)).putExtra("desc", "No space in SD card !");
                ((Intent) (obj)).putExtra("message", "Application needs SD card for working properly.\nPlease free several megabytes from SD card.");
                startActivity(((Intent) (obj)));
            }
        }
        supportRequestWindowFeature(5);
        setContentView(0x7f030153);
        obj = (Toolbar)findViewById(0x7f10017b);
        setSupportActionBar(((Toolbar) (obj)));
        if ("com.picsart.studio".equalsIgnoreCase(Utils.k(this)) && !M)
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.AppOpenEvent("direct", "default"));
            M = true;
        }
        obj1 = getSupportActionBar();
        ((ActionBar) (obj1)).setHomeButtonEnabled(true);
        ((ActionBar) (obj1)).setDisplayHomeAsUpEnabled(true);
        p = new com.socialin.android.photo.picsinphoto.e(getFragmentManager(), this);
        AnalyticUtils.getInstance(this).trackLocalAction("start:onCreate");
        w = getSharedPreferences((new StringBuilder("sinPref_")).append(getString(myobfuscated.f.m.e(this, "app_name_short"))).toString(), 0);
        myobfuscated.cv.c.a(getIntent(), this);
        k = (DrawerLayout)findViewById(0x7f100167);
        l = (DrawerLayout)findViewById(0x7f1006cb);
        l.setDrawerListener(new android.support.v4.widget.DrawerLayout.SimpleDrawerListener() {

            private MainPagerActivity a;

            public final void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
                a.invalidateOptionsMenu();
            }

            public final void onDrawerOpened(View view)
            {
                super.onDrawerOpened(view);
                view = a.getFragmentManager().findFragmentByTag("notification.fragment");
                if (view != null && (view instanceof myobfuscated.cs.e))
                {
                    ((myobfuscated.cs.e)view).g();
                }
                a.invalidateOptionsMenu();
                if (SocialinV3.getInstance().getUser() != null && SocialinV3.getInstance().getUser().id > 1L)
                {
                    AnalyticUtils.getInstance(a.getApplicationContext()).track(new com.socialin.android.apiv3.events.EventsFactory.NotificationsOpenEvent(SocialinV3.getInstance().getUser().id));
                }
                ((com.socialin.android.photo.notifications.a)MainPagerActivity.f(a)).c();
            }

            
            {
                a = MainPagerActivity.this;
                super();
            }
        });
        m = new ActionBarDrawerToggle(this, k, ((Toolbar) (obj))) {

            private MainPagerActivity a;

            public final void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
                a.invalidateOptionsMenu();
                if (com.socialin.android.photo.picsinphoto.MainPagerActivity.g(a) != null)
                {
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.g(a).run();
                    com.socialin.android.photo.picsinphoto.MainPagerActivity.h(a);
                }
            }

            public final void onDrawerOpened(View view)
            {
                super.onDrawerOpened(view);
                com.socialin.android.photo.picsinphoto.MainPagerActivity.b(a, view.getId());
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.DrawerOpenEvent(com.socialin.android.photo.picsinphoto.MainPagerActivity.i(a)));
            }

            public final void onDrawerStateChanged(int j1)
            {
                MainPagerActivity.j(a).closeDrawer(0x800005);
            }

            
            {
                a = MainPagerActivity.this;
                super(activity, drawerlayout, toolbar, 0x7f080319, 0x7f0802a4);
            }
        };
        k.setDrawerListener(m);
        if (bundle != null)
        {
            I = bundle.getInt("selectedNavigation", 13);
            C = bundle.getBoolean("isIntentReaded", false);
        }
        x = new com.socialin.android.util.a(this);
        if (bundle != null && bundle.containsKey("currentPage"))
        {
            z = bundle.getInt("currentPage");
        } else
        {
            z = com.socialin.android.photo.picsinphoto.e.a(0x7f0802c4);
        }
        K = (FloatingActionButton)findViewById(0x7f1006cd);
        K.setOnClickListener(new android.view.View.OnClickListener() {

            private MainPagerActivity a;

            public final void onClick(View view)
            {
                view = new Intent(a, com/socialin/android/picsart/profile/activity/BottomSheetActivity);
                a.startActivity(view);
            }

            
            {
                a = MainPagerActivity.this;
                super();
            }
        });
        if (I == 13)
        {
            K.setVisibility(0);
        } else
        {
            K.setVisibility(8);
        }
        if (bundle != null)
        {
            I = bundle.getInt("selectedNavigation", 13);
        }
        findViewById(0x7f1006cf).setOnTouchListener(new android.view.View.OnTouchListener() {

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                return false;
            }

        });
        bundle = getFragmentManager();
        obj = bundle.beginTransaction();
        B = (NavigationFragment)bundle.findFragmentByTag("left.fragment");
        if (B != null && B.isAdded())
        {
            ((FragmentTransaction) (obj)).show(B);
        } else
        {
            if (B == null)
            {
                B = NavigationFragment.a();
            }
            B.a(13);
            ((FragmentTransaction) (obj)).add(0x7f1006cf, B, "left.fragment");
        }
        B.a = new au(this);
        ((FragmentTransaction) (obj)).commitAllowingStateLoss();
        if (I == 11)
        {
            if (B != null)
            {
                B.a(11);
            }
            setTitle(getString(0x7f0802cb));
            K.setVisibility(8);
        } else
        if (I == 14)
        {
            if (B != null)
            {
                B.a(14);
            }
            setTitle(getString(0x7f08034b));
            K.setVisibility(8);
        } else
        if (I == 13)
        {
            if (B != null)
            {
                B.a(13);
            }
            K.setVisibility(0);
        }
        bundle = getFragmentManager();
        obj = bundle.beginTransaction();
        A = bundle.findFragmentByTag("notification.fragment");
        if (A != null && A.isAdded())
        {
            ((FragmentTransaction) (obj)).show(A);
        } else
        {
            A = new com.socialin.android.photo.notifications.a();
            ((FragmentTransaction) (obj)).add(0x7f1006ce, A, "notification.fragment");
        }
        ((com.socialin.android.photo.notifications.a)A).f = this;
        ((FragmentTransaction) (obj)).commitAllowingStateLoss();
        if (!isFinishing())
        {
            o = (ViewPager)findViewById(0x7f1006cc);
            if (o != null)
            {
                o.requestDisallowInterceptTouchEvent(true);
                n = (SlidingTabLayout)findViewById(0x7f10068c);
                o.setOffscreenPageLimit(4);
                o.setAdapter(p);
                n.setOnPageChangeListener(J);
                n.setViewPager(o);
                if (z < p.getCount())
                {
                    o.setCurrentItem(z);
                    if (z == 0)
                    {
                        J.onPageSelected(0);
                    }
                }
                p.f = z;
                if (o.getCurrentItem() > 1)
                {
                    com.socialin.android.photo.util.a.a(this).a = true;
                } else
                {
                    com.socialin.android.photo.util.a.a(this).a = false;
                }
            }
        }
        setProgressBarIndeterminateVisibility(false);
        if (!h)
        {
            h = true;
            SocialinV3.getInstance().refreshUser();
        }
        com.socialin.android.picsart.profile.util.y.h(this);
        if (SocialinApplication.b || !SocialinApplication.a && !SocialinApplication.b)
        {
            v.postDelayed(new Runnable() {

                private MainPagerActivity a;

                public final void run()
                {
                    if (!MainPagerActivity.k(a))
                    {
                        MainPagerActivity.l(a);
                    }
                }

            
            {
                a = MainPagerActivity.this;
                super();
            }
            }, 3000L);
        }
        new g(this);
        try
        {
            AppEventsLogger.activateApp(this);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (C) goto _L2; else goto _L1
_L1:
        intent1 = getIntent();
        if (intent1 == null) goto _L2; else goto _L3
_L3:
        C = true;
        obj1 = intent1.getAction();
        bundle1 = intent1.getExtras();
        bundle = intent1.getData();
        s4 = intent1.getType();
        if (bundle1 == null) goto _L2; else goto _L4
_L4:
        if ("navigation".equals(bundle1.getString("source")))
        {
            D = true;
        }
        SocialinV3.getInstance().getAppProps();
        flag = SocialinV3.getInstance().getSettings().isAppboyEnabled();
        if ("Appboy".equals(bundle1.getString("source")) && flag)
        {
            obj = bundle1.getString("cid");
            if (obj != null)
            {
                Appboy.getInstance(this).logPushNotificationOpened(((String) (obj)));
                bundle1.remove("source");
                getIntent().removeExtra("source");
            }
        }
        obj = bundle;
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        if ("android.intent.action.VIEW".equals(obj1))
        {
            bundle = getIntent().getData();
            getIntent().setAction("");
        }
        if ("android.intent.action.SEND".equals(obj1))
        {
            bundle = (Uri)bundle1.get("android.intent.extra.STREAM");
            getIntent().setAction("");
        }
        obj = bundle;
        if (!"android.intent.action.SEND_MULTIPLE".equals(obj1)) goto _L6; else goto _L7
_L7:
        obj = bundle;
        if (s4 == null) goto _L6; else goto _L8
_L8:
        obj = bundle;
        if (!s4.startsWith("image/")) goto _L6; else goto _L9
_L9:
        a(intent1);
        getIntent().setAction("");
_L2:
        bundle = getIntent().getData();
        if (bundle != null)
        {
            a(bundle);
        }
        if (!StudioManager.isHookHandled())
        {
            m();
        }
        (new StringBuilder("ProcInfo:")).append(PicsartContext.b);
        u = new com.socialin.android.photo.picsinphoto.c(this, new Handler());
        getContentResolver().registerContentObserver(SocialinV3.UPDATE_USER_URI, false, u);
        myobfuscated.f.m.a(this, getString(0x7f0808be)).getPurchasedItems(new myobfuscated.bp.b() {

            public final void a()
            {
                PublicSyncInventory.setAdsState(false);
            }

            public final void a(List list)
            {
                PublicSyncInventory.setAdsState(false);
                list = list.iterator();
                do
                {
label0:
                    {
                        if (list.hasNext())
                        {
                            if (!"ad_remover".equals((String)list.next()))
                            {
                                break label0;
                            }
                            PublicSyncInventory.setAdsState(true);
                        }
                        return;
                    }
                    PublicSyncInventory.setAdsState(false);
                } while (true);
            }

        });
        if (SocialinV3.getInstance().isRegistered() && !(new File(Inventory.getExternalCacheDirectory())).exists())
        {
            SocialinV3.getInstance().updateInventory();
        }
        r = new com.socialin.android.photo.picsinphoto.a(this, (byte)0);
        s = new com.socialin.android.photo.picsinphoto.d(this, (byte)0);
        t = new com.socialin.android.photo.picsinphoto.b(this, (byte)0);
        registerReceiver(r, new IntentFilter("com.picsart.studio.update.user.action"));
        registerReceiver(s, new IntentFilter("update.adds.enabled.action"));
        registerReceiver(t, new IntentFilter("com.picsart.studio.notification.action"));
        if (!SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            break MISSING_BLOCK_LABEL_1648;
        }
        bundle = SocialinV3.getInstance().getUser();
        obj = com.socialin.android.util.b.a(this);
        obj1 = SocialinV3.getInstance().getDeviceId();
        if (((b) (obj)).a != null)
        {
            ((b) (obj)).a.getCurrentUser().setCustomUserAttribute("device_id", ((String) (obj1)));
            ((b) (obj)).a.getCurrentUser().setCustomUserAttributeToNow((new StringBuilder("LastDate ")).append("device_id").toString());
        }
        if (TextUtils.isEmpty(Appboy.getInstance(this).getCurrentUser().getUserId()) && bundle != null)
        {
            try
            {
                ((b) (obj)).a(((User) (bundle)).id);
                ((b) (obj)).a(((User) (bundle)).email);
                Utils.l(this);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                com.socialin.android.d.b(g, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
                });
            }
        }
        G.connect();
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f0803df), "android-app://com.picsart.studio/picsart/login");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f0803df), "android-app://com.picsart.studio/picsart/login");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f0804d0), "android-app://com.picsart.studio/picsart/photos");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f0804d0), "android-app://com.picsart.studio/picsart/photos");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f0805f0), "android-app://com.picsart.studio/picsart/tags");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f0805f0), "android-app://com.picsart.studio/picsart/tags");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f0800f8), "android-app://com.picsart.studio/picsart/contests");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f0800f8), "android-app://com.picsart.studio/picsart/contests");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f08058d), "android-app://com.picsart.studio/picsart/shop");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f08058d), "android-app://com.picsart.studio/picsart/shop");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f080255), "android-app://com.picsart.studio/picsart/explore");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f080255), "android-app://com.picsart.studio/picsart/explore");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f080497), "android-app://com.picsart.studio/picsart/mynetwork");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f080497), "android-app://com.picsart.studio/picsart/mynetwork");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f08065a), "android-app://com.picsart.studio/picsart/users");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f08065a), "android-app://com.picsart.studio/picsart/users");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f080675), "android-app://com.picsart.studio/picsart/whatsnew");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f080675), "android-app://com.picsart.studio/picsart/whatsnew");
        myobfuscated.f.m.a(G, "http://schema.org/PhotographAction", getString(0x7f080090), "android-app://com.picsart.studio/picsart/camera");
        myobfuscated.f.m.b(G, "http://schema.org/PhotographAction", getString(0x7f080090), "android-app://com.picsart.studio/picsart/camera");
        myobfuscated.f.m.a(G, "http://schema.org/ActivateAction", getString(0x7f0800c7), "android-app://com.picsart.studio/picsart/collage");
        myobfuscated.f.m.b(G, "http://schema.org/ActivateAction", getString(0x7f0800c7), "android-app://com.picsart.studio/picsart/collage");
        myobfuscated.f.m.a(G, "http://schema.org/ActivateAction", getString(0x7f08012a), "android-app://com.picsart.studio/picsart/draw");
        myobfuscated.f.m.b(G, "http://schema.org/ActivateAction", getString(0x7f08012a), "android-app://com.picsart.studio/picsart/draw");
        myobfuscated.f.m.a(G, "http://schema.org/ActivateAction", getString(0x7f080227), "android-app://com.picsart.studio/picsart/effects");
        myobfuscated.f.m.b(G, "http://schema.org/ActivateAction", getString(0x7f080227), "android-app://com.picsart.studio/picsart/effects");
        myobfuscated.f.m.a(G, "http://schema.org/ActivateAction", getString(0x7f080148), "android-app://com.picsart.studio/picsart/editor");
        myobfuscated.f.m.b(G, "http://schema.org/ActivateAction", getString(0x7f080148), "android-app://com.picsart.studio/picsart/editor");
        myobfuscated.f.m.a(G, "http://schema.org/ViewAction", getString(0x7f0803df), "android-app://com.picsart.studio/picsart/login");
        myobfuscated.f.m.b(G, "http://schema.org/ViewAction", getString(0x7f0803df), "android-app://com.picsart.studio/picsart/login");
        setTheme(0x7f0c0197);
        return;
_L6:
        if (obj != null && !((Uri) (obj)).toString().startsWith("http://picsart.com/i/") && !((Uri) (obj)).toString().startsWith("https://picsart.com/i/"))
        {
            bundle = ((Uri) (obj)).toString();
            int i1;
            if (!TextUtils.isEmpty(bundle) && bundle.startsWith("http://picsart.com") && bundle.contains("ref=app_invite_inbox"))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 == 0)
            {
                if (((Uri) (obj)).toString().contains("file://"))
                {
                    String s2 = ((Uri) (obj)).toString().substring(7);
                    bundle = s2;
                    if (!(new File(s2)).exists())
                    {
                        bundle = Uri.decode(((Uri) (obj)).toString().substring(7));
                    }
                } else
                {
                    String s3 = com.socialin.android.util.w.a(((Uri) (obj)), this);
                    bundle = s3;
                    if (s3 == null)
                    {
                        bundle = com.socialin.android.util.w.a(this, ((Uri) (obj)), (new StringBuilder()).append(getString(0x7f0808fb)).append(File.separator).append(getString(0x7f08096a)).toString());
                    }
                }
                i1 = com.socialin.android.util.w.a(this, ((Uri) (obj)), bundle);
                com.socialin.android.d.b(d.a, new Object[] {
                    (new StringBuilder("onActivityResult() URI from share:")).append(bundle).toString()
                });
                if (!TextUtils.isEmpty(bundle) && !bundle.equals("null"))
                {
                    if (SocialinApplication.a)
                    {
                        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.AppOpenEvent("other_app", "install"));
                    } else
                    if (SocialinApplication.b)
                    {
                        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.AppOpenEvent("other_app", "update"));
                    } else
                    {
                        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.AppOpenEvent("other_app", "default"));
                    }
                    com.socialin.android.util.x.a();
                    bundle = com.socialin.android.util.x.a(bundle, true);
                    obj = new Intent(this, com/picsart/studio/editor/activity/EditorActivity);
                    ((Intent) (obj)).putExtra("editing_data", EditingData.a(com.picsart.studio.utils.c.a(this, null), "unknown"));
                    ((Intent) (obj)).putExtra("degree", i1);
                    ((Intent) (obj)).putExtra("path", bundle);
                    startActivity(((Intent) (obj)));
                }
            }
        }
        if (bundle1.containsKey("widget") && bundle1.getBoolean("widget"))
        {
            if (SocialinApplication.a)
            {
                AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.AppOpenEvent("widget", "install"));
            } else
            if (SocialinApplication.b)
            {
                AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.AppOpenEvent("widget", "update"));
            } else
            {
                AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.AppOpenEvent("widget", "default"));
            }
        }
        if (bundle1.getBoolean("openEdit", false))
        {
            StudioManager.openPhotoEditor(this);
            intent1.putExtra("openEdit", false);
        }
        if (bundle1.getBoolean("openCamera", false))
        {
            StudioManager.startCamera(this);
            intent1.putExtra("openCamera", false);
        }
        if (bundle1.getBoolean("openDraw", false))
        {
            StudioManager.openDrawDialog(this);
            intent1.putExtra("openDraw", false);
        }
        if (bundle1.getBoolean("openEffect", false))
        {
            StudioManager.openEffects(this);
            intent1.putExtra("openEffect", false);
        }
        if (bundle1.getBoolean("fromDesignMaker", false))
        {
            f = true;
            bundle = bundle1.getString("action");
            com.socialin.android.d.b(g, new Object[] {
                (new StringBuilder("fromDesignMaker!!!!action= ")).append(bundle).toString()
            });
            if (bundle.equals("upload"))
            {
                if (SocialinV3.getInstance().isRegistered())
                {
                    bundle = new Intent(this, com/socialin/android/picsart/upload/PicsartUploadEditActivity);
                    bundle.putExtras(bundle1);
                    startActivityForResult(bundle, 5);
                } else
                {
                    com.socialin.android.picsart.profile.util.y.e(this);
                }
            } else
            if (bundle.equals("profile"))
            {
                long l2 = SocialinV3.getInstance().getUser().id;
                if (l2 < 0L)
                {
                    bundle = "0";
                } else
                {
                    bundle = String.valueOf(l2);
                }
                GalleryUtils.a(this, bundle);
            }
        }
        if (true) goto _L2; else goto _L10
_L10:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        ActionBar actionbar;
        menu.clear();
        actionbar = getSupportActionBar();
        getMenuInflater().inflate(0x7f110008, menu);
        menu.findItem(0x7f100ae9).setVisible(false);
        menu.findItem(0x7f100aea).setVisible(false);
        menu.findItem(0x7f100aeb).setVisible(false);
        menu.findItem(0x7f100aec).setVisible(false);
        if (!l.isDrawerOpen(0x800005) || actionbar == null) goto _L2; else goto _L1
_L1:
        actionbar.setTitle(getString(0x7f08030f));
        menu.findItem(0x7f100aea).setVisible(true);
        menu.findItem(0x7f100aea).setShowAsAction(2);
        menu.findItem(0x7f100ae9).setVisible(true);
        menu.findItem(0x7f100ae9).setShowAsAction(2);
_L4:
        q = new com.socialin.android.photo.util.d(getResources().getDrawable(0x7f0203be), this);
        a(L);
        menu.findItem(0x7f100aec).setVisible(true);
        menu.findItem(0x7f100aec).setShowAsAction(2);
        menu.findItem(0x7f100aec).setIcon(q);
        return true;
_L2:
        if (getSupportActionBar() != null)
        {
            int i1 = o.getCurrentItem();
            if (I != 13)
            {
                break; /* Loop/switch isn't completed */
            }
            getSupportActionBar().setTitle(com.socialin.android.photo.picsinphoto.e.a[i1]);
            if (B != null)
            {
                B.a(13);
            }
        }
_L5:
        menu.findItem(0x7f100aeb).setVisible(true);
        menu.findItem(0x7f100aeb).setShowAsAction(2);
        if (true) goto _L4; else goto _L3
_L3:
        if (I == 14)
        {
            getSupportActionBar().setTitle(0x7f08034b);
            if (B != null)
            {
                B.a(14);
            }
        } else
        if (I == 11)
        {
            getSupportActionBar().setTitle(0x7f0802cb);
            if (B != null)
            {
                B.a(11);
            }
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void onDestroy()
    {
        if (v != null)
        {
            v.removeCallbacksAndMessages(null);
        }
        com.bumptech.glide.b.a(getApplicationContext()).a();
        if (u != null)
        {
            getContentResolver().unregisterContentObserver(u);
        }
        if (isFinishing() && x != null)
        {
            (new com.socialin.android.util.a._cls1(x)).start();
            com.socialin.android.util.m m1 = com.socialin.android.util.m.a();
            String s1 = com.socialin.android.photo.g.a(this);
            if (FileUtils.a())
            {
                if (FileUtils.a())
                {
                    long l1 = FileUtils.c();
                    if (!d.b);
                    if (30L > l1)
                    {
                        m1.a(30L - l1, s1);
                    }
                }
                float f1 = m1.a(new File(s1));
                if (!d.b);
                if (f1 > 30F)
                {
                    m1.a(15F, s1);
                }
            }
            if (!EffectsActivityNew.a)
            {
                com.socialin.android.util.w.d((new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f08096b)).toString());
            }
            if (!EffectsActivityNew.a)
            {
                com.socialin.android.util.w.d((new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f08096c)).toString());
            }
            com.socialin.android.util.w.c("PicsArt/.multiselect/cache/thumb");
            com.socialin.android.util.w.c("PicsArt/.multiselect/cache/images");
            myobfuscated.bn.a.b();
        }
        if (r != null)
        {
            unregisterReceiver(r);
        }
        if (s != null)
        {
            unregisterReceiver(s);
        }
        if (t != null)
        {
            unregisterReceiver(t);
        }
        if (i != null)
        {
            j.removeUpdates(i);
            i = null;
            j = null;
        }
        com.socialin.android.picsart.profile.invite.i.a(this).edit().putBoolean("exit_app", true).apply();
        com.socialin.android.picsart.profile.invite.a.a = false;
        super.onDestroy();
    }

    public void onFragmentFinishWithResultOK(int i1)
    {
        super.onFragmentFinishWithResultOK(i1);
        i1;
        JVM INSTR lookupswitch 3: default 40
    //                   15: 85
    //                   126: 94
    //                   150: 94;
           goto _L1 _L2 _L3 _L3
_L1:
        if (p != null)
        {
            p.a();
            if (n != null)
            {
                n.setViewPager(o);
                n.invalidate();
            }
        }
        invalidateOptionsMenu();
        return;
_L2:
        I = 13;
        continue; /* Loop/switch isn't completed */
_L3:
        a(0);
        Object obj = new Intent(this, com/socialin/android/photo/notifications/NotificationsService);
        ((Intent) (obj)).setAction("action.delete");
        startService(((Intent) (obj)));
        obj = new Intent(this, com/picsart/upload/UploadService);
        ((Intent) (obj)).setAction("picsart.upload.delete.all");
        startService(((Intent) (obj)));
        i();
        obj = p.e;
        if (obj != null && (obj instanceof myobfuscated.cs.e))
        {
            ((myobfuscated.cs.e)obj).g();
        }
        if (p == null) goto _L5; else goto _L4
_L4:
        Object obj1 = p;
        if (((com.socialin.android.photo.picsinphoto.e) (obj1)).d == null)
        {
            obj1.d = ((com.socialin.android.photo.picsinphoto.e) (obj1)).c.beginTransaction();
        }
        obj1 = ((com.socialin.android.photo.picsinphoto.e) (obj1)).c.findFragmentByTag("my.network.fragment");
        if (obj1 != null)
        {
            try
            {
                ((at)obj1).n();
            }
            catch (Exception exception)
            {
                com.socialin.android.d.b("FragmentPagerAdapter", new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
            }
        }
_L5:
        if (A != null && A.isAdded())
        {
            ((com.socialin.android.photo.notifications.a)A).a();
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        com.bumptech.glide.b.a(getApplicationContext()).onLowMemory();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        C = false;
        m();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131757801 2131757804: default 36
    //                   2131757801 158
    //                   2131757802 195
    //                   2131757803 38
    //                   2131757804 69;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L4:
        menuitem = new Intent(this, com/socialin/android/picsart/profile/activity/SearchActivity);
        menuitem.putExtra("source", "direct");
        startActivity(menuitem);
        continue; /* Loop/switch isn't completed */
_L5:
        if (l.isDrawerOpen(0x800003))
        {
            l.closeDrawer(0x800003);
        }
        if (l.isDrawerOpen(0x800005))
        {
            l.closeDrawer(0x800005);
        } else
        {
            l.openDrawer(0x800005);
            if (A != null && A.isAdded())
            {
                ((com.socialin.android.photo.notifications.a)A).a();
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        A = getFragmentManager().findFragmentByTag("notification.fragment");
        if (A != null)
        {
            ((com.socialin.android.photo.notifications.a)A).a("action.delete");
        }
        continue; /* Loop/switch isn't completed */
_L3:
        k();
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        if (m != null)
        {
            m.syncState();
        }
        (new Thread() {

            final MainPagerActivity a;

            public final void run()
            {
label0:
                {
                    if (Inventory.isAdsEnabled())
                    {
                        if (!myobfuscated.bn.a.a(a))
                        {
                            break label0;
                        }
                        com.socialin.android.d.b(com.socialin.android.photo.picsinphoto.MainPagerActivity.e(), new Object[] {
                            "Vaelil FS es anqam."
                        });
                        a.runOnUiThread(new Runnable() {

                            public final void run()
                            {
                            }

                        });
                        try
                        {
                            Thread.sleep(4000L);
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            com.socialin.android.d.b(com.socialin.android.photo.picsinphoto.MainPagerActivity.e(), new Object[] {
                                (new StringBuilder("Got unexpected exception: ")).append(interruptedexception.getMessage()).toString()
                            });
                        }
                        a.runOnUiThread(new Runnable(this) {

                            private _cls3 a;

                            public final void run()
                            {
                                DialogUtils.openInfoDialog("", a.a.getString(0x7f0802a9), "", a.a.getString(0x7f080569), a.a, Integer.valueOf(0));
                            }

            
            {
                a = _pcls3;
                super();
            }
                        });
                    }
                    return;
                }
                a.runOnUiThread(new Runnable(this) {

                    private _cls3 a;

                    public final void run()
                    {
                        ab.a(a.a, 2);
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
            }

            
            {
                a = MainPagerActivity.this;
                super();
            }
        }).start();
        if (!com.picsart.studio.utils.c.c(getApplicationContext()))
        {
            j = (LocationManager)getApplicationContext().getSystemService("location");
            i = new LocationListener() {

                final MainPagerActivity a;

                public final void onLocationChanged(Location location)
                {
                    (new Thread(new Runnable(this, location) {

                        private Location a;
                        private _cls2 b;

                        public final void run()
                        {
                            List list;
                            try
                            {
                                list = com.picsart.studio.utils.c.b(b.a.getApplicationContext(), a.getLatitude(), a.getLongitude());
                            }
                            catch (Exception exception)
                            {
                                exception.printStackTrace();
                                return;
                            }
                            if (list == null)
                            {
                                break MISSING_BLOCK_LABEL_67;
                            }
                            if (list.size() > 0)
                            {
                                com.picsart.studio.utils.c.a(b.a.getApplicationContext(), ((Address)list.get(0)).getCountryCode());
                            }
                        }

            
            {
                b = _pcls2;
                a = location;
                super();
            }
                    })).start();
                }

                public final void onProviderDisabled(String s1)
                {
                }

                public final void onProviderEnabled(String s1)
                {
                }

                public final void onStatusChanged(String s1, int i1, Bundle bundle1)
                {
                }

            
            {
                a = MainPagerActivity.this;
                super();
            }
            };
            com.picsart.studio.utils.c.a(getApplicationContext(), i);
        }
    }

    protected void onPostResume()
    {
        super.onPostResume();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        y = bundle.getLong("lastRefreshTime");
    }

    protected void onResume()
    {
        super.onResume();
        (new GetAppPropsController("props", false)).doRequest();
        if (SocialinV3.getInstance().getSettings().isContactSyncEnabled())
        {
            myobfuscated.cy.a.b(getApplicationContext());
        }
        com.socialin.android.apiv3.model.AppProps.Api api = SocialinV3.getInstance().getAppProps().getData().api;
        if (api != null)
        {
            try
            {
                if ("pull".equals(api.notificationPolicy) || "pullpush".equals(api.notificationPolicy))
                {
                    Intent intent = new Intent(this, com/socialin/android/photo/notifications/NotificationsService);
                    intent.setAction("action.start.continuous.refresh");
                    startService(intent);
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        if (I != 13) goto _L2; else goto _L1
_L1:
        getSupportActionBar().setTitle(com.socialin.android.photo.picsinphoto.e.a[o.getCurrentItem()]);
        B.a(13);
_L4:
        if (!PublicSyncInventory.publicInventoryFileExists())
        {
            myobfuscated.f.m.a(this, getString(0x7f0808be)).getPurchasedItems(new myobfuscated.bp.b() {

                private MainPagerActivity a;

                public final void a()
                {
                }

                public final void a(List list)
                {
                    myobfuscated.f.m.a(a, a.getString(0x7f0808be)).requestShopItems(true, new myobfuscated.bp.c(list) {

                        private List a;

                        public final void a(ArrayList arraylist)
                        {
                            PublicSyncInventory.createEmptyInventoryFile();
                            for (arraylist = arraylist.iterator(); arraylist.hasNext();)
                            {
                                com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.next();
                                Iterator iterator = a.iterator();
                                while (iterator.hasNext()) 
                                {
                                    if (((String)iterator.next()).equals(shopitem.data.shopItemUid))
                                    {
                                        PublicSyncInventory.writeShopItem(shopitem);
                                    }
                                }
                            }

                        }

            
            {
                a = list;
                super();
            }
                    });
                }

            
            {
                a = MainPagerActivity.this;
                super();
            }
            });
        }
        invalidateOptionsMenu();
        p.a(true);
        return;
_L2:
        if (I == 14)
        {
            getSupportActionBar().setTitle(getString(0x7f08034b));
            B.a(14);
        } else
        if (I == 11)
        {
            getSupportActionBar().setTitle(getString(0x7f0802cb));
            B.a(11);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (bundle == null) goto _L2; else goto _L1
_L1:
        if (o == null || o.getChildCount() <= 0) goto _L2; else goto _L3
_L3:
        Fragment fragment;
        bundle.putInt("currentPage", z);
        bundle.putLong("lastRefreshTime", y);
        fragment = getFragmentManager().findFragmentByTag("find.friends.fragment");
        if (fragment == null) goto _L5; else goto _L4
_L4:
        if (!fragment.isVisible()) goto _L5; else goto _L6
_L6:
        boolean flag = true;
_L8:
        bundle.putBoolean("keyFindFriendsOpened", flag);
        bundle.putInt("selectedNavigation", I);
        bundle.putBoolean("isIntentReaded", C);
_L2:
        super.onSaveInstanceState(bundle);
        return;
_L5:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        bundle;
        com.socialin.android.d.b(g, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
        });
        return;
    }

    protected void onStart()
    {
        super.onStart();
        if (com.socialin.android.picsart.profile.invite.i.h())
        {
            f();
        } else
        if (!com.socialin.android.picsart.profile.invite.a.a)
        {
            com.socialin.android.picsart.profile.invite.a.a(this, new io.branch.referral.i() {

                private MainPagerActivity a;

                public final void a(JSONObject jsonobject, io.branch.referral.m m1)
                {
                    if (m1 == null && "ad_remover".equals(jsonobject.optString("campaign")))
                    {
                        com.socialin.android.photo.picsinphoto.MainPagerActivity.m(a);
                    }
                }

            
            {
                a = MainPagerActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onStop()
    {
        super.onStop();
        if (G.isConnected())
        {
            G.disconnect();
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        if (getSupportActionBar() != null)
        {
            Object obj = charsequence;
            if (charsequence == null)
            {
                obj = getString(0x7f080324);
            }
            getSupportActionBar().setTitle(((CharSequence) (obj)));
        }
    }

}
