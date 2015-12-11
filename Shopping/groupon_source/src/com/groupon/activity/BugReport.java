// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.db.dao.DaoBugReportEmail;
import com.groupon.db.models.BugReportEmail;
import com.groupon.service.DeviceConfigurationLogger;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.CacheUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.EmailSyncManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import java.io.File;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, Gifting

public class BugReport extends GrouponActivity
    implements GrouponDialogListener
{

    private static final String REPORT_A_BUG_THANKS_DIALOG = "report_a_bug_thanks_dialog";
    private static final String SCREENSHOT_VIEW_VISIBILITY = "screenshotViewVisibility";
    private AbTestService abtestService;
    String activityName;
    EditText bugDescription;
    private DaoBugReportEmail bugReportEmailDao;
    private ConsumerDeviceSettings consumerDeviceSettings;
    private DeviceInfoUtil deviceInfoUtil;
    private DialogManager dialogManager;
    private DateFormat fullDateTimeFormat;
    private InternetUsDateFormat internetUsDateFormat;
    private LocationService locationService;
    private LoginService loginService;
    private SharedPreferences prefs;
    Button removeButton;
    String screenshotFilename;
    ImageView screenshotView;
    EditText senderEmail;
    private EmailSyncManager syncManager;

    public BugReport()
    {
    }

    protected void displayScreenShot(String s)
    {
        s = CacheUtils.getScreenshotCacheDirWithNewFile(s, getApplicationContext());
        if (s.length() < 0xf4240L)
        {
            s = BitmapFactory.decodeFile(s.getAbsolutePath());
            if (s != null)
            {
                screenshotView.setImageBitmap(s);
                return;
            }
        }
        hideScreenshot();
    }

    protected String generateEmailBody()
    {
        Object obj = locationService.getLocation();
        Object obj1 = abtestService.listExperiments();
        ArrayList arraylist = new ArrayList(((List) (obj1)).size());
        String s;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); arraylist.add((new StringBuilder()).append(s).append(": ").append(abtestService.getVariant(s)).toString()))
        {
            s = (String)((Iterator) (obj1)).next();
        }

        obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append("*Description*: ").append(bugDescription.getText().toString()).append("\n");
        ((StringBuilder) (obj1)).append("*Manufacturer,Model,Product,Brand*: ").append(DeviceConfigurationLogger.getBuildConfigurationString()).append("\n");
        ((StringBuilder) (obj1)).append("*Android Version*: ").append(android.os.Build.VERSION.RELEASE).append("\n");
        ((StringBuilder) (obj1)).append("*Build Version*: ").append(consumerDeviceSettings.getVersion()).append("\n");
        ((StringBuilder) (obj1)).append("*User's Name*: ").append(loginService.getFullName()).append("\n");
        ((StringBuilder) (obj1)).append("*Username*: ").append(loginService.getUsername()).append("\n");
        ((StringBuilder) (obj1)).append("*User Id*: ").append(loginService.getUserId()).append("\n");
        ((StringBuilder) (obj1)).append("*User Permalink*: ").append(consumerDeviceSettings.getUserPermalink()).append("\n");
        ((StringBuilder) (obj1)).append("*Sender Email*: ").append(senderEmail.getText().toString()).append("\n");
        ((StringBuilder) (obj1)).append("*Country Division*: ").append(consumerDeviceSettings.getCountryCode()).append("\n");
        ((StringBuilder) (obj1)).append("*Current Activity*: ").append(activityName).append("\n");
        ((StringBuilder) (obj1)).append("*Local Time*: ").append(fullDateTimeFormat.format(new Date())).append("\n");
        ((StringBuilder) (obj1)).append("*Useragent*: ").append(consumerDeviceSettings.getUserAgent()).append("\n");
        ((StringBuilder) (obj1)).append("*Device ID*: ").append(consumerDeviceSettings.getDeviceID()).append("\n");
        ((StringBuilder) (obj1)).append("*Bcookie*: ").append(consumerDeviceSettings.getBcookie()).append("\n");
        if (obj != null)
        {
            obj = (new StringBuilder()).append(((Location) (obj)).getLatitude()).append(",").append(((Location) (obj)).getLongitude()).toString();
            ((StringBuilder) (obj1)).append("*Location*: ").append(((String) (obj))).append("\n");
            try
            {
                ((StringBuilder) (obj1)).append("*Location URL*: ").append("https://www.google.com/#q=").append(URLEncoder.encode(((String) (obj)), "UTF-8")).append("\n");
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception);
            }
        }
        ((StringBuilder) (obj1)).append("*Display Metrics*: ").append(deviceInfoUtil.getDisplayMetrics().toString()).append("\n").append("*AB Test Settings*:\n\t").append(Strings.join("\n\t", arraylist)).append("\n");
        return ((StringBuilder) (obj1)).toString();
    }

    protected String generateEmailSubject()
    {
        String s = bugDescription.getText().toString();
        return (new StringBuilder()).append(senderEmail.getText().toString()).append(" ").append(internetUsDateFormat.format("yyyy/MM/dd HH:mm", new Date())).append(" ").append(s.substring(0, Math.min(s.length(), 20))).toString();
    }

    protected void hideScreenshot()
    {
        removeButton.setVisibility(8);
        screenshotView.setVisibility(8);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f08031b));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030047);
        if (bundle != null)
        {
            int i;
            if (bundle.getBoolean("screenshotViewVisibility", true))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            removeButton.setVisibility(i);
            screenshotView.setVisibility(i);
        }
        bundle = loginService.getEmail();
        if (Strings.notEmpty(bundle))
        {
            senderEmail.setText(bundle);
            bugDescription.requestFocus();
        }
        removeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final BugReport this$0;

            public void onClick(View view)
            {
                hideScreenshot();
            }

            
            {
                this$0 = BugReport.this;
                super();
            }
        });
        if (Strings.notEmpty(screenshotFilename))
        {
            try
            {
                displayScreenShot(screenshotFilename);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Ln.e(bundle, "Report a bug", new Object[0]);
            }
            return;
        } else
        {
            hideScreenshot();
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        final GrouponDialogFragment dialogFragment = dialogManager.getDialogFragment(Integer.valueOf(0x7f08031d), Integer.valueOf(0x7f08031e), Integer.valueOf(0x7f080447), false);
        ActionBarUtil.addReportBugMenu(getMenuInflater(), menu).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

            final BugReport this$0;
            final GrouponDialogFragment val$dialogFragment;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                if (valid())
                {
                    GrouponDialogFragment.show(getFragmentManager(), dialogFragment, "report_a_bug_thanks_dialog");
                }
                return false;
            }

            
            {
                this$0 = BugReport.this;
                dialogFragment = groupondialogfragment;
                super();
            }
        });
        return true;
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "report_a_bug_thanks_dialog"))
        {
            try
            {
                s = new BugReportEmail();
                s.emailRecipient = prefs.getString("reportABugEmail", "");
                s.emailSubject = generateEmailSubject();
                s.emailBody = generateEmailBody();
                if (screenshotView.getVisibility() == 0)
                {
                    s.screenshotFileName = screenshotFilename;
                }
                bugReportEmailDao.create(s);
                syncManager.requestSync(null, null);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Ln.e((new StringBuilder()).append("Report a Bug: ").append(s).toString(), new Object[0]);
            }
            finish();
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        boolean flag;
        if (screenshotView.getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.putBoolean("screenshotViewVisibility", flag);
    }

    protected boolean valid()
    {
        boolean flag = true;
        if (Strings.isEmpty(bugDescription.getText()))
        {
            bugDescription.requestFocus();
            bugDescription.setError(getString(0x7f080131));
            flag = false;
        }
        if (!Gifting.isEmailValid(senderEmail.getText()))
        {
            senderEmail.requestFocus();
            senderEmail.setError(getString(0x7f080366));
            flag = false;
        }
        return flag;
    }
}
