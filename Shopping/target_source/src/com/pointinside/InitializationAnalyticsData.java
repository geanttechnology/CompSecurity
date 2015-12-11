// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside;


class InitializationAnalyticsData
{
    static class Builder
    {

        private String appName;
        private String appVersion;
        private String devModel;
        private String libName;
        private String libVersion;
        private String osVersion;

        public Builder appName(String s)
        {
            appName = s;
            return this;
        }

        public Builder appVersion(String s)
        {
            appVersion = s;
            return this;
        }

        public InitializationAnalyticsData build()
        {
            return new InitializationAnalyticsData(this);
        }

        public Builder devModel(String s)
        {
            devModel = s;
            return this;
        }

        public Builder libName(String s)
        {
            libName = s;
            return this;
        }

        public Builder libVersion(String s)
        {
            libVersion = s;
            return this;
        }

        public Builder osVersion(String s)
        {
            osVersion = s;
            return this;
        }







        public Builder()
        {
        }
    }


    public final String appName;
    public final String appVersion;
    public final String devModel;
    public final String libName;
    public final String libVersion;
    public final String osName;
    public final String osVersion;

    private InitializationAnalyticsData(Builder builder)
    {
        osName = "Android";
        libName = builder.libName;
        libVersion = builder.libVersion;
        devModel = builder.devModel;
        osVersion = builder.osVersion;
        appName = builder.appName;
        appVersion = builder.appVersion;
    }

}
