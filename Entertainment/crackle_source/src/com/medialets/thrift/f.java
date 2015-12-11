// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;

// Referenced classes of package com.medialets.thrift:
//            MMAdControl, MMAdSlot, MMAdFrequencyCap, MMAdTrackingPixel

final class f extends HashMap
{

    f()
    {
        put(Integer.valueOf(1), new FieldMetaData("adControl", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(2), new FieldMetaData("minimumConnection", (byte)3, new FieldValueMetaData((byte)8)));
        put(Integer.valueOf(3), new FieldMetaData("adID", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(4), new FieldMetaData("adVersion", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(5), new FieldMetaData("adSlotType", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(6), new FieldMetaData("orientation", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(7), new FieldMetaData("clipType", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(8), new FieldMetaData("mainFile", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(9), new FieldMetaData("startDate", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(10), new FieldMetaData("endDate", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(11), new FieldMetaData("maxImpressions", (byte)3, new FieldValueMetaData((byte)8)));
        put(Integer.valueOf(12), new FieldMetaData("maxRunImpressions", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(13), new FieldMetaData("blockList", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        put(Integer.valueOf(14), new FieldMetaData("slotTargetNames", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdSlot))));
        put(Integer.valueOf(15), new FieldMetaData("slotTargetKeywords", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        put(Integer.valueOf(16), new FieldMetaData("slotBlockKeywords", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        put(Integer.valueOf(17), new FieldMetaData("clickURL", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(18), new FieldMetaData("displayTimes", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdFrequencyCap))));
        put(Integer.valueOf(19), new FieldMetaData("width", (byte)2, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(20), new FieldMetaData("height", (byte)2, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(21), new FieldMetaData("expandedWidth", (byte)2, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(22), new FieldMetaData("expandedHeight", (byte)2, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(23), new FieldMetaData("expandedMainFile", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(24), new FieldMetaData("displaysCloseButton", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(25), new FieldMetaData("expandableTitle", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(26), new FieldMetaData("closeButtonLibID", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(27), new FieldMetaData("closeButtonOrientation", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(28), new FieldMetaData("adWeight", (byte)2, new FieldValueMetaData((byte)4)));
        put(Integer.valueOf(29), new FieldMetaData("trackingPixels", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdTrackingPixel))));
        put(Integer.valueOf(30), new FieldMetaData("notForAdRotation", (byte)2, new FieldValueMetaData((byte)2)));
    }
}
