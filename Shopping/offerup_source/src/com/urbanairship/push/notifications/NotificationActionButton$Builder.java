// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.notifications;

import android.support.design.widget.al;
import android.support.v4.app.bh;
import android.support.v4.app.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship.push.notifications:
//            NotificationActionButton, LocalizableRemoteInput

public class buttonId
{

    private final String buttonId;
    private String description;
    private List extenders;
    private int iconId;
    private boolean isForegroundAction;
    private int labelId;
    private List remoteInputs;

    public buttonId addRemoteInput(LocalizableRemoteInput localizableremoteinput)
    {
        if (remoteInputs == null)
        {
            remoteInputs = new ArrayList();
        }
        remoteInputs.add(localizableremoteinput);
        return this;
    }

    public NotificationActionButton build()
    {
        Object obj = new bi(iconId, null, null);
        if (extenders != null)
        {
            for (Iterator iterator = extenders.iterator(); iterator.hasNext(); iterator.next()) { }
        }
        obj = ((bi) (obj)).a();
        return new NotificationActionButton(buttonId, ((bh) (obj)).a, labelId, description, ((bh) (obj)).d(), isForegroundAction, remoteInputs, null);
    }

    public remoteInputs extend$4a02a3(al al)
    {
        if (extenders == null)
        {
            extenders = new ArrayList();
        }
        extenders.add(al);
        return this;
    }

    public extenders setDescription(String s)
    {
        description = s;
        return this;
    }

    public description setIcon(int i)
    {
        iconId = i;
        return this;
    }

    public iconId setLabel(int i)
    {
        labelId = i;
        return this;
    }

    public labelId setPerformsInForeground(boolean flag)
    {
        isForegroundAction = flag;
        return this;
    }

    public (String s)
    {
        labelId = 0;
        iconId = 0;
        isForegroundAction = true;
        buttonId = s;
    }
}
