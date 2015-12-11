// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package co.vine.android:
//            DebugHomeActivity

class val.query
    implements android.view.
{

    final DebugHomeActivity this$0;
    final EditText val$query;

    public void onClick(View view)
    {
        DebugHomeActivity.access$000(DebugHomeActivity.this, val$query.getText().toString());
    }

    ()
    {
        this$0 = final_debughomeactivity;
        val$query = EditText.this;
        super();
    }
}
