// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import ab;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import cg;
import co;
import cp;
import cq;
import cr;
import cs;
import u;
import w;
import y;
import z;

public class ActivityChooserView extends ViewGroup
{

    private final LinearLayoutCompat mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    private final cr mAdapter;
    private final cs mCallbacks;
    private int mDefaultActionButtonContentDescription;
    private final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    private final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    private int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    private boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    private final DataSetObserver mModelDataSetOberver;
    private android.widget.PopupWindow.OnDismissListener mOnDismissListener;
    private final android.view.ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    public ActionProvider mProvider;

    public ActivityChooserView(Context context)
    {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mModelDataSetOberver = new co(this);
        mOnGlobalLayoutListener = new cp(this);
        mInitialActivityCount = 4;
        attributeset = context.obtainStyledAttributes(attributeset, ab.ActivityChooserView, i, 0);
        mInitialActivityCount = attributeset.getInt(ab.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = attributeset.getDrawable(ab.ActivityChooserView_expandActivityOverflowButtonDrawable);
        attributeset.recycle();
        LayoutInflater.from(getContext()).inflate(y.abc_activity_chooser_view, this, true);
        mCallbacks = new cs(this, null);
        mActivityChooserContent = (LinearLayoutCompat)findViewById(w.activity_chooser_view_content);
        mActivityChooserContentBackground = mActivityChooserContent.getBackground();
        mDefaultActivityButton = (FrameLayout)findViewById(w.default_activity_button);
        mDefaultActivityButton.setOnClickListener(mCallbacks);
        mDefaultActivityButton.setOnLongClickListener(mCallbacks);
        mDefaultActivityButtonImage = (ImageView)mDefaultActivityButton.findViewById(w.image);
        mExpandActivityOverflowButton = (FrameLayout)findViewById(w.expand_activities_button);
        mExpandActivityOverflowButton.setOnClickListener(mCallbacks);
        mExpandActivityOverflowButtonImage = (ImageView)mExpandActivityOverflowButton.findViewById(w.image);
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
        mAdapter = new cr(this, null);
        mAdapter.registerDataSetObserver(new cq(this));
        context = context.getResources();
        mListPopupMaxWidth = Math.max(context.getDisplayMetrics().widthPixels / 2, context.getDimensionPixelSize(u.abc_config_prefDialogWidth));
    }

    private ListPopupWindow getListPopupWindow()
    {
        if (mListPopupWindow == null)
        {
            mListPopupWindow = new ListPopupWindow(getContext());
            mListPopupWindow.a(mAdapter);
            mListPopupWindow.a(this);
            mListPopupWindow.a(true);
            mListPopupWindow.a(mCallbacks);
            mListPopupWindow.a(mCallbacks);
        }
        return mListPopupWindow;
    }

    private void showPopupUnchecked(int i)
    {
        if (mAdapter.e() == null)
        {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);
        ListPopupWindow listpopupwindow;
        int j;
        int k;
        boolean flag;
        if (mDefaultActivityButton.getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = mAdapter.c();
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (i != 0x7fffffff && k > j + i)
        {
            mAdapter.a(true);
            mAdapter.a(i - 1);
        } else
        {
            mAdapter.a(false);
            mAdapter.a(i);
        }
        listpopupwindow = getListPopupWindow();
        if (!listpopupwindow.b())
        {
            if (mIsSelectingDefaultActivity || !flag)
            {
                mAdapter.a(true, flag);
            } else
            {
                mAdapter.a(false, false);
            }
            listpopupwindow.d(Math.min(mAdapter.a(), mListPopupMaxWidth));
            listpopupwindow.c();
            if (mProvider != null)
            {
                mProvider.subUiVisibilityChanged(true);
            }
            listpopupwindow.g().setContentDescription(getContext().getString(z.abc_activitychooserview_choose_application));
        }
    }

    private void updateAppearance()
    {
        int i;
        int j;
        if (mAdapter.getCount() > 0)
        {
            mExpandActivityOverflowButton.setEnabled(true);
        } else
        {
            mExpandActivityOverflowButton.setEnabled(false);
        }
        i = mAdapter.c();
        j = mAdapter.d();
        if (i == 1 || i > 1 && j > 0)
        {
            mDefaultActivityButton.setVisibility(0);
            Object obj = mAdapter.b();
            android.content.pm.PackageManager packagemanager = getContext().getPackageManager();
            mDefaultActivityButtonImage.setImageDrawable(((ResolveInfo) (obj)).loadIcon(packagemanager));
            if (mDefaultActionButtonContentDescription != 0)
            {
                obj = ((ResolveInfo) (obj)).loadLabel(packagemanager);
                obj = getContext().getString(mDefaultActionButtonContentDescription, new Object[] {
                    obj
                });
                mDefaultActivityButton.setContentDescription(((CharSequence) (obj)));
            }
        } else
        {
            mDefaultActivityButton.setVisibility(8);
        }
        if (mDefaultActivityButton.getVisibility() == 0)
        {
            mActivityChooserContent.setBackgroundDrawable(mActivityChooserContentBackground);
            return;
        } else
        {
            mActivityChooserContent.setBackgroundDrawable(null);
            return;
        }
    }

    public boolean dismissPopup()
    {
        if (isShowingPopup())
        {
            getListPopupWindow().a();
            ViewTreeObserver viewtreeobserver = getViewTreeObserver();
            if (viewtreeobserver.isAlive())
            {
                viewtreeobserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
            }
        }
        return true;
    }

    public cg getDataModel()
    {
        return mAdapter.e();
    }

    public boolean isShowingPopup()
    {
        return getListPopupWindow().b();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        cg cg1 = mAdapter.e();
        if (cg1 != null)
        {
            cg1.registerObserver(mModelDataSetOberver);
        }
        mIsAttachedToWindow = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        Object obj = mAdapter.e();
        if (obj != null)
        {
            ((cg) (obj)).unregisterObserver(mModelDataSetOberver);
        }
        obj = getViewTreeObserver();
        if (((ViewTreeObserver) (obj)).isAlive())
        {
            ((ViewTreeObserver) (obj)).removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
        }
        if (isShowingPopup())
        {
            dismissPopup();
        }
        mIsAttachedToWindow = false;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        mActivityChooserContent.layout(0, 0, k - i, l - j);
        if (!isShowingPopup())
        {
            dismissPopup();
        }
    }

    protected void onMeasure(int i, int j)
    {
        LinearLayoutCompat linearlayoutcompat = mActivityChooserContent;
        int k = j;
        if (mDefaultActivityButton.getVisibility() != 0)
        {
            k = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(j), 0x40000000);
        }
        measureChild(linearlayoutcompat, i, k);
        setMeasuredDimension(linearlayoutcompat.getMeasuredWidth(), linearlayoutcompat.getMeasuredHeight());
    }

    public void setActivityChooserModel(cg cg1)
    {
        mAdapter.a(cg1);
        if (isShowingPopup())
        {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i)
    {
        mDefaultActionButtonContentDescription = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i)
    {
        String s = getContext().getString(i);
        mExpandActivityOverflowButtonImage.setContentDescription(s);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable)
    {
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i)
    {
        mInitialActivityCount = i;
    }

    public void setOnDismissListener(android.widget.PopupWindow.OnDismissListener ondismisslistener)
    {
        mOnDismissListener = ondismisslistener;
    }

    public void setProvider(ActionProvider actionprovider)
    {
        mProvider = actionprovider;
    }

    public boolean showPopup()
    {
        if (isShowingPopup() || !mIsAttachedToWindow)
        {
            return false;
        } else
        {
            mIsSelectingDefaultActivity = false;
            showPopupUnchecked(mInitialActivityCount);
            return true;
        }
    }









/*
    public static boolean access$602(ActivityChooserView activitychooserview, boolean flag)
    {
        activitychooserview.mIsSelectingDefaultActivity = flag;
        return flag;
    }

*/



}
