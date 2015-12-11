// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.a;
import cn.jpush.android.api.m;
import cn.jpush.android.data.c;
import cn.jpush.android.data.d;
import cn.jpush.android.data.l;
import cn.jpush.android.data.p;
import cn.jpush.android.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package cn.jpush.android.service:
//            e, ServiceInterface, PushReceiver, a, 
//            f, d

public class DownloadService extends IntentService
{

    public static ConcurrentLinkedQueue a;
    private static Bundle b;
    private static final String z[];
    private NotificationManager c;
    private d d;
    private f e;
    private Notification f;
    private RemoteViews g;
    private Integer h;
    private Integer i;
    private Integer j;
    private Integer k;
    private Integer l;
    private Handler m;

    public DownloadService()
    {
        super(z[4]);
        h = Integer.valueOf(0);
        i = Integer.valueOf(0);
        j = Integer.valueOf(0);
        k = Integer.valueOf(0);
        l = Integer.valueOf(0);
        m = new e(this);
    }

    static d a(DownloadService downloadservice)
    {
        return downloadservice.d;
    }

    public static void a(Context context)
    {
        int i1 = a.size();
        (new StringBuilder(z[13])).append(i1).toString();
        x.c();
        Object obj = new ArrayList();
        do
        {
            d d1 = (d)a.poll();
            if (d1 == null)
            {
                break;
            }
            if (d1.M)
            {
                (new StringBuilder(z[12])).append(d1.c).toString();
                x.c();
                cn.jpush.android.service.ServiceInterface.a(context, d1);
            } else
            {
                x.b();
                ((ArrayList) (obj)).add(d1);
            }
        } while (true);
        for (context = ((ArrayList) (obj)).iterator(); context.hasNext(); a.offer(obj))
        {
            obj = (d)context.next();
        }

    }

    private void a(d d1, int i1, long l1, long l2)
    {
        if (f == null)
        {
            f = new Notification();
            f.icon = 0x1080081;
            f.when = System.currentTimeMillis();
            f.flags = 2;
            f.defaults = 4;
            Object obj = new Intent();
            obj = PendingIntent.getActivity(getApplicationContext(), i1, ((Intent) (obj)), 0x8000000);
            f.contentIntent = ((PendingIntent) (obj));
        }
        String s1 = d1.A;
        String s = z[8];
        int j1 = (int)(((float)l1 / (float)l2) * 100F);
        d1 = s;
        if (l2 > 0L)
        {
            d1 = (new StringBuilder()).append(s).append(j1).append("%").toString();
        }
        if (l != null && l.intValue() > 0)
        {
            if (g == null)
            {
                g = new RemoteViews(getPackageName(), l.intValue());
                g.setTextViewText(h.intValue(), s1);
                g.setImageViewResource(j.intValue(), a.a);
            }
            g.setTextViewText(k.intValue(), (new StringBuilder()).append(j1).append("%").toString());
            g.setProgressBar(i.intValue(), 100, j1, false);
            f.contentView = g;
        } else
        {
            Object obj1 = new Intent();
            obj1 = PendingIntent.getActivity(getApplicationContext(), i1, ((Intent) (obj1)), 0x8000000);
            f.setLatestEventInfo(this, s1, d1, ((PendingIntent) (obj1)));
        }
        c.notify(i1, f);
    }

    private void a(d d1, boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = d1.c();
        Intent intent;
        if (d1.a() && !flag)
        {
            intent = new Intent();
            intent.putExtra(z[2], d1);
            intent.setClass(getApplicationContext(), cn/jpush/android/service/PushReceiver);
            intent.setAction(z[1]);
            int i1;
            if (d1.c())
            {
                d1.B = z[0];
                flag = flag1;
            } else
            {
                d1.B = z[3];
                flag = flag1;
            }
        } else
        {
            intent = cn.jpush.android.util.a.a(getApplicationContext(), d1, false);
            flag = false;
        }
        i1 = cn.jpush.android.api.m.a(d1, 0);
        d1 = cn.jpush.android.api.m.a(getApplicationContext(), i1, intent, d1, flag2, flag);
        if (d1 != null)
        {
            c.notify(i1, d1);
            return;
        } else
        {
            x.f();
            return;
        }
    }

    static void a(DownloadService downloadservice, int i1, d d1, int j1)
    {
_L2:
        return;
        if (j1 == 0 || d1.f()) goto _L2; else goto _L1
_L1:
        String s;
        int k1;
        k1 = 4;
        String s1;
        Object obj;
        if (2 == j1)
        {
            s = z[7];
        } else
        {
            if (3 != j1)
            {
                continue; /* Loop/switch isn't completed */
            }
            s = z[6];
        }
_L4:
        s1 = d1.A;
        obj = new Intent();
        if (cn.jpush.android.service.a.a(j1))
        {
            ((Intent) (obj)).setClass(downloadservice.getApplicationContext(), cn/jpush/android/service/DownloadService);
            d1.P = -1;
            ((Intent) (obj)).putExtra(z[2], d1);
        }
        d1 = new Notification();
        d1.icon = 0x1080082;
        d1.when = System.currentTimeMillis();
        d1.flags = k1;
        obj = PendingIntent.getService(downloadservice, i1, ((Intent) (obj)), 0x8000000);
        d1.setLatestEventInfo(downloadservice.getApplicationContext(), s1, s, ((PendingIntent) (obj)));
        downloadservice.c.notify(i1, d1);
        return;
        if (1 != j1) goto _L2; else goto _L3
_L3:
        s = z[5];
        k1 = 2;
          goto _L4
        if (true) goto _L2; else goto _L5
_L5:
    }

    static void a(DownloadService downloadservice, d d1)
    {
        if (!d1.f()) goto _L2; else goto _L1
_L1:
        cn.jpush.android.util.a.a(downloadservice.getApplicationContext(), d1);
_L5:
        return;
_L2:
        String s2;
        l l1;
        s2 = d1.e();
        if (!d1.a() || TextUtils.isEmpty(s2))
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = (l)d1;
        PackageInfo packageinfo;
        String s1;
        Object obj;
        if (l1.aa)
        {
            s1 = l1.W;
        } else
        {
            s1 = z[9];
        }
        packageinfo = null;
        obj = downloadservice.getPackageManager().getPackageArchiveInfo(s2, 16384);
        packageinfo = ((PackageInfo) (obj));
_L3:
        String s;
        Exception exception;
        if (packageinfo != null)
        {
            s = packageinfo.packageName;
        } else
        {
            s = "";
        }
        obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = s;
            if (!TextUtils.isEmpty(l1.a))
            {
                obj = l1.a;
            }
        }
        cn.jpush.android.data.c.a(downloadservice, d1, ((String) (obj)), s1);
        if (p.a(l1.Y, l1.Z, downloadservice.getApplicationContext()))
        {
            downloadservice.a(d1, true);
            return;
        }
        break MISSING_BLOCK_LABEL_176;
        exception;
        x.i();
          goto _L3
        if (l1.af)
        {
            downloadservice.a(d1, false);
        }
        if (l1.ag)
        {
            cn.jpush.android.util.a.e(downloadservice.getApplicationContext(), s2);
        }
        if (!l1.af && !l1.ag)
        {
            x.c();
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (d1.b() && !TextUtils.isEmpty(s2))
        {
            downloadservice.a(d1, false);
            return;
        } else
        {
            (new StringBuilder(z[10])).append(s2).toString();
            x.c();
            return;
        }
    }

    static void a(DownloadService downloadservice, d d1, int i1, long l1, long l2)
    {
        downloadservice.a(d1, i1, l1, l2);
    }

    public static boolean a()
    {
        return a.size() > 0;
    }

    static Handler b(DownloadService downloadservice)
    {
        return downloadservice.m;
    }

    static NotificationManager c(DownloadService downloadservice)
    {
        return downloadservice.c;
    }

    public void onCreate()
    {
        x.c();
        super.onCreate();
        e = new f(this, getApplicationContext());
        c = (NotificationManager)getSystemService(z[21]);
        if (b == null)
        {
            b = new Bundle();
        }
        try
        {
            if (l.intValue() == 0)
            {
                HashMap hashmap = cn.jpush.android.api.m.a(z[18], new String[] {
                    z[20]
                });
                if (hashmap.size() > 0)
                {
                    l = (Integer)hashmap.get(z[20]);
                }
                hashmap = cn.jpush.android.api.m.a(z[17], new String[] {
                    z[15], z[14], z[16], z[19]
                });
                if (hashmap.size() > 0)
                {
                    h = (Integer)hashmap.get(z[15]);
                    i = (Integer)hashmap.get(z[14]);
                    j = (Integer)hashmap.get(z[16]);
                    k = (Integer)hashmap.get(z[19]);
                }
            }
            return;
        }
        catch (Exception exception)
        {
            x.i();
        }
    }

    public void onDestroy()
    {
        x.c();
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent)
    {
        x.c();
        d = (d)intent.getSerializableExtra(z[2]);
        if (d == null)
        {
            x.e();
            return;
        }
        if (!Environment.getExternalStorageState().equals(z[11]))
        {
            x.e();
            e.sendEmptyMessage(0);
            return;
        }
        if (d.N)
        {
            x.c();
            return;
        }
        if (d.L)
        {
            cn.jpush.android.service.ServiceInterface.a(d.c, 1012, this);
        }
        if (!a.contains(d))
        {
            a.offer(d);
        }
        int i1 = cn.jpush.android.api.m.a(d, 1);
        intent = d;
        boolean flag1;
        if (intent.f())
        {
            flag1 = true;
        } else
        {
            boolean flag;
            if (intent.a())
            {
                l l1 = (l)intent;
                if (!p.a(l1.Y, l1.Z, this))
                {
                    a(intent, i1, 0L, 0L);
                    flag = false;
                } else
                {
                    flag = true;
                }
            } else
            {
                flag = false;
            }
            if (flag || intent.b())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        Thread.currentThread().setPriority(1);
        new cn.jpush.android.service.a(this, d, b, new cn.jpush.android.service.d(this, flag1, i1), 3000);
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[22];
        i1 = 0;
        obj1 = "\u66D2\u658F\u720C\u671C\u5DBD\u4E2D\u8F42\u5BC8\u6BE5\uFF43\u8BD1\u7086\u51BF\u5BB9\u888A\u3024";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j1;
        int k1;
        int l1;
        int i2;
        byte byte2;
        int j2;
        ac = ((String) (obj1)).toCharArray();
        j1 = ac.length;
        i2 = 0;
        k1 = 0;
        byte2 = byte0;
        obj1 = ac;
        j2 = i1;
        as1 = ((String []) (obj));
        l1 = j1;
        if (j1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l1 = k1;
_L9:
        obj1 = obj;
        i2 = obj1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 754
    //                   1 761
    //                   2 768
    //                   3 775;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_775;
_L3:
        byte0 = 79;
_L13:
label0:
        {
            obj1[k1] = (char)(byte0 ^ i2);
            l1++;
            if (j1 != 0)
            {
                break label0;
            }
            k1 = j1;
        }
        if (true) goto _L9; else goto _L8
        i2 = l1;
        l1 = j1;
        as1 = as2;
        j2 = i1;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i1 = j2;
        as2 = as1;
        j1 = l1;
        k1 = i2;
        if (l1 > i2) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j2] = ((String) (obj));
            i1 = 1;
            obj1 = "EQjZ?SL,\036.H[6_&B\021-^;CQ0\036\001ik\rv\006e~\020y\000h`\r~\034r~\b|\020es\rs\004c{";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "DP I";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "\u5BAF\u88FA\u5341\u5DC2\u4E44\u8F5B\u5BB3\u6B91\uFF3C\u8BB8\u709F\u51C4\u5BCD\u88F5\u304D";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "bP3^#I^ c*TI-S*";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "\u5F75\u5272\u7F15\u7EEC\u4E42\u53C9\u7517\u3046\u7A3D\u5441\u4F3C\u7ED8\u7EA9\u4E3B\u8F32\uFF27";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "\u4E2D\u8F42\u8D00\u6EA0\u597E\u656E\u303D\u8BB3\u7A3D\u5441\u709F\u51C4\u9189\u6580\u4E44\u8F5B\uFF3E";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            i1 = 7;
            obj1 = "\u4E2D\u8F42\u5975\u8D15\u304D\u8BD1\u7A32\u544A\u7089\u51B4\u91EB\u658F\u4E4F\u8F4D\uFF4E";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j2] = ((String) (obj));
            i1 = 8;
            obj1 = "\u4E2D\u8F42\u4E69\036a\b\037";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j2] = ((String) (obj));
            i1 = 9;
            obj1 = "HP0o.SK+B:H";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j2] = ((String) (obj));
            i1 = 10;
            obj1 = "hPdU!B\037*_;OY-S.RV+^a\006V7\020)OS!`.RWdU\"VK=\020p\006\022d";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j2] = ((String) (obj));
            i1 = 11;
            obj1 = "KP1^;C[";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j2] = ((String) (obj));
            i1 = 12;
            obj1 = "uK%B;OQ#\020;I\037 _8HS+Q+\006\022d]*UL%W*o[~";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j2] = ((String) (obj));
            i1 = 13;
            obj1 = "cG!S:RZd_#B\037 _8HS+Q+\006K%C$\006\022dC&\\Z~";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j2] = ((String) (obj));
            i1 = 14;
            obj1 = "VM+W=CL7o-GM";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j2] = ((String) (obj));
            i1 = 15;
            obj1 = "RV0\\*";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j2] = ((String) (obj));
            i1 = 16;
            obj1 = "O\\+^";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j2] = ((String) (obj));
            i1 = 17;
            obj1 = "t\033-T";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j2] = ((String) (obj));
            i1 = 18;
            obj1 = "t\033(Q6IJ0";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[j2] = ((String) (obj));
            i1 = 19;
            obj1 = "RZ<D\020VM+W=CL7";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[j2] = ((String) (obj));
            i1 = 20;
            obj1 = "HP0Y)O\\%D&IQ\033\\._P1D";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[j2] = ((String) (obj));
            i1 = 21;
            obj1 = "HP0Y)O\\%D&IQ";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[j2] = ((String) (obj));
            z = as;
            a = new ConcurrentLinkedQueue();
            return;
        }
          goto _L12
_L8:
        byte0 = 38;
          goto _L13
_L5:
        byte0 = 63;
          goto _L13
_L6:
        byte0 = 68;
          goto _L13
        byte0 = 48;
          goto _L13
    }
}
