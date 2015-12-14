// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.picsart.studio.editor.view.SquareFitEditorView;
import com.socialin.android.util.w;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class b extends AsyncTask
{

    private int a;
    private SquareFitFragment b;

    private transient Bitmap a()
    {
        float f;
        Object obj;
        obj = new android.graphics.();
        obj.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(SquareFitFragment.M(b), ((android.graphics.) (obj)));
        int i = ((android.graphics.) (obj)).outWidth;
        int k = ((android.graphics.) (obj)).outHeight;
        f = (float)i / (float)k;
        obj = SquareFitFragment.M(b);
        if (f > 1.0F) goto _L2; else goto _L1
_L1:
        int j;
        int l;
        try
        {
            j = a;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        if (f > 1.0F)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        l = (int)((float)a / f);
_L3:
        return w.a(((String) (obj)), j, l, m.d(SquareFitFragment.M(b)));
_L2:
        j = (int)((float)a * f);
        break MISSING_BLOCK_LABEL_62;
        l = a;
          goto _L3
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onCancelled()
    {
        SquareFitFragment.O(b).remove(this);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        SquareFitFragment.c(b).setBgPattern(((Bitmap) (obj)));
        SquareFitFragment.c(b).invalidate();
        SquareFitFragment.O(b).remove(this);
        if (SquareFitFragment.O(b).size() == 0 && !SquareFitFragment.d(b))
        {
            SquareFitFragment.B(b).setVisibility(8);
        }
    }

    (SquareFitFragment squarefitfragment)
    {
        b = squarefitfragment;
        super();
        a = Math.min(SquareFitFragment.c(b).c, 2048);
    }
}
