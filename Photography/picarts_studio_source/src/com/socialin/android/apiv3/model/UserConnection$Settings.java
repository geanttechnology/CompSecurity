// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;


// Referenced classes of package com.socialin.android.apiv3.model:
//            UserConnection

public class actionAll
{

    public boolean actionAdd;
    public boolean actionAll;
    public boolean actionComment;
    public boolean actionFollow;
    public boolean actionLike;
    final UserConnection this$0;

    public ()
    {
        this$0 = UserConnection.this;
        super();
        actionFollow = true;
        actionAdd = true;
        actionComment = true;
        actionLike = true;
        actionAll = true;
    }
}
