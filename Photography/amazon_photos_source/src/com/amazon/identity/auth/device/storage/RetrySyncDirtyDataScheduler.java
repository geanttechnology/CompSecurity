// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.framework.AlarmManagerWrapper;
import com.amazon.identity.auth.device.framework.PendingIntentWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.SystemWrapper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DirtyDataSyncingService

public class RetrySyncDirtyDataScheduler
{
    public final class RetrySyncDirtyDataUnscheduler
    {

        private final PendingIntentWrapper mDirtyDataIntent;
        private final Long mLastScheduledDirtySyncTime;
        final RetrySyncDirtyDataScheduler this$0;

        public void markDataNotDirty()
        {
label0:
            {
                synchronized (mLock)
                {
                    if (mDirtyDataIntent != null)
                    {
                        break label0;
                    }
                    RetrySyncDirtyDataScheduler.TAG;
                }
                return;
            }
            mAlarmManager.cancel(mDirtyDataIntent);
            setNextScheduledDirtyDataSync(mLastScheduledDirtySyncTime);
            aobj;
            JVM INSTR monitorexit ;
        }

        private RetrySyncDirtyDataUnscheduler(PendingIntentWrapper pendingintentwrapper, Long long1)
        {
            this$0 = RetrySyncDirtyDataScheduler.this;
            super();
            mDirtyDataIntent = pendingintentwrapper;
            mLastScheduledDirtySyncTime = long1;
        }

        RetrySyncDirtyDataUnscheduler(PendingIntentWrapper pendingintentwrapper, Long long1, byte byte0)
        {
            this(pendingintentwrapper, long1);
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler.getName();
    private static final long WAIT_TO_RETRY_SYNC_DIRTY_DATA_MS_DEFAULT;
    private final AlarmManagerWrapper mAlarmManager;
    private final ServiceWrappingContext mContext;
    private final Object mLock[] = new Object[0];
    private final SystemWrapper mSystem;

    public RetrySyncDirtyDataScheduler(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAlarmManager = (AlarmManagerWrapper)mContext.getSystemService("sso_alarm_maanger");
        mSystem = (SystemWrapper)mContext.getSystemService("dcp_system");
    }

    private SharedPreferences getStore()
    {
        return mContext.getSharedPreferences("sync_dirty_data_store", 0);
    }

    private void setNextScheduledDirtyDataSync(Long long1)
    {
        android.content.SharedPreferences.Editor editor = getStore().edit();
        if (long1 != null)
        {
            editor.putLong("sync_dirty_data_store_time", long1.longValue());
        } else
        {
            editor.remove("sync_dirty_data_store_time");
        }
        if (!editor.commit())
        {
            MAPLog.e(TAG, "Unable to save next scheduled dirty data sync");
        }
    }

    public RetrySyncDirtyDataUnscheduler setDirtyData()
    {
        Object obj1;
        boolean flag;
        obj1 = null;
        flag = true;
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        Object obj;
        long l;
        l = mSystem.currentTimeMillis();
        obj = getStore();
        if (!((SharedPreferences) (obj)).contains("sync_dirty_data_store_time")) goto _L2; else goto _L1
_L1:
        obj = Long.valueOf(((SharedPreferences) (obj)).getLong("sync_dirty_data_store_time", 0L));
          goto _L3
_L9:
        if (obj1 != null) goto _L5; else goto _L4
_L4:
        String s = TAG;
_L6:
        obj = new RetrySyncDirtyDataUnscheduler(((PendingIntentWrapper) (obj1)), ((Long) (obj)), (byte)0);
        aobj;
        JVM INSTR monitorexit ;
        return ((RetrySyncDirtyDataUnscheduler) (obj));
_L8:
        if (((Long) (obj)).longValue() > l)
        {
            flag = false;
        }
        break; /* Loop/switch isn't completed */
_L10:
        obj1 = mContext;
        Intent intent = new Intent("com.amazon.identity.action.SYNC_DIRTY_DATA");
        intent.setClass(((Context) (obj1)), com/amazon/identity/auth/device/storage/DirtyDataSyncingService);
        obj1 = PendingIntentWrapper.getService$227fb7c8(((Context) (obj1)), intent);
        break; /* Loop/switch isn't completed */
_L5:
        String s1 = TAG;
        l = PlatformSettings.getInstance(mContext).getSettingLong("wait_to_retry_sync_dirty_data_ms", WAIT_TO_RETRY_SYNC_DIRTY_DATA_MS_DEFAULT) + l;
        mAlarmManager.set$6d261ae(l, ((PendingIntentWrapper) (obj1)));
        setNextScheduledDirtyDataSync(Long.valueOf(l));
          goto _L6
        obj;
        throw obj;
_L3:
        if (obj != null) goto _L8; else goto _L7
_L7:
        if (flag) goto _L10; else goto _L9
_L2:
        obj = null;
          goto _L3
    }

    static 
    {
        WAIT_TO_RETRY_SYNC_DIRTY_DATA_MS_DEFAULT = TimeUnit.MILLISECONDS.convert(15L, TimeUnit.SECONDS);
    }




}
