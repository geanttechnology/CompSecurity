// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            at, gh

public class hh
{

    private final gh a;
    private final ParseUser b;

    public hh(gh gh1, ParseUser parseuser)
    {
        a = gh1;
        b = parseuser;
    }

    public void a(Context context)
    {
        a(context, "app-rating-start");
    }

    protected void a(Context context, String s)
    {
        a.b(context, s, new at(1), b);
    }

    public void b(Context context)
    {
        b(context, "app-rating-rate");
    }

    protected void b(Context context, String s)
    {
        a.a(context, s, new at(1), b);
    }

    public void c(Context context)
    {
        b(context, "app-rating-suggest");
    }

    public void d(Context context)
    {
        b(context, "app-rating-dont-ask");
    }
}
