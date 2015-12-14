// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.os.Bundle;
import com.facebook.android.FacebookError;

// Referenced classes of package com.parse:
//            FacebookAuthenticationProvider

class this._cls0
    implements com.facebook.android.
{

    final FacebookAuthenticationProvider this$0;

    public void onComplete(Bundle bundle)
    {
        FacebookAuthenticationProvider.access$100(FacebookAuthenticationProvider.this, FacebookAuthenticationProvider.access$000(FacebookAuthenticationProvider.this));
    }

    public void onError(Error error)
    {
        FacebookAuthenticationProvider.access$200(FacebookAuthenticationProvider.this, error);
    }

    public void onFacebookError(FacebookError facebookerror)
    {
        FacebookAuthenticationProvider.access$200(FacebookAuthenticationProvider.this, facebookerror);
    }

    er()
    {
        this$0 = FacebookAuthenticationProvider.this;
        super();
    }
}
