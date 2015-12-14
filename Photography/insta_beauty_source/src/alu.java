// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.File;

class alu
    implements alz
{

    final alt a;

    alu(alt alt1)
    {
        a = alt1;
        super();
    }

    public void a()
    {
        Object obj;
        obj = new File((new StringBuilder()).append(als.a()).append("/fonts/").append(a.a.f).append(".zip").toString());
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
        }
        obj = new File((new StringBuilder()).append(als.a()).append("/fonts/").append(a.a.f).toString());
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_224;
        }
        obj = Typeface.createFromFile(((File) (obj)));
        if (obj != null)
        {
            try
            {
                if (als.c(a.b) != null)
                {
                    als.c(a.b).a(((Typeface) (obj)));
                }
                obj = new Intent(als.a);
                InstaBeautyApplication.a.sendBroadcast(((Intent) (obj)));
                return;
            }
            catch (Exception exception) { }
            break MISSING_BLOCK_LABEL_195;
        }
        if (als.c(a.b) != null)
        {
            als.c(a.b).a();
            return;
        }
        break MISSING_BLOCK_LABEL_252;
        if (als.c(a.b) != null)
        {
            als.c(a.b).a();
            return;
        }
        break MISSING_BLOCK_LABEL_252;
        if (als.c(a.b) != null)
        {
            als.c(a.b).a();
        }
    }
}
