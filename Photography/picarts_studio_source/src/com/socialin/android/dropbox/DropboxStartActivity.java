// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dropbox;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.dialog.b;
import com.socialin.android.oauth2.a;
import com.socialin.android.util.Utils;
import myobfuscated.bt.c;
import myobfuscated.bt.i;
import org.json.JSONArray;

public class DropboxStartActivity extends BaseActivity
{

    public boolean a;
    public i b;
    private c c;

    public DropboxStartActivity()
    {
        a = false;
        b = null;
        c = null;
    }

    static c a(DropboxStartActivity dropboxstartactivity)
    {
        return dropboxstartactivity.c;
    }

    private void a()
    {
        if ("".equals(c.b))
        {
            setResult(1);
            finish();
            return;
        } else
        {
            c.a(c.b);
            return;
        }
    }

    public void dismissFragmentProgressDialog()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03011b);
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setIcon(getResources().getDrawable(0x7f020345));
        bundle.setTitle(getResources().getString(0x7f0802bc));
        c = new c();
        bundle = getFragmentManager().beginTransaction();
        bundle.setTransition(8194);
        bundle.replace(0x7f10061c, c);
        bundle.commit();
        bundle = getIntent();
        if (bundle != null && bundle.hasExtra("multipleCheckMode"))
        {
            a = bundle.getBooleanExtra("multipleCheckMode", false);
        }
        if (a)
        {
            b = new i();
            b.c = c;
            bundle = getFragmentManager().beginTransaction();
            bundle.replace(0x7f100505, b, "multiselectFragment");
            bundle.commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (c != null)
        {
            c c1 = c;
            if (c1.h == null)
            {
                c1.h = c1.getActivity().getSharedPreferences("DropboxPrefs", 0);
            }
            if (com.socialin.android.oauth2.a.b(c1.h))
            {
                MenuItemCompat.setShowAsAction(menu.add(0, 2, 0, getString(0x7f0802f9)), 0);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onFragmentFinishWithResultError(int j)
    {
        setResult(0);
        finish();
    }

    public void onFragmentImageSelected(String s, boolean flag, String as[], String as1[], int j, JSONArray jsonarray)
    {
        as = new Intent();
        as.putExtra("path", s);
        setResult(-1, as);
        finish();
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j == 4 && c != null)
        {
            a();
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 2)
        {
            b b1 = new b();
            b1.b = getString(0x7f0802fa);
            b1.a(getString(0x7f080373)).a(new android.view.View.OnClickListener() {

                private DropboxStartActivity a;

                public final void onClick(View view)
                {
                    if (com.socialin.android.dropbox.DropboxStartActivity.a(a) != null)
                    {
                        view = com.socialin.android.dropbox.DropboxStartActivity.a(a);
                        com.socialin.android.oauth2.a.a(((c) (view)).h);
                        Utils.c(view.getActivity());
                        if (view.getActivity() != null)
                        {
                            view.getActivity().finish();
                        }
                        return;
                    } else
                    {
                        view = a.getSharedPreferences("DropboxPrefs", 0);
                        Utils.c(a.getApplicationContext());
                        com.socialin.android.oauth2.a.a(view);
                        return;
                    }
                }

            
            {
                a = DropboxStartActivity.this;
                super();
            }
            }).b(getString(0x7f08030b)).a().show(getFragmentManager(), null);
        }
        if (menuitem.getItemId() == 0x102002c)
        {
            a();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void showFragmentNoNetworkDialog()
    {
    }

    public void showFragmentProgressDialog(String s, String s1, boolean flag)
    {
    }
}
