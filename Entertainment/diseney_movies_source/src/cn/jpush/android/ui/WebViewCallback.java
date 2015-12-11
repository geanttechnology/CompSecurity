// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import cn.jpush.android.api.m;
import cn.jpush.android.data.d;
import cn.jpush.android.data.l;
import cn.jpush.android.data.p;
import cn.jpush.android.data.y;
import cn.jpush.android.service.PushService;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.JavascriptCallback;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.lang.ref.WeakReference;

public class WebViewCallback
    implements JavascriptCallback
{

    private static final String z[];
    private final WeakReference a;
    private final d b;

    public WebViewCallback(Context context, d d1)
    {
        a = new WeakReference((Activity)context);
        b = d1;
    }

    private void userClick(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        catch (Exception exception)
        {
            (new StringBuilder(z[8])).append(s).toString();
            i = 1100;
            x.f();
        }
        ServiceInterface.a(b.c, i, (Context)a.get());
    }

    public void click(String s, String s1, String s2)
    {
        if (a.get() == null) goto _L2; else goto _L1
_L1:
        (new StringBuilder(z[15])).append(s).append(z[14]).append(s1).append(z[16]).append(s2).toString();
        x.c();
        userClick(s);
        boolean flag = Boolean.parseBoolean(s1);
        boolean flag1 = Boolean.parseBoolean(s2);
_L4:
        if (flag1)
        {
            m.a((Context)a.get(), b, 0);
        }
        if (flag)
        {
            ((Activity)a.get()).finish();
        }
_L2:
        return;
        s;
        flag = false;
_L5:
        flag1 = false;
        if (true) goto _L4; else goto _L3
_L3:
        s;
          goto _L5
    }

    public void close()
    {
        if (a.get() != null)
        {
            x.c();
            ((Activity)a.get()).finish();
        }
    }

    public void createShortcut(String s, String s1, String s2)
    {
        int i;
        try
        {
            i = Integer.parseInt(s2);
        }
        catch (Exception exception)
        {
            (new StringBuilder(z[11])).append(s2).toString();
            i = 0;
            x.c();
        }
        if (a.get() == null)
        {
            return;
        } else
        {
            (new StringBuilder(z[12])).append(s).append(z[10]).append(s1).toString();
            x.c();
            cn.jpush.android.util.a.a((Context)a.get(), s, s1, m.a(i));
            return;
        }
    }

    public void download(String s)
    {
        if (a.get() == null)
        {
            return;
        }
        (new StringBuilder(z[0])).append(s).toString();
        x.c();
        Context context = (Context)a.get();
        d d1 = b;
        if (d1.a())
        {
            l l1 = (l)d1;
            if (TextUtils.isEmpty(l1.ac))
            {
                l1.ac = s;
            }
            if (!TextUtils.isEmpty(l1.ah))
            {
                cn.jpush.android.util.a.e(context, l1.ah);
                m.a(context, l1, 0);
                m.a(context, l1, 1);
                return;
            }
        } else
        if (d1.b())
        {
            y y1 = (y)d1;
            if (TextUtils.isEmpty(y1.W))
            {
                y1.W = s;
            }
            if (!TextUtils.isEmpty(y1.aa))
            {
                context.startActivity(cn.jpush.android.util.a.a(context, d1, false));
                return;
            }
        } else
        {
            (new StringBuilder(z[1])).append(d1.o).toString();
            x.e();
            return;
        }
        ServiceInterface.a(context, d1);
    }

    public void download(String s, String s1)
    {
        if (a.get() == null)
        {
            return;
        } else
        {
            userClick(s);
            download(s1);
            m.a((Context)a.get(), b, 0);
            ((Activity)a.get()).finish();
            return;
        }
    }

    public void download(String s, String s1, String s2)
    {
        (new StringBuilder(z[19])).append(s2).toString();
        x.b();
        download(s, s1);
    }

    public void executeMsgMessage(String s)
    {
label0:
        {
            if (PushService.b)
            {
                (new StringBuilder(z[17])).append(s).toString();
                x.c();
                if (a.get() != null)
                {
                    break label0;
                }
            }
            return;
        }
        p.a((Context)a.get(), s);
    }

    public void showToast(String s)
    {
        if (a.get() != null)
        {
            (new StringBuilder(z[9])).append(s).toString();
            x.c();
            Toast.makeText((Context)a.get(), s, 0).show();
        }
    }

    public void startActivityByIntent(String s, String s1)
    {
        Context context = (Context)a.get();
        if (context == null)
        {
            return;
        }
        try
        {
            Intent intent = new Intent(s);
            intent.addCategory(context.getPackageName());
            intent.putExtra(z[4], s1);
            intent.setFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            x.e(z[3], (new StringBuilder(z[2])).append(s).toString());
        }
    }

    public void startActivityByName(String s, String s1)
    {
        Context context;
        if (ai.a(s))
        {
            x.e(z[3], z[5]);
        }
        context = (Context)a.get();
        if (context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((s = Class.forName(s)) == null) goto _L1; else goto _L3
_L3:
        s = new Intent(context, s);
        s.putExtra(z[7], s1);
        s.setFlags(0x10000000);
        context.startActivity(s);
        return;
        s;
        x.e(z[3], z[6]);
        return;
    }

    public void startMainActivity(String s)
    {
        Context context = (Context)a.get();
        if (context == null)
        {
            return;
        }
        try
        {
            cn.jpush.android.util.a.h(context, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            x.e(z[3], z[13]);
        }
    }

    public void triggerNativeAction(String s)
    {
        Context context = (Context)a.get();
        if (context == null)
        {
            return;
        } else
        {
            cn.jpush.android.util.a.b(context, z[18], s);
            return;
        }
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[20];
        i = 0;
        obj1 = "q~`X\021Gwn\032\023Ep8\034\035Qun\027\023B;/X";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int i1;
        int j1;
        byte byte2;
        int k1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        j1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        k1 = i;
        as1 = ((String []) (obj));
        i1 = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        i1 = k;
_L9:
        obj1 = obj;
        j1 = obj1[k];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 694
    //                   1 701
    //                   2 708
    //                   3 714;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_714;
_L3:
        byte0 = 114;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ j1);
            i1++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        j1 = i1;
        i1 = j;
        as1 = as2;
        k1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = k1;
        as2 = as1;
        j = i1;
        k = j1;
        if (i1 > j1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[k1] = ((String) (obj));
            i = 1;
            obj1 = "out\031\036O\177\"\025\027Uhc\037\027rbr\035R@tpX\026Ill\024\035G\177\"UR";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[k1] = ((String) (obj));
            i = 2;
            obj1 = "suj\031\034BwgX\033Hog\026\006\006!\"";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[k1] = ((String) (obj));
            i = 3;
            obj1 = "q~`.\033ClA\031\036Jyc\033\031";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[k1] = ((String) (obj));
            i = 4;
            obj1 = "Eu,\022\002ShjV\023H\177p\027\033B5G &tZ";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[k1] = ((String) (obj));
            i = 5;
            obj1 = "rsgX\023Eok\016\033Rb\"\026\023K~\"\021\001\006uw\024\036\006tpX\027Kkv\001^\006\\k\016\027\006nrV\\";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[k1] = ((String) (obj));
            i = 6;
            obj1 = "rsgX\023Eok\016\033Rb\"\026\023K~\"\021\001\006rl\016\023JrfTRart\035RSk,V";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[k1] = ((String) (obj));
            i = 7;
            obj1 = "Eu,\022\002ShjV\023H\177p\027\033B5C;&oMK,+yKC*3k";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[k1] = ((String) (obj));
            i = 8;
            obj1 = "out\031\036O\177\"\031\021Rrm\026;B;d\n\035K;U\035\020\0066\"";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[k1] = ((String) (obj));
            i = 9;
            obj1 = "q~`X\021Gwn\032\023Ep8\013\032IlV\027\023Uo\"UR";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[k1] = ((String) (obj));
            i = 10;
            obj1 = "\n;w\n\036\034";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[k1] = ((String) (obj));
            i = 11;
            obj1 = "Oxm\026;B;q\020\035SwfX\020C;k\026\006\0066\"";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[k1] = ((String) (obj));
            i = 12;
            obj1 = "q~`X\021Gwn\032\023Ep8\033\000Czv\035!Ntp\f\021So\"URHzo\035H";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[k1] = ((String) (obj));
            i = 13;
            obj1 = "suj\031\034BwgX\033Hog\026\006\006!\"\033\034\bqr\r\001N5c\026\026Ttk\034\\Ouv\035\034R5C;&oTL'3eOK.;rB]7\"cUF=6";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[k1] = ((String) (obj));
            i = 14;
            obj1 = "\n;q\020\035Swf;\036IhgB";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[k1] = ((String) (obj));
            i = 15;
            obj1 = "q~`X\021Gwn\032\023Ep8\033\036OxiX_\006za\f\033IuK\034H";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[k1] = ((String) (obj));
            i = 16;
            obj1 = "\n;q\020\035Swf;\023Hxg\024<Iok\036\033Ezv\021\035H!";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[k1] = ((String) (obj));
            i = 17;
            obj1 = "q~`X\021Gwn\032\023Ep8\035\nCxw\f\027khe5\027Uhc\037\027\0066\"";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[k1] = ((String) (obj));
            i = 18;
            obj1 = "Eu,\022\002ShjV\023H\177p\027\033B5k\026\006CuvV3eOK7<yIK;:vNQ0-eZN40gXI";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[k1] = ((String) (obj));
            i = 19;
            obj1 = "Khe,\013V~\"\036\000Iv\"\017\027D!\"";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[k1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 38;
          goto _L13
_L5:
        byte0 = 27;
          goto _L13
_L6:
        byte0 = 2;
          goto _L13
        byte0 = 120;
          goto _L13
    }
}
