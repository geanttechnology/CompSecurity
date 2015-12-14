// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.ttml;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

final class TtmlNode
{

    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SMPTE_DATA = "smpte:data";
    public static final String TAG_SMPTE_IMAGE = "smpte:image";
    public static final String TAG_SMPTE_INFORMATION = "smpte:information";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final long UNDEFINED_TIME = -1L;
    private List children;
    public final long endTimeUs;
    public final boolean isTextNode;
    public final long startTimeUs;
    public final String tag;
    public final String text;

    private TtmlNode(String s, String s1, long l, long l1)
    {
        tag = s;
        text = s1;
        boolean flag;
        if (s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isTextNode = flag;
        startTimeUs = l;
        endTimeUs = l1;
    }

    private static String applyTextElementSpacePolicy(String s)
    {
        return s.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static TtmlNode buildNode(String s, long l, long l1)
    {
        return new TtmlNode(s, null, l, l1);
    }

    public static TtmlNode buildTextNode(String s)
    {
        return new TtmlNode(null, applyTextElementSpacePolicy(s), -1L, -1L);
    }

    private static void endParagraph(SpannableStringBuilder spannablestringbuilder)
    {
        int i;
        for (i = spannablestringbuilder.length() - 1; i >= 0 && spannablestringbuilder.charAt(i) == ' '; i--) { }
        if (i >= 0 && spannablestringbuilder.charAt(i) != '\n')
        {
            spannablestringbuilder.append('\n');
        }
    }

    private void getEventTimes(TreeSet treeset, boolean flag)
    {
        boolean flag2 = "p".equals(tag);
        if (flag || flag2)
        {
            if (startTimeUs != -1L)
            {
                treeset.add(Long.valueOf(startTimeUs));
            }
            if (endTimeUs != -1L)
            {
                treeset.add(Long.valueOf(endTimeUs));
            }
        }
        if (children != null)
        {
            int i = 0;
            while (i < children.size()) 
            {
                TtmlNode ttmlnode = (TtmlNode)children.get(i);
                boolean flag1;
                if (flag || flag2)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                ttmlnode.getEventTimes(treeset, flag1);
                i++;
            }
        }
    }

    private SpannableStringBuilder getText(long l, SpannableStringBuilder spannablestringbuilder, boolean flag)
    {
        if (isTextNode && flag)
        {
            spannablestringbuilder.append(text);
        } else
        {
            if ("br".equals(tag) && flag)
            {
                spannablestringbuilder.append('\n');
                return spannablestringbuilder;
            }
            if (!"metadata".equals(tag) && isActive(l))
            {
                boolean flag2 = "p".equals(tag);
                int i = 0;
                while (i < getChildCount()) 
                {
                    TtmlNode ttmlnode = getChild(i);
                    boolean flag1;
                    if (flag || flag2)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    ttmlnode.getText(l, spannablestringbuilder, flag1);
                    i++;
                }
                if (flag2)
                {
                    endParagraph(spannablestringbuilder);
                    return spannablestringbuilder;
                }
            }
        }
        return spannablestringbuilder;
    }

    public void addChild(TtmlNode ttmlnode)
    {
        if (children == null)
        {
            children = new ArrayList();
        }
        children.add(ttmlnode);
    }

    public TtmlNode getChild(int i)
    {
        if (children == null)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return (TtmlNode)children.get(i);
        }
    }

    public int getChildCount()
    {
        if (children == null)
        {
            return 0;
        } else
        {
            return children.size();
        }
    }

    public long[] getEventTimesUs()
    {
        Object obj = new TreeSet();
        getEventTimes(((TreeSet) (obj)), false);
        long al[] = new long[((TreeSet) (obj)).size()];
        obj = ((TreeSet) (obj)).iterator();
        for (int i = 0; ((Iterator) (obj)).hasNext(); i++)
        {
            al[i] = ((Long)((Iterator) (obj)).next()).longValue();
        }

        return al;
    }

    public CharSequence getText(long l)
    {
        SpannableStringBuilder spannablestringbuilder = getText(l, new SpannableStringBuilder(), false);
        int i = spannablestringbuilder.length();
        int i1;
        for (int j = 0; j < i; i = i1)
        {
            i1 = i;
            if (spannablestringbuilder.charAt(j) == ' ')
            {
                for (i1 = j + 1; i1 < spannablestringbuilder.length() && spannablestringbuilder.charAt(i1) == ' '; i1++) { }
                int k1 = i1 - (j + 1);
                i1 = i;
                if (k1 > 0)
                {
                    spannablestringbuilder.delete(j, j + k1);
                    i1 = i - k1;
                }
            }
            j++;
        }

        int k = i;
        if (i > 0)
        {
            k = i;
            if (spannablestringbuilder.charAt(0) == ' ')
            {
                spannablestringbuilder.delete(0, 1);
                k = i - 1;
            }
        }
        int j1 = 0;
        for (i = k; j1 < i - 1; i = k)
        {
            k = i;
            if (spannablestringbuilder.charAt(j1) == '\n')
            {
                k = i;
                if (spannablestringbuilder.charAt(j1 + 1) == ' ')
                {
                    spannablestringbuilder.delete(j1 + 1, j1 + 2);
                    k = i - 1;
                }
            }
            j1++;
        }

        k = i;
        if (i > 0)
        {
            k = i;
            if (spannablestringbuilder.charAt(i - 1) == ' ')
            {
                spannablestringbuilder.delete(i - 1, i);
                k = i - 1;
            }
        }
        j1 = 0;
        for (i = k; j1 < i - 1; i = k)
        {
            k = i;
            if (spannablestringbuilder.charAt(j1) == ' ')
            {
                k = i;
                if (spannablestringbuilder.charAt(j1 + 1) == '\n')
                {
                    spannablestringbuilder.delete(j1, j1 + 1);
                    k = i - 1;
                }
            }
            j1++;
        }

        k = i;
        if (i > 0)
        {
            k = i;
            if (spannablestringbuilder.charAt(i - 1) == '\n')
            {
                spannablestringbuilder.delete(i - 1, i);
                k = i - 1;
            }
        }
        return spannablestringbuilder.subSequence(0, k);
    }

    public boolean isActive(long l)
    {
        return startTimeUs == -1L && endTimeUs == -1L || startTimeUs <= l && endTimeUs == -1L || startTimeUs == -1L && l < endTimeUs || startTimeUs <= l && l < endTimeUs;
    }
}
