// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.os.Bundle;
import android.widget.Toast;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class this._cls0
    implements com.facebook.widget.ner
{

    final FacebookHelperActivity this$0;

    public void onComplete(Bundle bundle, FacebookException facebookexception)
    {
        if (facebookexception == null)
        {
            if (bundle.getString("post_id") != null)
            {
                Toast.makeText(getThis(), getThis().getString(0x7f0b00c7), 0).show();
                getThis().finish();
                return;
            } else
            {
                Toast.makeText(getThis().getApplicationContext(), getThis().getString(0x7f0b00c8), 0).show();
                getThis().finish();
                return;
            }
        }
        if (facebookexception instanceof FacebookOperationCanceledException)
        {
            Toast.makeText(getThis().getApplicationContext(), facebookexception.getLocalizedMessage(), 1).show();
            getThis().finish();
            return;
        } else
        {
            Toast.makeText(getThis().getApplicationContext(), facebookexception.getLocalizedMessage(), 1).show();
            getThis().finish();
            return;
        }
    }

    ption()
    {
        this$0 = FacebookHelperActivity.this;
        super();
    }
}
