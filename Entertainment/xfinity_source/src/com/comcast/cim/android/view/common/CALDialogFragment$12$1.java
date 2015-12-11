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

class this._cls1
    implements android.view.CALDialogFragment._cls12._cls1
{

    final l.stackTrace this$1;

    public void onClick(View view)
    {
        CALDialogFragment.access$400(_fld0, view.getContext(), stackTrace);
    }

    l.stackTrace()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/cim/android/view/common/CALDialogFragment$12

/* anonymous class */
    class CALDialogFragment._cls12
        implements android.view.View.OnClickListener
    {

        final CALDialogFragment this$0;
        final TextView val$stackTrace;

        public void onClick(View view)
        {
            stackTrace.setVisibility(0);
            ((Button)view).setText(getResources().getString(com.comcast.cim.android.R.string.dlg_btn_copy_info));
            view.setOnClickListener(new CALDialogFragment._cls12._cls1());
        }

            
            {
                this$0 = final_caldialogfragment;
                stackTrace = TextView.this;
                super();
            }
    }

}
