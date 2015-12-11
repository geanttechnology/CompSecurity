// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.appsflyer.b;
import com.parse.ParseUser;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            gi

public class hj
    implements gi
{

    public hj()
    {
    }

    public void a()
    {
    }

    public void a(Activity activity)
    {
        com.appsflyer.b.a(activity.getApplicationContext());
    }

    public void a(Application application)
    {
        com.appsflyer.b.c("5EKnCjmwmNKjE2e7gYBo6T");
        com.appsflyer.b.a(application.getApplicationContext());
    }

    public void a(Context context, String s, Map map, ParseUser parseuser)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   -1514399234: 111
    //                   -1339456808: 96
    //                   -187270926: 126
    //                   486764790: 81;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_126;
_L6:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            com.appsflyer.b.a(context.getApplicationContext(), s, map);
            break;
        }
        break MISSING_BLOCK_LABEL_150;
_L5:
        if (s.equals("product-sell-complete"))
        {
            byte0 = 0;
        }
          goto _L6
_L3:
        if (s.equals("product-detail-ask-question"))
        {
            byte0 = 1;
        }
          goto _L6
_L2:
        if (s.equals("product-detail-offer"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("product-detail-sold"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public void a(ParseUser parseuser)
    {
        com.appsflyer.b.b(parseuser.getObjectId());
        if (parseuser.getEmail() != null)
        {
            com.appsflyer.b.a(com.appsflyer.c.a.c, new String[] {
                parseuser.getEmail()
            });
        }
    }

    public void b()
    {
    }

    public void b(Activity activity)
    {
    }

    public void b(Context context, String s, Map map, ParseUser parseuser)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   -1514399234: 111
    //                   -1339456808: 96
    //                   -187270926: 126
    //                   486764790: 81;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_126;
_L6:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            com.appsflyer.b.a(context.getApplicationContext(), s, map);
            break;
        }
        break MISSING_BLOCK_LABEL_150;
_L5:
        if (s.equals("product-sell-complete"))
        {
            byte0 = 0;
        }
          goto _L6
_L3:
        if (s.equals("product-detail-ask-question"))
        {
            byte0 = 1;
        }
          goto _L6
_L2:
        if (s.equals("product-detail-offer"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("product-detail-sold"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public void c(Activity activity)
    {
    }

    public void d(Activity activity)
    {
        com.appsflyer.b.a(activity);
    }

    public void e(Activity activity)
    {
        com.appsflyer.b.b(activity);
    }

    public void f(Activity activity)
    {
    }
}
