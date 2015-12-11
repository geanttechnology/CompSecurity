// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.is;
import android.support.v7.iu;
import android.support.v7.iv;
import android.widget.Toast;
import com.abtnprojects.ambatana.models.user.UserEntity;
import com.abtnprojects.ambatana.ui.activities.CategoryListingActivity;
import com.abtnprojects.ambatana.ui.activities.ContactActivity;
import com.abtnprojects.ambatana.ui.activities.HelpActivity;
import com.abtnprojects.ambatana.ui.activities.ProductListingActivity;
import com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity;
import com.abtnprojects.ambatana.ui.activities.chat.UserMessagesListActivity;
import com.abtnprojects.ambatana.ui.activities.profile.EditProfileActivity;
import com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity;
import com.abtnprojects.ambatana.ui.signup.MainSignUpActivity;
import com.parse.ParseUser;

public class b
{

    private final DrawerLayout a;
    private Activity b;
    private UserEntity c;

    public b(DrawerLayout drawerlayout, Activity activity)
    {
        c = new UserEntity();
        b = activity;
        a = drawerlayout;
    }

    private void a()
    {
        Intent intent = new Intent(b, com/abtnprojects/ambatana/ui/activities/chat/UserMessagesListActivity);
        b.startActivity(intent);
        i();
    }

    private void a(ParseUser parseuser)
    {
        if (iu.c(parseuser))
        {
            c(parseuser);
            return;
        } else
        {
            a("list");
            return;
        }
    }

    private void a(String s)
    {
        Intent intent = new Intent(b, com/abtnprojects/ambatana/ui/signup/MainSignUpActivity);
        Bundle bundle = new Bundle();
        bundle.putString("login_type", s);
        intent.putExtras(bundle);
        b.startActivityForResult(intent, 537);
        i();
    }

    private void b()
    {
        Intent intent = new Intent(b, com/abtnprojects/ambatana/ui/activities/HelpActivity);
        b.startActivity(intent);
        i();
    }

    private void b(ParseUser parseuser)
    {
        if (b instanceof UserProfileActivity)
        {
            i();
            return;
        }
        if (iu.c(parseuser))
        {
            c(parseuser);
            return;
        } else
        {
            a("view-profile");
            return;
        }
    }

    private void c()
    {
        Intent intent = new Intent(b, com/abtnprojects/ambatana/ui/activities/profile/EditProfileActivity);
        b.startActivityForResult(intent, 5);
        i();
    }

    private void c(ParseUser parseuser)
    {
        Intent intent = new Intent(b, com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity);
        intent.putExtra("user", c.transform(parseuser));
        b.startActivity(intent);
        i();
    }

    private void d()
    {
        if (b instanceof CategoryListingActivity)
        {
            i();
            return;
        } else
        {
            e();
            return;
        }
    }

    private void d(ParseUser parseuser)
    {
        if (b instanceof MessagesActivity)
        {
            i();
            return;
        }
        if (iu.c(parseuser))
        {
            a();
            return;
        } else
        {
            a("messages");
            return;
        }
    }

    private void e()
    {
        Intent intent = new Intent(b, com/abtnprojects/ambatana/ui/activities/CategoryListingActivity);
        b.startActivityForResult(intent, 3);
        i();
    }

    private void e(ParseUser parseuser)
    {
        if (b instanceof EditProfileActivity)
        {
            i();
            return;
        }
        if (iu.c(parseuser))
        {
            c();
            return;
        } else
        {
            a("edit-profile");
            return;
        }
    }

    private void f()
    {
        if (!iv.b(b))
        {
            Toast.makeText(b.getApplicationContext(), b.getString(0x7f090072), 1).show();
            return;
        }
        is.b(b);
        if (b instanceof ProductListingActivity)
        {
            ((ProductListingActivity)b).o();
            i();
            return;
        } else
        {
            g();
            return;
        }
    }

    private void f(ParseUser parseuser)
    {
        if (b instanceof ContactActivity)
        {
            i();
            return;
        } else
        {
            h();
            return;
        }
    }

    private void g()
    {
        Intent intent = new Intent(b, com/abtnprojects/ambatana/ui/activities/ProductListingActivity);
        b.startActivity(intent);
        i();
    }

    private void h()
    {
        b.startActivity(new Intent(b, com/abtnprojects/ambatana/ui/activities/ContactActivity));
        i();
    }

    private void i()
    {
        a.e(0x800003);
    }

    public void a(long l, ParseUser parseuser)
    {
        if (l == 2L)
        {
            a(parseuser);
        } else
        {
            if (l == 3L)
            {
                b(parseuser);
                return;
            }
            if (l == 4L)
            {
                d(parseuser);
                return;
            }
            if (l == 5L)
            {
                e(parseuser);
                return;
            }
            if (l == 6L)
            {
                d();
                return;
            }
            if (l == 7L)
            {
                f();
                return;
            }
            if (l == 8L)
            {
                b();
                return;
            }
            if (l == 9L)
            {
                f(parseuser);
                return;
            }
        }
    }
}
