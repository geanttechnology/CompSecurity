.class public Lcom/fasterxml/jackson/databind/type/TypeBindings;
.super Ljava/lang/Object;
.source "TypeBindings.java"


# static fields
.field private static final NO_TYPES:[Lcom/fasterxml/jackson/databind/JavaType;

.field public static final UNBOUND:Lcom/fasterxml/jackson/databind/JavaType;


# instance fields
.field protected _bindings:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ">;"
        }
    .end annotation
.end field

.field protected final _contextClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field protected final _contextType:Lcom/fasterxml/jackson/databind/JavaType;

.field private final _parentBindings:Lcom/fasterxml/jackson/databind/type/TypeBindings;

.field protected _placeholders:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected final _typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 13
    const/4 v0, 0x0

    new-array v0, v0, [Lcom/fasterxml/jackson/databind/JavaType;

    sput-object v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->NO_TYPES:[Lcom/fasterxml/jackson/databind/JavaType;

    .line 18
    new-instance v0, Lcom/fasterxml/jackson/databind/type/SimpleType;

    const-class v1, Ljava/lang/Object;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/type/SimpleType;-><init>(Ljava/lang/Class;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->UNBOUND:Lcom/fasterxml/jackson/databind/JavaType;

    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 2
    .param p1, "typeFactory"    # Lcom/fasterxml/jackson/databind/type/TypeFactory;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;

    .prologue
    .line 69
    const/4 v0, 0x0

    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1, p2}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Lcom/fasterxml/jackson/databind/type/TypeBindings;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 70
    return-void
.end method

.method private constructor <init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Lcom/fasterxml/jackson/databind/type/TypeBindings;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 0
    .param p1, "tf"    # Lcom/fasterxml/jackson/databind/type/TypeFactory;
    .param p2, "parent"    # Lcom/fasterxml/jackson/databind/type/TypeBindings;
    .param p4, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/type/TypeFactory;",
            "Lcom/fasterxml/jackson/databind/type/TypeBindings;",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            ")V"
        }
    .end annotation

    .prologue
    .line 84
    .local p3, "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    .line 86
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_parentBindings:Lcom/fasterxml/jackson/databind/type/TypeBindings;

    .line 87
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    .line 88
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 89
    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Ljava/lang/Class;)V
    .locals 1
    .param p1, "typeFactory"    # Lcom/fasterxml/jackson/databind/type/TypeFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/type/TypeFactory;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .local p2, "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x0

    .line 64
    invoke-direct {p0, p1, v0, p2, v0}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Lcom/fasterxml/jackson/databind/type/TypeBindings;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 65
    return-void
.end method


# virtual methods
.method public _addPlaceholder(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 224
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_placeholders:Ljava/util/HashSet;

    if-nez v0, :cond_0

    .line 225
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_placeholders:Ljava/util/HashSet;

    .line 227
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_placeholders:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 228
    return-void
.end method

.method protected _resolve()V
    .locals 5

    .prologue
    .line 203
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    invoke-virtual {p0, v4}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_resolveBindings(Ljava/lang/reflect/Type;)V

    .line 206
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    if-eqz v4, :cond_0

    .line 207
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/JavaType;->containedTypeCount()I

    move-result v0

    .line 208
    .local v0, "count":I
    if-lez v0, :cond_0

    .line 209
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 210
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v4, v1}, Lcom/fasterxml/jackson/databind/JavaType;->containedTypeName(I)Ljava/lang/String;

    move-result-object v2

    .line 211
    .local v2, "name":Ljava/lang/String;
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v4, v1}, Lcom/fasterxml/jackson/databind/JavaType;->containedType(I)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v3

    .line 212
    .local v3, "type":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->addBinding(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 209
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 218
    .end local v0    # "count":I
    .end local v1    # "i":I
    .end local v2    # "name":Ljava/lang/String;
    .end local v3    # "type":Lcom/fasterxml/jackson/databind/JavaType;
    :cond_0
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    if-nez v4, :cond_1

    .line 219
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v4

    iput-object v4, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    .line 221
    :cond_1
    return-void
.end method

.method protected _resolveBindings(Ljava/lang/reflect/Type;)V
    .locals 20
    .param p1, "t"    # Ljava/lang/reflect/Type;

    .prologue
    .line 232
    if-nez p1, :cond_1

    .line 313
    :cond_0
    return-void

    .line 235
    :cond_1
    move-object/from16 v0, p1

    instance-of v0, v0, Ljava/lang/reflect/ParameterizedType;

    move/from16 v17, v0

    if-eqz v17, :cond_7

    move-object/from16 v10, p1

    .line 236
    check-cast v10, Ljava/lang/reflect/ParameterizedType;

    .line 237
    .local v10, "pt":Ljava/lang/reflect/ParameterizedType;
    invoke-interface {v10}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object v2

    .line 238
    .local v2, "args":[Ljava/lang/reflect/Type;
    if-eqz v2, :cond_5

    array-length v0, v2

    move/from16 v17, v0

    if-lez v17, :cond_5

    .line 239
    invoke-interface {v10}, Ljava/lang/reflect/ParameterizedType;->getRawType()Ljava/lang/reflect/Type;

    move-result-object v12

    check-cast v12, Ljava/lang/Class;

    .line 240
    .local v12, "rawType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v12}, Ljava/lang/Class;->getTypeParameters()[Ljava/lang/reflect/TypeVariable;

    move-result-object v16

    .line 241
    .local v16, "vars":[Ljava/lang/reflect/TypeVariable;, "[Ljava/lang/reflect/TypeVariable<*>;"
    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v17, v0

    array-length v0, v2

    move/from16 v18, v0

    move/from16 v0, v17

    move/from16 v1, v18

    if-eq v0, v1, :cond_2

    .line 242
    new-instance v17, Ljava/lang/IllegalArgumentException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Strange parametrized type (in class "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual {v12}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "): number of type arguments != number of type parameters ("

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    array-length v0, v2

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " vs "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, ")"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v17

    .line 244
    :cond_2
    const/4 v4, 0x0

    .local v4, "i":I
    array-length v7, v2

    .local v7, "len":I
    :goto_0
    if-ge v4, v7, :cond_5

    .line 245
    aget-object v14, v16, v4

    .line 246
    .local v14, "var":Ljava/lang/reflect/TypeVariable;, "Ljava/lang/reflect/TypeVariable<*>;"
    invoke-interface {v14}, Ljava/lang/reflect/TypeVariable;->getName()Ljava/lang/String;

    move-result-object v9

    .line 247
    .local v9, "name":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    move-object/from16 v17, v0

    if-nez v17, :cond_4

    .line 248
    new-instance v17, Ljava/util/LinkedHashMap;

    invoke-direct/range {v17 .. v17}, Ljava/util/LinkedHashMap;-><init>()V

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    .line 256
    :cond_3
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_addPlaceholder(Ljava/lang/String;)V

    .line 258
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-object/from16 v18, v0

    aget-object v19, v2, v4

    invoke-virtual/range {v18 .. v20}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-interface {v0, v9, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 244
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 253
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v9}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_3

    goto :goto_1

    .line 261
    .end local v4    # "i":I
    .end local v7    # "len":I
    .end local v9    # "name":Ljava/lang/String;
    .end local v12    # "rawType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v14    # "var":Ljava/lang/reflect/TypeVariable;, "Ljava/lang/reflect/TypeVariable<*>;"
    .end local v16    # "vars":[Ljava/lang/reflect/TypeVariable;, "[Ljava/lang/reflect/TypeVariable<*>;"
    :cond_5
    invoke-interface {v10}, Ljava/lang/reflect/ParameterizedType;->getRawType()Ljava/lang/reflect/Type;

    move-result-object v11

    check-cast v11, Ljava/lang/Class;

    .line 309
    .end local v2    # "args":[Ljava/lang/reflect/Type;
    .end local v10    # "pt":Ljava/lang/reflect/ParameterizedType;
    .local v11, "raw":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_6
    invoke-virtual {v11}, Ljava/lang/Class;->getGenericSuperclass()Ljava/lang/reflect/Type;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_resolveBindings(Ljava/lang/reflect/Type;)V

    .line 310
    invoke-virtual {v11}, Ljava/lang/Class;->getGenericInterfaces()[Ljava/lang/reflect/Type;

    move-result-object v3

    .local v3, "arr$":[Ljava/lang/reflect/Type;
    array-length v8, v3

    .local v8, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_2
    if-ge v5, v8, :cond_0

    aget-object v6, v3, v5

    .line 311
    .local v6, "intType":Ljava/lang/reflect/Type;
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_resolveBindings(Ljava/lang/reflect/Type;)V

    .line 310
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 262
    .end local v3    # "arr$":[Ljava/lang/reflect/Type;
    .end local v5    # "i$":I
    .end local v6    # "intType":Ljava/lang/reflect/Type;
    .end local v8    # "len$":I
    .end local v11    # "raw":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_7
    move-object/from16 v0, p1

    instance-of v0, v0, Ljava/lang/Class;

    move/from16 v17, v0

    if-eqz v17, :cond_0

    move-object/from16 v11, p1

    .line 263
    check-cast v11, Ljava/lang/Class;

    .line 269
    .restart local v11    # "raw":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v11}, Ljava/lang/Class;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_resolveBindings(Ljava/lang/reflect/Type;)V

    .line 273
    invoke-virtual {v11}, Ljava/lang/Class;->getTypeParameters()[Ljava/lang/reflect/TypeVariable;

    move-result-object v16

    .line 274
    .restart local v16    # "vars":[Ljava/lang/reflect/TypeVariable;, "[Ljava/lang/reflect/TypeVariable<*>;"
    if-eqz v16, :cond_6

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v17, v0

    if-lez v17, :cond_6

    .line 275
    const/4 v13, 0x0

    .line 277
    .local v13, "typeParams":[Lcom/fasterxml/jackson/databind/JavaType;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    move-object/from16 v17, v0

    if-eqz v17, :cond_8

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v17

    if-eqz v17, :cond_8

    .line 278
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v11}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->findTypeParameters(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)[Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v13

    .line 281
    :cond_8
    const/4 v4, 0x0

    .restart local v4    # "i":I
    :goto_3
    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v4, v0, :cond_6

    .line 282
    aget-object v14, v16, v4

    .line 284
    .restart local v14    # "var":Ljava/lang/reflect/TypeVariable;, "Ljava/lang/reflect/TypeVariable<*>;"
    invoke-interface {v14}, Ljava/lang/reflect/TypeVariable;->getName()Ljava/lang/String;

    move-result-object v9

    .line 285
    .restart local v9    # "name":Ljava/lang/String;
    invoke-interface {v14}, Ljava/lang/reflect/TypeVariable;->getBounds()[Ljava/lang/reflect/Type;

    move-result-object v17

    const/16 v18, 0x0

    aget-object v15, v17, v18

    .line 286
    .local v15, "varType":Ljava/lang/reflect/Type;
    if-eqz v15, :cond_a

    .line 287
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    move-object/from16 v17, v0

    if-nez v17, :cond_b

    .line 288
    new-instance v17, Ljava/util/LinkedHashMap;

    invoke-direct/range {v17 .. v17}, Ljava/util/LinkedHashMap;-><init>()V

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    .line 292
    :cond_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_addPlaceholder(Ljava/lang/String;)V

    .line 294
    if-eqz v13, :cond_c

    .line 295
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    move-object/from16 v17, v0

    aget-object v18, v13, v4

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-interface {v0, v9, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    :cond_a
    :goto_4
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 290
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v9}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_9

    goto :goto_4

    .line 297
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-virtual {v0, v15, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-interface {v0, v9, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4
.end method

.method public addBinding(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;

    .prologue
    .line 178
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 179
    :cond_0
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    .line 181
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    return-void
.end method

.method public childInstance()Lcom/fasterxml/jackson/databind/type/TypeBindings;
    .locals 4

    .prologue
    .line 79
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-direct {v0, v1, p0, v2, v3}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Lcom/fasterxml/jackson/databind/type/TypeBindings;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;)V

    return-object v0
.end method

.method public findType(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 120
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    if-nez v3, :cond_0

    .line 121
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_resolve()V

    .line 123
    :cond_0
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/fasterxml/jackson/databind/JavaType;

    .line 124
    .local v2, "t":Lcom/fasterxml/jackson/databind/JavaType;
    if-eqz v2, :cond_1

    .line 146
    .end local v2    # "t":Lcom/fasterxml/jackson/databind/JavaType;
    :goto_0
    return-object v2

    .line 127
    .restart local v2    # "t":Lcom/fasterxml/jackson/databind/JavaType;
    :cond_1
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_placeholders:Ljava/util/HashSet;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_placeholders:Ljava/util/HashSet;

    invoke-virtual {v3, p1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 128
    sget-object v2, Lcom/fasterxml/jackson/databind/type/TypeBindings;->UNBOUND:Lcom/fasterxml/jackson/databind/JavaType;

    goto :goto_0

    .line 130
    :cond_2
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_parentBindings:Lcom/fasterxml/jackson/databind/type/TypeBindings;

    if-eqz v3, :cond_3

    .line 131
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_parentBindings:Lcom/fasterxml/jackson/databind/type/TypeBindings;

    invoke-virtual {v3, p1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->findType(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v2

    goto :goto_0

    .line 140
    :cond_3
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    if-eqz v3, :cond_4

    .line 141
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    invoke-virtual {v3}, Ljava/lang/Class;->getEnclosingClass()Ljava/lang/Class;

    move-result-object v1

    .line 142
    .local v1, "enclosing":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz v1, :cond_4

    .line 145
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    invoke-virtual {v3}, Ljava/lang/Class;->getModifiers()I

    move-result v3

    invoke-static {v3}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v3

    if-nez v3, :cond_4

    .line 146
    sget-object v2, Lcom/fasterxml/jackson/databind/type/TypeBindings;->UNBOUND:Lcom/fasterxml/jackson/databind/JavaType;

    goto :goto_0

    .line 163
    .end local v1    # "enclosing":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_4
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    if-eqz v3, :cond_5

    .line 164
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 170
    .local v0, "className":Ljava/lang/String;
    :goto_1
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Type variable \'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\' can not be resolved (with context of class "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 165
    .end local v0    # "className":Ljava/lang/String;
    :cond_5
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    if-eqz v3, :cond_6

    .line 166
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/JavaType;->toString()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "className":Ljava/lang/String;
    goto :goto_1

    .line 168
    .end local v0    # "className":Ljava/lang/String;
    :cond_6
    const-string v0, "UNKNOWN"

    .restart local v0    # "className":Ljava/lang/String;
    goto :goto_1
.end method

.method public getBindingCount()I
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 113
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_resolve()V

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    return v0
.end method

.method public resolveType(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/JavaType;"
        }
    .end annotation

    .prologue
    .line 98
    .local p1, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    invoke-virtual {v0, p1, p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public resolveType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1
    .param p1, "type"    # Ljava/lang/reflect/Type;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_typeFactory:Lcom/fasterxml/jackson/databind/type/TypeFactory;

    invoke-virtual {v0, p1, p0}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->_constructType(Ljava/lang/reflect/Type;Lcom/fasterxml/jackson/databind/type/TypeBindings;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 318
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    if-nez v1, :cond_0

    .line 319
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_resolve()V

    .line 321
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "[TypeBindings for "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 322
    .local v0, "sb":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    if-eqz v1, :cond_1

    .line 323
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/JavaType;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 327
    :goto_0
    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 328
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 325
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_contextClass:Ljava/lang/Class;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public typesAsArray()[Lcom/fasterxml/jackson/databind/JavaType;
    .locals 2

    .prologue
    .line 186
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 187
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_resolve()V

    .line 189
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 190
    sget-object v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->NO_TYPES:[Lcom/fasterxml/jackson/databind/JavaType;

    .line 192
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/type/TypeBindings;->_bindings:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    new-array v1, v1, [Lcom/fasterxml/jackson/databind/JavaType;

    invoke-interface {v0, v1}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/fasterxml/jackson/databind/JavaType;

    goto :goto_0
.end method
