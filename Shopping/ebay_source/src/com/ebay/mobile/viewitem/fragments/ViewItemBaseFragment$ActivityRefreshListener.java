// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.Intent;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment

public static interface 
{

    public static final String MEB_FLAGS = "meb_flags";

    public abstract void deleteCachedItem();

    public abstract void reloadItemFromNetwork(Intent intent);
}
