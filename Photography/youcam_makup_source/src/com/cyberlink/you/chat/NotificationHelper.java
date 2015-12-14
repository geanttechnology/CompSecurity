// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.cyberlink.you.activity.ChatDialogActivity;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.friends.p;
import com.cyberlink.you.g;
import com.cyberlink.you.n;
import com.cyberlink.you.r;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.ULogUtility;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.utility.h;
import com.cyberlink.you.utility.q;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.chat:
//            b, a

public class NotificationHelper
{

    private static q a;

    public static int a(Context context, Group group)
    {
        if (a == null)
        {
            a = new q(context, "NotificationIdMapPref", 0);
        }
        int j = a.a(String.valueOf(group.b), -1);
        int i = j;
        if (j == -1)
        {
            i = b();
            a.b(String.valueOf(group.b), i);
        }
        return i;
    }

    static Uri a(boolean flag)
    {
        return c(flag);
    }

    public static HasNotifiedResultType a(String s, boolean flag)
    {
        return HasNotifiedResultType.a;
    }

    static String a(Context context, b b1, Group group, Friend friend)
    {
        return b(context, b1, group, friend);
    }

    public static void a(Group group, b b1, String s)
    {
        Object obj = b1.toString();
        ULogUtility.d(s, (new StringBuilder()).append("Call NotificationHelper.sendChatNotificaiton. Message = ").append(((String) (obj))).toString());
        if (!com.cyberlink.you.utility.d.f())
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] Notificaion is disable.").toString());
            ULogUtility.d(s, "Notificaion is disable.");
            return;
        }
        if (group.j)
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] Group notificaion is disable. groupId = ").append(group.b).toString());
            ULogUtility.d(s, (new StringBuilder()).append("Group notificaion is disable. groupId = ").append(group.b).toString());
            return;
        }
        if (b1.k().before(g.a().q()))
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] Not notify (Message time is < Registration Time). Message = ").append(((String) (obj))).toString());
            ULogUtility.d(s, (new StringBuilder()).append("Not notify (Message time is < Registration Time). Message = ").append(((String) (obj))).toString());
            return;
        }
        Object obj1 = a(b1.i(), s.equals("(HB)"));
        if (((HasNotifiedResultType) (obj1)).equals(HasNotifiedResultType.b))
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] Not notify (This message was notified). Message = ").append(((String) (obj))).toString());
            ULogUtility.d(s, (new StringBuilder()).append("Not notify (This message was notified). Message = ").append(((String) (obj))).toString());
            return;
        }
        if (((HasNotifiedResultType) (obj1)).equals(HasNotifiedResultType.c))
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] Not notify (This message is in database). Message = ").append(((String) (obj))).toString());
            ULogUtility.d(s, (new StringBuilder()).append("Not notify (This message is in database). Message = ").append(((String) (obj))).toString());
            return;
        }
        Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] start notify. Message = ").append(((String) (obj))).toString());
        ULogUtility.d(s, (new StringBuilder()).append("start notify. Message = ").append(((String) (obj))).toString());
        boolean flag = a();
        Context context = g.a().getApplicationContext();
        obj = b1.e();
        Object obj2 = e.g().a(((String) (obj)));
        b1.k().getTime();
        if (obj2 == null)
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] start query userInfo from server. userId=").append(((String) (obj))).toString());
            ULogUtility.d(s, (new StringBuilder()).append("start query userInfo from server. userId=").append(((String) (obj))).toString());
            obj1 = new l();
            obj2 = new ArrayList();
            ((List) (obj2)).add(new BasicNameValuePair("token", g.a().e()));
            ((List) (obj2)).add(new BasicNameValuePair("userId", ((String) (obj))));
            ((l) (obj1)).a("user", "userInfo", ((List) (obj2)), new p(s, context, group, s, flag, b1) {

                final String a;
                final Context b;
                final Group c;
                final String d;
                final boolean e;
                final b f;

                public void a(String s1, String s2, String s3, String s4)
                {
                    if (s3 == null)
                    {
                        Log.d("NotificationHelper", (new StringBuilder()).append("[").append(a).append("] stop query userInfo from server. statuscode = null").toString());
                        ULogUtility.d(a, "stop query userInfo from server. statuscode = null");
                        return;
                    }
                    if (!s3.equals("200"))
                    {
                        Log.d("NotificationHelper", (new StringBuilder()).append("[").append(a).append("] stop query userInfo from server. statuscode = ").append(s3).toString());
                        ULogUtility.d(a, (new StringBuilder()).append("stop query userInfo from server. statuscode = ").append(s3).toString());
                        return;
                    }
                    Log.d("NotificationHelper", (new StringBuilder()).append("[").append(a).append("] stop query userInfo from server.").toString());
                    ULogUtility.d(a, "stop query userInfo from server.");
                    s3 = new Intent(b, com/cyberlink/you/activity/ChatDialogActivity);
                    s1 = new Bundle();
                    s1.putParcelable("Group", c);
                    s1.putString("debugPrefix", d);
                    s3.putExtras(s1);
                    Friend friend = h.a(h.c(s4));
                    if (friend != null)
                    {
                        s1 = "U";
                        s2 = b.getResources().getString(r.u_notification_default_string);
                        if (e)
                        {
                            s1 = c.f;
                            s2 = NotificationHelper.a(b, f, c, friend);
                        }
                        if (g.a().b() && (d.equals("(HB)") || d.equals("(GCM)")))
                        {
                            s2 = (new StringBuilder()).append(d).append(s2).toString();
                            s1 = (new StringBuilder()).append(d).append(s1).toString();
                        }
                        NotificationHelper.a(c, s1, s2, s2, s3, friend.b, d);
                        return;
                    } else
                    {
                        Log.d("NotificationHelper", (new StringBuilder()).append("[").append(a).append("] get userInfo from server fail. jsonstr = ").append(s4).toString());
                        ULogUtility.d(a, (new StringBuilder()).append("get userInfo from server fail. jsonstr = ").append(s4).toString());
                        return;
                    }
                }

            
            {
                a = s;
                b = context;
                c = group;
                d = s1;
                e = flag;
                f = b1;
                super();
            }
            });
            return;
        }
        Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] get userInfo from db. userId=").append(((String) (obj))).toString());
        ULogUtility.d(s, (new StringBuilder()).append("get userInfo from db. userId=").append(((String) (obj))).toString());
        Intent intent = new Intent(context, com/cyberlink/you/activity/ChatDialogActivity);
        intent.setFlags(0x10008000);
        obj = new Bundle();
        ((Bundle) (obj)).putParcelable("Group", group);
        ((Bundle) (obj)).putString("debugPrefix", s);
        intent.putExtras(((Bundle) (obj)));
        obj = "U";
        obj1 = context.getResources().getString(r.u_notification_default_string);
        if (flag)
        {
            obj = group.f;
            obj1 = b(context, b1, group, ((Friend) (obj2)));
        }
        if (g.a().b() && (s.equals("(HB)") || s.equals("(GCM)")))
        {
            b1 = (new StringBuilder()).append(s).append(((String) (obj1))).toString();
            obj = (new StringBuilder()).append(s).append(((String) (obj))).toString();
        } else
        {
            b1 = ((b) (obj1));
        }
        b(group, ((String) (obj)), b1, b1, intent, ((Friend) (obj2)).b, s);
    }

    static void a(Group group, String s, String s1, String s2, Intent intent, String s3, String s4)
    {
        b(group, s, s1, s2, intent, s3, s4);
    }

    public static boolean a()
    {
        return true;
    }

    static boolean a(Context context)
    {
        return b(context);
    }

    public static int b()
    {
        int i = a.a("notificationId", 0);
        a.b("notificationId", i + 1);
        return i;
    }

    static int b(boolean flag)
    {
        return d(flag);
    }

    private static String b(Context context, b b1, Group group, Friend friend)
    {
        String s = "";
        if (!b1.g().equals(com.cyberlink.you.database.MessageObj.MessageType.a)) goto _L2; else goto _L1
_L1:
        b1 = b1.h();
        group = String.format(context.getResources().getString(r.u_notification_chat_user_say), new Object[] {
            friend.b(), b1
        });
_L4:
        return group;
_L2:
        if (b1.g().equals(com.cyberlink.you.database.MessageObj.MessageType.b))
        {
            return String.format(context.getResources().getString(r.u_notification_chat_user_send_photo), new Object[] {
                friend.b()
            });
        }
        if (b1.g().equals(com.cyberlink.you.database.MessageObj.MessageType.h))
        {
            b1 = (a)b1.a("event", "urn:xmpp:custom:event");
            if (b1 != null && ((String)b1.f().get("eventType")).equals("group.member.created") && !group.e.equals("Dual"))
            {
                context = String.format(context.getResources().getString(r.u_notification_chat_invite_user_into_group), new Object[] {
                    friend.b(), group.f
                });
            } else
            {
                context = "";
            }
            return context;
        }
        if (!b1.g().equals(com.cyberlink.you.database.MessageObj.MessageType.m))
        {
            break MISSING_BLOCK_LABEL_274;
        }
        b1 = b1.h();
        try
        {
            b1 = (new JSONObject(b1)).getString("replyText");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "";
        }
        group = s;
        if (b1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = String.format(context.getResources().getString(r.u_notification_chat_user_say), new Object[] {
            friend.b(), b1
        });
        return context;
        group = s;
        if (b1.g().equals(com.cyberlink.you.database.MessageObj.MessageType.n))
        {
            return String.format(context.getResources().getString(r.u_notification_chat_user_send_bc_post), new Object[] {
                friend.b()
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void b(Group group, String s, String s1, String s2, Intent intent, String s3, String s4)
    {
        group = new Runnable(s4, s, s1, s2, group, intent, s3) {

            final String a;
            final String b;
            final String c;
            final String d;
            final Group e;
            final Intent f;
            final String g;

            public void run()
            {
                Object obj;
                Object obj1;
                String s5 = a;
                obj = com.cyberlink.you.g.a().getApplicationContext();
                if (obj == null)
                {
                    Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s5).append("] Notify fail. context = null").toString());
                    ULogUtility.d(s5, "Notify fail. context = null");
                    return;
                }
                NotificationManager notificationmanager;
                android.graphics.Bitmap bitmap;
                try
                {
                    obj1 = b;
                    String s6 = c;
                    String s7 = d;
                    boolean flag = NotificationHelper.a(((Context) (obj)));
                    notificationmanager = (NotificationManager)((Context) (obj)).getSystemService("notification");
                    PendingIntent pendingintent = PendingIntent.getActivity(((Context) (obj)), NotificationHelper.a(((Context) (obj)), e), f, 0x10000000);
                    bitmap = LoadImageUtils.a(((Context) (obj)), g);
                    obj1 = (new android.support.v4.app.NotificationCompat.Builder(((Context) (obj)))).setContentTitle(((CharSequence) (obj1))).setContentText(s6).setSmallIcon(n.u_ic_bc_launcher).setAutoCancel(true).setTicker(s7).setContentIntent(pendingintent).setDefaults(NotificationHelper.b(flag)).setSound(NotificationHelper.a(flag));
                }
                catch (Exception exception)
                {
                    Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s5).append("] Notify fail. exception = ").append(Log.getStackTraceString(exception)).toString());
                    ULogUtility.d(s5, (new StringBuilder()).append("Notify fail. exception = ").append(Log.getStackTraceString(exception)).toString());
                    return;
                }
                if (bitmap == null) goto _L2; else goto _L1
_L1:
                ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setLargeIcon(bitmap);
_L4:
                notificationmanager.cancel(2);
                notificationmanager.notify(e.c, 1, ((android.support.v4.app.NotificationCompat.Builder) (obj1)).build());
                Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s5).append("] Notify success.").toString());
                ULogUtility.d(s5, "Notify success.");
                return;
_L2:
                obj = LoadImageUtils.a(((Context) (obj)));
                if (obj == null) goto _L4; else goto _L3
_L3:
                ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setLargeIcon(((android.graphics.Bitmap) (obj)));
                  goto _L4
            }

            
            {
                a = s;
                b = s1;
                c = s2;
                d = s3;
                e = group;
                f = intent;
                g = s4;
                super();
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            group.run();
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(group);
            return;
        }
    }

    private static boolean b(Context context)
    {
        context = new q(context, "U", 0);
        long l1 = context.a("AlertTime", 0L);
        long l2 = context.a("PervoiusAlertTime", 0L);
        long l3 = System.currentTimeMillis();
        context.b("PervoiusAlertTime", l3);
        if (l3 - l1 < 1000L)
        {
            return false;
        }
        if (l3 - l2 < 3000L)
        {
            return true;
        } else
        {
            context.b("AlertTime", l3);
            return false;
        }
    }

    private static Uri c(boolean flag)
    {
        if (flag)
        {
            return null;
        } else
        {
            return android.provider.Settings.System.DEFAULT_NOTIFICATION_URI;
        }
    }

    private static int d(boolean flag)
    {
        return !flag ? -1 : 2;
    }

    private class HasNotifiedResultType extends Enum
    {

        public static final HasNotifiedResultType a;
        public static final HasNotifiedResultType b;
        public static final HasNotifiedResultType c;
        private static final HasNotifiedResultType d[];

        public static HasNotifiedResultType valueOf(String s)
        {
            return (HasNotifiedResultType)Enum.valueOf(com/cyberlink/you/chat/NotificationHelper$HasNotifiedResultType, s);
        }

        public static HasNotifiedResultType[] values()
        {
            return (HasNotifiedResultType[])d.clone();
        }

        static 
        {
            a = new HasNotifiedResultType("NO_RECORD", 0);
            b = new HasNotifiedResultType("HAS_NOTIFIED", 1);
            c = new HasNotifiedResultType("IN_DATABASE", 2);
            d = (new HasNotifiedResultType[] {
                a, b, c
            });
        }

        private HasNotifiedResultType(String s, int i)
        {
            super(s, i);
        }
    }

}
