// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.bluetooth.BluetoothAdapter;

public class c
{
    public static class a
    {

        private final int mDeviceStatus;
        private final boolean mIsEnabled;

        public boolean a()
        {
            return mIsEnabled;
        }

        public int b()
        {
            return mDeviceStatus;
        }

        a(boolean flag, int i)
        {
            mIsEnabled = flag;
            mDeviceStatus = i;
        }
    }


    public static a a()
    {
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothadapter == null)
        {
            return new a(false, 2);
        } else
        {
            return new a(bluetoothadapter.isEnabled(), 1);
        }
    }
}
