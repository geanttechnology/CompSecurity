// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            CircleBasic

public class CircleDetail extends CircleBasic
{

    public String creatorName;
    public Long followerCount;
    public Boolean isEditable;
    public Boolean isFollowed;
    public Long postCount;
    public ArrayList postThumbnails;

    public CircleDetail()
    {
    }

    public Long b_()
    {
        return id;
    }
}
