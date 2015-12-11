// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.IntRangeSet;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package com.medialets.thrift:
//            e, f, MMAdSlot, MMAdFrequencyCap, 
//            MMAdTrackingPixel, connectionState

public class MMAdControl
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField A = new TField("closeButtonLibID", (byte)11, (short)26);
    public static final int ADCONTROL = 1;
    public static final int ADID = 3;
    public static final int ADSLOTTYPE = 5;
    public static final int ADVERSION = 4;
    public static final int ADWEIGHT = 28;
    private static final TField B = new TField("closeButtonOrientation", (byte)11, (short)27);
    public static final int BLOCKLIST = 13;
    private static final TField C = new TField("adWeight", (byte)4, (short)28);
    public static final int CLICKURL = 17;
    public static final int CLIPTYPE = 7;
    public static final int CLOSEBUTTONLIBID = 26;
    public static final int CLOSEBUTTONORIENTATION = 27;
    private static final TField D = new TField("trackingPixels", (byte)15, (short)29);
    public static final int DISPLAYSCLOSEBUTTON = 24;
    public static final int DISPLAYTIMES = 18;
    private static final TField E = new TField("notForAdRotation", (byte)2, (short)30);
    public static final int ENDDATE = 10;
    public static final int EXPANDABLETITLE = 25;
    public static final int EXPANDEDHEIGHT = 22;
    public static final int EXPANDEDMAINFILE = 23;
    public static final int EXPANDEDWIDTH = 21;
    public static final int HEIGHT = 20;
    public static final int MAINFILE = 8;
    public static final int MAXIMPRESSIONS = 11;
    public static final int MAXRUNIMPRESSIONS = 12;
    public static final int MINIMUMCONNECTION = 2;
    public static final int NOTFORADROTATION = 30;
    public static final int ORIENTATION = 6;
    public static final int SLOTBLOCKKEYWORDS = 16;
    public static final int SLOTTARGETKEYWORDS = 15;
    public static final int SLOTTARGETNAMES = 14;
    public static final int STARTDATE = 9;
    public static final int TRACKINGPIXELS = 29;
    public static final int WIDTH = 19;
    private static final TStruct a = new TStruct("MMAdControl");
    private static final TField b = new TField("adControl", (byte)11, (short)1);
    private static final TField c = new TField("minimumConnection", (byte)8, (short)2);
    private static final TField d = new TField("adID", (byte)11, (short)3);
    private static final TField e = new TField("adVersion", (byte)11, (short)4);
    private static final TField f = new TField("adSlotType", (byte)6, (short)5);
    public static final Map fieldNameMap = Collections.unmodifiableMap(new e());
    private static final TField g = new TField("orientation", (byte)6, (short)6);
    private static final TField h = new TField("clipType", (byte)6, (short)7);
    private static final TField i = new TField("mainFile", (byte)11, (short)8);
    private static final TField j = new TField("startDate", (byte)11, (short)9);
    private static final TField k = new TField("endDate", (byte)11, (short)10);
    private static final TField l = new TField("maxImpressions", (byte)8, (short)11);
    private static final TField m = new TField("maxRunImpressions", (byte)6, (short)12);
    public static final Map metaDataMap;
    private static final TField n = new TField("blockList", (byte)15, (short)13);
    private static final TField o = new TField("slotTargetNames", (byte)15, (short)14);
    private static final TField p = new TField("slotTargetKeywords", (byte)15, (short)15);
    private static final TField q = new TField("slotBlockKeywords", (byte)15, (short)16);
    private static final TField r = new TField("clickURL", (byte)11, (short)17);
    private static final TField s = new TField("displayTimes", (byte)15, (short)18);
    private static final TField t = new TField("width", (byte)6, (short)19);
    private static final TField u = new TField("height", (byte)6, (short)20);
    private static final TField v = new TField("expandedWidth", (byte)6, (short)21);
    private static final TField w = new TField("expandedHeight", (byte)6, (short)22);
    private static final TField x = new TField("expandedMainFile", (byte)11, (short)23);
    private static final TField y = new TField("displaysCloseButton", (byte)2, (short)24);
    private static final TField z = new TField("expandableTitle", (byte)11, (short)25);
    private BitSet F;
    public String adControl;
    public String adID;
    public short adSlotType;
    public String adVersion;
    public double adWeight;
    public List blockList;
    public String clickURL;
    public short clipType;
    public String closeButtonLibID;
    public String closeButtonOrientation;
    public List displayTimes;
    public boolean displaysCloseButton;
    public String endDate;
    public String expandableTitle;
    public short expandedHeight;
    public String expandedMainFile;
    public short expandedWidth;
    public short height;
    public String mainFile;
    public int maxImpressions;
    public short maxRunImpressions;
    public int minimumConnection;
    public boolean notForAdRotation;
    public short orientation;
    public List slotBlockKeywords;
    public List slotTargetKeywords;
    public List slotTargetNames;
    public String startDate;
    public List trackingPixels;
    public short width;

    public MMAdControl()
    {
        F = new BitSet(13);
    }

    public MMAdControl(MMAdControl mmadcontrol)
    {
        F = new BitSet(13);
        F.clear();
        F.or(mmadcontrol.F);
        if (mmadcontrol.isSetAdControl())
        {
            adControl = mmadcontrol.adControl;
        }
        minimumConnection = mmadcontrol.minimumConnection;
        if (mmadcontrol.isSetAdID())
        {
            adID = mmadcontrol.adID;
        }
        if (mmadcontrol.isSetAdVersion())
        {
            adVersion = mmadcontrol.adVersion;
        }
        adSlotType = mmadcontrol.adSlotType;
        orientation = mmadcontrol.orientation;
        clipType = mmadcontrol.clipType;
        if (mmadcontrol.isSetMainFile())
        {
            mainFile = mmadcontrol.mainFile;
        }
        if (mmadcontrol.isSetStartDate())
        {
            startDate = mmadcontrol.startDate;
        }
        if (mmadcontrol.isSetEndDate())
        {
            endDate = mmadcontrol.endDate;
        }
        maxImpressions = mmadcontrol.maxImpressions;
        maxRunImpressions = mmadcontrol.maxRunImpressions;
        if (!mmadcontrol.isSetBlockList()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = mmadcontrol.blockList.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        blockList = arraylist;
_L2:
        if (mmadcontrol.isSetSlotTargetNames())
        {
            arraylist = new ArrayList();
            for (iterator = mmadcontrol.slotTargetNames.iterator(); iterator.hasNext(); arraylist.add(new MMAdSlot((MMAdSlot)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_558;
            }

            slotTargetNames = arraylist;
        }
        if (mmadcontrol.isSetSlotTargetKeywords())
        {
            arraylist = new ArrayList();
            for (iterator = mmadcontrol.slotTargetKeywords.iterator(); iterator.hasNext(); arraylist.add((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_584;
            }

            slotTargetKeywords = arraylist;
        }
        if (mmadcontrol.isSetSlotBlockKeywords())
        {
            arraylist = new ArrayList();
            for (iterator = mmadcontrol.slotBlockKeywords.iterator(); iterator.hasNext(); arraylist.add((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_603;
            }

            slotBlockKeywords = arraylist;
        }
        if (mmadcontrol.isSetClickURL())
        {
            clickURL = mmadcontrol.clickURL;
        }
        if (mmadcontrol.isSetDisplayTimes())
        {
            arraylist = new ArrayList();
            for (iterator = mmadcontrol.displayTimes.iterator(); iterator.hasNext(); arraylist.add(new MMAdFrequencyCap((MMAdFrequencyCap)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_622;
            }

            displayTimes = arraylist;
        }
        width = mmadcontrol.width;
        height = mmadcontrol.height;
        expandedWidth = mmadcontrol.expandedWidth;
        expandedHeight = mmadcontrol.expandedHeight;
        if (mmadcontrol.isSetExpandedMainFile())
        {
            expandedMainFile = mmadcontrol.expandedMainFile;
        }
        displaysCloseButton = mmadcontrol.displaysCloseButton;
        if (mmadcontrol.isSetExpandableTitle())
        {
            expandableTitle = mmadcontrol.expandableTitle;
        }
        if (mmadcontrol.isSetCloseButtonLibID())
        {
            closeButtonLibID = mmadcontrol.closeButtonLibID;
        }
        if (mmadcontrol.isSetCloseButtonOrientation())
        {
            closeButtonOrientation = mmadcontrol.closeButtonOrientation;
        }
        adWeight = mmadcontrol.adWeight;
        if (mmadcontrol.isSetTrackingPixels())
        {
            arraylist = new ArrayList();
            for (iterator = mmadcontrol.trackingPixels.iterator(); iterator.hasNext(); arraylist.add(new MMAdTrackingPixel((MMAdTrackingPixel)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_648;
            }

            trackingPixels = arraylist;
        }
        notForAdRotation = mmadcontrol.notForAdRotation;
        return;
_L4:
        arraylist.add((String)iterator.next());
        if (true) goto _L6; else goto _L5
_L5:
    }

    public MMAdControl(String s1, int i1, String s2, String s3, short word0, short word1, short word2, 
            String s4, String s5, String s6, int j1, short word3)
    {
        this();
        adControl = s1;
        minimumConnection = i1;
        setMinimumConnectionIsSet(true);
        adID = s2;
        adVersion = s3;
        adSlotType = word0;
        setAdSlotTypeIsSet(true);
        orientation = word1;
        setOrientationIsSet(true);
        clipType = word2;
        setClipTypeIsSet(true);
        mainFile = s4;
        startDate = s5;
        endDate = s6;
        maxImpressions = j1;
        setMaxImpressionsIsSet(true);
        maxRunImpressions = word3;
        setMaxRunImpressionsIsSet(true);
    }

    public void addToBlockList(String s1)
    {
        if (blockList == null)
        {
            blockList = new ArrayList();
        }
        blockList.add(s1);
    }

    public void addToDisplayTimes(MMAdFrequencyCap mmadfrequencycap)
    {
        if (displayTimes == null)
        {
            displayTimes = new ArrayList();
        }
        displayTimes.add(mmadfrequencycap);
    }

    public void addToSlotBlockKeywords(String s1)
    {
        if (slotBlockKeywords == null)
        {
            slotBlockKeywords = new ArrayList();
        }
        slotBlockKeywords.add(s1);
    }

    public void addToSlotTargetKeywords(String s1)
    {
        if (slotTargetKeywords == null)
        {
            slotTargetKeywords = new ArrayList();
        }
        slotTargetKeywords.add(s1);
    }

    public void addToSlotTargetNames(MMAdSlot mmadslot)
    {
        if (slotTargetNames == null)
        {
            slotTargetNames = new ArrayList();
        }
        slotTargetNames.add(mmadslot);
    }

    public void addToTrackingPixels(MMAdTrackingPixel mmadtrackingpixel)
    {
        if (trackingPixels == null)
        {
            trackingPixels = new ArrayList();
        }
        trackingPixels.add(mmadtrackingpixel);
    }

    public MMAdControl clone()
    {
        return new MMAdControl(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public int compareTo(MMAdControl mmadcontrol)
    {
        int i1;
        if (!getClass().equals(mmadcontrol.getClass()))
        {
            i1 = getClass().getName().compareTo(mmadcontrol.getClass().getName());
        } else
        {
            int j1 = Boolean.valueOf(isSetAdControl()).compareTo(Boolean.valueOf(isSetAdControl()));
            i1 = j1;
            if (j1 == 0)
            {
                int k1 = TBaseHelper.compareTo(adControl, mmadcontrol.adControl);
                i1 = k1;
                if (k1 == 0)
                {
                    int l1 = Boolean.valueOf(isSetMinimumConnection()).compareTo(Boolean.valueOf(isSetMinimumConnection()));
                    i1 = l1;
                    if (l1 == 0)
                    {
                        int i2 = TBaseHelper.compareTo(minimumConnection, mmadcontrol.minimumConnection);
                        i1 = i2;
                        if (i2 == 0)
                        {
                            int j2 = Boolean.valueOf(isSetAdID()).compareTo(Boolean.valueOf(isSetAdID()));
                            i1 = j2;
                            if (j2 == 0)
                            {
                                int k2 = TBaseHelper.compareTo(adID, mmadcontrol.adID);
                                i1 = k2;
                                if (k2 == 0)
                                {
                                    int l2 = Boolean.valueOf(isSetAdVersion()).compareTo(Boolean.valueOf(isSetAdVersion()));
                                    i1 = l2;
                                    if (l2 == 0)
                                    {
                                        int i3 = TBaseHelper.compareTo(adVersion, mmadcontrol.adVersion);
                                        i1 = i3;
                                        if (i3 == 0)
                                        {
                                            int j3 = Boolean.valueOf(isSetAdSlotType()).compareTo(Boolean.valueOf(isSetAdSlotType()));
                                            i1 = j3;
                                            if (j3 == 0)
                                            {
                                                int k3 = TBaseHelper.compareTo(adSlotType, mmadcontrol.adSlotType);
                                                i1 = k3;
                                                if (k3 == 0)
                                                {
                                                    int l3 = Boolean.valueOf(isSetOrientation()).compareTo(Boolean.valueOf(isSetOrientation()));
                                                    i1 = l3;
                                                    if (l3 == 0)
                                                    {
                                                        int i4 = TBaseHelper.compareTo(orientation, mmadcontrol.orientation);
                                                        i1 = i4;
                                                        if (i4 == 0)
                                                        {
                                                            int j4 = Boolean.valueOf(isSetClipType()).compareTo(Boolean.valueOf(isSetClipType()));
                                                            i1 = j4;
                                                            if (j4 == 0)
                                                            {
                                                                int k4 = TBaseHelper.compareTo(clipType, mmadcontrol.clipType);
                                                                i1 = k4;
                                                                if (k4 == 0)
                                                                {
                                                                    int l4 = Boolean.valueOf(isSetMainFile()).compareTo(Boolean.valueOf(isSetMainFile()));
                                                                    i1 = l4;
                                                                    if (l4 == 0)
                                                                    {
                                                                        int i5 = TBaseHelper.compareTo(mainFile, mmadcontrol.mainFile);
                                                                        i1 = i5;
                                                                        if (i5 == 0)
                                                                        {
                                                                            int j5 = Boolean.valueOf(isSetStartDate()).compareTo(Boolean.valueOf(isSetStartDate()));
                                                                            i1 = j5;
                                                                            if (j5 == 0)
                                                                            {
                                                                                int k5 = TBaseHelper.compareTo(startDate, mmadcontrol.startDate);
                                                                                i1 = k5;
                                                                                if (k5 == 0)
                                                                                {
                                                                                    int l5 = Boolean.valueOf(isSetEndDate()).compareTo(Boolean.valueOf(isSetEndDate()));
                                                                                    i1 = l5;
                                                                                    if (l5 == 0)
                                                                                    {
                                                                                        int i6 = TBaseHelper.compareTo(endDate, mmadcontrol.endDate);
                                                                                        i1 = i6;
                                                                                        if (i6 == 0)
                                                                                        {
                                                                                            int j6 = Boolean.valueOf(isSetMaxImpressions()).compareTo(Boolean.valueOf(isSetMaxImpressions()));
                                                                                            i1 = j6;
                                                                                            if (j6 == 0)
                                                                                            {
                                                                                                int k6 = TBaseHelper.compareTo(maxImpressions, mmadcontrol.maxImpressions);
                                                                                                i1 = k6;
                                                                                                if (k6 == 0)
                                                                                                {
                                                                                                    int l6 = Boolean.valueOf(isSetMaxRunImpressions()).compareTo(Boolean.valueOf(isSetMaxRunImpressions()));
                                                                                                    i1 = l6;
                                                                                                    if (l6 == 0)
                                                                                                    {
                                                                                                        int i7 = TBaseHelper.compareTo(maxRunImpressions, mmadcontrol.maxRunImpressions);
                                                                                                        i1 = i7;
                                                                                                        if (i7 == 0)
                                                                                                        {
                                                                                                            int j7 = Boolean.valueOf(isSetBlockList()).compareTo(Boolean.valueOf(isSetBlockList()));
                                                                                                            i1 = j7;
                                                                                                            if (j7 == 0)
                                                                                                            {
                                                                                                                int k7 = TBaseHelper.compareTo(blockList, mmadcontrol.blockList);
                                                                                                                i1 = k7;
                                                                                                                if (k7 == 0)
                                                                                                                {
                                                                                                                    int l7 = Boolean.valueOf(isSetSlotTargetNames()).compareTo(Boolean.valueOf(isSetSlotTargetNames()));
                                                                                                                    i1 = l7;
                                                                                                                    if (l7 == 0)
                                                                                                                    {
                                                                                                                        int i8 = TBaseHelper.compareTo(slotTargetNames, mmadcontrol.slotTargetNames);
                                                                                                                        i1 = i8;
                                                                                                                        if (i8 == 0)
                                                                                                                        {
                                                                                                                            int j8 = Boolean.valueOf(isSetSlotTargetKeywords()).compareTo(Boolean.valueOf(isSetSlotTargetKeywords()));
                                                                                                                            i1 = j8;
                                                                                                                            if (j8 == 0)
                                                                                                                            {
                                                                                                                                int k8 = TBaseHelper.compareTo(slotTargetKeywords, mmadcontrol.slotTargetKeywords);
                                                                                                                                i1 = k8;
                                                                                                                                if (k8 == 0)
                                                                                                                                {
                                                                                                                                    int l8 = Boolean.valueOf(isSetSlotBlockKeywords()).compareTo(Boolean.valueOf(isSetSlotBlockKeywords()));
                                                                                                                                    i1 = l8;
                                                                                                                                    if (l8 == 0)
                                                                                                                                    {
                                                                                                                                        int i9 = TBaseHelper.compareTo(slotBlockKeywords, mmadcontrol.slotBlockKeywords);
                                                                                                                                        i1 = i9;
                                                                                                                                        if (i9 == 0)
                                                                                                                                        {
                                                                                                                                            int j9 = Boolean.valueOf(isSetClickURL()).compareTo(Boolean.valueOf(isSetClickURL()));
                                                                                                                                            i1 = j9;
                                                                                                                                            if (j9 == 0)
                                                                                                                                            {
                                                                                                                                                int k9 = TBaseHelper.compareTo(clickURL, mmadcontrol.clickURL);
                                                                                                                                                i1 = k9;
                                                                                                                                                if (k9 == 0)
                                                                                                                                                {
                                                                                                                                                    int l9 = Boolean.valueOf(isSetDisplayTimes()).compareTo(Boolean.valueOf(isSetDisplayTimes()));
                                                                                                                                                    i1 = l9;
                                                                                                                                                    if (l9 == 0)
                                                                                                                                                    {
                                                                                                                                                        int i10 = TBaseHelper.compareTo(displayTimes, mmadcontrol.displayTimes);
                                                                                                                                                        i1 = i10;
                                                                                                                                                        if (i10 == 0)
                                                                                                                                                        {
                                                                                                                                                            int j10 = Boolean.valueOf(isSetWidth()).compareTo(Boolean.valueOf(isSetWidth()));
                                                                                                                                                            i1 = j10;
                                                                                                                                                            if (j10 == 0)
                                                                                                                                                            {
                                                                                                                                                                int k10 = TBaseHelper.compareTo(width, mmadcontrol.width);
                                                                                                                                                                i1 = k10;
                                                                                                                                                                if (k10 == 0)
                                                                                                                                                                {
                                                                                                                                                                    int l10 = Boolean.valueOf(isSetHeight()).compareTo(Boolean.valueOf(isSetHeight()));
                                                                                                                                                                    i1 = l10;
                                                                                                                                                                    if (l10 == 0)
                                                                                                                                                                    {
                                                                                                                                                                        int i11 = TBaseHelper.compareTo(height, mmadcontrol.height);
                                                                                                                                                                        i1 = i11;
                                                                                                                                                                        if (i11 == 0)
                                                                                                                                                                        {
                                                                                                                                                                            int j11 = Boolean.valueOf(isSetExpandedWidth()).compareTo(Boolean.valueOf(isSetExpandedWidth()));
                                                                                                                                                                            i1 = j11;
                                                                                                                                                                            if (j11 == 0)
                                                                                                                                                                            {
                                                                                                                                                                                int k11 = TBaseHelper.compareTo(expandedWidth, mmadcontrol.expandedWidth);
                                                                                                                                                                                i1 = k11;
                                                                                                                                                                                if (k11 == 0)
                                                                                                                                                                                {
                                                                                                                                                                                    int l11 = Boolean.valueOf(isSetExpandedHeight()).compareTo(Boolean.valueOf(isSetExpandedHeight()));
                                                                                                                                                                                    i1 = l11;
                                                                                                                                                                                    if (l11 == 0)
                                                                                                                                                                                    {
                                                                                                                                                                                        int i12 = TBaseHelper.compareTo(expandedHeight, mmadcontrol.expandedHeight);
                                                                                                                                                                                        i1 = i12;
                                                                                                                                                                                        if (i12 == 0)
                                                                                                                                                                                        {
                                                                                                                                                                                            int j12 = Boolean.valueOf(isSetExpandedMainFile()).compareTo(Boolean.valueOf(isSetExpandedMainFile()));
                                                                                                                                                                                            i1 = j12;
                                                                                                                                                                                            if (j12 == 0)
                                                                                                                                                                                            {
                                                                                                                                                                                                int k12 = TBaseHelper.compareTo(expandedMainFile, mmadcontrol.expandedMainFile);
                                                                                                                                                                                                i1 = k12;
                                                                                                                                                                                                if (k12 == 0)
                                                                                                                                                                                                {
                                                                                                                                                                                                    int l12 = Boolean.valueOf(isSetDisplaysCloseButton()).compareTo(Boolean.valueOf(isSetDisplaysCloseButton()));
                                                                                                                                                                                                    i1 = l12;
                                                                                                                                                                                                    if (l12 == 0)
                                                                                                                                                                                                    {
                                                                                                                                                                                                        int i13 = TBaseHelper.compareTo(displaysCloseButton, mmadcontrol.displaysCloseButton);
                                                                                                                                                                                                        i1 = i13;
                                                                                                                                                                                                        if (i13 == 0)
                                                                                                                                                                                                        {
                                                                                                                                                                                                            int j13 = Boolean.valueOf(isSetExpandableTitle()).compareTo(Boolean.valueOf(isSetExpandableTitle()));
                                                                                                                                                                                                            i1 = j13;
                                                                                                                                                                                                            if (j13 == 0)
                                                                                                                                                                                                            {
                                                                                                                                                                                                                int k13 = TBaseHelper.compareTo(expandableTitle, mmadcontrol.expandableTitle);
                                                                                                                                                                                                                i1 = k13;
                                                                                                                                                                                                                if (k13 == 0)
                                                                                                                                                                                                                {
                                                                                                                                                                                                                    int l13 = Boolean.valueOf(isSetCloseButtonLibID()).compareTo(Boolean.valueOf(isSetCloseButtonLibID()));
                                                                                                                                                                                                                    i1 = l13;
                                                                                                                                                                                                                    if (l13 == 0)
                                                                                                                                                                                                                    {
                                                                                                                                                                                                                        int i14 = TBaseHelper.compareTo(closeButtonLibID, mmadcontrol.closeButtonLibID);
                                                                                                                                                                                                                        i1 = i14;
                                                                                                                                                                                                                        if (i14 == 0)
                                                                                                                                                                                                                        {
                                                                                                                                                                                                                            int j14 = Boolean.valueOf(isSetCloseButtonOrientation()).compareTo(Boolean.valueOf(isSetCloseButtonOrientation()));
                                                                                                                                                                                                                            i1 = j14;
                                                                                                                                                                                                                            if (j14 == 0)
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                int k14 = TBaseHelper.compareTo(closeButtonOrientation, mmadcontrol.closeButtonOrientation);
                                                                                                                                                                                                                                i1 = k14;
                                                                                                                                                                                                                                if (k14 == 0)
                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                    int l14 = Boolean.valueOf(isSetAdWeight()).compareTo(Boolean.valueOf(isSetAdWeight()));
                                                                                                                                                                                                                                    i1 = l14;
                                                                                                                                                                                                                                    if (l14 == 0)
                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                        int i15 = TBaseHelper.compareTo(adWeight, mmadcontrol.adWeight);
                                                                                                                                                                                                                                        i1 = i15;
                                                                                                                                                                                                                                        if (i15 == 0)
                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                            int j15 = Boolean.valueOf(isSetTrackingPixels()).compareTo(Boolean.valueOf(isSetTrackingPixels()));
                                                                                                                                                                                                                                            i1 = j15;
                                                                                                                                                                                                                                            if (j15 == 0)
                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                                int k15 = TBaseHelper.compareTo(trackingPixels, mmadcontrol.trackingPixels);
                                                                                                                                                                                                                                                i1 = k15;
                                                                                                                                                                                                                                                if (k15 == 0)
                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                    int l15 = Boolean.valueOf(isSetNotForAdRotation()).compareTo(Boolean.valueOf(isSetNotForAdRotation()));
                                                                                                                                                                                                                                                    i1 = l15;
                                                                                                                                                                                                                                                    if (l15 == 0)
                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                        int i16 = TBaseHelper.compareTo(notForAdRotation, mmadcontrol.notForAdRotation);
                                                                                                                                                                                                                                                        i1 = i16;
                                                                                                                                                                                                                                                        if (i16 == 0)
                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                            return 0;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return i1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((MMAdControl)obj);
    }

    public MMAdControl deepCopy()
    {
        return new MMAdControl(this);
    }

    public boolean equals(MMAdControl mmadcontrol)
    {
        if (mmadcontrol != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetAdControl())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmadcontrol.isSetAdControl())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if ((!flag && !flag1 || flag && flag1 && adControl.equals(mmadcontrol.adControl)) && minimumConnection == mmadcontrol.minimumConnection)
            {
                if (isSetAdID())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (mmadcontrol.isSetAdID())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && adID.equals(mmadcontrol.adID))
                {
                    if (isSetAdVersion())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (mmadcontrol.isSetAdVersion())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if ((!flag && !flag1 || flag && flag1 && adVersion.equals(mmadcontrol.adVersion)) && adSlotType == mmadcontrol.adSlotType && orientation == mmadcontrol.orientation && clipType == mmadcontrol.clipType)
                    {
                        if (isSetMainFile())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (mmadcontrol.isSetMainFile())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && mainFile.equals(mmadcontrol.mainFile))
                        {
                            if (isSetStartDate())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (mmadcontrol.isSetStartDate())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && startDate.equals(mmadcontrol.startDate))
                            {
                                if (isSetEndDate())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (mmadcontrol.isSetEndDate())
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if ((!flag && !flag1 || flag && flag1 && endDate.equals(mmadcontrol.endDate)) && maxImpressions == mmadcontrol.maxImpressions && maxRunImpressions == mmadcontrol.maxRunImpressions)
                                {
                                    if (isSetBlockList())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (mmadcontrol.isSetBlockList())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (!flag && !flag1 || flag && flag1 && blockList.equals(mmadcontrol.blockList))
                                    {
                                        if (isSetSlotTargetNames())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        if (mmadcontrol.isSetSlotTargetNames())
                                        {
                                            flag1 = true;
                                        } else
                                        {
                                            flag1 = false;
                                        }
                                        if (!flag && !flag1 || flag && flag1 && slotTargetNames.equals(mmadcontrol.slotTargetNames))
                                        {
                                            if (isSetSlotTargetKeywords())
                                            {
                                                flag = true;
                                            } else
                                            {
                                                flag = false;
                                            }
                                            if (mmadcontrol.isSetSlotTargetKeywords())
                                            {
                                                flag1 = true;
                                            } else
                                            {
                                                flag1 = false;
                                            }
                                            if (!flag && !flag1 || flag && flag1 && slotTargetKeywords.equals(mmadcontrol.slotTargetKeywords))
                                            {
                                                if (isSetSlotBlockKeywords())
                                                {
                                                    flag = true;
                                                } else
                                                {
                                                    flag = false;
                                                }
                                                if (mmadcontrol.isSetSlotBlockKeywords())
                                                {
                                                    flag1 = true;
                                                } else
                                                {
                                                    flag1 = false;
                                                }
                                                if (!flag && !flag1 || flag && flag1 && slotBlockKeywords.equals(mmadcontrol.slotBlockKeywords))
                                                {
                                                    if (isSetClickURL())
                                                    {
                                                        flag = true;
                                                    } else
                                                    {
                                                        flag = false;
                                                    }
                                                    if (mmadcontrol.isSetClickURL())
                                                    {
                                                        flag1 = true;
                                                    } else
                                                    {
                                                        flag1 = false;
                                                    }
                                                    if (!flag && !flag1 || flag && flag1 && clickURL.equals(mmadcontrol.clickURL))
                                                    {
                                                        if (isSetDisplayTimes())
                                                        {
                                                            flag = true;
                                                        } else
                                                        {
                                                            flag = false;
                                                        }
                                                        if (mmadcontrol.isSetDisplayTimes())
                                                        {
                                                            flag1 = true;
                                                        } else
                                                        {
                                                            flag1 = false;
                                                        }
                                                        if (!flag && !flag1 || flag && flag1 && displayTimes.equals(mmadcontrol.displayTimes))
                                                        {
                                                            if (isSetWidth())
                                                            {
                                                                flag = true;
                                                            } else
                                                            {
                                                                flag = false;
                                                            }
                                                            if (mmadcontrol.isSetWidth())
                                                            {
                                                                flag1 = true;
                                                            } else
                                                            {
                                                                flag1 = false;
                                                            }
                                                            if (!flag && !flag1 || flag && flag1 && width == mmadcontrol.width)
                                                            {
                                                                if (isSetHeight())
                                                                {
                                                                    flag = true;
                                                                } else
                                                                {
                                                                    flag = false;
                                                                }
                                                                if (mmadcontrol.isSetHeight())
                                                                {
                                                                    flag1 = true;
                                                                } else
                                                                {
                                                                    flag1 = false;
                                                                }
                                                                if (!flag && !flag1 || flag && flag1 && height == mmadcontrol.height)
                                                                {
                                                                    if (isSetExpandedWidth())
                                                                    {
                                                                        flag = true;
                                                                    } else
                                                                    {
                                                                        flag = false;
                                                                    }
                                                                    if (mmadcontrol.isSetExpandedWidth())
                                                                    {
                                                                        flag1 = true;
                                                                    } else
                                                                    {
                                                                        flag1 = false;
                                                                    }
                                                                    if (!flag && !flag1 || flag && flag1 && expandedWidth == mmadcontrol.expandedWidth)
                                                                    {
                                                                        if (isSetExpandedHeight())
                                                                        {
                                                                            flag = true;
                                                                        } else
                                                                        {
                                                                            flag = false;
                                                                        }
                                                                        if (mmadcontrol.isSetExpandedHeight())
                                                                        {
                                                                            flag1 = true;
                                                                        } else
                                                                        {
                                                                            flag1 = false;
                                                                        }
                                                                        if (!flag && !flag1 || flag && flag1 && expandedHeight == mmadcontrol.expandedHeight)
                                                                        {
                                                                            if (isSetExpandedMainFile())
                                                                            {
                                                                                flag = true;
                                                                            } else
                                                                            {
                                                                                flag = false;
                                                                            }
                                                                            if (mmadcontrol.isSetExpandedMainFile())
                                                                            {
                                                                                flag1 = true;
                                                                            } else
                                                                            {
                                                                                flag1 = false;
                                                                            }
                                                                            if (!flag && !flag1 || flag && flag1 && expandedMainFile.equals(mmadcontrol.expandedMainFile))
                                                                            {
                                                                                if (isSetDisplaysCloseButton())
                                                                                {
                                                                                    flag = true;
                                                                                } else
                                                                                {
                                                                                    flag = false;
                                                                                }
                                                                                if (mmadcontrol.isSetDisplaysCloseButton())
                                                                                {
                                                                                    flag1 = true;
                                                                                } else
                                                                                {
                                                                                    flag1 = false;
                                                                                }
                                                                                if (!flag && !flag1 || flag && flag1 && displaysCloseButton == mmadcontrol.displaysCloseButton)
                                                                                {
                                                                                    if (isSetExpandableTitle())
                                                                                    {
                                                                                        flag = true;
                                                                                    } else
                                                                                    {
                                                                                        flag = false;
                                                                                    }
                                                                                    if (mmadcontrol.isSetExpandableTitle())
                                                                                    {
                                                                                        flag1 = true;
                                                                                    } else
                                                                                    {
                                                                                        flag1 = false;
                                                                                    }
                                                                                    if (!flag && !flag1 || flag && flag1 && expandableTitle.equals(mmadcontrol.expandableTitle))
                                                                                    {
                                                                                        if (isSetCloseButtonLibID())
                                                                                        {
                                                                                            flag = true;
                                                                                        } else
                                                                                        {
                                                                                            flag = false;
                                                                                        }
                                                                                        if (mmadcontrol.isSetCloseButtonLibID())
                                                                                        {
                                                                                            flag1 = true;
                                                                                        } else
                                                                                        {
                                                                                            flag1 = false;
                                                                                        }
                                                                                        if (!flag && !flag1 || flag && flag1 && closeButtonLibID.equals(mmadcontrol.closeButtonLibID))
                                                                                        {
                                                                                            if (isSetCloseButtonOrientation())
                                                                                            {
                                                                                                flag = true;
                                                                                            } else
                                                                                            {
                                                                                                flag = false;
                                                                                            }
                                                                                            if (mmadcontrol.isSetCloseButtonOrientation())
                                                                                            {
                                                                                                flag1 = true;
                                                                                            } else
                                                                                            {
                                                                                                flag1 = false;
                                                                                            }
                                                                                            if (!flag && !flag1 || flag && flag1 && closeButtonOrientation.equals(mmadcontrol.closeButtonOrientation))
                                                                                            {
                                                                                                if (isSetAdWeight())
                                                                                                {
                                                                                                    flag = true;
                                                                                                } else
                                                                                                {
                                                                                                    flag = false;
                                                                                                }
                                                                                                if (mmadcontrol.isSetAdWeight())
                                                                                                {
                                                                                                    flag1 = true;
                                                                                                } else
                                                                                                {
                                                                                                    flag1 = false;
                                                                                                }
                                                                                                if (!flag && !flag1 || flag && flag1 && adWeight == mmadcontrol.adWeight)
                                                                                                {
                                                                                                    if (isSetTrackingPixels())
                                                                                                    {
                                                                                                        flag = true;
                                                                                                    } else
                                                                                                    {
                                                                                                        flag = false;
                                                                                                    }
                                                                                                    if (mmadcontrol.isSetTrackingPixels())
                                                                                                    {
                                                                                                        flag1 = true;
                                                                                                    } else
                                                                                                    {
                                                                                                        flag1 = false;
                                                                                                    }
                                                                                                    if (!flag && !flag1 || flag && flag1 && trackingPixels.equals(mmadcontrol.trackingPixels))
                                                                                                    {
                                                                                                        if (isSetNotForAdRotation())
                                                                                                        {
                                                                                                            flag = true;
                                                                                                        } else
                                                                                                        {
                                                                                                            flag = false;
                                                                                                        }
                                                                                                        if (mmadcontrol.isSetNotForAdRotation())
                                                                                                        {
                                                                                                            flag1 = true;
                                                                                                        } else
                                                                                                        {
                                                                                                            flag1 = false;
                                                                                                        }
                                                                                                        if (!flag && !flag1 || flag && flag1 && notForAdRotation == mmadcontrol.notForAdRotation)
                                                                                                        {
                                                                                                            return true;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMAdControl)) 
        {
            return false;
        }
        return equals((MMAdControl)obj);
    }

    public String getAdControl()
    {
        return adControl;
    }

    public String getAdID()
    {
        return adID;
    }

    public short getAdSlotType()
    {
        return adSlotType;
    }

    public String getAdVersion()
    {
        return adVersion;
    }

    public double getAdWeight()
    {
        return adWeight;
    }

    public List getBlockList()
    {
        return blockList;
    }

    public Iterator getBlockListIterator()
    {
        if (blockList == null)
        {
            return null;
        } else
        {
            return blockList.iterator();
        }
    }

    public int getBlockListSize()
    {
        if (blockList == null)
        {
            return 0;
        } else
        {
            return blockList.size();
        }
    }

    public String getClickURL()
    {
        return clickURL;
    }

    public short getClipType()
    {
        return clipType;
    }

    public String getCloseButtonLibID()
    {
        return closeButtonLibID;
    }

    public String getCloseButtonOrientation()
    {
        return closeButtonOrientation;
    }

    public List getDisplayTimes()
    {
        return displayTimes;
    }

    public Iterator getDisplayTimesIterator()
    {
        if (displayTimes == null)
        {
            return null;
        } else
        {
            return displayTimes.iterator();
        }
    }

    public int getDisplayTimesSize()
    {
        if (displayTimes == null)
        {
            return 0;
        } else
        {
            return displayTimes.size();
        }
    }

    public String getEndDate()
    {
        return endDate;
    }

    public String getExpandableTitle()
    {
        return expandableTitle;
    }

    public short getExpandedHeight()
    {
        return expandedHeight;
    }

    public String getExpandedMainFile()
    {
        return expandedMainFile;
    }

    public short getExpandedWidth()
    {
        return expandedWidth;
    }

    public Object getFieldValue(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getAdControl();

        case 2: // '\002'
            return Integer.valueOf(getMinimumConnection());

        case 3: // '\003'
            return getAdID();

        case 4: // '\004'
            return getAdVersion();

        case 5: // '\005'
            return new Short(getAdSlotType());

        case 6: // '\006'
            return new Short(getOrientation());

        case 7: // '\007'
            return new Short(getClipType());

        case 8: // '\b'
            return getMainFile();

        case 9: // '\t'
            return getStartDate();

        case 10: // '\n'
            return getEndDate();

        case 11: // '\013'
            return new Integer(getMaxImpressions());

        case 12: // '\f'
            return new Short(getMaxRunImpressions());

        case 13: // '\r'
            return getBlockList();

        case 14: // '\016'
            return getSlotTargetNames();

        case 15: // '\017'
            return getSlotTargetKeywords();

        case 16: // '\020'
            return getSlotBlockKeywords();

        case 17: // '\021'
            return getClickURL();

        case 18: // '\022'
            return getDisplayTimes();

        case 19: // '\023'
            return new Short(getWidth());

        case 20: // '\024'
            return new Short(getHeight());

        case 21: // '\025'
            return new Short(getExpandedWidth());

        case 22: // '\026'
            return new Short(getExpandedHeight());

        case 23: // '\027'
            return getExpandedMainFile();

        case 24: // '\030'
            return new Boolean(isDisplaysCloseButton());

        case 25: // '\031'
            return getExpandableTitle();

        case 26: // '\032'
            return getCloseButtonLibID();

        case 27: // '\033'
            return getCloseButtonOrientation();

        case 28: // '\034'
            return new Double(getAdWeight());

        case 29: // '\035'
            return getTrackingPixels();

        case 30: // '\036'
            return new Boolean(isNotForAdRotation());
        }
    }

    public short getHeight()
    {
        return height;
    }

    public String getMainFile()
    {
        return mainFile;
    }

    public int getMaxImpressions()
    {
        return maxImpressions;
    }

    public short getMaxRunImpressions()
    {
        return maxRunImpressions;
    }

    public int getMinimumConnection()
    {
        return minimumConnection;
    }

    public short getOrientation()
    {
        return orientation;
    }

    public List getSlotBlockKeywords()
    {
        return slotBlockKeywords;
    }

    public Iterator getSlotBlockKeywordsIterator()
    {
        if (slotBlockKeywords == null)
        {
            return null;
        } else
        {
            return slotBlockKeywords.iterator();
        }
    }

    public int getSlotBlockKeywordsSize()
    {
        if (slotBlockKeywords == null)
        {
            return 0;
        } else
        {
            return slotBlockKeywords.size();
        }
    }

    public List getSlotTargetKeywords()
    {
        return slotTargetKeywords;
    }

    public Iterator getSlotTargetKeywordsIterator()
    {
        if (slotTargetKeywords == null)
        {
            return null;
        } else
        {
            return slotTargetKeywords.iterator();
        }
    }

    public int getSlotTargetKeywordsSize()
    {
        if (slotTargetKeywords == null)
        {
            return 0;
        } else
        {
            return slotTargetKeywords.size();
        }
    }

    public List getSlotTargetNames()
    {
        return slotTargetNames;
    }

    public Iterator getSlotTargetNamesIterator()
    {
        if (slotTargetNames == null)
        {
            return null;
        } else
        {
            return slotTargetNames.iterator();
        }
    }

    public int getSlotTargetNamesSize()
    {
        if (slotTargetNames == null)
        {
            return 0;
        } else
        {
            return slotTargetNames.size();
        }
    }

    public String getStartDate()
    {
        return startDate;
    }

    public List getTrackingPixels()
    {
        return trackingPixels;
    }

    public Iterator getTrackingPixelsIterator()
    {
        if (trackingPixels == null)
        {
            return null;
        } else
        {
            return trackingPixels.iterator();
        }
    }

    public int getTrackingPixelsSize()
    {
        if (trackingPixels == null)
        {
            return 0;
        } else
        {
            return trackingPixels.size();
        }
    }

    public short getWidth()
    {
        return width;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isDisplaysCloseButton()
    {
        return displaysCloseButton;
    }

    public boolean isNotForAdRotation()
    {
        return notForAdRotation;
    }

    public boolean isSet(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetAdControl();

        case 2: // '\002'
            return isSetMinimumConnection();

        case 3: // '\003'
            return isSetAdID();

        case 4: // '\004'
            return isSetAdVersion();

        case 5: // '\005'
            return isSetAdSlotType();

        case 6: // '\006'
            return isSetOrientation();

        case 7: // '\007'
            return isSetClipType();

        case 8: // '\b'
            return isSetMainFile();

        case 9: // '\t'
            return isSetStartDate();

        case 10: // '\n'
            return isSetEndDate();

        case 11: // '\013'
            return isSetMaxImpressions();

        case 12: // '\f'
            return isSetMaxRunImpressions();

        case 13: // '\r'
            return isSetBlockList();

        case 14: // '\016'
            return isSetSlotTargetNames();

        case 15: // '\017'
            return isSetSlotTargetKeywords();

        case 16: // '\020'
            return isSetSlotBlockKeywords();

        case 17: // '\021'
            return isSetClickURL();

        case 18: // '\022'
            return isSetDisplayTimes();

        case 19: // '\023'
            return isSetWidth();

        case 20: // '\024'
            return isSetHeight();

        case 21: // '\025'
            return isSetExpandedWidth();

        case 22: // '\026'
            return isSetExpandedHeight();

        case 23: // '\027'
            return isSetExpandedMainFile();

        case 24: // '\030'
            return isSetDisplaysCloseButton();

        case 25: // '\031'
            return isSetExpandableTitle();

        case 26: // '\032'
            return isSetCloseButtonLibID();

        case 27: // '\033'
            return isSetCloseButtonOrientation();

        case 28: // '\034'
            return isSetAdWeight();

        case 29: // '\035'
            return isSetTrackingPixels();

        case 30: // '\036'
            return isSetNotForAdRotation();
        }
    }

    public boolean isSetAdControl()
    {
        return adControl != null;
    }

    public boolean isSetAdID()
    {
        return adID != null;
    }

    public boolean isSetAdSlotType()
    {
        return F.get(1);
    }

    public boolean isSetAdVersion()
    {
        return adVersion != null;
    }

    public boolean isSetAdWeight()
    {
        return F.get(11);
    }

    public boolean isSetBlockList()
    {
        return blockList != null;
    }

    public boolean isSetClickURL()
    {
        return clickURL != null;
    }

    public boolean isSetClipType()
    {
        return F.get(3);
    }

    public boolean isSetCloseButtonLibID()
    {
        return closeButtonLibID != null;
    }

    public boolean isSetCloseButtonOrientation()
    {
        return closeButtonOrientation != null;
    }

    public boolean isSetDisplayTimes()
    {
        return displayTimes != null;
    }

    public boolean isSetDisplaysCloseButton()
    {
        return F.get(10);
    }

    public boolean isSetEndDate()
    {
        return endDate != null;
    }

    public boolean isSetExpandableTitle()
    {
        return expandableTitle != null;
    }

    public boolean isSetExpandedHeight()
    {
        return F.get(9);
    }

    public boolean isSetExpandedMainFile()
    {
        return expandedMainFile != null;
    }

    public boolean isSetExpandedWidth()
    {
        return F.get(8);
    }

    public boolean isSetHeight()
    {
        return F.get(7);
    }

    public boolean isSetMainFile()
    {
        return mainFile != null;
    }

    public boolean isSetMaxImpressions()
    {
        return F.get(4);
    }

    public boolean isSetMaxRunImpressions()
    {
        return F.get(5);
    }

    public boolean isSetMinimumConnection()
    {
        return F.get(0);
    }

    public boolean isSetNotForAdRotation()
    {
        return F.get(12);
    }

    public boolean isSetOrientation()
    {
        return F.get(2);
    }

    public boolean isSetSlotBlockKeywords()
    {
        return slotBlockKeywords != null;
    }

    public boolean isSetSlotTargetKeywords()
    {
        return slotTargetKeywords != null;
    }

    public boolean isSetSlotTargetNames()
    {
        return slotTargetNames != null;
    }

    public boolean isSetStartDate()
    {
        return startDate != null;
    }

    public boolean isSetTrackingPixels()
    {
        return trackingPixels != null;
    }

    public boolean isSetWidth()
    {
        return F.get(6);
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L33:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_1505;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 30: default 156
    //                   1 171
    //                   2 202
    //                   3 238
    //                   4 269
    //                   5 300
    //                   6 336
    //                   7 372
    //                   8 408
    //                   9 439
    //                   10 470
    //                   11 501
    //                   12 537
    //                   13 573
    //                   14 657
    //                   15 749
    //                   16 833
    //                   17 917
    //                   18 948
    //                   19 1040
    //                   20 1076
    //                   21 1112
    //                   22 1148
    //                   23 1184
    //                   24 1215
    //                   25 1250
    //                   26 1281
    //                   27 1312
    //                   28 1343
    //                   29 1378
    //                   30 1470;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31
_L2:
        break; /* Loop/switch isn't completed */
_L31:
        break MISSING_BLOCK_LABEL_1470;
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L34:
        tprotocol.readFieldEnd();
        if (true) goto _L33; else goto _L32
_L32:
        if (((TField) (obj)).type == 11)
        {
            adControl = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L3:
        if (((TField) (obj)).type == 8)
        {
            minimumConnection = tprotocol.readI32();
            setMinimumConnectionIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L4:
        if (((TField) (obj)).type == 11)
        {
            adID = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L5:
        if (((TField) (obj)).type == 11)
        {
            adVersion = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L6:
        if (((TField) (obj)).type == 6)
        {
            adSlotType = tprotocol.readI16();
            setAdSlotTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L7:
        if (((TField) (obj)).type == 6)
        {
            orientation = tprotocol.readI16();
            setOrientationIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L8:
        if (((TField) (obj)).type == 6)
        {
            clipType = tprotocol.readI16();
            setClipTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L9:
        if (((TField) (obj)).type == 11)
        {
            mainFile = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L10:
        if (((TField) (obj)).type == 11)
        {
            startDate = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L11:
        if (((TField) (obj)).type == 11)
        {
            endDate = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L12:
        if (((TField) (obj)).type == 8)
        {
            maxImpressions = tprotocol.readI32();
            setMaxImpressionsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L13:
        if (((TField) (obj)).type == 6)
        {
            maxRunImpressions = tprotocol.readI16();
            setMaxRunImpressionsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L14:
        int i1;
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_646;
        }
        obj = tprotocol.readListBegin();
        blockList = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L35:
label0:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label0;
            }
            tprotocol.readListEnd();
        }
          goto _L34
        String s1 = tprotocol.readString();
        blockList.add(s1);
        i1++;
          goto _L35
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L34
_L15:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_738;
        }
        obj = tprotocol.readListBegin();
        slotTargetNames = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L36:
label1:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label1;
            }
            tprotocol.readListEnd();
        }
          goto _L34
        MMAdSlot mmadslot = new MMAdSlot();
        mmadslot.read(tprotocol);
        slotTargetNames.add(mmadslot);
        i1++;
          goto _L36
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L34
_L16:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_822;
        }
        obj = tprotocol.readListBegin();
        slotTargetKeywords = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L37:
label2:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label2;
            }
            tprotocol.readListEnd();
        }
          goto _L34
        String s2 = tprotocol.readString();
        slotTargetKeywords.add(s2);
        i1++;
          goto _L37
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L34
_L17:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_906;
        }
        obj = tprotocol.readListBegin();
        slotBlockKeywords = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L38:
label3:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label3;
            }
            tprotocol.readListEnd();
        }
          goto _L34
        String s3 = tprotocol.readString();
        slotBlockKeywords.add(s3);
        i1++;
          goto _L38
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L34
_L18:
        if (((TField) (obj)).type == 11)
        {
            clickURL = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L19:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_1029;
        }
        obj = tprotocol.readListBegin();
        displayTimes = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L39:
label4:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label4;
            }
            tprotocol.readListEnd();
        }
          goto _L34
        MMAdFrequencyCap mmadfrequencycap = new MMAdFrequencyCap();
        mmadfrequencycap.read(tprotocol);
        displayTimes.add(mmadfrequencycap);
        i1++;
          goto _L39
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L34
_L20:
        if (((TField) (obj)).type == 6)
        {
            width = tprotocol.readI16();
            setWidthIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L21:
        if (((TField) (obj)).type == 6)
        {
            height = tprotocol.readI16();
            setHeightIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L22:
        if (((TField) (obj)).type == 6)
        {
            expandedWidth = tprotocol.readI16();
            setExpandedWidthIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L23:
        if (((TField) (obj)).type == 6)
        {
            expandedHeight = tprotocol.readI16();
            setExpandedHeightIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L24:
        if (((TField) (obj)).type == 11)
        {
            expandedMainFile = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L25:
        if (((TField) (obj)).type == 2)
        {
            displaysCloseButton = tprotocol.readBool();
            setDisplaysCloseButtonIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L26:
        if (((TField) (obj)).type == 11)
        {
            expandableTitle = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L27:
        if (((TField) (obj)).type == 11)
        {
            closeButtonLibID = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L28:
        if (((TField) (obj)).type == 11)
        {
            closeButtonOrientation = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L29:
        if (((TField) (obj)).type == 4)
        {
            adWeight = tprotocol.readDouble();
            setAdWeightIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
_L30:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_1459;
        }
        obj = tprotocol.readListBegin();
        trackingPixels = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L40:
label5:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label5;
            }
            tprotocol.readListEnd();
        }
          goto _L34
        MMAdTrackingPixel mmadtrackingpixel = new MMAdTrackingPixel();
        mmadtrackingpixel.read(tprotocol);
        trackingPixels.add(mmadtrackingpixel);
        i1++;
          goto _L40
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L34
        if (((TField) (obj)).type == 2)
        {
            notForAdRotation = tprotocol.readBool();
            setNotForAdRotationIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L34
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public MMAdControl setAdControl(String s1)
    {
        adControl = s1;
        return this;
    }

    public void setAdControlIsSet(boolean flag)
    {
        if (!flag)
        {
            adControl = null;
        }
    }

    public MMAdControl setAdID(String s1)
    {
        adID = s1;
        return this;
    }

    public void setAdIDIsSet(boolean flag)
    {
        if (!flag)
        {
            adID = null;
        }
    }

    public MMAdControl setAdSlotType(short word0)
    {
        adSlotType = word0;
        setAdSlotTypeIsSet(true);
        return this;
    }

    public void setAdSlotTypeIsSet(boolean flag)
    {
        F.set(1, flag);
    }

    public MMAdControl setAdVersion(String s1)
    {
        adVersion = s1;
        return this;
    }

    public void setAdVersionIsSet(boolean flag)
    {
        if (!flag)
        {
            adVersion = null;
        }
    }

    public MMAdControl setAdWeight(double d1)
    {
        adWeight = d1;
        setAdWeightIsSet(true);
        return this;
    }

    public void setAdWeightIsSet(boolean flag)
    {
        F.set(11, flag);
    }

    public MMAdControl setBlockList(List list)
    {
        blockList = list;
        return this;
    }

    public void setBlockListIsSet(boolean flag)
    {
        if (!flag)
        {
            blockList = null;
        }
    }

    public MMAdControl setClickURL(String s1)
    {
        clickURL = s1;
        return this;
    }

    public void setClickURLIsSet(boolean flag)
    {
        if (!flag)
        {
            clickURL = null;
        }
    }

    public MMAdControl setClipType(short word0)
    {
        clipType = word0;
        setClipTypeIsSet(true);
        return this;
    }

    public void setClipTypeIsSet(boolean flag)
    {
        F.set(3, flag);
    }

    public MMAdControl setCloseButtonLibID(String s1)
    {
        closeButtonLibID = s1;
        return this;
    }

    public void setCloseButtonLibIDIsSet(boolean flag)
    {
        if (!flag)
        {
            closeButtonLibID = null;
        }
    }

    public MMAdControl setCloseButtonOrientation(String s1)
    {
        closeButtonOrientation = s1;
        return this;
    }

    public void setCloseButtonOrientationIsSet(boolean flag)
    {
        if (!flag)
        {
            closeButtonOrientation = null;
        }
    }

    public MMAdControl setDisplayTimes(List list)
    {
        displayTimes = list;
        return this;
    }

    public void setDisplayTimesIsSet(boolean flag)
    {
        if (!flag)
        {
            displayTimes = null;
        }
    }

    public MMAdControl setDisplaysCloseButton(boolean flag)
    {
        displaysCloseButton = flag;
        setDisplaysCloseButtonIsSet(true);
        return this;
    }

    public void setDisplaysCloseButtonIsSet(boolean flag)
    {
        F.set(10, flag);
    }

    public MMAdControl setEndDate(String s1)
    {
        endDate = s1;
        return this;
    }

    public void setEndDateIsSet(boolean flag)
    {
        if (!flag)
        {
            endDate = null;
        }
    }

    public MMAdControl setExpandableTitle(String s1)
    {
        expandableTitle = s1;
        return this;
    }

    public void setExpandableTitleIsSet(boolean flag)
    {
        if (!flag)
        {
            expandableTitle = null;
        }
    }

    public MMAdControl setExpandedHeight(short word0)
    {
        expandedHeight = word0;
        setExpandedHeightIsSet(true);
        return this;
    }

    public void setExpandedHeightIsSet(boolean flag)
    {
        F.set(9, flag);
    }

    public MMAdControl setExpandedMainFile(String s1)
    {
        expandedMainFile = s1;
        return this;
    }

    public void setExpandedMainFileIsSet(boolean flag)
    {
        if (!flag)
        {
            expandedMainFile = null;
        }
    }

    public MMAdControl setExpandedWidth(short word0)
    {
        expandedWidth = word0;
        setExpandedWidthIsSet(true);
        return this;
    }

    public void setExpandedWidthIsSet(boolean flag)
    {
        F.set(8, flag);
    }

    public void setFieldValue(int i1, Object obj)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            if (obj == null)
            {
                unsetAdControl();
                return;
            } else
            {
                setAdControl((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetMinimumConnection();
                return;
            } else
            {
                setMinimumConnection(((Integer)obj).intValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetAdID();
                return;
            } else
            {
                setAdID((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetAdVersion();
                return;
            } else
            {
                setAdVersion((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetAdSlotType();
                return;
            } else
            {
                setAdSlotType(((Short)obj).shortValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetOrientation();
                return;
            } else
            {
                setOrientation(((Short)obj).shortValue());
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetClipType();
                return;
            } else
            {
                setClipType(((Short)obj).shortValue());
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetMainFile();
                return;
            } else
            {
                setMainFile((String)obj);
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetStartDate();
                return;
            } else
            {
                setStartDate((String)obj);
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetEndDate();
                return;
            } else
            {
                setEndDate((String)obj);
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetMaxImpressions();
                return;
            } else
            {
                setMaxImpressions(((Integer)obj).intValue());
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetMaxRunImpressions();
                return;
            } else
            {
                setMaxRunImpressions(((Short)obj).shortValue());
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetBlockList();
                return;
            } else
            {
                setBlockList((List)obj);
                return;
            }

        case 14: // '\016'
            if (obj == null)
            {
                unsetSlotTargetNames();
                return;
            } else
            {
                setSlotTargetNames((List)obj);
                return;
            }

        case 15: // '\017'
            if (obj == null)
            {
                unsetSlotTargetKeywords();
                return;
            } else
            {
                setSlotTargetKeywords((List)obj);
                return;
            }

        case 16: // '\020'
            if (obj == null)
            {
                unsetSlotBlockKeywords();
                return;
            } else
            {
                setSlotBlockKeywords((List)obj);
                return;
            }

        case 17: // '\021'
            if (obj == null)
            {
                unsetClickURL();
                return;
            } else
            {
                setClickURL((String)obj);
                return;
            }

        case 18: // '\022'
            if (obj == null)
            {
                unsetDisplayTimes();
                return;
            } else
            {
                setDisplayTimes((List)obj);
                return;
            }

        case 19: // '\023'
            if (obj == null)
            {
                unsetWidth();
                return;
            } else
            {
                setWidth(((Short)obj).shortValue());
                return;
            }

        case 20: // '\024'
            if (obj == null)
            {
                unsetHeight();
                return;
            } else
            {
                setHeight(((Short)obj).shortValue());
                return;
            }

        case 21: // '\025'
            if (obj == null)
            {
                unsetExpandedWidth();
                return;
            } else
            {
                setExpandedWidth(((Short)obj).shortValue());
                return;
            }

        case 22: // '\026'
            if (obj == null)
            {
                unsetExpandedHeight();
                return;
            } else
            {
                setExpandedHeight(((Short)obj).shortValue());
                return;
            }

        case 23: // '\027'
            if (obj == null)
            {
                unsetExpandedMainFile();
                return;
            } else
            {
                setExpandedMainFile((String)obj);
                return;
            }

        case 24: // '\030'
            if (obj == null)
            {
                unsetDisplaysCloseButton();
                return;
            } else
            {
                setDisplaysCloseButton(((Boolean)obj).booleanValue());
                return;
            }

        case 25: // '\031'
            if (obj == null)
            {
                unsetExpandableTitle();
                return;
            } else
            {
                setExpandableTitle((String)obj);
                return;
            }

        case 26: // '\032'
            if (obj == null)
            {
                unsetCloseButtonLibID();
                return;
            } else
            {
                setCloseButtonLibID((String)obj);
                return;
            }

        case 27: // '\033'
            if (obj == null)
            {
                unsetCloseButtonOrientation();
                return;
            } else
            {
                setCloseButtonOrientation((String)obj);
                return;
            }

        case 28: // '\034'
            if (obj == null)
            {
                unsetAdWeight();
                return;
            } else
            {
                setAdWeight(((Double)obj).doubleValue());
                return;
            }

        case 29: // '\035'
            if (obj == null)
            {
                unsetTrackingPixels();
                return;
            } else
            {
                setTrackingPixels((List)obj);
                return;
            }

        case 30: // '\036'
            break;
        }
        if (obj == null)
        {
            unsetNotForAdRotation();
            return;
        } else
        {
            setNotForAdRotation(((Boolean)obj).booleanValue());
            return;
        }
    }

    public MMAdControl setHeight(short word0)
    {
        height = word0;
        setHeightIsSet(true);
        return this;
    }

    public void setHeightIsSet(boolean flag)
    {
        F.set(7, flag);
    }

    public MMAdControl setMainFile(String s1)
    {
        mainFile = s1;
        return this;
    }

    public void setMainFileIsSet(boolean flag)
    {
        if (!flag)
        {
            mainFile = null;
        }
    }

    public MMAdControl setMaxImpressions(int i1)
    {
        maxImpressions = i1;
        setMaxImpressionsIsSet(true);
        return this;
    }

    public void setMaxImpressionsIsSet(boolean flag)
    {
        F.set(4, flag);
    }

    public MMAdControl setMaxRunImpressions(short word0)
    {
        maxRunImpressions = word0;
        setMaxRunImpressionsIsSet(true);
        return this;
    }

    public void setMaxRunImpressionsIsSet(boolean flag)
    {
        F.set(5, flag);
    }

    public MMAdControl setMinimumConnection(int i1)
    {
        minimumConnection = i1;
        setMinimumConnectionIsSet(true);
        return this;
    }

    public void setMinimumConnectionIsSet(boolean flag)
    {
        F.set(0, flag);
    }

    public MMAdControl setNotForAdRotation(boolean flag)
    {
        notForAdRotation = flag;
        setNotForAdRotationIsSet(true);
        return this;
    }

    public void setNotForAdRotationIsSet(boolean flag)
    {
        F.set(12, flag);
    }

    public MMAdControl setOrientation(short word0)
    {
        orientation = word0;
        setOrientationIsSet(true);
        return this;
    }

    public void setOrientationIsSet(boolean flag)
    {
        F.set(2, flag);
    }

    public MMAdControl setSlotBlockKeywords(List list)
    {
        slotBlockKeywords = list;
        return this;
    }

    public void setSlotBlockKeywordsIsSet(boolean flag)
    {
        if (!flag)
        {
            slotBlockKeywords = null;
        }
    }

    public MMAdControl setSlotTargetKeywords(List list)
    {
        slotTargetKeywords = list;
        return this;
    }

    public void setSlotTargetKeywordsIsSet(boolean flag)
    {
        if (!flag)
        {
            slotTargetKeywords = null;
        }
    }

    public MMAdControl setSlotTargetNames(List list)
    {
        slotTargetNames = list;
        return this;
    }

    public void setSlotTargetNamesIsSet(boolean flag)
    {
        if (!flag)
        {
            slotTargetNames = null;
        }
    }

    public MMAdControl setStartDate(String s1)
    {
        startDate = s1;
        return this;
    }

    public void setStartDateIsSet(boolean flag)
    {
        if (!flag)
        {
            startDate = null;
        }
    }

    public MMAdControl setTrackingPixels(List list)
    {
        trackingPixels = list;
        return this;
    }

    public void setTrackingPixelsIsSet(boolean flag)
    {
        if (!flag)
        {
            trackingPixels = null;
        }
    }

    public MMAdControl setWidth(short word0)
    {
        width = word0;
        setWidthIsSet(true);
        return this;
    }

    public void setWidthIsSet(boolean flag)
    {
        F.set(6, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMAdControl(");
        stringbuilder.append("adControl:");
        String s1;
        if (adControl == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(adControl);
        }
        stringbuilder.append(", ");
        stringbuilder.append("minimumConnection:");
        s1 = (String)connectionState.VALUES_TO_NAMES.get(Integer.valueOf(minimumConnection));
        if (s1 != null)
        {
            stringbuilder.append(s1);
            stringbuilder.append(" (");
        }
        stringbuilder.append(minimumConnection);
        if (s1 != null)
        {
            stringbuilder.append(")");
        }
        stringbuilder.append(", ");
        stringbuilder.append("adID:");
        if (adID == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(adID);
        }
        stringbuilder.append(", ");
        stringbuilder.append("adVersion:");
        if (adVersion == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(adVersion);
        }
        stringbuilder.append(", ");
        stringbuilder.append("adSlotType:");
        stringbuilder.append(adSlotType);
        stringbuilder.append(", ");
        stringbuilder.append("orientation:");
        stringbuilder.append(orientation);
        stringbuilder.append(", ");
        stringbuilder.append("clipType:");
        stringbuilder.append(clipType);
        stringbuilder.append(", ");
        stringbuilder.append("mainFile:");
        if (mainFile == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(mainFile);
        }
        stringbuilder.append(", ");
        stringbuilder.append("startDate:");
        if (startDate == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(startDate);
        }
        stringbuilder.append(", ");
        stringbuilder.append("endDate:");
        if (endDate == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(endDate);
        }
        stringbuilder.append(", ");
        stringbuilder.append("maxImpressions:");
        stringbuilder.append(maxImpressions);
        stringbuilder.append(", ");
        stringbuilder.append("maxRunImpressions:");
        stringbuilder.append(maxRunImpressions);
        if (isSetBlockList())
        {
            stringbuilder.append(", ");
            stringbuilder.append("blockList:");
            if (blockList == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(blockList);
            }
        }
        if (isSetSlotTargetNames())
        {
            stringbuilder.append(", ");
            stringbuilder.append("slotTargetNames:");
            if (slotTargetNames == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(slotTargetNames);
            }
        }
        if (isSetSlotTargetKeywords())
        {
            stringbuilder.append(", ");
            stringbuilder.append("slotTargetKeywords:");
            if (slotTargetKeywords == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(slotTargetKeywords);
            }
        }
        if (isSetSlotBlockKeywords())
        {
            stringbuilder.append(", ");
            stringbuilder.append("slotBlockKeywords:");
            if (slotBlockKeywords == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(slotBlockKeywords);
            }
        }
        if (isSetClickURL())
        {
            stringbuilder.append(", ");
            stringbuilder.append("clickURL:");
            if (clickURL == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(clickURL);
            }
        }
        if (isSetDisplayTimes())
        {
            stringbuilder.append(", ");
            stringbuilder.append("displayTimes:");
            if (displayTimes == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(displayTimes);
            }
        }
        if (isSetWidth())
        {
            stringbuilder.append(", ");
            stringbuilder.append("width:");
            stringbuilder.append(width);
        }
        if (isSetHeight())
        {
            stringbuilder.append(", ");
            stringbuilder.append("height:");
            stringbuilder.append(height);
        }
        if (isSetExpandedWidth())
        {
            stringbuilder.append(", ");
            stringbuilder.append("expandedWidth:");
            stringbuilder.append(expandedWidth);
        }
        if (isSetExpandedHeight())
        {
            stringbuilder.append(", ");
            stringbuilder.append("expandedHeight:");
            stringbuilder.append(expandedHeight);
        }
        if (isSetExpandedMainFile())
        {
            stringbuilder.append(", ");
            stringbuilder.append("expandedMainFile:");
            if (expandedMainFile == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(expandedMainFile);
            }
        }
        if (isSetDisplaysCloseButton())
        {
            stringbuilder.append(", ");
            stringbuilder.append("displaysCloseButton:");
            stringbuilder.append(displaysCloseButton);
        }
        if (isSetExpandableTitle())
        {
            stringbuilder.append(", ");
            stringbuilder.append("expandableTitle:");
            if (expandableTitle == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(expandableTitle);
            }
        }
        if (isSetCloseButtonLibID())
        {
            stringbuilder.append(", ");
            stringbuilder.append("closeButtonLibID:");
            if (closeButtonLibID == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(closeButtonLibID);
            }
        }
        if (isSetCloseButtonOrientation())
        {
            stringbuilder.append(", ");
            stringbuilder.append("closeButtonOrientation:");
            if (closeButtonOrientation == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(closeButtonOrientation);
            }
        }
        if (isSetAdWeight())
        {
            stringbuilder.append(", ");
            stringbuilder.append("adWeight:");
            stringbuilder.append(adWeight);
        }
        if (isSetTrackingPixels())
        {
            stringbuilder.append(", ");
            stringbuilder.append("trackingPixels:");
            if (trackingPixels == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(trackingPixels);
            }
        }
        if (isSetNotForAdRotation())
        {
            stringbuilder.append(", ");
            stringbuilder.append("notForAdRotation:");
            stringbuilder.append(notForAdRotation);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAdControl()
    {
        adControl = null;
    }

    public void unsetAdID()
    {
        adID = null;
    }

    public void unsetAdSlotType()
    {
        F.clear(1);
    }

    public void unsetAdVersion()
    {
        adVersion = null;
    }

    public void unsetAdWeight()
    {
        F.clear(11);
    }

    public void unsetBlockList()
    {
        blockList = null;
    }

    public void unsetClickURL()
    {
        clickURL = null;
    }

    public void unsetClipType()
    {
        F.clear(3);
    }

    public void unsetCloseButtonLibID()
    {
        closeButtonLibID = null;
    }

    public void unsetCloseButtonOrientation()
    {
        closeButtonOrientation = null;
    }

    public void unsetDisplayTimes()
    {
        displayTimes = null;
    }

    public void unsetDisplaysCloseButton()
    {
        F.clear(10);
    }

    public void unsetEndDate()
    {
        endDate = null;
    }

    public void unsetExpandableTitle()
    {
        expandableTitle = null;
    }

    public void unsetExpandedHeight()
    {
        F.clear(9);
    }

    public void unsetExpandedMainFile()
    {
        expandedMainFile = null;
    }

    public void unsetExpandedWidth()
    {
        F.clear(8);
    }

    public void unsetHeight()
    {
        F.clear(7);
    }

    public void unsetMainFile()
    {
        mainFile = null;
    }

    public void unsetMaxImpressions()
    {
        F.clear(4);
    }

    public void unsetMaxRunImpressions()
    {
        F.clear(5);
    }

    public void unsetMinimumConnection()
    {
        F.clear(0);
    }

    public void unsetNotForAdRotation()
    {
        F.clear(12);
    }

    public void unsetOrientation()
    {
        F.clear(2);
    }

    public void unsetSlotBlockKeywords()
    {
        slotBlockKeywords = null;
    }

    public void unsetSlotTargetKeywords()
    {
        slotTargetKeywords = null;
    }

    public void unsetSlotTargetNames()
    {
        slotTargetNames = null;
    }

    public void unsetStartDate()
    {
        startDate = null;
    }

    public void unsetTrackingPixels()
    {
        trackingPixels = null;
    }

    public void unsetWidth()
    {
        F.clear(6);
    }

    public void validate()
        throws TException
    {
        if (isSetMinimumConnection() && !connectionState.VALID_VALUES.contains(minimumConnection))
        {
            throw new TProtocolException((new StringBuilder("The field 'minimumConnection' has been assigned the invalid value ")).append(minimumConnection).toString());
        } else
        {
            return;
        }
    }

    public void write(TProtocol tprotocol)
        throws TException
    {
        validate();
        tprotocol.writeStructBegin(a);
        if (adControl != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(adControl);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(c);
        tprotocol.writeI32(minimumConnection);
        tprotocol.writeFieldEnd();
        if (adID != null)
        {
            tprotocol.writeFieldBegin(d);
            tprotocol.writeString(adID);
            tprotocol.writeFieldEnd();
        }
        if (adVersion != null)
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeString(adVersion);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(f);
        tprotocol.writeI16(adSlotType);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(g);
        tprotocol.writeI16(orientation);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(h);
        tprotocol.writeI16(clipType);
        tprotocol.writeFieldEnd();
        if (mainFile != null)
        {
            tprotocol.writeFieldBegin(i);
            tprotocol.writeString(mainFile);
            tprotocol.writeFieldEnd();
        }
        if (startDate != null)
        {
            tprotocol.writeFieldBegin(j);
            tprotocol.writeString(startDate);
            tprotocol.writeFieldEnd();
        }
        if (endDate != null)
        {
            tprotocol.writeFieldBegin(k);
            tprotocol.writeString(endDate);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(l);
        tprotocol.writeI32(maxImpressions);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(m);
        tprotocol.writeI16(maxRunImpressions);
        tprotocol.writeFieldEnd();
        if (blockList == null || !isSetBlockList()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(n);
        tprotocol.writeListBegin(new TList((byte)11, blockList.size()));
        iterator = blockList.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeListEnd();
        tprotocol.writeFieldEnd();
_L2:
        if (slotTargetNames != null && isSetSlotTargetNames())
        {
            tprotocol.writeFieldBegin(o);
            tprotocol.writeListBegin(new TList((byte)12, slotTargetNames.size()));
            for (iterator = slotTargetNames.iterator(); iterator.hasNext(); ((MMAdSlot)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_1073;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (slotTargetKeywords != null && isSetSlotTargetKeywords())
        {
            tprotocol.writeFieldBegin(p);
            tprotocol.writeListBegin(new TList((byte)11, slotTargetKeywords.size()));
            for (iterator = slotTargetKeywords.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_1089;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (slotBlockKeywords != null && isSetSlotBlockKeywords())
        {
            tprotocol.writeFieldBegin(q);
            tprotocol.writeListBegin(new TList((byte)11, slotBlockKeywords.size()));
            for (iterator = slotBlockKeywords.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_1105;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (clickURL != null && isSetClickURL())
        {
            tprotocol.writeFieldBegin(r);
            tprotocol.writeString(clickURL);
            tprotocol.writeFieldEnd();
        }
        if (displayTimes != null && isSetDisplayTimes())
        {
            tprotocol.writeFieldBegin(s);
            tprotocol.writeListBegin(new TList((byte)12, displayTimes.size()));
            for (iterator = displayTimes.iterator(); iterator.hasNext(); ((MMAdFrequencyCap)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_1121;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (isSetWidth())
        {
            tprotocol.writeFieldBegin(t);
            tprotocol.writeI16(width);
            tprotocol.writeFieldEnd();
        }
        if (isSetHeight())
        {
            tprotocol.writeFieldBegin(u);
            tprotocol.writeI16(height);
            tprotocol.writeFieldEnd();
        }
        if (isSetExpandedWidth())
        {
            tprotocol.writeFieldBegin(v);
            tprotocol.writeI16(expandedWidth);
            tprotocol.writeFieldEnd();
        }
        if (isSetExpandedHeight())
        {
            tprotocol.writeFieldBegin(w);
            tprotocol.writeI16(expandedHeight);
            tprotocol.writeFieldEnd();
        }
        if (expandedMainFile != null && isSetExpandedMainFile())
        {
            tprotocol.writeFieldBegin(x);
            tprotocol.writeString(expandedMainFile);
            tprotocol.writeFieldEnd();
        }
        if (isSetDisplaysCloseButton())
        {
            tprotocol.writeFieldBegin(y);
            tprotocol.writeBool(displaysCloseButton);
            tprotocol.writeFieldEnd();
        }
        if (expandableTitle != null && isSetExpandableTitle())
        {
            tprotocol.writeFieldBegin(z);
            tprotocol.writeString(expandableTitle);
            tprotocol.writeFieldEnd();
        }
        if (closeButtonLibID != null && isSetCloseButtonLibID())
        {
            tprotocol.writeFieldBegin(A);
            tprotocol.writeString(closeButtonLibID);
            tprotocol.writeFieldEnd();
        }
        if (closeButtonOrientation != null && isSetCloseButtonOrientation())
        {
            tprotocol.writeFieldBegin(B);
            tprotocol.writeString(closeButtonOrientation);
            tprotocol.writeFieldEnd();
        }
        if (isSetAdWeight())
        {
            tprotocol.writeFieldBegin(C);
            tprotocol.writeDouble(adWeight);
            tprotocol.writeFieldEnd();
        }
        if (trackingPixels != null && isSetTrackingPixels())
        {
            tprotocol.writeFieldBegin(D);
            tprotocol.writeListBegin(new TList((byte)12, trackingPixels.size()));
            for (iterator = trackingPixels.iterator(); iterator.hasNext(); ((MMAdTrackingPixel)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_1137;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (isSetNotForAdRotation())
        {
            tprotocol.writeFieldBegin(E);
            tprotocol.writeBool(notForAdRotation);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        tprotocol.writeString((String)iterator.next());
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new f());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMAdControl, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/e
    final class e extends HashMap
    {

            e()
            {
                put("adControl", new Integer(1));
                put("minimumConnection", new Integer(2));
                put("adID", new Integer(3));
                put("adVersion", new Integer(4));
                put("adSlotType", new Integer(5));
                put("orientation", new Integer(6));
                put("clipType", new Integer(7));
                put("mainFile", new Integer(8));
                put("startDate", new Integer(9));
                put("endDate", new Integer(10));
                put("maxImpressions", new Integer(11));
                put("maxRunImpressions", new Integer(12));
                put("blockList", new Integer(13));
                put("slotTargetNames", new Integer(14));
                put("slotTargetKeywords", new Integer(15));
                put("slotBlockKeywords", new Integer(16));
                put("clickURL", new Integer(17));
                put("displayTimes", new Integer(18));
                put("width", new Integer(19));
                put("height", new Integer(20));
                put("expandedWidth", new Integer(21));
                put("expandedHeight", new Integer(22));
                put("expandedMainFile", new Integer(23));
                put("displaysCloseButton", new Integer(24));
                put("expandableTitle", new Integer(25));
                put("closeButtonLibID", new Integer(26));
                put("closeButtonOrientation", new Integer(27));
                put("adWeight", new Integer(28));
                put("trackingPixels", new Integer(29));
                put("notForAdRotation", new Integer(30));
            }
    }


    // Unreferenced inner class com/medialets/thrift/f
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

}
