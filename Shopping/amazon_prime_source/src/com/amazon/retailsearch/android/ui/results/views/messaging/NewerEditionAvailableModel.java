// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.NewerVersion;

public class NewerEditionAvailableModel
{
    public static class Builder
    {

        public NewerEditionAvailableModel build(NewerVersion newerversion, String s)
        {
            if (newerversion == null || newerversion.getAsin() == null || newerversion.getLink() == null || TextUtils.isEmpty(newerversion.getLink().getText()) || TextUtils.isEmpty(newerversion.getLink().getUrl()))
            {
                return null;
            } else
            {
                NewerEditionAvailableModel newereditionavailablemodel = new NewerEditionAvailableModel();
                newereditionavailablemodel.setAsin(newerversion.getAsin());
                newereditionavailablemodel.setNewerVersionText(newerversion.getLink().getText());
                newereditionavailablemodel.setNewerVersionUrl(newerversion.getLink().getUrl());
                newereditionavailablemodel.setProductGroup(s);
                return newereditionavailablemodel;
            }
        }

        public Builder()
        {
        }
    }


    private String asin;
    private String newerVersionText;
    private String newerVersionUrl;
    private String productGroup;

    public NewerEditionAvailableModel()
    {
    }

    private void setAsin(String s)
    {
        asin = s;
    }

    private void setNewerVersionText(String s)
    {
        newerVersionText = s;
    }

    private void setNewerVersionUrl(String s)
    {
        newerVersionUrl = s;
    }

    private void setProductGroup(String s)
    {
        productGroup = s;
    }

    public String getAsin()
    {
        return asin;
    }

    public String getNewerVersionText()
    {
        return newerVersionText;
    }

    public String getNewerVersionUrl()
    {
        return newerVersionUrl;
    }

    public String getProductGroup()
    {
        return productGroup;
    }




}
