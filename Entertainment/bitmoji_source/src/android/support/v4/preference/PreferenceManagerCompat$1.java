// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.preference;

import android.preference.Preference;
import android.preference.PreferenceScreen;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v4.preference:
//            PreferenceManagerCompat

static final class val.listener
    implements InvocationHandler
{

    final PreferenceTreeClickListener val$listener;

    public Object invoke(Object obj, Method method, Object aobj[])
    {
        if (method.getName().equals("onPreferenceTreeClick"))
        {
            return Boolean.valueOf(val$listener.onPreferenceTreeClick((PreferenceScreen)aobj[0], (Preference)aobj[1]));
        } else
        {
            return null;
        }
    }

    PreferenceTreeClickListener(PreferenceTreeClickListener preferencetreeclicklistener)
    {
        val$listener = preferencetreeclicklistener;
        super();
    }
}
