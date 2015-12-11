// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import com.urbanairship.Logger;
import java.util.Set;

// Referenced classes of package com.urbanairship.push:
//            TagGroupsEditor, PushManager

class r extends TagGroupsEditor
{

    final PushManager this$0;

    public TagGroupsEditor addTag(String s, String s1)
    {
        if (PushManager.access$000(PushManager.this) && "device".equals(s))
        {
            Logger.error((new StringBuilder("Unable to add tag ")).append(s1).append(" to device tag group when channelTagRegistrationEnabled is true.").toString());
            return this;
        } else
        {
            return super.addTag(s, s1);
        }
    }

    public TagGroupsEditor addTags(String s, Set set)
    {
        if (PushManager.access$000(PushManager.this) && "device".equals(s))
        {
            Logger.error((new StringBuilder("Unable to add tags { ")).append(set).append(" } to device tag group when channelTagRegistrationEnabled is true.").toString());
            return this;
        } else
        {
            return super.addTags(s, set);
        }
    }

    public TagGroupsEditor removeTag(String s, String s1)
    {
        if (PushManager.access$000(PushManager.this) && "device".equals(s))
        {
            Logger.error((new StringBuilder("Unable to remove tag ")).append(s1).append(" from device tag group when channelTagRegistrationEnabled is true.").toString());
            return this;
        } else
        {
            return super.removeTag(s, s1);
        }
    }

    public TagGroupsEditor removeTags(String s, Set set)
    {
        if (PushManager.access$000(PushManager.this) && "device".equals(s))
        {
            Logger.error((new StringBuilder("Unable to remove tags { ")).append(set).append(" } from device tag group when channelTagRegistrationEnabled is true.").toString());
            return this;
        } else
        {
            return super.removeTags(s, set);
        }
    }

    r(String s)
    {
        this$0 = PushManager.this;
        super(s);
    }
}
