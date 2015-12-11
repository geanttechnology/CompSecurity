// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.processor.javawriter.JavaWriter;
import java.io.IOException;

// Referenced classes of package io.realm.processor:
//            RealmJsonTypeHelper

private static class <init>
    implements rter
{

    private final String castType;
    private final String jsonType;

    public void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitStatement("obj.%s((%s) reader.next%s())", new Object[] {
            s, castType, jsonType
        });
    }

    public void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
            s1
        }).emitStatement("obj.%s((%s) json.get%s(\"%s\"))", new Object[] {
            s, castType, jsonType, s1
        }).endControlFlow();
    }

    private rter(String s, String s1)
    {
        castType = s;
        jsonType = s1;
    }

    jsonType(String s, String s1, jsonType jsontype)
    {
        this(s, s1);
    }
}
