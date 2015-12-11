// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.annotations.internal.RealmModule;
import io.realm.processor.javawriter.JavaWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;

public class DefaultModuleGenerator
{

    private final ProcessingEnvironment env;

    public DefaultModuleGenerator(ProcessingEnvironment processingenvironment)
    {
        env = processingenvironment;
    }

    public void generate()
        throws IOException
    {
        String s = String.format("%s.%s", new Object[] {
            "io.realm", "DefaultRealmModule"
        });
        JavaWriter javawriter = new JavaWriter(new BufferedWriter(env.getFiler().createSourceFile(s, new Element[0]).openWriter()));
        javawriter.setIndent("    ");
        javawriter.emitPackage("io.realm");
        javawriter.emitEmptyLine();
        HashMap hashmap = new HashMap();
        hashmap.put("allClasses", Boolean.TRUE);
        javawriter.emitAnnotation(io/realm/annotations/internal/RealmModule, hashmap);
        javawriter.beginType(s, "class", Collections.emptySet(), null, new String[0]);
        javawriter.emitEmptyLine();
        javawriter.endType();
        javawriter.close();
    }
}
