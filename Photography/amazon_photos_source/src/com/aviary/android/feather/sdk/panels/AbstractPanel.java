// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.headless.filters.IFilter;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import java.util.HashMap;

public abstract class AbstractPanel
{
    public static interface ContentPanel
    {

        public abstract View getContentView();

        public abstract View getContentView(LayoutInflater layoutinflater);

        public abstract void setOnReadyListener(OnContentReadyListener oncontentreadylistener);
    }

    public static interface OnApplyResultListener
    {

        public abstract void onComplete(Bitmap bitmap, EditToolResultVO edittoolresultvo);
    }

    public static interface OnContentReadyListener
    {

        public abstract void onReady(AbstractPanel abstractpanel);
    }

    public static interface OnErrorListener
    {

        public abstract void onError(CharSequence charsequence, int i, android.content.DialogInterface.OnClickListener onclicklistener);

        public abstract void onError(CharSequence charsequence, int i, android.content.DialogInterface.OnClickListener onclicklistener, int j, android.content.DialogInterface.OnClickListener onclicklistener1);

        public abstract void onMessage(CharSequence charsequence, CharSequence charsequence1, int i, android.content.DialogInterface.OnClickListener onclicklistener);

        public abstract void onMessage(CharSequence charsequence, CharSequence charsequence1, int i, android.content.DialogInterface.OnClickListener onclicklistener, int j, android.content.DialogInterface.OnClickListener onclicklistener1);
    }

    public static interface OnPreviewListener
    {

        public abstract void onPreviewChange(Bitmap bitmap, boolean flag);

        public abstract void onPreviewChange(Drawable drawable, boolean flag);

        public abstract void onPreviewUpdated();
    }

    public static interface OnProgressListener
    {

        public abstract void onProgressEnd();

        public abstract void onProgressModalEnd();

        public abstract void onProgressModalStart();

        public abstract void onProgressStart();
    }

    public static interface OptionPanel
    {

        public abstract View getOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup);
    }


    static final int FILTER_SAVE_COMPLETED = 3;
    static final int HIDE_TOOLBAR_APPLY_BUTTON = 10;
    public static final int LAST_VALID_MESSAGE = 999;
    static final int PREVIEW_BITMAP_CHANGED = 1;
    static final int PREVIEW_BITMAP_UPDATED = 12;
    static final int PREVIEW_DRAWABLE_CHANGED = 13;
    static final int PROGRESS_END = 5;
    static final int PROGRESS_MODAL_END = 7;
    static final int PROGRESS_MODAL_START = 6;
    static final int PROGRESS_START = 4;
    static final int RESTORE_TOOLBAR_TITLE = 9;
    static final int SET_TOOLBAR_TITLE = 8;
    static final int SHOW_TOOLBAR_APPLY_BUTTON = 11;
    private boolean mActive;
    protected OnApplyResultListener mApplyListener;
    protected Bitmap mBitmap;
    protected boolean mChanged;
    private boolean mCreated;
    protected final EditToolResultVO mEditResult;
    protected boolean mEnabled;
    private com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools mEntryName;
    protected OnErrorListener mErrorListener;
    protected IFilter mFilter;
    private IAviaryController mFilterContext;
    protected OnPreviewListener mListener;
    final Handler mListenerHandler = new Handler() {

        final AbstractPanel this$0;

        public void handleMessage(Message message)
        {
            boolean flag;
            boolean flag2;
            flag2 = true;
            flag = true;
            super.handleMessage(message);
            message.what;
            JVM INSTR tableswitch 1 13: default 80
        //                       1 81
        //                       2 80
        //                       3 80
        //                       4 238
        //                       5 271
        //                       6 304
        //                       7 337
        //                       8 370
        //                       9 400
        //                       10 423
        //                       11 447
        //                       12 141
        //                       13 174;
               goto _L1 _L2 _L1 _L1 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
            return;
_L2:
            if (mListener != null && isActive())
            {
                OnPreviewListener onpreviewlistener = mListener;
                Bitmap bitmap = (Bitmap)message.obj;
                if (message.arg1 != 1)
                {
                    flag = false;
                }
                onpreviewlistener.onPreviewChange(bitmap, flag);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L11:
            if (mListener != null && isActive())
            {
                mListener.onPreviewUpdated();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L12:
            if (mListener != null && isActive())
            {
                OnPreviewListener onpreviewlistener1 = mListener;
                Drawable drawable = (Drawable)message.obj;
                boolean flag1;
                if (message.arg1 == 1)
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
                onpreviewlistener1.onPreviewChange(drawable, flag1);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (mProgressListener != null && isCreated())
            {
                mProgressListener.onProgressStart();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (mProgressListener != null && isCreated())
            {
                mProgressListener.onProgressEnd();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (mProgressListener != null && isCreated())
            {
                mProgressListener.onProgressModalStart();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (mProgressListener != null && isCreated())
            {
                mProgressListener.onProgressModalEnd();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (isActive())
            {
                getContext().setToolbarTitle((CharSequence)message.obj);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L8:
            if (isActive())
            {
                getContext().restoreToolbarTitle();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L9:
            if (isActive())
            {
                getContext().setPanelApplyStatusEnabled(false);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L10:
            if (isActive())
            {
                getContext().setPanelApplyStatusEnabled(true);
                return;
            }
            if (true) goto _L1; else goto _L13
_L13:
        }

            
            {
                this$0 = AbstractPanel.this;
                super();
            }
    };
    protected com.aviary.android.feather.common.log.LoggerFactory.Logger mLogger;
    private Bundle mOptions;
    protected Bitmap mPreview;
    protected OnProgressListener mProgressListener;
    protected boolean mSaving;
    protected HashMap mTrackingAttributes;

    public AbstractPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        mFilterContext = iaviarycontroller;
        mEntryName = toolentry.name;
        mActive = false;
        mEnabled = true;
        mTrackingAttributes = new HashMap();
        mLogger = LoggerFactory.getLogger(getClass().getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
        mEditResult = new EditToolResultVO(ToolLoaderFactory.getToolId(mEntryName), ToolLoaderFactory.getToolVersion(mEntryName));
        setIsChanged(false);
    }

    private void internalDispose()
    {
        recyclePreview();
        mPreview = null;
        mBitmap = null;
        mListener = null;
        mErrorListener = null;
        mApplyListener = null;
        mFilterContext = null;
        mFilter = null;
        mEntryName = null;
        mOptions = null;
    }

    public IAviaryController getContext()
    {
        return mFilterContext;
    }

    public EditToolResultVO getEditToolResult()
    {
        return mEditResult;
    }

    public Handler getHandler()
    {
        return mListenerHandler;
    }

    public boolean getIsChanged()
    {
        return mChanged;
    }

    public com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools getName()
    {
        return mEntryName;
    }

    public Bundle getOptions()
    {
        return mOptions;
    }

    public boolean hasOption(String s)
    {
        return hasOptions() && mOptions.containsKey(s);
    }

    public boolean hasOptions()
    {
        return mOptions != null;
    }

    public boolean isActive()
    {
        return mActive && isCreated();
    }

    public boolean isCreated()
    {
        return mCreated;
    }

    public boolean isEnabled()
    {
        return mEnabled;
    }

    public abstract boolean isRendering();

    public void onActivate()
    {
        mLogger.info("onActivate");
        mActive = true;
    }

    public boolean onBackPressed()
    {
        return false;
    }

    public void onBitmapReplaced(Bitmap bitmap)
    {
        mLogger.info("onBitmapReplaced");
        if (isActive())
        {
            mBitmap = bitmap;
            mEditResult.reset();
            setIsChanged(false);
        }
    }

    public boolean onCancel()
    {
        mLogger.info("onCancel");
        return false;
    }

    public void onCancelled()
    {
        mLogger.info("onCancelled");
        setEnabled(false);
    }

    public void onClosing()
    {
        mLogger.info("onClosing");
    }

    protected void onComplete(Bitmap bitmap)
    {
        onComplete(bitmap, mEditResult);
    }

    protected void onComplete(Bitmap bitmap, EditToolResultVO edittoolresultvo)
    {
        mLogger.info("onComplete(bitmap, editResult)");
        if (mApplyListener != null && isActive())
        {
            getContext().getTracker().tagEventAttributes((new StringBuilder()).append(ToolLoaderFactory.getToolName(mEntryName)).append(": saved").toString(), mTrackingAttributes);
            mApplyListener.onComplete(bitmap, edittoolresultvo);
        }
        mPreview = null;
        mSaving = false;
    }

    public void onConfigurationChanged(Configuration configuration, Configuration configuration1)
    {
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        mLogger.info("onCreate");
        mBitmap = bitmap;
        mCreated = true;
        mOptions = bundle;
    }

    public void onDeactivate()
    {
        mLogger.info("onDeactivate");
        setEnabled(false);
        mActive = false;
    }

    public void onDestroy()
    {
        mLogger.info("onDestroy");
        mCreated = false;
        onDispose();
    }

    protected void onDispose()
    {
        mLogger.info("onDispose");
        internalDispose();
    }

    protected void onGenerateResult()
    {
        onGenerateResult(mEditResult);
    }

    protected void onGenerateResult(EditToolResultVO edittoolresultvo)
    {
        mLogger.info("onGenerateResult(editResult)");
        onComplete(mPreview, edittoolresultvo);
    }

    protected void onGenericError(int i, int j, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        if (mErrorListener != null && isActive())
        {
            String s = getContext().getBaseContext().getString(i);
            mErrorListener.onError(s, j, onclicklistener);
        }
    }

    protected void onGenericError(int i, int j, android.content.DialogInterface.OnClickListener onclicklistener, int k, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        if (mErrorListener != null && isActive())
        {
            onGenericError(getContext().getBaseContext().getString(i), j, onclicklistener, k, onclicklistener1);
        }
    }

    protected void onGenericError(CharSequence charsequence, int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        if (mErrorListener != null && isActive())
        {
            mErrorListener.onError(charsequence, i, onclicklistener);
        }
    }

    protected void onGenericError(Exception exception)
    {
        onGenericError(((CharSequence) (exception.getMessage())), 0x104000a, null);
    }

    protected void onGenericError(String s, int i, android.content.DialogInterface.OnClickListener onclicklistener, int j, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        if (mErrorListener != null && isActive())
        {
            mErrorListener.onError(s, i, onclicklistener, j, onclicklistener1);
        }
    }

    protected void onGenericMessage(CharSequence charsequence, CharSequence charsequence1, int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        if (mErrorListener != null && isActive())
        {
            mErrorListener.onMessage(charsequence, charsequence1, i, onclicklistener);
        }
    }

    protected void onGenericMessage(CharSequence charsequence, CharSequence charsequence1, int i, android.content.DialogInterface.OnClickListener onclicklistener, int j, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        if (mErrorListener != null && isActive())
        {
            mErrorListener.onMessage(charsequence, charsequence1, i, onclicklistener, j, onclicklistener1);
        }
    }

    public void onOpening()
    {
        mLogger.info("onOpening");
    }

    protected void onPreviewChanged(Bitmap bitmap, boolean flag, boolean flag1)
    {
        int i = 1;
        boolean flag2;
        if (bitmap != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        setIsChanged(flag2);
        if (bitmap == null || !bitmap.equals(mPreview))
        {
            recyclePreview();
        }
        mPreview = bitmap;
        if (flag1 && isActive())
        {
            Message message = mListenerHandler.obtainMessage(1);
            message.obj = bitmap;
            if (!flag)
            {
                i = 0;
            }
            message.arg1 = i;
            mListenerHandler.sendMessage(message);
        }
    }

    protected void onPreviewChanged(Drawable drawable, boolean flag, boolean flag1)
    {
        int i = 1;
        boolean flag2;
        if (drawable != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        setIsChanged(flag2);
        if (flag1 && isActive())
        {
            Message message = mListenerHandler.obtainMessage(13);
            if (!flag)
            {
                i = 0;
            }
            message.arg1 = i;
            message.obj = drawable;
            message.sendToTarget();
        }
    }

    protected void onPreviewUpdated()
    {
        setIsChanged(true);
        if (isActive())
        {
            mListenerHandler.removeMessages(12);
            mListenerHandler.sendEmptyMessage(12);
        }
    }

    protected void onProgressEnd()
    {
        if (isActive())
        {
            mListenerHandler.sendEmptyMessage(5);
        }
    }

    protected void onProgressModalEnd()
    {
        if (isActive())
        {
            mListenerHandler.sendEmptyMessage(7);
        }
    }

    protected void onProgressModalStart()
    {
        if (isActive())
        {
            mListenerHandler.sendEmptyMessage(6);
        }
    }

    protected void onProgressStart()
    {
        if (isActive())
        {
            mListenerHandler.sendEmptyMessage(4);
        }
    }

    public void onSave()
    {
        mLogger.info("onSave");
        if (!mSaving)
        {
            mSaving = true;
            onGenerateResult();
        }
    }

    protected void recyclePreview()
    {
        if (mPreview != null && !mPreview.isRecycled() && !mPreview.equals(mBitmap))
        {
            mLogger.warn("Recycle PreviewBitmap");
            mPreview.recycle();
        }
    }

    protected void restoreToolbarTitle()
    {
        mListenerHandler.sendEmptyMessage(9);
    }

    protected void setApplyEnabled(boolean flag)
    {
        Handler handler = mListenerHandler;
        byte byte0;
        if (flag)
        {
            byte0 = 11;
        } else
        {
            byte0 = 10;
        }
        handler.sendEmptyMessage(byte0);
    }

    public void setEnabled(boolean flag)
    {
        mEnabled = flag;
    }

    protected void setIsChanged(boolean flag)
    {
        mChanged = flag;
    }

    public void setOnApplyResultListener(OnApplyResultListener onapplyresultlistener)
    {
        mApplyListener = onapplyresultlistener;
    }

    public void setOnErrorListener(OnErrorListener onerrorlistener)
    {
        mErrorListener = onerrorlistener;
    }

    public void setOnPreviewListener(OnPreviewListener onpreviewlistener)
    {
        mListener = onpreviewlistener;
    }

    public void setOnProgressListener(OnProgressListener onprogresslistener)
    {
        mProgressListener = onprogresslistener;
    }

    protected void setOptions(Bundle bundle)
    {
        mOptions = bundle;
    }

    protected void setToolbarTitle(CharSequence charsequence)
    {
        mListenerHandler.obtainMessage(8, charsequence).sendToTarget();
    }
}
