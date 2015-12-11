// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import co.vine.android.client.AppController;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

// Referenced classes of package co.vine.android.util:
//            BuildUtil, LongSparseArray, Util

public class LoopManager
{
    public static class Record
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Record createFromParcel(Parcel parcel)
            {
                return new Record(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Record[] newArray(int i)
            {
                return new Record[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public int loopCount;
        public long postId;
        public long timeStamp;
        public long userId;

        public static Record fromSerializedString(String s)
        {
            s = s.split(":");
            if (s.length != 4)
            {
                return null;
            } else
            {
                Record record = new Record();
                record.userId = Long.parseLong(s[0]);
                record.postId = Long.parseLong(s[1]);
                record.loopCount = Integer.parseInt(s[2]);
                record.timeStamp = Long.parseLong(s[3]);
                return record;
            }
        }

        public int describeContents()
        {
            return 0;
        }

        public void increment()
        {
            loopCount = loopCount + 1;
            timeStamp = System.currentTimeMillis();
            int i = ((Integer)LoopManager.sCounts.get(postId, Integer.valueOf(-1))).intValue();
            if (i == -1)
            {
                LoopManager.sCounts.put(postId, Integer.valueOf(1));
                return;
            } else
            {
                LoopManager.sCounts.put(postId, Integer.valueOf(i + 1));
                return;
            }
        }

        public String toSerializedString()
        {
            return (new StringBuilder()).append(String.valueOf(userId)).append(':').append(postId).append(':').append(loopCount).append(':').append(timeStamp).toString();
        }

        public String toString()
        {
            return toSerializedString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeLong(userId);
            parcel.writeLong(postId);
            parcel.writeInt(loopCount);
            parcel.writeLong(timeStamp);
        }


        private Record()
        {
        }

        public Record(long l, long l1)
        {
            userId = l;
            postId = l1;
            loopCount = 0;
        }

        private Record(Parcel parcel)
        {
            userId = parcel.readLong();
            postId = parcel.readLong();
            loopCount = parcel.readInt();
            timeStamp = parcel.readLong();
        }

    }


    private static final boolean DEBUGABLE = BuildUtil.isLogsOn();
    private static final int LOCK[] = new int[0];
    private static final String TAG = "VineLoopManager";
    private static final LongSparseArray sCounts = new LongSparseArray();
    private static LoopManager sInstance;
    private final Context mContext;
    private final SharedPreferences mPrefs;
    private LinkedList mRecords;
    private long mViewingId;

    private LoopManager(Context context)
    {
        mPrefs = Util.getDefaultSharedPrefs(context);
        mRecords = new LinkedList();
        mContext = context;
        mViewingId = 0L;
        for (context = mPrefs.getStringSet("pref_loop_count_records", Collections.emptySet()).iterator(); context.hasNext(); addRecord(Record.fromSerializedString((String)context.next()))) { }
    }

    public static LoopManager get(Context context)
    {
        synchronized (LOCK)
        {
            if (sInstance == null)
            {
                sInstance = new LoopManager(context);
            }
        }
        return sInstance;
        context;
        ai;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static int getLocalLoopCount(long l)
    {
        return ((Integer)sCounts.get(l, Integer.valueOf(0))).intValue();
    }

    public void addRecord(Record record)
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        int i;
        mRecords.add(record);
        if (record.loopCount <= 0)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        i = ((Integer)sCounts.get(record.postId, Integer.valueOf(-1))).intValue();
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        sCounts.put(record.postId, Integer.valueOf(record.loopCount));
_L2:
        ai;
        JVM INSTR monitorexit ;
        return;
        sCounts.put(record.postId, Integer.valueOf(record.loopCount + i));
        if (true) goto _L2; else goto _L1
_L1:
        record;
        ai;
        JVM INSTR monitorexit ;
        throw record;
    }

    public void increment(long l)
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        Record record;
        if (mViewingId == l)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        record = new Record(AppController.getInstance(mContext).getActiveId(), l);
        addRecord(record);
_L2:
        mViewingId = l;
        record.increment();
        return;
        record = (Record)mRecords.getLast();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List popPendingLoops()
    {
        Object obj1 = new LinkedList();
        synchronized (LOCK)
        {
            obj = mRecords;
            mRecords = ((LinkedList) (obj1));
            if (!((LinkedList) (obj)).isEmpty() && mViewingId == ((Record)((LinkedList) (obj)).getLast()).postId)
            {
                mRecords.add(((LinkedList) (obj)).removeLast());
            }
        }
        long l = AppController.getInstance(mContext).getActiveId();
        obj1 = ((LinkedList) (obj)).listIterator();
        do
        {
            if (!((ListIterator) (obj1)).hasNext())
            {
                break;
            }
            Record record = (Record)((ListIterator) (obj1)).next();
            if (record.userId != l)
            {
                synchronized (LOCK)
                {
                    mRecords.addFirst(record);
                }
                ((ListIterator) (obj1)).remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_147;
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
        return ((List) (obj));
    }

    public void save()
    {
        Object obj = new HashSet();
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mRecords.iterator(); iterator.hasNext(); ((Set) (obj)).add(((Record)iterator.next()).toSerializedString())) { }
        break MISSING_BLOCK_LABEL_58;
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
        if (DEBUGABLE)
        {
            Log.v("VineLoopManager", (new StringBuilder()).append("Committing these loop records:\n").append(toString()).toString());
        }
        ai;
        JVM INSTR monitorexit ;
        mPrefs.edit().putStringSet("pref_loop_count_records", ((Set) (obj))).commit();
        return;
    }

    public String toString()
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new StringBuilder();
        for (Iterator iterator = mRecords.iterator(); iterator.hasNext(); ((StringBuilder) (obj)).append(((Record)iterator.next()).toString()).append('\n')) { }
        break MISSING_BLOCK_LABEL_61;
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
        obj = ((StringBuilder) (obj)).toString();
        ai;
        JVM INSTR monitorexit ;
        return ((String) (obj));
    }

    public void undoPopPendingLoops(List list)
    {
        synchronized (LOCK)
        {
            mRecords.addAll(0, list);
            save();
        }
        return;
        list;
        ai;
        JVM INSTR monitorexit ;
        throw list;
    }


}
