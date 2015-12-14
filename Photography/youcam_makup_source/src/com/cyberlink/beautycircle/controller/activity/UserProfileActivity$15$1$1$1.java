// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.ba;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.c;
import com.cyberlink.beautycircle.utility.i;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            UserProfileActivity

class a
    implements c
{

    final a a;

    public void a()
    {
    }

    public void b()
    {
        UserProfileActivity.a(a.a.a.a, 48258);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$15

/* anonymous class */
    class UserProfileActivity._cls15
        implements android.view.View.OnClickListener
    {

        final UserProfileActivity a;

        public void onClick(View view)
        {
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist1 = new ArrayList();
            String as[] = AccountManager.d;
            int l1 = as.length;
            int i1 = 0;
            int l = 0;
            int k = 0;
            int j = 0;
            while (i1 < l1) 
            {
                Object obj = as[i1];
                view = ((View) (obj));
                if (((String) (obj)).length() < 5)
                {
                    view = Locale.getDefault().toString();
                }
                int j1;
                if (view.equalsIgnoreCase("others"))
                {
                    arraylist.add(a.getResources().getString(m.bc_user_profile_other_country));
                } else
                {
                    arraylist.add(i.b(view));
                }
                arraylist1.add(view);
                if (AccountManager.a().equals(view))
                {
                    j = 1;
                    l = k;
                } else
                {
                    int k1 = j;
                    j = l;
                    l = k1;
                }
                j1 = i1 + 1;
                k++;
                i1 = l;
                l = j;
                j = i1;
                i1 = j1;
            }
            if (l == 0)
            {
                j = AccountManager.d.length - 1;
            }
            view = (String[])arraylist.toArray(new String[arraylist.size()]);
            obj = new android.app.AlertDialog.Builder(a);
            ((android.app.AlertDialog.Builder) (obj)).setTitle(m.bc_user_profile_country_title);
            ((android.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(view, j, new UserProfileActivity._cls15._cls1(this, arraylist1, arraylist));
            UserProfileActivity.a(a, ((android.app.AlertDialog.Builder) (obj)).show());
            Globals.a(com.cyberlink.beautycircle.controller.activity.UserProfileActivity.b(a), a.getResources().getColor(g.bc_color_main_style));
        }

            
            {
                a = userprofileactivity;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$15$1

/* anonymous class */
    class UserProfileActivity._cls15._cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final ArrayList a;
        final ArrayList b;
        final UserProfileActivity._cls15 c;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (com.cyberlink.beautycircle.controller.activity.UserProfileActivity.b(c.a) != null)
            {
                com.cyberlink.beautycircle.controller.activity.UserProfileActivity.b(c.a).dismiss();
                UserProfileActivity.a(c.a, null);
            }
            (new UserProfileActivity._cls15._cls1._cls2(i, new UserProfileActivity._cls15._cls1._cls1(this, i))).executeOnExecutor(j.q, new Void[0]);
        }

            
            {
                c = _pcls15;
                a = arraylist;
                b = arraylist1;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$15$1$2

/* anonymous class */
        class UserProfileActivity._cls15._cls1._cls2 extends AsyncTask
        {

            final int a;
            final AsyncTask b;
            final UserProfileActivity._cls15._cls1 c;

            protected transient Void a(Void avoid[])
            {
                avoid = AccountManager.d();
                String s = (String)c.a.get(a);
                if (((UserInfo) (avoid)).region.equals(s) || s.equals("others") && !AccountManager.a(((UserInfo) (avoid)).region))
                {
                    return null;
                } else
                {
                    com.perfectcorp.a.b.a(new ba());
                    String s1 = c.c.a.getResources().getString(m.bc_user_edit_confirm_locale_change);
                    DialogUtils.a(c.c.a, "", String.format(Locale.getDefault(), s1, new Object[] {
                        c.b.get(a)
                    }), null, null, c.c.a.getResources().getString(m.bc_dialog_button_ok), new UserProfileActivity._cls15._cls1._cls2._cls1(this, avoid));
                    return null;
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

                    
                    {
                        c = UserProfileActivity._cls15._cls1.this;
                        a = i;
                        b = asynctask;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$15$1$2$1

/* anonymous class */
        class UserProfileActivity._cls15._cls1._cls2._cls1
            implements Runnable
        {

            final UserInfo a;
            final UserProfileActivity._cls15._cls1._cls2 b;

            public void run()
            {
                b.b.executeOnExecutor(j.q, new UserInfo[] {
                    a
                });
            }

                    
                    {
                        b = _pcls2;
                        a = userinfo;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$15$1$1

/* anonymous class */
    class UserProfileActivity._cls15._cls1._cls1 extends AsyncTask
    {

        final int a;
        final UserProfileActivity._cls15._cls1 b;

        protected transient Void a(UserInfo auserinfo[])
        {
            if (auserinfo.length >= 1 && auserinfo[0] != null)
            {
                auserinfo = auserinfo[0];
                String s = AccountManager.b();
                String s1 = (String)b.a.get(a);
                b.c.a.k();
                if (auserinfo != null)
                {
                    auserinfo.region = s1;
                    try
                    {
                        AccountManager.a(s, auserinfo, new UserProfileActivity._cls15._cls1._cls1._cls1(this), false).d();
                    }
                    // Misplaced declaration of an exception variable
                    catch (UserInfo auserinfo[])
                    {
                        auserinfo.printStackTrace();
                        return null;
                    }
                    // Misplaced declaration of an exception variable
                    catch (UserInfo auserinfo[])
                    {
                        auserinfo.printStackTrace();
                        return null;
                    }
                    // Misplaced declaration of an exception variable
                    catch (UserInfo auserinfo[])
                    {
                        auserinfo.printStackTrace();
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }

        protected void a(Void void1)
        {
            b.c.a.l();
            com.cyberlink.beautycircle.controller.activity.UserProfileActivity.c(b.c.a);
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((UserInfo[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Void)obj);
        }

            
            {
                b = _pcls1;
                a = i;
                super();
            }
    }

}
