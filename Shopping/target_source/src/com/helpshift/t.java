// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.helpshift.g.a.b;
import com.helpshift.i.c;
import com.helpshift.i.e;
import com.helpshift.i.l;
import com.helpshift.i.u;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            HSConversation, l, s, p, 
//            HSReview, u, HSRetryService, v, 
//            HSFaqs, a, w, m

public final class t
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/helpshift/t$a, s1);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("ALWAYS", 0);
            b = new a("NEVER", 1);
            c = new a("AFTER_VIEWING_FAQS", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s1, int i)
        {
            super(s1, i);
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        private static final b e[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/helpshift/t$b, s1);
        }

        public static b[] values()
        {
            return (b[])e.clone();
        }

        static 
        {
            a = new b("SUCCESS", 0);
            b = new b("FEEDBACK", 1);
            c = new b("CLOSE", 2);
            d = new b("FAIL", 3);
            e = (new b[] {
                a, b, c, d
            });
        }

        private b(String s1, int i)
        {
            super(s1, i);
        }
    }

    public static interface c
    {

        public abstract void a();

        public abstract void a(int i);

        public abstract void a(int i, String s1);

        public abstract void a(File file);

        public abstract void a(String s1);

        public abstract void b();

        public abstract void b(String s1);
    }


    private static com.helpshift.l a = null;
    private static s b = null;
    private static Context c = null;
    private static c d;

    public static c a()
    {
        return d;
    }

    public static void a(Activity activity, HashMap hashmap)
    {
        Intent intent = new Intent(activity, com/helpshift/HSConversation);
        intent.putExtra("decomp", true);
        intent.putExtras(c(hashmap));
        intent.putExtra("showInFullScreen", e.a(activity));
        intent.putExtra("chatLaunchSource", "support");
        intent.putExtra("isRoot", true);
        e.b();
        activity.startActivity(intent);
    }

    private static void a(Application application)
    {
        b(application.getApplicationContext());
    }

    public static void a(Application application, String s1, String s2, String s3, HashMap hashmap)
    {
        a(application);
        d();
        com.helpshift.i.c.b("__hs__db_profiles");
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
        }
        hashmap = a.B();
        Object obj;
        if ((String)hashmap1.get("sdkType") != null)
        {
            b.q((String)hashmap1.get("sdkType"));
        } else
        {
            b.q("android");
        }
        obj = hashmap1.get("notificationIcon");
        if (obj != null && (obj instanceof String))
        {
            obj = (String)obj;
            hashmap1.put("notificationIcon", Integer.valueOf(application.getResources().getIdentifier(((String) (obj)), "drawable", application.getPackageName())));
        }
        obj = hashmap1.get("notificationSound");
        if (obj != null && (obj instanceof String))
        {
            obj = (String)obj;
            hashmap1.put("notificationSound", Integer.valueOf(application.getResources().getIdentifier(((String) (obj)), "raw", application.getPackageName())));
        }
        obj = hashmap1.get("enableDialogUIForTablets");
        if (obj != null && (obj instanceof Boolean))
        {
            hashmap1.put("enableDialogUIForTablets", (Boolean)obj);
        }
        b.Y();
        try
        {
            String s4 = c.getPackageManager().getPackageInfo(c.getPackageName(), 0).versionName;
            if (!b.m().equals(s4))
            {
                a.i();
                a.j();
                b.p(s4);
            }
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.d("HelpShiftDebug", "Application Name Not Found", namenotfoundexception);
        }
        com.helpshift.g.a.b.a(c);
        b.b(new JSONObject(hashmap1));
        b.i(new JSONObject());
        a.a(s1, s2, s3);
        if (!TextUtils.isEmpty(hashmap))
        {
            try
            {
                a.c(new Handler(), new Handler());
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                Log.d("HelpShiftDebug", "Install - Get Latest Issues", s1);
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            s1 = p.a();
            application.unregisterActivityLifecycleCallbacks(s1);
            application.registerActivityLifecycleCallbacks(s1);
            return;
        }
        a.h();
        if (a.f().booleanValue())
        {
            application = new Intent(c, com/helpshift/HSReview);
            application.setFlags(0x10000000);
            c.startActivity(application);
        }
        try
        {
            a.b(new Handler() {

                public void handleMessage(Message message)
                {
                    com.helpshift.g.b.a.b((JSONObject)message.obj);
                    com.helpshift.t.c().a(com.helpshift.t.b().B());
                }

            }, new Handler());
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            Log.d("HelpShiftDebug", application.toString(), application);
        }
        if (u.a(c))
        {
            c.startService(new Intent(c, com/helpshift/HSRetryService));
        }
        a.u();
        a.d();
    }

    private static void a(Context context)
    {
        b(context.getApplicationContext());
    }

    public static void a(Handler handler, Handler handler1)
    {
label0:
        {
label1:
            {
                if (handler == null)
                {
                    break label1;
                }
                if (a == null || b == null)
                {
                    if (v.a() == null)
                    {
                        break label1;
                    }
                    a(v.a());
                }
                Integer integer = b.d(a.B());
                Message message = handler.obtainMessage();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("value", integer.intValue());
                bundle1.putBoolean("cache", true);
                message.obj = bundle1;
                handler.sendMessage(message);
                handler1 = new Handler(handler1) {

                    final Handler a;

                    public void handleMessage(Message message1)
                    {
                        if (a != null)
                        {
                            Message message2 = a.obtainMessage();
                            message2.obj = message1.obj;
                            a.sendMessage(message2);
                        }
                    }

            
            {
                a = handler;
                super();
            }
                };
                if (TextUtils.isEmpty(a.B()))
                {
                    break label0;
                }
                a.e(handler, handler1);
            }
            return;
        }
        handler = handler1.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("value", -1);
        handler.obj = bundle;
        handler1.sendMessage(handler);
    }

    public static void a(m m)
    {
        u.a(m);
        try
        {
            b.c(u.a());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (m m)
        {
            Log.d("HelpShiftDebug", "Exception getting custom meta ", m);
        }
    }

    public static void a(c c1)
    {
        d = c1;
    }

    public static void a(String s1)
    {
        if (s1 != null && !TextUtils.isEmpty(s1.trim()))
        {
            b.r(s1);
        }
    }

    public static void a(String s1, String s2)
    {
        if (s1 == null)
        {
            s1 = "";
        } else
        {
            s1 = s1.trim();
        }
        if (s2 == null)
        {
            s2 = "";
        } else
        {
            s2 = s2.trim();
        }
        if (TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2))
        {
            a.h("");
            a.i("");
        }
        if (!TextUtils.isEmpty(s1) && !l.b(s1))
        {
            a.h(s1);
        }
        if (!TextUtils.isEmpty(s2) && l.a(s2))
        {
            a.i(s2);
        }
    }

    private static void a(HashMap hashmap)
    {
        if (hashmap.containsKey("hs-custom-metadata"))
        {
            a(new m(hashmap) {

                final HashMap a;

                public HashMap a()
                {
                    if (a.get("hs-custom-metadata") instanceof HashMap)
                    {
                        return (HashMap)a.get("hs-custom-metadata");
                    } else
                    {
                        return null;
                    }
                }

            
            {
                a = hashmap;
                super();
            }
            });
        }
    }

    static com.helpshift.l b()
    {
        return a;
    }

    private static HashMap b(HashMap hashmap)
    {
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
        }
        hashmap = new String[2];
        hashmap[0] = "conversationPrefillText";
        hashmap[1] = "showSearchOnNewConversation";
        int j = hashmap.length;
        for (int i = 0; i < j; i++)
        {
            String s1 = hashmap[i];
            hashmap1.remove(s1);
            if (s1.equals("showSearchOnNewConversation"))
            {
                b.g(Boolean.valueOf(false));
            }
        }

        return hashmap1;
    }

    public static void b(Activity activity, HashMap hashmap)
    {
        Intent intent = new Intent(activity, com/helpshift/HSFaqs);
        intent.putExtras(c(b(hashmap)));
        intent.putExtra("showInFullScreen", e.a(activity));
        intent.putExtra("decomp", false);
        intent.putExtra("isRoot", true);
        e.b();
        activity.startActivity(intent);
    }

    private static void b(Context context)
    {
        v.a(context);
        if (c == null)
        {
            a = new com.helpshift.l(context);
            b = a.a;
            com.helpshift.a.a(context);
            w.a(context);
            c = context;
        }
    }

    private static Bundle c(HashMap hashmap)
    {
        boolean flag1 = true;
        com.helpshift.a.a(hashmap);
        Bundle bundle = new Bundle();
        if (hashmap != null)
        {
            a(hashmap);
            hashmap = new JSONObject(hashmap);
            boolean flag = flag1;
            if (!hashmap.optBoolean("gotoCoversationAfterContactUs", false))
            {
                if (hashmap.optBoolean("gotoConversationAfterContactUs", false))
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
            }
            try
            {
                if (hashmap.has("requireEmail"))
                {
                    b.d(Boolean.valueOf(hashmap.getBoolean("requireEmail")));
                }
                if (hashmap.has("hideNameAndEmail"))
                {
                    b.f(Boolean.valueOf(hashmap.getBoolean("hideNameAndEmail")));
                }
                if (hashmap.has("showSearchOnNewConversation"))
                {
                    b.g(Boolean.valueOf(hashmap.getBoolean("showSearchOnNewConversation")));
                }
                if (hashmap.has("enableFullPrivacy"))
                {
                    b.e(Boolean.valueOf(hashmap.getBoolean("enableFullPrivacy")));
                }
            }
            catch (JSONException jsonexception)
            {
                Log.d("HelpShiftDebug", (new StringBuilder()).append("Exception parsing config : ").append(jsonexception).toString());
            }
            b.z(null);
            try
            {
                if (hashmap.has("conversationPrefillText") && !hashmap.getString("conversationPrefillText").equals("null"))
                {
                    if (hashmap.has("hs-custom-metadata"))
                    {
                        bundle.putBoolean("dropMeta", true);
                    }
                    String s1 = hashmap.getString("conversationPrefillText").trim();
                    if (!TextUtils.isEmpty(s1))
                    {
                        b.z(s1);
                    }
                }
            }
            catch (JSONException jsonexception1)
            {
                Log.d("HelpShiftDebug", "JSON exception while parsing config : ", jsonexception1);
            }
            bundle.putBoolean("showConvOnReportIssue", Boolean.valueOf(flag).booleanValue());
            bundle.putBoolean("showSearchOnNewConversation", hashmap.optBoolean("showSearchOnNewConversation", false));
        }
        return bundle;
    }

    static s c()
    {
        return b;
    }

    private static void d()
    {
        String s1 = b.b();
        String s2 = b.H();
        Boolean boolean1 = b.K();
        Boolean boolean2 = b.L();
        Boolean boolean3 = b.O();
        Boolean boolean4 = b.Q();
        JSONObject jsonobject = b.M();
        Float float1 = b.G();
        String s3 = b.l();
        if (s3.length() > 0 && !s3.equals("3.9.1"))
        {
            b.c();
            b.c(s1);
            if (!TextUtils.isEmpty(s2))
            {
                b.x(s2);
            }
            b.d(boolean1);
            b.e(boolean2);
            b.f(boolean3);
            b.g(boolean4);
            b.c(jsonobject);
            b.a(float1);
        }
        b.o("3.9.1");
    }

}
