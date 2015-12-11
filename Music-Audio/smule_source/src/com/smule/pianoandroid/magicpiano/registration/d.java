// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Activity;
import com.smule.pianoandroid.magicpiano.an;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            b

public class d extends an
{

    private b a;

    public d(Activity activity, String s)
    {
        super(activity, s);
    }

    static d a(Activity activity, int i, String s)
    {
        activity = new d(activity, s);
        activity.a(i, s, false);
        activity.setCancelable(false);
        return activity;
    }

    public static d b(Activity activity, int i, String s)
    {
        activity = a(activity, i, s);
        activity.a(false);
        return activity;
    }

    public void a(b b1)
    {
        a = b1;
    }

    public void a(String s)
    {
        a(0, s, false);
    }
}
