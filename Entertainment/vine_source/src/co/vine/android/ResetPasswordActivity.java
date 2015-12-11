// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;
import co.vine.android.widget.Typefaces;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity

public class ResetPasswordActivity extends BaseControllerActionBarActivity
    implements TextWatcher
{
    private class ResetPasswordListener extends AppSessionListener
    {

        final ResetPasswordActivity this$0;

        public void onResetPasswordComplete(String s, int i, String s1)
        {
            dismissDialog();
            i;
            JVM INSTR lookupswitch 2: default 36
        //                       200: 69
        //                       404: 75;
               goto _L1 _L2 _L3
_L1:
            i = 0x7f0e016f;
_L5:
            s = PromptDialogSupportFragment.newInstance(1);
            s.setMessage(i);
            s.setPositiveButton(0x7f0e0163);
            s.show(getSupportFragmentManager());
            return;
_L2:
            i = 0x7f0e016e;
            continue; /* Loop/switch isn't completed */
_L3:
            i = 0x7f0e0170;
            if (true) goto _L5; else goto _L4
_L4:
        }

        private ResetPasswordListener()
        {
            this$0 = ResetPasswordActivity.this;
            super();
        }

    }


    private static final int DIALOG_CONFIRMED = 1;
    public static final String EXTRA_EMAIL = "email";
    private EditText mEmail;
    private MenuItem mSend;

    public ResetPasswordActivity()
    {
    }

    private boolean validate()
    {
        return mEmail.length() >= 3;
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030087, false);
        ((InputMethodManager)getSystemService("input_method")).showSoftInputFromInputMethod(getWindow().getDecorView().getWindowToken(), 0);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e0172, Boolean.valueOf(true));
        mAppSessionListener = new ResetPasswordListener();
        bundle = (EditText)findViewById(0x7f0a01e8);
        bundle.addTextChangedListener(this);
        bundle.setTypeface(Typefaces.get(this).getContentTypeface(0, 2));
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null && bundle1.containsKey("email"))
        {
            bundle.setText(bundle1.getString("email"));
            bundle.setSelection(bundle.length());
        }
        mEmail = bundle;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100010, menu);
        mSend = menu.findItem(0x7f0a024b);
        mSend.setEnabled(validate());
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362379: 
            break;
        }
        if (validate())
        {
            menuitem = new ProgressDialog(this, 0x7f0f0037);
            menuitem.setProgress(0);
            menuitem.setMessage(getString(0x7f0e00b9));
            menuitem.show();
            mProgressDialog = menuitem;
            mAppController.resetPassword(mEmail.getText().toString());
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        Util.setSoftKeyboardVisibility(this, mEmail, false);
    }

    protected void onResume()
    {
        super.onResume();
        Util.setSoftKeyboardVisibility(this, mEmail, true);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (mSend != null)
        {
            mSend.setEnabled(validate());
        }
    }
}
