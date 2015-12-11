// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.signin;

import android.content.Context;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.shell.content.FwLoader;

public class InstantiateGuidLoader extends FwLoader
{

    public String id3pp;
    public String id4pp;

    public InstantiateGuidLoader(Context context)
    {
        super(context);
    }

    protected void doInBackground()
    {
        id3pp = EbayIdentity.get3ppFingerprint(getContext());
        id4pp = EbayIdentity.get4ppFingerprint(getContext());
    }
}
