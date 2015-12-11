// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatState, BoldChatSession, BoldChatFormView

public class BoldChatViewManager
{

    private int mAnimationDuration;
    private Map mBrandings;
    private ViewGroup mBusyView;
    private Button mCloseButton;
    private Context mContext;
    private BoldChatState mCurrentState;
    private HashMap mDesiredVisibility;
    private View mEmailTranscriptButton;
    private Button mEndButton;
    private MenuItem mEndChatMenuItem;
    private View mEndSeparator;
    private ViewGroup mFormView;
    Handler mMainHandler;
    private ViewGroup mMainView;
    private View mSendButton;
    private EditText mTextInput;
    private TextView mTypingView;

    protected BoldChatViewManager(Context context, ViewGroup viewgroup, ViewGroup viewgroup1, ViewGroup viewgroup2, String s)
    {
        mCurrentState = BoldChatState.Idle;
        mDesiredVisibility = new HashMap();
        mContext = context;
        mMainHandler = new Handler(context.getMainLooper());
        mBusyView = viewgroup;
        mFormView = viewgroup1;
        mMainView = viewgroup2;
        mTextInput = (EditText)viewgroup2.findViewById(R.id.bc_edit_text);
        mSendButton = viewgroup2.findViewById(R.id.bc_send_button);
        mEndButton = (Button)viewgroup2.findViewById(R.id.bc_end_chat);
        mEndSeparator = viewgroup2.findViewById(R.id.bc_end_chat_separator);
        mEmailTranscriptButton = viewgroup2.findViewById(R.id.bc_email_transcript);
        mCloseButton = (Button)viewgroup2.findViewById(R.id.bc_close_button);
        mTypingView = (TextView)viewgroup2.findViewById(R.id.bc_typing_indicator);
        if (mTypingView != null)
        {
            mTypingView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (mTextInput != null && s != null)
        {
            mTextInput.setText(s);
        }
        mAnimationDuration = mContext.getResources().getInteger(R.integer.bc_animation_duration);
    }

    private void animateGone(final View view)
    {
label0:
        {
            Integer integer = (Integer)mDesiredVisibility.get(view);
            if (view != null && (integer == null || integer.intValue() == 0))
            {
                mDesiredVisibility.put(view, Integer.valueOf(8));
                if (mAnimationDuration <= 0 || android.os.Build.VERSION.SDK_INT < 14)
                {
                    break label0;
                }
                view.animate().translationX(-((View)view.getParent()).getMeasuredWidth()).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {

                    final BoldChatViewManager this$0;
                    final View val$view;

                    public void onAnimationEnd(Animator animator)
                    {
                        view.setVisibility(((Integer)mDesiredVisibility.get(view)).intValue());
                        if (view == mFormView && ((Integer)mDesiredVisibility.get(view)).intValue() == 8)
                        {
                            mFormView.removeAllViews();
                        }
                    }

            
            {
                this$0 = BoldChatViewManager.this;
                view = view1;
                super();
            }
                });
            }
            return;
        }
        view.setVisibility(((Integer)mDesiredVisibility.get(view)).intValue());
    }

    private void animateVisible(final View view)
    {
label0:
        {
            Integer integer = (Integer)mDesiredVisibility.get(view);
            if (view != null && (integer == null || integer.intValue() == 8))
            {
                mDesiredVisibility.put(view, Integer.valueOf(0));
                if (mAnimationDuration <= 0 || android.os.Build.VERSION.SDK_INT < 14)
                {
                    break label0;
                }
                view.setVisibility(((Integer)mDesiredVisibility.get(view)).intValue());
                view.setTranslationX(((View)view.getParent()).getMeasuredWidth());
                view.animate().translationX(0.0F).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {

                    final BoldChatViewManager this$0;
                    final View val$view;

                    public void onAnimationEnd(Animator animator)
                    {
                        view.setVisibility(((Integer)mDesiredVisibility.get(view)).intValue());
                        view.setAlpha(1.0F);
                    }

            
            {
                this$0 = BoldChatViewManager.this;
                view = view1;
                super();
            }
                });
            }
            return;
        }
        view.setVisibility(((Integer)mDesiredVisibility.get(view)).intValue());
    }

    private void setStateMain(BoldChatState boldchatstate, BoldChatFormView boldchatformview)
    {
        boolean flag = false;
        if (boldchatformview != null)
        {
            mFormView.removeAllViews();
            mFormView.addView(boldchatformview);
        }
        static class _cls5
        {

            static final int $SwitchMap$com$boldchat$sdk$BoldChatState[];

            static 
            {
                $SwitchMap$com$boldchat$sdk$BoldChatState = new int[BoldChatState.values().length];
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.Idle.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.InitialLoading.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.UnavailableChat.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.UnavailableChatSending.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.PreChat.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.PreChatSending.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.ChatActive.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.ChatInactive.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.ChatEnding.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.PostChat.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.PostChatSending.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.Finished.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.Error.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5..SwitchMap.com.boldchat.sdk.BoldChatState[boldchatstate.ordinal()])
        {
        case 1: // '\001'
        default:
            return;

        case 2: // '\002'
            showBusy();
            showChatMenu(false);
            return;

        case 3: // '\003'
            showFormView();
            showChatMenu(false);
            return;

        case 4: // '\004'
            showBusy();
            showChatMenu(false);
            return;

        case 5: // '\005'
            showFormView();
            showChatMenu(false);
            return;

        case 6: // '\006'
            showBusy();
            showChatMenu(false);
            return;

        case 7: // '\007'
            if (mTextInput != null)
            {
                mTextInput.setVisibility(0);
                mTextInput.setEnabled(true);
            }
            if (mSendButton != null)
            {
                mSendButton.setVisibility(0);
                mSendButton.setEnabled(true);
            }
            if (mEndButton != null)
            {
                boldchatstate = mEndButton;
                int i;
                if (mEndChatMenuItem == null)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                boldchatstate.setVisibility(i);
                mEndButton.setEnabled(true);
                if (mEndSeparator != null)
                {
                    boldchatstate = mEndSeparator;
                    if (mEndChatMenuItem == null)
                    {
                        i = ((flag) ? 1 : 0);
                    } else
                    {
                        i = 8;
                    }
                    boldchatstate.setVisibility(i);
                }
            }
            showChatMenu(true);
            if (mTypingView != null)
            {
                mTypingView.setVisibility(4);
                mTypingView.setEnabled(true);
            }
            if (mCloseButton != null)
            {
                mCloseButton.setVisibility(8);
            }
            animateGone(mBusyView);
            animateGone(mFormView);
            animateVisible(mMainView);
            return;

        case 8: // '\b'
            if (mCloseButton != null)
            {
                if (mSendButton != null)
                {
                    mSendButton.setVisibility(8);
                }
                if (mEndButton != null)
                {
                    mEndButton.setVisibility(8);
                }
                if (mEndSeparator != null)
                {
                    mEndSeparator.setVisibility(8);
                }
                if (mEmailTranscriptButton != null)
                {
                    mEmailTranscriptButton.setVisibility(8);
                }
                if (mTextInput != null)
                {
                    mTextInput.setVisibility(8);
                }
                mCloseButton.setText(BoldChatSession.getBranding("api#chat#close", mBrandings, mContext));
                mCloseButton.setVisibility(0);
            } else
            {
                if (mEndButton != null)
                {
                    mEndButton.setVisibility(0);
                    mEndButton.setEnabled(true);
                }
                mTextInput.setEnabled(false);
                mSendButton.setEnabled(false);
                mTypingView.setEnabled(false);
                mEmailTranscriptButton.setEnabled(false);
            }
            animateGone(mBusyView);
            animateGone(mFormView);
            animateVisible(mMainView);
            return;

        case 9: // '\t'
            showBusy();
            showChatMenu(false);
            return;

        case 10: // '\n'
            showFormView();
            showChatMenu(false);
            return;

        case 11: // '\013'
            showBusy();
            showChatMenu(false);
            return;

        case 12: // '\f'
            showFormView();
            showChatMenu(false);
            return;
        }
    }

    private void showBusy()
    {
        if (mBusyView != null)
        {
            animateGone(mFormView);
            animateGone(mMainView);
            animateVisible(mBusyView);
        }
    }

    private void showFormView()
    {
        animateGone(mBusyView);
        animateGone(mMainView);
        animateVisible(mFormView);
    }

    public void addMenuItems(MenuInflater menuinflater, Menu menu)
    {
        menuinflater.inflate(R.menu.bc_chat, menu);
        mEndChatMenuItem = menu.findItem(R.id.bc_end_chat);
        boolean flag;
        if (mCurrentState == BoldChatState.ChatActive)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showChatMenu(flag);
        if (mEndButton != null)
        {
            mEndButton.setVisibility(8);
        }
    }

    public Button getEndButton()
    {
        return mEndButton;
    }

    public MenuItem getEndChatMenuItem()
    {
        return mEndChatMenuItem;
    }

    public EditText getMessageInputField()
    {
        return mTextInput;
    }

    public TextView getTypingTextView()
    {
        return mTypingView;
    }

    protected void setBrandings(final Map brandings)
    {
        mBrandings = brandings;
        mMainHandler.post(new Runnable() {

            final BoldChatViewManager this$0;
            final Map val$brandings;

            public void run()
            {
                if (brandings != null && mEndChatMenuItem != null)
                {
                    mEndChatMenuItem.setTitle(BoldChatSession.getBranding("api#chat#end", brandings, mContext));
                }
            }

            
            {
                this$0 = BoldChatViewManager.this;
                brandings = map;
                super();
            }
        });
    }

    public void setMainViewClickListener(int i, android.view.View.OnClickListener onclicklistener)
    {
        View view = mMainView.findViewById(i);
        if (view != null)
        {
            view.setOnClickListener(onclicklistener);
        }
    }

    public void setState(BoldChatState boldchatstate)
    {
        setState(boldchatstate, null);
    }

    public void setState(final BoldChatState newState, final BoldChatFormView form)
    {
        mMainHandler.post(new Runnable() {

            final BoldChatViewManager this$0;
            final BoldChatFormView val$form;
            final BoldChatState val$newState;

            public void run()
            {
                setStateMain(newState, form);
            }

            
            {
                this$0 = BoldChatViewManager.this;
                newState = boldchatstate;
                form = boldchatformview;
                super();
            }
        });
        mCurrentState = newState;
        BoldChatSession.setCurrentState(newState);
    }

    protected void showChatMenu(boolean flag)
    {
        if (mEndChatMenuItem != null)
        {
            mEndChatMenuItem.setVisible(flag);
        }
    }





}
