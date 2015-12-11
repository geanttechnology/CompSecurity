.class public Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
.super Ljava/lang/Exception;
.source "MAPCallbackErrorException.java"


# instance fields
.field private final mErrorBundleBytes:[B


# direct methods
.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "givenErrorBundle"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 18
    if-nez p1, :cond_1

    move-object v2, v3

    :cond_0
    :goto_0
    invoke-direct {p0, v2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 19
    if-eqz p1, :cond_3

    move-object v0, p1

    .line 23
    .local v0, "errorBundle":Landroid/os/Bundle;
    :goto_1
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 26
    .local v1, "parcel":Landroid/os/Parcel;
    :try_start_0
    invoke-virtual {v1, v0}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    .line 27
    invoke-virtual {v1}, Landroid/os/Parcel;->marshall()[B

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->mErrorBundleBytes:[B
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 31
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 32
    return-void

    .line 18
    .end local v0    # "errorBundle":Landroid/os/Bundle;
    .end local v1    # "parcel":Landroid/os/Parcel;
    :cond_1
    const-string/jumbo v2, "com.amazon.dcp.sso.ErrorMessage"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_2

    move-object v2, v3

    goto :goto_0

    :cond_2
    const-string/jumbo v3, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 19
    :cond_3
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    goto :goto_1

    .line 31
    .restart local v0    # "errorBundle":Landroid/os/Bundle;
    .restart local v1    # "parcel":Landroid/os/Parcel;
    :catchall_0
    move-exception v2

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    throw v2
.end method


# virtual methods
.method public getErrorBundle()Landroid/os/Bundle;
    .locals 4

    .prologue
    .line 41
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 44
    .local v0, "parcel":Landroid/os/Parcel;
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->mErrorBundleBytes:[B

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->mErrorBundleBytes:[B

    array-length v3, v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Parcel;->unmarshall([BII)V

    .line 45
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 46
    invoke-virtual {v0}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 50
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method
