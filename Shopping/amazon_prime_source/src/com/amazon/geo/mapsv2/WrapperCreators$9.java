// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.internal.IUiSettingsDelegate;

// Referenced classes of package com.amazon.geo.mapsv2:
//            WrapperCreators, UiSettings

static final class legate
    implements com.amazon.geo.mapsv2.pvt.eator
{

    public UiSettings newWrapper(IUiSettingsDelegate iuisettingsdelegate)
    {
        return new UiSettings(iuisettingsdelegate);
    }

    public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
    {
        return newWrapper((IUiSettingsDelegate)iobjectdelegate);
    }

    legate()
    {
    }
}
