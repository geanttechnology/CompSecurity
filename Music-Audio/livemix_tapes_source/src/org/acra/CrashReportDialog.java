// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.IOException;
import org.acra.collector.CrashReportData;
import org.acra.log.ACRALog;
import org.acra.util.ToastSender;

// Referenced classes of package org.acra:
//            ACRA, ACRAConfiguration, ErrorReporter, CrashReportPersister, 
//            ReportField

public class CrashReportDialog extends Activity
    implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener
{

    private static final String STATE_COMMENT = "comment";
    private static final String STATE_EMAIL = "email";
    AlertDialog mDialog;
    String mReportFileName;
    private SharedPreferences prefs;
    private EditText userComment;
    private EditText userEmail;

    public CrashReportDialog()
    {
    }

    private View buildCustomView(Bundle bundle)
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        linearlayout.setPadding(10, 10, 10, 10);
        linearlayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
        linearlayout.setFocusable(true);
        linearlayout.setFocusableInTouchMode(true);
        Object obj = new ScrollView(this);
        linearlayout.addView(((View) (obj)), new android.widget.LinearLayout.LayoutParams(-1, -1, 1.0F));
        LinearLayout linearlayout1 = new LinearLayout(this);
        linearlayout1.setOrientation(1);
        ((ScrollView) (obj)).addView(linearlayout1);
        obj = new TextView(this);
        int i = ACRA.getConfig().resDialogText();
        if (i != 0)
        {
            ((TextView) (obj)).setText(getText(i));
        }
        linearlayout1.addView(((View) (obj)));
        i = ACRA.getConfig().resDialogCommentPrompt();
        if (i != 0)
        {
            TextView textview = new TextView(this);
            textview.setText(getText(i));
            textview.setPadding(textview.getPaddingLeft(), 10, textview.getPaddingRight(), textview.getPaddingBottom());
            linearlayout1.addView(textview, new android.widget.LinearLayout.LayoutParams(-1, -2));
            userComment = new EditText(this);
            userComment.setLines(2);
            if (bundle != null)
            {
                String s = bundle.getString("comment");
                if (s != null)
                {
                    userComment.setText(s);
                }
            }
            linearlayout1.addView(userComment);
        }
        i = ACRA.getConfig().resDialogEmailPrompt();
        if (i != 0)
        {
            Object obj1 = new TextView(this);
            ((TextView) (obj1)).setText(getText(i));
            ((TextView) (obj1)).setPadding(((TextView) (obj1)).getPaddingLeft(), 10, ((TextView) (obj1)).getPaddingRight(), ((TextView) (obj1)).getPaddingBottom());
            linearlayout1.addView(((View) (obj1)));
            userEmail = new EditText(this);
            userEmail.setSingleLine();
            userEmail.setInputType(33);
            prefs = getSharedPreferences(ACRA.getConfig().sharedPreferencesName(), ACRA.getConfig().sharedPreferencesMode());
            obj1 = null;
            if (bundle != null)
            {
                obj1 = bundle.getString("email");
            }
            if (obj1 != null)
            {
                userEmail.setText(((CharSequence) (obj1)));
            } else
            {
                userEmail.setText(prefs.getString("acra.user.email", ""));
            }
            linearlayout1.addView(userEmail);
        }
        return linearlayout;
    }

    private void cancelReports()
    {
        ACRA.getErrorReporter().deletePendingNonApprovedReports(false);
    }

    private void sendCrash()
    {
        String s;
        String s1;
        CrashReportPersister crashreportpersister;
        int i;
        if (userComment != null)
        {
            s = userComment.getText().toString();
        } else
        {
            s = "";
        }
        if (prefs != null && userEmail != null)
        {
            s1 = userEmail.getText().toString();
            android.content.SharedPreferences.Editor editor = prefs.edit();
            editor.putString("acra.user.email", s1);
            editor.commit();
        } else
        {
            s1 = "";
        }
        crashreportpersister = new CrashReportPersister(getApplicationContext());
        try
        {
            Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Add user comment to ").append(mReportFileName).toString());
            CrashReportData crashreportdata = crashreportpersister.load(mReportFileName);
            crashreportdata.put(ReportField.USER_COMMENT, s);
            crashreportdata.put(ReportField.USER_EMAIL, s1);
            crashreportpersister.store(crashreportdata, mReportFileName);
        }
        catch (IOException ioexception)
        {
            Log.w(ACRA.LOG_TAG, "User comment not added: ", ioexception);
        }
        Log.v(ACRA.LOG_TAG, "About to start SenderWorker from CrashReportDialog");
        ACRA.getErrorReporter().startSendingReports(false, true);
        i = ACRA.getConfig().resDialogOkToast();
        if (i != 0)
        {
            ToastSender.sendToast(getApplicationContext(), i, 1);
        }
    }

    protected void cancelNotification()
    {
        ((NotificationManager)getSystemService("notification")).cancel(666);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            sendCrash();
        } else
        {
            cancelReports();
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("FORCE_CANCEL", false))
        {
            ACRA.log.d(ACRA.LOG_TAG, "Forced reports deletion.");
            cancelReports();
            finish();
            return;
        }
        mReportFileName = getIntent().getStringExtra("REPORT_FILE_NAME");
        Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Opening CrashReportDialog for ").append(mReportFileName).toString());
        if (mReportFileName == null)
        {
            finish();
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        int i = ACRA.getConfig().resDialogTitle();
        if (i != 0)
        {
            builder.setTitle(i);
        }
        i = ACRA.getConfig().resDialogIcon();
        if (i != 0)
        {
            builder.setIcon(i);
        }
        builder.setView(buildCustomView(bundle));
        builder.setPositiveButton(0x104000a, this);
        builder.setNegativeButton(0x1040000, this);
        cancelNotification();
        mDialog = builder.create();
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.setOnDismissListener(this);
        mDialog.show();
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        finish();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (userComment != null && userComment.getText() != null)
        {
            bundle.putString("comment", userComment.getText().toString());
        }
        if (userEmail != null && userEmail.getText() != null)
        {
            bundle.putString("email", userEmail.getText().toString());
        }
    }
}
