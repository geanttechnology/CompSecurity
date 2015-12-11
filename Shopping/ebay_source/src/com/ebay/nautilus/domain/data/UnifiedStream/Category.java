// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import com.ebay.nautilus.domain.data.cos.base.Text;

public class Category
{
    public static final class Destination extends Enum
    {

        private static final Destination $VALUES[];
        public static final Destination ALLCATEGORIES;
        public static final Destination SRP;

        public static Destination valueOf(String s)
        {
            return (Destination)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Category$Destination, s);
        }

        public static Destination[] values()
        {
            return (Destination[])$VALUES.clone();
        }

        static 
        {
            SRP = new Destination("SRP", 0);
            ALLCATEGORIES = new Destination("ALLCATEGORIES", 1);
            $VALUES = (new Destination[] {
                SRP, ALLCATEGORIES
            });
        }

        private Destination(String s, int i)
        {
            super(s, i);
        }
    }


    public Destination destination;
    public String id;
    public boolean leafCategory;
    public int level;
    public Text name;

    public Category()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("Category(").append(id).append(",").append(name.content).append(",").append(level).append(",").append(leafCategory).append(")").toString();
    }
}
