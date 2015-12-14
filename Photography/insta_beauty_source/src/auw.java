// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;
import com.fotoable.sketch.activity.TTieZhiActivity;
import com.instabeauty.application.InstaBeautyApplication;
import java.util.ArrayList;

public class auw
    implements bje
{

    final TTieZhiActivity a;

    public auw(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void DidProcessed(ArrayList arraylist, int i)
    {
        arraylist = (Bitmap)arraylist.get(0);
        if (arraylist == null)
        {
            TTieZhiActivity.d(a);
            Toast.makeText(a.getApplicationContext(), 0x7f0600f5, 0).show();
        } else
        {
            a.h = arraylist;
            if (a.h != null)
            {
                (new Thread(new aux(this))).start();
                return;
            }
        }
    }

    public void StartProcessing(int i)
    {
        TTieZhiActivity.a(a, true, InstaBeautyApplication.a.getString(0x7f06015c));
    }
}
