.class final Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$1;
.super Lcom/AmazonDevice/Authentication/ITokenAuthProvider;
.source "AmazonOODMSUserIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->makeITokenAuth(Ljava/lang/String;Ljava/lang/String;)Lcom/AmazonDevice/Authentication/ITokenAuthProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$adpToken:Ljava/lang/String;

.field final synthetic val$privateKey:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$1;->val$adpToken:Ljava/lang/String;

    iput-object p2, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$1;->val$privateKey:Ljava/lang/String;

    invoke-direct {p0}, Lcom/AmazonDevice/Authentication/ITokenAuthProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public getPrivateKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$1;->val$privateKey:Ljava/lang/String;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$1;->val$adpToken:Ljava/lang/String;

    return-object v0
.end method
