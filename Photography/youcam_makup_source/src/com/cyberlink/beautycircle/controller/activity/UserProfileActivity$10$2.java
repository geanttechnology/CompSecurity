// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            UserProfileActivity

class a extends j
{

    final a a;

    protected Boolean a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            try
            {
                AccountManager.a(false, true, Globals.c()).d();
            }
            catch (CancellationException cancellationexception)
            {
                cancellationexception.printStackTrace();
                return boolean1;
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
                return boolean1;
            }
            catch (ExecutionException executionexception)
            {
                executionexception.printStackTrace();
                return boolean1;
            }
        }
        return boolean1;
    }

    protected volatile Object a(Object obj)
    {
        return a((Boolean)obj);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$10

/* anonymous class */
    class UserProfileActivity._cls10
        implements Runnable
    {

        final UserProfileActivity a;

        public void run()
        {
            a.k();
            Globals.f().a(new UserProfileActivity._cls10._cls2(this)).a(new UserProfileActivity._cls10._cls1());
        }

            
            {
                a = userprofileactivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$10$1

/* anonymous class */
        class UserProfileActivity._cls10._cls1 extends m
        {

            final UserProfileActivity._cls10 a;

            protected void a(Boolean boolean1)
            {
                a.a.l();
                if (boolean1.booleanValue())
                {
                    a.a.e();
                    Globals.a(String.format(Locale.getDefault(), a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_profile_change_webserver_success), new Object[] {
                        Globals.e()
                    }));
                    return;
                } else
                {
                    Globals.a(String.format(Locale.getDefault(), a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_profile_change_webserver_fail), new Object[] {
                        Globals.e()
                    }));
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

                    
                    {
                        a = UserProfileActivity._cls10.this;
                        super();
                    }
        }

    }

}
