// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.etc;

import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.model.EditorialTVSeries;

// Referenced classes of package com.xfinity.playerlib.model.etc:
//            EditorialProgramFactory

public class EditorialTVSeriesFactory
    implements EditorialProgramFactory
{

    public EditorialTVSeriesFactory()
    {
    }

    public volatile EditorialProgram create()
    {
        return create();
    }

    public EditorialTVSeries create()
    {
        return new EditorialTVSeries();
    }
}
