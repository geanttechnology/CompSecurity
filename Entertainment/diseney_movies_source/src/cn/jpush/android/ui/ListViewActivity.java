// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import cn.jpush.android.data.d;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.ui:
//            h, g

public class ListViewActivity extends Activity
{

    private static final String z;
    private d a;

    public ListViewActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        x.d();
        super.onCreate(bundle);
        if (getIntent() != null)
        {
            a = (d)getIntent().getSerializableExtra(z);
            Object obj = a;
            x.d();
            bundle = new GridView(getApplicationContext());
            bundle.setNumColumns(2);
            obj = ((d) (obj)).C;
            bundle.setAdapter(new h(this, 0x80000000, ((java.util.List) (obj))));
            bundle.setOnItemClickListener(new g(this, ((java.util.List) (obj))));
            setContentView(bundle);
            return;
        } else
        {
            x.e();
            return;
        }
    }

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int k;
        int l;
        ac = "l\031N\030".toCharArray();
        j = ac.length;
        l = 0;
        i = 0;
        ac1 = ac;
        k = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        l = i;
        k = i;
_L9:
        char c;
        ac1 = ac;
        c = ac1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 135
    //                   1 141
    //                   2 147
    //                   3 153;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_153;
_L3:
        i = 48;
_L10:
label0:
        {
            ac1[k] = (char)(i ^ c);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        k = j;
        ac1 = ac;
_L2:
        ac = ac1;
        j = k;
        i = l;
        if (k <= l)
        {
            z = (new String(ac1)).intern();
            return;
        }
          goto _L1
_L8:
        i = 14;
          goto _L10
_L5:
        i = 118;
          goto _L10
_L6:
        i = 42;
          goto _L10
        i = 97;
          goto _L10
    }
}
