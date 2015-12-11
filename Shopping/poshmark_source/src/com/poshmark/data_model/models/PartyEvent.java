// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.data_model.models.inner_models.Host;
import com.poshmark.data_model.models.inner_models.PartyAggregates;
import com.poshmark.data_model.models.inner_models.PartyRoomInfo;
import com.poshmark.data_model.models.inner_models.Theme;
import com.poshmark.utils.DateUtils;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            ListingSummary, NewListing, MetaItem

public class PartyEvent
{

    PartyAggregates aggregates;
    List collections;
    CoverShot cover_shot;
    String created_at;
    String creator_id;
    String description;
    BigDecimal duration;
    List hosts;
    String id;
    String name;
    String reminder;
    String rsvp;
    String rsvp_at;
    boolean send_push;
    String short_url;
    String start_time;
    String status;
    String status_changed_at;
    Theme theme;
    String updated_at;

    public PartyEvent()
    {
        collections = Collections.synchronizedList(new ArrayList());
        hosts = Collections.synchronizedList(new ArrayList());
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        if (collections == null) goto _L2; else goto _L1
_L1:
        List list = collections;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = collections.iterator(); iterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (PartyRoomInfo)iterator.next()
})) { }
        break MISSING_BLOCK_LABEL_68;
        custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
        throw custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
_L2:
    }

    public List getCollections()
    {
        return collections;
    }

    public String getCommaSeparatedHostNames()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = hosts.iterator(); iterator.hasNext(); stringbuilder.append(", "))
        {
            stringbuilder.append(((Host)iterator.next()).username);
        }

        if (stringbuilder.length() > 0)
        {
            return stringbuilder.substring(0, stringbuilder.length() - 2);
        } else
        {
            return "";
        }
    }

    public String getCovershot()
    {
        return cover_shot.url_small;
    }

    public PartyRoomInfo getDefaultShowroom()
    {
        for (int i = 0; i < collections.size(); i++)
        {
            PartyRoomInfo partyroominfo = (PartyRoomInfo)collections.get(i);
            if (partyroominfo.isDefault())
            {
                return partyroominfo;
            }
        }

        return null;
    }

    public String getDescription()
    {
        return description;
    }

    public long getDuration()
    {
        return duration.longValue();
    }

    public String getFormattedPendingTime()
    {
        long l = getMilliSecondsToEnd();
        String s;
        if (l < 0L)
        {
            s = "";
        } else
        {
            int j = (int)((l + duration.multiply(new BigDecimal("1000")).longValue()) - System.currentTimeMillis()) / 1000;
            int i = (j / 60) % 60;
            j /= 3600;
            s = new String();
            String s2 = new String();
            String s1;
            if (j == 1)
            {
                s1 = (new StringBuilder()).append(s).append(String.format("%d hr", new Object[] {
                    Integer.valueOf(j)
                })).toString();
            } else
            {
                s1 = s;
                if (j > 1)
                {
                    s1 = (new StringBuilder()).append(s).append(String.format("%d hrs", new Object[] {
                        Integer.valueOf(j)
                    })).toString();
                }
            }
            if (i == 1)
            {
                s = (new StringBuilder()).append(s2).append(String.format("%d min", new Object[] {
                    Integer.valueOf(i)
                })).toString();
            } else
            {
                s = s2;
                if (i > 1)
                {
                    s = (new StringBuilder()).append(s2).append(String.format("%d mins", new Object[] {
                        Integer.valueOf(i)
                    })).toString();
                }
            }
            if (j == 0 && i == 0)
            {
                return PMApplication.getContext().getString(0x7f060161);
            }
            if (j == 0 || i == 0)
            {
                if (j != 0)
                {
                    if (i == 0)
                    {
                        return s1;
                    } else
                    {
                        return "";
                    }
                }
            } else
            {
                return (new StringBuilder()).append(s1).append(s).toString();
            }
        }
        return s;
    }

    public List getHosts()
    {
        return hosts;
    }

    public String getId()
    {
        return id;
    }

    public int getListingCount()
    {
        return aggregates.posts;
    }

    public long getMilliSecondsToEnd()
    {
        if (!isHappeningNow())
        {
            return -1L;
        } else
        {
            return DateUtils.getDateFromString(start_time).getTime();
        }
    }

    public String getName()
    {
        return name;
    }

    public String getStartDateTimeString(Context context)
    {
        Object obj = DateUtils.getDateFromString(start_time);
        String s = (new SimpleDateFormat("EEE MMM d")).format(((Date) (obj)));
        obj = (new SimpleDateFormat("h:mm a")).format(((Date) (obj)));
        return (new StringBuilder()).append(s).append(" ").append(context.getString(0x7f06004b)).append(" ").append(((String) (obj))).toString();
    }

    public String getStartTime()
    {
        return start_time;
    }

    public Theme getTheme()
    {
        return theme;
    }

    public String getTitle()
    {
        return name;
    }

    public String getURL()
    {
        return (new StringBuilder()).append("https://www.poshmark.com/parties/").append(getId()).toString();
    }

    public boolean hasShowrooms()
    {
        return collections.size() > 0;
    }

    public boolean isFutureEvent()
    {
        return DateUtils.getDateFromString(start_time).after(new Date());
    }

    public boolean isHappeningNow()
    {
        return DateUtils.isDateWithinPastWindow(DateUtils.getDateFromString(start_time), duration.longValue(), com.poshmark.utils.DateUtils.TIME_UNIT.SECONDS);
    }

    public boolean isListingEligibleForParty(ListingSummary listingsummary)
    {
label0:
        {
            boolean flag = false;
            if (listingsummary != null)
            {
                if (theme != null)
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        if (!theme.isMatchingCategory(listingsummary.getCategoryId()))
        {
            return false;
        }
        if (!theme.isMatchingSubCategory(listingsummary.getSubCategoryList()))
        {
            return false;
        }
        if (!theme.isMatchingColor(listingsummary.getColorList()))
        {
            return false;
        }
        if (!theme.isMatchingSize(listingsummary.getSize()))
        {
            return false;
        }
        if (!theme.isMatchingBrand(listingsummary.getBrand()))
        {
            return false;
        }
        return theme.isMatchingPrice(listingsummary.getPrice().toString());
    }

    public boolean isListingEligibleForParty(NewListing newlisting)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (newlisting != null)
        {
            if (theme == null)
            {
                flag = true;
            } else
            {
                MetaItem metaitem = newlisting.getCategory();
                flag = flag1;
                if (metaitem != null)
                {
                    if (!theme.isMatchingCategory(metaitem.getId()))
                    {
                        return false;
                    }
                    if (!theme.isMatchingSubCategory(newlisting.getSubCategoryList()))
                    {
                        return false;
                    }
                    if (!theme.isMatchingColor(newlisting.getColors()))
                    {
                        return false;
                    }
                    if (!theme.isMatchingSize(newlisting.getSize()))
                    {
                        return false;
                    }
                    if (!theme.isMatchingBrand(newlisting.getBrand()))
                    {
                        return false;
                    }
                    return theme.isMatchingPrice(newlisting.getPrice());
                }
            }
        }
        return flag;
    }

    public boolean isPastEvent()
    {
        for (Date date = DateUtils.getDateFromString(start_time); date.after(new Date()) || DateUtils.isDateWithinPastWindow(date, duration.longValue(), com.poshmark.utils.DateUtils.TIME_UNIT.SECONDS);)
        {
            return false;
        }

        return true;
    }

    public boolean isReminderEnabled()
    {
        return reminder.equals("local");
    }
}
