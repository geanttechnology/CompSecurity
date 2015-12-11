// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class gf
{

    public static void a(Context context, String s)
    {
        (new gz(context)).a("EP_CONTEXT_ID", s);
    }

    public static boolean a(Context context)
    {
        return (new gz(context)).b("EP_CONTEXT_ID") != null;
    }

    public static String b(Context context)
    {
        return (new gz(context)).b("EP_CONTEXT_ID");
    }
}
