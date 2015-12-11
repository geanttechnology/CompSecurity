// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            AddPhotoSelectSourceDialog

class a extends DebouncingOnClickListener
{

    final AddPhotoSelectSourceDialog a;
    final nClicked b;

    public void doClick(View view)
    {
        a.onGalleryButtonClicked();
    }

    ( , AddPhotoSelectSourceDialog addphotoselectsourcedialog)
    {
        b = ;
        a = addphotoselectsourcedialog;
        super();
    }
}
