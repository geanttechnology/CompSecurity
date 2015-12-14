// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.Intent;
import android.view.View;
import com.picsart.studio.ImagePickerActivity;
import com.picsart.studio.editor.Tool;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a
    implements android.view..SquareFitFragment._cls17
{

    private SquareFitFragment a;

    public final void onClick(View view)
    {
        view = new Intent(a.getActivity(), com/picsart/studio/ImagePickerActivity);
        view.putExtra("fromDrawing", false);
        view.putExtra("showCameraEffects", false);
        view.putExtra("from", Tool.SQUARE_FIT.toString().toLowerCase());
        a.startActivityForResult(view, com.picsart.studio.editor.activity.tCode.SELECT_PHOTO.toInt());
    }

    tCode(SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
