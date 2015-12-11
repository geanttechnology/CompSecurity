// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.processor.javawriter.JavaWriter;
import java.io.IOException;

// Referenced classes of package io.realm.processor:
//            RealmJsonTypeHelper

static final class onToRealmTypeConverter
    implements onToRealmTypeConverter
{

    public void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginControlFlow("if (reader.peek() == JsonToken.NUMBER)", new Object[0]).emitStatement("long timestamp = reader.nextLong()", new Object[] {
            s1
        }).beginControlFlow("if (timestamp > -1)", new Object[0]).emitStatement("obj.%s(new Date(timestamp))", new Object[] {
            s
        }).endControlFlow().nextControlFlow("else", new Object[0]).emitStatement("obj.%s(JsonUtils.stringToDate(reader.nextString()))", new Object[] {
            s
        }).endControlFlow();
    }

    public void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
            s1
        }).emitStatement("Object timestamp = json.get(\"%s\")", new Object[] {
            s1
        }).beginControlFlow("if (timestamp instanceof String)", new Object[0]).emitStatement("obj.%s(JsonUtils.stringToDate((String) timestamp))", new Object[] {
            s
        }).nextControlFlow("else", new Object[0]).emitStatement("obj.%s(new Date(json.getLong(\"%s\")))", new Object[] {
            s, s1
        }).endControlFlow().endControlFlow();
    }

    onToRealmTypeConverter()
    {
    }
}
