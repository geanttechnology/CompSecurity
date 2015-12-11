.class public Lcom/amazon/mShop/crash/EmptyOAuthHelper;
.super Ljava/lang/Object;
.source "EmptyOAuthHelper.java"

# interfaces
.implements Lcom/amazon/device/utils/OAuthHelper;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAccessToken()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 12
    const-string/jumbo v0, ""

    return-object v0
.end method
