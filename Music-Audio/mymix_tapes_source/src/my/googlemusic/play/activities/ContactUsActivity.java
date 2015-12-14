// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import my.googlemusic.play.utils.appbar.AppBar;

public class ContactUsActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, android.view.View.OnClickListener
{
    public class DialogContactFragment extends DialogFragment
    {

        final ContactUsActivity this$0;

        public Dialog onCreateDialog(Bundle bundle)
        {
            bundle = new android.app.AlertDialog.Builder(new ContextThemeWrapper(getActivity(), 0x7f0800e7));
        /* block-local class not found */
        class _cls2 {}

        /* block-local class not found */
        class _cls1 {}

            bundle.setView(getActivity().getLayoutInflater().inflate(0x7f030048, null)).setPositiveButton("Send email", new _cls2()).setNegativeButton("Cancel", new _cls1());
            return bundle.create();
        }

        public DialogContactFragment()
        {
            this$0 = ContactUsActivity.this;
            super();
        }
    }

    public class DialogTermFragment extends DialogFragment
    {

        final ContactUsActivity this$0;

        public Dialog onCreateDialog(Bundle bundle)
        {
            bundle = new android.app.AlertDialog.Builder(new ContextThemeWrapper(getActivity(), 0x7f0800e7));
            bundle.setView(getActivity().getLayoutInflater().inflate(0x7f030049, null));
            return bundle.create();
        }

        public DialogTermFragment()
        {
            this$0 = ContactUsActivity.this;
            super();
        }
    }

    private static class ViewHolder
    {

        TextView digital;
        TextView feedback;
        TextView sales;
        TextView terms;
        TextView version;

        private ViewHolder()
        {
        }

    }


    ViewHolder mHolder;

    public ContactUsActivity()
    {
    }

    private void sendEmail(String s, String s1)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            s
        });
        intent.putExtra("android.intent.extra.SUBJECT", s1);
        try
        {
            startActivity(Intent.createChooser(intent, "Send mail..."));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Toast.makeText(this, "There is no email client installed.", 0).show();
        }
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    public void onClick(View view)
    {
        if (view == mHolder.terms)
        {
            (new DialogTermFragment()).show(getSupportFragmentManager(), null);
        } else
        {
            if (view == mHolder.sales)
            {
                sendEmail("sales@mymixtapez.com", "Sales");
                return;
            }
            if (view == mHolder.digital)
            {
                (new DialogContactFragment()).show(getSupportFragmentManager(), null);
                return;
            }
            if (view == mHolder.feedback)
            {
                sendEmail("support@mymixtapez.com", "Support/Feedback");
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        setContentView(0x7f03001e);
        mHolder = new ViewHolder();
        mHolder.terms = (TextView)findViewById(0x7f0d0099);
        mHolder.sales = (TextView)findViewById(0x7f0d009d);
        mHolder.digital = (TextView)findViewById(0x7f0d00a0);
        mHolder.feedback = (TextView)findViewById(0x7f0d009b);
        mHolder.version = (TextView)findViewById(0x7f0d0098);
        mHolder.terms.setOnClickListener(this);
        mHolder.sales.setOnClickListener(this);
        mHolder.digital.setOnClickListener(this);
        mHolder.feedback.setOnClickListener(this);
        AppBar.with(findViewById(0x7f0d0074), this).title("Contact us").back();
        try
        {
            mHolder.version.setText((new StringBuilder()).append("Version ").append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName).append("\n").append(mHolder.version.getText()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            mHolder.version.setText((new StringBuilder()).append("Version 3.0\n").append(mHolder.version.getText()).toString());
        }
        bundle.printStackTrace();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        onBackPressed();
        if (true) goto _L1; else goto _L3
_L3:
    }

}
