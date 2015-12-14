// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.content.Context;
import android.content.SharedPreferences;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle:
//            Globals

final class tor extends j
{

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    protected Void a(String s)
    {
        android.content.erences.Editor editor = Globals.n().getApplicationContext().getSharedPreferences("BeautyCircleResumeActivityFile", 0).edit();
        editor.putString("BeautyCircleResumeActivity", s);
        editor.apply();
        return null;
    }

    tor()
    {
    }
}
