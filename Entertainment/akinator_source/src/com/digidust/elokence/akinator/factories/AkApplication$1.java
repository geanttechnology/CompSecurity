// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.graphics.Typeface;
import com.facebook.FacebookSdk;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplication

class this._cls0 extends Thread
{

    final AkApplication this$0;

    public void run()
    {
        Typeface _tmp = AkApplication.access$002(Typeface.createFromAsset(getAssets(), (new StringBuilder()).append("fonts/").append(AkApplication.access$100()).append(".ttf").toString()));
        try
        {
            Class.forName("android.os.AsyncTask");
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        FacebookSdk.sdkInitialize(getApplicationContext());
    }

    ()
    {
        this$0 = AkApplication.this;
        super();
    }
}
