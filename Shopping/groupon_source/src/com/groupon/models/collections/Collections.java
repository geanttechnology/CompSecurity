// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.collections;

import java.util.List;

public class Collections
{
    public static class Occasion
    {

        public String endTime;
        public String shortName;
        public String startTime;

        public Occasion()
        {
        }
    }

    public static class Wrapper
    {

        public Collections collections;

        public Wrapper()
        {
        }
    }


    public List occasion;

    public Collections()
    {
    }
}
