// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            hf, gi

public class he extends hf
{

    public he(gi gi, ParseUser parseuser)
    {
        super(gi, parseuser);
    }

    public void a(Context context)
    {
        b(context, "dummy-profile-edit-start", a());
    }

    public void b(Context context)
    {
        a(context, "dummy-profile-edit-abandon", a());
    }

    public void c(Context context)
    {
        a(context, "dummy-profile-edit-edit-name", a());
    }

    public void d(Context context)
    {
        a(context, "dummy-profile-edit-picture", a());
    }

    public void e(Context context)
    {
        a(context, "dummy-logout", a());
    }

    public void f(Context context)
    {
        a(context, "dummy-profile-edit-edit-distance", b());
    }

    public void g(Context context)
    {
        a(context, "dummy-profile-edit-edit-distance", c());
    }

    public void h(Context context)
    {
        a(context, "dummy-profile-edit-edit-location", e());
    }

    public void i(Context context)
    {
        a(context, "dummy-profile-edit-edit-location", d());
    }
}
