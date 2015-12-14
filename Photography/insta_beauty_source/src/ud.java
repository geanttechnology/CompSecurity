// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import java.io.File;

public class ud
    implements Runnable
{

    final MNewFotoBeautyActivity a;

    public ud(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void run()
    {
        Object obj = sm.a(MNewFotoBeautyActivity.f(a));
        if (obj == null)
        {
            a.runOnUiThread(new ue(this));
            return;
        } else
        {
            sm.a(((File) (obj)).getAbsolutePath(), a);
            Uri uri = Uri.fromFile(((File) (obj)));
            obj = ((File) (obj)).getAbsolutePath();
            a.runOnUiThread(new uf(this, ((String) (obj)), uri));
            return;
        }
    }
}
