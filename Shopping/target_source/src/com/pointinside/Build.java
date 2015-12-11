// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside;

import java.io.PrintStream;

public class Build
{
    public static class VERSION
    {

        public static final String COMMIT_HASH = "hash";
        public static final String VERSION_LABEL = "4.2.10";
        public static final String VERSION_MAINTENANCE = "10";
        public static final int VERSION_MAJOR = 4;
        public static final int VERSION_MINOR = 2;

        public VERSION()
        {
        }
    }


    public static final boolean DEBUG = false;
    public static final String LIB_NAME = "PIMapsLib";

    public Build()
    {
    }

    public static void main(String args[])
    {
        System.out.println("PIMapsLib 4.2.10");
        System.out.println("Copyright (C) 2009-2015 Point Inside, Inc.");
        System.out.println("All rights reserved.");
    }
}
