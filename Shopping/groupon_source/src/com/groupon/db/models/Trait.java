// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Option

public class Trait
{

    public String name;
    public Option parentOption;
    public String position;
    public Long primaryKey;
    public String value;

    public Trait()
    {
        name = "";
        position = "";
        value = "";
    }
}
