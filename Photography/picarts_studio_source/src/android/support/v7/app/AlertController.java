// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.internal.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

// Referenced classes of package android.support.v7.app:
//            AppCompatDialog

class AlertController
{

    private ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final android.view.View.OnClickListener mButtonHandler = new android.view.View.OnClickListener() {

        final AlertController this$0;

        public void onClick(View view)
        {
            if (view == mButtonPositive && mButtonPositiveMessage != null)
            {
                view = Message.obtain(mButtonPositiveMessage);
            } else
            if (view == mButtonNegative && mButtonNegativeMessage != null)
            {
                view = Message.obtain(mButtonNegativeMessage);
            } else
            if (view == mButtonNeutral && mButtonNeutralMessage != null)
            {
                view = Message.obtain(mButtonNeutralMessage);
            } else
            {
                view = null;
            }
            if (view != null)
            {
                view.sendToTarget();
            }
            mHandler.obtainMessage(1, mDialog).sendToTarget();
        }

            
            {
                this$0 = AlertController.this;
                super();
            }
    };
    private Button mButtonNegative;
    private Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    private Button mButtonNeutral;
    private Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint;
    private int mButtonPanelSideLayout;
    private Button mButtonPositive;
    private Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    private int mCheckedItem;
    private final Context mContext;
    private View mCustomTitleView;
    private final AppCompatDialog mDialog;
    private Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    private int mListItemLayout;
    private int mListLayout;
    private ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    private int mMultiChoiceItemLayout;
    private ScrollView mScrollView;
    private int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;

    public AlertController(Context context, AppCompatDialog appcompatdialog, Window window)
    {
        mViewSpacingSpecified = false;
        mIconId = 0;
        mCheckedItem = -1;
        mButtonPanelLayoutHint = 0;
        mContext = context;
        mDialog = appcompatdialog;
        mWindow = window;
        mHandler = new ButtonHandler(appcompatdialog);
        context = context.obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.AlertDialog, android.support.v7.appcompat.R.attr.alertDialogStyle, 0);
        mAlertDialogLayout = context.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_android_layout, 0);
        mButtonPanelSideLayout = context.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        mListLayout = context.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_listLayout, 0);
        mMultiChoiceItemLayout = context.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        mSingleChoiceItemLayout = context.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        mListItemLayout = context.getResourceId(android.support.v7.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        context.recycle();
    }

    static boolean canTextInput(View view)
    {
        if (view.onCheckIsTextEditor())
        {
            return true;
        }
        if (!(view instanceof ViewGroup))
        {
            return false;
        }
        view = (ViewGroup)view;
        for (int i = view.getChildCount(); i > 0;)
        {
            int j = i - 1;
            i = j;
            if (canTextInput(view.getChildAt(j)))
            {
                return true;
            }
        }

        return false;
    }

    private void centerButton(Button button)
    {
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)button.getLayoutParams();
        layoutparams.gravity = 1;
        layoutparams.weight = 0.5F;
        button.setLayoutParams(layoutparams);
    }

    private int selectContentView()
    {
        if (mButtonPanelSideLayout == 0)
        {
            return mAlertDialogLayout;
        }
        if (mButtonPanelLayoutHint == 1)
        {
            return mButtonPanelSideLayout;
        } else
        {
            return mAlertDialogLayout;
        }
    }

    private boolean setupButtons()
    {
        mButtonPositive = (Button)mWindow.findViewById(0x1020019);
        mButtonPositive.setOnClickListener(mButtonHandler);
        int i;
        if (TextUtils.isEmpty(mButtonPositiveText))
        {
            mButtonPositive.setVisibility(8);
            i = 0;
        } else
        {
            mButtonPositive.setText(mButtonPositiveText);
            mButtonPositive.setVisibility(0);
            i = 1;
        }
        mButtonNegative = (Button)mWindow.findViewById(0x102001a);
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
        mButtonNeutral = (Button)mWindow.findViewById(0x102001b);
        mButtonNeutral.setOnClickListener(mButtonHandler);
        if (TextUtils.isEmpty(mButtonNeutralText))
        {
            mButtonNeutral.setVisibility(8);
        } else
        {
            mButtonNeutral.setText(mButtonNeutralText);
            mButtonNeutral.setVisibility(0);
            i |= 4;
        }
        if (shouldCenterSingleButton(mContext))
        {
            if (i == 1)
            {
                centerButton(mButtonPositive);
            } else
            if (i == 2)
            {
                centerButton(mButtonNegative);
            } else
            if (i == 4)
            {
                centerButton(mButtonNeutral);
            }
        }
        return i != 0;
    }

    private void setupContent(ViewGroup viewgroup)
    {
        mScrollView = (ScrollView)mWindow.findViewById(android.support.v7.appcompat.R.id.scrollView);
        mScrollView.setFocusable(false);
        mMessageView = (TextView)mWindow.findViewById(0x102000b);
        if (mMessageView == null)
        {
            return;
        }
        if (mMessage != null)
        {
            mMessageView.setText(mMessage);
            return;
        }
        mMessageView.setVisibility(8);
        mScrollView.removeView(mMessageView);
        if (mListView != null)
        {
            viewgroup = (ViewGroup)mScrollView.getParent();
            int i = viewgroup.indexOfChild(mScrollView);
            viewgroup.removeViewAt(i);
            viewgroup.addView(mListView, i, new android.view.ViewGroup.LayoutParams(-1, -1));
            return;
        } else
        {
            viewgroup.setVisibility(8);
            return;
        }
    }

    private boolean setupTitle(ViewGroup viewgroup)
    {
        if (mCustomTitleView != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -2);
            viewgroup.addView(mCustomTitleView, 0, layoutparams);
            mWindow.findViewById(android.support.v7.appcompat.R.id.title_template).setVisibility(8);
            return true;
        }
        mIconView = (ImageView)mWindow.findViewById(0x1020006);
        boolean flag;
        if (!TextUtils.isEmpty(mTitle))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            mTitleView = (TextView)mWindow.findViewById(android.support.v7.appcompat.R.id.alertTitle);
            mTitleView.setText(mTitle);
            if (mIconId != 0)
            {
                mIconView.setImageResource(mIconId);
                return true;
            }
            if (mIcon != null)
            {
                mIconView.setImageDrawable(mIcon);
                return true;
            } else
            {
                mTitleView.setPadding(mIconView.getPaddingLeft(), mIconView.getPaddingTop(), mIconView.getPaddingRight(), mIconView.getPaddingBottom());
                mIconView.setVisibility(8);
                return true;
            }
        } else
        {
            mWindow.findViewById(android.support.v7.appcompat.R.id.title_template).setVisibility(8);
            mIconView.setVisibility(8);
            viewgroup.setVisibility(8);
            return false;
        }
    }

    private void setupView()
    {
        boolean flag = false;
        setupContent((ViewGroup)mWindow.findViewById(android.support.v7.appcompat.R.id.contentPanel));
        boolean flag1 = setupButtons();
        Object obj = (ViewGroup)mWindow.findViewById(android.support.v7.appcompat.R.id.topPanel);
        TintTypedArray tinttypedarray = TintTypedArray.obtainStyledAttributes(mContext, null, android.support.v7.appcompat.R.styleable.AlertDialog, android.support.v7.appcompat.R.attr.alertDialogStyle, 0);
        setupTitle(((ViewGroup) (obj)));
        obj = mWindow.findViewById(android.support.v7.appcompat.R.id.buttonPanel);
        if (!flag1)
        {
            ((View) (obj)).setVisibility(8);
            obj = mWindow.findViewById(android.support.v7.appcompat.R.id.textSpacerNoButtons);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(0);
            }
        }
        FrameLayout framelayout = (FrameLayout)mWindow.findViewById(android.support.v7.appcompat.R.id.customPanel);
        if (mView != null)
        {
            obj = mView;
        } else
        if (mViewLayoutResId != 0)
        {
            obj = LayoutInflater.from(mContext).inflate(mViewLayoutResId, framelayout, false);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            flag = true;
        }
        if (!flag || !canTextInput(((View) (obj))))
        {
            mWindow.setFlags(0x20000, 0x20000);
        }
        if (flag)
        {
            FrameLayout framelayout1 = (FrameLayout)mWindow.findViewById(android.support.v7.appcompat.R.id.custom);
            framelayout1.addView(((View) (obj)), new android.view.ViewGroup.LayoutParams(-1, -1));
            if (mViewSpacingSpecified)
            {
                framelayout1.setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight, mViewSpacingBottom);
            }
            if (mListView != null)
            {
                ((android.widget.LinearLayout.LayoutParams)framelayout.getLayoutParams()).weight = 0.0F;
            }
        } else
        {
            framelayout.setVisibility(8);
        }
        obj = mListView;
        if (obj != null && mAdapter != null)
        {
            ((ListView) (obj)).setAdapter(mAdapter);
            int i = mCheckedItem;
            if (i >= 0)
            {
                ((ListView) (obj)).setItemChecked(i, true);
                ((ListView) (obj)).setSelection(i);
            }
        }
        tinttypedarray.recycle();
    }

    private static boolean shouldCenterSingleButton(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.alertDialogCenterButtons, typedvalue, true);
        return typedvalue.data != 0;
    }

    public Button getButton(int i)
    {
        switch (i)
        {
        default:
            return null;

        case -1: 
            return mButtonPositive;

        case -2: 
            return mButtonNegative;

        case -3: 
            return mButtonNeutral;
        }
    }

    public int getIconAttributeResId(int i)
    {
        TypedValue typedvalue = new TypedValue();
        mContext.getTheme().resolveAttribute(i, typedvalue, true);
        return typedvalue.resourceId;
    }

    public ListView getListView()
    {
        return mListView;
    }

    public void installContent()
    {
        mDialog.supportRequestWindowFeature(1);
        int i = selectContentView();
        mDialog.setContentView(i);
        setupView();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return mScrollView != null && mScrollView.executeKeyEvent(keyevent);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        return mScrollView != null && mScrollView.executeKeyEvent(keyevent);
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
            throw new IllegalArgumentException("Button does not exist");

        case -1: 
            mButtonPositiveText = charsequence;
            mButtonPositiveMessage = message1;
            return;

        case -2: 
            mButtonNegativeText = charsequence;
            mButtonNegativeMessage = message1;
            return;

        case -3: 
            mButtonNeutralText = charsequence;
            mButtonNeutralMessage = message1;
            return;
        }
    }

    public void setButtonPanelLayoutHint(int i)
    {
        mButtonPanelLayoutHint = i;
    }

    public void setCustomTitle(View view)
    {
        mCustomTitleView = view;
    }

    public void setIcon(int i)
    {
label0:
        {
            mIcon = null;
            mIconId = i;
            if (mIconView != null)
            {
                if (i == 0)
                {
                    break label0;
                }
                mIconView.setImageResource(mIconId);
            }
            return;
        }
        mIconView.setVisibility(8);
    }

    public void setIcon(Drawable drawable)
    {
label0:
        {
            mIcon = drawable;
            mIconId = 0;
            if (mIconView != null)
            {
                if (drawable == null)
                {
                    break label0;
                }
                mIconView.setImageDrawable(drawable);
            }
            return;
        }
        mIconView.setVisibility(8);
    }

    public void setMessage(CharSequence charsequence)
    {
        mMessage = charsequence;
        if (mMessageView != null)
        {
            mMessageView.setText(charsequence);
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        if (mTitleView != null)
        {
            mTitleView.setText(charsequence);
        }
    }

    public void setView(int i)
    {
        mView = null;
        mViewLayoutResId = i;
        mViewSpacingSpecified = false;
    }

    public void setView(View view)
    {
        mView = view;
        mViewLayoutResId = 0;
        mViewSpacingSpecified = false;
    }

    public void setView(View view, int i, int j, int k, int l)
    {
        mView = view;
        mViewLayoutResId = 0;
        mViewSpacingSpecified = true;
        mViewSpacingLeft = i;
        mViewSpacingTop = j;
        mViewSpacingRight = k;
        mViewSpacingBottom = l;
    }






/*
    static ListAdapter access$1202(AlertController alertcontroller, ListAdapter listadapter)
    {
        alertcontroller.mAdapter = listadapter;
        return listadapter;
    }

*/


/*
    static int access$1302(AlertController alertcontroller, int i)
    {
        alertcontroller.mCheckedItem = i;
        return i;
    }

*/


/*
    static ListView access$1402(AlertController alertcontroller, ListView listview)
    {
        alertcontroller.mListView = listview;
        return listview;
    }

*/









    private class ButtonHandler extends Handler
    {

        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference mDialog;

        public final void handleMessage(Message message)
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

}
