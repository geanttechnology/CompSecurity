// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.ui.activities.b;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class EditPasswordActivity extends b
{

    EditText etPassword;
    EditText etPasswordConfirm;
    private boolean n;

    public EditPasswordActivity()
    {
    }

    private boolean a(String s, String s1)
    {
        boolean flag;
        if (s.equals("") || s1.equals(""))
        {
            Toast.makeText(this, getString(0x7f0901bb), 1).show();
            flag = false;
        } else
        {
            flag = true;
        }
        if (!s.equals(s1))
        {
            Toast.makeText(this, getString(0x7f0901bc), 1).show();
            flag = false;
        }
        if (s.trim().length() < 4)
        {
            Toast.makeText(this, getString(0x7f0900d0, new Object[] {
                Integer.valueOf(4)
            }), 1).show();
            return false;
        } else
        {
            return flag;
        }
    }

    private void d(String s)
    {
        w.setPassword(s);
        w.put("processed", Boolean.valueOf(false));
        w.saveInBackground(new SaveCallback() {

            final EditPasswordActivity a;

            public void done(ParseException parseexception)
            {
                if (parseexception == null)
                {
                    Toast.makeText(a, a.getString(0x7f0901c0), 1).show();
                    a.setResult(-1);
                    a.finish();
                    return;
                } else
                {
                    Toast.makeText(a, 0x7f090072, 0).show();
                    return;
                }
            }

            public volatile void done(Throwable throwable)
            {
                done((ParseException)throwable);
            }

            
            {
                a = EditPasswordActivity.this;
                super();
            }
        });
    }

    private void l()
    {
        String s = etPassword.getText().toString();
        if (a(s, etPasswordConfirm.getText().toString()))
        {
            d(s);
        }
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            a(0x7f0200d1);
            ButterKnife.bind(this);
            if (bundle != null)
            {
                n = bundle.getBoolean("changes");
            }
        }
    }

    protected void changeMenuIcon(CharSequence charsequence)
    {
        n = true;
        invalidateOptionsMenu();
    }

    protected void k()
    {
        setContentView(0x7f04002a);
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110009, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f100177)
        {
            l();
        }
        return super.onOptionsItemSelected(menuitem);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu = menu.findItem(0x7f100177);
        if (n)
        {
            menu.setIcon(0x7f0200e7);
            menu.setEnabled(true);
            return true;
        } else
        {
            menu.setIcon(0x7f0200e8);
            menu.setEnabled(false);
            return true;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("changes", n);
        super.onSaveInstanceState(bundle);
    }
}
