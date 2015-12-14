// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.sticker;

import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.s;

// Referenced classes of package com.socialin.android.photo.sticker:
//            SelectStickerActivity

final class c extends ModernAsyncTask
{

    private String a;
    private String b;
    private int c;
    private SelectStickerActivity d;

    protected final Object doInBackground(Object aobj[])
    {
        return Boolean.valueOf(s.a(a, b));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Boolean)obj;
        super.onPostExecute(obj);
        if (((Boolean) (obj)).booleanValue())
        {
            SelectStickerActivity.a(d, c);
        }
    }

    (SelectStickerActivity selectstickeractivity, String s1, String s2, int i)
    {
        d = selectstickeractivity;
        a = s1;
        b = s2;
        c = i;
        super();
    }
}
