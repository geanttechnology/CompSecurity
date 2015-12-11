// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.protobuf:
//            ByteString, WireFormat, UnknownFieldSet, Message

public final class TextFormat
{
    static class InvalidEscapeSequenceException extends IOException
    {

        InvalidEscapeSequenceException(String s)
        {
            super(s);
        }
    }

    private static final class Printer
    {

        final boolean singleLineMode;

        private void print(Message message, TextGenerator textgenerator)
            throws IOException
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = message.getAllFields().entrySet().iterator(); iterator.hasNext(); printField((Descriptors.FieldDescriptor)entry.getKey(), entry.getValue(), textgenerator))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            printUnknownFields(message.getUnknownFields(), textgenerator);
        }

        private void printField(Descriptors.FieldDescriptor fielddescriptor, Object obj, TextGenerator textgenerator)
            throws IOException
        {
            if (fielddescriptor.isRepeated())
            {
                for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); printSingleField(fielddescriptor, ((Iterator) (obj)).next(), textgenerator)) { }
            } else
            {
                printSingleField(fielddescriptor, obj, textgenerator);
            }
        }

        private void printFieldValue(Descriptors.FieldDescriptor fielddescriptor, Object obj, TextGenerator textgenerator)
            throws IOException
        {
            static class _cls1
            {

                static final int $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[];

                static 
                {
                    $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = new int[Descriptors.FieldDescriptor.Type.values().length];
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror17) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror16) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror15) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.google.protobuf.Descriptors.FieldDescriptor.Type[fielddescriptor.getType().ordinal()])
            {
            default:
                return;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                textgenerator.print(((Integer)obj).toString());
                return;

            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
                textgenerator.print(((Long)obj).toString());
                return;

            case 7: // '\007'
                textgenerator.print(((Boolean)obj).toString());
                return;

            case 8: // '\b'
                textgenerator.print(((Float)obj).toString());
                return;

            case 9: // '\t'
                textgenerator.print(((Double)obj).toString());
                return;

            case 10: // '\n'
            case 11: // '\013'
                textgenerator.print(TextFormat.unsignedToString(((Integer)obj).intValue()));
                return;

            case 12: // '\f'
            case 13: // '\r'
                textgenerator.print(TextFormat.unsignedToString(((Long)obj).longValue()));
                return;

            case 14: // '\016'
                textgenerator.print("\"");
                textgenerator.print(TextFormat.escapeText((String)obj));
                textgenerator.print("\"");
                return;

            case 15: // '\017'
                textgenerator.print("\"");
                textgenerator.print(TextFormat.escapeBytes((ByteString)obj));
                textgenerator.print("\"");
                return;

            case 16: // '\020'
                textgenerator.print(((Descriptors.EnumValueDescriptor)obj).getName());
                return;

            case 17: // '\021'
            case 18: // '\022'
                print((Message)obj, textgenerator);
                break;
            }
        }

        private void printSingleField(Descriptors.FieldDescriptor fielddescriptor, Object obj, TextGenerator textgenerator)
            throws IOException
        {
            if (fielddescriptor.isExtension())
            {
                textgenerator.print("[");
                if (fielddescriptor.getContainingType().getOptions().getMessageSetWireFormat() && fielddescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && fielddescriptor.isOptional() && fielddescriptor.getExtensionScope() == fielddescriptor.getMessageType())
                {
                    textgenerator.print(fielddescriptor.getMessageType().getFullName());
                } else
                {
                    textgenerator.print(fielddescriptor.getFullName());
                }
                textgenerator.print("]");
            } else
            if (fielddescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP)
            {
                textgenerator.print(fielddescriptor.getMessageType().getName());
            } else
            {
                textgenerator.print(fielddescriptor.getName());
            }
            if (fielddescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
            {
                if (singleLineMode)
                {
                    textgenerator.print(" { ");
                } else
                {
                    textgenerator.print(" {\n");
                    textgenerator.indent();
                }
            } else
            {
                textgenerator.print(": ");
            }
            printFieldValue(fielddescriptor, obj, textgenerator);
            if (fielddescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
            {
                if (singleLineMode)
                {
                    textgenerator.print("} ");
                    return;
                } else
                {
                    textgenerator.outdent();
                    textgenerator.print("}\n");
                    return;
                }
            }
            if (singleLineMode)
            {
                textgenerator.print(" ");
                return;
            } else
            {
                textgenerator.print("\n");
                return;
            }
        }

        private void printUnknownField(int i, int j, List list, TextGenerator textgenerator)
            throws IOException
        {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                list = ((List) (iterator.next()));
                textgenerator.print(String.valueOf(i));
                textgenerator.print(": ");
                TextFormat.printUnknownFieldValue(j, list, textgenerator);
                if (singleLineMode)
                {
                    list = " ";
                } else
                {
                    list = "\n";
                }
                textgenerator.print(list);
            }
        }

        private void printUnknownFields(UnknownFieldSet unknownfieldset, TextGenerator textgenerator)
            throws IOException
        {
            for (unknownfieldset = unknownfieldset.asMap().entrySet().iterator(); unknownfieldset.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)unknownfieldset.next();
                int i = ((Integer)entry.getKey()).intValue();
                Object obj = (UnknownFieldSet.Field)entry.getValue();
                printUnknownField(i, 0, ((UnknownFieldSet.Field) (obj)).getVarintList(), textgenerator);
                printUnknownField(i, 5, ((UnknownFieldSet.Field) (obj)).getFixed32List(), textgenerator);
                printUnknownField(i, 1, ((UnknownFieldSet.Field) (obj)).getFixed64List(), textgenerator);
                printUnknownField(i, 2, ((UnknownFieldSet.Field) (obj)).getLengthDelimitedList(), textgenerator);
                obj = ((UnknownFieldSet.Field) (obj)).getGroupList().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    UnknownFieldSet unknownfieldset1 = (UnknownFieldSet)((Iterator) (obj)).next();
                    textgenerator.print(((Integer)entry.getKey()).toString());
                    if (singleLineMode)
                    {
                        textgenerator.print(" { ");
                    } else
                    {
                        textgenerator.print(" {\n");
                        textgenerator.indent();
                    }
                    printUnknownFields(unknownfieldset1, textgenerator);
                    if (singleLineMode)
                    {
                        textgenerator.print("} ");
                    } else
                    {
                        textgenerator.outdent();
                        textgenerator.print("}\n");
                    }
                }
            }

        }



        private Printer(boolean flag)
        {
            singleLineMode = flag;
        }

    }

    private static final class TextGenerator
    {

        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;

        private void write(CharSequence charsequence, int i)
            throws IOException
        {
            if (i == 0)
            {
                return;
            }
            if (atStartOfLine)
            {
                atStartOfLine = false;
                output.append(indent);
            }
            output.append(charsequence);
        }

        public void indent()
        {
            indent.append("  ");
        }

        public void outdent()
        {
            int i = indent.length();
            if (i == 0)
            {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            } else
            {
                indent.delete(i - 2, i);
                return;
            }
        }

        public void print(CharSequence charsequence)
            throws IOException
        {
            int j = 0;
            int l = charsequence.length();
            for (int i = 0; i < l;)
            {
                int k = j;
                if (charsequence.charAt(i) == '\n')
                {
                    write(charsequence.subSequence(j, l), (i - j) + 1);
                    k = i + 1;
                    atStartOfLine = true;
                }
                i++;
                j = k;
            }

            write(charsequence.subSequence(j, l), l - j);
        }

        private TextGenerator(Appendable appendable)
        {
            indent = new StringBuilder();
            atStartOfLine = true;
            output = appendable;
        }

    }


    private static final Printer DEFAULT_PRINTER = new Printer(false, null);
    private static final Printer SINGLE_LINE_PRINTER = new Printer(true, null);

    private TextFormat()
    {
    }

    private static int digitValue(byte byte0)
    {
        if (48 <= byte0 && byte0 <= 57)
        {
            return byte0 - 48;
        }
        if (97 <= byte0 && byte0 <= 122)
        {
            return (byte0 - 97) + 10;
        } else
        {
            return (byte0 - 65) + 10;
        }
    }

    static String escapeBytes(ByteString bytestring)
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
label7:
                                    {
label8:
                                        {
label9:
                                            {
                                                stringbuilder = new StringBuilder(bytestring.size());
                                                int i = 0;
label10:
                                                do
                                                {
                                                    {
                                                        if (i >= bytestring.size())
                                                        {
                                                            break label0;
                                                        }
                                                        byte byte0 = bytestring.byteAt(i);
                                                        switch (byte0)
                                                        {
                                                        default:
                                                            if (byte0 >= 32)
                                                            {
                                                                stringbuilder.append((char)byte0);
                                                            } else
                                                            {
                                                                stringbuilder.append('\\');
                                                                stringbuilder.append((char)((byte0 >>> 6 & 3) + 48));
                                                                stringbuilder.append((char)((byte0 >>> 3 & 7) + 48));
                                                                stringbuilder.append((char)((byte0 & 7) + 48));
                                                            }
                                                            break;

                                                        case 7: // '\007'
                                                            break label10;

                                                        case 8: // '\b'
                                                            break label9;

                                                        case 9: // '\t'
                                                            break label5;

                                                        case 10: // '\n'
                                                            break label7;

                                                        case 11: // '\013'
                                                            break label4;

                                                        case 12: // '\f'
                                                            break label8;

                                                        case 13: // '\r'
                                                            break label6;

                                                        case 34: // '"'
                                                            break label1;

                                                        case 39: // '\''
                                                            break label2;

                                                        case 92: // '\\'
                                                            break label3;
                                                        }
                                                    }
                                                    i++;
                                                } while (true);
                                                stringbuilder.append("\\a");
                                                break MISSING_BLOCK_LABEL_133;
                                            }
                                            stringbuilder.append("\\b");
                                            break MISSING_BLOCK_LABEL_133;
                                        }
                                        stringbuilder.append("\\f");
                                        break MISSING_BLOCK_LABEL_133;
                                    }
                                    stringbuilder.append("\\n");
                                    break MISSING_BLOCK_LABEL_133;
                                }
                                stringbuilder.append("\\r");
                                break MISSING_BLOCK_LABEL_133;
                            }
                            stringbuilder.append("\\t");
                            break MISSING_BLOCK_LABEL_133;
                        }
                        stringbuilder.append("\\v");
                        break MISSING_BLOCK_LABEL_133;
                    }
                    stringbuilder.append("\\\\");
                    break MISSING_BLOCK_LABEL_133;
                }
                stringbuilder.append("\\'");
                break MISSING_BLOCK_LABEL_133;
            }
            stringbuilder.append("\\\"");
            break MISSING_BLOCK_LABEL_133;
        }
        return stringbuilder.toString();
    }

    static String escapeText(String s)
    {
        return escapeBytes(ByteString.copyFromUtf8(s));
    }

    private static boolean isHex(byte byte0)
    {
        return 48 <= byte0 && byte0 <= 57 || 97 <= byte0 && byte0 <= 102 || 65 <= byte0 && byte0 <= 70;
    }

    private static boolean isOctal(byte byte0)
    {
        return 48 <= byte0 && byte0 <= 55;
    }

    static int parseInt32(String s)
        throws NumberFormatException
    {
        return (int)parseInteger(s, true, false);
    }

    static long parseInt64(String s)
        throws NumberFormatException
    {
        return parseInteger(s, true, true);
    }

    private static long parseInteger(String s, boolean flag, boolean flag1)
        throws NumberFormatException
    {
label0:
        {
            boolean flag2 = true;
            int i = 0;
            Object obj;
            int j;
            long l1;
            if (s.startsWith("-", 0))
            {
                if (!flag)
                {
                    throw new NumberFormatException((new StringBuilder()).append("Number must be positive: ").append(s).toString());
                }
                i = 1;
            } else
            {
                flag2 = false;
            }
            if (s.startsWith("0x", i))
            {
                j = i + 2;
                i = 16;
            } else
            if (s.startsWith("0", i))
            {
                j = i;
                i = 8;
            } else
            {
                j = i;
                i = 10;
            }
            obj = s.substring(j);
            if (((String) (obj)).length() < 16)
            {
                long l = Long.parseLong(((String) (obj)), i);
                if (flag2)
                {
                    l = -l;
                }
                l1 = l;
                if (flag1)
                {
                    break label0;
                }
                if (flag)
                {
                    if (l <= 0x7fffffffL)
                    {
                        l1 = l;
                        if (l >= 0xffffffff80000000L)
                        {
                            break label0;
                        }
                    }
                    throw new NumberFormatException((new StringBuilder()).append("Number out of range for 32-bit signed integer: ").append(s).toString());
                }
                if (l < 0x100000000L)
                {
                    l1 = l;
                    if (l >= 0L)
                    {
                        break label0;
                    }
                }
                throw new NumberFormatException((new StringBuilder()).append("Number out of range for 32-bit unsigned integer: ").append(s).toString());
            }
            obj = new BigInteger(((String) (obj)), i);
            if (flag2)
            {
                obj = ((BigInteger) (obj)).negate();
            }
            if (!flag1)
            {
                if (flag)
                {
                    if (((BigInteger) (obj)).bitLength() > 31)
                    {
                        throw new NumberFormatException((new StringBuilder()).append("Number out of range for 32-bit signed integer: ").append(s).toString());
                    }
                } else
                if (((BigInteger) (obj)).bitLength() > 32)
                {
                    throw new NumberFormatException((new StringBuilder()).append("Number out of range for 32-bit unsigned integer: ").append(s).toString());
                }
            } else
            if (flag)
            {
                if (((BigInteger) (obj)).bitLength() > 63)
                {
                    throw new NumberFormatException((new StringBuilder()).append("Number out of range for 64-bit signed integer: ").append(s).toString());
                }
            } else
            if (((BigInteger) (obj)).bitLength() > 64)
            {
                throw new NumberFormatException((new StringBuilder()).append("Number out of range for 64-bit unsigned integer: ").append(s).toString());
            }
            l1 = ((BigInteger) (obj)).longValue();
        }
        return l1;
    }

    static int parseUInt32(String s)
        throws NumberFormatException
    {
        return (int)parseInteger(s, false, false);
    }

    static long parseUInt64(String s)
        throws NumberFormatException
    {
        return parseInteger(s, false, true);
    }

    public static void print(Message message, Appendable appendable)
        throws IOException
    {
        DEFAULT_PRINTER.print(message, new TextGenerator(appendable, null));
    }

    public static void print(UnknownFieldSet unknownfieldset, Appendable appendable)
        throws IOException
    {
        DEFAULT_PRINTER.printUnknownFields(unknownfieldset, new TextGenerator(appendable, null));
    }

    public static String printToString(Message message)
    {
        try
        {
            StringBuilder stringbuilder = new StringBuilder();
            print(message, stringbuilder);
            message = stringbuilder.toString();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            throw new IllegalStateException(message);
        }
        return message;
    }

    public static String printToString(UnknownFieldSet unknownfieldset)
    {
        try
        {
            StringBuilder stringbuilder = new StringBuilder();
            print(unknownfieldset, stringbuilder);
            unknownfieldset = stringbuilder.toString();
        }
        // Misplaced declaration of an exception variable
        catch (UnknownFieldSet unknownfieldset)
        {
            throw new IllegalStateException(unknownfieldset);
        }
        return unknownfieldset;
    }

    private static void printUnknownFieldValue(int i, Object obj, TextGenerator textgenerator)
        throws IOException
    {
        switch (WireFormat.getTagWireType(i))
        {
        case 4: // '\004'
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Bad tag: ").append(i).toString());

        case 0: // '\0'
            textgenerator.print(unsignedToString(((Long)obj).longValue()));
            return;

        case 5: // '\005'
            textgenerator.print(String.format((Locale)null, "0x%08x", new Object[] {
                (Integer)obj
            }));
            return;

        case 1: // '\001'
            textgenerator.print(String.format((Locale)null, "0x%016x", new Object[] {
                (Long)obj
            }));
            return;

        case 2: // '\002'
            textgenerator.print("\"");
            textgenerator.print(escapeBytes((ByteString)obj));
            textgenerator.print("\"");
            return;

        case 3: // '\003'
            DEFAULT_PRINTER.printUnknownFields((UnknownFieldSet)obj, textgenerator);
            return;
        }
    }

    static ByteString unescapeBytes(CharSequence charsequence)
        throws InvalidEscapeSequenceException
    {
        byte abyte0[];
        int j;
        int l;
        charsequence = ByteString.copyFromUtf8(charsequence.toString());
        abyte0 = new byte[charsequence.size()];
        j = 0;
        l = 0;
_L9:
        if (j >= charsequence.size()) goto _L2; else goto _L1
_L1:
        byte byte0 = charsequence.byteAt(j);
        if (byte0 != 92) goto _L4; else goto _L3
_L3:
        if (j + 1 >= charsequence.size()) goto _L6; else goto _L5
_L5:
        int k;
        k = j + 1;
        byte0 = charsequence.byteAt(k);
        if (!isOctal(byte0)) goto _L8; else goto _L7
_L7:
        int i;
        int i1 = digitValue(byte0);
        i = i1;
        j = k;
        if (k + 1 < charsequence.size())
        {
            i = i1;
            j = k;
            if (isOctal(charsequence.byteAt(k + 1)))
            {
                j = k + 1;
                i = i1 * 8 + digitValue(charsequence.byteAt(j));
            }
        }
        i1 = i;
        k = j;
        if (j + 1 < charsequence.size())
        {
            i1 = i;
            k = j;
            if (isOctal(charsequence.byteAt(j + 1)))
            {
                k = j + 1;
                i1 = i * 8 + digitValue(charsequence.byteAt(k));
            }
        }
        abyte0[l] = (byte)i1;
        i = l + 1;
        j = k;
_L11:
        j++;
        l = i;
          goto _L9
_L8:
        switch (byte0)
        {
        default:
            throw new InvalidEscapeSequenceException((new StringBuilder()).append("Invalid escape sequence: '\\").append((char)byte0).append('\'').toString());

        case 97: // 'a'
            i = l + 1;
            abyte0[l] = 7;
            j = k;
            break;

        case 98: // 'b'
            i = l + 1;
            abyte0[l] = 8;
            j = k;
            break;

        case 102: // 'f'
            i = l + 1;
            abyte0[l] = 12;
            j = k;
            break;

        case 110: // 'n'
            i = l + 1;
            abyte0[l] = 10;
            j = k;
            break;

        case 114: // 'r'
            i = l + 1;
            abyte0[l] = 13;
            j = k;
            break;

        case 116: // 't'
            i = l + 1;
            abyte0[l] = 9;
            j = k;
            break;

        case 118: // 'v'
            i = l + 1;
            abyte0[l] = 11;
            j = k;
            break;

        case 92: // '\\'
            i = l + 1;
            abyte0[l] = 92;
            j = k;
            break;

        case 39: // '\''
            i = l + 1;
            abyte0[l] = 39;
            j = k;
            break;

        case 34: // '"'
            i = l + 1;
            abyte0[l] = 34;
            j = k;
            break;

        case 120: // 'x'
            if (k + 1 < charsequence.size() && isHex(charsequence.byteAt(k + 1)))
            {
                int j1 = k + 1;
                k = digitValue(charsequence.byteAt(j1));
                i = k;
                j = j1;
                if (j1 + 1 < charsequence.size())
                {
                    i = k;
                    j = j1;
                    if (isHex(charsequence.byteAt(j1 + 1)))
                    {
                        j = j1 + 1;
                        i = k * 16 + digitValue(charsequence.byteAt(j));
                    }
                }
                abyte0[l] = (byte)i;
                i = l + 1;
            } else
            {
                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
_L4:
        abyte0[l] = byte0;
        i = l + 1;
        continue; /* Loop/switch isn't completed */
_L2:
        return ByteString.copyFrom(abyte0, 0, l);
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static String unsignedToString(int i)
    {
        if (i >= 0)
        {
            return Integer.toString(i);
        } else
        {
            return Long.toString((long)i & 0xffffffffL);
        }
    }

    private static String unsignedToString(long l)
    {
        if (l >= 0L)
        {
            return Long.toString(l);
        } else
        {
            return BigInteger.valueOf(0x7fffffffffffffffL & l).setBit(63).toString();
        }
    }




}
