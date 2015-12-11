// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;

import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ums:
//            Metadata

public static class Value
{
    public static class Value
    {

        public Relationships relationships;
        public String value;

        public Value()
        {
        }
    }

    public static class Value.Relationships
    {

        public ArrayList relationship;

        public Value.Relationships()
        {
        }
    }

    public static class Value.Relationships.Relationship
    {

        public String parentName;
        public String parentValue;

        public Value.Relationships.Relationship()
        {
        }
    }


    public ArrayList tagValue;

    public Value()
    {
    }
}
