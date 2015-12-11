// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.Uri;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand

class ParseRESTObjectCommand extends ParseRESTCommand
{

    public ParseRESTObjectCommand(String s, ParseRequest.Method method, JSONObject jsonobject, String s1)
    {
        super(s, method, jsonobject, s1);
    }

    private static ParseRESTObjectCommand createObjectCommand(String s, JSONObject jsonobject, String s1)
    {
        return new ParseRESTObjectCommand(String.format("classes/%s", new Object[] {
            Uri.encode(s)
        }), ParseRequest.Method.POST, jsonobject, s1);
    }

    public static ParseRESTObjectCommand deleteObjectCommand(ParseObject.State state, String s)
    {
        String s1 = String.format("classes/%s", new Object[] {
            Uri.encode(state.className())
        });
        String s2 = state.objectId();
        state = s1;
        if (s2 != null)
        {
            state = (new StringBuilder()).append(s1).append(String.format("/%s", new Object[] {
                Uri.encode(s2)
            })).toString();
        }
        return new ParseRESTObjectCommand(state, ParseRequest.Method.DELETE, null, s);
    }

    public static ParseRESTObjectCommand getObjectCommand(String s, String s1, String s2)
    {
        return new ParseRESTObjectCommand(String.format("classes/%s/%s", new Object[] {
            Uri.encode(s1), Uri.encode(s)
        }), ParseRequest.Method.GET, null, s2);
    }

    public static ParseRESTObjectCommand saveObjectCommand(ParseObject.State state, JSONObject jsonobject, String s)
    {
        if (state.objectId() == null)
        {
            return createObjectCommand(state.className(), jsonobject, s);
        } else
        {
            return updateObjectCommand(state.objectId(), state.className(), jsonobject, s);
        }
    }

    private static ParseRESTObjectCommand updateObjectCommand(String s, String s1, JSONObject jsonobject, String s2)
    {
        return new ParseRESTObjectCommand(String.format("classes/%s/%s", new Object[] {
            Uri.encode(s1), Uri.encode(s)
        }), ParseRequest.Method.PUT, jsonobject, s2);
    }
}
