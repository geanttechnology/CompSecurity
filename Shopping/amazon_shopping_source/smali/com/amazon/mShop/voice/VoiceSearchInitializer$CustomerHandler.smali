.class public Lcom/amazon/mShop/voice/VoiceSearchInitializer$CustomerHandler;
.super Ljava/lang/Object;
.source "VoiceSearchInitializer.java"

# interfaces
.implements Lcom/amazon/shopapp/voice/module/CustomerProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/voice/VoiceSearchInitializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "CustomerHandler"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/voice/VoiceSearchInitializer;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/mShop/voice/VoiceSearchInitializer$CustomerHandler;->this$0:Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDirectedId(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 128
    invoke-static {p1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
