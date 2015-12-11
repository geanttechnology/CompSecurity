.class Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;
.super Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
.source "DefaultAuthenticationMethod.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 20
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->None:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V

    .line 21
    return-void
.end method


# virtual methods
.method getAuthenticationBundle(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 2
    .param p1, "serviceUri"    # Landroid/net/Uri;
    .param p2, "verb"    # Ljava/lang/String;
    .param p3, "headers"    # Ljava/util/Map;
    .param p4, "body"    # [B
    .param p5, "callbackFuture"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "Ljava/lang/String;",
            "Ljava/util/Map;",
            "[B",
            "Lcom/amazon/identity/auth/device/callback/CallbackFuture;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "The AuthenticationType is not supported, so using DefaultAuthenticationMethod but doing nothing."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    if-eqz p5, :cond_0

    .line 34
    const/4 v0, 0x5

    const-string/jumbo v1, "Probably you are passing non-exist authentication type. Please check AuthenticationType"

    invoke-static {p5, v0, v1}, Lcom/amazon/identity/auth/device/api/DefaultAuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 38
    :cond_0
    return-object p5
.end method
