// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.crop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class MonitoredActivity extends AppCompatActivity
{

    private final ArrayList a = new ArrayList();

    public MonitoredActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        for (bundle = a.iterator(); bundle.hasNext(); bundle.next()) { }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); iterator.next()) { }
    }

    protected void onStart()
    {
        super.onStart();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); iterator.next()) { }
    }

    protected void onStop()
    {
        super.onStop();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); iterator.next()) { }
    }
}
