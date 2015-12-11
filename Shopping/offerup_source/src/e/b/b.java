// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.b;


final class b extends RuntimeException
{

    private static String a = "Chain of Causes for CompositeException In Order Received =>";

    b()
    {
    }

    public final String getMessage()
    {
        return a;
    }

}
