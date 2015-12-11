// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive.latency;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.retailsearch.adaptive.NetworkType;
import com.amazon.retailsearch.adaptive.framework.AdaptiveTreatmentEnum;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.adaptive.latency:
//            LatencyRecord

public class LatencyRecordsManager
{

    private static final int MAX_LATENCY = 10;
    private static final int MIN_LATENCY = 3;
    private static final String RECORDS_FILENAME = "SXDataStore";
    private static final String RECORDS_KEY = "searchLatencies";
    private static LatencyRecordsManager singleton = null;
    private boolean dataChange;
    private final List recordList = new ArrayList();

    private LatencyRecordsManager()
    {
        dataChange = false;
    }

    public static LatencyRecordsManager getInstance()
    {
        if (singleton == null)
        {
            singleton = new LatencyRecordsManager();
        }
        return singleton;
    }

    private String recordsToString()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(((java.io.OutputStream) (obj)));
        objectoutputstream.writeObject(recordList);
        objectoutputstream.flush();
        obj = Base64.encodeToString(((ByteArrayOutputStream) (obj)).toByteArray(), 0);
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        Object obj1;
        obj1;
        System.out.println(obj1);
        obj1 = "";
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        throw obj1;
    }

    private void removeExpiredLatencies()
    {
        long l = System.nanoTime();
        Iterator iterator = recordList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((LatencyRecord)iterator.next()).hasExpired(l))
            {
                iterator.remove();
            }
        } while (true);
    }

    private List stringToRecords(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (List)(new ObjectInputStream(new ByteArrayInputStream(Base64.decode(s, 0)))).readObject();
_L2:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        System.out.println(s);
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public void addLatency(int i, AdaptiveTreatmentEnum adaptivetreatmentenum, NetworkType networktype)
    {
        adaptivetreatmentenum = new LatencyRecord(i, adaptivetreatmentenum, networktype);
        recordList.add(adaptivetreatmentenum);
        if (recordList.size() >= 10)
        {
            recordList.remove(0);
        }
        dataChange = true;
    }

    public double getMeanLatency(NetworkType networktype)
    {
        removeExpiredLatencies();
        int i = 0;
        double d = 0.0D;
        long l = System.nanoTime();
        Iterator iterator = recordList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LatencyRecord latencyrecord = (LatencyRecord)iterator.next();
            if (latencyrecord.getNetworkType() == networktype)
            {
                double d1 = (double)latencyrecord.getTime() / (double)l;
                d += (double)latencyrecord.getLatency() * d1;
                i++;
            }
        } while (true);
        if (i < 3)
        {
            return (0.0D / 0.0D);
        } else
        {
            return d / (double)recordList.size();
        }
    }

    public void recoverRecords(Context context)
    {
        context = context.getSharedPreferences("SXDataStore", 0).getString("searchLatencies", null);
        if (TextUtils.isEmpty(context))
        {
            return;
        } else
        {
            recordList.clear();
            recordList.addAll(stringToRecords(context));
            return;
        }
    }

    public void saveRecords(Context context)
    {
        if (!dataChange)
        {
            return;
        } else
        {
            context = context.getSharedPreferences("SXDataStore", 0).edit();
            context.putString("searchLatencies", recordsToString());
            context.apply();
            dataChange = false;
            return;
        }
    }

}
