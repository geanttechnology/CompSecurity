// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.cvsd;

import java.util.ArrayList;
import java.util.List;

public class CVSDReceivedResult
{

    public static String message;
    public static List receivedAddresss = new ArrayList();
    public static int receivedType;

    public CVSDReceivedResult()
    {
    }

    public static void reset()
    {
        receivedType = -1;
        message = null;
        receivedAddresss = new ArrayList();
    }

}
