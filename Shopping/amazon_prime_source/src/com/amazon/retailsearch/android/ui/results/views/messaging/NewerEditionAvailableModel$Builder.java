// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.NewerVersion;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            NewerEditionAvailableModel

public static class 
{

    public NewerEditionAvailableModel build(NewerVersion newerversion, String s)
    {
        if (newerversion == null || newerversion.getAsin() == null || newerversion.getLink() == null || TextUtils.isEmpty(newerversion.getLink().getText()) || TextUtils.isEmpty(newerversion.getLink().getUrl()))
        {
            return null;
        } else
        {
            NewerEditionAvailableModel newereditionavailablemodel = new NewerEditionAvailableModel();
            NewerEditionAvailableModel.access$000(newereditionavailablemodel, newerversion.getAsin());
            NewerEditionAvailableModel.access$100(newereditionavailablemodel, newerversion.getLink().getText());
            NewerEditionAvailableModel.access$200(newereditionavailablemodel, newerversion.getLink().getUrl());
            NewerEditionAvailableModel.access$300(newereditionavailablemodel, s);
            return newereditionavailablemodel;
        }
    }

    public ()
    {
    }
}
