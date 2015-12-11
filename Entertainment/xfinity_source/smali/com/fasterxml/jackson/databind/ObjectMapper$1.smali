.class Lcom/fasterxml/jackson/databind/ObjectMapper$1;
.super Ljava/lang/Object;
.source "ObjectMapper.java"

# interfaces
.implements Lcom/fasterxml/jackson/databind/Module$SetupContext;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/fasterxml/jackson/databind/ObjectMapper;->registerModule(Lcom/fasterxml/jackson/databind/Module;)Lcom/fasterxml/jackson/databind/ObjectMapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field final synthetic val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0

    .prologue
    .line 526
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->this$0:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addAbstractTypeResolver(Lcom/fasterxml/jackson/databind/AbstractTypeResolver;)V
    .locals 3
    .param p1, "resolver"    # Lcom/fasterxml/jackson/databind/AbstractTypeResolver;

    .prologue
    .line 617
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_factory:Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;->withAbstractTypeResolver(Lcom/fasterxml/jackson/databind/AbstractTypeResolver;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    .line 618
    .local v0, "df":Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, v2, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->with(Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    move-result-object v2

    iput-object v2, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    .line 619
    return-void
.end method

.method public addBeanDeserializerModifier(Lcom/fasterxml/jackson/databind/deser/BeanDeserializerModifier;)V
    .locals 3
    .param p1, "modifier"    # Lcom/fasterxml/jackson/databind/deser/BeanDeserializerModifier;

    .prologue
    .line 592
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_factory:Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;->withDeserializerModifier(Lcom/fasterxml/jackson/databind/deser/BeanDeserializerModifier;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    .line 593
    .local v0, "df":Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, v2, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->with(Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    move-result-object v2

    iput-object v2, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    .line 594
    return-void
.end method

.method public addBeanSerializerModifier(Lcom/fasterxml/jackson/databind/ser/BeanSerializerModifier;)V
    .locals 2
    .param p1, "modifier"    # Lcom/fasterxml/jackson/databind/ser/BeanSerializerModifier;

    .prologue
    .line 610
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/ser/SerializerFactory;->withSerializerModifier(Lcom/fasterxml/jackson/databind/ser/BeanSerializerModifier;)Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .line 611
    return-void
.end method

.method public addDeserializationProblemHandler(Lcom/fasterxml/jackson/databind/deser/DeserializationProblemHandler;)V
    .locals 1
    .param p1, "handler"    # Lcom/fasterxml/jackson/databind/deser/DeserializationProblemHandler;

    .prologue
    .line 663
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->addHandler(Lcom/fasterxml/jackson/databind/deser/DeserializationProblemHandler;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 664
    return-void
.end method

.method public addDeserializers(Lcom/fasterxml/jackson/databind/deser/Deserializers;)V
    .locals 3
    .param p1, "d"    # Lcom/fasterxml/jackson/databind/deser/Deserializers;

    .prologue
    .line 580
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_factory:Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;->withAdditionalDeserializers(Lcom/fasterxml/jackson/databind/deser/Deserializers;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    .line 581
    .local v0, "df":Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, v2, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->with(Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    move-result-object v2

    iput-object v2, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    .line 582
    return-void
.end method

.method public addKeyDeserializers(Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;)V
    .locals 3
    .param p1, "d"    # Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;

    .prologue
    .line 586
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_factory:Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;->withAdditionalKeyDeserializers(Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    .line 587
    .local v0, "df":Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, v2, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->with(Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    move-result-object v2

    iput-object v2, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    .line 588
    return-void
.end method

.method public addKeySerializers(Lcom/fasterxml/jackson/databind/ser/Serializers;)V
    .locals 2
    .param p1, "s"    # Lcom/fasterxml/jackson/databind/ser/Serializers;

    .prologue
    .line 605
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/ser/SerializerFactory;->withAdditionalKeySerializers(Lcom/fasterxml/jackson/databind/ser/Serializers;)Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .line 606
    return-void
.end method

.method public addSerializers(Lcom/fasterxml/jackson/databind/ser/Serializers;)V
    .locals 2
    .param p1, "s"    # Lcom/fasterxml/jackson/databind/ser/Serializers;

    .prologue
    .line 600
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/ser/SerializerFactory;->withAdditionalSerializers(Lcom/fasterxml/jackson/databind/ser/Serializers;)Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializerFactory:Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .line 601
    return-void
.end method

.method public addTypeModifier(Lcom/fasterxml/jackson/databind/type/TypeModifier;)V
    .locals 2
    .param p1, "modifier"    # Lcom/fasterxml/jackson/databind/type/TypeModifier;

    .prologue
    .line 623
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v0, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    .line 624
    .local v0, "f":Lcom/fasterxml/jackson/databind/type/TypeFactory;
    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->withModifier(Lcom/fasterxml/jackson/databind/type/TypeModifier;)Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v0

    .line 625
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->setTypeFactory(Lcom/fasterxml/jackson/databind/type/TypeFactory;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 626
    return-void
.end method

.method public addValueInstantiators(Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;)V
    .locals 3
    .param p1, "instantiators"    # Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;

    .prologue
    .line 630
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_factory:Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;->withValueInstantiators(Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;)Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    move-result-object v0

    .line 631
    .local v0, "df":Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, v2, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->with(Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    move-result-object v2

    iput-object v2, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationContext:Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;

    .line 632
    return-void
.end method

.method public appendAnnotationIntrospector(Lcom/fasterxml/jackson/databind/AnnotationIntrospector;)V
    .locals 2
    .param p1, "ai"    # Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    .prologue
    .line 642
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationConfig:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->withAppendedAnnotationIntrospector(Lcom/fasterxml/jackson/databind/AnnotationIntrospector;)Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationConfig:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    .line 643
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializationConfig:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->withAppendedAnnotationIntrospector(Lcom/fasterxml/jackson/databind/AnnotationIntrospector;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializationConfig:Lcom/fasterxml/jackson/databind/SerializationConfig;

    .line 644
    return-void
.end method

.method public getMapperVersion()Lcom/fasterxml/jackson/core/Version;
    .locals 1

    .prologue
    .line 531
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->this$0:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->version()Lcom/fasterxml/jackson/core/Version;

    move-result-object v0

    return-object v0
.end method

.method public getOwner()Lcom/fasterxml/jackson/core/ObjectCodec;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<C:",
            "Lcom/fasterxml/jackson/core/ObjectCodec;",
            ">()TC;"
        }
    .end annotation

    .prologue
    .line 538
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method

.method public getTypeFactory()Lcom/fasterxml/jackson/databind/type/TypeFactory;
    .locals 1

    .prologue
    .line 543
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->this$0:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/ObjectMapper;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    return-object v0
.end method

.method public insertAnnotationIntrospector(Lcom/fasterxml/jackson/databind/AnnotationIntrospector;)V
    .locals 2
    .param p1, "ai"    # Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    .prologue
    .line 636
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationConfig:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->withInsertedAnnotationIntrospector(Lcom/fasterxml/jackson/databind/AnnotationIntrospector;)Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/ObjectMapper;->_deserializationConfig:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    .line 637
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializationConfig:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/databind/SerializationConfig;->withInsertedAnnotationIntrospector(Lcom/fasterxml/jackson/databind/AnnotationIntrospector;)Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/ObjectMapper;->_serializationConfig:Lcom/fasterxml/jackson/databind/SerializationConfig;

    .line 638
    return-void
.end method

.method public isEnabled(Lcom/fasterxml/jackson/core/JsonFactory$Feature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/core/JsonFactory$Feature;

    .prologue
    .line 563
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->isEnabled(Lcom/fasterxml/jackson/core/JsonFactory$Feature;)Z

    move-result v0

    return v0
.end method

.method public isEnabled(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    .prologue
    .line 573
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->isEnabled(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    return v0
.end method

.method public isEnabled(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/core/JsonParser$Feature;

    .prologue
    .line 568
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->isEnabled(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    return v0
.end method

.method public isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/databind/DeserializationFeature;

    .prologue
    .line 553
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v0

    return v0
.end method

.method public isEnabled(Lcom/fasterxml/jackson/databind/MapperFeature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/databind/MapperFeature;

    .prologue
    .line 548
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->isEnabled(Lcom/fasterxml/jackson/databind/MapperFeature;)Z

    move-result v0

    return v0
.end method

.method public isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z
    .locals 1
    .param p1, "f"    # Lcom/fasterxml/jackson/databind/SerializationFeature;

    .prologue
    .line 558
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    return v0
.end method

.method public varargs registerSubtypes([Lcom/fasterxml/jackson/databind/jsontype/NamedType;)V
    .locals 1
    .param p1, "subtypes"    # [Lcom/fasterxml/jackson/databind/jsontype/NamedType;

    .prologue
    .line 653
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->registerSubtypes([Lcom/fasterxml/jackson/databind/jsontype/NamedType;)V

    .line 654
    return-void
.end method

.method public varargs registerSubtypes([Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 648
    .local p1, "subtypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->registerSubtypes([Ljava/lang/Class;)V

    .line 649
    return-void
.end method

.method public setMixInAnnotations(Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 658
    .local p1, "target":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p2, "mixinSource":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ObjectMapper$1;->val$mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1, p2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->addMixInAnnotations(Ljava/lang/Class;Ljava/lang/Class;)V

    .line 659
    return-void
.end method
