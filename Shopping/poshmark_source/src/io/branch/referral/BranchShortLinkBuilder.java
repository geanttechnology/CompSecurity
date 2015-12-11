// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            BranchUrlBuilder

public class BranchShortLinkBuilder extends BranchUrlBuilder
{

    public BranchShortLinkBuilder(Context context)
    {
        super(context);
    }

    public void generateShortUrl(Branch.BranchLinkCreateListener branchlinkcreatelistener)
    {
        super.generateUrl(branchlinkcreatelistener);
    }

    public String getShortUrl()
    {
        return super.getUrl();
    }

    public BranchShortLinkBuilder setAlias(String s)
    {
        alias_ = s;
        return this;
    }

    public BranchShortLinkBuilder setChannel(String s)
    {
        channel_ = s;
        return this;
    }

    public BranchShortLinkBuilder setDuration(int i)
    {
        duration_ = i;
        return this;
    }

    public BranchShortLinkBuilder setFeature(String s)
    {
        feature_ = s;
        return this;
    }

    public BranchShortLinkBuilder setParameters(JSONObject jsonobject)
    {
        params_ = jsonobject;
        return this;
    }

    public BranchShortLinkBuilder setStage(String s)
    {
        stage_ = s;
        return this;
    }

    public BranchShortLinkBuilder setType(int i)
    {
        type_ = i;
        return this;
    }
}
