// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;

import com.socialin.android.apiv3.model.Adress;

// Referenced classes of package com.socialin.android.apiv3.request:
//            ParamWithItemId

public class UpdateItemParams extends ParamWithItemId
{

    public Adress address;
    public String desc;
    public int isMature;
    public int isPublic;
    public String tags;
    public String title;

    public UpdateItemParams()
    {
        isPublic = -1;
    }
}
