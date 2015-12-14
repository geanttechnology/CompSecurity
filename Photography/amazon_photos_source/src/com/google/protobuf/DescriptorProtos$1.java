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
        criptor _tmp = DescriptorProtos.access$21602(criptor);
        tor _tmp1 = DescriptorProtos.access$002((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(0));
        eldAccessorTable _tmp2 = DescriptorProtos.access$102(new eldAccessorTable(DescriptorProtos.access$000(), new String[] {
            "File"
        }));
        tor _tmp3 = DescriptorProtos.access$702((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(1));
        eldAccessorTable _tmp4 = DescriptorProtos.access$802(new eldAccessorTable(DescriptorProtos.access$700(), new String[] {
            "Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", 
            "SourceCodeInfo"
        }));
        tor _tmp5 = DescriptorProtos.access$2502((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(2));
        eldAccessorTable _tmp6 = DescriptorProtos.access$2602(new eldAccessorTable(DescriptorProtos.access$2500(), new String[] {
            "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options"
        }));
        tor _tmp7 = DescriptorProtos.access$2802((tor)DescriptorProtos.access$2500().getNestedTypes().get(0));
        eldAccessorTable _tmp8 = DescriptorProtos.access$2902(new eldAccessorTable(DescriptorProtos.access$2800(), new String[] {
            "Start", "End"
        }));
        tor _tmp9 = DescriptorProtos.access$4802((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(3));
        eldAccessorTable _tmp10 = DescriptorProtos.access$4902(new eldAccessorTable(DescriptorProtos.access$4800(), new String[] {
            "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options"
        }));
        tor _tmp11 = DescriptorProtos.access$6302((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(4));
        eldAccessorTable _tmp12 = DescriptorProtos.access$6402(new eldAccessorTable(DescriptorProtos.access$6300(), new String[] {
            "Name", "Value", "Options"
        }));
        tor _tmp13 = DescriptorProtos.access$7302((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(5));
        eldAccessorTable _tmp14 = DescriptorProtos.access$7402(new eldAccessorTable(DescriptorProtos.access$7300(), new String[] {
            "Name", "Number", "Options"
        }));
        tor _tmp15 = DescriptorProtos.access$8302((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(6));
        eldAccessorTable _tmp16 = DescriptorProtos.access$8402(new eldAccessorTable(DescriptorProtos.access$8300(), new String[] {
            "Name", "Method", "Options"
        }));
        tor _tmp17 = DescriptorProtos.access$9302((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(7));
        eldAccessorTable _tmp18 = DescriptorProtos.access$9402(new eldAccessorTable(DescriptorProtos.access$9300(), new String[] {
            "Name", "InputType", "OutputType", "Options"
        }));
        tor _tmp19 = DescriptorProtos.access$10402((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(8));
        eldAccessorTable _tmp20 = DescriptorProtos.access$10502(new eldAccessorTable(DescriptorProtos.access$10400(), new String[] {
            "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption"
        }));
        tor _tmp21 = DescriptorProtos.access$12102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(9));
        eldAccessorTable _tmp22 = DescriptorProtos.access$12202(new eldAccessorTable(DescriptorProtos.access$12100(), new String[] {
            "MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption"
        }));
        tor _tmp23 = DescriptorProtos.access$13102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(10));
        eldAccessorTable _tmp24 = DescriptorProtos.access$13202(new eldAccessorTable(DescriptorProtos.access$13100(), new String[] {
            "Ctype", "Packed", "Lazy", "Deprecated", "ExperimentalMapKey", "Weak", "UninterpretedOption"
        }));
        tor _tmp25 = DescriptorProtos.access$14502((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(11));
        eldAccessorTable _tmp26 = DescriptorProtos.access$14602(new eldAccessorTable(DescriptorProtos.access$14500(), new String[] {
            "AllowAlias", "UninterpretedOption"
        }));
        tor _tmp27 = DescriptorProtos.access$15402((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(12));
        eldAccessorTable _tmp28 = DescriptorProtos.access$15502(new eldAccessorTable(DescriptorProtos.access$15400(), new String[] {
            "UninterpretedOption"
        }));
        tor _tmp29 = DescriptorProtos.access$16102((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(13));
        eldAccessorTable _tmp30 = DescriptorProtos.access$16202(new eldAccessorTable(DescriptorProtos.access$16100(), new String[] {
            "UninterpretedOption"
        }));
        tor _tmp31 = DescriptorProtos.access$16802((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(14));
        eldAccessorTable _tmp32 = DescriptorProtos.access$16902(new eldAccessorTable(DescriptorProtos.access$16800(), new String[] {
            "UninterpretedOption"
        }));
        tor _tmp33 = DescriptorProtos.access$17502((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(15));
        eldAccessorTable _tmp34 = DescriptorProtos.access$17602(new eldAccessorTable(DescriptorProtos.access$17500(), new String[] {
            "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"
        }));
        tor _tmp35 = DescriptorProtos.access$17802((tor)DescriptorProtos.access$17500().getNestedTypes().get(0));
        eldAccessorTable _tmp36 = DescriptorProtos.access$17902(new eldAccessorTable(DescriptorProtos.access$17800(), new String[] {
            "NamePart", "IsExtension"
        }));
        tor _tmp37 = DescriptorProtos.access$19802((tor)DescriptorProtos.getDescriptor().getMessageTypes().get(16));
        eldAccessorTable _tmp38 = DescriptorProtos.access$19902(new eldAccessorTable(DescriptorProtos.access$19800(), new String[] {
            "Location"
        }));
        tor _tmp39 = DescriptorProtos.access$20102((tor)DescriptorProtos.access$19800().getNestedTypes().get(0));
        eldAccessorTable _tmp40 = DescriptorProtos.access$20202(new eldAccessorTable(DescriptorProtos.access$20100(), new String[] {
            "Path", "Span", "LeadingComments", "TrailingComments"
        }));
        return null;
    }

    criptor()
    {
    }
}
