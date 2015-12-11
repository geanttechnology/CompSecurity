.class public Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
.super Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
.source "CreatorProperty.java"


# instance fields
.field protected final _annotated:Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

.field protected final _creatorIndex:I

.field protected final _injectableValueId:Ljava/lang/Object;


# direct methods
.method protected constructor <init>(Lcom/fasterxml/jackson/databind/deser/CreatorProperty;Lcom/fasterxml/jackson/databind/JsonDeserializer;)V
    .locals 1
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/deser/CreatorProperty;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 81
    .local p2, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;-><init>(Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;Lcom/fasterxml/jackson/databind/JsonDeserializer;)V

    .line 82
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_annotated:Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_annotated:Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    .line 83
    iget v0, p1, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_creatorIndex:I

    iput v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_creatorIndex:I

    .line 84
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_injectableValueId:Ljava/lang/Object;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_injectableValueId:Ljava/lang/Object;

    .line 85
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/deser/CreatorProperty;Ljava/lang/String;)V
    .locals 1
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    .param p2, "newName"    # Ljava/lang/String;

    .prologue
    .line 74
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;-><init>(Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;Ljava/lang/String;)V

    .line 75
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_annotated:Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_annotated:Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    .line 76
    iget v0, p1, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_creatorIndex:I

    iput v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_creatorIndex:I

    .line 77
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_injectableValueId:Ljava/lang/Object;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_injectableValueId:Ljava/lang/Object;

    .line 78
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/util/Annotations;Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;ILjava/lang/Object;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p3, "typeDeser"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .param p4, "contextAnnotations"    # Lcom/fasterxml/jackson/databind/util/Annotations;
    .param p5, "param"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    .param p6, "index"    # I
    .param p7, "injectableValueId"    # Ljava/lang/Object;

    .prologue
    .line 67
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/util/Annotations;)V

    .line 68
    iput-object p5, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_annotated:Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    .line 69
    iput p6, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_creatorIndex:I

    .line 70
    iput-object p7, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_injectableValueId:Ljava/lang/Object;

    .line 71
    return-void
.end method


# virtual methods
.method public deserializeAndSet(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;)V
    .locals 1
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "instance"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 150
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p0, p3, v0}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 151
    return-void
.end method

.method public deserializeSetAndReturn(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "instance"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 158
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p0, p3, v0}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->setAndReturn(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getCreatorIndex()I
    .locals 1

    .prologue
    .line 136
    iget v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_creatorIndex:I

    return v0
.end method

.method public getInjectableValueId()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_injectableValueId:Ljava/lang/Object;

    return-object v0
.end method

.method public getMember()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_annotated:Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    return-object v0
.end method

.method public set(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 3
    .param p1, "instance"    # Ljava/lang/Object;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 167
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Method should never be called on a "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setAndReturn(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0
    .param p1, "instance"    # Ljava/lang/Object;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 173
    return-object p1
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 182
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "[creator property, name \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\'; inject id \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->_injectableValueId:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\']"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public withName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    .locals 1
    .param p1, "newName"    # Ljava/lang/String;

    .prologue
    .line 89
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    invoke-direct {v0, p0, p1}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;-><init>(Lcom/fasterxml/jackson/databind/deser/CreatorProperty;Ljava/lang/String;)V

    return-object v0
.end method

.method public bridge synthetic withName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->withName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-result-object v0

    return-object v0
.end method

.method public withValueDeserializer(Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/deser/CreatorProperty;"
        }
    .end annotation

    .prologue
    .line 94
    .local p1, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    invoke-direct {v0, p0, p1}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;-><init>(Lcom/fasterxml/jackson/databind/deser/CreatorProperty;Lcom/fasterxml/jackson/databind/JsonDeserializer;)V

    return-object v0
.end method

.method public bridge synthetic withValueDeserializer(Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    .locals 1
    .param p1, "x0"    # Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .prologue
    .line 28
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->withValueDeserializer(Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    move-result-object v0

    return-object v0
.end method
