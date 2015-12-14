// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.picsart.studio.utils.ItemControl;
import com.picsart.studio.utils.c;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddFollowingController;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.GetUsersParams;
import com.socialin.android.d;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.instagram.h;
import com.socialin.android.picsart.profile.adapter.az;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.twitter.TwitterSessionManager;
import com.socialin.android.util.s;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.cr.f;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

public class x extends f
    implements LocationListener, a
{

    static final String c = com/socialin/android/picsart/profile/fragment/x.getSimpleName();
    az d;
    AddFollowingController m;
    private BaseSocialinApiRequestController n;
    private BaseSocialinApiRequestController o;
    private String p;
    private GetUsersParams q;
    private Location r;
    private View s;

    public x()
    {
        n = RequestControllerFactory.createUserSuggestionsController();
        m = new AddFollowingController();
        p = "topUsers";
        setRetainInstance(false);
    }

    static BaseSocialinApiRequestController a(x x1)
    {
        return x1.o;
    }

    static GetUsersParams a(x x1, GetUsersParams getusersparams)
    {
        x1.q = getusersparams;
        return getusersparams;
    }

    static String a(x x1, List list)
    {
        int i = 40;
        if (list != null && !list.isEmpty() && list.size() > 0) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L4:
        return ((String) (obj));
_L2:
        int j = list.size();
        if (40 > j)
        {
            i = j;
        }
        x1 = "";
        j = 0;
        do
        {
            obj = x1;
            if (j >= i)
            {
                continue;
            }
            obj = (new StringBuilder()).append(x1).append((String)list.get(j)).toString();
            x1 = ((x) (obj));
            if (j < i - 1)
            {
                x1 = (new StringBuilder()).append(((String) (obj))).append(",").toString();
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Location location)
    {
        if (location != null)
        {
            double d1 = location.getLatitude();
            double d2 = location.getLongitude();
            location = new Adress();
            location.setLatitude((float)d1);
            location.setLongitude((float)d2);
            if (SocialinV3.getInstance().getUser().isRegistered())
            {
                SocialinV3.getInstance().getUser().address = location;
            }
            q = ((GetUsersParams)o.getRequestParams()).clearParams();
            q.near = (new StringBuilder()).append(location.getLatitude()).append(",").append(location.getLongitude()).toString();
            getActivity().runOnUiThread(new _cls3());
        }
    }

    static GetUsersParams b(x x1)
    {
        return x1.q;
    }

    static void b(x x1, List list)
    {
        String s1 = String.valueOf(list.get(0));
        for (int i = 1; i < list.size(); i++)
        {
            s1 = (new StringBuilder()).append(s1).append(",").append(String.valueOf(list.get(i))).toString();
        }

        x1.q = ((GetUsersParams)x1.o.getRequestParams()).clearParams();
        x1.q.instagramIds = s1;
        x1.getActivity().getIntent().putExtra("instagramUserIds", s1);
        x1.getActivity().runOnUiThread(new _cls6(x1));
    }

    static void c(x x1)
    {
        x1.l();
    }

    static void d(x x1)
    {
        x1.getActivity().runOnUiThread(new _cls5(x1));
    }

    static View e(x x1)
    {
        return x1.s;
    }

    static az f(x x1)
    {
        return x1.d;
    }

    public static x g()
    {
        return new x();
    }

    private void l()
    {
label0:
        {
            if (getActivity() != null && !getActivity().isFinishing())
            {
                if (com.socialin.android.util.s.a(getActivity()))
                {
                    break label0;
                }
                GalleryUtils.a(getActivity());
                a(myobfuscated.f.m.a(getActivity(), 0x7f0805cb));
            }
            return;
        }
        a(false, true, true);
    }

    public final void a()
    {
        super.a();
        if (d.isEmpty() && com.socialin.android.util.s.a(getActivity()))
        {
            a(myobfuscated.f.m.a(getActivity(), 0x7f0803fa));
        }
    }

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        ViewerUser vieweruser = (ViewerUser)d.getItem(i);
        switch (com.socialin.android.picsart.profile.fragment._cls2.a[itemcontrol.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            GalleryUtils.a(getActivity(), vieweruser.id, null, "find_friends");
            return;

        case 2: // '\002'
            com.socialin.android.picsart.profile.util.x.a(vieweruser, this, new _cls10(i), "find_friends");
            return;

        case 3: // '\003'
            y.a(this, (ImageItem)aobj[0], vieweruser, 0);
            break;
        }
    }

    public final void b(View view)
    {
        s = view;
        view.setOnClickListener(new _cls8());
    }

    public final void k()
    {
        Object obj2;
        obj2 = null;
        l_();
        if (getActivity() != null && !getActivity().isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (s != null)
        {
            s.setVisibility(0);
        }
        p = getActivity().getIntent().getStringExtra("friendType");
        myobfuscated.cr.a a1;
        if (d != null)
        {
            d.clear();
        } else
        {
            d = new az(getActivity(), this);
        }
        if (!"topUsers".equals(p))
        {
            break; /* Loop/switch isn't completed */
        }
        a1 = myobfuscated.cr.a.a(n, d);
        b(d, a1);
        if (getView() != null)
        {
            a(false, true, true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        o = RequestControllerFactory.createSearchUsersController();
        b(d, myobfuscated.cr.a.a(o, d));
        if (getActivity() == null || getActivity().isFinishing()) goto _L1; else goto _L4
_L4:
        Object obj = getActivity().getIntent();
        if ("fbUsers".equals(p))
        {
            if (!com.socialin.android.util.s.a(getActivity()))
            {
                a(myobfuscated.f.m.a(this));
                return;
            } else
            {
                obj = new ArrayList();
                obj2 = com.facebook.CallbackManager.Factory.create();
                FacebookUtils.getFacebookFriends(getActivity(), ((com.facebook.CallbackManager) (obj2)), ((List) (obj)), new _cls1(((List) (obj))));
                return;
            }
        }
        if ("twitterFriends".equals(p))
        {
            if (((Intent) (obj)).hasExtra("twitterUserIds"))
            {
                obj = ((Intent) (obj)).getStringExtra("twitterUserIds");
            } else
            {
                obj = null;
            }
            q = ((GetUsersParams)o.getRequestParams()).clearParams();
            q.twitterIds = ((String) (obj));
            if (obj == null)
            {
                obj = new TwitterSessionManager(getActivity(), this);
                if (((TwitterSessionManager) (obj)).checkTwitterSession())
                {
                    (new _cls7(((TwitterSessionManager) (obj)), null)).start();
                    return;
                } else
                {
                    ((TwitterSessionManager) (obj)).startTwitterNewSession(11, true);
                    return;
                }
            } else
            {
                l();
                return;
            }
        }
        if (!"nearbyFriends".equals(p))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (getActivity() == null || getActivity().isFinishing()) goto _L1; else goto _L5
_L5:
        Object obj1;
        if (SocialinV3.getInstance().getUser().address == null)
        {
            obj1 = null;
        } else
        {
            obj1 = SocialinV3.getInstance().getUser().address.getLatitudeString();
        }
        if (SocialinV3.getInstance().getUser().address != null)
        {
            obj2 = SocialinV3.getInstance().getUser().address.getLongitudeString();
        }
        if (TextUtils.isEmpty(((CharSequence) (obj2))) || TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj1 = com.picsart.studio.utils.c.a(getActivity().getApplicationContext(), this);
            if (obj1 != null)
            {
                a(((Location) (obj1)));
                return;
            } else
            {
                a(myobfuscated.f.m.a(getActivity(), 0x7f080448));
                return;
            }
        } else
        {
            q = ((GetUsersParams)o.getRequestParams()).clearParams();
            q.near = (new StringBuilder()).append(((String) (obj1))).append(",").append(((String) (obj2))).toString();
            l();
            return;
        }
        if (!"instagram".equals(p)) goto _L1; else goto _L6
_L6:
        (new Thread(new _cls4())).start();
        return;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 12 && j == 326)
        {
            intent = intent.getExtras().getString("oauth2ResultJson");
            try
            {
                intent = new com.socialin.android.instagram.a(new JSONObject(intent));
                h.a(getActivity().getApplicationContext(), intent);
                k();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                com.socialin.android.d.b(c, "onActivityResult", intent);
            }
        }
        if (i == 11 && j == -1)
        {
            k();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i = getResources().getInteger(0x7f0e0016);
        int j = getResources().getInteger(0x7f0e0017);
        a((new myobfuscated.cr.h(getResources())).a(i, j).a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.GRID
        }).b());
        k();
    }

    public void onLocationChanged(Location location)
    {
        if (getActivity() != null)
        {
            com.socialin.android.d.a(c, "onLocationChanged");
            if (com.picsart.studio.utils.c.a(location, r))
            {
                r = location;
                a(r);
            }
        }
    }

    public void onProviderDisabled(String s1)
    {
        com.socialin.android.d.a(c, (new StringBuilder("onProviderDisabled  ")).append(s1).toString());
    }

    public void onProviderEnabled(String s1)
    {
        com.socialin.android.d.a(c, (new StringBuilder(" onProviderEnabled   ")).append(s1).toString());
    }

    public void onResume()
    {
        super.onResume();
        if ("topUsers".equals(p))
        {
            a(false, true, true);
        }
    }

    public void onStatusChanged(String s1, int i, Bundle bundle)
    {
        com.socialin.android.d.a(c, (new StringBuilder("onStatusChanged  provider= ")).append(s1).append(" status= ").append(i).toString());
    }


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls4 {}

}
