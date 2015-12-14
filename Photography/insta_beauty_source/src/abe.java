// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.fotoable.fotobeauty.NewPhotoShareActivity;

public class abe
    implements hz
{

    final NewPhotoShareActivity a;

    public abe(NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }

    public void a(String s)
    {
        if (!s.startsWith("http://") && !s.startsWith("https://") || s == null || s.length() <= 0)
        {
            return;
        } else
        {
            Intent intent = new Intent(a, com/fotoable/adbuttonlib/TWebBrowActivity);
            intent.putExtra("webUriString", s);
            a.startActivity(intent);
            return;
        }
    }

    public void b(String s)
    {
    }
}
