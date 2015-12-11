// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;


public class DecodeMonitor
{

    public static final DecodeMonitor SILENT = new DecodeMonitor();
    public static final DecodeMonitor STRICT = new DecodeMonitor() {

        public boolean isListening()
        {
            return true;
        }

        public boolean warn(String s, String s1)
        {
            return true;
        }

    };

    public DecodeMonitor()
    {
    }

    public boolean isListening()
    {
        return false;
    }

    public boolean warn(String s, String s1)
    {
        return false;
    }

}
