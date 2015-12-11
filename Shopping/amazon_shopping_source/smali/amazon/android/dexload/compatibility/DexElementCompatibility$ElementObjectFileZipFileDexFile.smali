.class Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileZipFileDexFile;
.super Lamazon/android/dexload/compatibility/DexElementCompatibility;
.source "DexElementCompatibility.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/android/dexload/compatibility/DexElementCompatibility;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ElementObjectFileZipFileDexFile"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 97
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
    .line 101
    .local p1, "dexElementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Class;

    const/4 v1, 0x0

    const-class v2, Ljava/io/File;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-class v2, Ljava/util/zip/ZipFile;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-class v2, Ldalvik/system/DexFile;

    aput-object v2, v0, v1

    invoke-virtual {p1, v0}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    iput-object v0, p0, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileZipFileDexFile;->mElementConstructor:Ljava/lang/reflect/Constructor;

    .line 102
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
    .line 108
    :try_start_0
    new-instance v1, Ljava/util/zip/ZipFile;

    invoke-direct {v1, p1}, Ljava/util/zip/ZipFile;-><init>(Ljava/io/File;)V

    .line 109
    .local v1, "zipFile":Ljava/util/zip/ZipFile;
    iget-object v2, p0, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileZipFileDexFile;->mElementConstructor:Ljava/lang/reflect/Constructor;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object v1, v3, v4

    const/4 v4, 0x2

    aput-object p2, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/util/zip/ZipException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_5

    move-result-object v2

    return-object v2

    .line 110
    .end local v1    # "zipFile":Ljava/util/zip/ZipFile;
    :catch_0
    move-exception v0

    .line 111
    .local v0, "e":Ljava/util/zip/ZipException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    .line 123
    .end local v0    # "e":Ljava/util/zip/ZipException;
    :goto_0
    new-instance v2, Ljava/lang/InstantiationException;

    const-string/jumbo v3, "Could not instantiate DexPathList$Element"

    invoke-direct {v2, v3}, Ljava/lang/InstantiationException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 112
    :catch_1
    move-exception v0

    .line 113
    .local v0, "e":Ljava/io/IOException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    goto :goto_0

    .line 114
    .end local v0    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v0

    .line 115
    .local v0, "e":Ljava/lang/InstantiationException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    goto :goto_0

    .line 116
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :catch_3
    move-exception v0

    .line 117
    .local v0, "e":Ljava/lang/IllegalAccessException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    goto :goto_0

    .line 118
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_4
    move-exception v0

    .line 119
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    goto :goto_0

    .line 120
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_5
    move-exception v0

    .line 121
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    # invokes: Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V
    invoke-static {v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->access$100(Ljava/lang/Exception;)V

    goto :goto_0
.end method
