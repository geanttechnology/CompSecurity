// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import android.preference.Preference;
import java.net.InetAddress;
import java.net.UnknownHostException;

// Referenced classes of package com.socialin.android.preference:
//            d

final class a
    implements Runnable
{

    private String a;
    private a b;

    public final void run()
    {
        b.b.setSummary(a);
    }

    ( , String s)
    {
        b = ;
        a = s;
        super();
    }

    // Unreferenced inner class com/socialin/android/preference/d$15

/* anonymous class */
    final class d._cls15 extends Thread
    {

        final Preference a;
        private d b;

        public final void run()
        {
            InetAddress ainetaddress[] = InetAddress.getAllByName("api.picsart.com");
            String s = "IPs: ";
            int j = ainetaddress.length;
            int i = 0;
_L2:
            InetAddress inetaddress;
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            inetaddress = ainetaddress[i];
            s = (new StringBuilder()).append(s).append(inetaddress.getHostAddress()).append(", ").toString();
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            try
            {
                if (b.getActivity() != null)
                {
                    b.getActivity().runOnUiThread(new d._cls15._cls1(this, s));
                }
                return;
            }
            catch (UnknownHostException unknownhostexception)
            {
                unknownhostexception.printStackTrace();
            }
            return;
        }

            
            {
                b = d1;
                a = preference;
                super();
            }
    }

}
