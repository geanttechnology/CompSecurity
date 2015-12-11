// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.json.JSONArray;

// Referenced classes of package a.a:
//            bd, be, ah, cn

public final class br
    implements bd
{

    private JSONArray a;

    public br()
    {
        a = null;
        be.c();
        be.d();
        if (be.c().a)
        {
            a = be.d().a();
        }
    }

    public final String a()
    {
        return "logcat";
    }

    public final volatile Object b()
    {
        return a;
    }
}
