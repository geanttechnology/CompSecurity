// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.os.Bundle;
import android.support.v4.a.k;
import android.support.v4.app.ba;
import com.facebook.FacebookException;

// Referenced classes of package com.facebook.widget:
//            GraphObjectPagingLoader, SimpleGraphObjectCursor

class this._cls1
    implements ba
{

    final LoadReset this$1;

    public k onCreateLoader(int i, Bundle bundle)
    {
        return CreateLoader();
    }

    public void onLoadFinished(k k, SimpleGraphObjectCursor simplegraphobjectcursor)
    {
        if (k != ader)
        {
            throw new FacebookException("Received callback for unknown loader.");
        } else
        {
            LoadFinished((GraphObjectPagingLoader)k, simplegraphobjectcursor);
            return;
        }
    }

    public volatile void onLoadFinished(k k, Object obj)
    {
        onLoadFinished(k, (SimpleGraphObjectCursor)obj);
    }

    public void onLoaderReset(k k)
    {
        if (k != ader)
        {
            throw new FacebookException("Received callback for unknown loader.");
        } else
        {
            LoadReset((GraphObjectPagingLoader)k);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
