// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.javawriter;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.Modifier;

public class JavaWriter
    implements Closeable
{
    private static final class Scope extends Enum
    {

        private static final Scope $VALUES[];
        public static final Scope ABSTRACT_METHOD;
        public static final Scope ANNOTATION_ARRAY_VALUE;
        public static final Scope ANNOTATION_ATTRIBUTE;
        public static final Scope CONSTRUCTOR;
        public static final Scope CONTROL_FLOW;
        public static final Scope INITIALIZER;
        public static final Scope NON_ABSTRACT_METHOD;
        public static final Scope TYPE_DECLARATION;

        public static Scope valueOf(String s)
        {
            return (Scope)Enum.valueOf(com/squareup/javawriter/JavaWriter$Scope, s);
        }

        public static Scope[] values()
        {
            return (Scope[])$VALUES.clone();
        }

        static 
        {
            TYPE_DECLARATION = new Scope("TYPE_DECLARATION", 0);
            ABSTRACT_METHOD = new Scope("ABSTRACT_METHOD", 1);
            NON_ABSTRACT_METHOD = new Scope("NON_ABSTRACT_METHOD", 2);
            CONSTRUCTOR = new Scope("CONSTRUCTOR", 3);
            CONTROL_FLOW = new Scope("CONTROL_FLOW", 4);
            ANNOTATION_ATTRIBUTE = new Scope("ANNOTATION_ATTRIBUTE", 5);
            ANNOTATION_ARRAY_VALUE = new Scope("ANNOTATION_ARRAY_VALUE", 6);
            INITIALIZER = new Scope("INITIALIZER", 7);
            $VALUES = (new Scope[] {
                TYPE_DECLARATION, ABSTRACT_METHOD, NON_ABSTRACT_METHOD, CONSTRUCTOR, CONTROL_FLOW, ANNOTATION_ATTRIBUTE, ANNOTATION_ARRAY_VALUE, INITIALIZER
            });
        }

        private Scope(String s, int i)
        {
            super(s, i);
        }
    }


    private static final EnumSet METHOD_SCOPES;
    private static final Pattern TYPE_PATTERN = Pattern.compile("(?:[\\w$]+\\.)*([\\w\\.*$]+)");
    private final Map importedTypes = new LinkedHashMap();
    private String indent;
    private boolean isCompressingTypes;
    private final Writer out;
    private String packagePrefix;
    private final Deque scopes = new ArrayDeque();
    private final Deque types = new ArrayDeque();

    public JavaWriter(Writer writer)
    {
        isCompressingTypes = true;
        indent = "  ";
        out = writer;
    }

    private void checkInMethod()
    {
        if (!METHOD_SCOPES.contains(scopes.peekFirst()))
        {
            throw new IllegalArgumentException();
        } else
        {
            return;
        }
    }

    private boolean containsArray(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (collection.next() instanceof Object[])
            {
                return true;
            }
        }

        return false;
    }

    private JavaWriter emitAnnotationValue(Object obj)
        throws IOException
    {
        if (obj instanceof Object[])
        {
            out.write("{");
            boolean flag = true;
            scopes.push(Scope.ANNOTATION_ARRAY_VALUE);
            obj = ((Object) ((Object[])(Object[])obj));
            int j = obj.length;
            int i = 0;
            while (i < j) 
            {
                Object obj1 = obj[i];
                if (flag)
                {
                    flag = false;
                    out.write("\n");
                } else
                {
                    out.write(",\n");
                }
                indent();
                out.write(obj1.toString());
                i++;
            }
            popScope(Scope.ANNOTATION_ARRAY_VALUE);
            out.write("\n");
            indent();
            out.write("}");
            return this;
        } else
        {
            out.write(obj.toString());
            return this;
        }
    }

    private JavaWriter emitCompressedType(String s)
        throws IOException
    {
        if (isCompressingTypes)
        {
            out.write(compressType(s));
            return this;
        } else
        {
            out.write(s);
            return this;
        }
    }

    private void emitModifiers(Set set)
        throws IOException
    {
        Object obj = set;
        if (!(set instanceof EnumSet))
        {
            obj = EnumSet.copyOf(set);
        }
        for (set = ((Set) (obj)).iterator(); set.hasNext(); out.append(((Modifier) (obj)).toString()).append(' '))
        {
            obj = (Modifier)set.next();
        }

    }

    private void hangingIndent()
        throws IOException
    {
        int i = 0;
        for (int j = scopes.size(); i < j + 2; i++)
        {
            out.write(indent);
        }

    }

    private void indent()
        throws IOException
    {
        int i = 0;
        for (int j = scopes.size(); i < j; i++)
        {
            out.write(indent);
        }

    }

    private boolean isAmbiguous(String s)
    {
        return importedTypes.values().contains(s);
    }

    private static boolean isClassInPackage(String s, String s1)
    {
        while (s.startsWith(s1) && (s.indexOf('.', s1.length()) == -1 || Character.isUpperCase(s.charAt(s1.length())))) 
        {
            return true;
        }
        return false;
    }

    private void popScope(Scope scope)
    {
        if (scopes.pop() != scope)
        {
            throw new IllegalStateException();
        } else
        {
            return;
        }
    }

    public static String stringLiteral(String s)
    {
        StringBuilder stringbuilder;
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
label5:
                            {
label6:
                                {
                                    stringbuilder = new StringBuilder();
                                    stringbuilder.append('"');
                                    int i = 0;
label7:
                                    do
                                    {
                                        {
                                            if (i >= s.length())
                                            {
                                                break label0;
                                            }
                                            char c = s.charAt(i);
                                            switch (c)
                                            {
                                            default:
                                                if (Character.isISOControl(c))
                                                {
                                                    stringbuilder.append(String.format("\\u%04x", new Object[] {
                                                        Integer.valueOf(c)
                                                    }));
                                                } else
                                                {
                                                    stringbuilder.append(c);
                                                }
                                                break;

                                            case 8: // '\b'
                                                break label5;

                                            case 9: // '\t'
                                                break label4;

                                            case 10: // '\n'
                                                break label3;

                                            case 12: // '\f'
                                                break label2;

                                            case 13: // '\r'
                                                break label1;

                                            case 34: // '"'
                                                break label7;

                                            case 92: // '\\'
                                                break label6;
                                            }
                                        }
                                        i++;
                                    } while (true);
                                    stringbuilder.append("\\\"");
                                    break MISSING_BLOCK_LABEL_128;
                                }
                                stringbuilder.append("\\\\");
                                break MISSING_BLOCK_LABEL_128;
                            }
                            stringbuilder.append("\\b");
                            break MISSING_BLOCK_LABEL_128;
                        }
                        stringbuilder.append("\\t");
                        break MISSING_BLOCK_LABEL_128;
                    }
                    stringbuilder.append("\\n");
                    break MISSING_BLOCK_LABEL_128;
                }
                stringbuilder.append("\\f");
                break MISSING_BLOCK_LABEL_128;
            }
            stringbuilder.append("\\r");
            break MISSING_BLOCK_LABEL_128;
        }
        stringbuilder.append('"');
        return stringbuilder.toString();
    }

    public static transient String type(Class class1, String as[])
    {
        if (as.length == 0)
        {
            return class1.getCanonicalName();
        }
        if (class1.getTypeParameters().length != as.length)
        {
            throw new IllegalArgumentException();
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(class1.getCanonicalName());
        stringbuilder.append("<");
        stringbuilder.append(as[0]);
        for (int i = 1; i < as.length; i++)
        {
            stringbuilder.append(", ");
            stringbuilder.append(as[i]);
        }

        stringbuilder.append(">");
        return stringbuilder.toString();
    }

    public JavaWriter beginMethod(String s, String s1, Set set, List list, List list1)
        throws IOException
    {
        indent();
        emitModifiers(set);
        if (s != null)
        {
            emitCompressedType(s);
            out.write(" ");
            out.write(s1);
        } else
        {
            emitCompressedType(s1);
        }
        out.write("(");
        if (list != null)
        {
            int k;
            for (int i = 0; i < list.size(); emitCompressedType((String)list.get(k)))
            {
                if (i != 0)
                {
                    out.write(", ");
                }
                k = i + 1;
                emitCompressedType((String)list.get(i));
                out.write(" ");
                i = k + 1;
            }

        }
        out.write(")");
        if (list1 != null && list1.size() > 0)
        {
            out.write("\n");
            indent();
            out.write("    throws ");
            for (int j = 0; j < list1.size(); j++)
            {
                if (j != 0)
                {
                    out.write(", ");
                }
                emitCompressedType((String)list1.get(j));
            }

        }
        if (set.contains(Modifier.ABSTRACT))
        {
            out.write(";\n");
            scopes.push(Scope.ABSTRACT_METHOD);
            return this;
        }
        out.write(" {\n");
        s1 = scopes;
        if (s == null)
        {
            s = Scope.CONSTRUCTOR;
        } else
        {
            s = Scope.NON_ABSTRACT_METHOD;
        }
        s1.push(s);
        return this;
    }

    public transient JavaWriter beginMethod(String s, String s1, Set set, String as[])
        throws IOException
    {
        return beginMethod(s, s1, set, Arrays.asList(as), null);
    }

    public transient JavaWriter beginType(String s, String s1, Set set, String s2, String as[])
        throws IOException
    {
        indent();
        emitModifiers(set);
        out.write(s1);
        out.write(" ");
        emitCompressedType(s);
        if (s2 != null)
        {
            out.write(" extends ");
            emitCompressedType(s2);
        }
        if (as.length > 0)
        {
            out.write("\n");
            indent();
            out.write("    implements ");
            for (int i = 0; i < as.length; i++)
            {
                if (i != 0)
                {
                    out.write(", ");
                }
                emitCompressedType(as[i]);
            }

        }
        out.write(" {\n");
        scopes.push(Scope.TYPE_DECLARATION);
        types.push(s);
        return this;
    }

    public void close()
        throws IOException
    {
        out.close();
    }

    public String compressType(String s)
    {
        StringBuilder stringbuilder;
        Matcher matcher;
        int i;
        stringbuilder = new StringBuilder();
        if (packagePrefix == null)
        {
            throw new IllegalStateException();
        }
        matcher = TYPE_PATTERN.matcher(s);
        i = 0;
_L2:
        String s1;
        boolean flag = matcher.find(i);
        int j;
        if (flag)
        {
            j = matcher.start();
        } else
        {
            j = s.length();
        }
        stringbuilder.append(s, i, j);
        if (!flag)
        {
            return stringbuilder.toString();
        }
        s1 = matcher.group(0);
        String s2 = (String)importedTypes.get(s1);
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(s2);
_L3:
        i = matcher.end();
        if (true) goto _L2; else goto _L1
_L1:
        if (isClassInPackage(s1, packagePrefix))
        {
            String s3 = s1.substring(packagePrefix.length());
            if (isAmbiguous(s3))
            {
                stringbuilder.append(s1);
            } else
            {
                stringbuilder.append(s3);
            }
        } else
        if (isClassInPackage(s1, "java.lang."))
        {
            stringbuilder.append(s1.substring("java.lang.".length()));
        } else
        {
            stringbuilder.append(s1);
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public JavaWriter emitAnnotation(Class class1)
        throws IOException
    {
        return emitAnnotation(type(class1, new String[0]), Collections.emptyMap());
    }

    public JavaWriter emitAnnotation(Class class1, Object obj)
        throws IOException
    {
        return emitAnnotation(type(class1, new String[0]), obj);
    }

    public JavaWriter emitAnnotation(String s, Object obj)
        throws IOException
    {
        indent();
        out.write("@");
        emitCompressedType(s);
        out.write("(");
        emitAnnotationValue(obj);
        out.write(")");
        out.write("\n");
        return this;
    }

    public JavaWriter emitAnnotation(String s, Map map)
        throws IOException
    {
        indent();
        out.write("@");
        emitCompressedType(s);
        map.size();
        JVM INSTR tableswitch 0 1: default 48
    //                   0 292
    //                   1 200;
           goto _L1 _L2 _L3
_L2:
        break MISSING_BLOCK_LABEL_292;
_L1:
        boolean flag;
        if (map.size() > 3 || containsArray(map.values()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        out.write("(");
        scopes.push(Scope.ANNOTATION_ATTRIBUTE);
        if (flag)
        {
            s = "\n";
        } else
        {
            s = "";
        }
        map = map.entrySet().iterator();
        while (map.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            out.write(s);
            if (flag)
            {
                s = ",\n";
            } else
            {
                s = ", ";
            }
            if (flag)
            {
                indent();
            }
            out.write((String)entry.getKey());
            out.write(" = ");
            emitAnnotationValue(entry.getValue());
        }
        break; /* Loop/switch isn't completed */
_L3:
        s = (java.util.Map.Entry)map.entrySet().iterator().next();
        out.write("(");
        if (!"value".equals(s.getKey()))
        {
            out.write((String)s.getKey());
            out.write(" = ");
        }
        emitAnnotationValue(s.getValue());
        out.write(")");
_L5:
        out.write("\n");
        return this;
        popScope(Scope.ANNOTATION_ATTRIBUTE);
        if (flag)
        {
            out.write("\n");
            indent();
        }
        out.write(")");
        if (true) goto _L5; else goto _L4
_L4:
    }

    public JavaWriter emitEmptyLine()
        throws IOException
    {
        out.write("\n");
        return this;
    }

    public JavaWriter emitField(String s, String s1, Set set)
        throws IOException
    {
        return emitField(s, s1, set, null);
    }

    public JavaWriter emitField(String s, String s1, Set set, String s2)
        throws IOException
    {
        indent();
        emitModifiers(set);
        emitCompressedType(s);
        out.write(" ");
        out.write(s1);
        if (s2 != null)
        {
            out.write(" = ");
            s = s2.split("\n", -1);
            out.write(s[0]);
            for (int i = 1; i < s.length; i++)
            {
                out.write("\n");
                hangingIndent();
                out.write(s[i]);
            }

        }
        out.write(";\n");
        return this;
    }

    public JavaWriter emitImports(Collection collection)
        throws IOException
    {
        for (collection = (new TreeSet(collection)).iterator(); collection.hasNext(); out.write(";\n"))
        {
            String s = (String)collection.next();
            Matcher matcher = TYPE_PATTERN.matcher(s);
            if (!matcher.matches())
            {
                throw new IllegalArgumentException(s);
            }
            if (importedTypes.put(s, matcher.group(1)) != null)
            {
                throw new IllegalArgumentException(s);
            }
            out.write("import ");
            out.write(s);
        }

        return this;
    }

    public transient JavaWriter emitJavadoc(String s, Object aobj[])
        throws IOException
    {
        s = String.format(s, aobj);
        indent();
        out.write("/**\n");
        s = s.split("\n");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            aobj = s[i];
            indent();
            out.write(" *");
            if (!((String) (aobj)).isEmpty())
            {
                out.write(" ");
                out.write(((String) (aobj)));
            }
            out.write("\n");
        }

        indent();
        out.write(" */\n");
        return this;
    }

    public JavaWriter emitPackage(String s)
        throws IOException
    {
        if (packagePrefix != null)
        {
            throw new IllegalStateException();
        }
        if (s.isEmpty())
        {
            packagePrefix = "";
            return this;
        } else
        {
            out.write("package ");
            out.write(s);
            out.write(";\n\n");
            packagePrefix = (new StringBuilder()).append(s).append(".").toString();
            return this;
        }
    }

    public transient JavaWriter emitSingleLineComment(String s, Object aobj[])
        throws IOException
    {
        indent();
        out.write("// ");
        out.write(String.format(s, aobj));
        out.write("\n");
        return this;
    }

    public transient JavaWriter emitStatement(String s, Object aobj[])
        throws IOException
    {
        checkInMethod();
        s = String.format(s, aobj).split("\n", -1);
        indent();
        out.write(s[0]);
        for (int i = 1; i < s.length; i++)
        {
            out.write("\n");
            hangingIndent();
            out.write(s[i]);
        }

        out.write(";\n");
        return this;
    }

    public JavaWriter endMethod()
        throws IOException
    {
        Scope scope = (Scope)scopes.pop();
        if (scope == Scope.NON_ABSTRACT_METHOD || scope == Scope.CONSTRUCTOR)
        {
            indent();
            out.write("}\n");
        } else
        if (scope != Scope.ABSTRACT_METHOD)
        {
            throw new IllegalStateException();
        }
        return this;
    }

    public JavaWriter endType()
        throws IOException
    {
        popScope(Scope.TYPE_DECLARATION);
        types.pop();
        indent();
        out.write("}\n");
        return this;
    }

    static 
    {
        METHOD_SCOPES = EnumSet.of(Scope.NON_ABSTRACT_METHOD, Scope.CONSTRUCTOR, Scope.CONTROL_FLOW, Scope.INITIALIZER);
    }
}
