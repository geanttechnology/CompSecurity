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
        javawriter.emitStatement("obj.%s(JsonUtils.stringToBytes(reader.nextString()))", new Object[] {
            s
        });
    }

    public void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
            s1
        }).emitStatement("obj.%s(JsonUtils.stringToBytes(json.getString(\"%s\")))", new Object[] {
            s, s1
        }).endControlFlow();
    }

    onToRealmTypeConverter()
    {
    }
}
