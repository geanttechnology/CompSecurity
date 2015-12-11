// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.util.Arrays;
import java.util.logging.Logger;

public class InternalFlags
{
    public static final class IncludeStackTraceOption extends Enum
    {

        private static final IncludeStackTraceOption $VALUES[];
        public static final IncludeStackTraceOption COMPLETE;
        public static final IncludeStackTraceOption OFF;
        public static final IncludeStackTraceOption ONLY_FOR_DECLARING_SOURCE;

        public static IncludeStackTraceOption valueOf(String s)
        {
            return (IncludeStackTraceOption)Enum.valueOf(com/google/inject/internal/InternalFlags$IncludeStackTraceOption, s);
        }

        public static IncludeStackTraceOption[] values()
        {
            return (IncludeStackTraceOption[])$VALUES.clone();
        }

        static 
        {
            OFF = new IncludeStackTraceOption("OFF", 0);
            ONLY_FOR_DECLARING_SOURCE = new IncludeStackTraceOption("ONLY_FOR_DECLARING_SOURCE", 1);
            COMPLETE = new IncludeStackTraceOption("COMPLETE", 2);
            $VALUES = (new IncludeStackTraceOption[] {
                OFF, ONLY_FOR_DECLARING_SOURCE, COMPLETE
            });
        }

        private IncludeStackTraceOption(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Logger logger = Logger.getLogger(com/google/inject/internal/InternalFlags.getName());

    public InternalFlags()
    {
    }

    public static IncludeStackTraceOption getIncludeStackTraceOption()
    {
        String s;
        s = System.getProperty("guice_include_stack_traces");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        return IncludeStackTraceOption.ONLY_FOR_DECLARING_SOURCE;
        IncludeStackTraceOption includestacktraceoption = IncludeStackTraceOption.valueOf(s);
        return includestacktraceoption;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        logger.warning((new StringBuilder()).append(s).append(" is not a valid flag value for guice_include_stack_traces. ").append(" Values must be one of ").append(Arrays.asList(IncludeStackTraceOption.values())).toString());
        return IncludeStackTraceOption.ONLY_FOR_DECLARING_SOURCE;
    }

}
