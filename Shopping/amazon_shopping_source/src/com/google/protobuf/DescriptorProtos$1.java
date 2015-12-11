// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.List;

// Referenced classes of package com.google.protobuf:
//            DescriptorProtos, ExtensionRegistry

static final class criptor
    implements criptor.InternalDescriptorAssigner
{

    public ExtensionRegistry assignDescriptors(criptor criptor)
    {
        criptor _tmp = DescriptorProtos.access$20602(criptor);
        tor _tmp1 = DescriptorProtos.access$002((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(0));
        eldAccessorTable _tmp2 = DescriptorProtos.access$102(new eldAccessorTable(DescriptorProtos.access$000(), new String[] {
            "File"
        }, com/google/protobuf/DescriptorProtos$FileDescriptorSet, com/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder));
        tor _tmp3 = DescriptorProtos.access$702((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(1));
        eldAccessorTable _tmp4 = DescriptorProtos.access$802(new eldAccessorTable(DescriptorProtos.access$700(), new String[] {
            "Name", "Package", "Dependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo"
        }, com/google/protobuf/DescriptorProtos$FileDescriptorProto, com/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder));
        tor _tmp5 = DescriptorProtos.access$2302((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(2));
        eldAccessorTable _tmp6 = DescriptorProtos.access$2402(new eldAccessorTable(DescriptorProtos.access$2300(), new String[] {
            "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options"
        }, com/google/protobuf/DescriptorProtos$DescriptorProto, com/google/protobuf/DescriptorProtos$DescriptorProto$Builder));
        tor _tmp7 = DescriptorProtos.access$2502((tor)DescriptorProtos.access$2300().getNestedTypes().get(0));
        eldAccessorTable _tmp8 = DescriptorProtos.access$2602(new eldAccessorTable(DescriptorProtos.access$2500(), new String[] {
            "Start", "End"
        }, com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange, com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder));
        tor _tmp9 = DescriptorProtos.access$4602((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(3));
        eldAccessorTable _tmp10 = DescriptorProtos.access$4702(new eldAccessorTable(DescriptorProtos.access$4600(), new String[] {
            "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options"
        }, com/google/protobuf/DescriptorProtos$FieldDescriptorProto, com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder));
        tor _tmp11 = DescriptorProtos.access$6102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(4));
        eldAccessorTable _tmp12 = DescriptorProtos.access$6202(new eldAccessorTable(DescriptorProtos.access$6100(), new String[] {
            "Name", "Value", "Options"
        }, com/google/protobuf/DescriptorProtos$EnumDescriptorProto, com/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder));
        tor _tmp13 = DescriptorProtos.access$7102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(5));
        eldAccessorTable _tmp14 = DescriptorProtos.access$7202(new eldAccessorTable(DescriptorProtos.access$7100(), new String[] {
            "Name", "Number", "Options"
        }, com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto, com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder));
        tor _tmp15 = DescriptorProtos.access$8102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(6));
        eldAccessorTable _tmp16 = DescriptorProtos.access$8202(new eldAccessorTable(DescriptorProtos.access$8100(), new String[] {
            "Name", "Method", "Options"
        }, com/google/protobuf/DescriptorProtos$ServiceDescriptorProto, com/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder));
        tor _tmp17 = DescriptorProtos.access$9102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(7));
        eldAccessorTable _tmp18 = DescriptorProtos.access$9202(new eldAccessorTable(DescriptorProtos.access$9100(), new String[] {
            "Name", "InputType", "OutputType", "Options"
        }, com/google/protobuf/DescriptorProtos$MethodDescriptorProto, com/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder));
        tor _tmp19 = DescriptorProtos.access$10202((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(8));
        eldAccessorTable _tmp20 = DescriptorProtos.access$10302(new eldAccessorTable(DescriptorProtos.access$10200(), new String[] {
            "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption"
        }, com/google/protobuf/DescriptorProtos$FileOptions, com/google/protobuf/DescriptorProtos$FileOptions$Builder));
        tor _tmp21 = DescriptorProtos.access$11802((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(9));
        eldAccessorTable _tmp22 = DescriptorProtos.access$11902(new eldAccessorTable(DescriptorProtos.access$11800(), new String[] {
            "MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption"
        }, com/google/protobuf/DescriptorProtos$MessageOptions, com/google/protobuf/DescriptorProtos$MessageOptions$Builder));
        tor _tmp23 = DescriptorProtos.access$12802((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(10));
        eldAccessorTable _tmp24 = DescriptorProtos.access$12902(new eldAccessorTable(DescriptorProtos.access$12800(), new String[] {
            "Ctype", "Packed", "Deprecated", "ExperimentalMapKey", "UninterpretedOption"
        }, com/google/protobuf/DescriptorProtos$FieldOptions, com/google/protobuf/DescriptorProtos$FieldOptions$Builder));
        tor _tmp25 = DescriptorProtos.access$14002((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(11));
        eldAccessorTable _tmp26 = DescriptorProtos.access$14102(new eldAccessorTable(DescriptorProtos.access$14000(), new String[] {
            "UninterpretedOption"
        }, com/google/protobuf/DescriptorProtos$EnumOptions, com/google/protobuf/DescriptorProtos$EnumOptions$Builder));
        tor _tmp27 = DescriptorProtos.access$14702((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(12));
        eldAccessorTable _tmp28 = DescriptorProtos.access$14802(new eldAccessorTable(DescriptorProtos.access$14700(), new String[] {
            "UninterpretedOption"
        }, com/google/protobuf/DescriptorProtos$EnumValueOptions, com/google/protobuf/DescriptorProtos$EnumValueOptions$Builder));
        tor _tmp29 = DescriptorProtos.access$15402((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(13));
        eldAccessorTable _tmp30 = DescriptorProtos.access$15502(new eldAccessorTable(DescriptorProtos.access$15400(), new String[] {
            "UninterpretedOption"
        }, com/google/protobuf/DescriptorProtos$ServiceOptions, com/google/protobuf/DescriptorProtos$ServiceOptions$Builder));
        tor _tmp31 = DescriptorProtos.access$16102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(14));
        eldAccessorTable _tmp32 = DescriptorProtos.access$16202(new eldAccessorTable(DescriptorProtos.access$16100(), new String[] {
            "UninterpretedOption"
        }, com/google/protobuf/DescriptorProtos$MethodOptions, com/google/protobuf/DescriptorProtos$MethodOptions$Builder));
        tor _tmp33 = DescriptorProtos.access$16802((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(15));
        eldAccessorTable _tmp34 = DescriptorProtos.access$16902(new eldAccessorTable(DescriptorProtos.access$16800(), new String[] {
            "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"
        }, com/google/protobuf/DescriptorProtos$UninterpretedOption, com/google/protobuf/DescriptorProtos$UninterpretedOption$Builder));
        tor _tmp35 = DescriptorProtos.access$17002((tor)DescriptorProtos.access$16800().getNestedTypes().get(0));
        eldAccessorTable _tmp36 = DescriptorProtos.access$17102(new eldAccessorTable(DescriptorProtos.access$17000(), new String[] {
            "NamePart", "IsExtension"
        }, com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart, com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder));
        tor _tmp37 = DescriptorProtos.access$19102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(16));
        eldAccessorTable _tmp38 = DescriptorProtos.access$19202(new eldAccessorTable(DescriptorProtos.access$19100(), new String[] {
            "Location"
        }, com/google/protobuf/DescriptorProtos$SourceCodeInfo, com/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder));
        tor _tmp39 = DescriptorProtos.access$19302((tor)DescriptorProtos.access$19100().getNestedTypes().get(0));
        eldAccessorTable _tmp40 = DescriptorProtos.access$19402(new eldAccessorTable(DescriptorProtos.access$19300(), new String[] {
            "Path", "Span"
        }, com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location, com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder));
        return null;
    }

    criptor()
    {
    }
}
