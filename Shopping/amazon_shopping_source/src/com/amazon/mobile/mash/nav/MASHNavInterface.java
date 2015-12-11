// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import com.amazon.mobile.mash.MASHWebView;

public interface MASHNavInterface
{

    public abstract Class getModalActivityClass();

    public abstract void replaceRootWebViewWithNewUrl(MASHWebView mashwebview, MASHNavOperation.MASHNavRequest mashnavrequest);
}
