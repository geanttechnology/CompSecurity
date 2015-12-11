// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.UserManager;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            s

public class r extends AsyncTask
{

    private static final String a = com/smule/pianoandroid/magicpiano/b/r.getName();
    private String b;
    private String c;
    private String d;
    private com.smule.android.f.b e;
    private s f;

    public r(String s1, String s2, String s3, com.smule.android.f.b b1, s s4)
    {
        c = s1;
        b = s2;
        d = s3;
        e = b1;
        f = s4;
    }

    private int b(o o1)
    {
        if (o1.b != 1008)
        {
            return -1;
        }
        switch (o1.f)
        {
        default:
            return 0x7f0c01ca;

        case 30: // '\036'
            return 0x7f0c01cc;
        }
    }

    private int c(o o1)
    {
        int i = 0x7f0c00e4;
        if (o1.b == 1006) goto _L2; else goto _L1
_L1:
        i = -1;
_L4:
        return i;
_L2:
        switch (o1.f)
        {
        default:
            return 0x7f0c00e4;

        case 11: // '\013'
            return 0x7f0c00ea;

        case 12: // '\f'
            return 0x7f0c00e6;

        case 13: // '\r'
            return 0x7f0c00eb;

        case 10: // '\n'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int d(o o1)
    {
        int i = 0x7f0c0134;
        if (o1.b == 1007) goto _L2; else goto _L1
_L1:
        i = -1;
_L4:
        return i;
_L2:
        switch (o1.f)
        {
        default:
            return 0x7f0c0134;

        case 21: // '\025'
            return 0x7f0c0136;

        case 22: // '\026'
            return 0x7f0c0135;

        case 23: // '\027'
            return 0x7f0c0137;

        case 20: // '\024'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected transient o a(Void avoid[])
    {
        return UserManager.n().a(c, b, d, e);
    }

    protected void a(o o1)
    {
        int j;
        boolean flag1;
        flag1 = false;
        j = 0x7f0c00e4;
        if (o1 == null || o1.a != p.a) goto _L2; else goto _L1
_L1:
        int i;
        boolean flag;
        i = j;
        flag = flag1;
        o1.b;
        JVM INSTR lookupswitch 7: default 96
    //                   0: 261
    //                   10: 165
    //                   50: 269
    //                   56: 102
    //                   1006: 126
    //                   1007: 139
    //                   1008: 152;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L7:
        break; /* Loop/switch isn't completed */
_L3:
        i = -1;
        flag = flag1;
_L12:
        if (f != null)
        {
            f.a(o1, Boolean.valueOf(flag), i);
        }
        return;
_L8:
        i = c(o1);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L9:
        i = d(o1);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L10:
        i = b(o1);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L5:
        if (TextUtils.isEmpty(d) && TextUtils.isEmpty(b))
        {
            i = 0x7f0c0134;
            flag = flag1;
            continue; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty(d))
        {
            i = j;
            flag = flag1;
            if (TextUtils.isEmpty(c))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        if (TextUtils.isEmpty(b) && TextUtils.isEmpty(c))
        {
            i = 0x7f0c01ca;
            flag = flag1;
        } else
        {
            i = 0x7f0c0121;
            flag = flag1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag = true;
        i = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        if (TextUtils.isEmpty(d) && TextUtils.isEmpty(b))
        {
            i = 0x7f0c0134;
            flag = flag1;
            continue; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty(d))
        {
            i = j;
            flag = flag1;
            if (TextUtils.isEmpty(c))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        if (TextUtils.isEmpty(b) && TextUtils.isEmpty(c))
        {
            i = 0x7f0c01ca;
            flag = flag1;
        } else
        {
            i = 0x7f0c0036;
            flag = flag1;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        com.smule.android.network.core.b.d().p();
        i = 0x7f0c0045;
        flag = flag1;
        if (true) goto _L12; else goto _L11
_L11:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((o)obj);
    }

    protected void onPreExecute()
    {
    }

}
