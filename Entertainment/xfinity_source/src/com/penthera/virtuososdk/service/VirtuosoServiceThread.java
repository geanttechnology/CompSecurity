// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.service;


class VirtuosoServiceThread extends Thread
{

    private static String LOG_TAG = com/penthera/virtuososdk/service/VirtuosoServiceThread.getName();

    public void run()
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "VirtuosoServiceThread(): run: begin");
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "VirtuosoServiceThread(): run: end");
    }

    public void start()
    {
        super.start();
    }

}
