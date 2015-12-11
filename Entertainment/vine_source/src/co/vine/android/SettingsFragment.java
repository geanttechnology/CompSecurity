// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.service.GCMRegistrationService;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.ImageUtils;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.ColorPicker;
import co.vine.android.widget.TypingEditText;
import co.vine.android.widgets.PromptDialogSupportFragment;
import com.edisonwang.android.slog.SLog;
import com.facebook.Session;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, Settings, HomeTabActivity, EditProfileCropActivity, 
//            SetThumbnailTask, ResetPasswordActivity, ContentControlsActivity, PrivacyControlsActivity, 
//            FindFriendsActivity, WebViewActivity, DebugHomeActivity, LocaleDialog, 
//            NotificationSettingsActivity, ConfirmationFlowActivity, ImagePicker, VineLoggingException, 
//            StartActivity

public class SettingsFragment extends BaseControllerFragment
    implements SetThumbnailTask.SetThumbnailListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener, android.view.View.OnClickListener, ImagePicker.Listener, android.widget.CompoundButton.OnCheckedChangeListener, android.support.v4.app.LoaderManager.LoaderCallbacks, co.vine.android.widget.TypingEditText.TypingListener, co.vine.android.widget.ColorPicker.ColorClickListener
{
    class EditionsSpinnerAdapter extends BaseAdapter
        implements SpinnerAdapter
    {

        private Cursor mCursor;
        final SettingsFragment this$0;

        public void changeCursor(Cursor cursor)
        {
            mCursor = cursor;
            notifyDataSetChanged();
        }

        public int getCount()
        {
            if (mCursor != null)
            {
                return mCursor.getCount();
            } else
            {
                return 0;
            }
        }

        public Object getCursor()
        {
            return mCursor;
        }

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            if (mCursor != null && i < mCursor.getCount())
            {
                if (view == null)
                {
                    view = LayoutInflater.from(getActivity()).inflate(0x7f030092, null);
                }
                viewgroup = (TextView)view.findViewById(0x7f0a004a);
                viewgroup.setText(getEditionName(i));
                viewgroup.setSingleLine(false);
                view.invalidate();
                return view;
            } else
            {
                return view;
            }
        }

        public String getEditionCode(int i)
        {
            if (mCursor != null && i < mCursor.getCount())
            {
                mCursor.moveToPosition(i);
                return mCursor.getString(1);
            } else
            {
                return "";
            }
        }

        public String getEditionName(int i)
        {
            if (mCursor != null && i < mCursor.getCount())
            {
                mCursor.moveToPosition(i);
                return mCursor.getString(2);
            } else
            {
                return "";
            }
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (mCursor != null && i < mCursor.getCount())
            {
                if (view == null)
                {
                    view = LayoutInflater.from(getActivity()).inflate(0x7f030092, null);
                }
                viewgroup = (TextView)view.findViewById(0x7f0a004a);
                viewgroup.setText(getEditionName(i));
                viewgroup.setSingleLine(true);
                viewgroup.setEllipsize(android.text.TextUtils.TruncateAt.END);
                return view;
            } else
            {
                return view;
            }
        }

        public void setSelectionToUserEdition()
        {
label0:
            {
                if (mCursor == null)
                {
                    break label0;
                }
                mCursor.moveToPosition(-1);
                do
                {
                    if (!mCursor.moveToNext())
                    {
                        break label0;
                    }
                } while (!mCursor.getString(1).equals(mEdition));
                mEditionsSpinner.setSelection(mCursor.getPosition());
            }
        }

        EditionsSpinnerAdapter()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }

    public class GetCacheSizeAsyncTask extends AsyncTask
    {

        final SettingsFragment this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            try
            {
                avoid = Util.formatFileSize(getResources(), Util.getCacheSize(getActivity()));
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                CrashUtil.logException(avoid);
                return null;
            }
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (s != null)
            {
                mClearCacheValue.setText(s);
            }
        }

        public GetCacheSizeAsyncTask()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }

    class SettingsListener extends AppSessionListener
    {

        final SettingsFragment this$0;

        public void onClearCacheComplete(String s, int i, String s1)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            try
            {
                mClearCacheValue.setText(Util.formatFileSize(getResources(), Util.getCacheSize(getActivity())));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                CrashUtil.logException(s);
            }
            getActivity().setResult(1);
        }

        public void onConnectFacebookComplete(String s, int i, String s1)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            if (i != 200)
            {
                Util.showCenteredToast(getActivity(), 0x7f0e00ca);
                mFacebookValue.setText(0x7f0e01f1);
                return;
            } else
            {
                invalidateFacebookSessionUI();
                return;
            }
        }

        public void onConnectTwitterComplete(String s, int i, String s1, String s2, String s3, String s4, long l)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            s = (TextView)getView().findViewById(0x7f0a0204);
            TextView textview = (TextView)getView().findViewById(0x7f0a0203);
            if (i == 200 && l > 0L && !TextUtils.isEmpty(s3) && !TextUtils.isEmpty(s4))
            {
                textview.setText(0x7f0e01db);
                s.setText((new StringBuilder()).append('@').append(s2).toString());
                VineAccountHelper.saveTwitterInfo(getActivity(), mAppController.getActiveSession().getLoginEmail(), s2, s3, s4, l);
                mTwitterLogin = true;
                s = mPrefs.edit();
                s.putBoolean("settings_twitter_connected", true);
                s.commit();
                return;
            }
            textview.setText(0x7f0e01d8);
            s.setText(0x7f0e01d9);
            mTwitterLogin = false;
            s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = getResources().getString(0x7f0e01e9);
            }
            Util.showCenteredToast(getActivity(), s);
        }

        public void onDeactivateAccountComplete(String s, int i, String s1, boolean flag)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            if (flag)
            {
                mAppController.logout(mAppController.getActiveSession());
                i = 0x7f0e01cc;
                SLog.d("User account successfully deactivated");
            } else
            {
                i = 0x7f0e01cb;
                SLog.d("User account deactivation failed");
            }
            Util.showCenteredToast(getActivity(), i);
        }

        public void onDisconnectTwitterComplete(String s, int i, String s1)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            s = (TextView)getView().findViewById(0x7f0a0204);
            TextView textview = (TextView)getView().findViewById(0x7f0a0203);
            if (i == 200)
            {
                textview.setText(0x7f0e01d8);
                s.setText(0x7f0e01d9);
                VineAccountHelper.removeTwitterInfo(getActivity(), mAppController.getActiveSession().getLoginEmail());
                mTwitterLogin = false;
                mEditor.putBoolean("settings_twitter_connected", false);
                mEditor.commit();
                return;
            }
            s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = getResources().getString(0x7f0e01ea);
            }
            Util.showCenteredToast(getActivity(), s);
        }

        public void onGetEditionsComplete(int i, ArrayList arraylist)
        {
            if (i == 200)
            {
                mEditionsFetched = true;
            }
        }

        public void onGetUsersMeComplete(String s, int i, String s1, long l, VineUser vineuser)
        {
            if (vineuser != null)
            {
                mIsEmailVerified = vineuser.isEmailVerified();
                mIsPhoneVerified = vineuser.isPhoneVerified();
                updateVerificationIcons();
            }
        }

        public void onLogoutComplete(String s)
        {
            if (getActivity() == null || getActivity().isFinishing())
            {
                return;
            }
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            StartActivity.toStart(getActivity());
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            hashmap = (UrlImage)hashmap.get(mAvatarKey);
            if (hashmap != null && hashmap.isValid())
            {
                mAvatarImageView.setImageDrawable(new RecyclableBitmapDrawable(mAvatarImageView.getResources(), ((UrlImage) (hashmap)).bitmap));
            }
        }

        public void onRequestEmailVerificationComplete(String s, int i, String s1, String s2)
        {
            if (i == 200)
            {
                s = PromptDialogSupportFragment.newInstance(10);
                s.setTargetFragment(SettingsFragment.this, 0);
                s.setNeutralButton(0x104000a).setMessage(0x7f0e0082).show(getActivity().getSupportFragmentManager());
                return;
            }
            if (s1 == null)
            {
                s1 = getString(0x7f0e0105);
            }
            Util.showCenteredToast(getActivity(), s1);
        }

        public void onUpdateEditionComplete(String s, int i, String s1, String s2)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            if (i == 200)
            {
                mEdition = s2;
                mOriginalEdition = s2;
            }
        }

        public void onUpdateProfileComplete(String s, int i, String s1, String s2)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            s = getActivity();
            if (i == 200)
            {
                s1 = mEditor;
                if (!TextUtils.isEmpty(s2))
                {
                    mEditor.putString("settings_profile_avatar_url", s2);
                }
                s1.putString("settings_profile_name", mName);
                s1.putString("settings_profile_description", mDescription);
                s1.putString("settings_profile_location", mLocation);
                s1.putString("settings_profile_email", mEmail);
                s1.putString("settings_profile_phone", mPhone);
                if (mColorIndex < 0 || mColorIndex >= Settings.PROFILE_BACKGROUND_COLORS.length)
                {
                    mColorIndex = 0;
                }
                s1.putInt("profile_background", Settings.PROFILE_BACKGROUND_COLORS[mColorIndex]);
                s1.putInt("color_index", mColorIndex);
                s1.commit();
                if (s != null)
                {
                    s.finish();
                }
                Util.changeProfileColor(s);
                return;
            }
            if (TextUtils.isEmpty(s1))
            {
                Util.showCenteredToast(s, 0x7f0e0258);
                return;
            } else
            {
                Util.showCenteredToast(s, s1);
                return;
            }
        }

        SettingsListener()
        {
            this$0 = SettingsFragment.this;
            super();
        }
    }


    private static final int DEBUG_TAP_THRESHOLD = 6;
    private static final int DIALOG_CLEAR_CACHE = 6;
    private static final int DIALOG_DEACTIVATE_ACCOUNT = 7;
    private static final int DIALOG_DISCONNECT_TWITTER = 5;
    private static final int DIALOG_FACEBOOK_DISCONNECT = 11;
    private static final int DIALOG_LOGOUT = 4;
    private static final int DIALOG_REMOVE_TAKE_OR_CHOOSE_PHOTO = 2;
    private static final int DIALOG_TAKE_OR_CHOOSE_PHOTO = 1;
    private static final int DIALOG_UNSAVED_CHANGES = 3;
    private static final int DIALOG_VERIFY_EMAIL = 8;
    private static final int DIALOG_VERIFY_EMAIL_SENT = 10;
    private static final int DIALOG_VERIFY_PHONE = 9;
    private static final int LOADER_ID_DEFAULT = 0;
    private static final int REQUEST_CODE_CHOOSE_PHOTO = 5;
    private static final int REQUEST_CODE_CONFIRM_PHONE = 7;
    private static final int REQUEST_CODE_CROP = 4;
    private static final int REQUEST_CODE_TAKE_PHOTO = 3;
    private static final int REQUEST_GMS_RESOLUTION = 6;
    public static final int RESULT_CACHE_CLEARED = 1;
    private static final String STATE_AVATAR_URI = "state_avatar_url";
    private static final String STATE_BACKGROUND_COLOR = "state_background_color";
    private static final String STATE_COLOR_INDEX = "state_color_index";
    private static final String STATE_DESCRIPTION = "state_desc";
    private static final String STATE_EDITION = "state_edition";
    private static final String STATE_EDITIONS_FETCHED = "state_editions_fetched";
    private static final String STATE_EMAIL = "state_email";
    private static final String STATE_LOCATION = "state_loc";
    private static final String STATE_NAME = "state_name";
    private static final String STATE_PHONE = "state_phone";
    private static final String TAG = "SettingsFragment";
    private ImageView mAlertIcon;
    private AppController mAppController;
    private ImageView mAvatarActionView;
    private ImageView mAvatarImageView;
    private ImageKey mAvatarKey;
    private Uri mAvatarUri;
    private int mBackgroundColor;
    private TextView mClearCacheValue;
    private int mColorIndex;
    private String mDescription;
    private TextView mEditTextEmail;
    private TextView mEditTextPhone;
    private String mEdition;
    private boolean mEditionsFetched;
    private Spinner mEditionsSpinner;
    private android.content.SharedPreferences.Editor mEditor;
    private String mEmail;
    private ImageView mEmailVerified;
    private int mErrorCode;
    private TextView mFacebookValue;
    private Session mFbSession;
    private ImagePicker mImagePicker;
    private Intent mInviteSmsIntent;
    private boolean mIsEmailVerified;
    private boolean mIsPhoneVerified;
    private String mLocation;
    private String mName;
    private ViewGroup mNotifications;
    private String mOriginalAvatarUrl;
    private int mOriginalBackgroundColor;
    private int mOriginalColorIndex;
    private String mOriginalDescription;
    private String mOriginalEdition;
    private String mOriginalEmail;
    private boolean mOriginalEmailVerified;
    private String mOriginalLocation;
    private String mOriginalName;
    private String mOriginalPhone;
    private boolean mOriginalPhoneVerified;
    private String mPhone;
    private ImageView mPhoneVerified;
    private boolean mPhotoChanged;
    private SharedPreferences mPrefs;
    private View mProfileBackground;
    private ProgressDialog mProgress;
    private ScrollView mScrollView;
    private EditionsSpinnerAdapter mSpinnerAdapter;
    private Bitmap mThumbnail;
    private boolean mTwitterConnected;
    private boolean mTwitterLogin;
    private int mVersionTapCount;

    public SettingsFragment()
    {
        mEditionsFetched = false;
    }

    private void invalidateFacebookSessionUI()
    {
        mFbSession = mAppController.getValidFacebookSession(getActivity(), true);
        if (mFbSession != null)
        {
            mFacebookValue.setText(0x7f0e01da);
            return;
        } else
        {
            mFacebookValue.setText(0x7f0e01f1);
            return;
        }
    }

    private boolean isDirty()
    {
        return !mOriginalName.equals(mName) || !mOriginalEmail.equals(mEmail) || !mOriginalDescription.equals(mDescription) || !mOriginalLocation.equals(mLocation) || !mOriginalPhone.equals(mPhone) || !mOriginalEdition.equals(mEdition) || mOriginalColorIndex != mColorIndex || mPhotoChanged;
    }

    private void resetPrefs()
    {
        android.content.SharedPreferences.Editor editor = mEditor;
        editor.putString("settings_profile_name", mOriginalName);
        editor.putString("settings_profile_description", mOriginalDescription);
        editor.putString("settings_profile_location", mOriginalLocation);
        editor.putString("settings_profile_email", mOriginalEmail);
        editor.putString("settings_profile_phone", mOriginalPhone);
        editor.putString("settings_profile_avatar_url", mOriginalAvatarUrl);
        editor.putString("settings_edition", mOriginalEdition);
        editor.putInt("color_index", mOriginalColorIndex);
        editor.putInt("profile_background", mOriginalBackgroundColor);
        editor.commit();
    }

    private void setImage(Bitmap bitmap, boolean flag)
    {
        mThumbnail = bitmap;
        if (bitmap == null)
        {
            mAvatarImageView.setImageResource(0x7f020065);
            mAvatarActionView.setImageResource(0x7f020061);
            return;
        }
        ImageView imageview = mAvatarActionView;
        int i;
        if (flag)
        {
            i = 0x7f020062;
        } else
        {
            i = 0x7f020064;
        }
        imageview.setImageResource(i);
        mAvatarImageView.setImageDrawable(new RecyclableBitmapDrawable(mAvatarImageView.getResources(), bitmap));
    }

    private void setOriginalPreferenceValues()
    {
        SharedPreferences sharedpreferences = mPrefs;
        mOriginalName = sharedpreferences.getString("settings_profile_name", "");
        mName = mOriginalName;
        mOriginalDescription = sharedpreferences.getString("settings_profile_description", "");
        mDescription = mOriginalDescription;
        mOriginalLocation = sharedpreferences.getString("settings_profile_location", "");
        mLocation = mOriginalLocation;
        mOriginalEmail = sharedpreferences.getString("settings_profile_email", "");
        mEmail = mOriginalEmail;
        mOriginalPhone = sharedpreferences.getString("settings_profile_phone", "");
        mPhone = mOriginalPhone;
        mOriginalEdition = sharedpreferences.getString("settings_edition", "");
        mEdition = mOriginalEdition;
        mTwitterConnected = sharedpreferences.getBoolean("settings_twitter_connected", false);
        mAvatarUri = Uri.parse(sharedpreferences.getString("settings_profile_avatar_url", ""));
        mOriginalAvatarUrl = mAvatarUri.toString();
        mBackgroundColor = sharedpreferences.getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
        mOriginalBackgroundColor = mBackgroundColor;
        int i = 0;
        do
        {
label0:
            {
                if (i < Settings.PROFILE_BACKGROUND_COLORS.length)
                {
                    if (Settings.PROFILE_BACKGROUND_COLORS[i] != mBackgroundColor)
                    {
                        break label0;
                    }
                    mOriginalColorIndex = i;
                }
                mColorIndex = mOriginalColorIndex;
                mOriginalEmailVerified = sharedpreferences.getBoolean("profile_email_verified", false);
                mIsEmailVerified = mOriginalEmailVerified;
                mOriginalPhoneVerified = sharedpreferences.getBoolean("profile_phone_verified", false);
                mIsPhoneVerified = mOriginalPhoneVerified;
                return;
            }
            i++;
        } while (true);
    }

    private void updateProfile(Uri uri)
    {
        if (validate())
        {
            if (!mOriginalName.equals(mName))
            {
                FlurryUtils.trackChangedName();
            }
            if (!mOriginalDescription.equals(mDescription))
            {
                FlurryUtils.trackChangedDescription();
            }
            if (!mOriginalLocation.equals(mLocation))
            {
                FlurryUtils.trackChangedLocation();
            }
            if (!mOriginalEmail.equals(mEmail))
            {
                FlurryUtils.trackChangedEmail();
            }
            if (!mOriginalEdition.equals(mEdition))
            {
                FlurryUtils.trackChangedEdition();
            }
            AppController appcontroller = mAppController;
            co.vine.android.client.Session session = mAppController.getActiveSession();
            String s = mName;
            String s1 = mDescription;
            String s2 = mLocation;
            String s3 = mEmail;
            String s4 = mPhone;
            if (!mPhotoChanged)
            {
                uri = null;
            }
            appcontroller.updateProfile(session, s, s1, s2, s3, s4, uri, mBackgroundColor);
            mAppController.updateEdition(mAppController.getActiveSession(), mEdition);
        }
    }

    private void updateVerificationIcons()
    {
        Resources resources;
        resources = null;
        Resources resources1;
        try
        {
            resources1 = getResources();
        }
        catch (Exception exception)
        {
            CrashUtil.logException(exception);
            continue; /* Loop/switch isn't completed */
        }
        resources = resources1;
_L6:
        if (mEditTextEmail != null && TextUtils.isEmpty(mEditTextEmail.getText().toString()))
        {
            mEmailVerified.setVisibility(8);
        } else
        if (resources != null)
        {
            mEmailVerified.setVisibility(0);
            if (mIsEmailVerified)
            {
                mEmailVerified.setImageDrawable(resources.getDrawable(0x7f0201d8));
            } else
            {
                mEmailVerified.setImageDrawable(resources.getDrawable(0x7f0201d7));
            }
        }
        if (mEditTextPhone == null || !TextUtils.isEmpty(mEditTextPhone.getText().toString())) goto _L2; else goto _L1
_L1:
        mPhoneVerified.setVisibility(8);
_L4:
        return;
_L2:
        mPhoneVerified.setVisibility(0);
        if (resources == null) goto _L4; else goto _L3
_L3:
        if (mIsPhoneVerified)
        {
            mPhoneVerified.setImageDrawable(resources.getDrawable(0x7f0201d8));
            return;
        }
        mPhoneVerified.setImageDrawable(resources.getDrawable(0x7f0201d7));
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean validate()
    {
        Object obj = getActivity();
        if (!mName.isEmpty()) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            Util.showCenteredToast(((android.content.Context) (obj)), 0x7f0e0149);
        }
_L4:
        return false;
_L2:
        if (mLocation.length() <= 32)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj != null)
        {
            Util.showCenteredToast(((android.content.Context) (obj)), 0x7f0e0014);
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (mDescription.length() > 140)
        {
            if (obj != null)
            {
                Util.showCenteredToast(((android.content.Context) (obj)), 0x7f0e0009);
                return false;
            }
        } else
        {
            if (obj != null)
            {
                obj = new ProgressDialog(((android.content.Context) (obj)), 0x7f0f0037);
                ((ProgressDialog) (obj)).setMessage(getString(0x7f0e0201));
                ((ProgressDialog) (obj)).show();
                mProgress = ((ProgressDialog) (obj));
            }
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void onActivityCreated(final Bundle scrollView)
    {
        super.onActivityCreated(scrollView);
        scrollView = getArguments();
        if (scrollView != null)
        {
            scrollView = scrollView.getString("action");
            if (HomeTabActivity.ACTION_VERIFICATION_COMPLETE.equals(scrollView))
            {
                scrollView = mScrollView;
                scrollView.post(new Runnable() {

                    final SettingsFragment this$0;
                    final ScrollView val$scrollView;
                    final View val$verified;

                    public void run()
                    {
                        scrollView.smoothScrollTo(0, verified.getBottom());
                    }

            
            {
                this$0 = SettingsFragment.this;
                scrollView = scrollview;
                verified = view;
                super();
            }
                });
            }
        }
        mInviteSmsIntent = new Intent("android.intent.action.VIEW");
        mInviteSmsIntent.setType("vnd.android-dir/mms-sms");
        mInviteSmsIntent.putExtra("sms_body", Util.getSmsMessage(getActivity()));
        if (mInviteSmsIntent.resolveActivity(getActivity().getPackageManager()) == null)
        {
            mScrollView.findViewById(0x7f0a01ff).setVisibility(8);
            mScrollView.findViewById(0x7f0a0200).setVisibility(8);
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 1 7: default 52
    //                   1 280
    //                   2 397
    //                   3 167
    //                   4 217
    //                   5 167
    //                   6 518
    //                   7 592;
           goto _L1 _L2 _L3 _L4 _L5 _L4 _L6 _L7
_L1:
        SLog.d("Facebook auth came back: {}", Integer.valueOf(i));
        if (j != -1) goto _L9; else goto _L8
_L8:
        Session session = Session.getActiveSession();
        if (session == null) goto _L11; else goto _L10
_L10:
        if (!session.onActivityResult(getActivity(), i, j, intent)) goto _L13; else goto _L12
_L12:
        if (!session.getPermissions().contains("publish_actions")) goto _L15; else goto _L14
_L14:
        AppController.setPendingFacebookToken(getActivity(), session.getAccessToken());
        intent = new ProgressDialog(getActivity(), 2);
        intent.setMessage(getString(0x7f0e0120));
        intent.setProgress(0);
        intent.show();
        mProgress = intent;
        mAppController.sendFacebookToken();
_L17:
        return;
_L4:
        if (j != -1) goto _L17; else goto _L16
_L16:
        if (i == 3)
        {
            intent = mAvatarUri;
        } else
        {
            intent = intent.getData();
        }
        startActivityForResult((new Intent(getActivity(), co/vine/android/EditProfileCropActivity)).putExtra("uri", intent), 4);
        return;
_L5:
        if (j != -1 || intent == null) goto _L17; else goto _L18
_L18:
        intent = (Uri)intent.getParcelableExtra("uri");
        if (intent != null)
        {
            ImageUtils.deleteTempPic(mAvatarUri);
            mAvatarUri = intent;
            (new SetThumbnailTask(this)).execute(new Uri[] {
                intent
            });
        }
        mPhotoChanged = true;
        return;
_L2:
        if (j == -1)
        {
            String s = intent.getStringExtra("screen_name");
            String s2 = intent.getStringExtra("tk");
            String s4 = intent.getStringExtra("ts");
            long l = intent.getLongExtra("user_id", 0L);
            intent = new ProgressDialog(getActivity(), 0x7f0f0037);
            intent.setMessage(getString(0x7f0e021d));
            intent.setProgress(0);
            intent.show();
            mProgress = intent;
            mAppController.connectTwitter(mAppController.getActiveSession(), s, s2, s4, l);
            return;
        } else
        {
            Util.showCenteredToast(getActivity(), 0x7f0e00ce);
            return;
        }
_L3:
        if (j == -1)
        {
            String s1 = intent.getStringExtra("screen_name");
            String s3 = intent.getStringExtra("token");
            String s5 = intent.getStringExtra("secret");
            long l1 = intent.getLongExtra("user_id", 0L);
            intent = new ProgressDialog(getActivity(), 0x7f0f0037);
            intent.setMessage(getString(0x7f0e021d));
            intent.setProgress(0);
            intent.show();
            mProgress = intent;
            mAppController.connectTwitter(mAppController.getActiveSession(), s1, s3, s5, l1);
            return;
        }
        if (j == 0) goto _L17; else goto _L19
_L19:
        Util.showCenteredToast(getActivity(), 0x7f0e00d0);
        return;
_L6:
        intent = getActivity();
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(intent) == 0)
        {
            if (mNotifications != null)
            {
                mNotifications.setOnClickListener(this);
            }
            if (mAlertIcon != null)
            {
                mAlertIcon.setVisibility(8);
            }
            getActivity().startService(GCMRegistrationService.getRegisterIntent(intent, mAppController.getActiveId()));
            return;
        } else
        {
            Util.showCenteredToast(getActivity(), 0x7f0e024b);
            return;
        }
_L7:
        switch (j)
        {
        default:
            return;

        case 1527: 
            mPrefs.edit().putBoolean("profile_phone_verified", true).commit();
            mIsPhoneVerified = true;
            updateVerificationIcons();
            return;

        case 1528: 
            mIsPhoneVerified = false;
            break;
        }
        mPrefs.edit().putBoolean("profile_phone_verified", false).commit();
        updateVerificationIcons();
        return;
_L15:
        getActivity().runOnUiThread(new Runnable() {

            final SettingsFragment this$0;

            public void run()
            {
                Util.showCenteredToast(getActivity(), 0x7f0e01a0);
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        mAppController.connectToFacebookPublish(this);
        return;
_L13:
        invalidateFacebookSessionUI();
        return;
_L11:
        invalidateFacebookSessionUI();
        super.onActivityResult(i, j, intent);
        return;
_L9:
        invalidateFacebookSessionUI();
        return;
    }

    public void onBackPressed()
    {
        FragmentActivity fragmentactivity = getActivity();
        if (isDirty() && fragmentactivity != null)
        {
            PromptDialogSupportFragment promptdialogsupportfragment = PromptDialogSupportFragment.newInstance(3);
            promptdialogsupportfragment.setMessage(0x7f0e01ff);
            promptdialogsupportfragment.setNeutralButton(0x7f0e01dc);
            promptdialogsupportfragment.setPositiveButton(0x7f0e01e3);
            promptdialogsupportfragment.setTargetFragment(this, 0);
            promptdialogsupportfragment.show(fragmentactivity.getSupportFragmentManager());
        } else
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            if (fragmentactivity != null)
            {
                fragmentactivity.finish();
                return;
            }
        }
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 23: default 200
    //                   2131361891: 301
    //                   2131362117: 637
    //                   2131362119: 1121
    //                   2131362291: 1167
    //                   2131362294: 1239
    //                   2131362296: 1112
    //                   2131362297: 1112
    //                   2131362299: 553
    //                   2131362300: 596
    //                   2131362301: 618
    //                   2131362302: 1121
    //                   2131362303: 738
    //                   2131362305: 662
    //                   2131362306: 425
    //                   2131362309: 201
    //                   2131362312: 766
    //                   2131362315: 847
    //                   2131362316: 814
    //                   2131362317: 880
    //                   2131362318: 1095
    //                   2131362319: 913
    //                   2131362320: 500
    //                   2131362321: 978;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L8 _L9 _L10 _L4 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22
_L1:
        return;
_L14:
        if (mFbSession != null)
        {
            view = PromptDialogSupportFragment.newInstance(11);
            view.setTargetFragment(this, 0);
            view.setTitle(0x7f0e01e4).setPositiveButton(0x7f0e0288).setNegativeButton(0x7f0e0057);
            try
            {
                view.show(getActivity().getSupportFragmentManager());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                CrashUtil.logException(view);
            }
            return;
        }
        if (mAppController.getValidFacebookSession(getActivity(), false) == null)
        {
            mAppController.connectToFacebookInitialize(this);
            return;
        }
        if (mAppController.getPendingFacebookToken() != null)
        {
            mAppController.sendFacebookToken();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (mAvatarUri != null && !Util.isDefaultAvatarUrl(mAvatarUri.toString()))
        {
            view = PromptDialogSupportFragment.newInstance(2);
            view.setTargetFragment(this, 0);
            view.setTitle(0x7f0e021e).setPositiveButton(0x7f0e01a4).setNeutralButton(0x7f0e0242).setNegativeButton(0x7f0e005b);
            try
            {
                view.show(getActivity().getSupportFragmentManager());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                CrashUtil.logException(view);
            }
            return;
        }
        view = PromptDialogSupportFragment.newInstance(1);
        view.setTargetFragment(this, 0);
        view.setTitle(0x7f0e021e).setPositiveButton(0x7f0e0242).setNeutralButton(0x7f0e005b);
        try
        {
            view.show(getActivity().getSupportFragmentManager());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            CrashUtil.logException(view);
        }
        return;
_L13:
        if (mTwitterLogin)
        {
            view = PromptDialogSupportFragment.newInstance(5);
            view.setMessage(0x7f0e01e5);
            view.setPositiveButton(0x7f0e01e4);
            view.setNegativeButton(0x7f0e0057);
            view.setTargetFragment(this, 0);
            try
            {
                view.show(getActivity().getSupportFragmentManager());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                CrashUtil.logException(view);
            }
            return;
        } else
        {
            AppController.startTwitterAuthWithFinish(mAppController.getTwitter(), getActivity());
            return;
        }
_L21:
        view = PromptDialogSupportFragment.newInstance(4);
        view.setMessage(0x7f0e0131);
        view.setPositiveButton(0x7f0e0130);
        view.setNegativeButton(0x7f0e0057);
        view.setTargetFragment(this, 0);
        try
        {
            view.show(getActivity().getSupportFragmentManager());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            CrashUtil.logException(view);
        }
        return;
_L8:
        view = new Intent(getActivity(), co/vine/android/ResetPasswordActivity);
        if (!TextUtils.isEmpty(mEmail))
        {
            view.putExtra("email", mEmail);
        }
        startActivity(view);
        return;
_L9:
        FlurryUtils.trackContentControls();
        startActivity(new Intent(getActivity(), co/vine/android/ContentControlsActivity));
        return;
_L10:
        startActivity(new Intent(getActivity(), co/vine/android/PrivacyControlsActivity));
        return;
_L3:
        FlurryUtils.trackVisitFindFriends("Settings");
        startActivity(new Intent(getActivity(), co/vine/android/FindFriendsActivity));
        return;
_L12:
        FlurryUtils.trackInvite("email", "Settings");
        view = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null));
        view.putExtra("android.intent.extra.SUBJECT", getString(0x7f0e00e6));
        view.putExtra("android.intent.extra.TEXT", Util.getEmailMessage(getActivity()));
        startActivity(Intent.createChooser(view, getString(0x7f0e00e4)));
        return;
_L11:
        FlurryUtils.trackInvite("sms", "Settings");
        startActivity(Intent.createChooser(mInviteSmsIntent, getString(0x7f0e01be)));
        return;
_L15:
        view = PromptDialogSupportFragment.newInstance(6);
        view.setMessage(0x7f0e01d6);
        view.setNegativeButton(0x7f0e0057);
        view.setPositiveButton(0x7f0e01d5);
        view.setTargetFragment(this, 0);
        view.show(getActivity().getSupportFragmentManager());
        return;
_L17:
        FlurryUtils.trackPrivacyPolicy();
        view = new Intent(getActivity(), co/vine/android/WebViewActivity);
        view.putExtra("type", 1);
        startActivity(view);
        return;
_L16:
        FlurryUtils.trackTos();
        view = new Intent(getActivity(), co/vine/android/WebViewActivity);
        view.putExtra("type", 2);
        startActivity(view);
        return;
_L18:
        FlurryUtils.trackAttribution();
        view = new Intent(getActivity(), co/vine/android/WebViewActivity);
        view.putExtra("type", 5);
        startActivity(view);
        return;
_L20:
        FlurryUtils.trackDeactivateAccount();
        view = PromptDialogSupportFragment.newInstance(7);
        view.setMessage(0x7f0e01df);
        view.setTitle(0x7f0e01e0);
        view.setNegativeButton(0x7f0e0057);
        view.setPositiveButton(0x7f0e01de);
        view.setTargetFragment(this, 0);
        try
        {
            view.show(getActivity().getSupportFragmentManager());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            CrashUtil.logException(view);
        }
        return;
_L22:
        mVersionTapCount = mVersionTapCount + 1;
        if (mVersionTapCount >= 6)
        {
            mVersionTapCount = 0;
            startActivity(new Intent(getActivity(), co/vine/android/DebugHomeActivity));
            return;
        }
        if (mVersionTapCount == 5)
        {
            Util.showShortCenteredToast(getActivity(), "One more!");
            return;
        }
        try
        {
            view = getActivity().getPackageManager().getPackageInfo("co.vine.android", 0);
            Util.showShortCenteredToast(getActivity(), (new StringBuilder()).append("Version Code: ").append(((PackageInfo) (view)).versionCode).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            SLog.e("Failed to show version code.", view);
        }
        return;
_L19:
        LocaleDialog.newInstance().show(getActivity().getSupportFragmentManager(), "locale");
        return;
_L7:
        mEditionsSpinner.performClick();
        return;
_L4:
        if (mErrorCode != 0)
        {
            GooglePlayServicesUtil.getErrorDialog(mErrorCode, getActivity(), 6).show();
            return;
        } else
        {
            FlurryUtils.trackNotificationSettings();
            startActivity(new Intent(getActivity(), co/vine/android/NotificationSettingsActivity));
            return;
        }
_L5:
        if (!mIsEmailVerified)
        {
            view = PromptDialogSupportFragment.newInstance(8);
            view.setTargetFragment(this, 0);
            view.setPositiveButton(0x7f0e0083).setMessage(getString(0x7f0e0081, new Object[] {
                mEmail
            })).setNeutralButton(0x1040000);
            try
            {
                view.show(getActivity().getSupportFragmentManager());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                CrashUtil.logException(view);
            }
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (!mIsPhoneVerified)
        {
            view = ConfirmationFlowActivity.getIntent(getActivity(), mPhone, false);
            getActivity().startActivityForResult(view, 7);
            return;
        }
        if (true) goto _L1; else goto _L23
_L23:
    }

    public void onColorClick(int i)
    {
        Object obj;
        ColorDrawable colordrawable;
        TransitionDrawable transitiondrawable;
        int j;
        if (mColorIndex >= 0)
        {
            j = Settings.PROFILE_BACKGROUND_COLORS[mColorIndex];
        } else
        {
            j = Settings.DEFAULT_PROFILE_COLOR;
        }
        mColorIndex = i;
        mBackgroundColor = Settings.PROFILE_BACKGROUND_COLORS[mColorIndex];
        obj = new ColorDrawable(j | 0xff000000);
        colordrawable = new ColorDrawable(mBackgroundColor | 0xff000000);
        transitiondrawable = new TransitionDrawable(new Drawable[] {
            obj, colordrawable
        });
        if (mProfileBackground != null)
        {
            mProfileBackground.setBackgroundDrawable(transitiondrawable);
            transitiondrawable.startTransition(100);
        }
        obj = new TransitionDrawable(new Drawable[] {
            obj, colordrawable
        });
        if (android.os.Build.VERSION.SDK_INT > 16)
        {
            setActionBarTransition(((TransitionDrawable) (obj)));
        } else
        {
            setActionBarColor(mBackgroundColor);
        }
        obj = new Intent("co.vine.android.profileColor");
        getActivity().sendBroadcast(((Intent) (obj)), "co.vine.android.BROADCAST");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        mPrefs = Util.getDefaultSharedPrefs(getActivity());
        mAppSessionListener = new SettingsListener();
        mAppController = AppController.getInstance(getActivity());
        mImagePicker = new ImagePicker(getActivity(), this, mAppController.getActiveId());
        mEditor = mPrefs.edit();
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getActivity(), co.vine.android.provider.Vine.Editions.CONTENT_URI, co.vine.android.provider.VineDatabaseSQL.EditionsQuery.PROJECTION, null, null, null);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f100012, menu);
        menu.findItem(0x7f0a0245).setEnabled(true);
        menu.findItem(0x7f0a0245).setEnabled(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f03008f, viewgroup, false);
        Object obj = getResources();
        setOriginalPreferenceValues();
        if (bundle != null)
        {
            mName = bundle.getString("state_name");
            mDescription = bundle.getString("state_desc");
            mLocation = bundle.getString("state_loc");
            mPhone = bundle.getString("state_phone");
            mEmail = bundle.getString("state_email");
            mEditionsFetched = bundle.getBoolean("state_editions_fetched");
            mEdition = bundle.getString("state_edition");
            mAvatarUri = (Uri)bundle.getParcelable("state_avatar_url");
            mBackgroundColor = bundle.getInt("state_background_color");
            mColorIndex = bundle.getInt("state_color_index");
        }
        mScrollView = (ScrollView)viewgroup.findViewById(0x7f0a00e0);
        mEmailVerified = (ImageView)viewgroup.findViewById(0x7f0a01f3);
        mEmailVerified.setOnClickListener(this);
        mPhoneVerified = (ImageView)viewgroup.findViewById(0x7f0a01f6);
        mPhoneVerified.setOnClickListener(this);
        layoutinflater = (ColorPicker)viewgroup.findViewById(0x7f0a0213);
        layoutinflater.setOnColorClickListener(this);
        layoutinflater.setColorIndex(mColorIndex);
        layoutinflater = (ViewGroup)viewgroup.findViewById(0x7f0a0103);
        layoutinflater.setBackgroundColor(mBackgroundColor | 0xff000000);
        mProfileBackground = layoutinflater;
        setActionBarColor(mBackgroundColor);
        ((TextView)viewgroup.findViewById(0x7f0a01fd)).setOnClickListener(this);
        mAvatarImageView = (ImageView)viewgroup.findViewById(0x7f0a0063);
        mAvatarActionView = (ImageView)viewgroup.findViewById(0x7f0a022b);
        mAvatarActionView.setVisibility(0);
        if (mAvatarUri == null)
        {
            layoutinflater = "";
        } else
        {
            layoutinflater = mAvatarUri.toString();
        }
        mAvatarImageView.setOnClickListener(this);
        if (mThumbnail != null)
        {
            setImage(mThumbnail, false);
        } else
        if (!TextUtils.isEmpty(layoutinflater))
        {
            if (Util.isDefaultAvatarUrl(layoutinflater))
            {
                setImage(null, false);
            } else
            {
                int i = ((Resources) (obj)).getDimensionPixelOffset(0x7f0b0088);
                mAvatarKey = new ImageKey(layoutinflater, i, i, true);
                setImage(mAppController.getPhotoBitmap(mAvatarKey), false);
            }
        } else
        {
            setImage(null, false);
        }
        layoutinflater = (EditText)viewgroup.findViewById(0x7f0a01f1);
        layoutinflater.setText(mName);
        layoutinflater.addTextChangedListener(new TextWatcher() {

            final SettingsFragment this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                mName = charsequence.toString();
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        layoutinflater = (EditText)viewgroup.findViewById(0x7f0a019d);
        layoutinflater.setText(mDescription);
        layoutinflater.setHint(0x7f0e01e2);
        layoutinflater.addTextChangedListener(new TextWatcher() {

            final SettingsFragment this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                mDescription = charsequence.toString();
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        layoutinflater = (EditText)viewgroup.findViewById(0x7f0a019e);
        layoutinflater.setText(mLocation);
        layoutinflater.setHint(0x7f0e01f0);
        layoutinflater.addTextChangedListener(new TextWatcher() {

            final SettingsFragment this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                mLocation = charsequence.toString();
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        layoutinflater = (TypingEditText)viewgroup.findViewById(0x7f0a01f4);
        layoutinflater.setText(mEmail);
        layoutinflater.setInputType(32);
        layoutinflater.setTypingListener(this);
        mEditTextEmail = layoutinflater;
        layoutinflater.addTextChangedListener(new TextWatcher() {

            final SettingsFragment this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                mEmail = charsequence.toString();
                if (mOriginalEmail != null && !mOriginalPhone.equals(mEmail))
                {
                    mIsEmailVerified = false;
                    return;
                } else
                {
                    mIsEmailVerified = mOriginalEmailVerified;
                    return;
                }
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        layoutinflater = (TypingEditText)viewgroup.findViewById(0x7f0a01f7);
        layoutinflater.setText(mPhone);
        layoutinflater.setInputType(3);
        layoutinflater.addTextChangedListener(new TextWatcher() {

            final SettingsFragment this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                mPhone = charsequence.toString();
                if (mOriginalPhone != null && !mOriginalPhone.equals(mPhone))
                {
                    mIsPhoneVerified = false;
                    return;
                } else
                {
                    mIsPhoneVerified = mOriginalPhoneVerified;
                    return;
                }
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        layoutinflater.setTypingListener(this);
        mEditTextPhone = layoutinflater;
        mEditionsSpinner = (Spinner)viewgroup.findViewById(0x7f0a01fa);
        mEditionsSpinner.setFocusable(false);
        mEditionsSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final SettingsFragment this$0;

            public void onItemSelected(AdapterView adapterview, View view, int j, long l)
            {
                mEdition = mSpinnerAdapter.getEditionCode(j);
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        viewgroup.findViewById(0x7f0a01f8).setOnClickListener(this);
        viewgroup.findViewById(0x7f0a01f9).setOnClickListener(this);
        mSpinnerAdapter = new EditionsSpinnerAdapter();
        mEditionsSpinner.setAdapter(mSpinnerAdapter);
        ((TextView)viewgroup.findViewById(0x7f0a01fb)).setOnClickListener(this);
        ((TextView)viewgroup.findViewById(0x7f0a01fc)).setOnClickListener(this);
        mNotifications = (ViewGroup)viewgroup.findViewById(0x7f0a0147);
        if (BuildUtil.isGoogle())
        {
            mNotifications.setVisibility(0);
            mAlertIcon = (ImageView)mNotifications.findViewById(0x7f0a01fe);
            mErrorCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
            android.accounts.Account account;
            if (mErrorCode != 0)
            {
                mAlertIcon.setVisibility(0);
                mAlertIcon.setOnClickListener(this);
            } else
            {
                mAlertIcon.setVisibility(8);
            }
            mNotifications.setOnClickListener(this);
        } else
        {
            mNotifications.setVisibility(8);
        }
        ((TextView)viewgroup.findViewById(0x7f0a0145)).setOnClickListener(this);
        ((TextView)viewgroup.findViewById(0x7f0a01ff)).setOnClickListener(this);
        ((TextView)viewgroup.findViewById(0x7f0a0201)).setOnClickListener(this);
        layoutinflater = (RelativeLayout)viewgroup.findViewById(0x7f0a0202);
        layoutinflater.setBackgroundResource(0x7f020076);
        bundle = (TextView)layoutinflater.findViewById(0x7f0a0204);
        obj = AccountManager.get(getActivity());
        account = VineAccountHelper.getAccount(getActivity(), mAppController.getActiveSession().getLoginEmail());
        if (account != null && VineAccountHelper.getLoginType(((AccountManager) (obj)), account) == 2)
        {
            bundle.setText((new StringBuilder()).append('@').append(VineAccountHelper.getTwitterUsername(((AccountManager) (obj)), account)).toString());
            mTwitterLogin = true;
        } else
        if (mTwitterConnected)
        {
            bundle.setText("");
            mTwitterLogin = true;
        } else
        {
            bundle.setText(0x7f0e01d9);
            mTwitterLogin = false;
        }
        layoutinflater.setOnClickListener(this);
        layoutinflater = (RelativeLayout)viewgroup.findViewById(0x7f0a0205);
        layoutinflater.setOnClickListener(this);
        ((TextView)viewgroup.findViewById(0x7f0a0206)).setText(0x7f0e00d5);
        mFacebookValue = (TextView)viewgroup.findViewById(0x7f0a0207);
        invalidateFacebookSessionUI();
        layoutinflater.setOnClickListener(this);
        ((RelativeLayout)viewgroup.findViewById(0x7f0a0208)).setOnClickListener(this);
        ((TextView)viewgroup.findViewById(0x7f0a0209)).setText(getString(0x7f0e01d4));
        mClearCacheValue = (TextView)viewgroup.findViewById(0x7f0a020a);
        (new GetCacheSizeAsyncTask()).execute(new Void[0]);
        ((TextView)viewgroup.findViewById(0x7f0a020b)).setOnClickListener(this);
        ((TextView)viewgroup.findViewById(0x7f0a020c)).setOnClickListener(this);
        ((TextView)viewgroup.findViewById(0x7f0a020d)).setOnClickListener(this);
        ((TextView)viewgroup.findViewById(0x7f0a020f)).setOnClickListener(this);
        ((Button)viewgroup.findViewById(0x7f0a0210)).setOnClickListener(this);
        layoutinflater = (LinearLayout)viewgroup.findViewById(0x7f0a0211);
        bundle = (TextView)viewgroup.findViewById(0x7f0a0212);
        try
        {
            bundle.setText(getString(0x7f0e01c6, new Object[] {
                getActivity().getPackageManager().getPackageInfo("co.vine.android", 0).versionName
            }));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.d("SettingsFragment", "Error retrieving package info:", bundle);
        }
        layoutinflater.setOnClickListener(this);
        if (BuildUtil.isI18nOn())
        {
            layoutinflater = (TextView)viewgroup.findViewById(0x7f0a020e);
            layoutinflater.setVisibility(0);
            layoutinflater.setOnClickListener(this);
        }
        return viewgroup;
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        i;
        JVM INSTR tableswitch 1 11: default 60
    //                   1 61
    //                   2 153
    //                   3 220
    //                   4 259
    //                   5 358
    //                   6 433
    //                   7 503
    //                   8 637
    //                   9 574
    //                   10 60
    //                   11 107;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L1 _L11
_L1:
        return;
_L2:
        switch (j)
        {
        case -2: 
        default:
            return;

        case -3: 
            mImagePicker.chooseImage(5);
            return;

        case -1: 
            mImagePicker.captureImage(3);
            break;
        }
        return;
_L11:
        switch (j)
        {
        default:
            return;

        case -1: 
            break;
        }
        if (mFbSession != null)
        {
            mFbSession.closeAndClearTokenInformation();
            mFbSession = null;
        }
        invalidateFacebookSessionUI();
        return;
_L3:
        switch (j)
        {
        default:
            return;

        case -3: 
            mImagePicker.captureImage(3);
            return;

        case -1: 
            setThumbnailImage(null);
            mPhotoChanged = true;
            mAvatarUri = Uri.parse("");
            return;

        case -2: 
            mImagePicker.chooseImage(5);
            return;
        }
_L4:
        switch (j)
        {
        default:
            return;

        case -1: 
            resetPrefs();
            break;
        }
        dialoginterface = getActivity();
        if (dialoginterface != null)
        {
            dialoginterface.finish();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        switch (j)
        {
        default:
            return;

        case -1: 
            FlurryUtils.trackLogout();
            break;
        }
        if (mFbSession != null)
        {
            mFbSession.closeAndClearTokenInformation();
        }
        invalidateFacebookSessionUI();
        dialoginterface = new ProgressDialog(getActivity(), 0x7f0f0037);
        dialoginterface.setMessage(getString(0x7f0e011e));
        dialoginterface.setProgress(0);
        dialoginterface.show();
        mProgress = dialoginterface;
        mAppController.logout(mAppController.getActiveSession());
        return;
_L6:
        switch (j)
        {
        default:
            return;

        case -1: 
            dialoginterface = new ProgressDialog(getActivity(), 0x7f0f0037);
            break;
        }
        dialoginterface.setMessage(getString(0x7f0e01e6));
        dialoginterface.setProgress(0);
        dialoginterface.show();
        mProgress = dialoginterface;
        mAppController.disconnectTwitter(mAppController.getActiveSession());
        return;
_L7:
        switch (j)
        {
        default:
            return;

        case -1: 
            dialoginterface = new ProgressDialog(getActivity(), 0x7f0f0037);
            break;
        }
        dialoginterface.setMessage(getString(0x7f0e01d7));
        dialoginterface.setProgress(0);
        dialoginterface.show();
        mProgress = dialoginterface;
        mAppController.clearDbCache(true);
        return;
_L8:
        switch (j)
        {
        default:
            return;

        case -1: 
            dialoginterface = new ProgressDialog(getActivity(), 0x7f0f0037);
            break;
        }
        dialoginterface.setMessage(getString(0x7f0e01e1));
        dialoginterface.setProgress(0);
        dialoginterface.show();
        mProgress = dialoginterface;
        mAppController.deactivateAccount();
        return;
_L10:
        switch (j)
        {
        default:
            return;

        case -1: 
            dialoginterface = mEditTextPhone.getText();
            break;
        }
        if (!TextUtils.isEmpty(dialoginterface))
        {
            mAppController.requestPhoneVerification(mAppController.getActiveSession(), dialoginterface.toString(), mAppController.getActiveId());
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
        switch (j)
        {
        default:
            return;

        case -1: 
            dialoginterface = mEditTextEmail.getText();
            break;
        }
        if (!TextUtils.isEmpty(dialoginterface))
        {
            mAppController.requestEmailVerification(mAppController.getActiveSession(), dialoginterface.toString(), mAppController.getActiveId());
            return;
        }
        if (true) goto _L1; else goto _L12
_L12:
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        if (!mEditionsFetched)
        {
            mAppController.getEditions();
            mEditionsFetched = true;
        }
        mSpinnerAdapter.changeCursor(cursor);
        mSpinnerAdapter.setSelectionToUserEdition();
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362373: 
            break;
        }
        if (!isDirty()) goto _L2; else goto _L1
_L1:
        updateProfile(mAvatarUri);
_L4:
        return true;
_L2:
        if (mProgress != null)
        {
            mProgress.dismiss();
        }
        if (getActivity() != null)
        {
            getActivity().finish();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
        if (mProgress != null)
        {
            mProgress.dismiss();
        }
    }

    public void onResume()
    {
        super.onResume();
        mAppController.fetchUsersMe(mAppController.getActiveId());
        if (mSpinnerAdapter.getCursor() == null)
        {
            getLoaderManager().initLoader(0, null, this);
        } else
        if (mSpinnerAdapter.isEmpty() && !mEditionsFetched)
        {
            mEditionsFetched = true;
            mAppController.getEditions();
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("state_name", mName);
        bundle.putString("state_desc", mDescription);
        bundle.putString("state_loc", mLocation);
        bundle.putString("state_phone", mPhone);
        bundle.putString("state_email", mEmail);
        bundle.putString("state_edition", mEdition);
        bundle.putBoolean("state_editions_fetched", mEditionsFetched);
        bundle.putParcelable("state_avatar_url", mAvatarUri);
        bundle.putInt("state_background_color", mBackgroundColor);
        bundle.putInt("state_color_index", mColorIndex);
    }

    public void onTypingTimeout(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362280: 
        case 2131362329: 
            updateVerificationIcons();
            break;
        }
    }

    public void setAvatarUrl(Uri uri)
    {
        mAvatarUri = uri;
    }

    public void setThumbnailImage(Bitmap bitmap)
    {
        setImage(bitmap, true);
    }




/*
    static boolean access$1002(SettingsFragment settingsfragment, boolean flag)
    {
        settingsfragment.mIsPhoneVerified = flag;
        return flag;
    }

*/


/*
    static String access$102(SettingsFragment settingsfragment, String s)
    {
        settingsfragment.mName = s;
        return s;
    }

*/




/*
    static String access$1202(SettingsFragment settingsfragment, String s)
    {
        settingsfragment.mEdition = s;
        return s;
    }

*/











/*
    static int access$2002(SettingsFragment settingsfragment, int i)
    {
        settingsfragment.mColorIndex = i;
        return i;
    }

*/


/*
    static String access$202(SettingsFragment settingsfragment, String s)
    {
        settingsfragment.mDescription = s;
        return s;
    }

*/


/*
    static String access$2102(SettingsFragment settingsfragment, String s)
    {
        settingsfragment.mOriginalEdition = s;
        return s;
    }

*/



/*
    static boolean access$2302(SettingsFragment settingsfragment, boolean flag)
    {
        settingsfragment.mTwitterLogin = flag;
        return flag;
    }

*/




/*
    static boolean access$2602(SettingsFragment settingsfragment, boolean flag)
    {
        settingsfragment.mEditionsFetched = flag;
        return flag;
    }

*/




/*
    static String access$302(SettingsFragment settingsfragment, String s)
    {
        settingsfragment.mLocation = s;
        return s;
    }

*/



/*
    static String access$402(SettingsFragment settingsfragment, String s)
    {
        settingsfragment.mEmail = s;
        return s;
    }

*/




/*
    static boolean access$702(SettingsFragment settingsfragment, boolean flag)
    {
        settingsfragment.mIsEmailVerified = flag;
        return flag;
    }

*/




/*
    static String access$902(SettingsFragment settingsfragment, String s)
    {
        settingsfragment.mPhone = s;
        return s;
    }

*/
}
