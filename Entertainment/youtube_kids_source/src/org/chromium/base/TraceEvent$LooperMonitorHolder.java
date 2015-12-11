// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;


// Referenced classes of package org.chromium.base:
//            CommandLine

final class itor
{

    private static final a a;

    static itor a()
    {
        return a;
    }

    static 
    {
        Object obj;
        if (CommandLine.b().a("enable-idle-tracing"))
        {
            obj = new itor();
        } else
        {
            obj = new init>();
        }
        a = ((a) (obj));
    }

    private itor()
    {
    }
}
