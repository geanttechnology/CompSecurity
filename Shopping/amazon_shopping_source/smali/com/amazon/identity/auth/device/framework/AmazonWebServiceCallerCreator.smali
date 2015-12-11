.class public Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;
.super Ljava/lang/Object;
.source "AmazonWebServiceCallerCreator.java"


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    .line 19
    return-void
.end method


# virtual methods
.method public create(Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;
    .locals 2
    .param p1, "credentials"    # Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 33
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1, p2}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-object v0
.end method

.method public create(Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;
    .locals 2
    .param p1, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 23
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-object v0
.end method

.method public create(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 28
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1, p2}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-object v0
.end method

.method public createSync(Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;
    .locals 3
    .param p1, "credentials"    # Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 53
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-direct {v2, p1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;-><init>(Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;)V

    invoke-direct {v0, v1, v2, p2}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-object v0
.end method

.method public createSync(Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;
    .locals 4
    .param p1, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 38
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;-><init>(Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;)V

    invoke-direct {v0, v1, v2, p1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-object v0
.end method

.method public createSync(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 45
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->mContext:Landroid/content/Context;

    invoke-static {v3, p1}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->getCredentialsForAccount(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;-><init>(Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;)V

    invoke-direct {v0, v1, v2, p2}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-object v0
.end method
