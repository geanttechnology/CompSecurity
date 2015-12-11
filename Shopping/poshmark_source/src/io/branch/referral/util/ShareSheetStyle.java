// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

public class ShareSheetStyle
{

    final Context context_;
    private String copyURlText_;
    private Drawable copyUrlIcon_;
    private String defaultURL_;
    private final String messageBody_;
    private final String messageTitle_;
    private Drawable moreOptionIcon_;
    private String moreOptionText_;
    private final ArrayList preferredOptions_ = new ArrayList();
    private String urlCopiedMessage_;

    public ShareSheetStyle(Context context, String s, String s1)
    {
        context_ = context;
        moreOptionIcon_ = null;
        moreOptionText_ = null;
        copyUrlIcon_ = null;
        copyURlText_ = null;
        urlCopiedMessage_ = null;
        defaultURL_ = null;
        messageTitle_ = s;
        messageBody_ = s1;
    }

    private Drawable getDrawable(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return context.getResources().getDrawable(i, context.getTheme());
        } else
        {
            return context.getResources().getDrawable(i);
        }
    }

    public ShareSheetStyle addPreferredSharingOption(io.branch.referral.SharingHelper.SHARE_WITH share_with)
    {
        preferredOptions_.add(share_with);
        return this;
    }

    public String getCopyURlText()
    {
        return copyURlText_;
    }

    public Drawable getCopyUrlIcon()
    {
        return copyUrlIcon_;
    }

    public String getDefaultURL()
    {
        return defaultURL_;
    }

    public String getMessageBody()
    {
        return messageBody_;
    }

    public String getMessageTitle()
    {
        return messageTitle_;
    }

    public Drawable getMoreOptionIcon()
    {
        return moreOptionIcon_;
    }

    public String getMoreOptionText()
    {
        return moreOptionText_;
    }

    public ArrayList getPreferredOptions()
    {
        return preferredOptions_;
    }

    public String getUrlCopiedMessage()
    {
        return urlCopiedMessage_;
    }

    public ShareSheetStyle setCopyUrlStyle(int i, int j, int k)
    {
        copyUrlIcon_ = getDrawable(context_, i);
        copyURlText_ = context_.getResources().getString(j);
        urlCopiedMessage_ = context_.getResources().getString(k);
        return this;
    }

    public ShareSheetStyle setCopyUrlStyle(Drawable drawable, String s, String s1)
    {
        copyUrlIcon_ = drawable;
        copyURlText_ = s;
        urlCopiedMessage_ = s1;
        return this;
    }

    public ShareSheetStyle setDefaultURL(String s)
    {
        defaultURL_ = s;
        return this;
    }

    public ShareSheetStyle setMoreOptionStyle(int i, int j)
    {
        moreOptionIcon_ = getDrawable(context_, i);
        moreOptionText_ = context_.getResources().getString(j);
        return this;
    }

    public ShareSheetStyle setMoreOptionStyle(Drawable drawable, String s)
    {
        moreOptionIcon_ = drawable;
        moreOptionText_ = s;
        return this;
    }
}
