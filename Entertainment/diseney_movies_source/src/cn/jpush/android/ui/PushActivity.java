// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import cn.jpush.android.api.m;
import cn.jpush.android.data.d;
import cn.jpush.android.data.g;
import cn.jpush.android.data.p;
import cn.jpush.android.data.s;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.x;
import java.io.File;

// Referenced classes of package cn.jpush.android.ui:
//            k, a, i, j

public class PushActivity extends Activity
{

    private static final String z[];
    private d a;
    private String b;
    private g c;
    private a d;
    private boolean e;
    private ProgressDialog f;
    private Handler g;

    public PushActivity()
    {
        e = false;
        g = new k(this);
    }

    static String a(PushActivity pushactivity)
    {
        return pushactivity.b;
    }

    private void a(Intent intent)
    {
        boolean flag;
        flag = intent.getBooleanExtra(z[3], false);
        a = (d)intent.getSerializableExtra(z[1]);
        b = a.c;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (a == null);
_L4:
        return;
_L2:
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        switch (a.o)
        {
        default:
            (new StringBuilder(z[2])).append(a.o).toString();
            x.e();
            m.a(this, a, 0);
            break MISSING_BLOCK_LABEL_130;

        case 0: // '\0'
            break MISSING_BLOCK_LABEL_164;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_135;

        case 2: // '\002'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_135;
        finish();
        return;
        g.removeMessages(2);
        g.removeMessages(3);
        g.sendEmptyMessageDelayed(2, 500L);
        return;
        g.removeMessages(4);
        g.removeMessages(5);
        g.sendEmptyMessageDelayed(4, 500L);
        return;
    }

    static d b(PushActivity pushactivity)
    {
        return pushactivity.a;
    }

    static Handler c(PushActivity pushactivity)
    {
        return pushactivity.g;
    }

    static void d(PushActivity pushactivity)
    {
label0:
        {
            x.d();
            s s1 = (s)pushactivity.a;
            String s2 = s1.a;
            if (s1.W == 0)
            {
                if (!p.a(s2))
                {
                    break label0;
                }
                String s3 = s1.ab;
                if (s1.q)
                {
                    pushactivity.d = new a(pushactivity, s1);
                    pushactivity.d.a(new i(pushactivity));
                    pushactivity.setContentView(pushactivity.d, new android.view.ViewGroup.LayoutParams(-1, -1));
                    if (!TextUtils.isEmpty(s3) && (new File(s3.replace(z[0], ""))).exists())
                    {
                        pushactivity.d.a(s3);
                    } else
                    {
                        pushactivity.d.a(s2);
                    }
                } else
                {
                    pushactivity.c = new g(pushactivity, pushactivity.a);
                    if (!TextUtils.isEmpty(s3) && (new File(s3.replace(z[0], ""))).exists())
                    {
                        pushactivity.c.a(s3, false, true);
                    } else
                    {
                        pushactivity.c.a(s2, false, true);
                    }
                    pushactivity.setContentView(pushactivity.c);
                    pushactivity.c.a(new j(pushactivity));
                }
                ServiceInterface.a(pushactivity.b, 1000, pushactivity);
            }
            return;
        }
        m.a(pushactivity, pushactivity.a, 0);
        pushactivity.finish();
    }

    static ProgressDialog e(PushActivity pushactivity)
    {
        return pushactivity.f;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (e)
        {
            ServiceInterface.a(b, 1008, this);
        } else
        {
            ServiceInterface.a(b, 1006, this);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        x.c();
        super.onCreate(bundle);
        if (getIntent() != null)
        {
            a = (d)getIntent().getSerializableExtra(z[1]);
            if (a != null && a.z == 2)
            {
                a.z = 1;
                a.p = 3;
                m.a(this, a);
            }
            requestWindowFeature(1);
            if (a.q)
            {
                getWindow().setFlags(1024, 1024);
            }
            a(getIntent());
            return;
        } else
        {
            x.e();
            return;
        }
    }

    protected void onDestroy()
    {
        if (c != null)
        {
            c.a();
        }
        if (d != null)
        {
            d.a();
        }
        if (f != null)
        {
            f.dismiss();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int l, KeyEvent keyevent)
    {
        return super.onKeyDown(l, keyevent);
    }

    protected void onNewIntent(Intent intent)
    {
        a(intent);
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int l;
        as = new String[4];
        l = 0;
        obj1 = "jsA\177>#5";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int i1;
        int j1;
        int k1;
        int l1;
        byte byte2;
        int i2;
        ac = ((String) (obj1)).toCharArray();
        i1 = ac.length;
        l1 = 0;
        j1 = 0;
        byte2 = byte0;
        obj1 = ac;
        i2 = l;
        as1 = ((String []) (obj));
        k1 = i1;
        if (i1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        k1 = j1;
_L9:
        obj1 = obj;
        l1 = obj1[j1];
        k1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 299
    //                   1 306
    //                   2 313
    //                   3 320;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_320;
_L3:
        byte0 = 4;
_L13:
label0:
        {
            obj1[j1] = (char)(byte0 ^ l1);
            k1++;
            if (i1 != 0)
            {
                break label0;
            }
            j1 = i1;
        }
        if (true) goto _L9; else goto _L8
        l1 = k1;
        k1 = i1;
        as1 = as2;
        i2 = l;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        l = i2;
        as2 = as1;
        i1 = k1;
        j1 = l1;
        if (k1 > l1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[i2] = ((String) (obj));
            l = 1;
            obj1 = "nuIc";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            l = 2;
            obj1 = "Et[{he~\rwwk:Ycti:Yu$\177rBm$!:";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            l = 3;
            obj1 = "eixj`mnHLa~iDuj";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[i2] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 12;
          goto _L13
_L5:
        byte0 = 26;
          goto _L13
_L6:
        byte0 = 45;
          goto _L13
        byte0 = 26;
          goto _L13
    }
}
