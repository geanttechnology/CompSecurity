// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bro
{

    public static String a(int i)
    {
        switch (i)
        {
        default:
            return "\u65B0\u6D6A\u5FAE\u535A\u672A\u77E5\u9519\u8BEF,\u7F51\u7EDC\u5F02\u5E38\u6216\u8005\u5E94\u7528\u5185\u90E8\u9519\u8BEF";

        case 400: 
            return "\u65B0\u6D6A\u5FAE\u535A\u9A8C\u8BC1,Bad Request: \u8BF7\u6C42\u6570\u636E\u4E0D\u5408\u6CD5\uFF0C\u6216\u8005\u8D85\u8FC7\u8BF7\u6C42\u9891\u7387\u9650\u5236";

        case 401: 
            return "\u65B0\u6D6A\u5FAE\u535A\u9A8C\u8BC1,Not Authorized: \u6CA1\u6709\u8FDB\u884C\u8EAB\u4EFD\u9A8C\u8BC1. ";

        case 402: 
            return "\u65B0\u6D6A\u5FAE\u535A\u9A8C\u8BC1,Not Start mblog: \u6CA1\u6709\u5F00\u901A\u5FAE\u535A ";

        case 403: 
            return "\u65B0\u6D6A\u5FAE\u535A\u9A8C\u8BC1,Forbidden: \u6CA1\u6709\u6743\u9650\u8BBF\u95EE\u65B0\u6D6A\u5BF9\u5E94\u7684\u8D44\u6E90";

        case 404: 
            return "\u65B0\u6D6A\u5FAE\u535A\u9A8C\u8BC1,Not Found: \u8BF7\u6C42\u7684\u65B0\u6D6A\u8D44\u6E90\u4E0D\u5B58\u5728";

        case 405: 
            return "\u65B0\u6D6A\u5FAE\u535A\u9A8C\u8BC1,Internal Server Error: \u65B0\u6D6A\u670D\u52A1\u5668\u5185\u90E8\u9519\u8BEF";

        case 502: 
            return "\u65B0\u6D6A\u5FAE\u535A\u9A8C\u8BC1,Bad Gateway: \u65B0\u6D6A\u5FAE\u535A\u63A5\u53E3API\u5173\u95ED\u6216\u6B63\u5728\u5347\u7EA7";

        case 503: 
            return "\u65B0\u6D6A\u5FAE\u535A\u9A8C\u8BC1,Service Unavailable: \u670D\u52A1\u7AEF\u8D44\u6E90\u4E0D\u53EF\u7528";
        }
    }
}
