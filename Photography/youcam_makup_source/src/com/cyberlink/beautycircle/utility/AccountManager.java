// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.gcm.a;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkManager;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.you.u;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            b, DialogUtils, c, a

public class AccountManager
{

    public static boolean a = false;
    public static final String d[] = {
        "en_CA", "zh_CN", "fr_FR", "de_DE", "zh_HK", "ja_JP", "ko_KR", "zh_TW", "en_GB", "en_US", 
        "pt_BR", "others"
    };
    private static AccountManager f = new AccountManager();
    private static Handler g = new Handler(Looper.getMainLooper());
    private static j h = null;
    private static j i = null;
    protected String b;
    protected b c;
    protected HashSet e;

    private AccountManager()
    {
        b = null;
        c = null;
        e = new HashSet();
    }

    public static j a(AccountSource accountsource)
    {
        if (i != null)
        {
            i.a(true);
            i = null;
        }
        i = (new j() {

            protected Boolean a(AccountSource accountsource1)
            {
                if (accountsource1 == null)
                {
                    return Boolean.valueOf(false);
                } else
                {
                    return Boolean.valueOf(Globals.D().edit().putString("AccountSource", accountsource1.toString()).commit());
                }
            }

            protected volatile Object a(Object obj)
            {
                return a((AccountSource)obj);
            }


            private class AccountSource extends Enum
            {

                public static final AccountSource a;
                public static final AccountSource b;
                public static final AccountSource c;
                public static final AccountSource d;
                public static final AccountSource e;
                public static final AccountSource f;
                private static final AccountSource g[];

                public static AccountSource valueOf(String s)
                {
                    return (AccountSource)Enum.valueOf(com/cyberlink/beautycircle/utility/AccountManager$AccountSource, s);
                }

                public static AccountSource[] values()
                {
                    return (AccountSource[])g.clone();
                }

                static 
                {
                    a = new AccountSource("EMAIL", 0);
                    b = new AccountSource("FACEBOOK", 1);
                    c = new AccountSource("WEIBO", 2);
                    d = new AccountSource("WECHAT", 3);
                    e = new AccountSource("QQ", 4);
                    f = new AccountSource("TWITTER", 5);
                    g = (new AccountSource[] {
                        a, b, c, d, e, f
                    });
                }

                private AccountSource(String s, int i1)
                {
                    super(s, i1);
                }
            }

        }).d(accountsource);
        return i;
    }

    public static j a(String s, UserInfo userinfo, com.cyberlink.beautycircle.utility.c c1, boolean flag)
    {
        if (h != null)
        {
            h.a(true);
            h = null;
        }
        h = (new j(userinfo, s, c1, flag) {

            final UserInfo a;
            final String b;
            final com.cyberlink.beautycircle.utility.c c;
            final boolean d;

            protected Boolean a(Void void1)
            {
                if (a == null || b == null || b.isEmpty())
                {
                    return Boolean.valueOf(false);
                }
                boolean flag1;
                if (AccountManager.b(a.region) && a.region != null)
                {
                    void1 = a.region;
                    NetworkUser.a(b, null, null, null, null, null, void1, null, null, null, null, null, null, null).a(new m(this, void1) {

                        final String a;
                        final _cls2 b;

                        protected void a(int i1)
                        {
                            com.perfectcorp.utility.e.e(new Object[] {
                                "Set default locale fail: ", Integer.valueOf(i1)
                            });
                            Globals.b((new StringBuilder()).append("Set default locale fail: ").append(i1).toString());
                            if (b.c != null && i1 == 420)
                            {
                                b.c.b();
                            }
                        }

                        protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                        {
                            com.perfectcorp.utility.e.c(new Object[] {
                                "Set default locale to: ", a
                            });
                            Globals.b((new StringBuilder()).append("Set default locale to: ").append(a).toString());
                            if (b.c != null)
                            {
                                b.c.a();
                            }
                        }

                        protected void b(Object obj)
                        {
                            a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
                        }

            
            {
                b = _pcls2;
                a = s;
                super();
            }
                    });
                    flag1 = true;
                } else
                {
                    void1 = AccountManager.d();
                    Date date;
                    if (void1 != null)
                    {
                        void1 = ((UserInfo) (void1)).lastModified;
                    } else
                    {
                        void1 = null;
                    }
                    if (a != null)
                    {
                        date = a.lastModified;
                    } else
                    {
                        date = null;
                    }
                    if (void1 != null && date != null && void1.getTime() != date.getTime() || void1 == null && date != null || void1 != null && date == null)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                }
                if (d)
                {
                    com.cyberlink.beautycircle.utility.AccountManager.a(b, a);
                } else
                {
                    AccountManager.b(a);
                }
                AccountManager.o().b = b;
                if (Globals.m())
                {
                    u.a(Globals.n(), b);
                }
                Globals.D().edit().putString("AccountToken", b).putString("UserInfo", a.toString()).commit();
                if (!com.cyberlink.beautycircle.utility.AccountManager.a)
                {
                    AccountManager.d(b);
                }
                if (flag1)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "dispatchAccountInfoChangeEvent"
                    });
                    AccountManager.o().a(a);
                }
                return Boolean.valueOf(true);
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                a = userinfo;
                b = s;
                c = c1;
                d = flag;
                super();
            }
        }).d(null);
        return h;
    }

    public static j a(String s, UserInfo userinfo, boolean flag)
    {
        return a(s, userinfo, null, flag);
    }

    public static j a(boolean flag, boolean flag1, String s)
    {
        return (new j(flag, s, flag1) {

            final boolean a;
            final String b;
            final boolean c;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                AccountManager.p();
                if (a)
                {
                    AccountManager.b(b, AccountManager.o().b);
                }
                AccountManager.o().b = null;
                BCTileImage.a();
                UserInfo userinfo = new UserInfo();
                String s2 = Locale.getDefault().toString();
                String s1 = s2;
                void1 = userinfo;
                if (c)
                {
                    s1 = s2;
                    void1 = userinfo;
                    if (AccountManager.l())
                    {
                        s1 = s2;
                        void1 = userinfo;
                        if (AccountManager.o().b != null)
                        {
                            s1 = com.cyberlink.beautycircle.utility.AccountManager.a();
                            void1 = AccountManager.d();
                        }
                    }
                }
                NetworkManager.a(s1);
                AccountManager.o().a(void1);
                return null;
            }

            
            {
                a = flag;
                b = s;
                c = flag1;
                super();
            }
        }).d(null);
    }

    public static String a()
    {
        UserInfo userinfo = d();
        if (userinfo != null && userinfo.region != null)
        {
            return userinfo.region;
        } else
        {
            return Locale.getDefault().toString();
        }
    }

    public static void a(Activity activity, int i1, b b1)
    {
        if (activity != null)
        {
            if (f.b != null || b() != null)
            {
                b1.a(f.b);
                return;
            }
            f.c = b1;
            if (activity != null)
            {
                com.cyberlink.beautycircle.c.a(activity, i1, 0, 0);
                return;
            }
        }
    }

    public static void a(Context context, b b1)
    {
        if (b() != null)
        {
            b1.a(f.b);
            return;
        }
        f.c = b1;
        if (context == null)
        {
            com.cyberlink.beautycircle.c.b(Globals.n());
            return;
        } else
        {
            com.cyberlink.beautycircle.utility.DialogUtils.a((Activity)context, new Runnable() {

                public void run()
                {
                    AccountManager.i();
                }

            });
            return;
        }
    }

    public static void a(com.cyberlink.beautycircle.utility.a a1)
    {
        if (a1 != null)
        {
            f.e.add(a1);
        }
    }

    static void a(String s, UserInfo userinfo)
    {
        b(s, userinfo);
    }

    public static boolean a(Integer integer, Integer integer1)
    {
        UserInfo userinfo;
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        userinfo = d();
        if (userinfo != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
label0:
        {
            flag = flag1;
            if (integer == null)
            {
                break label0;
            }
            if (userinfo.followerCount != null)
            {
                flag = flag1;
                if (userinfo.followerCount == integer)
                {
                    break label0;
                }
            }
            userinfo.followerCount = integer;
            flag = true;
        }
label1:
        {
            flag1 = flag;
            if (integer1 == null)
            {
                break label1;
            }
            if (userinfo.followingCount != null)
            {
                flag1 = flag;
                if (userinfo.followingCount == integer1)
                {
                    break label1;
                }
            }
            userinfo.followingCount = integer1;
            flag1 = true;
        }
        flag = flag1;
        if (flag1)
        {
            Globals.D().edit().putString("UserInfo", userinfo.toString()).commit();
            return flag1;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String as[] = d;
        int j1 = as.length;
        int i1 = 0;
        do
        {
            if (i1 < j1)
            {
label0:
                {
                    String s1 = as[i1];
                    if (!s1.equalsIgnoreCase(s))
                    {
                        break label0;
                    }
                    if (!s1.equalsIgnoreCase("others"))
                    {
                        return true;
                    }
                }
            }
            if (true)
            {
                continue;
            }
            i1++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean a(String s, String s1)
    {
        if (a(s))
        {
            return s.equalsIgnoreCase(s1);
        }
        return !a(s1);
    }

    public static String b()
    {
        if (f.b == null)
        {
            SharedPreferences sharedpreferences = Globals.D();
            f.b = sharedpreferences.getString("AccountToken", null);
        }
        if (f.b == null)
        {
            m();
        }
        return f.b;
    }

    static void b(UserInfo userinfo)
    {
        c(userinfo);
    }

    public static void b(com.cyberlink.beautycircle.utility.a a1)
    {
        f.e.remove(a1);
    }

    private static void b(String s, UserInfo userinfo)
    {
    }

    static void b(String s, String s1)
    {
        c(s, s1);
    }

    public static boolean b(String s)
    {
        boolean flag = false;
        if (!a(s)) goto _L2; else goto _L1
_L1:
        if (!a(a(), s))
        {
            NetworkManager.a(s);
            flag = true;
        }
        return flag;
_L2:
        String s1 = Locale.getDefault().toString();
        s = s1;
        if (a(s1))
        {
            s = "others";
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static Long c()
    {
        UserInfo userinfo = d();
        if (userinfo == null)
        {
            return null;
        } else
        {
            return Long.valueOf(userinfo.id);
        }
    }

    private static void c(UserInfo userinfo)
    {
    }

    private static void c(String s, String s1)
    {
    }

    public static boolean c(String s)
    {
        if (s == null || s.isEmpty())
        {
            return false;
        } else
        {
            Globals.D().edit().putString("UserEmail", s).apply();
            return true;
        }
    }

    public static UserInfo d()
    {
        UserInfo userinfo = null;
        String s = Globals.D().getString("UserInfo", null);
        if (s != null)
        {
            userinfo = (UserInfo)Model.a(com/cyberlink/beautycircle/model/UserInfo, s);
        }
        return userinfo;
    }

    public static void d(String s)
    {
        a = false;
        if (g != null)
        {
            g.post(new Runnable(s) {

                final String a;

                public void run()
                {
                    if (AccountManager.o().c != null)
                    {
                        AccountManager.o().c.a(a);
                        AccountManager.o().c = null;
                    }
                }

            
            {
                a = s;
                super();
            }
            });
        }
    }

    public static String e()
    {
        return Globals.D().getString("UserEmail", "");
    }

    public static AccountSource f()
    {
        String s = Globals.D().getString("AccountSource", null);
        if (s == null)
        {
            return null;
        } else
        {
            return AccountSource.valueOf(s);
        }
    }

    public static String g()
    {
        String s1 = Globals.D().getString("AccountSource", null);
        String s;
        if (s1 == null)
        {
            s = null;
        } else
        {
            s = s1;
            if (s1.equals(com.cyberlink.beautycircle.utility.AccountSource.a.toString()))
            {
                return "CL ACCOUNT";
            }
        }
        return s;
    }

    public static void h()
    {
        if (g != null)
        {
            g.post(new Runnable() {

                public void run()
                {
                    if (AccountManager.o().c != null)
                    {
                        AccountManager.o().c.a();
                        AccountManager.o().c = null;
                    }
                }

            });
        }
    }

    public static void i()
    {
        if (g != null)
        {
            g.post(new Runnable() {

                public void run()
                {
                    if (AccountManager.o().c != null)
                    {
                        AccountManager.o().c.b();
                        AccountManager.o().c = null;
                    }
                }

            });
        }
    }

    public static String j()
    {
        return com.cyberlink.beautycircle.controller.gcm.a.c(Globals.n().getApplicationContext());
    }

    public static String k()
    {
        String s = e();
        if (s == null || s.isEmpty())
        {
            return "";
        } else
        {
            return s.split("[@.]")[0];
        }
    }

    public static boolean l()
    {
        return false;
    }

    public static boolean m()
    {
        return false;
    }

    public static boolean n()
    {
        return !a().equalsIgnoreCase("pt_BR");
    }

    static AccountManager o()
    {
        return f;
    }

    static void p()
    {
        q();
    }

    private static void q()
    {
        Globals.D().edit().remove("AccountToken").remove("UserInfo").remove("UserEmail").remove("AccountSource").commit();
    }

    protected void a(UserInfo userinfo)
    {
        if (g != null)
        {
            g.post(new Runnable(userinfo) {

                final UserInfo a;
                final AccountManager b;

                public void run()
                {
                    for (Iterator iterator = b.e.iterator(); iterator.hasNext(); ((com.cyberlink.beautycircle.utility.a)iterator.next()).a(a)) { }
                }

            
            {
                b = AccountManager.this;
                a = userinfo;
                super();
            }
            });
        }
    }

}
