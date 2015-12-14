// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.sketch.activity.TTieZhiActivity;

class avo
    implements Runnable
{

    final avn a;

    avo(avn avn1)
    {
        a = avn1;
        super();
    }

    public void run()
    {
        Bitmap bitmap = TTieZhiActivity.a(a.a, a.a.h.getWidth(), a.a.h.getHeight());
        a.a.runOnUiThread(new avp(this, bitmap));
    }
}
