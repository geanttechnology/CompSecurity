// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Debug

public static interface Y
    extends MessageLiteOrBuilder
{

    public abstract Y getResults(int i);

    public abstract int getResultsCount();

    public abstract List getResultsList();

    public abstract Y getRulesEvaluation();

    public abstract boolean hasRulesEvaluation();
}
