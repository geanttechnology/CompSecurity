// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fitbit.device.ui.setup.replace;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.fitbit.data.domain.device.TrackerType;

// Referenced classes of package com.fitbit.device.ui.setup.replace:
//            ConfirmReplaceDeviceActivity_

public static class a
{

    private Context a;
    private final Intent b;
    private Fragment c;

    public Intent a()
    {
        return b;
    }

    public b a(int i)
    {
        b.setFlags(i);
        return this;
    }

    public b a(TrackerType trackertype)
    {
        b.putExtra("deviceType", trackertype);
        return this;
    }

    public b a(String s)
    {
        b.putExtra("deviceName", s);
        return this;
    }

    public void b()
    {
        a.startActivity(b);
    }

    public void b(int i)
    {
        if (c != null)
        {
            c.startActivityForResult(b, i);
            return;
        }
        if (a instanceof Activity)
        {
            ((Activity)a).startActivityForResult(b, i);
            return;
        } else
        {
            a.startActivity(b);
            return;
        }
    }

    public (Context context)
    {
        a = context;
        b = new Intent(context, com/fitbit/device/ui/setup/replace/ConfirmReplaceDeviceActivity_);
    }

    public b(Fragment fragment)
    {
        c = fragment;
        a = fragment.getActivity();
        b = new Intent(a, com/fitbit/device/ui/setup/replace/ConfirmReplaceDeviceActivity_);
    }
}
