// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.content.Intent;
import com.picsart.studio.ImagePickerActivity;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView, a

public class c
{

    e a;

    c(e e1)
    {
        a = e1;
        super();
    }

    public void a()
    {
        Object obj = e.b(a).b.iterator();
        int i = 0;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            if (((a)((Iterator) (obj)).next()).d == null)
            {
                i++;
            }
        } while (true);
        obj = a;
        Intent intent = new Intent(((e) (obj)).getActivity(), com/picsart/studio/ImagePickerActivity);
        intent.putExtra("multipleCheckMode", true);
        intent.putExtra("itemsCount", i);
        intent.putExtra("selectedIndex", ((e) (obj)).a.d);
        ((e) (obj)).startActivityForResult(intent, 1001);
    }
}
