// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.view.KeyEvent;

public class KeyUtils
{

    public KeyUtils()
    {
    }

    public static boolean isActionMatching(KeyEvent keyevent, int i)
    {
        return keyevent.getAction() == i;
    }

    public static boolean isEventMatching(KeyEvent keyevent, int i, int j)
    {
        return isKeyCodeMatching(keyevent, i) && isActionMatching(keyevent, j);
    }

    public static boolean isKeyCodeMatching(KeyEvent keyevent, int i)
    {
        return keyevent.getKeyCode() == i;
    }
}
