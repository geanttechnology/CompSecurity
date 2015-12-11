// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

// Referenced classes of package cn.jpush.android.service:
//            DownloadService

final class f extends Handler
{

    private static final String z;
    final DownloadService a;
    private Context b;

    public f(DownloadService downloadservice, Context context)
    {
        a = downloadservice;
        super(context.getMainLooper());
        b = context;
    }

    public final void handleMessage(Message message)
    {
        super.handleMessage(message);
        Toast.makeText(b, z, 1).show();
    }

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int k;
        int l;
        ac = "Gb:]\027p\006\032]\0134H\026HEcI\013W".toCharArray();
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
        i = 101;
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
        i = 20;
          goto _L10
_L5:
        i = 38;
          goto _L10
_L6:
        i = 121;
          goto _L10
        i = 60;
          goto _L10
    }
}
