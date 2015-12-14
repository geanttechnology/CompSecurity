// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import com.picsart.studio.EditingData;
import com.socialin.android.dialog.g;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.ay.e;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixActivity, BlemishFixImageView

final class a extends ModernAsyncTask
{

    private BlemishFixActivity a;

    protected final Object doInBackground(Object aobj[])
    {
        Object obj = null;
        HashMap hashmap = null;
        Bitmap bitmap = ((Bitmap[])aobj)[0];
        long l = System.nanoTime();
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        aobj = obj;
        if (bitmap != null)
        {
            aobj = obj;
            if (!bitmap.isRecycled())
            {
                ArrayList arraylist;
                if (BlemishFixActivity.c(a) != null)
                {
                    aobj = new File(BlemishFixActivity.c(a));
                    w.a(((File) (aobj)), bitmap, android.graphics..PNG, a);
                } else
                if (BlemishFixActivity.d(a) != null)
                {
                    hashmap = w.a(BlemishFixActivity.d(a), bitmap);
                    aobj = null;
                } else
                {
                    aobj = null;
                }
                arraylist = new ArrayList();
                arraylist.add(((Object) (aobj)));
                arraylist.add(hashmap);
                arraylist.add(new Long((System.nanoTime() - l) / 0xf4240L));
                arraylist.add(new Point(i, j));
                aobj = arraylist;
            }
        }
        return ((Object) (aobj));
    }

    protected final void onPostExecute(Object obj)
    {
label0:
        {
            Object obj2 = (ArrayList)obj;
            if (!a.isFinishing())
            {
                BlemishFixActivity.a(a).setSaving(false);
                if (obj2 == null)
                {
                    break label0;
                }
                Object obj1;
                int i;
                int j;
                long l;
                boolean flag;
                if (((ArrayList) (obj2)).get(0) != null)
                {
                    obj = (File)((ArrayList) (obj2)).get(0);
                } else
                {
                    obj = null;
                }
                if (((ArrayList) (obj2)).get(1) != null)
                {
                    obj1 = (HashMap)((ArrayList) (obj2)).get(1);
                } else
                {
                    obj1 = null;
                }
                l = ((Long)((ArrayList) (obj2)).get(2)).longValue();
                obj2 = (Point)((ArrayList) (obj2)).get(3);
                i = ((Point) (obj2)).x;
                j = ((Point) (obj2)).y;
                a.a.dismiss();
                obj2 = new Intent();
                if (obj != null)
                {
                    ((Intent) (obj2)).putExtra("path", ((File) (obj)).getAbsolutePath());
                } else
                if (obj1 != null)
                {
                    ((Intent) (obj2)).putExtra("result_buffer_Data", ((java.io.Serializable) (obj1)));
                }
                a.setResult(-1, ((Intent) (obj2)));
                BlemishFixActivity.a(a).setProcessRuning(false);
                a.finish();
                obj1 = "";
                obj2 = a.getIntent();
                obj = obj1;
                if (((Intent) (obj2)).hasExtra("editing_data"))
                {
                    obj2 = (EditingData)((Intent) (obj2)).getParcelableExtra("editing_data");
                    obj = obj1;
                    if (obj2 != null)
                    {
                        obj = ((EditingData) (obj2)).a;
                    }
                }
                obj1 = a;
                if (!a.b)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                e.a(((android.content.Context) (obj1)), "effect_blemish_fix", i, j, flag, true, l, false, new JSONArray(), ((String) (obj)));
            }
            return;
        }
        a.finish();
    }

    _cls9(BlemishFixActivity blemishfixactivity)
    {
        a = blemishfixactivity;
        super();
    }
}
