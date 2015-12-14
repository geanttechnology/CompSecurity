// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import java.util.EnumSet;

// Referenced classes of package com.mopub.common:
//            UrlAction, UrlHandler

public class skipShowMoPubBrowser
{

    private emeListener moPubSchemeListener;
    private tions resultActions;
    private boolean skipShowMoPubBrowser;
    private EnumSet supportedUrlActions;

    public UrlHandler build()
    {
        return new UrlHandler(supportedUrlActions, resultActions, moPubSchemeListener, skipShowMoPubBrowser, null);
    }

    public emeListener withMoPubSchemeListener(emeListener emelistener)
    {
        moPubSchemeListener = emelistener;
        return this;
    }

    public tions withResultActions(tions tions)
    {
        resultActions = tions;
        return this;
    }

    public transient resultActions withSupportedUrlActions(UrlAction urlaction, UrlAction aurlaction[])
    {
        supportedUrlActions = EnumSet.of(urlaction, aurlaction);
        return this;
    }

    public supportedUrlActions withSupportedUrlActions(EnumSet enumset)
    {
        supportedUrlActions = EnumSet.copyOf(enumset);
        return this;
    }

    public supportedUrlActions withoutMoPubBrowser()
    {
        skipShowMoPubBrowser = true;
        return this;
    }

    public tions()
    {
        supportedUrlActions = EnumSet.of(UrlAction.NOOP);
        resultActions = UrlHandler.access$000();
        moPubSchemeListener = UrlHandler.access$100();
        skipShowMoPubBrowser = false;
    }
}
