// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;

public interface tn
{

    public abstract void filterDownloadFailed(int i, Object obj);

    public abstract void filterDownloadFinished(Object obj);

    public abstract void filterUpdateFailed(int i);

    public abstract void filterUpdateFinished(ArrayList arraylist);

    public abstract void filterUpdateStarting();

    public abstract void newFilterCount(int i);
}
