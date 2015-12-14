// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkWeChat;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.j;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.mm.sdk.openapi.a;
import com.tencent.mm.sdk.openapi.b;
import com.tencent.mm.sdk.openapi.e;
import com.tencent.mm.sdk.openapi.f;
import com.tencent.mm.sdk.openapi.h;
import com.tencent.mm.sdk.openapi.i;
import com.tencent.mm.sdk.openapi.k;
import com.tencent.mm.sdk.openapi.l;
import com.tencent.mm.sdk.openapi.o;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ag, af

public class ae
{

    public static final String a;
    public static final String b;
    public static int c = 150;
    public static final f d = new f() {

        public void a(a a1)
        {
        }

        public void a(b b1)
        {
            if (b1 == null)
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    "WeChatGlobalEvent: resp null"
                });
            } else
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    "WeChatGlobalEvent: ", com.cyberlink.beautycircle.utility.ae.a(b1.a)
                });
                if (b1 instanceof i)
                {
                    com.cyberlink.beautycircle.utility.ae.a((i)b1);
                    return;
                }
                if (b1 instanceof l)
                {
                    if (com.cyberlink.beautycircle.utility.ae.a() != null)
                    {
                        if (b1.a == 0)
                        {
                            com.cyberlink.beautycircle.utility.ae.a().a();
                        } else
                        {
                            com.cyberlink.beautycircle.utility.ae.a().b();
                        }
                        com.cyberlink.beautycircle.utility.ae.a(null);
                        return;
                    }
                    if (com.cyberlink.beautycircle.utility.ae.b() != null)
                    {
                        com.cyberlink.beautycircle.utility.ae.a(null);
                        return;
                    }
                }
            }
        }

    };
    private static com.cyberlink.beautycircle.model.network.NetworkWeChat.AccessTokenResult f;
    private static ag g;
    private static af h;
    private e e;

    public ae(Context context)
    {
        e = o.a(context, a, true);
        e.a(a);
    }

    static com.cyberlink.beautycircle.model.network.NetworkWeChat.AccessTokenResult a(com.cyberlink.beautycircle.model.network.NetworkWeChat.AccessTokenResult accesstokenresult)
    {
        f = accesstokenresult;
        return accesstokenresult;
    }

    static af a()
    {
        return h;
    }

    static af a(af af)
    {
        h = af;
        return af;
    }

    static e a(ae ae1)
    {
        return ae1.e;
    }

    public static String a(int k)
    {
        switch (k)
        {
        default:
            return String.format(Locale.US, "ERR_UNDEF(%d)", new Object[] {
                Integer.valueOf(k)
            });

        case 0: // '\0'
            return "ERR_OK";

        case -1: 
            return "ERR_COMM";

        case -2: 
            return "ERR_USER_CANCEL";

        case -3: 
            return "ERR_SENT_FAILED";

        case -4: 
            return "ERR_AUTH_DENIED";

        case -5: 
            return "ERR_UNSUPPORTED";
        }
    }

    static String a(ae ae1, String s)
    {
        return ae1.a(s);
    }

    private String a(String s)
    {
        if (s == null)
        {
            return String.valueOf(System.currentTimeMillis());
        } else
        {
            return (new StringBuilder()).append(s).append(System.currentTimeMillis()).toString();
        }
    }

    static void a(i k)
    {
        b(k);
    }

    static ag b()
    {
        return g;
    }

    static ag b(ag ag1)
    {
        g = ag1;
        return ag1;
    }

    private static void b(i k)
    {
        if (k != null && k.a == 0)
        {
            NetworkWeChat.a(a, b, k.e).a(new j() {

                protected volatile Object a(Object obj)
                {
                    return a((com.cyberlink.beautycircle.model.network.NetworkWeChat.AccessTokenResult)obj);
                }

                protected Void a(com.cyberlink.beautycircle.model.network.NetworkWeChat.AccessTokenResult accesstokenresult)
                {
                    if (accesstokenresult == null)
                    {
                        b(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.d.a());
                    } else
                    {
                        com.cyberlink.beautycircle.utility.ae.a(accesstokenresult);
                        if (com.cyberlink.beautycircle.utility.ae.b() != null)
                        {
                            com.cyberlink.beautycircle.utility.ae.b().a(accesstokenresult);
                            com.cyberlink.beautycircle.utility.ae.b(null);
                            return null;
                        }
                    }
                    return null;
                }

                protected void a(int l)
                {
                    super.a(l);
                    com.perfectcorp.utility.e.e(new Object[] {
                        "NetworkWeChat.accessToken: ", Integer.valueOf(l)
                    });
                    if (com.cyberlink.beautycircle.utility.ae.b() != null)
                    {
                        com.cyberlink.beautycircle.utility.ae.b().a(null);
                        com.cyberlink.beautycircle.utility.ae.b(null);
                    }
                }

            });
        } else
        if (g != null)
        {
            g.a(null);
            g = null;
            return;
        }
    }

    public j a(UserInfo userinfo)
    {
        if (userinfo == null || f == null)
        {
            return (new j() {

                final ae a;

                protected com.cyberlink.beautycircle.model.network.NetworkWeChat.UserinfoResult a(Void void1)
                {
                    b(0x80000004);
                    return null;
                }

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

            
            {
                a = ae.this;
                super();
            }
            }).d(null);
        } else
        {
            return NetworkWeChat.a(f.access_token, f.openid).a(new j(userinfo) {

                final UserInfo a;
                final ae b;

                protected com.cyberlink.beautycircle.model.network.NetworkWeChat.UserinfoResult a(com.cyberlink.beautycircle.model.network.NetworkWeChat.UserinfoResult userinforesult)
                {
                    if (userinforesult == null)
                    {
                        b(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.d.a());
                        return null;
                    } else
                    {
                        a.displayName = userinforesult.nickname;
                        return userinforesult;
                    }
                }

                protected volatile Object a(Object obj)
                {
                    return a((com.cyberlink.beautycircle.model.network.NetworkWeChat.UserinfoResult)obj);
                }

                protected void a(int k)
                {
                    super.a(k);
                    com.perfectcorp.utility.e.e(new Object[] {
                        "NetworkWeChat.userinfo: ", Integer.valueOf(k)
                    });
                }

            
            {
                b = ae.this;
                a = userinfo;
                super();
            }
            });
        }
    }

    public void a(ag ag1)
    {
        g = ag1;
        ag1 = new h();
        ag1.b = "snsapi_userinfo";
        ag1.c = "none";
        e.a(ag1);
    }

    public void a(String s, String s1, String s2, Uri uri, af af, boolean flag)
    {
        if (s == null || s1 == null || s2 == null || uri == null)
        {
            return;
        } else
        {
            h = af;
            (new j(uri, s2, s, s1, flag) {

                final Uri a;
                final String b;
                final String c;
                final String d;
                final boolean e;
                final ae f;

                protected k a(Void void1)
                {
                    Object obj;
                    try
                    {
                        void1 = ImageUtils.a(Globals.n(), a);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void void1)
                    {
                        void1.printStackTrace();
                        return null;
                    }
                    if (void1 == null)
                    {
                        break MISSING_BLOCK_LABEL_131;
                    }
                    void1 = Bitmap.createScaledBitmap(void1, ae.c, ae.c, true);
_L1:
                    obj = new WXWebpageObject();
                    obj.webpageUrl = b;
                    obj = new WXMediaMessage(((com.tencent.mm.sdk.openapi.r) (obj)));
                    obj.title = c;
                    obj.description = d;
                    if (void1 == null)
                    {
                        break MISSING_BLOCK_LABEL_77;
                    }
                    ((WXMediaMessage) (obj)).setThumbImage(void1);
                    void1 = new k();
                    void1.a = com.cyberlink.beautycircle.utility.ae.a(f, "appdata");
                    void1.b = ((WXMediaMessage) (obj));
                    if (e)
                    {
                        break MISSING_BLOCK_LABEL_117;
                    }
                    void1.c = 0;
                    return void1;
                    void1.c = 1;
                    return void1;
                    void1 = null;
                      goto _L1
                }

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

            
            {
                f = ae.this;
                a = uri;
                b = s;
                c = s1;
                d = s2;
                e = flag;
                super();
            }
            }).d(null).a(new com.perfectcorp.utility.m(af) {

                final af a;
                final ae b;

                protected void a(k k1)
                {
                    if (k1 == null && a != null)
                    {
                        a.b();
                        com.cyberlink.beautycircle.utility.ae.a(null);
                    }
                    boolean flag1 = com.cyberlink.beautycircle.utility.ae.a(b).a(k1);
                    if (a != null && !flag1)
                    {
                        a.b();
                        com.cyberlink.beautycircle.utility.ae.a(null);
                    }
                }

                protected void b(Object obj)
                {
                    a((k)obj);
                }

            
            {
                b = ae.this;
                a = af1;
                super();
            }
            });
            return;
        }
    }

    static 
    {
        a = Globals.n().getResources().getString(m.share_wechat_app_id);
        b = Globals.n().getResources().getString(m.share_wechat_app_secret);
    }
}
