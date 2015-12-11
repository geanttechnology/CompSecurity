// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.googlecode.javacpp:
//            Loader

public class Parser
{
    static class Declarator
    {

        String annotations;
        boolean constPointer;
        boolean constValue;
        String convention;
        String cppType;
        String definitions;
        int indices;
        int infoNumber;
        String javaType;
        String objectName;
        String parameters;

        Declarator()
        {
            infoNumber = 0;
            indices = 0;
            constValue = false;
            constPointer = false;
            annotations = "";
            cppType = "";
            javaType = "";
            objectName = "";
            convention = "";
            definitions = "";
            parameters = "";
        }
    }

    public static class Exception extends java.lang.Exception
    {

        public Exception(String s)
        {
            super(s);
        }

        public Exception(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }

    public static class Info
        implements Cloneable
    {

        String annotations[];
        boolean cast;
        boolean complex;
        String cppNames[];
        boolean define;
        boolean forwardDeclared;
        String genericTypes[];
        String javaNames[];
        String pointerTypes[];
        String primitiveTypes[];
        String textAfter;
        String textBefore;

        public transient Info annotations(String as[])
        {
            annotations = as;
            return this;
        }

        public Info cast(boolean flag)
        {
            cast = flag;
            return this;
        }

        public Info clone()
        {
            Info info = new Info();
            String as[];
            if (cppNames != null)
            {
                as = (String[])cppNames.clone();
            } else
            {
                as = null;
            }
            info.cppNames = as;
            if (javaNames != null)
            {
                as = (String[])javaNames.clone();
            } else
            {
                as = null;
            }
            info.javaNames = as;
            if (annotations != null)
            {
                as = (String[])annotations.clone();
            } else
            {
                as = null;
            }
            info.annotations = as;
            if (primitiveTypes != null)
            {
                as = (String[])primitiveTypes.clone();
            } else
            {
                as = null;
            }
            info.primitiveTypes = as;
            if (pointerTypes != null)
            {
                as = (String[])pointerTypes.clone();
            } else
            {
                as = null;
            }
            info.pointerTypes = as;
            if (genericTypes != null)
            {
                as = (String[])genericTypes.clone();
            } else
            {
                as = null;
            }
            info.genericTypes = as;
            info.cast = cast;
            info.define = define;
            info.forwardDeclared = forwardDeclared;
            info.textBefore = textBefore;
            info.textAfter = textAfter;
            return info;
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public Info complex(boolean flag)
        {
            complex = flag;
            return this;
        }

        public transient Info cppNames(String as[])
        {
            cppNames = as;
            return this;
        }

        public Info define(boolean flag)
        {
            define = flag;
            return this;
        }

        public Info forwardDeclared(boolean flag)
        {
            forwardDeclared = flag;
            return this;
        }

        public transient Info genericTypes(String as[])
        {
            genericTypes = as;
            return this;
        }

        public transient Info javaNames(String as[])
        {
            javaNames = as;
            return this;
        }

        public transient Info pointerTypes(String as[])
        {
            pointerTypes = as;
            return this;
        }

        public transient Info primitiveTypes(String as[])
        {
            primitiveTypes = as;
            return this;
        }

        public Info textAfter(String s)
        {
            textAfter = s;
            return this;
        }

        public Info textBefore(String s)
        {
            textBefore = s;
            return this;
        }

        public Info()
        {
            cppNames = null;
            javaNames = null;
            annotations = null;
            primitiveTypes = null;
            pointerTypes = null;
            genericTypes = null;
            cast = false;
            define = false;
            complex = false;
            forwardDeclared = false;
            textBefore = null;
            textAfter = null;
        }

        public transient Info(String as[])
        {
            cppNames = null;
            javaNames = null;
            annotations = null;
            primitiveTypes = null;
            pointerTypes = null;
            genericTypes = null;
            cast = false;
            define = false;
            complex = false;
            forwardDeclared = false;
            textBefore = null;
            textAfter = null;
            cppNames = as;
        }
    }

    public static class InfoMap extends HashMap
    {

        static final InfoMap defaults = (new InfoMap(null)).put((new Info(new String[] {
            "void"
        })).primitiveTypes(new String[] {
            "void"
        }).pointerTypes(new String[] {
            "Pointer"
        })).put((new Info(new String[] {
            "FILE"
        })).pointerTypes(new String[] {
            "Pointer"
        }).cast(true)).put((new Info(new String[] {
            "va_list"
        })).pointerTypes(new String[] {
            "Pointer"
        }).cast(true)).put((new Info(new String[] {
            "int8_t", "jbyte", "signed char"
        })).primitiveTypes(new String[] {
            "byte"
        }).pointerTypes(new String[] {
            "BytePointer", "ByteBuffer", "byte[]"
        })).put((new Info(new String[] {
            "uint8_t", "char", "unsigned char"
        })).primitiveTypes(new String[] {
            "byte"
        }).pointerTypes(new String[] {
            "BytePointer", "ByteBuffer", "byte[]"
        }).cast(true)).put((new Info(new String[] {
            "int16_t", "jshort", "short", "signed short", "short int", "signed short int"
        })).primitiveTypes(new String[] {
            "short"
        }).pointerTypes(new String[] {
            "ShortPointer", "ShortBuffer", "short[]"
        })).put((new Info(new String[] {
            "uint16_t", "unsigned short", "unsigned short int"
        })).primitiveTypes(new String[] {
            "short"
        }).pointerTypes(new String[] {
            "ShortPointer", "ShortBuffer", "short[]"
        }).cast(true)).put((new Info(new String[] {
            "int32_t", "jint", "int", "signed int", "signed"
        })).primitiveTypes(new String[] {
            "int"
        }).pointerTypes(new String[] {
            "IntPointer", "IntBuffer", "int[]"
        })).put((new Info(new String[] {
            "uint32_t", "unsigned int", "unsigned"
        })).primitiveTypes(new String[] {
            "int"
        }).pointerTypes(new String[] {
            "IntPointer", "IntBuffer", "int[]"
        }).cast(true)).put((new Info(new String[] {
            "int64_t", "__int64", "jlong", "long long", "signed long long", "long long int", "signed long long int"
        })).primitiveTypes(new String[] {
            "long"
        }).pointerTypes(new String[] {
            "LongPointer", "LongBuffer", "long[]"
        })).put((new Info(new String[] {
            "uint64_t", "__uint64", "unsigned long long", "unsigned long long int"
        })).primitiveTypes(new String[] {
            "long"
        }).pointerTypes(new String[] {
            "LongPointer", "LongBuffer", "long[]"
        }).cast(true)).put((new Info(new String[] {
            "long", "signed long", "long int", "signed long int"
        })).primitiveTypes(new String[] {
            "long"
        }).pointerTypes(new String[] {
            "CLongPointer"
        })).put((new Info(new String[] {
            "unsigned long", "unsigned long int"
        })).primitiveTypes(new String[] {
            "long"
        }).pointerTypes(new String[] {
            "CLongPointer"
        }).cast(true)).put((new Info(new String[] {
            "size_t"
        })).primitiveTypes(new String[] {
            "long"
        }).pointerTypes(new String[] {
            "SizeTPointer"
        })).put((new Info(new String[] {
            "float", "jfloat"
        })).primitiveTypes(new String[] {
            "float"
        }).pointerTypes(new String[] {
            "FloatPointer", "FloatBuffer", "float[]"
        })).put((new Info(new String[] {
            "double", "jdouble"
        })).primitiveTypes(new String[] {
            "double"
        }).pointerTypes(new String[] {
            "DoublePointer", "DoubleBuffer", "double[]"
        })).put((new Info(new String[] {
            "bool", "jboolean"
        })).primitiveTypes(new String[] {
            "boolean"
        }).pointerTypes(new String[] {
            "BoolPointer"
        }).cast(true)).put((new Info(new String[] {
            "const char"
        })).primitiveTypes(new String[] {
            "byte"
        }).pointerTypes(new String[] {
            "@Cast(\"const char*\") BytePointer", "String"
        })).put((new Info(new String[] {
            "position"
        })).javaNames(new String[] {
            "_position"
        })).put((new Info(new String[] {
            "limit"
        })).javaNames(new String[] {
            "_limit"
        })).put((new Info(new String[] {
            "capacity"
        })).javaNames(new String[] {
            "_capacity"
        }));
        InfoMap parent;

        static String sort(String s)
        {
            return sort(s, false);
        }

        static String sort(String s, boolean flag)
        {
            if (s == null)
            {
                return null;
            }
            Object obj = new TreeSet();
            try
            {
                s = new Tokenizer(new StringReader(s));
                do
                {
                    Token token = s.nextToken();
                    if (token.isEmpty())
                    {
                        break;
                    }
                    ((TreeSet) (obj)).add(token.value);
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
            boolean flag1 = false;
            s = "";
            for (obj = ((TreeSet) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                String s1 = (String)((Iterator) (obj)).next();
                if ("const".equals(s1))
                {
                    flag1 = true;
                } else
                {
                    s = (new StringBuilder()).append(s).append(s1).append(" ").toString();
                }
            }

            if (!flag && flag1)
            {
                return (new StringBuilder()).append("const ").append(s.trim()).toString();
            } else
            {
                return s.trim();
            }
        }

        public LinkedList get(String s)
        {
            LinkedList linkedlist1 = (LinkedList)super.get(sort(s, false));
            LinkedList linkedlist = linkedlist1;
            if (linkedlist1 == null)
            {
                linkedlist = (LinkedList)super.get(sort(s, true));
            }
            linkedlist1 = linkedlist;
            if (linkedlist == null)
            {
                linkedlist1 = linkedlist;
                if (parent != null)
                {
                    linkedlist1 = parent.get(s);
                }
            }
            s = linkedlist1;
            if (linkedlist1 == null)
            {
                s = new LinkedList();
            }
            return s;
        }

        public InfoMap put(Info info)
        {
            String as[];
            int j;
            if (info.cppNames != null)
            {
                as = info.cppNames;
            } else
            {
                as = new String[1];
                as[0] = null;
            }
            j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = sort(as[i], false);
                LinkedList linkedlist1 = (LinkedList)super.get(s);
                LinkedList linkedlist = linkedlist1;
                if (linkedlist1 == null)
                {
                    linkedlist = new LinkedList();
                }
                if (!linkedlist.contains(info))
                {
                    linkedlist.add(info);
                }
                super.put(s, linkedlist);
            }

            return this;
        }


        public InfoMap()
        {
            parent = null;
            parent = defaults;
        }

        public InfoMap(InfoMap infomap)
        {
            parent = null;
            parent = infomap;
        }
    }

    public static interface InfoMapper
    {

        public abstract void map(InfoMap infomap);
    }

    static class Parameters
    {

        String definitions;
        int infoNumber;
        String list;
        String signature;

        Parameters()
        {
            infoNumber = 0;
            list = "";
            definitions = "";
            signature = "";
        }
    }

    static class TemplateMap extends LinkedHashMap
    {

        LinkedHashMap defaults;

        String get(String s)
        {
            String s1 = (String)super.get(s);
            if (s1 == null && defaults != null)
            {
                return (String)defaults.get(s);
            } else
            {
                return s1;
            }
        }

        TemplateMap(TemplateMap templatemap)
        {
            defaults = null;
            defaults = templatemap;
        }
    }

    static class Token
        implements Cloneable
    {

        static final Token CLASS = new Token(5, "class");
        static final int COMMENT = 4;
        static final Token CONST = new Token(5, "const");
        static final Token DEFINE = new Token(5, "define");
        static final Token ELIF = new Token(5, "elif");
        static final Token ELSE = new Token(5, "else");
        static final Token ENDIF = new Token(5, "endif");
        static final Token ENUM = new Token(5, "enum");
        static final Token EOF = new Token();
        static final Token EXTERN = new Token(5, "extern");
        static final int FLOAT = 2;
        static final int IDENTIFIER = 5;
        static final Token IF = new Token(5, "if");
        static final Token IFDEF = new Token(5, "ifdef");
        static final Token IFNDEF = new Token(5, "ifndef");
        static final Token INLINE = new Token(5, "inline");
        static final int INTEGER = 1;
        static final Token STATIC = new Token(5, "static");
        static final int STRING = 3;
        static final Token STRUCT = new Token(5, "struct");
        static final Token TEMPLATE = new Token(5, "template");
        static final Token TYPEDEF = new Token(5, "typedef");
        static final Token TYPENAME = new Token(5, "typename");
        static final Token UNION = new Token(5, "union");
        File file;
        int lineNumber;
        String spacing;
        int type;
        String value;

        public Token clone()
        {
            Token token = new Token();
            token.file = file;
            token.lineNumber = lineNumber;
            token.type = type;
            token.spacing = spacing;
            token.value = value;
            return token;
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public boolean equals(Object obj)
        {
            if (obj != this) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (obj == null)
            {
                return false;
            }
            if (obj.getClass() != java/lang/Integer)
            {
                break; /* Loop/switch isn't completed */
            }
            if (type != ((Integer)obj).intValue())
            {
                return false;
            }
            if (true) goto _L1; else goto _L3
_L3:
            if (obj.getClass() != java/lang/Character)
            {
                break; /* Loop/switch isn't completed */
            }
            if (type != ((Character)obj).charValue())
            {
                return false;
            }
            if (true) goto _L1; else goto _L4
_L4:
            if (obj.getClass() == java/lang/String)
            {
                return obj.equals(value);
            }
            if (obj.getClass() == getClass())
            {
                obj = (Token)obj;
                if (type != ((Token) (obj)).type || (value != null || ((Token) (obj)).value != null) && (value == null || !value.equals(((Token) (obj)).value)))
                {
                    return false;
                }
            } else
            {
                return false;
            }
            if (true) goto _L1; else goto _L5
_L5:
        }

        transient Token expect(Object aobj[])
            throws Exception
        {
            if (!match(aobj))
            {
                throw new Exception((new StringBuilder()).append(file).append(":").append(lineNumber).append(": Unexpected token '").append(toString()).append("'").toString());
            } else
            {
                return this;
            }
        }

        public int hashCode()
        {
            return type;
        }

        boolean isEmpty()
        {
            return type == -1 && spacing.isEmpty();
        }

        transient boolean match(Object aobj[])
        {
            boolean flag = false;
            int j = aobj.length;
            int i = 0;
            while (i < j) 
            {
                Object obj = aobj[i];
                if (flag || equals(obj))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                i++;
            }
            return flag;
        }

        public String toString()
        {
            if (value != null && value.length() > 0)
            {
                return value;
            } else
            {
                return String.valueOf((char)type);
            }
        }


        Token()
        {
            file = null;
            lineNumber = 0;
            type = -1;
            spacing = "";
            value = "";
        }

        Token(int i, String s)
        {
            file = null;
            lineNumber = 0;
            type = -1;
            spacing = "";
            value = "";
            type = i;
            value = s;
        }
    }

    static class Tokenizer
        implements Closeable
    {

        StringBuilder buffer;
        File file;
        int lastChar;
        int lineNumber;
        String lineSeparator;
        Reader reader;

        public void close()
            throws IOException
        {
            reader.close();
        }

        public Token nextToken()
            throws IOException
        {
            Object obj = new Token();
            int j = readChar();
            buffer.setLength(0);
            int i = j;
            if (Character.isWhitespace(j))
            {
                buffer.append((char)j);
                do
                {
                    int k = readChar();
                    i = k;
                    if (k == -1)
                    {
                        break;
                    }
                    i = k;
                    if (!Character.isWhitespace(k))
                    {
                        break;
                    }
                    buffer.append((char)k);
                } while (true);
            }
            obj.file = file;
            obj.lineNumber = lineNumber;
            obj.spacing = buffer.toString();
            buffer.setLength(0);
            if (Character.isLetter(i) || i == 95)
            {
                obj.type = 5;
                buffer.append((char)i);
                do
                {
                    i = readChar();
                    if (i == -1 || !Character.isDigit(i) && !Character.isLetter(i) && i != 95)
                    {
                        break;
                    }
                    buffer.append((char)i);
                } while (true);
                obj.value = buffer.toString();
                lastChar = i;
            } else
            if (Character.isDigit(i) || i == 46 || i == 45 || i == 43)
            {
                int l;
                if (i == 46)
                {
                    l = 2;
                } else
                {
                    l = 1;
                }
                obj.type = l;
                buffer.append((char)i);
                i = 0;
                do
                {
                    l = readChar();
                    if (l == -1 || !Character.isDigit(l) && l != 46 && l != 45 && l != 43 && (l < 97 || l > 102) && l != 108 && l != 117 && l != 120 && (l < 65 || l > 70) && l != 76 && l != 85 && l != 88)
                    {
                        break;
                    }
                    if (l == 46)
                    {
                        obj.type = 2;
                    }
                    if (l != 117 && l != 85)
                    {
                        buffer.append((char)l);
                    }
                    i = l;
                } while (true);
                if (i == 102 || i == 70)
                {
                    obj.type = 2;
                }
                obj.value = buffer.toString();
                if (((Token) (obj)).type == 1 && ((Token) (obj)).value.endsWith("LL"))
                {
                    obj.value = ((Token) (obj)).value.substring(0, ((Token) (obj)).value.length() - 1);
                }
                lastChar = l;
            } else
            if (i == 34)
            {
                obj.type = 3;
                buffer.append('"');
                i = 0;
                do
                {
                    int i1 = readChar();
                    if (i1 == -1 || i != 92 && i1 == 34)
                    {
                        break;
                    }
                    buffer.append((char)i1);
                    i = i1;
                } while (true);
                buffer.append('"');
                obj.value = buffer.toString();
            } else
            if (i == 47)
            {
                i = readChar();
                if (i == 47)
                {
                    obj.type = 4;
                    buffer.append('/').append('/');
                    i = 0;
                    int j1;
                    do
                    {
                        j1 = readChar();
                        if (j1 == -1 || i != 92 && j1 == 10)
                        {
                            break;
                        }
                        buffer.append((char)j1);
                        i = j1;
                    } while (true);
                    obj.value = buffer.toString();
                    lastChar = j1;
                } else
                if (i == 42)
                {
                    obj.type = 4;
                    buffer.append('/').append('*');
                    i = 0;
                    do
                    {
                        int k1 = readChar();
                        if (k1 == -1 || i == 42 && k1 == 47)
                        {
                            break;
                        }
                        buffer.append((char)k1);
                        i = k1;
                    } while (true);
                    buffer.append('/');
                    obj.value = buffer.toString();
                } else
                {
                    lastChar = i;
                    obj.type = 47;
                }
            } else
            {
                if (i == 92)
                {
                    int l1 = readChar();
                    if (l1 == 10)
                    {
                        obj = ((Token) (obj)).spacing;
                        Token token = nextToken();
                        token.spacing = ((String) (obj));
                        return token;
                    }
                    lastChar = l1;
                }
                obj.type = i;
            }
            return ((Token) (obj));
        }

        int readChar()
            throws IOException
        {
label0:
            {
                byte byte0 = -1;
                if (lastChar != -1)
                {
                    int i = lastChar;
                    lastChar = -1;
                    return i;
                }
                int k = reader.read();
                int j;
                if (k != 13)
                {
                    j = k;
                    if (k != 10)
                    {
                        break label0;
                    }
                }
                lineNumber = lineNumber + 1;
                j = byte0;
                if (k == 13)
                {
                    j = reader.read();
                }
                if (lineSeparator == null)
                {
                    String s;
                    if (k == 13 && j == 10)
                    {
                        s = "\r\n";
                    } else
                    if (k == 13)
                    {
                        s = "\r";
                    } else
                    {
                        s = "\n";
                    }
                    lineSeparator = s;
                }
                if (j != 10)
                {
                    lastChar = j;
                }
                j = 10;
            }
            return j;
        }

        Tokenizer(File file1)
            throws FileNotFoundException
        {
            file = null;
            reader = null;
            lineSeparator = null;
            lastChar = -1;
            lineNumber = 1;
            buffer = new StringBuilder();
            file = file1;
            reader = new BufferedReader(new FileReader(file1));
        }

        Tokenizer(Reader reader1)
        {
            file = null;
            reader = null;
            lineSeparator = null;
            lastChar = -1;
            lineNumber = 1;
            buffer = new StringBuilder();
            reader = reader1;
        }
    }


    InfoMap infoMap;
    Properties properties;
    Token tokenArray[];
    int tokenIndex;

    public Parser(Properties properties1, InfoMap infomap)
    {
        properties = null;
        infoMap = null;
        tokenArray = null;
        tokenIndex = 0;
        properties = properties1;
        infoMap = infomap;
    }

    boolean attribute()
        throws Exception
    {
        if (!getToken().match(new Object[] {
    Integer.valueOf(5)
}))
        {
            return false;
        }
        if (!nextToken().match(new Object[] {
    Character.valueOf('(')
}))
        {
            return true;
        }
        int j = 1;
        Token token = nextToken();
        while (!token.match(new Object[] {
            Token.EOF
        }) && j > 0) 
        {
            int i;
            if (token.match(new Object[] {
    Character.valueOf('(')
}))
            {
                i = j + 1;
            } else
            {
                i = j;
                if (token.match(new Object[] {
    Character.valueOf(')')
}))
                {
                    i = j - 1;
                }
            }
            token = nextToken(false);
            j = i;
        }
        return true;
    }

    boolean body()
        throws Exception
    {
        if (!getToken().match(new Object[] {
    Character.valueOf('{')
}))
        {
            return false;
        }
        int j = 1;
        Token token = nextToken();
        while (!token.match(new Object[] {
            Token.EOF
        }) && j > 0) 
        {
            int i;
            if (token.match(new Object[] {
    Character.valueOf('{')
}))
            {
                i = j + 1;
            } else
            {
                i = j;
                if (token.match(new Object[] {
    Character.valueOf('}')
}))
                {
                    i = j - 1;
                }
            }
            token = nextToken(false);
            j = i;
        }
        return true;
    }

    String commentAfter()
        throws Exception
    {
        Object obj = "";
        for (; tokenIndex > 0 && getToken(-1).match(new Object[] {
    Integer.valueOf(4)
}); tokenIndex = tokenIndex - 1) { }
        Object obj1 = getToken();
        while (((Token) (obj1)).match(new Object[] {
            Integer.valueOf(4)
        })) 
        {
            Object obj2 = obj;
            if (((Token) (obj1)).value.length() > 3)
            {
                obj2 = obj;
                if (((Token) (obj1)).value.charAt(3) == '<')
                {
                    obj1 = ((Token) (obj1)).value;
                    obj2 = (new StringBuilder()).append(((String) (obj)));
                    if (((String) (obj)).length() > 0)
                    {
                        obj = " * ";
                    } else
                    {
                        obj = "/**";
                    }
                    obj2 = ((StringBuilder) (obj2)).append(((String) (obj))).append(((String) (obj1)).substring(4)).toString();
                }
            }
            obj1 = nextToken(false);
            obj = obj2;
        }
        obj1 = obj;
        if (((String) (obj)).length() > 0)
        {
            obj1 = obj;
            if (!((String) (obj)).endsWith("*/"))
            {
                obj1 = (new StringBuilder()).append(((String) (obj))).append(" */").toString();
            }
        }
        return ((String) (obj1));
    }

    String commentBefore()
        throws Exception
    {
        String s = "";
        for (; tokenIndex > 0 && getToken(-1).match(new Object[] {
    Integer.valueOf(4)
}); tokenIndex = tokenIndex - 1) { }
        for (Token token = getToken(); token.match(new Object[] {
    Integer.valueOf(4)
});)
        {
            String s1;
label0:
            {
                if (token.value.length() > 3)
                {
                    s1 = s;
                    if (token.value.charAt(3) == '<')
                    {
                        break label0;
                    }
                }
                s1 = (new StringBuilder()).append(s).append(token.spacing).append(token.value).toString();
            }
            token = nextToken(false);
            s = s1;
        }

        return s;
    }

    String declaration(String s, TemplateMap templatemap)
        throws Exception
    {
        String s2 = commentBefore();
        Token token = getToken();
        String s3 = token.spacing;
        TemplateMap templatemap1 = template(templatemap);
        String s1 = s2;
        if (templatemap1 != templatemap)
        {
            s1 = (new StringBuilder()).append(s2).append(s3.substring(0, s3.lastIndexOf('\n'))).toString();
        }
        templatemap = macro();
        if (templatemap != null)
        {
            return (new StringBuilder()).append(s1).append(templatemap).toString();
        }
        templatemap = enumeration();
        if (templatemap != null)
        {
            return (new StringBuilder()).append(s1).append(templatemap).toString();
        }
        templatemap = group(templatemap1);
        if (templatemap != null)
        {
            return (new StringBuilder()).append(s1).append(templatemap).toString();
        }
        templatemap = typedef();
        if (templatemap != null)
        {
            return (new StringBuilder()).append(s1).append(templatemap).toString();
        }
        templatemap = function(s, templatemap1);
        if (templatemap != null)
        {
            return (new StringBuilder()).append(s1).append(templatemap).toString();
        }
        s = variable(s);
        if (s != null)
        {
            return (new StringBuilder()).append(s1).append(s).toString();
        }
        if (attribute())
        {
            return (new StringBuilder()).append(s1).append(s3).toString();
        } else
        {
            throw new Exception((new StringBuilder()).append(token.file).append(":").append(token.lineNumber).append(": Could not parse declaration at '").append(token).append("'").toString());
        }
    }

    Declarator declarator(TemplateMap templatemap, String s, int i, int j, boolean flag, boolean flag1)
        throws Exception
    {
        Object obj1;
        Object obj3;
        Declarator declarator1;
        boolean flag2;
        boolean flag8;
        flag8 = getToken().match(new Object[] {
            Token.TYPEDEF
        });
        declarator1 = new Declarator();
        obj1 = "";
        flag2 = false;
        obj3 = getToken();
_L5:
        if (!((Token) (obj3)).match(new Object[] {
            Token.EOF
        }) && ((Token) (obj3)).match(new Object[] {
            Integer.valueOf(5)
        })) goto _L2; else goto _L1
_L1:
        Object obj;
        obj1 = ((String) (obj1)).trim();
        obj = obj1;
        if (templatemap != null)
        {
            obj = obj1;
            if (templatemap.containsKey(obj1))
            {
                obj = templatemap.get(((String) (obj1)));
            }
        }
        declarator1.javaType = ((String) (obj));
        declarator1.cppType = ((String) (obj));
        if (!"...".equals(getToken().value)) goto _L4; else goto _L3
_L3:
        nextToken();
        templatemap = null;
_L28:
        return templatemap;
_L2:
        int i1;
        if (((Token) (obj3)).match(new Object[] {
    Token.CONST
}))
        {
            declarator1.constValue = true;
            i1 = ((flag2) ? 1 : 0);
            obj = obj1;
        } else
        {
            obj = obj1;
            i1 = ((flag2) ? 1 : 0);
            if (!((Token) (obj3)).match(new Object[] {
    Token.TYPEDEF, Token.ENUM, Token.CLASS, Token.STRUCT, Token.UNION
}))
            {
                if (!((Token) (obj3)).match(new Object[] {
    "signed", "unsigned", "char", "short", "int", "long", "bool", "float", "double"
}))
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (!flag2)
                {
                    obj = (new StringBuilder()).append(((Token) (obj3)).value).append(" ").toString();
                } else
                {
                    obj = (new StringBuilder()).append(((String) (obj1))).append(((Token) (obj3)).value).append(" ").toString();
                }
                i1 = 1;
            }
        }
_L8:
        obj3 = nextToken();
        obj1 = obj;
        flag2 = i1;
          goto _L5
        if (((String) (obj1)).length() > 0 && !getToken(1).match(new Object[] {
            Character.valueOf('*'), Character.valueOf('&'), Integer.valueOf(5), Token.CONST
        })) goto _L1; else goto _L6
_L6:
        int j1;
        int k1;
        obj = infoMap.get(((Token) (obj3)).value);
        if (((LinkedList) (obj)).size() <= 0 || ((Info)((LinkedList) (obj)).getFirst()).annotations == null)
        {
            break MISSING_BLOCK_LABEL_561;
        }
        obj3 = ((Info)((LinkedList) (obj)).getFirst()).annotations;
        k1 = obj3.length;
        j1 = 0;
_L9:
        obj = obj1;
        i1 = ((flag2) ? 1 : 0);
        if (j1 >= k1) goto _L8; else goto _L7
_L7:
        obj = obj3[j1];
        declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append(((String) (obj))).append(" ").toString();
        j1++;
          goto _L9
        obj = ((Token) (obj3)).value;
        i1 = ((flag2) ? 1 : 0);
          goto _L8
_L4:
        int k;
        i1 = 0;
        obj1 = getToken();
        k = j;
_L11:
        if (k <= 0 || ((Token) (obj1)).match(new Object[] {
    Token.EOF
}))
        {
            break MISSING_BLOCK_LABEL_772;
        }
        if (!((Token) (obj1)).match(new Object[] {
    Character.valueOf('(')
}))
        {
            break; /* Loop/switch isn't completed */
        }
        j = i1 + 1;
        j1 = k;
_L12:
        obj1 = nextToken();
        i1 = j;
        k = j1;
        if (true) goto _L11; else goto _L10
_L10:
        if (((Token) (obj1)).match(new Object[] {
    Character.valueOf(')')
}))
        {
            j = i1 - 1;
            j1 = k;
        } else
        {
            j = i1;
            j1 = k;
            if (i1 == 0)
            {
label0:
                {
                    if (!((Token) (obj1)).match(new Object[] {
    Character.valueOf(',')
}))
                    {
                        break label0;
                    }
                    j1 = k - 1;
                    j = i1;
                }
            }
        }
          goto _L12
          goto _L11
        j = i1;
        j1 = k;
        if (!((Token) (obj1)).match(new Object[] {
            Character.valueOf(';')
        })) goto _L12; else goto _L13
_L13:
        nextToken();
        return null;
        boolean flag4;
        j = 0;
        flag4 = false;
        obj1 = getToken();
_L15:
        if (((Token) (obj1)).match(new Object[] {
    Token.EOF
}))
        {
            break MISSING_BLOCK_LABEL_915;
        }
        if (!((Token) (obj1)).match(new Object[] {
    Character.valueOf('*')
}))
        {
            break; /* Loop/switch isn't completed */
        }
        j++;
_L16:
        obj = (new StringBuilder()).append(((String) (obj))).append(((Token) (obj1)).toString()).toString();
        obj1 = nextToken();
        if (true) goto _L15; else goto _L14
_L14:
        if (((Token) (obj1)).match(new Object[] {
    Character.valueOf('&')
}))
        {
            flag4 = true;
        } else
        {
            if (!((Token) (obj1)).match(new Object[] {
    Token.CONST
}))
            {
                break MISSING_BLOCK_LABEL_915;
            }
            declarator1.constPointer = true;
        }
          goto _L16
        if (true) goto _L15; else goto _L17
_L17:
        i1 = 0;
        k = 0;
        declarator1.objectName = s;
        if (!getToken().match(new Object[] {
    Character.valueOf('(')
}))
        {
            break MISSING_BLOCK_LABEL_1200;
        }
        for (; getToken().match(new Object[] {
    Character.valueOf('(')
}); nextToken()) { }
        obj1 = getToken();
        i1 = k;
_L19:
        if (((Token) (obj1)).match(new Object[] {
    Token.EOF
}))
        {
            break MISSING_BLOCK_LABEL_1166;
        }
        if (!((Token) (obj1)).match(new Object[] {
    Integer.valueOf(5)
}))
        {
            break; /* Loop/switch isn't completed */
        }
        declarator1.objectName = ((Token) (obj1)).value;
        k = i1;
_L20:
        obj1 = nextToken();
        i1 = k;
        if (true) goto _L19; else goto _L18
_L18:
        if (((Token) (obj1)).match(new Object[] {
    Character.valueOf('*')
}))
        {
            k = i1 + 1;
            declarator1.convention = declarator1.objectName;
            declarator1.objectName = s;
        } else
        {
label1:
            {
                if (!((Token) (obj1)).match(new Object[] {
    Character.valueOf('[')
}))
                {
                    break label1;
                }
                declarator1.indices = declarator1.indices + 1;
                k = i1;
            }
        }
          goto _L20
          goto _L19
        k = i1;
        if (!((Token) (obj1)).match(new Object[] {
            Character.valueOf(')')
        })) goto _L20; else goto _L21
_L21:
        nextToken();
        do
        {
            k = i1;
            if (!getToken().match(new Object[] {
    Character.valueOf(')')
}))
            {
                break;
            }
            nextToken();
        } while (true);
        break MISSING_BLOCK_LABEL_1246;
        k = i1;
        if (getToken().match(new Object[] {
    Integer.valueOf(5)
}))
        {
            declarator1.objectName = getToken().value;
            nextToken();
            k = i1;
        }
        k1 = 0;
        s = getToken();
_L26:
        i1 = k;
        if (s.match(new Object[] {
            Token.EOF
        })) goto _L23; else goto _L22
_L22:
        if (k1 != 0 || !s.match(new Object[] {
            Character.valueOf('[')
        })) goto _L25; else goto _L24
_L24:
        i1 = 1;
        declarator1.indices = declarator1.indices + 1;
_L27:
        s = nextToken();
        k1 = i1;
          goto _L26
_L25:
        if (k1 != 0)
        {
            break MISSING_BLOCK_LABEL_1369;
        }
        i1 = k;
_L23:
        for (; declarator1.indices > 0 && i1 > 0; i1--)
        {
            declarator1.indices = declarator1.indices + 1;
        }

        break MISSING_BLOCK_LABEL_1407;
        i1 = k1;
        if (k1 != 0)
        {
            i1 = k1;
            if (s.match(new Object[] {
    Character.valueOf(']')
}))
            {
                i1 = 0;
            }
        }
          goto _L27
        Object obj2 = obj;
        int l = j;
        if (flag)
        {
            obj2 = obj;
            l = j;
            if (declarator1.indices > 0)
            {
                l = j + 1;
                obj2 = (new StringBuilder()).append(((String) (obj))).append("*").toString();
            }
        }
        s = ((String) (obj2));
        int l1 = l;
        if (flag1)
        {
            s = ((String) (obj2));
            l1 = l;
            if (l > 1)
            {
                declarator1.indices = declarator1.indices + 1;
                l1 = l - 1;
                s = ((String) (obj2)).substring(0, ((String) (obj2)).length() - 1);
            }
        }
        if (getToken().match(new Object[] {
    Character.valueOf(':')
}))
        {
            declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append("@NoOffset ").toString();
            nextToken().expect(new Object[] {
                Integer.valueOf(1)
            });
            nextToken().expect(new Object[] {
                Character.valueOf(','), Character.valueOf(';')
            });
        }
        j = 1;
        boolean flag3 = false;
        flag1 = false;
        boolean flag5 = false;
        if (declarator1.constValue && l1 < 2 && !flag4)
        {
            obj = (new StringBuilder()).append("const ").append(declarator1.cppType).toString();
        } else
        {
            obj = declarator1.cppType;
        }
        obj = infoMap.get(((String) (obj)));
        if (((LinkedList) (obj)).size() > 0)
        {
            obj = (Info)((LinkedList) (obj)).getFirst();
            int i2;
            boolean flag6;
            if (((Info) (obj)).primitiveTypes != null && l1 == 0 && !flag4)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            flag1 = ((Info) (obj)).cast;
            flag5 = ((Info) (obj)).cppNames[0].startsWith("const ");
            if (flag3)
            {
                j = ((Info) (obj)).primitiveTypes.length;
            } else
            if (((Info) (obj)).pointerTypes != null)
            {
                j = ((Info) (obj)).pointerTypes.length;
            } else
            {
                j = 1;
            }
            if (i < 0)
            {
                i2 = 0;
            } else
            {
                i2 = i % j;
            }
            declarator1.infoNumber = i2;
            if (flag3)
            {
                obj = ((Info) (obj)).primitiveTypes[declarator1.infoNumber];
            } else
            if (((Info) (obj)).pointerTypes != null)
            {
                obj = ((Info) (obj)).pointerTypes[declarator1.infoNumber];
            } else
            {
                obj = declarator1.cppType;
            }
            declarator1.javaType = ((String) (obj));
        }
        flag6 = flag1;
        if (!flag3)
        {
            if (l1 == 0 && !flag4)
            {
                declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append("@ByVal ").toString();
            } else
            if (l1 == 0 && flag4)
            {
                declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append("@ByRef ").toString();
            } else
            if (l1 == 1 && flag4)
            {
                declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append("@ByPtrRef ").toString();
            } else
            if (l1 == 2 && !flag4 && i >= 0)
            {
                declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append("@ByPtrPtr ").toString();
                if (declarator1.cppType.equals("void"))
                {
                    flag1 = true;
                }
            } else
            if (l1 >= 2)
            {
                declarator1.infoNumber = declarator1.infoNumber + j;
                boolean flag7 = true;
                declarator1.javaType = "PointerPointer";
                flag1 = flag7;
                if (flag4)
                {
                    declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append("@ByRef ").toString();
                    flag1 = flag7;
                }
            }
            flag6 = flag1;
            if (!flag1)
            {
                flag6 = flag1;
                if (declarator1.constValue)
                {
                    flag6 = flag1;
                    if (!flag5)
                    {
                        declarator1.annotations = (new StringBuilder()).append("@Const ").append(declarator1.annotations).toString();
                        flag6 = flag1;
                    }
                }
            }
        }
        if (flag6 || flag && declarator1.indices > 1)
        {
            obj = s;
            if (declarator1.constValue)
            {
                obj = (new StringBuilder()).append("const ").append(s).toString();
            }
            if (!flag3 && l1 == 0 && !flag4)
            {
                declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append("@Cast(\"").append(((String) (obj))).append("*\") ").toString();
            } else
            {
                declarator1.annotations = (new StringBuilder()).append("@Cast(\"").append(((String) (obj))).append("\") ").append(declarator1.annotations).toString();
            }
        }
        s = parameters(templatemap, i);
        if (s != null)
        {
            declarator1.infoNumber = Math.max(declarator1.infoNumber, ((Parameters) (s)).infoNumber);
            if (((Parameters) (s)).definitions.length() > 0)
            {
                declarator1.definitions = (new StringBuilder()).append(declarator1.definitions).append(((Parameters) (s)).definitions).append("\n").toString();
            }
            if (i1 == 0)
            {
                declarator1.parameters = ((Parameters) (s)).list;
            } else
            {
                if (flag8)
                {
                    templatemap = declarator1.objectName;
                } else
                {
                    templatemap = (new StringBuilder()).append(Character.toUpperCase(declarator1.objectName.charAt(0))).append(declarator1.objectName.substring(1)).append(((Parameters) (s)).signature).toString();
                }
                if (i <= ((Parameters) (s)).infoNumber)
                {
                    declarator1.definitions = (new StringBuilder()).append(declarator1.definitions).append("public static class ").append(templatemap).append(" extends FunctionPointer {\n").append("    static { Loader.load(); }\n").append("    public    ").append(templatemap).append("(Pointer p) { super(p); }\n").append("    protected ").append(templatemap).append("() { allocate(); }\n").append("    private native void allocate();\n").append("    public native ").append(declarator1.annotations).append(declarator1.javaType).append(" call").append(((Parameters) (s)).list).append(";\n").append("}\n").toString();
                }
                declarator1.annotations = "";
                declarator1.javaType = templatemap;
                declarator1.parameters = "";
            }
        }
        s = infoMap.get(declarator1.objectName);
        templatemap = declarator1;
        if (s.size() > 0)
        {
            s = (Info)s.getFirst();
            templatemap = declarator1;
            if (((Info) (s)).javaNames != null)
            {
                templatemap = declarator1;
                if (((Info) (s)).javaNames.length > 0)
                {
                    declarator1.annotations = (new StringBuilder()).append(declarator1.annotations).append("@Name(\"").append(declarator1.objectName).append("\") ").toString();
                    declarator1.objectName = ((Info) (s)).javaNames[0];
                    return declarator1;
                }
            }
        }
          goto _L28
    }

    String enumeration()
        throws Exception
    {
        Object obj;
        String s4;
        boolean flag1;
        int k;
        boolean flag3;
        k = tokenIndex;
        s4 = getToken().spacing;
        flag3 = getToken().match(new Object[] {
            Token.TYPEDEF
        });
        flag1 = false;
        obj = getToken();
_L7:
        boolean flag = flag1;
        if (((Token) (obj)).match(new Object[] {
            Token.EOF
        })) goto _L2; else goto _L1
_L1:
        if (!((Token) (obj)).match(new Object[] {
            Token.ENUM
        })) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        if (!flag)
        {
            tokenIndex = k;
            return null;
        }
        break; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        if (!((Token) (obj)).match(new Object[] {
            Integer.valueOf(5)
        })) goto _L2; else goto _L5
_L5:
        obj = nextToken();
        if (true) goto _L7; else goto _L6
_L6:
        Object obj1;
        String s1;
        String s2;
        String s5;
        int i;
        if (flag3 && !getToken(1).match(new Object[] {
    Character.valueOf('{')
}) && getToken(2).match(new Object[] {
    Integer.valueOf(5)
}))
        {
            nextToken();
        }
        flag1 = true;
        i = 0;
        obj = " ";
        s1 = "";
        s2 = "";
        s5 = nextToken().expect(new Object[] {
            Integer.valueOf(5), Character.valueOf('{')
        }).value;
        if (!getToken().match(new Object[] {
    Character.valueOf('{')
}) && !nextToken().match(new Object[] {
    Character.valueOf('{')
}))
        {
            tokenIndex = k;
            return null;
        }
        obj1 = nextToken();
_L9:
        if (((Token) (obj1)).match(new Object[] {
    Token.EOF, Character.valueOf('}')
}))
        {
            break MISSING_BLOCK_LABEL_1055;
        }
        obj1 = macro();
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (new StringBuilder()).append(s2).append(((String) (obj1))).toString();
_L10:
        Token token = getToken();
        s2 = ((String) (obj1));
        obj1 = token;
        if (true) goto _L9; else goto _L8
_L8:
        Object obj3;
        Object obj5;
        String s6;
        Token token2;
        String s8;
        s8 = commentBefore();
        token2 = getToken();
        obj3 = " ";
        int l;
        if (flag1)
        {
            obj1 = "";
        } else
        {
            obj1 = ",";
        }
        obj5 = obj1;
        if (!nextToken().match(new Object[] {
    Character.valueOf('=')
}))
        {
            break MISSING_BLOCK_LABEL_655;
        }
        s6 = getToken().spacing;
        obj = " ";
        l = 0;
        obj5 = new Token();
        k = 0;
        obj3 = nextToken();
        while (!((Token) (obj3)).match(new Object[] {
            Token.EOF, Character.valueOf(','), Character.valueOf('}')
        }) || l > 0) 
        {
            obj = (new StringBuilder()).append(((String) (obj))).append(((Token) (obj3)).spacing).append(obj3).toString();
            Token token1;
            if (((Token) (obj3)).match(new Object[] {
    Character.valueOf('(')
}))
            {
                i = l + 1;
            } else
            {
                i = l;
                if (((Token) (obj3)).match(new Object[] {
    Character.valueOf(')')
}))
                {
                    i = l - 1;
                }
            }
            l = k;
            if (((Token) (obj5)).match(new Object[] {
    Integer.valueOf(5)
}))
            {
                l = k;
                if (((Token) (obj3)).match(new Object[] {
    Character.valueOf('(')
}))
                {
                    l = 1;
                }
            }
            token1 = nextToken();
            k = l;
            l = i;
            obj5 = obj3;
            obj3 = token1;
        }
        i = Integer.parseInt(((String) (obj)).trim());
        obj = " ";
        obj3 = s6;
        obj5 = obj1;
_L11:
        flag1 = false;
        s6 = (new StringBuilder()).append(s1).append(((String) (obj5))).append(s2).append(s8).toString();
        obj5 = "";
        s1 = commentAfter();
        obj1 = s1;
        if (s1.length() == 0)
        {
            obj1 = s1;
            if (getToken().match(new Object[] {
    Character.valueOf(',')
}))
            {
                nextToken();
                obj1 = commentAfter();
            }
        }
        String s7 = token2.spacing;
        s1 = s6;
        s2 = s7;
        if (((String) (obj1)).length() > 0)
        {
            obj1 = (new StringBuilder()).append(s6).append(s7).append(((String) (obj1))).toString();
            k = s7.lastIndexOf('\n');
            s1 = ((String) (obj1));
            s2 = s7;
            if (k > 0)
            {
                s2 = s7.substring(k);
                s1 = ((String) (obj1));
            }
        }
        obj3 = (new StringBuilder()).append(s1).append(s2).append(token2.value).append(((String) (obj3))).append("=").append(((String) (obj))).toString();
        boolean flag2;
        if (((String) (obj)).trim().length() > 0)
        {
            obj1 = obj3;
            if (i > 0)
            {
                obj1 = (new StringBuilder()).append(((String) (obj3))).append(" + ").append(i).toString();
            }
        } else
        {
            obj1 = (new StringBuilder()).append(((String) (obj3))).append(i).toString();
        }
        i++;
        s1 = ((String) (obj1));
        obj1 = obj5;
          goto _L10
        obj3;
        flag2 = false;
        i = ((flag2) ? 1 : 0);
        obj5 = obj1;
        obj3 = s6;
        if (k != 0)
        {
            if (!flag1)
            {
                obj1 = ";\n";
            }
            obj5 = (new StringBuilder()).append(((String) (obj1))).append("public static native @MemberGetter int ").append(token2.value).append("();\npublic static final int").toString();
            obj = (new StringBuilder()).append(" ").append(token2.value).append("()").toString();
            i = ((flag2) ? 1 : 0);
            obj3 = s6;
        }
          goto _L11
        String s3 = commentBefore();
        Object obj4 = nextToken();
        String s = s5;
        Object obj2 = obj4;
        if (((Token) (obj4)).match(new Object[] {
    Integer.valueOf(5)
}))
        {
            s = ((Token) (obj4)).value;
            obj2 = nextToken();
        }
        s5 = (new StringBuilder()).append("").append(s4).append("/** enum ").append(s).append(" */\n").toString();
        int j = s4.lastIndexOf('\n');
        obj4 = s4;
        if (j >= 0)
        {
            obj4 = s4.substring(j + 1);
        }
        obj2 = (new StringBuilder()).append(s5).append(((String) (obj4))).append("public static final int").append(s1).append(((Token) (obj2)).expect(new Object[] {
            Character.valueOf(';')
        }).spacing).append(";").toString();
        infoMap.put((new Info(new String[] {
            s
        })).primitiveTypes(new String[] {
            "int"
        }).pointerTypes(new String[] {
            "IntPointer", "IntBuffer", "int[]"
        }).cast(true));
        nextToken();
        return (new StringBuilder()).append(((String) (obj2))).append(s2).append(s3).toString();
    }

    String function(String s, TemplateMap templatemap)
        throws Exception
    {
        Object obj;
        String s2;
        String s5;
        int i;
        i = tokenIndex;
        s5 = getToken().spacing;
        if (s == null || s.length() == 0)
        {
            s = "public static native ";
        } else
        {
            s = "public native ";
        }
        obj = getToken();
        s2 = s;
        if (((Token) (obj)).match(new Object[] {
            Token.EOF
        })) goto _L2; else goto _L1
_L1:
        if (!((Token) (obj)).match(new Object[] {
            Token.STATIC
        })) goto _L4; else goto _L3
_L3:
        s = "public static native ";
_L5:
        obj = nextToken();
        s2 = s;
        break MISSING_BLOCK_LABEL_38;
_L4:
        s = s2;
        if (((Token) (obj)).match(new Object[] {
            Token.INLINE
        })) goto _L5; else goto _L2
_L2:
        String s1;
        int l;
        l = tokenIndex;
        s = declarator(templatemap, null, 0, 0, false, false);
        s1 = ((Declarator) (s)).objectName;
        if (s1 != null && ((Declarator) (s)).parameters.length() != 0) goto _L7; else goto _L6
_L6:
        tokenIndex = i;
        obj = null;
_L18:
        return ((String) (obj));
_L7:
        String s3;
        String s6;
        Iterator iterator;
        s6 = "";
        obj = "";
        s3 = "";
        s = infoMap.get(s1);
        if (s.size() == 0)
        {
            s.add(null);
        }
        iterator = s.iterator();
_L16:
        if (!iterator.hasNext()) goto _L9; else goto _L8
_L8:
        LinkedList linkedlist;
        Declarator declarator1;
        boolean flag;
        Object obj2 = (Info)iterator.next();
        if (obj2 != null)
        {
            if (((Info) (obj2)).genericTypes != null && templatemap != null)
            {
                i = 0;
                s = templatemap.keySet().iterator();
                do
                {
                    if (!s.hasNext())
                    {
                        break;
                    }
                    s1 = (String)s.next();
                    if (i < ((Info) (obj2)).genericTypes.length)
                    {
                        templatemap.put(s1, ((Info) (obj2)).genericTypes[i]);
                        i++;
                    }
                } while (true);
            }
            if (((Info) (obj2)).javaNames == null)
            {
                s = ((Info) (obj2)).cppNames[0];
            } else
            if (((Info) (obj2)).javaNames.length == 0)
            {
                s = "";
            } else
            {
                s = ((Info) (obj2)).javaNames[0];
            }
            s1 = s;
            if (!s.equals(((Info) (obj2)).cppNames[0]))
            {
                s1 = s;
                if (s.length() > 0)
                {
                    s1 = (new StringBuilder()).append("@Name(\"").append(((Info) (obj2)).cppNames[0]).append("\") ").append(s).toString();
                }
            }
        }
        linkedlist = new LinkedList();
        i = -1;
_L14:
        if (i >= 0x7fffffff) goto _L11; else goto _L10
_L10:
        tokenIndex = l;
        declarator1 = declarator(templatemap, null, i, 0, false, false);
        flag = false;
        for (s = linkedlist.iterator(); s.hasNext();)
        {
            obj2 = (Declarator)s.next();
            flag |= declarator1.parameters.equals(((Declarator) (obj2)).parameters);
        }

        if (!flag || i <= 0) goto _L12; else goto _L11
_L11:
        while (attribute()) ;
        String s4;
        if (getToken().match(new Object[] {
    Character.valueOf('{')
}))
        {
            body();
        } else
        {
            nextToken();
        }
          goto _L13
_L12:
        s4 = s3;
        s = ((String) (obj));
        if (s1.length() > 0)
        {
            s4 = s3;
            s = ((String) (obj));
            if (!flag)
            {
                s = (new StringBuilder()).append(((String) (obj))).append(s2).append(declarator1.annotations).append(declarator1.javaType).append(" ").append(s1).append(declarator1.parameters).append(";\n").toString();
                s4 = (new StringBuilder()).append(s3).append(declarator1.definitions).toString();
            }
        }
        linkedlist.add(declarator1);
        i++;
        s3 = s4;
        obj = s;
        if (true) goto _L14; else goto _L9
_L9:
        s = commentAfter();
        Object obj1 = obj;
        if (s.length() > 0)
        {
            obj1 = (new StringBuilder()).append(s).append("\n").append(((String) (obj))).toString();
        }
        Scanner scanner = new Scanner(s3);
        templatemap = s6;
        s = s5;
        do
        {
            if (!scanner.hasNextLine())
            {
                break;
            }
            obj = (new StringBuilder()).append(templatemap).append(s).append(scanner.nextLine()).toString();
            int j = s.lastIndexOf('\n');
            templatemap = ((TemplateMap) (obj));
            if (j > 0)
            {
                s = s.substring(j);
                templatemap = ((TemplateMap) (obj));
            }
        } while (true);
        obj1 = new Scanner(((String) (obj1)));
        do
        {
            obj = templatemap;
            if (!((Scanner) (obj1)).hasNextLine())
            {
                continue;
            }
            obj = (new StringBuilder()).append(templatemap).append(s).append(((Scanner) (obj1)).nextLine()).toString();
            int k = s.lastIndexOf('\n');
            templatemap = ((TemplateMap) (obj));
            if (k > 0)
            {
                s = s.substring(k);
                templatemap = ((TemplateMap) (obj));
            }
        } while (true);
_L13:
        if (true) goto _L16; else goto _L15
_L15:
        if (true) goto _L18; else goto _L17
_L17:
    }

    Token getToken()
    {
        return getToken(0);
    }

    Token getToken(int i)
    {
        if (tokenIndex + i < tokenArray.length)
        {
            return tokenArray[tokenIndex + i];
        } else
        {
            return Token.EOF;
        }
    }

    String group(TemplateMap templatemap)
        throws Exception
    {
        Token token;
        String s3;
        boolean flag2;
        boolean flag3;
        int j;
        boolean flag4;
        j = tokenIndex;
        s3 = getToken().spacing;
        flag4 = getToken().match(new Object[] {
            Token.TYPEDEF
        });
        flag3 = false;
        flag2 = true;
        token = getToken();
_L8:
        boolean flag;
        boolean flag1;
        flag1 = flag2;
        flag = flag3;
        if (token.match(new Object[] {
            Token.EOF
        })) goto _L2; else goto _L1
_L1:
        if (!token.match(new Object[] {
            Token.CLASS, Token.STRUCT, Token.UNION
        })) goto _L4; else goto _L3
_L3:
        flag = true;
        flag1 = flag2;
_L2:
        if (!flag)
        {
            tokenIndex = j;
            return null;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!token.match(new Object[] {
    Token.EXTERN
}) || !nextToken().match(new Object[] {
    Integer.valueOf(3)
}))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
        flag1 = false;
        if (true) goto _L2; else goto _L5
_L5:
        flag1 = flag2;
        flag = flag3;
        if (!token.match(new Object[] {
            Integer.valueOf(5)
        })) goto _L2; else goto _L6
_L6:
        token = nextToken();
        if (true) goto _L8; else goto _L7
_L7:
        Object obj;
        String s2;
label0:
        {
            if (flag4 && !getToken(1).match(new Object[] {
    Character.valueOf('{')
}) && getToken(2).match(new Object[] {
    Integer.valueOf(5)
}))
            {
                nextToken();
            }
            obj = "";
            String s1 = nextToken().expect(new Object[] {
                Integer.valueOf(3), Integer.valueOf(5), Character.valueOf('{')
            }).value;
            if (!getToken(0).match(new Object[] {
    Character.valueOf('{'), Character.valueOf(';')
}) && !getToken(1).match(new Object[] {
    Character.valueOf('{'), Character.valueOf(';')
}))
            {
                tokenIndex = j;
                return null;
            }
            s2 = s1;
            if (!flag1)
            {
                break label0;
            }
            obj = infoMap.get(s1);
            if (getToken().match(new Object[] {
    Integer.valueOf(5)
}) && nextToken().match(new Object[] {
    Character.valueOf(';')
}))
            {
                nextToken();
                if (((LinkedList) (obj)).size() == 0 || !((Info)((LinkedList) (obj)).getFirst()).forwardDeclared)
                {
                    infoMap.put((new Info(new String[] {
                        s1
                    })).forwardDeclared(true));
                    return (new StringBuilder()).append(s3).append("@Opaque public static class ").append(s1).append(" extends Pointer {\n").append("    public ").append(s1).append("() { }\n").append("    public ").append(s1).append("(Pointer p) { super(p); }\n").append("}").toString();
                } else
                {
                    return "";
                }
            }
            int i = tokenIndex;
            String s = s1;
            if (body())
            {
                s = s1;
                if (flag4)
                {
                    s = s1;
                    if (getToken().match(new Object[] {
    Integer.valueOf(5)
}))
                    {
                        s = getToken().value;
                        infoMap.get(s);
                    }
                }
            }
            if (s.length() == 0)
            {
                templatemap = nextToken();
                do
                {
label1:
                    {
                        if (!templatemap.match(new Object[] {
    Token.EOF
}))
                        {
                            if (!templatemap.match(new Object[] {
    Character.valueOf(';')
}))
                            {
                                break label1;
                            }
                            nextToken();
                        }
                        return "";
                    }
                    templatemap = nextToken();
                } while (true);
            }
            tokenIndex = i;
            obj = (new StringBuilder()).append("").append(s3).append("public static class ").append(s).append(" extends Pointer {\n").append("    static { Loader.load(); }\n").append("    public ").append(s).append("() { allocate(); }\n").append("    public ").append(s).append("(int size) { allocateArray(size); }\n").append("    public ").append(s).append("(Pointer p) { super(p); }\n").append("    private native void allocate();\n").append("    private native void allocateArray(int size);\n").append("    @Override public ").append(s).append(" position(int position) {\n").append("        return (").append(s).append(")super.position(position);\n").append("    }\n").toString();
            s2 = s;
        }
        Object obj1 = obj;
        if (getToken().match(new Object[] {
    Character.valueOf('{')
}))
        {
            nextToken();
            obj1 = obj;
        }
        while (!getToken().match(new Object[] {
            Token.EOF, Character.valueOf('}')
        })) 
        {
            obj1 = (new StringBuilder()).append(((String) (obj1))).append(declaration(s2, templatemap)).toString();
        }
        templatemap = ((TemplateMap) (obj1));
        if (flag1)
        {
            obj1 = (new StringBuilder()).append(((String) (obj1))).append(getToken().spacing).append('}').toString();
            Token token1 = nextToken();
            templatemap = token1;
            if (token1.match(new Object[] {
    Integer.valueOf(5)
}))
            {
                templatemap = nextToken();
            }
            templatemap = (new StringBuilder()).append(((String) (obj1))).append(templatemap.expect(new Object[] {
                Character.valueOf(';')
            }).spacing).toString();
        }
        nextToken();
        return templatemap;
    }

    String macro()
        throws Exception
    {
        if (getToken().match(new Object[] {
            Character.valueOf('#')
        })) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L29:
        return ((String) (obj));
_L2:
        Object obj3;
        String s6;
        int j1;
        s6 = getToken().spacing;
        obj3 = nextToken();
        nextToken();
        j1 = tokenIndex;
        obj = getToken();
_L17:
        if (!((Token) (obj)).match(new Object[] {
            Token.EOF
        }) && !((Token) (obj)).match(new Object[] {
            Integer.valueOf(4)
        }) && ((Token) (obj)).spacing.indexOf('\n') < 0) goto _L4; else goto _L3
_L3:
        String s1;
        Object obj5;
        String s7;
        LinkedList linkedlist;
        int i1;
        i1 = tokenIndex;
        s7 = "";
        if (!((Token) (obj3)).match(new Object[] {
    Token.DEFINE
}) || j1 + 1 >= i1)
        {
            break MISSING_BLOCK_LABEL_1546;
        }
        tokenIndex = j1;
        obj5 = getToken().value;
        obj = nextToken();
        s1 = "";
        linkedlist = infoMap.get(((String) (obj5)));
        if (((Token) (obj)).spacing.length() != 0 || !((Token) (obj)).match(new Object[] {
            Character.valueOf('(')
        })) goto _L6; else goto _L5
_L5:
        Object obj4 = linkedlist.iterator();
_L10:
        obj = s1;
        if (!((Iterator) (obj4)).hasNext()) goto _L8; else goto _L7
_L7:
        obj5 = (Info)((Iterator) (obj4)).next();
        if (((Info) (obj5)).genericTypes == null || ((Info) (obj5)).genericTypes.length == 0) goto _L10; else goto _L9
_L9:
        int i;
        i = 1;
        tokenIndex = j1 + 2;
        obj = "(";
        obj3 = getToken();
_L16:
        Object obj1;
        int k;
        k = i;
        obj1 = obj;
        if (tokenIndex >= i1) goto _L12; else goto _L11
_L11:
        k = i;
        obj1 = obj;
        if (i >= ((Info) (obj5)).genericTypes.length) goto _L12; else goto _L13
_L13:
        if (!((Token) (obj3)).match(new Object[] {
            Integer.valueOf(5)
        })) goto _L15; else goto _L14
_L14:
        String s3 = ((Info) (obj5)).genericTypes[i];
        obj3 = ((Token) (obj3)).value;
        obj1 = obj3;
        if (((String) (obj3)).equals("..."))
        {
            obj1 = (new StringBuilder()).append("arg").append(i).toString();
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(s3).append(" ").append(((String) (obj1))).toString();
        i++;
        k = i;
        obj1 = obj;
        if (i < ((Info) (obj5)).genericTypes.length)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append(", ").toString();
            k = i;
        }
_L19:
        obj3 = nextToken();
        i = k;
        obj = obj1;
          goto _L16
_L4:
        obj = nextToken(false);
          goto _L17
_L15:
        k = i;
        obj1 = obj;
        if (!((Token) (obj3)).match(new Object[] {
            Character.valueOf(')')
        })) goto _L19; else goto _L18
_L18:
        obj1 = obj;
        k = i;
_L12:
        do
        {
            if (k >= ((Info) (obj5)).genericTypes.length)
            {
                break;
            }
            obj = ((Info) (obj5)).genericTypes[k];
            obj3 = (new StringBuilder()).append("arg").append(k).toString();
            obj = (new StringBuilder()).append(((String) (obj1))).append(((String) (obj))).append(" ").append(((String) (obj3))).toString();
            i = k + 1;
            k = i;
            obj1 = obj;
            if (i < ((Info) (obj5)).genericTypes.length)
            {
                obj1 = (new StringBuilder()).append(((String) (obj))).append(", ").toString();
                k = i;
            }
        } while (true);
        obj3 = (new StringBuilder()).append(((String) (obj1))).append(")").toString();
        String s4 = ((Info) (obj5)).genericTypes[0];
        if (((Info) (obj5)).javaNames == null)
        {
            obj = ((Info) (obj5)).cppNames[0];
        } else
        {
            obj = ((Info) (obj5)).javaNames[0];
        }
        obj1 = obj;
        if (!((String) (obj)).equals(((Info) (obj5)).cppNames[0]))
        {
            obj1 = (new StringBuilder()).append("@Name(\"").append(((Info) (obj5)).cppNames[0]).append("\") ").append(((String) (obj))).toString();
        }
        s1 = (new StringBuilder()).append(s1).append("public static native ").append(s4).append(" ").append(((String) (obj1))).append(((String) (obj3))).append(";\n").toString();
          goto _L10
_L6:
        if (linkedlist.size() == 0 || ((Info)linkedlist.getFirst()).genericTypes == null) goto _L21; else goto _L20
_L20:
        obj = s1;
        if (((Info)linkedlist.getFirst()).genericTypes.length <= 0) goto _L8; else goto _L21
_L21:
        String s5;
        Object obj6;
        String s8;
        s5 = "";
        obj6 = "int";
        s8 = "";
        tokenIndex = j1 + 1;
        obj4 = new Token();
        i = 0;
        obj3 = getToken();
_L24:
        obj1 = s8;
        obj = obj6;
        boolean flag;
        if (tokenIndex < i1)
        {
            if (((Token) (obj3)).match(new Object[] {
    Integer.valueOf(3)
}))
            {
                obj = "String";
                obj1 = " + ";
            } else
            if (((Token) (obj3)).match(new Object[] {
    Integer.valueOf(2)
}))
            {
                obj = "double";
                obj1 = "";
            } else
            {
label0:
                {
                    if (!((Token) (obj3)).match(new Object[] {
    Integer.valueOf(1)
}) || !((Token) (obj3)).value.endsWith("L"))
                    {
                        break label0;
                    }
                    obj = "long";
                    obj1 = "";
                }
            }
        }
        flag = i;
        obj3 = obj;
        if (linkedlist.size() > 0)
        {
            obj6 = (Info)linkedlist.getFirst();
            if (((Info) (obj6)).genericTypes != null)
            {
                obj = ((Info) (obj6)).genericTypes[0];
            }
            obj4 = ((Info) (obj6)).cppNames[0];
            if (((Info) (obj6)).javaNames != null)
            {
                obj4 = ((Info) (obj6)).javaNames[0];
            }
            flag = i;
            obj5 = obj4;
            obj3 = obj;
            if (((Info) (obj6)).complex)
            {
                flag = true;
                obj3 = obj;
                obj5 = obj4;
            }
        }
        tokenIndex = j1 + 1;
        if (!flag) goto _L23; else goto _L22
_L22:
        s5 = (new StringBuilder()).append("").append("public static native @MemberGetter ").append(((String) (obj3))).append(" ").append(((String) (obj5))).append("();\n").toString();
        obj4 = (new StringBuilder()).append(" ").append(((String) (obj5))).append("()").toString();
_L26:
        i = ((String) (obj3)).lastIndexOf(' ');
        obj = obj3;
        if (i > 0)
        {
            obj = ((String) (obj3)).substring(i + 1);
        }
        obj = (new StringBuilder()).append(s5).append("public static final ").append(((String) (obj))).append(" ").append(((String) (obj5))).append(" =").append(((String) (obj4))).append(";\n").toString();
_L8:
        tokenIndex = i1;
        s1 = commentAfter();
        obj1 = obj;
        if (s1.length() > 0)
        {
            obj1 = (new StringBuilder()).append(s1).append("\n").append(((String) (obj))).toString();
        }
        obj3 = new Scanner(((String) (obj1)));
        obj1 = s7;
        s1 = s6;
        do
        {
            obj = obj1;
            if (!((Scanner) (obj3)).hasNextLine())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (new StringBuilder()).append(((String) (obj1))).append(s1).append(((Scanner) (obj3)).nextLine()).toString();
            i = s1.lastIndexOf('\n');
            obj1 = obj;
            if (i > 0)
            {
                s1 = s1.substring(i);
                obj1 = obj;
            }
        } while (true);
        if (((Token) (obj4)).match(new Object[] {
    Integer.valueOf(5)
}) && ((Token) (obj3)).match(new Object[] {
    Character.valueOf('(')
}) || ((Token) (obj3)).match(new Object[] {
    Character.valueOf('{'), Character.valueOf('}')
}))
        {
            i = 1;
        }
        obj = nextToken();
        obj4 = obj3;
        obj3 = obj;
          goto _L24
_L23:
        obj6 = getToken();
        obj = s5;
_L27:
        s5 = s1;
        obj4 = obj;
        if (tokenIndex >= i1) goto _L26; else goto _L25
_L25:
        StringBuilder stringbuilder = (new StringBuilder()).append(((String) (obj))).append(((Token) (obj6)).spacing).append(obj6);
        if (tokenIndex < i1)
        {
            obj = obj1;
        } else
        {
            obj = "";
        }
        obj = stringbuilder.append(((String) (obj))).toString();
        obj6 = nextToken();
          goto _L27
        if (!((Token) (obj3)).match(new Object[] {
    Token.IF, Token.IFDEF, Token.IFNDEF, Token.ELIF
}) || j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        tokenIndex = j1;
        obj = "";
        for (Token token = getToken(); tokenIndex < i1; token = nextToken())
        {
            obj = (new StringBuilder()).append(((String) (obj))).append(token.spacing).append(token).toString();
        }

        String s2 = (new StringBuilder()).append(s6).append("// #").append(obj3).append(((String) (obj))).toString();
        obj = infoMap.get(((String) (obj)));
        boolean flag1 = true;
        if (((LinkedList) (obj)).size() > 0)
        {
            obj = (Info)((LinkedList) (obj)).getFirst();
            if (((Token) (obj3)).match(new Object[] {
    Token.IFNDEF
}))
            {
                if (!((Info) (obj)).define)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            {
                flag1 = ((Info) (obj)).define;
            }
        }
        obj = s2;
        if (!flag1)
        {
            int l = 1;
            Object obj2 = new Token();
            obj = getToken();
            while (!((Token) (obj)).match(new Object[] {
                Token.EOF
            }) && l > 0) 
            {
                int j;
                if (((Token) (obj2)).match(new Object[] {
    Character.valueOf('#')
}) && ((Token) (obj)).match(new Object[] {
    Token.IF, Token.IFDEF, Token.IFNDEF
}))
                {
                    j = l + 1;
                } else
                {
                    j = l;
                    if (((Token) (obj2)).match(new Object[] {
    Character.valueOf('#')
}))
                    {
                        j = l;
                        if (((Token) (obj)).match(new Object[] {
    Token.ELIF, Token.ELSE, Token.ENDIF
}))
                        {
                            j = l - 1;
                        }
                    }
                }
                obj3 = nextToken(false);
                l = j;
                obj2 = obj;
                obj = obj3;
            }
            tokenIndex = tokenIndex - 2;
            return s2;
        }
        if (true) goto _L29; else goto _L28
_L28:
        tokenIndex = j1;
        String s = (new StringBuilder()).append(s6).append("// #").append(obj3).toString();
        Token token1 = getToken();
        do
        {
            obj = s;
            if (tokenIndex >= i1)
            {
                continue;
            }
            s = (new StringBuilder()).append(s).append(token1.spacing).append(token1).toString();
            token1 = nextToken();
        } while (true);
        if (true) goto _L29; else goto _L30
_L30:
    }

    Token nextToken()
    {
        return nextToken(true);
    }

    Token nextToken(boolean flag)
    {
        for (tokenIndex = tokenIndex + 1; flag && getToken().match(new Object[] {
    Integer.valueOf(4)
}); tokenIndex = tokenIndex + 1) { }
        return getToken();
    }

    Parameters parameters(TemplateMap templatemap, int i)
        throws Exception
    {
        if (getToken().match(new Object[] {
            Character.valueOf('(')
        })) goto _L2; else goto _L1
_L1:
        Parameters parameters1 = null;
_L4:
        return parameters1;
_L2:
        Object obj;
        Parameters parameters2;
        int k;
        k = 0;
        parameters2 = new Parameters();
        parameters2.list = "(";
        obj = nextToken();
_L5:
        parameters1 = parameters2;
        if (((Token) (obj)).match(new Object[] {
            Token.EOF
        })) goto _L4; else goto _L3
_L3:
        Declarator declarator1;
        int j;
        String s = ((Token) (obj)).spacing;
        if (((Token) (obj)).match(new Object[] {
    Character.valueOf(')')
}))
        {
            parameters2.list = (new StringBuilder()).append(parameters2.list).append(s).append(")").toString();
            nextToken();
            return parameters2;
        }
        obj = (new StringBuilder()).append("arg");
        j = k + 1;
        declarator1 = declarator(templatemap, ((StringBuilder) (obj)).append(k).toString(), i, 0, true, false);
        if (declarator1 == null || declarator1.javaType.equals("void"))
        {
            break MISSING_BLOCK_LABEL_504;
        }
        parameters2.infoNumber = Math.max(parameters2.infoNumber, declarator1.infoNumber);
        StringBuilder stringbuilder = (new StringBuilder()).append(parameters2.list);
        int l;
        if (j > 1)
        {
            obj = ",";
        } else
        {
            obj = "";
        }
        parameters2.list = stringbuilder.append(((String) (obj))).append(s).append(declarator1.annotations).append(declarator1.javaType).append(" ").append(declarator1.objectName).toString();
        parameters2.definitions = (new StringBuilder()).append(parameters2.definitions).append(declarator1.definitions).toString();
        parameters2.signature = (new StringBuilder()).append(parameters2.signature).append('_').toString();
        obj = declarator1.javaType.substring(declarator1.javaType.lastIndexOf(' ') + 1).toCharArray();
        l = obj.length;
        for (k = 0; k < l; k++)
        {
            char c = obj[k];
            if (Character.isDigit(c) || Character.isLetter(c) || c == '_')
            {
                parameters2.signature = (new StringBuilder()).append(parameters2.signature).append(c).toString();
            }
        }

        if (!declarator1.objectName.startsWith("arg"))
        {
            break MISSING_BLOCK_LABEL_504;
        }
        k = Integer.parseInt(declarator1.objectName.substring(3));
        j = k + 1;
_L6:
        if (getToken().expect(new Object[] {
    Character.valueOf(','), Character.valueOf(')')
}).match(new Object[] {
    Character.valueOf(',')
}))
        {
            nextToken();
        }
        obj = getToken();
        k = j;
          goto _L5
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L6
    }

    public File parse(File file, Class class1)
        throws IOException, Exception
    {
        Object obj1 = Loader.loadProperties(class1, properties, true);
        Object obj = Loader.loadProperties(class1, properties, false);
        LinkedList linkedlist1 = ((Loader.ClassProperties) (obj1)).getHeaderFiles();
        LinkedList linkedlist = ((Loader.ClassProperties) (obj)).getHeaderFiles();
        LinkedList linkedlist2 = ((Loader.ClassProperties) (obj1)).get("parser.target");
        String s = (String)((Loader.ClassProperties) (obj)).get("parser.target").getFirst();
        obj = "/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */\n\n";
        int i = s.lastIndexOf('.');
        if (i > 0)
        {
            obj = (new StringBuilder()).append("/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */\n\n").append("package ").append(s.substring(0, i)).append(";\n\n").toString();
        }
        obj = (new StringBuilder()).append(((String) (obj))).append("import com.googlecode.javacpp.*;\nimport com.googlecode.javacpp.annotation.*;\nimport java.nio.*;\n\n").toString();
        obj1 = linkedlist2.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            String s1 = (String)((Iterator) (obj1)).next();
            if (!s.equals(s1))
            {
                obj = (new StringBuilder()).append(((String) (obj))).append("import static ").append(s1).append(".*;\n").toString();
            }
        } while (true);
        obj1 = obj;
        if (linkedlist2.size() > 1)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("\n").toString();
        }
        class1 = (new StringBuilder()).append(((String) (obj1))).append("public class ").append(s.substring(i + 1)).append(" extends ").append(class1.getCanonicalName()).append(" ").toString();
        infoMap.put((new Info()).textBefore(class1));
        file = new File(file, (new StringBuilder()).append(s.replace('.', '/')).append(".java").toString());
        System.out.println((new StringBuilder()).append("Targeting file: ").append(file).toString());
        class1 = linkedlist1.iterator();
        do
        {
            if (!class1.hasNext())
            {
                break;
            }
            File file1 = (File)class1.next();
            if (!linkedlist.contains(file1))
            {
                parse(((File) (null)), new File[] {
                    file1
                });
            }
        } while (true);
        parse(file, (File[])linkedlist.toArray(new File[linkedlist.size()]));
        return file;
    }

    public File parse(String s, Class class1)
        throws IOException, Exception
    {
        return parse(new File(s), class1);
    }

    public transient void parse(File file, File afile[])
        throws IOException, Exception
    {
        ArrayList arraylist = new ArrayList();
        Object obj = "\n";
        int j = afile.length;
        for (int i = 0; i < j;)
        {
            Object obj1 = afile[i];
            System.out.println((new StringBuilder()).append("Parsing header file: ").append(obj1).toString());
            Object obj2 = new Token();
            obj2.type = 4;
            obj2.value = (new StringBuilder()).append("\n/* Wrapper for header file ").append(obj1).append(" */\n\n").toString();
            arraylist.add(obj2);
            obj2 = new Tokenizer(((File) (obj1)));
            do
            {
                obj1 = ((Tokenizer) (obj2)).nextToken();
                if (((Token) (obj1)).isEmpty())
                {
                    break;
                }
                if (((Token) (obj1)).type == -1)
                {
                    obj1.type = 4;
                }
                arraylist.add(obj1);
            } while (true);
            obj1 = obj;
            if (obj == null)
            {
                obj1 = ((Tokenizer) (obj2)).lineSeparator;
            }
            ((Tokenizer) (obj2)).close();
            obj = new Token();
            obj.type = 4;
            obj.spacing = "\n";
            arraylist.add(obj);
            i++;
            obj = obj1;
        }

        tokenArray = (Token[])arraylist.toArray(new Token[arraylist.size()]);
        tokenIndex = 0;
        Iterator iterator;
        if (file != null)
        {
            file = new FileWriter(file);
        } else
        {
            file = new Writer() {

                final Parser this$0;

                public void close()
                {
                }

                public void flush()
                {
                }

                public void write(char ac[], int k, int l)
                {
                }

            
            {
                this$0 = Parser.this;
                super();
            }
            };
        }
        afile = infoMap.get(null);
        iterator = afile.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Info info1 = (Info)iterator.next();
            if (info1.textBefore != null)
            {
                file.append(info1.textBefore.replaceAll("\n", ((String) (obj))));
            }
        } while (true);
        file.append((new StringBuilder()).append("{").append(((String) (obj))).toString());
        file.append((new StringBuilder()).append("    static { Loader.load(); }").append(((String) (obj))).toString());
        afile = afile.iterator();
        do
        {
            if (!afile.hasNext())
            {
                break;
            }
            Info info = (Info)afile.next();
            if (info.textAfter != null)
            {
                file.append(info.textAfter.replaceAll("\n", ((String) (obj))));
            }
        } while (true);
        for (; !getToken().match(new Object[] {
    Token.EOF
}); file.append(declaration(null, null).replaceAll("\n", ((String) (obj))))) { }
        afile = commentBefore();
        if (afile != null)
        {
            file.append(afile.replaceAll("\n", ((String) (obj))));
        }
        file.append((new StringBuilder()).append(((String) (obj))).append("}").append(((String) (obj))).toString());
        file.close();
    }

    public transient void parse(String s, String as[])
        throws IOException, Exception
    {
        File afile[] = new File[as.length];
        for (int i = 0; i < afile.length; i++)
        {
            afile[i] = new File(as[i]);
        }

        parse(new File(s), afile);
    }

    TemplateMap template(TemplateMap templatemap)
        throws Exception
    {
        if (!getToken().match(new Object[] {
    Token.TEMPLATE
}))
        {
            return templatemap;
        }
        TemplateMap templatemap1 = new TemplateMap(templatemap);
        nextToken().expect(new Object[] {
            Character.valueOf('<')
        });
        templatemap = nextToken();
        do
        {
label0:
            {
                if (!templatemap.match(new Object[] {
    Token.EOF
}))
                {
                    if (templatemap.match(new Object[] {
    Token.CLASS, Token.TYPENAME
}))
                    {
                        templatemap1.put(nextToken().expect(new Object[] {
                            Integer.valueOf(5)
                        }).value, null);
                    }
                    if (!nextToken().expect(new Object[] {
    Character.valueOf(','), Character.valueOf('>')
}).match(new Object[] {
    Character.valueOf('>')
}))
                    {
                        break label0;
                    }
                    nextToken();
                }
                return templatemap1;
            }
            templatemap = nextToken();
        } while (true);
    }

    String typedef()
        throws Exception
    {
        if (getToken().match(new Object[] {
            Token.TYPEDEF
        })) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return ((String) (obj1));
_L2:
        String s = getToken().spacing;
        obj1 = declarator(null, null, 0, 0, false, false);
        nextToken();
        Object obj = infoMap.get(((Declarator) (obj1)).cppType);
        Object obj2;
        int i;
        if (((LinkedList) (obj)).size() > 0)
        {
            obj = ((Info)((LinkedList) (obj)).getFirst()).clone();
        } else
        {
            obj = new Info();
        }
        infoMap.put(((Info) (obj)).cppNames(new String[] {
            ((Declarator) (obj1)).objectName
        }).cast(true));
        obj = "";
        obj2 = commentAfter();
        if (((String) (obj2)).length() > 0)
        {
            obj = (new StringBuilder()).append(((String) (obj2))).append("\n").append("").toString();
        }
        obj2 = new Scanner(((Declarator) (obj1)).definitions);
        obj1 = obj;
        if (((Scanner) (obj2)).hasNextLine())
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append(s).append(((Scanner) (obj2)).nextLine()).toString();
            i = s.lastIndexOf('\n');
            obj = obj1;
            if (i > 0)
            {
                s = s.substring(i);
                obj = obj1;
            }
            break MISSING_BLOCK_LABEL_162;
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
    }

    String variable(String s)
        throws Exception
    {
        String s4;
        int l;
        l = tokenIndex;
        s4 = getToken().spacing;
        if (declarator(null, null, 0, 0, false, true).objectName != null && getToken().match(new Object[] {
            Character.valueOf('['), Character.valueOf('='), Character.valueOf(','), Character.valueOf(':'), Character.valueOf(';')
        })) goto _L2; else goto _L1
_L1:
        Object obj1;
        tokenIndex = l;
        obj1 = null;
_L4:
        return ((String) (obj1));
_L2:
        String s5 = "";
        Object obj = "";
        Object obj2 = "";
        int i = 0;
label0:
        do
        {
            Declarator declarator1;
label1:
            {
                if (i < 0x7fffffff)
                {
                    tokenIndex = l;
                    declarator1 = declarator(null, null, -1, i, false, true);
                    if (declarator1 != null)
                    {
                        break label1;
                    }
                }
                s = commentAfter();
                obj1 = obj;
                if (s.length() > 0)
                {
                    obj1 = (new StringBuilder()).append(s).append("\n").append(((String) (obj))).toString();
                }
                Scanner scanner = new Scanner(((String) (obj2)));
                obj = s5;
                s = s4;
                do
                {
                    if (!scanner.hasNextLine())
                    {
                        break;
                    }
                    obj2 = (new StringBuilder()).append(((String) (obj))).append(s).append(scanner.nextLine()).toString();
                    i = s.lastIndexOf('\n');
                    obj = obj2;
                    if (i > 0)
                    {
                        s = s.substring(i);
                        obj = obj2;
                    }
                } while (true);
                break label0;
            }
            String s1;
            String s2;
            String s6;
            if (s == null || s.length() == 0)
            {
                s1 = "public static native ";
            } else
            {
                s1 = "public native ";
            }
            if (s == null || s.length() == 0)
            {
                s2 = "void ";
            } else
            {
                s2 = (new StringBuilder()).append(s).append(" ").toString();
            }
            s6 = declarator1.objectName;
            obj1 = "";
            for (int k = 0; k < declarator1.indices; k++)
            {
                String s3 = ((String) (obj1));
                if (k > 0)
                {
                    s3 = (new StringBuilder()).append(((String) (obj1))).append(", ").toString();
                }
                obj1 = (new StringBuilder()).append(s3).append("int ").append((char)(k + 105)).toString();
            }

            Object obj3 = obj;
            if (declarator1.constValue)
            {
                obj3 = (new StringBuilder()).append(((String) (obj))).append("@MemberGetter ").toString();
            }
            obj3 = (new StringBuilder()).append(((String) (obj3))).append(s1).append(declarator1.annotations).append(declarator1.javaType).append(" ").append(s6).append("(").append(((String) (obj1))).append(");").toString();
            obj = obj3;
            if (!declarator1.constValue)
            {
                obj = obj1;
                if (declarator1.indices > 0)
                {
                    obj = (new StringBuilder()).append(((String) (obj1))).append(", ").toString();
                }
                obj = (new StringBuilder()).append(((String) (obj3))).append(" ").append(s1).append(s2).append(s6).append("(").append(((String) (obj))).append(declarator1.javaType).append(" ").append(s6).append(");").toString();
            }
            obj1 = (new StringBuilder()).append(((String) (obj))).append("\n").toString();
            obj2 = (new StringBuilder()).append(((String) (obj2))).append(declarator1.definitions).toString();
            obj = obj1;
            if (declarator1.indices > 0)
            {
                tokenIndex = l;
                obj = declarator(null, null, -1, i, true, false);
                obj = (new StringBuilder()).append(((String) (obj1))).append("@MemberGetter ").append(s1).append(((Declarator) (obj)).annotations).append(((Declarator) (obj)).javaType).append(" ").append(s6).append("();\n").toString();
            }
            i++;
        } while (true);
        obj2 = new Scanner(((String) (obj1)));
        do
        {
            obj1 = obj;
            if (!((Scanner) (obj2)).hasNextLine())
            {
                continue;
            }
            obj1 = (new StringBuilder()).append(((String) (obj))).append(s).append(((Scanner) (obj2)).nextLine()).toString();
            int j = s.lastIndexOf('\n');
            obj = obj1;
            if (j > 0)
            {
                s = s.substring(j);
                obj = obj1;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
