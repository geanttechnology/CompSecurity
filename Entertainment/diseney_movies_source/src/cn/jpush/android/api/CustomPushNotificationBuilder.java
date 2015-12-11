// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.content.Context;
import android.widget.RemoteViews;
import cn.jpush.android.a;

// Referenced classes of package cn.jpush.android.api:
//            BasicPushNotificationBuilder

public class CustomPushNotificationBuilder extends BasicPushNotificationBuilder
{

    private static final String z[];
    public int layout;
    public int layoutContentId;
    public int layoutIconDrawable;
    public int layoutIconId;
    public int layoutTitleId;

    CustomPushNotificationBuilder(Context context)
    {
        super(context);
        layoutIconDrawable = a.a;
    }

    public CustomPushNotificationBuilder(Context context, int i, int j, int k, int l)
    {
        super(context);
        layoutIconDrawable = a.a;
        layout = i;
        layoutIconId = j;
        layoutTitleId = k;
        layoutContentId = l;
    }

    final void a(String as[])
    {
        super.a(as);
        layout = Integer.parseInt(as[5]);
        layoutIconId = Integer.parseInt(as[6]);
        layoutTitleId = Integer.parseInt(as[7]);
        layoutContentId = Integer.parseInt(as[8]);
        layoutIconDrawable = Integer.parseInt(as[9]);
    }

    final RemoteViews b(String s)
    {
        RemoteViews remoteviews = new RemoteViews(a.getPackageName(), layout);
        remoteviews.setTextViewText(layoutTitleId, b);
        remoteviews.setImageViewResource(layoutIconId, layoutIconDrawable);
        remoteviews.setTextViewText(layoutContentId, s);
        return remoteviews;
    }

    final String b()
    {
        return (new StringBuilder()).append(super.b()).append(z[0]).append(layout).append(z[0]).append(layoutIconId).append(z[0]).append(layoutTitleId).append(z[0]).append(layoutContentId).append(z[0]).append(layoutIconDrawable).toString();
    }

    public String toString()
    {
        return (new StringBuilder(z[1])).append(b()).toString();
    }

    static 
    {
        Object obj1;
        String as2[];
        int k;
        int l;
        as2 = new String[2];
        obj1 = ":*zg\003";
        k = -1;
        l = 0;
_L10:
        Object obj;
        String as[];
        int i;
        int j;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        j = obj1.length;
        if (j > 1)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        i = 0;
        as = ((String []) (obj));
        i1 = l;
        obj = obj1;
        j1 = k;
_L9:
        l = i;
        k = i;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 100
    //                   0 236
    //                   1 243
    //                   2 250
    //                   3 257;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 92;
_L11:
label0:
        {
            obj1[k] = (char)(i ^ k1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        k = j;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        j = k;
        i = l;
        if (k > l) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "\006\000VL3\b*zg\003:";
            l = 1;
            k = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 101;
          goto _L11
_L3:
        i = 117;
          goto _L11
_L4:
        i = 37;
          goto _L11
_L5:
        i = 56;
          goto _L11
        boolean flag = false;
        k1 = k;
        l1 = l;
        as1 = ((String []) (obj));
        k = j;
        l = ((flag) ? 1 : 0);
          goto _L12
    }
}
