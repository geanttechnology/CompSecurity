// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;

public final class il
{

    final ComponentName a;

    il(ComponentName componentname)
    {
        if (componentname == null)
        {
            throw new IllegalArgumentException("componentName must not be null");
        } else
        {
            a = componentname;
            return;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("ProviderMetadata{ componentName=")).append(a.flattenToShortString()).append(" }").toString();
    }
}
