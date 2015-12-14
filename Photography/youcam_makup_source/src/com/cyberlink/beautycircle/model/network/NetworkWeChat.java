// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager

public class NetworkWeChat
{

    public static j a(String s, String s1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1) {

            final String a;
            final String b;

            protected u a(NetworkManager networkmanager)
            {
                if (a == null || b == null)
                {
                    b(NetworkManager.NetworkErrorCode.b.a());
                    return null;
                } else
                {
                    networkmanager = new u("https://api.weixin.qq.com/sns/userinfo");
                    networkmanager.a("access_token", a);
                    networkmanager.a("openid", b);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = s1;
                super();
            }
        }).a(NetworkManager.d()).a(new j() {

            protected UserinfoResult a(String s2)
            {
                return (UserinfoResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkWeChat$UserinfoResult, s2);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class UserinfoResult extends Model
            {

                public String city;
                public String country;
                public Integer errcode;
                public String errmsg;
                public String headimgurl;
                public String language;
                public String nickname;
                public String openid;
                public ArrayList privilege;
                public String province;
                public int sex;
                public String unionid;

                public UserinfoResult()
                {
                }
            }

        });
    }

    public static j a(String s, String s1, String s2)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, s2) {

            final String a;
            final String b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (a == null || b == null || c == null)
                {
                    b(NetworkManager.NetworkErrorCode.b.a());
                    return null;
                } else
                {
                    networkmanager = new u("https://api.weixin.qq.com/sns/oauth2/access_token");
                    networkmanager.a("appid", a);
                    networkmanager.a("secret", b);
                    networkmanager.a("code", c);
                    networkmanager.a("grant_type", "authorization_code");
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = s1;
                c = s2;
                super();
            }
        }).a(NetworkManager.d()).a(new j() {

            protected AccessTokenResult a(String s3)
            {
                return (AccessTokenResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkWeChat$AccessTokenResult, s3);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class AccessTokenResult extends Model
            {

                public String access_token;
                public Integer errcode;
                public String errmsg;
                public int expires_in;
                public String openid;
                public String refresh_token;
                public String scope;
                public String unionid;

                public AccessTokenResult()
                {
                }
            }

        });
    }
}
