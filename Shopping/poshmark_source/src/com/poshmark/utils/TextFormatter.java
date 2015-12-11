// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.EventContext;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.inner_models.Like;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.view_holders.PMUrlSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.poshmark.utils:
//            PMClickableSpan, DateUtils, TextClickListener

public class TextFormatter
{

    public TextFormatter()
    {
    }

    public CharSequence getClickableCommentString(PMTextView pmtextview, TextClickListener textclicklistener, String s)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        SpannableString spannablestring = new SpannableString(s);
        int i = s.indexOf(" ", 0);
        if (i != -1)
        {
            String s1 = s.substring(0, i);
            spannablestring.setSpan(new PMClickableSpan(s1, textclicklistener, pmtextview.getFontColor(), pmtextview.getFontName(), false), 0, s1.length(), 33);
        }
        String s2;
        for (s = Pattern.compile("(?<![a-z])@\\w*\\b").matcher(s); s.find(); spannablestring.setSpan(new PMClickableSpan(s2.substring(1), textclicklistener, pmtextview.getFontColor(), pmtextview.getFontName(), false), s.start(), s.start() + s2.length(), 33))
        {
            s2 = s.group();
        }

        spannablestringbuilder.append(spannablestring);
        return spannablestringbuilder;
    }

    public CharSequence getClickableLikesString(PMTextView pmtextview, TextClickListener textclicklistener, TextClickListener textclicklistener1, List list, String s)
    {
        Object obj;
        Iterator iterator;
        Object obj3;
        obj = new String();
        obj3 = new ArrayList();
        iterator = null;
        if (list.size() <= 2) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        obj1 = (Like)list.get(0);
        obj = (new StringBuilder()).append(((String) (obj))).append(((Like) (obj1)).getDisplayHandle()).toString();
        ((List) (obj3)).add(new Point(0, ((Like) (obj1)).getDisplayHandle().length()));
        obj = (new StringBuilder()).append(((String) (obj))).append(" and ").toString();
        list = (new StringBuilder()).append(Integer.toString(list.size() - 1)).append(" others").toString();
        obj1 = new Point(((String) (obj)).length(), list.length());
        ((List) (obj3)).add(obj1);
        obj2 = (new StringBuilder()).append(((String) (obj))).append(list).append(" like this").toString();
_L4:
        list = new SpannableStringBuilder();
        if (((String) (obj2)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_525;
        }
        obj = new SpannableString(((CharSequence) (obj2)));
        for (iterator = ((List) (obj3)).iterator(); iterator.hasNext();)
        {
            obj3 = (Point)iterator.next();
            int i;
            int j;
            if (obj3 != obj1)
            {
                ((SpannableString) (obj)).setSpan(new PMClickableSpan(((String) (obj2)).substring(((Point) (obj3)).x, ((Point) (obj3)).x + ((Point) (obj3)).y), textclicklistener, pmtextview.getFontColor(), pmtextview.getFontName(), false), ((Point) (obj3)).x, ((Point) (obj3)).x + ((Point) (obj3)).y, 33);
            } else
            {
                ((SpannableString) (obj)).setSpan(new PMClickableSpan(s, textclicklistener1, pmtextview.getFontColor(), pmtextview.getFontName(), false), ((Point) (obj3)).x, ((Point) (obj3)).x + ((Point) (obj3)).y, 33);
            }
        }

        break; /* Loop/switch isn't completed */
_L2:
        j = list.size();
        i = 0;
        do
        {
            obj2 = obj;
            obj1 = iterator;
            if (i >= j)
            {
                break;
            }
            obj1 = (Like)list.get(i);
            ((List) (obj3)).add(new Point(((String) (obj)).length(), ((Like) (obj1)).getDisplayHandle().length()));
            obj1 = (new StringBuilder()).append(((String) (obj))).append(((Like) (obj1)).getDisplayHandle()).toString();
            obj = obj1;
            if (i < j - 1)
            {
                obj = (new StringBuilder()).append(((String) (obj1))).append(", ").toString();
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        list.append(((CharSequence) (obj)));
        return list;
    }

    public CharSequence getClickableLinkString(PMTextView pmtextview, TextClickListener textclicklistener, String s, ArrayList arraylist)
    {
        String s1 = (new String(s)).replace("[", "").replace("]", "");
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        SpannableString spannablestring = new SpannableString(s1);
        int i = 0;
        int k = 0;
        int j = s.indexOf("[", 0);
        do
        {
            if (j == -1)
            {
                break;
            }
            int l = s.indexOf("]", j);
            if (l != -1)
            {
                k = l - 1;
                s = (new StringBuilder()).append(s.substring(0, j)).append("").append(s.substring(j + 1)).toString();
                s = (new StringBuilder()).append(s.substring(0, k)).append("").append(s.substring(k + 1)).toString();
                String s2 = s.substring(j, k);
                String s3 = (String)arraylist.get(i);
                if (s3 != null)
                {
                    spannablestring.setSpan(new PMClickableSpan(s3, textclicklistener, pmtextview.getFontColor(), pmtextview.getFontName(), false), j, s2.length() + j, 33);
                }
                i++;
                j = s.indexOf("[", k);
                k = 1;
            }
        } while (true);
        if (k == 0)
        {
            spannablestringbuilder.append(s1);
            return spannablestringbuilder;
        } else
        {
            spannablestringbuilder.append(spannablestring);
            return spannablestringbuilder;
        }
    }

    public CharSequence getClickableSimpleString(PMTextView pmtextview, TextClickListener textclicklistener, String s, String s1)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new PMClickableSpan(s1, textclicklistener, pmtextview.getFontColor(), pmtextview.getFontName(), false), 0, s.length(), 33);
        spannablestringbuilder.append(spannablestring);
        return spannablestringbuilder;
    }

    public CharSequence getClickableUserNameString(PMTextView pmtextview, TextClickListener textclicklistener, String s)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new PMClickableSpan(s, textclicklistener, pmtextview.getFontColor(), pmtextview.getFontName(), false), 0, s.length(), 33);
        spannablestringbuilder.append(spannablestring);
        return spannablestringbuilder;
    }

    public CharSequence getHtmlStringWithClickableLinks(PMTextView pmtextview, TextClickListener textclicklistener, String s, String s1)
    {
        s = new SpannableStringBuilder();
        s1 = new SpannableString(Html.fromHtml(s1));
        URLSpan aurlspan[] = (URLSpan[])s1.getSpans(0, s1.length(), android/text/style/URLSpan);
        int j = aurlspan.length;
        for (int i = 0; i < j; i++)
        {
            URLSpan urlspan = aurlspan[i];
            int k = s1.getSpanStart(urlspan);
            int l = s1.getSpanEnd(urlspan);
            s1.removeSpan(urlspan);
            s1.setSpan(new PMUrlSpan(urlspan.getURL(), textclicklistener, pmtextview.getFontColor(), pmtextview.getFontName(), false), k, l, 0);
        }

        s.append(s1);
        return s;
    }

    public String getPublishedAtMessageString(ListingSocial listingsocial)
    {
        String s = null;
        Object obj = PMApplication.getContext().getResources();
        if (listingsocial.hasEventContext())
        {
            EventContext eventcontext = listingsocial.getEventContext();
            String s1 = eventcontext.created_at;
            if (listingsocial.getUserId().equals(eventcontext.by_id))
            {
                listingsocial = DateUtils.formatDateForDisplay(s1, null);
            } else
            {
                listingsocial = eventcontext.by_username;
                s = String.format(((Resources) (obj)).getString(0x7f060181), new Object[] {
                    listingsocial
                });
                listingsocial = DateUtils.formatDateForDisplay(s1, s);
            }
        } else
        {
            s = listingsocial.getSharedByUserName();
            if (s != null)
            {
                s = String.format(((Resources) (obj)).getString(0x7f060181), new Object[] {
                    s
                });
                listingsocial = DateUtils.formatDateForDisplay(listingsocial.getSharedAtTime(), s);
            } else
            if (listingsocial.getPublishCount() > 1)
            {
                s = ((Resources) (obj)).getString(0x7f0602b4);
                listingsocial = DateUtils.formatDateForDisplay(listingsocial.statusChangedAt(), s);
            } else
            {
                s = new String("");
                listingsocial = DateUtils.formatDateForDisplay(listingsocial.getListingDate(), s);
            }
        }
        obj = listingsocial;
        if (s != null)
        {
            obj = (new StringBuilder()).append(s).append(listingsocial).toString();
        }
        return ((String) (obj));
    }

    public String getPublishedAtTimeString(ListingSocial listingsocial)
    {
        PMApplication.getContext().getResources();
        if (listingsocial.hasEventContext())
        {
            return listingsocial.getEventContext().created_at;
        }
        if (listingsocial.getSharedByUserName() != null)
        {
            return DateUtils.formatDateForDisplay(listingsocial.getSharedAtTime(), null);
        }
        if (listingsocial.getPublishCount() > 1)
        {
            return DateUtils.formatDateForDisplay(listingsocial.statusChangedAt(), null);
        } else
        {
            return DateUtils.formatDateForDisplay(listingsocial.getListingDate(), null);
        }
    }
}
