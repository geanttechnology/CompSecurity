// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, d

public class NetworkEvent
{

    public static String a = "OK";

    public static j a(long l, Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, long1) {

            final long a;
            final Long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.event.getBrandEventInfo == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.event.getBrandEventInfo);
                    networkmanager.a("brandEventId", Long.valueOf(a));
                    networkmanager.a("curUserId", b);
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
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected BrandEventInfoResult a(String s)
            {
                return (BrandEventInfoResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkEvent$BrandEventInfoResult, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class BrandEventInfoResult extends Model
            {

                public Date currentTime;
                public com.cyberlink.beautycircle.model.Event.BrandEventInfo result;

                public BrandEventInfoResult()
                {
                }
            }

        });
    }

    public static j a(long l, Long long1, String as[], Integer integer, Integer integer1)
    {
        return NetworkManager.a(NetworkManager.c).a(new j(l, long1, as, integer, integer1) {

            final long a;
            final Long b;
            final String c[];
            final Integer d;
            final Integer e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.event.listEventUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.event.listEventUser);
                networkmanager.a("brandEventId", Long.valueOf(a));
                networkmanager.a("curUserId", b);
                if (c != null)
                {
                    String as1[] = c;
                    int k = as1.length;
                    for (int i = 0; i < k; i++)
                    {
                        networkmanager.a("eventUserStatus", as1[i]);
                    }

                }
                networkmanager.a("offset", d);
                networkmanager.a("limit", e);
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = l;
                b = long1;
                c = as;
                d = integer;
                e = integer1;
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

    public static j a(Long long1, String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1, s) {

            final Long a;
            final String b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.event.listBrandEvent == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    networkmanager = null;
                } else
                {
                    u u1 = new u(networkmanager.e.event.listBrandEvent);
                    u1.a("curUserId", a);
                    networkmanager = u1;
                    if (b != null)
                    {
                        u1.b("locale");
                        u1.a("locale", b);
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
                a = long1;
                b = s;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected ListBrandEventResult a(String s1)
            {
                return (ListBrandEventResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkEvent$ListBrandEventResult, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class ListBrandEventResult extends Model
            {

                public Date currentTime;
                public ArrayList results;
                public Integer totalSize;

                public d b()
                {
                    d d1 = new d();
                    d1.b = results;
                    d1.a = totalSize;
                    return d1;
                }

                public ListBrandEventResult()
                {
                }
            }

        });
    }

    public static j a(String s, long l)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l) {

            final String a;
            final long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.event.getReceiveUserInfo == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                if (a == null)
                {
                    b(NetworkManager.NetworkErrorCode.b.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.event.getReceiveUserInfo);
                    networkmanager.a("token", a);
                    networkmanager.a("brandEventId", Long.valueOf(b));
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

            protected ReceiveUserInfoResult a(String s1)
            {
                return (ReceiveUserInfoResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkEvent$ReceiveUserInfoResult, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class ReceiveUserInfoResult extends Model
            {

                public com.cyberlink.beautycircle.model.Event.ReceiveUserInfo result;

                public ReceiveUserInfoResult()
                {
                }
            }

        });
    }

    public static j a(String s, JoinEventParam joineventparam)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, joineventparam) {

            final String a;
            final JoinEventParam b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.event.joinEvent == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                if (a == null || b == null)
                {
                    b(NetworkManager.NetworkErrorCode.b.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.event.joinEvent);
                    networkmanager.a("token", a);
                    networkmanager.a(b);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = joineventparam;
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

    public static String a(String s, long l, Long long1)
    {
        if (s == null)
        {
            return null;
        } else
        {
            s = new u(s);
            s.a("brandEventId", Long.valueOf(l));
            s.a("curUserId", long1);
            return s.c();
        }
    }

    public static String a(String s, Long long1)
    {
        if (NetworkManager.f == null || NetworkManager.f.deeplink == null)
        {
            return null;
        }
        Object obj = Globals.s();
        String s1 = ((String) (obj));
        if (((String) (obj)).equals("YCP"))
        {
            s1 = "YPA";
        }
        obj = new u(NetworkManager.f.deeplink);
        ((u) (obj)).a("appUrl", s);
        ((u) (obj)).a("appName", s1);
        ((u) (obj)).a("postId", long1);
        return ((u) (obj)).c();
    }

    public static String a(String s, String s1)
    {
        if (s == null)
        {
            return null;
        } else
        {
            s = new u(s);
            s.a("Token", s1);
            s.a("locale", AccountManager.a());
            s.a("platform", "android");
            return s.c();
        }
    }

    public static j b(String s, long l)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l) {

            final String a;
            final long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.event.redeemEventProd == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.event.redeemEventProd);
                    networkmanager.a("token", a);
                    networkmanager.a("brandEventId", Long.valueOf(b));
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

}
