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
import android.view.View;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.GetTrendingCardController;
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
import com.socialin.android.picsart.profile.util.x;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.Utils;
import java.util.List;
import myobfuscated.cr.f;
import myobfuscated.cr.h;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            a

public class bj extends com.socialin.android.picsart.profile.fragment.a
    implements a
{

    private static final String m = com/socialin/android/picsart/profile/fragment/bj.getSimpleName();
    private GetTrendingCardController n;
    private c o;

    public bj()
    {
    }

    public static bj m()
    {
        return new bj();
    }

    public final void a()
    {
        super.a();
        if (getActivity() != null && !getActivity().isFinishing() && o.isEmpty())
        {
            View view = myobfuscated.f.m.a(getActivity(), 0x7f0805cb);
            if (view != null)
            {
                a(view, false);
            }
        }
    }

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        org.json.JSONObject jsonobject = null;
        com.socialin.android.picsart.profile.fragment._cls3.a[itemcontrol.ordinal()];
        JVM INSTR tableswitch 1 7: default 880
    //                   1 52
    //                   2 352
    //                   3 436
    //                   4 568
    //                   5 708
    //                   6 756
    //                   7 822;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        itemcontrol = (Card)aobj[0];
        jsonobject = myobfuscated.f.m.a(itemcontrol);
        if (TextUtils.isEmpty(((Card) (itemcontrol)).type)) goto _L10; else goto _L9
_L9:
        if (!((Card) (itemcontrol)).type.contains("user")) goto _L12; else goto _L11
_L11:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.UsersOpenEvent(myobfuscated.f.m.g(((Card) (itemcontrol)).key), jsonobject));
_L10:
        if (aobj.length <= 1) goto _L14; else goto _L13
_L13:
        aobj = (String)aobj[1];
        if (!"footer".equals(((Object) (aobj)))) goto _L16; else goto _L15
_L15:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickSeeAllEvent(jsonobject, "artists"));
        o.a(itemcontrol, "footer_click");
_L14:
        aobj = new Intent("android.intent.action.VIEW");
        ((Intent) (aobj)).setData(Uri.parse(((Card) (itemcontrol)).action));
        ((Intent) (aobj)).putExtra("title", ((Card) (itemcontrol)).title);
        startActivity(((Intent) (aobj)));
        return;
_L12:
        if (!((Card) (itemcontrol)).type.contains("photo")) goto _L18; else goto _L17
_L17:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.PhotosOpenEvent(myobfuscated.f.m.h(((Card) (itemcontrol)).key), jsonobject));
          goto _L10
_L18:
        if (!((Card) (itemcontrol)).type.contains("tag")) goto _L10; else goto _L19
_L19:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.TagsOpenEvent(myobfuscated.f.m.f(((Card) (itemcontrol)).key), jsonobject));
        o.a(itemcontrol, "tag_click");
          goto _L10
_L16:
        if (!"header".equals(((Object) (aobj)))) goto _L14; else goto _L20
_L20:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickTitleEvent(jsonobject, "artists"));
        o.a(itemcontrol, "footer_click");
          goto _L14
_L3:
        try
        {
            itemcontrol = (Card)aobj[1];
            aobj = (ViewerUser)aobj[0];
            jsonobject = myobfuscated.f.m.a(itemcontrol);
        }
        // Misplaced declaration of an exception variable
        catch (ItemControl itemcontrol)
        {
            d.b(m, "onCLicked", itemcontrol);
            return;
        }
        if (aobj != null) goto _L22; else goto _L21
_L21:
        Utils.c(getActivity(), getString(0x7f08024e));
        return;
_L22:
        GalleryUtils.a(getActivity(), ((ViewerUser) (aobj)), "artists", jsonobject);
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickProfileEvent(jsonobject, ((ViewerUser) (aobj)).id));
        o.a(itemcontrol, "user_open");
        return;
_L4:
        itemcontrol = (Card)aobj[1];
        aobj = (ViewerUser)aobj[0];
        jsonobject = myobfuscated.f.m.a(itemcontrol);
        x.a(((ViewerUser) (aobj)), this, new _cls2(), jsonobject, "artists");
        if (!((ViewerUser) (aobj)).isOwnerFollowing) goto _L24; else goto _L23
_L23:
        o.a(itemcontrol, "user_unfollow");
_L27:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("artists", "follow_user"));
        }
        itemcontrol = AnalyticUtils.getInstance(getActivity());
        if (aobj == null) goto _L26; else goto _L25
_L25:
        long l = ((ViewerUser) (aobj)).id;
_L36:
        itemcontrol.track(new com.socialin.android.apiv3.events.EventsFactory.CardClickFollowEvent(jsonobject, l));
        return;
_L24:
        o.a(itemcontrol, "user_follow");
          goto _L27
_L5:
        itemcontrol = (Card)aobj[1];
        aobj = (Tag)aobj[0];
        jsonobject = myobfuscated.f.m.a(itemcontrol);
        x.a(((Tag) (aobj)), this, null, jsonobject, "artists");
        if (!((Tag) (aobj)).isTagFollow) goto _L29; else goto _L28
_L28:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickTagRemoveFavoritesEvent(jsonobject, ((Tag) (aobj)).name));
        o.a(itemcontrol, "tag_unfollow");
_L30:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("artists", "follow_tag"));
            return;
        }
          goto _L1
_L29:
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CardClickTagAddFavoritesEvent(jsonobject, ((Tag) (aobj)).name));
        o.a(itemcontrol, "tag_follow");
          goto _L30
_L6:
        if (aobj.length <= 2) goto _L32; else goto _L31
_L31:
        itemcontrol = (Card)aobj[2];
_L35:
        o.a(itemcontrol, "photo_open");
        GalleryUtils.a(this, (List)aobj[1], i, -1, ((BaseActivity)getActivity()).getGalleryItemFragmentFrame(), itemcontrol);
        return;
_L7:
        String s = (String)aobj[0];
        itemcontrol = jsonobject;
        if (aobj.length > 1)
        {
            itemcontrol = (Card)aobj[1];
        }
        aobj = new Intent("android.intent.action.VIEW");
        if (s == null) goto _L34; else goto _L33
_L33:
        ((Intent) (aobj)).setData(Uri.parse(s));
        startActivity(((Intent) (aobj)));
_L34:
        o.a(itemcontrol, "weblink_click");
        return;
_L8:
        itemcontrol = new Intent();
        itemcontrol.addCategory("android.intent.category.DEFAULT");
        itemcontrol.setClass(getActivity(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity);
        itemcontrol.setFlags(0x4000000);
        itemcontrol.putExtra("from", "artists");
        startActivityForResult(itemcontrol, 1);
        return;
_L32:
        itemcontrol = null;
          goto _L35
_L1:
        return;
_L26:
        l = -1L;
          goto _L36
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

    public void onConfigurationChanged(Configuration configuration)
    {
        boolean flag1 = false;
        setUserVisibleHint(false);
        o.b.a();
        super.onConfigurationChanged(configuration);
        g();
        GetTrendingCardController gettrendingcardcontroller = n;
        boolean flag = flag1;
        if (Utils.h(getActivity()))
        {
            flag = flag1;
            if (configuration.orientation == 2)
            {
                flag = true;
            }
        }
        gettrendingcardcontroller.setLoadDataForTabletLandscape(flag);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i = (int)getResources().getDimension(0x7f0b009d);
        int j = getResources().getColor(0x7f0f009b);
        int k = getResources().getInteger(0x7f0e001b);
        int l = getResources().getInteger(0x7f0e0015);
        bundle = y.a(getActivity().getApplicationContext());
        Object obj = new h(getResources());
        obj.f = 0;
        obj.j = i;
        obj.e = j;
        obj.i = 0;
        a(((h) (obj)).a(k, l).a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.STAGGERED
        }).b());
        a(getActivity());
        o = new c(getActivity(), this);
        o.a = i;
        o.a(((Point) (bundle)).x, ((Point) (bundle)).y);
        n = new GetTrendingCardController();
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
        ((GetTrendingCardController) (obj)).setLoadDataForTabletLandscape(flag);
        obj = a(o);
        a(com.socialin.android.apiv3.model.AppProps.TabAdType.ARTISTS, bundle);
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
