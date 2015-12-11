// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Intent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.amazon.device.ads:
//            AdActivity, co, cn

static final class xception
{

    private final cn a = co.a(AdActivity.a());

    final xception a(Intent intent)
    {
        intent = intent.getStringExtra("adapter");
        if (intent == null)
        {
            a.d("Unable to launch the AdActivity due to an internal error.", null);
            return null;
        }
        try
        {
            intent = Class.forName(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a.d("Unable to get the adapter class.", null);
            return null;
        }
        try
        {
            intent = intent.getDeclaredConstructor(new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a.d("Security exception when trying to get the default constructor.", null);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a.d("No default constructor exists for the adapter.", null);
            return null;
        }
        try
        {
            intent = (a)intent.newInstance(new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a.d("Illegal arguments given to the default constructor.", null);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a.d("Instantiation exception when instantiating the adapter.", null);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a.d("Illegal access exception when instantiating the adapter.", null);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a.d("Invocation target exception when instantiating the adapter.", null);
            return null;
        }
        return intent;
    }

    public xception()
    {
    }
}
