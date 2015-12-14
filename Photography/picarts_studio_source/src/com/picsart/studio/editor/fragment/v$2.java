// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.CompoundButton;
import com.socialin.android.photo.collage.ShapeCropView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            v

final class a
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private v a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        v.b(a).setInverted(flag);
    }

    eCropView(v v1)
    {
        a = v1;
        super();
    }
}
