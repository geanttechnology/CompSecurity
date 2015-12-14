// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response, ViewerUser

public class Stream extends Response
{

    public Date createdAt;
    public String description;
    public long id;
    public ArrayList items;
    public int itemsCount;
    public String title;
    public String type;
    public ViewerUser user;

    public Stream()
    {
    }
}
