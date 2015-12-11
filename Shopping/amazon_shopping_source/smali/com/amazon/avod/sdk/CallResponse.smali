.class public Lcom/amazon/avod/sdk/CallResponse;
.super Ljava/lang/Object;
.source "CallResponse.java"


# instance fields
.field private mErrorCode:Ljava/lang/String;

.field private mResponseMessage:Ljava/lang/String;

.field private mResponseType:Lcom/amazon/avod/sdk/Constants$CallResponseType;


# direct methods
.method constructor <init>(Lcom/amazon/avod/sdk/Constants$CallResponseType;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "responseType"    # Lcom/amazon/avod/sdk/Constants$CallResponseType;
    .param p2, "responseMessage"    # Ljava/lang/String;
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/amazon/avod/sdk/CallResponse;->mResponseType:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    .line 20
    iput-object p2, p0, Lcom/amazon/avod/sdk/CallResponse;->mResponseMessage:Ljava/lang/String;

    .line 21
    iput-object p3, p0, Lcom/amazon/avod/sdk/CallResponse;->mErrorCode:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public static fromBundle(Landroid/os/Bundle;)Lcom/amazon/avod/sdk/CallResponse;
    .locals 5
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 30
    const-string/jumbo v4, "callResponseType"

    invoke-virtual {p0, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 32
    .local v0, "callResponseType":I
    invoke-static {v0}, Lcom/amazon/avod/sdk/Constants$CallResponseType;->fromResponseCode(I)Lcom/amazon/avod/sdk/Constants$CallResponseType;

    move-result-object v3

    .line 33
    .local v3, "responseType":Lcom/amazon/avod/sdk/Constants$CallResponseType;
    const-string/jumbo v4, "callResponseMessage"

    invoke-virtual {p0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 34
    .local v2, "responseMessage":Ljava/lang/String;
    const-string/jumbo v4, "callErrorCode"

    invoke-virtual {p0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 36
    .local v1, "errorMessage":Ljava/lang/String;
    new-instance v4, Lcom/amazon/avod/sdk/CallResponse;

    invoke-direct {v4, v3, v2, v1}, Lcom/amazon/avod/sdk/CallResponse;-><init>(Lcom/amazon/avod/sdk/Constants$CallResponseType;Ljava/lang/String;Ljava/lang/String;)V

    return-object v4
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 62
    const-string/jumbo v0, "Type: %s Message: %s ErrorCode: %s"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/avod/sdk/CallResponse;->mResponseType:Lcom/amazon/avod/sdk/Constants$CallResponseType;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/amazon/avod/sdk/CallResponse;->mResponseMessage:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/amazon/avod/sdk/CallResponse;->mErrorCode:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
