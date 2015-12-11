// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import java.lang.reflect.Field;

public class imageBytes
{

    public int convertType;
    public Field field;
    public byte imageBytes[];
    public int labelResId;
    public Object report;
    public Class viewerActivity;

    boolean isExpandable()
    {
        return viewerActivity != null;
    }

    boolean isHeader()
    {
        return report == null;
    }

    boolean isImageView()
    {
        return imageBytes != null;
    }

    (int i)
    {
        this(i, null, null, null, 0);
    }

    <init>(int i, Object obj, Field field1, Class class1, int j)
    {
        labelResId = i;
        report = obj;
        field = field1;
        viewerActivity = class1;
        convertType = j;
        if (field1 != null && field1.getType().equals((new byte[0]).getClass()))
        {
            try
            {
                imageBytes = (byte[])field1.get(obj);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                imageBytes = null;
                ((IllegalArgumentException) (obj)).printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                imageBytes = null;
            }
            ((IllegalAccessException) (obj)).printStackTrace();
            return;
        } else
        {
            imageBytes = null;
            return;
        }
    }
}
