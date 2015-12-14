// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.main;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.socialin.android.photo.main:
//            a

public class DateAndTimeListActivity extends BaseActivity
{

    private ListView a;
    private ArrayList b;

    public DateAndTimeListActivity()
    {
        a = null;
        b = new ArrayList();
    }

    static ArrayList a(DateAndTimeListActivity dateandtimelistactivity)
    {
        return dateandtimelistactivity.b;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f0301af);
        AnalyticUtils.getInstance(this).trackLocalAction("dateTime:onCreate");
        a = (ListView)findViewById(0x7f10080f);
        a.setAdapter(new a(this));
        a.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private DateAndTimeListActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent();
                adapterview.putExtra("text", (String)DateAndTimeListActivity.a(a).get(i));
                a.setResult(-1, adapterview);
                a.finish();
                AnalyticUtils.getInstance(a).trackLocalAction("dateTime:done");
            }

            
            {
                a = DateAndTimeListActivity.this;
                super();
            }
        });
        bundle = new Date();
        b.add((String)DateFormat.format("MMMM dd", bundle));
        b.add((String)DateFormat.format("EEEE", bundle));
        b.add((String)DateFormat.format("MMMM dd, yyyy  h:mmaa", bundle));
        b.add((String)DateFormat.format("MMM dd, yyyy", bundle));
        b.add((String)DateFormat.format("MM/dd/yy", bundle));
        b.add((String)DateFormat.format("h:mmaa", bundle));
        b.add((String)DateFormat.format("EEEE, MMMM dd, yyyy", bundle));
        b.add((String)DateFormat.format("EEEE, MMMM dd", bundle));
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        bundle.setTitle(0x7f0805ff);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("dateTime:exit");
        if (true) goto _L1; else goto _L3
_L3:
    }
}
