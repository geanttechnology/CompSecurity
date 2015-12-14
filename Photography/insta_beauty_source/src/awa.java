// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.sketch.activity.TTieZhiActivity;

class awa
    implements android.view.View.OnClickListener
{

    final avz a;

    awa(avz avz1)
    {
        a = avz1;
        super();
    }

    public void onClick(View view)
    {
        if (TTieZhiActivity.a(a.a, avz.a(a), avz.b(a)))
        {
            a.b(true);
            a.a.B = a;
        }
    }
}
