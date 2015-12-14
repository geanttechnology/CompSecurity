// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.Comment;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.PostPhoto;
import com.cyberlink.beautycircle.model.SubPost;
import com.cyberlink.beautycircle.model.Tags;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, p, q, d

public class NetworkPost
{

    public static j a()
    {
        return NetworkManager.a(NetworkManager.b).a(new j() {

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.listPostPhoto == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    return new u(networkmanager.e.post.listPostPhoto);
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

        }).a(NetworkManager.c()).a(new j() {

            protected BCTileImage a(String s)
            {
                Object obj = null;
                d d1 = new d(com/cyberlink/beautycircle/model/PostPhoto, s);
                s = obj;
                if (d1 != null)
                {
                    s = obj;
                    if (d1.b != null)
                    {
                        s = obj;
                        if (d1.b.size() > 0)
                        {
                            s = new BCTileImage();
                            s.imageList = new ArrayList();
                            Iterator iterator = d1.b.iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                PostPhoto postphoto = (PostPhoto)iterator.next();
                                if (postphoto != null)
                                {
                                    ((BCTileImage) (s)).imageList.add(postphoto.originalUrl.toString());
                                }
                            } while (true);
                        }
                    }
                }
                return s;
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(long l, long l1, Integer integer, Integer integer1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, l1, integer, integer1) {

            final long a;
            final long b;
            final Integer c;
            final Integer d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.listRecircleIn == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.listRecircleIn);
                    networkmanager.a("postId", Long.valueOf(a));
                    networkmanager.a("userId", Long.valueOf(b));
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
                a = l;
                b = l1;
                c = integer;
                d = integer1;
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

    public static j a(long l, String s, Long long1, Integer integer, Integer integer1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, s, long1, integer, integer1) {

            final long a;
            final String b;
            final Long c;
            final Integer d;
            final Integer e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.listRelatedPost == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.post.listRelatedPost);
                networkmanager.a("postStatus", "Published");
                if (Globals.j())
                {
                    networkmanager.a("postStatus", "Auditing");
                }
                networkmanager.a("postId", Long.valueOf(a));
                networkmanager.a("postStatus", b);
                networkmanager.a("curUserId", c);
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
                b = s;
                c = long1;
                d = integer;
                e = integer1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                return new d(com/cyberlink/beautycircle/model/Post, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(Long long1, long l)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(l, long1) {

            final long a;
            final Long b;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.queryCompletePostById == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.queryCompletePostById);
                    networkmanager.a("postId", Long.valueOf(a));
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

            protected CompletePost a(String s)
            {
                return (CompletePost)Model.a(com/cyberlink/beautycircle/model/CompletePost, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(Long long1, Long long2, String s, String s1, Long long3, String s2, Integer integer, Integer integer1)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1, long2, s, s2, s1, long3, integer, integer1) {

            final Long a;
            final Long b;
            final String c;
            final String d;
            final String e;
            final Long f;
            final Integer g;
            final Integer h;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.listPostByCircle == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.post.listPostByCircle);
                if (Globals.j())
                {
                    networkmanager.a("postStatus", "Published");
                    networkmanager.a("postStatus", "Auditing");
                }
                networkmanager.a("circleId", a);
                networkmanager.a("circleTypeId", b);
                networkmanager.a("postStatus", c);
                networkmanager.a("defaultType", d);
                networkmanager.a("sortBy", e);
                networkmanager.a("curUserId", f);
                networkmanager.a("offset", Integer.valueOf(g.intValue()));
                networkmanager.a("limit", h);
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = long1;
                b = long2;
                c = s;
                d = s1;
                e = s2;
                f = long3;
                g = integer;
                h = integer1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s3)
            {
                return new d(com/cyberlink/beautycircle/model/Post, s3);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, long l, Long long1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l, long1, i, k) {

            final String a;
            final long b;
            final Long c;
            final int d;
            final int e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.listComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.listComment);
                    networkmanager.a("targetType", a);
                    networkmanager.a("targetId", Long.valueOf(b));
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
                a = s;
                b = l;
                c = long1;
                d = i;
                e = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                return new d(com/cyberlink/beautycircle/model/Comment, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, p p, q q)
    {
        if (p == null)
        {
            p = null;
        } else
        {
            p = p.toString();
        }
        return NetworkManager.a(NetworkManager.b).a(new j(s, q, p) {

            final String a;
            final q b;
            final String c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.updatePosts == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                if (a == null || b == null || b.a == null)
                {
                    b(NetworkManager.NetworkErrorCode.b.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.post.updatePosts);
                networkmanager.a("token", a);
                networkmanager.a("postSource", c);
                networkmanager.a("mainPost", b.a);
                if (b.b != null)
                {
                    for (Iterator iterator = b.b.iterator(); iterator.hasNext(); networkmanager.a("updateSubPosts", (SubPost)iterator.next())) { }
                }
                if (b.c != null)
                {
                    for (Iterator iterator1 = b.c.iterator(); iterator1.hasNext(); networkmanager.a("newSubPosts", (SubPost)iterator1.next())) { }
                }
                if (b.d != null)
                {
                    for (Iterator iterator2 = b.d.iterator(); iterator2.hasNext(); networkmanager.a("deleteSubPosts", (SubPost)iterator2.next())) { }
                }
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = q1;
                c = s1;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected CreatePostsResult a(String s1)
            {
                return (CreatePostsResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkPost$CreatePostsResult, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class CreatePostsResult extends Model
            {

                public Date lastModified;
                public Long postId;

                public CreatePostsResult()
                {
                    postId = null;
                    lastModified = null;
                }
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
                if (networkmanager.e.post.deletePost == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.deletePost);
                    networkmanager.a("token", a);
                    networkmanager.a("postId", b);
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

    public static j a(String s, Long long1, String s1, Long long2)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1, s1, long2) {

            final String a;
            final Long b;
            final String c;
            final Long d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.circleInPost == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.circleInPost);
                    networkmanager.a("token", a);
                    networkmanager.a("postId", b);
                    networkmanager.a("title", c);
                    networkmanager.a("circleId", d);
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
                d = long2;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected CircleInPostResult a(String s2)
            {
                return (CircleInPostResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkPost$CircleInPostResult, s2);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }


            private class CircleInPostResult extends Model
            {

                public Date lastModified;
                public Long postId;
            }

        });
    }

    public static j a(String s, Long long1, String s1, JSONObject jsonobject)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, long1, s1, jsonobject) {

            final String a;
            final Long b;
            final String c;
            final JSONObject d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.updateComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    networkmanager = null;
                } else
                {
                    u u1 = new u(networkmanager.e.post.updateComment);
                    u1.a("token", a);
                    u1.a("commentId", b);
                    u1.a("comment", c);
                    networkmanager = u1;
                    if (d != null)
                    {
                        u1.a("tags", d.toString());
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
                b = long1;
                c = s1;
                d = jsonobject;
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

    public static j a(String s, String s1, long l)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, l) {

            final String a;
            final String b;
            final long c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.like == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.like);
                    networkmanager.a("token", a);
                    networkmanager.a("targetType", b);
                    networkmanager.a("targetId", Long.valueOf(c));
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
                c = l;
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

    public static j a(String s, String s1, long l, String s2)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, l, s2) {

            final String a;
            final String b;
            final long c;
            final String d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.reportInappropriate == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.reportInappropriate);
                    networkmanager.a("token", a);
                    networkmanager.a("targetType", b);
                    networkmanager.a("targetId", Long.valueOf(c));
                    networkmanager.a("reason", d);
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
                c = l;
                d = s2;
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

    public static j a(String s, String s1, long l, String s2, Tags tags)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, l, s2, tags) {

            final String a;
            final String b;
            final long c;
            final String d;
            final Tags e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.createComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    networkmanager = null;
                } else
                {
                    u u1 = new u(networkmanager.e.post.createComment);
                    u1.a("token", a);
                    u1.a("targetType", b);
                    u1.a("targetId", Long.valueOf(c));
                    u1.a("comment", d);
                    networkmanager = u1;
                    if (e != null)
                    {
                        u1.a("tags", e.toString());
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
                b = s1;
                c = l;
                d = s2;
                e = tags;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected Comment a(String s3)
            {
                return (Comment)Model.a(com/cyberlink/beautycircle/model/Comment, s3);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(String s, String s1, Post post, ArrayList arraylist)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, post, arraylist) {

            final String a;
            final String b;
            final Post c;
            final ArrayList d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.createPosts == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.post.createPosts);
                networkmanager.a("token", a);
                networkmanager.a("postSource", b);
                networkmanager.a("mainPost", c);
                if (d != null)
                {
                    for (Iterator iterator = d.iterator(); iterator.hasNext(); networkmanager.a("subPosts", (SubPost)iterator.next())) { }
                }
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = s;
                b = s1;
                c = post;
                d = arraylist;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected CreatePostsResult a(String s2)
            {
                return (CreatePostsResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkPost$CreatePostsResult, s2);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static j a(Long along[], String s, Long long1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(along, long1, s, i, k) {

            final Long a[];
            final Long b;
            final String c;
            final int d;
            final int e;

            protected u a(NetworkManager networkmanager)
            {
                int l = 0;
                if (networkmanager.e.post.listPostByUser == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.post.listPostByUser);
                networkmanager.a("postStatus", "Published");
                if (Globals.j())
                {
                    networkmanager.a("postStatus", "Auditing");
                }
                if (a != null)
                {
                    if (b != null && a.length == 1 && a[0] != null && a[0].equals(b))
                    {
                        networkmanager.a("postStatus", "Drafted");
                    }
                    Long along1[] = a;
                    for (int i1 = along1.length; l < i1; l++)
                    {
                        networkmanager.a("userId", along1[l]);
                    }

                }
                networkmanager.a("postStatus", c);
                networkmanager.a("curUserId", b);
                networkmanager.a("offset", Integer.valueOf(d));
                networkmanager.a("limit", Integer.valueOf(e));
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = along;
                b = long1;
                c = s;
                d = i;
                e = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                return new d(com/cyberlink/beautycircle/model/Post, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }

    public static com.cyberlink.beautycircle.model.MeTabItem.MeListMode b()
    {
        if (NetworkManager.f == null || NetworkManager.f.userTab == null)
        {
            return com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b;
        }
        String s = NetworkManager.f.userTab;
        if (s.equals("CIRCLE"))
        {
            return com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b;
        }
        if (s.equals("POST"))
        {
            return com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c;
        }
        if (s.equals("FOLLOWER"))
        {
            return com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e;
        }
        if (s.equals("FOLLOWING"))
        {
            return com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f;
        }
        if (s.equals("LIKE"))
        {
            return com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d;
        }
        if (s.equals("PRODUCT"))
        {
            return com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g;
        } else
        {
            return com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b;
        }
    }

    public static j b(String s, long l, Long long1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l, long1, i, k) {

            final String a;
            final long b;
            final Long c;
            final int d;
            final int e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.listLike == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.listLike);
                    networkmanager.a("targetType", a);
                    networkmanager.a("targetId", Long.valueOf(b));
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
                a = s;
                b = l;
                c = long1;
                d = i;
                e = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                return new d(com/cyberlink/beautycircle/model/Creator, s1);
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
                if (networkmanager.e.post.deleteComment == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.deleteComment);
                    networkmanager.a("token", a);
                    networkmanager.a("commentId", b);
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

    public static j b(String s, String s1, long l)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, s1, l) {

            final String a;
            final String b;
            final long c;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.unlike == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.unlike);
                    networkmanager.a("token", a);
                    networkmanager.a("targetType", b);
                    networkmanager.a("targetId", Long.valueOf(c));
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
                c = l;
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

    public static j c(String s, long l, Long long1, int i, int k)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(s, l, long1, i, k) {

            final String a;
            final long b;
            final Long c;
            final int d;
            final int e;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.post.listLikedTarget == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                } else
                {
                    networkmanager = new u(networkmanager.e.post.listLikedTarget);
                    networkmanager.a("targetType", a);
                    networkmanager.a("userId", Long.valueOf(b));
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
                a = s;
                b = l;
                c = long1;
                d = i;
                e = k;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s1)
            {
                return new d(com/cyberlink/beautycircle/model/Post, s1);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }
}
