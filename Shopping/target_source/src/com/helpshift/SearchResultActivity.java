// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.helpshift.g.a.a;
import com.helpshift.g.a.b;
import com.helpshift.i.e;
import com.helpshift.i.f;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.helpshift:
//            h, l, s, v, 
//            g, HSQuestion, o

public final class SearchResultActivity extends h
{

    private l a;

    public SearchResultActivity()
    {
    }

    private void a(com.helpshift.b.b b1)
    {
        h().setAdapter(b1);
    }

    private ListView h()
    {
        return (ListView)findViewById(0x102000a);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1 && i == 32699)
        {
            Intent intent1 = new Intent();
            intent1.putExtras(intent);
            setResult(-1, intent1);
            finish();
        }
    }

    public volatile void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (Boolean.valueOf(getIntent().getExtras().getBoolean("showInFullScreen")).booleanValue())
        {
            getWindow().setFlags(1024, 1024);
        }
        a = new l(this);
        setContentView(b.d.D);
        if (!a.a.Z())
        {
            bundle = (ImageView)findViewById(b.c.l);
            bundle.setImageDrawable(com.helpshift.g.a.a.a(this, (String)b.a.get("newHSLogo")));
            bundle.setBackgroundResource(0x106000c);
        }
        bundle = (TextView)getLayoutInflater().inflate(b.d.G, null, false);
        f.a(bundle, 0.5F);
        h().addHeaderView(bundle, "", false);
        h().addFooterView(getLayoutInflater().inflate(b.d.F, null, false));
        bundle = i();
        bundle.a(true);
        bundle.a(getResources().getString(b.g.N));
        bundle = getIntent().getExtras().getString("searchQuery");
        bundle = (new l(this)).a(bundle, q.a.c);
        int i;
        if (bundle.size() < 3)
        {
            i = bundle.size();
        } else
        {
            i = 3;
        }
        a(new com.helpshift.b.b(this, b.d.E, bundle.subList(0, i)));
        h().setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(bundle) {

            final ArrayList a;
            final SearchResultActivity b;

            public void onItemClick(AdapterView adapterview, View view, int j, long l1)
            {
                adapterview = (g)a.get(j - 1);
                view = new Intent(b, com/helpshift/HSQuestion);
                view.putExtra("questionPublishId", adapterview.b());
                view.putExtra("searchTerms", adapterview.j());
                view.putExtra("questionFlow", "showSearchOnNewConversationFlow");
                view.putExtra("showInFullScreen", e.a(b));
                b.startActivityForResult(view, 32699);
            }

            
            {
                b = SearchResultActivity.this;
                a = arraylist;
                super();
            }
        });
        ((Button)findViewById(b.c.ah)).setOnClickListener(new android.view.View.OnClickListener() {

            final SearchResultActivity a;

            public void onClick(View view)
            {
                com.helpshift.o.a("taf");
                view = new Intent();
                view.putExtra("action", "startConversation");
                a.setResult(-1, view);
                a.finish();
            }

            
            {
                a = SearchResultActivity.this;
                super();
            }
        });
    }

    public volatile boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        com.helpshift.v.a(null);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onResume()
    {
        super.onResume();
        com.helpshift.v.a("issue-filing");
    }

    public volatile void onStart()
    {
        super.onStart();
    }

    public volatile void onStop()
    {
        super.onStop();
    }
}
