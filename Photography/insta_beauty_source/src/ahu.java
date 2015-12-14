// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;
import java.util.ArrayList;

public class ahu
    implements bje
{

    final ProEditMosaicActivity a;

    public ahu(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void DidProcessed(ArrayList arraylist, int i)
    {
        Log.i("ProEditMosaicActivity", "DidProcessed");
        a.b();
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            Toast.makeText(a.getApplicationContext(), 0x7f0600f5, 0).show();
            a.finish();
        } else
        {
            ProEditMosaicActivity.a(a, arraylist);
            if (ProEditMosaicActivity.i(a) != null)
            {
                a.b();
                ProEditMosaicActivity.j(a);
                return;
            }
        }
    }

    public void StartProcessing(int i)
    {
        a.a();
    }
}
