// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.f.r;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.aw;
import java.util.Collections;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.smule.android.facebook:
//            c, e, d, b

public class a
{

    private static a a;
    private static final String b = com/smule/android/facebook/a.getName();
    private Handler c;
    private c d;
    private GraphRequest e;
    private boolean f;

    private a()
    {
        c = new Handler(Looper.getMainLooper());
        e = null;
        f = false;
    }

    static Context a(a a1)
    {
        return a1.k();
    }

    public static a a()
    {
        if (a == null)
        {
            a = new a();
        }
        return a;
    }

    static c a(a a1, c c1)
    {
        a1.d = c1;
        return c1;
    }

    static boolean a(a a1, boolean flag)
    {
        a1.f = flag;
        return flag;
    }

    static String j()
    {
        return b;
    }

    private Context k()
    {
        return com.smule.android.network.core.b.d().e();
    }

    public c a(String s, boolean flag)
    {
        aa.a(b, "getUserInfo - logged in Facebook!");
        Object obj = e();
        if (obj == null)
        {
            return null;
        }
        if (((GraphResponse) (obj)).getError() != null)
        {
            aa.b(b, (new StringBuilder()).append("Failed to get user info from facebook ").append(((GraphResponse) (obj)).getError()).toString());
            return null;
        }
        c c1 = new c();
        JSONObject jsonobject = ((GraphResponse) (obj)).getJSONObject();
        try
        {
            c1.b = jsonobject.getString("id");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aa.b(b, (new StringBuilder()).append("Failed to parse JSON response. JsonObject: ").append(jsonobject).toString(), s);
            return null;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = jsonobject.optString("email", null);
        if (obj != null)
        {
            s = ((String) (obj));
        }
        c1.c = s;
_L3:
        c1.d = jsonobject.getString("gender");
        c1.e = jsonobject.optString("birthday", null);
        c1.f = jsonobject.getString("token_for_business");
        c1.g = jsonobject.getString("name");
        c1.h = jsonobject.getString("first_name");
        c1.i = jsonobject.getString("last_name");
        s = jsonobject.getJSONObject("age_range");
        c1.j = Integer.valueOf(s.optInt("min", -1));
        if (c1.j.intValue() == -1)
        {
            c1.j = null;
        }
        c1.k = Integer.valueOf(s.optInt("max", -1));
        if (c1.k.intValue() == -1)
        {
            c1.k = null;
        }
        c1.a = b();
        aa.d(b, (new StringBuilder()).append("Facebook user data cached for '").append(c1.g).append("'").toString());
        d = c1;
        aa.d(b, (new StringBuilder()).append("Facebook user data cached for '").append(c1.g).append("'").toString());
        d = c1;
        return c1;
_L2:
        if (!TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_407;
        }
        s = jsonobject.optString("email", null);
_L4:
        c1.c = s;
          goto _L3
        s = null;
          goto _L4
    }

    public o a(e e1, String s, boolean flag)
    {
        Object obj;
        Object obj1;
        c c1;
        obj1 = null;
        obj = null;
        c1 = a(s, flag);
        if (c1 != null) goto _L2; else goto _L1
_L1:
        s = obj;
_L4:
        return s;
_L2:
        aa.c(b, (new StringBuilder()).append("getUserInfoAndDoSNPAction - Facebook user info: ").append(c1.b).append(", ").append(c1.c).append(", ").append(c1.d).append(", ").append(c1.e).toString());
        aa.a(b, "getUserInfoAndDoSNPAction - Authenticated!");
        if (e1 == e.a)
        {
            e1 = UserManager.n().a(c1, s, UserManager.o(), flag).a;
        } else
        if (e1 == com.smule.android.facebook.e.b)
        {
            e1 = UserManager.n().a(c1);
        } else
        {
            aa.b(b, (new StringBuilder()).append("getUserInfoAndDoSNPAction - Invalid action for getting FB user info: ").append(e1).toString());
            e1 = obj1;
        }
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = e1;
        if (e1.a()) goto _L4; else goto _L3
_L3:
        aa.b(b, "getUserInfoAndDoSNPAction - Failed to update SNP server with FB user info after successful authentication");
        return e1;
    }

    public o a(e e1, boolean flag)
    {
        return a(e1, ((String) (null)), flag);
    }

    public void a(Activity activity, Bundle bundle, String s)
    {
        bundle = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentDescription(bundle.getString("description")).setContentTitle(bundle.getString("name")).setContentUrl(Uri.parse(bundle.getString("link")))).setImageUrl(Uri.parse(bundle.getString("picture"))).build();
        (new ShareDialog(activity)).show(bundle, com.facebook.share.widget.ShareDialog.Mode.FEED);
    }

    public void a(Activity activity, String s, Bundle bundle, String s1)
    {
        aa.a(b, (new StringBuilder()).append("Making request to publish action ").append(s).toString());
        (new GraphRequest(AccessToken.getCurrentAccessToken(), s, bundle, HttpMethod.POST, new com.facebook.GraphRequest.Callback(s1, activity) {

            final String a;
            final Activity b;
            final a c;

            public void onCompleted(GraphResponse graphresponse)
            {
                if (graphresponse == null)
                {
                    aa.b(a.j(), "Facebook response is null, possible crash incoming");
                }
                FacebookRequestError facebookrequesterror = graphresponse.getError();
                if (facebookrequesterror != null)
                {
                    aa.b(a.j(), (new StringBuilder()).append("Failed to publish action ").append(facebookrequesterror.getErrorMessage()).toString());
                } else
                {
                    graphresponse = graphresponse.getJSONObject();
                    try
                    {
                        graphresponse = graphresponse.getString("id");
                        aa.a(a.j(), (new StringBuilder()).append("publishAction - post id: ").append(graphresponse).toString());
                    }
                    // Misplaced declaration of an exception variable
                    catch (GraphResponse graphresponse)
                    {
                        aa.c(a.j(), (new StringBuilder()).append("JSON error ").append(graphresponse.getMessage()).toString());
                    }
                    if (a != null)
                    {
                        r.a(b, a);
                        return;
                    }
                }
            }

            
            {
                c = a.this;
                a = s;
                b = activity;
                super();
            }
        })).executeAsync();
    }

    public void a(d d1)
    {
        Handler handler = new Handler();
        if (d == null)
        {
            com.smule.android.network.core.b.a(new Runnable(d1, handler) {

                final d a;
                final Handler b;
                final a c;

                public void run()
                {
                    c c1 = c.a(null, true);
                    if (a != null)
                    {
                        b.post(new Runnable(this, c1) {

                            final c a;
                            final _cls3 b;

                            public void run()
                            {
                                b.a.a(a);
                            }

            
            {
                b = _pcls3;
                a = c1;
                super();
            }
                        });
                    }
                }

            
            {
                c = a.this;
                a = d1;
                b = handler;
                super();
            }
            });
        } else
        if (d1 != null)
        {
            d1.a(d);
            return;
        }
    }

    public void a(boolean flag)
    {
        p.a(k().getSharedPreferences("MagicFacebook", 0).edit().putBoolean("HAS_ENABLED_FACEBOOK", flag));
    }

    public void a(boolean flag, com.smule.android.facebook.b b1)
    {
        com.smule.android.network.core.b.a(new Runnable(flag, b1) {

            final boolean a;
            final com.smule.android.facebook.b b;
            final a c;

            public void run()
            {
                SharedPreferences sharedpreferences;
                boolean flag2;
                boolean flag3;
                if (c.c())
                {
                    flag2 = UserManager.n().q().a();
                } else
                {
                    flag2 = false;
                }
                sharedpreferences = a.a(c).getSharedPreferences("MagicFacebook", 0);
                p.a(sharedpreferences.edit().remove("access_token"));
                p.a(sharedpreferences.edit().remove("access_expires"));
                flag3 = flag2;
                if (a)
                {
                    boolean flag1;
                    if (GraphRequest.newDeleteObjectRequest(c.b(), "me/permissions", new com.facebook.GraphRequest.Callback(this) {

            final _cls4 a;

            public void onCompleted(GraphResponse graphresponse)
            {
            }

            
            {
                a = _pcls4;
                super();
            }
        }).executeAndWait().getError() == null)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    flag3 = flag2 & flag1;
                }
                if (flag3)
                {
                    if (c.c())
                    {
                        LoginManager.getInstance().logOut();
                    }
                    c.a(false);
                    a.a(c, null);
                }
                b.a(flag3);
            }

            
            {
                c = a.this;
                a = flag;
                b = b1;
                super();
            }
        });
    }

    public boolean a(Activity activity)
    {
        try
        {
            activity.getPackageManager().getApplicationInfo("com.facebook.katana", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    public boolean a(String s)
    {
        if (AccessToken.getCurrentAccessToken() == null)
        {
            return false;
        } else
        {
            return AccessToken.getCurrentAccessToken().getPermissions().contains(s);
        }
    }

    public AccessToken b()
    {
        return AccessToken.getCurrentAccessToken();
    }

    public aw b(String s, boolean flag)
    {
        c c1 = a(s, flag);
        if (c1 != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        Object obj;
        if (flag)
        {
            obj = UserManager.n().g();
        } else
        {
            obj = UserManager.o();
        }
        obj = UserManager.n().a(c1, s, ((String) (obj)), flag);
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((String) (obj));
        if (((aw) (obj)).a.a()) goto _L4; else goto _L3
_L3:
        aa.b(b, "Failed to login to SNP after Facebook authentication");
        return ((aw) (obj));
    }

    public void b(Activity activity)
    {
        if (!c())
        {
            return;
        } else
        {
            LoginManager.getInstance().logInWithPublishPermissions(activity, Collections.singletonList("publish_actions"));
            return;
        }
    }

    public boolean c()
    {
        return AccessToken.getCurrentAccessToken() != null && !AccessToken.getCurrentAccessToken().isExpired();
    }

    public SharedPreferences d()
    {
        return k().getSharedPreferences("MagicFacebook", 0);
    }

    public GraphResponse e()
    {
        GraphRequest graphrequest = GraphRequest.newMeRequest(b(), new com.facebook.GraphRequest.GraphJSONObjectCallback() {

            final a a;

            public void onCompleted(JSONObject jsonobject, GraphResponse graphresponse)
            {
            }

            
            {
                a = a.this;
                super();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("fields", "first_name,birthday,gender,email,id,last_name,age_range,link,locale,middle_name,name,timezone,updated_time,verified,token_for_business");
        graphrequest.setParameters(bundle);
        return graphrequest.executeAndWait();
    }

    public void f()
    {
        if (f)
        {
            aa.e(b, "on connectFacebookToSmuleAccountSync - already in the process of connecting Facebook to Smule");
            return;
        }
        f = true;
        SharedPreferences sharedpreferences = k().getSharedPreferences("MagicFacebook", 0);
        if (sharedpreferences.getBoolean("DID_CONNECT_FACEBOOK", false))
        {
            aa.a(b, "on connectFacebookToSmuleAccountSync - account has already been connected; ignoring request");
            f = false;
            return;
        } else
        {
            com.smule.android.network.core.b.a(new Runnable(sharedpreferences) {

                final SharedPreferences a;
                final a b;

                public void run()
                {
                    Object obj = b.a(null, false);
                    obj = UserManager.n().a(((c) (obj)));
                    if (obj != null && ((o) (obj)).a())
                    {
                        aa.a(a.j(), "on connectFacebookToSmuleAccountSync - Facebook account successfully connected");
                        p.a(a.edit().putBoolean("DID_CONNECT_FACEBOOK", true));
                    }
                    a.a(b, false);
                }

            
            {
                b = a.this;
                a = sharedpreferences;
                super();
            }
            });
            return;
        }
    }

    public boolean g()
    {
        return k().getSharedPreferences("MagicFacebook", 0).getBoolean("HAS_ENABLED_FACEBOOK", false);
    }

    public boolean h()
    {
        return AccessToken.getCurrentAccessToken() != null && !AccessToken.getCurrentAccessToken().isExpired();
    }

    public boolean i()
    {
        return a("publish_actions");
    }

}
