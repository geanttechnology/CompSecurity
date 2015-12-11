.class public final Lcom/amazon/identity/auth/device/utils/BuildInfo;
.super Ljava/lang/Object;
.source "BuildInfo.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sBuildInfo:Lcom/amazon/identity/auth/device/utils/BuildInfo;


# instance fields
.field public final mBrazilVersion:Ljava/lang/String;

.field public final mMajorVersion:I

.field public final mMapSWVersion:I

.field public final mMinorVersion:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const-class v0, Lcom/amazon/identity/auth/device/utils/BuildInfo;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(IILjava/lang/String;)V
    .locals 2
    .param p1, "majorVersion"    # I
    .param p2, "minorVersion"    # I
    .param p3, "jarBrazilVersion"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput p1, p0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMajorVersion:I

    .line 24
    iput p2, p0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMinorVersion:I

    .line 25
    iput-object p3, p0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mBrazilVersion:Ljava/lang/String;

    .line 27
    const v0, 0x989680

    iget v1, p0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMajorVersion:I

    mul-int/2addr v0, v1

    iget v1, p0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMinorVersion:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMapSWVersion:I

    .line 28
    return-void
.end method

.method public static declared-synchronized getBuildInfo()Lcom/amazon/identity/auth/device/utils/BuildInfo;
    .locals 9

    .prologue
    .line 38
    const-class v6, Lcom/amazon/identity/auth/device/utils/BuildInfo;

    monitor-enter v6

    :try_start_0
    sget-object v5, Lcom/amazon/identity/auth/device/utils/BuildInfo;->sBuildInfo:Lcom/amazon/identity/auth/device/utils/BuildInfo;

    if-eqz v5, :cond_0

    .line 40
    sget-object v5, Lcom/amazon/identity/auth/device/utils/BuildInfo;->sBuildInfo:Lcom/amazon/identity/auth/device/utils/BuildInfo;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    .local v2, "jarBrazilVersion":Ljava/lang/String;
    :goto_0
    monitor-exit v6

    return-object v5

    .line 42
    .end local v2    # "jarBrazilVersion":Ljava/lang/String;
    :cond_0
    const/4 v2, 0x0

    .line 45
    .restart local v2    # "jarBrazilVersion":Ljava/lang/String;
    :try_start_1
    const-string/jumbo v5, "com.amazon.identity.auth.device.utils.JarVersionInfo"

    invoke-static {v5}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v5

    .line 47
    const/4 v4, 0x0

    .local v4, "jarVersionClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string/jumbo v7, "JAR_BRAZIL_VERSION"

    invoke-virtual {v5, v7}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v3

    .line 48
    .local v3, "jarBrazilVersionField":Ljava/lang/reflect/Field;
    const/4 v5, 0x1

    invoke-virtual {v3, v5}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 49
    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v0, v5

    check-cast v0, Ljava/lang/String;

    move-object v2, v0
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 67
    .end local v3    # "jarBrazilVersionField":Ljava/lang/reflect/Field;
    .end local v4    # "jarVersionClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_1
    :try_start_2
    new-instance v5, Lcom/amazon/identity/auth/device/utils/BuildInfo;

    const/16 v7, 0xd

    const v8, 0xc351

    invoke-direct {v5, v7, v8, v2}, Lcom/amazon/identity/auth/device/utils/BuildInfo;-><init>(IILjava/lang/String;)V

    .line 68
    sput-object v5, Lcom/amazon/identity/auth/device/utils/BuildInfo;->sBuildInfo:Lcom/amazon/identity/auth/device/utils/BuildInfo;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 38
    :catchall_0
    move-exception v5

    monitor-exit v6

    throw v5

    .line 51
    :catch_0
    move-exception v1

    .line 53
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    :try_start_3
    sget-object v5, Lcom/amazon/identity/auth/device/utils/BuildInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "No JarVersionInfo class. This is most likely because this was a local developer build"

    invoke-static {v5, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 55
    .end local v1    # "e":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v1

    .line 57
    .local v1, "e":Ljava/lang/NoSuchFieldException;
    sget-object v5, Lcom/amazon/identity/auth/device/utils/BuildInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "No field for getting jar version. This is a programatic error. If you are using proguard please make sure you are not stripping this class out by looking at the onboarding guide."

    invoke-static {v5, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    new-instance v5, Ljava/lang/RuntimeException;

    invoke-direct {v5, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 62
    .end local v1    # "e":Ljava/lang/NoSuchFieldException;
    :catch_2
    move-exception v1

    .line 64
    .local v1, "e":Ljava/lang/Exception;
    sget-object v5, Lcom/amazon/identity/auth/device/utils/BuildInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Unexpected exception prevents getting jar version"

    invoke-static {v5, v7, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 33
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMapSWVersion:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " / "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mBrazilVersion:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
