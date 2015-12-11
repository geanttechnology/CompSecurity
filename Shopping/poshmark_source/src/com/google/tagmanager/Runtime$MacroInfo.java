// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            Runtime

private static class dedFunctionCall
{

    private final Map mAddMacroNames = new HashMap();
    private final Map mAddMacros = new HashMap();
    private dedFunctionCall mDefault;
    private final Map mRemoveMacroNames = new HashMap();
    private final Map mRemoveMacros = new HashMap();
    private final Set mRules = new HashSet();

    public void addAddMacroForRule(dedRule dedrule, dedFunctionCall dedfunctioncall)
    {
        List list = (List)mAddMacros.get(dedrule);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            mAddMacros.put(dedrule, obj);
        }
        ((List) (obj)).add(dedfunctioncall);
    }

    public void addAddMacroRuleNameForRule(dedRule dedrule, String s)
    {
        List list = (List)mAddMacroNames.get(dedrule);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            mAddMacroNames.put(dedrule, obj);
        }
        ((List) (obj)).add(s);
    }

    public void addRemoveMacroForRule(dedRule dedrule, dedFunctionCall dedfunctioncall)
    {
        List list = (List)mRemoveMacros.get(dedrule);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            mRemoveMacros.put(dedrule, obj);
        }
        ((List) (obj)).add(dedfunctioncall);
    }

    public void addRemoveMacroRuleNameForRule(dedRule dedrule, String s)
    {
        List list = (List)mRemoveMacroNames.get(dedrule);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            mRemoveMacroNames.put(dedrule, obj);
        }
        ((List) (obj)).add(s);
    }

    public void addRule(dedRule dedrule)
    {
        mRules.add(dedrule);
    }

    public Map getAddMacroRuleNames()
    {
        return mAddMacroNames;
    }

    public Map getAddMacros()
    {
        return mAddMacros;
    }

    public dedFunctionCall getDefault()
    {
        return mDefault;
    }

    public Map getRemoveMacroRuleNames()
    {
        return mRemoveMacroNames;
    }

    public Map getRemoveMacros()
    {
        return mRemoveMacros;
    }

    public Set getRules()
    {
        return mRules;
    }

    public void setDefault(dedFunctionCall dedfunctioncall)
    {
        mDefault = dedfunctioncall;
    }

    public dedFunctionCall()
    {
    }
}
