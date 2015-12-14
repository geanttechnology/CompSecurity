// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.File;

class bet
    implements bfa
{

    final ber a;

    bet(ber ber1)
    {
        a = ber1;
        super();
    }

    public void a()
    {
        Object obj;
        obj = new File((new StringBuilder()).append(ber.a()).append("/fonts/").append(ber.a(a).d).append(".zip").toString());
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
        }
        obj = new File((new StringBuilder()).append(ber.a()).append("/fonts/").append(ber.a(a).d).toString());
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_206;
        }
        obj = Typeface.createFromFile(((File) (obj)));
        if (obj != null)
        {
            try
            {
                if (ber.e(a) != null)
                {
                    ber.e(a).a(((Typeface) (obj)));
                }
                obj = new Intent(ber.a);
                InstaBeautyApplication.a.sendBroadcast(((Intent) (obj)));
                return;
            }
            catch (Exception exception) { }
            break MISSING_BLOCK_LABEL_183;
        }
        if (ber.e(a) != null)
        {
            ber.e(a).a();
            return;
        }
        break MISSING_BLOCK_LABEL_228;
        if (ber.e(a) != null)
        {
            ber.e(a).a();
            return;
        }
        break MISSING_BLOCK_LABEL_228;
        if (ber.e(a) != null)
        {
            ber.e(a).a();
        }
    }
}
