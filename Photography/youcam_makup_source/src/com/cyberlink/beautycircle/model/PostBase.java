// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            Tags

public abstract class PostBase extends Model
{

    public PostAttachments attachments;
    public Long circleInCount;
    public Long commentCount;
    public String content;
    public String extLookUrl;
    public Boolean isLiked;
    public Date lastModified;
    public Long likeCount;
    public Tags tags;

    public PostBase()
    {
    }
}
