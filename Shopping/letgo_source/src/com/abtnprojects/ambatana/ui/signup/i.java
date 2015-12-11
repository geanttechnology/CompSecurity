// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.abtnprojects.ambatana.a;
import com.abtnprojects.ambatana.ui.activities.HelpActivity;
import com.abtnprojects.ambatana.ui.activities.ProductListingActivity;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            ForgotPasswordActivity

public class i
{

    private final Activity a;

    public i(Activity activity)
    {
        a = activity;
    }

    public void a()
    {
        com.abtnprojects.ambatana.a.a(a).b();
        Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/ProductListingActivity);
        intent.setFlags(0x10008000);
        a.startActivity(intent);
    }

    void a(Intent intent)
    {
        if (intent == null)
        {
            intent = a;
            Activity activity = a;
            intent.setResult(-1);
        } else
        {
            Activity activity1 = a;
            Activity activity2 = a;
            activity1.setResult(-1, intent);
        }
        a.finish();
    }

    void a(Class class1, String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("login_type", s);
        bundle.putString("product_id", s1);
        class1 = new Intent(a, class1);
        class1.putExtras(bundle);
        a.startActivityForResult(class1, 537);
    }

    void b()
    {
        Activity activity = a;
        Activity activity1 = a;
        activity.setResult(0);
        a.finish();
    }

    void c()
    {
        Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/signup/ForgotPasswordActivity);
        a.startActivityForResult(intent, 536);
    }

    public void d()
    {
        a.startActivity(new Intent(a, com/abtnprojects/ambatana/ui/activities/HelpActivity));
    }
}
