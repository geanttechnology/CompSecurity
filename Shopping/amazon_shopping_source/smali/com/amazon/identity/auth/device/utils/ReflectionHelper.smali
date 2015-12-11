.class public Lcom/amazon/identity/auth/device/utils/ReflectionHelper;
.super Ljava/lang/Object;
.source "ReflectionHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;,
        Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;
    }
.end annotation


# static fields
.field private static final CLASS_NAME_TO_CLASS_CACHE:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/Class",
            "<*>;>;>;"
        }
    .end annotation
.end field

.field private static final METHOD_INFO_TO_CLASS_CACHE:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/reflect/Method;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 61
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->CLASS_NAME_TO_CLASS_CACHE:Ljava/util/Map;

    .line 63
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->METHOD_INFO_TO_CLASS_CACHE:Ljava/util/Map;

    .line 66
    const-class v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    return-void
.end method

.method private findHiddenClass(Ljava/lang/String;)Ljava/lang/Class;
    .locals 4
    .param p1, "hiddenClassName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 111
    :try_start_0
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 119
    :goto_0
    return-object v1

    .line 115
    :catch_0
    move-exception v1

    const-string/jumbo v1, "Failed to locate class named %s. If this is not a Kindle device, you can ignore this warning."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 118
    .local v0, "message":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private findMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    .locals 5
    .param p2, "methodName"    # Ljava/lang/String;
    .param p3, "parameterTypes"    # [Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/Class;",
            ")",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .line 275
    .local p1, "receiverClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v1, 0x0

    .line 278
    .local v1, "method":Ljava/lang/reflect/Method;
    :try_start_0
    invoke-virtual {p1, p2, p3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 279
    if-nez v1, :cond_0

    .line 281
    sget-object v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Method cannot be found. Are you sure it is public?"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 297
    :cond_0
    :goto_0
    return-object v1

    .line 284
    :catch_0
    move-exception v0

    .line 286
    .local v0, "e":Ljava/lang/SecurityException;
    sget-object v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Security Exception! Error: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/SecurityException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 290
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v2

    sget-object v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Method cannot be found. Are you sure it is public?"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 294
    :catch_2
    move-exception v2

    sget-object v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "IllegalArguemntException calling method"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private getField(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 8
    .param p2, "obj"    # Ljava/lang/Object;
    .param p3, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Object;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
        }
    .end annotation

    .prologue
    .local p1, "classObj":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 233
    :try_start_0
    invoke-virtual {p1, p3}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 234
    .local v1, "field":Ljava/lang/reflect/Field;
    if-nez v1, :cond_0

    .line 236
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "Field %s cannot be found"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p3, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_3

    .line 241
    .end local v1    # "field":Ljava/lang/reflect/Field;
    :catch_0
    move-exception v0

    .line 243
    .local v0, "e":Ljava/lang/SecurityException;
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "Cannot get field because of a security exception"

    invoke-direct {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 239
    .end local v0    # "e":Ljava/lang/SecurityException;
    .restart local v1    # "field":Ljava/lang/reflect/Field;
    :cond_0
    :try_start_1
    invoke-virtual {v1, p2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_3

    move-result-object v2

    return-object v2

    .line 245
    .end local v1    # "field":Ljava/lang/reflect/Field;
    :catch_1
    move-exception v0

    .line 247
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "Field %s cannot be found"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object p3, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 249
    .end local v0    # "e":Ljava/lang/NoSuchFieldException;
    :catch_2
    move-exception v0

    .line 251
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "Cannot get field because of IllegalArgumentException"

    invoke-direct {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 253
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_3
    move-exception v0

    .line 255
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "Cannot get field because of IllegalAccessException"

    invoke-direct {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method private varargs invoke(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 8
    .param p1, "methodName"    # Ljava/lang/String;
    .param p3, "receiver"    # Ljava/lang/Object;
    .param p4, "parameterTypes"    # [Ljava/lang/Class;
    .param p5, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Object;",
            "[",
            "Ljava/lang/Class;",
            "[",
            "Ljava/lang/Object;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
        }
    .end annotation

    .prologue
    .local p2, "receiverClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 191
    :try_start_0
    new-instance v3, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;

    invoke-direct {v3, p2, p1, p4}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;-><init>(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V

    sget-object v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->METHOD_INFO_TO_CLASS_CACHE:Ljava/util/Map;

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/Value;

    if-nez v2, :cond_0

    invoke-direct {p0, p2, p1, p4}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->findMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    new-instance v2, Lcom/amazon/identity/auth/device/framework/Value;

    invoke-direct {v2, v4}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V

    sget-object v4, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->METHOD_INFO_TO_CLASS_CACHE:Ljava/util/Map;

    invoke-interface {v4, v3, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/reflect/Method;

    .line 192
    .local v1, "method":Ljava/lang/reflect/Method;
    if-nez v1, :cond_1

    .line 194
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "Method %s cannot be found or accessed!"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_3

    .line 199
    .end local v1    # "method":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v0

    .line 201
    .local v0, "e":Ljava/lang/SecurityException;
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    invoke-virtual {v0}, Ljava/lang/SecurityException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 197
    .end local v0    # "e":Ljava/lang/SecurityException;
    .restart local v1    # "method":Ljava/lang/reflect/Method;
    :cond_1
    :try_start_1
    invoke-virtual {v1, p3, p5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_1} :catch_3

    move-result-object v2

    return-object v2

    .line 203
    .end local v1    # "method":Ljava/lang/reflect/Method;
    :catch_1
    move-exception v0

    .line 205
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "IllegalArguemntException calling method"

    invoke-direct {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 207
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_2
    move-exception v0

    .line 209
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "IllegalAccessException calling method"

    invoke-direct {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 211
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_3
    move-exception v0

    .line 213
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    sget-object v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Exception thrown while calling method %s"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object p1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 214
    new-instance v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    const-string/jumbo v3, "Exception calling method"

    invoke-direct {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method


# virtual methods
.method public getField(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
        }
    .end annotation

    .prologue
    .line 220
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-direct {p0, v0, p1, p2}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getField(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getHiddenClass(Ljava/lang/String;)Ljava/lang/Class;
    .locals 3
    .param p1, "hiddenClassName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 91
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 93
    const/4 v2, 0x0

    .line 104
    :goto_0
    return-object v2

    .line 96
    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->CLASS_NAME_TO_CLASS_CACHE:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/Value;

    .line 97
    .local v0, "cachedClass":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/Class<*>;>;"
    if-nez v0, :cond_1

    .line 99
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->findHiddenClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 100
    .local v1, "foundClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lcom/amazon/identity/auth/device/framework/Value;

    .end local v0    # "cachedClass":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/Class<*>;>;"
    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V

    .line 101
    .restart local v0    # "cachedClass":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/Class<*>;>;"
    sget-object v2, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->CLASS_NAME_TO_CLASS_CACHE:Ljava/util/Map;

    invoke-interface {v2, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    .end local v1    # "foundClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Class;

    goto :goto_0
.end method

.method public getHiddenMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;
    .locals 9
    .param p1, "classToFindFrom"    # Ljava/lang/Class;
    .param p2, "hiddenMethodName"    # Ljava/lang/String;

    .prologue
    .line 125
    invoke-virtual {p1}, Ljava/lang/Class;->getMethods()[Ljava/lang/reflect/Method;

    move-result-object v5

    .line 126
    .local v5, "methods":[Ljava/lang/reflect/Method;
    const/4 v1, 0x0

    .line 127
    .local v1, "hiddenPackageMethod":Ljava/lang/reflect/Method;
    move-object v0, v5

    .local v0, "arr$":[Ljava/lang/reflect/Method;
    array-length v3, v5

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v4, v0, v2

    .line 129
    .local v4, "method":Ljava/lang/reflect/Method;
    invoke-virtual {v4}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 131
    move-object v1, v4

    .line 136
    .end local v4    # "method":Ljava/lang/reflect/Method;
    :cond_0
    if-nez v1, :cond_1

    .line 138
    sget-object v6, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Failed to find method "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, " in class "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    :cond_1
    return-object v1

    .line 127
    .restart local v4    # "method":Ljava/lang/reflect/Method;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public getStaticField(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p2, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
        }
    .end annotation

    .prologue
    .line 225
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getField(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public varargs invoke(Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6
    .param p1, "methodName"    # Ljava/lang/String;
    .param p2, "receiver"    # Ljava/lang/Object;
    .param p3, "parameterTypes"    # [Ljava/lang/Class;
    .param p4, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
        }
    .end annotation

    .prologue
    .line 155
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public varargs invoke(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "method"    # Ljava/lang/reflect/Method;
    .param p2, "receiver"    # Ljava/lang/Object;
    .param p3, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .prologue
    .line 147
    invoke-virtual {p1, p2, p3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public varargs invokeStatic(Ljava/lang/String;Ljava/lang/Class;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6
    .param p1, "methodName"    # Ljava/lang/String;
    .param p3, "parameterTypes"    # [Ljava/lang/Class;
    .param p4, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;[",
            "Ljava/lang/Class;",
            "[",
            "Ljava/lang/Object;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
        }
    .end annotation

    .prologue
    .line 180
    .local p2, "receiverClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public varargs invokeStatic(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 7
    .param p1, "methodName"    # Ljava/lang/String;
    .param p2, "receiverClassName"    # Ljava/lang/String;
    .param p3, "parameterTypes"    # [Ljava/lang/Class;
    .param p4, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
        }
    .end annotation

    .prologue
    .line 164
    invoke-virtual {p0, p2}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getHiddenClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    .line 165
    .local v2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v2, :cond_0

    .line 167
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Cannot find class "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 168
    .local v6, "errorMsg":Ljava/lang/String;
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->TAG:Ljava/lang/String;

    invoke-static {v0, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 169
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;

    invoke-direct {v0, v6}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 172
    .end local v6    # "errorMsg":Ljava/lang/String;
    :cond_0
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public isClassAvailable(Ljava/lang/String;)Z
    .locals 1
    .param p1, "className"    # Ljava/lang/String;

    .prologue
    .line 85
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getHiddenClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
