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

class this._cls0
    implements android.view.
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
            ExceptionActivity.access$102(view, b1.a(new android.view.View.OnClickListener() {

                final ExceptionActivity._cls4 this$1;

                public void onClick(View view1)
                {
                    ExceptionActivity.access$100(this$0).dismiss();
                }

            
            {
                this$1 = ExceptionActivity._cls4.this;
                super();
            }
            }).a());
        }
        if (!ExceptionActivity.access$100(ExceptionActivity.this).isAdded())
        {
            ExceptionActivity.access$100(ExceptionActivity.this).show(getFragmentManager(), "dialogPreview");
        }
    }

    _cls1.this._cls1()
    {
        this$0 = ExceptionActivity.this;
        super();
    }
}
