// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.a;
import cn.jpush.android.api.m;
import cn.jpush.android.data.c;
import cn.jpush.android.data.d;
import cn.jpush.android.data.l;
import cn.jpush.android.data.p;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.k;
import cn.jpush.android.util.x;
import java.io.File;

// Referenced classes of package cn.jpush.android.service:
//            PushService, ServiceInterface, p, a, 
//            DownloadService

public class PushReceiver extends BroadcastReceiver
{

    public static d a;
    private static final String z[];

    public PushReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj;
        obj = intent.getAction();
        (new StringBuilder(z[26])).append(((String) (obj))).toString();
        x.c();
        break MISSING_BLOCK_LABEL_29;
_L2:
        Object obj1;
        do
        {
            return;
        } while (!cn.jpush.android.a.a(context.getApplicationContext()) || obj == null);
        if (((String) (obj)).equals(z[11]))
        {
            ae.a(context);
            k.d(context);
            if (cn.jpush.android.service.PushService.a())
            {
                cn.jpush.android.service.ServiceInterface.c(context, 500);
                return;
            } else
            {
                x.d();
                return;
            }
        }
        if (!((String) (obj)).equals(z[9]))
        {
            break MISSING_BLOCK_LABEL_253;
        }
        String s = intent.getDataString().replace(z[7], "");
        intent = c.a(context, s);
        cn.jpush.android.service.ServiceInterface.a(context, cn.jpush.android.service.p.a(s));
        String as[];
        try
        {
            if (TextUtils.isEmpty(intent))
            {
                continue; /* Loop/switch isn't completed */
            }
            as = intent.split(",");
            if (as.length <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.getMessage();
            x.f();
            return;
        }
        obj1 = as[0];
        cn.jpush.android.service.ServiceInterface.a(((String) (obj1)), 1002, context);
        Object obj2;
        String s1;
        String s2;
        String s3;
        String s4;
        int i;
        int j;
        if (as.length >= 2)
        {
            obj = as[1];
        } else
        {
            obj = "";
        }
        intent = "";
        if (as.length >= 3)
        {
            intent = as[2];
        }
        x.f();
        if (!((String) (obj)).equals(z[34]) && !cn.jpush.android.util.a.a(context, s, ((String) (obj))))
        {
            x.c();
            cn.jpush.android.service.ServiceInterface.a(((String) (obj1)), 1100, context);
        }
        if (ai.a(intent))
        {
            intent = ((Intent) (obj1));
        }
        m.a(context, intent);
        return;
        if (((String) (obj)).equals(z[41]))
        {
            cn.jpush.android.service.ServiceInterface.a(context, p.b(intent.getDataString().replace(z[7], "")));
            return;
        }
        if (!((String) (obj)).equals(z[21]))
        {
            break; /* Loop/switch isn't completed */
        }
        if (PushService.q && cn.jpush.android.service.PushService.a())
        {
            cn.jpush.android.service.ServiceInterface.c(context);
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (!((String) (obj)).equals(z[14]))
        {
            break; /* Loop/switch isn't completed */
        }
        intent = (d)intent.getSerializableExtra(z[13]);
        if (intent != null && intent.a())
        {
            cn.jpush.android.service.ServiceInterface.a(((d) (intent)).c, 1015, context);
            intent = (l)intent;
            obj = new Intent();
            ((Intent) (obj)).addFlags(0x10000000);
            ((Intent) (obj)).setAction(z[33]);
            ((Intent) (obj)).setDataAndType(Uri.fromFile(new File(((l) (intent)).ah)), z[15]);
            context.startActivity(((Intent) (obj)));
            return;
        }
        if (true) goto _L2; else goto _L3
_L3:
        if (!((String) (obj)).startsWith(z[29]))
        {
            break; /* Loop/switch isn't completed */
        }
        i = intent.getIntExtra(z[25], 0);
        (new StringBuilder(z[3])).append(i).toString();
        x.c();
        if (i == 0)
        {
            if (ServiceInterface.j(context))
            {
                x.d();
                return;
            }
            if (!cn.jpush.android.util.a.o(context))
            {
                x.d();
                return;
            }
        }
        obj = intent.getStringExtra(z[32]);
        if (!ai.a(((String) (obj))))
        {
            obj1 = intent.getStringExtra(z[36]);
            intent = p.a(context, ((String) (obj)), intent.getStringExtra(z[38]), ((String) (obj1)), intent.getStringExtra(z[35]));
            if (intent == null)
            {
                x.e();
                return;
            }
            if (((cn.jpush.android.data.a) (intent)).e)
            {
                intent.h = true;
                p.a(context, intent);
            }
            abortBroadcast();
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
        if (!((String) (obj)).startsWith(z[17]))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!intent.getBooleanExtra(z[18], false)) goto _L6; else goto _L5
_L5:
        s3 = intent.getStringExtra(z[10]);
        i = intent.getIntExtra(z[8], -1);
        if (i == -1)
        {
            intent = intent.getStringExtra(z[30]);
            context = Toast.makeText(context, s3, 1);
            obj = context.getView();
            if (obj instanceof LinearLayout)
            {
                obj = ((LinearLayout)obj).getChildAt(0);
                if (obj instanceof TextView)
                {
                    obj = (TextView)obj;
                    if (!ai.a(intent))
                    {
                        ((TextView) (obj)).setText(intent);
                    }
                    ((TextView) (obj)).setTextSize(13F);
                }
            }
            context.show();
            return;
        }
        if (ai.a(s3))
        {
            continue; /* Loop/switch isn't completed */
        }
        s4 = z[23];
        obj2 = z[37];
        s1 = z[1];
        s2 = z[5];
        intent = s1;
        obj = s2;
        obj1 = obj2;
        i;
        JVM INSTR tableswitch 0 2: default 808
    //                   0 818
    //                   1 1052
    //                   2 1076;
           goto _L7 _L8 _L9 _L10
_L8:
        break; /* Loop/switch isn't completed */
_L7:
        obj1 = obj2;
        obj = s2;
        intent = s1;
_L11:
        obj2 = new StringBuilder();
        ((StringBuilder) (obj2)).append(s4).append(s3).append(((String) (obj1))).append(intent).append(((String) (obj))).append(z[4]);
        obj2 = new SpannableStringBuilder(((CharSequence) (obj2)));
        i = s4.length();
        j = s3.length() + i;
        ((SpannableStringBuilder) (obj2)).setSpan(new ForegroundColorSpan(0xff3197ff), i, j, 33);
        i = j + 2;
        j = (((String) (obj1)).length() + i) - 2;
        ((SpannableStringBuilder) (obj2)).setSpan(new ForegroundColorSpan(0xff3197ff), i, j, 33);
        i = intent.length() + j;
        j = ((String) (obj)).length();
        ((SpannableStringBuilder) (obj2)).setSpan(new ForegroundColorSpan(0xff3197ff), i, j + i, 33);
        context = Toast.makeText(context, s3, 1);
        intent = context.getView();
        if (intent instanceof LinearLayout)
        {
            intent = ((LinearLayout)intent).getChildAt(0);
            if (intent instanceof TextView)
            {
                intent = (TextView)intent;
                if (obj2 != null)
                {
                    intent.setText(((CharSequence) (obj2)));
                }
                intent.setTextSize(13F);
            }
        }
        context.show();
        return;
_L9:
        obj1 = z[20];
        intent = z[1];
        obj = z[46];
        continue; /* Loop/switch isn't completed */
_L10:
        obj1 = z[28];
        intent = z[1];
        obj = z[43];
        if (true) goto _L11; else goto _L6
_L6:
        obj = intent.getStringExtra(z[42]);
        if (!ai.a(((String) (obj))))
        {
            obj1 = intent.getStringExtra(z[2]);
            (new StringBuilder(z[6])).append(((String) (obj1))).toString();
            x.c();
            if (obj1 != null && "1".equals(obj1))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (true != i)
            {
                cn.jpush.android.service.ServiceInterface.a(((String) (obj)), 1000, context);
            }
        }
        if (!cn.jpush.android.util.a.a(context, z[12], true))
        {
            x.b(z[31], z[40]);
            cn.jpush.android.util.a.f(context);
            return;
        }
        obj1 = new Intent(z[12]);
        ((Intent) (obj1)).putExtras(intent.getExtras());
        obj = intent.getStringExtra(z[22]);
        intent = ((Intent) (obj));
        if (ai.a(((String) (obj))))
        {
            intent = context.getPackageName();
        }
        ((Intent) (obj1)).addCategory(intent);
        (new StringBuilder(z[44])).append(intent).toString();
        x.d();
        context.sendBroadcast(((Intent) (obj1)), (new StringBuilder()).append(intent).append(z[45]).toString());
        return;
        if (!((String) (obj)).equalsIgnoreCase(z[39])) goto _L2; else goto _L12
_L12:
        obj = (NetworkInfo)intent.getParcelableExtra(z[16]);
        if (obj != null)
        {
            (new StringBuilder(z[27])).append(((NetworkInfo) (obj)).toString()).toString();
            x.b();
            if (intent.getBooleanExtra(z[19], false))
            {
                x.b();
                a.b = false;
                ServiceInterface.b(context);
                return;
            }
            if (android.net.NetworkInfo.State.CONNECTED == ((NetworkInfo) (obj)).getState())
            {
                ServiceInterface.f(context);
                x.b();
                a.b = true;
                if (cn.jpush.android.service.DownloadService.a())
                {
                    cn.jpush.android.service.DownloadService.a(context);
                }
                if (PushService.r)
                {
                    cn.jpush.android.service.ServiceInterface.c(context, 3000);
                }
                if (a != null)
                {
                    m.b(context, a);
                    return;
                }
            } else
            if (android.net.NetworkInfo.State.DISCONNECTED == ((NetworkInfo) (obj)).getState())
            {
                x.b();
                a.b = false;
                ServiceInterface.b(context);
                return;
            } else
            {
                (new StringBuilder(z[24])).append(((NetworkInfo) (obj)).getState()).append(z[0]).toString();
                x.b();
                return;
            }
        }
        if (true) goto _L2; else goto _L13
_L13:
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[47];
        i = 0;
        obj1 = "\017pZ85O?j?|O70";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int i1;
        int j1;
        int k1;
        byte byte2;
        int l1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        k1 = 0;
        i1 = 0;
        byte2 = byte0;
        obj1 = ac;
        l1 = i;
        as1 = ((String []) (obj));
        j1 = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        j1 = i1;
_L9:
        obj1 = obj;
        k1 = obj1[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 1373
    //                   1 1380
    //                   2 1387
    //                   3 1394;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_1394;
_L3:
        byte0 = 21;
_L13:
label0:
        {
            obj1[i1] = (char)(byte0 ^ k1);
            j1++;
            if (j != 0)
            {
                break label0;
            }
            i1 = j;
        }
        if (true) goto _L9; else goto _L8
        k1 = j1;
        j1 = j;
        as1 = as2;
        l1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = l1;
        as2 = as1;
        j = j1;
        i1 = k1;
        if (j1 > k1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[l1] = ((String) (obj));
            i = 1;
            obj1 = "\u6598\u6C85\u4E33\u6CF6\u671C\u8C22\u7578";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            i = 2;
            obj1 = "B>0=eT#vytO4l8|E~P\030Ah\026W\024Tu\031Q\031Ju\tN\022";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            i = 3;
            obj1 = "`\023J\036Zo\017P\030Ah\026W\024Tu\031Q\031Js\025]\022\\w\025Z\bEs\037F\0165\001pp8aH6w4tU9q9JU)n25\034p";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[l1] = ((String) (obj));
            i = 4;
            obj1 = "+Z\u6732\u6387\u792F\u53CB\u5778\u5F1E\u5386\u6246\u5324\u72E6\u601F\u4E5C\u51EF\u7391|\u53CF\u5E54\u6246\u5324\u4E5D\u4F04\u51AD\u73A5\017";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[l1] = ((String) (obj));
            i = 5;
            obj1 = "+\032N\"fI\031p#pS6\1774p\017?p\005pR%s2=\b";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[l1] = ((String) (obj));
            i = 6;
            obj1 = "R$l\031AX {w(\001";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[l1] = ((String) (obj));
            i = 7;
            obj1 = "Q1}<tF5$";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[l1] = ((String) (obj));
            i = 8;
            obj1 = "U)n2";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[l1] = ((String) (obj));
            i = 9;
            obj1 = "@>z%zH40>{U5p#;@3j>zO~N\026Vj\021Y\022J`\024Z\022Q";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[l1] = ((String) (obj));
            i = 10;
            obj1 = "@3j>cH$g";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[l1] = ((String) (obj));
            i = 11;
            obj1 = "@>z%zH40>{U5p#;@3j>zO~\\\030Zu\017]\030Xq\034[\003Pe";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[l1] = ((String) (obj));
            i = 12;
            obj1 = "B>0=eT#vytO4l8|E~w9aD>jy[n\004W\021\\b\021J\036Zo\017Q\007Po\025Z";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[l1] = ((String) (obj));
            i = 13;
            obj1 = "C?z.";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[l1] = ((String) (obj));
            i = 14;
            obj1 = "B>0=eT#vytO4l8|E~w9aD>jy[n\004W\021\\b\021J\036Zo\017W\031Fu\021R\033Jb\034W\024^d\024";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[l1] = ((String) (obj));
            i = 15;
            obj1 = "@ n;|B1j>zO\177h9q\0171p3gN9zye@3u6rD}\177%vI9h2";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[l1] = ((String) (obj));
            i = 16;
            obj1 = "O5j zS;W9sN";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[l1] = ((String) (obj));
            i = 17;
            obj1 = "B>0=eT#vytO4l8|E~w9aD>jy[n\004W\021\\b\021J\036Zo\017Q\007Po\025Z\bEs\037F\016";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[l1] = ((String) (obj));
            i = 18;
            obj1 = "E5|\"r~>q#|G9}6aH?p";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[l1] = ((String) (obj));
            i = 19;
            obj1 = "O?]8{O5}#|W9j.";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[l1] = ((String) (obj));
            i = 20;
            obj1 = "+\u76D4\0248{q1k$p\ty\024";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[l1] = ((String) (obj));
            i = 21;
            obj1 = "@>z%zH40>{U5p#;@3j>zO~K\004Ps\017N\005Pr\025P\003";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[l1] = ((String) (obj));
            i = 22;
            obj1 = "@ n";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[l1] = ((String) (obj));
            i = 23;
            obj1 = "k\000k$}\001\u5EAA\u8BB0\u9691\u6205\001\003Z\0345\u65D7\u52F0\u4E14\u7E88\u8BB4\u4EC2\u7851\u4EFB\u8B93\u4F25\u6389\u9051\u6556\u67CB\u3017\001Z\024\u6897\u6D5E\u5211\u5778\024";
            byte0 = 22;
            obj = as;
            break;

        case 22: // '\026'
            as1[l1] = ((String) (obj));
            i = 24;
            obj1 = "N$v2g\001>{#bN\"uwfU1j25\fp";
            byte0 = 23;
            obj = as;
            break;

        case 23: // '\027'
            as1[l1] = ((String) (obj));
            i = 25;
            obj1 = "O?j>sH3\177>zO\017j.eD";
            byte0 = 24;
            obj = as;
            break;

        case 24: // '\030'
            as1[l1] = ((String) (obj));
            i = 26;
            obj1 = "N>L2vD9h25\fp";
            byte0 = 25;
            obj = as;
            break;

        case 25: // '\031'
            as1[l1] = ((String) (obj));
            i = 27;
            obj1 = "b?p9pB$w8{\001#j6aDp}?tO7{35U?>z5";
            byte0 = 26;
            obj = as;
            break;

        case 26: // '\032'
            as1[l1] = ((String) (obj));
            i = 28;
            obj1 = "+\u76D4\0248{s5m\"xDx7]zO\000\177\"fDx7]";
            byte0 = 27;
            obj = as;
            break;

        case 27: // '\033'
            as1[l1] = ((String) (obj));
            i = 29;
            obj1 = "B>0=eT#vytO4l8|E~w9aD>jy[n\004W\021\\b\021J\036Zo\017L\022Vd\031H\022Q~\000L\030Mx";
            byte0 = 28;
            obj = as;
            break;

        case 28: // '\034'
            as1[l1] = ((String) (obj));
            i = 30;
            obj1 = "U?\177$au5f#";
            byte0 = 29;
            obj = as;
            break;

        case 29: // '\035'
            as1[l1] = ((String) (obj));
            i = 31;
            obj1 = "q%m?GD3{>cD\"";
            byte0 = 30;
            obj = as;
            break;

        case 30: // '\036'
            as1[l1] = ((String) (obj));
            i = 32;
            obj1 = "L5m$tF5";
            byte0 = 31;
            obj = as;
            break;

        case 31: // '\037'
            as1[l1] = ((String) (obj));
            i = 33;
            obj1 = "@>z%zH40>{U5p#;@3j>zO~H\036Pv";
            byte0 = 32;
            obj = as;
            break;

        case 32: // ' '
            as1[l1] = ((String) (obj));
            i = 34;
            obj1 = "O?j\btT$q%`O";
            byte0 = 33;
            obj = as;
            break;

        case 33: // '!'
            as1[l1] = ((String) (obj));
            i = 35;
            obj1 = "L#y\b|E";
            byte0 = 34;
            obj = as;
            break;

        case 34: // '"'
            as1[l1] = ((String) (obj));
            i = 36;
            obj1 = "R5p3pS\031z";
            byte0 = 35;
            obj = as;
            break;

        case 35: // '#'
            as1[l1] = ((String) (obj));
            i = 37;
            obj1 = "+\u76D4\0248{s5m\"xDx7]";
            byte0 = 36;
            obj = as;
            break;

        case 36: // '$'
            as1[l1] = ((String) (obj));
            i = 38;
            obj1 = "@ n\036q";
            byte0 = 37;
            obj = as;
            break;

        case 37: // '%'
            as1[l1] = ((String) (obj));
            i = 39;
            obj1 = "@>z%zH409pU~}8{O~]\030[o\025]\003\\w\031J\016Jb\030_\031Rd";
            byte0 = 38;
            obj = as;
            break;

        case 38: // '&'
            as1[l1] = ((String) (obj));
            i = 40;
            obj1 = "o?>\026Vu\031Q\031Jo\037J\036Sh\023_\003\\n\036A\030Ed\036[\0235E5x>{D4>>{\001=\1779|G5m#9\001?n2{\001$v25E5x6`M$>:tH>>6vU9h>aX";
            byte0 = 39;
            obj = as;
            break;

        case 39: // '\''
            as1[l1] = ((String) (obj));
            i = 41;
            obj1 = "@>z%zH40>{U5p#;@3j>zO~N\026Vj\021Y\022Js\025S\030Cd\024";
            byte0 = 40;
            obj = as;
            break;

        case 40: // '('
            as1[l1] = ((String) (obj));
            i = 42;
            obj1 = "B>0=eT#vytO4l8|E~N\002Fi\017W\023";
            byte0 = 41;
            obj = as;
            break;

        case 41: // ')'
            as1[l1] = ((String) (obj));
            i = 43;
            obj1 = "+\032N\"fI\031p#pS6\1774p\017?p\005pR%s2=\bZT\007`R8W9aD\"x6vD~q9E@%m2=\b";
            byte0 = 42;
            obj = as;
            break;

        case 42: // '*'
            as1[l1] = ((String) (obj));
            i = 44;
            obj1 = "r5p35C\"q6qB1m#5U?>6eQj>";
            byte0 = 43;
            obj = as;
            break;

        case 43: // '+'
            as1[l1] = ((String) (obj));
            i = 45;
            obj1 = "\017 {%xH#m>zO~T\007@r\030A\032Pr\003_\020P";
            byte0 = 44;
            obj = as;
            break;

        case 44: // ','
            as1[l1] = ((String) (obj));
            i = 46;
            obj1 = "+\032N\"fI\031p#pS6\1774p\017?p\007tT#{\177<";
            byte0 = 45;
            obj = as;
            break;

        case 45: // '-'
            as1[l1] = ((String) (obj));
            z = as;
            a = null;
            return;
        }
          goto _L12
_L8:
        byte0 = 33;
          goto _L13
_L5:
        byte0 = 80;
          goto _L13
_L6:
        byte0 = 30;
          goto _L13
        byte0 = 87;
          goto _L13
    }
}
