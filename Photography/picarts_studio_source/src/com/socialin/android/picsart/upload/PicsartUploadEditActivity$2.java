// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.upload;

import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.util.an;

// Referenced classes of package com.socialin.android.picsart.upload:
//            PicsartUploadEditActivity

final class a extends an
{

    private String a;
    private PicsartUploadEditActivity b;

    protected final Object doInBackground(Object aobj[])
    {
        DialogUtils.showDialog(b, PicsartUploadEditActivity.b(b));
        return PicsartUploadEditActivity.a(b, a);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        if (!isCancelled() && !b.isFinishing())
        {
            PicsartUploadEditActivity.b(b, ((String) (obj)));
        }
    }

    (PicsartUploadEditActivity picsartuploadeditactivity, String s)
    {
        b = picsartuploadeditactivity;
        a = s;
        super();
    }
}
