// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package co.vine.android.util:
//            Util, DateTimeUtil

public class VineDateFormatter
{

    private final SimpleDateFormat mDateFormatLong;
    private final SimpleDateFormat mDateFormatShort;
    private final HashSet mDateSectionSpans = new HashSet();
    private final String mDateTimePlacerPart1;
    private final boolean mIsDateBeforeTime;
    private Calendar mStartOfToday;
    private long mStartOfYesterday;
    private final SimpleDateFormat mTimeFormat;
    private final HashSet mTimeSectionSpans = new HashSet();
    private final String mYesterday;

    public VineDateFormatter(Resources resources)
    {
        mTimeFormat = new SimpleDateFormat(resources.getString(0x7f0e0283));
        String s = resources.getString(0x7f0e0277);
        int i = s.indexOf("%1$s");
        int j = s.indexOf("%2$s");
        boolean flag;
        if (i < j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDateBeforeTime = flag;
        if (mIsDateBeforeTime)
        {
            mDateTimePlacerPart1 = s.substring(i, j);
        } else
        {
            mDateTimePlacerPart1 = s.substring(i);
        }
        mDateFormatLong = new SimpleDateFormat(resources.getString(0x7f0e00a9));
        mDateFormatShort = new SimpleDateFormat(resources.getString(0x7f0e00aa));
        mYesterday = resources.getString(0x7f0e0289);
    }

    public void addSpanForDateSection(TypefaceSpan typefacespan)
    {
        mDateSectionSpans.add(typefacespan);
    }

    public void addSpanForTimeSection(TypefaceSpan typefacespan)
    {
        mTimeSectionSpans.add(typefacespan);
    }

    public CharSequence format(long l)
    {
        Object obj;
        Object obj1;
        obj = new Date(l);
        obj1 = Calendar.getInstance();
        ((Calendar) (obj1)).setTimeInMillis(l);
        if (l <= mStartOfToday.getTimeInMillis()) goto _L2; else goto _L1
_L1:
        obj = mTimeFormat.format(((Date) (obj)));
_L4:
        return ((CharSequence) (obj));
_L2:
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (mIsDateBeforeTime)
        {
            int i;
            int k;
            if (l > mStartOfYesterday)
            {
                spannablestringbuilder.append(mDateTimePlacerPart1.replace("%1$s", mYesterday));
            } else
            if (((Calendar) (obj1)).get(1) == mStartOfToday.get(1))
            {
                spannablestringbuilder.append(mDateTimePlacerPart1.replace("%1$s", mDateFormatShort.format(((Date) (obj)))));
            } else
            {
                spannablestringbuilder.append(mDateTimePlacerPart1.replace("%1$s", mDateFormatLong.format(((Date) (obj)))));
            }
            i = spannablestringbuilder.length();
            spannablestringbuilder.append(mTimeFormat.format(((Date) (obj))));
            k = spannablestringbuilder.length();
            for (obj = mDateSectionSpans.iterator(); ((Iterator) (obj)).hasNext(); Util.safeSetSpan(spannablestringbuilder, (TypefaceSpan)((Iterator) (obj)).next(), 0, i, 33)) { }
            obj1 = mTimeSectionSpans.iterator();
            do
            {
                obj = spannablestringbuilder;
                if (!((Iterator) (obj1)).hasNext())
                {
                    continue;
                }
                Util.safeSetSpan(spannablestringbuilder, (TypefaceSpan)((Iterator) (obj1)).next(), i, k, 33);
            } while (true);
        }
        spannablestringbuilder.append(mTimeFormat.format(((Date) (obj))));
        int j = spannablestringbuilder.length();
        int i1;
        if (l > mStartOfYesterday)
        {
            spannablestringbuilder.append(mDateTimePlacerPart1.replace("%1$s", mYesterday));
        } else
        if (((Calendar) (obj1)).get(1) == mStartOfToday.get(1))
        {
            spannablestringbuilder.append(mDateTimePlacerPart1.replace("%1$s", mDateFormatShort.format(((Date) (obj)))));
        } else
        {
            spannablestringbuilder.append(mDateTimePlacerPart1.replace("%1$s", mDateFormatLong.format(((Date) (obj)))));
        }
        i1 = spannablestringbuilder.length();
        for (obj = mDateSectionSpans.iterator(); ((Iterator) (obj)).hasNext(); Util.safeSetSpan(spannablestringbuilder, (TypefaceSpan)((Iterator) (obj)).next(), j, i1, 33)) { }
        obj1 = mTimeSectionSpans.iterator();
        do
        {
            obj = spannablestringbuilder;
            if (!((Iterator) (obj1)).hasNext())
            {
                continue;
            }
            Util.safeSetSpan(spannablestringbuilder, (TypefaceSpan)((Iterator) (obj1)).next(), 0, j, 33);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void refreshDates()
    {
        mStartOfToday = DateTimeUtil.getStartOfDay();
        mStartOfYesterday = mStartOfToday.getTimeInMillis() - 0x5265c00L;
    }
}
