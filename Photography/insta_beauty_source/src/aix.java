// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;
import java.util.ArrayList;

public class aix
    implements bje
{

    final ProEditSlimBodyActivity a;

    public aix(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
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
            return;
        } else
        {
            ProEditSlimBodyActivity.a(a, arraylist);
            ProEditSlimBodyActivity.b(a, arraylist);
            ProEditSlimBodyActivity.f(a);
            return;
        }
    }

    public void StartProcessing(int i)
    {
        a.a();
    }
}
