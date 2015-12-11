// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.SharedPreferences;
import com.smule.android.f.p;
import com.smule.android.network.core.o;

// Referenced classes of package com.smule.android.network.managers:
//            ag

public class SocialManager
{

    protected static SocialManager a = null;
    private static final String b = com/smule/android/network/managers/SocialManager.getName();

    private SocialManager()
    {
    }


    // Unreferenced inner class com/smule/android/network/managers/SocialManager$1

/* anonymous class */
    class _cls1
        implements FeedItemsCallback
    {

        final SharedPreferences a;

        public void handleResponse(ag ag1)
        {
            if (!ag1.a.a())
            {
                return;
            } else
            {
                ag1 = a.edit();
                ag1.putBoolean("newsfeedActivated", true);
                p.a(ag1);
                return;
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((ag)obj);
        }
    }

}
