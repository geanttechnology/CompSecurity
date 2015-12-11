// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.data.d;
import cn.jpush.android.util.JavascriptCallback;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.api:
//            q

final class t
    implements JavascriptCallback
{

    private static final String z[];
    private Context a;
    private WindowManager b;
    private WebView c;
    private ImageButton d;

    public t(Context context, d d1, WindowManager windowmanager, WebView webview, ImageButton imagebutton)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        x.c();
        a = context;
        b = windowmanager;
        c = webview;
        d = imagebutton;
    }

    public final void close()
    {
        x.c();
        q.a(b, c, d);
    }

    public final int getWindowHeight()
    {
        (new StringBuilder(z[0])).append(q.b()).toString();
        x.c();
        return q.b();
    }

    public final int getWindowWidth()
    {
        (new StringBuilder(z[7])).append(q.a()).toString();
        x.c();
        return q.a();
    }

    public final void startActivityByName(String s, String s1)
    {
        (new StringBuilder(z[6])).append(s).append(z[4]).append(s1).toString();
        x.c();
        if (ai.a(s))
        {
            x.e(z[1], z[3]);
        }
        if (a != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((s = Class.forName(s)) == null) goto _L1; else goto _L3
_L3:
        s = new Intent(a, s);
        s.putExtra(z[2], s1);
        s.setFlags(0x10000000);
        a.startActivity(s);
        close();
        return;
        s;
        x.e(z[1], z[5]);
        return;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[8];
        i = 0;
        obj1 = "\tEX\177=\tdSr5\026X\026&r";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 394
    //                   1 401
    //                   2 408
    //                   3 415;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_415;
_L3:
        byte0 = 82;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "-UEo7\023mZ~ \n{Sy\004\027IAX3\022@Tz1\025";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "\035B\030q\"\013_^53\020HDt;\032\002wX\0067z\177O\013!|wI\0233";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "*DS;3\035X_m;\nU\026u3\023I\026r!^BCw>^CD;7\023\\Bb~^k_m7^YF5|";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "S\001\0336\177^\\Wi3\023_\026!r";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "*DS;3\035X_m;\nU\026u3\023I\026r!^EXm3\022ER7r9E@~r\013\\\0305";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "\037OBr=\020\f\0336\177^_Bz \nmUo;\bEBb\020\007bWv7S\001\0336\177S\001\033z1\nE@r&\007bWv7^\026\026";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "\tEX\177=\t{_\177&\026\f\013;";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 126;
          goto _L13
_L5:
        byte0 = 44;
          goto _L13
_L6:
        byte0 = 54;
          goto _L13
        byte0 = 27;
          goto _L13
    }
}
