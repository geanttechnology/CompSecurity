// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.json;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.cds.json:
//            CdsJsonParser

public class CdsMessageContentParser extends CdsJsonParser
{

    String actionButtonText;
    long beginDate;
    String contentIdentifier;
    String contentURL;
    String dismissButtonText;
    long endDate;
    String identifier;
    String layoutStyle;
    String paragraph;
    boolean showNewBanner;
    boolean splitButton;
    String title;
    String versionKey;

    public CdsMessageContentParser()
    {
    }

    public String getActionButtonText()
    {
        return actionButtonText;
    }

    public long getBeginDate()
    {
        return beginDate;
    }

    public String getContentIdentifier()
    {
        return contentIdentifier;
    }

    public String getContentURL()
    {
        return contentURL;
    }

    public String getDismissButtonText()
    {
        return dismissButtonText;
    }

    public long getEndDate()
    {
        return endDate;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getLayoutStyle()
    {
        return layoutStyle;
    }

    public String getParagraph()
    {
        return paragraph;
    }

    public String getTitle()
    {
        return title;
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    public boolean isShowNewBanner()
    {
        return showNewBanner;
    }

    public boolean isSplitButton()
    {
        return splitButton;
    }

    protected void onParseJson(JSONObject jsonobject)
        throws JSONException
    {
        identifier = jsonobject.getString("identifier");
        versionKey = jsonobject.getString("versionKey");
        contentIdentifier = jsonobject.getString("contentIdentifier");
        beginDate = jsonobject.getLong("beginDate");
        endDate = jsonobject.getLong("endDate");
        contentURL = jsonobject.getString("contentURL");
        title = jsonobject.getString("title");
        paragraph = jsonobject.getString("paragraph");
        dismissButtonText = jsonobject.getString("dismissButtonText");
        actionButtonText = jsonobject.optString("actionButtonText", "Yes");
        layoutStyle = jsonobject.getString("layoutStyle");
        showNewBanner = jsonobject.getBoolean("showsNewBanner");
        splitButton = jsonobject.getBoolean("isSplitButton");
    }
}
