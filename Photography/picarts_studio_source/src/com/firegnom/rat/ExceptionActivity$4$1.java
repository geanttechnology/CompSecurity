// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.firegnom.rat;

import android.content.res.Resources;
import android.view.View;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;

// Referenced classes of package com.firegnom.rat:
//            ExceptionActivity

class this._cls1
    implements android.view._cls4._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        ExceptionActivity.access$100(_fld0).dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/firegnom/rat/ExceptionActivity$4

/* anonymous class */
    class ExceptionActivity._cls4
        implements android.view.View.OnClickListener
    {

        final ExceptionActivity this$0;

        public void onClick(View view)
        {
            if (ExceptionActivity.access$100(ExceptionActivity.this) == null)
            {
                view = ExceptionActivity.this;
                b b1 = (new b()).a(1, 0x7f0c0181).a(getResources().getString(0x7f0802b8));
                b1.h = false;
                b1.p = ExceptionActivity.access$200(ExceptionActivity.this);
                b1.f = 0x7f0300eb;
                b1.g = true;
                ExceptionActivity.access$102(view, b1.a(new ExceptionActivity._cls4._cls1()).a());
            }
            if (!ExceptionActivity.access$100(ExceptionActivity.this).isAdded())
            {
                ExceptionActivity.access$100(ExceptionActivity.this).show(getFragmentManager(), "dialogPreview");
            }
        }

            
            {
                this$0 = ExceptionActivity.this;
                super();
            }
    }

}
