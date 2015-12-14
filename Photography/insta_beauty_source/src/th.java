// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;
import java.lang.ref.WeakReference;

public class th extends Handler
{

    final FotoBeautySimpleActivity a;
    private WeakReference b;

    public th(FotoBeautySimpleActivity fotobeautysimpleactivity, FotoBeautySimpleActivity fotobeautysimpleactivity1)
    {
        a = fotobeautysimpleactivity;
        super();
        b = new WeakReference(fotobeautysimpleactivity1);
    }

    public void handleMessage(Message message)
    {
        FotoBeautySimpleActivity fotobeautysimpleactivity;
label0:
        {
            fotobeautysimpleactivity = (FotoBeautySimpleActivity)b.get();
            if (fotobeautysimpleactivity != null && message != null)
            {
                message = (Bitmap)message.obj;
                if (message != null && fotobeautysimpleactivity != null)
                {
                    break label0;
                }
            }
            return;
        }
        FotoBeautySimpleActivity.a(fotobeautysimpleactivity).post(new ti(this, fotobeautysimpleactivity, message));
    }
}
