// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            Creator

public class ProductComment extends Model
{

    public String comment;
    public Creator creator;
    public long id;
    public long lastModified;
    public float rating;

    public ProductComment()
    {
    }
}
