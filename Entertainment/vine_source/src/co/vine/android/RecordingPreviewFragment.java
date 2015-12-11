// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import co.vine.android.client.AppController;
import co.vine.android.player.OnSingleVideoClickedListener;
import co.vine.android.player.SdkVideoView;
import co.vine.android.player.StaticSizeVideoView;
import co.vine.android.provider.VineProviderHelper;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.UploadManager;
import co.vine.android.util.ViewUtil;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesTextView;
import co.vine.android.widgets.PromptDialogSupportFragment;
import java.io.File;
import java.util.ArrayList;

// Referenced classes of package co.vine.android:
//            BaseFragment, AbstractRecordingActivity, RecipientPickerActivity, ConversationActivity, 
//            Settings, SonyStartActivity, PostActivity

public class RecordingPreviewFragment extends BaseFragment
    implements android.view.View.OnClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{

    public static final String AG_THUMBNAIL_PATH = "pic_path";
    public static final String AG_UPLOAD_PATH = "upload_path";
    public static final String AG_VIDEO_PATH = "video_path";
    public static final String ARG_AM_FOLLOWING = "am_following";
    public static final String ARG_COLOR = "color";
    public static final String ARG_CONVERSATION_ROW_ID = "conversation_row_id";
    public static final String ARG_DIRECT_USER_ID = "direct_user_id";
    public static final String ARG_FROM_SONY = "f_s";
    public static final String ARG_IS_MESSAGING = "messaging";
    public static final String ARG_IS_VM_ONBOARDING = "is_vm_onboarding";
    public static final String ARG_RECIPIENT_USERNAME = "recipient_username";
    private static final int DIALOG_MUST_LOGIN = 1;
    private static final int REQUEST_CODE_LOGIN_TO_POST = 12345;
    public static final int REQUEST_POST = 1990;
    public static final int REQUEST_SEND_MESSAGE = 1991;
    private static final long TRANSITION_DURATION = 250L;
    private static final int VALID_MAX_LOOPS[] = {
        0, 1, 3, 6
    };
    private boolean mAmFollowing;
    private int mColor;
    private long mConversationRowId;
    private long mDirectUserId;
    private RecordingFile mFinalFile;
    private boolean mIsFromSony;
    private boolean mIsMessaging;
    private boolean mIsVmOnboarding;
    private int mMaxLoop;
    private EditText mMessagingEditText;
    private Button mMessagingLoopLimitText;
    private View mNextButton;
    private View mPreviewButtons;
    private String mRecipientUsername;
    private String mThumbnailPath;
    private String mUploadPath;
    private String mVideoPath;
    private SdkVideoView mVideoPlayer;

    public RecordingPreviewFragment()
    {
    }

    private void animateInViews()
    {
        if (!mIsMessaging)
        {
            mNextButton.setAlpha(0.0F);
            mNextButton.setVisibility(0);
            mNextButton.animate().setDuration(250L).alpha(1.0F).start();
        }
        mPreviewButtons.setAlpha(0.0F);
        mPreviewButtons.setVisibility(0);
        mPreviewButtons.animate().setDuration(250L).alpha(1.0F).start();
    }

    private void animateOutViews()
    {
        mNextButton.animate().setDuration(250L).alpha(0.0F).start();
        mPreviewButtons.animate().setDuration(250L).alpha(0.0F).start();
    }

    public static RecordingPreviewFragment newInstance(String s, String s1, String s2, boolean flag, long l, long l1, 
            boolean flag1, int i, String s3, boolean flag2, boolean flag3)
    {
        RecordingPreviewFragment recordingpreviewfragment = new RecordingPreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("video_path", s);
        bundle.putString("pic_path", s2);
        bundle.putString("upload_path", s1);
        bundle.putBoolean("messaging", flag);
        bundle.putLong("conversation_row_id", l);
        bundle.putLong("direct_user_id", l1);
        bundle.putBoolean("f_s", flag1);
        bundle.putInt("color", i);
        bundle.putString("recipient_username", s3);
        bundle.putBoolean("am_following", flag2);
        bundle.putBoolean("is_vm_onboarding", flag3);
        recordingpreviewfragment.setArguments(bundle);
        return recordingpreviewfragment;
    }

    private void updateMessageLoopLimit()
    {
        if (mMessagingLoopLimitText != null)
        {
            Button button = mMessagingLoopLimitText;
            StringBuilder stringbuilder = (new StringBuilder()).append("Loop Limit: ");
            Object obj;
            if (VALID_MAX_LOOPS[mMaxLoop] == 0)
            {
                obj = "Infinite";
            } else
            {
                obj = Integer.valueOf(VALID_MAX_LOOPS[mMaxLoop]);
            }
            button.setText(stringbuilder.append(obj).toString());
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        RecordConfigUtils.deletePreProcess(getActivity().getFilesDir());
        mVideoPlayer.setVideoPath(mVideoPath);
        CrashUtil.log("Preview: {}", new Object[] {
            mVideoPath
        });
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            super.onActivityResult(i, j, intent);
            return;

        case 12345: 
            switch (j)
            {
            default:
                return;

            case -1: 
                uploadAndToPost();
                break;
            }
            return;

        case 1990: 
            switch (j)
            {
            default:
                return;

            case 32: // ' '
                getActivity().finish();
                break;
            }
            break;
        }
    }

    public void onClick(View view)
    {
        AbstractRecordingActivity abstractrecordingactivity = (AbstractRecordingActivity)getActivity();
        if (abstractrecordingactivity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mUploadPath == null)
        {
            mUploadPath = abstractrecordingactivity.makeSureUploadIsReady();
        }
        switch (view.getId())
        {
        case 2131362174: 
        case 2131362177: 
        default:
            return;

        case 2131362172: 
        case 2131362175: 
            animateOutViews();
            previewToRecord((AbstractRecordingActivity)getActivity(), false);
            FlurryUtils.trackPreviewAction("capture");
            return;

        case 2131362178: 
            if (!AppController.getInstance(abstractrecordingactivity).isLoggedIn())
            {
                view = PromptDialogSupportFragment.newInstance(1);
                view.setMessage(0x7f0e0207);
                view.setPositiveButton(0x104000a);
                view.setNeutralButton(0x1040000);
                view.setListener(this);
                view.setTargetFragment(this, 0);
                view.show(getFragmentManager());
                return;
            } else
            {
                toPost();
                FlurryUtils.trackPreviewAction("post");
                return;
            }

        case 2131362176: 
            view = mMessagingEditText.getText();
            if (view != null)
            {
                view = view.toString();
            } else
            {
                view = "";
            }
            if (mIsMessaging)
            {
                if (mDirectUserId < 0L && mConversationRowId < 0L)
                {
                    abstractrecordingactivity.startActivityForResult(RecipientPickerActivity.getIntent(getActivity(), view, mUploadPath, mThumbnailPath, mVideoPath, VALID_MAX_LOOPS[mMaxLoop], mIsVmOnboarding), 1991);
                    abstractrecordingactivity.startService(VineUploadService.getShowProgressIntent(getActivity()));
                    return;
                }
                ArrayList arraylist;
                if (mDirectUserId >= 0L)
                {
                    arraylist = new ArrayList();
                    arraylist.add(VineRecipient.fromUser(mDirectUserId));
                } else
                {
                    arraylist = VineProviderHelper.getConversationRecipients(abstractrecordingactivity.getContentResolver(), mConversationRowId);
                }
                abstractrecordingactivity.startService(VineUploadService.getVMPostIntent(abstractrecordingactivity, mUploadPath, false, mConversationRowId, arraylist, view, VALID_MAX_LOOPS[mMaxLoop]));
                abstractrecordingactivity.startService(VineUploadService.getShowProgressIntent(abstractrecordingactivity));
                if (abstractrecordingactivity.startConversationOnFinish())
                {
                    view = ConversationActivity.getIntent(abstractrecordingactivity.getApplicationContext(), mConversationRowId, mRecipientUsername, mDirectUserId, mAmFollowing, false);
                    view.setFlags(0x4000000);
                    startActivity(view);
                }
                abstractrecordingactivity.finish();
                return;
            }
            break;

        case 2131362173: 
            animateOutViews();
            previewToRecord((AbstractRecordingActivity)getActivity(), true);
            FlurryUtils.trackPreviewAction("edit");
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getArguments();
        mVideoPath = bundle.getString("video_path");
        mThumbnailPath = bundle.getString("pic_path");
        mUploadPath = bundle.getString("upload_path");
        mIsMessaging = bundle.getBoolean("messaging");
        mConversationRowId = bundle.getLong("conversation_row_id", -1L);
        mRecipientUsername = bundle.getString("recipient_username");
        mAmFollowing = bundle.getBoolean("am_following");
        mDirectUserId = bundle.getLong("direct_user_id", -1L);
        mIsFromSony = bundle.getBoolean("f_s");
        mColor = bundle.getInt("color", -1);
        if (mColor == Settings.DEFAULT_PROFILE_COLOR || mColor <= 0)
        {
            mColor = 0xffffff & getResources().getColor(0x7f090096);
        }
        mColor = mColor | 0xff000000;
        mIsVmOnboarding = bundle.getBoolean("is_vm_onboarding");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = getResources();
        layoutinflater = layoutinflater.inflate(0x7f030072, viewgroup, false);
        viewgroup = SystemUtil.getDisplaySize(getActivity());
        mMessagingEditText = (EditText)layoutinflater.findViewById(0x7f0a0179);
        mMessagingLoopLimitText = (Button)layoutinflater.findViewById(0x7f0a017a);
        mNextButton = layoutinflater.findViewById(0x7f0a0182);
        Object obj;
        Object obj1;
        int j;
        if (mIsMessaging)
        {
            mMaxLoop = 0;
            updateMessageLoopLimit();
            if (mMessagingLoopLimitText != null)
            {
                mMessagingLoopLimitText.setOnClickListener(new android.view.View.OnClickListener() {

                    final RecordingPreviewFragment this$0;

                    public void onClick(View view)
                    {
                        mMaxLoop = (mMaxLoop + 1) % RecordingPreviewFragment.VALID_MAX_LOOPS.length;
                        updateMessageLoopLimit();
                    }

            
            {
                this$0 = RecordingPreviewFragment.this;
                super();
            }
                });
                mMessagingLoopLimitText.setVisibility(8);
            }
            mMessagingEditText.setVisibility(0);
            mPreviewButtons = layoutinflater.findViewById(0x7f0a017e);
            mPreviewButtons.setVisibility(0);
            mPreviewButtons.setOnTouchListener(new android.view.View.OnTouchListener() {

                final RecordingPreviewFragment this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                this$0 = RecordingPreviewFragment.this;
                super();
            }
            });
            int i = bundle.getColor(0x7f090025);
            mPreviewButtons.setBackgroundColor(i);
            layoutinflater.setBackgroundColor(i);
            layoutinflater.findViewById(0x7f0a00e0).setBackgroundColor(i);
            TypefacesTextView typefacestextview = (TypefacesTextView)layoutinflater.findViewById(0x7f0a0181);
            typefacestextview.setWeight(3);
            typefacestextview.setTypeface(Typefaces.get(getActivity()).mediumContent);
            typefacestextview.setVisibility(0);
            if (!TextUtils.isEmpty(mRecipientUsername))
            {
                typefacestextview.setText(mRecipientUsername);
            }
        } else
        {
            mMessagingLoopLimitText.setVisibility(8);
            mMessagingEditText.setVisibility(8);
            mPreviewButtons = layoutinflater.findViewById(0x7f0a017b);
            mPreviewButtons.setVisibility(0);
            mPreviewButtons.setOnTouchListener(new android.view.View.OnTouchListener() {

                final RecordingPreviewFragment this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                this$0 = RecordingPreviewFragment.this;
                super();
            }
            });
            mNextButton.setVisibility(0);
        }
        mNextButton.setOnClickListener(this);
        layoutinflater.findViewById(0x7f0a017c).setOnClickListener(this);
        layoutinflater.findViewById(0x7f0a017d).setOnClickListener(this);
        obj = (TextView)layoutinflater.findViewById(0x7f0a0180);
        ((TextView) (obj)).setOnClickListener(this);
        if (mIsMessaging)
        {
            ((TextView) (obj)).setTextColor(mColor);
        }
        obj = layoutinflater.findViewById(0x7f0a017f);
        ((View) (obj)).setOnClickListener(this);
        if (mIsMessaging)
        {
            ViewUtil.fillColor(bundle, mColor, 0x7f02014c, ((View) (obj)));
        }
        mVideoPlayer = (SdkVideoView)layoutinflater.findViewById(0x7f0a0178);
        mVideoPlayer.setVisibility(0);
        mVideoPlayer.setAutoPlayOnPrepared(true);
        mVideoPlayer.setKeepScreenOn(true);
        obj = layoutinflater.findViewById(0x7f0a00d6);
        j = bundle.getDimensionPixelSize(0x7f0b001c);
        ((StaticSizeVideoView)mVideoPlayer).setSize(((Point) (viewgroup)).x, ((Point) (viewgroup)).x);
        ((View) (obj)).setOnClickListener(new OnSingleVideoClickedListener(mVideoPlayer));
        mVideoPlayer.setLooping(true);
        obj = new Rect();
        obj1 = getActivity().getWindow();
        ((Window) (obj1)).getDecorView().getWindowVisibleDisplayFrame(((Rect) (obj)));
        ((Window) (obj1)).setSoftInputMode(16);
        obj1 = layoutinflater.findViewById(0x7f0a00a3);
        if (mIsMessaging)
        {
            ((View) (obj1)).setVisibility(8);
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)mNextButton.getLayoutParams();
            int k = bundle.getDimensionPixelSize(0x7f0b0061);
            layoutparams.setMargins(0, 0, 0, (((Rect) (obj)).bottom - ((Rect) (obj)).top - ((Point) (viewgroup)).x - j - k) / 2);
            mNextButton.setLayoutParams(layoutparams);
            k = ((Rect) (obj)).bottom;
            int l = ((Rect) (obj)).top;
            int i1 = ((Point) (viewgroup)).x;
            viewgroup = (android.widget.RelativeLayout.LayoutParams)((View) (obj1)).getLayoutParams();
            viewgroup.height = k - l - j - i1;
            ((View) (obj1)).setLayoutParams(viewgroup);
            ((View) (obj1)).setOnTouchListener(new android.view.View.OnTouchListener() {

                final RecordingPreviewFragment this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                this$0 = RecordingPreviewFragment.this;
                super();
            }
            });
        }
        animateInViews();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mFinalFile = null;
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            switch (j)
            {
            default:
                return;

            case -1: 
                dialoginterface = getActivity();
                break;
            }
            break;
        }
        Intent intent = new Intent(dialoginterface, co/vine/android/SonyStartActivity);
        intent.putExtra("login_request_start_activity", true);
        dialoginterface.startActivityForResult(intent, 12345);
    }

    public void onPause()
    {
        super.onPause();
        if (mVideoPlayer.canPause())
        {
            mVideoPlayer.pause();
        }
    }

    public void onResume()
    {
        super.onResume();
        animateInViews();
        if (mVideoPlayer.mCurrentState == 7)
        {
            mVideoPlayer.start();
        }
    }

    public void previewToRecord(AbstractRecordingActivity abstractrecordingactivity, boolean flag)
    {
        if (abstractrecordingactivity != null)
        {
            abstractrecordingactivity.toRecord(false, flag, mFinalFile);
        }
    }

    public void setFinalFile(RecordingFile recordingfile)
    {
        mFinalFile = recordingfile;
    }

    public void toPost()
    {
        Object obj = (AbstractRecordingActivity)getActivity();
        if (obj == null)
        {
            return;
        }
        if (BuildUtil.isIsHwEncodingEnabled())
        {
            mUploadPath = ((AbstractRecordingActivity) (obj)).makeSureUploadIsReady();
        }
        obj = PostActivity.getIntent(getActivity(), mUploadPath, mThumbnailPath, mVideoPath, false, mIsFromSony);
        getActivity().startActivityForResult(((Intent) (obj)), 1990);
    }

    public void uploadAndToPost()
    {
        AbstractRecordingActivity abstractrecordingactivity = (AbstractRecordingActivity)getActivity();
        if (abstractrecordingactivity == null)
        {
            return;
        }
        try
        {
            if (BuildUtil.isIsHwEncodingEnabled())
            {
                abstractrecordingactivity.makeSureUploadIsReady();
            }
            mUploadPath = UploadManager.addToUploadQueue(abstractrecordingactivity, mFinalFile, mThumbnailPath, mFinalFile.folder.getName(), mIsMessaging, mConversationRowId);
            toPost();
            return;
        }
        catch (Exception exception)
        {
            CrashUtil.logException(exception);
        }
        return;
    }




/*
    static int access$002(RecordingPreviewFragment recordingpreviewfragment, int i)
    {
        recordingpreviewfragment.mMaxLoop = i;
        return i;
    }

*/


}
