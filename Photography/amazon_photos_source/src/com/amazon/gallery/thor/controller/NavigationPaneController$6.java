// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.controller;

import android.content.SharedPreferences;

// Referenced classes of package com.amazon.gallery.thor.controller:
//            NavigationPaneController

class this._cls0
    implements android.content.referenceChangeListener
{

    final NavigationPaneController this$0;

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        while (sharedpreferences == null || !"coldBootStatus".equals(s)) 
        {
            return;
        }
        updateItems();
    }

    ener()
    {
        this$0 = NavigationPaneController.this;
        super();
    }
}
