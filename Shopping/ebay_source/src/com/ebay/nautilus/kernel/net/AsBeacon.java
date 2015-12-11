// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.os.SystemClock;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            AsMark

public final class AsBeacon
    implements Cloneable
{
    public static final class AsTagName extends Enum
    {

        private static final AsTagName $VALUES[];
        public static final AsTagName landscape;
        public static final AsTagName launch;
        public static final AsTagName reload;
        public static final AsTagName signedout;

        public static AsTagName valueOf(String s)
        {
            return (AsTagName)Enum.valueOf(com/ebay/nautilus/kernel/net/AsBeacon$AsTagName, s);
        }

        public static AsTagName[] values()
        {
            return (AsTagName[])$VALUES.clone();
        }

        static 
        {
            launch = new AsTagName("launch", 0);
            landscape = new AsTagName("landscape", 1);
            signedout = new AsTagName("signedout", 2);
            reload = new AsTagName("reload", 3);
            $VALUES = (new AsTagName[] {
                launch, landscape, signedout, reload
            });
        }

        private AsTagName(String s, int i)
        {
            super(s, i);
        }
    }


    public final String activityName;
    public final long epochTimestamp = System.currentTimeMillis();
    public final long freeRam = Runtime.getRuntime().freeMemory() / 0x100000L;
    public final int id;
    private long markBits;
    private ArrayList marks;
    public final String tags;
    public final long timestamp;
    public final String userCountry;

    protected AsBeacon(int i, String s, String s1, List list, long l)
    {
        timestamp = SystemClock.elapsedRealtime() - l;
        id = i;
        activityName = s;
        marks = new ArrayList();
        userCountry = s1;
        if (list != null && list.size() > 0)
        {
            tags = TextUtils.join(",", list);
            return;
        } else
        {
            tags = null;
            return;
        }
    }

    protected void addMark(AsMark asmark)
    {
        this;
        JVM INSTR monitorenter ;
        if (AsMark.AsMarkName.activity_atf_render != asmark.name) goto _L2; else goto _L1
_L1:
        boolean flag = hasMark(AsMark.AsMarkName.activity_atf_render);
        if (!flag) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        marks.add(asmark);
        markBits = markBits | (long)asmark.name.value;
        if (true) goto _L3; else goto _L4
_L4:
        asmark;
        throw asmark;
    }

    public void addMarksFrom(AsBeacon asbeacon)
    {
        this;
        JVM INSTR monitorenter ;
        if (asbeacon == null) goto _L2; else goto _L1
_L1:
        boolean flag = asbeacon.marks.isEmpty();
        if (!flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        asbeacon = asbeacon.marks.iterator();
        while (asbeacon.hasNext()) 
        {
            AsMark asmark = (AsMark)asbeacon.next();
            if ((markBits & (long)asmark.name.value) == 0L)
            {
                addMark(asmark);
            }
        }
        if (true) goto _L2; else goto _L4
_L4:
        asbeacon;
        throw asbeacon;
    }

    protected void clearAndSetMark(AsMark asmark)
    {
        this;
        JVM INSTR monitorenter ;
        marks.clear();
        markBits = 0L;
        addMark(asmark);
        this;
        JVM INSTR monitorexit ;
        return;
        asmark;
        throw asmark;
    }

    public AsBeacon clone()
    {
        AsBeacon asbeacon = null;
        AsBeacon asbeacon1;
        try
        {
            asbeacon1 = (AsBeacon)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return asbeacon;
        }
        asbeacon = asbeacon1;
        asbeacon1.marks = (ArrayList)marks.clone();
        return asbeacon1;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public List getMarks()
    {
        this;
        JVM INSTR monitorenter ;
        List list = (List)marks.clone();
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hasMark(AsMark.AsMarkName asmarkname)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        long l;
        l = markBits;
        i = asmarkname.value;
        boolean flag;
        if ((l & (long)i) != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        asmarkname;
        throw asmarkname;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{id=").append(id);
        stringbuilder.append(",activityName=").append(activityName);
        stringbuilder.append(",creation=").append(timestamp);
        stringbuilder.append(",markBits=").append(Long.toBinaryString(markBits));
        if (!marks.isEmpty())
        {
            DelimitedStringBuilder.join(stringbuilder.append(",marks={"), ",", false, marks).append('}');
        }
        if (tags != null)
        {
            stringbuilder.append(",tags={").append(tags).append('}');
        }
        return stringbuilder.append('}').toString();
    }
}
