// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;


final class BrowserLauncher extends Enum
{

    public static final BrowserLauncher AUTH;
    public static final BrowserLauncher COMMON;
    private static final BrowserLauncher ENUM$VALUES[];
    public static final BrowserLauncher GAME;
    public static final BrowserLauncher SHARE;
    public static final BrowserLauncher WIDGET;

    private BrowserLauncher(String s, int i)
    {
        super(s, i);
    }

    public static BrowserLauncher valueOf(String s)
    {
        return (BrowserLauncher)Enum.valueOf(com/sina/weibo/sdk/component/BrowserLauncher, s);
    }

    public static BrowserLauncher[] values()
    {
        BrowserLauncher abrowserlauncher[] = ENUM$VALUES;
        int i = abrowserlauncher.length;
        BrowserLauncher abrowserlauncher1[] = new BrowserLauncher[i];
        System.arraycopy(abrowserlauncher, 0, abrowserlauncher1, 0, i);
        return abrowserlauncher1;
    }

    static 
    {
        AUTH = new BrowserLauncher("AUTH", 0);
        SHARE = new BrowserLauncher("SHARE", 1);
        WIDGET = new BrowserLauncher("WIDGET", 2);
        COMMON = new BrowserLauncher("COMMON", 3);
        GAME = new BrowserLauncher("GAME", 4);
        ENUM$VALUES = (new BrowserLauncher[] {
            AUTH, SHARE, WIDGET, COMMON, GAME
        });
    }
}
