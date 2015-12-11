// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.device.ads:
//            Settings

class 
    implements Runnable
{

    final Settings this$0;
    final SharedPreferences val$sharedPreferences;

    public void run()
    {
        Settings.access$000(Settings.this).lock();
        android.content.rences.Editor editor = val$sharedPreferences.edit();
        editor.clear();
        Iterator iterator = Settings.access$100(Settings.this).entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util..Settings settings = (java.util.sNext)iterator.next();
            lue lue = (lue)settings.etValue();
            if (!lue.isTransientData)
            {
                if (lue.clazz == java/lang/String)
                {
                    editor.putString((String)settings.etKey(), (String)lue.value);
                } else
                if (lue.clazz == java/lang/Long)
                {
                    editor.putLong((String)settings.etKey(), ((Long)lue.value).longValue());
                } else
                if (lue.clazz == java/lang/Integer)
                {
                    editor.putInt((String)settings.etKey(), ((Integer)lue.value).intValue());
                } else
                if (lue.clazz == java/lang/Boolean)
                {
                    editor.putBoolean((String)settings.etKey(), ((Boolean)lue.value).booleanValue());
                }
            }
        } while (true);
        Settings.access$200(Settings.this, editor);
        Settings.access$000(Settings.this).unlock();
    }

    ()
    {
        this$0 = final_settings;
        val$sharedPreferences = SharedPreferences.this;
        super();
    }
}
