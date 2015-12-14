// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.Toast;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;
import java.util.ArrayList;

public class afy
    implements bje
{

    final ProEditFilterActivity a;

    public afy(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }

    public void DidProcessed(ArrayList arraylist, int i)
    {
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            a.c();
            Toast.makeText(a.getApplicationContext(), 0x7f0600f5, 0).show();
            a.finish();
        } else
        {
            a.i = arraylist;
            if (a.i != null)
            {
                a.c();
                if (ProEditFilterActivity.n(a))
                {
                    ProEditFilterActivity.d(a);
                    return;
                } else
                {
                    ProEditFilterActivity.b(a, true);
                    return;
                }
            }
        }
    }

    public void StartProcessing(int i)
    {
    }
}
