// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import java.util.ArrayList;

public class g
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public ArrayList q;
    public String r;
    public String s;
    public String t;

    public g()
    {
    }

    public g(NetworkFeedback.FeedbackConfig feedbackconfig)
    {
        if (feedbackconfig == null)
        {
            return;
        } else
        {
            a = feedbackconfig.product;
            b = feedbackconfig.version;
            g = feedbackconfig.sr;
            l = feedbackconfig.hwid;
            m = feedbackconfig.phoneid;
            n = feedbackconfig.appversion;
            r = feedbackconfig.umaid;
            return;
        }
    }
}
