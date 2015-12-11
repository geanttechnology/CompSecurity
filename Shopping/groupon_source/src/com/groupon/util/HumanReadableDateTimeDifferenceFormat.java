// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.groupon.util:
//            HumanReadableCountdownFormat, TimeUtil

public class HumanReadableDateTimeDifferenceFormat extends HumanReadableCountdownFormat
{

    private Context context;
    private TimeUtil timeUtil;

    public HumanReadableDateTimeDifferenceFormat()
    {
    }

    protected void doCompleteDateFormat(StringBuffer stringbuffer, int i, int j, int k, int l, int i1, int j1, 
            int k1)
    {
        if (i > 0 && j > 0)
        {
            stringbuffer.append(String.format(context.getString(0x7f080064), new Object[] {
                context.getResources().getQuantityString(0x7f0c001f, i, new Object[] {
                    Integer.valueOf(i)
                }), context.getResources().getQuantityString(0x7f0c0012, j, new Object[] {
                    Integer.valueOf(j)
                })
            }));
            return;
        }
        if (i > 0)
        {
            stringbuffer.append(context.getResources().getQuantityString(0x7f0c0020, i, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        }
        if (j > 0 && k > 0)
        {
            stringbuffer.append(String.format(context.getString(0x7f080064), new Object[] {
                context.getResources().getQuantityString(0x7f0c0011, j, new Object[] {
                    Integer.valueOf(j)
                }), context.getResources().getQuantityString(0x7f0c001d, k, new Object[] {
                    Integer.valueOf(k)
                })
            }));
            return;
        }
        if (j > 0)
        {
            stringbuffer.append(context.getResources().getQuantityString(0x7f0c0012, j, new Object[] {
                Integer.valueOf(j)
            }));
            return;
        }
        if (k > 0 && l > 0)
        {
            stringbuffer.append(String.format(context.getString(0x7f080064), new Object[] {
                context.getResources().getQuantityString(0x7f0c001c, k, new Object[] {
                    Integer.valueOf(k)
                }), context.getResources().getQuantityString(0x7f0c0006, l, new Object[] {
                    Integer.valueOf(l)
                })
            }));
            return;
        }
        if (k > 0)
        {
            stringbuffer.append(context.getResources().getQuantityString(0x7f0c001d, k, new Object[] {
                Integer.valueOf(k)
            }));
            return;
        }
        if (l > 0 && i1 > 0)
        {
            stringbuffer.append(String.format(context.getString(0x7f080064), new Object[] {
                context.getResources().getQuantityString(0x7f0c0005, l, new Object[] {
                    Integer.valueOf(l)
                }), context.getResources().getQuantityString(0x7f0c0009, i1, new Object[] {
                    Integer.valueOf(i1)
                })
            }));
            return;
        }
        if (l > 0)
        {
            stringbuffer.append(context.getResources().getQuantityString(0x7f0c0006, l, new Object[] {
                Integer.valueOf(l)
            }));
            return;
        }
        if (i1 > 0 && j1 > 0)
        {
            stringbuffer.append(String.format(context.getString(0x7f080064), new Object[] {
                context.getResources().getQuantityString(0x7f0c0008, i1, new Object[] {
                    Integer.valueOf(i1)
                }), context.getResources().getQuantityString(0x7f0c000f, j1, new Object[] {
                    Integer.valueOf(j1)
                })
            }));
            return;
        }
        if (i1 > 0)
        {
            stringbuffer.append(context.getResources().getQuantityString(0x7f0c0009, i1, new Object[] {
                Integer.valueOf(i1)
            }));
            return;
        }
        if (j1 > 0 && k1 > 0)
        {
            stringbuffer.append(String.format(context.getString(0x7f080064), new Object[] {
                context.getResources().getQuantityString(0x7f0c000e, j1, new Object[] {
                    Integer.valueOf(j1)
                }), context.getResources().getQuantityString(0x7f0c0019, k1, new Object[] {
                    Integer.valueOf(k1)
                })
            }));
            return;
        }
        if (j1 > 0)
        {
            stringbuffer.append(context.getResources().getQuantityString(0x7f0c000f, j1, new Object[] {
                Integer.valueOf(j1)
            }));
            return;
        } else
        {
            stringbuffer.append(context.getResources().getString(0x7f080245));
            return;
        }
    }

    protected void doFormat(StringBuffer stringbuffer, int i, int j, int k, int l)
    {
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if (date == null)
        {
            return new StringBuffer(0);
        } else
        {
            stringbuffer = Calendar.getInstance();
            stringbuffer.setTime(relativeTo);
            int i = timeUtil.diffYears(relativeTo, date);
            stringbuffer.add(1, i);
            int j = timeUtil.diffMonths(stringbuffer.getTime(), date);
            stringbuffer.add(2, j);
            int k = timeUtil.diffWeeks(stringbuffer.getTime(), date);
            stringbuffer.add(3, k);
            int l = timeUtil.diffDays(stringbuffer.getTime(), date);
            stringbuffer.add(6, l);
            int i1 = timeUtil.diffHours(stringbuffer.getTime(), date);
            stringbuffer.add(10, i1);
            int j1 = timeUtil.diffMinutes(stringbuffer.getTime(), date);
            stringbuffer.add(12, j1);
            int k1 = timeUtil.diffSeconds(stringbuffer.getTime(), date);
            date = new StringBuffer();
            doCompleteDateFormat(date, i, j, k, l, i1, j1, k1);
            return date;
        }
    }

    public String getReadableTimer(Date date)
    {
        relativeTo = date;
        return format(new Date());
    }
}
