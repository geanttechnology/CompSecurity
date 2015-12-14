// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.content.Intent;
import com.picsart.studio.EditingData;
import com.picsart.studio.utils.c;
import com.socialin.android.photo.draw.DrawingActivity;
import myobfuscated.bj.b;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            StudioActivity

final class g
    implements b
{

    private final String a;
    private StudioActivity b;

    public g(StudioActivity studioactivity, String s)
    {
        b = studioactivity;
        super();
        a = s;
    }

    public final void a(int i, int j)
    {
        Intent intent = new Intent(b, com/socialin/android/photo/draw/DrawingActivity);
        intent.putExtra("from", "default");
        intent.putExtra("extra.has.bg.image", true);
        intent.putExtra("path", a);
        intent.putExtra("degree", 0);
        intent.putExtra("comingFrom", 1);
        intent.putExtra("editing_data", EditingData.a(c.a(b, null), "background"));
        intent.putExtra("extra.bg.mode", true);
        intent.putExtra("extra.bg.path", a);
        intent.putExtra("extra.canvas.width", i);
        intent.putExtra("extra.canvas.height", j);
        b.startActivity(intent);
        b.finish();
    }
}
