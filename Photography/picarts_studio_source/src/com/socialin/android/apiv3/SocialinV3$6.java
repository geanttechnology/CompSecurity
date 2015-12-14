// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.socialin.android.apiv3.gcm.ServerUtilities;
import com.socialin.android.util.an;

// Referenced classes of package com.socialin.android.apiv3:
//            SocialinV3

final class lities extends an
{

    private static transient Void a()
    {
        String s1;
        android.app.Application application;
        SocialinV3 socialinv3;
        GoogleCloudMessaging googlecloudmessaging;
        application = SocialinV3.getInstance().getContext();
        googlecloudmessaging = GoogleCloudMessaging.getInstance(application);
        socialinv3 = SocialinV3.getInstance();
        s1 = socialinv3.getRegistrationId(application);
        String s = s1;
        try
        {
            if (s1.length() == 0)
            {
                s = googlecloudmessaging.register(new String[] {
                    "1076413845392"
                });
            }
            if (ServerUtilities.register(application, s))
            {
                SocialinV3.access$100(socialinv3, application, s);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final volatile void onPostExecute(Object obj)
    {
    }

    lities()
    {
    }
}
