// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.headless.AviaryExecutionException;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.services.BadgeService;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.DragControllerService;
import com.aviary.android.feather.library.services.HiResBackgroundService;
import com.aviary.android.feather.library.services.IAPService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.services.LocalDataService;
import com.aviary.android.feather.library.services.PreferenceService;
import com.aviary.android.feather.library.services.ServiceLoader;
import com.aviary.android.feather.library.services.SessionService;
import com.aviary.android.feather.library.services.ThreadPoolService;
import com.aviary.android.feather.library.services.drag.DragLayer;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.utils.ImageInfo;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.sdk.overlays.AviaryOverlay;
import com.aviary.android.feather.sdk.overlays.UndoRedoOverlay;
import com.aviary.android.feather.sdk.panels.AbstractPanel;
import com.aviary.android.feather.sdk.panels.AbstractPanelLoaderService;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import it.sephiroth.android.library.tooltip.TooltipManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.sdk:
//            FeatherActivity

public final class AviaryMainController
    implements com.aviary.android.feather.library.services.HiResBackgroundService.OnHiresListener, IAviaryController, com.aviary.android.feather.sdk.panels.AbstractPanel.OnApplyResultListener, com.aviary.android.feather.sdk.panels.AbstractPanel.OnContentReadyListener, com.aviary.android.feather.sdk.panels.AbstractPanel.OnErrorListener, com.aviary.android.feather.sdk.panels.AbstractPanel.OnPreviewListener, com.aviary.android.feather.sdk.panels.AbstractPanel.OnProgressListener
{
    public static interface FeatherContext
    {

        public abstract ViewGroup activatePopupContainer();

        public abstract void deactivatePopupContainer();

        public abstract int getActionBarSize();

        public abstract AviaryBottomBarViewFlipper getBottomBar();

        public abstract ViewGroup getDrawingImageContainer();

        public abstract ImageViewTouchBase getMainImage();

        public abstract ViewGroup getOptionsPanelContainer();

        public abstract AviaryTracker getTracker();

        public abstract void hideModalProgress();

        public abstract void hideToolProgress();

        public abstract void showModalProgress();

        public abstract void showToolProgress();
    }

    public static interface OnBitmapChangeListener
    {

        public abstract void onBitmapChange(Bitmap bitmap, boolean flag, Matrix matrix);

        public abstract void onInvalidateBitmap();

        public abstract void onPreviewChange(Bitmap bitmap, boolean flag);

        public abstract void onPreviewChange(Drawable drawable, boolean flag);
    }


    public static final int CONTROLLER_STATE_CHANGED = 10;
    public static final int CONTROLLER_STATE_CLOSED_CANCEL = 5;
    public static final int CONTROLLER_STATE_CLOSED_CONFIRMED = 4;
    public static final int CONTROLLER_STATE_CLOSING = 3;
    public static final int CONTROLLER_STATE_DISABLED = 0;
    public static final int CONTROLLER_STATE_OPENED = 2;
    public static final int CONTROLLER_STATE_OPENING = 1;
    public static final int PANEL_STATE_CONTENT_READY = 5;
    public static final int PANEL_STATE_READY = 6;
    public static final int TOOLBAR_APPLY_VISIBILITY = 102;
    public static final int TOOLBAR_TITLE = 100;
    public static final int TOOLBAR_TITLE_INT = 101;
    private com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private Boolean mAppIsUpdated;
    private Bitmap mBitmap;
    private OnBitmapChangeListener mBitmapChangeListener;
    private boolean mChanged;
    private Configuration mConfiguration;
    private FeatherContext mContext;
    private AbstractPanel mCurrentEffect;
    private ToolEntry mCurrentEntry;
    private int mCurrentState;
    private DragLayer mDragLayer;
    private final Handler mHandler;
    private List mHiresListeners;
    private Bitmap mOriginalBitmap;
    private AbstractPanelLoaderService mPanelCreatorService;
    private final ServiceLoader mServiceLoader = new ServiceLoader(this);
    private int mToolCompleteCount;
    private List mToolList;

    public AviaryMainController(FeatherContext feathercontext, Handler handler)
    {
        logger = LoggerFactory.getLogger("AviaryMainController", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
        mContext = feathercontext;
        mHandler = handler;
        mToolCompleteCount = 0;
        mHiresListeners = new ArrayList(0);
        mConfiguration = new Configuration(((Context)feathercontext).getResources().getConfiguration());
        initServices(feathercontext);
        setCurrentState(0);
        mChanged = false;
    }

    private void initHiResService(Bitmap bitmap, ImageInfo imageinfo)
    {
        logger.info("initHiResService");
        LocalDataService localdataservice = (LocalDataService)getService(com/aviary/android/feather/library/services/LocalDataService);
        Object obj = (HiResBackgroundService)getService(com/aviary/android/feather/library/services/HiResBackgroundService);
        if (bitmap != null && imageinfo != null && imageinfo.getOriginalSize() != null && imageinfo.getOriginalSize().length == 2)
        {
            logger.log("original size: %dx%d", new Object[] {
                Integer.valueOf(imageinfo.getOriginalSize()[0]), Integer.valueOf(imageinfo.getOriginalSize()[1])
            });
            logger.log("bitmap size: %dx%d", new Object[] {
                Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())
            });
        }
        if (!((HiResBackgroundService) (obj)).isRunning())
        {
            ((HiResBackgroundService) (obj)).setOnHiresListener(this);
        }
        obj = (SessionService)getService(com/aviary/android/feather/library/services/SessionService);
        if (!((SessionService) (obj)).isRunning())
        {
            ((SessionService) (obj)).start();
        }
        ((SessionService) (obj)).load(bitmap, localdataservice.getRequestedMegaPixels(), imageinfo);
    }

    private void initServices(FeatherContext feathercontext)
    {
        this;
        JVM INSTR monitorenter ;
        logger.info("initServices");
        mServiceLoader.register(com/aviary/android/feather/library/services/SessionService);
        mServiceLoader.register(com/aviary/android/feather/library/services/LocalDataService);
        mServiceLoader.register(com/aviary/android/feather/library/services/ThreadPoolService);
        mServiceLoader.register(com/aviary/android/feather/library/services/ConfigService);
        mServiceLoader.register(com/aviary/android/feather/library/services/IAPService);
        mServiceLoader.register(com/aviary/android/feather/library/services/BadgeService);
        mServiceLoader.register(com/aviary/android/feather/library/services/HiResBackgroundService);
        mServiceLoader.register(com/aviary/android/feather/library/services/DragControllerService);
        mServiceLoader.register(com/aviary/android/feather/library/services/PreferenceService);
        mServiceLoader.register(com/aviary/android/feather/sdk/panels/AbstractPanelLoaderService);
        this;
        JVM INSTR monitorexit ;
        return;
        feathercontext;
        throw feathercontext;
    }

    private void onClose(final boolean isConfirmed)
    {
        logger.info("onClose");
        setCurrentState(3);
        mContext.getBottomBar().addOnViewChangingStatusListener(new com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper.OnViewChangingStatusListener() {

            final AviaryMainController this$0;
            final boolean val$isConfirmed;

            public void onCloseEnd()
            {
                AviaryMainController aviarymaincontroller = AviaryMainController.this;
                byte byte0;
                if (isConfirmed)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 5;
                }
                aviarymaincontroller.setCurrentState(byte0);
                mContext.getBottomBar().removeOnViewChangingStatusListener(this);
            }

            public void onCloseStart()
            {
                mCurrentEffect.onClosing();
            }

            public void onOpenEnd()
            {
            }

            public void onOpenStart()
            {
            }

            
            {
                this$0 = AviaryMainController.this;
                isConfirmed = flag;
                super();
            }
        });
        mContext.getBottomBar().close();
    }

    private void prepareToolPanel(AbstractPanel abstractpanel, ToolEntry toolentry, Bundle bundle)
    {
        if (abstractpanel instanceof com.aviary.android.feather.sdk.panels.AbstractPanel.OptionPanel)
        {
            toolentry = ((com.aviary.android.feather.sdk.panels.AbstractPanel.OptionPanel)abstractpanel).getOptionView(LayoutInflater.from((Context)mContext), mContext.getOptionsPanelContainer());
            mContext.getOptionsPanelContainer().addView(toolentry);
        }
        if (abstractpanel instanceof com.aviary.android.feather.sdk.panels.AbstractPanel.ContentPanel)
        {
            toolentry = ((com.aviary.android.feather.sdk.panels.AbstractPanel.ContentPanel)abstractpanel).getContentView(LayoutInflater.from((Context)mContext));
            toolentry.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
            mContext.getDrawingImageContainer().addView(toolentry);
        }
        abstractpanel.onCreate(mBitmap, bundle);
    }

    private void setCurrentState(int i)
    {
        if (i == mCurrentState) goto _L2; else goto _L1
_L1:
        int j;
        logger.info("setcurrentState: %s >> %s", new Object[] {
            Integer.valueOf(mCurrentState), Integer.valueOf(i)
        });
        j = mCurrentState;
        mCurrentState = i;
        i;
        JVM INSTR tableswitch 0 5: default 92
    //                   0 361
    //                   1 105
    //                   2 175
    //                   3 217
    //                   4 278
    //                   5 278;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L8
_L7:
        break MISSING_BLOCK_LABEL_217;
_L8:
        break MISSING_BLOCK_LABEL_278;
_L4:
        break MISSING_BLOCK_LABEL_361;
_L3:
        logger.error("Invalid state");
_L2:
        return;
_L5:
        mCurrentEffect.setOnPreviewListener(this);
        mCurrentEffect.setOnApplyResultListener(this);
        mCurrentEffect.setOnErrorListener(this);
        mCurrentEffect.setOnProgressListener(this);
        if (mCurrentEffect instanceof com.aviary.android.feather.sdk.panels.AbstractPanel.ContentPanel)
        {
            ((com.aviary.android.feather.sdk.panels.AbstractPanel.ContentPanel)mCurrentEffect).setOnReadyListener(this);
        }
        mHandler.obtainMessage(10, i, j).sendToTarget();
        return;
_L6:
        mCurrentEffect.onActivate();
        mHandler.obtainMessage(10, i, j).sendToTarget();
        if (mCurrentEffect instanceof com.aviary.android.feather.sdk.panels.AbstractPanel.ContentPanel) goto _L2; else goto _L9
_L9:
        mHandler.sendEmptyMessage(6);
        return;
        mHandler.obtainMessage(10, i, j).sendToTarget();
        mCurrentEffect.onDeactivate();
        if (mCurrentEffect instanceof com.aviary.android.feather.sdk.panels.AbstractPanel.ContentPanel)
        {
            ((com.aviary.android.feather.sdk.panels.AbstractPanel.ContentPanel)mCurrentEffect).setOnReadyListener(null);
        }
        mHandler.post(new Runnable() {

            final AviaryMainController this$0;

            public void run()
            {
                mContext.getDrawingImageContainer().removeAllViews();
                mContext.deactivatePopupContainer();
            }

            
            {
                this$0 = AviaryMainController.this;
                super();
            }
        });
        return;
        mContext.getOptionsPanelContainer().removeAllViews();
        if (j != 0)
        {
            mCurrentEffect.onDestroy();
            mCurrentEffect.setOnPreviewListener(null);
            mCurrentEffect.setOnApplyResultListener(null);
            mCurrentEffect.setOnErrorListener(null);
            mCurrentEffect.setOnProgressListener(null);
            mCurrentEffect = null;
            mCurrentEntry = null;
        }
        mHandler.obtainMessage(10, i, j).sendToTarget();
        System.gc();
        return;
        mHandler.obtainMessage(10, i, j).sendToTarget();
        return;
    }

    private void showUndoRedoToolTip(int i)
    {
        DisplayMetrics displaymetrics = getBaseActivity().getResources().getDisplayMetrics();
        TooltipManager.getInstance(getBaseActivity()).remove(0);
        TooltipManager.getInstance(getBaseActivity()).create(0).withCustomView(R.layout.aviary_default_tooltip, false).closePolicy(it.sephiroth.android.library.tooltip.TooltipManager.ClosePolicy.None, 1000L).text(getBaseContext().getResources(), i).withStyleId(R.style.AviaryUndoTooltip).actionBarSize(mContext.getActionBarSize()).toggleArrow(false).anchor(new Point(displaymetrics.widthPixels / 2, 90), it.sephiroth.android.library.tooltip.TooltipManager.Gravity.BOTTOM).show();
    }

    public static String stateToString(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 5: // '\005'
            return "closed_cancel";

        case 4: // '\004'
            return "closed_confirmed";

        case 3: // '\003'
            return "closing";

        case 2: // '\002'
            return "opened";

        case 0: // '\0'
            return "disabled";

        case 1: // '\001'
            return "opening";
        }
    }

    public void activateTool(ToolEntry toolentry)
    {
        activateTool(toolentry, null);
    }

    public void activateTool(ToolEntry toolentry, Bundle bundle)
    {
        if (getEnabled() && isClosed() && mBitmap != null && (mToolList == null || mToolList.indexOf(toolentry.name.name()) >= 0))
        {
            if (mCurrentEffect != null)
            {
                throw new IllegalStateException("There is already an active effect. Cannot activate new");
            }
            if (mPanelCreatorService == null)
            {
                mPanelCreatorService = (AbstractPanelLoaderService)getService(com/aviary/android/feather/sdk/panels/AbstractPanelLoaderService);
            }
            AbstractPanel abstractpanel = mPanelCreatorService.createNew(toolentry);
            if (abstractpanel != null)
            {
                mCurrentEffect = abstractpanel;
                mCurrentEntry = toolentry;
                ((BadgeService)getService(com/aviary/android/feather/library/services/BadgeService)).markAsRead(toolentry.name);
                setCurrentState(1);
                prepareToolPanel(abstractpanel, toolentry, bundle);
                getTracker().tagEvent((new StringBuilder()).append(mCurrentEntry.name.name().toLowerCase(Locale.US)).append(": opened").toString());
                mContext.getBottomBar().addOnViewChangingStatusListener(new com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper.OnViewChangingStatusListener() {

                    final AviaryMainController this$0;

                    public void onCloseEnd()
                    {
                    }

                    public void onCloseStart()
                    {
                    }

                    public void onOpenEnd()
                    {
                        setCurrentState(2);
                        mContext.getBottomBar().removeOnViewChangingStatusListener(this);
                    }

                    public void onOpenStart()
                    {
                        mCurrentEffect.onOpening();
                    }

            
            {
                this$0 = AviaryMainController.this;
                super();
            }
                });
                mContext.getBottomBar().open();
                return;
            }
        }
    }

    public void addOnHiresListener(com.aviary.android.feather.library.services.HiResBackgroundService.OnHiresListener onhireslistener)
    {
        mHiresListeners.add(onhireslistener);
    }

    public void cancel()
    {
        logger.info("FilterManager::cancel");
        if (!getEnabled() || !isOpened())
        {
            return;
        }
        if (mCurrentEffect == null)
        {
            throw new IllegalStateException("there is no current effect active in the context");
        }
        mContext.getTracker().tagEvent((new StringBuilder()).append(mCurrentEntry.name.name().toLowerCase(Locale.US)).append(": cancelled").toString());
        mCurrentEffect.onCancelled();
        if (mCurrentEffect.getIsChanged())
        {
            setNextBitmap(mBitmap, true);
        } else
        {
            setNextBitmap(mBitmap, true);
        }
        onClose(false);
    }

    public void dispose()
    {
        if (mCurrentEffect != null)
        {
            logger.log("Deactivate and destroy current panel");
            mCurrentEffect.onDeactivate();
            mCurrentEffect.onDestroy();
            mCurrentEffect = null;
        }
        HiResBackgroundService hiresbackgroundservice = (HiResBackgroundService)getService(com/aviary/android/feather/library/services/HiResBackgroundService);
        if (hiresbackgroundservice != null)
        {
            hiresbackgroundservice.setOnHiresListener(null);
        }
        mServiceLoader.dispose();
        mContext = null;
        mBitmapChangeListener = null;
        System.gc();
    }

    public ToolEntry getActiveTool()
    {
        return mCurrentEntry;
    }

    public AbstractPanel getActiveToolPanel()
    {
        return mCurrentEffect;
    }

    public boolean getAppIsUpdated()
    {
        if (mAppIsUpdated == null)
        {
            PreferenceService preferenceservice = (PreferenceService)getService(com/aviary/android/feather/library/services/PreferenceService);
            if (preferenceservice != null)
            {
                PackageInfo packageinfo = PackageManagerUtils.getPackageInfo(getBaseContext());
                int i;
                int j;
                if (packageinfo != null)
                {
                    i = packageinfo.versionCode;
                } else
                {
                    i = 380;
                }
                j = preferenceservice.getInt("aviary-package-version", 0);
                logger.info((new StringBuilder()).append("registered version: ").append(j).append(", my version: ").append(i).toString());
                if (j != i)
                {
                    mAppIsUpdated = Boolean.valueOf(true);
                    preferenceservice.putInt("aviary-package-version", i);
                } else
                {
                    mAppIsUpdated = Boolean.valueOf(false);
                }
            } else
            {
                logger.error("can't open preferenceService");
                mAppIsUpdated = Boolean.valueOf(false);
            }
        }
        return mAppIsUpdated.booleanValue();
    }

    public Activity getBaseActivity()
    {
        return (Activity)mContext;
    }

    public Context getBaseContext()
    {
        return (Context)mContext;
    }

    public Bitmap getBitmap()
    {
        return mBitmap;
    }

    public boolean getBitmapIsChanged()
    {
        return mChanged;
    }

    public boolean getBitmapIsChangedOrChanging()
    {
        while (mChanged || mCurrentEffect != null && mCurrentEffect.isActive() && mCurrentEffect.getIsChanged()) 
        {
            return true;
        }
        return false;
    }

    public Matrix getCurrentImageViewMatrix()
    {
        return mContext.getMainImage().getDisplayMatrix();
    }

    public DragLayer getDragLayer()
    {
        return mDragLayer;
    }

    public boolean getEnabled()
    {
        return mCurrentState != 0;
    }

    public Bitmap getOriginalBitmap()
    {
        return mOriginalBitmap;
    }

    public boolean getPanelIsRendering()
    {
        if (mCurrentEffect != null && mCurrentEffect.isActive())
        {
            return mCurrentEffect.isRendering();
        } else
        {
            return false;
        }
    }

    public Object getService(Class class1)
    {
        try
        {
            class1 = mServiceLoader.getService(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        return class1;
    }

    public int getToolCompleteCount()
    {
        return mToolCompleteCount;
    }

    protected List getToolList()
    {
        return mToolList;
    }

    public AviaryTracker getTracker()
    {
        return mContext.getTracker();
    }

    public boolean isClosed()
    {
        return mCurrentState == 5 || mCurrentState == 4;
    }

    public boolean isOpened()
    {
        return mCurrentState == 2;
    }

    public boolean isToolActive()
    {
        return mCurrentEffect != null;
    }

    public void onActivate(Bitmap bitmap, ImageInfo imageinfo)
    {
        if (mCurrentState != 0)
        {
            throw new IllegalStateException("Cannot activate. Already active!");
        }
        if (mBitmap != null && !mBitmap.isRecycled())
        {
            mBitmap = null;
        }
        mBitmap = bitmap;
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            mOriginalBitmap = BitmapUtils.copy(mBitmap, mBitmap.getConfig());
        }
        ((LocalDataService)getService(com/aviary/android/feather/library/services/LocalDataService)).setImageInfo(imageinfo);
        mChanged = false;
        setCurrentState(4);
        initHiResService(bitmap, imageinfo);
    }

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        IAPService iapservice;
        iapservice = (IAPService)getService(com/aviary/android/feather/library/services/IAPService);
        if (iapservice == null || i != IAPService.PURCHASE_FLOW_REQUEST_CODE)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        boolean flag = iapservice.handleActivityResult(i, j, intent);
        return flag;
        intent;
        logger.error("handled exception");
        intent.printStackTrace();
        return false;
    }

    public void onApply()
    {
        logger.info("FilterManager::onapply");
        if (getEnabled() && isOpened())
        {
            if (mCurrentEffect == null)
            {
                throw new IllegalStateException("there is no current effect active in the context");
            }
            if (mCurrentEffect.isEnabled())
            {
                if (mCurrentEffect.getIsChanged())
                {
                    mCurrentEffect.onSave();
                    mChanged = true;
                    return;
                } else
                {
                    onCancel();
                    return;
                }
            }
        }
    }

    public boolean onBackPressed()
    {
        while (isClosed() || mCurrentState == 0) 
        {
            return false;
        }
        if (isOpened() && !mCurrentEffect.onBackPressed())
        {
            if (mCurrentEffect.getIsChanged())
            {
                onSave();
                mChanged = true;
            }
            onCancel();
        }
        return true;
    }

    public void onCancel()
    {
        if (getEnabled() && isOpened())
        {
            if (mCurrentEffect == null)
            {
                throw new IllegalStateException("there is no current effect active in the context");
            }
            if (!mCurrentEffect.onCancel())
            {
                cancel();
                return;
            }
        }
    }

    public void onComplete(Bitmap bitmap, EditToolResultVO edittoolresultvo)
    {
        mToolCompleteCount = mToolCompleteCount + 1;
        if (bitmap != null)
        {
            setNextBitmap(bitmap, true);
        } else
        {
            logger.error("Error: returned bitmap is null!");
            setNextBitmap(mBitmap, true);
        }
        onClose(true);
        if (edittoolresultvo != null)
        {
            if (!edittoolresultvo.valid())
            {
                logger.error("editResult is not valid!");
            }
            LocalDataService localdataservice = (LocalDataService)getService(com/aviary/android/feather/library/services/LocalDataService);
            if (localdataservice != null)
            {
                localdataservice.addRecipe(edittoolresultvo.getEditTool());
            }
            if (edittoolresultvo.getActionList() != null && edittoolresultvo.getActionList().size() > 0)
            {
                ((SessionService)getService(com/aviary/android/feather/library/services/SessionService)).push(bitmap, edittoolresultvo);
                if (ApiHelper.isUndoRedoAvailable() && AviaryOverlay.shouldShow(this, 5))
                {
                    (new UndoRedoOverlay(getBaseContext(), R.style.AviaryWidget_Overlay_UndoRedo)).showDelayed(400L);
                }
                return;
            } else
            {
                logger.error("actionlist is missing!");
                return;
            }
        } else
        {
            logger.error("Something was wrong, edit result is null!");
            return;
        }
    }

    public boolean onConfigurationChanged(Configuration configuration)
    {
        boolean flag1 = false;
        logger.info((new StringBuilder()).append("onConfigurationChanged: ").append(configuration.orientation).append(", ").append(mConfiguration.orientation).toString());
        boolean flag = flag1;
        if (mCurrentEffect != null)
        {
            flag = flag1;
            if (mCurrentEffect.isCreated())
            {
                logger.info("onConfigurationChanged, sending event to ", new Object[] {
                    mCurrentEffect
                });
                mCurrentEffect.onConfigurationChanged(configuration, mConfiguration);
                flag = true;
            }
        }
        mConfiguration = new Configuration(configuration);
        return flag;
    }

    public void onError(CharSequence charsequence, int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        (new android.app.AlertDialog.Builder((Activity)mContext)).setTitle(R.string.feather_generic_error_title).setMessage(charsequence).setPositiveButton(i, onclicklistener).setIcon(0x1080027).show();
    }

    public void onError(CharSequence charsequence, int i, android.content.DialogInterface.OnClickListener onclicklistener, int j, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        (new android.app.AlertDialog.Builder((Activity)mContext)).setTitle(R.string.feather_generic_error_title).setMessage(charsequence).setPositiveButton(i, onclicklistener).setNegativeButton(j, onclicklistener1).setIcon(0x1080027).show();
    }

    public void onHiresComplete()
    {
        logger.info("onHiresComplete");
        for (Iterator iterator = mHiresListeners.iterator(); iterator.hasNext(); ((com.aviary.android.feather.library.services.HiResBackgroundService.OnHiresListener)iterator.next()).onHiresComplete()) { }
    }

    public void onHiresError(AviaryExecutionException aviaryexecutionexception)
    {
        logger.info((new StringBuilder()).append("onHiresError: ").append(aviaryexecutionexception).toString());
        for (Iterator iterator = mHiresListeners.iterator(); iterator.hasNext(); ((com.aviary.android.feather.library.services.HiResBackgroundService.OnHiresListener)iterator.next()).onHiresError(aviaryexecutionexception)) { }
    }

    public void onHiresProgress(int i, int j)
    {
        logger.info("onHiresProgress: %d of %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        for (Iterator iterator = mHiresListeners.iterator(); iterator.hasNext(); ((com.aviary.android.feather.library.services.HiResBackgroundService.OnHiresListener)iterator.next()).onHiresProgress(i, j)) { }
    }

    public void onMessage(CharSequence charsequence, CharSequence charsequence1, int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        (new android.app.AlertDialog.Builder((Activity)mContext)).setTitle(charsequence).setMessage(charsequence1).setIcon(0x108009b).setPositiveButton(i, onclicklistener).show();
    }

    public void onMessage(CharSequence charsequence, CharSequence charsequence1, int i, android.content.DialogInterface.OnClickListener onclicklistener, int j, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        (new android.app.AlertDialog.Builder((Activity)mContext)).setTitle(charsequence).setMessage(charsequence1).setPositiveButton(i, onclicklistener).setNegativeButton(j, onclicklistener1).setIcon(0x108009b).show();
    }

    public void onPreviewChange(Bitmap bitmap, boolean flag)
    {
        while (!getEnabled() || !isOpened() || mBitmapChangeListener == null) 
        {
            return;
        }
        mBitmapChangeListener.onPreviewChange(bitmap, flag);
    }

    public void onPreviewChange(Drawable drawable, boolean flag)
    {
        while (!getEnabled() || !isOpened() || mBitmapChangeListener == null) 
        {
            return;
        }
        mBitmapChangeListener.onPreviewChange(drawable, flag);
    }

    public void onPreviewUpdated()
    {
        while (!getEnabled() || !isOpened() || mBitmapChangeListener == null) 
        {
            return;
        }
        mBitmapChangeListener.onInvalidateBitmap();
    }

    public void onProgressEnd()
    {
        mContext.hideToolProgress();
    }

    public void onProgressModalEnd()
    {
        mContext.hideModalProgress();
    }

    public void onProgressModalStart()
    {
        mContext.showModalProgress();
    }

    public void onProgressStart()
    {
        mContext.showToolProgress();
    }

    public void onReady(AbstractPanel abstractpanel)
    {
        mHandler.sendEmptyMessage(5);
        mHandler.sendEmptyMessage(6);
    }

    public void onRedo()
    {
        logger.info("onRedo");
        Object obj;
        if (getEnabled() && mCurrentEffect == null)
        {
            if (((SessionService) (obj = (SessionService)getService(com/aviary/android/feather/library/services/SessionService))).canRedo() && (obj = ((SessionService) (obj)).redo()) != null)
            {
                setNextBitmap(((Bitmap) (obj)), true);
                showUndoRedoToolTip(R.string.feather_redo);
                getTracker().tagEvent("editor: redo");
                return;
            }
        }
    }

    public void onRestoreOriginal()
    {
        logger.info("onRestoreOriginal");
        break MISSING_BLOCK_LABEL_12;
        if (getEnabled() && mOriginalBitmap != null)
        {
            Bitmap bitmap = BitmapUtils.copy(mOriginalBitmap, mOriginalBitmap.getConfig());
            SessionService sessionservice = (SessionService)getService(com/aviary/android/feather/library/services/SessionService);
            LocalDataService localdataservice = (LocalDataService)getService(com/aviary/android/feather/library/services/LocalDataService);
            sessionservice.clearAll();
            sessionservice.load(bitmap, localdataservice.getRequestedMegaPixels(), localdataservice.getImageInfo());
            setNextBitmap(bitmap, true, null);
            mChanged = false;
            if (mCurrentEffect != null)
            {
                mCurrentEffect.onBitmapReplaced(bitmap);
                return;
            }
        }
        return;
    }

    public void onSave()
    {
        if (getEnabled())
        {
            if (isClosed());
        }
    }

    public void onUndo()
    {
        logger.info("onUndo");
        if (getEnabled() && (mCurrentEffect == null || FeatherActivity.MATURITY.isKidsFriendly())) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SessionService sessionservice;
        Bitmap bitmap;
        if (FeatherActivity.MATURITY.isKidsFriendly() && mCurrentEffect != null)
        {
            onApply();
        }
        sessionservice = (SessionService)getService(com/aviary/android/feather/library/services/SessionService);
        if (!sessionservice.canUndo())
        {
            continue; /* Loop/switch isn't completed */
        }
        bitmap = sessionservice.undo();
        if (bitmap == null) goto _L1; else goto _L3
_L3:
        setNextBitmap(bitmap, true);
        showUndoRedoToolTip(R.string.feather_undo);
        if (mCurrentEffect != null)
        {
            mCurrentEffect.onBitmapReplaced(bitmap);
        }
        if (!sessionservice.canUndo())
        {
            mChanged = false;
        }
        getTracker().tagEvent("editor: undo");
        return;
        if (!sessionservice.canRedo()) goto _L1; else goto _L4
_L4:
        showUndoRedoToolTip(R.string.feather_cant_undo_anymore);
        return;
    }

    public void registerService(Class class1)
    {
        mServiceLoader.register(class1);
    }

    public boolean removeOnHiresListener(com.aviary.android.feather.library.services.HiResBackgroundService.OnHiresListener onhireslistener)
    {
        return mHiresListeners.remove(onhireslistener);
    }

    public void removeService(Class class1)
    {
        mServiceLoader.remove(class1);
    }

    public void restoreToolbarTitle()
    {
        if (mCurrentEntry != null)
        {
            Message message = mHandler.obtainMessage(101, mCurrentEntry.labelResourceId, 0);
            mHandler.sendMessage(message);
        }
    }

    public void runOnUiThread(Runnable runnable)
    {
        if (mContext != null)
        {
            ((Activity)mContext).runOnUiThread(runnable);
        }
    }

    public void setDragLayer(DragLayer draglayer)
    {
        mDragLayer = draglayer;
    }

    public void setEnabled(boolean flag)
    {
label0:
        {
            if (!flag)
            {
                if (!isClosed())
                {
                    break label0;
                }
                setCurrentState(0);
            }
            return;
        }
        logger.warn("FilterManager must be closed to change state");
    }

    void setNextBitmap(Bitmap bitmap)
    {
        setNextBitmap(bitmap, true);
    }

    void setNextBitmap(Bitmap bitmap, boolean flag)
    {
        setNextBitmap(bitmap, flag, null);
    }

    void setNextBitmap(Bitmap bitmap, boolean flag, Matrix matrix)
    {
        logger.log("setNextBitmap", new Object[] {
            bitmap, Boolean.valueOf(flag), matrix
        });
        if (mBitmapChangeListener != null)
        {
            mBitmapChangeListener.onBitmapChange(bitmap, flag, matrix);
        }
        if (!mBitmap.equals(bitmap) && !mBitmap.isRecycled())
        {
            logger.warn((new StringBuilder()).append("[recycle] original Bitmap: ").append(mBitmap).toString());
            mBitmap.recycle();
            mBitmap = null;
        }
        mBitmap = bitmap;
    }

    public void setOnBitmapChangeListener(OnBitmapChangeListener onbitmapchangelistener)
    {
        mBitmapChangeListener = onbitmapchangelistener;
    }

    public void setPanelApplyStatusEnabled(boolean flag)
    {
        Object obj = mHandler;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj = ((Handler) (obj)).obtainMessage(102, i, 0);
        mHandler.sendMessage(((Message) (obj)));
    }

    protected void setToolList(List list)
    {
        mToolList = list;
    }

    public void setToolbarTitle(int i)
    {
        Message message = mHandler.obtainMessage(101, i, 0);
        mHandler.sendMessage(message);
    }

    public void setToolbarTitle(CharSequence charsequence)
    {
        charsequence = mHandler.obtainMessage(100, charsequence);
        mHandler.sendMessage(charsequence);
    }



}
