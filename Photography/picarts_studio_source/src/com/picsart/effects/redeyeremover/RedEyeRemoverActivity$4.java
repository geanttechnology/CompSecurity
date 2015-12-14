// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.redeyeremover;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.picsart.studio.EditingData;
import com.socialin.android.dialog.g;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.ay.e;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.redeyeremover:
//            RedEyeRemoverActivity, RedEyeRemoverImageView

final class a extends ModernAsyncTask
{

    private RedEyeRemoverActivity a;

    protected final transient Object doInBackground(Object aobj[])
    {
        Object obj2 = null;
        Bitmap bitmap = (Bitmap)aobj[0];
        Object obj;
        Object obj1;
        Point point;
        Context context;
        long l;
        if (aobj[1] != null)
        {
            obj = (String)aobj[1];
        } else
        {
            obj = null;
        }
        if (aobj[2] != null)
        {
            obj1 = (String)aobj[2];
        } else
        {
            obj1 = null;
        }
        context = (Context)aobj[3];
        point = new Point(bitmap.getWidth(), bitmap.getHeight());
        l = System.nanoTime();
        if (obj != null)
        {
            aobj = new File(((String) (obj)));
            w.a(((File) (aobj)), bitmap, android.graphics.G, context);
            obj = obj2;
        } else
        if (obj1 != null)
        {
            obj = w.a(((String) (obj1)), bitmap);
            aobj = null;
        } else
        {
            aobj = null;
            obj = obj2;
        }
        l = (System.nanoTime() - l) / 0xf4240L;
        obj1 = new ArrayList();
        ((ArrayList) (obj1)).add(((Object) (aobj)));
        ((ArrayList) (obj1)).add(obj);
        ((ArrayList) (obj1)).add(new Long(l));
        ((ArrayList) (obj1)).add(point);
        return obj1;
    }

    protected final void onPostExecute(Object obj)
    {
        RedEyeRemoverActivity.c(a);
        if (!a.isFinishing())
        {
            RedEyeRemoverActivity.d(a).dismiss();
            Intent intent = new Intent();
            obj = (ArrayList)obj;
            String s;
            Point point;
            Object obj1;
            long l;
            if (((ArrayList) (obj)).get(0) != null)
            {
                intent.putExtra("path", ((File)((ArrayList) (obj)).get(0)).getAbsolutePath());
            } else
            {
                intent.putExtra("result_buffer_Data", (HashMap)((ArrayList) (obj)).get(1));
            }
            l = ((Long)((ArrayList) (obj)).get(2)).longValue();
            point = (Point)((ArrayList) (obj)).get(3);
            s = "";
            obj1 = a.getIntent();
            obj = s;
            if (((Intent) (obj1)).hasExtra("editing_data"))
            {
                obj1 = (EditingData)((Intent) (obj1)).getParcelableExtra("editing_data");
                obj = s;
                if (obj1 != null)
                {
                    obj = ((EditingData) (obj1)).a;
                }
            }
            Log.e("ex1", (new StringBuilder("RED EYE remover uid = ")).append(((String) (obj))).toString());
            e.a(a, "effect_red_eye", point.x, point.y, true, true, l, false, new JSONArray(), ((String) (obj)));
            a.setResult(-1, intent);
            a.finish();
            return;
        } else
        {
            RedEyeRemoverActivity.a(a).a();
            return;
        }
    }

    (RedEyeRemoverActivity redeyeremoveractivity)
    {
        a = redeyeremoveractivity;
        super();
    }
}
