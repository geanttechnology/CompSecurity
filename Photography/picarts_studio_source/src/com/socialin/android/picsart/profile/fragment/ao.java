// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.facebook.CallbackManager;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.picsart.studio.utils.c;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddConnectionController;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.GetOwnerConnectionsController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.controllers.SigninController;
import com.socialin.android.apiv3.controllers.SignupController;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.FbConnection;
import com.socialin.android.apiv3.model.GooglePlusConnection;
import com.socialin.android.apiv3.model.TwitterConnection;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.UserConnection;
import com.socialin.android.apiv3.request.ParamWithUserData;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.request.SigninParams;
import com.socialin.android.apiv3.request.SignupParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.b;
import com.socialin.android.d;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.googleplus.GooglePlusSignInActivity;
import com.socialin.android.picsart.profile.activity.RegistrationActivity;
import com.socialin.android.picsart.profile.activity.WelcomeActivity;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.twitter.TwitterOAuthActivity;
import com.socialin.android.twitter.TwitterSessionManager;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            aq, ap

public class ao extends Fragment
    implements LocationListener, b
{

    private static String c = (new StringBuilder()).append(com/socialin/android/picsart/profile/fragment/ao.getSimpleName()).append(" - ").toString();
    private AddConnectionController d;
    private SigninController e;
    private SigninParams f;
    private Bundle g;
    private UserConnection h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private String n;
    private SignupController o;
    private SignupParams p;
    private View q;
    private Pattern r;
    private Adress s;
    private Location t;
    private String u;
    private BaseSocialinApiRequestController v;
    private ParamWithUserData w;
    private String x;
    private CallbackManager y;
    private com.socialin.asyncnet.d z;

    public ao()
    {
        d = new AddConnectionController();
        e = new SigninController();
        f = new SigninParams();
        i = false;
        j = false;
        k = false;
        l = false;
        m = false;
        o = new SignupController();
        p = new SignupParams();
        s = new Adress();
        t = null;
        v = RequestControllerFactory.createCheckUsernameController();
        w = new ParamWithUserData();
        x = "";
        z = new _cls3();
        setRetainInstance(true);
    }

    static Bundle a(ao ao1, Bundle bundle)
    {
        ao1.g = bundle;
        return bundle;
    }

    static UserConnection a(ao ao1, UserConnection userconnection)
    {
        ao1.h = userconnection;
        return userconnection;
    }

    static String a(ao ao1, String s1)
    {
        ao1.u = s1;
        return s1;
    }

    static void a(ao ao1)
    {
        Activity activity = ao1.getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        if (!com.socialin.android.util.s.a(activity))
        {
            com.socialin.android.picsart.profile.util.y.a(activity);
            return;
        } else
        {
            ao1.y = com.facebook.CallbackManager.Factory.create();
            FacebookUtils.connectFacebook(ao1.getActivity(), ao1.y, new _cls10(ao1));
            return;
        }
    }

    static void a(ao ao1, ArrayList arraylist)
    {
        Activity activity = ao1.getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        UserConnection userconnection;
        ArrayList arraylist1;
        if (arraylist != null)
        {
            Iterator iterator = arraylist.iterator();
            FbConnection fbconnection = null;
            arraylist = null;
            do
            {
                arraylist1 = arraylist;
                userconnection = fbconnection;
                if (!iterator.hasNext())
                {
                    break;
                }
                userconnection = (UserConnection)iterator.next();
                if (userconnection.provider.equals("facebook"))
                {
                    fbconnection = new FbConnection(userconnection.data);
                }
                if (userconnection.provider.equals("twitter"))
                {
                    arraylist = new TwitterConnection(userconnection.data);
                }
            } while (true);
        } else
        {
            userconnection = null;
            arraylist1 = null;
        }
        if (arraylist1 == null && SocialinV3.getInstance().getUser().connections != null)
        {
            SocialinV3.getInstance().getUser().connections.getTwitterConnection();
        }
        if (ao1.f.provider.equals("facebook") || ao1.f.provider.equals("android"))
        {
            boolean flag;
            if (userconnection != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ao1.j = flag;
        }
        SocialinV3.getInstance().writeUser();
        com.socialin.android.picsart.profile.util.y.f(ao1.getActivity());
        if (!ao1.i && (ao1.j || !ao1.f.provider.equals("facebook"))) goto _L2; else goto _L1
_L1:
        ao1.i = false;
_L4:
        ao1.f();
        return;
_L2:
        if (ao1.k && !ao1.l && !ao1.m)
        {
            ao1.e();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void b(ao ao1)
    {
        Object obj;
label0:
        {
            obj = ao1.getActivity();
            if (obj != null && !((Activity) (obj)).isFinishing())
            {
                if (com.socialin.android.util.s.a(ao1.getActivity()))
                {
                    break label0;
                }
                com.socialin.android.picsart.profile.util.y.a(ao1.getActivity());
            }
            return;
        }
        (new TwitterSessionManager(((android.content.Context) (obj)))).clearTwitterSession();
        obj = new Intent(((android.content.Context) (obj)), com/socialin/android/twitter/TwitterOAuthActivity);
        ((Intent) (obj)).putExtra("twitterMethod", "auth");
        ((Intent) (obj)).putExtra("is_return_user_info", true);
        ao1.startActivityForResult(((Intent) (obj)), 125);
    }

    static void b(ao ao1, String s1)
    {
        ao1.v.setRequestCompleteListener(new _cls2(ao1));
        ao1.w.username = s1;
        ao1.v.cancelRequest("getUsernameSuggestionsTAG");
        ao1.v.doRequest("getUsernameSuggestionsTAG", ao1.w);
    }

    static String c()
    {
        return c;
    }

    static void c(ao ao1)
    {
label0:
        {
            if (ao1.q.isClickable())
            {
                if (com.socialin.android.util.s.a(ao1.getActivity()))
                {
                    break label0;
                }
                com.socialin.android.picsart.profile.util.y.a(ao1.getActivity());
            }
            return;
        }
        ao1.startActivityForResult(new Intent(ao1.getActivity(), com/socialin/android/googleplus/GooglePlusSignInActivity), 158);
    }

    static SigninParams d(ao ao1)
    {
        return ao1.f;
    }

    static void d()
    {
    }

    static SigninController e(ao ao1)
    {
        return ao1.e;
    }

    private void e()
    {
        Intent intent = new Intent(getActivity(), com/socialin/android/picsart/profile/activity/WelcomeActivity);
        intent.putExtra("signup_provider", p.provider);
        startActivityForResult(intent, 162);
    }

    private void f()
    {
        if (getActivity() == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        if (getActivity().isFinishing())
        {
            return;
        }
        try
        {
            com.socialin.android.picsart.profile.util.y.f(getActivity());
            if (getTargetFragment() != null)
            {
                getTargetFragment().onActivityResult(getTargetRequestCode(), -1, getActivity().getIntent());
            }
            getActivity().getIntent().putExtra("reloadPager", true);
            if (getActivity() instanceof FragmentActionsListener)
            {
                ((FragmentActionsListener)getActivity()).onFragmentFinishWithResultOK(150);
                return;
            }
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(c, "exit", exception);
            if (d.b)
            {
                com.socialin.android.d.b(c, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                return;
            }
            ExceptionReportService.report(getActivity(), exception, SocialinV3.getInstance().getUser().id);
        }
    }

    static void f(ao ao1)
    {
        Object obj = ao1.getActivity();
        View view = ao1.getView();
        if (obj == null || ((Activity) (obj)).isFinishing() || view == null)
        {
            return;
        }
        obj = new Intent(((android.content.Context) (obj)), com/socialin/android/picsart/profile/activity/RegistrationActivity);
        if (ao1.m)
        {
            ((Intent) (obj)).putExtra("invite_mode", com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER_AUTO.name());
        }
        ao1.startActivityForResult(((Intent) (obj)), 124);
    }

    static Bundle g(ao ao1)
    {
        return ao1.g;
    }

    static boolean h(ao ao1)
    {
        ao1.k = false;
        return false;
    }

    static UserConnection i(ao ao1)
    {
        return ao1.h;
    }

    static boolean j(ao ao1)
    {
        return ao1.j;
    }

    static boolean k(ao ao1)
    {
        ao1.i = true;
        return true;
    }

    static boolean l(ao ao1)
    {
        return ao1.k;
    }

    static boolean m(ao ao1)
    {
        return ao1.l;
    }

    static boolean n(ao ao1)
    {
        return ao1.m;
    }

    static void o(ao ao1)
    {
        ao1.e();
    }

    static void p(ao ao1)
    {
        ao1.f();
    }

    static AddConnectionController q(ao ao1)
    {
        return ao1.d;
    }

    static String r(ao ao1)
    {
        return ao1.n;
    }

    static View s(ao ao1)
    {
        return ao1.q;
    }

    static void t(ao ao1)
    {
        Object obj = ao1.g;
        if (obj != null) goto _L2; else goto _L1
_L1:
        ao1.p.provider = "android";
_L11:
        com.socialin.android.picsart.profile.util.y.g(ao1.getActivity());
        ao1.k = true;
        ao1.o.doRequest(c, ao1.p);
        return;
_L2:
        Object obj1;
        byte byte0;
        obj1 = ((Bundle) (obj)).getString("provider");
        ao1.p.adress = ao1.s;
        byte0 = -1;
        ((String) (obj1)).hashCode();
        JVM INSTR lookupswitch 3: default 108
    //                   -1240244679: 179
    //                   -916346253: 164
    //                   497130182: 149;
           goto _L3 _L4 _L5 _L6
_L3:
        byte0;
        JVM INSTR tableswitch 0 2: default 136
    //                   0 195
    //                   1 458
    //                   2 847;
           goto _L7 _L8 _L9 _L10
_L7:
        ao1.p.provider = "android";
          goto _L11
_L6:
        if (((String) (obj1)).equals("facebook"))
        {
            byte0 = 0;
        }
          goto _L3
_L5:
        if (((String) (obj1)).equals("twitter"))
        {
            byte0 = 1;
        }
          goto _L3
_L4:
        if (((String) (obj1)).equals("google"))
        {
            byte0 = 2;
        }
          goto _L3
_L8:
        obj1 = FacebookUtils.getFbConnectionData();
        ao1.p.fbEmail = ((FbConnection) (obj1)).getFbEmail();
        ao1.p.fbId = ((FbConnection) (obj1)).getId();
        ao1.p.fbUrl = ((FbConnection) (obj1)).getFbUrl();
        ao1.p.fbToken = ((FbConnection) (obj1)).getFbToken();
        ao1.p.fbName = ((FbConnection) (obj1)).getFbName();
        ao1.p.provider = "facebook";
        ao1.p.photoUrl = ((Bundle) (obj)).getString("userProfileImgUrl");
        try
        {
            ao1.p.fbData = ((FbConnection) (obj1)).data.toJson();
            ao1.h = ((UserConnection) (obj1));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(c, "prefillFields", ((Throwable) (obj)));
            if (d.b)
            {
                com.socialin.android.d.b(c, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
                });
            } else
            {
                ExceptionReportService.report(ao1.getActivity(), ((Throwable) (obj)), SocialinV3.getInstance().getUser().id);
            }
        }
        ao1.p.name = ao1.p.fbName;
        ao1.p.email = ao1.p.fbEmail;
        if (TextUtils.isEmpty(ao1.p.username) && !TextUtils.isEmpty(ao1.p.name))
        {
            obj = ao1.p.name.trim().toLowerCase().replace(" ", "");
            ao1.p.username = ((String) (obj));
        }
          goto _L11
_L9:
        ao1.p.twUserId = ((Bundle) (obj)).getString("tw_user_id");
        ao1.p.twUserName = ((Bundle) (obj)).getString("tw_user_name");
        ao1.p.twUserScreenName = ((Bundle) (obj)).getString("tw_user_screen_name");
        ao1.p.twUserToken = ((Bundle) (obj)).getString("tw_user_token");
        ao1.p.twUserTokenSecret = ((Bundle) (obj)).getString("tw_user_token_secret");
        ao1.p.provider = "twitter";
        ao1.p.photoUrl = ((Bundle) (obj)).getString("userProfileImgUrl");
        try
        {
            obj1 = new TwitterConnection();
            obj1.token = ao1.p.twUserToken;
            obj1.connectionId = ao1.p.twUserId;
            ((TwitterConnection) (obj1)).data.id = ao1.p.twUserId;
            ((TwitterConnection) (obj1)).data.name = ao1.p.twUserName;
            ((TwitterConnection) (obj1)).data.screenName = ao1.p.twUserScreenName;
            ((TwitterConnection) (obj1)).data.token = ao1.p.twUserToken;
            ((TwitterConnection) (obj1)).data.tokenSecret = ao1.p.twUserTokenSecret;
            ((TwitterConnection) (obj1)).data.profileUrl = ((Bundle) (obj)).getString("tw_user_profile_url");
            ao1.p.twitterData = ((TwitterConnection) (obj1)).data.toJson();
            ao1.h = ((UserConnection) (obj1));
        }
        catch (Exception exception1)
        {
            com.socialin.android.d.b(c, "prefillFields", exception1);
            if (d.b)
            {
                com.socialin.android.d.b(c, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception1.getMessage()).toString()
                });
            } else
            {
                ExceptionReportService.report(ao1.getActivity(), exception1, SocialinV3.getInstance().getUser().id);
            }
        }
        ao1.p.photoUrl = ((Bundle) (obj)).getString("tw_user_profile_url");
        ao1.p.username = ao1.p.twUserScreenName;
        ao1.p.name = ao1.p.twUserName;
        if (TextUtils.isEmpty(ao1.p.username))
        {
            obj = ao1.p.name.trim().toLowerCase().replace(" ", "");
            ao1.p.username = ((String) (obj));
        }
          goto _L11
_L10:
        ao1.p.gpEmail = ((Bundle) (obj)).getString("userEmail");
        ao1.p.gpUserId = ((Bundle) (obj)).getString("userId");
        ao1.p.gpUrl = ((Bundle) (obj)).getString("userProfileUrl");
        ao1.p.gpImgUrl = ((Bundle) (obj)).getString("userProfileImgUrl");
        ao1.p.gpUserToken = ((Bundle) (obj)).getString("accessToken");
        ao1.p.gpUserName = ((Bundle) (obj)).getString("userName");
        exception1 = ao1.p;
        com.socialin.android.apiv3.model.UserConnection.Data data;
        if (!TextUtils.isEmpty(ao1.u))
        {
            obj = ao1.u;
        } else
        {
            obj = ((Bundle) (obj)).getString("userScreenName");
        }
        exception1.gpUserScreenName = ((String) (obj));
        ao1.p.provider = "google";
        exception1 = new GooglePlusConnection();
        exception1.token = ao1.p.gpUserToken;
        ((GooglePlusConnection) (exception1)).data.id = ao1.p.gpUserId;
        ((GooglePlusConnection) (exception1)).data.name = ao1.p.gpUserName;
        data = ((GooglePlusConnection) (exception1)).data;
        if (TextUtils.isEmpty(ao1.u)) goto _L13; else goto _L12
_L12:
        obj = ao1.u;
_L16:
        data.screenName = ((String) (obj));
        ((GooglePlusConnection) (exception1)).data.profileUrl = ao1.p.gpUrl;
        ((GooglePlusConnection) (exception1)).data.profileImgUrl = ao1.p.gpImgUrl;
        ((GooglePlusConnection) (exception1)).data.email = ao1.p.gpEmail;
        ((GooglePlusConnection) (exception1)).data.token = ao1.p.gpUserToken;
_L17:
        if (TextUtils.isEmpty(ao1.u)) goto _L15; else goto _L14
_L14:
        ao1.p.username = ao1.u;
_L21:
        Exception exception;
        try
        {
            ao1.p.googlePlusData = ((GooglePlusConnection) (exception1)).data.toJson();
        }
        catch (JSONException jsonexception)
        {
            com.socialin.android.d.b(c, "prefillFields", jsonexception);
            if (d.b)
            {
                com.socialin.android.d.b(c, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(jsonexception.getMessage()).toString()
                });
            } else
            {
                ExceptionReportService.report(ao1.getActivity(), jsonexception, SocialinV3.getInstance().getUser().id);
            }
        }
        ao1.h = exception1;
        ao1.p.photoUrl = ao1.p.gpImgUrl;
        ao1.p.name = ao1.p.gpUserName;
        ao1.p.email = ao1.p.gpEmail;
          goto _L11
_L13:
        obj = ao1.p.gpUserScreenName;
          goto _L16
        exception;
        com.socialin.android.d.b(c, "prefillFields", exception);
        if (d.b)
        {
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
        } else
        {
            ExceptionReportService.report(ao1.getActivity(), exception, SocialinV3.getInstance().getUser().id);
        }
          goto _L17
_L15:
        if (TextUtils.isEmpty(ao1.p.gpUserScreenName)) goto _L19; else goto _L18
_L18:
        exception = ao1.p.gpUserScreenName;
        if (!ao1.r.matcher(exception).matches()) goto _L19; else goto _L20
_L20:
        ao1.p.username = ao1.p.gpUserScreenName;
          goto _L21
_L19:
        if (ao1.p.gpUserName != null)
        {
            ao1.p.username = ao1.p.gpUserName.trim().toLowerCase();
            ao1.p.username = ao1.p.username.replace(" ", "");
            ((GooglePlusConnection) (exception1)).data.screenName = ao1.p.username;
        }
          goto _L21
    }

    static SignupParams u(ao ao1)
    {
        return ao1.p;
    }

    static String v(ao ao1)
    {
        return ao1.u;
    }

    public final void a()
    {
        if (m && getActivity() != null && !getActivity().isFinishing())
        {
            ImageView imageview = (ImageView)getView().findViewById(0x7f1009c5);
            View view = getView().findViewById(0x7f1009b7);
            view.post(new _cls9(imageview, view));
        }
    }

    public final void b()
    {
        (new StringBuilder("Login:getUserConnections  isReg = ")).append(SocialinV3.getInstance().isRegistered());
        if (!SocialinV3.getInstance().isRegistered())
        {
            f();
            return;
        } else
        {
            GetOwnerConnectionsController getownerconnectionscontroller = new GetOwnerConnectionsController();
            getownerconnectionscontroller.setRequestCompleteListener(new _cls11());
            getownerconnectionscontroller.doRequest(null, new RequestParams());
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        Activity activity;
        activity = getActivity();
        x = getString(0x7f0808c8);
        if (activity == null) goto _L2; else goto _L1
_L1:
        if (activity.isFinishing())
        {
            return;
        }
        if (getArguments() == null) goto _L4; else goto _L3
_L3:
        bundle = getArguments().getString("invite_mode");
_L18:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        l = com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER.name().equals(bundle);
        m = com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER_AUTO.name().equals(bundle);
        Object obj;
        bundle = (FrameLayout)getView().findViewById(0x7f1009b8);
        obj = LayoutInflater.from(bundle.getContext());
        int i1;
        if (m)
        {
            i1 = 0x7f03021a;
        } else
        {
            i1 = 0x7f030219;
        }
        bundle.addView(((LayoutInflater) (obj)).inflate(i1, bundle, false));
        AnalyticUtils.getInstance(activity).track(new com.socialin.android.apiv3.events.EventsFactory.RegistrationStepEvent("reg_signin_open", false, false, false, false, false));
        com.socialin.android.util.b.a(activity).a("reg_signin_open", false, false, false, false, false);
        if (!m && Utils.d(activity) < 360F)
        {
            i1 = (int)Utils.a(80F, activity);
            int j1 = (int)Utils.a(4F, activity);
            bundle = new android.widget.LinearLayout.LayoutParams(i1, i1);
            if (getView() != null)
            {
                getView().findViewById(0x7f1009c2).setPadding(j1, j1, j1, j1);
                getView().findViewById(0x7f1009c2).setLayoutParams(bundle);
                getView().findViewById(0x7f1009c3).setPadding(j1, j1, j1, j1);
                getView().findViewById(0x7f1009c3).setLayoutParams(bundle);
                getView().findViewById(0x7f1009c4).setPadding(j1, j1, j1, j1);
                getView().findViewById(0x7f1009c4).setLayoutParams(bundle);
            }
        }
        bundle = getActivity();
        obj = getView();
        if (bundle == null) goto _L6; else goto _L5
_L5:
        if (!bundle.isFinishing() && obj != null) goto _L7; else goto _L6
_L6:
        e.setRequestCompleteListener(new aq(this));
        d.setRequestCompleteListener(new ap(this));
        o.setRequestCompleteListener(z);
        r = Pattern.compile("^[a-z0-9-]{3,20}$");
        activity.getWindow().setSoftInputMode(3);
        com.picsart.studio.utils.c.a(getActivity().getApplicationContext(), this);
        if (activity instanceof FragmentActionsListener)
        {
            ((FragmentActionsListener)activity).onFragmentLoaded();
        }
_L15:
        if (!activity.getIntent().hasExtra("action")) goto _L9; else goto _L8
_L8:
        n = activity.getIntent().getStringExtra("action");
_L16:
        com.picsart.studio.d d1;
        com.socialin.android.apiv3.model.AppProps.AutoRedeemProps autoredeemprops;
        if (x.equals(getString(0x7f0808cc)))
        {
            bundle = getView();
            if (bundle != null)
            {
                TextView textview = (TextView)bundle.findViewById(0x7f1009c0);
                if (textview != null)
                {
                    textview.setText((new StringBuilder()).append(textview.getText()).append(" PicsArt").toString());
                    textview.setVisibility(8);
                }
                bundle.findViewById(0x7f1009c1).setVisibility(8);
                bundle.findViewById(0x7f1009b9).setVisibility(8);
                if (bundle.findViewById(0x7f1009bf) != null)
                {
                    bundle.findViewById(0x7f1009bf).setVisibility(8);
                    return;
                }
            }
        } else
        if (!getString(0x7f0808c8).equals(getString(0x7f0808ce)))
        {
            getView().findViewById(0x7f1009c2).setVisibility(8);
        }
          goto _L2
_L4:
        bundle = null;
        continue; /* Loop/switch isn't completed */
_L7:
        ((View) (obj)).findViewById(0x7f1009c3).setOnClickListener(new _cls1(bundle));
        ((View) (obj)).findViewById(0x7f1009c4).setOnClickListener(new _cls4(bundle));
        q = ((View) (obj)).findViewById(0x7f1009c2);
        i1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if (i1 == 0 || i1 == 2)
        {
            break MISSING_BLOCK_LABEL_679;
        }
        q.setVisibility(8);
        q.setClickable(true);
        q.setOnClickListener(new _cls5(bundle));
        ((View) (obj)).findViewById(0x7f1009bc).setOnClickListener(new _cls6(bundle));
        _cls7 _lcls7 = new _cls7(((View) (obj)), bundle);
        ((View) (obj)).findViewById(0x7f1008d7).setOnClickListener(_lcls7);
        ((View) (obj)).findViewById(0x7f1009bd).setOnClickListener(new _cls8(((View) (obj)), bundle));
        if (!m) goto _L6; else goto _L10
_L10:
        bundle = (ImageView)getView().findViewById(0x7f1009c5);
        obj = (TextView)getView().findViewById(0x7f1009c6);
        d1 = new com.picsart.studio.d(getActivity().getApplicationContext());
        a();
        autoredeemprops = SocialinV3.getInstance().getAppProps().getAutoRedeemProps();
        if (autoredeemprops == null) goto _L6; else goto _L11
_L11:
        if (TextUtils.isEmpty(autoredeemprops.loginPhoto) || bundle == null) goto _L13; else goto _L12
_L12:
        d1.c(autoredeemprops.loginPhoto, bundle, com.bumptech.glide.request.e.b(l.a));
_L13:
        if (TextUtils.isEmpty(autoredeemprops.loginText) || obj == null) goto _L6; else goto _L14
_L14:
        ((TextView) (obj)).setText(autoredeemprops.loginText);
          goto _L6
        bundle;
label0:
        {
            com.socialin.android.d.b(c, "onActivityCreated", bundle);
            if (!d.b)
            {
                break label0;
            }
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
            });
        }
          goto _L15
        ExceptionReportService.report(getActivity(), bundle, SocialinV3.getInstance().getUser().id);
          goto _L15
_L9:
        try
        {
            n = "";
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.socialin.android.d.b(c, "onActivityCreated", bundle);
            if (d.b)
            {
                com.socialin.android.d.b(c, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
                });
            } else
            {
                ExceptionReportService.report(getActivity(), bundle, SocialinV3.getInstance().getUser().id);
            }
        }
          goto _L16
_L2:
        return;
        if (true) goto _L18; else goto _L17
_L17:
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        Object obj;
        View view;
        super.onActivityResult(i1, j1, intent);
        obj = getActivity();
        view = getView();
        if (obj != null && !((Activity) (obj)).isFinishing() && view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (j1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i1 == 158)
        {
            Utils.a(((Activity) (obj)), 0x7f080425);
            q.setClickable(true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (j1 != -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i1 == 161)
        {
            f();
            return;
        }
        if (i1 != 158) goto _L5; else goto _L4
_L4:
        GooglePlusConnection googleplusconnection;
        JSONObject jsonobject1;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        u = null;
        f.provider = "google";
        googleplusconnection = new GooglePlusConnection();
        jsonobject1 = new JSONObject();
        s3 = intent.getStringExtra("googleplus_id");
        s4 = intent.getStringExtra("googleplus_name");
        s5 = intent.getStringExtra("googleplus_profile_url");
        s6 = intent.getStringExtra("googleplus_profile_image_url");
        s7 = intent.getStringExtra("googleplus_token");
        if (!intent.hasExtra("googleplus_nikName"))
        {
            break MISSING_BLOCK_LABEL_1148;
        }
        obj = intent.getStringExtra("googleplus_nikName");
_L8:
        String s1 = "";
        try
        {
            if (intent.hasExtra("googleplus_email"))
            {
                s1 = intent.getStringExtra("googleplus_email");
            }
            jsonobject1.put("id", s3);
            jsonobject1.put("name", s4);
            jsonobject1.put("screen_name", obj);
            jsonobject1.put("profile_url", s5);
            jsonobject1.put("profile_img_url", s6);
            jsonobject1.put("token", s7);
            jsonobject1.put("email", s1);
            googleplusconnection.data.id = s3;
            googleplusconnection.data.name = s4;
            googleplusconnection.data.screenName = ((String) (obj));
            googleplusconnection.data.token = s7;
            googleplusconnection.data.profileImgUrl = s6;
            googleplusconnection.data.profileUrl = s5;
            googleplusconnection.data.email = s1;
            googleplusconnection.token = googleplusconnection.data.token;
            googleplusconnection.connectionId = googleplusconnection.data.id;
            h = googleplusconnection;
            f.passwordOrFbJson = jsonobject1.toString();
            f.usernameOrToken = googleplusconnection.data.token;
            k = false;
            e.doRequest(c, f);
            com.socialin.android.picsart.profile.util.y.g(getActivity());
            g = new Bundle();
            g.putString("userId", s3);
            g.putString("userName", s4);
            g.putString("userScreenName", ((String) (obj)));
            g.putString("userProfileUrl", s5);
            g.putString("userProfileImgUrl", s6);
            g.putString("userEmail", s1);
            g.putString("accessToken", s7);
            g.putString("provider", "google");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.socialin.android.d.b(c, "signInWithGoogle", intent);
        }
        if (d.b)
        {
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(intent.getMessage()).toString()
            });
            return;
        } else
        {
            ExceptionReportService.report(getActivity(), intent, SocialinV3.getInstance().getUser().id);
            return;
        }
_L5:
        if (i1 == 125)
        {
            if (intent == null)
            {
                Utils.a(getActivity(), 0x7f080252);
                return;
            }
            obj = intent.getStringExtra("tw_user_token");
            String s2 = intent.getStringExtra("tw_user_token_secret");
            if (obj != null && s2 != null)
            {
                u = null;
                f.provider = "twitter";
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("id", intent.getStringExtra("tw_user_id"));
                    jsonobject.put("name", intent.getStringExtra("tw_user_name"));
                    jsonobject.put("screen_name", intent.getStringExtra("tw_user_screen_name"));
                    jsonobject.put("profile_url", intent.getStringExtra("tw_user_profile_url"));
                    jsonobject.put("token", intent.getStringExtra("tw_user_token"));
                    jsonobject.put("token_secret", intent.getStringExtra("tw_user_token_secret"));
                    TwitterConnection twitterconnection = new TwitterConnection();
                    h = null;
                    twitterconnection.data.id = intent.getStringExtra("tw_user_id");
                    twitterconnection.data.name = intent.getStringExtra("tw_user_name");
                    twitterconnection.data.screenName = intent.getStringExtra("tw_user_screen_name");
                    twitterconnection.data.token = intent.getStringExtra("tw_user_token");
                    twitterconnection.data.tokenSecret = intent.getStringExtra("tw_user_token_secret");
                    twitterconnection.data.profileUrl = intent.getStringExtra("tw_user_profile_url");
                    twitterconnection.token = twitterconnection.data.token;
                    twitterconnection.connectionId = twitterconnection.data.id;
                    h = twitterconnection;
                }
                catch (JSONException jsonexception)
                {
                    com.socialin.android.d.b(c, "signinViaTwitter", jsonexception);
                    if (d.b)
                    {
                        com.socialin.android.d.b(c, new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(jsonexception.getMessage()).toString()
                        });
                    } else
                    {
                        ExceptionReportService.report(getActivity(), jsonexception, SocialinV3.getInstance().getUser().id);
                    }
                }
                f.passwordOrFbJson = jsonobject.toString();
                f.usernameOrToken = ((String) (obj));
                g = new Bundle();
                g.putAll(intent.getExtras());
                g.putString("provider", "twitter");
                com.socialin.android.picsart.profile.util.y.g(getActivity());
                k = false;
                e.doRequest(c, f);
                return;
            } else
            {
                Utils.a(getActivity(), 0x7f080425);
                return;
            }
        }
        if (i1 != 124) goto _L1; else goto _L6
_L6:
        if (!l && !m)
        {
            e();
        }
        f();
        return;
        if (j1 != 1 || i1 != 158) goto _L1; else goto _L7
_L7:
        q.setClickable(true);
        return;
        obj = "";
          goto _L8
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030218, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        FileUtils.a(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f08096d)).toString()));
    }

    public void onLocationChanged(Location location)
    {
        if (com.picsart.studio.utils.c.a(location, t))
        {
            t = location;
            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing())
            {
                com.picsart.studio.utils.c.a(this);
                Activity activity1 = getActivity();
                if (activity1 != null)
                {
                    s = com.picsart.studio.utils.c.a(location, activity1);
                    return;
                }
            }
        }
    }

    public void onPause()
    {
        Object obj;
        super.onPause();
        obj = getActivity();
        if (obj != null && !((Activity) (obj)).isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((obj = (LocationManager)((Activity) (obj)).getSystemService("location")) == null) goto _L1; else goto _L3
_L3:
        try
        {
            ((LocationManager) (obj)).removeUpdates(this);
            return;
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(c, "onPause", exception);
            if (d.b)
            {
                com.socialin.android.d.b(c, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                return;
            } else
            {
                ExceptionReportService.report(getActivity(), exception, SocialinV3.getInstance().getUser().id);
                return;
            }
        }
    }

    public void onProviderDisabled(String s1)
    {
    }

    public void onProviderEnabled(String s1)
    {
    }

    public void onResume()
    {
        super.onResume();
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        } else
        {
            com.picsart.studio.utils.c.a(getActivity().getApplicationContext(), this);
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onStatusChanged(String s1, int i1, Bundle bundle)
    {
    }

    public void onStop()
    {
        super.onStop();
        com.picsart.studio.utils.c.a(this);
    }


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}

}
