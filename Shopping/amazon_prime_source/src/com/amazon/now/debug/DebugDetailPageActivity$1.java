// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.amazon.now.util.DataStore;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.now.debug:
//            DebugDetailPageActivity

class val.serviceUrlText
    implements android.view.ivity._cls1
{

    final DebugDetailPageActivity this$0;
    final EditText val$serviceUrlText;

    public void onClick(View view)
    {
        UIUtils.closeSoftKeyboard(view);
        DataStore.removeKey("detail_page_service_url_key");
        val$serviceUrlText.setText(DebugDetailPageActivity.access$000(DebugDetailPageActivity.this));
        Toast.makeText(DebugDetailPageActivity.this, "Detail Page Endpoint Reset!", 0).show();
    }

    ()
    {
        this$0 = final_debugdetailpageactivity;
        val$serviceUrlText = EditText.this;
        super();
    }
}
