// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;

class om
    implements android.view.View.OnClickListener
{

    final oj a;

    om(oj oj1)
    {
        a = oj1;
        super();
    }

    public void onClick(View view)
    {
        oj.a(a, oj.d(a) + 90);
        if (oj.e(a))
        {
            oj.b(a, oj.b(a) + 270);
        } else
        {
            oj.b(a, oj.b(a) + 90);
        }
        Log.d(oj.f(a), (new StringBuilder()).append("activitycameranew correctoriention two:").append(oj.b(a)).append(",correctvalue:").append(oj.d(a)).toString());
        oj.c(a).a(oj.b(a));
    }
}
