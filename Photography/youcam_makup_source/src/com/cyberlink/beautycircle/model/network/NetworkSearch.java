// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, d

public class NetworkSearch
{

    public static j a()
    {
        return NetworkManager.a(NetworkManager.b).a(new j() {

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.search.listTopPostKeyword == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    return new u(networkmanager.e.search.listTopPostKeyword);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

        }).a(NetworkManager.c()).a(new j() {

            protected SuggestionKeywords a(String s)
            {
                if (s == null)
                {
                    b(0x80000003);
                    return null;
                } else
                {
                    return (SuggestionKeywords)Model.a(com/cyberlink/beautycircle/model/network/NetworkSearch$SuggestionKeywords, s);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class SuggestionKeywords extends Model
            {

                public static final String EMPTY_JSON = "{\"totalSize\":0,\"results\":[]}";
                public ArrayList results;
                public Integer totalSize;

                public SuggestionKeywords()
                {
                }
            }

        });
    }

    public static j a(String s)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s) {

            final String a;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.search.listCircleSuggestion == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.search.listCircleSuggestion);
                    networkmanager.a("keyword", a);
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

            protected d a(String s1)
            {
                if (s1 == null)
                {
                    b(0x80000003);
                    return null;
                } else
                {
                    return new d(com/cyberlink/beautycircle/model/CircleDetail, s1);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, Integer integer, Integer integer1, Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, integer, integer1, long1) {

            final String a;
            final Integer b;
            final Integer c;
            final Long d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.search.searchPost == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.search.searchPost);
                    networkmanager.a("keyword", a);
                    networkmanager.a("offset", b);
                    networkmanager.a("limit", c);
                    networkmanager.a("curUserId", d);
                    return networkmanager;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = integer;
                c = integer1;
                d = long1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                if (s1 == null)
                {
                    b(0x80000003);
                    return null;
                } else
                {
                    return new d(com/cyberlink/beautycircle/model/Post, s1);
                }
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
                if (networkmanager.e.search.listPeopleSuggestion == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.search.listPeopleSuggestion);
                    networkmanager.a("keyword", a);
                    networkmanager.a("curUserId", b);
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

            protected d a(String s1)
            {
                if (s1 == null)
                {
                    b(0x80000003);
                    return null;
                } else
                {
                    return new d(com/cyberlink/beautycircle/model/UserInfo, s1);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, Long long1, Integer integer, Integer integer1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1, integer, integer1) {

            final String a;
            final Long b;
            final Integer c;
            final Integer d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.search.searchCircle == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.search.searchCircle);
                    networkmanager.a("keyword", a);
                    networkmanager.a("curUserId", b);
                    networkmanager.a("offset", c);
                    networkmanager.a("limit", d);
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
                c = integer;
                d = integer1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                if (s1 == null)
                {
                    b(0x80000003);
                    return null;
                } else
                {
                    return new d(com/cyberlink/beautycircle/model/CircleDetail, s1);
                }
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
                if (networkmanager.e.search.listPostKeywordSuggestion == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.search.listPostKeywordSuggestion);
                    networkmanager.a("keyword", a);
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

            protected SuggestionKeywords a(String s1)
            {
                if (s1 == null)
                {
                    b(0x80000003);
                    return null;
                } else
                {
                    return (SuggestionKeywords)Model.a(com/cyberlink/beautycircle/model/network/NetworkSearch$SuggestionKeywords, s1);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
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
                if (networkmanager.e.search.listRecentKeywordByUserId == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.search.listRecentKeywordByUserId);
                    networkmanager.a("type", a);
                    networkmanager.a("curUserId", b);
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

            protected SuggestionKeywords a(String s1)
            {
                if (s1 == null)
                {
                    b(0x80000003);
                    return null;
                } else
                {
                    return (SuggestionKeywords)Model.a(com/cyberlink/beautycircle/model/network/NetworkSearch$SuggestionKeywords, s1);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j b(String s, Long long1, Integer integer, Integer integer1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1, integer, integer1) {

            final String a;
            final Long b;
            final Integer c;
            final Integer d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.search.searchPeople == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.search.searchPeople);
                    networkmanager.a("keyword", a);
                    networkmanager.a("curUserId", b);
                    networkmanager.a("offset", c);
                    networkmanager.a("limit", d);
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
                c = integer;
                d = integer1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                if (s1 == null)
                {
                    b(0x80000003);
                    return null;
                } else
                {
                    return new d(com/cyberlink/beautycircle/model/UserInfo, s1);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j c(String s, Long long1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1) {

            final String a;
            final Long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.search.removeRecentKeywordByUserId == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.search.removeRecentKeywordByUserId);
                    networkmanager.a("type", a);
                    networkmanager.a("curUserId", b);
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
}
