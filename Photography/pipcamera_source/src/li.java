// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.photocollage.activity.compose2.CollageHandleView;
import com.fotoable.photocollage.activity.compose2.CollageModuleFragment2;
import com.fotoable.photocollage.activity.compose2.CollageStylesType;
import com.fotoable.photocollage.activity.compose2.ComposePhotoesActivity2;
import java.util.List;

public class li
    implements android.view.View.OnClickListener
{

    final ComposePhotoesActivity2 a;

    public li(ComposePhotoesActivity2 composephotoesactivity2)
    {
        a = composephotoesactivity2;
        super();
    }

    public void onClick(View view)
    {
        if (a.g == CollageStylesType.collageFrame)
        {
            a.e.setData(a.q.size(), a.I);
            ComposePhotoesActivity2.a(a, a.f, 0x7f04002d, 300L, true);
            if (a.t != null)
            {
                a.t.c(true);
                ComposePhotoesActivity2.a(a, true);
            }
        }
        a.y = false;
    }
}
