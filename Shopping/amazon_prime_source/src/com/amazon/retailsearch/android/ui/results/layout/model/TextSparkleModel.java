// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import com.amazon.searchapp.retailsearch.model.TextSparkle;

public class TextSparkleModel
{
    public static class Builder
    {

        private TextSparkle textSparkle;

        public TextSparkleModel build()
        {
            return new TextSparkleModel(textSparkle);
        }

        public Builder(TextSparkle textsparkle)
        {
            textSparkle = textsparkle;
        }
    }


    private TextSparkle textSparkle;

    public TextSparkleModel(TextSparkle textsparkle)
    {
        textSparkle = textsparkle;
    }

    public TextSparkle getTextSparkle()
    {
        return textSparkle;
    }
}
