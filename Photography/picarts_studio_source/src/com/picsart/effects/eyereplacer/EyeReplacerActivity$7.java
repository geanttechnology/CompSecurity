// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.graphics.Bitmap;
import android.util.Log;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.c;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            EyeReplacerActivity, a

final class a extends ModernAsyncTask
{

    private EyeReplacerActivity a;

    protected final volatile Object doInBackground(Object aobj[])
    {
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        Log.e("ex1", "onStop onPostExecute");
        if (EyeReplacerActivity.a(a) == null) goto _L2; else goto _L1
_L1:
        obj = EyeReplacerActivity.a(a);
        if (((a) (obj)).b == null || ((a) (obj)).k) goto _L4; else goto _L3
_L3:
        ImageOpCommon.freeNativeBuffer(((a) (obj)).b);
        obj.b = null;
_L6:
        if (((a) (obj)).c != null && !((a) (obj)).c.isRecycled())
        {
            c.a(((a) (obj)).c, "EyeReplacer");
            obj.c = null;
        }
_L2:
        return;
_L4:
        if (((a) (obj)).k)
        {
            obj.l = true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    (EyeReplacerActivity eyereplaceractivity)
    {
        a = eyereplaceractivity;
        super();
    }
}
