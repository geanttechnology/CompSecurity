.class public Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;
.super Ljava/lang/Object;
.source "StandardChildApplicationRegistrar.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;->mContext:Landroid/content/Context;

    .line 30
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_webservice_caller_creator"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;->mCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    .line 32
    return-void
.end method


# virtual methods
.method public registerChild(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "registerChildRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p3, "callback"    # Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 40
    new-instance v0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;

    invoke-direct {v0, p0, p3}, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;-><init>(Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;)V

    .line 71
    .local v0, "listener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-direct {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;-><init>()V

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;->mCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    invoke-virtual {v2, p1, p4}, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->create(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;

    move-result-object v2

    invoke-virtual {v2, p2, v1, v0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->call()V

    .line 72
    return-void
.end method
