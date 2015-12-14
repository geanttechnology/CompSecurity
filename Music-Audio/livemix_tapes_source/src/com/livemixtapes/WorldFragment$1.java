// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import java.util.HashMap;

// Referenced classes of package com.livemixtapes:
//            WorldFragment

class this._cls0
    implements android.widget.emClickListener
{

    final WorldFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (HashMap)adapterview.getItemAtPosition(i);
        view = (String)adapterview.get("mixtape_id");
        if (view == null || view.equals(""))
        {
            adapterview = new Intent("android.intent.action.VIEW", Uri.parse((String)adapterview.get("url")));
            startActivity(adapterview);
            return;
        } else
        {
            (new adDownloadData(WorldFragment.this)).execute(new String[] {
                view
            });
            return;
        }
    }

    adDownloadData()
    {
        this$0 = WorldFragment.this;
        super();
    }
}
