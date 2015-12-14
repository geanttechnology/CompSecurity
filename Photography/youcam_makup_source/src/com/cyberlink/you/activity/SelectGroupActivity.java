// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.cyberlink.you.BaseActivity;
import com.cyberlink.you.chat.e;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.d;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

public class SelectGroupActivity extends BaseActivity
{

    private static final String a = com/cyberlink/you/activity/SelectGroupActivity.getSimpleName();
    private ArrayAdapter b;
    private ListView c;
    private View d;
    private Intent e;
    private android.view.View.OnClickListener f;
    private android.widget.AdapterView.OnItemClickListener g;

    public SelectGroupActivity()
    {
        e = null;
        f = new android.view.View.OnClickListener() {

            final SelectGroupActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = SelectGroupActivity.this;
                super();
            }
        };
        g = new android.widget.AdapterView.OnItemClickListener() {

            final SelectGroupActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (Group)SelectGroupActivity.a(a).getItem(i);
                SelectGroupActivity.a(a, adapterview);
            }

            
            {
                a = SelectGroupActivity.this;
                super();
            }
        };
    }

    static ArrayAdapter a(SelectGroupActivity selectgroupactivity)
    {
        return selectgroupactivity.b;
    }

    private void a()
    {
        (new AsyncTask() {

            final SelectGroupActivity a;

            protected transient List a(Void avoid[])
            {
                return com.cyberlink.you.e.f().b();
            }

            protected void a(List list)
            {
                if (list != null)
                {
                    SelectGroupActivity.a(a).clear();
                    SelectGroupActivity.a(a).addAll(list);
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((List)obj);
            }

            
            {
                a = SelectGroupActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static void a(SelectGroupActivity selectgroupactivity, Group group)
    {
        selectgroupactivity.a(group);
    }

    private void a(Group group)
    {
        if (e != null)
        {
            String s = e.getComponent().getClassName();
            Log.d(a, (new StringBuilder()).append("start next activity : ").append(s).toString());
            if (s.equals(com/cyberlink/you/activity/ChatDialogActivity.getCanonicalName()))
            {
                e.putExtra("Group", group);
            }
            startActivity(e);
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_select_group);
        e = (Intent)getIntent().getExtras().getParcelable("nextIntent");
        b = new e(this, p.u_view_item_chat_group, new ArrayList());
        c = (ListView)findViewById(o.listView);
        c.setAdapter(b);
        c.setOnItemClickListener(g);
        d = findViewById(o.back);
        d.setOnClickListener(f);
        a();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        d.setOnClickListener(null);
        c.setOnItemClickListener(null);
    }

}
