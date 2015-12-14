// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.NotificationList;
import com.cyberlink.beautycircle.model.NotificationNew;
import com.cyberlink.beautycircle.model.NotificationSetting;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, d

public class o
{

    public static j a(long l)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l) {

            final long a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.notify.getNotifySetting == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.notify.getNotifySetting);
                    networkmanager.a("userId", Long.valueOf(a));
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = l;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected NotificationSetting a(String s)
            {
                return (NotificationSetting)Model.a(com/cyberlink/beautycircle/model/NotificationSetting, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(long l, long l1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, l1, i, k) {

            final long a;
            final long b;
            final int c;
            final int d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.notify.listNotifyReference == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.notify.listNotifyReference);
                    networkmanager.a("nId", Long.valueOf(a));
                    networkmanager.a("curUserId", Long.valueOf(b));
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
                b = l1;
                c = i;
                d = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/Post, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(long l, long l1, String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, l1, s) {

            final long a;
            final long b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.notify.setNotifyReaded == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.notify.setNotifyReaded);
                    networkmanager.a("userId", Long.valueOf(a));
                    networkmanager.a("createTime", Long.valueOf(b));
                    networkmanager.a("type", c);
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
                c = s;
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

    public static j a(Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1) {

            final Long a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.notify.checkNewNotify == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.notify.checkNewNotify);
                    networkmanager.a("userId", a);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = long1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected NotificationNew a(String s)
            {
                return (NotificationNew)Model.a(com/cyberlink/beautycircle/model/NotificationNew, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, String s1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, i, k) {

            final String a;
            final String b;
            final int c;
            final int d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.notify.listNotify == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.notify.listNotify);
                    networkmanager.a("token", a);
                    networkmanager.a("type", b);
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
                a = s;
                b = s1;
                c = i;
                d = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s2)
            {
                return new d(com/cyberlink/beautycircle/model/NotificationList, s2);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, ArrayList arraylist)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, arraylist) {

            final String a;
            final ArrayList b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.notify.setNotifySetting == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.notify.setNotifySetting);
                networkmanager.a("token", a);
                if (b != null)
                {
                    for (Iterator iterator = b.iterator(); iterator.hasNext(); networkmanager.a("nonNotifyType", (String)iterator.next())) { }
                }
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = arraylist;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected String a(String s1)
            {
                return s1;
            }

        });
    }

    public static j b(long l, long l1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, l1, i, k) {

            final long a;
            final long b;
            final int c;
            final int d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.notify.listNotifyReference == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.notify.listNotifyReference);
                    networkmanager.a("nId", Long.valueOf(a));
                    networkmanager.a("curUserId", Long.valueOf(b));
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
                b = l1;
                c = i;
                d = k;
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
}
