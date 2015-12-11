// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.a;

import android.app.Application;
import android.content.Context;

// Referenced classes of package android.support.a:
//            a

public class d extends Application
{

    public d()
    {
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
        a.a(this);
    }
}
