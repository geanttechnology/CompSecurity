// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.removablestorage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.UserUtils;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.di.AppKeys;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.removablestorage:
//            RemovableStorageManager, RemovableStorageStateListener

public abstract class RemovableStorageManagerCommon
    implements RemovableStorageManager
{

    private static final String TAG = com/amazon/gallery/thor/removablestorage/RemovableStorageManagerCommon.getName();
    private BroadcastReceiver badRemovalReceiver;
    protected final BeanFactory beanFactory;
    protected final Context context;
    protected final FreeTime freeTime;
    private final Set listeners = new HashSet();
    private BroadcastReceiver mediaMountedReceiver;
    private BroadcastReceiver mediaUnmountedReceiver;
    protected final ComponentProfiler profiler;
    private File removableStorageRootDirectory;

    protected RemovableStorageManagerCommon(Context context1, BeanFactory beanfactory)
    {
        removableStorageRootDirectory = getSecondaryStoragePath();
        mediaMountedReceiver = new BroadcastReceiver() {

            final RemovableStorageManagerCommon this$0;

            public void onReceive(Context context2, Intent intent)
            {
                removableStorageRootDirectory = RemovableStorageManagerCommon.getSecondaryStoragePath();
                if (isFileOnRemovableStorage(Uri.parse(intent.getDataString())))
                {
                    notifyRemovableStorageMounted();
                }
            }

            
            {
                this$0 = RemovableStorageManagerCommon.this;
                super();
            }
        };
        badRemovalReceiver = new BroadcastReceiver() {

            final RemovableStorageManagerCommon this$0;

            public void onReceive(Context context2, Intent intent)
            {
                if (isFileOnRemovableStorage(Uri.parse(intent.getDataString())))
                {
                    notifyRemovableStorageBadRemoval();
                }
            }

            
            {
                this$0 = RemovableStorageManagerCommon.this;
                super();
            }
        };
        mediaUnmountedReceiver = new BroadcastReceiver() {

            final RemovableStorageManagerCommon this$0;

            public void onReceive(Context context2, Intent intent)
            {
                if (isFileOnRemovableStorage(Uri.parse(intent.getDataString())))
                {
                    notifyRemovableStorageUnmounted();
                }
            }

            
            {
                this$0 = RemovableStorageManagerCommon.this;
                super();
            }
        };
        context = context1;
        beanFactory = beanfactory;
        profiler = new ComponentProfiler((Profiler)beanFactory.getBean(Keys.PROFILER), com/amazon/gallery/thor/removablestorage/RemovableStorageManager);
        freeTime = (FreeTime)beanFactory.getBean(AppKeys.THOR_FREE_TIME);
        beanfactory = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
        beanfactory.addDataScheme("file");
        context1.registerReceiver(mediaMountedReceiver, beanfactory);
        beanfactory = new IntentFilter("android.intent.action.MEDIA_BAD_REMOVAL");
        beanfactory.addDataScheme("file");
        context1.registerReceiver(badRemovalReceiver, beanfactory);
        beanfactory = new IntentFilter("android.intent.action.MEDIA_UNMOUNTED");
        beanfactory.addDataScheme("file");
        context1.registerReceiver(mediaUnmountedReceiver, beanfactory);
        addListener(this);
    }

    private static File getSecondaryStoragePath()
    {
        String as[];
        int i;
        int j;
        if (!Api.isAtLeastLollipop())
        {
            return null;
        }
        String s = System.getenv("SECONDARY_STORAGE");
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        as = s.split(":");
        j = as.length;
        i = 0;
_L2:
        Object obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj = as[i];
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!((File) (obj = new File(((String) (obj))))).isDirectory()) goto _L4; else goto _L3
_L3:
        return ((File) (obj));
        return null;
    }

    private void notifyRemovableStorageBadRemoval()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((RemovableStorageStateListener)iterator.next()).onMediaBadRemoval()) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void notifyRemovableStorageMounted()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((RemovableStorageStateListener)iterator.next()).onMediaMounted()) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void notifyRemovableStorageUnmounted()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((RemovableStorageStateListener)iterator.next()).onMediaUnmounted()) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public boolean addListener(RemovableStorageStateListener removablestoragestatelistener)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (removablestoragestatelistener != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertTrue(flag, "listener is null");
        flag = listeners.add(removablestoragestatelistener);
        DebugAssert.assertTrue(flag, "listener already added");
        this;
        JVM INSTR monitorexit ;
        return flag;
        removablestoragestatelistener;
        throw removablestoragestatelistener;
    }

    protected abstract File getDownloadRootDirectory();

    protected File getFirstRemovableStorageDirectoryInArray(File afile[])
    {
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file = afile[i];
            if (isFileOnRemovableStorage(file))
            {
                return file;
            }
        }

        return null;
    }

    public File getRemovableStorageDownloadDirectory()
    {
        File file;
        if (!Api.isAtLeastLollipop())
        {
            file = null;
        } else
        {
            file = getDownloadRootDirectory();
            if (file == null)
            {
                return null;
            }
            File file1 = new File(file, Integer.toString(UserUtils.getCurrentUserId()));
            file = file1;
            if (!file1.exists())
            {
                file = file1;
                if (!file1.mkdirs())
                {
                    return null;
                }
            }
        }
        return file;
    }

    public File getRemovableStorageRootDirectory()
    {
        return removableStorageRootDirectory;
    }

    public boolean isFileOnRemovableStorage(Uri uri)
    {
        File file;
        if (uri != null)
        {
            if ((file = getRemovableStorageRootDirectory()) != null)
            {
                return StringUtils.startsWithIgnoreCase(uri.getPath(), file.getAbsolutePath());
            }
        }
        return false;
    }

    public boolean isFileOnRemovableStorage(File file)
    {
        File file1;
        if (file != null)
        {
            if ((file1 = getRemovableStorageRootDirectory()) != null)
            {
                return StringUtils.startsWithIgnoreCase(file.getAbsolutePath(), file1.getAbsolutePath());
            }
        }
        return false;
    }

    public boolean isRemovableStorageMounted()
    {
        File file;
        if (Api.isAtLeastLollipop())
        {
            if ((file = getRemovableStorageRootDirectory()) != null)
            {
                return "mounted".equals(Environment.getExternalStorageState(file));
            }
        }
        return false;
    }

    public void onMediaBadRemoval()
    {
        GLogger.i(TAG, "Media Bad Removal", new Object[0]);
        profiler.trackEvent(RemovableStorageManager.MetricsEvent.MediaBadRemoval);
    }

    public void onMediaMounted()
    {
        GLogger.i(TAG, "Media Mounted", new Object[0]);
        profiler.trackEvent(RemovableStorageManager.MetricsEvent.MediaMounted);
    }

    public void onMediaUnmounted()
    {
        GLogger.i(TAG, "Media Unmounted", new Object[0]);
        profiler.trackEvent(RemovableStorageManager.MetricsEvent.MediaUnmounted);
        removableStorageRootDirectory = getSecondaryStoragePath();
    }

    public boolean promptForStoragePreferenceIfNeeded(Activity activity)
    {
        while (freeTime.isFreeTime() || !isRemovableStorageMounted()) 
        {
            return false;
        }
        return showStoragePreferencePrompt(activity);
    }

    protected abstract boolean showStoragePreferencePrompt(Activity activity);



/*
    static File access$002(RemovableStorageManagerCommon removablestoragemanagercommon, File file)
    {
        removablestoragemanagercommon.removableStorageRootDirectory = file;
        return file;
    }

*/




}
