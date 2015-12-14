// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;
import java.io.File;

class le
    implements uy
{

    final File a;
    final String b;
    final ld c;

    le(ld ld1, File file, String s)
    {
        c = ld1;
        a = file;
        b = s;
        super();
    }

    public void a()
    {
        c.a.runOnUiThread(new lf(this));
    }
}
