// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.WeiboAccountInfo;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.StatusesAPI;
import com.sina.weibo.sdk.openapi.UsersAPI;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ai

public class ah
{

    public static final String a;
    public static final String b;
    public SsoHandler c;
    private Context d;
    private Oauth2AccessToken e;
    private WeiboAccountInfo f;

    public ah(Context context)
    {
        d = context;
        AuthInfo authinfo = new AuthInfo(context, a, b, "");
        c = new SsoHandler((Activity)context, authinfo);
    }

    static WeiboAccountInfo a(ah ah1, WeiboAccountInfo weiboaccountinfo)
    {
        ah1.f = weiboaccountinfo;
        return weiboaccountinfo;
    }

    static Oauth2AccessToken a(ah ah1)
    {
        return ah1.e;
    }

    static Oauth2AccessToken a(ah ah1, Oauth2AccessToken oauth2accesstoken)
    {
        ah1.e = oauth2accesstoken;
        return oauth2accesstoken;
    }

    static Object a(ah ah1, Object obj)
    {
        return ah1.a(obj);
    }

    private Object a(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1 = JSONObject.NULL;
_L4:
        return obj1;
_L2:
        obj1 = obj;
        if (obj instanceof JSONArray) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        if (obj instanceof JSONObject) goto _L4; else goto _L5
_L5:
        obj1 = obj;
        if (obj.equals(JSONObject.NULL)) goto _L4; else goto _L6
_L6:
        if (obj instanceof Collection)
        {
            return new JSONArray((Collection)obj);
        }
        if (!obj.getClass().isArray()) goto _L8; else goto _L7
_L7:
        int j;
        obj1 = new JSONArray();
        j = Array.getLength(obj);
        int i = 0;
_L10:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((JSONArray) (obj1)).put(a(Array.get(obj, i)));
        i++;
        if (true) goto _L10; else goto _L9
_L8:
        if (obj instanceof Map)
        {
            return new JSONObject((Map)obj);
        }
        obj1 = obj;
        if (obj instanceof Boolean) goto _L4; else goto _L11
_L11:
        obj1 = obj;
        if (obj instanceof Byte) goto _L4; else goto _L12
_L12:
        obj1 = obj;
        if (obj instanceof Character) goto _L4; else goto _L13
_L13:
        obj1 = obj;
        if (obj instanceof Double) goto _L4; else goto _L14
_L14:
        obj1 = obj;
        if (obj instanceof Float) goto _L4; else goto _L15
_L15:
        obj1 = obj;
        if (obj instanceof Integer) goto _L4; else goto _L16
_L16:
        obj1 = obj;
        if (obj instanceof Long) goto _L4; else goto _L17
_L17:
        obj1 = obj;
        if (obj instanceof Short) goto _L4; else goto _L18
_L18:
        obj1 = obj;
        if (obj instanceof String) goto _L4; else goto _L19
_L19:
        if (!obj.getClass().getPackage().getName().startsWith("java."))
        {
            break MISSING_BLOCK_LABEL_238;
        }
        obj = obj.toString();
        return obj;
        obj;
        return null;
_L9:
        return obj1;
    }

    private void a(Bundle bundle)
    {
        (new j(bundle) {

            final Bundle a;
            final ah b;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                Iterator iterator;
                void1 = new JSONObject();
                iterator = a.keySet().iterator();
_L6:
                if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
                String s = (String)iterator.next();
                if (android.os.Build.VERSION.SDK_INT >= 19) goto _L4; else goto _L3
_L3:
                void1.put(s, ah.a(b, a.get(s)));
                  goto _L5
_L4:
                try
                {
                    void1.put(s, JSONObject.wrap(a.get(s)));
                }
                catch (Exception exception) { }
_L5:
                if (true) goto _L6; else goto _L2
_L2:
                void1 = void1.toString();
                Globals.D().edit().putString("KEY_WEIBO_TOKEN", void1).commit();
                return null;
            }

            
            {
                b = ah.this;
                a = bundle;
                super();
            }
        }).d(null);
    }

    static void a(ah ah1, Bundle bundle)
    {
        ah1.a(bundle);
    }

    static void a(ah ah1, Oauth2AccessToken oauth2accesstoken, String s, Uri uri, ai ai1)
    {
        ah1.a(oauth2accesstoken, s, uri, ai1);
    }

    private void a(Oauth2AccessToken oauth2accesstoken, String s, Uri uri, ai ai1)
    {
        (new j(oauth2accesstoken, uri, s, ai1) {

            final Oauth2AccessToken a;
            final Uri b;
            final String c;
            final ai d;
            final ah e;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                StatusesAPI statusesapi = new StatusesAPI(ah.b(e), ah.a, a);
                android.graphics.Bitmap bitmap = ImageUtils.a(Globals.n(), b);
                try
                {
                    void1 = URLEncoder.encode(c, "UTF-8");
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    Globals.b("Encode content failed.");
                    void1 = null;
                }
                if (void1 != null)
                {
                    statusesapi.upload(void1, bitmap, "", "", new RequestListener(this) {

                        final _cls5 a;

                        public void onComplete(String s)
                        {
                            com.perfectcorp.utility.e.b(new Object[] {
                                s
                            });
                            if (a.d != null)
                            {
                                a.d.a();
                            }
                        }

                        public void onWeiboException(WeiboException weiboexception)
                        {
                            String s;
                            if (weiboexception != null && weiboexception.toString() != null)
                            {
                                s = weiboexception.toString();
                            } else
                            {
                                s = "Unknow error";
                            }
                            com.perfectcorp.utility.e.b(new Object[] {
                                s
                            });
                            if (a.d != null)
                            {
                                a.d.a(weiboexception);
                            }
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                } else
                if (d != null)
                {
                    d.a(new WeiboException("Encode url failed"));
                    return null;
                }
                return null;
            }

            
            {
                e = ah.this;
                a = oauth2accesstoken;
                b = uri;
                c = s;
                d = ai1;
                super();
            }
        }).d(null);
    }

    static Context b(ah ah1)
    {
        return ah1.d;
    }

    private String e()
    {
        return Globals.D().getString("KEY_WEIBO_TOKEN", "");
    }

    public void a(UserInfo userinfo)
    {
        if (userinfo != null && f != null)
        {
            userinfo.displayName = f.screen_name;
            userinfo.description = f.description;
            if (f.gender != null)
            {
                if (f.gender.equals("m"))
                {
                    userinfo.gender = "Male";
                    return;
                }
                if (f.gender.equals("f"))
                {
                    userinfo.gender = "Female";
                    return;
                }
            }
        }
    }

    public void a(ai ai1)
    {
        if (e == null)
        {
            String s = e();
            if (!s.isEmpty())
            {
                e = Oauth2AccessToken.parseAccessToken(s);
            }
        }
        if (e == null || !a())
        {
            c.authorize(new WeiboAuthListener(ai1) {

                final ai a;
                final ah b;

                public void onCancel()
                {
                    if (a != null)
                    {
                        a.a(new WeiboException("Cancelled"));
                    }
                }

                public void onComplete(Bundle bundle)
                {
                    if (bundle != null)
                    {
                        ah.a(b, Oauth2AccessToken.parseAccessToken(bundle));
                        ah.a(b, bundle);
                        if (a != null)
                        {
                            a.a();
                        }
                    }
                }

                public void onWeiboException(WeiboException weiboexception)
                {
                    if (a != null)
                    {
                        a.a(weiboexception);
                    }
                }

            
            {
                b = ah.this;
                a = ai1;
                super();
            }
            });
        } else
        if (ai1 != null)
        {
            ai1.a();
            return;
        }
    }

    public void a(String s, Uri uri, ai ai1)
    {
        if (e == null)
        {
            a(new ai(s, uri, ai1) {

                final String a;
                final Uri b;
                final ai c;
                final ah d;

                public void a()
                {
                    ah.a(d, ah.a(d), a, b, c);
                }

                public void a(WeiboException weiboexception)
                {
                    if (c != null)
                    {
                        c.a(weiboexception);
                    }
                }

            
            {
                d = ah.this;
                a = s;
                b = uri;
                c = ai1;
                super();
            }
            });
            return;
        } else
        {
            a(e, s, uri, ai1);
            return;
        }
    }

    public boolean a()
    {
        return e != null && e.isSessionValid();
    }

    public String b()
    {
        if (e != null)
        {
            return e.getToken();
        } else
        {
            return "";
        }
    }

    public void b(ai ai1)
    {
        (new UsersAPI(d, a, e)).show(c(), new RequestListener(ai1) {

            final ai a;
            final ah b;

            public void onComplete(String s)
            {
                ah.a(b, (WeiboAccountInfo)Model.a(com/cyberlink/beautycircle/model/WeiboAccountInfo, s));
                if (a != null)
                {
                    a.a();
                }
            }

            public void onWeiboException(WeiboException weiboexception)
            {
                if (a != null)
                {
                    a.a(weiboexception);
                }
            }

            
            {
                b = ah.this;
                a = ai1;
                super();
            }
        });
    }

    public long c()
    {
        long l = -1L;
        try
        {
            if (e != null)
            {
                l = Long.parseLong(e.getUid());
            }
        }
        catch (Exception exception)
        {
            return -1L;
        }
        return l;
    }

    public WeiboAccountInfo d()
    {
        return f;
    }

    static 
    {
        a = Globals.n().getResources().getString(m.share_weibo_app_key);
        b = Globals.n().getResources().getString(m.share_weibo_direct_url);
    }
}
