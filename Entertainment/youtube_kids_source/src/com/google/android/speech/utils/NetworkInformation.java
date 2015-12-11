// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class NetworkInformation
{

    public static final int ERROR_VALUE = -1;
    public static final int MISSING_TELEPHONY_RESULT[] = {
        -1, -1
    };
    private final ConnectivityManager mConnectivityManager;
    private final TelephonyManager mTelephonyManager;

    public NetworkInformation(TelephonyManager telephonymanager, ConnectivityManager connectivitymanager)
    {
        mTelephonyManager = telephonymanager;
        mConnectivityManager = connectivitymanager;
    }

    private static int tryParse(String s, int i)
    {
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public int getConnectionId()
    {
        if (mConnectivityManager != null)
        {
            NetworkInfo networkinfo = mConnectivityManager.getActiveNetworkInfo();
            if (networkinfo == null || !networkinfo.isConnected())
            {
                return 0;
            }
            if (networkinfo.getType() == 1)
            {
                return 1;
            }
            if (networkinfo.getType() == 6)
            {
                return 19;
            }
            if (networkinfo.getType() == 7)
            {
                return 17;
            }
            if (networkinfo.getType() == 9)
            {
                return 18;
            }
            if (networkinfo.getType() == 0)
            {
                if (mTelephonyManager != null)
                {
                    switch (mTelephonyManager.getNetworkType())
                    {
                    default:
                        return 0;

                    case 7: // '\007'
                        return 2;

                    case 4: // '\004'
                        return 3;

                    case 2: // '\002'
                        return 4;

                    case 14: // '\016'
                        return 5;

                    case 5: // '\005'
                        return 6;

                    case 6: // '\006'
                        return 7;

                    case 12: // '\f'
                        return 8;

                    case 1: // '\001'
                        return 9;

                    case 8: // '\b'
                        return 10;

                    case 10: // '\n'
                        return 11;

                    case 15: // '\017'
                        return 12;

                    case 9: // '\t'
                        return 13;

                    case 11: // '\013'
                        return 14;

                    case 13: // '\r'
                        return 15;

                    case 3: // '\003'
                        return 16;
                    }
                }
            } else
            {
                return 0;
            }
        }
        return -1;
    }

    public String getDeviceCountryCode()
    {
        if (mTelephonyManager == null)
        {
            return "";
        }
        String s = mTelephonyManager.getSimCountryIso();
        if (TextUtils.isEmpty(s))
        {
            return "";
        } else
        {
            return s.toUpperCase();
        }
    }

    public int[] getNetworkMccMnc()
    {
        if (mTelephonyManager == null)
        {
            return MISSING_TELEPHONY_RESULT;
        }
        String s = mTelephonyManager.getNetworkOperator();
        if (s == null || s.length() < 3)
        {
            return MISSING_TELEPHONY_RESULT;
        } else
        {
            return (new int[] {
                tryParse(s.substring(0, 3), -1), tryParse(s.substring(3), -1)
            });
        }
    }

    public int getSimMcc()
    {
        String s;
        if (mTelephonyManager != null)
        {
            if ((s = mTelephonyManager.getSimOperator()) != null && s.length() > 3)
            {
                return tryParse(s.substring(0, 3), -1);
            }
        }
        return -1;
    }

    public int[] getSimMccMnc()
    {
        if (mTelephonyManager == null)
        {
            return MISSING_TELEPHONY_RESULT;
        }
        String s = mTelephonyManager.getSimOperator();
        if (s == null || s.length() < 3)
        {
            return MISSING_TELEPHONY_RESULT;
        } else
        {
            return (new int[] {
                tryParse(s.substring(0, 3), -1), tryParse(s.substring(3), -1)
            });
        }
    }

    public boolean isConnected()
    {
        NetworkInfo networkinfo;
        if (mConnectivityManager != null)
        {
            if ((networkinfo = mConnectivityManager.getActiveNetworkInfo()) != null && networkinfo.isConnected())
            {
                return true;
            }
        }
        return false;
    }

    public boolean isConnectedUnmetered()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = mConnectivityManager.isActiveNetworkMetered();
        } else
        {
            NetworkInfo networkinfo = mConnectivityManager.getActiveNetworkInfo();
            if (networkinfo != null && networkinfo.getType() != 1 && networkinfo.getType() != 6)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        return isConnected() && !flag;
    }

}
