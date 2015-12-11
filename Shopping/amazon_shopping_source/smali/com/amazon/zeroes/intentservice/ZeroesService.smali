.class public Lcom/amazon/zeroes/intentservice/ZeroesService;
.super Landroid/app/IntentService;
.source "ZeroesService.java"


# static fields
.field public static final BASE_PACKAGE_NAME:Ljava/lang/String;

.field public static final EXTRA_OUTPUT_RESULT:Ljava/lang/String;

.field private static final LOG:Lcom/amazon/logging/Logger;


# instance fields
.field accountSummaryProvider:Lcom/amazon/mas/client/account/summary/AccountSummaryProvider;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field actionFactory:Lcom/amazon/zeroes/intentservice/action/ActionFactory;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field deviceInspector:Lcom/amazon/mas/client/device/DeviceInspector;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 22
    const-class v0, Lcom/amazon/zeroes/intentservice/ZeroesService;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/ZeroesService;->LOG:Lcom/amazon/logging/Logger;

    .line 25
    const-class v0, Lcom/amazon/zeroes/intentservice/ZeroesService;

    invoke-virtual {v0}, Ljava/lang/Class;->getPackage()Ljava/lang/Package;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Package;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    .line 28
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".result"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/ZeroesService;->EXTRA_OUTPUT_RESULT:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 46
    const-class v0, Lcom/amazon/zeroes/intentservice/ZeroesService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 47
    invoke-static {p0}, Lcom/amazon/android/dagger/DaggerAndroid;->inject(Ljava/lang/Object;)V

    .line 49
    invoke-static {p0}, Lcom/amazon/zeroes/intentservice/Metrics;->setContext(Landroid/content/Context;)V

    .line 50
    invoke-static {}, Lcom/amazon/sdk/availability/MeasurementManagerFactory;->getMeasurementManager()Lcom/amazon/sdk/availability/MeasurementManager;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/Metrics;->setMeasurementManager(Lcom/amazon/sdk/availability/MeasurementManager;)V

    .line 51
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/ZeroesService;->deviceInspector:Lcom/amazon/mas/client/device/DeviceInspector;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/ZeroesService;->accountSummaryProvider:Lcom/amazon/mas/client/account/summary/AccountSummaryProvider;

    invoke-static {v0, v1}, Lcom/amazon/zeroes/intentservice/Metrics;->setMeasurementDefaults(Lcom/amazon/mas/client/device/DeviceInspector;Lcom/amazon/mas/client/account/summary/AccountSummaryProvider;)V

    .line 52
    return-void
.end method

.method private getActionFromIntent(Landroid/content/Intent;)Lcom/amazon/zeroes/intentservice/action/ZeroesAction;
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 64
    :try_start_0
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/ZeroesService;->actionFactory:Lcom/amazon/zeroes/intentservice/action/ActionFactory;

    invoke-virtual {v1, p1}, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->getActionFromIntent(Landroid/content/Intent;)Lcom/amazon/zeroes/intentservice/action/ZeroesAction;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 68
    :goto_0
    return-object v1

    .line 65
    :catch_0
    move-exception v0

    .line 66
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v2, "Failed to perform the action due to a malformed request"

    invoke-virtual {v1, v2}, Lcom/amazon/logging/Logger;->e(Ljava/lang/String;)V

    .line 67
    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 68
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 78
    const-class v2, Lcom/amazon/zeroes/intentservice/ZeroesService;

    const-string/jumbo v3, "onHandleIntent"

    invoke-static {v2, v3}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v1

    .line 79
    .local v1, "scope":Lcom/amazon/profiling/ProfilerScope;
    sget-object v2, Lcom/amazon/zeroes/intentservice/ZeroesService;->LOG:Lcom/amazon/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Received a request ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 80
    invoke-direct {p0, p1}, Lcom/amazon/zeroes/intentservice/ZeroesService;->getActionFromIntent(Landroid/content/Intent;)Lcom/amazon/zeroes/intentservice/action/ZeroesAction;

    move-result-object v0

    .line 81
    .local v0, "action":Lcom/amazon/zeroes/intentservice/action/ZeroesAction;
    if-eqz v0, :cond_0

    .line 82
    invoke-interface {v0, p0}, Lcom/amazon/zeroes/intentservice/action/ZeroesAction;->act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V

    .line 85
    :cond_0
    invoke-static {v1}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 86
    return-void
.end method
