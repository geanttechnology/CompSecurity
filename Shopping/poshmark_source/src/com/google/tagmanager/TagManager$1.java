// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            TagManager

class this._cls0
    implements tener
{

    final TagManager this$0;

    public void changed(Map map)
    {
        map = ((Map) (map.get("event")));
        if (map != null)
        {
            TagManager.access$000(TagManager.this, map.toString());
        }
    }

    tener()
    {
        this$0 = TagManager.this;
        super();
    }
}
