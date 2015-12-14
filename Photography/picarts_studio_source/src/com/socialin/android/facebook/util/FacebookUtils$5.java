// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import android.view.View;
import com.socialin.android.facebook.p;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class a
    implements android.view.ener
{

    final p a;
    private Activity b;
    private String c[];

    public final void onClick(View view)
    {
        FacebookUtils.access$1100(b, c, new p() {

            private FacebookUtils._cls5 a;

            public final void a()
            {
                a.a.a();
            }

            
            {
                a = FacebookUtils._cls5.this;
                super();
            }
        });
    }

    _cls1.a(Activity activity, String as[], p p)
    {
        b = activity;
        c = as;
        a = p;
        super();
    }
}
