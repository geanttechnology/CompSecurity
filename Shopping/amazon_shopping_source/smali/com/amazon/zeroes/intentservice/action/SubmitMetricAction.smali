.class public Lcom/amazon/zeroes/intentservice/action/SubmitMetricAction;
.super Ljava/lang/Object;
.source "SubmitMetricAction.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/action/ZeroesAction;


# static fields
.field public static final ACTION_REQUEST:Ljava/lang/String;


# instance fields
.field private final measurement:Lcom/amazon/sdk/availability/Measurement;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 15
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".SubmitMetric"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/SubmitMetricAction;->ACTION_REQUEST:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    invoke-static {p1}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromIntent(Landroid/content/Intent;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/action/SubmitMetricAction;->measurement:Lcom/amazon/sdk/availability/Measurement;

    .line 27
    return-void
.end method


# virtual methods
.method public act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V
    .locals 1
    .param p1, "service"    # Lcom/amazon/zeroes/intentservice/ZeroesService;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/action/SubmitMetricAction;->measurement:Lcom/amazon/sdk/availability/Measurement;

    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 35
    return-void
.end method
