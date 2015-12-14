// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;
import java.util.ArrayList;

public class aif
    implements bje
{

    final ProEditNewStretchActivity a;

    public aif(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }

    public void DidProcessed(ArrayList arraylist, int i)
    {
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            a.i.dismiss();
            Toast.makeText(a.getApplicationContext(), 0x7f0600f5, 0).show();
            a.finish();
        } else
        {
            ProEditNewStretchActivity.a(a, arraylist);
            if (ProEditNewStretchActivity.a(a) != null)
            {
                a.i.dismiss();
                ProEditNewStretchActivity.b(a);
                return;
            }
        }
    }

    public void StartProcessing(int i)
    {
    }
}
