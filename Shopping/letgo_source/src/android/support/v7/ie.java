// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity;
import com.abtnprojects.ambatana.ui.signup.MainSignUpActivity;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            iu

public class ie
{

    private final Activity a;

    public ie(Activity activity)
    {
        a = activity;
    }

    public void a()
    {
        if (a == null)
        {
            return;
        }
        if (iu.c(ParseUser.getCurrentUser()))
        {
            Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/posting/ProductNewActivity);
            a.startActivity(intent);
            return;
        } else
        {
            Intent intent1 = new Intent(a, com/abtnprojects/ambatana/ui/signup/MainSignUpActivity);
            Bundle bundle = new Bundle();
            bundle.putString("login_type", "posting");
            intent1.putExtras(bundle);
            a.startActivityForResult(intent1, 537);
            return;
        }
    }
}
