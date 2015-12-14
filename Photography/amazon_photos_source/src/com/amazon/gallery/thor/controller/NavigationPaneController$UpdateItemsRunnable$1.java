// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.controller;

import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.controller:
//            NavigationPaneController

class val.hideItems
    implements Runnable
{

    final is._cls0 this$1;
    final List val$hideItems;
    final List val$showItems;

    public void run()
    {
        if (NavigationPaneController.access$200(_fld0) != null)
        {
            Integer integer;
            for (Iterator iterator = val$showItems.iterator(); iterator.hasNext(); NavigationPaneController.access$200(_fld0).setItemVisible(integer.intValue()))
            {
                integer = (Integer)iterator.next();
            }

            Integer integer1;
            for (Iterator iterator1 = val$hideItems.iterator(); iterator1.hasNext(); NavigationPaneController.access$200(_fld0).setItemInvisible(integer1.intValue()))
            {
                integer1 = (Integer)iterator1.next();
            }

        }
    }

    ()
    {
        this$1 = final_;
        val$showItems = list;
        val$hideItems = List.this;
        super();
    }
}
