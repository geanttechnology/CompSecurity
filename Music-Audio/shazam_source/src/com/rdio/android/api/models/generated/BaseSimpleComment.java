// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.api.models.generated;

import com.rdio.android.api.models.ApiModel;
import java.util.List;

public class BaseSimpleComment extends ApiModel
{

    public boolean canDelete;
    public boolean canEdit;
    public String comment;
    public String commentHtml;
    public ApiModel commentedItem;
    public List comments;
    public String dateLastEdited;
    public String datePosted;
    public boolean isReply;
    public boolean liked;
    public List likes;
    public int replyCount;
    public String url;

    public BaseSimpleComment()
    {
    }
}
