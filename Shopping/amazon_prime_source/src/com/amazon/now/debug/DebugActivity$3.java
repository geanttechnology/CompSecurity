// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.DataStore;
import com.amazon.now.util.WeblabUtil;

// Referenced classes of package com.amazon.now.debug:
//            DebugActivity

class this._cls0
    implements android.view.ener
{

    final DebugActivity this$0;

    public void onClick(View view)
    {
        DataStore.removeKey("service_url_key");
        DataStore.removeKey("service_url_state_key");
        DebugActivity.access$200(DebugActivity.this).setText(AppUtils.getServiceUrl(DebugActivity.access$100(DebugActivity.this)));
        WeblabUtil.saveWeblabs(null);
        Toast.makeText(DebugActivity.access$100(DebugActivity.this), "Service URL Reset!", 0).show();
    }

    ()
    {
        this$0 = DebugActivity.this;
        super();
    }
}
