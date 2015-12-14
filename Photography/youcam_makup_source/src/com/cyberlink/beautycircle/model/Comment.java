// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            Creator, Tags

public class Comment extends Model
{

    public String comment;
    public long commentId;
    public Creator creator;
    public boolean isLiked;
    public Date lastModified;
    public long likeCount;
    public Tags tags;

    public Comment()
    {
        commentId = -1L;
        creator = null;
        lastModified = null;
        comment = null;
        isLiked = false;
        likeCount = -1L;
        tags = null;
    }
}
