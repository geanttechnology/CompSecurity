// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            Branch, ServerRequestCreateUrl, BranchUtil, BranchError

abstract class BranchUrlBuilder
{

    protected String alias_;
    protected Branch branchReferral_;
    protected String channel_;
    private final Context context_;
    protected int duration_;
    protected String feature_;
    protected JSONObject params_;
    protected String stage_;
    protected ArrayList tags_;
    protected int type_;

    protected BranchUrlBuilder(Context context)
    {
        type_ = 0;
        duration_ = 0;
        branchReferral_ = Branch.getInstance();
        context_ = context.getApplicationContext();
    }

    public BranchUrlBuilder addParameters(String s, String s1)
    {
        try
        {
            if (params_ == null)
            {
                params_ = new JSONObject();
            }
            params_.put(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        return this;
    }

    public BranchUrlBuilder addParameters(String s, JSONArray jsonarray)
    {
        try
        {
            if (params_ == null)
            {
                params_ = new JSONObject();
            }
            params_.put(s, jsonarray);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        return this;
    }

    public BranchUrlBuilder addTag(String s)
    {
        if (tags_ == null)
        {
            tags_ = new ArrayList();
        }
        tags_.add(s);
        return this;
    }

    public BranchUrlBuilder addTags(List list)
    {
        if (tags_ == null)
        {
            tags_ = new ArrayList();
        }
        tags_.addAll(list);
        return this;
    }

    protected void generateUrl(Branch.BranchLinkCreateListener branchlinkcreatelistener)
    {
        if (branchReferral_ != null)
        {
            branchlinkcreatelistener = new ServerRequestCreateUrl(context_, alias_, type_, duration_, tags_, channel_, feature_, stage_, BranchUtil.formatAndStringifyLinkParam(params_), branchlinkcreatelistener, true);
            branchReferral_.generateShortLinkInternal(branchlinkcreatelistener);
            return;
        }
        if (branchlinkcreatelistener != null)
        {
            branchlinkcreatelistener.onLinkCreate(null, new BranchError("session has not been initialized", -101));
        }
        Log.i("BranchSDK", "Branch Warning: User session has not been initialized");
    }

    protected String getUrl()
    {
        Object obj = null;
        if (branchReferral_ != null)
        {
            obj = new ServerRequestCreateUrl(context_, alias_, type_, duration_, tags_, channel_, feature_, stage_, BranchUtil.formatAndStringifyLinkParam(params_), null, false);
            obj = branchReferral_.generateShortLinkInternal(((ServerRequestCreateUrl) (obj)));
        }
        return ((String) (obj));
    }
}
