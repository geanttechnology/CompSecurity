// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.ef;
import android.support.v7.eg;
import android.support.v7.fl;
import android.support.v7.fm;
import android.support.v7.gh;
import android.support.v7.hf;
import android.support.v7.hg;
import android.support.v7.ic;
import android.support.v7.is;
import android.support.v7.iu;
import android.support.v7.iv;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.LetgoApplication;
import com.abtnprojects.ambatana.i;
import com.abtnprojects.ambatana.ui.activities.ProductListingActivity;
import com.abtnprojects.ambatana.ui.activities.b;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import java.util.Locale;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditPasswordActivity, EditLocationActivity

public class EditProfileActivity extends b
{

    private fl A;
    private boolean B;
    private ProgressDialog C;
    private hf D;
    private int E;
    private boolean F;
    private int G;
    EditText etUserName;
    ImageView ivUserAvatar;
    private boolean n;
    RadioButton rbKm;
    RadioButton rbMl;
    ViewSwitcher vsAvatar;

    public EditProfileActivity()
    {
    }

    private void C()
    {
        Object obj = w.getParseFile("avatar");
        if (obj != null)
        {
            obj = ((ParseFile) (obj)).getUrl();
            if (!TextUtils.isEmpty(((CharSequence) (obj))) && A != null)
            {
                A.a(Uri.parse(((String) (obj))));
            }
        }
    }

    private void D()
    {
        Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/activities/ProductListingActivity);
        intent.setFlags(0x10008000);
        startActivity(intent);
        finish();
    }

    private void E()
    {
        F();
        d(etUserName.getText().toString().trim());
    }

    private void F()
    {
        if (rbKm.isChecked())
        {
            is.a(this, "km");
            setResult(2);
        } else
        if (rbMl.isChecked())
        {
            is.a(this, "mi");
            setResult(2);
            return;
        }
    }

    static ProgressDialog a(EditProfileActivity editprofileactivity)
    {
        return editprofileactivity.C;
    }

    static hf b(EditProfileActivity editprofileactivity)
    {
        return editprofileactivity.D;
    }

    private void d(String s)
    {
        if (s.equals(w.getString("username_public")))
        {
            finish();
            return;
        }
        if (iv.b(this))
        {
            if (e(s))
            {
                C = ProgressDialog.show(this, null, getString(0x7f0901b9), true, false);
                w.put("username_public", s);
                w.put("processed", Boolean.valueOf(false));
                w.saveInBackground(new SaveCallback() {

                    final EditProfileActivity a;

                    public void done(ParseException parseexception)
                    {
                        iv.a(EditProfileActivity.a(a));
                        if (parseexception == null)
                        {
                            com.abtnprojects.ambatana.ui.activities.profile.EditProfileActivity.b(a).c(a);
                            a.setResult(-1);
                            a.finish();
                            return;
                        } else
                        {
                            Toast.makeText(a, 0x7f090072, 1).show();
                            return;
                        }
                    }

                    public volatile void done(Throwable throwable)
                    {
                        done((ParseException)throwable);
                    }

            
            {
                a = EditProfileActivity.this;
                super();
            }
                });
                return;
            } else
            {
                finish();
                return;
            }
        } else
        {
            Toast.makeText(this, 0x7f090072, 0).show();
            return;
        }
    }

    private boolean e(String s)
    {
        for (String s1 = w.getString("username_public"); s.length() < 2 || s.equals(s1);)
        {
            return false;
        }

        return true;
    }

    private void l()
    {
        E = 0;
        String s = is.a(this, Locale.getDefault());
        if (s.equals("mi"))
        {
            rbMl.setChecked(true);
            rbKm.setChecked(false);
            return;
        }
        if (s.equals("km"))
        {
            rbMl.setChecked(false);
            rbKm.setChecked(true);
            return;
        } else
        {
            throw new IllegalArgumentException("Distance has to be either KM or ML");
        }
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            D = (new hg()).a(new gh(), ParseUser.getCurrentUser(), new iu());
            D.a(this);
            a(0x7f0200d1);
            b(0x7f040019);
            ButterKnife.bind(this);
            l();
            A = new i(this, vsAvatar, ivUserAvatar, w);
            C();
            String s = w.getString("username_public");
            etUserName.setText(s);
            int j = etUserName.length();
            etUserName.setSelection(j);
            n = true;
            if (bundle != null)
            {
                F = bundle.getBoolean("changes");
            }
        }
    }

    protected void k()
    {
        setContentView(0x7f040028);
    }

    protected boolean m()
    {
        return false;
    }

    protected void notifyChangeSaveIcon(CharSequence charsequence)
    {
        G = G + 1;
        if (G > 1)
        {
            F = true;
            invalidateOptionsMenu();
        }
    }

    protected void onActivityResult(int j, int i1, Intent intent)
    {
        super.onActivityResult(j, i1, intent);
        j;
        JVM INSTR lookupswitch 4: default 52
    //                   0: 64
    //                   1: 64
    //                   217: 53
    //                   218: 52;
           goto _L1 _L2 _L2 _L3 _L1
_L1:
        return;
_L3:
        if (i1 == -1)
        {
            setResult(-1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        B = true;
        D.d(this);
        A.a(j, i1, intent);
        if (i1 == -1)
        {
            setResult(-1);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onBackPressed()
    {
        if (E <= 1)
        {
            D.b(this);
        }
        super.onBackPressed();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110007, menu);
        return true;
    }

    protected void onDestroy()
    {
        iv.a(C);
        super.onDestroy();
    }

    protected void onEditAvatarTap()
    {
        A.c();
    }

    protected void onEditPasswordTap()
    {
        startActivityForResult(new Intent(this, com/abtnprojects/ambatana/ui/activities/profile/EditPasswordActivity), 218);
    }

    public void onEvent(ef ef)
    {
        D.a(ParseUser.getCurrentUser());
        iv.a(C);
        is.b(this);
        is.i(this);
        is.k(this);
        is.m(this);
        D();
    }

    public void onEvent(eg eg)
    {
        C = ProgressDialog.show(this, null, getString(0x7f0900cc), true, false);
    }

    protected boolean onFinishEditingUsername(int j)
    {
        if (j == 6)
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(etUserName.getWindowToken(), 0);
            F = true;
            invalidateOptionsMenu();
            return true;
        } else
        {
            return false;
        }
    }

    protected void onHelpTap()
    {
        x.c();
    }

    void onKmChecked(boolean flag)
    {
        if (flag)
        {
            E = E + 1;
            if (E > 1)
            {
                F = true;
                D.g(this);
                invalidateOptionsMenu();
            }
        }
    }

    protected void onLogoutTap()
    {
        if (LetgoApplication.a != null)
        {
            LetgoApplication.a = null;
        }
        D.e(this);
        fm fm1 = new fm(getApplicationContext());
        Void avoid[] = new Void[0];
        if (!(fm1 instanceof AsyncTask))
        {
            fm1.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)fm1, avoid);
            return;
        }
    }

    void onMilesChecked(boolean flag)
    {
        if (flag)
        {
            E = E + 1;
            if (E > 1)
            {
                F = true;
                D.f(this);
                invalidateOptionsMenu();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f100175)
        {
            E();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        iv.b(this);
        iv.a(C);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu = menu.findItem(0x7f100175);
        if (F)
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

    protected void onResume()
    {
        super.onResume();
        if (!n && !B)
        {
            w = ParseUser.getCurrentUser();
            C();
        }
        n = false;
        B = false;
        iv.a(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("changes", F);
        super.onSaveInstanceState(bundle);
    }

    void onUserLocationEditPressed()
    {
        startActivityForResult(new Intent(this, com/abtnprojects/ambatana/ui/activities/profile/EditLocationActivity), 600);
    }

    protected void onUsernameFocusChanged(boolean flag)
    {
        if (flag)
        {
            int j = etUserName.length();
            etUserName.setSelection(j);
        }
    }

    protected void onUsernameTap()
    {
        etUserName.setCursorVisible(true);
    }
}
