// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import java.util.HashMap;

final class g extends HashMap
{

    g()
    {
        put("android.permission.INTERNET", Integer.valueOf(1));
        put("android.permission.ACCESS_NETWORK_STATE", Integer.valueOf(2));
        put("android.permission.RECEIVE_BOOT_COMPLETED", Integer.valueOf(4));
        put("android.permission.SYSTEM_ALERT_WINDOW", Integer.valueOf(8));
        put("com.android.browser.permission.READ_HISTORY_BOOKMARKS", Integer.valueOf(16));
        put("com.android.browser.permission.WRITE_HISTORY_BOOKMARKS", Integer.valueOf(32));
        put("com.android.launcher.permission.INSTALL_SHORTCUT", Integer.valueOf(64));
        put("com.android.launcher.permission.UNINSTALL_SHORTCUT", Integer.valueOf(128));
    }
}
