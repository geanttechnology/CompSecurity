// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.DateTimeUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.ScreenUtils;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.AviaryExecutionException;
import com.aviary.android.feather.headless.AviaryInitializationException;
import com.aviary.android.feather.headless.filters.NativeFilterProxy;
import com.aviary.android.feather.library.MonitoredActivity;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.HiResBackgroundService;
import com.aviary.android.feather.library.services.LocalDataService;
import com.aviary.android.feather.library.services.PreferenceService;
import com.aviary.android.feather.library.services.SessionService;
import com.aviary.android.feather.library.services.drag.DragLayer;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.utils.ImageInfo;
import com.aviary.android.feather.sdk.async_tasks.DownloadImageAsyncTask;
import com.aviary.android.feather.sdk.panels.AbstractPanelLoaderService;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.aviary.android.feather.sdk.utils.UIUtils;
import com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper;
import com.aviary.android.feather.sdk.widget.AviaryImageViewUndoRedo;
import com.aviary.android.feather.sdk.widget.AviaryNavBarViewFlipper;
import com.aviary.android.feather.sdk.widget.AviaryToast;
import it.sephiroth.android.library.exif2.ExifInterface;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.sdk:
//            AviaryMainController, ToolsLoaderAsyncTask

public class FeatherActivity extends MonitoredActivity
    implements AviaryMainController.FeatherContext, AviaryMainController.OnBitmapChangeListener, ToolsLoaderAsyncTask.OnToolsLoadListener, com.aviary.android.feather.sdk.async_tasks.DownloadImageAsyncTask.OnImageDownloadListener, com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper.OnBottomBarItemClickListener, com.aviary.android.feather.sdk.widget.AviaryImageViewUndoRedo.OnHistoryListener, com.aviary.android.feather.sdk.widget.AviaryNavBarViewFlipper.OnToolbarClickListener, it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
{
    public static final class FinalAction extends Enum
    {

        private static final FinalAction $VALUES[];
        public static final FinalAction ASK;
        public static final FinalAction CLOSE;

        public static FinalAction valueOf(String s)
        {
            return (FinalAction)Enum.valueOf(com/aviary/android/feather/sdk/FeatherActivity$FinalAction, s);
        }

        public static FinalAction[] values()
        {
            return (FinalAction[])$VALUES.clone();
        }

        static 
        {
            ASK = new FinalAction("ASK", 0);
            CLOSE = new FinalAction("CLOSE", 1);
            $VALUES = (new FinalAction[] {
                ASK, CLOSE
            });
        }

        private FinalAction(String s, int i)
        {
            super(s, i);
        }
    }

    class ListAdapter extends ArrayAdapter
    {

        static final int TYPE_FEDDBACK = 1;
        static final int TYPE_TOOL = 0;
        LayoutInflater mInflater;
        Object mLock;
        List mObjects;
        int mToolViewWidth;
        int mViewWidth;
        boolean mWhiteLabel;
        final FeatherActivity this$0;

        public int getCount()
        {
            return mObjects.size();
        }

        public ToolEntry getItem(int i)
        {
            return (ToolEntry)mObjects.get(i);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public int getItemViewType(int i)
        {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            int k = getItemViewType(i);
            Object obj = view;
            if (view == null)
            {
                obj = view;
                if (k == 0)
                {
                    view = mInflater;
                    int j;
                    if (FeatherActivity.MATURITY.isKidsFriendly())
                    {
                        j = R.layout.aviary_tool_layout_freetime;
                    } else
                    {
                        j = R.layout.aviary_tool_layout;
                    }
                    view = view.inflate(j, viewgroup, false);
                    viewgroup = view.getLayoutParams();
                    if (mToolViewWidth == -1)
                    {
                        obj = mToolsList.measureChild(view);
                        double d = Math.floor((double)mViewWidth / (double)obj[0]);
                        mToolViewWidth = (int)((double)mViewWidth / (d + 0.5D));
                    }
                    obj = view;
                    if (viewgroup != null)
                    {
                        viewgroup.width = mToolViewWidth;
                        view.setLayoutParams(viewgroup);
                        obj = view;
                    }
                }
            }
            if (k == 0)
            {
                ((View) (obj)).setTag(getItem(i));
            }
            return ((View) (obj));
        }

        public int getViewTypeCount()
        {
            return !mWhiteLabel ? 2 : 1;
        }

        public ListAdapter(Context context, List list, boolean flag)
        {
            this$0 = FeatherActivity.this;
            super(context, -1);
            mLock = new Object();
            mViewWidth = context.getResources().getDisplayMetrics().widthPixels;
            mToolViewWidth = -1;
            mInflater = LayoutInflater.from(context);
            mObjects = list;
            mWhiteLabel = flag;
        }
    }

    class SaveHiResImageTask extends AviaryAsyncTask
        implements android.content.DialogInterface.OnDismissListener, android.media.MediaScannerConnection.OnScanCompletedListener, com.aviary.android.feather.library.media.SingleMediaScannerItem.OnScanErrorListener, com.aviary.android.feather.library.services.HiResBackgroundService.OnHiresListener
    {

        com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
        Bitmap mBitmap;
        android.graphics.Bitmap.CompressFormat mCompressFormat;
        private int mCompressQuality;
        File mDestFile;
        String mErrorString;
        FinalAction mFinalAction;
        private Object mFinishedLock;
        AviaryExecutionException mHiresException;
        boolean mIsHiRes;
        private Uri mOutputContentUri;
        ProgressDialog mProgress;
        private Object mScanCompletedLock;
        final FeatherActivity this$0;

        private boolean saveInBackgroundHiRes()
        {
            logger.info("saveInBackgroundHiRes");
            SessionService sessionservice = (SessionService)mMainController.getService(com/aviary/android/feather/library/services/SessionService);
            if (sessionservice == null)
            {
                return false;
            }
            mMainController.addOnHiresListener(this);
            sessionservice.save(mDestFile.getAbsolutePath(), mCompressFormat, mCompressQuality);
            logger.log("waiting for notification from mFinishedLock..");
            Object obj = mFinishedLock;
            obj;
            JVM INSTR monitorenter ;
            logger.log("waiting for mFinishedLock...");
            mFinishedLock.wait();
            mMainController.removeOnHiresListener(this);
            return true;
            Object obj1;
            obj1;
            ((InterruptedException) (obj1)).printStackTrace();
            mMainController.removeOnHiresListener(this);
            obj;
            JVM INSTR monitorexit ;
            return false;
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
        }

        private boolean saveInBackgroundLowRes()
        {
            logger.info("saveInBackgroundLowRes");
            try
            {
                FileOutputStream fileoutputstream = new FileOutputStream(mDestFile);
                mBitmap.compress(mCompressFormat, mCompressQuality, fileoutputstream);
                IOUtils.closeSilently(fileoutputstream);
            }
            catch (IOException ioexception)
            {
                logger.error(ioexception.getMessage());
                mErrorString = ioexception.getMessage();
                ioexception.printStackTrace();
                return false;
            }
            return true;
        }

        protected transient Pair doInBackground(Bitmap abitmap[])
        {
            mBitmap = abitmap[0];
            boolean flag;
            if (mIsHiRes)
            {
                flag = saveInBackgroundHiRes();
            } else
            {
                flag = saveInBackgroundLowRes();
            }
            while (isCancelled() || !flag || mDestFile == null || mErrorString != null || mHiresException != null) 
            {
                return null;
            }
            saveExif(mDestFile.getAbsolutePath());
            return Pair.create(mDestFile.getAbsolutePath(), mOutputContentUri);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Bitmap[])aobj);
        }

        protected void doPostExecute(Pair pair)
        {
            logger.info("doPostExecute, mErrorString:%s, mHiResException: %s", new Object[] {
                mErrorString, mHiresException
            });
            try
            {
                if (mProgress.getWindow() != null)
                {
                    mProgress.dismiss();
                }
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
                logger.error(throwable.getMessage());
            }
            if (isCancelled())
            {
                logger.warn("was cancelled..");
                onSetResult(0, null);
                finish();
                return;
            }
            if (mHiresException != null || mErrorString != null || pair == null)
            {
                if (mHiresException != null)
                {
                    performSave(mBitmap, null, mCompressFormat, mCompressQuality, false, mFinalAction);
                    return;
                }
                FeatherActivity featheractivity = FeatherActivity.this;
                if (mErrorString != null)
                {
                    pair = mErrorString;
                } else
                {
                    pair = getString(R.string.feather_error_saving_image);
                }
                featheractivity.onSaveError(pair);
                return;
            } else
            {
                onSaveCompleted(pair, mFinalAction);
                return;
            }
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Pair)obj);
        }

        protected void doPreExecute()
        {
            logger.info("doPreExecute");
            mProgress = new ProgressDialog(FeatherActivity.this);
            mProgress.setIndeterminate(true);
            mProgress.setProgressStyle(1);
            mProgress.setCancelable(true);
            mProgress.setCanceledOnTouchOutside(false);
            mProgress.setOnDismissListener(this);
            mProgress.setMessage(getString(R.string.feather_save_progress));
            mProgress.show();
        }

        protected transient void doProgressUpdate(Integer ainteger[])
        {
            int i = ainteger[0].intValue();
            int j = ainteger[1].intValue();
            logger.info("doProgressUpdate. %d/%d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            });
            if (i == 0)
            {
                ainteger = getString(R.string.feather_loading_image);
                mProgress.setProgress(0);
                mProgress.setIndeterminate(true);
            } else
            if (i == j)
            {
                ainteger = getString(R.string.feather_save_progress);
                mProgress.setProgress(100);
                mProgress.setIndeterminate(true);
            } else
            {
                if (i >= 0 && i <= j)
                {
                    float f = (float)i / (float)j;
                    try
                    {
                        mProgress.setProgress((int)(f * 100F));
                        mProgress.setIndeterminate(false);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Integer ainteger[])
                    {
                        mProgress.setIndeterminate(true);
                    }
                } else
                {
                    mProgress.setIndeterminate(true);
                }
                ainteger = "Applying actions...";
            }
            mProgress.setMessage(ainteger);
        }

        protected volatile void doProgressUpdate(Object aobj[])
        {
            doProgressUpdate((Integer[])aobj);
        }

        protected void onCancelled()
        {
            logger.error("save task cancelled");
            onSetResult(0, null);
            finish();
        }

        public void onDismiss(DialogInterface dialoginterface)
        {
            logger.error("onDismiss");
            cancel(true);
        }

        public void onHiresComplete()
        {
            logger.log("onHiresComplete");
            synchronized (mFinishedLock)
            {
                mFinishedLock.notify();
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onHiresError(AviaryExecutionException aviaryexecutionexception)
        {
            logger.info("onHiresError: %s", new Object[] {
                aviaryexecutionexception
            });
            mHiresException = aviaryexecutionexception;
            synchronized (mFinishedLock)
            {
                mFinishedLock.notify();
            }
            return;
            exception;
            aviaryexecutionexception;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onHiresProgress(int i, int j)
        {
            publishProgress(new Integer[] {
                Integer.valueOf(i), Integer.valueOf(j)
            });
        }

        public void onScanCompleted(String s, Uri uri)
        {
            logger.info((new StringBuilder()).append("onScanCompleted: ").append(s).append(", uri: ").append(uri).toString());
            mOutputContentUri = uri;
            synchronized (mScanCompletedLock)
            {
                mScanCompletedLock.notify();
            }
            return;
            uri;
            s;
            JVM INSTR monitorexit ;
            throw uri;
        }

        public void onScanError()
        {
            logger.error("onScanError");
            synchronized (mScanCompletedLock)
            {
                mScanCompletedLock.notify();
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public SaveHiResImageTask(File file, FinalAction finalaction, android.graphics.Bitmap.CompressFormat compressformat, int i, boolean flag)
        {
            this$0 = FeatherActivity.this;
            super();
            mFinishedLock = new Object();
            mScanCompletedLock = new Object();
            logger = LoggerFactory.getLogger("SaveHiResImageTask", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
            logger.info("ctor, file: %s, action: %s, hires: %b", new Object[] {
                file.getAbsolutePath(), finalaction, Boolean.valueOf(flag)
            });
            mFinalAction = finalaction;
            mDestFile = file;
            mIsHiRes = flag;
            mCompressFormat = compressformat;
            mCompressQuality = i;
        }
    }


    private static final int ALERT_ABOUT = 4;
    private static final int ALERT_CONFIRM_EXIT = 0;
    private static final int ALERT_CONFIRM_EXIT_WITH_NO_CHANGES = 5;
    private static final int ALERT_DELETE_IMAGE = 6;
    private static final int ALERT_DOWNLOAD_ERROR = 1;
    private static final int ALERT_FEEDBACK = 3;
    private static final int ALERT_REVERT_IMAGE = 2;
    public static final String EXTRA_DELETE = "delete";
    public static final String EXTRA_MATURITY = "maturity";
    public static final String ID = "$Id: 1188a5aea602ac3fc926a1a2cc7cecd7816084d2 $";
    public static Maturity MATURITY;
    private static final int TOOLS_OPEN_DELAY_TIME = 50;
    protected final com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private int mActionBarSize;
    private AviaryBottomBarViewFlipper mBottomBarFlipper;
    private DownloadImageAsyncTask mDownloadTask;
    private DragLayer mDragLayer;
    private ViewGroup mDrawingViewContainer;
    protected final Handler mHandler = new Handler();
    private AviaryImageViewUndoRedo mImageRestore;
    private View mInlineProgressLoader;
    private boolean mIsNavigatingHome;
    private boolean mIsRunning;
    protected AviaryMainController mMainController;
    private int mOrientation;
    private ViewGroup mPopupContainer;
    protected boolean mSaving;
    private AviaryToast mToastLoader;
    private AviaryNavBarViewFlipper mToolbar;
    private HListView mToolsList;
    private Handler mUIHandler;
    private com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper.OnViewChangingStatusListener onViewChaningStatusListener;
    private int pResultCode;

    public FeatherActivity()
    {
        logger = LoggerFactory.getLogger("FeatherActivity", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
        pResultCode = 0;
        mIsNavigatingHome = false;
        mActionBarSize = -1;
        mUIHandler = new Handler(new android.os.Handler.Callback() {

            final FeatherActivity this$0;

            public boolean handleMessage(Message message)
            {
                boolean flag = false;
                if (message.what == 10)
                {
                    onStateChanged(message.arg1, message.arg2);
                    return true;
                }
                AviaryNavBarViewFlipper aviarynavbarviewflipper;
                switch (message.what)
                {
                default:
                    logger.warn("un-handled message");
                    return true;

                case 5: // '\005'
                    mImageRestore.setVisibility(8);
                    return true;

                case 6: // '\006'
                    mToolbar.setTitle(mMainController.getActiveTool().labelResourceId, false);
                    mToolbar.open();
                    getMainImage().resetMatrix();
                    return true;

                case 100: // 'd'
                    mToolbar.setTitle((CharSequence)message.obj);
                    return true;

                case 101: // 'e'
                    mToolbar.setTitle(message.arg1);
                    return true;

                case 102: // 'f'
                    aviarynavbarviewflipper = mToolbar;
                    break;
                }
                if (message.arg1 != 0)
                {
                    flag = true;
                }
                aviarynavbarviewflipper.setApplyVisible(flag);
                return true;
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        });
    }

    private int getActionBarHeight()
    {
        Object obj;
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            obj = new int[1];
            obj[0] = 0x10102eb;
        } else
        {
            obj = new int[1];
            obj[0] = R.attr.actionBarSize;
        }
        obj = obtainStyledAttributes(((int []) (obj)));
        i = (int)((TypedArray) (obj)).getDimension(0, 0.0F);
        ((TypedArray) (obj)).recycle();
        logger.log("actionbarHeight: %d", new Object[] {
            Integer.valueOf(i)
        });
        return i;
    }

    private int getStatusBarHeight()
    {
        int i = 0;
        int j = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (j > 0)
        {
            i = getResources().getDimensionPixelSize(j);
        }
        return i;
    }

    private void hideProgressLoader()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(getResources().getInteger(0x10e0001));
        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final FeatherActivity this$0;

            public void onAnimationEnd(Animation animation)
            {
                mInlineProgressLoader.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        });
        mInlineProgressLoader.startAnimation(alphaanimation);
    }

    private void initFreetimeOptions()
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final FeatherActivity this$0;

            public void onClick(View view)
            {
                onBackPressed();
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener1 = new android.view.View.OnClickListener() {

            final FeatherActivity this$0;

            public void onClick(View view)
            {
                if (!mMainController.isToolActive() && !mMainController.getBitmapIsChanged())
                {
                    showDialog(6);
                    return;
                } else
                {
                    mMainController.onRestoreOriginal();
                    return;
                }
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        };
        findViewById(R.id.bottom_bar_undo).setOnClickListener(new android.view.View.OnClickListener() {

            final FeatherActivity this$0;

            public void onClick(View view)
            {
                mMainController.onUndo();
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        });
        findViewById(R.id.bottom_bar_trash).setOnClickListener(onclicklistener1);
        findViewById(R.id.bottom_bar_clear).setOnClickListener(onclicklistener1);
        findViewById(R.id.bottom_bar_gallery).setOnClickListener(onclicklistener);
        findViewById(R.id.bottom_bar_tool).setOnClickListener(onclicklistener);
    }

    private void initializeController()
    {
        mMainController = new AviaryMainController(this, mUIHandler);
        onControllerLoaded(mMainController);
    }

    private void onInitializeUI()
    {
        mToolbar.setOnToolbarClickListener(this);
        mImageRestore.setDoubleTapEnabled(false);
        mImageRestore.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        mToolsList.setAdapter(null);
        mBottomBarFlipper.setOnBottomBarItemClickListener(this);
    }

    private void onRevert()
    {
        loadImage(((LocalDataService)mMainController.getService(com/aviary/android/feather/library/services/LocalDataService)).getSourceImageUri());
    }

    private void postSetContentView()
    {
        if (MATURITY.isKidsFriendly())
        {
            View view = findViewById(R.id.main_content_view);
            view.setPadding(0, 0, 0, 0);
            view.invalidate();
            findViewById(R.id.aviary_navbar).setVisibility(8);
            findViewById(R.id.bottom_bar_gallery).setVisibility(0);
            findViewById(R.id.bottom_bar_trash).setVisibility(0);
            onViewChaningStatusListener = new com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper.OnViewChangingStatusListener() {

                final FeatherActivity this$0;

                public void onCloseEnd()
                {
                }

                public void onCloseStart()
                {
                    findViewById(R.id.bottom_bar_gallery).setVisibility(0);
                    findViewById(R.id.bottom_bar_trash).setVisibility(0);
                    findViewById(R.id.bottom_bar_tool).setVisibility(8);
                    findViewById(R.id.bottom_bar_undo).setVisibility(8);
                    findViewById(R.id.bottom_bar_clear).setVisibility(8);
                }

                public void onOpenEnd()
                {
                }

                public void onOpenStart()
                {
                    findViewById(R.id.bottom_bar_gallery).setVisibility(8);
                    findViewById(R.id.bottom_bar_trash).setVisibility(8);
                    findViewById(R.id.bottom_bar_tool).setVisibility(0);
                    findViewById(R.id.bottom_bar_undo).setVisibility(0);
                    findViewById(R.id.bottom_bar_clear).setVisibility(0);
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            };
            mBottomBarFlipper.addOnViewChangingStatusListener(onViewChaningStatusListener);
            initFreetimeOptions();
        }
    }

    public ViewGroup activatePopupContainer()
    {
        mPopupContainer.setVisibility(0);
        return mPopupContainer;
    }

    protected Dialog createAboutDialog()
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final FeatherActivity this$0;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setData(Uri.parse("http://www.aviary.com/android"));
                startActivity(view);
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        };
        return createBaseDialog(R.string.feather_about_dialog_message, "aviary.com/android", onclicklistener);
    }

    protected Dialog createBaseDialog(int i, String s, final android.view.View.OnClickListener button1Listener)
    {
        final Dialog dialog = new Dialog(this, R.style.AviaryTheme_Dark_Dialog_Custom);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.aviary_feedback_dialog_view);
        dialog.setCanceledOnTouchOutside(true);
        Object obj = dialog.getWindow();
        TextView textview = (TextView)((Window) (obj)).findViewById(R.id.aviary_version);
        TextView textview1 = (TextView)((Window) (obj)).findViewById(R.id.aviary_text);
        Button button = (Button)((Window) (obj)).findViewById(R.id.aviary_button1);
        obj = (Button)((Window) (obj)).findViewById(R.id.aviary_button2);
        textview.setText((new StringBuilder()).append(getString(R.string.feather_version)).append(" ").append("3.6.2").toString());
        textview1.setText(i);
        button.setText(s);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final FeatherActivity this$0;
            final android.view.View.OnClickListener val$button1Listener;
            final Dialog val$dialog;

            public void onClick(View view)
            {
                if (button1Listener != null)
                {
                    button1Listener.onClick(view);
                }
                dialog.dismiss();
            }

            
            {
                this$0 = FeatherActivity.this;
                button1Listener = onclicklistener;
                dialog = dialog1;
                super();
            }
        });
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final FeatherActivity this$0;
            final Dialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = FeatherActivity.this;
                dialog = dialog1;
                super();
            }
        });
        return dialog;
    }

    protected Dialog createFeedbackDialog()
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final FeatherActivity this$0;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setData(Uri.parse("http://support.aviary.com/"));
                startActivity(view);
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        };
        return createBaseDialog(R.string.feather_feedback_dialog_message, getString(R.string.feather_send_feedback), onclicklistener);
    }

    public void deactivatePopupContainer()
    {
        mPopupContainer.removeAllViews();
        mPopupContainer.setVisibility(8);
    }

    protected void exitWithDeleteAction()
    {
        Intent intent = new Intent();
        intent.setData(((LocalDataService)mMainController.getService(com/aviary/android/feather/library/services/LocalDataService)).getSourceImageUri());
        intent.putExtra("bitmap-changed", false);
        intent.putExtra("delete", true);
        onSetResult(-1, intent);
        finish();
    }

    protected void exitWithNoModifications()
    {
        logger.info("exitWithNoModifications");
        Intent intent = new Intent();
        intent.putExtra("bitmap-changed", false);
        onSetResult(0, intent);
        finish();
    }

    public int getActionBarSize()
    {
        if (mActionBarSize < 0)
        {
            mActionBarSize = getActionBarHeight();
        }
        return mActionBarSize;
    }

    public AviaryBottomBarViewFlipper getBottomBar()
    {
        return mBottomBarFlipper;
    }

    protected File getDefaultOutputDestination(android.graphics.Bitmap.CompressFormat compressformat)
    {
        return getSystemDefaultOutput(compressformat);
    }

    public ViewGroup getDrawingImageContainer()
    {
        return mDrawingViewContainer;
    }

    public AviaryMainController getMainController()
    {
        return mMainController;
    }

    public ImageViewTouch getMainImage()
    {
        return mImageRestore;
    }

    public volatile ImageViewTouchBase getMainImage()
    {
        return getMainImage();
    }

    public ViewGroup getOptionsPanelContainer()
    {
        return mBottomBarFlipper.getContentPanel();
    }

    protected File getSystemDefaultOutput(android.graphics.Bitmap.CompressFormat compressformat)
    {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        StringBuilder stringbuilder = (new StringBuilder()).append("aviary-image-").append(System.currentTimeMillis()).append(".");
        if (compressformat == android.graphics.Bitmap.CompressFormat.JPEG)
        {
            compressformat = "jpeg";
        } else
        {
            compressformat = "png";
        }
        return new File(file, stringbuilder.append(compressformat).toString());
    }

    public AviaryTracker getTracker()
    {
        return mTracker;
    }

    protected boolean handleBackPressedOnUnchangedImage()
    {
        if (getMainController() != null)
        {
            Object obj = (LocalDataService)getMainController().getService(com/aviary/android/feather/library/services/LocalDataService);
            if (obj != null && ((LocalDataService) (obj)).getIntentHasExtra("source-type"))
            {
                obj = (String)((LocalDataService) (obj)).getIntentExtra("source-type", com.aviary.android.feather.library.Constants.SourceType.Gallery.name());
                if (com.aviary.android.feather.library.Constants.SourceType.Camera.name().equals(obj))
                {
                    showDialog(5);
                    return true;
                }
            }
        }
        return false;
    }

    protected Uri handleIntent(Intent intent)
    {
        logger.info("handleIntent");
        if (intent != null && intent.getData() != null)
        {
            Object obj = intent.getAction();
            HashMap hashmap = new HashMap();
            if (obj == null)
            {
                obj = "null";
            }
            hashmap.put("from", obj);
            getTracker().tagEventAttributes("editor: invoked", hashmap);
            obj = intent.getData();
            intent = ((Intent) (obj));
            if (ApiHelper.isIceCreamSandwich())
            {
                intent = ((Intent) (obj));
                if (((Uri) (obj)).toString().startsWith("content://com.android.gallery3d.provider"))
                {
                    intent = Uri.parse(((Uri) (obj)).toString().replace("com.android.gallery3d", "com.google.android.gallery3d"));
                }
            }
            logger.log((new StringBuilder()).append("src: ").append(intent).toString());
            return intent;
        } else
        {
            return null;
        }
    }

    public void hideModalProgress()
    {
        if (mToastLoader != null)
        {
            mToastLoader.hide();
        }
    }

    public void hideToolProgress()
    {
        mToolbar.setApplyProgressVisible(false);
    }

    public boolean isActive()
    {
        return mIsRunning;
    }

    public boolean isFirstTimeLaunch()
    {
        if (mMainController != null)
        {
            PreferenceService preferenceservice = (PreferenceService)mMainController.getService(com/aviary/android/feather/library/services/PreferenceService);
            if (preferenceservice != null)
            {
                return preferenceservice.isFirstTimeLaunch();
            }
        }
        return false;
    }

    protected void loadImage(Uri uri)
    {
        if (mDownloadTask != null)
        {
            mDownloadTask.setOnLoadListener(null);
            mDownloadTask = null;
        }
        LocalDataService localdataservice = (LocalDataService)mMainController.getService(com/aviary/android/feather/library/services/LocalDataService);
        int i = ((Integer)localdataservice.getIntentExtra("max-image-size", Integer.valueOf(0))).intValue();
        localdataservice.setSourceImageUri(uri);
        if (mMainController.getToolList() == null && localdataservice.getIntentHasExtra("tools-list"))
        {
            Arrays.asList((Object[])localdataservice.getIntentExtra("tools-list", new String[0]));
        }
        mDownloadTask = new DownloadImageAsyncTask(uri, i);
        mDownloadTask.setOnLoadListener(this);
        mDownloadTask.executeInParallel(new Context[] {
            this
        });
    }

    protected List loadStandaloneTools()
    {
        logger.info("loadStandaloneTools");
        return null;
    }

    protected void loadTools()
    {
        List list = null;
        LocalDataService localdataservice = (LocalDataService)mMainController.getService(com/aviary/android/feather/library/services/LocalDataService);
        AbstractPanelLoaderService abstractpanelloaderservice = (AbstractPanelLoaderService)mMainController.getService(com/aviary/android/feather/sdk/panels/AbstractPanelLoaderService);
        if (mMainController.getToolList() == null)
        {
            if (localdataservice.getIntentHasExtra("tools-list"))
            {
                list = Arrays.asList((Object[])localdataservice.getIntentExtra("tools-list", new String[0]));
            }
            (new ToolsLoaderAsyncTask(this, list, abstractpanelloaderservice)).executeInParallel(new FeatherActivity[] {
                this
            });
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        mMainController.onActivityResult(i, j, intent);
    }

    public void onApplyClick()
    {
        mMainController.onApply();
    }

    public void onBackPressed()
    {
        if (MATURITY.isKidsFriendly() && mMainController.isToolActive())
        {
            mMainController.onApply();
        } else
        if (!mMainController.onBackPressed())
        {
            if (mToastLoader != null)
            {
                mToastLoader.hide();
            }
            if (mMainController.getBitmapIsChanged())
            {
                if (MATURITY.isKidsFriendly())
                {
                    onDoneClick();
                    return;
                }
                LocalDataService localdataservice = (LocalDataService)mMainController.getService(com/aviary/android/feather/library/services/LocalDataService);
                if (localdataservice != null && ((Boolean)localdataservice.getIntentExtra("hide-exit-unsave-confirmation", Boolean.valueOf(false))).booleanValue())
                {
                    super.onBackPressed();
                    return;
                } else
                {
                    showDialog(0);
                    return;
                }
            }
            if (!handleBackPressedOnUnchangedImage())
            {
                onSetResult(0, null);
                super.onBackPressed();
                return;
            }
        }
    }

    protected void onBackPressed(boolean flag)
    {
        if (flag)
        {
            super.onBackPressed();
            return;
        } else
        {
            onBackPressed();
            return;
        }
    }

    public void onBitmapChange(Bitmap bitmap, boolean flag, Matrix matrix)
    {
        Matrix matrix1 = matrix;
        if (!flag)
        {
            matrix1 = matrix;
            if (matrix == null)
            {
                matrix1 = getMainImage().getDisplayMatrix();
            }
        }
        logger.log("onBitmapChange, update: %b, matrix: %s", new Object[] {
            Boolean.valueOf(flag), matrix1
        });
        getMainImage().setImageBitmap(bitmap, matrix1, -1F, -1F);
    }

    public void onBottomBarItemClick(int i)
    {
        if (i == R.id.aviary_white_logo)
        {
            showDialog(4);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (mOrientation != configuration.orientation)
        {
            mOrientation = configuration.orientation;
            if (mMainController != null)
            {
                mMainController.onConfigurationChanged(configuration);
            }
        }
        mOrientation = configuration.orientation;
    }

    public void onContentChanged()
    {
        super.onContentChanged();
        mDragLayer = (DragLayer)findViewById(R.id.dragLayer);
        mToolbar = (AviaryNavBarViewFlipper)findViewById(R.id.aviary_navbar);
        mBottomBarFlipper = (AviaryBottomBarViewFlipper)findViewById(R.id.aviary_bottombar);
        mToolsList = mBottomBarFlipper.getToolsListView();
        mDrawingViewContainer = (ViewGroup)findViewById(R.id.drawing_view_container);
        mInlineProgressLoader = findViewById(R.id.image_loading_view);
        mPopupContainer = (ViewGroup)findViewById(R.id.feather_dialogs_container);
        mBottomBarFlipper.setDisplayedChild(1);
        mImageRestore = (AviaryImageViewUndoRedo)findViewById(R.id.image);
    }

    protected void onControllerLoaded(AviaryMainController aviarymaincontroller)
    {
    }

    public void onCreate(Bundle bundle)
    {
        long l = DateTimeUtils.tick();
        onPreCreate();
        super.onCreate(bundle);
        if (getIntent().hasExtra("maturity"))
        {
            MATURITY = Maturity.valueOf(getIntent().getStringExtra("maturity"));
        }
        if (MATURITY != null && MATURITY.isKidsFriendly())
        {
            setRequestedOrientation(0);
        } else
        if (!ScreenUtils.isTablet(this))
        {
            setRequestedOrientation(1);
        }
        if (MATURITY.isKidsFriendly())
        {
            setContentView(R.layout.aviary_main_freetime_view);
        } else
        {
            setContentView(R.layout.aviary_main_view);
        }
        postSetContentView();
        onSetResult(0, null);
        initializeController();
        onInitializeUtils();
        onInitializeUI();
        mMainController.setOnBitmapChangeListener(this);
        mMainController.setDragLayer(mDragLayer);
        bundle = handleIntent(getIntent());
        if (bundle == null)
        {
            onSetResult(0, null);
            finish();
            return;
        } else
        {
            loadTools();
            loadImage(bundle);
            onPostCreate();
            getTracker().tagEvent("editor: opened");
            DateTimeUtils.tick(l, "onCreate finished");
            return;
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return (new android.app.AlertDialog.Builder(this)).setTitle(R.string.feather_confirm).setMessage(R.string.confirm_quit_message).setPositiveButton(R.string.feather_yes_leave, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    onBackPressed(true);
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).setNegativeButton(R.string.feather_keep_editing, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).create();

        case 1: // '\001'
            return (new android.app.AlertDialog.Builder(this)).setTitle(R.string.feather_attention).setMessage(R.string.feather_error_download_image_message).setCancelable(false).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    finish();
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).create();

        case 2: // '\002'
            return (new android.app.AlertDialog.Builder(this)).setTitle(R.string.feather_revert_dialog_title).setMessage(R.string.feather_revert_dialog_message).setPositiveButton(0x1040013, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    onRevert();
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).setNegativeButton(0x1040009, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).create();

        case 3: // '\003'
            return createFeedbackDialog();

        case 4: // '\004'
            return createAboutDialog();

        case 5: // '\005'
            return (new android.app.AlertDialog.Builder(this)).setTitle(R.string.feather_confirm).setMessage(R.string.feather_unsaved_from_camera).setPositiveButton(R.string.feather_yes_leave, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    onBackPressed(true);
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).setNegativeButton(R.string.feather_keep_editing, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).create();

        case 6: // '\006'
            return (new android.app.AlertDialog.Builder(this)).setTitle(R.string.feather_delete_from_device).setPositiveButton(R.string.feather_delete, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    exitWithDeleteAction();
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).setNegativeButton(R.string.feather_cancel, new android.content.DialogInterface.OnClickListener() {

                final FeatherActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
            }).create();
        }
    }

    protected void onDestroy()
    {
        logger.info("onDestroy");
        if (pResultCode != -1)
        {
            getTracker().tagEvent("editor: cancelled");
        }
        super.onDestroy();
        mToolbar.setOnToolbarClickListener(null);
        mBottomBarFlipper.setOnBottomBarItemClickListener(null);
        mMainController.setOnBitmapChangeListener(null);
        mToolsList.setOnScrollListener(null);
        if (onViewChaningStatusListener != null)
        {
            mBottomBarFlipper.removeOnViewChangingStatusListener(onViewChaningStatusListener);
        }
        if (mDownloadTask != null)
        {
            mDownloadTask.setOnLoadListener(null);
            mDownloadTask = null;
        }
        if (mMainController != null)
        {
            mMainController.dispose();
        }
        mUIHandler = null;
        mMainController = null;
    }

    public void onDoneClick()
    {
        if (mMainController != null && mMainController.getEnabled())
        {
            LocalDataService localdataservice = (LocalDataService)mMainController.getService(com/aviary/android/feather/library/services/LocalDataService);
            boolean flag = mMainController.getBitmapIsChanged();
            boolean flag1 = ((Boolean)localdataservice.getIntentExtra("save-on-no-changes", Boolean.valueOf(true))).booleanValue();
            logger.log((new StringBuilder()).append("bitmap changed: ").append(flag).toString());
            logger.log((new StringBuilder()).append("save with no changes: ").append(flag1).toString());
            if (!flag && !flag1)
            {
                exitWithNoModifications();
            } else
            {
                mMainController.onSave();
                Bitmap bitmap = mMainController.getBitmap();
                if (bitmap != null)
                {
                    performSave(bitmap, flag);
                    return;
                }
            }
        }
    }

    public void onDownloadComplete(final Bitmap tool, final ImageInfo toolExtras)
    {
        logger.info("onDownloadComplete");
        logger.log("imageinfo: %s", new Object[] {
            toolExtras
        });
        mDownloadTask = null;
        getMainImage().setImageBitmap(tool, null, -1F, -1F);
        Animation animation = AnimationUtils.loadAnimation(this, 0x10a0000);
        animation.setFillEnabled(true);
        mImageRestore.setVisibility(0);
        mImageRestore.startAnimation(animation);
        hideProgressLoader();
        if (mMainController != null)
        {
            if (!mMainController.getEnabled())
            {
                mMainController.onActivate(tool, toolExtras);
            }
            mImageRestore.setOnHistoryListener(this);
        }
        if (tool != null && toolExtras.getOriginalSize() != null)
        {
            logger.error((new StringBuilder()).append("original.size: ").append(toolExtras.getOriginalSize()[0]).append("x").append(toolExtras.getOriginalSize()[1]).toString());
            logger.error((new StringBuilder()).append("final.size: ").append(tool.getWidth()).append("x").append(tool.getHeight()).toString());
        }
        toolExtras = getIntent();
        if (toolExtras != null && toolExtras.hasExtra("extra-in-quick-tool"))
        {
            tool = ToolLoaderFactory.findToolByName(toolExtras.getStringExtra("extra-in-quick-tool"));
            toolExtras = toolExtras.getBundleExtra("extra-in-quick-tool-options");
            if (tool != null)
            {
                mHandler.post(new Runnable() {

                    final FeatherActivity this$0;
                    final com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools val$tool;
                    final Bundle val$toolExtras;

                    public void run()
                    {
                        quickLaunch(tool, toolExtras);
                    }

            
            {
                this$0 = FeatherActivity.this;
                tool = tools;
                toolExtras = bundle;
                super();
            }
                });
            }
        }
    }

    public void onDownloadError(String s)
    {
        logger.error("onDownloadError", new Object[] {
            s
        });
        mDownloadTask = null;
        hideProgressLoader();
        showDialog(1);
    }

    public void onDownloadStart()
    {
        mImageRestore.setVisibility(4);
        mInlineProgressLoader.setVisibility(0);
    }

    protected void onInitializeUtils()
    {
        try
        {
            NativeFilterProxy.init(this);
            return;
        }
        catch (AviaryInitializationException aviaryinitializationexception)
        {
            aviaryinitializationexception.printStackTrace();
            Toast.makeText(getApplicationContext(), (new StringBuilder()).append("Sorry an error occurred: ").append(aviaryinitializationexception.getMessage()).toString(), 1).show();
            finish();
            return;
        }
    }

    public void onInvalidateBitmap()
    {
        getMainImage().invalidate();
    }

    public void onItemClick(final AdapterView tag, View view, int i, long l)
    {
        logger.info((new StringBuilder()).append("onItemClick: ").append(i).toString());
        if (view != null && tag.isEnabled() && tag.getAdapter() != null)
        {
            int j = tag.getAdapter().getItemViewType(i);
            if (j == 0)
            {
                tag = ((AdapterView) (tag.getAdapter().getItem(i)));
                if (tag instanceof ToolEntry)
                {
                    mUIHandler.postDelayed(new Runnable() {

                        final FeatherActivity this$0;
                        final Object val$tag;

                        public void run()
                        {
                            mMainController.activateTool((ToolEntry)tag);
                        }

            
            {
                this$0 = FeatherActivity.this;
                tag = obj;
                super();
            }
                    }, 50L);
                }
            } else
            if (j == 1)
            {
                showDialog(3);
                return;
            }
        }
    }

    protected void onPause()
    {
        super.onPause();
        mIsRunning = false;
    }

    protected void onPostCreate()
    {
    }

    protected void onPreCreate()
    {
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        while (mSaving || !mMainController.getEnabled() || !mMainController.isClosed()) 
        {
            return false;
        }
        return true;
    }

    public void onPreviewChange(Bitmap bitmap, boolean flag)
    {
        boolean flag1 = true;
        if (!flag)
        {
            flag1 = BitmapUtils.compareBySize(getMainImage().getDrawable(), bitmap);
        }
        logger.info((new StringBuilder()).append("onPreviewChange: ").append(bitmap).append(", changed: ").append(flag1).toString());
        Matrix matrix = null;
        if (!flag1)
        {
            matrix = getMainImage().getDisplayMatrix();
        }
        getMainImage().setImageBitmap(bitmap, matrix, -1F, -1F);
    }

    public void onPreviewChange(Drawable drawable, boolean flag)
    {
        boolean flag1 = true;
        if (!flag)
        {
            flag1 = BitmapUtils.compareBySize(getMainImage().getDrawable(), drawable);
        }
        Matrix matrix = null;
        if (!flag1)
        {
            matrix = getMainImage().getDisplayMatrix();
        }
        getMainImage().setImageDrawable(drawable, matrix, -1F, -1F);
    }

    public void onRedo()
    {
        mMainController.onRedo();
    }

    protected void onRestart()
    {
        logger.info("onRestart");
        super.onRestart();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        logger.info((new StringBuilder()).append("onRestoreInstanceState: ").append(bundle).toString());
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        mIsRunning = true;
    }

    protected void onSaveCompleted(Pair pair, FinalAction finalaction)
    {
        logger.info((new StringBuilder()).append("onSaveCompleted: ").append(pair).append(", action: ").append(finalaction).toString());
        finalaction = new Intent();
        if (pair != null)
        {
            finalaction.setData(Uri.parse((String)pair.first));
            finalaction.putExtra("extra-output-uri", (Parcelable)pair.second);
        }
        onSetResult(-1, finalaction);
        finish();
    }

    protected void onSaveCustomTags(ExifInterface exifinterface)
    {
    }

    protected void onSaveError(String s)
    {
        onSetResult(0, null);
        (new android.app.AlertDialog.Builder(this)).setTitle(R.string.feather_generic_error_title).setMessage(s).setCancelable(false).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final FeatherActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                onSetResult(0, null);
                finish();
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        }).setPositiveButton(R.string.feather_close, new android.content.DialogInterface.OnClickListener() {

            final FeatherActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                onSetResult(0, null);
                finish();
            }

            
            {
                this$0 = FeatherActivity.this;
                super();
            }
        }).show();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        logger.info("onSaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    protected final void onSetResult(int i, Intent intent)
    {
        pResultCode = i;
        Intent intent1 = intent;
        if (intent == null)
        {
            intent1 = new Intent();
        }
        intent = getIntent();
        if (intent != null)
        {
            intent = intent.getBundleExtra("extra-in-extras");
            if (intent != null)
            {
                intent1.putExtra("extra-in-extras", intent);
            }
            if (mMainController != null && !intent1.hasExtra("bitmap-changed"))
            {
                intent1.putExtra("bitmap-changed", mMainController.getBitmapIsChanged());
            }
        }
        setResult(i, intent1);
    }

    public void onStart()
    {
        logger.info("onStart");
        super.onStart();
        mOrientation = getResources().getConfiguration().orientation;
    }

    protected void onStateChanged(int i, int j)
    {
        logger.info("onStateChanged: %d >> %d", new Object[] {
            Integer.valueOf(j), Integer.valueOf(i)
        });
        switch (i)
        {
        default:
            logger.warn("state not handled: %d", new Object[] {
                Integer.valueOf(i)
            });
            return;

        case 1: // '\001'
            mToolbar.setClickable(false);
            return;

        case 2: // '\002'
            mToolbar.setClickable(true);
            return;

        case 3: // '\003'
            mToolbar.setClickable(false);
            mImageRestore.setVisibility(0);
            return;

        case 4: // '\004'
        case 5: // '\005'
            mToolsList.setEnabled(true);
            mToolbar.setClickable(true);
            mToolbar.close();
            mToolbar.setSaveEnabled(true);
            return;

        case 0: // '\0'
            mToolsList.setEnabled(false);
            mToolbar.setClickable(false);
            mToolbar.setSaveEnabled(false);
            return;
        }
    }

    public void onStop()
    {
        logger.info("onStop");
        super.onStop();
    }

    public void onToolsLoaded(List list, List list1, boolean flag)
    {
        logger.info("onToolsLoaded: %s, white-label: %b", new Object[] {
            list, Boolean.valueOf(flag)
        });
        mToolsList.setAdapter(new ListAdapter(this, list1, false));
        mToolsList.setOnItemClickListener(this);
        if (mMainController != null)
        {
            mMainController.setToolList(list);
        }
    }

    public void onUndo()
    {
        mMainController.onUndo();
    }

    protected void performSave(Bitmap bitmap, Uri uri, android.graphics.Bitmap.CompressFormat compressformat, int i, boolean flag, FinalAction finalaction)
    {
        Object obj;
        logger.info("performSave, uri:%s, quality: %d, action:%s", new Object[] {
            uri, Integer.valueOf(i), finalaction
        });
        if (uri != null)
        {
            uri = new File(uri.getPath());
        } else
        {
            uri = getDefaultOutputDestination(compressformat);
        }
        logger.log("trying to create the new file...");
        obj = uri;
        if (uri.exists())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        obj = uri;
        if (uri.createNewFile())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        logger.error("Failed to create the file");
        obj = uri;
_L2:
        ((LocalDataService)getMainController().getService(com/aviary/android/feather/library/services/LocalDataService)).setDestImageUri(Uri.parse(((File) (obj)).getAbsolutePath()));
        (new SaveHiResImageTask(((File) (obj)), finalaction, compressformat, i, flag)).execute(new Bitmap[] {
            bitmap
        });
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            logger.error("using a temporary file!");
            ioexception = File.createTempFile("aviary-image-", ".jpeg");
        }
        catch (IOException ioexception1)
        {
            ioexception1.printStackTrace();
            ioexception1 = uri;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void performSave(Bitmap bitmap, boolean flag)
    {
        if (mSaving)
        {
            return;
        }
        mSaving = true;
        getTracker().tagEvent("editor: saved", new String[] {
            "tool_count", String.valueOf(mMainController.getToolCompleteCount())
        });
        mMainController.setEnabled(false);
        LocalDataService localdataservice = (LocalDataService)mMainController.getService(com/aviary/android/feather/library/services/LocalDataService);
        if (((Boolean)localdataservice.getIntentExtra("return-data", Boolean.valueOf(false))).booleanValue())
        {
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", bitmap);
            onSetResult(-1, (new Intent()).setData(localdataservice.getDestImageUri()).setAction("inline-data").putExtras(bundle));
            finish();
            return;
        }
        flag = ((HiResBackgroundService)mMainController.getService(com/aviary/android/feather/library/services/HiResBackgroundService)).getHiresEnabled();
        FinalAction finalaction = FinalAction.ASK;
        if ("aviary.intent.action.EDIT".equals(getIntent().getAction()))
        {
            finalaction = FinalAction.CLOSE;
        }
        performSave(bitmap, localdataservice.getDestImageUri(), localdataservice.getOutputFormat(), localdataservice.getOutputQuality(), flag, finalaction);
    }

    void quickLaunch(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools, Bundle bundle)
    {
        logger.info("quickLaunch: %s", new Object[] {
            tools
        });
        AviaryMainController aviarymaincontroller = getMainController();
        ToolEntry toolentry = ((AbstractPanelLoaderService)aviarymaincontroller.getService(com/aviary/android/feather/sdk/panels/AbstractPanelLoaderService)).findEntry(tools);
        if (tools != null && aviarymaincontroller.isClosed() && aviarymaincontroller.getEnabled())
        {
            aviarymaincontroller.activateTool(toolentry, bundle);
        }
    }

    protected final boolean quickLaunchRequested()
    {
        Intent intent = getIntent();
        return intent != null && intent.hasExtra("extra-in-quick-tool");
    }

    protected void saveExif(Uri uri)
    {
        logger.log((new StringBuilder()).append("saveExif: ").append(uri).toString());
        if (uri != null)
        {
            saveExif(uri.getPath());
        }
    }

    protected void saveExif(String s)
    {
        logger.log((new StringBuilder()).append("saveExif: ").append(s).toString());
        if (s == null)
        {
            return;
        }
        Object obj = (LocalDataService)mMainController.getService(com/aviary/android/feather/library/services/LocalDataService);
        ExifInterface exifinterface = new ExifInterface();
        if (obj != null)
        {
            obj = ((LocalDataService) (obj)).getImageInfo();
            if (obj != null)
            {
                exifinterface.setTags(((ImageInfo) (obj)).getExifTagList());
            }
        }
        exifinterface.deleteTag(ExifInterface.TAG_IMAGE_WIDTH);
        exifinterface.deleteTag(ExifInterface.TAG_IMAGE_LENGTH);
        exifinterface.setTag(exifinterface.buildTag(ExifInterface.TAG_ORIENTATION, Integer.valueOf(0)));
        exifinterface.setTag(exifinterface.buildTag(ExifInterface.TAG_SOFTWARE, "Aviary for Android 3.6.2"));
        onSaveCustomTags(exifinterface);
        try
        {
            exifinterface.writeExif(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void showModalProgress()
    {
        if (mToastLoader == null)
        {
            mToastLoader = UIUtils.createModalLoaderToast(this);
        }
        mToastLoader.show();
    }

    public void showToolProgress()
    {
        mToolbar.setApplyProgressVisible(true);
    }

    static 
    {
        MATURITY = Maturity.ADULT;
    }





}
