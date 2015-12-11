.class public Lcom/comcast/cim/android/authentication/AuthenticationClient;
.super Ljava/lang/Object;
.source "AuthenticationClient.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final authService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private final requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/comcast/cim/android/authentication/AuthenticationClient;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p4, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/fasterxml/jackson/databind/ObjectMapper;",
            ")V"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationClient;, "Lcom/comcast/cim/android/authentication/AuthenticationClient<TT;>;"
    .local p2, "authService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p3, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p4, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 28
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 29
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 32
    iput-object p2, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->authService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 33
    iput-object p3, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 34
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/authentication/AuthenticationClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/authentication/AuthenticationClient;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method public authenticate(Lcom/comcast/cim/android/authentication/UserCredentials;)Lcom/comcast/cim/model/user/AuthKeys;
    .locals 5
    .param p1, "credentials"    # Lcom/comcast/cim/android/authentication/UserCredentials;

    .prologue
    .line 37
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationClient;, "Lcom/comcast/cim/android/authentication/AuthenticationClient<TT;>;"
    sget-object v2, Lcom/comcast/cim/android/authentication/AuthenticationClient;->LOG:Lorg/slf4j/Logger;

    const-string v3, "authenticating"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 38
    iget-object v2, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    const-string v3, "login"

    const-string v4, "POST"

    invoke-virtual {v2, v3, v4}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 39
    .local v0, "request":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    const-string v2, "username"

    invoke-virtual {p1}, Lcom/comcast/cim/android/authentication/UserCredentials;->getUsername()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    const-string v2, "password"

    invoke-virtual {p1}, Lcom/comcast/cim/android/authentication/UserCredentials;->getPassword()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const-string v2, "deviceId"

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    const-string v2, "deviceName"

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getDeviceName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    const-string v2, "deviceType"

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    const-string v2, "appId"

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getAppId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    sget-object v2, Lcom/comcast/cim/android/authentication/AuthenticationClient;->LOG:Lorg/slf4j/Logger;

    const-string v3, "generated requestProvider"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 47
    iget-object v2, p0, Lcom/comcast/cim/android/authentication/AuthenticationClient;->authService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v3, Lcom/comcast/cim/android/authentication/AuthenticationClient$1;

    invoke-direct {v3, p0}, Lcom/comcast/cim/android/authentication/AuthenticationClient$1;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationClient;)V

    invoke-interface {v2, v0, v3}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/android/authentication/AuthResponseHandler;

    .line 52
    .local v1, "response":Lcom/comcast/cim/android/authentication/AuthResponseHandler;
    sget-object v2, Lcom/comcast/cim/android/authentication/AuthenticationClient;->LOG:Lorg/slf4j/Logger;

    const-string v3, "executed requestProvider"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 53
    invoke-virtual {v1}, Lcom/comcast/cim/android/authentication/AuthResponseHandler;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v2

    return-object v2
.end method
