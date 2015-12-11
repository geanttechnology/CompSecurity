// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.api.TwitterUser;
import co.vine.android.api.VineLogin;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.ContactsHelper;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.ImageUtils;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.SpanClickListener;
import co.vine.android.widget.StyledClickableSpan;
import co.vine.android.widgets.PromptDialogSupportFragment;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, SignUpPagerActivity, ImagePicker, EditProfileCropActivity, 
//            SetThumbnailTask, WebViewActivity

public class SignUpNameAvatarFragment extends BaseControllerFragment
    implements TextWatcher, android.view.View.OnClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener, SetThumbnailTask.SetThumbnailListener, ImagePicker.Listener, co.vine.android.util.ContactsHelper.ContactHelperListener, SpanClickListener
{
    class SignUpListener extends AppSessionListener
    {

        final SignUpNameAvatarFragment this$0;

        public void onGetTwitterUserComplete(String s, int i, String s1, TwitterUser twitteruser, VineLogin vinelogin)
        {
            if (i == 200 || twitteruser == null) goto _L2; else goto _L1
_L1:
            mName.setText(twitteruser.name);
            mPhoneNumberContainer.setVisibility(0);
            mProfileUri = null;
            if (twitteruser.defaultProfileImage) goto _L4; else goto _L3
_L3:
            s = new ImageKey(twitteruser.profileUrl);
            s1 = mAppController.getPhotoBitmap(s);
            setAvatar(s1);
            if (mPhotoAttached)
            {
                mProfileImage.setTag(null);
                mImagePicker.saveProfileImage(s1);
                if (mProgress != null)
                {
                    mProgress.dismiss();
                }
            } else
            {
                mProfileImage.setTag(s);
            }
_L8:
            mTwitterUser = twitteruser;
_L6:
            return;
_L4:
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if (mProgress == null) goto _L6; else goto _L5
_L5:
            mProgress.dismiss();
            return;
            if (true) goto _L8; else goto _L7
_L7:
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            hashmap = (UrlImage)hashmap.get((ImageKey)mProfileImage.getTag());
            if (hashmap != null && hashmap.isValid())
            {
                setAvatar(((UrlImage) (hashmap)).bitmap);
                mImagePicker.saveProfileImage(((UrlImage) (hashmap)).bitmap);
                if (mProgress != null)
                {
                    mProgress.dismiss();
                }
            }
        }

        SignUpListener()
        {
            this$0 = SignUpNameAvatarFragment.this;
            super();
        }
    }


    public static final String ARG_LOGIN = "user";
    private static final int DIALOG_REMOVE_TAKE_OR_CHOOSE_PHOTO = 3;
    private static final int DIALOG_SET_PHOTO_OR_SKIP = 1;
    private static final int DIALOG_TAKE_OR_CHOOSE_PHOTO = 2;
    public static final int REQUEST_CODE_CHOOSE_PHOTO = 3;
    public static final int REQUEST_CODE_CROP = 2;
    public static final int REQUEST_CODE_TAKE_PHOTO = 1;
    private static final int SPAN_PRIVACY_POLICY = 1;
    private static final int SPAN_TOS = 2;
    private static final String STATE_PROFILE_URI = "state_pi";
    private boolean mHasPromptedForPhoto;
    private ImagePicker mImagePicker;
    private VineLogin mLogin;
    private EditText mName;
    private MenuItem mNextButton;
    private EditText mPhoneNumber;
    private RelativeLayout mPhoneNumberContainer;
    private boolean mPhotoAttached;
    private ImageView mProfileImage;
    private ImageView mProfileImageAction;
    private Uri mProfileUri;
    private Dialog mProgress;
    private TwitterUser mTwitterUser;
    private int mVineGreen;

    public SignUpNameAvatarFragment()
    {
    }

    private void addPhoto()
    {
        if (mPhotoAttached)
        {
            PromptDialogSupportFragment promptdialogsupportfragment = PromptDialogSupportFragment.newInstance(3);
            promptdialogsupportfragment.setTargetFragment(this, 0);
            promptdialogsupportfragment.setTitle(0x7f0e021e).setPositiveButton(0x7f0e01a4).setNeutralButton(0x7f0e0242).setNegativeButton(0x7f0e005b).show(getActivity().getSupportFragmentManager());
            return;
        }
        PromptDialogSupportFragment promptdialogsupportfragment1 = PromptDialogSupportFragment.newInstance(2);
        promptdialogsupportfragment1.setTargetFragment(this, 0);
        try
        {
            promptdialogsupportfragment1.setTitle(0x7f0e021e).setPositiveButton(0x7f0e0242).setNeutralButton(0x7f0e005b).show(getActivity().getSupportFragmentManager());
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            CrashUtil.logException(illegalstateexception);
        }
    }

    private void nextClicked()
    {
        SignUpPagerActivity signuppageractivity = (SignUpPagerActivity)getActivity();
        signuppageractivity.setName(mName.getText().toString());
        signuppageractivity.setPhone(mPhoneNumber.getText().toString());
        if (mPhotoAttached)
        {
            signuppageractivity.setProfile(mProfileUri);
        }
        if (mTwitterUser != null)
        {
            mTwitterUser.name = mName.getText().toString();
            signuppageractivity.setTwitterUser(mTwitterUser);
        }
        signuppageractivity.toNextStep();
    }

    private boolean onEditorActionClicked(int i, View view)
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null && i == 6 && validate())
        {
            ((InputMethodManager)fragmentactivity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            onNextClicked(fragmentactivity);
        }
        return true;
    }

    private boolean onNextClicked(Activity activity)
    {
        if (!showProfilePhotoPrompt())
        {
            activity = (SignUpPagerActivity)activity;
            activity.setName(mName.getText().toString());
            activity.setPhone(mPhoneNumber.getText().toString());
            activity.setProfile(mImagePicker.getSavedImageUri());
            if (mTwitterUser != null)
            {
                mTwitterUser.name = mName.getText().toString();
                activity.setTwitterUser(mTwitterUser);
            }
            nextClicked();
        }
        Util.setSoftKeyboardVisibility(getActivity(), mName, false);
        return true;
    }

    private void setAvatar(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            mProfileImage.setImageDrawable(new RecyclableBitmapDrawable(mProfileImage.getResources(), bitmap));
            mProfileImage.setColorFilter(null);
            mProfileImageAction.setImageResource(0x7f020064);
            mPhotoAttached = true;
            return;
        } else
        {
            mProfileImage.setImageResource(0x7f020065);
            mProfileImage.setColorFilter(mVineGreen, android.graphics.PorterDuff.Mode.SRC_IN);
            mProfileImageAction.setImageResource(0x7f020061);
            mPhotoAttached = false;
            return;
        }
    }

    private boolean showProfilePhotoPrompt()
    {
        if (mProfileUri == null && !mHasPromptedForPhoto && !mPhotoAttached)
        {
            PromptDialogSupportFragment promptdialogsupportfragment = PromptDialogSupportFragment.newInstance(1).setMessage(0x7f0e019b).setPositiveButton(0x7f0e01c4).setNegativeButton(0x7f0e0227);
            promptdialogsupportfragment.setListener(this);
            try
            {
                promptdialogsupportfragment.show(getActivity().getSupportFragmentManager());
            }
            catch (IllegalStateException illegalstateexception)
            {
                return false;
            }
            mHasPromptedForPhoto = true;
            return true;
        } else
        {
            return false;
        }
    }

    private boolean validate()
    {
        return mName != null && mName.length() >= 3;
    }

    public void afterTextChanged(Editable editable)
    {
        if (mNextButton != null)
        {
            mNextButton.setEnabled(validate());
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mVineGreen = getActivity().getResources().getColor(0x7f090096) | 0xff000000;
        setAvatar(null);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 98
    //                   3 37;
           goto _L1 _L2 _L3 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            if (i == 1)
            {
                intent = mProfileUri;
            } else
            {
                intent = intent.getData();
            }
            intent = (new Intent(getActivity(), co/vine/android/EditProfileCropActivity)).putExtra("uri", intent);
            getActivity().startActivityForResult(intent, 2);
            return;
        } else
        {
            mProfileUri = null;
            return;
        }
_L3:
        if (j == -1 && intent != null)
        {
            intent = (Uri)intent.getParcelableExtra("uri");
            if (intent != null)
            {
                ImageUtils.deleteTempPic(mProfileUri);
                mProfileUri = intent;
                (new SetThumbnailTask(this)).execute(new Uri[] {
                    intent
                });
                return;
            }
        } else
        {
            mProfileUri = null;
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362051: 
            addPhoto();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppController = AppController.getInstance(getActivity());
        if (bundle != null && bundle.containsKey("state_pi"))
        {
            mProfileUri = (Uri)bundle.getParcelable("state_pi");
            if (mProfileUri != null)
            {
                (new SetThumbnailTask(this)).execute(new Uri[] {
                    mProfileUri
                });
            }
        }
        setHasOptionsMenu(true);
        ((SignUpPagerActivity)getActivity()).setBarTitle(0x7f0e0124);
        bundle = getArguments();
        if (bundle != null && bundle.containsKey("user"))
        {
            mLogin = (VineLogin)bundle.getParcelable("user");
        }
        mAppSessionListener = new SignUpListener();
        mHasPromptedForPhoto = false;
        mImagePicker = new ImagePicker(getActivity(), this, mAppController.getActiveId());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f10000b, menu);
        mNextButton = menu.findItem(0x7f0a0246);
        if (mNextButton != null)
        {
            mNextButton.setEnabled(validate());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030095, viewgroup, false);
        bundle = (TextView)layoutinflater.findViewById(0x7f0a021e);
        viewgroup = new StyleSpan(1);
        Object obj = new StyleSpan(1);
        String s = getString(0x7f0e0220);
        viewgroup = Util.getSpannedText(new StyleSpan[] {
            viewgroup, obj
        }, s, '"');
        bundle.setText(viewgroup);
        bundle.setMovementMethod(LinkMovementMethod.getInstance());
        bundle = (Spannable)bundle.getText();
        StyleSpan astylespan[] = (StyleSpan[])viewgroup.getSpans(0, viewgroup.length(), android/text/style/StyleSpan);
        obj = getResources();
        int i = viewgroup.getSpanStart(astylespan[0]);
        int j = viewgroup.getSpanEnd(astylespan[0]);
        StyledClickableSpan styledclickablespan = new StyledClickableSpan(1, null, this);
        styledclickablespan.setColor(((Resources) (obj)).getColor(0x7f09008d));
        Util.safeSetSpan(bundle, styledclickablespan, i, j, 33);
        i = viewgroup.getSpanStart(astylespan[1]);
        j = viewgroup.getSpanEnd(astylespan[1]);
        viewgroup = new StyledClickableSpan(2, null, this);
        viewgroup.setColor(((Resources) (obj)).getColor(0x7f09008d));
        Util.safeSetSpan(bundle, viewgroup, i, j, 33);
        return layoutinflater;
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

            case -2: 
                nextClicked();
                return;

            case -1: 
                addPhoto();
                break;
            }
            return;

        case 2: // '\002'
            switch (j)
            {
            case -2: 
            default:
                return;

            case -3: 
                mImagePicker.chooseImage(3);
                return;

            case -1: 
                mImagePicker.captureImage(1);
                break;
            }
            return;

        case 3: // '\003'
            switch (j)
            {
            default:
                return;

            case -3: 
                mImagePicker.captureImage(1);
                return;

            case -1: 
                setThumbnailImage(null);
                return;

            case -2: 
                mImagePicker.chooseImage(3);
                return;
            }
        }
    }

    public void onEmailLoaded(String s)
    {
    }

    public void onNameLoaded(String s)
    {
        EditText edittext = mName;
        if (TextUtils.isEmpty(edittext.getText()) && !TextUtils.isEmpty(s))
        {
            edittext.setText(s);
            edittext.setSelection(s.length());
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362374: 
            return onNextClicked(getActivity());
        }
    }

    public void onPhoneNumberLoaded(String s)
    {
        if (mPhoneNumber.getVisibility() == 0 && TextUtils.isEmpty(mPhoneNumber.getText()) && !TextUtils.isEmpty(s))
        {
            mPhoneNumber.setText(s);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("state_pi", mProfileUri);
    }

    public void onSpanClicked(View view, int i, Object obj)
    {
        if (getActivity() == null)
        {
            return;
        }
        view = new Intent(getActivity(), co/vine/android/WebViewActivity);
        i;
        JVM INSTR tableswitch 1 2: default 48
    //                   1 49
    //                   2 64;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        view.putExtra("type", 1);
_L5:
        startActivity(view);
        return;
_L3:
        view.putExtra("type", 2);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mName = (EditText)view.findViewById(0x7f0a021f);
        mName.addTextChangedListener(this);
        mName.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SignUpNameAvatarFragment this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                return onEditorActionClicked(i, mName);
            }

            
            {
                this$0 = SignUpNameAvatarFragment.this;
                super();
            }
        });
        mPhoneNumberContainer = (RelativeLayout)view.findViewById(0x7f0a0219);
        mPhoneNumber = (EditText)view.findViewById(0x7f0a021a);
        mPhoneNumber.addTextChangedListener(this);
        mPhoneNumber.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SignUpNameAvatarFragment this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                return onEditorActionClicked(i, mPhoneNumber);
            }

            
            {
                this$0 = SignUpNameAvatarFragment.this;
                super();
            }
        });
        view = view.findViewById(0x7f0a0103);
        mProfileImageAction = (ImageView)view.findViewById(0x7f0a022b);
        mProfileImageAction.setVisibility(0);
        view.setOnClickListener(this);
        mProfileImage = (ImageView)view.findViewById(0x7f0a0063);
        if (mLogin != null)
        {
            view = new ProgressDialog(getActivity(), 0x7f0f0037);
            view.setMessage(getString(0x7f0e011c));
            view.setProgress(0);
            view.show();
            mProgress = view;
            mAppController.fetchTwitterUser(mLogin);
        }
        ContactsHelper.loadContacts(this, this);
    }

    public void setAvatarUrl(Uri uri)
    {
        mProfileUri = uri;
    }

    public void setThumbnailImage(Bitmap bitmap)
    {
        setAvatar(bitmap);
        if (mPhotoAttached)
        {
            mHasPromptedForPhoto = true;
        }
    }




/*
    static TwitterUser access$1002(SignUpNameAvatarFragment signupnameavatarfragment, TwitterUser twitteruser)
    {
        signupnameavatarfragment.mTwitterUser = twitteruser;
        return twitteruser;
    }

*/




/*
    static Uri access$402(SignUpNameAvatarFragment signupnameavatarfragment, Uri uri)
    {
        signupnameavatarfragment.mProfileUri = uri;
        return uri;
    }

*/





}
