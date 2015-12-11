// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackCrashData, ProductSpecificBinaryDataHolder, UiConfigurationOptions

public class UserFeedbackSpec
{

    private Bitmap mAlternateScreenshot;
    private String mBucket;
    private final String mCategoryTag;
    private final Context mContext;
    private UserFeedbackCrashData mCrashData;
    private final View mCurrentView;
    private final String mLogFilter;
    private String mLogs;
    private final Activity mParentActivity;
    private List mProductBinaryData;
    private boolean mRunningAppsEnabled;
    private boolean mScreenshotEnabled;
    private String mSelectedAccount;
    private boolean mShouldAutoScaleBitmap;
    private boolean mShouldShowPopupOnAnonymousSubmission;
    private boolean mShouldShowPopupOnEmptyDescription;
    private boolean mSystemLogEnabled;
    private UiConfigurationOptions mUiConfigurationOptions;

    public UserFeedbackSpec(Activity activity, Context context, View view, String s, String s1, String s2, boolean flag)
    {
        mSystemLogEnabled = true;
        mRunningAppsEnabled = true;
        mParentActivity = activity;
        mContext = context;
        if (view != null)
        {
            mCurrentView = view.getRootView();
            mCurrentView.setDrawingCacheEnabled(true);
        } else
        {
            mCurrentView = null;
        }
        mLogFilter = s;
        mCategoryTag = s1;
        mProductBinaryData = new LinkedList();
        mScreenshotEnabled = flag;
        mAlternateScreenshot = null;
        mShouldShowPopupOnAnonymousSubmission = false;
        mShouldShowPopupOnEmptyDescription = false;
        mCrashData = null;
        mBucket = s2;
        mUiConfigurationOptions = null;
        mLogs = null;
        mShouldAutoScaleBitmap = false;
    }

    public UserFeedbackSpec(Activity activity, View view, String s, String s1)
    {
        this(activity, view, s, s1, null, true);
    }

    public UserFeedbackSpec(Activity activity, View view, String s, String s1, String s2)
    {
        this(activity, view, s, s1, s2, true);
    }

    public UserFeedbackSpec(Activity activity, View view, String s, String s1, String s2, boolean flag)
    {
        this(activity, activity.getApplicationContext(), view, s, s1, s2, flag);
    }

    public UserFeedbackSpec(Activity activity, String s, String s1)
    {
        this(activity, null, s, s1, null, false);
    }

    protected static final UserFeedbackSpec defensiveCopyFrom(UserFeedbackSpec userfeedbackspec)
    {
        UserFeedbackSpec userfeedbackspec1 = new UserFeedbackSpec(userfeedbackspec.getActivity(), userfeedbackspec.getContext(), userfeedbackspec.mCurrentView, userfeedbackspec.mLogFilter, userfeedbackspec.mCategoryTag, userfeedbackspec.getBucket(), userfeedbackspec.isScreenshotEnabled());
        userfeedbackspec1.setSystemLogEnabled(userfeedbackspec.isSystemLogEnabled());
        userfeedbackspec1.setCrashData(userfeedbackspec.getCrashData());
        userfeedbackspec1.setUiConfigurationOptions(userfeedbackspec.getUiConfigurationOptions());
        if (userfeedbackspec.shouldShowPopupForAnonymousSubmission())
        {
            userfeedbackspec1.showPopupOnAnonymousSubmission();
        }
        if (userfeedbackspec.shouldShowPopupForEmptyDescription())
        {
            userfeedbackspec1.showPopupOnEmptyDescription();
        }
        userfeedbackspec1.setLogs(userfeedbackspec.getLogs());
        if (userfeedbackspec.getCrashData() != null)
        {
            userfeedbackspec1.setCrashData(new UserFeedbackCrashData(userfeedbackspec.getCrashData()));
        }
        userfeedbackspec1.setSelectedAccount(userfeedbackspec.getSelectedAccount());
        userfeedbackspec1.setRunningAppsEnabled(userfeedbackspec.isRunningAppsEnabled());
        if (userfeedbackspec.getCurrentScreenshot() != null)
        {
            userfeedbackspec1.setScreenshot(Bitmap.createBitmap(userfeedbackspec.getCurrentScreenshot()));
            if (userfeedbackspec.mCurrentView != null)
            {
                userfeedbackspec.mCurrentView.destroyDrawingCache();
            }
        }
        ProductSpecificBinaryDataHolder productspecificbinarydataholder;
        for (userfeedbackspec = userfeedbackspec.getProductSpecificBinaryData().iterator(); userfeedbackspec.hasNext(); userfeedbackspec1.addProductSpecificBinaryData(productspecificbinarydataholder.getName(), productspecificbinarydataholder.getMimeType(), productspecificbinarydataholder.getData()))
        {
            productspecificbinarydataholder = (ProductSpecificBinaryDataHolder)userfeedbackspec.next();
        }

        return userfeedbackspec1;
    }

    private byte[] getBytes(Object obj)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
            objectoutputstream.writeObject(obj);
            objectoutputstream.flush();
            objectoutputstream.close();
            obj = bytearrayoutputstream.toByteArray();
            bytearrayoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            return null;
        }
        return ((byte []) (obj));
    }

    public UserFeedbackSpec addProductSpecificBinaryData(String s, String s1, Object obj)
    {
        mProductBinaryData.add(new ProductSpecificBinaryDataHolder(s, s1, getBytes(obj)));
        return this;
    }

    public UserFeedbackSpec addProductSpecificBinaryData(String s, String s1, byte abyte0[])
    {
        mProductBinaryData.add(new ProductSpecificBinaryDataHolder(s, s1, abyte0));
        return this;
    }

    public Activity getActivity()
    {
        return mParentActivity;
    }

    public String getBucket()
    {
        return mBucket;
    }

    public String getCategoryTag()
    {
        return mCategoryTag;
    }

    public Context getContext()
    {
        return mContext;
    }

    public UserFeedbackCrashData getCrashData()
    {
        return mCrashData;
    }

    public Bitmap getCurrentScreenshot()
    {
        if (isScreenshotEnabled())
        {
            if (mAlternateScreenshot != null)
            {
                return mAlternateScreenshot;
            }
            if (mCurrentView != null)
            {
                Bitmap bitmap;
                try
                {
                    bitmap = mCurrentView.getDrawingCache(mShouldAutoScaleBitmap);
                }
                catch (Exception exception)
                {
                    String s = String.valueOf(exception.getMessage());
                    if (s.length() != 0)
                    {
                        s = "Error generating screenshot: ".concat(s);
                    } else
                    {
                        s = new String("Error generating screenshot: ");
                    }
                    Log.e("GFEEDBACK", s, exception);
                    return null;
                }
                return bitmap;
            }
        }
        return null;
    }

    public String getLogFilter()
    {
        return mLogFilter;
    }

    public String getLogs()
    {
        return mLogs;
    }

    List getProductSpecificBinaryData()
    {
        return mProductBinaryData;
    }

    public String getSelectedAccount()
    {
        return mSelectedAccount;
    }

    public UiConfigurationOptions getUiConfigurationOptions()
    {
        return mUiConfigurationOptions;
    }

    public boolean isRunningAppsEnabled()
    {
        return mRunningAppsEnabled;
    }

    public boolean isScreenshotEnabled()
    {
        return mScreenshotEnabled;
    }

    public boolean isSystemLogEnabled()
    {
        return mSystemLogEnabled;
    }

    public void setAutoScaleBitmap(boolean flag)
    {
        mShouldAutoScaleBitmap = flag;
    }

    public UserFeedbackSpec setCrashData(UserFeedbackCrashData userfeedbackcrashdata)
    {
        mCrashData = userfeedbackcrashdata;
        return this;
    }

    public UserFeedbackSpec setLogs(String s)
    {
        mLogs = s;
        return this;
    }

    public UserFeedbackSpec setRunningAppsEnabled(boolean flag)
    {
        mRunningAppsEnabled = flag;
        return this;
    }

    public void setScreenshot(Bitmap bitmap)
    {
        setScreenshotEnabled(true);
        mAlternateScreenshot = bitmap;
    }

    public UserFeedbackSpec setScreenshotEnabled(boolean flag)
    {
        mScreenshotEnabled = flag;
        return this;
    }

    public void setSelectedAccount(String s)
    {
        mSelectedAccount = s;
    }

    public UserFeedbackSpec setSystemLogEnabled(boolean flag)
    {
        mSystemLogEnabled = flag;
        return this;
    }

    public UserFeedbackSpec setUiConfigurationOptions(UiConfigurationOptions uiconfigurationoptions)
    {
        mUiConfigurationOptions = uiconfigurationoptions;
        return this;
    }

    boolean shouldShowPopupForAnonymousSubmission()
    {
        return mShouldShowPopupOnAnonymousSubmission;
    }

    boolean shouldShowPopupForEmptyDescription()
    {
        return mShouldShowPopupOnEmptyDescription;
    }

    public UserFeedbackSpec showPopupOnAnonymousSubmission()
    {
        mShouldShowPopupOnAnonymousSubmission = true;
        return this;
    }

    public UserFeedbackSpec showPopupOnEmptyDescription()
    {
        mShouldShowPopupOnEmptyDescription = true;
        return this;
    }
}
