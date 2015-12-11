.class Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileBooleanFileDexFile;
.super Lamazon/android/dexload/compatibility/DexElementCompatibility;
.source "DexElementCompatibility.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/android/dexload/compatibility/DexElementCompatibility;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ElementObjectFileBooleanFileDexFile"
.end annotation


# instance fields
.field private mElementConstructor:Ljava/lang/reflect/Constructor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/reflect/Constructor",
            "<+",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 170
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;-><init>(Lamazon/android/dexload/compatibility/DexElementCompatibility$1;)V

    return-void
.end method


# virtual methods
.method protected findConstructor(Ljava/lang/Class;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/SecurityException;
        }
    .end annotation

    .prologue
    .line 176
    .local p1, "dexElementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Class;

    const/4 v1, 0x0

    const-class v2, Ljava/io/File;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    sget-object v2, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-class v2, Ljava/io/File;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-class v2, Ldalvik/system/DexFile;

    aput-object v2, v0, v1

    invoke-virtual {p1, v0}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    iput-object v0, p0, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileBooleanFileDexFile;->mElementConstructor:Ljava/lang/reflect/Constructor;

    .line 177
    return-void
.end method

.method public newInstance(Ljava/io/File;Ldalvik/system/DexFile;)Ljava/lang/Object;
    .locals 5
    .param p1, "file"    # Ljava/io/File;
    .param p2, "dexFile"    # Ldalvik/system/DexFile;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InstantiationException;
        }
    .end annotation

    .prologue
    .line 183
    :try_start_0
    iget-object v1, p0, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileBooleanFileDexFile;->mElementConstructor:Ljava/lang/reflect/Constructor;

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    aput-object p1, v2, v3

    const/4 v3, 0x3

    aput-object p2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v1

    return-object v1

    .line 184
    :catch_0
    move-exception v0

    .line 185
    .local v0, "e":Ljava/lang/InstantiationException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    .line 193
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :goto_0
    new-instance v1, Ljava/lang/InstantiationException;

    const-string/jumbo v2, "Could not instantiate DexPathList$Element"

    invoke-direct {v1, v2}, Ljava/lang/InstantiationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 186
    :catch_1
    move-exception v0

    .line 187
    .local v0, "e":Ljava/lang/IllegalAccessException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    goto :goto_0

    .line 188
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v0

    .line 189
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    goto :goto_0

    .line 190
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_3
    move-exception v0

    .line 191
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    goto :goto_0
.end method
