// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.validate;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.system.FileManager;
import com.amazon.insights.core.system.System;
import com.amazon.insights.impl.InitializationException;
import java.io.File;
import java.io.IOException;

public class FileManagerValidator
{

    public FileManagerValidator()
    {
    }

    public void validate(InsightsContext insightscontext)
    {
        insightscontext = insightscontext.getSystem().getFileManager();
        File file;
        try
        {
            file = insightscontext.createFile(new File(insightscontext.getDirectory(""), "validatorFile"));
        }
        // Misplaced declaration of an exception variable
        catch (InsightsContext insightscontext)
        {
            throw new InitializationException("Could not create file on disk", insightscontext);
        }
        if (file == null)
        {
            throw new InitializationException("File was not created");
        }
        if (!insightscontext.deleteFile(file))
        {
            throw new InitializationException("Could not delete file from disk");
        } else
        {
            return;
        }
    }
}
