// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Debug

public static interface I
    extends MessageLiteOrBuilder
{

    public abstract I getAddMacros(int i);

    public abstract int getAddMacrosCount();

    public abstract List getAddMacrosList();

    public abstract I getAddTags(int i);

    public abstract int getAddTagsCount();

    public abstract List getAddTagsList();

    public abstract I getNegativePredicates(int i);

    public abstract int getNegativePredicatesCount();

    public abstract List getNegativePredicatesList();

    public abstract I getPositivePredicates(int i);

    public abstract int getPositivePredicatesCount();

    public abstract List getPositivePredicatesList();

    public abstract I getRemoveMacros(int i);

    public abstract int getRemoveMacrosCount();

    public abstract List getRemoveMacrosList();

    public abstract I getRemoveTags(int i);

    public abstract int getRemoveTagsCount();

    public abstract List getRemoveTagsList();

    public abstract com.google.analytics.midtier.proto.containertag.google.analytics.cony getResult();

    public abstract boolean hasResult();
}
