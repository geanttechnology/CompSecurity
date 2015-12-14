// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.AdapterView;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.photo.collage.ShapeCropView;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            v

final class a
    implements android.widget.terView.OnItemSelectedListener
{

    private List a;
    private v b;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        v.b(b).setBlendMode((BlendMode)a.get(i));
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    eCropView(v v1, List list)
    {
        b = v1;
        a = list;
        super();
    }
}
