// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import android.widget.CompoundButton;
import nl;

// Referenced classes of package com.fotoable.photoselector.uicomp:
//            EncryptItemView

class a
    implements android.widget.heckedChangeListener
{

    final EncryptItemView a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (EncryptItemView.access$000(a) != null)
        {
            EncryptItemView.access$000(a).c(flag);
        }
    }

    r(EncryptItemView encryptitemview)
    {
        a = encryptitemview;
        super();
    }
}
