// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.xfinity.playerlib.model.Favorite;
import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            FavoriteSpeechRecognizer

class this._cls1
    implements Comparator
{

    final compare this$1;

    public int compare(Favorite favorite, Favorite favorite1)
    {
        return favorite1.getCreated().compareTo(favorite.getCreated());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Favorite)obj, (Favorite)obj1);
    }

    Y()
    {
        this$1 = this._cls1.this;
        super();
    }
}
