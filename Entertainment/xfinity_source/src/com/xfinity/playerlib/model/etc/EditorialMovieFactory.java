// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.etc;

import com.xfinity.playerlib.model.EditorialMovie;
import com.xfinity.playerlib.model.EditorialProgram;

// Referenced classes of package com.xfinity.playerlib.model.etc:
//            EditorialProgramFactory

public class EditorialMovieFactory
    implements EditorialProgramFactory
{

    public EditorialMovieFactory()
    {
    }

    public EditorialMovie create()
    {
        return new EditorialMovie();
    }

    public volatile EditorialProgram create()
    {
        return create();
    }
}
