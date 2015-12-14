// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.picsart.studio.util.StudioManager;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.GetExploreCardController;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.Tag;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.model.card.Card;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.picsart.profile.adapter.CardWebView;
import com.socialin.android.picsart.profile.adapter.c;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.h;
import com.socialin.android.picsart.profile.util.x;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.Utils;
import com.socialin.android.util.b;
import java.util.List;
import myobfuscated.cr.f;
import myobfuscated.cs.e;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            a

public class v extends com.socialin.android.picsart.profile.fragment.a
    implements a, e
{

    private static final String m = com/socialin/android/picsart/profile/fragment/v.getSimpleName();
    private GetExploreCardController n;
    private c o;

    public v()
    {
    }

    public static v m()
    {
        return new v();
    }

    public final void a()
    {
        super.a();
        if (getActivity() != null && !getActivity().isFinishing() && o.isEmpty())
        {
            a(e());
        }
    }

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        Object obj = null;
        com.socialin.android.picsart.profile.fragment._cls3.a[itemcontrol.ordinal()];
        JVM INSTR tableswitch 1 8: default 1031
    //                   1 56
    //                   2 377
    //                   3 461
    //                   4 593
    //                   5 733
    //                   6 863
    //                   7 929
    //                   8 973;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L2:
        itemcontrol = (Card)aobj[0];
        obj = myobfuscated.f.m.a(itemcontrol);
        if (TextUtils.isEmpty(((Card) (itemcontrol)).type)) goto _L11; else goto _L10
_L10:
        if (!((Card) (itemcontrol)).type.contains("user")) goto _L13; else goto _L12
_L12:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.UsersOpenEvent(myobfuscated.f.m.g(((Card) (itemcontrol)).key), ((org.json.JSONObject) (obj))));
_L11:
        if (aobj.length <= 1) goto _L15; else goto _L14
_L14:
        aobj = (String)aobj[1];
        if (!"footer".equals(((Object) (aobj)))) goto _L17; else goto _L16
_L16:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickSeeAllEvent(((org.json.JSONObject) (obj)), "explore"));
        o.a(itemcontrol, "footer_click");
_L15:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickSeeAllEvent(((org.json.JSONObject) (obj)), "explore"));
        aobj = new Intent("android.intent.action.VIEW");
        ((Intent) (aobj)).setData(Uri.parse(((Card) (itemcontrol)).action));
        ((Intent) (aobj)).putExtra("title", ((Card) (itemcontrol)).title);
        startActivity(((Intent) (aobj)));
        return;
_L13:
        if (!((Card) (itemcontrol)).type.contains("photo")) goto _L19; else goto _L18
_L18:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.PhotosOpenEvent(myobfuscated.f.m.h(((Card) (itemcontrol)).key), ((org.json.JSONObject) (obj))));
          goto _L11
_L19:
        if (!((Card) (itemcontrol)).type.contains("tag")) goto _L11; else goto _L20
_L20:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.TagsOpenEvent(myobfuscated.f.m.f(((Card) (itemcontrol)).key), ((org.json.JSONObject) (obj))));
        o.a(itemcontrol, "tag_click");
          goto _L11
_L17:
        if (!"header".equals(((Object) (aobj)))) goto _L15; else goto _L21
_L21:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickTitleEvent(((org.json.JSONObject) (obj)), "explore"));
        o.a(itemcontrol, "header_click");
          goto _L15
_L3:
        try
        {
            itemcontrol = (Card)aobj[1];
            aobj = (ViewerUser)aobj[0];
            obj = myobfuscated.f.m.a(itemcontrol);
        }
        // Misplaced declaration of an exception variable
        catch (ItemControl itemcontrol)
        {
            d.b(m, "onClicked", itemcontrol);
            return;
        }
        if (aobj != null) goto _L23; else goto _L22
_L22:
        Utils.c(getActivity(), getString(0x7f08024e));
        return;
_L23:
        GalleryUtils.a(getActivity(), ((ViewerUser) (aobj)), "explore", ((org.json.JSONObject) (obj)));
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickProfileEvent(((org.json.JSONObject) (obj)), ((ViewerUser) (aobj)).id));
        o.a(itemcontrol, "user_open");
        return;
_L4:
        itemcontrol = (Card)aobj[1];
        aobj = (ViewerUser)aobj[0];
        obj = myobfuscated.f.m.a(itemcontrol);
        x.a(((ViewerUser) (aobj)), this, new _cls2(), ((org.json.JSONObject) (obj)), "explore");
        if (!((ViewerUser) (aobj)).isOwnerFollowing) goto _L25; else goto _L24
_L24:
        o.a(itemcontrol, "user_unfollow");
_L28:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("explore", "follow_tag"));
        }
        itemcontrol = AnalyticUtils.getInstance(getActivity());
        if (aobj == null) goto _L27; else goto _L26
_L26:
        long l = ((ViewerUser) (aobj)).id;
_L37:
        itemcontrol.track(new com.socialin.android.apiv3.events.EventsFactory.CardClickFollowEvent(((org.json.JSONObject) (obj)), l));
        return;
_L25:
        o.a(itemcontrol, "user_follow");
          goto _L28
_L5:
        itemcontrol = (Card)aobj[1];
        aobj = (Tag)aobj[0];
        obj = myobfuscated.f.m.a(itemcontrol);
        x.a(((Tag) (aobj)), this, null, ((org.json.JSONObject) (obj)), "explore_tag_card");
        if (!((Tag) (aobj)).isTagFollow) goto _L30; else goto _L29
_L29:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickTagRemoveFavoritesEvent(((org.json.JSONObject) (obj)), ((Tag) (aobj)).name));
        o.a(itemcontrol, "tag_unfollow");
_L31:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("explore", "follow_tag"));
            return;
        }
          goto _L1
_L30:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickTagAddFavoritesEvent(((org.json.JSONObject) (obj)), ((Tag) (aobj)).name));
        o.a(itemcontrol, "tag_follow");
          goto _L31
_L6:
        obj = (ImageItem)aobj[0];
        if (aobj.length <= 2) goto _L33; else goto _L32
_L32:
        itemcontrol = (Card)aobj[2];
_L36:
        org.json.JSONObject jsonobject = myobfuscated.f.m.a(itemcontrol);
        if (aobj.length > 3)
        {
            String s1 = (String)aobj[3];
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickPhotoEvent(jsonobject, s1, i, "explore", ((ImageItem) (obj)).id));
        }
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            b.a(getActivity()).b("explorer_photo_open");
        }
        o.a(itemcontrol, "photo_open");
        GalleryUtils.a(this, (List)aobj[1], i, -1, ((BaseActivity)getActivity()).getGalleryItemFragmentFrame(), itemcontrol);
        return;
_L7:
        String s = (String)aobj[0];
        itemcontrol = ((ItemControl) (obj));
        if (aobj.length > 1)
        {
            itemcontrol = (Card)aobj[1];
        }
        aobj = new Intent("android.intent.action.VIEW");
        if (s == null) goto _L35; else goto _L34
_L34:
        ((Intent) (aobj)).setData(Uri.parse(s));
        startActivity(((Intent) (aobj)));
_L35:
        o.a(itemcontrol, "weblink_click");
        return;
_L8:
        itemcontrol = (List)aobj[0];
        aobj = (Card)aobj[1];
        o.a(((Card) (aobj)), "photo_open");
        GalleryUtils.a(this, itemcontrol, i, -1, ((BaseActivity)getActivity()).getGalleryItemFragmentFrame(), ((Card) (aobj)));
        return;
_L9:
        itemcontrol = new Intent();
        itemcontrol.addCategory("android.intent.category.DEFAULT");
        itemcontrol.setClass(getActivity(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity);
        itemcontrol.setFlags(0x4000000);
        itemcontrol.putExtra("from", "explore");
        startActivityForResult(itemcontrol, 1);
        return;
_L33:
        itemcontrol = null;
          goto _L36
_L1:
        return;
_L27:
        l = -1L;
          goto _L37
    }

    public final void a(boolean flag, boolean flag1)
    {
        if (!o.isEmpty())
        {
            o.b(true);
        }
        super.a(flag, flag1);
    }

    public final void a(boolean flag, boolean flag1, boolean flag2)
    {
        super.a(flag, flag1, flag2);
        for (int i = 0; i < a_.getChildCount(); i++)
        {
            View view = a_.getChildAt(i);
            if (view == null)
            {
                continue;
            }
            view = view.findViewById(0x7f100ad9);
            if (view instanceof CardWebView)
            {
                ((CardWebView)view).reload();
            }
        }

    }

    protected final View e()
    {
        Activity activity = getActivity();
        View view = activity.getLayoutInflater().inflate(0x7f03020c, null, false);
        StudioManager.assignStudioButtonActions(view, activity, null);
        view.findViewById(0x7f100979).setOnClickListener(new h(this));
        return view;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        boolean flag1 = false;
        setUserVisibleHint(false);
        o.b.a();
        super.onConfigurationChanged(configuration);
        g();
        GetExploreCardController getexplorecardcontroller = n;
        boolean flag = flag1;
        if (Utils.h(getActivity()))
        {
            flag = flag1;
            if (configuration.orientation == 2)
            {
                flag = true;
            }
        }
        getexplorecardcontroller.setLoadDataForTabletLandscape(flag);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i = (int)getResources().getDimension(0x7f0b009d);
        int j = getResources().getColor(0x7f0f009b);
        int k = getResources().getInteger(0x7f0e001b);
        int l = getResources().getInteger(0x7f0e0015);
        bundle = y.a(getActivity().getApplicationContext());
        Object obj = new myobfuscated.cr.h(getResources());
        obj.f = 0;
        obj.j = i;
        obj.e = j;
        obj.i = 0;
        a(((myobfuscated.cr.h) (obj)).a(k, l).a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.STAGGERED
        }).b());
        a(getActivity());
        o = new c(getActivity(), this);
        o.a = i;
        o.a(((Point) (bundle)).x, ((Point) (bundle)).y);
        n = new GetExploreCardController();
        obj = (GetItemsParams)n.getRequestParams();
        Location location = com.picsart.studio.utils.c.a(getActivity(), null);
        if (location != null)
        {
            obj.latitude = location.getLatitude();
            obj.longitude = location.getLongitude();
        }
        obj = n;
        boolean flag;
        if (Utils.h(getActivity()) && Utils.j(getActivity()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((GetExploreCardController) (obj)).setLoadDataForTabletLandscape(flag);
        obj = a(o);
        a(com.socialin.android.apiv3.model.AppProps.TabAdType.EXPLORE, bundle);
        b(((com.socialin.android.adapter.RecyclerViewAdapter) (obj)), myobfuscated.cr.a.a(n, ((com.socialin.android.adapter.RecyclerViewAdapter) (obj))));
    }

    public void onDestroy()
    {
        super.onDestroy();
        o.b.a();
        l();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        o.b.a();
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        com.bumptech.glide.b.a(getActivity().getApplicationContext()).onLowMemory();
    }

    public void onResume()
    {
        super.onResume();
        o.a(false);
        if (o.isEmpty())
        {
            a(false, true, true);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onStop()
    {
        super.onStop();
        setUserVisibleHint(false);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        a_.setRecyclerListener(new _cls1());
    }

    public void setUserVisibleHint(boolean flag)
    {
        if (o != null && getUserVisibleHint() != flag)
        {
            if (flag)
            {
                o.a(true);
            } else
            {
                o.b(false);
            }
        }
        super.setUserVisibleHint(flag);
    }


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
