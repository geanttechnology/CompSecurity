// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.io.PrintStream;

public final class Version
{

    private static final String TITLE = "Twitter4J";
    private static final String VERSION = "3.0.6-SNAPSHOT";

    private Version()
    {
        throw new AssertionError();
    }

    public static String getVersion()
    {
        return "3.0.6-SNAPSHOT";
    }

    public static void main(String args[])
    {
        System.out.println("Twitter4J 3.0.6-SNAPSHOT");
    }
}
