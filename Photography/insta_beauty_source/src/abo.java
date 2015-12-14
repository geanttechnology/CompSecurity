// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import com.fotoable.fotobeauty.NewPhotoShareActivity;

public class abo
    implements atx
{

    final NewPhotoShareActivity a;

    public abo(NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }

    public void a(boolean flag, boolean flag1)
    {
        android.content.SharedPreferences.Editor editor;
        NewPhotoShareActivity.b(a);
        editor = a.getSharedPreferences("shareStyle", 0).edit();
        editor.putString("shareName", "sync_instagram");
        if (!flag || flag1) goto _L2; else goto _L1
_L1:
        editor.putInt("ShareState", 1);
_L4:
        editor.commit();
        return;
_L2:
        if (flag && flag1)
        {
            editor.putInt("ShareState", 2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
