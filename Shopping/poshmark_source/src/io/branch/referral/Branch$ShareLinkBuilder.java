// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            Branch, BranchShortLinkBuilder, BranchUtil

public static class urlCopiedMessage_
{

    private final Activity activity_;
    private final Branch branch_;
    private stener callback_;
    private String copyURlText_;
    private Drawable copyUrlIcon_;
    private String defaultURL_;
    private Drawable moreOptionIcon_;
    private String moreOptionText_;
    private ArrayList preferredOptions_;
    private String shareMsg_;
    private String shareSub_;
    BranchShortLinkBuilder shortLinkBuilder_;
    private String urlCopiedMessage_;

    public urlCopiedMessage_ addParam(String s, String s1)
    {
        try
        {
            shortLinkBuilder_.addParameters(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        return this;
    }

    public  addPreferredSharingOption( )
    {
        preferredOptions_.add();
        return this;
    }

    public preferredOptions_ addPreferredSharingOptions(ArrayList arraylist)
    {
        preferredOptions_.addAll(arraylist);
        return this;
    }

    public preferredOptions_ addTag(String s)
    {
        shortLinkBuilder_.addTag(s);
        return this;
    }

    public ddTag addTags(ArrayList arraylist)
    {
        shortLinkBuilder_.addTags(arraylist);
        return this;
    }

    public Activity getActivity()
    {
        return activity_;
    }

    public Branch getBranch()
    {
        return branch_;
    }

    public stener getCallback()
    {
        return callback_;
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

    public String getShareMsg()
    {
        return shareMsg_;
    }

    public String getShareSub()
    {
        return shareSub_;
    }

    public BranchShortLinkBuilder getShortLinkBuilder()
    {
        return shortLinkBuilder_;
    }

    public String getUrlCopiedMessage()
    {
        return urlCopiedMessage_;
    }

    public urlCopiedMessage_ setAlias(String s)
    {
        shortLinkBuilder_.setAlias(s);
        return this;
    }

    public stener setCallback(stener stener)
    {
        callback_ = stener;
        return this;
    }

    public callback_ setCopyUrlStyle(int i, int j, int k)
    {
        copyUrlIcon_ = BranchUtil.getDrawable(activity_.getApplicationContext(), i);
        copyURlText_ = activity_.getResources().getString(j);
        urlCopiedMessage_ = activity_.getResources().getString(k);
        return this;
    }

    public activity_ setCopyUrlStyle(Drawable drawable, String s, String s1)
    {
        copyUrlIcon_ = drawable;
        copyURlText_ = s;
        urlCopiedMessage_ = s1;
        return this;
    }

    public urlCopiedMessage_ setDefaultURL(String s)
    {
        defaultURL_ = s;
        return this;
    }

    public defaultURL_ setFeature(String s)
    {
        shortLinkBuilder_.setFeature(s);
        return this;
    }

    public etFeature setMatchDuration(int i)
    {
        shortLinkBuilder_.setDuration(i);
        return this;
    }

    public etDuration setMessage(String s)
    {
        shareMsg_ = s;
        return this;
    }

    public shareMsg_ setMoreOptionStyle(int i, int j)
    {
        moreOptionIcon_ = BranchUtil.getDrawable(activity_.getApplicationContext(), i);
        moreOptionText_ = activity_.getResources().getString(j);
        return this;
    }

    public activity_ setMoreOptionStyle(Drawable drawable, String s)
    {
        moreOptionIcon_ = drawable;
        moreOptionText_ = s;
        return this;
    }

    public void setShortLinkBuilderInternal(BranchShortLinkBuilder branchshortlinkbuilder)
    {
        shortLinkBuilder_ = branchshortlinkbuilder;
    }

    public shortLinkBuilder_ setStage(String s)
    {
        shortLinkBuilder_.setStage(s);
        return this;
    }

    public etStage setSubject(String s)
    {
        shareSub_ = s;
        return this;
    }

    public void shareLink()
    {
        Branch.access$2900(Branch.access$2300(), this);
    }

    public stener(Activity activity, BranchShortLinkBuilder branchshortlinkbuilder)
    {
        this(activity, new JSONObject());
        shortLinkBuilder_ = branchshortlinkbuilder;
    }

    public shortLinkBuilder_(Activity activity, JSONObject jsonobject)
    {
        callback_ = null;
        activity_ = activity;
        branch_ = Branch.access$2300();
        shortLinkBuilder_ = new BranchShortLinkBuilder(activity);
        try
        {
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); shortLinkBuilder_.addParameters(s, (String)jsonobject.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        shareMsg_ = "";
        callback_ = null;
        preferredOptions_ = new ArrayList();
        defaultURL_ = null;
        moreOptionIcon_ = BranchUtil.getDrawable(activity.getApplicationContext(), 0x1080045);
        moreOptionText_ = "More...";
        copyUrlIcon_ = BranchUtil.getDrawable(activity.getApplicationContext(), 0x108004e);
        copyURlText_ = "Copy link";
        urlCopiedMessage_ = "Copied link to clipboard!";
    }
}
