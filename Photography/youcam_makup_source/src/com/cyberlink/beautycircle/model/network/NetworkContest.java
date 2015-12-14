// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, e

public class NetworkContest
{

    public static j a(Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1) {

            final Long a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.contest.contestInfo == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.contest.contestInfo);
                    networkmanager.a("nEventId", a);
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
        }).a(NetworkManager.d()).a(new j() {

            protected com.cyberlink.beautycircle.model.Contest.ContestInfoResult a(String s)
            {
                return (com.cyberlink.beautycircle.model.Contest.ContestInfoResult)Model.a(com/cyberlink/beautycircle/model/Contest$ContestInfoResult, s);
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
                if (networkmanager.e.contest.contestList == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    networkmanager = null;
                } else
                {
                    u u1 = new u(networkmanager.e.contest.contestList);
                    networkmanager = u1;
                    if (a != null)
                    {
                        u1.b("locale");
                        u1.a("locale", a);
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
        }).a(NetworkManager.d()).a(new j() {

            protected e a(String s1)
            {
                return new e(com/cyberlink/beautycircle/model/Contest$ContestInfo, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static String a(String s, Long long1)
    {
        if (NetworkManager.a == null || NetworkManager.a.e.contest.sharePost == null || long1 == null)
        {
            return null;
        }
        Object obj = Globals.s();
        String s1 = ((String) (obj));
        if (((String) (obj)).equals("YCP"))
        {
            s1 = "YPA";
        }
        obj = new u(NetworkManager.a.e.contest.sharePost);
        ((u) (obj)).a("appUrl", s);
        ((u) (obj)).a("appName", s1);
        ((u) (obj)).a("postId", long1);
        return ((u) (obj)).c();
    }

    public static j b(Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1) {

            final Long a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.contest.votePost == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.contest.votePost);
                    networkmanager.a("postId", a);
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
        }).a(NetworkManager.d()).a(new j() {

            protected ContestResult a(String s)
            {
                return (ContestResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkContest$ContestResult, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class ContestResult extends Model
            {

                public Date currentTime;
                public com.cyberlink.beautycircle.model.Contest.ContestResponse result;

                public ContestResult()
                {
                }
            }

        });
    }

    public static j c(Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1) {

            final Long a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.contest.deletePost == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.contest.deletePost);
                    networkmanager.a("postId", a);
                    networkmanager.a("isDelete", Integer.valueOf(1));
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
        }).a(NetworkManager.d()).a(new j() {

            protected ContestResult a(String s)
            {
                return (ContestResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkContest$ContestResult, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j d(Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1) {

            final Long a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.contest.reportPost == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.contest.reportPost);
                    networkmanager.a("postId", a);
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
        }).a(NetworkManager.d()).a(new j() {

            protected ContestResult a(String s)
            {
                return (ContestResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkContest$ContestResult, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j e(Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1) {

            final Long a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.contest.queryVoteStatus == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.contest.queryVoteStatus);
                    networkmanager.a("postId", a);
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
        }).a(NetworkManager.d()).a(new j() {

            protected QueryVoteStatusResult a(String s)
            {
                return (QueryVoteStatusResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkContest$QueryVoteStatusResult, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class QueryVoteStatusResult extends Model
            {

                public Date currentTime;
                public com.cyberlink.beautycircle.model.Contest.VoteStatus result;

                public QueryVoteStatusResult()
                {
                }
            }

        });
    }
}
