.class public Lcom/amazon/mShop/net/WebViewErrorException;
.super Ljava/io/IOException;
.source "WebViewErrorException.java"


# instance fields
.field private mDescription:Ljava/lang/String;

.field private mErrorCode:I

.field private mFailingUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "errorCode"    # I
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/io/IOException;-><init>()V

    .line 15
    iput p1, p0, Lcom/amazon/mShop/net/WebViewErrorException;->mErrorCode:I

    .line 16
    iput-object p2, p0, Lcom/amazon/mShop/net/WebViewErrorException;->mDescription:Ljava/lang/String;

    .line 17
    iput-object p3, p0, Lcom/amazon/mShop/net/WebViewErrorException;->mFailingUrl:Ljava/lang/String;

    .line 18
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 22
    const-string/jumbo v0, "%s\n ErrorCode = %s, Description = %s, FailingUrl = %s"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget v3, p0, Lcom/amazon/mShop/net/WebViewErrorException;->mErrorCode:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/amazon/mShop/net/WebViewErrorException;->mDescription:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Lcom/amazon/mShop/net/WebViewErrorException;->mFailingUrl:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
