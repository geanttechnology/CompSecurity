// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, d

public class NetworkCircle
{

    public static j a(long l, long l1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, l1) {

            final long a;
            final long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.listCircleByUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.listCircleByUser);
                    networkmanager.a("userId", Long.valueOf(a));
                    networkmanager.a("curUserId", Long.valueOf(b));
                    networkmanager.a("responseType", "Basic");
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = l;
                b = l1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/CircleBasic, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(long l, long l1, Long long1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, l1, long1, i, k) {

            final long a;
            final long b;
            final Long c;
            final int d;
            final int e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.listFollowerByCircle == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.listFollowerByCircle);
                    networkmanager.a("circleId", Long.valueOf(a));
                    networkmanager.a("circleCreatorId", Long.valueOf(b));
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
                b = l1;
                c = long1;
                d = i;
                e = k;
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

    public static j a(long l, Long long1, Integer integer, Integer integer1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, long1) {

            final long a;
            final Long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.listCircleByUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.listCircleByUser);
                    networkmanager.a("userId", Long.valueOf(a));
                    networkmanager.a("curUserId", b);
                    networkmanager.a("responseType", "Detail");
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

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/CircleDetail, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(Integer integer, Integer integer1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(integer, integer1) {

            final Integer a;
            final Integer b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.listCircleType == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.listCircleType);
                    networkmanager.a("offset", a);
                    networkmanager.a("limit", b);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = integer;
                b = integer1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/CircleType, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(Long long1, Long long2, Long long3)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1, long2, long3) {

            final Long a;
            final Long b;
            final Long c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.getCircleInfo == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.getCircleInfo);
                    networkmanager.a("circleId", a);
                    networkmanager.a("circleCreatorId", b);
                    networkmanager.a("curUserId", c);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = long1;
                b = long2;
                c = long3;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/CircleDetail, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
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
                if (networkmanager.e.circle.deleteCircle == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.deleteCircle);
                    networkmanager.a("token", a);
                    networkmanager.a("circleId", b);
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

    public static j a(String s, Long long1, Long long2)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1, long2) {

            final String a;
            final Long b;
            final Long c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.followCircle == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.followCircle);
                    networkmanager.a("token", a);
                    networkmanager.a("circleId", b);
                    networkmanager.a("circleCreatorId", c);
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
                c = long2;
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

    public static j a(String s, Long long1, String s1, String s2, Long long2, Boolean boolean1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1, s1, s2, long2, boolean1) {

            final String a;
            final Long b;
            final String c;
            final String d;
            final Long e;
            final Boolean f;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.updateCircle == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.updateCircle);
                    networkmanager.a("token", a);
                    networkmanager.a("circleId", b);
                    networkmanager.a("circleName", c);
                    networkmanager.a("description", d);
                    networkmanager.a("circleTypeId", e);
                    networkmanager.a("isSecret", f);
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
                d = s2;
                e = long2;
                f = boolean1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected CreateCircleResult a(String s3)
            {
                return (CreateCircleResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkCircle$CreateCircleResult, s3);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class CreateCircleResult extends Model
            {

                public Long circleId;

                public CreateCircleResult()
                {
                }
            }

        });
    }

    public static j a(String s, String s1, String s2, Long long1, Boolean boolean1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, s2, long1, boolean1) {

            final String a;
            final String b;
            final String c;
            final Long d;
            final Boolean e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.createCircle == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.createCircle);
                    networkmanager.a("token", a);
                    networkmanager.a("circleName", b);
                    networkmanager.a("description", c);
                    networkmanager.a("circleTypeId", d);
                    networkmanager.a("isSecret", e);
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
                d = long1;
                e = boolean1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected CreateCircleResult a(String s3)
            {
                return (CreateCircleResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkCircle$CreateCircleResult, s3);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j b(String s, Long long1, Long long2)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1, long2) {

            final String a;
            final Long b;
            final Long c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.circle.unfollowCircle == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.circle.unfollowCircle);
                    networkmanager.a("token", a);
                    networkmanager.a("circleId", b);
                    networkmanager.a("circleCreatorId", c);
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
                c = long2;
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
