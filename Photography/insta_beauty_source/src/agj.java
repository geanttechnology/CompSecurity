// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import java.util.ArrayList;

public class agj
    implements bje
{

    final ProEditFontActivity a;

    public agj(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void DidProcessed(ArrayList arraylist, int i)
    {
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            a.f();
            Toast.makeText(a.getApplicationContext(), 0x7f0600f5, 0).show();
            a.finish();
            return;
        } else
        {
            ProEditFontActivity.a(a, arraylist);
            ProEditFontActivity.a(a);
            return;
        }
    }

    public void StartProcessing(int i)
    {
    }
}
