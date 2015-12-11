// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.SystemWrapper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.util.Date;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DistributedDataStorage

public class LambortishClock
{
    public static class ChangeTimestampsBroadcastReceiver extends BroadcastReceiver
    {

        public static boolean isValidOnThisPlatform(PlatformWrapper platformwrapper)
        {
            return DistributedDataStorage.shouldPlatformUseThisStore(platformwrapper);
        }

        public void onReceive(Context context, Intent intent)
        {
            intent = intent.getAction();
            if (!"android.intent.action.TIME_SET".equals(intent))
            {
                MAPLog.formattedError(LambortishClock.TAG, "Cannot Handle intent with action %s", new Object[] {
                    intent
                });
                return;
            }
            context = ServiceWrappingContext.create(context);
            if (!DistributedDataStorage.shouldPlatformUseThisStore((PlatformWrapper)context.getSystemService("sso_platform")))
            {
                String _tmp = LambortishClock.TAG;
                return;
            } else
            {
                LambortishClock.getInstance(context).notifySystemTimeChanged();
                return;
            }
        }

        public ChangeTimestampsBroadcastReceiver()
        {
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/storage/LambortishClock.getName();
    private static LambortishClock sTheOneAndTheOnly;
    private final Context mContext;
    private Long mDeltaMs;
    private Long mGreatestTimeStampMs;
    private final SystemWrapper mSystem;

    LambortishClock(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mSystem = (SystemWrapper)mContext.getSystemService("dcp_system");
    }

    private long getGreatestTimestampSeen(SharedPreferences sharedpreferences)
    {
        if (mGreatestTimeStampMs == null)
        {
            mGreatestTimeStampMs = Long.valueOf(sharedpreferences.getLong("greatest_timestamp_ms_seen_key", 0L));
        }
        return mGreatestTimeStampMs.longValue();
    }

    public static LambortishClock getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/LambortishClock;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new LambortishClock(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/storage/LambortishClock;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private SharedPreferences getStore()
    {
        return mContext.getSharedPreferences("Lambortish_Clock_Store", 0);
    }

    private boolean saveGreatestTimestampSeen(SharedPreferences sharedpreferences, long l)
    {
        mGreatestTimeStampMs = Long.valueOf(l);
        if (!sharedpreferences.edit().putLong("greatest_timestamp_ms_seen_key", l).commit())
        {
            MAPLog.e(TAG, "Could not save the greatest timestamp seen!", new Throwable());
            return false;
        } else
        {
            return true;
        }
    }

    public Date getNewTimestamp()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        long l;
        long l1;
        long l2;
        obj = getStore();
        l1 = getGreatestTimestampSeen(((SharedPreferences) (obj)));
        l2 = mSystem.currentTimeMillis();
        if (mDeltaMs == null)
        {
            mDeltaMs = Long.valueOf(((SharedPreferences) (obj)).getLong("cur_delta_ms_key", 0L));
        }
        l = l2 + mDeltaMs.longValue();
        if (l <= l1) goto _L2; else goto _L1
_L1:
        saveGreatestTimestampSeen(((SharedPreferences) (obj)), l);
        obj = new Date(l);
        this;
        JVM INSTR monitorexit ;
        return ((Date) (obj));
_L2:
        l1 += 100L;
        l2 = l1 - l2;
        mDeltaMs = Long.valueOf(l2);
        l = l1;
        if (((SharedPreferences) (obj)).edit().putLong("cur_delta_ms_key", l2).commit())
        {
            continue; /* Loop/switch isn't completed */
        }
        MAPLog.e(TAG, "Could not save the new delta!", new Throwable());
        l = l1;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean markDateSeen(Date date)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        long l = date.getTime();
        date = getStore();
        if (l > getGreatestTimestampSeen(date))
        {
            flag = saveGreatestTimestampSeen(date, l);
        }
        if (true) goto _L1; else goto _L3
_L3:
        date;
        throw date;
    }

    public void notifySystemTimeChanged()
    {
        this;
        JVM INSTR monitorenter ;
        Date date = getNewTimestamp();
        MAPLog.formattedInfo(TAG, "Users clock moved. System time is %s and timestamp is %s", new Object[] {
            Long.toString(mSystem.currentTimeMillis()), Long.toString(date.getTime())
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }


}
