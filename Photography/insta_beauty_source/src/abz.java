// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.Toast;
import com.fotoable.fotobeauty.NewPhotoShareActivity;
import com.fotoable.fotobeauty.PhotoShareToInstagramActivity;
import java.io.File;

class abz
    implements Runnable
{

    final File a;
    final aby b;

    abz(aby aby1, File file)
    {
        b = aby1;
        a = file;
        super();
    }

    public void run()
    {
        if (a == null)
        {
            Toast.makeText(b.b, b.b.getResources().getString(0x7f0601b8), 0).show();
        } else
        {
            sm.a(a.getAbsolutePath(), b.b);
            Uri uri = Uri.fromFile(a);
            if (uri != null)
            {
                Intent intent = new Intent(b.b, com/fotoable/fotobeauty/NewPhotoShareActivity);
                intent.putExtra("PhotoShareActivity_ToShareImageUri", uri.toString());
                b.b.startActivity(intent);
                b.b.overridePendingTransition(0x7f040009, 0);
                return;
            }
        }
    }
}
