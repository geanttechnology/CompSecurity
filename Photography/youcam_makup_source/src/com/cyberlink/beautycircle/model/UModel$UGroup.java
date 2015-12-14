// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;

public class e extends Model
{

    public Uri avatar1;
    public Uri avatar2;
    public String displayName;
    public Long groupId;
    public String groupSubType;
    public String groupType;
    public e lastMsg;
    public Integer numberOfMember;
    public Integer unread;

    public Long b_()
    {
        return groupId;
    }

    public e()
    {
    }
}
