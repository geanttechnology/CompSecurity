// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import java.io.PrintWriter;
import java.io.StringWriter;

// Referenced classes of package com.mopub.common.event:
//            BaseEvent

public class ErrorEvent extends BaseEvent
{
    public static class Builder extends BaseEvent.Builder
    {

        private String mErrorClassName;
        private String mErrorExceptionClassName;
        private String mErrorFileName;
        private Integer mErrorLineNumber;
        private String mErrorMessage;
        private String mErrorMethodName;
        private String mErrorStackTrace;

        public volatile BaseEvent build()
        {
            return build();
        }

        public ErrorEvent build()
        {
            return new ErrorEvent(this);
        }

        public Builder withErrorClassName(String s)
        {
            mErrorClassName = s;
            return this;
        }

        public Builder withErrorExceptionClassName(String s)
        {
            mErrorExceptionClassName = s;
            return this;
        }

        public Builder withErrorFileName(String s)
        {
            mErrorFileName = s;
            return this;
        }

        public Builder withErrorLineNumber(Integer integer)
        {
            mErrorLineNumber = integer;
            return this;
        }

        public Builder withErrorMessage(String s)
        {
            mErrorMessage = s;
            return this;
        }

        public Builder withErrorMethodName(String s)
        {
            mErrorMethodName = s;
            return this;
        }

        public Builder withErrorStackTrace(String s)
        {
            mErrorStackTrace = s;
            return this;
        }

        public Builder withException(Exception exception)
        {
            mErrorExceptionClassName = exception.getClass().getName();
            mErrorMessage = exception.getMessage();
            StringWriter stringwriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringwriter));
            mErrorStackTrace = stringwriter.toString();
            if (exception.getStackTrace().length > 0)
            {
                mErrorFileName = exception.getStackTrace()[0].getFileName();
                mErrorClassName = exception.getStackTrace()[0].getClassName();
                mErrorMethodName = exception.getStackTrace()[0].getMethodName();
                mErrorLineNumber = Integer.valueOf(exception.getStackTrace()[0].getLineNumber());
            }
            return this;
        }








        public Builder(BaseEvent.Name name, BaseEvent.Category category, double d)
        {
            super(BaseEvent.ScribeCategory.EXCHANGE_CLIENT_ERROR, name, category, d);
        }
    }


    private final String mErrorClassName;
    private final String mErrorExceptionClassName;
    private final String mErrorFileName;
    private final Integer mErrorLineNumber;
    private final String mErrorMessage;
    private final String mErrorMethodName;
    private final String mErrorStackTrace;

    private ErrorEvent(Builder builder)
    {
        super(builder);
        mErrorExceptionClassName = builder.mErrorExceptionClassName;
        mErrorMessage = builder.mErrorMessage;
        mErrorStackTrace = builder.mErrorStackTrace;
        mErrorFileName = builder.mErrorFileName;
        mErrorClassName = builder.mErrorClassName;
        mErrorMethodName = builder.mErrorMethodName;
        mErrorLineNumber = builder.mErrorLineNumber;
    }


    public String getErrorClassName()
    {
        return mErrorClassName;
    }

    public String getErrorExceptionClassName()
    {
        return mErrorExceptionClassName;
    }

    public String getErrorFileName()
    {
        return mErrorFileName;
    }

    public Integer getErrorLineNumber()
    {
        return mErrorLineNumber;
    }

    public String getErrorMessage()
    {
        return mErrorMessage;
    }

    public String getErrorMethodName()
    {
        return mErrorMethodName;
    }

    public String getErrorStackTrace()
    {
        return mErrorStackTrace;
    }

    public String toString()
    {
        String s = super.toString();
        return (new StringBuilder()).append(s).append("ErrorEvent\n").append("ErrorExceptionClassName: ").append(getErrorExceptionClassName()).append("\n").append("ErrorMessage: ").append(getErrorMessage()).append("\n").append("ErrorStackTrace: ").append(getErrorStackTrace()).append("\n").append("ErrorFileName: ").append(getErrorFileName()).append("\n").append("ErrorClassName: ").append(getErrorClassName()).append("\n").append("ErrorMethodName: ").append(getErrorMethodName()).append("\n").append("ErrorLineNumber: ").append(getErrorLineNumber()).append("\n").toString();
    }
}
