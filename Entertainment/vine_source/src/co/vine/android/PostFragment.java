// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.CursorAdapter;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import co.vine.android.api.VineUpload;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.TwitterVineApp;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.provider.VineSuggestionsProvider;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RecordSessionManager;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.MediaUtil;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.UploadManager;
import co.vine.android.util.Util;
import co.vine.android.views.SwitchInterface;
import co.vine.android.widget.PopupEditText;
import com.edisonwang.android.slog.SLog;
import com.facebook.Session;
import com.twitter.android.sdk.Twitter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, HomeTabActivity, ComposeFilter, VineLoggingException, 
//            ChannelsListActivity, UsersAutoCompleteAdapter, TagsAutoCompleteAdapter, ComposeTokenizer, 
//            SonyLaunchActivity

public class PostFragment extends BaseControllerFragment
    implements android.widget.CompoundButton.OnCheckedChangeListener, android.view.View.OnClickListener, Filterable, co.vine.android.widget.PopupEditText.PopupEditTextListener, android.view.View.OnLongClickListener
{
    class PostSessionListener extends AppSessionListener
    {

        final PostFragment this$0;

        public void onConnectFacebookComplete(String s, int i, String s1)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            if (i != 200)
            {
                Util.showCenteredToast(getActivity(), 0x7f0e00ca);
                mPostFacebook.setChecked(false);
            }
        }

        public void onConnectTwitterComplete(String s, int i, String s1, String s2, String s3, String s4, long l)
        {
            if (i == 200)
            {
                if (l > 0L && !TextUtils.isEmpty(s3) && !TextUtils.isEmpty(s4))
                {
                    VineAccountHelper.saveTwitterInfo(getActivity(), mAppController.getActiveSession().getLoginEmail(), s2, s3, s4, l);
                    mPostTwitter.setChecked(true);
                }
                return;
            } else
            {
                Util.showCenteredToast(getActivity(), s1);
                mPostTwitter.setChecked(false);
                return;
            }
        }

        public void onGetTagTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
        {
            if (i == 200 && !arraylist.isEmpty())
            {
                VineSuggestionsProvider.addRealtimeTagSuggestions(s2, arraylist);
                mCaption.performFilter(false);
            }
        }

        public void onGetUserTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
        {
            if (i == 200 && !arraylist.isEmpty())
            {
                VineSuggestionsProvider.addRealtimeUserSuggestions(s2, arraylist);
                mCaption.performFilter(false);
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            super.onPhotoImageLoaded(hashmap);
            mUsersAdapter.setUserImages(hashmap);
        }

        PostSessionListener()
        {
            this$0 = PostFragment.this;
            super();
        }
    }


    private static final String AG_FROM_SONY = "f_s";
    private static final String AG_IS_RETRY = "is_retry";
    private static final String AG_PREVIEW_PATH = "preview_path";
    private static final String AG_THUMBNAIL_PATH = "pic_path";
    private static final String AG_VIDEO_PATH = "vid_path";
    private static final int MAX_CHARS = 120;
    private static final int POSTING_DIALOG_DELAY = 750;
    public static final int REQUEST_CODE_ADD_TO_CHANNEL = 3;
    public static final int RESULT_FINISH = 32;
    public static final int RESULT_SAVED = 31;
    private static final String STATE_CHANNEL = "channel";
    private static Toast mToastLengthExceeded;
    private View mAddToChannel;
    private ImageView mAddToChannelIcon;
    private TextView mAddToChannelText;
    private PopupEditText mCaption;
    private long mChannelId;
    private Filter mFilter;
    private ImageView mImagePreview;
    private boolean mIsFromSony;
    private boolean mIsRetry;
    private SwitchInterface mPostFacebook;
    private TextView mPostToFacebookText;
    private TextView mPostToTwitterText;
    private SwitchInterface mPostTwitter;
    private SwitchInterface mPostVine;
    private String mPreviewPath;
    private ProgressDialog mProgress;
    private TagsAutoCompleteAdapter mTagsAdapter;
    private ComposeTokenizer mTokenizer;
    private Twitter mTwitter;
    private CursorAdapter mTypeaheadAdapter;
    private UsersAutoCompleteAdapter mUsersAdapter;
    private String mVideoPath;

    public PostFragment()
    {
    }

    private int captionLength()
    {
        return mCaption.getText().toString().trim().length();
    }

    private void insertText(String s)
    {
        if (mCaption != null)
        {
            int i = mCaption.getSelectionStart();
            int j = mCaption.getSelectionEnd();
            if (mCaption.getText() != null && i >= 0 && j <= mCaption.length())
            {
                mCaption.getText().replace(i, j, s);
            }
        }
    }

    private boolean post()
    {
        final FragmentActivity activity;
        if (captionLength() > 120)
        {
            break MISSING_BLOCK_LABEL_364;
        }
        Editable editable = mCaption.getText();
        activity = getActivity();
        String s;
        if (mPreviewPath != null)
        {
            s = mPreviewPath;
        } else
        {
            s = mVideoPath;
        }
        saveToCameraRoll(s);
        if (mPostVine.isChecked())
        {
            String s1 = mVideoPath;
            if (editable != null)
            {
                s = editable.toString();
            } else
            {
                s = "";
            }
            activity.startService(VineUploadService.getPostIntent(activity, s1, s, mPostTwitter.isChecked(), mPostFacebook.isChecked(), mChannelId, mIsRetry, mCaption.getEntities(), null, null, -1L, 0));
            activity.startService(VineUploadService.getShowProgressIntent(activity));
        } else
        {
            activity.startService(VineUploadService.getDiscardIntent(activity, mVideoPath));
        }
        FlurryUtils.trackPost(mPostVine.isChecked());
        FlurryUtils.trackPostTier(String.valueOf((int)(SystemUtil.getMemoryRatio(activity, true) * 2D)));
        activity.setResult(31);
        if (!mPostVine.isChecked()) goto _L2; else goto _L1
_L1:
        if (mPreviewPath == null) goto _L4; else goto _L3
_L3:
        RecordSessionManager.deleteSession((new File(mPreviewPath)).getParentFile(), "Session Completed.");
_L5:
        SLog.i("Session folder deleted: {}.", mPreviewPath);
_L2:
        IOException ioexception;
        if (mIsFromSony)
        {
            mProgress = new ProgressDialog(activity, 2);
            mProgress.setMessage(getString(0x7f0e020b));
            mProgress.show();
            (new Handler()).postDelayed(new Runnable() {

                final PostFragment this$0;
                final Activity val$activity;

                public void run()
                {
                    activity.startActivity(new Intent(activity, co/vine/android/SonyLaunchActivity));
                    activity.setResult(32);
                    activity.finish();
                }

            
            {
                this$0 = PostFragment.this;
                activity = activity1;
                super();
            }
            }, 750L);
        } else
        {
            activity.startActivity((new Intent(activity, co/vine/android/HomeTabActivity)).setFlags(0x4000000));
            activity.finish();
        }
        return true;
_L4:
        RecordSessionVersion.deleteSessionWithName(activity, (new File(mVideoPath)).getName());
          goto _L5
        ioexception;
        SLog.e("Failed to delete session folder.", ioexception);
          goto _L2
        mToastLengthExceeded.show();
        return true;
          goto _L5
    }

    public static Bundle prepareArguments(Intent intent, String s, String s1, String s2, boolean flag)
    {
        intent = BaseControllerFragment.prepareArguments(intent);
        intent.putBoolean("is_retry", flag);
        intent.putString("vid_path", s);
        intent.putString("pic_path", s1);
        intent.putString("preview_path", s2);
        return intent;
    }

    private void saveToCameraRoll(String s)
    {
        SLog.d("Saving to camera roll: {}.", s);
        File file1 = new File(s);
        File file = RecordConfigUtils.getCameraRollFile(getActivity(), System.currentTimeMillis(), FilenameUtils.getExtension(s));
        if (file == null)
        {
            SLog.d("Failed to find directory.");
            return;
        }
        if (file1.exists() && RecordConfigUtils.copySilently(file1, file))
        {
            s = getActivity();
            if (s != null)
            {
                MediaUtil.scanFile(s, file, null);
            }
            SLog.d("Renamed to finale position! {}, Scan {}.", file, file.getAbsolutePath());
            return;
        } else
        {
            SLog.d("Failed to move {}, file is probably already copied.", s);
            return;
        }
    }

    public Filter getFilter()
    {
        if (mFilter == null)
        {
            mFilter = new ComposeFilter(this, mAppController.getActiveId());
        }
        return mFilter;
    }

    public CursorAdapter getPopupAdapter()
    {
        return mTypeaheadAdapter;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getArguments();
        String s = bundle.getString("pic_path");
        mVideoPath = bundle.getString("vid_path");
        if (mVideoPath == null)
        {
            throw new IllegalArgumentException("Null video path.");
        }
        mPreviewPath = bundle.getString("preview_path");
        mIsFromSony = bundle.getBoolean("f_s");
        try
        {
            bundle = BitmapFactory.decodeFile(s);
            mImagePreview.setImageBitmap(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            CrashUtil.logException(bundle);
        }
        bundle = UploadManager.getUpload(getActivity(), mVideoPath);
        if (bundle != null)
        {
            bundle = bundle.getPostInfo();
            if (bundle != null)
            {
                mCaption.setText(((co.vine.android.api.VineUpload.PostInfo) (bundle)).caption);
            }
        }
        ((NotificationManager)getActivity().getSystemService("notification")).cancel(mVideoPath, 0);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 143
    //                   2 220
    //                   3 297;
           goto _L1 _L2 _L3 _L4
_L1:
        SLog.d("Facebook auth came back: {}", Integer.valueOf(i));
        if (j != -1) goto _L6; else goto _L5
_L5:
        Session session = Session.getActiveSession();
        if (session == null) goto _L8; else goto _L7
_L7:
        if (!session.onActivityResult(getActivity(), i, j, intent)) goto _L10; else goto _L9
_L9:
        if (!session.getPermissions().contains("publish_actions")) goto _L12; else goto _L11
_L11:
        AppController.setPendingFacebookToken(getActivity(), session.getAccessToken());
        intent = new ProgressDialog(getActivity(), 2);
        intent.setMessage(getString(0x7f0e0120));
        intent.setProgress(0);
        intent.show();
        mProgress = intent;
        mAppController.sendFacebookToken();
_L14:
        return;
_L2:
        if (j == -1)
        {
            String s = intent.getStringExtra("screen_name");
            String s2 = intent.getStringExtra("tk");
            String s4 = intent.getStringExtra("ts");
            long l = intent.getLongExtra("user_id", 0L);
            mAppController.connectTwitter(mAppController.getActiveSession(), s, s2, s4, l);
            return;
        } else
        {
            mPostTwitter.setChecked(false);
            return;
        }
_L3:
        if (j == -1)
        {
            String s1 = intent.getStringExtra("screen_name");
            String s3 = intent.getStringExtra("token");
            String s5 = intent.getStringExtra("secret");
            long l1 = intent.getLongExtra("user_id", 0L);
            mAppController.connectTwitter(mAppController.getActiveSession(), s1, s3, s5, l1);
            return;
        } else
        {
            mPostTwitter.setChecked(false);
            return;
        }
_L4:
        if (j != -1) goto _L14; else goto _L13
_L13:
        long l2;
        l2 = intent.getLongExtra("channel_id", -1L);
        intent = intent.getStringExtra("channel");
        if (l2 <= -1L || TextUtils.isEmpty(intent)) goto _L14; else goto _L15
_L15:
        mAddToChannelText.setText(intent);
        mChannelId = l2;
        mAddToChannelIcon.setSelected(true);
        FlurryUtils.trackChannelChange((new StringBuilder()).append(intent).append(" (id=").append(l2).append(")").toString());
        return;
_L12:
        getActivity().runOnUiThread(new Runnable() {

            final PostFragment this$0;

            public void run()
            {
                Util.showCenteredToast(getActivity(), 0x7f0e01a0);
            }

            
            {
                this$0 = PostFragment.this;
                super();
            }
        });
        mAppController.connectToFacebookPublish(this);
        return;
_L10:
        mPostFacebook.setChecked(false);
        return;
_L8:
        mPostFacebook.setChecked(false);
        super.onActivityResult(i, j, intent);
        return;
_L6:
        mPostFacebook.setChecked(false);
        return;
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        compoundbutton.getId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131362158: 41
    //                   2131362162: 189
    //                   2131362166: 167;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        mPostTwitter.setEnabled(flag);
        mPostFacebook.setEnabled(flag);
        if (!flag)
        {
            mPostTwitter.setChecked(false);
            mPostToTwitterText.setTextColor(getActivity().getResources().getColor(0x7f09007e));
            mPostFacebook.setChecked(false);
            mPostToFacebookText.setTextColor(getActivity().getResources().getColor(0x7f09007e));
            return;
        } else
        {
            mPostToTwitterText.setTextColor(getActivity().getResources().getColor(0x7f090061));
            mPostToFacebookText.setTextColor(getActivity().getResources().getColor(0x7f090061));
            return;
        }
_L4:
        if (mPostVine.isChecked()) goto _L6; else goto _L5
_L5:
        mPostFacebook.setChecked(false);
_L3:
        if (!mPostVine.isChecked())
        {
            mPostTwitter.setChecked(false);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (!flag) goto _L3; else goto _L7
_L7:
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
        if (!flag) goto _L1; else goto _L8
_L8:
        compoundbutton = getActivity();
        android.accounts.Account account = VineAccountHelper.getAccount(compoundbutton, mAppController.getActiveSession().getLoginEmail());
        AccountManager accountmanager = AccountManager.get(compoundbutton);
        if (account == null || accountmanager == null)
        {
            CrashUtil.logException(new VineLoggingException((new StringBuilder()).append("Account or AM is null: ").append(account).append(" ").append(accountmanager).toString()));
            return;
        }
        if (TextUtils.isEmpty(accountmanager.getUserData(account, "account_t_token")))
        {
            AppController.startTwitterAuthWithFinish(mTwitter, compoundbutton);
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362152: 
            view = new Intent(getActivity(), co/vine/android/ChannelsListActivity);
            view.putExtra("selected_channel", mChannelId);
            getActivity().startActivityForResult(view, 3);
            return;

        case 2131362167: 
            post();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        mTwitter = new Twitter(TwitterVineApp.API_KEY, TwitterVineApp.API_SECRET);
        mAppSessionListener = new PostSessionListener();
        mIsRetry = getArguments().getBoolean("is_retry", false);
        mToastLengthExceeded = Toast.makeText(getActivity(), 0x7f0e0058, 1);
        mToastLengthExceeded.setGravity(17, 0, 0);
        if (bundle == null)
        {
            mChannelId = -1L;
        } else
        {
            mChannelId = bundle.getLong("channel");
        }
        mUsersAdapter = new UsersAutoCompleteAdapter(getActivity(), mAppController);
        mTagsAdapter = new TagsAutoCompleteAdapter(getActivity(), mAppController);
        mTypeaheadAdapter = mUsersAdapter;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f100013, menu);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030071, viewgroup, false);
        viewgroup = layoutinflater.findViewById(0x7f0a0168);
        mAddToChannelIcon = (ImageView)viewgroup.findViewById(0x7f0a0169);
        mAddToChannelText = (TextView)viewgroup.findViewById(0x7f0a016a);
        mAddToChannel = viewgroup;
        mPostVine = (SwitchInterface)layoutinflater.findViewById(0x7f0a016e);
        mPostTwitter = (SwitchInterface)layoutinflater.findViewById(0x7f0a0172);
        mPostFacebook = (SwitchInterface)layoutinflater.findViewById(0x7f0a0176);
        mImagePreview = (ImageView)layoutinflater.findViewById(0x7f0a0165);
        viewgroup = (PopupEditText)layoutinflater.findViewById(0x7f0a0166);
        viewgroup.setAdapter(mUsersAdapter);
        mTokenizer = new ComposeTokenizer(this);
        viewgroup.setTokenizer(mTokenizer, this, mAppController.getTypeaheadThrottle());
        viewgroup.setPopupEditTextListener(this);
        mCaption = viewgroup;
        mPostToTwitterText = (TextView)layoutinflater.findViewById(0x7f0a0171);
        mPostToFacebookText = (TextView)layoutinflater.findViewById(0x7f0a0175);
        mAddToChannel.setOnClickListener(this);
        mAddToChannel.setOnLongClickListener(this);
        mPostVine.setChecked(true);
        mPostVine.setEnabled(true);
        mPostVine.setOnCheckedChangeListener(this);
        mPostTwitter.setChecked(false);
        mPostTwitter.setOnCheckedChangeListener(this);
        mPostFacebook.setChecked(false);
        mPostFacebook.setOnCheckedChangeListener(this);
        layoutinflater.findViewById(0x7f0a0177).setOnClickListener(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        VineSuggestionsProvider.clearRealtimeUserSuggestions();
        VineSuggestionsProvider.clearRealtimeTagSuggestions();
    }

    public void onFiltering(CharSequence charsequence)
    {
        boolean flag1 = true;
        boolean flag = true;
        if (!TextUtils.isEmpty(charsequence))
        {
            charsequence = charsequence.toString();
            String s;
            int i;
            if (charsequence.startsWith("@"))
            {
                s = "mention";
                charsequence = charsequence.substring(1, charsequence.length());
            } else
            if (charsequence.startsWith("#"))
            {
                s = "tag";
                charsequence = charsequence.substring(1, charsequence.length());
            } else
            {
                s = null;
                charsequence = null;
            }
            i = mAppController.getTypeaheadFetchThreshold(s);
            if (!TextUtils.isEmpty(charsequence) && charsequence.length() >= i)
            {
                if ("mention".equals(s))
                {
                    if (VineSuggestionsProvider.getRealtimeUserSuggestions(charsequence) != null)
                    {
                        flag = false;
                    }
                } else
                if ("tag".equals(s))
                {
                    if (VineSuggestionsProvider.getRealtimeTagSuggestions(charsequence) == null)
                    {
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    if ("mention".equals(s))
                    {
                        mAppController.fetchUserTypeahead(charsequence);
                    } else
                    if ("tag".equals(s))
                    {
                        mAppController.fetchTagTypeahead(charsequence);
                        return;
                    }
                }
            }
        }
    }

    public boolean onLongClick(View view)
    {
        switch (view.getId())
        {
        default:
            return false;

        case 2131362152: 
            mAddToChannelText.setText(0x7f0e0047);
            break;
        }
        mChannelId = -1L;
        mAddToChannelIcon.setSelected(false);
        FlurryUtils.trackChannelChange("Channel removed");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131362366: 51
    //                   2131362367: 60
    //                   2131362385: 46;
           goto _L1 _L2 _L3 _L4
_L1:
        return super.onOptionsItemSelected(menuitem);
_L4:
        return post();
_L2:
        insertText("@");
_L6:
        return true;
_L3:
        insertText("#");
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onPopupItemSelected(int i, int j, CharSequence charsequence, long l)
    {
    }

    public void onPopupShown()
    {
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putLong("channel", mChannelId);
    }

    public void setPopupAdapter(String s)
    {
        if (!"users_adapter".equals(s)) goto _L2; else goto _L1
_L1:
        mTypeaheadAdapter = mUsersAdapter;
_L4:
        mCaption.setAdapter(mTypeaheadAdapter);
        return;
_L2:
        if ("tags_adapter".equals(s))
        {
            mTypeaheadAdapter = mTagsAdapter;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }





}
