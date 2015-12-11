.class public Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;
.super Ljava/lang/Object;
.source "CreatorCollector.java"


# instance fields
.field protected final _beanDesc:Lcom/fasterxml/jackson/databind/BeanDescription;

.field protected _booleanCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

.field protected final _canFixAccess:Z

.field protected _defaultConstructor:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

.field protected _delegateArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

.field protected _delegateCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

.field protected _doubleCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

.field protected _intCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

.field protected _longCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

.field protected _propertyBasedArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

.field protected _propertyBasedCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

.field protected _stringCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/BeanDescription;Z)V
    .locals 1
    .param p1, "beanDesc"    # Lcom/fasterxml/jackson/databind/BeanDescription;
    .param p2, "canFixAccess"    # Z

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_propertyBasedArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    .line 54
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_beanDesc:Lcom/fasterxml/jackson/databind/BeanDescription;

    .line 55
    iput-boolean p2, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_canFixAccess:Z

    .line 56
    return-void
.end method

.method private _fixAccess(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;",
            ">(TT;)TT;"
        }
    .end annotation

    .prologue
    .line 193
    .local p1, "member":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;, "TT;"
    if-eqz p1, :cond_0

    iget-boolean v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_canFixAccess:Z

    if-eqz v0, :cond_0

    .line 194
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;->getAnnotated()Ljava/lang/reflect/AnnotatedElement;

    move-result-object v0

    check-cast v0, Ljava/lang/reflect/Member;

    invoke-static {v0}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->checkAndFixAccess(Ljava/lang/reflect/Member;)V

    .line 196
    :cond_0
    return-object p1
.end method


# virtual methods
.method public addBooleanCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V
    .locals 2
    .param p1, "creator"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .prologue
    .line 139
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_booleanCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    const-string v1, "boolean"

    invoke-virtual {p0, p1, v0, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->verifyNonDup(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_booleanCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 140
    return-void
.end method

.method public addDelegatingCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V
    .locals 2
    .param p1, "creator"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    .param p2, "injectables"    # [Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    const-string v1, "delegate"

    invoke-virtual {p0, p1, v0, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->verifyNonDup(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 146
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    .line 147
    return-void
.end method

.method public addDoubleCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V
    .locals 2
    .param p1, "creator"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .prologue
    .line 136
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_doubleCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    const-string v1, "double"

    invoke-virtual {p0, p1, v0, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->verifyNonDup(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_doubleCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 137
    return-void
.end method

.method public addIntCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V
    .locals 2
    .param p1, "creator"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .prologue
    .line 130
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_intCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    const-string v1, "int"

    invoke-virtual {p0, p1, v0, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->verifyNonDup(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_intCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 131
    return-void
.end method

.method public addLongCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V
    .locals 2
    .param p1, "creator"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .prologue
    .line 133
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_longCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    const-string v1, "long"

    invoke-virtual {p0, p1, v0, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->verifyNonDup(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_longCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 134
    return-void
.end method

.method public addPropertyCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V
    .locals 8
    .param p1, "creator"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    .param p2, "properties"    # [Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    .prologue
    .line 151
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    const-string v6, "property-based"

    invoke-virtual {p0, p1, v5, v6}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->verifyNonDup(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    move-result-object v5

    iput-object v5, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 153
    array-length v5, p2

    const/4 v6, 0x1

    if-le v5, v6, :cond_2

    .line 154
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 155
    .local v3, "names":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    array-length v1, p2

    .local v1, "len":I
    :goto_0
    if-ge v0, v1, :cond_2

    .line 156
    aget-object v5, p2, v0

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->getName()Ljava/lang/String;

    move-result-object v2

    .line 160
    .local v2, "name":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_1

    aget-object v5, p2, v0

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/deser/CreatorProperty;->getInjectableValueId()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 155
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 163
    :cond_1
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    .line 164
    .local v4, "old":Ljava/lang/Integer;
    if-eqz v4, :cond_0

    .line 165
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Duplicate creator property \""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\" (index "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " vs "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ")"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 169
    .end local v0    # "i":I
    .end local v1    # "len":I
    .end local v2    # "name":Ljava/lang/String;
    .end local v3    # "names":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    .end local v4    # "old":Ljava/lang/Integer;
    :cond_2
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_propertyBasedArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    .line 170
    return-void
.end method

.method public addStringCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V
    .locals 2
    .param p1, "creator"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .prologue
    .line 127
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_stringCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    const-string v1, "String"

    invoke-virtual {p0, p1, v0, v1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->verifyNonDup(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_stringCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 128
    return-void
.end method

.method public constructValueInstantiator(Lcom/fasterxml/jackson/databind/DeserializationConfig;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    .locals 11
    .param p1, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;

    .prologue
    .line 60
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_beanDesc:Lcom/fasterxml/jackson/databind/BeanDescription;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/BeanDescription;->getType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;-><init>(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 64
    .local v0, "inst":Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    if-nez v1, :cond_0

    .line 65
    const/4 v3, 0x0

    .line 81
    .local v3, "delegateType":Lcom/fasterxml/jackson/databind/JavaType;
    :goto_0
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_defaultConstructor:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    iget-object v4, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_propertyBasedArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    invoke-virtual/range {v0 .. v6}, Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;->configureFromObjectSettings(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/JavaType;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;)V

    .line 84
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_stringCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;->configureFromStringCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 85
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_intCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;->configureFromIntCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 86
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_longCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;->configureFromLongCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 87
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_doubleCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;->configureFromDoubleCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 88
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_booleanCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;->configureFromBooleanCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V

    .line 89
    return-object v0

    .line 68
    .end local v3    # "delegateType":Lcom/fasterxml/jackson/databind/JavaType;
    :cond_0
    const/4 v9, 0x0

    .line 69
    .local v9, "ix":I
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    if-eqz v1, :cond_1

    .line 70
    const/4 v8, 0x0

    .local v8, "i":I
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    array-length v10, v1

    .local v10, "len":I
    :goto_1
    if-ge v8, v10, :cond_1

    .line 71
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateArgs:[Lcom/fasterxml/jackson/databind/deser/CreatorProperty;

    aget-object v1, v1, v8

    if-nez v1, :cond_2

    .line 72
    move v9, v8

    .line 77
    .end local v8    # "i":I
    .end local v10    # "len":I
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_beanDesc:Lcom/fasterxml/jackson/databind/BeanDescription;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/BeanDescription;->bindingsForBeanType()Lcom/fasterxml/jackson/databind/type/TypeBindings;

    move-result-object v7

    .line 78
    .local v7, "bindings":Lcom/fasterxml/jackson/databind/type/TypeBindings;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_delegateCreator:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    invoke-virtual {v1, v9}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;->getGenericParameterType(I)Ljava/lang/reflect/Type;

    move-result-object v1

    invoke-virtual {v7, v1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->resolveType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v3

    .restart local v3    # "delegateType":Lcom/fasterxml/jackson/databind/JavaType;
    goto :goto_0

    .line 70
    .end local v3    # "delegateType":Lcom/fasterxml/jackson/databind/JavaType;
    .end local v7    # "bindings":Lcom/fasterxml/jackson/databind/type/TypeBindings;
    .restart local v8    # "i":I
    .restart local v10    # "len":I
    :cond_2
    add-int/lit8 v8, v8, 0x1

    goto :goto_1
.end method

.method public hasDefaultCreator()Z
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_defaultConstructor:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setDefaultConstructor(Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;)V
    .locals 1
    .param p1, "ctor"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 103
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_fixAccess(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_defaultConstructor:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 104
    return-void
.end method

.method public setDefaultCreator(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)V
    .locals 1
    .param p1, "creator"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .prologue
    .line 119
    instance-of v0, p1, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;

    if-eqz v0, :cond_0

    .line 120
    check-cast p1, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;

    .end local p1    # "creator":Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->setDefaultConstructor(Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;)V

    .line 124
    :goto_0
    return-void

    .line 123
    .restart local p1    # "creator":Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    :cond_0
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_fixAccess(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_defaultConstructor:Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    goto :goto_0
.end method

.method protected verifyNonDup(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    .locals 3
    .param p1, "newOne"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    .param p2, "oldOne"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    .param p3, "type"    # Ljava/lang/String;

    .prologue
    .line 202
    if-eqz p2, :cond_0

    .line 204
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 205
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Conflicting "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " creators: already had "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", encountered "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 208
    :cond_0
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/deser/impl/CreatorCollector;->_fixAccess(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    return-object v0
.end method
