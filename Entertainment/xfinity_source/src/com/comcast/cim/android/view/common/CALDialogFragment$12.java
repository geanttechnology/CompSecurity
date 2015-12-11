// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.comcast.cim.android.view.common:
//            CALDialogFragment

class val.stackTrace
    implements android.view.n.CALDialogFragment._cls12
{

    final CALDialogFragment this$0;
    final TextView val$stackTrace;

    public void onClick(View view)
    {
        val$stackTrace.setVisibility(0);
        ((Button)view).setText(getResources().getString(com.comcast.cim.android._info));
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final CALDialogFragment._cls12 this$1;

            public void onClick(View view1)
            {
                CALDialogFragment.access$400(this$0, view1.getContext(), stackTrace);
            }

            
            {
                this$1 = CALDialogFragment._cls12.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_caldialogfragment;
        val$stackTrace = TextView.this;
        super();
    }
}
