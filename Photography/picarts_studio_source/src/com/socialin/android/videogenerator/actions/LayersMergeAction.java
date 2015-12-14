// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            AsyncAction, Action

public class LayersMergeAction extends AsyncAction
{

    private static final long serialVersionUID = 0xf4a2a7274b9a5502L;
    private boolean isComplete;
    private List mergeActions;

    public LayersMergeAction(String s)
    {
        super(s);
        isComplete = false;
        mergeActions = new ArrayList();
    }

    public LayersMergeAction(List list, String s)
    {
        super(s);
        isComplete = false;
        mergeActions = list;
    }

    public void addMergeAction(Action action)
    {
        mergeActions.add(action);
    }

    public void apply(a a)
    {
        for (Iterator iterator = mergeActions.iterator(); iterator.hasNext(); ((Action)iterator.next()).apply(a)) { }
    }

    public String getActionDescription()
    {
        return "Merging Layers";
    }

    public List getActions()
    {
        return mergeActions;
    }

    public boolean isComplete()
    {
        return isComplete;
    }

    public void setComplete(boolean flag)
    {
        isComplete = flag;
    }

    public String toString()
    {
        Iterator iterator = mergeActions.iterator();
        String s;
        Action action;
        for (s = "Merging Layers LayerIds: "; iterator.hasNext(); s = (new StringBuilder()).append(s).append(" ").append(action).toString())
        {
            action = (Action)iterator.next();
        }

        return s;
    }
}
