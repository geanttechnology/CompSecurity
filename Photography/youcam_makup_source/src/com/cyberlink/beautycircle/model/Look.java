// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;
import java.util.Date;

public class Look extends Model
{

    public Uri attachmentUrl;
    public String description;
    public Long downloadCount;
    public String featureRoomId;
    public Long id;
    public String imageUrls;
    public Date lastModified;
    public Long likeCount;
    public String name;
    public Long postId;
    public Long typeId;
    public Long userId;

    public Look()
    {
    }

    public Long b_()
    {
        return id;
    }
}
