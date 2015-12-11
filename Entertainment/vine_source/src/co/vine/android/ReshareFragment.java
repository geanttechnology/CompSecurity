// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.TwitterVineApp;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.service.PendingAction;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import com.edisonwang.android.slog.SLog;
import com.twitter.android.sdk.Twitter;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, VineLoggingException, CaptchaRequestHelper, PendingCaptchaRequest

public class ReshareFragment extends BaseControllerFragment
{
    class ReshareListener extends AppSessionListener
    {

        final ReshareFragment this$0;

        public void onCaptchaRequired(String s, String s1, PendingAction pendingaction)
        {
            mCaptchaRequestHelper.onCaptchaRequired(getActivity(), s, pendingaction.actionCode, pendingaction.bundle, s1);
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
                getActivity().finish();
            }
        }

        public void onConnectTwitterComplete(String s, int i, String s1, String s2, String s3, String s4, long l)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            if (i == 200)
            {
                if (l > 0L && !TextUtils.isEmpty(s3) && !TextUtils.isEmpty(s4))
                {
                    VineAccountHelper.saveTwitterInfo(getActivity(), mAppController.getActiveSession().getLoginEmail(), s2, s3, s4, l);
                    s = Util.getDefaultSharedPrefs(getActivity()).edit();
                    s.putBoolean("settings_twitter_connected", true);
                    s.commit();
                }
                return;
            } else
            {
                Util.showCenteredToast(getActivity(), s1);
                getActivity().finish();
                return;
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            hashmap = (UrlImage)hashmap.get(mThumbnailKey);
            if (hashmap != null && hashmap.isValid())
            {
                setThumbnailImage(((UrlImage) (hashmap)).bitmap);
            }
        }

        public void onSharePostComplete(String s, int i, String s1)
        {
            if (mShareProgress != null)
            {
                mShareProgress.dismiss();
            }
            if (i != 200)
            {
                if (!TextUtils.isEmpty(s1))
                {
                    Util.showCenteredToast(getActivity(), getString(0x7f0e00cc, new Object[] {
                        s1
                    }));
                }
                return;
            }
            if (!"facebook".equals(mNetwork)) goto _L2; else goto _L1
_L1:
            Util.showCenteredToast(getActivity(), 0x7f0e0205);
_L4:
            getActivity().finish();
            return;
_L2:
            if ("twitter".equals(mNetwork))
            {
                Util.showCenteredToast(getActivity(), 0x7f0e0213);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        ReshareListener()
        {
            this$0 = ReshareFragment.this;
            super();
        }
    }


    public static final String ARG_DESCRIPTION = "description";
    public static final String ARG_NETWORK = "network";
    public static final String ARG_POST_ID = "post_id";
    public static final String ARG_SHARE_URL = "share_url";
    public static final String ARG_THUMBNAIL_URL = "thumbnail_url";
    public static final String FRAGMENT_TAG = "reshare";
    private static final int MAX_CHARS_TWITTER = 140;
    public static final String NETWORK_FACEBOOK = "facebook";
    public static final String NETWORK_TWITTER = "twitter";
    private CaptchaRequestHelper mCaptchaRequestHelper;
    private EditText mCaption;
    private String mDescription;
    private String mNetwork;
    private long mPostId;
    private ProgressDialog mProgress;
    private ProgressDialog mShareProgress;
    private String mShareUrl;
    private ImageKey mThumbnailKey;
    private String mThumbnailUrl;
    private ImageView mThumbnailView;
    private Twitter mTwitter;

    public ReshareFragment()
    {
        mCaptchaRequestHelper = new CaptchaRequestHelper() {

            final ReshareFragment this$0;

            protected void handleFailedCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
            {
                pendingcaptcharequest = mAppController.generateReqIdForCanceledCaptcha();
                mAppController.failRequest(pendingcaptcharequest, mPendingCaptchaRequest.actionCode, mPendingCaptchaRequest.bundle);
            }

            protected void handleRetryCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
            {
                mAppController.retryRequest(mPendingCaptchaRequest.actionCode, mPendingCaptchaRequest.bundle);
            }

            
            {
                this$0 = ReshareFragment.this;
                super();
            }
        };
    }

    private void setThumbnailImage(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            mThumbnailView.setImageDrawable(new RecyclableBitmapDrawable(mThumbnailView.getResources(), bitmap));
            return;
        } else
        {
            mThumbnailView.setImageBitmap(null);
            mThumbnailView.setBackgroundColor(getResources().getColor(0x7f09007f));
            return;
        }
    }

    private boolean validateSocialConnect()
    {
        boolean flag = false;
        if ("facebook".equals(mNetwork))
        {
            flag = mAppController.isConnectedToFacebook(getActivity());
        } else
        if ("twitter".equals(mNetwork))
        {
            return Util.getDefaultSharedPrefs(getActivity()).getBoolean("settings_twitter_connected", false);
        }
        return flag;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!"facebook".equals(mNetwork)) goto _L2; else goto _L1
_L1:
        if (mAppController.getValidFacebookSession(getActivity(), false) != null) goto _L4; else goto _L3
_L3:
        mAppController.connectToFacebookInitialize(this);
_L6:
        mCaption.setLines(8);
        mCaption.setHorizontallyScrolling(false);
        if (!TextUtils.isEmpty(mThumbnailUrl))
        {
            mThumbnailKey = new ImageKey(mThumbnailUrl);
            setThumbnailImage(mAppController.getPhotoBitmap(mThumbnailKey));
        }
        if (!TextUtils.isEmpty(mDescription))
        {
            mCaption.setText(mDescription);
        }
        return;
_L4:
        if (mAppController.getPendingFacebookToken() != null)
        {
            mAppController.sendFacebookToken();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ("twitter".equals(mNetwork))
        {
            bundle = getActivity();
            android.accounts.Account account = VineAccountHelper.getAccount(bundle, mAppController.getActiveSession().getLoginEmail());
            AccountManager accountmanager = AccountManager.get(bundle);
            if (account == null || accountmanager == null)
            {
                CrashUtil.logException(new VineLoggingException((new StringBuilder()).append("Account or AM is null: ").append(account).append(" ").append(accountmanager).toString()));
            } else
            if (TextUtils.isEmpty(accountmanager.getUserData(account, "account_t_token")))
            {
                AppController.startTwitterAuthWithFinish(mTwitter, bundle);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j != 0) goto _L2; else goto _L1
_L1:
        getActivity().finish();
_L4:
        return;
_L2:
        if (!mCaptchaRequestHelper.onActivityResult(i, j, intent))
        {
            break; /* Loop/switch isn't completed */
        }
        if (mShareProgress != null && mShareProgress.isShowing())
        {
            mShareProgress.hide();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (mProgress == null || !mProgress.isShowing())
        {
            ProgressDialog progressdialog = new ProgressDialog(getActivity(), 0x7f0f0037);
            progressdialog.setMessage(getString(0x7f0e0120));
            progressdialog.setProgress(0);
            progressdialog.show();
            mProgress = progressdialog;
        }
        i;
        JVM INSTR tableswitch 1 2: default 136
    //                   1 213
    //                   2 279;
           goto _L5 _L6 _L7
_L7:
        continue; /* Loop/switch isn't completed */
_L5:
        SLog.d("Facebook auth came back: {}", Integer.valueOf(i));
        if (j != -1) goto _L4; else goto _L8
_L8:
        com.facebook.Session session = com.facebook.Session.getActiveSession();
        if (session == null) goto _L10; else goto _L9
_L9:
        if (!session.onActivityResult(getActivity(), i, j, intent)) goto _L4; else goto _L11
_L11:
        if (session.getPermissions().contains("publish_actions"))
        {
            AppController.setPendingFacebookToken(getActivity(), session.getAccessToken());
            mAppController.sendFacebookToken();
            return;
        } else
        {
            getActivity().runOnUiThread(new Runnable() {

                final ReshareFragment this$0;

                public void run()
                {
                    Util.showCenteredToast(getActivity(), 0x7f0e01a0);
                }

            
            {
                this$0 = ReshareFragment.this;
                super();
            }
            });
            mAppController.connectToFacebookPublish(this);
            return;
        }
_L6:
        if (j != -1) goto _L4; else goto _L12
_L12:
        String s = intent.getStringExtra("screen_name");
        String s2 = intent.getStringExtra("tk");
        String s4 = intent.getStringExtra("ts");
        long l = intent.getLongExtra("user_id", 0L);
        mAppController.connectTwitter(mAppController.getActiveSession(), s, s2, s4, l);
        return;
        if (j != -1) goto _L4; else goto _L13
_L13:
        String s1 = intent.getStringExtra("screen_name");
        String s3 = intent.getStringExtra("token");
        String s5 = intent.getStringExtra("secret");
        long l1 = intent.getLongExtra("user_id", 0L);
        mAppController.connectTwitter(mAppController.getActiveSession(), s1, s3, s5, l1);
        return;
_L10:
        super.onActivityResult(i, j, intent);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new ReshareListener();
        Bundle bundle1 = getArguments();
        mPostId = bundle1.getLong("post_id");
        mDescription = bundle1.getString("description");
        mNetwork = bundle1.getString("network");
        mShareUrl = bundle1.getString("share_url");
        if (mShareUrl == null)
        {
            mShareUrl = "";
        }
        mThumbnailUrl = bundle1.getString("thumbnail_url");
        if (mThumbnailUrl == null)
        {
            mThumbnailUrl = "";
        }
        mTwitter = new Twitter(TwitterVineApp.API_KEY, TwitterVineApp.API_SECRET);
        if (bundle != null)
        {
            mCaptchaRequestHelper.restorePendingCaptchaRequest(bundle);
        }
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        MenuItem menuitem;
        if (isDetached())
        {
            break MISSING_BLOCK_LABEL_94;
        }
        menuinflater.inflate(0x7f100011, menu);
        menuitem = menu.findItem(0x7f0a0245);
        if (!"facebook".equals(mNetwork)) goto _L2; else goto _L1
_L1:
        menuitem.setTitle(getString(0x7f0e0202).toUpperCase());
_L4:
        super.onCreateOptionsMenu(menu, menuinflater);
        return;
_L2:
        if ("twitter".equals(mNetwork))
        {
            menuitem.setTitle(getString(0x7f0e0203).toUpperCase());
        }
        if (true) goto _L4; else goto _L3
_L3:
        menu;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030088, viewgroup, false);
        mCaption = (EditText)layoutinflater.findViewById(0x7f0a0166);
        mThumbnailView = (ImageView)layoutinflater.findViewById(0x7f0a0065);
        return layoutinflater;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i;
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362373: 
            i = 140 - mShareUrl.length() - 1;
            break;
        }
        if ("twitter".equals(mNetwork) && mCaption.getText().length() > i)
        {
            Util.showCenteredToast(getActivity(), getString(0x7f0e01ae, new Object[] {
                Integer.valueOf(i)
            }));
            return true;
        }
        if (validateSocialConnect())
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(mCaption.getWindowToken(), 0);
            menuitem = mCaption.getText().toString();
            mAppController.sharePost(mNetwork, menuitem, mPostId);
            menuitem = new ProgressDialog(getActivity(), 0x7f0f0037);
            menuitem.setMessage(getString(0x7f0e021a));
            menuitem.setProgress(0);
            menuitem.show();
            mShareProgress = menuitem;
            return true;
        } else
        {
            menuitem = (new StringBuilder()).append(mNetwork.substring(0, 1).toUpperCase()).append(mNetwork.substring(1)).toString();
            Util.showCenteredToast(getActivity(), getString(0x7f0e0206, new Object[] {
                menuitem
            }));
            getActivity().finish();
            return true;
        }
    }

    public void onResume()
    {
        super.onResume();
        if (mCaption != null)
        {
            Util.setSoftKeyboardVisibility(getActivity(), mCaption, true);
        }
        mCaptchaRequestHelper.handlePendingCaptchaRequest();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mCaptchaRequestHelper.onSaveInstanceState(bundle);
    }






}
