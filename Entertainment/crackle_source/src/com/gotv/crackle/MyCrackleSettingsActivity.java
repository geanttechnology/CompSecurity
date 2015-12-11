// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.data.SocialOnAPI;
import com.gotv.crackle.dialogs.ParentalPinDialog;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.util.LocalNotificationManager;
import com.gotv.crackle.util.OmnitureWrapper;
import java.util.HashSet;

// Referenced classes of package com.gotv.crackle:
//            Application, FacebookHelperActivity

public class MyCrackleSettingsActivity extends BaseActivity
    implements com.gotv.crackle.data.DataRequest.DataRequestListener
{

    private boolean mIgnoreCheckChanged;
    private CheckBox mPcRestrictAllContentCheckBox;
    private SocialOnAPI mSocialOnAPI;

    public MyCrackleSettingsActivity()
    {
        mIgnoreCheckChanged = false;
        mSocialOnAPI = new SocialOnAPI();
    }

    private void displayParentalControlDialog(final com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl pc, final CheckBox checkBox)
    {
        final ParentalPinDialog dialog = new ParentalPinDialog(this);
        ((TextView)dialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
        dialog.setTitle(getString(0x7f0b0069));
        dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final MyCrackleSettingsActivity this$0;
            final CheckBox val$checkBox;
            final ParentalPinDialog val$dialog;
            final com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl val$pc;

            public void onDismiss(DialogInterface dialoginterface)
            {
label0:
                {
label1:
                    {
                        if (dialog.getCode().length() == 4)
                        {
                            if (!SharedPrefsManager.getIsParentalLockEnabled(pc))
                            {
                                break label0;
                            }
                            if (!SharedPrefsManager.getParentalLockCode().equalsIgnoreCase(dialog.getCode()))
                            {
                                break label1;
                            }
                            SharedPrefsManager.setIsParentalLockEnabled(pc, checkBox.isChecked());
                        }
                        return;
                    }
                    dialog.show();
                    return;
                }
                SharedPrefsManager.setParentalLockCode(dialog.getCode());
                SharedPrefsManager.setIsParentalLockEnabled(pc, checkBox.isChecked());
            }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                dialog = parentalpindialog;
                pc = parentalcontrol;
                checkBox = checkbox;
                super();
            }
        });
        dialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final MyCrackleSettingsActivity this$0;
            final CheckBox val$checkBox;
            final com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl val$pc;

            public void onCancel(DialogInterface dialoginterface)
            {
                boolean flag1 = true;
                mIgnoreCheckChanged = true;
                dialoginterface = pc;
                boolean flag;
                if (!checkBox.isChecked())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                SharedPrefsManager.setIsParentalLockEnabled(dialoginterface, flag);
                dialoginterface = checkBox;
                if (!checkBox.isChecked())
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                dialoginterface.setChecked(flag);
            }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                pc = parentalcontrol;
                checkBox = checkbox;
                super();
            }
        });
        if (mIgnoreCheckChanged)
        {
            mIgnoreCheckChanged = false;
            return;
        } else
        {
            dialog.show();
            return;
        }
    }

    private void setupUI()
    {
        if (Application.isLeanBack())
        {
            findViewById(0x7f0a0132).setBackgroundColor(getResources().getColor(0x7f070027));
            mRootView = findViewById(0x1020002);
            mRootView.setPadding(Application.getDisplayIndependantPixelSize(20), mRootView.getPaddingTop(), Application.getDisplayIndependantPixelSize(20), Application.getDisplayIndependantPixelSize(20));
            mRootView.setBackgroundColor(getResources().getColor(0x7f070027));
        }
        Button button = (Button)findViewById(0x7f0a0134);
        final CheckBox showResumePromptCheckBox = (CheckBox)findViewById(0x7f0a0135);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleSettingsActivity this$0;
            final CheckBox val$showResumePromptCheckBox;

            public void onClick(View view)
            {
                view = showResumePromptCheckBox;
                boolean flag;
                if (!showResumePromptCheckBox.isChecked())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setChecked(flag);
            }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                showResumePromptCheckBox = checkbox;
                super();
            }
        });
        showResumePromptCheckBox.setChecked(SharedPrefsManager.getShowResumePrompt());
        showResumePromptCheckBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final MyCrackleSettingsActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                SharedPrefsManager.setShowResumePrompt(flag);
            }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                super();
            }
        });
        if (Application.isLeanBack())
        {
            findViewById(0x7f0a0136).setVisibility(8);
        } else
        {
            Button button1 = (Button)findViewById(0x7f0a0137);
            final CheckBox wifiOnlyCheckBox = (CheckBox)findViewById(0x7f0a0138);
            button1.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCrackleSettingsActivity this$0;
                final CheckBox val$wifiOnlyCheckBox;

                public void onClick(View view)
                {
                    view = wifiOnlyCheckBox;
                    boolean flag;
                    if (!wifiOnlyCheckBox.isChecked())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    view.setChecked(flag);
                }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                wifiOnlyCheckBox = checkbox;
                super();
            }
            });
            wifiOnlyCheckBox.setChecked(SharedPrefsManager.getWifiOnlyEnabled());
            wifiOnlyCheckBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                final MyCrackleSettingsActivity this$0;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    SharedPrefsManager.setWifiOnlyEnabled(flag);
                }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                super();
            }
            });
        }
        if (Application.isLeanBack())
        {
            findViewById(0x7f0a013b).setVisibility(8);
        } else
        {
            Button button2 = (Button)findViewById(0x7f0a013c);
            final CheckBox onFacebookCheckBox = (CheckBox)findViewById(0x7f0a013d);
            button2.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCrackleSettingsActivity this$0;
                final CheckBox val$onFacebookCheckBox;

                public void onClick(View view)
                {
                    view = onFacebookCheckBox;
                    boolean flag;
                    if (!onFacebookCheckBox.isChecked())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    view.setChecked(flag);
                }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                onFacebookCheckBox = checkbox;
                super();
            }
            });
            onFacebookCheckBox.setChecked(SharedPrefsManager.getSocialOnEnabled());
            onFacebookCheckBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                final MyCrackleSettingsActivity this$0;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    if (flag)
                    {
                        compoundbutton = new Intent(MyCrackleSettingsActivity.this, com/gotv/crackle/FacebookHelperActivity);
                        compoundbutton.putExtra("REQUEST_TYPE", 0);
                        startActivity(compoundbutton);
                    } else
                    {
                        compoundbutton = CrackleAccountManager.getUserID();
                        if (compoundbutton != null)
                        {
                            mSocialOnAPI.updateSocialSettings(MyCrackleSettingsActivity.this, compoundbutton, false, true);
                            return;
                        }
                    }
                }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                super();
            }
            });
        }
        button = (Button)findViewById(0x7f0a0139);
        mPcRestrictAllContentCheckBox = (CheckBox)findViewById(0x7f0a013a);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleSettingsActivity this$0;

            public void onClick(View view)
            {
                view = mPcRestrictAllContentCheckBox;
                boolean flag;
                if (!mPcRestrictAllContentCheckBox.isChecked())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setChecked(flag);
            }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                super();
            }
        });
        if (SharedPrefsManager.getIsParentalLockEnabled(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_MATURE_CONTENT))
        {
            mPcRestrictAllContentCheckBox.setChecked(true);
        }
        if (SharedPrefsManager.getIsParentalLockEnabled(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_ALL_CONTENT))
        {
            mPcRestrictAllContentCheckBox.setChecked(true);
        }
        mPcRestrictAllContentCheckBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final MyCrackleSettingsActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                displayParentalControlDialog(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_ALL_CONTENT, mPcRestrictAllContentCheckBox);
            }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                super();
            }
        });
        if (Application.isFanhattan())
        {
            findViewById(0x7f0a013e).setVisibility(8);
        } else
        {
            Button button3 = (Button)findViewById(0x7f0a013f);
            final CheckBox alertOnWatchlistExpiring = (CheckBox)findViewById(0x7f0a0140);
            button3.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCrackleSettingsActivity this$0;
                final CheckBox val$alertOnWatchlistExpiring;

                public void onClick(View view)
                {
                    view = alertOnWatchlistExpiring;
                    boolean flag;
                    if (!alertOnWatchlistExpiring.isChecked())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    view.setChecked(flag);
                }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                alertOnWatchlistExpiring = checkbox;
                super();
            }
            });
            alertOnWatchlistExpiring.setChecked(SharedPrefsManager.getIsWatchlistNotificationEnabled());
            alertOnWatchlistExpiring.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                final MyCrackleSettingsActivity this$0;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    SharedPrefsManager.setIsWatchlistNotificationEnabled(flag);
                }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                super();
            }
            });
        }
        if (Application.isLeanBack() || false)
        {
            findViewById(0x7f0a0141).setVisibility(8);
            return;
        } else
        {
            Button button4 = (Button)findViewById(0x7f0a0142);
            final CheckBox alertNewMoviesAndShows = (CheckBox)findViewById(0x7f0a0143);
            button4.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCrackleSettingsActivity this$0;
                final CheckBox val$alertNewMoviesAndShows;

                public void onClick(View view)
                {
                    view = alertNewMoviesAndShows;
                    boolean flag;
                    if (!alertNewMoviesAndShows.isChecked())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    view.setChecked(flag);
                }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                alertNewMoviesAndShows = checkbox;
                super();
            }
            });
            alertNewMoviesAndShows.setChecked(SharedPrefsManager.getIsPushEnabled());
            alertNewMoviesAndShows.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                final MyCrackleSettingsActivity this$0;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    SharedPrefsManager.setIsPushEnabled(flag);
                    (new HashSet(1)).add(Application.getInstance().getLocalization().getCurrentCountryCode());
                    (new LocalNotificationManager()).create2DayNotification(MyCrackleSettingsActivity.this);
                }

            
            {
                this$0 = MyCrackleSettingsActivity.this;
                super();
            }
            });
            return;
        }
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03005f);
        setActionBarTitle(getResources().getString(0x7f0b011a));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0f0006, menu);
        mChromeCastHelper.setupMenuItem(menu);
        return true;
    }

    public void onDataFailed(String s, String s1)
    {
    }

    public void onDataSuccess(String s)
    {
        if (s.equalsIgnoreCase("SOCIAL SETTINGS"))
        {
            SharedPrefsManager.setSocialOnEnabled(false);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        performMenuAction(menuitem.getItemId());
        return true;
    }

    protected void onResume()
    {
        Application.getInstance().getOmnitureTracker().myCracklePage("settings");
        setupUI();
        super.onResume();
    }

    protected void performMenuAction(int i)
    {
        if (i == 0x102002c)
        {
            finish();
        }
    }





/*
    static boolean access$302(MyCrackleSettingsActivity mycracklesettingsactivity, boolean flag)
    {
        mycracklesettingsactivity.mIgnoreCheckChanged = flag;
        return flag;
    }

*/
}
