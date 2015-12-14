// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import java.util.List;

public interface SelectionAction
{

    public abstract boolean canExecute(List list);

    public abstract boolean canExecuteTags(List list);

    public abstract void execute(List list);

    public abstract void executeTags(List list);
}
