// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;

public class ahj
    implements Runnable
{

    final Bitmap a;
    final ProEditMosaicActivity b;

    public ahj(ProEditMosaicActivity proeditmosaicactivity, Bitmap bitmap)
    {
        b = proeditmosaicactivity;
        a = bitmap;
        super();
    }

    public void run()
    {
        b.b();
        if (a != null && !a.isRecycled()) goto _L2; else goto _L1
_L1:
        b.finish();
        b.overridePendingTransition(0, 0x7f04001e);
_L4:
        return;
_L2:
        if (a == null) goto _L4; else goto _L3
_L3:
        if (!ProEditMosaicActivity.h(b))
        {
            break MISSING_BLOCK_LABEL_96;
        }
        apq.a("mosaic");
_L5:
        Exception exception;
        b.a();
        uv.c().a(a, new ahk(this));
        return;
        try
        {
            apq.a("draw");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
          goto _L5
    }
}
