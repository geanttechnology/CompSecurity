// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import android.app.Fragment;
import com.squareup.otto.Bus;

public class RedirectTracking
{
    public static class TrackingEvent
    {

        private String fragment;
        private String nameValue[];
        private String type;

        public String getFragment()
        {
            return fragment;
        }

        public String[] getNameValue()
        {
            return nameValue;
        }

        public String getType()
        {
            return type;
        }

        public transient TrackingEvent(String s, String s1, String as[])
        {
            fragment = s;
            type = s1;
            nameValue = as;
        }
    }


    private Bus bus;

    public RedirectTracking(Bus bus1)
    {
        bus = bus1;
    }

    public transient void track(Fragment fragment, String s, String as[])
    {
        Bus bus1 = bus;
        if (fragment == null)
        {
            fragment = null;
        } else
        {
            fragment = fragment.getClass().getSimpleName();
        }
        bus1.post(new TrackingEvent(fragment, s, as));
    }

    public transient void track(String s, String s1, String as[])
    {
        bus.post(new TrackingEvent(s, s1, as));
    }
}
