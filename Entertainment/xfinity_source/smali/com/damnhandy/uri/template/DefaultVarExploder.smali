.class public Lcom/damnhandy/uri/template/DefaultVarExploder;
.super Ljava/lang/Object;
.source "DefaultVarExploder.java"

# interfaces
.implements Lcom/damnhandy/uri/template/VarExploder;


# instance fields
.field private pairs:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private source:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 1
    .param p1, "source"    # Ljava/lang/Object;

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    .line 80
    invoke-virtual {p0, p1}, Lcom/damnhandy/uri/template/DefaultVarExploder;->setSource(Ljava/lang/Object;)V

    .line 81
    return-void
.end method

.method private getValue(Ljava/lang/reflect/Method;)Ljava/lang/Object;
    .locals 3
    .param p1, "method"    # Ljava/lang/reflect/Method;

    .prologue
    .line 188
    if-nez p1, :cond_0

    .line 190
    const/4 v1, 0x0

    .line 192
    :goto_0
    return-object v1

    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->source:Ljava/lang/Object;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p1, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v1

    goto :goto_0

    .line 194
    :catch_0
    move-exception v0

    .line 196
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    new-instance v1, Lcom/damnhandy/uri/template/impl/VariableExpansionException;

    invoke-direct {v1, v0}, Lcom/damnhandy/uri/template/impl/VariableExpansionException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 198
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v0

    .line 200
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v1, Lcom/damnhandy/uri/template/impl/VariableExpansionException;

    invoke-direct {v1, v0}, Lcom/damnhandy/uri/template/impl/VariableExpansionException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 202
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v0

    .line 204
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    new-instance v1, Lcom/damnhandy/uri/template/impl/VariableExpansionException;

    invoke-direct {v1, v0}, Lcom/damnhandy/uri/template/impl/VariableExpansionException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private initValues()V
    .locals 12

    .prologue
    .line 108
    iget-object v10, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->source:Ljava/lang/Object;

    invoke-virtual {v10}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    .line 109
    .local v2, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v2}, Ljava/lang/Class;->isAnnotation()Z

    move-result v10

    if-nez v10, :cond_0

    invoke-virtual {v2}, Ljava/lang/Class;->isArray()Z

    move-result v10

    if-nez v10, :cond_0

    invoke-virtual {v2}, Ljava/lang/Class;->isEnum()Z

    move-result v10

    if-nez v10, :cond_0

    invoke-virtual {v2}, Ljava/lang/Class;->isPrimitive()Z

    move-result v10

    if-eqz v10, :cond_1

    .line 111
    :cond_0
    new-instance v10, Ljava/lang/IllegalArgumentException;

    const-string v11, "The value must an object"

    invoke-direct {v10, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 116
    :cond_1
    :try_start_0
    invoke-static {v2}, Ljava/beans/Introspector;->getBeanInfo(Ljava/lang/Class;)Ljava/beans/BeanInfo;
    :try_end_0
    .catch Ljava/beans/IntrospectionException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 122
    .local v1, "beanInfo":Ljava/beans/BeanInfo;
    invoke-interface {v1}, Ljava/beans/BeanInfo;->getPropertyDescriptors()[Ljava/beans/PropertyDescriptor;

    move-result-object v0

    .local v0, "arr$":[Ljava/beans/PropertyDescriptor;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_4

    aget-object v7, v0, v4

    .line 124
    .local v7, "p":Ljava/beans/PropertyDescriptor;
    invoke-virtual {v7}, Ljava/beans/PropertyDescriptor;->getReadMethod()Ljava/lang/reflect/Method;

    move-result-object v8

    .line 125
    .local v8, "readMethod":Ljava/lang/reflect/Method;
    const-class v10, Lcom/damnhandy/uri/template/UriTransient;

    invoke-virtual {v8, v10}, Ljava/lang/reflect/Method;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v10

    if-nez v10, :cond_3

    invoke-virtual {v7}, Ljava/beans/PropertyDescriptor;->getName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "class"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_3

    .line 127
    invoke-direct {p0, v8}, Lcom/damnhandy/uri/template/DefaultVarExploder;->getValue(Ljava/lang/reflect/Method;)Ljava/lang/Object;

    move-result-object v9

    .line 128
    .local v9, "value":Ljava/lang/Object;
    invoke-virtual {v7}, Ljava/beans/PropertyDescriptor;->getName()Ljava/lang/String;

    move-result-object v6

    .line 129
    .local v6, "name":Ljava/lang/String;
    const-class v10, Lcom/damnhandy/uri/template/VarName;

    invoke-virtual {v8, v10}, Ljava/lang/reflect/Method;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 131
    const-class v10, Lcom/damnhandy/uri/template/VarName;

    invoke-virtual {v8, v10}, Ljava/lang/reflect/Method;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v10

    check-cast v10, Lcom/damnhandy/uri/template/VarName;

    invoke-interface {v10}, Lcom/damnhandy/uri/template/VarName;->value()Ljava/lang/String;

    move-result-object v6

    .line 133
    :cond_2
    if-eqz v9, :cond_3

    .line 135
    iget-object v10, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    invoke-interface {v10, v6, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 122
    .end local v6    # "name":Ljava/lang/String;
    .end local v9    # "value":Ljava/lang/Object;
    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 118
    .end local v0    # "arr$":[Ljava/beans/PropertyDescriptor;
    .end local v1    # "beanInfo":Ljava/beans/BeanInfo;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    .end local v7    # "p":Ljava/beans/PropertyDescriptor;
    .end local v8    # "readMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v3

    .line 120
    .local v3, "e":Ljava/beans/IntrospectionException;
    new-instance v10, Lcom/damnhandy/uri/template/impl/VariableExpansionException;

    invoke-direct {v10, v3}, Lcom/damnhandy/uri/template/impl/VariableExpansionException;-><init>(Ljava/lang/Throwable;)V

    throw v10

    .line 140
    .end local v3    # "e":Ljava/beans/IntrospectionException;
    .restart local v0    # "arr$":[Ljava/beans/PropertyDescriptor;
    .restart local v1    # "beanInfo":Ljava/beans/BeanInfo;
    .restart local v4    # "i$":I
    .restart local v5    # "len$":I
    :cond_4
    invoke-direct {p0, v2}, Lcom/damnhandy/uri/template/DefaultVarExploder;->scanFields(Ljava/lang/Class;)V

    .line 141
    return-void
.end method

.method private scanFields(Ljava/lang/Class;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 151
    .local p1, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Class;->isInterface()Z

    move-result v7

    if-nez v7, :cond_2

    .line 153
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v3

    .line 154
    .local v3, "fields":[Ljava/lang/reflect/Field;
    move-object v0, v3

    .local v0, "arr$":[Ljava/lang/reflect/Field;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_2

    aget-object v1, v0, v4

    .line 156
    .local v1, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v2

    .line 158
    .local v2, "fieldName":Ljava/lang/String;
    iget-object v7, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    invoke-interface {v7, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 160
    const-class v7, Lcom/damnhandy/uri/template/UriTransient;

    invoke-virtual {v1, v7}, Ljava/lang/reflect/Field;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 162
    iget-object v7, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    invoke-interface {v7, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    :cond_0
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 164
    :cond_1
    const-class v7, Lcom/damnhandy/uri/template/VarName;

    invoke-virtual {v1, v7}, Ljava/lang/reflect/Field;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 166
    const-class v7, Lcom/damnhandy/uri/template/VarName;

    invoke-virtual {v1, v7}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v7

    check-cast v7, Lcom/damnhandy/uri/template/VarName;

    invoke-interface {v7}, Lcom/damnhandy/uri/template/VarName;->value()Ljava/lang/String;

    move-result-object v6

    .line 167
    .local v6, "name":Ljava/lang/String;
    iget-object v7, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    iget-object v8, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    invoke-interface {v8, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v7, v6, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 168
    iget-object v7, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    invoke-interface {v7, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 178
    .end local v0    # "arr$":[Ljava/lang/reflect/Field;
    .end local v1    # "field":Ljava/lang/reflect/Field;
    .end local v2    # "fieldName":Ljava/lang/String;
    .end local v3    # "fields":[Ljava/lang/reflect/Field;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    .end local v6    # "name":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v7

    const-class v8, Ljava/lang/Object;

    invoke-virtual {v7, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 180
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v7

    invoke-direct {p0, v7}, Lcom/damnhandy/uri/template/DefaultVarExploder;->scanFields(Ljava/lang/Class;)V

    .line 182
    :cond_3
    return-void
.end method


# virtual methods
.method public getNameValuePairs()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    return-object v0
.end method

.method public getValues()Ljava/util/Collection;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 211
    iget-object v1, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->pairs:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    .line 212
    .local v0, "c":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Object;>;"
    return-object v0
.end method

.method public setSource(Ljava/lang/Object;)V
    .locals 0
    .param p1, "source"    # Ljava/lang/Object;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/damnhandy/uri/template/DefaultVarExploder;->source:Ljava/lang/Object;

    .line 98
    invoke-direct {p0}, Lcom/damnhandy/uri/template/DefaultVarExploder;->initValues()V

    .line 99
    return-void
.end method
