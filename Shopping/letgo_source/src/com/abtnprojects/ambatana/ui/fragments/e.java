// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            b

public class e extends b
{

    public e()
    {
    }

    public static e a()
    {
        return new e();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f070001);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view.setBackgroundColor(getResources().getColor(0x7f0f0091));
    }
}
