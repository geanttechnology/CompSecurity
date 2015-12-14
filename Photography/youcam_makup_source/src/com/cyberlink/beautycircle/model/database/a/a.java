// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.database.Contract;
import com.cyberlink.beautycircle.model.database.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;

public class a
{

    private static final String a;
    private final SQLiteDatabase b = com.cyberlink.beautycircle.model.database.b.a();
    private final SQLiteDatabase c = com.cyberlink.beautycircle.model.database.b.b();

    public a()
    {
    }

    public Post a(long l)
    {
        Object obj1;
        String as[] = Contract.Posts.a();
        obj1 = (new StringBuilder()).append(Contract.Posts.postId.b).append("=?").toString();
        obj1 = b.query(false, a, as, ((String) (obj1)), new String[] {
            String.valueOf(l)
        }, null, null, null, null);
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
        e.b(new Object[] {
            "Failed to query: cursor is null"
        });
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        obj = null;
_L4:
        return ((Post) (obj));
_L2:
        obj = obj1;
        if (((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = obj1;
        e.b(new Object[] {
            "Failure of cursor.moveToFirst()."
        });
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        int i = ((Cursor) (obj1)).getColumnIndex(Contract.Posts.postId.b);
        obj = obj1;
        int j = ((Cursor) (obj1)).getColumnIndex(Contract.Posts.lastModified.b);
        obj = obj1;
        int k = ((Cursor) (obj1)).getColumnIndex(Contract.Posts.postJSON.b);
        if (i >= 0 && j >= 0 && k >= 0)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        obj = obj1;
        e.b(new Object[] {
            "cursor.getColumnIndex() returned negative number"
        });
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        Post post = (Post)Model.a(com/cyberlink/beautycircle/model/Post, ((Cursor) (obj1)).getString(k));
        obj = post;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj1)).close();
        return post;
        Exception exception1;
        exception1;
        obj1 = null;
_L8:
        obj = obj1;
        e.b(new Object[] {
            "Exception: ", exception1.getMessage()
        });
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        Exception exception;
        exception;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(Post post)
    {
        String s = (new StringBuilder()).append(Contract.Posts.postId.b).append(" = ?").toString();
        String s1 = String.valueOf(post.postId);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(Contract.Posts.postJSON.b, post.toString());
        c.update(a, contentvalues, s, new String[] {
            s1
        });
    }

    public void a(Post post, Long long1)
    {
        if (post == null || long1 == null)
        {
            return;
        } else
        {
            post.commentCount = long1;
            a(post);
            return;
        }
    }

    public void a(Post post, boolean flag)
    {
        if (post == null)
        {
            return;
        }
        post.isLiked = Boolean.valueOf(flag);
        long l = post.likeCount.longValue();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        post.likeCount = Long.valueOf((long)i + l);
        a(post);
    }

    public void a(Post apost[])
    {
        int j = apost.length;
        for (int i = 0; i < j; i++)
        {
            Post post = apost[i];
            post.postJSON = post.toString();
        }

        Contract.Posts.a(c, apost);
    }

    static 
    {
        a = Contract.Posts.TABLE_NAME;
    }
}
