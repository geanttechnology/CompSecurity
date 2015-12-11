.class final Lcom/amazon/sdk/availability/EncryptionFactory;
.super Ljava/lang/Object;
.source "EncryptionFactory.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    return-void
.end method

.method public static getEncryptionManager(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/EncryptionManager;
    .locals 2
    .param p0, "scheme"    # Ljava/lang/String;
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 19
    :try_start_0
    new-instance v1, Lcom/amazon/sdk/availability/EncryptionManagerImpl;

    invoke-direct {v1, p0, p1}, Lcom/amazon/sdk/availability/EncryptionManagerImpl;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 24
    :goto_0
    return-object v1

    .line 20
    :catch_0
    move-exception v0

    .line 21
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "could not create encryption manager"

    invoke-static {v1, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 24
    const/4 v1, 0x0

    goto :goto_0
.end method
