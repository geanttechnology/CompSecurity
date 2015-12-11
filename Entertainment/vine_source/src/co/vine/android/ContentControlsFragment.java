// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.views.SwitchInterface;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment

public class ContentControlsFragment extends BaseControllerFragment
    implements android.widget.CompoundButton.OnCheckedChangeListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{
    class ContentControlsListener extends AppSessionListener
    {

        final ContentControlsFragment this$0;

        public void onUpdateExplicitComplete(String s, int i, String s1, boolean flag)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            s = getActivity();
            if (i == 200)
            {
                s = Util.getDefaultSharedPrefs(getActivity()).edit();
                s.putBoolean("settings_explicit", flag);
                s.commit();
                return;
            }
            if (!TextUtils.isEmpty(s1))
            {
                Util.showCenteredToast(s, s1);
                return;
            } else
            {
                Util.showCenteredToast(s, 0x7f0e00a1);
                return;
            }
        }

        public void onUpdatePrivateComplete(String s, int i, String s1, boolean flag)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            s = getActivity();
            if (i == 200)
            {
                s = Util.getDefaultSharedPrefs(s).edit();
                s.putBoolean("settings_private", flag);
                s.commit();
                return;
            }
            if (!TextUtils.isEmpty(s1))
            {
                Util.showCenteredToast(s, s1);
                return;
            } else
            {
                Util.showCenteredToast(s, 0x7f0e00a1);
                return;
            }
        }

        ContentControlsListener()
        {
            this$0 = ContentControlsFragment.this;
            super();
        }
    }


    private static final int DIALOG_MAKE_EXPLICIT = 3;
    private static final int DIALOG_MAKE_UNEXPLICIT = 4;
    private static final int DIALOG_PROTECT_POSTS = 1;
    private static final int DIALOG_UNPROTECT_POSTS = 2;
    private static final String STATE_EXPLICIT = "state_explicit";
    private static final String STATE_PRIVATE = "state_private";
    private boolean mExplicit;
    private ImageView mExplicitIcon;
    private SwitchInterface mExplicitSwitch;
    private boolean mPrivate;
    private ImageView mPrivateIcon;
    private SwitchInterface mPrivateSwitch;
    private ProgressDialog mProgress;
    private View mView;

    public ContentControlsFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ViewUtil.reduceTextSizeViaFontScaleIfNeeded(getActivity(), 1.1F, 10F, new TextView[] {
            (TextView)mView.findViewById(0x7f0a008d), (TextView)mView.findViewById(0x7f0a0093)
        });
        ViewUtil.reduceTextSizeViaFontScaleIfNeeded(getActivity(), 1.1F, 5F, new TextView[] {
            (TextView)mView.findViewById(0x7f0a008f), (TextView)mView.findViewById(0x7f0a0095)
        });
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        switch (compoundbutton.getId())
        {
        default:
            return;

        case 2131361934: 
            if (flag)
            {
                mPrivateIcon.setImageResource(0x7f0201dc);
                compoundbutton = PromptDialogSupportFragment.newInstance(1);
                compoundbutton.setTitle(0x7f0e0098);
                compoundbutton.setMessage(0x7f0e0099);
                compoundbutton.setNegativeButton(0x7f0e0057);
                compoundbutton.setPositiveButton(0x7f0e0097);
                compoundbutton.setTargetFragment(this, 0);
                compoundbutton.show(getActivity().getSupportFragmentManager());
                return;
            } else
            {
                mPrivateIcon.setImageResource(0x7f0201db);
                compoundbutton = PromptDialogSupportFragment.newInstance(2);
                compoundbutton.setTitle(0x7f0e009f);
                compoundbutton.setMessage(0x7f0e00a0);
                compoundbutton.setNegativeButton(0x7f0e0057);
                compoundbutton.setPositiveButton(0x7f0e009e);
                compoundbutton.setTargetFragment(this, 0);
                compoundbutton.show(getActivity().getSupportFragmentManager());
                return;
            }

        case 2131361940: 
            break;
        }
        if (flag)
        {
            mExplicitIcon.setImageResource(0x7f0201da);
            compoundbutton = PromptDialogSupportFragment.newInstance(3);
            compoundbutton.setTitle(0x7f0e0093);
            compoundbutton.setMessage(0x7f0e0094);
            compoundbutton.setNegativeButton(0x7f0e0057);
            compoundbutton.setPositiveButton(0x7f0e0095);
            compoundbutton.setTargetFragment(this, 0);
            compoundbutton.show(getActivity().getSupportFragmentManager());
            return;
        } else
        {
            mExplicitIcon.setImageResource(0x7f0201d9);
            compoundbutton = PromptDialogSupportFragment.newInstance(4);
            compoundbutton.setTitle(0x7f0e009b);
            compoundbutton.setMessage(0x7f0e009c);
            compoundbutton.setNegativeButton(0x7f0e0057);
            compoundbutton.setPositiveButton(0x7f0e009d);
            compoundbutton.setTargetFragment(this, 0);
            compoundbutton.show(getFragmentManager());
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new ContentControlsListener();
        if (bundle != null)
        {
            mPrivate = bundle.getBoolean("state_private", false);
            mExplicit = bundle.getBoolean("state_explicit", false);
        } else
        {
            bundle = Util.getDefaultSharedPrefs(getActivity());
            mPrivate = bundle.getBoolean("settings_private", false);
            mExplicit = bundle.getBoolean("settings_explicit", false);
        }
        bundle = new ProgressDialog(getActivity(), 0x7f0f0037);
        bundle.setMessage(getString(0x7f0e00a2));
        bundle.setProgressStyle(0);
        mProgress = bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        mView = layoutinflater.inflate(0x7f030029, viewgroup, false);
        return mView;
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
                mPrivate = false;
                mPrivateIcon.setImageResource(0x7f0201db);
                mPrivateSwitch.setOnCheckedChangeListener(null);
                mPrivateSwitch.setChecked(false);
                mPrivateSwitch.setOnCheckedChangeListener(this);
                return;

            case -1: 
                mPrivate = true;
                break;
            }
            mProgress.show();
            mAppController.updatePrivate(mAppController.getActiveSession(), true);
            return;

        case 2: // '\002'
            switch (j)
            {
            default:
                mPrivate = false;
                mPrivateIcon.setImageResource(0x7f0201dc);
                mPrivateSwitch.setOnCheckedChangeListener(null);
                mPrivateSwitch.setChecked(true);
                mPrivateSwitch.setOnCheckedChangeListener(this);
                return;

            case -1: 
                mPrivate = false;
                break;
            }
            mProgress.show();
            mAppController.updatePrivate(mAppController.getActiveSession(), false);
            return;

        case 3: // '\003'
            switch (j)
            {
            default:
                mExplicit = false;
                mExplicitIcon.setImageResource(0x7f0201d9);
                mExplicitSwitch.setOnCheckedChangeListener(null);
                mExplicitSwitch.setChecked(false);
                mExplicitSwitch.setOnCheckedChangeListener(this);
                return;

            case -1: 
                mExplicit = true;
                break;
            }
            mProgress.show();
            mAppController.updateExplicit(mAppController.getActiveSession(), true);
            return;

        case 4: // '\004'
            switch (j)
            {
            default:
                mExplicit = true;
                mExplicitIcon.setImageResource(0x7f0201da);
                mExplicitSwitch.setOnCheckedChangeListener(null);
                mExplicitSwitch.setChecked(true);
                mExplicitSwitch.setOnCheckedChangeListener(this);
                return;

            case -1: 
                mExplicit = false;
                break;
            }
            break;
        }
        mProgress.show();
        mAppController.updateExplicit(mAppController.getActiveSession(), false);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("state_private", mPrivate);
        bundle.putBoolean("state_explicit", mExplicit);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        bundle = (SwitchInterface)view.findViewById(0x7f0a008e);
        SwitchInterface switchinterface = (SwitchInterface)view.findViewById(0x7f0a0094);
        mPrivateIcon = (ImageView)view.findViewById(0x7f0a008c);
        if (mPrivate)
        {
            mPrivateIcon.setImageResource(0x7f0201dc);
            bundle.setChecked(true);
        } else
        {
            mPrivateIcon.setImageResource(0x7f0201db);
        }
        if (BuildUtil.isExplore())
        {
            view.findViewById(0x7f0a0090).setVisibility(8);
            view.findViewById(0x7f0a0095).setVisibility(8);
        } else
        {
            mExplicitIcon = (ImageView)view.findViewById(0x7f0a0092);
            if (mExplicit)
            {
                mExplicitIcon.setImageResource(0x7f0201da);
                switchinterface.setChecked(true);
            } else
            {
                mExplicitIcon.setImageResource(0x7f0201d9);
            }
        }
        bundle.setOnCheckedChangeListener(this);
        switchinterface.setOnCheckedChangeListener(this);
        mPrivateSwitch = bundle;
        mExplicitSwitch = switchinterface;
    }

}
