.class public abstract Lamazon/android/dexload/compatibility/DexElementCompatibility;
.super Ljava/lang/Object;
.source "DexElementCompatibility.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lamazon/android/dexload/compatibility/DexElementCompatibility$1;,
        Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileBooleanFileDexFile;,
        Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileFileDexFile;,
        Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileZipFileDexFile;
    }
.end annotation


# static fields
.field private static final DEX_ELEMENT_VARIATIONS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lamazon/android/dexload/compatibility/DexElementCompatibility;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field protected mElementConstructor:Ljava/lang/reflect/Constructor;
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
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 55
    const/4 v0, 0x3

    new-array v0, v0, [Lamazon/android/dexload/compatibility/DexElementCompatibility;

    const/4 v1, 0x0

    new-instance v2, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileFileDexFile;

    invoke-direct {v2}, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileFileDexFile;-><init>()V

    aput-object v2, v0, v1

    const/4 v1, 0x1

    new-instance v2, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileZipFileDexFile;

    invoke-direct {v2}, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileZipFileDexFile;-><init>()V

    aput-object v2, v0, v1

    const/4 v1, 0x2

    new-instance v2, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileBooleanFileDexFile;

    invoke-direct {v2}, Lamazon/android/dexload/compatibility/DexElementCompatibility$ElementObjectFileBooleanFileDexFile;-><init>()V

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lamazon/android/dexload/compatibility/DexElementCompatibility;->DEX_ELEMENT_VARIATIONS:Ljava/util/List;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    return-void
.end method

.method synthetic constructor <init>(Lamazon/android/dexload/compatibility/DexElementCompatibility$1;)V
    .locals 0
    .param p1, "x0"    # Lamazon/android/dexload/compatibility/DexElementCompatibility$1;

    .prologue
    .line 22
    invoke-direct {p0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;-><init>()V

    return-void
.end method

.method static synthetic access$100(Ljava/lang/Exception;)V
    .locals 0
    .param p0, "x0"    # Ljava/lang/Exception;

    .prologue
    .line 22
    invoke-static {p0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->logInstantiationFailed(Ljava/lang/Exception;)V

    return-void
.end method

.method public static getDexElementCompatibility(Ljava/lang/Class;)Lamazon/android/dexload/compatibility/DexElementCompatibility;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lamazon/android/dexload/compatibility/DexElementCompatibility;"
        }
    .end annotation

    .prologue
    .line 69
    .local p0, "dexElementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v3, Lamazon/android/dexload/compatibility/DexElementCompatibility;->DEX_ELEMENT_VARIATIONS:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lamazon/android/dexload/compatibility/DexElementCompatibility;

    .line 72
    .local v0, "dexElementCompatibility":Lamazon/android/dexload/compatibility/DexElementCompatibility;
    :try_start_0
    invoke-virtual {v0, p0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->findConstructor(Ljava/lang/Class;)V
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    .line 73
    return-object v0

    .line 74
    :catch_0
    move-exception v1

    .line 75
    .local v1, "e":Ljava/lang/NoSuchMethodException;
    const-string/jumbo v3, "DexElementCompatibility"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " is not the right one for this platform"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 76
    .end local v1    # "e":Ljava/lang/NoSuchMethodException;
    :catch_1
    move-exception v1

    .line 77
    .local v1, "e":Ljava/lang/SecurityException;
    const-string/jumbo v3, "DexElementCompatibility"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " has a SecurityException"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 80
    .end local v0    # "dexElementCompatibility":Lamazon/android/dexload/compatibility/DexElementCompatibility;
    .end local v1    # "e":Ljava/lang/SecurityException;
    :cond_0
    new-instance v3, Ljava/lang/NoSuchMethodError;

    const-string/jumbo v4, "DexPath$Element contructor for this version of android is unhandled by DexElementCompatibility"

    invoke-direct {v3, v4}, Ljava/lang/NoSuchMethodError;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private static logInstantiationFailed(Ljava/lang/Exception;)V
    .locals 3
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 85
    const-string/jumbo v0, "DexElementCompatibility"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Instantiation of the object failed. This might be a new version of android that needs to be handled.This is due to this exception: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    return-void
.end method


# virtual methods
.method protected abstract findConstructor(Ljava/lang/Class;)V
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
.end method

.method public abstract newInstance(Ljava/io/File;Ldalvik/system/DexFile;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InstantiationException;
        }
    .end annotation
.end method
