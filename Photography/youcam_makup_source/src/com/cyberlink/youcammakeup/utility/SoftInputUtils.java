// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.app.FragmentManager;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.widgetpool.dialogs.g;
import com.cyberlink.youcammakeup.widgetpool.dialogs.m;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            o, bl

public class SoftInputUtils
{

    private static void a(Activity activity, FragmentManager fragmentmanager, int i, String s, bl bl)
    {
        o.a(fragmentmanager, i, s, 9, 0x7f0703fd, 0x7f0703fa, new m(bl, activity) {

            final bl a;
            final Activity b;
            private Toast c;
            private g d;

            private void a()
            {
                if (c != null)
                {
                    c.cancel();
                    c = null;
                }
            }

            public boolean a(View view, String s1)
            {
label0:
                {
                    view = a.a(s1);
                    boolean flag;
                    if (view == CheckResult.c)
                    {
                        a.a(s1);
                        view = a.a();
                        flag = true;
                    } else
                    if (view == CheckResult.b)
                    {
                        view = a.b();
                        flag = false;
                    } else
                    if (view == CheckResult.a)
                    {
                        view = a.c();
                        flag = false;
                    } else
                    {
                        view = null;
                        flag = false;
                    }
                    if (view != null)
                    {
                        if (b != null)
                        {
                            break label0;
                        }
                        a();
                        c = Toast.makeText(Globals.d(), view, 0);
                        c.show();
                    }
                    return flag;
                }
                d.a(b, view, 2000);
                return flag;
            }

            public boolean b(View view, String s1)
            {
                a.a(new Exception("User canceled."));
                return true;
            }

            public boolean c(View view, String s1)
            {
                a.a(new Exception("User canceled."));
                return true;
            }

            
            {
                a = bl1;
                b = activity;
                super();
                c = null;
                d = new g();
            }

            private class CheckResult extends Enum
            {

                public static final CheckResult a;
                public static final CheckResult b;
                public static final CheckResult c;
                private static final CheckResult d[];

                public static CheckResult valueOf(String s)
                {
                    return (CheckResult)Enum.valueOf(com/cyberlink/youcammakeup/utility/SoftInputUtils$CheckResult, s);
                }

                public static CheckResult[] values()
                {
                    return (CheckResult[])d.clone();
                }

                static 
                {
                    a = new CheckResult("NAME_EMPTY", 0);
                    b = new CheckResult("NAME_CONFLICT", 1);
                    c = new CheckResult("NAME_VALID", 2);
                    d = (new CheckResult[] {
                        a, b, c
                    });
                }

                private CheckResult(String s, int i)
                {
                    super(s, i);
                }
            }

        }, null);
    }

    public static void a(Activity activity, FragmentManager fragmentmanager, String s, bl bl)
    {
        a(activity, fragmentmanager, 0x7f070600, s, bl);
    }

    public static void b(Activity activity, FragmentManager fragmentmanager, String s, bl bl)
    {
        a(activity, fragmentmanager, 0x7f0705ff, s, bl);
    }
}
