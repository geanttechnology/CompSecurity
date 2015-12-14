// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;


// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteAction

private static class actionState
{

    private final rce actionSource;
    private final rce actionState;
    private final rce selection;

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof actionState))
        {
            if (((actionState) (obj = (actionState)obj)).selection == selection && ((selection) (obj)).actionSource == actionSource && ((actionSource) (obj)).actionState == actionState)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return selection.shCode() + actionSource.hashCode() * 31 + actionState.hashCode() * 59;
    }

    public rce(rce rce, rce rce1, rce rce2)
    {
        selection = rce;
        actionSource = rce1;
        actionState = rce2;
    }
}
