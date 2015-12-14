// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.controller.androidviewcontroller;

import android.view.View;

// Referenced classes of package com.amazon.gallery.foundation.ui.controller.androidviewcontroller:
//            AndroidViewController

public class AndroidViewCompositeController
    implements AndroidViewController
{

    private final AndroidViewController controllers[];

    public transient AndroidViewCompositeController(AndroidViewController aandroidviewcontroller[])
    {
        controllers = aandroidviewcontroller;
    }

    public boolean onClick(View view, int i)
    {
        AndroidViewController aandroidviewcontroller[] = controllers;
        int k = aandroidviewcontroller.length;
        for (int j = 0; j < k; j++)
        {
            if (aandroidviewcontroller[j].onClick(view, i))
            {
                return true;
            }
        }

        return false;
    }

    public boolean onLongClick(View view, int i)
    {
        AndroidViewController aandroidviewcontroller[] = controllers;
        int k = aandroidviewcontroller.length;
        for (int j = 0; j < k; j++)
        {
            if (aandroidviewcontroller[j].onLongClick(view, i))
            {
                return true;
            }
        }

        return false;
    }
}
