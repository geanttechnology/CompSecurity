// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.processor;

import com.amazon.device.crashmanager.utils.CrashDescriptorDedupeUtil;
import com.amazon.device.utils.DetUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.device.crashmanager.processor:
//            ArtifactProcessorFactory, JavaCrashArtifactProcessor, AnrArtifactProcessor, SmvArtifactProcessor, 
//            NativeCrashArtifactProcessor, DiagnosticArtifactProcessor, RamDumpArtifactProcessor, PinFailuresArtifactProcessor, 
//            DefaultArtifactProcessor, MetricsHeaderProcessorFactory

public class DefaultArtifactProcessorFactory
    implements ArtifactProcessorFactory
{

    private final CrashDescriptorDedupeUtil mCrashDedupeUtil;
    private final DetUtil mDetUtil;
    private final String mDeviceSerialNumber;
    private final String mDeviceType;
    private final Map mExtraInfo;
    private final MetricsHeaderProcessorFactory mMetricsHeaderProcessorFactory;

    public DefaultArtifactProcessorFactory(DetUtil detutil, String s, String s1, Map map, MetricsHeaderProcessorFactory metricsheaderprocessorfactory, CrashDescriptorDedupeUtil crashdescriptordedupeutil)
    {
        if (detutil == null)
        {
            throw new IllegalArgumentException("DetUtil must not be null.");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("DeviceType must not be null.");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("DeviceSerialNumber must not be null.");
        }
        if (metricsheaderprocessorfactory == null)
        {
            throw new IllegalArgumentException("MetricsHeaderProcessorFactory must not be null.");
        }
        if (crashdescriptordedupeutil == null)
        {
            throw new IllegalArgumentException("DuplicateCrashCounts must not be null.");
        } else
        {
            mDetUtil = detutil;
            mDeviceType = s;
            mDeviceSerialNumber = s1;
            mExtraInfo = map;
            mMetricsHeaderProcessorFactory = metricsheaderprocessorfactory;
            mCrashDedupeUtil = crashdescriptordedupeutil;
            return;
        }
    }

    public List constructArtifactProcessors()
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new JavaCrashArtifactProcessor(mDetUtil, mDeviceType, mDeviceSerialNumber, mExtraInfo, mMetricsHeaderProcessorFactory, mCrashDedupeUtil));
        linkedlist.add(new AnrArtifactProcessor(mDetUtil, mDeviceType, mDeviceSerialNumber, mExtraInfo, mMetricsHeaderProcessorFactory, mCrashDedupeUtil));
        linkedlist.add(new SmvArtifactProcessor(mDetUtil, mDeviceType, mDeviceSerialNumber, mExtraInfo, mMetricsHeaderProcessorFactory, mCrashDedupeUtil));
        linkedlist.add(new NativeCrashArtifactProcessor(mDetUtil, mDeviceType, mDeviceSerialNumber, mExtraInfo, mMetricsHeaderProcessorFactory, mCrashDedupeUtil));
        linkedlist.add(new DiagnosticArtifactProcessor(mDetUtil, mDeviceType, mDeviceSerialNumber, mExtraInfo));
        linkedlist.add(new RamDumpArtifactProcessor(mDetUtil, mDeviceType, mDeviceSerialNumber, mExtraInfo));
        linkedlist.add(new PinFailuresArtifactProcessor(mDetUtil, mDeviceType, mDeviceSerialNumber, mExtraInfo));
        linkedlist.add(new DefaultArtifactProcessor(mDetUtil, mDeviceType, mDeviceSerialNumber, mExtraInfo));
        return linkedlist;
    }
}
