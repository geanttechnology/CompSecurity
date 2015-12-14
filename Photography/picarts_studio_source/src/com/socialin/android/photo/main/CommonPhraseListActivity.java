// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.main;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.photo.database.a;

public class CommonPhraseListActivity extends BaseActivity
    implements android.app.LoaderManager.LoaderCallbacks
{

    private static final String a = com/socialin/android/photo/main/CommonPhraseListActivity.getSimpleName();
    private ListView b;
    private SimpleCursorAdapter c;

    public CommonPhraseListActivity()
    {
        b = null;
    }

    static SimpleCursorAdapter a(CommonPhraseListActivity commonphraselistactivity)
    {
        return commonphraselistactivity.c;
    }

    static ListView b(CommonPhraseListActivity commonphraselistactivity)
    {
        return commonphraselistactivity.b;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301ae);
        AnalyticUtils.getInstance(this).trackLocalAction("commonPhrase:onCreate");
        b = (ListView)findViewById(0x7f10080e);
        c = new SimpleCursorAdapter(this, 0x7f03014f, null, new String[] {
            "addtext_addedtext"
        }, new int[] {
            0x7f10027b
        }, 0);
        b.setAdapter(c);
        b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private CommonPhraseListActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = ((AdapterView) (com.socialin.android.photo.main.CommonPhraseListActivity.a(a).getItem(i)));
                if (adapterview != null && (adapterview instanceof Cursor) && ((Cursor)adapterview).moveToPosition(i))
                {
                    adapterview = (Cursor)adapterview;
                    view = new Intent();
                    view.putExtra("text", adapterview.getString(adapterview.getColumnIndex("addtext_addedtext")));
                    a.setResult(-1, view);
                    CommonPhraseListActivity.b(a).setAdapter(null);
                    a.finish();
                    AnalyticUtils.getInstance(a).trackLocalAction("commonPhrase:done");
                    adapterview.close();
                }
            }

            
            {
                a = CommonPhraseListActivity.this;
                super();
            }
        });
        getLoaderManager().initLoader(0, null, this);
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        bundle.setTitle(0x7f0805fe);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        try
        {
            bundle = new CursorLoader(this, a.a, new String[] {
                "_id", "addtext_addedtext"
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
            });
            return null;
        }
        return bundle;
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        loader = (Cursor)obj;
        try
        {
            c.swapCursor(loader);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Loader loader)
        {
            d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(loader.getMessage()).toString()
            });
        }
    }

    public void onLoaderReset(Loader loader)
    {
        try
        {
            c.swapCursor(null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Loader loader)
        {
            d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(loader.getMessage()).toString()
            });
        }
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
        if (true) goto _L1; else goto _L3
_L3:
    }

}
