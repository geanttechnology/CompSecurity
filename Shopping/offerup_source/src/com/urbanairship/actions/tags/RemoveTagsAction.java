// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions.tags;

import com.urbanairship.Logger;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.push.PushManager;
import java.util.Set;

// Referenced classes of package com.urbanairship.actions.tags:
//            BaseTagsAction

public class RemoveTagsAction extends BaseTagsAction
{

    public static final String DEFAULT_REGISTRY_NAME = "remove_tags_action";
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^-t";

    public RemoveTagsAction()
    {
    }

    public ActionResult perform(ActionArguments actionarguments)
    {
        actionarguments = getTags(actionarguments);
        Logger.info((new StringBuilder("RemoveTagsAction - Removing tags: ")).append(actionarguments).toString());
        Set set = getPushManager().getTags();
        set.removeAll(actionarguments);
        getPushManager().setTags(set);
        return ActionResult.newEmptyResult();
    }
}
