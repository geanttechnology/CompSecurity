// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.AsyncTask;
import android.webkit.WebView;

// Referenced classes of package com.tapjoy.internal:
//            fd

static final class  extends AsyncTask
{

    private WebView a;

    protected final volatile Object doInBackground(Object aobj[])
    {
        a = ((WebView[])aobj)[0];
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        a.removeAllViews();
        a.destroy();
    }

    ()
    {
    }
}
