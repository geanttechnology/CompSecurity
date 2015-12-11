// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model.survey;


public interface Question
{

    public static final int QUESTION_TYPE_MULTICHOICE = 2;
    public static final int QUESTION_TYPE_MULTISELECT = 3;
    public static final int QUESTION_TYPE_SINGLELINE = 1;

    public abstract String getId();

    public abstract String getInstructions();

    public abstract int getMaxSelections();

    public abstract int getMinSelections();

    public abstract int getType();

    public abstract String getValue();

    public abstract boolean isRequired();
}
