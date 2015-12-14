// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ColdBootProgressEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.messaging.TagAutoSaveChangedEvent;
import com.amazon.gallery.framework.gallery.messaging.UploadStatusContentFetcher;
import com.amazon.gallery.framework.kindle.AutoSaveManagerImpl;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.exceptions.CloudStorageLimitException;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadActionEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadBatchFactory;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadError;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadListener;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadListenerEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStatus;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStatusEvent;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.ui.UiReadyExecutor;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AndroidNavigationUploadView extends LinearLayout
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener, UploadListener
{
    private static class AsyncCounterUpdate extends AsyncTask
    {

        private final WeakReference contextReference;
        private final AtomicBoolean isUpdatingInProgress;
        private final MediaItemDao mediaItemDao;
        private final TagDao tagDao;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            int i;
            int j;
            long l = SystemClock.uptimeMillis();
            i = mediaItemDao.getAutosaveableMediaItemCount(false);
            j = mediaItemDao.getAutosaveableMediaItemCount(true);
            GLogger.d(AndroidNavigationUploadView.TAG, "Async counter update completed in %dms", new Object[] {
                Long.valueOf(SystemClock.uptimeMillis() - l)
            });
            avoid = (Context)contextReference.get();
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            PreferenceManager.getDefaultSharedPreferences(avoid).edit().putInt("auto_save_count", i).putInt("unuploaded_auto_save_count", j).putLong("last_counter_update", SystemClock.uptimeMillis()).commit();
            isUpdatingInProgress.set(false);
            return null;
            avoid;
            isUpdatingInProgress.set(false);
            throw avoid;
        }

        AsyncCounterUpdate(Context context, MediaItemDao mediaitemdao, TagDao tagdao, AtomicBoolean atomicboolean)
        {
            contextReference = new WeakReference(context);
            mediaItemDao = mediaitemdao;
            tagDao = tagdao;
            isUpdatingInProgress = atomicboolean;
        }
    }

    private static final class ViewState extends Enum
    {

        private static final ViewState $VALUES[];
        public static final ViewState PAUSED;
        public static final ViewState REST;
        public static final ViewState SYNCING;
        public static final ViewState UPLOADING;
        private int priority;

        public static ViewState valueOf(String s)
        {
            return (ViewState)Enum.valueOf(com/amazon/gallery/thor/widget/AndroidNavigationUploadView$ViewState, s);
        }

        public static ViewState[] values()
        {
            return (ViewState[])$VALUES.clone();
        }

        boolean isHigherPriority(ViewState viewstate)
        {
            return priority < viewstate.priority;
        }

        static 
        {
            SYNCING = new ViewState("SYNCING", 0, 0);
            UPLOADING = new ViewState("UPLOADING", 1, 1);
            REST = new ViewState("REST", 2, 2);
            PAUSED = new ViewState("PAUSED", 3, 2);
            $VALUES = (new ViewState[] {
                SYNCING, UPLOADING, REST, PAUSED
            });
        }

        private ViewState(String s, int i, int j)
        {
            super(s, i);
            priority = j;
        }
    }


    private static final long COUNTER_UPDATE_GRACE_PERIOD;
    private static final String TAG = com/amazon/gallery/thor/widget/AndroidNavigationUploadView.getName();
    private Animator animator;
    private int autoSaveCount;
    private TextView bottomTextView;
    private QueueType currentQueueType;
    private SimpleDateFormat dateFormatter;
    private SharedPreferences defaultPrefs;
    private final Interpolator interpolator;
    private final AtomicBoolean isUpdatingInProgress;
    private SharedPreferences kindlePrefs;
    private MediaItemDao mediaItemDao;
    private ProgressBar progressBar;
    private TagDao tagDao;
    private TextView topTextView;
    private UiReadyExecutor uiReadyExecutor;
    private int unuploadedAutoSaveCount;
    private UploadStatus uploadStatus;
    private ViewState viewState;

    public AndroidNavigationUploadView(Context context)
    {
        super(context);
        interpolator = new LinearInterpolator();
        isUpdatingInProgress = new AtomicBoolean(false);
        currentQueueType = null;
        autoSaveCount = 0;
        unuploadedAutoSaveCount = 0;
        init(context);
    }

    public AndroidNavigationUploadView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0);
        interpolator = new LinearInterpolator();
        isUpdatingInProgress = new AtomicBoolean(false);
        currentQueueType = null;
        autoSaveCount = 0;
        unuploadedAutoSaveCount = 0;
        init(context);
    }

    private void animateProgress(int i, long l)
    {
        animateProgress(i, l, null);
    }

    private void animateProgress(int i, long l, android.animation.Animator.AnimatorListener animatorlistener)
    {
        animator = ObjectAnimator.ofInt(progressBar, "progress", new int[] {
            i
        }).setDuration(l);
        animator.setInterpolator(interpolator);
        if (animatorlistener != null)
        {
            animator.addListener(animatorlistener);
        }
        animator.start();
    }

    private UploadStatus getUploadStatus()
    {
        UploadStatusEvent uploadstatusevent = (UploadStatusEvent)(new UploadStatusContentFetcher()).getContentFromProducer();
        if (uploadstatusevent != null)
        {
            if (!uploadstatusevent.getUploadStatus(QueueType.AUTO_SAVE).isUploadComplete())
            {
                currentQueueType = QueueType.AUTO_SAVE;
                return uploadstatusevent.getUploadStatus(QueueType.AUTO_SAVE);
            }
            if (!uploadstatusevent.getUploadStatus(QueueType.MANUAL).isUploadComplete())
            {
                currentQueueType = QueueType.MANUAL;
                return uploadstatusevent.getUploadStatus(QueueType.MANUAL);
            }
        }
        return null;
    }

    private boolean hasColdBooted()
    {
        return kindlePrefs.getBoolean("coldBootStatus", false);
    }

    private void init(Context context)
    {
        mediaItemDao = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        tagDao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        uiReadyExecutor = (UiReadyExecutor)ThorGalleryApplication.getBean(Keys.UI_READY_EXECUTOR);
        defaultPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        kindlePrefs = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
        dateFormatter = new SimpleDateFormat("h:mm aa");
        dateFormatter.setTimeZone(TimeZone.getDefault());
        LayoutInflater.from(context).inflate(0x7f0300ae, this, true);
        progressBar = (ProgressBar)findViewById(0x7f0c0187);
        topTextView = (TextView)findViewById(0x7f0c0188);
        bottomTextView = (TextView)findViewById(0x7f0c0189);
        setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(16);
        autoSaveCount = defaultPrefs.getInt("auto_save_count", 0);
        unuploadedAutoSaveCount = defaultPrefs.getInt("unuploaded_auto_save_count", 0);
    }

    private void initViewState()
    {
        uploadStatus = getUploadStatus();
        if (!kindlePrefs.getBoolean("coldBootStatus", false))
        {
            updateViewState(ViewState.SYNCING, true);
        } else
        if (uploadStatus != null)
        {
            if (uploadStatus.isInErrorMode())
            {
                updateViewState(ViewState.PAUSED);
                return;
            }
            if (!uploadStatus.isUploadComplete())
            {
                updateViewState(ViewState.UPLOADING);
                return;
            }
        } else
        {
            updateCountersAsync(false);
            updateViewState(ViewState.REST);
            return;
        }
    }

    private boolean isAutoSaveOn()
    {
        return AutoSaveManagerImpl.isAutoSaveEnabled(defaultPrefs, MediaType.PHOTO) || AutoSaveManagerImpl.isAutoSaveEnabled(defaultPrefs, MediaType.VIDEO);
    }

    private boolean isQueueTypeAllowed(QueueType queuetype)
    {
        boolean flag = false;
        if (currentQueueType == null)
        {
            currentQueueType = queuetype;
            flag = true;
        } else
        if (currentQueueType == queuetype)
        {
            return true;
        }
        return flag;
    }

    private void setChildVisibility(final View view, final int visibility)
    {
        post(new Runnable() {

            final AndroidNavigationUploadView this$0;
            final View val$view;
            final int val$visibility;

            public void run()
            {
                view.setVisibility(visibility);
            }

            
            {
                this$0 = AndroidNavigationUploadView.this;
                view = view1;
                visibility = i;
                super();
            }
        });
    }

    private void setChildrenVisibility(int i)
    {
        for (int j = 0; j < getChildCount(); j++)
        {
            setChildVisibility(getChildAt(j), i);
        }

    }

    private void setText(final TextView view, final String text)
    {
        post(new Runnable() {

            final AndroidNavigationUploadView this$0;
            final String val$text;
            final TextView val$view;

            public void run()
            {
                view.setText(text);
            }

            
            {
                this$0 = AndroidNavigationUploadView.this;
                view = textview;
                text = s;
                super();
            }
        });
    }

    private void setUploadStatus(UploadStatus uploadstatus)
    {
        uploadStatus = uploadstatus;
    }

    private void switchToPausedState()
    {
        String s1;
        Resources resources;
        resources = getResources();
        TextView textview = topTextView;
        static class _cls5
        {

            static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[];
            static final int $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError = new int[UploadError.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_NETWORK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_WIFI.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.LOW_BATTERY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_POWER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_SPACE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.ACCOUNT_CHANGED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNREGISTERED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UPLOAD_DISABLED.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNKNOWN_ERROR.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_ERROR.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState = new int[ViewState.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[ViewState.UPLOADING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[ViewState.REST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[ViewState.PAUSED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$AndroidNavigationUploadView$ViewState[ViewState.SYNCING.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        int i;
        if (isAutoSaveOn())
        {
            i = 0x7f0e00ec;
        } else
        {
            i = 0x7f0e00eb;
        }
        setText(textview, resources.getString(i));
        s1 = "";
        _cls5..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadError[uploadStatus.getUploadError().ordinal()];
        JVM INSTR tableswitch 1 5: default 84
    //                   1 101
    //                   2 137
    //                   3 148
    //                   4 159
    //                   5 170;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        updateViewState(ViewState.REST, true);
        return;
_L2:
        String s = resources.getString(0x7f0e00e6);
_L8:
        setText(bottomTextView, s);
        setChildVisibility(topTextView, 0);
        setChildVisibility(bottomTextView, 0);
        return;
_L3:
        s = resources.getString(0x7f0e00e8);
        continue; /* Loop/switch isn't completed */
_L4:
        s = resources.getString(0x7f0e00e5);
        continue; /* Loop/switch isn't completed */
_L5:
        s = resources.getString(0x7f0e00e9);
        continue; /* Loop/switch isn't completed */
_L6:
        boolean flag = uploadStatus.hasAtLeastOneBatchFailed(UploadBatchFactory.VIDEO_BATCHES);
        boolean flag1 = uploadStatus.hasAtLeastOneBatchFailed(UploadBatchFactory.PHOTO_BATCHES);
        if (flag && !flag1)
        {
            s = resources.getString(0x7f0e00ea);
        } else
        {
            s = s1;
            if (flag1)
            {
                s = s1;
                if (flag)
                {
                    s = resources.getString(0x7f0e00e7);
                }
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void switchToRestState()
    {
        Resources resources = getResources();
        if (!isAutoSaveOn())
        {
            setText(bottomTextView, resources.getString(0x7f0e00eb));
            setChildVisibility(topTextView, 8);
        } else
        if (autoSaveCount == 0)
        {
            setText(bottomTextView, resources.getString(0x7f0e00ec));
            setChildVisibility(topTextView, 8);
        } else
        {
            String s = dateFormatter.format(new Date(kindlePrefs.getLong("last_media_store_sync", 0L)));
            setText(topTextView, String.format(resources.getString(0x7f0e00ee), new Object[] {
                Integer.valueOf(autoSaveCount - unuploadedAutoSaveCount), Integer.valueOf(autoSaveCount)
            }));
            setText(bottomTextView, String.format(resources.getString(0x7f0e00ed), new Object[] {
                s
            }));
            setChildVisibility(topTextView, 0);
        }
        setChildVisibility(bottomTextView, 0);
    }

    private void switchToSyncingState()
    {
        setText(bottomTextView, getResources().getString(0x7f0e00ef));
        setChildVisibility(progressBar, 0);
        setChildVisibility(bottomTextView, 0);
    }

    private void switchToUploadingState()
    {
        int i = (int)uploadStatus.getRealCurrentItemNumber();
        int j = (int)uploadStatus.getTotalItems();
        progressBar.setProgress(uploadStatus.getUploadProgress());
        setText(bottomTextView, String.format(getResources().getString(0x7f0e00f0), new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(uploadStatus.getUploadProgress())
        }));
        setChildVisibility(progressBar, 0);
        setChildVisibility(bottomTextView, 0);
    }

    private void updateCountersAsync(final boolean force)
    {
        uiReadyExecutor.execute(new Runnable() {

            final AndroidNavigationUploadView this$0;
            final boolean val$force;

            public void run()
            {
                updateCountersSync(force);
            }

            
            {
                this$0 = AndroidNavigationUploadView.this;
                force = flag;
                super();
            }
        });
    }

    private void updateCountersSync(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = SystemClock.uptimeMillis();
        l1 = defaultPrefs.getLong("last_counter_update", 0L);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (l - l1 <= COUNTER_UPDATE_GRACE_PERIOD)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        if (isUpdatingInProgress.compareAndSet(false, true))
        {
            (new AsyncCounterUpdate(getContext(), mediaItemDao, tagDao, isUpdatingInProgress)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void updateViewState(ViewState viewstate)
    {
        updateViewState(viewstate, false);
    }

    private void updateViewState(ViewState viewstate, boolean flag)
    {
        GLogger.i(TAG, "Updating view state to %s", new Object[] {
            viewstate.toString()
        });
        if (!flag && viewState != null && viewState.isHigherPriority(viewstate))
        {
            GLogger.d(TAG, "Ignoring view state update due to higher priority state currently visible", new Object[0]);
            return;
        }
        if (viewstate != viewState)
        {
            setChildrenVisibility(8);
        }
        _cls5..SwitchMap.com.amazon.gallery.thor.widget.AndroidNavigationUploadView.ViewState[viewstate.ordinal()];
        JVM INSTR tableswitch 1 4: default 108
    //                   1 114
    //                   2 121
    //                   3 128
    //                   4 135;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        viewState = viewstate;
        return;
_L2:
        switchToUploadingState();
        continue; /* Loop/switch isn't completed */
_L3:
        switchToRestState();
        continue; /* Loop/switch isn't completed */
_L4:
        switchToPausedState();
        continue; /* Loop/switch isn't completed */
_L5:
        switchToSyncingState();
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        GLogger.d(TAG, "View was attached to window", new Object[0]);
        defaultPrefs.registerOnSharedPreferenceChangeListener(this);
        kindlePrefs.registerOnSharedPreferenceChangeListener(this);
        GlobalMessagingBus.register(this);
        GlobalMessagingBus.post(new UploadListenerEvent(com.amazon.gallery.framework.network.multiqueueuploader.UploadListenerEvent.Action.ADD, QueueType.AUTO_SAVE, this));
        initViewState();
    }

    public void onCancelUploadActionEvent(UploadActionEvent uploadactionevent)
    {
        if (UploadControlAction.CANCEL.equals(uploadactionevent.getAction()))
        {
            currentQueueType = null;
            updateCountersAsync(false);
            updateViewState(ViewState.REST, hasColdBooted());
        }
    }

    public void onColdBootProgressEvent(ColdBootProgressEvent coldbootprogressevent)
    {
        animateProgress(coldbootprogressevent.getProgress(), coldbootprogressevent.getDuration());
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        GLogger.d(TAG, "View was detached from window", new Object[0]);
        defaultPrefs.unregisterOnSharedPreferenceChangeListener(this);
        kindlePrefs.unregisterOnSharedPreferenceChangeListener(this);
        GlobalMessagingBus.unregister(this);
        GlobalMessagingBus.post(new UploadListenerEvent(com.amazon.gallery.framework.network.multiqueueuploader.UploadListenerEvent.Action.REMOVE, QueueType.AUTO_SAVE, this));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        byte byte0;
        boolean flag;
        flag = false;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 6: default 68
    //                   -1573302249: 181
    //                   -1194150897: 196
    //                   127907720: 152
    //                   1142163549: 166
    //                   1756732669: 137
    //                   1990550374: 211;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        byte0;
        JVM INSTR tableswitch 0 5: default 108
    //                   0 226
    //                   1 236
    //                   2 259
    //                   3 276
    //                   4 293
    //                   5 293;
           goto _L8 _L9 _L10 _L11 _L12 _L13 _L13
_L8:
        byte0 = flag;
_L14:
        if (byte0 != 0 && viewState.equals(ViewState.REST))
        {
            updateViewState(viewState);
        }
        return;
_L6:
        if (s.equals("last_media_store_sync"))
        {
            byte0 = 0;
        }
          goto _L1
_L4:
        if (s.equals("coldBootStatus"))
        {
            byte0 = 1;
        }
          goto _L1
_L5:
        if (s.equals("auto_save_count"))
        {
            byte0 = 2;
        }
          goto _L1
_L2:
        if (s.equals("unuploaded_auto_save_count"))
        {
            byte0 = 3;
        }
          goto _L1
_L3:
        if (s.equals("auto_upload_photos_key"))
        {
            byte0 = 4;
        }
          goto _L1
_L7:
        if (s.equals("auto_upload_videos_key"))
        {
            byte0 = 5;
        }
          goto _L1
_L9:
        updateCountersAsync(true);
        byte0 = 1;
          goto _L14
_L10:
        animateProgress(100, 2500L, new AnimatorListenerAdapter() {

            final AndroidNavigationUploadView this$0;

            public void onAnimationEnd(Animator animator1)
            {
                updateCountersAsync(false);
                updateViewState(ViewState.REST, true);
            }

            
            {
                this$0 = AndroidNavigationUploadView.this;
                super();
            }
        });
        byte0 = flag;
          goto _L14
_L11:
        autoSaveCount = sharedpreferences.getInt(s, 0);
        byte0 = 1;
          goto _L14
_L12:
        unuploadedAutoSaveCount = sharedpreferences.getInt(s, 0);
        byte0 = 1;
          goto _L14
_L13:
        byte0 = 1;
          goto _L14
    }

    public void onTagAutoSaveChangedEvent(TagAutoSaveChangedEvent tagautosavechangedevent)
    {
        updateCountersAsync(true);
        if (ViewState.REST.equals(viewState))
        {
            updateViewState(viewState);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    public void onUploadError(UploadStatus uploadstatus, UploadError uploaderror, QueueType queuetype)
    {
        GLogger.v(TAG, "onUploadError", new Object[0]);
        setUploadStatus(uploadstatus);
        updateViewState(ViewState.PAUSED, hasColdBooted());
    }

    public void onUploadFailed(UploadStatus uploadstatus, QueueType queuetype, Exception exception)
    {
        GLogger.v(TAG, "onUploadFailed", new Object[0]);
        if (!isQueueTypeAllowed(queuetype))
        {
            return;
        }
        setUploadStatus(uploadstatus);
        if (uploadstatus.isUploadComplete())
        {
            if (exception instanceof CloudStorageLimitException)
            {
                updateViewState(ViewState.PAUSED, hasColdBooted());
                return;
            } else
            {
                updateCountersAsync(true);
                updateViewState(ViewState.REST, hasColdBooted());
                return;
            }
        } else
        {
            updateViewState(ViewState.UPLOADING);
            return;
        }
    }

    public void onUploadProgressChanged(UploadStatus uploadstatus, MediaItem mediaitem, QueueType queuetype, int i, int j)
    {
        GLogger.v(TAG, "onUploadProgressChanged", new Object[0]);
        if (!isQueueTypeAllowed(queuetype))
        {
            return;
        } else
        {
            setUploadStatus(uploadstatus);
            updateViewState(ViewState.UPLOADING);
            return;
        }
    }

    public void onUploadQueued(UploadStatus uploadstatus, List list, QueueType queuetype)
    {
        GLogger.v(TAG, "onUploadQueued", new Object[0]);
        if (!isQueueTypeAllowed(queuetype))
        {
            return;
        }
        setUploadStatus(uploadstatus);
        uploadstatus = ViewState.UPLOADING;
        if (viewState == ViewState.PAUSED)
        {
            uploadstatus = ViewState.PAUSED;
        }
        updateViewState(uploadstatus);
    }

    public void onUploadSuccessful(UploadStatus uploadstatus, QueueType queuetype)
    {
        GLogger.v(TAG, "onUploadSuccessful", new Object[0]);
        if (!isQueueTypeAllowed(queuetype))
        {
            return;
        }
        setUploadStatus(uploadstatus);
        if (uploadstatus.isUploadComplete())
        {
            updateCountersAsync(true);
            if (uploadstatus.hasAtLeastOneBatchFailed(UploadBatchFactory.PHOTO_BATCHES) || uploadstatus.hasAtLeastOneBatchFailed(UploadBatchFactory.VIDEO_BATCHES))
            {
                updateViewState(ViewState.PAUSED, hasColdBooted());
            } else
            {
                updateViewState(ViewState.REST, hasColdBooted());
            }
            currentQueueType = null;
            return;
        } else
        {
            updateViewState(ViewState.UPLOADING);
            return;
        }
    }

    static 
    {
        COUNTER_UPDATE_GRACE_PERIOD = TimeUnit.SECONDS.toMillis(30L);
    }




}
