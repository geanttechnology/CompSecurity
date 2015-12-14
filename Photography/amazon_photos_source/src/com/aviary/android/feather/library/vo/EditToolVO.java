// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.vo;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.library.vo:
//            ToolActionVO

public class EditToolVO
{

    final List toolActions = new ArrayList(0);
    final String toolId;
    final int toolVersion;

    public EditToolVO(String s, int i)
    {
        toolId = s;
        toolVersion = i;
    }

    public void addToolAction(ToolActionVO toolactionvo)
    {
        if (toolactionvo != null)
        {
            toolActions.add(toolactionvo);
        }
    }

    public List getToolActions()
    {
        return toolActions;
    }

    public String getToolId()
    {
        return toolId;
    }

    public int getToolVersion()
    {
        return toolVersion;
    }

    public void reset()
    {
        toolActions.clear();
    }

    public void setToolAction(ToolActionVO toolactionvo)
    {
        toolActions.clear();
        if (toolactionvo != null)
        {
            toolActions.add(toolactionvo);
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("EditVO{ ");
        stringbuilder.append((new StringBuilder()).append("toolId:").append(toolId).toString());
        stringbuilder.append((new StringBuilder()).append(", toolVersion:").append(toolVersion).toString());
        stringbuilder.append((new StringBuilder()).append(", edit:").append(toolActions.toString()).toString());
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }
}
