// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import com.ebay.nautilus.shell.app.FwActivity;

// Referenced classes of package com.ebay.mobile.sell:
//            CategoryDialogFragment

public static interface 
    extends FwActivity
{

    public abstract void detachCategoryDialog();

    public abstract String getSelectedCategoryId();

    public abstract boolean isDataAvailable();

    public abstract String keywordsForSuggestions();

    public abstract boolean showMotorsWithUsCats();
}
