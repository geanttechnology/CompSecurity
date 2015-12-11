// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class BlackTieProtection
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean linkToBlackTieProtectionPdpTab;

    public BlackTieProtection()
    {
    }

    public boolean isLinkToBlackTieProtectionPdpTab()
    {
        return linkToBlackTieProtectionPdpTab;
    }

    public void setLinkToBlackTieProtectionPdpTab(boolean flag)
    {
        linkToBlackTieProtectionPdpTab = flag;
    }
}
