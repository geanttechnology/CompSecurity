// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.translate.copydrop.views;

import android.view.View;

// Referenced classes of package com.google.android.apps.translate.copydrop.views:
//            TranslationEditTextView

final class f
    implements android.view.View.OnClickListener
{

    final TranslationEditTextView a;

    f(TranslationEditTextView translationedittextview)
    {
        a = translationedittextview;
        super();
    }

    public final void onClick(View view)
    {
        TranslationEditTextView.a(a);
    }
}
