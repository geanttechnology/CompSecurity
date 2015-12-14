// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import android.os.AsyncTask;
import com.cyberlink.beautycircle.model.database.a.a;
import com.cyberlink.beautycircle.model.database.b;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.f;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            PostBase, FileMetadata, Creator, r

public class Post extends PostBase
{

    public static final String SortByDate = "Date";
    public static final String SortByPopularity = "Popularity";
    public ArrayList circleIds;
    public ArrayList circles;
    public Date createdTime;
    public Creator creator;
    public Boolean gotProductTag;
    public Long postId;
    public transient String postJSON;
    public String postSource;
    public Creator sourcePostCreator;
    public String status;
    public String title;

    public Post()
    {
    }

    public static j a(long l, String s, Long long1, Integer integer, Integer integer1)
    {
        return NetworkPost.a(l, s, long1, integer, integer1).a(new j() {

            public d a(d d1)
            {
                com.cyberlink.beautycircle.model.database.b.c().a((Post[])d1.b.toArray(new Post[0]));
                return d1;
            }

            public volatile Object a(Object obj)
            {
                return a((d)obj);
            }

        });
    }

    public static j a(Long long1, int i, int k, Integer integer)
    {
        return f.a(long1, i, k, integer).a(new j() {

            public d a(d d1)
            {
                com.cyberlink.beautycircle.model.database.b.c().a((Post[])d1.b.toArray(new Post[0]));
                return d1;
            }

            public volatile Object a(Object obj)
            {
                return a((d)obj);
            }

        });
    }

    public static j a(Long long1, long l)
    {
        return (new j(l) {

            final long a;

            protected Post a(Void void1)
            {
                void1 = com.cyberlink.beautycircle.model.database.b.c().a(a);
                if (void1 != null)
                {
                    return void1;
                } else
                {
                    return null;
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                a = l;
                super();
            }
        }).d(null);
    }

    public static j a(Long long1, Long long2, String s, String s1, Long long3, String s2, Integer integer, Integer integer1)
    {
        return NetworkPost.a(long1, long2, s, s1, long3, s2, integer, integer1).a(new j() {

            public d a(d d1)
            {
                com.cyberlink.beautycircle.model.database.b.c().a((Post[])d1.b.toArray(new Post[0]));
                return d1;
            }

            public volatile Object a(Object obj)
            {
                return a((d)obj);
            }

        });
    }

    public static j a(Long along[], String s, Long long1, int i, int k)
    {
        return NetworkPost.a(along, s, long1, i, k).a(new j() {

            public d a(d d1)
            {
                com.cyberlink.beautycircle.model.database.b.c().a((Post[])d1.b.toArray(new Post[0]));
                return d1;
            }

            public volatile Object a(Object obj)
            {
                return a((d)obj);
            }

        });
    }

    public void a(Long long1, r r)
    {
        (new AsyncTask(long1, r) {

            final Long a;
            final r b;
            final Post c;

            protected transient Post a(Void avoid[])
            {
                com.cyberlink.beautycircle.model.database.b.c().a(c, a);
                return com.cyberlink.beautycircle.model.database.b.c().a(c.postId.longValue());
            }

            protected void a(Post post)
            {
                if (b != null)
                {
                    b.a(post);
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Post)obj);
            }

            
            {
                c = Post.this;
                a = long1;
                b = r1;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    public void a(boolean flag, r r)
    {
        (new AsyncTask(flag, r) {

            final boolean a;
            final r b;
            final Post c;

            protected transient Post a(Void avoid[])
            {
                com.cyberlink.beautycircle.model.database.b.c().a(c, a);
                return com.cyberlink.beautycircle.model.database.b.c().a(c.postId.longValue());
            }

            protected void a(Post post)
            {
                if (b != null)
                {
                    b.a(post);
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Post)obj);
            }

            
            {
                c = Post.this;
                a = flag;
                b = r1;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    public Uri b()
    {
        FileMetadata filemetadata = c();
        if (filemetadata != null)
        {
            return filemetadata.originalUrl;
        } else
        {
            return null;
        }
    }

    public Long b_()
    {
        return postId;
    }

    public FileMetadata c()
    {
        Object obj1 = null;
        Object obj2;
        if (attachments == null || attachments.files == null || attachments.files.size() <= 0)
        {
            obj2 = null;
        } else
        {
            Iterator iterator = attachments.files.iterator();
            Object obj = null;
            FileMetadata filemetadata = null;
            while (iterator.hasNext()) 
            {
                obj2 = (PostBase.PostAttachmentFile)iterator.next();
                if (((PostBase.PostAttachmentFile) (obj2)).fileType.equals("PostCover") && ((PostBase.PostAttachmentFile) (obj2)).metadata != null)
                {
                    filemetadata = ((PostBase.PostAttachmentFile) (obj2)).b();
                    obj2 = obj1;
                    obj1 = obj;
                    obj = obj2;
                } else
                if (((PostBase.PostAttachmentFile) (obj2)).fileType.equals("PostCoverOri") && ((PostBase.PostAttachmentFile) (obj2)).metadata != null)
                {
                    obj2 = ((PostBase.PostAttachmentFile) (obj2)).b();
                    obj = obj1;
                    obj1 = obj2;
                } else
                if (((PostBase.PostAttachmentFile) (obj2)).fileType.equals("Photo") && ((PostBase.PostAttachmentFile) (obj2)).metadata != null)
                {
                    obj2 = ((PostBase.PostAttachmentFile) (obj2)).b();
                    obj1 = obj;
                    obj = obj2;
                } else
                {
                    Object obj3 = obj;
                    obj = obj1;
                    obj1 = obj3;
                }
                obj2 = obj1;
                obj1 = obj;
                obj = obj2;
            }
            obj2 = obj;
            if (obj == null)
            {
                if (filemetadata != null)
                {
                    return filemetadata;
                } else
                {
                    return ((FileMetadata) (obj1));
                }
            }
        }
        return ((FileMetadata) (obj2));
    }

    public Uri d()
    {
        if (attachments != null && attachments.files != null) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return ((Uri) (obj1));
_L2:
        obj1 = attachments.files.iterator();
        Object obj;
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (PostBase.PostAttachmentFile)((Iterator) (obj1)).next();
            if (((PostBase.PostAttachmentFile) (obj)).metadata == null)
            {
                return null;
            }
            obj = ((PostBase.PostAttachmentFile) (obj)).b().redirectUrl;
        } while (obj == null);
        if (((Uri) (obj)).getScheme() == null)
        {
            obj1 = Uri.parse((new StringBuilder()).append("http://").append(((Uri) (obj)).toString()).toString());
            if (obj1 != null)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    String.format(Locale.getDefault(), "add Http scheme, oringal url: (%s), new url (%s)", new Object[] {
                        ((Uri) (obj)).toString(), ((Uri) (obj1)).toString()
                    })
                });
                obj = obj1;
            }
        }
        obj1 = obj;
        if (((Uri) (obj)).toString().isEmpty())
        {
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    public boolean e()
    {
        return sourcePostCreator != null || d() != null;
    }
}
