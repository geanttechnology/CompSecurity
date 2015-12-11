// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.groupon.adapter.ABTestListAdapter;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            PreconfiguredAbTests

class val.values
    implements android.content.Listener
{

    final PreconfiguredAbTests this$0;
    final String val$key;
    final List val$values;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i != 0)
        {
            PreconfiguredAbTests.access$000(PreconfiguredAbTests.this).addOverride(val$key, (String)val$values.get(i));
        } else
        {
            PreconfiguredAbTests.access$000(PreconfiguredAbTests.this).addOverride(val$key, null);
        }
        if (PreconfiguredAbTests.access$200(PreconfiguredAbTests.this) != null)
        {
            PreconfiguredAbTests.access$200(PreconfiguredAbTests.this).dismiss();
        }
    }

    ner()
    {
        this$0 = final_preconfiguredabtests;
        val$key = s;
        val$values = List.this;
        super();
    }
}
