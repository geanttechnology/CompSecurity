// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.view.View;
import com.cyberlink.beautycircle.view.widgetpool.common.BCToastView;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseArcMenuActivity, c

class b
    implements android.view.enuActivity._cls1
{

    final Long a;
    final Long b;
    final BaseArcMenuActivity c;

    public void onClick(View view)
    {
        BaseArcMenuActivity.a(c).b(new Runnable() {

            final BaseArcMenuActivity._cls1 a;

            public void run()
            {
                com.cyberlink.beautycircle.c.a(a.c, a.a, a.b);
            }

            
            {
                a = BaseArcMenuActivity._cls1.this;
                super();
            }
        });
    }

    _cls1.a(BaseArcMenuActivity basearcmenuactivity, Long long1, Long long2)
    {
        c = basearcmenuactivity;
        a = long1;
        b = long2;
        super();
    }
}
