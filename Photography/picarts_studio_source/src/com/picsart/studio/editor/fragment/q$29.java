// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.widget.Toast;
import com.picsart.shop.a;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.item.RasterClipArtItem;
import com.picsart.studio.editor.item.SvgClipArtItem;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.item.TransformingItem;
import com.socialin.android.photo.svg.Svg;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class k extends ModernAsyncTask
{

    private int a;
    private boolean b;
    private String c;
    private String d;
    private int e;
    private int f;
    private q g;

    private transient TransformingItem a()
    {
        Object obj2 = null;
        if (a != 0) goto _L2; else goto _L1
_L1:
        int i = PicsartContext.a.getCollageImageMaxSize();
        if (!b) goto _L4; else goto _L3
_L3:
        Object obj1 = com.picsart.shop.a.a().a(c, d);
        Object obj = obj1;
        android.graphics.Bitmap bitmap = com.socialin.android.util.c.a(((java.io.InputStream) (obj1)));
        obj = bitmap;
        try
        {
            ((ByteArrayInputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            ((IOException) (obj1)).printStackTrace();
        }
_L5:
        obj1 = obj2;
        if (obj != null)
        {
            obj1 = RasterClipArtItem.p();
            ((RasterClipArtItem) (obj1)).a(((android.graphics.Bitmap) (obj)), com.picsart.studio.editor.e.a().d.getTmpDirectory());
        }
_L7:
        return ((TransformingItem) (obj1));
        Exception exception;
        exception;
        obj1 = null;
_L11:
        obj = obj1;
        exception.printStackTrace();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        ((ByteArrayInputStream) (obj1)).close();
        obj = null;
          goto _L5
        obj;
        ((IOException) (obj)).printStackTrace();
        obj = null;
          goto _L5
        obj1;
        obj = null;
_L10:
        if (obj != null)
        {
            try
            {
                ((ByteArrayInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
_L4:
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        obj1 = obj2;
        if (!(new File(c)).exists()) goto _L7; else goto _L6
_L6:
        try
        {
            obj = w.b(c, i, i, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            obj = null;
        }
          goto _L5
        if (e != -1)
        {
            obj = com.socialin.android.util.c.a(g.getResources(), e);
        } else
        {
            obj = null;
        }
          goto _L5
_L2:
        obj1 = obj2;
        if (a != 1) goto _L7; else goto _L8
_L8:
        if (b)
        {
            obj = com.picsart.shop.a.a().c(c, d);
        } else
        {
            try
            {
                obj = FileUtils.f(new File(c));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
                obj = null;
            }
        }
        obj1 = obj2;
        if (obj == null) goto _L7; else goto _L9
_L9:
        obj1 = SvgClipArtItem.h();
        ((SvgClipArtItem) (obj1)).a(new Svg(((byte []) (obj))));
        if (((SvgItem) (obj1)).i.a() == 0.0F || ((SvgItem) (obj1)).i.b() == 0.0F)
        {
            Utils.c(g.getActivity(), g.getString(0x7f0805ca));
            return null;
        }
        Svg svg = ((SvgItem) (obj1)).i;
        boolean flag;
        if (c != null)
        {
            obj = (new File(c)).getName();
        } else
        if (d != null)
        {
            obj = d;
        } else
        {
            obj = "";
        }
        svg.a = ((String) (obj));
        if (f == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((SvgClipArtItem) (obj1)).b(flag);
        return ((TransformingItem) (obj1));
        obj1;
          goto _L10
        svg;
          goto _L11
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (TransformingItem)obj;
        super.onPostExecute(obj);
        if (g.isAdded()) goto _L2; else goto _L1
_L1:
        Fragment fragment = EditorActivity.a().getFragmentManager().findFragmentByTag("ItemEditorFragment_tag");
        if (fragment == null) goto _L4; else goto _L3
_L3:
        if (!fragment.isAdded() || !(fragment instanceof q) || obj == null) goto _L4; else goto _L5
_L5:
        com.picsart.studio.editor.fragment.q.a((q)fragment, ((TransformingItem) (obj)));
_L9:
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
_L4:
        if (obj != null)
        {
            com.picsart.studio.editor.fragment.q.a(g, ((TransformingItem) (obj)));
            return;
        }
          goto _L6
_L2:
        ((EditorActivity)g.getActivity()).e();
        if (true) goto _L4; else goto _L7
_L7:
_L6:
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        EditorActivity editoractivity = (EditorActivity)g.getActivity();
        if (PicsartContext.a.getAddPhotoMaxCount() - g.i() <= 0 && a == 0)
        {
            Toast.makeText(editoractivity, g.getString(0x7f080402), 0).show();
            cancel(true);
        } else
        if (editoractivity != null && !editoractivity.isFinishing() && g.isAdded())
        {
            editoractivity.d();
            return;
        }
    }

    ingItem(q q1, int i, boolean flag, String s, String s1, int j, int k)
    {
        g = q1;
        a = i;
        b = flag;
        c = s;
        d = s1;
        e = j;
        f = k;
        super();
    }
}
