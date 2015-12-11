// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.phone;

import android.app.Activity;
import android.util.Log;
import com.amazon.shopapp.voice.search.VoiceSearchController;

// Referenced classes of package com.amazon.shopapp.voice.phone:
//            VoiceSearchPackageInterface

public class VoiceSearchPackage
    implements VoiceSearchPackageInterface
{

    private static final String TAG = com/amazon/shopapp/voice/phone/VoiceSearchPackage.getSimpleName();

    public VoiceSearchPackage()
    {
    }

    public void startVoiceSearch(Activity activity, boolean flag)
    {
        try
        {
            VoiceSearchController.startVoiceSearch(activity, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e(TAG, "Error", activity);
        }
    }

}
