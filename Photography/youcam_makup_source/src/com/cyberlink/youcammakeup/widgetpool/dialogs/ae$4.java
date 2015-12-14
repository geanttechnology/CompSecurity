// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKBeforeAfterEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ae, al, ai

class a
    implements android.view.OnClickListener
{

    final ae a;

    public void onClick(View view)
    {
        b.a(new YMKBeforeAfterEvent(com.cyberlink.youcammakeup.clflurry.foreAfterEvent.Operation.c));
        view.setEnabled(false);
        Bundle bundle = new Bundle();
        bundle.putString("BUNDLE_KEY_TITLE", al.a);
        ai ai1 = new ai(ae.d(a), a);
        ai1.setArguments(bundle);
        ai1.a(new android.content.DialogInterface.OnDismissListener(view) {

            final View a;
            final ae._cls4 b;

            public void onDismiss(DialogInterface dialoginterface)
            {
                a.setEnabled(true);
            }

            
            {
                b = ae._cls4.this;
                a = view;
                super();
            }
        });
        o.a(a.getFragmentManager(), ai1, "ShareDialog");
    }

    _cls1.a(ae ae1)
    {
        a = ae1;
        super();
    }
}
