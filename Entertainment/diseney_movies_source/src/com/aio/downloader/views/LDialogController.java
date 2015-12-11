// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.aio.downloader.views:
//            LButton, LImageButton

public class LDialogController
{
    private static final class ButtonHandler extends Handler
    {

        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference mDialog;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            case 0: // '\0'
            default:
                return;

            case -3: 
            case -2: 
            case -1: 
                ((android.content.DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)mDialog.get(), message.what);
                return;

            case 1: // '\001'
                ((DialogInterface)message.obj).dismiss();
                break;
            }
        }

        public ButtonHandler(DialogInterface dialoginterface)
        {
            mDialog = new WeakReference(dialoginterface);
        }
    }

    public static class DialogParams
    {

        public boolean centerMsg;
        public boolean clickPositiveBtnDismiss;
        public boolean mCancelable;
        public android.content.DialogInterface.OnClickListener mCloseListener;
        public final Context mContext;
        public Drawable mIcon;
        public int mIconId;
        public final LayoutInflater mInflater;
        public CharSequence mMessage;
        public android.content.DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public android.content.DialogInterface.OnCancelListener mOnCancelListener;
        public android.content.DialogInterface.OnClickListener mOnClickListener;
        public android.content.DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;
        public View mView;
        public boolean visibleCallback;

        public void apply(LDialogController ldialogcontroller)
        {
            ldialogcontroller.setClickPositiveBtnDismiss(clickPositiveBtnDismiss);
            ldialogcontroller.setCenterMsg(centerMsg);
            if (mTitle != null)
            {
                ldialogcontroller.setTitle(mTitle);
            }
            if (mIcon != null)
            {
                ldialogcontroller.setIcon(mIcon);
            }
            ldialogcontroller.setCloseButton(visibleCallback);
            if (mIconId >= 0)
            {
                ldialogcontroller.setIcon(mIconId);
            }
            if (mMessage != null)
            {
                ldialogcontroller.setMessage(mMessage);
            }
            if (mPositiveButtonText != null)
            {
                ldialogcontroller.setButton(-1, mPositiveButtonText, mPositiveButtonListener, null);
            }
            if (mNegativeButtonText != null)
            {
                ldialogcontroller.setButton(-2, mNegativeButtonText, mNegativeButtonListener, null);
            }
            if (mView != null)
            {
                ldialogcontroller.setView(mView);
            }
        }

        public DialogParams(Context context)
        {
            mIconId = 0;
            mContext = context;
            mCancelable = true;
            clickPositiveBtnDismiss = true;
            mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }


    public boolean centerMsg;
    public boolean clickPositiveBtnDismiss;
    android.view.View.OnClickListener mButtonHandler;
    private LButton mButtonNegative;
    private Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    private LButton mButtonPositive;
    private Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    public LImageButton mCloseImageView;
    private final DialogInterface mDialogInterface;
    private Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    private CharSequence mMessage;
    private TextView mMessageView;
    private ScrollView mScrollView;
    private boolean mShowCloseBtn;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private final Window mWindow;

    public LDialogController(Context context, DialogInterface dialoginterface, Window window)
    {
        mIconId = -1;
        mShowCloseBtn = false;
        mButtonHandler = new android.view.View.OnClickListener() {

            final LDialogController this$0;

            public void onClick(View view)
            {
                Object obj = null;
                Message message;
                if (view == mButtonPositive && mButtonPositiveMessage != null)
                {
                    message = Message.obtain(mButtonPositiveMessage);
                } else
                {
                    message = obj;
                    if (view == mButtonNegative)
                    {
                        message = obj;
                        if (mButtonNegativeMessage != null)
                        {
                            message = Message.obtain(mButtonNegativeMessage);
                        }
                    }
                }
                if (message != null)
                {
                    message.sendToTarget();
                }
                if (!clickPositiveBtnDismiss && view == mButtonPositive)
                {
                    return;
                } else
                {
                    mHandler.obtainMessage(1, mDialogInterface).sendToTarget();
                    return;
                }
            }

            
            {
                this$0 = LDialogController.this;
                super();
            }
        };
        mDialogInterface = dialoginterface;
        mWindow = window;
        mHandler = new ButtonHandler(dialoginterface);
    }

    private boolean setupButtons()
    {
        int i = 0;
        mButtonPositive = (LButton)mWindow.findViewById(0x7f0702c4);
        mButtonPositive.setOnClickListener(mButtonHandler);
        if (TextUtils.isEmpty(mButtonPositiveText))
        {
            mButtonPositive.setVisibility(8);
        } else
        {
            mButtonPositive.setText(mButtonPositiveText);
            mButtonPositive.setVisibility(0);
            i = false | true;
        }
        mButtonNegative = (LButton)mWindow.findViewById(0x7f0702c3);
        mButtonNegative.setOnClickListener(mButtonHandler);
        if (TextUtils.isEmpty(mButtonNegativeText))
        {
            mButtonNegative.setVisibility(8);
        } else
        {
            mButtonNegative.setText(mButtonNegativeText);
            mButtonNegative.setVisibility(0);
            i |= 2;
        }
        return i != 0;
    }

    private void setupContent()
    {
        mScrollView = (ScrollView)mWindow.findViewById(0x7f0702bf);
        mScrollView.setFocusable(false);
        mMessageView = (TextView)mWindow.findViewById(0x7f0702c0);
        if (mMessage != null)
        {
            if (centerMsg)
            {
                mMessageView.setGravity(17);
            }
            mMessageView.setText(mMessage);
            return;
        } else
        {
            mMessageView.setVisibility(8);
            mScrollView.setVisibility(8);
            return;
        }
    }

    private boolean setupTitle()
    {
        boolean flag = false;
        boolean flag1 = true;
        int i;
        if (TextUtils.isEmpty(mTitle))
        {
            i = 0;
        } else
        {
            i = 1;
        }
        mIconView = (ImageView)mWindow.findViewById(0x7f0702bc);
        mCloseImageView = (LImageButton)mWindow.findViewById(0x7f0701ea);
        mCloseImageView.setOnClickListener(new android.view.View.OnClickListener() {

            final LDialogController this$0;

            public void onClick(View view)
            {
                mDialogInterface.dismiss();
            }

            
            {
                this$0 = LDialogController.this;
                super();
            }
        });
        if (i != 0)
        {
            mTitleView = (TextView)mWindow.findViewById(0x7f0702bd);
            mTitleView.setText(mTitle);
            Object obj;
            if (mIconId > 0)
            {
                mIconView.setImageResource(mIconId);
            } else
            if (mIcon != null)
            {
                mIconView.setImageDrawable(mIcon);
            } else
            if (mIconId == 0)
            {
                mTitleView.setPadding(mIconView.getPaddingLeft(), mIconView.getPaddingTop(), mIconView.getPaddingRight(), mIconView.getPaddingBottom());
                mIconView.setVisibility(8);
            }
            obj = mCloseImageView;
            if (mShowCloseBtn)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            ((LImageButton) (obj)).setVisibility(i);
        } else
        {
            mWindow.findViewById(0x7f0702bb).setVisibility(8);
            mIconView.setVisibility(8);
            mWindow.findViewById(0x7f0702ba).setVisibility(8);
            flag1 = false;
        }
        obj = mWindow.findViewById(0x7f0702be);
        i = ((flag) ? 1 : 0);
        if (flag1)
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        return flag1;
    }

    private void setupView()
    {
        setupContent();
        boolean flag = setupButtons();
        Object obj = mWindow.findViewById(0x7f0702c2);
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        setupTitle();
        obj = (FrameLayout)mWindow.findViewById(0x7f0702c1);
        if (mView != null)
        {
            ((FrameLayout) (obj)).addView(mView, new android.view.ViewGroup.LayoutParams(-1, -1));
            return;
        } else
        {
            ((FrameLayout) (obj)).setVisibility(8);
            return;
        }
    }

    public DialogInterface getDialogInterface()
    {
        return mDialogInterface;
    }

    public int getMaxListLineNum()
    {
        return 6;
    }

    public void installContent()
    {
        mWindow.requestFeature(1);
        mWindow.setContentView(0x7f030071);
        setupView();
    }

    public void setButton(int i, CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener, Message message)
    {
        Message message1 = message;
        if (message == null)
        {
            message1 = message;
            if (onclicklistener != null)
            {
                message1 = mHandler.obtainMessage(i, onclicklistener);
            }
        }
        switch (i)
        {
        default:
            return;

        case -1: 
            mButtonPositiveText = charsequence;
            mButtonPositiveMessage = message1;
            return;

        case -2: 
            mButtonNegativeText = charsequence;
            mButtonNegativeMessage = message1;
            return;
        }
    }

    public void setCenterMsg(boolean flag)
    {
        centerMsg = flag;
    }

    public void setClickPositiveBtnDismiss(boolean flag)
    {
        clickPositiveBtnDismiss = flag;
    }

    public void setCloseButton(boolean flag)
    {
        mShowCloseBtn = flag;
    }

    public void setIcon(int i)
    {
        mIconId = i;
        if (mIconView != null)
        {
            if (i > 0)
            {
                mIconView.setImageResource(mIconId);
            } else
            if (i == 0)
            {
                mIconView.setVisibility(8);
                return;
            }
        }
    }

    public void setIcon(Drawable drawable)
    {
        mIcon = drawable;
        if (mIconView != null && mIcon != null)
        {
            mIconView.setImageDrawable(drawable);
        }
    }

    public void setMessage(CharSequence charsequence)
    {
        mMessage = charsequence;
        if (mMessageView != null)
        {
            mMessageView.setText(charsequence);
        }
    }

    public void setPositiveButtonEnable(boolean flag)
    {
        mButtonPositive.setEnabled(flag);
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        if (mTitleView != null)
        {
            mTitleView.setText(charsequence);
        }
    }

    public void setView(View view)
    {
        mView = view;
    }






}
