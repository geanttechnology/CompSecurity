// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;
import java.util.ArrayList;

public class afe
    implements bje
{

    final ProEditCropActivity a;

    public afe(ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }

    public void DidProcessed(ArrayList arraylist, int i)
    {
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            a.b();
            Toast.makeText(a.getApplicationContext(), 0x7f0600f5, 0).show();
            a.finish();
        } else
        {
            ProEditCropActivity.a(a, arraylist);
            if (ProEditCropActivity.a(a) != null)
            {
                a.b();
                ProEditCropActivity.b(a);
                return;
            }
        }
    }

    public void StartProcessing(int i)
    {
    }
}
