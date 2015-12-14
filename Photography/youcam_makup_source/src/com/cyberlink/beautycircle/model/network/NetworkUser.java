// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, d

public class NetworkUser
{

    public static j a(long l, Long long1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.c).a(new j(l, long1, i, k) {

            final long a;
            final Long b;
            final int c;
            final int d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.listFollower == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.listFollower);
                    networkmanager.a("userId", Long.valueOf(a));
                    networkmanager.a("curUserId", b);
                    networkmanager.a("offset", Integer.valueOf(c));
                    networkmanager.a("limit", Integer.valueOf(d));
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = l;
                b = long1;
                c = i;
                d = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/UserInfo, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(long l, Long long1, String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1, l, s) {

            final Long a;
            final long b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.userInfo == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.user.userInfo);
                if (a == null || b != a.longValue() || c == null)
                {
                    networkmanager.a("userId", Long.valueOf(b));
                    networkmanager.a("curUserId", a);
                    return networkmanager;
                } else
                {
                    networkmanager.a("token", c);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = long1;
                b = l;
                c = s;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected UserInfo a(String s1)
            {
                return ((UserInfoResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkUser$UserInfoResult, s1)).result;
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class UserInfoResult extends Model
            {

                public UserInfo result;

                public UserInfoResult()
                {
                }
            }

        });
    }

    public static j a(long l, Long long1, String s, int i, int k)
    {
        return NetworkManager.a(NetworkManager.c).a(new j(l, s, long1, i, k) {

            final long a;
            final String b;
            final Long c;
            final int d;
            final int e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.listFollowing == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.listFollowing);
                    networkmanager.a("userId", Long.valueOf(a));
                    networkmanager.a("targetType", b);
                    networkmanager.a("curUserId", c);
                    networkmanager.a("offset", Integer.valueOf(d));
                    networkmanager.a("limit", Integer.valueOf(e));
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = l;
                b = s;
                c = long1;
                d = i;
                e = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected ListFollowingResult a(String s1)
            {
                return (ListFollowingResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkUser$ListFollowingResult, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class ListFollowingResult extends Model
            {

                public Circles circles;
                public Users users;

                public ListFollowingResult()
                {
                }
            }

        });
    }

    public static j a(Long long1, int i, int k, ArrayList arraylist)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(arraylist, long1, i, k) {

            final ArrayList a;
            final Long b;
            final int c;
            final int d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.listByType == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.user.listByType);
                if (a != null)
                {
                    for (Iterator iterator = a.iterator(); iterator.hasNext(); networkmanager.a("userType", (String)iterator.next())) { }
                }
                networkmanager.a("curUserId", b);
                networkmanager.a("offset", Integer.valueOf(c));
                networkmanager.a("limit", Integer.valueOf(d));
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = arraylist;
                b = long1;
                c = i;
                d = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/UserInfo, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s) {

            final String a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.signOut == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.signOut);
                    networkmanager.a("token", a);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                return null;
            }

        });
    }

    public static j a(String s, long l)
    {
        return NetworkManager.a(NetworkManager.c).a(new j(s, l) {

            final String a;
            final long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.follow == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.follow);
                    networkmanager.a("token", a);
                    networkmanager.a("userId", Long.valueOf(b));
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = l;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                return null;
            }

        });
    }

    public static j a(String s, Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1) {

            final String a;
            final Long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.blockUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.blockUser);
                    networkmanager.a("token", a);
                    networkmanager.a("targetId", b);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = long1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                return null;
            }

        });
    }

    public static j a(String s, Long long1, String s1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1, s1) {

            final String a;
            final Long b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.reportUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.reportUser);
                    networkmanager.a("token", a);
                    networkmanager.a("targetId", b);
                    networkmanager.a("reason", c);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = long1;
                c = s1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s2)
            {
                return null;
            }

        });
    }

    public static j a(String s, String s1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1) {

            final String a;
            final String b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.signInCL == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.signInCL);
                    networkmanager.a("email", a);
                    networkmanager.a("password", b);
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
        }).a(NetworkManager.c()).a(new j() {

            protected com.cyberlink.beautycircle.model.UserInfo.SignInResult a(String s2)
            {
                return (com.cyberlink.beautycircle.model.UserInfo.SignInResult)Model.a(com/cyberlink/beautycircle/model/UserInfo$SignInResult, s2);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, String s1, Long long1, Long long2, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, String s10, String s11)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, long1, long2, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11) {

            final String a;
            final String b;
            final Long c;
            final Long d;
            final String e;
            final String f;
            final String g;
            final String h;
            final String i;
            final String j;
            final String k;
            final String l;
            final String m;
            final String n;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.updateUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.updateUser);
                    networkmanager.a("token", a);
                    networkmanager.a("displayName", b);
                    networkmanager.a("avatarId", c);
                    networkmanager.a("coverId", d);
                    networkmanager.a("description", e);
                    networkmanager.a("gender", f);
                    networkmanager.a("region", g);
                    networkmanager.a("birthDay", h);
                    networkmanager.a("attrs", i);
                    networkmanager.a("name", j);
                    networkmanager.a("phone", k);
                    networkmanager.a("receiveEmail", l);
                    networkmanager.a("address", m);
                    networkmanager.a("websiteUrl", n);
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
                c = long1;
                d = long2;
                e = s2;
                f = s3;
                g = s4;
                h = s5;
                i = s6;
                j = s7;
                k = s8;
                l = s9;
                m = s10;
                n = s11;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse a(String s12)
            {
                return (com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)Model.a(com/cyberlink/beautycircle/model/UserInfo$UpdateUserResponse, s12);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
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
                if (networkmanager.e.user.signIn == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.signIn);
                    networkmanager.a("accountSource", a);
                    networkmanager.a("accountToken", b);
                    networkmanager.a("openId", c);
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
        }).a(NetworkManager.c()).a(new j() {

            protected com.cyberlink.beautycircle.model.UserInfo.SignInResult a(String s3)
            {
                return (com.cyberlink.beautycircle.model.UserInfo.SignInResult)Model.a(com/cyberlink/beautycircle/model/UserInfo$SignInResult, s3);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j b(String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s) {

            final String a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.deleteUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.deleteUser);
                    networkmanager.a("token", a);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                return null;
            }

        });
    }

    public static j b(String s, long l)
    {
        return NetworkManager.a(NetworkManager.c).a(new j(s, l) {

            final String a;
            final long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.unfollow == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.unfollow);
                    networkmanager.a("token", a);
                    networkmanager.a("userId", Long.valueOf(b));
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = l;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                return null;
            }

        });
    }

    public static j b(String s, Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1) {

            final String a;
            final Long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.unblockUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.unblockUser);
                    networkmanager.a("token", a);
                    networkmanager.a("targetId", b);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = long1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                return null;
            }

        });
    }

    public static j b(String s, String s1, String s2)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s2, s1) {

            final String a;
            final String b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.createCLAccount == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.createCLAccount);
                    networkmanager.a("email", a);
                    networkmanager.a("password", b);
                    networkmanager.a("displayName", c);
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
        }).a(NetworkManager.c()).a(new j() {

            protected CreateCLAccountResult a(String s3)
            {
                return (CreateCLAccountResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkUser$CreateCLAccountResult, s3);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class CreateCLAccountResult extends Model
            {

                public static final String STATUS_OK = "OK";
                public static final String STATUS_WAIT_VALIDATE = "WaitValidate";
                public com.cyberlink.beautycircle.model.UserInfo.SignInResult result;
                public String status;

                public CreateCLAccountResult()
                {
                }
            }

        });
    }

    public static j c(String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s) {

            final String a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.forgetPassword == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.forgetPassword);
                    networkmanager.a("email", a);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                return null;
            }

        });
    }

    public static j c(String s, String s1, String s2)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, s2) {

            final String a;
            final String b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.changePassword == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.user.changePassword);
                    networkmanager.a("token", a);
                    networkmanager.a("oldPassword", b);
                    networkmanager.a("newPassword", c);
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
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s3)
            {
                return null;
            }

        });
    }

    public static j d(String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s) {

            final String a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.user.listDefaultCover == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    networkmanager = null;
                } else
                {
                    u u1 = new u(networkmanager.e.user.listDefaultCover);
                    networkmanager = u1;
                    if (a != null)
                    {
                        u1.a("userType", a);
                        return u1;
                    }
                }
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                return new d(com/cyberlink/beautycircle/model/network/NetworkUser$DefaultCover, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }
}
