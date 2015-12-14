// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.Toast;
import com.fotoable.fotobeauty.PhotoShareToInstagramActivity;
import java.util.ArrayList;

public class aca
    implements bje
{

    final PhotoShareToInstagramActivity a;

    public aca(PhotoShareToInstagramActivity photosharetoinstagramactivity)
    {
        a = photosharetoinstagramactivity;
        super();
    }

    public void DidProcessed(ArrayList arraylist, int i)
    {
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            Toast.makeText(a.getApplicationContext(), 0x7f0600f5, 0).show();
            a.a();
            return;
        } else
        {
            a.a(arraylist);
            return;
        }
    }

    public void StartProcessing(int i)
    {
    }
}
