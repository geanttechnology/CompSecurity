// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import co.vine.android.recorder.BasicVineRecorder;
import co.vine.android.recorder.RecordController;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.UploadManager;
import com.edisonwang.android.slog.SLog;
import java.io.File;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, PostFragment

public class PostActivity extends BaseControllerActionBarActivity
    implements co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{

    public static final String AG_CAMERA_WAIT_TIME = "camera_wait";
    public static final String AG_COMBINE_WAIT_TIME = "combine_wait";
    public static final String AG_FROM_SONY = "f_s";
    public static final String AG_IS_RETRY = "is_retry";
    public static final String AG_PREVIEW_PATH = "preview_path";
    public static final String AG_THUMBNAIL_PATH = "pic_path";
    private static final int DIALOG_UNSAVED_CHANGES = 292;
    private static final String POST_TAG = "post";
    private PostFragment mFrag;
    private String mVideoPath;

    public PostActivity()
    {
    }

    public static Intent getIntent(Context context, String s, String s1, String s2, boolean flag, boolean flag1)
    {
        context = new Intent(context, co/vine/android/PostActivity);
        if (s == null || s1 == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Well, you should give two paths that are not null you know: ").append(s).append(" ").append(s1).toString());
        } else
        {
            context.setData(Uri.fromFile(new File(s)));
            context.putExtra("pic_path", s1);
            context.putExtra("preview_path", s2);
            context.putExtra("is_retry", flag);
            context.putExtra("f_s", flag1);
            context.putExtra("camera_wait", BasicVineRecorder.sTimeTaken);
            context.putExtra("combine_wait", RecordController.sMaxKnownStopTime);
            return context;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (mFrag == null)
        {
            mFrag = (PostFragment)getSupportFragmentManager().findFragmentByTag("post");
        }
        if (mFrag != null)
        {
            mFrag.onActivityResult(i, j, intent);
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onBackPressed()
    {
        FlurryUtils.trackBackFromPostScreen();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setRequestedOrientation(1);
        if (bundle == null)
        {
            setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e020f, Boolean.valueOf(true));
            bundle = getIntent();
            mVideoPath = bundle.getData().getPath();
            PostFragment postfragment = new PostFragment();
            Bundle bundle1 = PostFragment.prepareArguments(bundle, mVideoPath, bundle.getStringExtra("pic_path"), bundle.getStringExtra("preview_path"), bundle.getBooleanExtra("is_retry", false));
            SLog.d("Post activity started for {}.", mVideoPath);
            postfragment.setArguments(bundle1);
            BasicVineRecorder.sTimeTaken = bundle.getLongExtra("camera_wait", 0L);
            RecordController.sMaxKnownStopTime = bundle.getLongExtra("combine_wait", 0L);
            mFrag = postfragment;
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, postfragment, "post").commit();
        }
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 292: 
            switch (j)
            {
            default:
                return;

            case -2: 
                dialoginterface.dismiss();
                return;

            case -1: 
                FlurryUtils.trackAbandonedStage("post");
                break;
            }
            break;
        }
        UploadManager.removeFromUploadQueue(this, mVideoPath);
        finish();
    }
}
