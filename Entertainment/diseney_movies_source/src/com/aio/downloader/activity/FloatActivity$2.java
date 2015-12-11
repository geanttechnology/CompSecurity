// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.aio.downloader.model.Programe;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            FloatActivity

class this._cls0
    implements android.widget.emClickListener
{

    final FloatActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        try
        {
            adapterview = getPackageManager().getLaunchIntentForPackage(((Programe)FloatActivity.access$1(FloatActivity.this).get(i)).getPackagename());
            adapterview.addFlags(0x10000000);
            startActivity(adapterview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            Toast.makeText(getApplicationContext(), (new StringBuilder(String.valueOf(((Programe)FloatActivity.access$1(FloatActivity.this).get(i)).getPackagename()))).append(" program is protected").toString(), 0).show();
        }
    }

    er()
    {
        this$0 = FloatActivity.this;
        super();
    }
}
